package com.baidu.wallet.paysdk.fingerprint.entrance;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.router.RouterCallback;
/* loaded from: classes12.dex */
public class DxmCheckFingerprint {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.paysdk.fingerprint.entrance.DxmCheckFingerprint$1  reason: invalid class name */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes12.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static DxmCheckFingerprint a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1259012290, "Lcom/baidu/wallet/paysdk/fingerprint/entrance/DxmCheckFingerprint$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1259012290, "Lcom/baidu/wallet/paysdk/fingerprint/entrance/DxmCheckFingerprint$a;");
                    return;
                }
            }
            a = new DxmCheckFingerprint(null);
        }
    }

    public /* synthetic */ DxmCheckFingerprint(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static DxmCheckFingerprint getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (DxmCheckFingerprint) invokeV.objValue;
    }

    public void startCherkFingerprint(Context context, String str, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, str, routerCallback) == null) {
            if (context != null && routerCallback != null) {
                com.baidu.wallet.paysdk.fingerprint.a.a.a().a(context, str, routerCallback);
                return;
            }
            throw new IllegalArgumentException(DxmCheckFingerprint.class.getSimpleName() + " please check params");
        }
    }

    public DxmCheckFingerprint() {
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
