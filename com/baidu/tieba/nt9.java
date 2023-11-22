package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pb.feedback.FeedbackButtonStateType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class nt9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vra a;
    public final Function1<FeedbackButtonStateType, Unit> b;
    public final Function0<Boolean> c;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof nt9) {
                nt9 nt9Var = (nt9) obj;
                return Intrinsics.areEqual(this.a, nt9Var.a) && Intrinsics.areEqual(this.b, nt9Var.b) && Intrinsics.areEqual(this.c, nt9Var.c);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int hashCode = this.a.hashCode() * 31;
            Function1<FeedbackButtonStateType, Unit> function1 = this.b;
            int hashCode2 = (hashCode + (function1 == null ? 0 : function1.hashCode())) * 31;
            Function0<Boolean> function0 = this.c;
            return hashCode2 + (function0 != null ? function0.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "AigcFeedbackPostState(postData=" + this.a + ", onButtonClick=" + this.b + ", onInterceptClick=" + this.c + ')';
        }
        return (String) invokeV.objValue;
    }

    public nt9(vra postData, Function1<? super FeedbackButtonStateType, Unit> function1, Function0<Boolean> function0) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {postData, function1, function0};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(postData, "postData");
        this.a = postData;
        this.b = function1;
        this.c = function0;
    }

    public final Function1<FeedbackButtonStateType, Unit> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (Function1) invokeV.objValue;
    }

    public final Function0<Boolean> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (Function0) invokeV.objValue;
    }

    public final vra c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (vra) invokeV.objValue;
    }
}
