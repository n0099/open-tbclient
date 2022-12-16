package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes6.dex */
public class ug8 implements mu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public HashMap<String, ku7> c;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final mu7 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-375808795, "Lcom/baidu/tieba/ug8$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-375808795, "Lcom/baidu/tieba/ug8$b;");
                    return;
                }
            }
            a = new ug8(null);
        }
    }

    public ug8() {
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
        this.c = new HashMap<>();
    }

    public static mu7 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (mu7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mu7
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            n().k(this.a);
            q(this.a);
        }
    }

    @Override // com.baidu.tieba.mu7
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = this.a;
        }
    }

    @Override // com.baidu.tieba.mu7
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a = UUID.randomUUID().toString();
        }
    }

    @Override // com.baidu.tieba.mu7
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            n().j(this.a);
        }
    }

    public final ku7 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            tg8 tg8Var = new tg8(this.a);
            this.c.put(this.a, tg8Var);
            return tg8Var;
        }
        return (ku7) invokeV.objValue;
    }

    public final ku7 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ku7 ku7Var = this.c.get(this.a);
            if (ku7Var == null) {
                return l();
            }
            return ku7Var;
        }
        return (ku7) invokeV.objValue;
    }

    public /* synthetic */ ug8(a aVar) {
        this();
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            return n().d(str);
        }
        return invokeL.booleanValue;
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            return n().e(str);
        }
        return invokeL.booleanValue;
    }

    public void q(String str) {
        ku7 ku7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, str) != null) || (ku7Var = this.c.get(str)) == null) {
            return;
        }
        ku7Var.a(str);
        this.c.remove(str);
    }

    @Override // com.baidu.tieba.mu7
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            n().c(this.a, i, str);
        }
    }

    @Override // com.baidu.tieba.mu7
    public void b(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            n().f(this.a, i, str);
        }
    }

    @Override // com.baidu.tieba.mu7
    public void h(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, str) == null) {
            n().g(this.a, i, str);
        }
    }

    @Override // com.baidu.tieba.mu7
    public void i(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, str) == null) {
            n().l(this.a, i, str);
        }
    }

    @Override // com.baidu.tieba.mu7
    public void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && !StringUtils.isNull(this.b)) {
            if (!o(this.b) && !p(this.b)) {
                ju7.b(this.b);
                this.c.remove(this.a);
            } else {
                q(this.b);
            }
            g();
            n().h(this.b, str);
            this.b = null;
        }
    }

    @Override // com.baidu.tieba.mu7
    public void f(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, str) == null) {
            n().b(this.a, i, i2, str);
        }
    }

    @Override // com.baidu.tieba.mu7
    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            n().i(this.a, str);
            if (!o(this.a) && !p(this.a)) {
                ju7.b(this.a);
                this.c.remove(this.a);
            } else {
                q(this.a);
            }
            this.a = null;
        }
    }
}
