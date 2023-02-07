package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes5.dex */
public final class nu extends rr implements pu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ps d;
    public final rs e;
    public final vs f;
    public final ys g;
    public final ts h;
    public final os i;
    public final us j;
    public final qu k;
    public final yu l;

    public nu(ps psVar, rs rsVar, vs vsVar, ys ysVar, ts tsVar, os osVar, us usVar, qu quVar, yu yuVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {psVar, rsVar, vsVar, ysVar, tsVar, osVar, usVar, quVar, yuVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = psVar;
        this.e = rsVar;
        this.f = vsVar;
        this.g = ysVar;
        this.h = tsVar;
        this.i = osVar;
        this.j = usVar;
        this.k = quVar;
        this.l = yuVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ nu(ps psVar, rs rsVar, vs vsVar, ys ysVar, ts tsVar, os osVar, us usVar, qu quVar, yu yuVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(psVar, rsVar, vsVar, ysVar, tsVar, osVar, usVar, r10, r11);
        ru ruVar;
        av avVar;
        if ((i & 128) != 0) {
            ruVar = new ru();
        } else {
            ruVar = quVar;
        }
        if ((i & 256) != 0) {
            avVar = new av();
        } else {
            avVar = yuVar;
        }
    }

    @Override // com.baidu.tieba.qr
    public us a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (us) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qr
    public vs b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (vs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qr
    public os c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (os) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pu
    public qu d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (qu) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qr
    public ys e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (ys) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pu
    public yu f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (yu) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qr
    public rs g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (rs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qr
    public ps h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (ps) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qr
    public ts i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (ts) invokeV.objValue;
    }
}
