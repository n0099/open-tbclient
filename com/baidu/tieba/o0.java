package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.ashley.core.ComponentOperationHandler;
import com.badlogic.ashley.core.EntityManager;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.v0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final w0<p0> a;
    public final w0<p0> b;
    public v0 c;
    public EntityManager d;
    public ComponentOperationHandler e;
    public t0 f;
    public boolean g;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b implements w0<p0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o0 a;

        public b(o0 o0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.w0
        /* renamed from: b */
        public void a(x0<p0> x0Var, p0 p0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x0Var, p0Var) == null) {
                this.a.f.f(p0Var);
            }
        }

        public /* synthetic */ b(o0 o0Var, a aVar) {
            this(o0Var);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ComponentOperationHandler.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o0 a;

        public c(o0 o0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o0Var;
        }

        @Override // com.badlogic.ashley.core.ComponentOperationHandler.b
        public boolean value() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.g : invokeV.booleanValue;
        }

        public /* synthetic */ c(o0 o0Var, a aVar) {
            this(o0Var);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements q0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o0 a;

        public d(o0 o0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o0Var;
        }

        @Override // com.baidu.tieba.q0
        public void a(p0 p0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p0Var) == null) {
                this.a.n(p0Var);
            }
        }

        @Override // com.baidu.tieba.q0
        public void b(p0 p0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p0Var) == null) {
                this.a.d(p0Var);
            }
        }

        public /* synthetic */ d(o0 o0Var, a aVar) {
            this(o0Var);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements v0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o0 a;

        public e(o0 o0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o0Var;
        }

        @Override // com.baidu.tieba.v0.c
        public void a(r0 r0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r0Var) == null) {
                r0Var.h(this.a);
            }
        }

        @Override // com.baidu.tieba.v0.c
        public void b(r0 r0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r0Var) == null) {
                r0Var.d(this.a);
            }
        }

        public /* synthetic */ e(o0 o0Var, a aVar) {
            this(o0Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448311340, "Lcom/baidu/tieba/o0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448311340, "Lcom/baidu/tieba/o0;");
                return;
            }
        }
        s0.d(new Class[0]).b();
    }

    public o0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new b(this, null);
        this.b = new b(this, null);
        this.c = new v0(new e(this, null));
        this.d = new EntityManager(new d(this, null));
        this.e = new ComponentOperationHandler(new c(this, null));
        this.f = new t0(this.d.c());
    }

    public void c(p0 p0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, p0Var) == null) {
            this.d.a(p0Var, this.g || this.f.c());
        }
    }

    public void d(p0 p0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p0Var) == null) {
            p0Var.a.a(this.a);
            p0Var.b.a(this.b);
            p0Var.e = this.e;
            this.f.f(p0Var);
        }
    }

    public void e(s0 s0Var, int i, q0 q0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, s0Var, i, q0Var) == null) {
            this.f.a(s0Var, i, q0Var);
        }
    }

    public void f(s0 s0Var, q0 q0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, s0Var, q0Var) == null) {
            e(s0Var, 0, q0Var);
        }
    }

    public void g(r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, r0Var) == null) {
            this.c.a(r0Var);
        }
    }

    public <T extends m0> T h(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cls)) == null) {
            try {
                return (T) u8.i(cls);
            } catch (ReflectionException unused) {
                return null;
            }
        }
        return (T) invokeL.objValue;
    }

    public p0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new p0() : (p0) invokeV.objValue;
    }

    public z0<p0> j(s0 s0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, s0Var)) == null) ? this.f.b(s0Var) : (z0) invokeL.objValue;
    }

    public <T extends r0> T k(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls)) == null) ? (T) this.c.b(cls) : (T) invokeL.objValue;
    }

    public z0<r0> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c.c() : (z0) invokeV.objValue;
    }

    public void m(p0 p0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, p0Var) == null) {
            this.d.e(p0Var, this.g || this.f.c());
        }
    }

    public void n(p0 p0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, p0Var) == null) {
            this.f.f(p0Var);
            p0Var.a.c(this.a);
            p0Var.b.c(this.b);
            p0Var.e = null;
        }
    }

    public void o(q0 q0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, q0Var) == null) {
            this.f.e(q0Var);
        }
    }

    public void p(r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, r0Var) == null) {
            this.c.d(r0Var);
        }
    }

    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f) == null) {
            if (!this.g) {
                this.g = true;
                z0<r0> c2 = this.c.c();
                for (int i = 0; i < c2.size(); i++) {
                    try {
                        r0 r0Var = c2.get(i);
                        if (r0Var.e()) {
                            r0Var.update(f);
                        }
                        this.e.b();
                        this.d.d();
                    } finally {
                        this.g = false;
                    }
                }
                return;
            }
            throw new IllegalStateException("Cannot call update() on an Engine that is already updating.");
        }
    }
}
