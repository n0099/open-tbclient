package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes8.dex */
public final class rp extends vm implements tp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final tn d;
    public final vn e;
    public final zn f;
    public final co g;
    public final xn h;
    public final sn i;
    public final yn j;
    public final up k;
    public final cq l;

    public rp(tn tnVar, vn vnVar, zn znVar, co coVar, xn xnVar, sn snVar, yn ynVar, up upVar, cq cqVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tnVar, vnVar, znVar, coVar, xnVar, snVar, ynVar, upVar, cqVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = tnVar;
        this.e = vnVar;
        this.f = znVar;
        this.g = coVar;
        this.h = xnVar;
        this.i = snVar;
        this.j = ynVar;
        this.k = upVar;
        this.l = cqVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ rp(tn tnVar, vn vnVar, zn znVar, co coVar, xn xnVar, sn snVar, yn ynVar, up upVar, cq cqVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(tnVar, vnVar, znVar, coVar, xnVar, snVar, ynVar, r10, r11);
        vp vpVar;
        eq eqVar;
        if ((i & 128) != 0) {
            vpVar = new vp();
        } else {
            vpVar = upVar;
        }
        if ((i & 256) != 0) {
            eqVar = new eq();
        } else {
            eqVar = cqVar;
        }
    }

    @Override // com.baidu.tieba.um
    public yn a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (yn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.um
    public zn b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (zn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.um
    public sn c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (sn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tp
    public up d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (up) invokeV.objValue;
    }

    @Override // com.baidu.tieba.um
    public co e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (co) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tp
    public cq f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (cq) invokeV.objValue;
    }

    @Override // com.baidu.tieba.um
    public vn g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (vn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.um
    public tn h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (tn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.um
    public xn i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (xn) invokeV.objValue;
    }
}
