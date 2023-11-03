package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.ashley.core.ComponentOperationHandler;
import com.badlogic.ashley.core.EntityManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class x0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f1<y0> a;
    public final f1<y0> b;
    public e1 c;
    public EntityManager d;
    public ComponentOperationHandler e;
    public c1 f;
    public boolean g;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public abstract <T extends v0> T h(Class<T> cls);

    public abstract y0 i();

    /* loaded from: classes8.dex */
    public class b implements f1<y0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x0 a;

        public b(x0 x0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x0Var;
        }

        public /* synthetic */ b(x0 x0Var, a aVar) {
            this(x0Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f1
        /* renamed from: b */
        public void a(g1<y0> g1Var, y0 y0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g1Var, y0Var) == null) {
                this.a.f.f(y0Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ComponentOperationHandler.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x0 a;

        public c(x0 x0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x0Var;
        }

        public /* synthetic */ c(x0 x0Var, a aVar) {
            this(x0Var);
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

    /* loaded from: classes9.dex */
    public class d implements z0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x0 a;

        public d(x0 x0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x0Var;
        }

        @Override // com.baidu.tieba.z0
        public void a(y0 y0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y0Var) == null) {
                this.a.n(y0Var);
            }
        }

        @Override // com.baidu.tieba.z0
        public void b(y0 y0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y0Var) == null) {
                this.a.d(y0Var);
            }
        }

        public /* synthetic */ d(x0 x0Var, a aVar) {
            this(x0Var);
        }
    }

    /* loaded from: classes9.dex */
    public class e implements e1.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x0 a;

        public e(x0 x0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x0Var;
        }

        @Override // com.baidu.tieba.e1.c
        public void a(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a1Var) == null) {
                a1Var.h(this.a);
            }
        }

        @Override // com.baidu.tieba.e1.c
        public void b(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a1Var) == null) {
                a1Var.d(this.a);
            }
        }

        public /* synthetic */ e(x0 x0Var, a aVar) {
            this(x0Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448319989, "Lcom/baidu/tieba/x0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448319989, "Lcom/baidu/tieba/x0;");
                return;
            }
        }
        b1.d(new Class[0]).b();
    }

    public i1<a1> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c.c();
        }
        return (i1) invokeV.objValue;
    }

    public x0() {
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
        this.c = new e1(new e(this, null));
        this.d = new EntityManager(new d(this, null));
        this.e = new ComponentOperationHandler(new c(this, null));
        this.f = new c1(this.d.c());
    }

    public void c(y0 y0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, y0Var) == null) {
            if (!this.g && !this.f.c()) {
                z = false;
            } else {
                z = true;
            }
            this.d.a(y0Var, z);
        }
    }

    public void d(y0 y0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y0Var) == null) {
            y0Var.a.a(this.a);
            y0Var.b.a(this.b);
            y0Var.e = this.e;
            this.f.f(y0Var);
        }
    }

    public void g(a1 a1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, a1Var) == null) {
            this.c.a(a1Var);
        }
    }

    public i1<y0> j(b1 b1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, b1Var)) == null) {
            return this.f.b(b1Var);
        }
        return (i1) invokeL.objValue;
    }

    public <T extends a1> T k(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls)) == null) {
            return (T) this.c.b(cls);
        }
        return (T) invokeL.objValue;
    }

    public void m(y0 y0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, y0Var) == null) {
            if (!this.g && !this.f.c()) {
                z = false;
            } else {
                z = true;
            }
            this.d.e(y0Var, z);
        }
    }

    public void n(y0 y0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, y0Var) == null) {
            this.f.f(y0Var);
            y0Var.a.c(this.a);
            y0Var.b.c(this.b);
            y0Var.e = null;
        }
    }

    public void o(z0 z0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, z0Var) == null) {
            this.f.e(z0Var);
        }
    }

    public void p(a1 a1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, a1Var) == null) {
            this.c.d(a1Var);
        }
    }

    public void e(b1 b1Var, int i, z0 z0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, b1Var, i, z0Var) == null) {
            this.f.a(b1Var, i, z0Var);
        }
    }

    public void f(b1 b1Var, z0 z0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, b1Var, z0Var) == null) {
            e(b1Var, 0, z0Var);
        }
    }

    public void q(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f) == null) {
            if (!this.g) {
                this.g = true;
                i1<a1> c2 = this.c.c();
                for (int i = 0; i < c2.size(); i++) {
                    try {
                        a1 a1Var = c2.get(i);
                        if (a1Var.e()) {
                            a1Var.i(f);
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
