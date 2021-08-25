package com.baidu.wallet.base.widget;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.passport.LoginBackListenerProxy;
/* loaded from: classes8.dex */
public class SDKJumpManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LoginBackListenerProxy f60407a;

    /* loaded from: classes8.dex */
    public interface OnJumpListener {
        void beforeJump(Context context, String str, String str2, String str3, boolean z);
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static SDKJumpManager f60412a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(914361540, "Lcom/baidu/wallet/base/widget/SDKJumpManager$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(914361540, "Lcom/baidu/wallet/base/widget/SDKJumpManager$a;");
                    return;
                }
            }
            f60412a = new SDKJumpManager();
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

    public static SDKJumpManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? a.f60412a : (SDKJumpManager) invokeV.objValue;
    }

    public void doSDKJump(Context context, String str, String str2, String str3, boolean z, OnJumpListener onJumpListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, str3, Boolean.valueOf(z), onJumpListener}) == null) {
            if (onJumpListener != null) {
                onJumpListener.beforeJump(context, str, str2, str3, z);
            }
            if ("3".equals(str2) && !TextUtils.isEmpty(str3)) {
                BaiduWalletServiceController.getInstance().gotoWalletService(context, str3, "");
            } else if ("1".equals(str2) && !TextUtils.isEmpty(str3)) {
                if (!NetworkUtils.isNetworkAvailable(context)) {
                    GlobalUtils.toast(context, ResUtils.getString(context, "ebpay_no_network"));
                } else if (z) {
                    this.f60407a = new LoginBackListenerProxy(context, new ILoginBackListener(this, context, str3) { // from class: com.baidu.wallet.base.widget.SDKJumpManager.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Context f60408a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f60409b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ SDKJumpManager f60410c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, context, str3};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f60410c = this;
                            this.f60408a = context;
                            this.f60409b = str3;
                        }

                        @Override // com.baidu.wallet.api.ILoginBackListener
                        public void onFail(int i2, String str4) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str4) == null) {
                                if (i2 == 603) {
                                    WalletLoginHelper.getInstance().onlyLogin(this.f60410c.f60407a);
                                }
                                this.f60410c.f60407a = null;
                            }
                        }

                        @Override // com.baidu.wallet.api.ILoginBackListener
                        public void onSuccess(int i2, String str4) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str4) == null) {
                                BaiduWalletDelegate.getInstance().openH5Module(this.f60408a, this.f60409b, true);
                                this.f60410c.f60407a = null;
                            }
                        }
                    });
                    WalletLoginHelper.getInstance().login(this.f60407a);
                } else {
                    BaiduWalletDelegate.getInstance().openH5Module(context, str3, true);
                }
            } else if ("2".equals(str2) && !TextUtils.isEmpty(str3)) {
                if (!NetworkUtils.isNetworkAvailable(context)) {
                    GlobalUtils.toast(context, ResUtils.getString(context, "ebpay_no_network"));
                } else {
                    WalletLoginHelper.getInstance().startPage(str3);
                }
            } else if ("4".equals(str2) && !TextUtils.isEmpty(str3)) {
                BaiduWalletDelegate.getInstance().invokeHostNative(str3, "");
            } else if ("5".equals(str2)) {
                this.f60407a = new LoginBackListenerProxy(context, new ILoginBackListener(this) { // from class: com.baidu.wallet.base.widget.SDKJumpManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SDKJumpManager f60411a;

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
                        this.f60411a = this;
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onFail(int i2, String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str4) == null) {
                            if (i2 == 603) {
                                WalletLoginHelper.getInstance().onlyLogin(this.f60411a.f60407a);
                            }
                            this.f60411a.f60407a = null;
                        }
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onSuccess(int i2, String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str4) == null) {
                            this.f60411a.f60407a = null;
                        }
                    }
                });
                WalletLoginHelper.getInstance().login(this.f60407a);
            } else if (!"6".equals(str2) || a(context, str3)) {
            } else {
                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_string_service_forbidden"));
            }
        }
    }

    public SDKJumpManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
