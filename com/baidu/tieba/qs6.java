package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class qs6 implements d97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wca a;
    public final View.OnClickListener b;
    public int c;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof qs6) {
                qs6 qs6Var = (qs6) obj;
                return Intrinsics.areEqual(this.a, qs6Var.a) && Intrinsics.areEqual(this.b, qs6Var.b);
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
            View.OnClickListener onClickListener = this.b;
            return hashCode + (onClickListener == null ? 0 : onClickListener.hashCode());
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "DelegateFunAdUiState(funAdData=" + this.a + ", feedbackClickListener=" + this.b + ')';
        }
        return (String) invokeV.objValue;
    }

    @JvmOverloads
    public qs6(wca funAdData, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdData, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(funAdData, "funAdData");
        this.a = funAdData;
        this.b = onClickListener;
    }

    public /* synthetic */ qs6(wca wcaVar, View.OnClickListener onClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(wcaVar, (i & 2) != 0 ? rs6.a : onClickListener);
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final View.OnClickListener b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public final wca c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (wca) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d97
    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.c = i;
        }
    }
}
