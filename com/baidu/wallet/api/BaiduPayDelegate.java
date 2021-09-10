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
    public static final String f60041b = "BaiduPayDelegate";

    /* renamed from: c  reason: collision with root package name */
    public static final String f60042c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f60043d;

    /* renamed from: e  reason: collision with root package name */
    public static String f60044e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f60045a;

    /* renamed from: f  reason: collision with root package name */
    public HandlePassLoginResult f60046f;

    /* renamed from: g  reason: collision with root package name */
    public LoginBackListenerProxy f60047g;

    /* renamed from: h  reason: collision with root package name */
    public PayCallBack f60048h;

    /* renamed from: i  reason: collision with root package name */
    public long f60049i;

    /* loaded from: classes8.dex */
    public class HandlePassLoginResult extends LoginBackListenerProxy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaiduPayDelegate f60136a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f60137b;

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
            this.f60136a = baiduPayDelegate;
            this.f60137b = z;
        }

        @Override // com.dxmpay.wallet.passport.LoginBackListenerProxy, com.baidu.wallet.api.ILoginBackListener
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (this.f60137b) {
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
                    if (this.f60137b) {
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
        public com.baidu.wallet.paysdk.securitycenter.a f60138a;

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
            this.f60138a = aVar;
        }

        @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i2, int i3, String str) {
            com.baidu.wallet.paysdk.securitycenter.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) || (aVar = this.f60138a) == null) {
                return;
            }
            aVar.a(i3, str);
        }

        @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i2, Object obj, String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) || this.f60138a == null) {
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
            this.f60138a.a(i3, str2);
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final BaiduPayDelegate f60139a;
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
            f60139a = new BaiduPayDelegate();
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
        f60042c = f60041b + ".getPayMethod";
        f60043d = f60041b + ".getSecurityCenter";
        f60044e = "wallet_interface_unlogindata";
    }

    public static BaiduPayDelegate getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? b.f60139a : (BaiduPayDelegate) invokeV.objValue;
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
                public final /* synthetic */ BaiduPayDelegate f60053a;

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
                    this.f60053a = this;
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
                LogUtil.e(f60041b, "error", e2);
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
                public final /* synthetic */ Activity f60105a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Map f60106b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f60107c;

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
                    this.f60107c = this;
                    this.f60105a = activity;
                    this.f60106b = map;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        PrecashierModifyPayTypeManager.getInstance().getModifyPayType(this.f60105a, this.f60106b);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        PrecashierModifyPayTypeManager.getInstance().getModifyPayType(this.f60105a, this.f60106b);
                    }
                }
            }));
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void checkPwd(Context context, CheckCallBack checkCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, checkCallBack) == null) {
            this.f60047g = new LoginBackListenerProxy(context, new ILoginBackListener(this, checkCallBack) { // from class: com.baidu.wallet.api.BaiduPayDelegate.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CheckCallBack f60131a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f60132b;

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
                    this.f60132b = this;
                    this.f60131a = checkCallBack;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (i2 == 603) {
                            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f60132b.f60047g);
                            return;
                        }
                        CheckCallBack checkCallBack2 = this.f60131a;
                        if (checkCallBack2 != null) {
                            checkCallBack2.onCheckResult(2, "cancle");
                            this.f60132b.f60047g = null;
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f60132b.f60047g.getContext() == null) {
                        return;
                    }
                    BaiduPay.getInstance().checkPwd(this.f60132b.f60047g.getContext(), this.f60131a);
                }
            });
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f60047g);
        }
    }

    public void checkPwdFromH5(Context context, String str, CheckCallBack checkCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, context, str, checkCallBack) == null) {
            this.f60047g = new LoginBackListenerProxy(context, new ILoginBackListener(this, str, checkCallBack) { // from class: com.baidu.wallet.api.BaiduPayDelegate.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f60133a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ CheckCallBack f60134b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f60135c;

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
                    this.f60135c = this;
                    this.f60133a = str;
                    this.f60134b = checkCallBack;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        if (i2 == 603) {
                            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f60135c.f60047g);
                            return;
                        }
                        CheckCallBack checkCallBack2 = this.f60134b;
                        if (checkCallBack2 != null) {
                            checkCallBack2.onCheckResult(2, QueryResponse.Options.CANCEL);
                            this.f60135c.f60047g = null;
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) || this.f60135c.f60047g.getContext() == null) {
                        return;
                    }
                    BaiduPay.getInstance().checkPwdFromH5(this.f60135c.f60047g.getContext(), this.f60133a, this.f60134b);
                }
            });
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f60047g);
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
            this.f60047g = new LoginBackListenerProxy(context, new ILoginBackListener(this, bindBack, intent, context, str) { // from class: com.baidu.wallet.api.BaiduPayDelegate.25
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BindBack f60111a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Intent f60112b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Context f60113c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f60114d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f60115e;

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
                    this.f60115e = this;
                    this.f60111a = bindBack;
                    this.f60112b = intent;
                    this.f60113c = context;
                    this.f60114d = str;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        if (i2 == 603) {
                            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f60115e.f60047g);
                            return;
                        }
                        this.f60111a.onBindResult(2, "");
                        BaiduPay.getInstance().clearBindCallbackExt();
                        this.f60115e.f60047g = null;
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        BaiduPay.getInstance().bindCardOnCardaddReturn(this.f60115e.f60047g.getContext(), new BindCardEntry.OnReturn(this) { // from class: com.baidu.wallet.api.BaiduPayDelegate.25.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass25 f60116a;

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
                                this.f60116a = this;
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
                                        ((BaseActivity) loadingUi).startActivity(this.f60116a.f60112b);
                                        return;
                                    }
                                    AnonymousClass25 anonymousClass25 = this.f60116a;
                                    anonymousClass25.f60113c.startActivity(anonymousClass25.f60112b);
                                }
                            }
                        }, PayRequestCache.BindCategory.Initiative, 1, null, this.f60114d);
                    }
                }
            });
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f60047g);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doCheckPwd(Context context, Map<String, String> map, CheckCallBack checkCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, context, map, checkCallBack) == null) {
            this.f60047g = new LoginBackListenerProxy(context, new ILoginBackListener(this, map, checkCallBack) { // from class: com.baidu.wallet.api.BaiduPayDelegate.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Map f60128a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ CheckCallBack f60129b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f60130c;

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
                    this.f60130c = this;
                    this.f60128a = map;
                    this.f60129b = checkCallBack;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (i2 == 603) {
                            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f60130c.f60047g);
                            return;
                        }
                        CheckCallBack checkCallBack2 = this.f60129b;
                        if (checkCallBack2 != null) {
                            checkCallBack2.onCheckResult(2, "");
                            this.f60130c.f60047g = null;
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f60130c.f60047g.getContext() == null) {
                        return;
                    }
                    BaiduPay.getInstance().doCheckPwd(this.f60130c.f60047g.getContext(), this.f60128a, this.f60129b);
                }
            });
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f60047g);
        }
    }

    public void doInnerBind(Context context, BindBack bindBack, Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, context, bindBack, map, str) == null) {
            this.f60047g = null;
            this.f60047g = new LoginBackListenerProxy(context, new ILoginBackListener(this, context, bindBack, map, str) { // from class: com.baidu.wallet.api.BaiduPayDelegate.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f60074a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BindBack f60075b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Map f60076c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f60077d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f60078e;

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
                    this.f60078e = this;
                    this.f60074a = context;
                    this.f60075b = bindBack;
                    this.f60076c = map;
                    this.f60077d = str;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        if (i2 == 603) {
                            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f60078e.f60047g);
                        } else if (this.f60075b != null) {
                            StatisticManager.onEvent("#onBindResult");
                            this.f60075b.onBindResult(-5, null);
                            this.f60078e.f60047g = null;
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) || this.f60078e.f60047g.getContext() == null) {
                        return;
                    }
                    BaiduPay.getInstance().doBindCardExt(this.f60074a, this.f60075b, this.f60076c, this.f60077d);
                }
            });
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f60047g);
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
        this.f60047g = new LoginBackListenerProxy(context, new ILoginBackListener(this, str, rNAuthCallBack) { // from class: com.baidu.wallet.api.BaiduPayDelegate.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f60117a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RNAuthCallBack f60118b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BaiduPayDelegate f60119c;

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
                this.f60119c = this;
                this.f60117a = str;
                this.f60118b = rNAuthCallBack;
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i2, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                    if (i2 == 603) {
                        com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f60119c.f60047g);
                        return;
                    }
                    RNAuthCallBack rNAuthCallBack2 = this.f60118b;
                    if (rNAuthCallBack2 != null) {
                        rNAuthCallBack2.onRNAuthResult(-5, null);
                        this.f60119c.f60047g = null;
                    }
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i2, String str2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) || this.f60119c.f60047g.getContext() == null) {
                    return;
                }
                BaiduPay.getInstance().doPayRNAuth(this.f60119c.f60047g.getContext(), this.f60117a, this.f60118b);
            }
        });
        com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f60047g);
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
                    public final /* synthetic */ Context f60091a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f60092b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ PayCallBack f60093c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ Map f60094d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ BaiduPayDelegate f60095e;

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
                        this.f60095e = this;
                        this.f60091a = context;
                        this.f60092b = str;
                        this.f60093c = payCallBack;
                        this.f60094d = map;
                    }

                    @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                    public void onPayTypeModified(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, precashierModifyPayTypeDefaultData) == null) {
                            PayDataCache.getInstance().resetFromPrecashier();
                            this.f60095e.doPay(this.f60091a, this.f60092b, this.f60093c, this.f60094d);
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
            this.f60047g = new LoginBackListenerProxy(context, new ILoginBackListener(this, context, str, payCallBack, map, precashierCreateOrderResponse) { // from class: com.baidu.wallet.api.BaiduPayDelegate.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f60099a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f60100b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ PayCallBack f60101c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ Map f60102d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ PrecashierCreateOrderResponse f60103e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f60104f;

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
                    this.f60104f = this;
                    this.f60099a = context;
                    this.f60100b = str;
                    this.f60101c = payCallBack;
                    this.f60102d = map;
                    this.f60103e = precashierCreateOrderResponse;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) && i2 == 603) {
                        com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f60104f.f60047g);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        BaiduPay.getInstance().doPrecashierPay(this.f60099a, this.f60100b, this.f60101c, this.f60102d, this.f60103e);
                    }
                }
            });
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f60047g);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doRNAuth(Context context, Map<String, String> map, RNAuthCallBack rNAuthCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048592, this, context, map, rNAuthCallBack) == null) || context == null || map == null) {
            return;
        }
        this.f60047g = new LoginBackListenerProxy(context, new ILoginBackListener(this, map, rNAuthCallBack) { // from class: com.baidu.wallet.api.BaiduPayDelegate.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Map f60096a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RNAuthCallBack f60097b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ BaiduPayDelegate f60098c;

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
                this.f60098c = this;
                this.f60096a = map;
                this.f60097b = rNAuthCallBack;
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    if (i2 == 603) {
                        com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f60098c.f60047g);
                        return;
                    }
                    RNAuthCallBack rNAuthCallBack2 = this.f60097b;
                    if (rNAuthCallBack2 != null) {
                        rNAuthCallBack2.onRNAuthResult(-5, null);
                        this.f60098c.f60047g = null;
                    }
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f60098c.f60047g.getContext() == null) {
                    return;
                }
                BaiduPay.getInstance().doRNAuth(this.f60098c.f60047g.getContext(), this.f60096a, this.f60097b);
            }
        });
        com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f60047g);
    }

    public void doRemotePay(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048593, this, context, str, payCallBack, map) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.f60045a) {
            StatHelper.clearSensor();
        }
        this.f60045a = false;
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
                public final /* synthetic */ Context f60120a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f60121b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ IDefaultPayMethodCallback f60122c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f60123d;

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
                    this.f60123d = this;
                    this.f60120a = context;
                    this.f60121b = str;
                    this.f60122c = iDefaultPayMethodCallback;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        this.f60123d.a(this.f60120a, this.f60121b, this.f60122c);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        this.f60123d.a(this.f60120a, this.f60121b, this.f60122c);
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
            this.f60047g = new LoginBackListenerProxy(context, new ILoginBackListener(this, str, context, aVar) { // from class: com.baidu.wallet.api.BaiduPayDelegate.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f60079a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f60080b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ com.baidu.wallet.paysdk.securitycenter.a f60081c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f60082d;

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
                    this.f60082d = this;
                    this.f60079a = str;
                    this.f60080b = context;
                    this.f60081c = aVar;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        if (i2 == 603) {
                            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f60082d.f60047g);
                            return;
                        }
                        com.baidu.wallet.paysdk.securitycenter.a aVar2 = this.f60081c;
                        if (aVar2 != null) {
                            aVar2.a(-5, "未登录");
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        this.f60082d.a(this.f60079a, this.f60080b, this.f60081c);
                    }
                }
            });
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f60047g);
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
                public final /* synthetic */ Context f60054a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ IWalletOuterInterfaceListener f60055b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f60056c;

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
                    this.f60056c = this;
                    this.f60054a = context;
                    this.f60055b = iWalletOuterInterfaceListener;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f60056c.a(this.f60054a, this.f60055b);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        this.f60056c.a(this.f60054a, this.f60055b);
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
            String walletInterfaceData2 = PayPreferenceManager.getWalletInterfaceData(context, f60044e, "");
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
                    public final /* synthetic */ IPrecashierCallback f60057a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BaiduPayDelegate f60058b;

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
                        this.f60058b = this;
                        this.f60057a = iPrecashierCallback;
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
                                this.f60057a.onResult(this.f60058b.a(String.valueOf(i2), str3));
                                return;
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("data", Base64Utils.encodeToString(str3.getBytes()));
                            this.f60057a.onResult(this.f60058b.assembleResult(hashMap, true));
                        }
                    }
                };
                getInstance().preOrderPay(context, str2, jsonToURLParams, payCallBack, new IModifyPayTypeCallback(this, payCallBack) { // from class: com.baidu.wallet.api.BaiduPayDelegate.17
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayCallBack f60083a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BaiduPayDelegate f60084b;

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
                        this.f60084b = this;
                        this.f60083a = payCallBack;
                    }

                    @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                    public void onPayTypeModified(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, precashierModifyPayTypeDefaultData) == null) {
                            this.f60083a.onPayResult(10000, "默认支付方式变更");
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
            this.f60045a = true;
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
        this.f60045a = false;
        this.f60048h = null;
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
                        public final /* synthetic */ int f60050a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f60051b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f60052c;

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
                            this.f60052c = this;
                            this.f60050a = i2;
                            this.f60051b = str;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f60052c.this$0.f60048h == null) {
                                return;
                            }
                            this.f60052c.this$0.f60048h.onPayResult(this.f60050a, this.f60051b);
                            this.f60052c.this$0.f60048h = null;
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
            this.f60046f = new HandlePassLoginResult(this, context, false, new ILoginBackListener(this, payCallBack, context, map, str) { // from class: com.baidu.wallet.api.BaiduPayDelegate.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayCallBack f60069a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f60070b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Map f60071c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f60072d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f60073e;

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
                    this.f60073e = this;
                    this.f60069a = payCallBack;
                    this.f60070b = context;
                    this.f60071c = map;
                    this.f60072d = str;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        if (i2 == 603) {
                            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f60073e.f60046f);
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
                        if (this.f60069a != null) {
                            PayDataCache.getInstance().isRemotePay();
                            this.f60069a.onPayResult(2, "");
                            if (PayDataCache.getInstance().isRemotePay()) {
                                try {
                                    this.f60073e.a(this.f60070b, this.f60071c);
                                } catch (ActivityNotFoundException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            this.f60073e.f60046f = null;
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
                        if (this.f60073e.f60046f.getContext() != null) {
                            BaiduPayDelegate baiduPayDelegate = this.f60073e;
                            baiduPayDelegate.b(baiduPayDelegate.f60046f.getContext(), this.f60072d, this.f60069a, this.f60071c);
                            return;
                        }
                        StatHelper.cacheBankCode("-1");
                        StatHelper.cacheCardType("-1");
                        StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_CANCEL);
                        PayCallBack payCallBack2 = this.f60069a;
                        if (payCallBack2 != null) {
                            payCallBack2.onPayResult(2, "");
                        }
                    }
                }
            });
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f60046f);
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
                if (!this.f60045a) {
                    StatHelper.clearSensor();
                }
                this.f60045a = false;
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
                this.f60048h = payCallBack;
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
                        public final /* synthetic */ IPrecashierCallback f60126a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ BaiduPayDelegate f60127b;

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
                            this.f60127b = this;
                            this.f60126a = iPrecashierCallback;
                        }

                        @Override // com.baidu.wallet.paysdk.precashier.IDefaultPayMethodCallback
                        public void onReceived(int i2, String str2) {
                            String a2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                                if (i2 == 0) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("data", Base64Utils.encodeToString(str2.getBytes()));
                                    a2 = this.f60127b.assembleResult(hashMap, true);
                                } else {
                                    a2 = this.f60127b.a(String.valueOf(i2), str2);
                                }
                                this.f60126a.onResult(a2);
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
                        public final /* synthetic */ String f60108a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ IPrecashierCallback f60109b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ BaiduPayDelegate f60110c;

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
                            this.f60110c = this;
                            this.f60108a = r7;
                            this.f60109b = iPrecashierCallback;
                        }

                        @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                        public void onPayTypeModified(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
                            String localizedMessage;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, precashierModifyPayTypeDefaultData) == null) {
                                HashMap hashMap2 = new HashMap();
                                if ("1".equals(this.f60108a)) {
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
                                this.f60109b.onResult(this.f60110c.assembleResult(hashMap2, true));
                            }
                        }

                        @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                        public void onPayTypeModifiedFailed(int i2, String str2) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) || this.f60109b == null) {
                                return;
                            }
                            BaiduPayDelegate baiduPayDelegate = this.f60110c;
                            this.f60109b.onResult(baiduPayDelegate.a(i2 + "", str2));
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
            long j2 = currentTimeMillis - this.f60049i;
            com.dxmpay.apollon.utils.LogUtil.logd("timeD=" + j2);
            if (0 >= j2 || j2 >= 800) {
                this.f60049i = currentTimeMillis;
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
            this.f60046f = new HandlePassLoginResult(this, context, true, new ILoginBackListener(this, hashMap, payCallBack, context, str, sb2) { // from class: com.baidu.wallet.api.BaiduPayDelegate.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Map f60085a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PayCallBack f60086b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Context f60087c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f60088d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f60089e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f60090f;

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
                    this.f60090f = this;
                    this.f60085a = hashMap;
                    this.f60086b = payCallBack;
                    this.f60087c = context;
                    this.f60088d = str;
                    this.f60089e = sb2;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str3) == null) {
                        if (i2 == 603) {
                            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().onlyLogin(this.f60090f.f60046f);
                            return;
                        }
                        if (StatHelper.getPassLoginStatus().equals("1")) {
                            StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_OPENBDUSS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), "0"), this.f60085a);
                        }
                        PayCallBack payCallBack2 = this.f60086b;
                        if (payCallBack2 != null) {
                            payCallBack2.onPayResult(2, "");
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str3) == null) {
                        StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_OPENBDUSS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), "1"), this.f60085a);
                        BaiduPay.getInstance().preOrderPay(this.f60087c, this.f60088d, this.f60089e, this.f60086b, new HashMap());
                    }
                }
            });
            com.dxmpay.wallet.api.WalletLoginHelper.getInstance().login(this.f60046f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, IDefaultPayMethodCallback iDefaultPayMethodCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, this, context, str, iDefaultPayMethodCallback) == null) {
            BeanManager.getInstance().removeAllBeans(f60042c);
            new Handler(context.getMainLooper()).removeCallbacksAndMessages(null);
            PrecashierDefaultPayTypeBean precashierDefaultPayTypeBean = (PrecashierDefaultPayTypeBean) PrecashierBeanFactory.getInstance().getBean(context, 1, f60042c);
            precashierDefaultPayTypeBean.setParams(str);
            precashierDefaultPayTypeBean.setResponseCallback(new IBeanResponseCallback(this, iDefaultPayMethodCallback) { // from class: com.baidu.wallet.api.BaiduPayDelegate.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IDefaultPayMethodCallback f60124a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f60125b;

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
                    this.f60125b = this;
                    this.f60124a = iDefaultPayMethodCallback;
                }

                @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
                public void onBeanExecFailure(int i2, int i3, String str2) {
                    IDefaultPayMethodCallback iDefaultPayMethodCallback2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str2) == null) || (iDefaultPayMethodCallback2 = this.f60124a) == null) {
                        return;
                    }
                    iDefaultPayMethodCallback2.onReceived(i3, str2);
                }

                @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
                public void onBeanExecSuccess(int i2, Object obj, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeILL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str2) == null) || this.f60124a == null) {
                        return;
                    }
                    JSONObject jSONObject = null;
                    if (obj != null && (obj instanceof String)) {
                        String str3 = (String) obj;
                        try {
                            JSONObject jSONObject2 = new JSONObject(str3);
                            try {
                                if (jSONObject2.getInt(Constants.KEYS.RET) == 0) {
                                    this.f60124a.onReceived(0, str3);
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
                    this.f60124a.onReceived(i3, str4);
                }
            });
            precashierDefaultPayTypeBean.execBean();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, IWalletOuterInterfaceListener iWalletOuterInterfaceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, context, iWalletOuterInterfaceListener) == null) {
            BeanManager.getInstance().removeAllBeans(f60041b);
            Handler handler = new Handler(context.getMainLooper());
            handler.removeCallbacksAndMessages(null);
            s sVar = (s) PayBeanFactory.getInstance().getBean(context, PayBeanFactory.BEAN_ID_GET_WALLET_INTERFACE, f60041b);
            sVar.setResponseCallback(new IBeanResponseCallback(this, context, handler, iWalletOuterInterfaceListener) { // from class: com.baidu.wallet.api.BaiduPayDelegate.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f60059a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Handler f60060b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ IWalletOuterInterfaceListener f60061c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f60062d;

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
                    this.f60062d = this;
                    this.f60059a = context;
                    this.f60060b = handler;
                    this.f60061c = iWalletOuterInterfaceListener;
                }

                @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
                public void onBeanExecFailure(int i2, int i3, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str) == null) {
                        this.f60060b.post(new Runnable(this, i3, str) { // from class: com.baidu.wallet.api.BaiduPayDelegate.13.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f60066a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f60067b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass13 f60068c;

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
                                this.f60068c = this;
                                this.f60066a = i3;
                                this.f60067b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IWalletOuterInterfaceListener iWalletOuterInterfaceListener2;
                                Interceptable interceptable3 = $ic;
                                if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (iWalletOuterInterfaceListener2 = this.f60068c.f60061c) == null) {
                                    return;
                                }
                                iWalletOuterInterfaceListener2.onReceived(this.f60066a, this.f60067b);
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
                            String newPpKey = PayPreferenceManager.getNewPpKey(this.f60059a);
                            if (!TextUtils.isEmpty(newPpKey) && !TextUtils.isEmpty(encodeBytes)) {
                                PayPreferenceManager.setWalletInterfaceData(this.f60059a, newPpKey, encodeBytes);
                            }
                            this.f60060b.post(new Runnable(this, jSONObject2) { // from class: com.baidu.wallet.api.BaiduPayDelegate.13.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ String f60063a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass13 f60064b;

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
                                    this.f60064b = this;
                                    this.f60063a = jSONObject2;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IWalletOuterInterfaceListener iWalletOuterInterfaceListener2;
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (iWalletOuterInterfaceListener2 = this.f60064b.f60061c) == null) {
                                        return;
                                    }
                                    iWalletOuterInterfaceListener2.onReceived(0, this.f60063a);
                                }
                            });
                        } else {
                            this.f60060b.post(new Runnable(this) { // from class: com.baidu.wallet.api.BaiduPayDelegate.13.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass13 f60065a;

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
                                    this.f60065a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IWalletOuterInterfaceListener iWalletOuterInterfaceListener2;
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (iWalletOuterInterfaceListener2 = this.f60065a.f60061c) == null) {
                                        return;
                                    }
                                    iWalletOuterInterfaceListener2.onReceived(-1, "");
                                }
                            });
                        }
                        if (walletInterfaceResponse == null || walletInterfaceResponse.unlogin_data == null) {
                            return;
                        }
                        PayPreferenceManager.setWalletInterfaceData(this.f60059a, BaiduPayDelegate.f60044e, walletInterfaceResponse.unlogin_data.toString());
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
                    LogUtil.e(f60041b, "error", e2);
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
            BeanManager.getInstance().removeAllBeans(f60043d);
            new Handler(context.getMainLooper()).removeCallbacksAndMessages(null);
            if (EnterWalletDxmPayServiceAction.GET_SECURITY_CENTER_DATA.equals(str)) {
                SecurityCenterBean securityCenterBean = (SecurityCenterBean) SecurityCenterFactory.getInstance().getBean(context, 0, f60043d);
                securityCenterBean.setResponseCallback(new a(aVar));
                securityCenterBean.execBean();
            } else if (EnterWalletDxmPayServiceAction.GET_PAY_SETTING_DATA.equals(str)) {
                PaySetListBean paySetListBean = (PaySetListBean) SecurityCenterFactory.getInstance().getBean(context, 1, f60043d);
                paySetListBean.setResponseCallback(new a(aVar));
                paySetListBean.execBean();
            } else {
                aVar.a(10004, "功能未实现");
            }
        }
    }
}
