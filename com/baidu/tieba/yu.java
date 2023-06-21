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
public final class yu extends cs implements av {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final at d;
    public final ct e;
    public final gt f;
    public final jt g;
    public final et h;
    public final zs i;
    public final ft j;
    public final bv k;
    public final jv l;

    public yu(at atVar, ct ctVar, gt gtVar, jt jtVar, et etVar, zs zsVar, ft ftVar, bv bvVar, jv jvVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atVar, ctVar, gtVar, jtVar, etVar, zsVar, ftVar, bvVar, jvVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = atVar;
        this.e = ctVar;
        this.f = gtVar;
        this.g = jtVar;
        this.h = etVar;
        this.i = zsVar;
        this.j = ftVar;
        this.k = bvVar;
        this.l = jvVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ yu(at atVar, ct ctVar, gt gtVar, jt jtVar, et etVar, zs zsVar, ft ftVar, bv bvVar, jv jvVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(atVar, ctVar, gtVar, jtVar, etVar, zsVar, ftVar, r10, r11);
        cv cvVar;
        lv lvVar;
        if ((i & 128) != 0) {
            cvVar = new cv();
        } else {
            cvVar = bvVar;
        }
        if ((i & 256) != 0) {
            lvVar = new lv();
        } else {
            lvVar = jvVar;
        }
    }

    @Override // com.baidu.tieba.bs
    public ft a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (ft) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bs
    public gt b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (gt) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bs
    public zs c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (zs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.av
    public bv d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (bv) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bs
    public jt e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (jt) invokeV.objValue;
    }

    @Override // com.baidu.tieba.av
    public jv f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (jv) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bs
    public ct g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (ct) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bs
    public at h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (at) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bs
    public et i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (et) invokeV.objValue;
    }
}
