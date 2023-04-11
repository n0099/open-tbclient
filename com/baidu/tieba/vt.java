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
public final class vt extends zq implements xt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xr d;
    public final zr e;
    public final ds f;
    public final gs g;
    public final bs h;
    public final wr i;
    public final cs j;
    public final yt k;
    public final gu l;

    public vt(xr xrVar, zr zrVar, ds dsVar, gs gsVar, bs bsVar, wr wrVar, cs csVar, yt ytVar, gu guVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xrVar, zrVar, dsVar, gsVar, bsVar, wrVar, csVar, ytVar, guVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = xrVar;
        this.e = zrVar;
        this.f = dsVar;
        this.g = gsVar;
        this.h = bsVar;
        this.i = wrVar;
        this.j = csVar;
        this.k = ytVar;
        this.l = guVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ vt(xr xrVar, zr zrVar, ds dsVar, gs gsVar, bs bsVar, wr wrVar, cs csVar, yt ytVar, gu guVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(xrVar, zrVar, dsVar, gsVar, bsVar, wrVar, csVar, r10, r11);
        zt ztVar;
        iu iuVar;
        if ((i & 128) != 0) {
            ztVar = new zt();
        } else {
            ztVar = ytVar;
        }
        if ((i & 256) != 0) {
            iuVar = new iu();
        } else {
            iuVar = guVar;
        }
    }

    @Override // com.baidu.tieba.yq
    public cs a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (cs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yq
    public ds b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (ds) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yq
    public wr c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (wr) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xt
    public yt d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (yt) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yq
    public gs e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (gs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xt
    public gu f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (gu) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yq
    public zr g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (zr) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yq
    public xr h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (xr) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yq
    public bs i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (bs) invokeV.objValue;
    }
}
