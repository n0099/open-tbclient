package com.bytedance.sdk.component.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class i extends t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public t f64415a;

    public i(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (tVar != null) {
            this.f64415a = tVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final t a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64415a : (t) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.t
    public long b_() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f64415a.b_() : invokeV.longValue;
    }

    @Override // com.bytedance.sdk.component.b.a.t
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f64415a.c() : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.component.b.a.t
    public long c_() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f64415a.c_() : invokeV.longValue;
    }

    @Override // com.bytedance.sdk.component.b.a.t
    public t e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f64415a.e() : (t) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.t
    public t f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f64415a.f() : (t) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.t
    public void g() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f64415a.g();
        }
    }

    public final i a(t tVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tVar)) == null) {
            if (tVar != null) {
                this.f64415a = tVar;
                return this;
            }
            throw new IllegalArgumentException("delegate == null");
        }
        return (i) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.t
    public t a(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048579, this, j2, timeUnit)) == null) ? this.f64415a.a(j2, timeUnit) : (t) invokeJL.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.t
    public t a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) ? this.f64415a.a(j2) : (t) invokeJ.objValue;
    }
}
