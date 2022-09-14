package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class s0 {
    public static /* synthetic */ Interceptable $ic;
    public static x7<String, s0> e;
    public static int f;
    public static final b g;
    public static final e7 h;
    public transient /* synthetic */ FieldHolder $fh;
    public final e7 a;
    public final e7 b;
    public final e7 c;
    public final int d;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public e7 a;
        public e7 b;
        public e7 c;

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
            this.a = s0.h;
            this.b = s0.h;
            this.c = s0.h;
        }

        @SafeVarargs
        public final b a(Class<? extends m0>... clsArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, clsArr)) == null) {
                this.a = n0.a(clsArr);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public s0 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String f = s0.f(this.a, this.b, this.c);
                s0 s0Var = (s0) s0.e.d(f, null);
                if (s0Var == null) {
                    s0 s0Var2 = new s0(this.a, this.b, this.c, null);
                    s0.e.i(f, s0Var2);
                    return s0Var2;
                }
                return s0Var;
            }
            return (s0) invokeV.objValue;
        }

        @SafeVarargs
        public final b c(Class<? extends m0>... clsArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, clsArr)) == null) {
                this.b = n0.a(clsArr);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.a = s0.h;
                this.b = s0.h;
                this.c = s0.h;
                return this;
            }
            return (b) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448315184, "Lcom/baidu/tieba/s0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448315184, "Lcom/baidu/tieba/s0;");
                return;
            }
        }
        e = new x7<>();
        f = 0;
        g = new b();
        h = new e7();
    }

    public /* synthetic */ s0(e7 e7Var, e7 e7Var2, e7 e7Var3, a aVar) {
        this(e7Var, e7Var2, e7Var3);
    }

    @SafeVarargs
    public static final b d(Class<? extends m0>... clsArr) {
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

    public static String e(e7 e7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, e7Var)) == null) {
            StringBuilder sb = new StringBuilder();
            int h2 = e7Var.h();
            for (int i = 0; i < h2; i++) {
                sb.append(e7Var.e(i) ? "1" : "0");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String f(e7 e7Var, e7 e7Var2, e7 e7Var3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, e7Var, e7Var2, e7Var3)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!e7Var.g()) {
                sb.append("{all:");
                sb.append(e(e7Var));
                sb.append("}");
            }
            if (!e7Var2.g()) {
                sb.append("{one:");
                sb.append(e(e7Var2));
                sb.append("}");
            }
            if (!e7Var3.g()) {
                sb.append("{exclude:");
                sb.append(e(e7Var3));
                sb.append("}");
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    @SafeVarargs
    public static final b i(Class<? extends m0>... clsArr) {
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

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this == obj : invokeL.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : invokeV.intValue;
    }

    public boolean h(p0 p0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, p0Var)) == null) {
            e7 e2 = p0Var.e();
            if (e2.d(this.a)) {
                if (this.b.g() || this.b.f(e2)) {
                    return this.c.g() || !this.c.f(e2);
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : invokeV.intValue;
    }

    public s0(e7 e7Var, e7 e7Var2, e7 e7Var3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e7Var, e7Var2, e7Var3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = e7Var;
        this.b = e7Var2;
        this.c = e7Var3;
        int i3 = f;
        f = i3 + 1;
        this.d = i3;
    }
}
