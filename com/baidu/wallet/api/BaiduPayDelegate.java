package com.baidu.wallet.api;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.pay.BindBack;
import com.baidu.android.pay.PayCallBack;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.support.Base64;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.api.BindCardEntry;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.w;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.datamodel.WalletInterfaceResponse;
import com.baidu.wallet.paysdk.precashier.IDefaultPayMethodCallback;
import com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback;
import com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData;
import com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeManager;
import com.baidu.wallet.paysdk.precashier.beans.PrecashierBeanFactory;
import com.baidu.wallet.paysdk.precashier.beans.PrecashierDefaultPayTypeBean;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayPreferenceManager;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.BindCardPreCheckActivity;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.remotepay.IRemoteServiceCallback;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.rnauth.ui.RnAuthMiddleActivity;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import com.baidu.wallet.utils.JsonUtil;
import com.google.protobuf.CodedInputStream;
import com.qq.e.comm.constants.Constants;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class BaiduPayDelegate implements IWalletPayFacade {
    public static final int RNAUTH_HIGH_GRADE = 3;
    public static final int RNAUTH_LOW_GRADE = 1;
    public static final int RNAUTH_MEDIUM_GRADE = 2;

    /* renamed from: a  reason: collision with root package name */
    public static final String f23041a = "BaiduPayDelegate";

    /* renamed from: b  reason: collision with root package name */
    public static final String f23042b = f23041a + ".getPayMethod";

    /* renamed from: c  reason: collision with root package name */
    public static String f23043c = "wallet_interface_unlogindata";

    /* renamed from: d  reason: collision with root package name */
    public HandlePassLoginResult f23044d;

    /* renamed from: e  reason: collision with root package name */
    public LoginBackListenerProxy f23045e;

    /* renamed from: f  reason: collision with root package name */
    public PayCallBack f23046f;

    /* renamed from: g  reason: collision with root package name */
    public long f23047g;

    /* loaded from: classes5.dex */
    public class HandlePassLoginResult extends LoginBackListenerProxy {

        /* renamed from: b  reason: collision with root package name */
        public boolean f23132b;

        public HandlePassLoginResult(Context context, boolean z, ILoginBackListener iLoginBackListener) {
            super(context, iLoginBackListener);
            this.f23132b = z;
        }

        @Override // com.baidu.wallet.passport.LoginBackListenerProxy, com.baidu.wallet.api.ILoginBackListener
        public void onFail(int i, String str) {
            if (this.f23132b) {
                List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), "0");
                HashMap hashMap = new HashMap();
                hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
                hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
                StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PASS_RESULT, collectData, hashMap);
            } else if (PayDataCache.getInstance().isRemotePay()) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.RMT_PASS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), StatHelper.getFromPkg(), "0"));
            } else {
                StatisticManager.onEventWithValues(PayStatServiceEvent.LCL_PASS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), "0"));
            }
            StatHelper.cachePassLoginStatus("0");
            super.onFail(i, str);
        }

        @Override // com.baidu.wallet.passport.LoginBackListenerProxy, com.baidu.wallet.api.ILoginBackListener
        public void onSuccess(int i, String str) {
            if (StatHelper.getPassLoginStatus().equals("0")) {
                if (this.f23132b) {
                    List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), "1");
                    HashMap hashMap = new HashMap();
                    hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
                    hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
                    StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PASS_RESULT, collectData, hashMap);
                } else if (PayDataCache.getInstance().isRemotePay()) {
                    StatisticManager.onEventWithValues(PayStatServiceEvent.RMT_PASS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), StatHelper.getFromPkg(), "1"));
                } else {
                    StatisticManager.onEventWithValues(PayStatServiceEvent.LCL_PASS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), "1"));
                }
            }
            super.onSuccess(i, str);
        }
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final BaiduPayDelegate f23133a = new BaiduPayDelegate();
    }

    public static BaiduPayDelegate getInstance() {
        return a.f23133a;
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void accessWalletEntry(Context context, String str) {
        WalletInterfaceResponse.WalletModuleData walletModuleData;
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            walletModuleData = (WalletInterfaceResponse.WalletModuleData) JsonUtils.fromJson(str, WalletInterfaceResponse.WalletModuleData.class);
        } catch (JSONException e2) {
            e2.printStackTrace();
            walletModuleData = null;
        }
        if (walletModuleData == null || walletModuleData.link_addr == null) {
            return;
        }
        PayStatisticsUtil.onEventWithValues(StatServiceEvent.ACCESS_WALLET_ENTRY_EVENT, a(walletModuleData));
        int i = walletModuleData.type;
        if (i == 1) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_start").data("url", walletModuleData.link_addr).data("title", null).data("with_anim", Boolean.valueOf(walletModuleData.needAnim())).data("show_share", Boolean.TRUE), new RouterCallback() { // from class: com.baidu.wallet.api.BaiduPayDelegate.9
                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                }
            });
        } else if (i == 2) {
            WalletLoginHelper.getInstance().startPage(walletModuleData.link_addr);
        } else if (i == 3) {
            BaiduWalletServiceController.getInstance().gotoWalletService(context, walletModuleData.link_addr, "", walletModuleData.needAnim());
        }
    }

    public void cashierEnterSensor(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        StatHelper.clearPay();
        String orderNo = StatHelper.getOrderNo(str2);
        StatHelper.cacheOrderNo(orderNo);
        String spNo = StatHelper.getSpNo(str2);
        StatHelper.cacheSpNo(spNo);
        double doubleValue = TextUtils.isEmpty(StatHelper.getPayAmount(str2)) ? 0.0d : StringUtils.fen2YuanBigDecimal(StatHelper.getPayAmount(str2)).doubleValue();
        StatHelper.cachePayAmount(doubleValue);
        List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), new String[0]);
        HashMap hashMap = new HashMap();
        hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, spNo);
        hashMap.put(BaiduPay.AMOUNT, Double.valueOf(doubleValue));
        if (PayStatServiceEvent.PERCASHIER_PAY_ENTER.equals(str)) {
            StatHelper.setPrecashierMark(orderNo);
        } else if (PayStatServiceEvent.STD_PAY_ENTER.equals(str) && StatHelper.isPrecashierPay(orderNo)) {
            hashMap.put("pay_category", "1");
        }
        StatisticManager.onEventWithValues(str, collectData, hashMap);
    }

    public void changePayMethod(final Activity activity, final Map map, IModifyPayTypeCallback iModifyPayTypeCallback) {
        if (c()) {
            PayStatisticsUtil.onEvent(PayStatServiceEvent.FAST_DOUBLE_CLICK_CHANGE_PAY_METHOD);
            return;
        }
        StatisticManager.onEvent("changePayMethod");
        PayController.getInstance().setModifyPayTypeCallback(iModifyPayTypeCallback);
        WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
        WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(activity, new ILoginBackListener() { // from class: com.baidu.wallet.api.BaiduPayDelegate.19
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str) {
                PrecashierModifyPayTypeManager.getInstance().getModifyPayType(activity, map);
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str) {
                PrecashierModifyPayTypeManager.getInstance().getModifyPayType(activity, map);
            }
        }));
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void checkPwd(final Context context, final CheckCallBack checkCallBack) {
        this.f23045e = new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.api.BaiduPayDelegate.7
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str) {
                if (i == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BaiduPayDelegate.this.f23045e);
                    return;
                }
                CheckCallBack checkCallBack2 = checkCallBack;
                if (checkCallBack2 != null) {
                    checkCallBack2.onCheckResult(2, "cancle");
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str) {
                BaiduPay.getInstance().checkPwd(context, checkCallBack);
            }
        });
        WalletLoginHelper.getInstance().login(this.f23045e);
    }

    public void checkPwdFromH5(final Context context, final String str, final CheckCallBack checkCallBack) {
        this.f23045e = new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.api.BaiduPayDelegate.8
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str2) {
                if (i == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BaiduPayDelegate.this.f23045e);
                    return;
                }
                CheckCallBack checkCallBack2 = checkCallBack;
                if (checkCallBack2 != null) {
                    checkCallBack2.onCheckResult(2, QueryResponse.Options.CANCEL);
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str2) {
                BaiduPay.getInstance().checkPwdFromH5(context, str, checkCallBack);
            }
        });
        WalletLoginHelper.getInstance().login(this.f23045e);
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doBind(Context context, BindBack bindBack, Map<String, String> map) {
        if (context != null && map != null) {
            doInnerBind(context, bindBack, map, "");
            return;
        }
        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_ONBINDRESULT);
        bindBack.onBindResult(-10, null);
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doBindCardIndependent(final Context context, final BindBack bindBack, final String str) {
        if (context == null) {
            if (bindBack != null) {
                bindBack.onBindResult(2, null);
                return;
            }
            return;
        }
        BaiduPay.getInstance().setBindCardbackExt(bindBack);
        final Intent intent = new Intent();
        intent.setClass(context, BindCardPreCheckActivity.class);
        intent.putExtra(BindCardPreCheckActivity.PARAMS_KEY, str);
        if (!(context instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        this.f23045e = new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.api.BaiduPayDelegate.21
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str2) {
                if (i == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BaiduPayDelegate.this.f23045e);
                    return;
                }
                bindBack.onBindResult(2, "");
                BaiduPay.getInstance().clearBindCallbackExt();
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str2) {
                BaiduPay.getInstance().bindCardOnCardaddReturn(context, new BindCardEntry.OnReturn() { // from class: com.baidu.wallet.api.BaiduPayDelegate.21.1
                    @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
                    public void onFailed(int i2, String str3) {
                    }

                    @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
                    public void onResponse(CardAddResponse cardAddResponse) {
                        Activity loadingUi = BindCardEntry.getLoadingUi();
                        if (loadingUi instanceof BaseActivity) {
                            ((BaseActivity) loadingUi).startActivity(intent);
                            return;
                        }
                        AnonymousClass21 anonymousClass21 = AnonymousClass21.this;
                        context.startActivity(intent);
                    }
                }, PayRequestCache.BindCategory.Initiative, 1, null, str);
            }
        });
        WalletLoginHelper.getInstance().login(this.f23045e);
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doCheckPwd(final Context context, final Map<String, String> map, final CheckCallBack checkCallBack) {
        this.f23045e = new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.api.BaiduPayDelegate.6
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str) {
                if (i == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BaiduPayDelegate.this.f23045e);
                    return;
                }
                CheckCallBack checkCallBack2 = checkCallBack;
                if (checkCallBack2 != null) {
                    checkCallBack2.onCheckResult(2, "");
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str) {
                BaiduPay.getInstance().doCheckPwd(context, map, checkCallBack);
            }
        });
        WalletLoginHelper.getInstance().login(this.f23045e);
    }

    public void doInnerBind(final Context context, final BindBack bindBack, final Map<String, String> map, final String str) {
        this.f23045e = null;
        this.f23045e = new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.api.BaiduPayDelegate.14
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str2) {
                if (i == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BaiduPayDelegate.this.f23045e);
                } else if (bindBack != null) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_ONBINDRESULT);
                    bindBack.onBindResult(-5, null);
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str2) {
                BaiduPay.getInstance().doBindCardExt(context, bindBack, map, str);
            }
        });
        WalletLoginHelper.getInstance().login(this.f23045e);
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doPay(Context context, String str, PayCallBack payCallBack) {
        doPay(context, str, payCallBack, new HashMap());
    }

    public void doPayRNAuth(Context context, HashMap<String, String> hashMap, RNAuthCallBack rNAuthCallBack) {
        RnAuthMiddleActivity.setRnAuthCallBack(rNAuthCallBack);
        context.startActivity(RnAuthMiddleActivity.getStartIntent(context, hashMap));
    }

    public void doPrecashierPay(final Context context, final String str, final PayCallBack payCallBack, final Map<String, String> map, final PrecashierCreateOrderResponse precashierCreateOrderResponse, IModifyPayTypeCallback iModifyPayTypeCallback) {
        PayStatisticsUtil.onEvent(StatServiceEvent.PRE_CASHIER_PAY);
        if (iModifyPayTypeCallback == null) {
            iModifyPayTypeCallback = new IModifyPayTypeCallback() { // from class: com.baidu.wallet.api.BaiduPayDelegate.17
                @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                public void onPayTypeModified(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
                    PayDataCache.getInstance().resetFromPrecashier();
                    BaiduPayDelegate.this.doPay(context, str, payCallBack, map);
                }

                @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                public void onPayTypeSetted() {
                }
            };
        }
        PayController.getInstance().setModifyPayTypeCallback(iModifyPayTypeCallback);
        PayDataCache.getInstance().setIsRemotePay(false);
        PayDataCache.getInstance().setFromPreCashier();
        this.f23045e = new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.api.BaiduPayDelegate.18
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str2) {
                if (i == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BaiduPayDelegate.this.f23045e);
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str2) {
                BaiduPay.getInstance().doPrecashierPay(context, str, payCallBack, map, precashierCreateOrderResponse);
            }
        });
        WalletLoginHelper.getInstance().login(this.f23045e);
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doRNAuth(final Context context, final Map<String, String> map, final RNAuthCallBack rNAuthCallBack) {
        if (context == null || map == null) {
            return;
        }
        this.f23045e = new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.api.BaiduPayDelegate.2
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str) {
                if (i == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BaiduPayDelegate.this.f23045e);
                    return;
                }
                RNAuthCallBack rNAuthCallBack2 = rNAuthCallBack;
                if (rNAuthCallBack2 != null) {
                    rNAuthCallBack2.onRNAuthResult(-5, null);
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str) {
                BaiduPay.getInstance().doRNAuth(context, map, rNAuthCallBack);
            }
        });
        WalletLoginHelper.getInstance().login(this.f23045e);
    }

    public void doRemotePay(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList<String> a2 = a(str, map, context);
        StatisticManager.onEventWithValues(PayStatServiceEvent.RMT_PAY_ACCEPT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), StatHelper.getFromPkg()));
        cashierEnterSensor(PayStatServiceEvent.STD_PAY_ENTER, str);
        PayStatisticsUtil.onEventWithValues(StatServiceEvent.SCHEME_PAY_ENTER, a2);
        if (WalletLoginHelper.getInstance().isLogin() && map == null) {
            map = new HashMap<>();
        }
        PayDataCache.getInstance().setIsRemotePay(true);
        PayDataCache.getInstance().resetFromPrecashier();
        a(context, str, payCallBack, map);
    }

    public void getPayMethod(final Context context, final String str, final IDefaultPayMethodCallback iDefaultPayMethodCallback) {
        if (c()) {
            PayStatisticsUtil.onEvent(PayStatServiceEvent.FAST_DOUBLE_CLICK_GET_PAY_METHOD);
            return;
        }
        WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
        WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.api.BaiduPayDelegate.3
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str2) {
                BaiduPayDelegate.this.a(context, str, iDefaultPayMethodCallback);
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str2) {
                BaiduPayDelegate.this.a(context, str, iDefaultPayMethodCallback);
            }
        }));
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public String getWalletOuterInterface(final Context context, final IWalletOuterInterfaceListener iWalletOuterInterfaceListener) {
        WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.api.BaiduPayDelegate.10
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str) {
                BaiduPayDelegate.this.a(context, iWalletOuterInterfaceListener);
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str) {
                BaiduPayDelegate.this.a(context, iWalletOuterInterfaceListener);
            }
        }));
        String newPpKey = PayPreferenceManager.getNewPpKey(context);
        if (TextUtils.isEmpty(newPpKey)) {
            newPpKey = PayPreferenceManager.getPpKey(context);
        }
        String walletInterfaceData = PayPreferenceManager.getWalletInterfaceData(context, newPpKey, "");
        if ((WalletLoginHelper.getInstance().isPassLogin() || WalletLoginHelper.getInstance().isLogin()) && !TextUtils.isEmpty(walletInterfaceData)) {
            try {
                byte[] decode = Base64.decode(walletInterfaceData.getBytes());
                if (decode != null) {
                    return new String(decode);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return "";
        }
        String walletInterfaceData2 = PayPreferenceManager.getWalletInterfaceData(context, f23043c, "");
        return !TextUtils.isEmpty(walletInterfaceData2) ? walletInterfaceData2 : "";
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void preOrderPay(Context context, String str, final IPrecashierCallback iPrecashierCallback) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("orderInfo") && jSONObject2.get("orderInfo") != null) {
                String str2 = (String) jSONObject2.get("orderInfo");
                String jsonToURLParams = (!jSONObject2.has("orderInfoExtra") || (jSONObject = jSONObject2.getJSONObject("orderInfoExtra")) == null) ? "" : JsonUtil.jsonToURLParams(jSONObject, true);
                final PayCallBack payCallBack = new PayCallBack() { // from class: com.baidu.wallet.api.BaiduPayDelegate.12
                    @Override // com.baidu.android.pay.PayCallBack
                    public boolean isHideLoadingDialog() {
                        return false;
                    }

                    @Override // com.baidu.android.pay.PayCallBack
                    public void onPayResult(int i, String str3) {
                        if (i != 0 && i != 1) {
                            List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getHasPwd(), StatHelper.getPayType(), StatHelper.getPayWay());
                            HashMap hashMap = new HashMap();
                            hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
                            hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
                            StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PAY, collectData, hashMap);
                            StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PAY_FAILED, collectData, hashMap);
                            iPrecashierCallback.onResult(BaiduPayDelegate.this.a(String.valueOf(i), str3));
                            return;
                        }
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("data", Base64Utils.encodeToString(str3.getBytes()));
                        iPrecashierCallback.onResult(BaiduPayDelegate.this.a((Map<String, Object>) hashMap2, true));
                    }
                };
                getInstance().preOrderPay(context, str2, jsonToURLParams, payCallBack, new IModifyPayTypeCallback() { // from class: com.baidu.wallet.api.BaiduPayDelegate.15
                    @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                    public void onPayTypeModified(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
                        payCallBack.onPayResult(10000, "默认支付方式变更");
                    }

                    @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                    public void onPayTypeSetted() {
                    }
                });
                return;
            }
            throw new InvalidParameterException("参数非法");
        } catch (Exception e2) {
            e2.printStackTrace();
            String a2 = a(LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage());
            if (iPrecashierCallback != null) {
                iPrecashierCallback.onResult(a2);
            }
        }
    }

    public void reOrderPay(Context context) {
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        String str = payRequest != null ? payRequest.mParams : "";
        String payFrom = payRequest != null ? payRequest.getPayFrom() : "";
        PayCallBack payBack = BaiduPay.getInstance().getPayBack();
        PayRequestCache.getInstance().clearPaySdkRequestCache();
        PayBaseBeanActivity.exitEbpay();
        String str2 = f23041a;
        LogUtil.d(str2, "orderinfo=" + str + " ==============callback=" + payBack);
        HashMap hashMap = new HashMap();
        hashMap.put(BaiduPay.PAY_FROM, payFrom);
        StatisticManager.onEventWithValue(StatServiceEvent.EVENT_PAY_TYPE_SETTED_REORDE, str);
        List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), new String[0]);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
        hashMap2.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
        if (PayDataCache.getInstance().isRemotePay()) {
            StatisticManager.onEventWithValues(PayStatServiceEvent.STD_PAY_REORDER, collectData, hashMap2);
            if (payRequest != null) {
                hashMap.put(Constants.KEY_REMOTE_APP_NAME, payRequest.mRemotePayHostName);
                hashMap.put(Constants.KEY_REMOTE_PKG_NAME, payRequest.mRemotePkg);
                hashMap.put(Constants.KEY_REMOTE_WHERE_TO_BACK, payRequest.mRemoteWhereToBackAct);
            }
            getInstance().doRemotePay(context, str, payBack, hashMap);
        } else if (PayDataCache.getInstance().isFromPreCashier()) {
            if (BaiduPay.PAY_FROM_HUA_ZHUAN_ZHANG.equals(payFrom)) {
                return;
            }
            StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PAY_REORDER, collectData, hashMap2);
            BaiduPay.getInstance().preOrderPay(context, str, PayDataCache.getInstance().getOrderExtraInfo(), payBack, hashMap);
        } else {
            StatisticManager.onEventWithValues(PayStatServiceEvent.STD_PAY_REORDER, collectData, hashMap2);
            getInstance().doPay(context, str, payBack, hashMap);
        }
    }

    public BaiduPayDelegate() {
        this.f23046f = null;
    }

    private IRemoteServiceCallback b() {
        return new IRemoteServiceCallback.Stub() { // from class: com.baidu.wallet.api.BaiduPayDelegate.1
            @Override // com.baidu.wallet.remotepay.IRemoteServiceCallback
            public boolean isHideLoadingDialog() {
                return false;
            }

            @Override // com.baidu.wallet.remotepay.IRemoteServiceCallback
            public void onPayEnd(final int i, final String str) throws RemoteException {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.wallet.api.BaiduPayDelegate.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BaiduPayDelegate.this.f23046f != null) {
                            BaiduPayDelegate.this.f23046f.onPayResult(i, str);
                            BaiduPayDelegate.this.f23046f = null;
                        }
                    }
                });
            }

            @Override // com.baidu.wallet.remotepay.IRemoteServiceCallback
            public void startActivity(String str, String str2, int i, Bundle bundle) throws RemoteException {
            }
        };
    }

    private void c(final Context context, final String str, final PayCallBack payCallBack, final Map<String, String> map) {
        if (PayDataCache.getInstance().isRemotePay()) {
            String orderNo = StatHelper.getOrderNo();
            String[] strArr = new String[3];
            strArr[0] = StatHelper.getSpNo();
            strArr[1] = StatHelper.getFromPkg();
            strArr[2] = WalletLoginHelper.getInstance().isPassLogin() ? "1" : "0";
            StatisticManager.onEventWithValues(PayStatServiceEvent.RMT_LOGIN_ENTER, StatHelper.collectData(orderNo, strArr));
        } else {
            String orderNo2 = StatHelper.getOrderNo();
            String[] strArr2 = new String[2];
            strArr2[0] = StatHelper.getSpNo();
            strArr2[1] = WalletLoginHelper.getInstance().isPassLogin() ? "1" : "0";
            StatisticManager.onEventWithValues(PayStatServiceEvent.LCL_LOGIN_ENTER, StatHelper.collectData(orderNo2, strArr2));
        }
        StatHelper.cachePassLoginStatus(WalletLoginHelper.getInstance().isPassLogin() ? "1" : "0");
        this.f23044d = new HandlePassLoginResult(context, false, new ILoginBackListener() { // from class: com.baidu.wallet.api.BaiduPayDelegate.13
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str2) {
                if (i == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BaiduPayDelegate.this.f23044d);
                    return;
                }
                List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), new String[0]);
                HashMap hashMap = new HashMap();
                hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
                hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
                StatisticManager.onEventWithValues(PayStatServiceEvent.STD_PAY_NOT_LOGIN, collectData, hashMap);
                if (StatHelper.getPassLoginStatus().equals("1")) {
                    if (PayDataCache.getInstance().isRemotePay()) {
                        StatisticManager.onEventWithValues(PayStatServiceEvent.RMT_OPENBDUSS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), StatHelper.getFromPkg(), "0"));
                    } else {
                        StatisticManager.onEventWithValues(PayStatServiceEvent.LCL_OPENBDUSS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), "0"));
                    }
                }
                if (payCallBack != null) {
                    PayDataCache.getInstance().isRemotePay();
                    payCallBack.onPayResult(2, "");
                    if (PayDataCache.getInstance().isRemotePay()) {
                        try {
                            BaiduPayDelegate.this.a(context, map);
                        } catch (ActivityNotFoundException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str2) {
                if (PayDataCache.getInstance().isRemotePay()) {
                    StatisticManager.onEventWithValues(PayStatServiceEvent.RMT_OPENBDUSS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), StatHelper.getFromPkg(), "1"));
                } else {
                    StatisticManager.onEventWithValues(PayStatServiceEvent.LCL_OPENBDUSS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), "1"));
                }
                Context context2 = context;
                if (context2 != null) {
                    BaiduPayDelegate.this.b(context2, str, payCallBack, map);
                    return;
                }
                List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), new String[0]);
                HashMap hashMap = new HashMap();
                hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
                hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
                StatisticManager.onEventWithValues(PayStatServiceEvent.STD_PAY_CANCEL, collectData, hashMap);
                PayCallBack payCallBack2 = payCallBack;
                if (payCallBack2 != null) {
                    payCallBack2.onPayResult(2, "");
                }
            }
        });
        WalletLoginHelper.getInstance().login(this.f23044d);
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doPay(Context context, String str, PayCallBack payCallBack, @NonNull Map<String, String> map) {
        cashierEnterSensor(PayStatServiceEvent.STD_PAY_ENTER, str);
        if (c()) {
            StatisticManager.onEvent(PayStatServiceEvent.FAST_DOUBLE_CLICK_DO_PAY);
            List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), "FastDoubleClick", "", "");
            HashMap hashMap = new HashMap();
            hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
            hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
            if (StatHelper.isPrecashierPay(StatHelper.getOrderNo())) {
                hashMap.put("pay_category", "1");
            }
            StatisticManager.onEventWithValues(PayStatServiceEvent.STD_PAY_FAILED, collectData, hashMap);
        } else if (com.baidu.wallet.core.beans.BeanConstants.CHANNEL_ID.equals(BeanConstants.CHANNEL_ID_CHE_LIAN_WANG)) {
            this.f23046f = payCallBack;
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.baidu.wallet.remotepay.RemotePayEnterActivity");
            intent.putExtra("caller", a(str, (Map<String, String>) null, map));
            intent.putExtra("service", false);
            if (!(context instanceof Activity)) {
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            context.startActivity(intent);
        } else {
            PayDataCache.getInstance().setIsRemotePay(false);
            PayDataCache.getInstance().resetFromPrecashier();
            a(context, str, payCallBack, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        if (PayDataCache.getInstance().isRemotePay()) {
            String[] strArr = new String[3];
            strArr[0] = BaiduWalletDelegate.getInstance().getAppContext().getPackageName();
            strArr[1] = (map == null || map.isEmpty()) ? "" : map.get(Constants.KEY_REMOTE_PKG_NAME);
            strArr[2] = StatServiceEvent.REMOTE_DO_REMOTE_PAY;
            PayStatisticsUtil.onEventWithValues(StatServiceEvent.REMOTE_DO_REMOTE_PAY, com.baidu.wallet.base.a.a.a(str, strArr));
            BaiduPay.getInstance().doRemotePay(context, str, payCallBack, map);
            return;
        }
        BaiduPay.getInstance().doPay(context, str, payCallBack, map);
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void getPayMethod(Context context, String str, @NonNull final IPrecashierCallback iPrecashierCallback) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("requestInfo") && jSONObject.get("requestInfo") != null) {
                getInstance().getPayMethod(context, jSONObject.getString("requestInfo"), new IDefaultPayMethodCallback() { // from class: com.baidu.wallet.api.BaiduPayDelegate.5
                    @Override // com.baidu.wallet.paysdk.precashier.IDefaultPayMethodCallback
                    public void onReceived(int i, String str2) {
                        String a2;
                        if (i == 0) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("data", Base64Utils.encodeToString(str2.getBytes()));
                            a2 = BaiduPayDelegate.this.a((Map<String, Object>) hashMap, true);
                        } else {
                            a2 = BaiduPayDelegate.this.a(String.valueOf(i), str2);
                        }
                        iPrecashierCallback.onResult(a2);
                    }
                });
                return;
            }
            throw new InvalidParameterException("参数非法");
        } catch (Exception e2) {
            e2.printStackTrace();
            String a2 = a(LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage());
            if (iPrecashierCallback != null) {
                iPrecashierCallback.onResult(a2);
            }
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void changePayMethod(Activity activity, String str, final IPrecashierCallback iPrecashierCallback) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Map hashMap = new HashMap();
        try {
            JSONObject jSONObject3 = new JSONObject(str);
            if (jSONObject3.has("requestInfo") && jSONObject3.get("requestInfo") != null) {
                if (jSONObject3.has("requestInfo") && (jSONObject2 = (JSONObject) jSONObject3.get("requestInfo")) != null) {
                    hashMap = (Map) JsonUtils.fromJson(jSONObject2.toString(), Map.class);
                }
                if (jSONObject3.has("requestInfoExtra") && (jSONObject = jSONObject3.getJSONObject("requestInfoExtra")) != null) {
                    hashMap.putAll((Map) JsonUtils.fromJson(jSONObject.toString(), Map.class));
                }
                final String str2 = hashMap.containsKey("version") ? (String) hashMap.get("version") : "0";
                getInstance().changePayMethod(activity, hashMap, new IModifyPayTypeCallback() { // from class: com.baidu.wallet.api.BaiduPayDelegate.20
                    @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                    public void onPayTypeModified(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
                        String localizedMessage;
                        HashMap hashMap2 = new HashMap();
                        if ("1".equals(str2)) {
                            localizedMessage = precashierModifyPayTypeDefaultData.getOriginalHttpResponse();
                        } else {
                            JSONObject jSONObject4 = new JSONObject();
                            if (precashierModifyPayTypeDefaultData != null) {
                                try {
                                    jSONObject4.put("pay_type", precashierModifyPayTypeDefaultData.defaultType);
                                    jSONObject4.put("updated", precashierModifyPayTypeDefaultData.updated);
                                    jSONObject4.put("balance_amount", precashierModifyPayTypeDefaultData.balance_amount);
                                    if (precashierModifyPayTypeDefaultData.card != null) {
                                        jSONObject4.put("single_quota", precashierModifyPayTypeDefaultData.card.single_quota);
                                        jSONObject4.put("single_limit", precashierModifyPayTypeDefaultData.card.single_limit);
                                        jSONObject4.put("day_limit", precashierModifyPayTypeDefaultData.card.day_limit);
                                        jSONObject4.put("month_limit", precashierModifyPayTypeDefaultData.card.month_limit);
                                        jSONObject4.put("account_no", precashierModifyPayTypeDefaultData.card.account_no);
                                        jSONObject4.put("bank_name", precashierModifyPayTypeDefaultData.card.bank_name);
                                    }
                                    localizedMessage = jSONObject4.toString();
                                } catch (JSONException e2) {
                                    localizedMessage = e2.getLocalizedMessage();
                                }
                            } else {
                                localizedMessage = "";
                            }
                        }
                        hashMap2.put("data", Base64Utils.encodeToString(localizedMessage.getBytes()));
                        iPrecashierCallback.onResult(BaiduPayDelegate.this.a((Map<String, Object>) hashMap2, true));
                    }

                    @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                    public void onPayTypeSetted() {
                    }
                });
                return;
            }
            throw new InvalidParameterException("参数非法");
        } catch (Exception e2) {
            iPrecashierCallback.onResult(a(LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage()));
        }
    }

    private Bundle a(String str, Map<String, String> map, Map<String, String> map2) {
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT < 18) {
            try {
                bundle.getClass().getDeclaredMethod("putIBinder", String.class, IBinder.class).invoke(bundle, "callback", b());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            bundle.putBinder("callback", (IBinder) b());
        }
        bundle.putString("order_info", str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(map);
        arrayList.add(map2);
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        arrayList2.add(arrayList);
        bundle.putParcelableArrayList("map_params", arrayList2);
        return bundle;
    }

    private boolean c() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f23047g;
        com.baidu.apollon.utils.LogUtil.logd("timeD=" + j);
        if (0 >= j || j >= 800) {
            this.f23047g = currentTimeMillis;
            return false;
        }
        return true;
    }

    public void preOrderPay(final Context context, final String str, String str2, final PayCallBack payCallBack, IModifyPayTypeCallback iModifyPayTypeCallback) {
        StatisticManager.onEvent("preOrderPay");
        if (c()) {
            StatisticManager.onEvent(PayStatServiceEvent.FAST_DOUBLE_CLICK_PRE_ORDER_PAY);
            return;
        }
        cashierEnterSensor(PayStatServiceEvent.PERCASHIER_PAY_ENTER, str);
        final HashMap hashMap = new HashMap();
        hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
        hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
        PayController.getInstance().setModifyPayTypeCallback(iModifyPayTypeCallback);
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(TextUtils.isEmpty(str2) ? "order_from=pre_cashdesk" : !str2.contains("order_from") ? "&order_from=pre_cashdesk" : "");
        final String sb2 = sb.toString();
        PayDataCache.getInstance().setIsRemotePay(false);
        PayDataCache.getInstance().setFromPreCashier();
        String orderNo = StatHelper.getOrderNo();
        String[] strArr = new String[1];
        strArr[0] = WalletLoginHelper.getInstance().isPassLogin() ? "1" : "0";
        StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PAY_LOGIN, StatHelper.collectData(orderNo, strArr), hashMap);
        StatHelper.cachePassLoginStatus(WalletLoginHelper.getInstance().isPassLogin() ? "1" : "0");
        this.f23044d = new HandlePassLoginResult(context, true, new ILoginBackListener() { // from class: com.baidu.wallet.api.BaiduPayDelegate.16
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str3) {
                if (i == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BaiduPayDelegate.this.f23044d);
                    return;
                }
                if (StatHelper.getPassLoginStatus().equals("1")) {
                    StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_OPENBDUSS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), "0"), hashMap);
                }
                PayCallBack payCallBack2 = payCallBack;
                if (payCallBack2 != null) {
                    payCallBack2.onPayResult(2, "");
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str3) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_OPENBDUSS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), "1"), hashMap);
                BaiduPay.getInstance().preOrderPay(context, str, sb2, payCallBack, new HashMap());
            }
        });
        WalletLoginHelper.getInstance().login(this.f23044d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, final IDefaultPayMethodCallback iDefaultPayMethodCallback) {
        BeanManager.getInstance().removeAllBeans(f23042b);
        new Handler(context.getMainLooper()).removeCallbacksAndMessages(null);
        StatisticManager.onEventStart("getPayMethod");
        PrecashierDefaultPayTypeBean precashierDefaultPayTypeBean = (PrecashierDefaultPayTypeBean) PrecashierBeanFactory.getInstance().getBean(context, 1, f23042b);
        precashierDefaultPayTypeBean.setParams(str);
        precashierDefaultPayTypeBean.setResponseCallback(new IBeanResponseCallback() { // from class: com.baidu.wallet.api.BaiduPayDelegate.4
            @Override // com.baidu.apollon.beans.IBeanResponseCallback
            public void onBeanExecFailure(int i, int i2, String str2) {
                StatisticManager.onEventEnd("getPayMethod", i2);
                IDefaultPayMethodCallback iDefaultPayMethodCallback2 = iDefaultPayMethodCallback;
                if (iDefaultPayMethodCallback2 != null) {
                    iDefaultPayMethodCallback2.onReceived(i2, str2);
                }
            }

            @Override // com.baidu.apollon.beans.IBeanResponseCallback
            public void onBeanExecSuccess(int i, Object obj, String str2) {
                if (iDefaultPayMethodCallback == null) {
                    return;
                }
                JSONObject jSONObject = null;
                if (obj != null && (obj instanceof String)) {
                    String str3 = (String) obj;
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        try {
                            if (jSONObject2.getInt(Constants.KEYS.RET) == 0) {
                                StatisticManager.onEventEnd("getPayMethod", 0);
                                iDefaultPayMethodCallback.onReceived(0, str3);
                                return;
                            }
                        } catch (JSONException unused) {
                        }
                        jSONObject = jSONObject2;
                    } catch (JSONException unused2) {
                    }
                }
                int i2 = -1;
                String str4 = "";
                if (jSONObject != null) {
                    try {
                        i2 = jSONObject.getInt(Constants.KEYS.RET);
                        str4 = jSONObject.getString("msg");
                    } catch (Exception unused3) {
                    }
                }
                StatisticManager.onEventEnd("getPayMethod", i2);
                iDefaultPayMethodCallback.onReceived(i2, str4);
            }
        });
        precashierDefaultPayTypeBean.execBean();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final IWalletOuterInterfaceListener iWalletOuterInterfaceListener) {
        BeanManager.getInstance().removeAllBeans(f23041a);
        final Handler handler = new Handler(context.getMainLooper());
        handler.removeCallbacksAndMessages(null);
        PayStatisticsUtil.onEventStart(StatServiceEvent.GET_WALLET_OUTER_INTERFACE);
        w wVar = (w) PayBeanFactory.getInstance().getBean(context, PayBeanFactory.BEAN_ID_GET_WALLET_INTERFACE, f23041a);
        wVar.setResponseCallback(new IBeanResponseCallback() { // from class: com.baidu.wallet.api.BaiduPayDelegate.11
            @Override // com.baidu.apollon.beans.IBeanResponseCallback
            public void onBeanExecFailure(int i, final int i2, final String str) {
                PayStatisticsUtil.onEventEnd(StatServiceEvent.GET_WALLET_OUTER_INTERFACE, i2);
                handler.post(new Runnable() { // from class: com.baidu.wallet.api.BaiduPayDelegate.11.3
                    @Override // java.lang.Runnable
                    public void run() {
                        IWalletOuterInterfaceListener iWalletOuterInterfaceListener2 = iWalletOuterInterfaceListener;
                        if (iWalletOuterInterfaceListener2 != null) {
                            iWalletOuterInterfaceListener2.onReceived(i2, str);
                        }
                    }
                });
            }

            @Override // com.baidu.apollon.beans.IBeanResponseCallback
            public void onBeanExecSuccess(int i, Object obj, String str) {
                JSONObject jSONObject;
                PayStatisticsUtil.onEventEnd(StatServiceEvent.GET_WALLET_OUTER_INTERFACE, 0);
                WalletInterfaceResponse walletInterfaceResponse = obj instanceof WalletInterfaceResponse ? (WalletInterfaceResponse) obj : null;
                if (walletInterfaceResponse != null && (jSONObject = walletInterfaceResponse.login_data) != null) {
                    final String jSONObject2 = jSONObject.toString();
                    String encodeBytes = Base64.encodeBytes(jSONObject2.getBytes());
                    String newPpKey = PayPreferenceManager.getNewPpKey(context);
                    if (!TextUtils.isEmpty(newPpKey) && !TextUtils.isEmpty(encodeBytes)) {
                        PayPreferenceManager.setWalletInterfaceData(context, newPpKey, encodeBytes);
                    }
                    handler.post(new Runnable() { // from class: com.baidu.wallet.api.BaiduPayDelegate.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IWalletOuterInterfaceListener iWalletOuterInterfaceListener2 = iWalletOuterInterfaceListener;
                            if (iWalletOuterInterfaceListener2 != null) {
                                iWalletOuterInterfaceListener2.onReceived(0, jSONObject2);
                            }
                        }
                    });
                } else {
                    handler.post(new Runnable() { // from class: com.baidu.wallet.api.BaiduPayDelegate.11.2
                        @Override // java.lang.Runnable
                        public void run() {
                            IWalletOuterInterfaceListener iWalletOuterInterfaceListener2 = iWalletOuterInterfaceListener;
                            if (iWalletOuterInterfaceListener2 != null) {
                                iWalletOuterInterfaceListener2.onReceived(-1, "");
                            }
                        }
                    });
                }
                if (walletInterfaceResponse == null || walletInterfaceResponse.unlogin_data == null) {
                    return;
                }
                PayPreferenceManager.setWalletInterfaceData(context, BaiduPayDelegate.f23043c, walletInterfaceResponse.unlogin_data.toString());
            }
        });
        wVar.execBean();
    }

    private void a(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        if (!PayDataCache.getInstance().isRemotePay()) {
            StatisticManager.onEventWithValues(PayStatServiceEvent.LCL_PAY_ENTER, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo()));
        }
        c(context, str, payCallBack, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Map<String, String> map) {
        if (context == null || map == null) {
            return;
        }
        String str = map.get(Constants.KEY_REMOTE_PKG_NAME);
        String str2 = map.get(Constants.KEY_REMOTE_WHERE_TO_BACK);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        ComponentName componentName = new ComponentName(str, str2);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.addFlags(536870912);
        intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    private ArrayList<String> a(String str, Map map, Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str) && map == null) {
            return arrayList;
        }
        try {
            String spNo = StatHelper.getSpNo(str);
            StatHelper.cacheSpNo(spNo);
            arrayList.add(spNo);
            String orderNo = StatHelper.getOrderNo(str);
            StatHelper.cacheOrderNo(orderNo);
            arrayList.add(orderNo);
            arrayList.add(context.getPackageName());
            if (map.containsKey(Constants.KEY_REMOTE_PKG_NAME)) {
                String str2 = (String) map.get(Constants.KEY_REMOTE_PKG_NAME);
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                StatHelper.cacheFromPkg(str2);
                arrayList.add(str2);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    private ArrayList<String> a(WalletInterfaceResponse.WalletModuleData walletModuleData) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (walletModuleData == null) {
            return arrayList;
        }
        arrayList.add("" + walletModuleData.type);
        arrayList.add(walletModuleData.link_addr);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Map<String, Object> map, boolean z) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", z ? 0 : 1);
            jSONObject.put("cnt", new JSONObject(map));
        } catch (JSONException e2) {
            LogUtil.e(f23041a, "error", e2);
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2) {
        JSONObject jSONObject;
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            jSONObject = null;
        } else {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(RouterCallback.KEY_ERROR_CODE, str);
                jSONObject.put("des", str2);
            } catch (JSONException e2) {
                LogUtil.e(f23041a, "error", e2);
            }
        }
        hashMap.put("data", Base64Utils.encodeToString(jSONObject != null ? jSONObject.toString().getBytes() : str2.getBytes()));
        return a((Map<String, Object>) hashMap, false);
    }
}
