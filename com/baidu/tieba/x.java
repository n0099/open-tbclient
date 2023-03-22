package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.ashley.core.ComponentOperationHandler;
import com.badlogic.ashley.core.EntityManager;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f0<y> a;
    public final f0<y> b;
    public e0 c;
    public EntityManager d;
    public ComponentOperationHandler e;
    public c0 f;
    public boolean g;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b implements f0<y> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x a;

        public b(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xVar;
        }

        public /* synthetic */ b(x xVar, a aVar) {
            this(xVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f0
        /* renamed from: b */
        public void a(g0<y> g0Var, y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g0Var, yVar) == null) {
                this.a.f.f(yVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ComponentOperationHandler.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x a;

        public c(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xVar;
        }

        public /* synthetic */ c(x xVar, a aVar) {
            this(xVar);
        }

        @Override // com.badlogic.ashley.core.ComponentOperationHandler.b
        public boolean value() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.g;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x a;

        public d(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xVar;
        }

        @Override // com.baidu.tieba.z
        public void a(y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, yVar) == null) {
                this.a.n(yVar);
            }
        }

        @Override // com.baidu.tieba.z
        public void b(y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yVar) == null) {
                this.a.d(yVar);
            }
        }

        public /* synthetic */ d(x xVar, a aVar) {
            this(xVar);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x a;

        public e(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xVar;
        }

        @Override // com.baidu.tieba.e0.c
        public void a(a0 a0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a0Var) == null) {
                a0Var.h(this.a);
            }
        }

        @Override // com.baidu.tieba.e0.c
        public void b(a0 a0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a0Var) == null) {
                a0Var.d(this.a);
            }
        }

        public /* synthetic */ e(x xVar, a aVar) {
            this(xVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(323814673, "Lcom/baidu/tieba/x;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(323814673, "Lcom/baidu/tieba/x;");
                return;
            }
        }
        b0.d(new Class[0]).b();
    }

    public y i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new y();
        }
        return (y) invokeV.objValue;
    }

    public i0<a0> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c.c();
        }
        return (i0) invokeV.objValue;
    }

    public x() {
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
        this.c = new e0(new e(this, null));
        this.d = new EntityManager(new d(this, null));
        this.e = new ComponentOperationHandler(new c(this, null));
        this.f = new c0(this.d.c());
    }

    public void c(y yVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yVar) == null) {
            if (!this.g && !this.f.c()) {
                z = false;
            } else {
                z = true;
            }
            this.d.a(yVar, z);
        }
    }

    public void d(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yVar) == null) {
            yVar.a.a(this.a);
            yVar.b.a(this.b);
            yVar.e = this.e;
            this.f.f(yVar);
        }
    }

    public void g(a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, a0Var) == null) {
            this.c.a(a0Var);
        }
    }

    public <T extends v> T h(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cls)) == null) {
            try {
                return (T) d8.i(cls);
            } catch (ReflectionException unused) {
                return null;
            }
        }
        return (T) invokeL.objValue;
    }

    public i0<y> j(b0 b0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, b0Var)) == null) {
            return this.f.b(b0Var);
        }
        return (i0) invokeL.objValue;
    }

    public <T extends a0> T k(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls)) == null) {
            return (T) this.c.b(cls);
        }
        return (T) invokeL.objValue;
    }

    public void m(y yVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, yVar) == null) {
            if (!this.g && !this.f.c()) {
                z = false;
            } else {
                z = true;
            }
            this.d.e(yVar, z);
        }
    }

    public void n(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, yVar) == null) {
            this.f.f(yVar);
            yVar.a.c(this.a);
            yVar.b.c(this.b);
            yVar.e = null;
        }
    }

    public void o(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, zVar) == null) {
            this.f.e(zVar);
        }
    }

    public void p(a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, a0Var) == null) {
            this.c.d(a0Var);
        }
    }

    public void e(b0 b0Var, int i, z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, b0Var, i, zVar) == null) {
            this.f.a(b0Var, i, zVar);
        }
    }

    public void f(b0 b0Var, z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, b0Var, zVar) == null) {
            e(b0Var, 0, zVar);
        }
    }

    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f) == null) {
            if (!this.g) {
                this.g = true;
                i0<a0> c2 = this.c.c();
                for (int i = 0; i < c2.size(); i++) {
                    try {
                        a0 a0Var = c2.get(i);
                        if (a0Var.e()) {
                            a0Var.update(f);
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
