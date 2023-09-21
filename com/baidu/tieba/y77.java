package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.component.uistate.CardUiStateKt;
import com.baidu.tieba.feed.component.uistate.CardVirtualHeadUiStateKt;
import com.baidu.tieba.feed.helper.CommonOnClickKt;
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
public final class y77 implements yc7<y77> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final r87 a;
    public final d97 b;
    public final String c;
    public final String d;
    public final Function2<View, String, Unit> e;
    public final Function2<View, String, Boolean> f;
    public final Function2<d97, View, Unit> g;
    public final Function1<ea7, Unit> h;

    @Override // com.baidu.tieba.yc7
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "virtual_head" : (String) invokeV.objValue;
    }

    public y77 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (y77) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof y77) {
                y77 y77Var = (y77) obj;
                return Intrinsics.areEqual(this.a, y77Var.a) && Intrinsics.areEqual(this.b, y77Var.b) && Intrinsics.areEqual(this.c, y77Var.c) && Intrinsics.areEqual(this.d, y77Var.d) && Intrinsics.areEqual(this.e, y77Var.e) && Intrinsics.areEqual(this.f, y77Var.f) && Intrinsics.areEqual(this.g, y77Var.g) && Intrinsics.areEqual(this.h, y77Var.h);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int hashCode = this.a.hashCode() * 31;
            d97 d97Var = this.b;
            int hashCode2 = (hashCode + (d97Var == null ? 0 : d97Var.hashCode())) * 31;
            String str = this.c;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.d;
            return ((((((((hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return "CardVirtualHeadUiState(headData=" + this.a + ", feedBackData=" + this.b + ", schema=" + this.c + ", authorUserId=" + this.d + ", onItemClick=" + this.e + ", onImageClick=" + this.f + ", onFeedBackClick=" + this.g + ", onStat=" + this.h + ')';
        }
        return (String) invokeV.objValue;
    }

    @JvmOverloads
    public y77(r87 headData, d97 d97Var, String str, String str2, Function2<? super View, ? super String, Unit> onItemClick, Function2<? super View, ? super String, Boolean> onImageClick, Function2<? super d97, ? super View, Unit> onFeedBackClick, Function1<? super ea7, Unit> onStat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {headData, d97Var, str, str2, onItemClick, onImageClick, onFeedBackClick, onStat};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(headData, "headData");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(onImageClick, "onImageClick");
        Intrinsics.checkNotNullParameter(onFeedBackClick, "onFeedBackClick");
        Intrinsics.checkNotNullParameter(onStat, "onStat");
        this.a = headData;
        this.b = d97Var;
        this.c = str;
        this.d = str2;
        this.e = onItemClick;
        this.f = onImageClick;
        this.g = onFeedBackClick;
        this.h = onStat;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ y77(r87 r87Var, d97 d97Var, String str, String str2, Function2 function2, Function2 function22, Function2 function23, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r87Var, d97Var, str, str2, r7, r8, r9, r10);
        Function2<View, String, Unit> function24;
        Function2 function25;
        Function2<d97, View, Unit> function26;
        Function1<ea7, Unit> function12;
        Function2 function27;
        if ((i & 16) != 0) {
            function24 = CommonOnClickKt.b();
        } else {
            function24 = function2;
        }
        if ((i & 32) != 0) {
            function27 = CardVirtualHeadUiStateKt.a;
            function25 = function27;
        } else {
            function25 = function22;
        }
        if ((i & 64) != 0) {
            function26 = CommonOnClickKt.a();
        } else {
            function26 = function23;
        }
        if ((i & 128) != 0) {
            function12 = CardUiStateKt.b();
        } else {
            function12 = function1;
        }
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.yc7
    public /* bridge */ /* synthetic */ y77 b() {
        d();
        return this;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final d97 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (d97) invokeV.objValue;
    }

    public final r87 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return (r87) invokeV.objValue;
    }

    public final Function2<d97, View, Unit> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.g;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function2<View, String, Boolean> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function2<View, String, Unit> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.e;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function1<ea7, Unit> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.h;
        }
        return (Function1) invokeV.objValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }
}
