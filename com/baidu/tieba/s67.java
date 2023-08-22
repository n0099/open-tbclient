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
/* loaded from: classes8.dex */
public final class s67 extends hb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d77 c;
    public t87 d;
    public t87 e;
    public String f;
    public final sd7 g;
    public r87 h;
    public final Function1<r87, Unit> i;
    public final Function2<View, String, Unit> j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948103445, "Lcom/baidu/tieba/s67;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948103445, "Lcom/baidu/tieba/s67;");
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof s67) {
                s67 s67Var = (s67) obj;
                return Intrinsics.areEqual(this.c, s67Var.c) && Intrinsics.areEqual(this.d, s67Var.d) && Intrinsics.areEqual(this.e, s67Var.e) && Intrinsics.areEqual(this.f, s67Var.f) && Intrinsics.areEqual(this.g, s67Var.g) && Intrinsics.areEqual(this.h, s67Var.h) && Intrinsics.areEqual(this.i, s67Var.i) && Intrinsics.areEqual(this.j, s67Var.j);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int hashCode = this.c.hashCode() * 31;
            t87 t87Var = this.d;
            int hashCode2 = (hashCode + (t87Var == null ? 0 : t87Var.hashCode())) * 31;
            t87 t87Var2 = this.e;
            int hashCode3 = (hashCode2 + (t87Var2 == null ? 0 : t87Var2.hashCode())) * 31;
            String str = this.f;
            int hashCode4 = (((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.g.hashCode()) * 31;
            r87 r87Var = this.h;
            return ((((hashCode4 + (r87Var != null ? r87Var.hashCode() : 0)) * 31) + this.i.hashCode()) * 31) + this.j.hashCode();
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
    public s67(d77 headData, t87 t87Var, t87 t87Var2, String str, sd7 personAttentionUiState, r87 r87Var, Function1<? super r87, Unit> onStat, Function2<? super View, ? super String, Unit> onItemClick) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {headData, t87Var, t87Var2, str, personAttentionUiState, r87Var, onStat, onItemClick};
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
        this.d = t87Var;
        this.e = t87Var2;
        this.f = str;
        this.g = personAttentionUiState;
        this.h = r87Var;
        this.i = onStat;
        this.j = onItemClick;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ s67(d77 d77Var, t87 t87Var, t87 t87Var2, String str, sd7 sd7Var, r87 r87Var, Function1 function1, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d77Var, r5, r6, r7, sd7Var, r9, r10, r11);
        t87 t87Var3;
        t87 t87Var4;
        String str2;
        r87 r87Var2;
        Function1<r87, Unit> function12;
        Function2<View, String, Unit> function22;
        if ((i & 2) != 0) {
            t87Var3 = null;
        } else {
            t87Var3 = t87Var;
        }
        if ((i & 4) != 0) {
            t87Var4 = null;
        } else {
            t87Var4 = t87Var2;
        }
        if ((i & 8) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i & 32) != 0) {
            r87Var2 = null;
        } else {
            r87Var2 = r87Var;
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

    public final d77 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (d77) invokeV.objValue;
    }

    public final Function2<View, String, Unit> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function1<r87, Unit> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i;
        }
        return (Function1) invokeV.objValue;
    }

    public final sd7 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (sd7) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final r87 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return (r87) invokeV.objValue;
    }

    public final t87 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return (t87) invokeV.objValue;
    }

    public final t87 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (t87) invokeV.objValue;
    }
}
