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
public final class mu extends qr implements ou {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final os d;
    public final qs e;
    public final us f;
    public final xs g;
    public final ss h;
    public final ns i;
    public final ts j;
    public final pu k;
    public final xu l;

    public /* synthetic */ mu(os osVar, qs qsVar, us usVar, xs xsVar, ss ssVar, ns nsVar, ts tsVar, pu puVar, xu xuVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(osVar, qsVar, usVar, xsVar, ssVar, nsVar, tsVar, (i & 128) != 0 ? new qu() : puVar, (i & 256) != 0 ? new zu() : xuVar);
    }

    @Override // com.baidu.tieba.pr
    public ts a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (ts) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr
    public us b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (us) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr
    public ns c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i : (ns) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ou
    public pu d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (pu) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr
    public xs e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (xs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ou
    public xu f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : (xu) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr
    public qs g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (qs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr
    public os h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (os) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr
    public ss i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h : (ss) invokeV.objValue;
    }

    public mu(os osVar, qs qsVar, us usVar, xs xsVar, ss ssVar, ns nsVar, ts tsVar, pu puVar, xu xuVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {osVar, qsVar, usVar, xsVar, ssVar, nsVar, tsVar, puVar, xuVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = osVar;
        this.e = qsVar;
        this.f = usVar;
        this.g = xsVar;
        this.h = ssVar;
        this.i = nsVar;
        this.j = tsVar;
        this.k = puVar;
        this.l = xuVar;
    }
}
