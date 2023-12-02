package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class ui7 extends si7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ri7 c;
    public List<Long> d;
    public oi7 e;
    public bj7 f;

    public ui7() {
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
        this.c = new ri7(0L, null, null, null, null, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, 0, null, 524287, null);
        this.d = CollectionsKt__CollectionsKt.emptyList();
        this.e = new oi7();
    }

    public final oi7 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (oi7) invokeV.objValue;
    }

    public final ri7 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (ri7) invokeV.objValue;
    }

    public final List<Long> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    public final bj7 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (bj7) invokeV.objValue;
    }

    public final void k(oi7 oi7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, oi7Var) == null) {
            Intrinsics.checkNotNullParameter(oi7Var, "<set-?>");
            this.e = oi7Var;
        }
    }

    public final void l(ri7 ri7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ri7Var) == null) {
            Intrinsics.checkNotNullParameter(ri7Var, "<set-?>");
            this.c = ri7Var;
        }
    }

    public final void m(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.d = list;
        }
    }

    public final void n(bj7 bj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bj7Var) == null) {
            this.f = bj7Var;
        }
    }
}
