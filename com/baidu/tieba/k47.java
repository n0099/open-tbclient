package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes6.dex */
public final class k47 extends s47 implements o87<k47> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f57 b;
    public final s57 c;
    public final String d;
    public final Function2<View, String, Unit> e;
    public final Function2<View, String, Unit> f;
    public final Function2<s57, View, Unit> g;

    @Override // com.baidu.tieba.o87
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "feed_head" : (String) invokeV.objValue;
    }

    public k47 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (k47) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof k47) {
                k47 k47Var = (k47) obj;
                return Intrinsics.areEqual(this.b, k47Var.b) && Intrinsics.areEqual(this.c, k47Var.c) && Intrinsics.areEqual(this.d, k47Var.d) && Intrinsics.areEqual(this.e, k47Var.e) && Intrinsics.areEqual(this.f, k47Var.f) && Intrinsics.areEqual(this.g, k47Var.g);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int hashCode = this.b.hashCode() * 31;
            s57 s57Var = this.c;
            int hashCode2 = (hashCode + (s57Var == null ? 0 : s57Var.hashCode())) * 31;
            String str = this.d;
            return ((((((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return "CardHeadUiState(headData=" + this.b + ", feedBackData=" + this.c + ", schema=" + this.d + ", onItemClick=" + this.e + ", onImageClick=" + this.f + ", onFeedBackClick=" + this.g + ')';
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public k47(f57 headData, s57 s57Var, String str, Function2<? super View, ? super String, Unit> onItemClick, Function2<? super View, ? super String, Unit> onImageClick, Function2<? super s57, ? super View, Unit> onFeedBackClick) {
        super(null, null, 3, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {headData, s57Var, str, onItemClick, onImageClick, onFeedBackClick};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Function2) objArr2[0], (Function1) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(headData, "headData");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(onImageClick, "onImageClick");
        Intrinsics.checkNotNullParameter(onFeedBackClick, "onFeedBackClick");
        this.b = headData;
        this.c = s57Var;
        this.d = str;
        this.e = onItemClick;
        this.f = onImageClick;
        this.g = onFeedBackClick;
    }

    public /* synthetic */ k47(f57 f57Var, s57 s57Var, String str, Function2 function2, Function2 function22, Function2 function23, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f57Var, s57Var, str, (i & 8) != 0 ? CommonOnClickKt.b() : function2, (i & 16) != 0 ? CommonOnClickKt.b() : function22, (i & 32) != 0 ? CommonOnClickKt.a() : function23);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.o87
    public /* bridge */ /* synthetic */ k47 b() {
        d();
        return this;
    }

    public final s57 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (s57) invokeV.objValue;
    }

    public final f57 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (f57) invokeV.objValue;
    }

    public final Function2<s57, View, Unit> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function2<View, String, Unit> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function2<View, String, Unit> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e;
        }
        return (Function2) invokeV.objValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }
}
