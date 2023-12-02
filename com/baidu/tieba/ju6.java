package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class ju6 {
    public static /* synthetic */ Interceptable $ic;
    public static final ju6 a;
    public static final b1 b;
    public static final Class<? extends ls6>[] c;
    public static final b1 d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947895838, "Lcom/baidu/tieba/ju6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947895838, "Lcom/baidu/tieba/ju6;");
                return;
            }
        }
        a = new ju6();
        b1 b2 = b1.d(qs6.class).b();
        Intrinsics.checkNotNullExpressionValue(b2, "all(ItemDataComponent::class.java).get()");
        b = b2;
        c = new Class[]{qs6.class, ps6.class};
        b1.b d2 = b1.d(qs6.class, ps6.class);
        d2.c(rs6.class, ts6.class);
        b1 b3 = d2.b();
        Intrinsics.checkNotNullExpressionValue(b3, "all(\n        ItemDataCom…t::class.java\n    ).get()");
        d = b3;
    }

    public ju6() {
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

    public final b1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return b;
        }
        return (b1) invokeV.objValue;
    }

    public final Class<? extends ls6>[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return c;
        }
        return (Class[]) invokeV.objValue;
    }

    public final b1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return d;
        }
        return (b1) invokeV.objValue;
    }
}
