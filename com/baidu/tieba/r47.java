package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.component.uistate.CardUiStateKt;
import com.baidu.tieba.feed.helper.CommonOnClickKt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class r47 extends h87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b57 c;
    public d67 d;
    public d67 e;
    public String f;
    public final fa7 g;
    public c67 h;
    public final Function1<c67, Unit> i;
    public final Function2<View, String, Unit> j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948071732, "Lcom/baidu/tieba/r47;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948071732, "Lcom/baidu/tieba/r47;");
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof r47) {
                r47 r47Var = (r47) obj;
                return Intrinsics.areEqual(this.c, r47Var.c) && Intrinsics.areEqual(this.d, r47Var.d) && Intrinsics.areEqual(this.e, r47Var.e) && Intrinsics.areEqual(this.f, r47Var.f) && Intrinsics.areEqual(this.g, r47Var.g) && Intrinsics.areEqual(this.h, r47Var.h) && Intrinsics.areEqual(this.i, r47Var.i) && Intrinsics.areEqual(this.j, r47Var.j);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int hashCode = this.c.hashCode() * 31;
            d67 d67Var = this.d;
            int hashCode2 = (hashCode + (d67Var == null ? 0 : d67Var.hashCode())) * 31;
            d67 d67Var2 = this.e;
            int hashCode3 = (hashCode2 + (d67Var2 == null ? 0 : d67Var2.hashCode())) * 31;
            String str = this.f;
            int hashCode4 = (((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.g.hashCode()) * 31;
            c67 c67Var = this.h;
            return ((((hashCode4 + (c67Var != null ? c67Var.hashCode() : 0)) * 31) + this.i.hashCode()) * 31) + this.j.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "RecommendPersonAttentionCardUiState(headData=" + this.c + ", userName=" + this.d + ", userDesc=" + this.e + ", schema=" + this.f + ", personAttentionUiState=" + this.g + ", statData=" + this.h + ", onStat=" + this.i + ", onItemClick=" + this.j + ')';
        }
        return (String) invokeV.objValue;
    }

    @JvmOverloads
    public r47(b57 headData, d67 d67Var, d67 d67Var2, String str, fa7 personAttentionUiState, c67 c67Var, Function1<? super c67, Unit> onStat, Function2<? super View, ? super String, Unit> onItemClick) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {headData, d67Var, d67Var2, str, personAttentionUiState, c67Var, onStat, onItemClick};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(headData, "headData");
        Intrinsics.checkNotNullParameter(personAttentionUiState, "personAttentionUiState");
        Intrinsics.checkNotNullParameter(onStat, "onStat");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.c = headData;
        this.d = d67Var;
        this.e = d67Var2;
        this.f = str;
        this.g = personAttentionUiState;
        this.h = c67Var;
        this.i = onStat;
        this.j = onItemClick;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ r47(b57 b57Var, d67 d67Var, d67 d67Var2, String str, fa7 fa7Var, c67 c67Var, Function1 function1, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(b57Var, r5, r6, r7, fa7Var, r9, r10, r11);
        d67 d67Var3;
        d67 d67Var4;
        String str2;
        c67 c67Var2;
        Function1<c67, Unit> function12;
        Function2<View, String, Unit> function22;
        if ((i & 2) != 0) {
            d67Var3 = null;
        } else {
            d67Var3 = d67Var;
        }
        if ((i & 4) != 0) {
            d67Var4 = null;
        } else {
            d67Var4 = d67Var2;
        }
        if ((i & 8) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i & 32) != 0) {
            c67Var2 = null;
        } else {
            c67Var2 = c67Var;
        }
        if ((i & 64) != 0) {
            function12 = CardUiStateKt.b();
        } else {
            function12 = function1;
        }
        if ((i & 128) != 0) {
            function22 = CommonOnClickKt.b();
        } else {
            function22 = function2;
        }
    }

    public final b57 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (b57) invokeV.objValue;
    }

    public final Function2<View, String, Unit> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.j;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function1<c67, Unit> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i;
        }
        return (Function1) invokeV.objValue;
    }

    public final fa7 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (fa7) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final c67 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return (c67) invokeV.objValue;
    }

    public final d67 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return (d67) invokeV.objValue;
    }

    public final d67 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (d67) invokeV.objValue;
    }
}
