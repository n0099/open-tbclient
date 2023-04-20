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
public final class wt extends ar implements yt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yr d;
    public final as e;
    public final es f;
    public final hs g;
    public final cs h;
    public final xr i;
    public final ds j;
    public final zt k;
    public final hu l;

    public wt(yr yrVar, as asVar, es esVar, hs hsVar, cs csVar, xr xrVar, ds dsVar, zt ztVar, hu huVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yrVar, asVar, esVar, hsVar, csVar, xrVar, dsVar, ztVar, huVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = yrVar;
        this.e = asVar;
        this.f = esVar;
        this.g = hsVar;
        this.h = csVar;
        this.i = xrVar;
        this.j = dsVar;
        this.k = ztVar;
        this.l = huVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ wt(yr yrVar, as asVar, es esVar, hs hsVar, cs csVar, xr xrVar, ds dsVar, zt ztVar, hu huVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(yrVar, asVar, esVar, hsVar, csVar, xrVar, dsVar, r10, r11);
        au auVar;
        ju juVar;
        if ((i & 128) != 0) {
            auVar = new au();
        } else {
            auVar = ztVar;
        }
        if ((i & 256) != 0) {
            juVar = new ju();
        } else {
            juVar = huVar;
        }
    }

    @Override // com.baidu.tieba.zq
    public ds a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (ds) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zq
    public es b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (es) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zq
    public xr c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (xr) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yt
    public zt d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (zt) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zq
    public hs e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (hs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yt
    public hu f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (hu) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zq
    public as g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (as) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zq
    public yr h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (yr) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zq
    public cs i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (cs) invokeV.objValue;
    }
}
