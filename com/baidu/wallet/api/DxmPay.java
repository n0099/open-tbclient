package com.baidu.wallet.api;

import android.app.Application;
import android.content.Context;
import com.baidu.apollon.armor.SafePay;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.ReflectUtils;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterProvider;
import com.baidu.wallet.statistics.impl.SensorsSyncHttpImpl;
import com.baidu.wallet.statistics.impl.StatConfig;
/* loaded from: classes5.dex */
public class DxmPay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final DxmPay f23894a;
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
            f23894a = new DxmPay();
        }
    }

    private void a(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, application) == null) {
            Object providerObject = ReflectUtils.getProviderObject("com.baidu.wallet.paysdk.entrance.DxmPaySDKProvider");
            if (providerObject != null && (providerObject instanceof RouterProvider)) {
                LocalRouter.getInstance(application).registerProvider("dxmPay", (RouterProvider) providerObject);
            }
            Object providerObject2 = ReflectUtils.getProviderObject("com.baidu.wallet.bankdetection.entrance.BankCardDetectionProvider");
            if (providerObject2 == null || !(providerObject2 instanceof RouterProvider)) {
                return;
            }
            LocalRouter.getInstance(application).registerProvider("bankdetection", (RouterProvider) providerObject2);
        }
    }

    public static DxmPay getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f23894a : (DxmPay) invokeV.objValue;
    }

    public void initWallet(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            a((Application) context.getApplicationContext());
            new Thread(new Runnable(this, context) { // from class: com.baidu.wallet.api.DxmPay.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f23892a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ DxmPay f23893b;

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
                    this.f23893b = this;
                    this.f23892a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && SafePay.getInstance().prepareCompleted()) {
                        d.d.a.a.a.g(this.f23892a.getApplicationContext(), StatConfig.getInstance(this.f23892a.getApplicationContext()));
                        d.d.a.a.a.x(new SensorsSyncHttpImpl());
                    }
                }
            }, "DXMPaySDK").start();
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
}
