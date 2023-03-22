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
public final class ut extends yq implements wt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wr d;
    public final yr e;
    public final cs f;
    public final fs g;
    public final as h;
    public final vr i;
    public final bs j;
    public final xt k;
    public final fu l;

    public ut(wr wrVar, yr yrVar, cs csVar, fs fsVar, as asVar, vr vrVar, bs bsVar, xt xtVar, fu fuVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wrVar, yrVar, csVar, fsVar, asVar, vrVar, bsVar, xtVar, fuVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = wrVar;
        this.e = yrVar;
        this.f = csVar;
        this.g = fsVar;
        this.h = asVar;
        this.i = vrVar;
        this.j = bsVar;
        this.k = xtVar;
        this.l = fuVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ut(wr wrVar, yr yrVar, cs csVar, fs fsVar, as asVar, vr vrVar, bs bsVar, xt xtVar, fu fuVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(wrVar, yrVar, csVar, fsVar, asVar, vrVar, bsVar, r10, r11);
        yt ytVar;
        hu huVar;
        if ((i & 128) != 0) {
            ytVar = new yt();
        } else {
            ytVar = xtVar;
        }
        if ((i & 256) != 0) {
            huVar = new hu();
        } else {
            huVar = fuVar;
        }
    }

    @Override // com.baidu.tieba.xq
    public bs a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (bs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xq
    public cs b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (cs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xq
    public vr c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (vr) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wt
    public xt d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (xt) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xq
    public fs e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (fs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wt
    public fu f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (fu) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xq
    public yr g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (yr) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xq
    public wr h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (wr) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xq
    public as i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (as) invokeV.objValue;
    }
}
