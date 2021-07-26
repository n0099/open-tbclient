package com.baidu.wallet.api;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ChannelUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.enums.BindType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.Switch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.nopassauth.OtpTokenUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.statistics.StatSettings;
import com.baidu.wallet.base.statistics.SyncHttpImpl;
import com.baidu.wallet.core.ActLifecycleCbs;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.core.utils.PollOfflineCacheSwitch;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.BdWalletUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class BaiduWalletDelegate implements IWalletBaseFacade {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f24026b = "BaiduWalletDelegate";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ISecurityListener f24027a;

    /* renamed from: c  reason: collision with root package name */
    public Context f24028c;

    /* renamed from: d  reason: collision with root package name */
    public Domain f24029d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24030e;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final BaiduWalletDelegate f24047a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2120073438, "Lcom/baidu/wallet/api/BaiduWalletDelegate$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2120073438, "Lcom/baidu/wallet/api/BaiduWalletDelegate$a;");
                    return;
                }
            }
            f24047a = new BaiduWalletDelegate();
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-949691073, "Lcom/baidu/wallet/api/BaiduWalletDelegate;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-949691073, "Lcom/baidu/wallet/api/BaiduWalletDelegate;");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, context) == null) {
            long syncTime = OtpTokenUtils.syncTime(OtpTokenUtils.getmSyncWithServerTime(context));
            String str = f24026b;
            LogUtil.d(str, "sync server time: detatime is " + syncTime);
            OtpTokenUtils.setmSyncWithServerTime(context, syncTime);
        }
    }

    private void d(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, context) == null) || this.f24030e) {
            return;
        }
        this.f24030e = true;
        PayStatisticsUtil.initStatisticsModule(context, StatSettings.getInstance(context));
    }

    public static final BaiduWalletDelegate getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? a.f24047a : (BaiduWalletDelegate) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void callQRCodeScanner(Context context, IWalletQRScannerCallback iWalletQRScannerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, iWalletQRScannerCallback) == null) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_QRCODESCANNER).action("qrcodescanresult"), new RouterCallback(this, iWalletQRScannerCallback) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IWalletQRScannerCallback f24035a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletDelegate f24036b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iWalletQRScannerCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24036b = this;
                    this.f24035a = iWalletQRScannerCallback;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                        int i3 = 2;
                        String str = "";
                        String str2 = "失败";
                        if (i2 == 0 && hashMap != null) {
                            String str3 = (String) hashMap.get("value");
                            if (!TextUtils.isEmpty(str3)) {
                                str2 = "成功";
                                str = str3;
                                i3 = 0;
                            }
                            i3 = -1;
                        } else if (i2 == 5) {
                            str2 = "扫码模块不存在";
                            i3 = 1;
                        } else {
                            if (i2 == 1 && hashMap != null) {
                                int intValue = ((Integer) hashMap.get(RouterCallback.KEY_ERROR_CODE)).intValue();
                                String str4 = (String) hashMap.get("errorMsg");
                                if (intValue == 2 && TextUtils.equals(str4, "camera_permission_denied")) {
                                    str2 = "没有访问相机的权限";
                                } else if (intValue == 0) {
                                    i3 = 3;
                                    str2 = "用户取消";
                                }
                            }
                            i3 = -1;
                        }
                        IWalletQRScannerCallback iWalletQRScannerCallback2 = this.f24035a;
                        if (iWalletQRScannerCallback2 != null) {
                            iWalletQRScannerCallback2.onResult(i3, str2, str);
                        }
                    }
                }
            });
            BaiduWalletServiceController.getInstance().gotoWalletService(context, "32768", "");
        }
    }

    public Pair<Integer, Object> checkSecurityEvn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ISecurityListener iSecurityListener = this.f24027a;
            if (iSecurityListener != null) {
                return iSecurityListener.onCheck();
            }
            return null;
        }
        return (Pair) invokeV.objValue;
    }

    public void doBusCardChargeNFC(Context context, Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, context, parcelable) == null) {
            if (Build.VERSION.SDK_INT <= 9) {
                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_low_sdkversion_tip"));
                return;
            }
            BaiduWalletServiceController.getInstance().accessBusCardChargeNFC(context, parcelable);
            d(context);
        }
    }

    public Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24028c : (Context) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public String getBindUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? SdkInitResponse.getInstance().getLoginUrl(str) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void gotoWalletService(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, str, str2) == null) {
            BaiduWalletServiceController.getInstance().gotoWalletService(context, str, str2, true);
        }
    }

    public void initLangBrige(IWalletListener iWalletListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iWalletListener) == null) {
            LocalRouter.getInstance(this.f24028c).route(this.f24028c, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_init").data("wallet_listener", iWalletListener), new RouterCallback(this) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletDelegate f24034a;

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
                    this.f24034a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void initWallet(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            initWallet(context, BeanConstants.CHANNEL_ID_SIMPLIFY);
        }
    }

    public void invokeHostNative(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) || WalletLoginHelper.getInstance() == null || !(WalletLoginHelper.getInstance() instanceof IWalletInvokeHostListener) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ((IWalletInvokeHostListener) WalletLoginHelper.getInstance()).invokeHostNative(Long.parseLong(str), str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void logout(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            WalletLoginHelper.getInstance().logout();
            if (context != null) {
                AccountManager.getInstance(context.getApplicationContext()).logout();
            }
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void openH5Module(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048592, this, context, str, z) == null) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_start").data("url", str).data("title", null).data("with_anim", Boolean.TRUE).data("show_share", Boolean.valueOf(z)), new RouterCallback(this) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletDelegate f24044a;

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
                    this.f24044a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                    }
                }
            });
        }
    }

    public void removeH5LifeCycleCb(Context context, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, context, activityLifecycleCallbacks) == null) || context == null) {
            return;
        }
        LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_removeLifeCycleCb").data("lifeCycleCb", activityLifecycleCallbacks).data("activty", context), new RouterCallback(this) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BaiduWalletDelegate f24037a;

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
                this.f24037a = this;
            }

            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i2, HashMap hashMap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                }
            }
        });
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void setDebugOn(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, context, z) == null) {
            if (z) {
                DebugConfig.getInstance(context).changeQA();
            } else {
                DebugConfig.getInstance(context).changeOnline();
            }
            StatSettings statSettings = StatSettings.getInstance(context);
            if (statSettings != null) {
                statSettings.setReleaseVesionFlag(!z);
            }
        }
    }

    public void setPassDomain(Domain domain) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, domain) == null) {
            this.f24029d = domain;
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public boolean startWallet(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, context)) == null) {
            DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_API_STARTWALLET);
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_STARTWALLET);
            return BaiduWalletServiceController.getInstance().startWallet(context, true, false);
        }
        return invokeL.booleanValue;
    }

    public BaiduWalletDelegate() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context) == null) && this.f24029d == null) {
            this.f24029d = Domain.DOMAIN_ONLINE;
            String environment = DebugConfig.getInstance(context).getEnvironment();
            boolean z = true;
            if ("QA".equalsIgnoreCase(environment)) {
                this.f24029d = Domain.DOMAIN_QA;
            } else if ("RD".equalsIgnoreCase(environment)) {
                this.f24029d = Domain.DOMAIN_QA;
            } else {
                z = false;
            }
            SapiConfiguration.Builder initialShareStrategy = new SapiConfiguration.Builder(context).setProductLineInfo("bdwalletsdk", "1", "3s9y80v8ipz8huoh9k06hurn2lia5eez").setRuntimeEnvironment(this.f24029d).setSocialBindType(BindType.EXPLICIT).initialShareStrategy(LoginShareStrategy.DISABLED);
            Switch r1 = Switch.ON;
            SapiAccountManager.getInstance().init(initialShareStrategy.smsLoginConfig(new SapiConfiguration.SmsLoginConfig(r1, r1, r1)).configurableViewLayout(Switch.ON).setSupportFaceLogin(false).sofireSdkConfig("600000", "69a0826db896e8c99e5d7bf63a14de3d", 600000).debug(z).build());
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void initWallet(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                a(context);
                b(context);
                initWallet(null, context, str);
                initLangBrige(null);
                return;
            }
            throw new IllegalArgumentException("The channel number can not be empty.");
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            SapiAccountManager.registerReceiveShareListener(new SapiAccountManager.ReceiveShareListener(this, context) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f24031a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletDelegate f24032b;

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
                    this.f24032b = this;
                    this.f24031a = context;
                }

                public void onReceiveShare() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f24032b.b(this.f24031a);
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void openH5Module(Context context, String str, boolean z, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{context, str, Boolean.valueOf(z), bundle}) == null) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_start").data("url", str).data("title", null).data("with_anim", Boolean.TRUE).data("show_share", Boolean.valueOf(z)).data("bundle", bundle), new RouterCallback(this) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletDelegate f24045a;

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
                    this.f24045a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void initWallet(IWalletListener iWalletListener, Context context, String str, ISecurityListener iSecurityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, iWalletListener, context, str, iSecurityListener) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.f24027a = iSecurityListener;
                initWallet(iWalletListener, context, str);
                return;
            }
            throw new IllegalArgumentException("The channel number can not be empty.");
        }
    }

    public void openH5Module(Context context, String str, String str2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_start").data("url", str).data("title", str2).data("with_anim", Boolean.valueOf(z)).data("show_share", Boolean.valueOf(z2)), new RouterCallback(this) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletDelegate f24046a;

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
                    this.f24046a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void initWallet(IWalletListener iWalletListener, Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, iWalletListener, context, str) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("The channel number can not be empty.");
            }
            if (context == null) {
                return;
            }
            if (iWalletListener != null) {
                initLangBrige(iWalletListener);
            }
            WalletLoginHelper.getInstance().init(context, iWalletListener);
            BeanConstants.CHANNEL_ID = str;
            String str2 = "BaiduWallet-" + BeanConstants.VERSION_NO + "-Android-" + BeanConstants.CHANNEL_ID;
            BeanConstants.SDK_VERSION = str2;
            ChannelUtils.initBussinessParams(str2, false);
            DXMSdkSAUtils.initSensorStat(context);
            PassUtil.registerPassNormalize(new PassUtil.IPassNormalize(this) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletDelegate f24038a;

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
                    this.f24038a = this;
                }

                @Override // com.baidu.wallet.core.utils.PassUtil.IPassNormalize
                public boolean onNormalize(Context context2, int i2, Map<String, String> map) {
                    InterceptResult invokeLIL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, context2, i2, map)) == null) {
                        LogUtil.logd("onNormalize ");
                        WalletLoginHelper.getInstance().onLoginChanaged(context2, map);
                        return false;
                    }
                    return invokeLIL.booleanValue;
                }
            });
            if (DebugConfig.getInstance().isOnline()) {
                DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.ONLINE, (String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, BeanConstants.DOMAIN_CONFIG_KEY, ""));
                if (((Boolean) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_ONLINE, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.FALSE)).booleanValue()) {
                    com.baidu.apollon.heartbeat.a.c().a(true);
                }
            } else {
                DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.QA, (String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_QA, BeanConstants.DOMAIN_CONFIG_KEY, ""));
                if (((Boolean) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_QA, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.FALSE)).booleanValue()) {
                    com.baidu.apollon.heartbeat.a.c().a(true);
                }
            }
            MessageQueue messageQueue = null;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                messageQueue = Looper.myQueue();
            } else if (Build.VERSION.SDK_INT >= 23) {
                messageQueue = Looper.getMainLooper().getQueue();
            } else {
                try {
                    Field declaredField = Looper.class.getDeclaredField("mQueue");
                    declaredField.setAccessible(true);
                    messageQueue = (MessageQueue) declaredField.get(Looper.getMainLooper());
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (NoSuchFieldException e3) {
                    e3.printStackTrace();
                }
            }
            if (messageQueue != null) {
                messageQueue.addIdleHandler(new MessageQueue.IdleHandler(this, context) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Context f24039a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BaiduWalletDelegate f24040b;

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
                        this.f24040b = this;
                        this.f24039a = context;
                    }

                    @Override // android.os.MessageQueue.IdleHandler
                    public boolean queueIdle() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            LocalRouter.getInstance(this.f24039a.getApplicationContext()).route(this.f24039a, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_initWebView"), new RouterCallback(this) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.5.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass5 f24041a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f24041a = this;
                                }

                                @Override // com.baidu.wallet.router.RouterCallback
                                public void onResult(int i2, HashMap hashMap) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i2, hashMap) == null) {
                                        LogUtil.d(BaiduWalletDelegate.f24026b, "webview init finish");
                                    }
                                }
                            });
                            return false;
                        }
                        return invokeV.booleanValue;
                    }
                });
            }
            new Thread(new Runnable(this, context) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f24042a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletDelegate f24043b;

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
                    this.f24043b = this;
                    this.f24042a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && SafePay.getInstance().prepareCompleted()) {
                        PayStatisticsUtil.initStatisticsModule(this.f24042a.getApplicationContext(), StatSettings.getInstance(this.f24042a.getApplicationContext()));
                        PayStatisticsUtil.setHttpImpl(new SyncHttpImpl());
                        BdWalletUtils.loadDeviceFP(this.f24042a.getApplicationContext());
                        this.f24043b.c(this.f24042a);
                    }
                }
            }, "walletInit").start();
            this.f24028c = context.getApplicationContext();
            PollOfflineCacheSwitch.getInstance().registerListener();
            ActLifecycleCbs.a().a((Application) context.getApplicationContext());
        }
    }

    public void openH5Module(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, context, bundle) == null) || bundle == null || !bundle.containsKey("url") || TextUtils.isEmpty(bundle.getString("url"))) {
            return;
        }
        String string = bundle.getString("url");
        String string2 = bundle.containsKey("title") ? bundle.getString("title") : null;
        boolean z = bundle.containsKey("withAnim") ? bundle.getBoolean("withAnim") : true;
        boolean z2 = bundle.containsKey("show_share") ? bundle.getBoolean("show_share") : true;
        bundle.remove("url");
        bundle.remove("title");
        bundle.remove("withAnim");
        bundle.remove("show_share");
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_start").data("url", string).data("title", string2).data("with_anim", Boolean.valueOf(z)).data("show_share", Boolean.valueOf(z2)).data("bundle", bundle), new RouterCallback(this) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BaiduWalletDelegate f24033a;

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
                this.f24033a = this;
            }

            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i2, HashMap hashMap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                }
            }
        });
    }

    public void openH5Module(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) {
            openH5Module(context, str, true);
        }
    }
}
