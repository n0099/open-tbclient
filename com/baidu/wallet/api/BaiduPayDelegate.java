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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pay.BindBack;
import com.baidu.android.pay.PayCallBack;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.api.BindCardEntry;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.s;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.datamodel.WalletInterfaceResponse;
import com.baidu.wallet.paysdk.entrance.EnterWalletDxmPayServiceAction;
import com.baidu.wallet.paysdk.fingerprint.FingerprintCallback;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.fingerprint.c;
import com.baidu.wallet.paysdk.precashier.IDefaultPayMethodCallback;
import com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback;
import com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData;
import com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeManager;
import com.baidu.wallet.paysdk.precashier.beans.PrecashierBeanFactory;
import com.baidu.wallet.paysdk.precashier.beans.PrecashierDefaultPayTypeBean;
import com.baidu.wallet.paysdk.securitycenter.bean.PaySetListBean;
import com.baidu.wallet.paysdk.securitycenter.bean.SecurityCenterBean;
import com.baidu.wallet.paysdk.securitycenter.bean.SecurityCenterFactory;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.BindCardPreCheckActivity;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.remotepay.IRemoteServiceCallback;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.Base64Utils;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.Base64;
import com.dxmpay.wallet.BaiduWalletServiceController;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.paysdk.storage.PayPreferenceManager;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.JsonUtil;
import com.dxmpay.wallet.utils.StatHelper;
import com.dxmpay.wallet.utils.realtimeevent.RealTimeEventHelper;
import com.google.protobuf.CodedInputStream;
import com.qq.e.comm.constants.Constants;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class BaiduPayDelegate implements IWalletPayFacade {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int RNAUTH_HIGH_GRADE = 3;
    public static final int RNAUTH_LOW_GRADE = 1;
    public static final int RNAUTH_MEDIUM_GRADE = 2;

    /* renamed from: b  reason: collision with root package name */
    public static final String f59861b = "BaiduPayDelegate";

    /* renamed from: c  reason: collision with root package name */
    public static final String f59862c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f59863d;

    /* renamed from: e  reason: collision with root package name */
    public static String f59864e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f59865a;

    /* renamed from: f  reason: collision with root package name */
    public HandlePassLoginResult f59866f;

    /* renamed from: g  reason: collision with root package name */
    public LoginBackListenerProxy f59867g;

    /* renamed from: h  reason: collision with root package name */
    public PayCallBack f59868h;

    /* renamed from: i  reason: collision with root package name */
    public long f59869i;

    /* loaded from: classes8.dex */
    public class HandlePassLoginResult extends LoginBackListenerProxy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaiduPayDelegate f59956a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f59957b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlePassLoginResult(BaiduPayDelegate baiduPayDelegate, Context context, boolean z, ILoginBackListener iLoginBackListener) {
            super(context, iLoginBackListener);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baiduPayDelegate, context, Boolean.valueOf(z), iLoginBackListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (ILoginBackListener) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59956a = baiduPayDelegate;
            this.f59957b = z;
        }

        @Override // com.dxmpay.wallet.passport.LoginBackListenerProxy, com.baidu.wallet.api.ILoginBackListener
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (this.f59957b) {
                    List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), "0");
                    HashMap hashMap = new HashMap();
                    hashMap.put("sp_no", StatHelper.getSpNo());
                    hashMap.put("pay_amount", StatHelper.getPayAmount());
                    StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PASS_RESULT, collectData, hashMap);
                } else if (PayDataCache.getInstance().isRemotePay()) {
                    StatisticManager.onEventWithValues(PayStatServiceEvent.RMT_PASS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), StatHelper.getFromPkg(), "0"));
                } else {
                    StatHelper.payLoginSeneor(PayStatServiceEvent.LCL_PASS_RESULT, "0");
                }
                StatHelper.cachePassLoginStatus("0");
                super.onFail(i2, str);
            }
        }

        @Override // com.dxmpay.wallet.passport.LoginBackListenerProxy, com.baidu.wallet.api.ILoginBackListener
        public void onSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (StatHelper.getPassLoginStatus().equals("0")) {
                    if (this.f59957b) {
                        List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), "1");
                        HashMap hashMap = new HashMap();
                        hashMap.put("sp_no", StatHelper.getSpNo());
                        hashMap.put("pay_amount", StatHelper.getPayAmount());
                        StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PASS_RESULT, collectData, hashMap);
                    } else if (PayDataCache.getInstance().isRemotePay()) {
                        StatisticManager.onEventWithValues(PayStatServiceEvent.RMT_PASS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), StatHelper.getFromPkg(), "1"));
                    } else {
                        StatHelper.payLoginSeneor(PayStatServiceEvent.LCL_PASS_RESULT, "1");
                    }
                }
                super.onSuccess(i2, str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a implements IBeanResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public com.baidu.wallet.paysdk.securitycenter.a f59958a;

        public a(com.baidu.wallet.paysdk.securitycenter.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59958a = aVar;
        }

        @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i2, int i3, String str) {
            com.baidu.wallet.paysdk.securitycenter.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) || (aVar = this.f59958a) == null) {
                return;
            }
            aVar.a(i3, str);
        }

        @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i2, Object obj, String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) || this.f59958a == null) {
                return;
            }
            int i3 = 10011;
            if (obj == null || !(obj instanceof String)) {
                str2 = EnterDxmPayServiceAction.ERR_MSG;
            } else {
                str2 = (String) obj;
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int optInt = jSONObject.optInt(Constants.KEYS.RET);
                    if (optInt != 0) {
                        str2 = jSONObject.optString("msg");
                    }
                    i3 = optInt;
                } catch (JSONException e2) {
                    str2 = e2.toString();
                }
            }
            this.f59958a.a(i3, str2);
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final BaiduPayDelegate f59959a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2126409646, "Lcom/baidu/wallet/api/BaiduPayDelegate$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2126409646, "Lcom/baidu/wallet/api/BaiduPayDelegate$b;");
                    return;
                }
            }
            f59959a = new BaiduPayDelegate();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1128512276, "Lcom/baidu/wallet/api/BaiduPayDelegate;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1128512276, "Lcom/baidu/wallet/api/BaiduPayDelegate;");
                return;
            }
        }
        f59862c = f59861b + ".getPayMethod";
        f59863d = f59861b + ".getSecurityCenter";
        f59864e = "wallet_interface_unlogindata";
    }

    public static BaiduPayDelegate getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? b.f59959a : (BaiduPayDelegate) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void accessWalletEntry(Context context, String str) {
        WalletInterfaceResponse.WalletModuleData walletModuleData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) || context == null || TextUtils.isEmpty(str)) {
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
        StatisticManager.onEventWithValues("accessWalletEntryEvent", a(walletModuleData));
        int i2 = walletModuleData.type;
        if (i2 == 1) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_start").data("url", walletModuleData.link_addr).data("title", null).data("with_anim", Boolean.valueOf(walletModuleData.needAnim())).data("show_share", Boolean.TRUE), new RouterCallback(this) { // from class: com.baidu.wallet.api.BaiduPayDelegate.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f59873a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59873a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i3, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, hashMap) == null) {
                    }
                }
            });
        } else if (i2 == 2) {
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().startPage(walletModuleData.link_addr);
        } else if (i2 == 3) {
            BaiduWalletServiceController.getInstance().gotoWalletService(context, walletModuleData.link_addr, "", walletModuleData.needAnim());
        }
    }

    public String assembleResult(Map<String, Object> map, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, z)) == null) {
            if (map == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", z ? 0 : 1);
                jSONObject.put(BeanConstants.DXM_OCR_KEY_CNT, new JSONObject(map));
            } catch (JSONException e2) {
                LogUtil.e(f59861b, "error", e2);
            }
            return jSONObject.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public void cashierEnterSensor(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        String orderNo = StatHelper.getOrderNo(str2);
        StatHelper.cacheOrderNo(orderNo);
        String spNo = StatHelper.getSpNo(str2);
        StatHelper.cacheSpNo(spNo);
        double fen2YuanBigDecimal = TextUtils.isEmpty(StatHelper.getPayAmount(str2)) ? 0.0d : StatHelper.fen2YuanBigDecimal(StatHelper.getPayAmount(str2));
        StatHelper.cachePayAmount(fen2YuanBigDecimal);
        List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), new String[0]);
        HashMap hashMap = new HashMap();
        hashMap.put("sp_no", spNo);
        hashMap.put("pay_amount", Double.valueOf(fen2YuanBigDecimal));
        if (PayStatServiceEvent.PERCASHIER_PAY_ENTER.equals(str)) {
            StatHelper.setPrecashierMark(orderNo);
        } else if (PayStatServiceEvent.STD_PAY_ENTER.equals(str) && StatHelper.isPrecashierPay(orderNo)) {
            hashMap.put(StatHelper.PAY_CATEGORY, "1");
            StatHelper.setDowngrade(true);
        }
        hashMap.put("pay_from", StatHelper.getPayFrom());
        if (!TextUtils.isEmpty(StatHelper.getSignPay())) {
            hashMap.put(StatHelper.SIGN_PAY, StatHelper.getSignPay());
        }
        StatisticManager.onEventWithValues(str, collectData, hashMap);
    }

    public void changePayMethod(Activity activity, Map map, IModifyPayTypeCallback iModifyPayTypeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, activity, map, iModifyPayTypeCallback) == null) {
            if (c()) {
                StatisticManager.onEvent(PayStatServiceEvent.FAST_DOUBLE_CLICK_CHANGE_PAY_METHOD);
                return;
            }
            StatisticManager.onEvent("changePayMethod");
            PayController.getInstance().setModifyPayTypeCallback(iModifyPayTypeCallback);
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(activity, new ILoginBackListener(this, activity, map) { // from class: com.baidu.wallet.api.BaiduPayDelegate.21
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Activity f59925a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Map f59926b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f59927c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activity, map};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59927c = this;
                    this.f59925a = activity;
                    this.f59926b = map;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        PrecashierModifyPayTypeManager.getInstance().getModifyPayType(this.f59925a, this.f59926b);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        PrecashierModifyPayTypeManager.getInstance().getModifyPayType(this.f59925a, this.f59926b);
                    }
                }
            }));
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void checkPwd(Context context, CheckCallBack checkCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, checkCallBack) == null) {
            this.f59867g = new LoginBackListenerProxy(context, new ILoginBackListener(this, checkCallBack) { // from class: com.baidu.wallet.api.BaiduPayDelegate.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CheckCallBack f59951a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f59952b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, checkCallBack};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59952b = this;
                    this.f59951a = checkCallBack;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (i2 == 603) {
                            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f59952b.f59867g);
                            return;
                        }
                        CheckCallBack checkCallBack2 = this.f59951a;
                        if (checkCallBack2 != null) {
                            checkCallBack2.onCheckResult(2, "cancle");
                            this.f59952b.f59867g = null;
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f59952b.f59867g.getContext() == null) {
                        return;
                    }
                    BaiduPay.getInstance().checkPwd(this.f59952b.f59867g.getContext(), this.f59951a);
                }
            });
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f59867g);
        }
    }

    public void checkPwdFromH5(Context context, String str, CheckCallBack checkCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, context, str, checkCallBack) == null) {
            this.f59867g = new LoginBackListenerProxy(context, new ILoginBackListener(this, str, checkCallBack) { // from class: com.baidu.wallet.api.BaiduPayDelegate.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f59953a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ CheckCallBack f59954b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f59955c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, checkCallBack};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59955c = this;
                    this.f59953a = str;
                    this.f59954b = checkCallBack;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        if (i2 == 603) {
                            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f59955c.f59867g);
                            return;
                        }
                        CheckCallBack checkCallBack2 = this.f59954b;
                        if (checkCallBack2 != null) {
                            checkCallBack2.onCheckResult(2, QueryResponse.Options.CANCEL);
                            this.f59955c.f59867g = null;
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) || this.f59955c.f59867g.getContext() == null) {
                        return;
                    }
                    BaiduPay.getInstance().checkPwdFromH5(this.f59955c.f59867g.getContext(), this.f59953a, this.f59954b);
                }
            });
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f59867g);
        }
    }

    public void closeFingerprintPay(Activity activity, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, activity, cVar) == null) {
            IFingerprintPay fingerprintPay = WalletFingerprint.getInstance(activity).getFingerprintPay(WalletFingerprint.FpType.SYSTEM_FINGERPRINT);
            if (fingerprintPay != null) {
                fingerprintPay.close(activity, new FingerprintCallback(this, cVar, fingerprintPay) { // from class: com.baidu.wallet.api.BaiduPayDelegate.24
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BaiduPayDelegate this$0;
                    public final /* synthetic */ IFingerprintPay val$fingerprintPay;
                    public final /* synthetic */ c val$fingerprintPayResult;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, cVar, fingerprintPay};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$fingerprintPayResult = cVar;
                        this.val$fingerprintPay = fingerprintPay;
                    }

                    @Override // com.baidu.wallet.paysdk.fingerprint.FingerprintCallback
                    public void onAuthorizeResult(IFingerprintPay.Action action, int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, action, i2, str) == null) {
                            if (i2 == 0) {
                                StatisticManager.onEvent("fp_paysetting_close_success");
                                this.this$0.d();
                                this.val$fingerprintPayResult.a(2200, str);
                            } else {
                                StatisticManager.onEvent("fp_paysetting_close_failed");
                                this.val$fingerprintPayResult.a(2201, str);
                            }
                            this.val$fingerprintPay.destory();
                        }
                    }
                });
            } else {
                cVar.a(2112, "手机不支持指纹支付");
            }
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doBind(Context context, BindBack bindBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, bindBack, map) == null) {
            if (context != null && map != null) {
                doInnerBind(context, bindBack, map, "");
                return;
            }
            StatisticManager.onEvent("#onBindResult");
            bindBack.onBindResult(-10, null);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doBindCardIndependent(Context context, BindBack bindBack, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, context, bindBack, str) == null) {
            if (context == null) {
                if (bindBack != null) {
                    bindBack.onBindResult(2, null);
                    return;
                }
                return;
            }
            BaiduPay.getInstance().setBindCardbackExt(bindBack);
            Intent intent = new Intent();
            intent.setClass(context, BindCardPreCheckActivity.class);
            intent.putExtra(BindCardPreCheckActivity.PARAMS_KEY, str);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            this.f59867g = new LoginBackListenerProxy(context, new ILoginBackListener(this, bindBack, intent, context, str) { // from class: com.baidu.wallet.api.BaiduPayDelegate.25
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BindBack f59931a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Intent f59932b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Context f59933c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f59934d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f59935e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bindBack, intent, context, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59935e = this;
                    this.f59931a = bindBack;
                    this.f59932b = intent;
                    this.f59933c = context;
                    this.f59934d = str;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        if (i2 == 603) {
                            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f59935e.f59867g);
                            return;
                        }
                        this.f59931a.onBindResult(2, "");
                        BaiduPay.getInstance().clearBindCallbackExt();
                        this.f59935e.f59867g = null;
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        BaiduPay.getInstance().bindCardOnCardaddReturn(this.f59935e.f59867g.getContext(), new BindCardEntry.OnReturn(this) { // from class: com.baidu.wallet.api.BaiduPayDelegate.25.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass25 f59936a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f59936a = this;
                            }

                            @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
                            public void onFailed(int i3, String str3) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i3, str3) == null) {
                                }
                            }

                            @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
                            public void onResponse(CardAddResponse cardAddResponse) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cardAddResponse) == null) {
                                    Activity loadingUi = BindCardEntry.getLoadingUi();
                                    if (loadingUi instanceof BaseActivity) {
                                        ((BaseActivity) loadingUi).startActivity(this.f59936a.f59932b);
                                        return;
                                    }
                                    AnonymousClass25 anonymousClass25 = this.f59936a;
                                    anonymousClass25.f59933c.startActivity(anonymousClass25.f59932b);
                                }
                            }
                        }, PayRequestCache.BindCategory.Initiative, 1, null, this.f59934d);
                    }
                }
            });
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f59867g);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doCheckPwd(Context context, Map<String, String> map, CheckCallBack checkCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, context, map, checkCallBack) == null) {
            this.f59867g = new LoginBackListenerProxy(context, new ILoginBackListener(this, map, checkCallBack) { // from class: com.baidu.wallet.api.BaiduPayDelegate.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Map f59948a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ CheckCallBack f59949b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f59950c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, map, checkCallBack};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59950c = this;
                    this.f59948a = map;
                    this.f59949b = checkCallBack;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (i2 == 603) {
                            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f59950c.f59867g);
                            return;
                        }
                        CheckCallBack checkCallBack2 = this.f59949b;
                        if (checkCallBack2 != null) {
                            checkCallBack2.onCheckResult(2, "");
                            this.f59950c.f59867g = null;
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f59950c.f59867g.getContext() == null) {
                        return;
                    }
                    BaiduPay.getInstance().doCheckPwd(this.f59950c.f59867g.getContext(), this.f59948a, this.f59949b);
                }
            });
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f59867g);
        }
    }

    public void doInnerBind(Context context, BindBack bindBack, Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, context, bindBack, map, str) == null) {
            this.f59867g = null;
            this.f59867g = new LoginBackListenerProxy(context, new ILoginBackListener(this, context, bindBack, map, str) { // from class: com.baidu.wallet.api.BaiduPayDelegate.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f59894a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BindBack f59895b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Map f59896c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f59897d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f59898e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, bindBack, map, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59898e = this;
                    this.f59894a = context;
                    this.f59895b = bindBack;
                    this.f59896c = map;
                    this.f59897d = str;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        if (i2 == 603) {
                            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f59898e.f59867g);
                        } else if (this.f59895b != null) {
                            StatisticManager.onEvent("#onBindResult");
                            this.f59895b.onBindResult(-5, null);
                            this.f59898e.f59867g = null;
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) || this.f59898e.f59867g.getContext() == null) {
                        return;
                    }
                    BaiduPay.getInstance().doBindCardExt(this.f59894a, this.f59895b, this.f59896c, this.f59897d);
                }
            });
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f59867g);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doPay(Context context, String str, PayCallBack payCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, context, str, payCallBack) == null) {
            doPay(context, str, payCallBack, new HashMap());
        }
    }

    public void doPayRNAuth(Context context, String str, RNAuthCallBack rNAuthCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, context, str, rNAuthCallBack) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_RNAUTH_ENTER, StatHelper.getOrderNo());
        this.f59867g = new LoginBackListenerProxy(context, new ILoginBackListener(this, str, rNAuthCallBack) { // from class: com.baidu.wallet.api.BaiduPayDelegate.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f59937a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RNAuthCallBack f59938b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BaiduPayDelegate f59939c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str, rNAuthCallBack};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59939c = this;
                this.f59937a = str;
                this.f59938b = rNAuthCallBack;
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i2, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                    if (i2 == 603) {
                        com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f59939c.f59867g);
                        return;
                    }
                    RNAuthCallBack rNAuthCallBack2 = this.f59938b;
                    if (rNAuthCallBack2 != null) {
                        rNAuthCallBack2.onRNAuthResult(-5, null);
                        this.f59939c.f59867g = null;
                    }
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i2, String str2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) || this.f59939c.f59867g.getContext() == null) {
                    return;
                }
                BaiduPay.getInstance().doPayRNAuth(this.f59939c.f59867g.getContext(), this.f59937a, this.f59938b);
            }
        });
        com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f59867g);
    }

    public void doPrecashierPay(Context context, String str, PayCallBack payCallBack, Map<String, String> map, PrecashierCreateOrderResponse precashierCreateOrderResponse, IModifyPayTypeCallback iModifyPayTypeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, str, payCallBack, map, precashierCreateOrderResponse, iModifyPayTypeCallback}) == null) {
            if (!"2".equals(StatHelper.getPayFrom())) {
                StatHelper.clearSensor();
            }
            StatisticManager.onEvent("doPreCashierPay");
            if (iModifyPayTypeCallback == null) {
                iModifyPayTypeCallback = new IModifyPayTypeCallback(this, context, str, payCallBack, map) { // from class: com.baidu.wallet.api.BaiduPayDelegate.19
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Context f59911a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f59912b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ PayCallBack f59913c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ Map f59914d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ BaiduPayDelegate f59915e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str, payCallBack, map};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f59915e = this;
                        this.f59911a = context;
                        this.f59912b = str;
                        this.f59913c = payCallBack;
                        this.f59914d = map;
                    }

                    @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                    public void onPayTypeModified(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, precashierModifyPayTypeDefaultData) == null) {
                            PayDataCache.getInstance().resetFromPrecashier();
                            this.f59915e.doPay(this.f59911a, this.f59912b, this.f59913c, this.f59914d);
                        }
                    }

                    @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                    public void onPayTypeModifiedFailed(int i2, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        }
                    }

                    @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                    public void onPayTypeSetted() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
                        }
                    }
                };
            }
            PayController.getInstance().setModifyPayTypeCallback(iModifyPayTypeCallback);
            PayDataCache.getInstance().setIsRemotePay(false);
            PayDataCache.getInstance().setFromPreCashier();
            StatHelper.cachePayFrom("1");
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_DURATION);
            cashierEnterSensor(PayStatServiceEvent.PERCASHIER_PAY_ENTER, str);
            this.f59867g = new LoginBackListenerProxy(context, new ILoginBackListener(this, context, str, payCallBack, map, precashierCreateOrderResponse) { // from class: com.baidu.wallet.api.BaiduPayDelegate.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f59919a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f59920b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ PayCallBack f59921c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ Map f59922d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ PrecashierCreateOrderResponse f59923e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f59924f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str, payCallBack, map, precashierCreateOrderResponse};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59924f = this;
                    this.f59919a = context;
                    this.f59920b = str;
                    this.f59921c = payCallBack;
                    this.f59922d = map;
                    this.f59923e = precashierCreateOrderResponse;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) && i2 == 603) {
                        com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f59924f.f59867g);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        BaiduPay.getInstance().doPrecashierPay(this.f59919a, this.f59920b, this.f59921c, this.f59922d, this.f59923e);
                    }
                }
            });
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f59867g);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doRNAuth(Context context, Map<String, String> map, RNAuthCallBack rNAuthCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048592, this, context, map, rNAuthCallBack) == null) || context == null || map == null) {
            return;
        }
        this.f59867g = new LoginBackListenerProxy(context, new ILoginBackListener(this, map, rNAuthCallBack) { // from class: com.baidu.wallet.api.BaiduPayDelegate.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Map f59916a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RNAuthCallBack f59917b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BaiduPayDelegate f59918c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, map, rNAuthCallBack};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59918c = this;
                this.f59916a = map;
                this.f59917b = rNAuthCallBack;
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    if (i2 == 603) {
                        com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f59918c.f59867g);
                        return;
                    }
                    RNAuthCallBack rNAuthCallBack2 = this.f59917b;
                    if (rNAuthCallBack2 != null) {
                        rNAuthCallBack2.onRNAuthResult(-5, null);
                        this.f59918c.f59867g = null;
                    }
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f59918c.f59867g.getContext() == null) {
                    return;
                }
                BaiduPay.getInstance().doRNAuth(this.f59918c.f59867g.getContext(), this.f59916a, this.f59917b);
            }
        });
        com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f59867g);
    }

    public void doRemotePay(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048593, this, context, str, payCallBack, map) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.f59865a) {
            StatHelper.clearSensor();
        }
        this.f59865a = false;
        StatHelper.cachePayFrom("3");
        StatisticManager.onEventStart(PayStatServiceEvent.PAY_DURATION);
        ArrayList<String> a2 = a(str, map, context);
        StatisticManager.onEventWithValues(PayStatServiceEvent.RMT_PAY_ACCEPT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), StatHelper.getFromPkg()));
        cashierEnterSensor(PayStatServiceEvent.STD_PAY_ENTER, str);
        StatisticManager.onEventWithValues("schemePayEnter", a2);
        if (com.dxmpay.wallet.api.WalletLoginHelper.getInstance().isLogin() && map == null) {
            map = new HashMap<>();
        }
        PayDataCache.getInstance().setIsRemotePay(true);
        PayDataCache.getInstance().resetFromPrecashier();
        a(context, str, payCallBack, map);
    }

    public void getBiometricsStatus(Context context, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, context, cVar) == null) {
            boolean isDevicesSupport = WalletFingerprint.getInstance(context).isDevicesSupport();
            boolean hasEnrollFingerprint = WalletFingerprint.getInstance(context).hasEnrollFingerprint();
            boolean hasOTPToken = WalletFingerprint.getInstance(context).hasOTPToken();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ifDeviceSupport", isDevicesSupport ? 1 : 0);
                jSONObject.put("ifBiometricsAvailable", hasEnrollFingerprint ? 1 : 0);
                jSONObject.put("ifBiometricPayInfoExist", hasOTPToken ? 1 : 0);
                jSONObject.put("ifDeviceSupportFaceID", 0);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            cVar.a(0, jSONObject.toString());
        }
    }

    public void getPayMethod(Context context, String str, IDefaultPayMethodCallback iDefaultPayMethodCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048596, this, context, str, iDefaultPayMethodCallback) == null) {
            if (c()) {
                StatisticManager.onEvent(PayStatServiceEvent.FAST_DOUBLE_CLICK_GET_PAY_METHOD);
                return;
            }
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(context, new ILoginBackListener(this, context, str, iDefaultPayMethodCallback) { // from class: com.baidu.wallet.api.BaiduPayDelegate.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f59940a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f59941b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ IDefaultPayMethodCallback f59942c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f59943d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str, iDefaultPayMethodCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59943d = this;
                    this.f59940a = context;
                    this.f59941b = str;
                    this.f59942c = iDefaultPayMethodCallback;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        this.f59943d.a(this.f59940a, this.f59941b, this.f59942c);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        this.f59943d.a(this.f59940a, this.f59941b, this.f59942c);
                    }
                }
            }));
        }
    }

    public void getSecurityCenterOrPaySettingData(String str, Context context, com.baidu.wallet.paysdk.securitycenter.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, str, context, aVar) == null) {
            if (!EnterWalletDxmPayServiceAction.GET_SECURITY_CENTER_DATA.equals(str) && !EnterWalletDxmPayServiceAction.GET_PAY_SETTING_DATA.equals(str)) {
                aVar.a(10004, "功能未实现");
                return;
            }
            this.f59867g = new LoginBackListenerProxy(context, new ILoginBackListener(this, str, context, aVar) { // from class: com.baidu.wallet.api.BaiduPayDelegate.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f59899a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f59900b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ com.baidu.wallet.paysdk.securitycenter.a f59901c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f59902d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, context, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59902d = this;
                    this.f59899a = str;
                    this.f59900b = context;
                    this.f59901c = aVar;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        if (i2 == 603) {
                            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f59902d.f59867g);
                            return;
                        }
                        com.baidu.wallet.paysdk.securitycenter.a aVar2 = this.f59901c;
                        if (aVar2 != null) {
                            aVar2.a(-5, "未登录");
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        this.f59902d.a(this.f59899a, this.f59900b, this.f59901c);
                    }
                }
            });
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f59867g);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public String getWalletOuterInterface(Context context, IWalletOuterInterfaceListener iWalletOuterInterfaceListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, context, iWalletOuterInterfaceListener)) == null) {
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().verifyPassLogin(false, new LoginBackListenerProxy(context, new ILoginBackListener(this, context, iWalletOuterInterfaceListener) { // from class: com.baidu.wallet.api.BaiduPayDelegate.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f59874a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ IWalletOuterInterfaceListener f59875b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f59876c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, iWalletOuterInterfaceListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59876c = this;
                    this.f59874a = context;
                    this.f59875b = iWalletOuterInterfaceListener;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f59876c.a(this.f59874a, this.f59875b);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        this.f59876c.a(this.f59874a, this.f59875b);
                    }
                }
            }));
            String newPpKey = PayPreferenceManager.getNewPpKey(context);
            if (TextUtils.isEmpty(newPpKey)) {
                newPpKey = PayPreferenceManager.getPpKey(context);
            }
            String walletInterfaceData = PayPreferenceManager.getWalletInterfaceData(context, newPpKey, "");
            if ((com.dxmpay.wallet.api.WalletLoginHelper.getInstance().isPassLogin() || com.dxmpay.wallet.api.WalletLoginHelper.getInstance().isLogin()) && !TextUtils.isEmpty(walletInterfaceData)) {
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
            String walletInterfaceData2 = PayPreferenceManager.getWalletInterfaceData(context, f59864e, "");
            return !TextUtils.isEmpty(walletInterfaceData2) ? walletInterfaceData2 : "";
        }
        return (String) invokeLL.objValue;
    }

    public void openFingerprintPay(Activity activity, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, activity, cVar) == null) || activity == null || cVar == null) {
            return;
        }
        IFingerprintPay fingerprintPay = WalletFingerprint.getInstance(activity).getFingerprintPay();
        if (fingerprintPay == null) {
            cVar.a(2112, "手机不支持指纹支付");
        } else if (!WalletFingerprint.getInstance(activity).hasEnrollFingerprint()) {
            cVar.a(2111, "手机没有录入指纹");
        } else {
            PayDataCache.getInstance().setPaySettingOpenFingerprintPay(true);
            fingerprintPay.open(activity, new FingerprintCallback(this, cVar, activity, fingerprintPay) { // from class: com.baidu.wallet.api.BaiduPayDelegate.23
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaiduPayDelegate this$0;
                public final /* synthetic */ Activity val$context;
                public final /* synthetic */ IFingerprintPay val$fingerprintPay;
                public final /* synthetic */ c val$fingerprintPayResult;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cVar, activity, fingerprintPay};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$fingerprintPayResult = cVar;
                    this.val$context = activity;
                    this.val$fingerprintPay = fingerprintPay;
                }

                @Override // com.baidu.wallet.paysdk.fingerprint.FingerprintCallback
                public void onAuthorizeResult(IFingerprintPay.Action action, int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, action, i2, str) == null) {
                        if (i2 == 0) {
                            StatisticManager.onEvent("fp_paysetting_open_success");
                            this.this$0.d();
                            this.val$fingerprintPayResult.a(2100, "开通成功");
                        } else if (i2 == 1) {
                            StatisticManager.onEvent("fp_paysetting_open_cancle");
                            this.val$fingerprintPayResult.a(2102, str);
                        } else if (i2 == 2) {
                            StatisticManager.onEvent("fp_paysetting_open_failed");
                            if (TextUtils.isEmpty(str)) {
                                str = ResUtils.getString(this.val$context, "wallet_fp_try_too_many_times_try_later");
                            }
                            this.val$fingerprintPayResult.a(2102, str);
                        } else {
                            this.val$fingerprintPayResult.a(2102, str);
                        }
                        this.val$fingerprintPay.destory();
                    }
                }
            }, true);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void preOrderPay(Context context, String str, IPrecashierCallback iPrecashierCallback) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048600, this, context, str, iPrecashierCallback) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("orderInfo") && jSONObject2.get("orderInfo") != null) {
                String str2 = (String) jSONObject2.get("orderInfo");
                String jsonToURLParams = (!jSONObject2.has("orderInfoExtra") || (jSONObject = jSONObject2.getJSONObject("orderInfoExtra")) == null) ? "" : JsonUtil.jsonToURLParams(jSONObject, true);
                PayCallBack payCallBack = new PayCallBack(this, iPrecashierCallback) { // from class: com.baidu.wallet.api.BaiduPayDelegate.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ IPrecashierCallback f59877a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BaiduPayDelegate f59878b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iPrecashierCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f59878b = this;
                        this.f59877a = iPrecashierCallback;
                    }

                    @Override // com.baidu.android.pay.PayCallBack
                    public boolean isHideLoadingDialog() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            return false;
                        }
                        return invokeV.booleanValue;
                    }

                    @Override // com.baidu.android.pay.PayCallBack
                    public void onPayResult(int i2, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str3) == null) {
                            if (i2 != 0 && i2 != 1) {
                                StatHelper.statServiceEvent(PayStatServiceEvent.PERCASHIER_PAY);
                                StatHelper.statServiceEvent(PayStatServiceEvent.PERCASHIER_PAY_FAILED);
                                this.f59877a.onResult(this.f59878b.a(String.valueOf(i2), str3));
                                return;
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("data", Base64Utils.encodeToString(str3.getBytes()));
                            this.f59877a.onResult(this.f59878b.assembleResult(hashMap, true));
                        }
                    }
                };
                getInstance().preOrderPay(context, str2, jsonToURLParams, payCallBack, new IModifyPayTypeCallback(this, payCallBack) { // from class: com.baidu.wallet.api.BaiduPayDelegate.17
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayCallBack f59903a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BaiduPayDelegate f59904b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, payCallBack};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f59904b = this;
                        this.f59903a = payCallBack;
                    }

                    @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                    public void onPayTypeModified(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, precashierModifyPayTypeDefaultData) == null) {
                            this.f59903a.onPayResult(10000, "默认支付方式变更");
                        }
                    }

                    @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                    public void onPayTypeModifiedFailed(int i2, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str3) == null) {
                        }
                    }

                    @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                    public void onPayTypeSetted() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
                        }
                    }
                });
                return;
            }
            throw new InvalidParameterException(EnterDxmPayServiceAction.ERR_MSG);
        } catch (Exception e2) {
            e2.printStackTrace();
            String a2 = a(LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage());
            if (iPrecashierCallback != null) {
                iPrecashierCallback.onResult(a2);
            }
        }
    }

    public void reOrderPay(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, context) == null) {
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(com.baidu.wallet.paysdk.beans.BeanConstants.REQUEST_ID_PAY);
            String str = payRequest != null ? payRequest.mParams : "";
            String payFrom = payRequest != null ? payRequest.getPayFrom() : "";
            PayCallBack payBack = BaiduPay.getInstance().getPayBack();
            PayRequestCache.getInstance().clearPaySdkRequestCache();
            PayBaseBeanActivity.exitEbpay();
            this.f59865a = true;
            String str2 = "orderinfo=" + str + " ==============callback=" + payBack;
            HashMap hashMap = new HashMap();
            hashMap.put("pay_from", payFrom);
            StatisticManager.onEventWithValue(StatServiceEvent.EVENT_PAY_TYPE_SETTED_REORDE, str);
            if (PayDataCache.getInstance().isRemotePay()) {
                StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_REORDER);
                if (payRequest != null) {
                    hashMap.put("key_remote_app_name", payRequest.mRemotePayHostName);
                    hashMap.put("key_remote_pkg_name", payRequest.mRemotePkg);
                    hashMap.put("key_remote_where_to_back", payRequest.mRemoteWhereToBackAct);
                }
                getInstance().doRemotePay(context, str, payBack, hashMap);
            } else if (PayDataCache.getInstance().isFromPreCashier()) {
                if (BaiduPay.PAY_FROM_HUA_ZHUAN_ZHANG.equals(payFrom)) {
                    return;
                }
                StatHelper.statServiceEvent(PayStatServiceEvent.PERCASHIER_PAY_REORDER);
                BaiduPay.getInstance().preOrderPay(context, str, PayDataCache.getInstance().getOrderExtraInfo(), payBack, hashMap);
            } else {
                StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_REORDER);
                getInstance().doPay(context, str, payBack, hashMap);
            }
        }
    }

    public BaiduPayDelegate() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f59865a = false;
        this.f59868h = null;
    }

    private IRemoteServiceCallback b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) ? new IRemoteServiceCallback.Stub(this) { // from class: com.baidu.wallet.api.BaiduPayDelegate.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaiduPayDelegate this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.wallet.remotepay.IRemoteServiceCallback
            public boolean isHideLoadingDialog() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.wallet.remotepay.IRemoteServiceCallback
            public void onPayEnd(int i2, String str) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(this, i2, str) { // from class: com.baidu.wallet.api.BaiduPayDelegate.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f59870a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f59871b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f59872c;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i2), str};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f59872c = this;
                            this.f59870a = i2;
                            this.f59871b = str;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f59872c.this$0.f59868h == null) {
                                return;
                            }
                            this.f59872c.this$0.f59868h.onPayResult(this.f59870a, this.f59871b);
                            this.f59872c.this$0.f59868h = null;
                        }
                    });
                }
            }

            @Override // com.baidu.wallet.remotepay.IRemoteServiceCallback
            public void startActivity(String str, String str2, int i2, Bundle bundle) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLIL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, str, str2, i2, bundle) == null) {
                }
            }
        } : (IRemoteServiceCallback) invokeV.objValue;
    }

    private void c(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65563, this, context, str, payCallBack, map) == null) {
            if (PayDataCache.getInstance().isRemotePay()) {
                String orderNo = StatHelper.getOrderNo();
                String[] strArr = new String[3];
                strArr[0] = StatHelper.getSpNo();
                strArr[1] = StatHelper.getFromPkg();
                strArr[2] = com.dxmpay.wallet.api.WalletLoginHelper.getInstance().isPassLogin() ? "1" : "0";
                StatisticManager.onEventWithValues(PayStatServiceEvent.RMT_LOGIN_ENTER, StatHelper.collectData(orderNo, strArr));
            } else {
                String[] strArr2 = new String[1];
                strArr2[0] = com.dxmpay.wallet.api.WalletLoginHelper.getInstance().isPassLogin() ? "1" : "0";
                StatHelper.payLoginSeneor(PayStatServiceEvent.LCL_LOGIN_ENTER, strArr2);
            }
            StatHelper.cachePassLoginStatus(com.dxmpay.wallet.api.WalletLoginHelper.getInstance().isPassLogin() ? "1" : "0");
            this.f59866f = new HandlePassLoginResult(this, context, false, new ILoginBackListener(this, payCallBack, context, map, str) { // from class: com.baidu.wallet.api.BaiduPayDelegate.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayCallBack f59889a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f59890b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Map f59891c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f59892d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f59893e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, payCallBack, context, map, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59893e = this;
                    this.f59889a = payCallBack;
                    this.f59890b = context;
                    this.f59891c = map;
                    this.f59892d = str;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        if (i2 == 603) {
                            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f59893e.f59866f);
                            return;
                        }
                        List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), new String[0]);
                        HashMap hashMap = new HashMap();
                        hashMap.put("sp_no", StatHelper.getSpNo());
                        hashMap.put("pay_amount", StatHelper.getPayAmount());
                        StatisticManager.onEventWithValues(PayStatServiceEvent.STD_PAY_NOT_LOGIN, collectData, hashMap);
                        if (StatHelper.getPassLoginStatus().equals("1")) {
                            if (PayDataCache.getInstance().isRemotePay()) {
                                StatisticManager.onEventWithValues(PayStatServiceEvent.RMT_OPENBDUSS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), StatHelper.getFromPkg(), "0"));
                            } else {
                                StatHelper.payLoginSeneor(PayStatServiceEvent.LCL_OPENBDUSS_RESULT, "0");
                            }
                        }
                        if (this.f59889a != null) {
                            PayDataCache.getInstance().isRemotePay();
                            this.f59889a.onPayResult(2, "");
                            if (PayDataCache.getInstance().isRemotePay()) {
                                try {
                                    this.f59893e.a(this.f59890b, this.f59891c);
                                } catch (ActivityNotFoundException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            this.f59893e.f59866f = null;
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        if (PayDataCache.getInstance().isRemotePay()) {
                            StatisticManager.onEventWithValues(PayStatServiceEvent.RMT_OPENBDUSS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), StatHelper.getFromPkg(), "1"));
                        } else {
                            StatHelper.payLoginSeneor(PayStatServiceEvent.LCL_OPENBDUSS_RESULT, "1");
                        }
                        if (this.f59893e.f59866f.getContext() != null) {
                            BaiduPayDelegate baiduPayDelegate = this.f59893e;
                            baiduPayDelegate.b(baiduPayDelegate.f59866f.getContext(), this.f59892d, this.f59889a, this.f59891c);
                            return;
                        }
                        StatHelper.cacheBankCode("-1");
                        StatHelper.cacheCardType("-1");
                        StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_CANCEL);
                        PayCallBack payCallBack2 = this.f59889a;
                        if (payCallBack2 != null) {
                            payCallBack2.onPayResult(2, "");
                        }
                    }
                }
            });
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f59866f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65565, this) == null) && PayRequestCache.getInstance().isPaying()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pay_sort_change", 1);
                EventBus eventBus = EventBus.getInstance();
                eventBus.getClass();
                EventBus.getInstance().post(new EventBus.Event(eventBus, com.baidu.wallet.paysdk.beans.BeanConstants.EVENT_PAY_SORT_SETTING, jSONObject.toString()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doPay(Context context, String str, PayCallBack payCallBack, @NonNull Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048589, this, context, str, payCallBack, map) == null) {
            if (!"2".equals(StatHelper.getPayFrom())) {
                if (!this.f59865a) {
                    StatHelper.clearSensor();
                }
                this.f59865a = false;
                String pureSign = StatHelper.getPureSign(str);
                if (TextUtils.isEmpty(pureSign)) {
                    StatHelper.cachePayFrom("0");
                } else {
                    StatHelper.cachePayFrom("4");
                    StatHelper.cacheSignPay("0".equals(pureSign) ? "1" : "2");
                }
            }
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_DURATION);
            cashierEnterSensor(PayStatServiceEvent.STD_PAY_ENTER, str);
            if (c()) {
                StatisticManager.onEvent(PayStatServiceEvent.FAST_DOUBLE_CLICK_DO_PAY);
                StatHelper.cacheBankCode("-1");
                StatHelper.cacheCardType("-1");
                StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_FAILED);
            } else if (BeanConstants.CHANNEL_ID.equals(com.baidu.wallet.paysdk.beans.BeanConstants.CHANNEL_ID_CHE_LIAN_WANG)) {
                this.f59868h = payCallBack;
                Intent intent = new Intent();
                intent.setClassName(context.getPackageName(), "com.baidu.wallet.remotepay.RemotePayEnterActivity");
                intent.putExtra("caller", a(str, (Map<String, String>) null, map));
                intent.putExtra("service", false);
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                context.startActivity(intent);
            } else {
                PayDataCache.getInstance().setIsRemotePay(false);
                PayDataCache.getInstance().resetFromPrecashier();
                a(context, str, payCallBack, map);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65561, this, context, str, payCallBack, map) == null) {
            if (PayDataCache.getInstance().isRemotePay()) {
                String[] strArr = new String[3];
                strArr[0] = com.dxmpay.wallet.api.BaiduWalletDelegate.getInstance().getAppContext().getPackageName();
                strArr[1] = (map == null || map.isEmpty()) ? "" : map.get("key_remote_pkg_name");
                strArr[2] = "doRemotePay";
                StatisticManager.onEventWithValues("doRemotePay", RealTimeEventHelper.genEventValue(str, strArr));
                BaiduPay.getInstance().doRemotePay(context, str, payCallBack, map);
                return;
            }
            BaiduPay.getInstance().doPay(context, str, payCallBack, map);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void getPayMethod(Context context, String str, @NonNull IPrecashierCallback iPrecashierCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, context, str, iPrecashierCallback) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("requestInfo") && jSONObject.get("requestInfo") != null) {
                    getInstance().getPayMethod(context, jSONObject.getString("requestInfo"), new IDefaultPayMethodCallback(this, iPrecashierCallback) { // from class: com.baidu.wallet.api.BaiduPayDelegate.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ IPrecashierCallback f59946a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ BaiduPayDelegate f59947b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iPrecashierCallback};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f59947b = this;
                            this.f59946a = iPrecashierCallback;
                        }

                        @Override // com.baidu.wallet.paysdk.precashier.IDefaultPayMethodCallback
                        public void onReceived(int i2, String str2) {
                            String a2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                                if (i2 == 0) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("data", Base64Utils.encodeToString(str2.getBytes()));
                                    a2 = this.f59947b.assembleResult(hashMap, true);
                                } else {
                                    a2 = this.f59947b.a(String.valueOf(i2), str2);
                                }
                                this.f59946a.onResult(a2);
                            }
                        }
                    });
                    return;
                }
                throw new InvalidParameterException(EnterDxmPayServiceAction.ERR_MSG);
            } catch (Exception e2) {
                e2.printStackTrace();
                String a2 = a(LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage());
                if (iPrecashierCallback != null) {
                    iPrecashierCallback.onResult(a2);
                }
            }
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void changePayMethod(Activity activity, String str, IPrecashierCallback iPrecashierCallback) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, str, iPrecashierCallback) == null) {
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
                    getInstance().changePayMethod(activity, hashMap, new IModifyPayTypeCallback(this, hashMap.containsKey("version") ? (String) hashMap.get("version") : "0", iPrecashierCallback) { // from class: com.baidu.wallet.api.BaiduPayDelegate.22
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f59928a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ IPrecashierCallback f59929b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ BaiduPayDelegate f59930c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r7, iPrecashierCallback};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f59930c = this;
                            this.f59928a = r7;
                            this.f59929b = iPrecashierCallback;
                        }

                        @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                        public void onPayTypeModified(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
                            String localizedMessage;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, precashierModifyPayTypeDefaultData) == null) {
                                HashMap hashMap2 = new HashMap();
                                if ("1".equals(this.f59928a)) {
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
                                this.f59929b.onResult(this.f59930c.assembleResult(hashMap2, true));
                            }
                        }

                        @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                        public void onPayTypeModifiedFailed(int i2, String str2) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) || this.f59929b == null) {
                                return;
                            }
                            BaiduPayDelegate baiduPayDelegate = this.f59930c;
                            this.f59929b.onResult(baiduPayDelegate.a(i2 + "", str2));
                        }

                        @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                        public void onPayTypeSetted() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
                            }
                        }
                    });
                    return;
                }
                throw new InvalidParameterException(EnterDxmPayServiceAction.ERR_MSG);
            } catch (Exception e2) {
                iPrecashierCallback.onResult(a(LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage()));
            }
        }
    }

    private Bundle a(String str, Map<String, String> map, Map<String, String> map2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, str, map, map2)) == null) {
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
        return (Bundle) invokeLLL.objValue;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - this.f59869i;
            com.dxmpay.apollon.utils.LogUtil.logd("timeD=" + j2);
            if (0 >= j2 || j2 >= 800) {
                this.f59869i = currentTimeMillis;
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void preOrderPay(Context context, String str, String str2, PayCallBack payCallBack, IModifyPayTypeCallback iModifyPayTypeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048601, this, context, str, str2, payCallBack, iModifyPayTypeCallback) == null) {
            StatisticManager.onEvent("preOrderPay");
            if (c()) {
                StatisticManager.onEvent(PayStatServiceEvent.FAST_DOUBLE_CLICK_PRE_ORDER_PAY);
                return;
            }
            StatHelper.clearSensor();
            StatHelper.cachePayFrom("1");
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_DURATION);
            cashierEnterSensor(PayStatServiceEvent.PERCASHIER_PAY_ENTER, str);
            HashMap hashMap = new HashMap();
            hashMap.put("sp_no", StatHelper.getSpNo());
            hashMap.put("pay_amount", StatHelper.getPayAmount());
            PayController.getInstance().setModifyPayTypeCallback(iModifyPayTypeCallback);
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(TextUtils.isEmpty(str2) ? "order_from=pre_cashdesk" : !str2.contains("order_from") ? "&order_from=pre_cashdesk" : "");
            String sb2 = sb.toString();
            PayDataCache.getInstance().setIsRemotePay(false);
            PayDataCache.getInstance().setFromPreCashier();
            String orderNo = StatHelper.getOrderNo();
            String[] strArr = new String[1];
            strArr[0] = com.dxmpay.wallet.api.WalletLoginHelper.getInstance().isPassLogin() ? "1" : "0";
            StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PAY_LOGIN, StatHelper.collectData(orderNo, strArr), hashMap);
            StatHelper.cachePassLoginStatus(com.dxmpay.wallet.api.WalletLoginHelper.getInstance().isPassLogin() ? "1" : "0");
            this.f59866f = new HandlePassLoginResult(this, context, true, new ILoginBackListener(this, hashMap, payCallBack, context, str, sb2) { // from class: com.baidu.wallet.api.BaiduPayDelegate.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Map f59905a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PayCallBack f59906b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Context f59907c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f59908d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f59909e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f59910f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, hashMap, payCallBack, context, str, sb2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59910f = this;
                    this.f59905a = hashMap;
                    this.f59906b = payCallBack;
                    this.f59907c = context;
                    this.f59908d = str;
                    this.f59909e = sb2;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str3) == null) {
                        if (i2 == 603) {
                            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f59910f.f59866f);
                            return;
                        }
                        if (StatHelper.getPassLoginStatus().equals("1")) {
                            StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_OPENBDUSS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), "0"), this.f59905a);
                        }
                        PayCallBack payCallBack2 = this.f59906b;
                        if (payCallBack2 != null) {
                            payCallBack2.onPayResult(2, "");
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str3) == null) {
                        StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_OPENBDUSS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), "1"), this.f59905a);
                        BaiduPay.getInstance().preOrderPay(this.f59907c, this.f59908d, this.f59909e, this.f59906b, new HashMap());
                    }
                }
            });
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f59866f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, IDefaultPayMethodCallback iDefaultPayMethodCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, this, context, str, iDefaultPayMethodCallback) == null) {
            BeanManager.getInstance().removeAllBeans(f59862c);
            new Handler(context.getMainLooper()).removeCallbacksAndMessages(null);
            PrecashierDefaultPayTypeBean precashierDefaultPayTypeBean = (PrecashierDefaultPayTypeBean) PrecashierBeanFactory.getInstance().getBean(context, 1, f59862c);
            precashierDefaultPayTypeBean.setParams(str);
            precashierDefaultPayTypeBean.setResponseCallback(new IBeanResponseCallback(this, iDefaultPayMethodCallback) { // from class: com.baidu.wallet.api.BaiduPayDelegate.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IDefaultPayMethodCallback f59944a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f59945b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iDefaultPayMethodCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59945b = this;
                    this.f59944a = iDefaultPayMethodCallback;
                }

                @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
                public void onBeanExecFailure(int i2, int i3, String str2) {
                    IDefaultPayMethodCallback iDefaultPayMethodCallback2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str2) == null) || (iDefaultPayMethodCallback2 = this.f59944a) == null) {
                        return;
                    }
                    iDefaultPayMethodCallback2.onReceived(i3, str2);
                }

                @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
                public void onBeanExecSuccess(int i2, Object obj, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeILL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str2) == null) || this.f59944a == null) {
                        return;
                    }
                    JSONObject jSONObject = null;
                    if (obj != null && (obj instanceof String)) {
                        String str3 = (String) obj;
                        try {
                            JSONObject jSONObject2 = new JSONObject(str3);
                            try {
                                if (jSONObject2.getInt(Constants.KEYS.RET) == 0) {
                                    this.f59944a.onReceived(0, str3);
                                    return;
                                }
                            } catch (JSONException unused) {
                            }
                            jSONObject = jSONObject2;
                        } catch (JSONException unused2) {
                        }
                    }
                    int i3 = -1;
                    String str4 = "";
                    if (jSONObject != null) {
                        try {
                            i3 = jSONObject.getInt(Constants.KEYS.RET);
                            str4 = jSONObject.getString("msg");
                        } catch (Exception unused3) {
                        }
                    }
                    this.f59944a.onReceived(i3, str4);
                }
            });
            precashierDefaultPayTypeBean.execBean();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, IWalletOuterInterfaceListener iWalletOuterInterfaceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, context, iWalletOuterInterfaceListener) == null) {
            BeanManager.getInstance().removeAllBeans(f59861b);
            Handler handler = new Handler(context.getMainLooper());
            handler.removeCallbacksAndMessages(null);
            s sVar = (s) PayBeanFactory.getInstance().getBean(context, PayBeanFactory.BEAN_ID_GET_WALLET_INTERFACE, f59861b);
            sVar.setResponseCallback(new IBeanResponseCallback(this, context, handler, iWalletOuterInterfaceListener) { // from class: com.baidu.wallet.api.BaiduPayDelegate.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f59879a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Handler f59880b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ IWalletOuterInterfaceListener f59881c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f59882d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, handler, iWalletOuterInterfaceListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59882d = this;
                    this.f59879a = context;
                    this.f59880b = handler;
                    this.f59881c = iWalletOuterInterfaceListener;
                }

                @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
                public void onBeanExecFailure(int i2, int i3, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str) == null) {
                        this.f59880b.post(new Runnable(this, i3, str) { // from class: com.baidu.wallet.api.BaiduPayDelegate.13.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f59886a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f59887b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass13 f59888c;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i3), str};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f59888c = this;
                                this.f59886a = i3;
                                this.f59887b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IWalletOuterInterfaceListener iWalletOuterInterfaceListener2;
                                Interceptable interceptable3 = $ic;
                                if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (iWalletOuterInterfaceListener2 = this.f59888c.f59881c) == null) {
                                    return;
                                }
                                iWalletOuterInterfaceListener2.onReceived(this.f59886a, this.f59887b);
                            }
                        });
                    }
                }

                @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
                public void onBeanExecSuccess(int i2, Object obj, String str) {
                    JSONObject jSONObject;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                        WalletInterfaceResponse walletInterfaceResponse = obj instanceof WalletInterfaceResponse ? (WalletInterfaceResponse) obj : null;
                        if (walletInterfaceResponse != null && (jSONObject = walletInterfaceResponse.login_data) != null) {
                            String jSONObject2 = jSONObject.toString();
                            String encodeBytes = Base64.encodeBytes(jSONObject2.getBytes());
                            String newPpKey = PayPreferenceManager.getNewPpKey(this.f59879a);
                            if (!TextUtils.isEmpty(newPpKey) && !TextUtils.isEmpty(encodeBytes)) {
                                PayPreferenceManager.setWalletInterfaceData(this.f59879a, newPpKey, encodeBytes);
                            }
                            this.f59880b.post(new Runnable(this, jSONObject2) { // from class: com.baidu.wallet.api.BaiduPayDelegate.13.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ String f59883a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass13 f59884b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, jSONObject2};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f59884b = this;
                                    this.f59883a = jSONObject2;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IWalletOuterInterfaceListener iWalletOuterInterfaceListener2;
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (iWalletOuterInterfaceListener2 = this.f59884b.f59881c) == null) {
                                        return;
                                    }
                                    iWalletOuterInterfaceListener2.onReceived(0, this.f59883a);
                                }
                            });
                        } else {
                            this.f59880b.post(new Runnable(this) { // from class: com.baidu.wallet.api.BaiduPayDelegate.13.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass13 f59885a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f59885a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IWalletOuterInterfaceListener iWalletOuterInterfaceListener2;
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (iWalletOuterInterfaceListener2 = this.f59885a.f59881c) == null) {
                                        return;
                                    }
                                    iWalletOuterInterfaceListener2.onReceived(-1, "");
                                }
                            });
                        }
                        if (walletInterfaceResponse == null || walletInterfaceResponse.unlogin_data == null) {
                            return;
                        }
                        PayPreferenceManager.setWalletInterfaceData(this.f59879a, BaiduPayDelegate.f59864e, walletInterfaceResponse.unlogin_data.toString());
                    }
                }
            });
            sVar.execBean();
        }
    }

    private void a(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65550, this, context, str, payCallBack, map) == null) {
            if (!PayDataCache.getInstance().isRemotePay()) {
                StatHelper.payLoginSeneor(PayStatServiceEvent.LCL_PAY_ENTER, new String[0]);
            }
            c(context, str, payCallBack, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, this, context, map) == null) || context == null || map == null) {
            return;
        }
        String str = map.get("key_remote_pkg_name");
        String str2 = map.get("key_remote_where_to_back");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        ComponentName componentName = new ComponentName(str, str2);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(268435456);
        }
        intent.addFlags(536870912);
        intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    private ArrayList<String> a(String str, Map map, Context context) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, this, str, map, context)) == null) {
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
                if (map.containsKey("key_remote_pkg_name")) {
                    String str2 = (String) map.get("key_remote_pkg_name");
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
        return (ArrayList) invokeLLL.objValue;
    }

    private ArrayList<String> a(WalletInterfaceResponse.WalletModuleData walletModuleData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, walletModuleData)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (walletModuleData == null) {
                return arrayList;
            }
            arrayList.add("" + walletModuleData.type);
            arrayList.add(walletModuleData.link_addr);
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, str, str2)) == null) {
            HashMap hashMap = new HashMap();
            if (TextUtils.isEmpty(str)) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("errCode", str);
                    jSONObject.put(BeanConstants.DXM_OCR_KEY_ERROR_DES, str2);
                } catch (JSONException e2) {
                    LogUtil.e(f59861b, "error", e2);
                }
            }
            hashMap.put("data", Base64Utils.encodeToString(jSONObject != null ? jSONObject.toString().getBytes() : str2.getBytes()));
            return assembleResult(hashMap, false);
        }
        return (String) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Context context, com.baidu.wallet.paysdk.securitycenter.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, this, str, context, aVar) == null) {
            BeanManager.getInstance().removeAllBeans(f59863d);
            new Handler(context.getMainLooper()).removeCallbacksAndMessages(null);
            if (EnterWalletDxmPayServiceAction.GET_SECURITY_CENTER_DATA.equals(str)) {
                SecurityCenterBean securityCenterBean = (SecurityCenterBean) SecurityCenterFactory.getInstance().getBean(context, 0, f59863d);
                securityCenterBean.setResponseCallback(new a(aVar));
                securityCenterBean.execBean();
            } else if (EnterWalletDxmPayServiceAction.GET_PAY_SETTING_DATA.equals(str)) {
                PaySetListBean paySetListBean = (PaySetListBean) SecurityCenterFactory.getInstance().getBean(context, 1, f59863d);
                paySetListBean.setResponseCallback(new a(aVar));
                paySetListBean.execBean();
            } else {
                aVar.a(10004, "功能未实现");
            }
        }
    }
}
