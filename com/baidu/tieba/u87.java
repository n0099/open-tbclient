package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class u87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ? extends tc7> a;
    public final f87 b;
    public final m97 c;
    public Map<String, String> d;
    public boolean e;

    public u87() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.b = new f87();
        this.c = new m97();
        this.d = new HashMap();
    }

    public final f87 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (f87) invokeV.objValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public final m97 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (m97) invokeV.objValue;
    }

    public final Map<String, String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (Map) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.util.Map<java.lang.String, ? extends com.baidu.tieba.tc7>, java.util.Map<java.lang.String, com.baidu.tieba.tc7> */
    public final Map<String, tc7> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (Map) invokeV.objValue;
    }

    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.e = z;
        }
    }

    public final void g(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.d = map;
        }
    }

    public final void h(Map<String, ? extends tc7> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.a = map;
        }
    }
}
