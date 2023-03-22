package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.zs4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class ys4 {
    public static /* synthetic */ Interceptable $ic;
    public static zs4 a;
    public static ys4 b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948340719, "Lcom/baidu/tieba/ys4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948340719, "Lcom/baidu/tieba/ys4;");
                return;
            }
        }
        new ArrayList(5);
    }

    public ys4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || a == null) {
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b();
            zs4 zs4Var = a;
            if (zs4Var != null) {
                zs4Var.d();
                c = false;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b();
            zs4 zs4Var = a;
            if (zs4Var != null) {
                zs4Var.c();
                c = false;
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b();
            zs4 zs4Var = a;
            if (zs4Var != null) {
                zs4Var.h();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b();
            i();
            m();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            b();
            zs4 zs4Var = a;
            if (zs4Var != null) {
                zs4Var.m();
                c = true;
            }
        }
    }

    public static ys4 a(BaseFragmentActivity baseFragmentActivity) {
        InterceptResult invokeL;
        zs4 zs4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, baseFragmentActivity)) == null) {
            if (b == null) {
                synchronized (ys4.class) {
                    if (b == null) {
                        b = new ys4();
                        a = zs4.a(baseFragmentActivity);
                    }
                }
            } else {
                zs4 zs4Var2 = a;
                if (zs4Var2 != null) {
                    zs4Var2.j(baseFragmentActivity.getPageContext());
                }
            }
            if (c && (zs4Var = a) != null) {
                zs4Var.d();
                a.c();
                c = false;
            }
            return b;
        }
        return (ys4) invokeL.objValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            try {
                if (a != null) {
                    if (b != null) {
                        b.j();
                    }
                    a.e();
                    a.i();
                    a = null;
                }
                if (b != null) {
                    b = null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void e(boolean z, boolean z2, boolean z3, zs4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), aVar}) == null) {
            b();
            if (z) {
                c();
            }
            if (z2) {
                d();
            }
            l(z3);
            k(aVar);
        }
    }

    public void f(zs4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            b();
            zs4 zs4Var = a;
            if (zs4Var != null) {
                if (zs4Var.b()) {
                    a.k(aVar);
                }
                a.f();
            }
        }
    }

    public void k(zs4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            b();
            zs4 zs4Var = a;
            if (zs4Var != null) {
                zs4Var.k(aVar);
            }
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            b();
            zs4 zs4Var = a;
            if (zs4Var != null) {
                zs4Var.l(z);
            }
        }
    }

    public void g(int i, zs4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, aVar) == null) {
            b();
            zs4 zs4Var = a;
            if (zs4Var != null) {
                if (zs4Var.b()) {
                    a.k(aVar);
                }
                a.g(i);
            }
        }
    }
}
