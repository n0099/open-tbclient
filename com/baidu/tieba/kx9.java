package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class kx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final lx9 a;
    public final lx9 b;
    public final lx9 c;
    public final lx9 d;
    public final lx9 e;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof kx9) {
                kx9 kx9Var = (kx9) obj;
                return Intrinsics.areEqual(this.a, kx9Var.a) && Intrinsics.areEqual(this.b, kx9Var.b) && Intrinsics.areEqual(this.c, kx9Var.c) && Intrinsics.areEqual(this.d, kx9Var.d) && Intrinsics.areEqual(this.e, kx9Var.e);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "AigcFeedbackTypesState(selectPositive=" + this.a + ", selectingPositive=" + this.b + ", selectNegative=" + this.c + ", unselectPositive=" + this.d + ", unselectNegative=" + this.e + ')';
        }
        return (String) invokeV.objValue;
    }

    public kx9(lx9 selectPositive, lx9 selectingPositive, lx9 selectNegative, lx9 unselectPositive, lx9 unselectNegative) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {selectPositive, selectingPositive, selectNegative, unselectPositive, unselectNegative};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(selectPositive, "selectPositive");
        Intrinsics.checkNotNullParameter(selectingPositive, "selectingPositive");
        Intrinsics.checkNotNullParameter(selectNegative, "selectNegative");
        Intrinsics.checkNotNullParameter(unselectPositive, "unselectPositive");
        Intrinsics.checkNotNullParameter(unselectNegative, "unselectNegative");
        this.a = selectPositive;
        this.b = selectingPositive;
        this.c = selectNegative;
        this.d = unselectPositive;
        this.e = unselectNegative;
    }

    public final lx9 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (lx9) invokeV.objValue;
    }

    public final lx9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (lx9) invokeV.objValue;
    }

    public final lx9 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (lx9) invokeV.objValue;
    }

    public final lx9 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (lx9) invokeV.objValue;
    }

    public final lx9 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (lx9) invokeV.objValue;
    }
}
