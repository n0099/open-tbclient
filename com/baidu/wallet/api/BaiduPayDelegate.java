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
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.pay.BindBack;
import com.baidu.android.pay.PayCallBack;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.support.Base64;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final int RNAUTH_HIGH_GRADE = 3;
    public static final int RNAUTH_LOW_GRADE = 1;
    public static final int RNAUTH_MEDIUM_GRADE = 2;

    /* renamed from: a  reason: collision with root package name */
    public static final String f23932a = "BaiduPayDelegate";

    /* renamed from: b  reason: collision with root package name */
    public static final String f23933b;

    /* renamed from: c  reason: collision with root package name */
    public static String f23934c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public HandlePassLoginResult f23935d;

    /* renamed from: e  reason: collision with root package name */
    public LoginBackListenerProxy f23936e;

    /* renamed from: f  reason: collision with root package name */
    public PayCallBack f23937f;

    /* renamed from: g  reason: collision with root package name */
    public long f23938g;

    /* loaded from: classes5.dex */
    public class HandlePassLoginResult extends LoginBackListenerProxy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaiduPayDelegate f24022a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f24023b;

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
            this.f24022a = baiduPayDelegate;
            this.f24023b = z;
        }

        @Override // com.baidu.wallet.passport.LoginBackListenerProxy, com.baidu.wallet.api.ILoginBackListener
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (this.f24023b) {
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
                super.onFail(i2, str);
            }
        }

        @Override // com.baidu.wallet.passport.LoginBackListenerProxy, com.baidu.wallet.api.ILoginBackListener
        public void onSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (StatHelper.getPassLoginStatus().equals("0")) {
                    if (this.f24023b) {
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
                super.onSuccess(i2, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final BaiduPayDelegate f24024a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2126409615, "Lcom/baidu/wallet/api/BaiduPayDelegate$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2126409615, "Lcom/baidu/wallet/api/BaiduPayDelegate$a;");
                    return;
                }
            }
            f24024a = new BaiduPayDelegate();
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
        f23933b = f23932a + ".getPayMethod";
        f23934c = "wallet_interface_unlogindata";
    }

    public static BaiduPayDelegate getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? a.f24024a : (BaiduPayDelegate) invokeV.objValue;
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
        PayStatisticsUtil.onEventWithValues(StatServiceEvent.ACCESS_WALLET_ENTRY_EVENT, a(walletModuleData));
        int i2 = walletModuleData.type;
        if (i2 == 1) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_start").data("url", walletModuleData.link_addr).data("title", null).data("with_anim", Boolean.valueOf(walletModuleData.needAnim())).data("show_share", Boolean.TRUE), new RouterCallback(this) { // from class: com.baidu.wallet.api.BaiduPayDelegate.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f24021a;

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
                    this.f24021a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i3, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, hashMap) == null) {
                    }
                }
            });
        } else if (i2 == 2) {
            WalletLoginHelper.getInstance().startPage(walletModuleData.link_addr);
        } else if (i2 == 3) {
            BaiduWalletServiceController.getInstance().gotoWalletService(context, walletModuleData.link_addr, "", walletModuleData.needAnim());
        }
    }

    public void cashierEnterSensor(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
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

    public void changePayMethod(Activity activity, Map map, IModifyPayTypeCallback iModifyPayTypeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, map, iModifyPayTypeCallback) == null) {
            if (c()) {
                PayStatisticsUtil.onEvent(PayStatServiceEvent.FAST_DOUBLE_CLICK_CHANGE_PAY_METHOD);
                return;
            }
            StatisticManager.onEvent("changePayMethod");
            PayController.getInstance().setModifyPayTypeCallback(iModifyPayTypeCallback);
            WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
            WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(activity, new ILoginBackListener(this, activity, map) { // from class: com.baidu.wallet.api.BaiduPayDelegate.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Activity f23986a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Map f23987b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f23988c;

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
                    this.f23988c = this;
                    this.f23986a = activity;
                    this.f23987b = map;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        PrecashierModifyPayTypeManager.getInstance().getModifyPayType(this.f23986a, this.f23987b);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        PrecashierModifyPayTypeManager.getInstance().getModifyPayType(this.f23986a, this.f23987b);
                    }
                }
            }));
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void checkPwd(Context context, CheckCallBack checkCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, checkCallBack) == null) {
            this.f23936e = new LoginBackListenerProxy(context, new ILoginBackListener(this, context, checkCallBack) { // from class: com.baidu.wallet.api.BaiduPayDelegate.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f24014a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ CheckCallBack f24015b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f24016c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, checkCallBack};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24016c = this;
                    this.f24014a = context;
                    this.f24015b = checkCallBack;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(this.f24016c.f23936e);
                            return;
                        }
                        CheckCallBack checkCallBack2 = this.f24015b;
                        if (checkCallBack2 != null) {
                            checkCallBack2.onCheckResult(2, "cancle");
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        BaiduPay.getInstance().checkPwd(this.f24014a, this.f24015b);
                    }
                }
            });
            WalletLoginHelper.getInstance().login(this.f23936e);
        }
    }

    public void checkPwdFromH5(Context context, String str, CheckCallBack checkCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, str, checkCallBack) == null) {
            this.f23936e = new LoginBackListenerProxy(context, new ILoginBackListener(this, context, str, checkCallBack) { // from class: com.baidu.wallet.api.BaiduPayDelegate.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f24017a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f24018b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ CheckCallBack f24019c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f24020d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str, checkCallBack};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24020d = this;
                    this.f24017a = context;
                    this.f24018b = str;
                    this.f24019c = checkCallBack;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        if (i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(this.f24020d.f23936e);
                            return;
                        }
                        CheckCallBack checkCallBack2 = this.f24019c;
                        if (checkCallBack2 != null) {
                            checkCallBack2.onCheckResult(2, QueryResponse.Options.CANCEL);
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        BaiduPay.getInstance().checkPwdFromH5(this.f24017a, this.f24018b, this.f24019c);
                    }
                }
            });
            WalletLoginHelper.getInstance().login(this.f23936e);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doBind(Context context, BindBack bindBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, context, bindBack, map) == null) {
            if (context != null && map != null) {
                doInnerBind(context, bindBack, map, "");
                return;
            }
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_ONBINDRESULT);
            bindBack.onBindResult(-10, null);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doBindCardIndependent(Context context, BindBack bindBack, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, bindBack, str) == null) {
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
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            this.f23936e = new LoginBackListenerProxy(context, new ILoginBackListener(this, bindBack, context, intent, str) { // from class: com.baidu.wallet.api.BaiduPayDelegate.21
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BindBack f23996a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f23997b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Intent f23998c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f23999d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f24000e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bindBack, context, intent, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24000e = this;
                    this.f23996a = bindBack;
                    this.f23997b = context;
                    this.f23998c = intent;
                    this.f23999d = str;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        if (i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(this.f24000e.f23936e);
                            return;
                        }
                        this.f23996a.onBindResult(2, "");
                        BaiduPay.getInstance().clearBindCallbackExt();
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        BaiduPay.getInstance().bindCardOnCardaddReturn(this.f23997b, new BindCardEntry.OnReturn(this) { // from class: com.baidu.wallet.api.BaiduPayDelegate.21.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass21 f24001a;

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
                                this.f24001a = this;
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
                                        ((BaseActivity) loadingUi).startActivity(this.f24001a.f23998c);
                                        return;
                                    }
                                    AnonymousClass21 anonymousClass21 = this.f24001a;
                                    anonymousClass21.f23997b.startActivity(anonymousClass21.f23998c);
                                }
                            }
                        }, PayRequestCache.BindCategory.Initiative, 1, null, this.f23999d);
                    }
                }
            });
            WalletLoginHelper.getInstance().login(this.f23936e);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doCheckPwd(Context context, Map<String, String> map, CheckCallBack checkCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, map, checkCallBack) == null) {
            this.f23936e = new LoginBackListenerProxy(context, new ILoginBackListener(this, context, map, checkCallBack) { // from class: com.baidu.wallet.api.BaiduPayDelegate.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f24010a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Map f24011b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ CheckCallBack f24012c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f24013d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, map, checkCallBack};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24013d = this;
                    this.f24010a = context;
                    this.f24011b = map;
                    this.f24012c = checkCallBack;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(this.f24013d.f23936e);
                            return;
                        }
                        CheckCallBack checkCallBack2 = this.f24012c;
                        if (checkCallBack2 != null) {
                            checkCallBack2.onCheckResult(2, "");
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        BaiduPay.getInstance().doCheckPwd(this.f24010a, this.f24011b, this.f24012c);
                    }
                }
            });
            WalletLoginHelper.getInstance().login(this.f23936e);
        }
    }

    public void doInnerBind(Context context, BindBack bindBack, Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, context, bindBack, map, str) == null) {
            this.f23936e = null;
            this.f23936e = new LoginBackListenerProxy(context, new ILoginBackListener(this, context, bindBack, map, str) { // from class: com.baidu.wallet.api.BaiduPayDelegate.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f23962a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BindBack f23963b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Map f23964c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f23965d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f23966e;

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
                    this.f23966e = this;
                    this.f23962a = context;
                    this.f23963b = bindBack;
                    this.f23964c = map;
                    this.f23965d = str;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        if (i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(this.f23966e.f23936e);
                        } else if (this.f23963b != null) {
                            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_ONBINDRESULT);
                            this.f23963b.onBindResult(-5, null);
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        BaiduPay.getInstance().doBindCardExt(this.f23962a, this.f23963b, this.f23964c, this.f23965d);
                    }
                }
            });
            WalletLoginHelper.getInstance().login(this.f23936e);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doPay(Context context, String str, PayCallBack payCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, context, str, payCallBack) == null) {
            doPay(context, str, payCallBack, new HashMap());
        }
    }

    public void doPayRNAuth(Context context, HashMap<String, String> hashMap, RNAuthCallBack rNAuthCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, context, hashMap, rNAuthCallBack) == null) {
            RnAuthMiddleActivity.setRnAuthCallBack(rNAuthCallBack);
            context.startActivity(RnAuthMiddleActivity.getStartIntent(context, hashMap));
        }
    }

    public void doPrecashierPay(Context context, String str, PayCallBack payCallBack, Map<String, String> map, PrecashierCreateOrderResponse precashierCreateOrderResponse, IModifyPayTypeCallback iModifyPayTypeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, str, payCallBack, map, precashierCreateOrderResponse, iModifyPayTypeCallback}) == null) {
            PayStatisticsUtil.onEvent(StatServiceEvent.PRE_CASHIER_PAY);
            if (iModifyPayTypeCallback == null) {
                iModifyPayTypeCallback = new IModifyPayTypeCallback(this, context, str, payCallBack, map) { // from class: com.baidu.wallet.api.BaiduPayDelegate.17
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Context f23975a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f23976b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ PayCallBack f23977c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ Map f23978d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ BaiduPayDelegate f23979e;

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
                        this.f23979e = this;
                        this.f23975a = context;
                        this.f23976b = str;
                        this.f23977c = payCallBack;
                        this.f23978d = map;
                    }

                    @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                    public void onPayTypeModified(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, precashierModifyPayTypeDefaultData) == null) {
                            PayDataCache.getInstance().resetFromPrecashier();
                            this.f23979e.doPay(this.f23975a, this.f23976b, this.f23977c, this.f23978d);
                        }
                    }

                    @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                    public void onPayTypeSetted() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        }
                    }
                };
            }
            PayController.getInstance().setModifyPayTypeCallback(iModifyPayTypeCallback);
            PayDataCache.getInstance().setIsRemotePay(false);
            PayDataCache.getInstance().setFromPreCashier();
            this.f23936e = new LoginBackListenerProxy(context, new ILoginBackListener(this, context, str, payCallBack, map, precashierCreateOrderResponse) { // from class: com.baidu.wallet.api.BaiduPayDelegate.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f23980a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f23981b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ PayCallBack f23982c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ Map f23983d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ PrecashierCreateOrderResponse f23984e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f23985f;

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
                    this.f23985f = this;
                    this.f23980a = context;
                    this.f23981b = str;
                    this.f23982c = payCallBack;
                    this.f23983d = map;
                    this.f23984e = precashierCreateOrderResponse;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) && i2 == 603) {
                        WalletLoginHelper.getInstance().onlyLogin(this.f23985f.f23936e);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        BaiduPay.getInstance().doPrecashierPay(this.f23980a, this.f23981b, this.f23982c, this.f23983d, this.f23984e);
                    }
                }
            });
            WalletLoginHelper.getInstance().login(this.f23936e);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doRNAuth(Context context, Map<String, String> map, RNAuthCallBack rNAuthCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, context, map, rNAuthCallBack) == null) || context == null || map == null) {
            return;
        }
        this.f23936e = new LoginBackListenerProxy(context, new ILoginBackListener(this, context, map, rNAuthCallBack) { // from class: com.baidu.wallet.api.BaiduPayDelegate.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f23989a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Map f23990b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ RNAuthCallBack f23991c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BaiduPayDelegate f23992d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, map, rNAuthCallBack};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f23992d = this;
                this.f23989a = context;
                this.f23990b = map;
                this.f23991c = rNAuthCallBack;
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    if (i2 == 603) {
                        WalletLoginHelper.getInstance().onlyLogin(this.f23992d.f23936e);
                        return;
                    }
                    RNAuthCallBack rNAuthCallBack2 = this.f23991c;
                    if (rNAuthCallBack2 != null) {
                        rNAuthCallBack2.onRNAuthResult(-5, null);
                    }
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                    BaiduPay.getInstance().doRNAuth(this.f23989a, this.f23990b, this.f23991c);
                }
            }
        });
        WalletLoginHelper.getInstance().login(this.f23936e);
    }

    public void doRemotePay(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048591, this, context, str, payCallBack, map) == null) || context == null || TextUtils.isEmpty(str)) {
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

    public void getPayMethod(Context context, String str, IDefaultPayMethodCallback iDefaultPayMethodCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, context, str, iDefaultPayMethodCallback) == null) {
            if (c()) {
                PayStatisticsUtil.onEvent(PayStatServiceEvent.FAST_DOUBLE_CLICK_GET_PAY_METHOD);
                return;
            }
            WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
            WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(context, new ILoginBackListener(this, context, str, iDefaultPayMethodCallback) { // from class: com.baidu.wallet.api.BaiduPayDelegate.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f24002a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f24003b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ IDefaultPayMethodCallback f24004c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f24005d;

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
                    this.f24005d = this;
                    this.f24002a = context;
                    this.f24003b = str;
                    this.f24004c = iDefaultPayMethodCallback;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        this.f24005d.a(this.f24002a, this.f24003b, this.f24004c);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        this.f24005d.a(this.f24002a, this.f24003b, this.f24004c);
                    }
                }
            }));
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public String getWalletOuterInterface(Context context, IWalletOuterInterfaceListener iWalletOuterInterfaceListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, context, iWalletOuterInterfaceListener)) == null) {
            WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(context, new ILoginBackListener(this, context, iWalletOuterInterfaceListener) { // from class: com.baidu.wallet.api.BaiduPayDelegate.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f23942a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ IWalletOuterInterfaceListener f23943b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f23944c;

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
                    this.f23944c = this;
                    this.f23942a = context;
                    this.f23943b = iWalletOuterInterfaceListener;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f23944c.a(this.f23942a, this.f23943b);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        this.f23944c.a(this.f23942a, this.f23943b);
                    }
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
            String walletInterfaceData2 = PayPreferenceManager.getWalletInterfaceData(context, f23934c, "");
            return !TextUtils.isEmpty(walletInterfaceData2) ? walletInterfaceData2 : "";
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void preOrderPay(Context context, String str, IPrecashierCallback iPrecashierCallback) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048595, this, context, str, iPrecashierCallback) == null) || TextUtils.isEmpty(str)) {
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
                    public final /* synthetic */ IPrecashierCallback f23955a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BaiduPayDelegate f23956b;

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
                        this.f23956b = this;
                        this.f23955a = iPrecashierCallback;
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
                                List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getHasPwd(), StatHelper.getPayType(), StatHelper.getPayWay());
                                HashMap hashMap = new HashMap();
                                hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
                                hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
                                StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PAY, collectData, hashMap);
                                StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PAY_FAILED, collectData, hashMap);
                                this.f23955a.onResult(this.f23956b.a(String.valueOf(i2), str3));
                                return;
                            }
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("data", Base64Utils.encodeToString(str3.getBytes()));
                            this.f23955a.onResult(this.f23956b.a((Map<String, Object>) hashMap2, true));
                        }
                    }
                };
                getInstance().preOrderPay(context, str2, jsonToURLParams, payCallBack, new IModifyPayTypeCallback(this, payCallBack) { // from class: com.baidu.wallet.api.BaiduPayDelegate.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayCallBack f23967a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BaiduPayDelegate f23968b;

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
                        this.f23968b = this;
                        this.f23967a = payCallBack;
                    }

                    @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                    public void onPayTypeModified(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, precashierModifyPayTypeDefaultData) == null) {
                            this.f23967a.onPayResult(10000, "默认支付方式变更");
                        }
                    }

                    @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                    public void onPayTypeSetted() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, context) == null) {
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            String str = payRequest != null ? payRequest.mParams : "";
            String payFrom = payRequest != null ? payRequest.getPayFrom() : "";
            PayCallBack payBack = BaiduPay.getInstance().getPayBack();
            PayRequestCache.getInstance().clearPaySdkRequestCache();
            PayBaseBeanActivity.exitEbpay();
            String str2 = f23932a;
            LogUtil.d(str2, "orderinfo=" + str + " ==============callback=" + payBack);
            HashMap hashMap = new HashMap();
            hashMap.put("pay_from", payFrom);
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
        this.f23937f = null;
    }

    private IRemoteServiceCallback b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) ? new IRemoteServiceCallback.Stub(this) { // from class: com.baidu.wallet.api.BaiduPayDelegate.1
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
                        public final /* synthetic */ int f23939a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f23940b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f23941c;

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
                            this.f23941c = this;
                            this.f23939a = i2;
                            this.f23940b = str;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f23941c.this$0.f23937f == null) {
                                return;
                            }
                            this.f23941c.this$0.f23937f.onPayResult(this.f23939a, this.f23940b);
                            this.f23941c.this$0.f23937f = null;
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
        if (interceptable == null || interceptable.invokeLLLL(65561, this, context, str, payCallBack, map) == null) {
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
            this.f23935d = new HandlePassLoginResult(this, context, false, new ILoginBackListener(this, payCallBack, context, map, str) { // from class: com.baidu.wallet.api.BaiduPayDelegate.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayCallBack f23957a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f23958b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Map f23959c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f23960d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f23961e;

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
                    this.f23961e = this;
                    this.f23957a = payCallBack;
                    this.f23958b = context;
                    this.f23959c = map;
                    this.f23960d = str;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        if (i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(this.f23961e.f23935d);
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
                        if (this.f23957a != null) {
                            PayDataCache.getInstance().isRemotePay();
                            this.f23957a.onPayResult(2, "");
                            if (PayDataCache.getInstance().isRemotePay()) {
                                try {
                                    this.f23961e.a(this.f23958b, this.f23959c);
                                } catch (ActivityNotFoundException e2) {
                                    e2.printStackTrace();
                                }
                            }
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
                            StatisticManager.onEventWithValues(PayStatServiceEvent.LCL_OPENBDUSS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo(), "1"));
                        }
                        Context context2 = this.f23958b;
                        if (context2 != null) {
                            this.f23961e.b(context2, this.f23960d, this.f23957a, this.f23959c);
                            return;
                        }
                        List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), new String[0]);
                        HashMap hashMap = new HashMap();
                        hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
                        hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
                        StatisticManager.onEventWithValues(PayStatServiceEvent.STD_PAY_CANCEL, collectData, hashMap);
                        PayCallBack payCallBack2 = this.f23957a;
                        if (payCallBack2 != null) {
                            payCallBack2.onPayResult(2, "");
                        }
                    }
                }
            });
            WalletLoginHelper.getInstance().login(this.f23935d);
        }
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doPay(Context context, String str, PayCallBack payCallBack, @NonNull Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, context, str, payCallBack, map) == null) {
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
                this.f23937f = payCallBack;
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65559, this, context, str, payCallBack, map) == null) {
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
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void getPayMethod(Context context, String str, @NonNull IPrecashierCallback iPrecashierCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, context, str, iPrecashierCallback) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("requestInfo") && jSONObject.get("requestInfo") != null) {
                    getInstance().getPayMethod(context, jSONObject.getString("requestInfo"), new IDefaultPayMethodCallback(this, iPrecashierCallback) { // from class: com.baidu.wallet.api.BaiduPayDelegate.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ IPrecashierCallback f24008a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ BaiduPayDelegate f24009b;

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
                            this.f24009b = this;
                            this.f24008a = iPrecashierCallback;
                        }

                        @Override // com.baidu.wallet.paysdk.precashier.IDefaultPayMethodCallback
                        public void onReceived(int i2, String str2) {
                            String a2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                                if (i2 == 0) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("data", Base64Utils.encodeToString(str2.getBytes()));
                                    a2 = this.f24009b.a((Map<String, Object>) hashMap, true);
                                } else {
                                    a2 = this.f24009b.a(String.valueOf(i2), str2);
                                }
                                this.f24008a.onResult(a2);
                            }
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
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void changePayMethod(Activity activity, String str, IPrecashierCallback iPrecashierCallback) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, activity, str, iPrecashierCallback) == null) {
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
                    getInstance().changePayMethod(activity, hashMap, new IModifyPayTypeCallback(this, hashMap.containsKey("version") ? (String) hashMap.get("version") : "0", iPrecashierCallback) { // from class: com.baidu.wallet.api.BaiduPayDelegate.20
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f23993a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ IPrecashierCallback f23994b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ BaiduPayDelegate f23995c;

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
                            this.f23995c = this;
                            this.f23993a = r7;
                            this.f23994b = iPrecashierCallback;
                        }

                        @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                        public void onPayTypeModified(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
                            String localizedMessage;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, precashierModifyPayTypeDefaultData) == null) {
                                HashMap hashMap2 = new HashMap();
                                if ("1".equals(this.f23993a)) {
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
                                this.f23994b.onResult(this.f23995c.a((Map<String, Object>) hashMap2, true));
                            }
                        }

                        @Override // com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback
                        public void onPayTypeSetted() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            }
                        }
                    });
                    return;
                }
                throw new InvalidParameterException("参数非法");
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.f23938g;
            com.baidu.apollon.utils.LogUtil.logd("timeD=" + j);
            if (0 >= j || j >= 800) {
                this.f23938g = currentTimeMillis;
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void preOrderPay(Context context, String str, String str2, PayCallBack payCallBack, IModifyPayTypeCallback iModifyPayTypeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048596, this, context, str, str2, payCallBack, iModifyPayTypeCallback) == null) {
            StatisticManager.onEvent("preOrderPay");
            if (c()) {
                StatisticManager.onEvent(PayStatServiceEvent.FAST_DOUBLE_CLICK_PRE_ORDER_PAY);
                return;
            }
            cashierEnterSensor(PayStatServiceEvent.PERCASHIER_PAY_ENTER, str);
            HashMap hashMap = new HashMap();
            hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
            hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
            PayController.getInstance().setModifyPayTypeCallback(iModifyPayTypeCallback);
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(TextUtils.isEmpty(str2) ? "order_from=pre_cashdesk" : !str2.contains("order_from") ? "&order_from=pre_cashdesk" : "");
            String sb2 = sb.toString();
            PayDataCache.getInstance().setIsRemotePay(false);
            PayDataCache.getInstance().setFromPreCashier();
            String orderNo = StatHelper.getOrderNo();
            String[] strArr = new String[1];
            strArr[0] = WalletLoginHelper.getInstance().isPassLogin() ? "1" : "0";
            StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PAY_LOGIN, StatHelper.collectData(orderNo, strArr), hashMap);
            StatHelper.cachePassLoginStatus(WalletLoginHelper.getInstance().isPassLogin() ? "1" : "0");
            this.f23935d = new HandlePassLoginResult(this, context, true, new ILoginBackListener(this, hashMap, payCallBack, context, str, sb2) { // from class: com.baidu.wallet.api.BaiduPayDelegate.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Map f23969a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PayCallBack f23970b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Context f23971c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f23972d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f23973e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f23974f;

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
                    this.f23974f = this;
                    this.f23969a = hashMap;
                    this.f23970b = payCallBack;
                    this.f23971c = context;
                    this.f23972d = str;
                    this.f23973e = sb2;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str3) == null) {
                        if (i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(this.f23974f.f23935d);
                            return;
                        }
                        if (StatHelper.getPassLoginStatus().equals("1")) {
                            StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_OPENBDUSS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), "0"), this.f23969a);
                        }
                        PayCallBack payCallBack2 = this.f23970b;
                        if (payCallBack2 != null) {
                            payCallBack2.onPayResult(2, "");
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str3) == null) {
                        StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_OPENBDUSS_RESULT, StatHelper.collectData(StatHelper.getOrderNo(), "1"), this.f23969a);
                        BaiduPay.getInstance().preOrderPay(this.f23971c, this.f23972d, this.f23973e, this.f23970b, new HashMap());
                    }
                }
            });
            WalletLoginHelper.getInstance().login(this.f23935d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, IDefaultPayMethodCallback iDefaultPayMethodCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, this, context, str, iDefaultPayMethodCallback) == null) {
            BeanManager.getInstance().removeAllBeans(f23933b);
            new Handler(context.getMainLooper()).removeCallbacksAndMessages(null);
            StatisticManager.onEventStart("getPayMethod");
            PrecashierDefaultPayTypeBean precashierDefaultPayTypeBean = (PrecashierDefaultPayTypeBean) PrecashierBeanFactory.getInstance().getBean(context, 1, f23933b);
            precashierDefaultPayTypeBean.setParams(str);
            precashierDefaultPayTypeBean.setResponseCallback(new IBeanResponseCallback(this, iDefaultPayMethodCallback) { // from class: com.baidu.wallet.api.BaiduPayDelegate.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IDefaultPayMethodCallback f24006a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f24007b;

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
                    this.f24007b = this;
                    this.f24006a = iDefaultPayMethodCallback;
                }

                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecFailure(int i2, int i3, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str2) == null) {
                        StatisticManager.onEventEnd("getPayMethod", i3);
                        IDefaultPayMethodCallback iDefaultPayMethodCallback2 = this.f24006a;
                        if (iDefaultPayMethodCallback2 != null) {
                            iDefaultPayMethodCallback2.onReceived(i3, str2);
                        }
                    }
                }

                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecSuccess(int i2, Object obj, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeILL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str2) == null) || this.f24006a == null) {
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
                                    this.f24006a.onReceived(0, str3);
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
                    StatisticManager.onEventEnd("getPayMethod", i3);
                    this.f24006a.onReceived(i3, str4);
                }
            });
            precashierDefaultPayTypeBean.execBean();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, IWalletOuterInterfaceListener iWalletOuterInterfaceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, context, iWalletOuterInterfaceListener) == null) {
            BeanManager.getInstance().removeAllBeans(f23932a);
            Handler handler = new Handler(context.getMainLooper());
            handler.removeCallbacksAndMessages(null);
            PayStatisticsUtil.onEventStart(StatServiceEvent.GET_WALLET_OUTER_INTERFACE);
            w wVar = (w) PayBeanFactory.getInstance().getBean(context, PayBeanFactory.BEAN_ID_GET_WALLET_INTERFACE, f23932a);
            wVar.setResponseCallback(new IBeanResponseCallback(this, context, handler, iWalletOuterInterfaceListener) { // from class: com.baidu.wallet.api.BaiduPayDelegate.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f23945a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Handler f23946b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ IWalletOuterInterfaceListener f23947c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ BaiduPayDelegate f23948d;

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
                    this.f23948d = this;
                    this.f23945a = context;
                    this.f23946b = handler;
                    this.f23947c = iWalletOuterInterfaceListener;
                }

                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecFailure(int i2, int i3, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str) == null) {
                        PayStatisticsUtil.onEventEnd(StatServiceEvent.GET_WALLET_OUTER_INTERFACE, i3);
                        this.f23946b.post(new Runnable(this, i3, str) { // from class: com.baidu.wallet.api.BaiduPayDelegate.11.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f23952a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f23953b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass11 f23954c;

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
                                this.f23954c = this;
                                this.f23952a = i3;
                                this.f23953b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IWalletOuterInterfaceListener iWalletOuterInterfaceListener2;
                                Interceptable interceptable3 = $ic;
                                if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (iWalletOuterInterfaceListener2 = this.f23954c.f23947c) == null) {
                                    return;
                                }
                                iWalletOuterInterfaceListener2.onReceived(this.f23952a, this.f23953b);
                            }
                        });
                    }
                }

                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecSuccess(int i2, Object obj, String str) {
                    JSONObject jSONObject;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                        PayStatisticsUtil.onEventEnd(StatServiceEvent.GET_WALLET_OUTER_INTERFACE, 0);
                        WalletInterfaceResponse walletInterfaceResponse = obj instanceof WalletInterfaceResponse ? (WalletInterfaceResponse) obj : null;
                        if (walletInterfaceResponse != null && (jSONObject = walletInterfaceResponse.login_data) != null) {
                            String jSONObject2 = jSONObject.toString();
                            String encodeBytes = Base64.encodeBytes(jSONObject2.getBytes());
                            String newPpKey = PayPreferenceManager.getNewPpKey(this.f23945a);
                            if (!TextUtils.isEmpty(newPpKey) && !TextUtils.isEmpty(encodeBytes)) {
                                PayPreferenceManager.setWalletInterfaceData(this.f23945a, newPpKey, encodeBytes);
                            }
                            this.f23946b.post(new Runnable(this, jSONObject2) { // from class: com.baidu.wallet.api.BaiduPayDelegate.11.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ String f23949a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass11 f23950b;

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
                                    this.f23950b = this;
                                    this.f23949a = jSONObject2;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IWalletOuterInterfaceListener iWalletOuterInterfaceListener2;
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (iWalletOuterInterfaceListener2 = this.f23950b.f23947c) == null) {
                                        return;
                                    }
                                    iWalletOuterInterfaceListener2.onReceived(0, this.f23949a);
                                }
                            });
                        } else {
                            this.f23946b.post(new Runnable(this) { // from class: com.baidu.wallet.api.BaiduPayDelegate.11.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass11 f23951a;

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
                                    this.f23951a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IWalletOuterInterfaceListener iWalletOuterInterfaceListener2;
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (iWalletOuterInterfaceListener2 = this.f23951a.f23947c) == null) {
                                        return;
                                    }
                                    iWalletOuterInterfaceListener2.onReceived(-1, "");
                                }
                            });
                        }
                        if (walletInterfaceResponse == null || walletInterfaceResponse.unlogin_data == null) {
                            return;
                        }
                        PayPreferenceManager.setWalletInterfaceData(this.f23945a, BaiduPayDelegate.f23934c, walletInterfaceResponse.unlogin_data.toString());
                    }
                }
            });
            wVar.execBean();
        }
    }

    private void a(Context context, String str, PayCallBack payCallBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65550, this, context, str, payCallBack, map) == null) {
            if (!PayDataCache.getInstance().isRemotePay()) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.LCL_PAY_ENTER, StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo()));
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
    public String a(Map<String, Object> map, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, this, map, z)) == null) {
            if (map == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", z ? 0 : 1);
                jSONObject.put("cnt", new JSONObject(map));
            } catch (JSONException e2) {
                LogUtil.e(f23932a, "error", e2);
            }
            return jSONObject.toString();
        }
        return (String) invokeLZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, str, str2)) == null) {
            HashMap hashMap = new HashMap();
            if (TextUtils.isEmpty(str)) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put(RouterCallback.KEY_ERROR_CODE, str);
                    jSONObject.put("des", str2);
                } catch (JSONException e2) {
                    LogUtil.e(f23932a, "error", e2);
                }
            }
            hashMap.put("data", Base64Utils.encodeToString(jSONObject != null ? jSONObject.toString().getBytes() : str2.getBytes()));
            return a((Map<String, Object>) hashMap, false);
        }
        return (String) invokeLL.objValue;
    }
}
