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
public final class zt extends dr implements bu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bs d;
    public final ds e;
    public final hs f;
    public final ks g;
    public final fs h;
    public final as i;
    public final gs j;
    public final cu k;
    public final ku l;

    public zt(bs bsVar, ds dsVar, hs hsVar, ks ksVar, fs fsVar, as asVar, gs gsVar, cu cuVar, ku kuVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bsVar, dsVar, hsVar, ksVar, fsVar, asVar, gsVar, cuVar, kuVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = bsVar;
        this.e = dsVar;
        this.f = hsVar;
        this.g = ksVar;
        this.h = fsVar;
        this.i = asVar;
        this.j = gsVar;
        this.k = cuVar;
        this.l = kuVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ zt(bs bsVar, ds dsVar, hs hsVar, ks ksVar, fs fsVar, as asVar, gs gsVar, cu cuVar, ku kuVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bsVar, dsVar, hsVar, ksVar, fsVar, asVar, gsVar, r10, r11);
        du duVar;
        mu muVar;
        if ((i & 128) != 0) {
            duVar = new du();
        } else {
            duVar = cuVar;
        }
        if ((i & 256) != 0) {
            muVar = new mu();
        } else {
            muVar = kuVar;
        }
    }

    @Override // com.baidu.tieba.cr
    public gs a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (gs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cr
    public hs b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (hs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cr
    public as c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (as) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bu
    public cu d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (cu) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cr
    public ks e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (ks) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bu
    public ku f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (ku) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cr
    public ds g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (ds) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cr
    public bs h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (bs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cr
    public fs i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (fs) invokeV.objValue;
    }
}
