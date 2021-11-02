package com.baidu.wallet.api;

import android.app.Application;
import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterProvider;
import com.dxmpay.wallet.core.utils.ReflectUtils;
/* loaded from: classes10.dex */
public class DxmPay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.api.DxmPay$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final DxmPay f57241a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-330812462, "Lcom/baidu/wallet/api/DxmPay$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-330812462, "Lcom/baidu/wallet/api/DxmPay$a;");
                    return;
                }
            }
            f57241a = new DxmPay(null);
        }
    }

    public /* synthetic */ DxmPay(AnonymousClass1 anonymousClass1) {
        this();
    }

    private void a(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, application) == null) {
            Object providerObject = ReflectUtils.getProviderObject("com.baidu.wallet.paysdk.entrance.DxmPaySDKProvider");
            if (providerObject != null && (providerObject instanceof RouterProvider)) {
                LocalRouter.getInstance(application).registerProvider("dxmPay", (RouterProvider) providerObject);
            }
            Object providerObject2 = ReflectUtils.getProviderObject("com.dxmpay.wallet.router.DxmPayServiceSDKProvider");
            if (providerObject2 != null && (providerObject2 instanceof RouterProvider)) {
                LocalRouter.getInstance(application).registerProvider("dxmPayService", (RouterProvider) providerObject2);
            }
            Object providerObject3 = ReflectUtils.getProviderObject("com.baidu.wallet.bankdetection.entrance.BankCardDetectionProvider");
            if (providerObject3 == null || !(providerObject3 instanceof RouterProvider)) {
                return;
            }
            LocalRouter.getInstance(application).registerProvider("bankdetection", (RouterProvider) providerObject3);
        }
    }

    public static DxmPay getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f57241a : (DxmPay) invokeV.objValue;
    }

    public void initWallet(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            a((Application) context.getApplicationContext());
            com.dxmpay.wallet.api.BaiduWalletDelegate.getInstance().initWallet(context);
        }
    }

    public DxmPay() {
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

    public void initWallet(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
            a((Application) context.getApplicationContext());
            com.dxmpay.wallet.api.BaiduWalletDelegate.getInstance().initWallet(context, str);
        }
    }

    public void initWallet(IWalletListener iWalletListener, Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, iWalletListener, context, str) == null) {
            a((Application) context.getApplicationContext());
            com.dxmpay.wallet.api.BaiduWalletDelegate.getInstance().initWallet(iWalletListener, context, str);
        }
    }

    public void initWallet(IWalletListener iWalletListener, Context context, String str, ISecurityListener iSecurityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, iWalletListener, context, str, iSecurityListener) == null) {
            a((Application) context.getApplicationContext());
            com.dxmpay.wallet.api.BaiduWalletDelegate.getInstance().initWallet(iWalletListener, context, str, iSecurityListener);
        }
    }
}
