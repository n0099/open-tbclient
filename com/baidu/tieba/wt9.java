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
/* loaded from: classes8.dex */
public final class wt9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject
    public final of1<am5> a;

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            mf1 b = mf1.b();
            this.a = b;
            b.a(new bm5());
        }
    }

    public wt9() {
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

    public final am5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            of1<am5> of1Var = this.a;
            if (of1Var != null) {
                return of1Var.get();
            }
            return null;
        }
        return (am5) invokeV.objValue;
    }

    public final BaseFragment b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            am5 a = a();
            if (a != null) {
                return a.F();
            }
            return null;
        }
        return (BaseFragment) invokeV.objValue;
    }

    public final long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            am5 a = a();
            if (a != null) {
                return a.t();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            am5 a = a();
            if (a != null && a.E()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d(int i, int i2, Intent intent) {
        am5 a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) && (a = a()) != null) {
            a.B(i, i2, intent);
        }
    }

    public final void g(boolean z) {
        am5 a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && (a = a()) != null) {
            a.G(z);
        }
    }

    public final void h(BdUniqueId bdUniqueId) {
        am5 a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) && (a = a()) != null) {
            a.setUniqueId(bdUniqueId);
        }
    }

    public final void i(boolean z) {
        am5 a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (a = a()) != null) {
            a.setUserVisibleHint(z);
        }
    }
}
