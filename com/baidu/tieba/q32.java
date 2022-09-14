package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.request.RequestStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public final class q32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final s32 a;
    public long b;

    public q32() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0L;
        this.a = new s32();
    }

    public void a(o32 o32Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, o32Var) == null) {
            this.a.a(o32Var);
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int size = this.a.d().size();
            int i = this.a.i();
            return i > 0 && (((double) size) * 1.0d) / ((double) i) > 0.5d;
        }
        return invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<o32> d = this.a.d();
            if (d.size() <= 0) {
                return false;
            }
            for (o32 o32Var : d) {
                if (i82.k().i(o32Var.f)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ((double) this.a.g().size()) >= 2.0d : invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.i() <= 2 || System.currentTimeMillis() - this.b < 3000 : invokeV.booleanValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int size = this.a.f().size();
            int i = this.a.i();
            return i > 0 && (((double) size) * 1.0d) / ((double) i) > 0.5d;
        }
        return invokeV.booleanValue;
    }

    public r32 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            r32 r32Var = new r32();
            r32Var.i(this.b);
            r32Var.h(this.a.d());
            r32Var.k(this.a.g());
            r32Var.l(this.a.i());
            if (c()) {
                r32Var.j(RequestStatus.STATUS_CORE_FAILED);
            } else if (e()) {
                r32Var.j(RequestStatus.STATUS_UNKNOWN);
            } else if (f()) {
                r32Var.j(RequestStatus.STATUS_SERVER_FAILED);
            } else if (b()) {
                r32Var.j(RequestStatus.STATUS_FAILED);
            } else if (d()) {
                r32Var.j(RequestStatus.STATUS_SLOW);
            } else {
                r32Var.j(RequestStatus.STATUS_SUCCESS);
            }
            return r32Var;
        }
        return (r32) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.b();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.b = System.currentTimeMillis();
        }
    }
}
