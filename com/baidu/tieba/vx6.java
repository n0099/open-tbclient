package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.l0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class vx6 {
    public static /* synthetic */ Interceptable $ic;
    public static final vx6 a;
    public static final l0 b;
    public static final Class<? extends xv6>[] c;
    public static final l0 d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948256213, "Lcom/baidu/tieba/vx6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948256213, "Lcom/baidu/tieba/vx6;");
                return;
            }
        }
        a = new vx6();
        l0 b2 = l0.d(cw6.class).b();
        Intrinsics.checkNotNullExpressionValue(b2, "all(ItemDataComponent::class.java).get()");
        b = b2;
        c = new Class[]{cw6.class, bw6.class};
        l0.b d2 = l0.d(cw6.class, bw6.class);
        d2.c(dw6.class, fw6.class);
        l0 b3 = d2.b();
        Intrinsics.checkNotNullExpressionValue(b3, "all(\n        ItemDataCom…t::class.java\n    ).get()");
        d = b3;
    }

    public vx6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final l0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return b;
        }
        return (l0) invokeV.objValue;
    }

    public final Class<? extends xv6>[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return c;
        }
        return (Class[]) invokeV.objValue;
    }

    public final l0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return d;
        }
        return (l0) invokeV.objValue;
    }
}
