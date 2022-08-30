package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes6.dex */
public final class yt extends cr implements au {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final as d;
    public final cs e;
    public final gs f;
    public final js g;
    public final es h;
    public final zr i;
    public final fs j;
    public final bu k;
    public final ju l;

    public /* synthetic */ yt(as asVar, cs csVar, gs gsVar, js jsVar, es esVar, zr zrVar, fs fsVar, bu buVar, ju juVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(asVar, csVar, gsVar, jsVar, esVar, zrVar, fsVar, (i & 128) != 0 ? new cu() : buVar, (i & 256) != 0 ? new lu() : juVar);
    }

    @Override // com.baidu.tieba.br
    public fs a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (fs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.br
    public gs b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (gs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.br
    public zr c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i : (zr) invokeV.objValue;
    }

    @Override // com.baidu.tieba.au
    public bu d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (bu) invokeV.objValue;
    }

    @Override // com.baidu.tieba.br
    public js e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (js) invokeV.objValue;
    }

    @Override // com.baidu.tieba.au
    public ju f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : (ju) invokeV.objValue;
    }

    @Override // com.baidu.tieba.br
    public cs g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (cs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.br
    public as h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (as) invokeV.objValue;
    }

    @Override // com.baidu.tieba.br
    public es i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h : (es) invokeV.objValue;
    }

    public yt(as asVar, cs csVar, gs gsVar, js jsVar, es esVar, zr zrVar, fs fsVar, bu buVar, ju juVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {asVar, csVar, gsVar, jsVar, esVar, zrVar, fsVar, buVar, juVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = asVar;
        this.e = csVar;
        this.f = gsVar;
        this.g = jsVar;
        this.h = esVar;
        this.i = zrVar;
        this.j = fsVar;
        this.k = buVar;
        this.l = juVar;
    }
}
