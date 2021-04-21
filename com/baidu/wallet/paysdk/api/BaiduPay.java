package com.baidu.wallet.paysdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.pay.BindBack;
import com.baidu.android.pay.PayCallBack;
import com.baidu.android.pay.ScanCodeCallBack;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.CheckCallBack;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BindCardEntry;
import com.baidu.wallet.paysdk.b.i;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.UserInfoBean;
import com.baidu.wallet.paysdk.beans.VerifyPayPasswordBean;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.datamodel.VerifyPayPasswordResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.BindCardImplActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.baidu.wallet.paysdk.ui.WelcomeActivity;
import com.baidu.wallet.remotepay.RemotePaySplashActivity;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import com.google.protobuf.CodedInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class BaiduPay {
    public static final String AMOUNT = "pay_amount";
    public static final String PAY_FROM = "pay_from";
    public static final String PAY_FROM_AUTHORIZE = "pay_from_authorize";
    public static final String PAY_FROM_BIND_CARD = "pay_from_bind_card";
    public static final String PAY_FROM_HUA_FEI = "pay_from_huafei";
    public static final String PAY_FROM_HUA_ZHUAN_ZHANG = "pay_from_zhuanzhang";
    public static final String PAY_FROM_NFC_BUSCARD_CHARGE = "pay_from_nfc_buscard_charge";
    public static final String PAY_FROM_TRAFFIC = "pay_from_traffic";
    public static final String PAY_TYPE_KEY = "type";
    public static final String PRECASHIER_PAY_RESPONSE = "precashier_pay_response";
    public static final int TYPE_FASE_PAY = 4;
    public static final int TYPE_PAY_ALL = 0;
    public static final int TYPE_SURPLUS = 1;

    /* renamed from: a  reason: collision with root package name */
    public PayCallBack f25074a;

    /* renamed from: b  reason: collision with root package name */
    public IBindCardCallback f25075b;

    /* renamed from: c  reason: collision with root package name */
    public RNAuthCallBack f25076c;

    /* renamed from: d  reason: collision with root package name */
    public a f25077d;

    /* renamed from: e  reason: collision with root package name */
    public ScanCodeCallBack f25078e;

    /* renamed from: f  reason: collision with root package name */
    public Context f25079f;

    /* renamed from: com.baidu.wallet.paysdk.api.BaiduPay$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass2 implements IBeanResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f25082a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f25083b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CheckCallBack f25084c;

        public AnonymousClass2(Context context, CheckCallBack checkCallBack) {
            this.f25083b = context;
            this.f25084c = checkCallBack;
            this.f25082a = new Handler(this.f25083b.getMainLooper());
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i, int i2, final String str) {
            WalletGlobalUtils.DismissLoadingDialog();
            this.f25082a.post(new Runnable() { // from class: com.baidu.wallet.paysdk.api.BaiduPay.2.2
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass2.this.f25084c.onCheckResult(3, str);
                }
            });
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i, final Object obj, String str) {
            WalletGlobalUtils.DismissLoadingDialog();
            this.f25082a.post(new Runnable() { // from class: com.baidu.wallet.paysdk.api.BaiduPay.2.1
                @Override // java.lang.Runnable
                public void run() {
                    UserData.UserModel userModel;
                    DirectPayContentResponse directPayContentResponse = (DirectPayContentResponse) obj;
                    if (directPayContentResponse != null && (userModel = directPayContentResponse.user) != null && userModel.hasMobilePwd()) {
                        PasswordController.getPassWordInstance().checkPwd(AnonymousClass2.this.f25083b, BeanConstants.FROM_COMMON_CHECK_PWD, new PasswordController.IPwdListener() { // from class: com.baidu.wallet.paysdk.api.BaiduPay.2.1.1
                            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                            public void onFail(int i2, String str2) {
                                PasswordController.getPassWordInstance().clearCheckPwdListener();
                                AnonymousClass2.this.f25084c.onCheckResult(2, QueryResponse.Options.CANCEL);
                            }

                            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                            public void onSucceed(String str2) {
                                PasswordController.getPassWordInstance().clearCheckPwdListener();
                                AnonymousClass2.this.f25084c.onCheckResult(0, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS);
                            }
                        });
                    } else {
                        AnonymousClass2.this.f25084c.onCheckResult(1, "当前未设置手机支付密码");
                    }
                }
            });
        }
    }

    /* renamed from: com.baidu.wallet.paysdk.api.BaiduPay$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 implements IBeanResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f25091a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f25092b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f25093c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CheckCallBack f25094d;

        public AnonymousClass3(Context context, String str, CheckCallBack checkCallBack) {
            this.f25092b = context;
            this.f25093c = str;
            this.f25094d = checkCallBack;
            this.f25091a = new Handler(this.f25092b.getMainLooper());
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i, int i2, final String str) {
            StatisticManager.onEventEnd(StatServiceEvent.CHECK_BASE_INFO, i2);
            WalletGlobalUtils.DismissLoadingDialog();
            this.f25091a.post(new Runnable() { // from class: com.baidu.wallet.paysdk.api.BaiduPay.3.2
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass3.this.f25094d.onCheckResult(3, str);
                }
            });
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i, final Object obj, String str) {
            WalletGlobalUtils.DismissLoadingDialog();
            this.f25091a.post(new Runnable() { // from class: com.baidu.wallet.paysdk.api.BaiduPay.3.1
                @Override // java.lang.Runnable
                public void run() {
                    VerifyPayPasswordResponse verifyPayPasswordResponse = (VerifyPayPasswordResponse) obj;
                    if (verifyPayPasswordResponse != null && verifyPayPasswordResponse.has_pwd == 1) {
                        StatisticManager.onEventEnd(StatServiceEvent.CHECK_BASE_INFO, 0);
                        PasswordController passWordInstance = PasswordController.getPassWordInstance();
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        passWordInstance.checkPwdFromH5(anonymousClass3.f25092b, anonymousClass3.f25093c, BeanConstants.FROM_COMMON_CHECK_PWD_FROM_H5, new PasswordController.IPwdListener() { // from class: com.baidu.wallet.paysdk.api.BaiduPay.3.1.1
                            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                            public void onFail(int i2, String str2) {
                                PasswordController.getPassWordInstance().clearCheckPwdListener();
                                AnonymousClass3.this.f25094d.onCheckResult(2, QueryResponse.Options.CANCEL);
                            }

                            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                            public void onSucceed(String str2) {
                                PasswordController.getPassWordInstance().clearCheckPwdListener();
                                AnonymousClass3.this.f25094d.onCheckResult(0, str2);
                            }
                        });
                        return;
                    }
                    StatisticManager.onEventEnd(StatServiceEvent.CHECK_BASE_INFO, 1);
                    AnonymousClass3.this.f25094d.onCheckResult(1, "当前未设置手机支付密码");
                }
            });
        }
    }

    /* loaded from: classes5.dex */
    public interface IBindCardCallback {
        void onChangeFailed(String str);

        void onChangeSucceed(String str);
    }

    /* loaded from: classes5.dex */
    public static class a implements BindBack {

        /* renamed from: a  reason: collision with root package name */
        public final BindBack f25103a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f25104b;

        @Override // com.baidu.android.pay.BindBack
        public boolean isHideLoadingDialog() {
            return false;
        }

        @Override // com.baidu.android.pay.BindBack
        public void onBindResult(int i, String str) {
            BindBack bindBack = this.f25103a;
            if (bindBack != null) {
                bindBack.onBindResult(i, str);
            }
            this.f25104b = false;
        }

        public a(BindBack bindBack) {
            this.f25104b = true;
            this.f25103a = bindBack;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static BaiduPay f25105a = new BaiduPay();
    }

    private void a(Context context, String str, PayCallBack payCallBack, Map<String, String> map, PrecashierCreateOrderResponse precashierCreateOrderResponse) {
        BaiduWalletDelegate.getInstance().checkSecurityEvn();
        if (!WalletLoginHelper.getInstance().isLogin()) {
            a(context);
            if (PayDataCache.getInstance().isFromPreCashier()) {
                return;
            }
            List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), new String[0]);
            HashMap hashMap = new HashMap();
            hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
            hashMap.put(AMOUNT, StatHelper.getPayAmount());
            StatisticManager.onEventWithValues(PayStatServiceEvent.STD_PAY_NOT_LOGIN, collectData, hashMap);
            return;
        }
        if (PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY) != null || PayDataCache.getInstance().isRemotePay()) {
            b(context);
        }
        this.f25074a = payCallBack;
        if (map == null) {
            PayCallBackManager.callBackClientCancel(context, "BaiduPay.innerPay().2");
            return;
        }
        a(str, map);
        a(context, precashierCreateOrderResponse);
    }

    private void b(Context context) {
        boolean isRemotePay = PayDataCache.getInstance().isRemotePay();
        Context remotePayContext = getInstance().getRemotePayContext();
        boolean isFromPreCashier = PayDataCache.getInstance().isFromPreCashier();
        if (!isRemotePay) {
            clearPayBack();
            PayCallBackManager.callBackClientCancel(context, "BaiduPay.innerPay().3");
        } else {
            PayCallBackManager.callBackClientClear(context, "BaiduPay.innerPay().4");
            clearPayBack();
            PayDataCache.getInstance().setIsRemotePay(true);
            getInstance().setRemotePayContext(remotePayContext);
        }
        if (isFromPreCashier) {
            PayDataCache.getInstance().setFromPreCashier();
        }
    }

    public static BaiduPay getInstance() {
        return b.f25105a;
    }

    public void bindCard(Context context, IBindCardCallback iBindCardCallback, PayRequestCache.BindCategory bindCategory, int i, String str, String str2, Bundle bundle, String str3, boolean z, String str4) {
        if (bindCategory == null || PayRequestCache.BindCategory.Other == bindCategory) {
            throw new IllegalStateException("not support bind card for Paying");
        }
        if (context == null) {
            if (iBindCardCallback != null) {
                iBindCardCallback.onChangeFailed("");
                return;
            }
            return;
        }
        BindFastRequest createBindRequest = BindCardEntry.createBindRequest(bindCategory);
        createBindRequest.mBindFrom = i;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str2)) {
            createBindRequest.setSp_no(str2);
            sb.append("sp_no:\"");
            sb.append(str2);
            sb.append("\",");
        }
        if (!TextUtils.isEmpty(str)) {
            createBindRequest.serviceType = str;
            sb.append("service_type:\"");
            sb.append(str);
            sb.append("\"}");
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(Constants.BDL_KEY_FROM, bindCategory.name());
        if (!TextUtils.isEmpty(str3)) {
            if (sb.length() > 0) {
                sb.insert(0, str3);
                sb.setCharAt(str3.length() - 1, ',');
                sb.setCharAt(sb.length() - 1, '}');
            } else {
                sb.append(str3);
            }
        } else if (sb.length() > 0) {
            sb.insert(0, StringUtil.ARRAY_START).setCharAt(sb.length() - 1, '}');
        }
        if (sb.length() > 0) {
            BindCardEntry.setExtrParam(sb.toString());
        }
        BindCardEntry.OnReturn createCb4CheckPwdAndBind = BindCardEntry.createCb4CheckPwdAndBind(context, iBindCardCallback, bundle, z, str4);
        BindCardEntry.init(context);
        BindCardEntry.setCallback(createCb4CheckPwdAndBind);
        BindCardEntry.run();
    }

    public void bindCardAuth(Context context, boolean z) {
        BindFastRequest bindFastRequest = new BindFastRequest();
        bindFastRequest.mBindFrom = 6;
        PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
        Intent intent = new Intent(context, BindCardImplActivity.class);
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(BindFastRequest.BIND_IS_FIRST, z);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public void bindCardOnCardaddReturn(Context context, BindCardEntry.OnReturn onReturn, PayRequestCache.BindCategory bindCategory, int i, String str, String str2) {
        if (onReturn == null) {
            return;
        }
        if (context == null) {
            onReturn.onFailed(-1, "context null");
            return;
        }
        BindCardEntry.init(context);
        BindCardEntry.setCallback(onReturn);
        BindCardEntry.setExtrParam(str2);
        BindFastRequest createBindRequest = BindCardEntry.createBindRequest(bindCategory);
        createBindRequest.mBindFrom = i;
        if (!TextUtils.isEmpty(str)) {
            createBindRequest.serviceType = str;
        }
        BindCardEntry.run();
    }

    public void checkPwd(Context context, CheckCallBack checkCallBack) {
        UserInfoBean userInfoBean = (UserInfoBean) PayBeanFactory.getInstance().getBean(context, 6, TableDefine.DB_TABLE_USERINFO);
        userInfoBean.setResponseCallback(new AnonymousClass2(context, checkCallBack));
        userInfoBean.execBean();
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        WalletGlobalUtils.showLoadingDialog(context);
    }

    public void checkPwdFromH5(Context context, String str, CheckCallBack checkCallBack) {
        StatisticManager.onEventStart(StatServiceEvent.CHECK_BASE_INFO);
        VerifyPayPasswordBean verifyPayPasswordBean = (VerifyPayPasswordBean) PayBeanFactory.getInstance().getBean(context, 600, "userHasPayPassword");
        verifyPayPasswordBean.setResponseCallback(new AnonymousClass3(context, str, checkCallBack));
        verifyPayPasswordBean.execBean();
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        WalletGlobalUtils.showLoadingDialog(context);
    }

    public void clearBindCallback() {
        this.f25075b = null;
    }

    public void clearBindCallbackExt() {
        this.f25077d = null;
    }

    public void clearPayBack() {
        this.f25074a = null;
    }

    public void clearRNAuthBack() {
        this.f25076c = null;
    }

    public void completeCardAuth(Context context, CardData.BondCard bondCard) {
        BindFastRequest bindFastRequest = new BindFastRequest();
        bindFastRequest.mBindFrom = 7;
        bindFastRequest.mBondCard = bondCard;
        PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
        Intent intent = new Intent(context, BindCardImplActivity.class);
        int a2 = i.a().a(context, bondCard, false);
        if (a2 > 0) {
            intent.putExtra("halfScreen", a2);
        }
        intent.putExtra("reasonForChangeCardItem", 1);
        context.startActivity(intent);
    }

    public void directAuth(Context context, CardData.BondCard bondCard) {
        CardData.BondCard bondCard2;
        BindFastRequest bindFastRequest = new BindFastRequest();
        bindFastRequest.mBondCard = bondCard;
        bindFastRequest.mBindFrom = 8;
        bindFastRequest.setmBankInfo(null);
        bindFastRequest.setmPhone(bondCard.mobile);
        bindFastRequest.setSendSmsphone(bondCard.mobile);
        bindFastRequest.setmBankCard(bondCard.account_no);
        bindFastRequest.setSubBankCode(bondCard.account_bank_code);
        a(bindFastRequest, bondCard);
        PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
        Intent intent = new Intent(context, WalletSmsActivity.class);
        intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 0);
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        if (payRequest != null && (bondCard2 = payRequest.mBondCard) != null && bondCard2.hideSMSDialog && PAY_FROM_AUTHORIZE.equals(payRequest.mPayFrom)) {
            intent.putExtra("showSMSDialog", false);
        }
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).startActivityWithoutAnim(intent);
        } else {
            context.startActivity(intent);
        }
    }

    public void doBindCardExt(Context context, final BindBack bindBack, Map<String, String> map, String str) {
        String sb;
        String urlParam2JsonStr;
        if (map != null && context != null) {
            if (!WalletLoginHelper.getInstance().isLogin()) {
                PayCallBackManager.callBackClientCancel(context, "BaiduPay.doBindCardExt().2");
                return;
            }
            setBindCardbackExt(bindBack);
            if (map.isEmpty() && TextUtils.isEmpty(str)) {
                urlParam2JsonStr = null;
            } else {
                PayDataCache.getInstance().setIsRemotePay(false);
                PayDataCache.getInstance().resetFromPrecashier();
                PayRequest payRequest = new PayRequest();
                payRequest.setPayFrom(PAY_FROM_BIND_CARD);
                if (!TextUtils.isEmpty(str)) {
                    sb = str;
                    payRequest.initBindCardOrder(sb);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (sb2.length() > 1) {
                            sb2.append("&");
                        }
                        sb2.append(entry.getKey());
                        sb2.append("=");
                        sb2.append(entry.getValue());
                    }
                    sb = sb2.toString();
                }
                if (TextUtils.isEmpty(payRequest.mSpNO)) {
                    payRequest.mSpNO = map.get(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID);
                }
                if (TextUtils.isEmpty(payRequest.mOrderNo)) {
                    payRequest.mOrderNo = map.get("order_no");
                }
                payRequest.mParams = sb;
                PayRequestCache.getInstance().addBeanRequestToCache(payRequest.getRequestId(), payRequest);
                urlParam2JsonStr = com.baidu.wallet.utils.StringUtil.urlParam2JsonStr(sb);
            }
            getInstance().bindCard(context, new IBindCardCallback() { // from class: com.baidu.wallet.paysdk.api.BaiduPay.1
                @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                public void onChangeFailed(String str2) {
                    BindBack bindBack2 = bindBack;
                    if (bindBack2 != null) {
                        bindBack2.onBindResult(-1, "");
                    } else {
                        BaiduPay.this.setBindCardbackExt(null);
                    }
                }

                @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                public void onChangeSucceed(String str2) {
                    BindBack bindBack2 = bindBack;
                    if (bindBack2 != null) {
                        bindBack2.onBindResult(0, "");
                    } else {
                        BaiduPay.this.setBindCardbackExt(null);
                    }
                }
            }, PayRequestCache.BindCategory.Initiative, 1, "", null, null, urlParam2JsonStr, true, BeanConstants.FROM_BIND);
            return;
        }
        PayCallBackManager.callBackClientCancel(context, "BaiduPay.doBindCardExt().1");
    }

    public void doCheckPwd(Context context, Map<String, String> map, final CheckCallBack checkCallBack) {
        PasswordController.getPassWordInstance().checkPwdForSp(context, map, new PasswordController.IPwdListener() { // from class: com.baidu.wallet.paysdk.api.BaiduPay.4
            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
            public void onFail(int i, String str) {
                PasswordController.getPassWordInstance().clearCheckPwdListener();
                checkCallBack.onCheckResult(i, str);
            }

            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
            public void onSucceed(String str) {
                PasswordController.getPassWordInstance().clearCheckPwdListener();
                checkCallBack.onCheckResult(0, "");
            }
        });
    }

    public void doPay(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        PayDataCache.getInstance().setIsRemotePay(false);
        PayDataCache.getInstance().resetFromPrecashier();
        if (!StatHelper.getOrderNo(str).equals(StatHelper.getOrderNo())) {
            BaiduPayDelegate.getInstance().cashierEnterSensor(PayStatServiceEvent.STD_PAY_ENTER, str);
        }
        a(context, str, payCallBack, map, null);
    }

    public void doPrecashierPay(Context context, String str, PayCallBack payCallBack, Map<String, String> map, PrecashierCreateOrderResponse precashierCreateOrderResponse) {
        PayDataCache.getInstance().setIsRemotePay(false);
        PayDataCache.getInstance().setFromPreCashier();
        a(context, str, payCallBack, map, precashierCreateOrderResponse);
    }

    public void doRNAuth(Context context, Map<String, String> map, RNAuthCallBack rNAuthCallBack) {
        if (WalletLoginHelper.getInstance().isLogin() && map != null) {
            this.f25076c = rNAuthCallBack;
            StringBuilder sb = new StringBuilder();
            if (!map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append("&");
                }
            }
            sb.append("is_from_sdk=1");
            StringBuilder sb2 = new StringBuilder(DomainConfig.getInstance().getMHost() + "/static/wap/auth/");
            if (sb.length() > 0) {
                sb2.append("?");
                sb2.append(sb.toString());
            }
            String sb3 = sb2.toString();
            Bundle bundle = new Bundle();
            bundle.putInt(Constants.BDL_KEY_BIZTYPE, 12);
            BaiduWalletDelegate.getInstance().openH5Module(context, sb3, false, bundle);
        }
    }

    public void doRemotePay(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        this.f25079f = context;
        PayDataCache.getInstance().setIsRemotePay(true);
        PayDataCache.getInstance().resetFromPrecashier();
        a(context, str, payCallBack, map, null);
    }

    public void finish() {
        clearPayBack();
    }

    public IBindCardCallback getBindCallback() {
        return this.f25075b;
    }

    public BindBack getBindCallbackExt() {
        return this.f25077d;
    }

    public PayCallBack getPayBack() {
        return this.f25074a;
    }

    public RNAuthCallBack getRNAuthBack() {
        return this.f25076c;
    }

    public Context getRemotePayContext() {
        return this.f25079f;
    }

    public ScanCodeCallBack getScanCallback() {
        return this.f25078e;
    }

    public boolean isBindCardProcessing() {
        a aVar = this.f25077d;
        return aVar != null && aVar.f25104b;
    }

    public void jumpWapCashier(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.setClassName(context, str2);
        intent.putExtra("jump_url", str);
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        context.startActivity(intent);
    }

    public void launchBindCardActivity(Context context, IBindCardCallback iBindCardCallback, Bundle bundle) {
        if (context == null) {
            if (iBindCardCallback != null) {
                iBindCardCallback.onChangeFailed("");
                return;
            }
            return;
        }
        this.f25075b = iBindCardCallback;
        Intent intent = new Intent(context, BindCardImplActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        context.startActivity(intent);
    }

    public void preOrderPay(Context context, String str, String str2, PayCallBack payCallBack, Map<String, String> map) {
        Intent intent;
        PayDataCache.getInstance().setIsRemotePay(false);
        PayDataCache.getInstance().setFromPreCashier();
        PayDataCache.getInstance().setOrderExtraInfo(str2);
        BaiduWalletDelegate.getInstance().checkSecurityEvn();
        if (!WalletLoginHelper.getInstance().isLogin()) {
            a(context);
            return;
        }
        if (PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY) != null || PayDataCache.getInstance().isRemotePay()) {
            b(context);
        }
        this.f25074a = payCallBack;
        if (map == null) {
            PayCallBackManager.callBackClientCancel(context, "BaiduPay.innerPay().2");
            return;
        }
        a(str, map);
        if (PayDataCache.getInstance().isRemotePay()) {
            intent = new Intent(context, RemotePaySplashActivity.class);
        } else {
            intent = new Intent(context, WelcomeActivity.class);
        }
        intent.putExtra("fromType", 3);
        intent.putExtra("orderExtraInfo", str2);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.startActivityForResult(intent, BeanConstants.REQUEST_CODE_PAY_ACTIVITY);
            activity.overridePendingTransition(0, 0);
            return;
        }
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        if (PayDataCache.getInstance().isRemotePay()) {
            intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        }
        context.getApplicationContext().startActivity(intent);
    }

    public void resetRemotePayContext() {
        this.f25079f = null;
    }

    public void setBindCardbackExt(BindBack bindBack) {
        this.f25077d = bindBack != null ? new a(bindBack) : null;
    }

    public void setRemotePayContext(Context context) {
        this.f25079f = context;
    }

    public void setScanCallback(ScanCodeCallBack scanCodeCallBack) {
        this.f25078e = scanCodeCallBack;
    }

    public BaiduPay() {
    }

    private void a(String str, Map<String, String> map) {
        PayRequest a2 = a(str, map, map.get(PAY_FROM));
        PayRequestCache.getInstance().addBeanRequestToCache(a2.getRequestId(), a2);
    }

    private void a(Context context) {
        LogUtil.d("BaiduPay", "必须要登陆");
        PayCallBackManager.callBackClientCancel(context, "BaiduPay.innerPay().1");
        AccountManager.getInstance(context).logout();
        WalletLoginHelper.getInstance().handlerWalletError(5003);
        GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_please_login"));
    }

    private void a(Context context, PrecashierCreateOrderResponse precashierCreateOrderResponse) {
        Intent intent;
        if (PayDataCache.getInstance().isRemotePay()) {
            intent = new Intent(context, RemotePaySplashActivity.class);
        } else {
            intent = new Intent(context, WelcomeActivity.class);
        }
        intent.putExtra("fromType", 1);
        if (precashierCreateOrderResponse != null) {
            intent.putExtra(PRECASHIER_PAY_RESPONSE, precashierCreateOrderResponse);
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.startActivityForResult(intent, BeanConstants.REQUEST_CODE_PAY_ACTIVITY);
            activity.overridePendingTransition(0, 0);
            return;
        }
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        if (PayDataCache.getInstance().isRemotePay()) {
            intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        }
        context.getApplicationContext().startActivity(intent);
    }

    private PayRequest a(String str, Map<String, String> map, String str2) {
        PayRequest payRequest = new PayRequest();
        payRequest.setPayFrom(str2);
        if (PayDataCache.getInstance().isRemotePay()) {
            payRequest.mRemotePayUserId = WalletLoginHelper.getInstance().getPassUid();
            payRequest.mRemotePayUserAccountName = WalletLoginHelper.getInstance().getPassUserName();
            payRequest.mRemotePayHostName = map.get(Constants.KEY_REMOTE_APP_NAME);
            payRequest.mRemotePkg = map.get(Constants.KEY_REMOTE_PKG_NAME);
            payRequest.mRemoteWhereToBackAct = map.get(Constants.KEY_REMOTE_WHERE_TO_BACK);
            PayDataCache.getInstance().setRemotePayHostName(map.get(Constants.KEY_REMOTE_APP_NAME));
            PayDataCache.getInstance().setRemotePkg(map.get(Constants.KEY_REMOTE_PKG_NAME));
            PayDataCache.getInstance().setRemoteWhereToBackAct(map.get(Constants.KEY_REMOTE_WHERE_TO_BACK));
        }
        payRequest.initOrder(str);
        LogUtil.d("doPay. order info = " + str);
        return payRequest;
    }

    private void a(BindFastRequest bindFastRequest, CardData.BondCard bondCard) {
        if (bindFastRequest != null) {
            bindFastRequest.setmBankCard(bondCard.account_no);
            bindFastRequest.mBankNo = bondCard.bank_code;
            bindFastRequest.setChannelNo(bondCard.account_bank_code);
            bindFastRequest.setBankType(bondCard.card_type);
            if (bondCard.card_type == 1) {
                bindFastRequest.setmCvv(bondCard.verify_code);
                bindFastRequest.setValidDateFromServer(bondCard.valid_date);
            }
            bindFastRequest.setmName(bondCard.true_name);
            bindFastRequest.setmPhone(bondCard.mobile);
            bindFastRequest.setSendSmsphone(bondCard.mobile);
            bindFastRequest.setmIdCard(bondCard.certificate_code);
            bindFastRequest.setCertificateType(bondCard.certificate_type);
        }
    }
}
