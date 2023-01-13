package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import bolts.ExecutorException;
import bolts.UnobservedTaskException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class k0<TResult> {
    public static /* synthetic */ Interceptable $ic;
    public static final Executor i;
    public static volatile f j;
    public static k0<?> k;
    public static k0<Boolean> l;
    public static k0<Boolean> m;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public boolean b;
    public boolean c;
    public TResult d;
    public Exception e;
    public boolean f;
    public m0 g;
    public List<j0<TResult, Void>> h;

    /* loaded from: classes5.dex */
    public interface f {
        void a(k0<?> k0Var, UnobservedTaskException unobservedTaskException);
    }

    /* loaded from: classes5.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i0 a;
        public final /* synthetic */ l0 b;
        public final /* synthetic */ j0 c;
        public final /* synthetic */ k0 d;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* loaded from: classes5.dex */
        public class a<TContinuationResult> implements j0<TContinuationResult, Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.j0
            /* renamed from: a */
            public Void then(k0<TContinuationResult> k0Var) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k0Var)) == null) {
                    i0 i0Var = this.a.a;
                    if (i0Var != null && i0Var.a()) {
                        this.a.b.b();
                        return null;
                    }
                    if (k0Var.n()) {
                        this.a.b.b();
                    } else if (k0Var.p()) {
                        this.a.b.c(k0Var.k());
                    } else {
                        this.a.b.setResult(k0Var.l());
                    }
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        }

        public d(i0 i0Var, l0 l0Var, j0 j0Var, k0 k0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i0Var, l0Var, j0Var, k0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i0Var;
            this.b = l0Var;
            this.c = j0Var;
            this.d = k0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i0 i0Var = this.a;
                if (i0Var != null && i0Var.a()) {
                    this.b.b();
                    return;
                }
                try {
                    k0 k0Var = (k0) this.c.then(this.d);
                    if (k0Var == null) {
                        this.b.setResult(null);
                    } else {
                        k0Var.e(new a(this));
                    }
                } catch (CancellationException unused) {
                    this.b.b();
                } catch (Exception e) {
                    this.b.c(e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements j0<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l0 a;
        public final /* synthetic */ j0 b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ i0 d;

        public a(k0 k0Var, l0 l0Var, j0 j0Var, Executor executor, i0 i0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, l0Var, j0Var, executor, i0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l0Var;
            this.b = j0Var;
            this.c = executor;
            this.d = i0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j0
        /* renamed from: a */
        public Void then(k0<TResult> k0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, k0Var)) != null) {
                return (Void) invokeL.objValue;
            }
            k0.d(this.a, this.b, k0Var, this.c, this.d);
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements j0<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l0 a;
        public final /* synthetic */ j0 b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ i0 d;

        public b(k0 k0Var, l0 l0Var, j0 j0Var, Executor executor, i0 i0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, l0Var, j0Var, executor, i0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l0Var;
            this.b = j0Var;
            this.c = executor;
            this.d = i0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j0
        /* renamed from: a */
        public Void then(k0<TResult> k0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, k0Var)) != null) {
                return (Void) invokeL.objValue;
            }
            k0.c(this.a, this.b, k0Var, this.c, this.d);
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i0 a;
        public final /* synthetic */ l0 b;
        public final /* synthetic */ j0 c;
        public final /* synthetic */ k0 d;

        public c(i0 i0Var, l0 l0Var, j0 j0Var, k0 k0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i0Var, l0Var, j0Var, k0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i0Var;
            this.b = l0Var;
            this.c = j0Var;
            this.d = k0Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.l0 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i0 i0Var = this.a;
                if (i0Var != null && i0Var.a()) {
                    this.b.b();
                    return;
                }
                try {
                    this.b.setResult(this.c.then(this.d));
                } catch (CancellationException unused) {
                    this.b.b();
                } catch (Exception e) {
                    this.b.c(e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i0 a;
        public final /* synthetic */ l0 b;
        public final /* synthetic */ Callable c;

        public e(i0 i0Var, l0 l0Var, Callable callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i0Var, l0Var, callable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i0Var;
            this.b = l0Var;
            this.c = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.l0 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i0 i0Var = this.a;
                if (i0Var != null && i0Var.a()) {
                    this.b.b();
                    return;
                }
                try {
                    this.b.setResult(this.c.call());
                } catch (CancellationException unused) {
                    this.b.b();
                } catch (Exception e) {
                    this.b.c(e);
                }
            }
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
        h0.a();
        i = h0.b();
        g0.c();
        k = new k0<>((Object) null);
        l = new k0<>(Boolean.TRUE);
        m = new k0<>(Boolean.FALSE);
        new k0(true);
    }

    public k0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Object();
        this.h = new ArrayList();
    }

    public static f m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return j;
        }
        return (f) invokeV.objValue;
    }

    public Exception k() {
        InterceptResult invokeV;
        Exception exc;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this.a) {
                if (this.e != null) {
                    this.f = true;
                    if (this.g != null) {
                        this.g.a();
                        this.g = null;
                    }
                }
                exc = this.e;
            }
            return exc;
        }
        return (Exception) invokeV.objValue;
    }

    public TResult l() {
        InterceptResult invokeV;
        TResult tresult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this.a) {
                tresult = this.d;
            }
            return tresult;
        }
        return (TResult) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.a) {
                z = this.c;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this.a) {
                z = this.b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this.a) {
                if (k() != null) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this.a) {
                if (this.b) {
                    return false;
                }
                this.b = true;
                this.c = true;
                this.a.notifyAll();
                q();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public k0(TResult tresult) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tresult};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new Object();
        this.h = new ArrayList();
        t(tresult);
    }

    public static <TResult> k0<TResult> j(TResult tresult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, tresult)) == null) {
            if (tresult == null) {
                return (k0<TResult>) k;
            }
            if (tresult instanceof Boolean) {
                if (((Boolean) tresult).booleanValue()) {
                    return (k0<TResult>) l;
                }
                return (k0<TResult>) m;
            }
            l0 l0Var = new l0();
            l0Var.setResult(tresult);
            return l0Var.a();
        }
        return (k0) invokeL.objValue;
    }

    public boolean s(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, exc)) == null) {
            synchronized (this.a) {
                if (this.b) {
                    return false;
                }
                this.b = true;
                this.e = exc;
                this.f = false;
                this.a.notifyAll();
                q();
                if (!this.f && m() != null) {
                    this.g = new m0(this);
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = new Object();
        this.h = new ArrayList();
        if (z) {
            r();
        } else {
            t(null);
        }
    }

    public static <TContinuationResult, TResult> void c(l0<TContinuationResult> l0Var, j0<TResult, k0<TContinuationResult>> j0Var, k0<TResult> k0Var, Executor executor, i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, l0Var, j0Var, k0Var, executor, i0Var) == null) {
            try {
                executor.execute(new d(i0Var, l0Var, j0Var, k0Var));
            } catch (Exception e2) {
                l0Var.c(new ExecutorException(e2));
            }
        }
    }

    public static <TContinuationResult, TResult> void d(l0<TContinuationResult> l0Var, j0<TResult, TContinuationResult> j0Var, k0<TResult> k0Var, Executor executor, i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65547, null, l0Var, j0Var, k0Var, executor, i0Var) == null) {
            try {
                executor.execute(new c(i0Var, l0Var, j0Var, k0Var));
            } catch (Exception e2) {
                l0Var.c(new ExecutorException(e2));
            }
        }
    }

    public static <TResult> k0<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, callable)) == null) {
            return call(callable, i, null);
        }
        return (k0) invokeL.objValue;
    }

    public static <TResult> k0<TResult> i(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, exc)) == null) {
            l0 l0Var = new l0();
            l0Var.c(exc);
            return l0Var.a();
        }
        return (k0) invokeL.objValue;
    }

    public <TContinuationResult> k0<TContinuationResult> e(j0<TResult, TContinuationResult> j0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, j0Var)) == null) {
            return f(j0Var, i, null);
        }
        return (k0) invokeL.objValue;
    }

    public <TContinuationResult> k0<TContinuationResult> g(j0<TResult, k0<TContinuationResult>> j0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, j0Var)) == null) {
            return h(j0Var, i, null);
        }
        return (k0) invokeL.objValue;
    }

    public boolean t(TResult tresult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, tresult)) == null) {
            synchronized (this.a) {
                if (this.b) {
                    return false;
                }
                this.b = true;
                this.d = tresult;
                this.a.notifyAll();
                q();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static <TResult> k0<TResult> call(Callable<TResult> callable, i0 i0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, callable, i0Var)) == null) {
            return call(callable, i, i0Var);
        }
        return (k0) invokeLL.objValue;
    }

    public static <TResult> k0<TResult> call(Callable<TResult> callable, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, callable, executor)) == null) {
            return call(callable, executor, null);
        }
        return (k0) invokeLL.objValue;
    }

    public static <TResult> k0<TResult> call(Callable<TResult> callable, Executor executor, i0 i0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, callable, executor, i0Var)) == null) {
            l0 l0Var = new l0();
            try {
                executor.execute(new e(i0Var, l0Var, callable));
            } catch (Exception e2) {
                l0Var.c(new ExecutorException(e2));
            }
            return l0Var.a();
        }
        return (k0) invokeLLL.objValue;
    }

    public <TContinuationResult> k0<TContinuationResult> f(j0<TResult, TContinuationResult> j0Var, Executor executor, i0 i0Var) {
        InterceptResult invokeLLL;
        boolean o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j0Var, executor, i0Var)) == null) {
            l0 l0Var = new l0();
            synchronized (this.a) {
                o = o();
                if (!o) {
                    this.h.add(new a(this, l0Var, j0Var, executor, i0Var));
                }
            }
            if (o) {
                d(l0Var, j0Var, this, executor, i0Var);
            }
            return l0Var.a();
        }
        return (k0) invokeLLL.objValue;
    }

    public <TContinuationResult> k0<TContinuationResult> h(j0<TResult, k0<TContinuationResult>> j0Var, Executor executor, i0 i0Var) {
        InterceptResult invokeLLL;
        boolean o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, j0Var, executor, i0Var)) == null) {
            l0 l0Var = new l0();
            synchronized (this.a) {
                o = o();
                if (!o) {
                    this.h.add(new b(this, l0Var, j0Var, executor, i0Var));
                }
            }
            if (o) {
                c(l0Var, j0Var, this, executor, i0Var);
            }
            return l0Var.a();
        }
        return (k0) invokeLLL.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.a) {
                for (j0<TResult, Void> j0Var : this.h) {
                    try {
                        j0Var.then(this);
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception e3) {
                        throw new RuntimeException(e3);
                    }
                }
                this.h = null;
            }
        }
    }
}
