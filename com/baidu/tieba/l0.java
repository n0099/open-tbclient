package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l0 {
    public static /* synthetic */ Interceptable $ic;
    public static q7<String, l0> e;
    public static int f;
    public static final b g;
    public static final x6 h;
    public transient /* synthetic */ FieldHolder $fh;
    public final x6 a;
    public final x6 b;
    public final x6 c;
    public final int d;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this == obj : invokeL.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public x6 a;
        public x6 b;
        public x6 c;

        public b() {
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
            this.a = l0.h;
            this.b = l0.h;
            this.c = l0.h;
        }

        public l0 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return (l0) invokeV.objValue;
            }
            String f = l0.f(this.a, this.b, this.c);
            l0 l0Var = (l0) l0.e.d(f, null);
            if (l0Var == null) {
                l0 l0Var2 = new l0(this.a, this.b, this.c, null);
                l0.e.i(f, l0Var2);
                return l0Var2;
            }
            return l0Var;
        }

        @SafeVarargs
        public final b a(Class<? extends f0>... clsArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, clsArr)) == null) {
                this.a = g0.a(clsArr);
                return this;
            }
            return (b) invokeL.objValue;
        }

        @SafeVarargs
        public final b c(Class<? extends f0>... clsArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, clsArr)) == null) {
                this.b = g0.a(clsArr);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.a = l0.h;
                this.b = l0.h;
                this.c = l0.h;
                return this;
            }
            return (b) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448308457, "Lcom/baidu/tieba/l0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448308457, "Lcom/baidu/tieba/l0;");
                return;
            }
        }
        e = new q7<>();
        f = 0;
        g = new b();
        h = new x6();
    }

    public l0(x6 x6Var, x6 x6Var2, x6 x6Var3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x6Var, x6Var2, x6Var3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = x6Var;
        this.b = x6Var2;
        this.c = x6Var3;
        int i3 = f;
        f = i3 + 1;
        this.d = i3;
    }

    public /* synthetic */ l0(x6 x6Var, x6 x6Var2, x6 x6Var3, a aVar) {
        this(x6Var, x6Var2, x6Var3);
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    @SafeVarargs
    public static final b d(Class<? extends f0>... clsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, clsArr)) == null) {
            b bVar = g;
            bVar.d();
            bVar.a(clsArr);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    @SafeVarargs
    public static final b i(Class<? extends f0>... clsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, clsArr)) == null) {
            b bVar = g;
            bVar.d();
            bVar.c(clsArr);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static String e(x6 x6Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, x6Var)) == null) {
            StringBuilder sb = new StringBuilder();
            int h2 = x6Var.h();
            for (int i = 0; i < h2; i++) {
                if (x6Var.e(i)) {
                    str = "1";
                } else {
                    str = "0";
                }
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public boolean h(i0 i0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i0Var)) == null) {
            x6 e2 = i0Var.e();
            if (!e2.d(this.a)) {
                return false;
            }
            if (!this.b.g() && !this.b.f(e2)) {
                return false;
            }
            if (!this.c.g() && this.c.f(e2)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String f(x6 x6Var, x6 x6Var2, x6 x6Var3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, x6Var, x6Var2, x6Var3)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!x6Var.g()) {
                sb.append("{all:");
                sb.append(e(x6Var));
                sb.append("}");
            }
            if (!x6Var2.g()) {
                sb.append("{one:");
                sb.append(e(x6Var2));
                sb.append("}");
            }
            if (!x6Var3.g()) {
                sb.append("{exclude:");
                sb.append(e(x6Var3));
                sb.append("}");
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }
}
