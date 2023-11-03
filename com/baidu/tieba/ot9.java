package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class ot9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final pt9 a;
    public final pt9 b;
    public final pt9 c;
    public final pt9 d;
    public final pt9 e;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ot9) {
                ot9 ot9Var = (ot9) obj;
                return Intrinsics.areEqual(this.a, ot9Var.a) && Intrinsics.areEqual(this.b, ot9Var.b) && Intrinsics.areEqual(this.c, ot9Var.c) && Intrinsics.areEqual(this.d, ot9Var.d) && Intrinsics.areEqual(this.e, ot9Var.e);
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

    public ot9(pt9 selectPositive, pt9 selectingPositive, pt9 selectNegative, pt9 unselectPositive, pt9 unselectNegative) {
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

    public final pt9 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (pt9) invokeV.objValue;
    }

    public final pt9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (pt9) invokeV.objValue;
    }

    public final pt9 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (pt9) invokeV.objValue;
    }

    public final pt9 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (pt9) invokeV.objValue;
    }

    public final pt9 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (pt9) invokeV.objValue;
    }
}
