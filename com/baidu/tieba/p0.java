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
import java.util.concurrent.ExecutorService;
/* loaded from: classes5.dex */
public class p0<TResult> {
    public static /* synthetic */ Interceptable $ic;
    public static final ExecutorService i;
    public static final Executor j;
    public static final Executor k;
    public static volatile f l;
    public static p0<?> m;
    public static p0<Boolean> n;
    public static p0<Boolean> o;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public boolean b;
    public boolean c;
    public TResult d;
    public Exception e;
    public boolean f;
    public r0 g;
    public List<o0<TResult, Void>> h;

    /* loaded from: classes5.dex */
    public interface f {
        void a(p0<?> p0Var, UnobservedTaskException unobservedTaskException);
    }

    /* loaded from: classes5.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n0 a;
        public final /* synthetic */ q0 b;
        public final /* synthetic */ o0 c;
        public final /* synthetic */ p0 d;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* loaded from: classes5.dex */
        public class a<TContinuationResult> implements o0<TContinuationResult, Void> {
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
            @Override // com.baidu.tieba.o0
            /* renamed from: a */
            public Void then(p0<TContinuationResult> p0Var) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, p0Var)) == null) {
                    n0 n0Var = this.a.a;
                    if (n0Var != null && n0Var.a()) {
                        this.a.b.b();
                        return null;
                    }
                    if (p0Var.n()) {
                        this.a.b.b();
                    } else if (p0Var.p()) {
                        this.a.b.c(p0Var.k());
                    } else {
                        this.a.b.setResult(p0Var.l());
                    }
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        }

        public d(n0 n0Var, q0 q0Var, o0 o0Var, p0 p0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n0Var, q0Var, o0Var, p0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n0Var;
            this.b = q0Var;
            this.c = o0Var;
            this.d = p0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n0 n0Var = this.a;
                if (n0Var != null && n0Var.a()) {
                    this.b.b();
                    return;
                }
                try {
                    p0 p0Var = (p0) this.c.then(this.d);
                    if (p0Var == null) {
                        this.b.setResult(null);
                    } else {
                        p0Var.e(new a(this));
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
    public class a implements o0<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q0 a;
        public final /* synthetic */ o0 b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ n0 d;

        public a(p0 p0Var, q0 q0Var, o0 o0Var, Executor executor, n0 n0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0Var, q0Var, o0Var, executor, n0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q0Var;
            this.b = o0Var;
            this.c = executor;
            this.d = n0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o0
        /* renamed from: a */
        public Void then(p0<TResult> p0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, p0Var)) != null) {
                return (Void) invokeL.objValue;
            }
            p0.d(this.a, this.b, p0Var, this.c, this.d);
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements o0<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q0 a;
        public final /* synthetic */ o0 b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ n0 d;

        public b(p0 p0Var, q0 q0Var, o0 o0Var, Executor executor, n0 n0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0Var, q0Var, o0Var, executor, n0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q0Var;
            this.b = o0Var;
            this.c = executor;
            this.d = n0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o0
        /* renamed from: a */
        public Void then(p0<TResult> p0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, p0Var)) != null) {
                return (Void) invokeL.objValue;
            }
            p0.c(this.a, this.b, p0Var, this.c, this.d);
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n0 a;
        public final /* synthetic */ q0 b;
        public final /* synthetic */ o0 c;
        public final /* synthetic */ p0 d;

        public c(n0 n0Var, q0 q0Var, o0 o0Var, p0 p0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n0Var, q0Var, o0Var, p0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n0Var;
            this.b = q0Var;
            this.c = o0Var;
            this.d = p0Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.q0 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n0 n0Var = this.a;
                if (n0Var != null && n0Var.a()) {
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
        public final /* synthetic */ n0 a;
        public final /* synthetic */ q0 b;
        public final /* synthetic */ Callable c;

        public e(n0 n0Var, q0 q0Var, Callable callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n0Var, q0Var, callable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n0Var;
            this.b = q0Var;
            this.c = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.q0 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n0 n0Var = this.a;
                if (n0Var != null && n0Var.a()) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448312301, "Lcom/baidu/tieba/p0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448312301, "Lcom/baidu/tieba/p0;");
                return;
            }
        }
        i = m0.a();
        j = m0.b();
        k = l0.c();
        m = new p0<>((Object) null);
        n = new p0<>(Boolean.TRUE);
        o = new p0<>(Boolean.FALSE);
        new p0(true);
    }

    public p0() {
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
            return l;
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

    public p0(TResult tresult) {
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

    public static <TResult> p0<TResult> j(TResult tresult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, tresult)) == null) {
            if (tresult == null) {
                return (p0<TResult>) m;
            }
            if (tresult instanceof Boolean) {
                if (((Boolean) tresult).booleanValue()) {
                    return (p0<TResult>) n;
                }
                return (p0<TResult>) o;
            }
            q0 q0Var = new q0();
            q0Var.setResult(tresult);
            return q0Var.a();
        }
        return (p0) invokeL.objValue;
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
                    this.g = new r0(this);
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public p0(boolean z) {
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

    public static <TContinuationResult, TResult> void c(q0<TContinuationResult> q0Var, o0<TResult, p0<TContinuationResult>> o0Var, p0<TResult> p0Var, Executor executor, n0 n0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, q0Var, o0Var, p0Var, executor, n0Var) == null) {
            try {
                executor.execute(new d(n0Var, q0Var, o0Var, p0Var));
            } catch (Exception e2) {
                q0Var.c(new ExecutorException(e2));
            }
        }
    }

    public static <TContinuationResult, TResult> void d(q0<TContinuationResult> q0Var, o0<TResult, TContinuationResult> o0Var, p0<TResult> p0Var, Executor executor, n0 n0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65547, null, q0Var, o0Var, p0Var, executor, n0Var) == null) {
            try {
                executor.execute(new c(n0Var, q0Var, o0Var, p0Var));
            } catch (Exception e2) {
                q0Var.c(new ExecutorException(e2));
            }
        }
    }

    public static <TResult> p0<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, callable)) == null) {
            return call(callable, j, null);
        }
        return (p0) invokeL.objValue;
    }

    public static <TResult> p0<TResult> i(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, exc)) == null) {
            q0 q0Var = new q0();
            q0Var.c(exc);
            return q0Var.a();
        }
        return (p0) invokeL.objValue;
    }

    public <TContinuationResult> p0<TContinuationResult> e(o0<TResult, TContinuationResult> o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, o0Var)) == null) {
            return f(o0Var, j, null);
        }
        return (p0) invokeL.objValue;
    }

    public <TContinuationResult> p0<TContinuationResult> g(o0<TResult, p0<TContinuationResult>> o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, o0Var)) == null) {
            return h(o0Var, j, null);
        }
        return (p0) invokeL.objValue;
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

    public static <TResult> p0<TResult> call(Callable<TResult> callable, n0 n0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, callable, n0Var)) == null) {
            return call(callable, j, n0Var);
        }
        return (p0) invokeLL.objValue;
    }

    public static <TResult> p0<TResult> call(Callable<TResult> callable, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, callable, executor)) == null) {
            return call(callable, executor, null);
        }
        return (p0) invokeLL.objValue;
    }

    public static <TResult> p0<TResult> call(Callable<TResult> callable, Executor executor, n0 n0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, callable, executor, n0Var)) == null) {
            q0 q0Var = new q0();
            try {
                executor.execute(new e(n0Var, q0Var, callable));
            } catch (Exception e2) {
                q0Var.c(new ExecutorException(e2));
            }
            return q0Var.a();
        }
        return (p0) invokeLLL.objValue;
    }

    public <TContinuationResult> p0<TContinuationResult> f(o0<TResult, TContinuationResult> o0Var, Executor executor, n0 n0Var) {
        InterceptResult invokeLLL;
        boolean o2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o0Var, executor, n0Var)) == null) {
            q0 q0Var = new q0();
            synchronized (this.a) {
                o2 = o();
                if (!o2) {
                    this.h.add(new a(this, q0Var, o0Var, executor, n0Var));
                }
            }
            if (o2) {
                d(q0Var, o0Var, this, executor, n0Var);
            }
            return q0Var.a();
        }
        return (p0) invokeLLL.objValue;
    }

    public <TContinuationResult> p0<TContinuationResult> h(o0<TResult, p0<TContinuationResult>> o0Var, Executor executor, n0 n0Var) {
        InterceptResult invokeLLL;
        boolean o2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, o0Var, executor, n0Var)) == null) {
            q0 q0Var = new q0();
            synchronized (this.a) {
                o2 = o();
                if (!o2) {
                    this.h.add(new b(this, q0Var, o0Var, executor, n0Var));
                }
            }
            if (o2) {
                c(q0Var, o0Var, this, executor, n0Var);
            }
            return q0Var.a();
        }
        return (p0) invokeLLL.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.a) {
                for (o0<TResult, Void> o0Var : this.h) {
                    try {
                        o0Var.then(this);
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
