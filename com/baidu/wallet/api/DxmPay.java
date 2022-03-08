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
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterProvider;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.wallet.core.utils.ReflectUtils;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class DxmPay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final DxmPay a;
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
            a = new DxmPay();
        }
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
            LocalRouter.getInstance(application).route(application, new RouterRequest().provider("bankdetection").action("initbankcarddetction"), new RouterCallback(this) { // from class: com.baidu.wallet.api.DxmPay.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DxmPay a;

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
                    this.a = this;
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

    public static DxmPay getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.a : (DxmPay) invokeV.objValue;
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
