package com.baidu.wallet.api;

import android.app.Activity;
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
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.ChannelUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.api.IWalletCreditFacade;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.nopassauth.OtpTokenUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.ActLifecycleCbs;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.beans.b;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.core.utils.PollInitUtils;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.BdWalletUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class BaiduWalletDelegate implements IWalletBaseFacade, IWalletCreditFacade {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f57215b = "BaiduWalletDelegate";

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f57216d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ISecurityListener f57217a;

    /* renamed from: c  reason: collision with root package name */
    public Context f57218c;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final BaiduWalletDelegate f57239a;
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
            f57239a = new BaiduWalletDelegate();
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

    public static final BaiduWalletDelegate getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? a.f57239a : (BaiduWalletDelegate) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void callQRCodeScanner(Context context, IWalletQRScannerCallback iWalletQRScannerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, iWalletQRScannerCallback) == null) {
            DXMSdkSAUtils.onEvent("#callQRCodeScanner");
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("saoyisao").action("qrcodescanner").data("withAnim", Boolean.toString(true)).data("qrcodeNeedResult", Boolean.TRUE), new RouterCallback(this, iWalletQRScannerCallback) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IWalletQRScannerCallback f57223a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletDelegate f57224b;

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
                    this.f57224b = this;
                    this.f57223a = iWalletQRScannerCallback;
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
                                int intValue = ((Integer) hashMap.get("errCode")).intValue();
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
                        IWalletQRScannerCallback iWalletQRScannerCallback2 = this.f57223a;
                        if (iWalletQRScannerCallback2 != null) {
                            iWalletQRScannerCallback2.onResult(i3, str2, str);
                        }
                    }
                }
            });
        }
    }

    public Pair<Integer, Object> checkSecurityEvn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ISecurityListener iSecurityListener = this.f57217a;
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
            } else {
                BaiduWalletServiceController.getInstance().accessBusCardChargeNFC(context, parcelable);
            }
        }
    }

    public Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57218c : (Context) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public String getBindUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? SdkInitResponse.getInstance().getLoginUrl(str) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletCreditFacade
    public void getUserFinancialInfo(Context context, IWalletCreditFacade.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, callback) == null) {
            if (!BdWalletUtils.isCertifiedApp(context) && callback != null) {
                a(callback, "验签失败");
            } else {
                WalletLoginHelper.getInstance().verifyPassLogin(false, new LoginBackListenerProxy(context, new ILoginBackListener(this, callback, context) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ IWalletCreditFacade.Callback f57225a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Context f57226b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ BaiduWalletDelegate f57227c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, callback, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f57227c = this;
                        this.f57225a = callback;
                        this.f57226b = context;
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onFail(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                            BaiduWalletDelegate baiduWalletDelegate = this.f57227c;
                            IWalletCreditFacade.Callback callback2 = this.f57225a;
                            if (TextUtils.isEmpty(str)) {
                                str = "用户登录异常";
                            }
                            baiduWalletDelegate.a(callback2, str);
                        }
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onSuccess(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                            b bVar = new b(this.f57226b);
                            bVar.setResponseCallback(new IBeanResponseCallback(this, bVar) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ b f57228a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f57229b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, bVar};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f57229b = this;
                                    this.f57228a = bVar;
                                }

                                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                                public void onBeanExecFailure(int i3, int i4, String str2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeIIL(1048576, this, i3, i4, str2) == null) {
                                        LogUtil.d("financial", "errCode: " + i4 + ", errMsg: " + str2);
                                        AnonymousClass3 anonymousClass3 = this.f57229b;
                                        anonymousClass3.f57227c.a(anonymousClass3.f57225a, str2);
                                    }
                                }

                                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                                public void onBeanExecSuccess(int i3, Object obj, String str2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeILL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, obj, str2) == null) {
                                        try {
                                            BeanResponseBase beanResponseBase = (BeanResponseBase) JsonUtils.fromJson(String.valueOf(obj), BeanResponseBase.class);
                                            if (beanResponseBase != null) {
                                                if (this.f57228a.a()) {
                                                    this.f57229b.f57225a.onResult(true, beanResponseBase.getRealResponseContent());
                                                } else {
                                                    this.f57229b.f57227c.a(this.f57229b.f57225a, beanResponseBase.getRealResponseMsg());
                                                }
                                            } else {
                                                this.f57229b.f57227c.a(this.f57229b.f57225a, ResUtils.getString(this.f57229b.f57226b, "ebpay_resolve_error"));
                                            }
                                        } catch (JSONException unused) {
                                            AnonymousClass3 anonymousClass3 = this.f57229b;
                                            anonymousClass3.f57227c.a(anonymousClass3.f57225a, ResUtils.getString(anonymousClass3.f57226b, "ebpay_resolve_error"));
                                        }
                                        LogUtil.d("financial", obj.toString());
                                    }
                                }
                            });
                            bVar.execBean();
                        }
                    }
                }));
            }
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void gotoWalletService(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, context, str, str2) == null) {
            BaiduWalletServiceController.getInstance().gotoWalletService(context, str, str2, true);
        }
    }

    public void initLangBrige(IWalletListener iWalletListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, iWalletListener) == null) {
            LocalRouter.getInstance(this.f57218c).route(this.f57218c, new RouterRequest().provider("langbrige").action("langbrige_init").data("wallet_listener", iWalletListener), new RouterCallback(this) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletDelegate f57221a;

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
                    this.f57221a = this;
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
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            initWallet(context, "simplify");
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void invokeBdWalletNative(Activity activity, String str, String str2, ILightappInvokerCallback iLightappInvokerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048588, this, activity, str, str2, iLightappInvokerCallback) == null) {
            LocalRouter.getInstance(activity).route(activity, new RouterRequest().provider("langbrige").action("langbrige_invokeNativeAbility").data("activity", activity).data("source", str).data("options", str2).data("callback", iLightappInvokerCallback), new RouterCallback(this) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletDelegate f57222a;

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
                    this.f57222a = this;
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

    public void invokeHostNative(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) || WalletLoginHelper.getInstance() == null || !(WalletLoginHelper.getInstance() instanceof IWalletInvokeHostListener) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ((IWalletInvokeHostListener) WalletLoginHelper.getInstance()).invokeHostNative(Long.parseLong(str), str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean isInited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? f57216d : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void logout(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            WalletLoginHelper.getInstance().logout();
            if (context != null) {
                AccountManager.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).logout();
            }
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void openH5Module(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048595, this, context, str, z) == null) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_start").data("url", str).data("title", null).data("with_anim", Boolean.TRUE).data("show_share", Boolean.valueOf(z)), new RouterCallback(this) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletDelegate f57236a;

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
                    this.f57236a = this;
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
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, context, activityLifecycleCallbacks) == null) || context == null) {
            return;
        }
        LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("langbrige").action("langbrige_removeLifeCycleCb").data("lifeCycleCb", activityLifecycleCallbacks).data("activty", context), new RouterCallback(this) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BaiduWalletDelegate f57230a;

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
                this.f57230a = this;
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
        if (interceptable == null || interceptable.invokeLZ(1048598, this, context, z) == null) {
            if (z) {
                DebugConfig.getInstance(context).changeQA();
            } else {
                DebugConfig.getInstance(context).changeOnline();
            }
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public boolean startWallet(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, context)) == null) {
            DXMSdkSAUtils.onEvent("#startWallet");
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

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void initWallet(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                WalletLoginHelper.getInstance().registerGlobalCallback(context);
                WalletLoginHelper.getInstance().configPass(context);
                initWallet(null, context, str);
                initLangBrige(null);
                return;
            }
            throw new IllegalArgumentException("The channel number can not be empty.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            long syncTime = OtpTokenUtils.syncTime(OtpTokenUtils.getmSyncWithServerTime(context));
            String str = f57215b;
            LogUtil.d(str, "sync server time: detatime is " + syncTime);
            OtpTokenUtils.setmSyncWithServerTime(context, syncTime);
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void openH5Module(Context context, String str, boolean z, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{context, str, Boolean.valueOf(z), bundle}) == null) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_start").data("url", str).data("title", null).data("with_anim", Boolean.TRUE).data("show_share", Boolean.valueOf(z)).data("bundle", bundle), new RouterCallback(this) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletDelegate f57237a;

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
                    this.f57237a = this;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IWalletCreditFacade.Callback callback, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, this, callback, str) == null) || callback == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msg", str);
            callback.onResult(false, jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void initWallet(IWalletListener iWalletListener, Context context, String str, ISecurityListener iSecurityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, iWalletListener, context, str, iSecurityListener) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.f57217a = iSecurityListener;
                initWallet(iWalletListener, context, str);
                return;
            }
            throw new IllegalArgumentException("The channel number can not be empty.");
        }
    }

    public void openH5Module(Context context, String str, String str2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_start").data("url", str).data("title", str2).data("with_anim", Boolean.valueOf(z)).data("show_share", Boolean.valueOf(z2)), new RouterCallback(this) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletDelegate f57238a;

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
                    this.f57238a = this;
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
        if (interceptable == null || interceptable.invokeLLL(1048586, this, iWalletListener, context, str) == null) {
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
            if (DebugConfig.getInstance().isOnline()) {
                DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.ONLINE, (String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, "wallet_sdk_domain_config_key", ""));
                com.baidu.apollon.heartbeat.a.c().a((String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, BeanConstants.DOMAIN_CONFIG_KEY_FOR_APP, ""));
            } else {
                DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.QA, (String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_QA, "wallet_sdk_domain_config_key", ""));
                com.baidu.apollon.heartbeat.a.c().a((String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_QA, BeanConstants.DOMAIN_CONFIG_KEY_FOR_APP, ""));
            }
            DXMSdkSAUtils.initSensorStat(context);
            com.baidu.apollon.restnet.a.a().a(new DXMSdkSAUtils());
            PassUtil.registerPassNormalize(new PassUtil.IPassNormalize(this) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletDelegate f57219a;

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
                    this.f57219a = this;
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
                    public final /* synthetic */ Context f57231a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BaiduWalletDelegate f57232b;

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
                        this.f57232b = this;
                        this.f57231a = context;
                    }

                    @Override // android.os.MessageQueue.IdleHandler
                    public boolean queueIdle() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            Context applicationContext = DxmApplicationContextImpl.getApplicationContext(this.f57231a);
                            if (applicationContext != null) {
                                LocalRouter.getInstance(applicationContext).route(this.f57231a, new RouterRequest().provider("langbrige").action("langbrige_initWebView"), new RouterCallback(this) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.5.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass5 f57233a;

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
                                        this.f57233a = this;
                                    }

                                    @Override // com.baidu.wallet.router.RouterCallback
                                    public void onResult(int i2, HashMap hashMap) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i2, hashMap) == null) {
                                            LogUtil.d(BaiduWalletDelegate.f57215b, "webview init finish");
                                        }
                                    }
                                });
                                return false;
                            }
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
                public final /* synthetic */ Context f57234a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BaiduWalletDelegate f57235b;

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
                    this.f57235b = this;
                    this.f57234a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && SafePay.getInstance().prepareCompleted()) {
                        BdWalletUtils.loadDeviceFP(DxmApplicationContextImpl.getApplicationContext(this.f57234a));
                        this.f57235b.a(this.f57234a);
                    }
                }
            }, "walletInit").start();
            this.f57218c = DxmApplicationContextImpl.getApplicationContext(context);
            PollInitUtils.getInstance().registerListener();
            ActLifecycleCbs.a().a((Application) DxmApplicationContextImpl.getApplicationContext(context));
            f57216d = true;
        }
    }

    public void openH5Module(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, context, bundle) == null) || bundle == null || !bundle.containsKey("url") || TextUtils.isEmpty(bundle.getString("url"))) {
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
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_start").data("url", string).data("title", string2).data("with_anim", Boolean.valueOf(z)).data("show_share", Boolean.valueOf(z2)).data("bundle", bundle), new RouterCallback(this) { // from class: com.baidu.wallet.api.BaiduWalletDelegate.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BaiduWalletDelegate f57220a;

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
                this.f57220a = this;
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
        if (interceptable == null || interceptable.invokeLL(1048593, this, context, str) == null) {
            openH5Module(context, str, true);
        }
    }
}
