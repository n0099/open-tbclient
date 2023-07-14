package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.helper.CommonOnClickKt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class u77 extends m77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public int e;
    public final m97 f;
    public final u87 g;
    public final Function2<u87, View, Unit> h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948163988, "Lcom/baidu/tieba/u77;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948163988, "Lcom/baidu/tieba/u77;");
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof u77) {
                u77 u77Var = (u77) obj;
                return Intrinsics.areEqual(this.d, u77Var.d) && this.e == u77Var.e && Intrinsics.areEqual(this.f, u77Var.f) && Intrinsics.areEqual(this.g, u77Var.g) && Intrinsics.areEqual(this.h, u77Var.h);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final u87 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.g : (u87) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String str = this.d;
            int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.e) * 31) + this.f.hashCode()) * 31;
            u87 u87Var = this.g;
            return ((hashCode + (u87Var != null ? u87Var.hashCode() : 0)) * 31) + this.h.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "RecommendCardUiState(mTitle=" + this.d + ", titleColorId=" + this.e + ", mNestedData=" + this.f + ", feedBackData=" + this.g + ", onFeedBackClick=" + this.h + ')';
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u77(String str, int i, m97 mNestedData, u87 u87Var, Function2<? super u87, ? super View, Unit> onFeedBackClick) {
        super(null, null, 3, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), mNestedData, u87Var, onFeedBackClick};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Function2) objArr2[0], (Function1) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mNestedData, "mNestedData");
        Intrinsics.checkNotNullParameter(onFeedBackClick, "onFeedBackClick");
        this.d = str;
        this.e = i;
        this.f = mNestedData;
        this.g = u87Var;
        this.h = onFeedBackClick;
    }

    public /* synthetic */ u77(String str, int i, m97 m97Var, u87 u87Var, Function2 function2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, m97Var, u87Var, (i2 & 16) != 0 ? CommonOnClickKt.a() : function2);
    }

    public final u87 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (u87) invokeV.objValue;
    }

    public final m97 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (m97) invokeV.objValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final Function2<u87, View, Unit> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (Function2) invokeV.objValue;
    }

    public final int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }
}
