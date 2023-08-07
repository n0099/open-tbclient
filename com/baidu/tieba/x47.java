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
public final class x47 implements u97<x47> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final q57 a;
    public final c67 b;
    public final String c;
    public final String d;
    public final Function2<View, String, Unit> e;
    public final Function2<View, String, Boolean> f;
    public final Function2<c67, View, Unit> g;
    public final Function1<c77, Unit> h;

    @Override // com.baidu.tieba.u97
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "virtual_head" : (String) invokeV.objValue;
    }

    public x47 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (x47) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof x47) {
                x47 x47Var = (x47) obj;
                return Intrinsics.areEqual(this.a, x47Var.a) && Intrinsics.areEqual(this.b, x47Var.b) && Intrinsics.areEqual(this.c, x47Var.c) && Intrinsics.areEqual(this.d, x47Var.d) && Intrinsics.areEqual(this.e, x47Var.e) && Intrinsics.areEqual(this.f, x47Var.f) && Intrinsics.areEqual(this.g, x47Var.g) && Intrinsics.areEqual(this.h, x47Var.h);
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
            c67 c67Var = this.b;
            int hashCode2 = (hashCode + (c67Var == null ? 0 : c67Var.hashCode())) * 31;
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
    public x47(q57 headData, c67 c67Var, String str, String str2, Function2<? super View, ? super String, Unit> onItemClick, Function2<? super View, ? super String, Boolean> onImageClick, Function2<? super c67, ? super View, Unit> onFeedBackClick, Function1<? super c77, Unit> onStat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {headData, c67Var, str, str2, onItemClick, onImageClick, onFeedBackClick, onStat};
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
        this.b = c67Var;
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
    public /* synthetic */ x47(q57 q57Var, c67 c67Var, String str, String str2, Function2 function2, Function2 function22, Function2 function23, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(q57Var, c67Var, str, str2, r7, r8, r9, r10);
        Function2<View, String, Unit> function24;
        Function2 function25;
        Function2<c67, View, Unit> function26;
        Function1<c77, Unit> function12;
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
    @Override // com.baidu.tieba.u97
    public /* bridge */ /* synthetic */ x47 b() {
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

    public final c67 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (c67) invokeV.objValue;
    }

    public final q57 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return (q57) invokeV.objValue;
    }

    public final Function2<c67, View, Unit> g() {
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

    public final Function1<c77, Unit> j() {
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
