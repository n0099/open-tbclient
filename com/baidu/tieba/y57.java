package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.VirtualImageCustomState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class y57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final z57 a;
    public final List<h67> b;
    public final List<h67> c;
    public final VirtualImageCustomState d;
    public final a87 e;
    public final a87 f;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof y57) {
                y57 y57Var = (y57) obj;
                return Intrinsics.areEqual(this.a, y57Var.a) && Intrinsics.areEqual(this.b, y57Var.b) && Intrinsics.areEqual(this.c, y57Var.c) && Intrinsics.areEqual(this.d, y57Var.d) && Intrinsics.areEqual(this.e, y57Var.e) && Intrinsics.areEqual(this.f, y57Var.f);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            VirtualImageCustomState virtualImageCustomState = this.d;
            int hashCode2 = (hashCode + (virtualImageCustomState == null ? 0 : virtualImageCustomState.hashCode())) * 31;
            a87 a87Var = this.e;
            int hashCode3 = (hashCode2 + (a87Var == null ? 0 : a87Var.hashCode())) * 31;
            a87 a87Var2 = this.f;
            return hashCode3 + (a87Var2 != null ? a87Var2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "CardVirtualHeadData(imageData=" + this.a + ", mainData=" + this.b + ", extraData=" + this.c + ", stateData=" + this.d + ", showStatData=" + this.e + ", clickStatData=" + this.f + ')';
        }
        return (String) invokeV.objValue;
    }

    public y57(z57 imageData, List<? extends h67> mainData, List<? extends h67> extraData, VirtualImageCustomState virtualImageCustomState, a87 a87Var, a87 a87Var2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageData, mainData, extraData, virtualImageCustomState, a87Var, a87Var2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(imageData, "imageData");
        Intrinsics.checkNotNullParameter(mainData, "mainData");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        this.a = imageData;
        this.b = mainData;
        this.c = extraData;
        this.d = virtualImageCustomState;
        this.e = a87Var;
        this.f = a87Var2;
    }

    public final a87 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (a87) invokeV.objValue;
    }

    public final List<h67> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public final z57 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (z57) invokeV.objValue;
    }

    public final List<h67> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final a87 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (a87) invokeV.objValue;
    }

    public final VirtualImageCustomState f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (VirtualImageCustomState) invokeV.objValue;
    }
}
