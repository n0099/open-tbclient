package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class xl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<rb7<?>> a;
    public bm7 b;
    public am7 c;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof xl7) {
                xl7 xl7Var = (xl7) obj;
                return Intrinsics.areEqual(this.a, xl7Var.a) && Intrinsics.areEqual(this.b, xl7Var.b) && Intrinsics.areEqual(this.c, xl7Var.c);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int hashCode = this.a.hashCode() * 31;
            bm7 bm7Var = this.b;
            int hashCode2 = (hashCode + (bm7Var == null ? 0 : bm7Var.hashCode())) * 31;
            am7 am7Var = this.c;
            return hashCode2 + (am7Var != null ? am7Var.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "ModelData(feedList=" + this.a + ", subTabData=" + this.b + ", sortTabData=" + this.c + ')';
        }
        return (String) invokeV.objValue;
    }

    public xl7(List<rb7<?>> feedList, bm7 bm7Var, am7 am7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedList, bm7Var, am7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(feedList, "feedList");
        this.a = feedList;
        this.b = bm7Var;
        this.c = am7Var;
    }

    public /* synthetic */ xl7(List list, bm7 bm7Var, am7 am7Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : bm7Var, (i & 4) != 0 ? null : am7Var);
    }

    public final List<rb7<?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public final am7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (am7) invokeV.objValue;
    }

    public final bm7 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (bm7) invokeV.objValue;
    }

    public final void d(am7 am7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, am7Var) == null) {
            this.c = am7Var;
        }
    }

    public final void e(bm7 bm7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bm7Var) == null) {
            this.b = bm7Var;
        }
    }
}
