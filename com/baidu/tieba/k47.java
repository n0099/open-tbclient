package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.component.uistate.CardVirtualHeadUiStateKt;
import com.baidu.tieba.feed.helper.CommonOnClickKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class k47 extends h47 implements za7<k47> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final k57 g;
    public final b67 h;
    public final String i;
    public final String j;
    public final Map<String, String> k;
    public final Map<String, String> l;
    public final boolean m;
    public final Function3<View, String, k47, Boolean> n;
    public final Function3<View, t57, k47, Unit> o;
    public final Function2<b67, View, Unit> p;

    @Override // com.baidu.tieba.za7
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "virtual_head" : (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof k47) {
                k47 k47Var = (k47) obj;
                return Intrinsics.areEqual(this.g, k47Var.g) && Intrinsics.areEqual(this.h, k47Var.h) && Intrinsics.areEqual(this.i, k47Var.i) && Intrinsics.areEqual(this.j, k47Var.j) && Intrinsics.areEqual(this.k, k47Var.k) && Intrinsics.areEqual(this.l, k47Var.l) && this.m == k47Var.m && Intrinsics.areEqual(this.n, k47Var.n) && Intrinsics.areEqual(this.o, k47Var.o) && Intrinsics.areEqual(this.p, k47Var.p);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int hashCode = this.g.hashCode() * 31;
            b67 b67Var = this.h;
            int hashCode2 = (hashCode + (b67Var == null ? 0 : b67Var.hashCode())) * 31;
            String str = this.i;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.j;
            int hashCode4 = (((((hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31;
            boolean z = this.m;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return ((((((hashCode4 + i) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + this.p.hashCode();
        }
        return invokeV.intValue;
    }

    public k47 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (k47) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return "CardVirtualHeadUiState(headData=" + this.g + ", feedBackData=" + this.h + ", schema=" + this.i + ", authorUserId=" + this.j + ", businessInfoMap=" + this.k + ", logInfoMap=" + this.l + ", hasThemeCard=" + this.m + ", onImageClick=" + this.n + ", onTagClick=" + this.o + ", onFeedBackClick=" + this.p + ')';
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public k47(k57 headData, b67 b67Var, String str, String str2, Map<String, String> businessInfoMap, Map<String, String> logInfoMap, boolean z, Function3<? super View, ? super String, ? super k47, Boolean> onImageClick, Function3<? super View, ? super t57, ? super k47, Unit> onTagClick, Function2<? super b67, ? super View, Unit> onFeedBackClick) {
        super(businessInfoMap, logInfoMap, null, null, 12, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {headData, b67Var, str, str2, businessInfoMap, logInfoMap, Boolean.valueOf(z), onImageClick, onTagClick, onFeedBackClick};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Map) objArr2[0], (Map) objArr2[1], (Function2) objArr2[2], (Function1) objArr2[3], ((Integer) objArr2[4]).intValue(), (DefaultConstructorMarker) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(headData, "headData");
        Intrinsics.checkNotNullParameter(businessInfoMap, "businessInfoMap");
        Intrinsics.checkNotNullParameter(logInfoMap, "logInfoMap");
        Intrinsics.checkNotNullParameter(onImageClick, "onImageClick");
        Intrinsics.checkNotNullParameter(onTagClick, "onTagClick");
        Intrinsics.checkNotNullParameter(onFeedBackClick, "onFeedBackClick");
        this.g = headData;
        this.h = b67Var;
        this.i = str;
        this.j = str2;
        this.k = businessInfoMap;
        this.l = logInfoMap;
        this.m = z;
        this.n = onImageClick;
        this.o = onTagClick;
        this.p = onFeedBackClick;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ k47(k57 k57Var, b67 b67Var, String str, String str2, Map map, Map map2, boolean z, Function3 function3, Function3 function32, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(k57Var, b67Var, str, str2, map, map2, z, r10, r11, r12);
        Function3 function33;
        Function3 function34;
        Function2<b67, View, Unit> function22;
        Function3 function35;
        Function3 function36;
        if ((i & 128) != 0) {
            function36 = CardVirtualHeadUiStateKt.a;
            function33 = function36;
        } else {
            function33 = function3;
        }
        if ((i & 256) != 0) {
            function35 = CardVirtualHeadUiStateKt.b;
            function34 = function35;
        } else {
            function34 = function32;
        }
        if ((i & 512) != 0) {
            function22 = CommonOnClickKt.a();
        } else {
            function22 = function2;
        }
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.za7
    public /* bridge */ /* synthetic */ k47 b() {
        m();
        return this;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public final b67 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (b67) invokeV.objValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public final k57 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return (k57) invokeV.objValue;
    }

    public final Function2<b67, View, Unit> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.p;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function3<View, String, k47, Boolean> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.n;
        }
        return (Function3) invokeV.objValue;
    }

    public final Function3<View, t57, k47, Unit> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.o;
        }
        return (Function3) invokeV.objValue;
    }

    public final String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }
}
