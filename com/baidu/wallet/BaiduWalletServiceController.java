package com.baidu.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.ResUtils;
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
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class BaiduWalletServiceController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String H5CHECKPWDCB = "H5CheckPwd";

    /* renamed from: b  reason: collision with root package name */
    public static final String f57095b = "BaiduWalletServiceController";

    /* renamed from: c  reason: collision with root package name */
    public static final String f57096c = "BaiduWalletServiceController";

    /* renamed from: d  reason: collision with root package name */
    public static int f57097d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f57098e;

    /* renamed from: f  reason: collision with root package name */
    public static LoginBackListenerProxy f57099f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ILightappInvokerCallback f57100a;

    /* renamed from: g  reason: collision with root package name */
    public long f57101g;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static BaiduWalletServiceController f57120a;
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
            f57120a = new BaiduWalletServiceController();
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
        f57098e = new Object();
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.f57101g;
            LogUtil.logd("timeD=" + j);
            if (0 >= j || j >= 800) {
                this.f57101g = currentTimeMillis;
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static BaiduWalletServiceController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? a.f57120a : (BaiduWalletServiceController) invokeV.objValue;
    }

    public static void getOpenBdussFirst(Context context, Intent intent, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, intent, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            WalletLoginHelper.getInstance().verifyPassLogin(z2, new LoginBackListenerProxy(context, new ILoginBackListener(context, intent, z) { // from class: com.baidu.wallet.BaiduWalletServiceController.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f57114a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Intent f57115b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f57116c;

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
                    this.f57114a = context;
                    this.f57115b = intent;
                    this.f57116c = z;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f57114a.startActivity(this.f57115b);
                        Context context2 = this.f57114a;
                        if (context2 instanceof Activity) {
                            if (this.f57116c) {
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
                        this.f57114a.startActivity(this.f57115b);
                        Context context2 = this.f57114a;
                        if (context2 instanceof Activity) {
                            if (this.f57116c) {
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
        if (interceptable == null || interceptable.invokeLLZ(65547, null, context, intent, z) == null) {
            if (context instanceof Activity) {
                com.baidu.wallet.core.utils.LogUtil.d("BaiduWalletServiceController", "context is activity!");
            } else {
                intent.setFlags(268435456);
            }
            f57099f = new LoginBackListenerProxy(context, new ILoginBackListener(intent, z, context) { // from class: com.baidu.wallet.BaiduWalletServiceController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Intent f57102a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f57103b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Context f57104c;

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
                    this.f57102a = intent;
                    this.f57103b = z;
                    this.f57104c = context;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(BaiduWalletServiceController.f57099f);
                        } else {
                            LoginBackListenerProxy unused = BaiduWalletServiceController.f57099f = null;
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        this.f57102a.putExtra("with_anim", this.f57103b);
                        this.f57104c.startActivity(this.f57102a);
                        Context context2 = this.f57104c;
                        if (context2 instanceof Activity) {
                            if (this.f57103b) {
                                BaiduWalletUtils.startActivityAnim(context2);
                            } else {
                                BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context2);
                            }
                        }
                        LoginBackListenerProxy unused = BaiduWalletServiceController.f57099f = null;
                    }
                }
            });
            WalletLoginHelper.getInstance().login(f57099f);
        }
    }

    public void accessBusCardChargeNFC(Context context, Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, parcelable) == null) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("nfc").action("nfchome").data("android.nfc.extra.TAG", parcelable), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletServiceController f57111a;

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
                    this.f57111a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) && i2 == 5) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("provider", "nfc");
                        hashMap2.put("action", "nfchome");
                        DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                    }
                }
            });
        }
    }

    public boolean enterTransConfirm(BaseActivity baseActivity, JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseActivity, jSONObject, str)) == null) {
            LocalRouter.getInstance(baseActivity).route(baseActivity, new RouterRequest().provider("transfer").action("entertransferconfirm").data("params", jSONObject.toString()).data("url", str), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletServiceController f57109a;

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
                    this.f57109a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) && i2 == 5) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("provider", "transfer");
                        hashMap2.put("action", "entertransferconfirm");
                        DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
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

    public boolean isDxmPayService(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) ? (j == 1 || j == 64 || j == 16384 || j == WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_CREDIT || j == WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_FINANCE || j == 32768) ? false : true : invokeJ.booleanValue;
    }

    public boolean startWallet(Context context, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("home").action("wallethome").data("withAnim", Boolean.toString(z)).data("pageType", Boolean.toString(z2)), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletServiceController f57110a;

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
                    this.f57110a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) && i2 == 5) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("provider", "home");
                        hashMap2.put("action", "wallethome");
                        DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
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
        this.f57100a = null;
    }

    private void a(Context context, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{context, Boolean.valueOf(z), str}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("extra", str);
            hashMap.put("withAnim", Boolean.toString(z));
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("fastpay").action("doPhoneCharge").data(hashMap), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletServiceController f57117a;

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
                    this.f57117a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap2) == null) && i2 == 5) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("provider", "fastpay");
                        hashMap3.put("action", "doPhoneCharge");
                        DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap3.values());
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

    private void b(Context context, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{context, Boolean.valueOf(z), str}) == null) {
            boolean z2 = true;
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("saoyisao").action("qrcodescanner").data("withAnim", Boolean.toString(z)).data("showQrCodeBtns", Boolean.valueOf((TextUtils.isEmpty(str) || !str.contains("showQrCodeBtns")) ? false : false)).data("type", Integer.valueOf((TextUtils.isEmpty(str) || !str.contains("barqrcodeType=2")) ? 1 : 2)), new RouterCallback(this, context) { // from class: com.baidu.wallet.BaiduWalletServiceController.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f57112a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletServiceController f57113b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57113b = this;
                    this.f57112a = context;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) && i2 == 5) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("provider", "saoyisao");
                        hashMap2.put("action", "qrcodescanner");
                        if (hashMap != null && hashMap.size() > 0 && "notSupport".equals(hashMap.get("errorMsg"))) {
                            Context context2 = this.f57112a;
                            GlobalUtils.toast(context2, ResUtils.getString(context2, "bd_wallet_not_include_tips"));
                            hashMap2.put("errmsg", hashMap.get("errorMsg"));
                        }
                        DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                    }
                }
            });
        }
    }

    public void gotoWalletService(Context context, String str, String str2, ILightappInvokerCallback iLightappInvokerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048581, this, context, str, str2, iLightappInvokerCallback) == null) || iLightappInvokerCallback == null) {
            return;
        }
        this.f57100a = iLightappInvokerCallback;
        gotoWalletService(context, str, str2, true);
    }

    public void gotoWalletService(Context context, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Long.valueOf(j), str}) == null) {
            gotoWalletService(context, j, str, true);
        }
    }

    public void gotoWalletService(Context context, long j, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j), str, Boolean.valueOf(z)}) == null) || context == null || j < 0 || b()) {
            return;
        }
        if (LocalRouter.getInstance(context).isProviderExisted(BaiduWalletServiceProviderMap.getInstance().getProviderNameBySerID(j))) {
            WalletLoginHelper.getInstance().clearOpenBduss();
            if (j == 1) {
                DXMSdkSAUtils.onEvent("#phoneFeeCharge");
                a(context, z, str);
                return;
            } else if (j == 64) {
                DXMSdkSAUtils.onEvent("#coupon");
                a(context, str, z);
                return;
            } else if (j == 2) {
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("transfer").action("entertransfer").data("withAnim", Boolean.toString(z)), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BaiduWalletServiceController f57119a;

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
                        this.f57119a = this;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i2, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) && i2 == 5) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("provider", "transfer");
                            hashMap2.put("action", "entertransfer");
                            DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                        }
                    }
                });
                return;
            } else if (j == 1024) {
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("nfc").action("nfchome").data("withAnim", Boolean.toString(z)), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BaiduWalletServiceController f57105a;

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
                        this.f57105a = this;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i2, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) && i2 == 5) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("provider", "nfc");
                            hashMap2.put("action", "nfchome");
                            DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                        }
                    }
                });
                return;
            } else if (j == 16384) {
                DXMSdkSAUtils.onEvent("#startWallet");
                startWallet(context, z, false);
                return;
            } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_CREDIT) {
                DXMSdkSAUtils.onEvent("#startWalletCredit");
                startWallet(context, z, true);
                return;
            } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_FINANCE) {
                DXMSdkSAUtils.onEvent("#startWalletFinance");
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("tab").action("startWalletFinance").data("withAnim", Boolean.toString(z)), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BaiduWalletServiceController f57106a;

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
                        this.f57106a = this;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i2, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) && i2 == 5) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("provider", "tab");
                            hashMap2.put("action", "startWalletFinance");
                            DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                        }
                    }
                });
                return;
            } else if (j == 32768) {
                DXMSdkSAUtils.onEvent("#ownerQrCode");
                b(context, z, str);
                return;
            } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_NFC_BUS_CARD_SETTING) {
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("nfc").action("nfcsetting").data("withAnim", Boolean.toString(z)), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BaiduWalletServiceController f57107a;

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
                        this.f57107a = this;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i2, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) && i2 == 5) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("provider", "nfc");
                            hashMap2.put("action", "nfcsetting");
                            DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                        }
                    }
                });
                return;
            } else {
                return;
            }
        }
        com.baidu.wallet.core.utils.LogUtil.d(f57095b, "dxmpay clearOpenBduss");
        com.dxmpay.wallet.api.WalletLoginHelper.getInstance().clearOpenBduss();
        HashMap hashMap = new HashMap();
        hashMap.put(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE, Long.toString(j));
        hashMap.put("extra", str);
        hashMap.put("withAnim", Boolean.toString(z));
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider("dxmPay").action("gotoWalletService").data(hashMap), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BaiduWalletServiceController f57108a;

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
                this.f57108a = this;
            }

            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i2, HashMap hashMap2) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap2) == null) && i2 == 5) {
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("provider", "dxmPay");
                    hashMap3.put("action", "gotoWalletService");
                    DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap3.values());
                }
            }
        });
    }

    private void a(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(AdIconUtil.AD_TEXT_ID, this, context, str, z) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("extra", str);
            hashMap.put("withAnim", Boolean.toString(z));
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("personal").action("entercoupon").data(hashMap), new RouterCallback(this) { // from class: com.baidu.wallet.BaiduWalletServiceController.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletServiceController f57118a;

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
                    this.f57118a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap2) == null) && i2 == 5) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("provider", "personal");
                        hashMap3.put("action", "entercoupon");
                        DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap3.values());
                    }
                }
            });
        }
    }
}
