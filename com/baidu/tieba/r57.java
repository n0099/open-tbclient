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
/* loaded from: classes7.dex */
public final class r57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final s57 a;
    public final List<w57> b;
    public final List<w57> c;
    public final VirtualImageCustomState d;
    public final d77 e;
    public final d77 f;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof r57) {
                r57 r57Var = (r57) obj;
                return Intrinsics.areEqual(this.a, r57Var.a) && Intrinsics.areEqual(this.b, r57Var.b) && Intrinsics.areEqual(this.c, r57Var.c) && Intrinsics.areEqual(this.d, r57Var.d) && Intrinsics.areEqual(this.e, r57Var.e) && Intrinsics.areEqual(this.f, r57Var.f);
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
            d77 d77Var = this.e;
            int hashCode3 = (hashCode2 + (d77Var == null ? 0 : d77Var.hashCode())) * 31;
            d77 d77Var2 = this.f;
            return hashCode3 + (d77Var2 != null ? d77Var2.hashCode() : 0);
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

    public r57(s57 imageData, List<? extends w57> mainData, List<? extends w57> extraData, VirtualImageCustomState virtualImageCustomState, d77 d77Var, d77 d77Var2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageData, mainData, extraData, virtualImageCustomState, d77Var, d77Var2};
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
        this.e = d77Var;
        this.f = d77Var2;
    }

    public final d77 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (d77) invokeV.objValue;
    }

    public final List<w57> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public final s57 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (s57) invokeV.objValue;
    }

    public final List<w57> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final d77 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (d77) invokeV.objValue;
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
