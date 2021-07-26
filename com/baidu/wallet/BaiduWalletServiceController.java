package com.baidu.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.api.WalletServiceBeanConst;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class BaiduWalletServiceController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String H5CHECKPWDCB = "H5CheckPwd";

    /* renamed from: b  reason: collision with root package name */
    public static final String f23908b = "BaiduWalletServiceController";

    /* renamed from: c  reason: collision with root package name */
    public static final Object f23909c;

    /* renamed from: d  reason: collision with root package name */
    public static LoginBackListenerProxy f23910d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ILightappInvokerCallback f23911a;

    /* renamed from: e  reason: collision with root package name */
    public long f23912e;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static BaiduWalletServiceController f23930a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-887653447, "Lcom/baidu/wallet/BaiduWalletServiceController$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-887653447, "Lcom/baidu/wallet/BaiduWalletServiceController$a;");
                    return;
                }
            }
            f23930a = new BaiduWalletServiceController();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1453436010, "Lcom/baidu/wallet/BaiduWalletServiceController;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1453436010, "Lcom/baidu/wallet/BaiduWalletServiceController;");
                return;
            }
        }
        f23909c = new Object();
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.f23912e;
            LogUtil.logd("timeD=" + j);
            if (0 >= j || j >= 800) {
                this.f23912e = currentTimeMillis;
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static BaiduWalletServiceController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a.f23930a : (BaiduWalletServiceController) invokeV.objValue;
    }

    public static void getOpenBdussFirst(Context context, Intent intent, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, intent, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            WalletLoginHelper.getInstance().verifyPassLogin(z2, new LoginBackListenerProxy(context, new ILoginBackListener(context, intent, z) { // from class: com.baidu.wallet.BaiduWalletServiceController.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f23924a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Intent f23925b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f23926c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, intent, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f23924a = context;
                    this.f23925b = intent;
                    this.f23926c = z;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f23924a.startActivity(this.f23925b);
                        Context context2 = this.f23924a;
                        if (context2 instanceof Activity) {
                            if (this.f23926c) {
                                BaiduWalletUtils.startActivityAnim(context2);
                            } else {
                                BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context2);
                            }
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        this.f23924a.startActivity(this.f23925b);
                        Context context2 = this.f23924a;
                        if (context2 instanceof Activity) {
                            if (this.f23926c) {
                                BaiduWalletUtils.startActivityAnim(context2);
                            } else {
                                BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context2);
                            }
                        }
                    }
                }
            }));
        }
    }

    public static void loginFirst(Context context, Intent intent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65545, null, context, intent, z) == null) {
            if (context instanceof Activity) {
                com.baidu.wallet.core.utils.LogUtil.d(f23908b, "context is activity!");
            } else {
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            f23910d = new LoginBackListenerProxy(context, new ILoginBackListener(intent, z, context) { // from class: com.baidu.wallet.BaiduWalletServiceController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Intent f23913a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f23914b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Context f23915c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {intent, Boolean.valueOf(z), context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f23913a = intent;
                    this.f23914b = z;
                    this.f23915c = context;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) && i2 == 603) {
                        WalletLoginHelper.getInstance().onlyLogin(BaiduWalletServiceController.f23910d);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        this.f23913a.putExtra("with_anim", this.f23914b);
                        this.f23915c.startActivity(this.f23913a);
                        Context context2 = this.f23915c;
                        if (context2 instanceof Activity) {
                            if (this.f23914b) {
                                BaiduWalletUtils.startActivityAnim(context2);
                            } else {
                                BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context2);
                            }
                        }
                    }
                }
            });
            WalletLoginHelper.getInstance().login(f23910d);
        }
    }

    public void accessBusCardChargeNFC(Context context, Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, parcelable) == null) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_NFC).action("nfchome").data("android.nfc.extra.TAG", parcelable), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletServiceController f23923a;

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
                    this.f23923a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) && i2 == 5) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("provider", BaiduWalletServiceProviderMap.PLUGIN_NFC);
                        hashMap2.put("action", "nfchome");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap2.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap2.values());
                    }
                }
            });
        }
    }

    public boolean enterTransConfirm(BaseActivity baseActivity, JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseActivity, jSONObject, str)) == null) {
            LocalRouter.getInstance(baseActivity).route(baseActivity, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_TRNASFER).action("entertransferconfirm").data("params", jSONObject.toString()).data("url", str), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletServiceController f23921a;

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
                    this.f23921a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) && i2 == 5) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("provider", BaiduWalletServiceProviderMap.PLUGIN_TRNASFER);
                        hashMap2.put("action", "entertransferconfirm");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap2.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap2.values());
                    }
                }
            });
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void gotoWalletService(Context context, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            gotoWalletService(context, Long.parseLong(str), str2, z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean startWallet(Context context, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_WALLETHOME).action("wallethome").data("withAnim", Boolean.toString(z)).data("pageType", Boolean.toString(z2)), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletServiceController f23922a;

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
                    this.f23922a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) && i2 == 5) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("provider", BaiduWalletServiceProviderMap.PLUGIN_WALLETHOME);
                        hashMap2.put("action", "wallethome");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap2.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap2.values());
                    }
                }
            });
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public BaiduWalletServiceController() {
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
        this.f23911a = null;
    }

    private void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, this, context, z) == null) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_FASTPAY).action("doPhoneCharge").data("withAnim", String.valueOf(z)), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletServiceController f23927a;

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
                    this.f23927a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) && i2 == 5) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("provider", BaiduWalletServiceProviderMap.PLUGIN_FASTPAY);
                        hashMap2.put("action", "doPhoneCharge");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap2.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap2.values());
                    }
                }
            });
        }
    }

    public void gotoWalletService(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, str, str2) == null) {
            gotoWalletService(context, str, str2, true);
        }
    }

    public void gotoWalletService(Context context, String str, String str2, ILightappInvokerCallback iLightappInvokerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048581, this, context, str, str2, iLightappInvokerCallback) == null) || iLightappInvokerCallback == null) {
            return;
        }
        this.f23911a = iLightappInvokerCallback;
        gotoWalletService(context, str, str2, true);
    }

    private void a(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str, z) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("extra", str);
            hashMap.put("withAnim", Boolean.toString(z));
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_PERSONAL).action("entercoupon").data(hashMap), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletServiceController f23928a;

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
                    this.f23928a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap2) == null) && i2 == 5) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("provider", BaiduWalletServiceProviderMap.PLUGIN_PERSONAL);
                        hashMap3.put("action", "entercoupon");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap3.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap3.values());
                    }
                }
            });
        }
    }

    public void gotoWalletService(Context context, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Long.valueOf(j), str}) == null) {
            gotoWalletService(context, j, str, true);
        }
    }

    public void gotoWalletService(Context context, long j, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j), str, Boolean.valueOf(z)}) == null) || context == null || j < 0) {
            return;
        }
        if (b()) {
            DXMSdkSAUtils.onEvent(StatServiceEvent.FAST_DOUBLE_CLICK_GOTO_WALLET_SERVICE);
            PayStatisticsUtil.onEvent(StatServiceEvent.FAST_DOUBLE_CLICK_GOTO_WALLET_SERVICE);
            return;
        }
        WalletLoginHelper.getInstance().clearOpenBduss();
        if (!LocalRouter.getInstance(context).isProviderExisted(BaiduWalletServiceProviderMap.getInstance().getProviderNameBySerID(j))) {
            HashMap hashMap = new HashMap();
            hashMap.put(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE, Long.toString(j));
            hashMap.put("extra", str);
            hashMap.put("withAnim", Boolean.toString(z));
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("dxmPay").action("gotoWalletService").data(hashMap), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletServiceController f23920a;

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
                    this.f23920a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap2) == null) && i2 == 5) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("provider", "dxmPay");
                        hashMap3.put("action", "gotoWalletService");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap3.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap3.values());
                    }
                }
            });
        } else if (j == 1) {
            DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_API_PHONEFEECHARGE);
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_PHONEFEECHARGE);
            a(context, z);
        } else if (j == 64) {
            DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_API_COUPON);
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_COUPON);
            a(context, str, z);
        } else if (j == 2) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_SUPERACCOUNTTRANS);
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_TRNASFER).action("entertransfer").data("withAnim", Boolean.toString(z)), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletServiceController f23929a;

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
                    this.f23929a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap2) == null) && i2 == 5) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("provider", BaiduWalletServiceProviderMap.PLUGIN_TRNASFER);
                        hashMap3.put("action", "entertransfer");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap3.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap3.values());
                    }
                }
            });
        } else if (j == 1024) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_NFCCHARGE);
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_NFC).action("nfchome").data("withAnim", Boolean.toString(z)), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletServiceController f23916a;

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
                    this.f23916a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap2) == null) && i2 == 5) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("provider", BaiduWalletServiceProviderMap.PLUGIN_NFC);
                        hashMap3.put("action", "nfchome");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap3.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap3.values());
                    }
                }
            });
        } else if (j == 16384) {
            DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_API_STARTWALLET);
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_STARTWALLET);
            startWallet(context, z, false);
        } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_CREDIT) {
            DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_API_START_WALLET_CREDIT);
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_START_WALLET_CREDIT);
            startWallet(context, z, true);
        } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_FINANCE) {
            DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_API_START_WALLET_FINANCE);
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_START_WALLET_FINANCE);
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("tab").action("startWalletFinance").data("withAnim", Boolean.toString(z)), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletServiceController f23917a;

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
                    this.f23917a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap2) == null) && i2 == 5) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("provider", "tab");
                        hashMap3.put("action", "startWalletFinance");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap3.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap3.values());
                    }
                }
            });
        } else if (j == 32768) {
            DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_API_OWNERSCANCODE);
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_OWNERSCANCODE);
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_QRCODESCANNER).action("qrcodescanner").data("withAnim", Boolean.toString(z)).data("showQrCodeBtns", Boolean.valueOf("showQrCodeBtns".equals(str))), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletServiceController f23918a;

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
                    this.f23918a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap2) == null) && i2 == 5) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("provider", BaiduWalletServiceProviderMap.PLUGIN_QRCODESCANNER);
                        hashMap3.put("action", "qrcodescanner");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap3.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap3.values());
                    }
                }
            });
        } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_NFC_BUS_CARD_SETTING) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_NFC).action("nfcsetting").data("withAnim", Boolean.toString(z)), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletServiceController f23919a;

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
                    this.f23919a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap2) == null) && i2 == 5) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("provider", BaiduWalletServiceProviderMap.PLUGIN_NFC);
                        hashMap3.put("action", "nfcsetting");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap3.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap3.values());
                    }
                }
            });
        }
    }
}
