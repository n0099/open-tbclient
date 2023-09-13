package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.jw4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class iw4 {
    public static /* synthetic */ Interceptable $ic;
    public static jw4 a;
    public static iw4 b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947867907, "Lcom/baidu/tieba/iw4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947867907, "Lcom/baidu/tieba/iw4;");
                return;
            }
        }
        new ArrayList(5);
    }

    public iw4() {
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
            jw4 jw4Var = a;
            if (jw4Var != null) {
                jw4Var.d();
                c = false;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b();
            jw4 jw4Var = a;
            if (jw4Var != null) {
                jw4Var.c();
                c = false;
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b();
            jw4 jw4Var = a;
            if (jw4Var != null) {
                jw4Var.h();
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
            jw4 jw4Var = a;
            if (jw4Var != null) {
                jw4Var.m();
                c = true;
            }
        }
    }

    public static iw4 a(BaseFragmentActivity baseFragmentActivity) {
        InterceptResult invokeL;
        jw4 jw4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, baseFragmentActivity)) == null) {
            if (b == null) {
                synchronized (iw4.class) {
                    if (b == null) {
                        b = new iw4();
                        a = jw4.a(baseFragmentActivity);
                    }
                }
            } else {
                jw4 jw4Var2 = a;
                if (jw4Var2 != null) {
                    jw4Var2.j(baseFragmentActivity.getPageContext());
                }
            }
            if (c && (jw4Var = a) != null) {
                jw4Var.d();
                a.c();
                c = false;
            }
            return b;
        }
        return (iw4) invokeL.objValue;
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

    public void e(boolean z, boolean z2, boolean z3, jw4.a aVar) {
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

    public void f(jw4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            b();
            jw4 jw4Var = a;
            if (jw4Var != null) {
                if (jw4Var.b()) {
                    a.k(aVar);
                }
                a.f();
            }
        }
    }

    public void k(jw4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            b();
            jw4 jw4Var = a;
            if (jw4Var != null) {
                jw4Var.k(aVar);
            }
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            b();
            jw4 jw4Var = a;
            if (jw4Var != null) {
                jw4Var.l(z);
            }
        }
    }

    public void g(int i, jw4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, aVar) == null) {
            b();
            jw4 jw4Var = a;
            if (jw4Var != null) {
                if (jw4Var.b()) {
                    a.k(aVar);
                }
                a.g(i);
            }
        }
    }
}
