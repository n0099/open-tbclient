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
public class k0 {
    public static /* synthetic */ Interceptable $ic;
    public static p7<String, k0> e;
    public static int f;
    public static final b g;
    public static final w6 h;
    public transient /* synthetic */ FieldHolder $fh;
    public final w6 a;
    public final w6 b;
    public final w6 c;
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
        public w6 a;
        public w6 b;
        public w6 c;

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
            this.a = k0.h;
            this.b = k0.h;
            this.c = k0.h;
        }

        public k0 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return (k0) invokeV.objValue;
            }
            String f = k0.f(this.a, this.b, this.c);
            k0 k0Var = (k0) k0.e.d(f, null);
            if (k0Var == null) {
                k0 k0Var2 = new k0(this.a, this.b, this.c, null);
                k0.e.i(f, k0Var2);
                return k0Var2;
            }
            return k0Var;
        }

        @SafeVarargs
        public final b a(Class<? extends e0>... clsArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, clsArr)) == null) {
                this.a = f0.a(clsArr);
                return this;
            }
            return (b) invokeL.objValue;
        }

        @SafeVarargs
        public final b c(Class<? extends e0>... clsArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, clsArr)) == null) {
                this.b = f0.a(clsArr);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.a = k0.h;
                this.b = k0.h;
                this.c = k0.h;
                return this;
            }
            return (b) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448307496, "Lcom/baidu/tieba/k0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448307496, "Lcom/baidu/tieba/k0;");
                return;
            }
        }
        e = new p7<>();
        f = 0;
        g = new b();
        h = new w6();
    }

    public k0(w6 w6Var, w6 w6Var2, w6 w6Var3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w6Var, w6Var2, w6Var3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = w6Var;
        this.b = w6Var2;
        this.c = w6Var3;
        int i3 = f;
        f = i3 + 1;
        this.d = i3;
    }

    public /* synthetic */ k0(w6 w6Var, w6 w6Var2, w6 w6Var3, a aVar) {
        this(w6Var, w6Var2, w6Var3);
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
    public static final b d(Class<? extends e0>... clsArr) {
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
    public static final b i(Class<? extends e0>... clsArr) {
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

    public static String e(w6 w6Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, w6Var)) == null) {
            StringBuilder sb = new StringBuilder();
            int h2 = w6Var.h();
            for (int i = 0; i < h2; i++) {
                if (w6Var.e(i)) {
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

    public boolean h(h0 h0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, h0Var)) == null) {
            w6 e2 = h0Var.e();
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

    public static String f(w6 w6Var, w6 w6Var2, w6 w6Var3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, w6Var, w6Var2, w6Var3)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!w6Var.g()) {
                sb.append("{all:");
                sb.append(e(w6Var));
                sb.append("}");
            }
            if (!w6Var2.g()) {
                sb.append("{one:");
                sb.append(e(w6Var2));
                sb.append("}");
            }
            if (!w6Var3.g()) {
                sb.append("{exclude:");
                sb.append(e(w6Var3));
                sb.append("}");
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }
}
