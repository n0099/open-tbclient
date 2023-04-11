package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SimpleUser;
/* loaded from: classes5.dex */
public class pd9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public SimpleUser i;
    public int j;
    public int k;

    public pd9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public SimpleUser f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (SimpleUser) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            p45 m = p45.m();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.a = m.n("post" + currentAccount, 0);
            this.b = m.n("like" + currentAccount, 0);
            this.c = m.n("group" + currentAccount, 0);
            this.d = m.n("live" + currentAccount, 0);
            this.f = m.n("reply" + currentAccount, 1);
            this.k = m.n("reply_show_myself" + currentAccount, 0);
            this.g = m.n(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
            this.h = m.n("bazhu_show_outside" + currentAccount, 0);
            this.e = TbadkCoreApplication.getInst().getLocationShared();
            if (this.a == 0 && this.b == 0 && this.c == 0 && this.d == 0 && this.f == 1 && this.k == 0 && this.g == 0 && this.h == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            p45 m = p45.m();
            m.z("post" + currentAccount, this.a);
            m.z("like" + currentAccount, this.b);
            m.z("group" + currentAccount, this.c);
            m.z("live" + currentAccount, this.d);
            m.z("reply" + currentAccount, this.f);
            m.z("reply_show_myself" + currentAccount, this.k);
            m.z(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.g);
            m.z("bazhu_show_outside" + currentAccount, this.h);
            TbadkCoreApplication.getInst().setLocationShared(this.e);
        }
    }

    public void l(pd9 pd9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, pd9Var) != null) || pd9Var == null) {
            return;
        }
        this.a = pd9Var.a;
        this.b = pd9Var.b;
        this.c = pd9Var.c;
        this.e = pd9Var.e;
        this.d = pd9Var.d;
        this.j = pd9Var.j;
        this.f = pd9Var.f;
        this.k = pd9Var.k;
        this.h = pd9Var.h;
        this.g = pd9Var.g;
    }

    public void n(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, str, i) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            p45 m = p45.m();
            m.z(str + currentAccount, i);
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.g = i;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.h = i;
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.j = i;
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i) == null) && i <= 3 && i >= 1) {
            this.b = i;
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i) == null) && i <= 3 && i >= 1) {
            this.c = i;
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i) == null) && i <= 3 && i >= 1) {
            this.d = i;
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            if (i != 1) {
                this.e = false;
            } else {
                this.e = true;
            }
        }
    }

    public void v(SimpleUser simpleUser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, simpleUser) == null) {
            this.i = simpleUser;
            if (simpleUser != null) {
                x(simpleUser.show_onlyme.intValue());
            }
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            if (i == 0) {
                this.f = 1;
            } else {
                this.f = i;
            }
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.k = i;
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.a = i;
        }
    }
}
