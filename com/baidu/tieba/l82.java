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
public final class l82 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final n82 a;
    public long b;

    public l82() {
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
        this.a = new n82();
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

    public void a(j82 j82Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, j82Var) == null) {
            this.a.a(j82Var);
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
            List<j82> d = this.a.d();
            if (d.size() <= 0) {
                return false;
            }
            for (j82 j82Var : d) {
                if (dd2.k().i(j82Var.f)) {
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

    public m82 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            m82 m82Var = new m82();
            m82Var.i(this.b);
            m82Var.h(this.a.d());
            m82Var.k(this.a.g());
            m82Var.l(this.a.i());
            if (c()) {
                m82Var.j(RequestStatus.STATUS_CORE_FAILED);
            } else if (e()) {
                m82Var.j(RequestStatus.STATUS_UNKNOWN);
            } else if (f()) {
                m82Var.j(RequestStatus.STATUS_SERVER_FAILED);
            } else if (b()) {
                m82Var.j(RequestStatus.STATUS_FAILED);
            } else if (d()) {
                m82Var.j(RequestStatus.STATUS_SLOW);
            } else {
                m82Var.j(RequestStatus.STATUS_SUCCESS);
            }
            return m82Var;
        }
        return (m82) invokeV.objValue;
    }
}
