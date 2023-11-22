package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class wu {
    public static /* synthetic */ Interceptable $ic = null;
    public static int b = 5;
    public static int c = 40;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.cesium.a.b a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448321167, "Lcom/baidu/tieba/wu;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448321167, "Lcom/baidu/tieba/wu;");
        }
    }

    public wu() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        com.baidu.cesium.a.b bVar = new com.baidu.cesium.a.b(c);
        this.a = bVar;
        bVar.a(0, c, true);
    }

    public void a(com.baidu.cesium.a.b bVar, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, bVar, i, i2, i3) == null) {
            com.baidu.cesium.a.b d = this.a.d(i, i + i2);
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        d.e(bVar);
                    } else if (i3 == 3) {
                        d.c(bVar);
                    }
                }
                d.d(bVar);
            } else {
                d.b(bVar);
            }
            for (int i4 = 0; i4 < i2; i4++) {
                this.a.a(i + i4, d.d(i4));
            }
        }
    }

    public byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.a() : (byte[]) invokeV.objValue;
    }
}
