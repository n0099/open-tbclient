package com.baidu.tieba;

import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class zt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject
    public final dj1<pi5> a;

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            bj1 b = bj1.b();
            this.a = b;
            b.a(new qi5());
        }
    }

    public zt8() {
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
        f();
    }

    public final pi5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            dj1<pi5> dj1Var = this.a;
            if (dj1Var != null) {
                return dj1Var.get();
            }
            return null;
        }
        return (pi5) invokeV.objValue;
    }

    public final BaseFragment b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            pi5 a = a();
            if (a != null) {
                return a.q();
            }
            return null;
        }
        return (BaseFragment) invokeV.objValue;
    }

    public final long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            pi5 a = a();
            if (a != null) {
                return a.k();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            pi5 a = a();
            if (a != null && a.p()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d(int i, int i2, Intent intent) {
        pi5 a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) && (a = a()) != null) {
            a.m(i, i2, intent);
        }
    }

    public final void g(boolean z) {
        pi5 a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && (a = a()) != null) {
            a.r(z);
        }
    }

    public final void h(BdUniqueId bdUniqueId) {
        pi5 a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) && (a = a()) != null) {
            a.setUniqueId(bdUniqueId);
        }
    }

    public final void i(boolean z) {
        pi5 a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (a = a()) != null) {
            a.setUserVisibleHint(z);
        }
    }
}
