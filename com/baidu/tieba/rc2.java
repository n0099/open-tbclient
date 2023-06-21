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
/* loaded from: classes7.dex */
public final class rc2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final tc2 a;
    public long b;

    public rc2() {
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
        this.a = new tc2();
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.g().size() >= 2.0d) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a.i() > 2 && System.currentTimeMillis() - this.b >= 3000) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
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

    public void a(pc2 pc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pc2Var) == null) {
            this.a.a(pc2Var);
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int size = this.a.d().size();
            int i = this.a.i();
            if (i <= 0 || (size * 1.0d) / i <= 0.5d) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<pc2> d = this.a.d();
            if (d.size() <= 0) {
                return false;
            }
            for (pc2 pc2Var : d) {
                if (jh2.k().i(pc2Var.f)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int size = this.a.f().size();
            int i = this.a.i();
            if (i <= 0 || (size * 1.0d) / i <= 0.5d) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public sc2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            sc2 sc2Var = new sc2();
            sc2Var.i(this.b);
            sc2Var.h(this.a.d());
            sc2Var.k(this.a.g());
            sc2Var.l(this.a.i());
            if (c()) {
                sc2Var.j(RequestStatus.STATUS_CORE_FAILED);
            } else if (e()) {
                sc2Var.j(RequestStatus.STATUS_UNKNOWN);
            } else if (f()) {
                sc2Var.j(RequestStatus.STATUS_SERVER_FAILED);
            } else if (b()) {
                sc2Var.j(RequestStatus.STATUS_FAILED);
            } else if (d()) {
                sc2Var.j(RequestStatus.STATUS_SLOW);
            } else {
                sc2Var.j(RequestStatus.STATUS_SUCCESS);
            }
            return sc2Var;
        }
        return (sc2) invokeV.objValue;
    }
}
