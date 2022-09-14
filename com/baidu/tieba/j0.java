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
/* loaded from: classes4.dex */
public class j0<TResult> {
    public static /* synthetic */ Interceptable $ic;
    public static final Executor i;
    public static volatile f j;
    public static j0<?> k;
    public static j0<Boolean> l;
    public static j0<Boolean> m;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public boolean b;
    public boolean c;
    public TResult d;
    public Exception e;
    public boolean f;
    public l0 g;
    public List<i0<TResult, Void>> h;

    /* loaded from: classes4.dex */
    public class a implements i0<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k0 a;
        public final /* synthetic */ i0 b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ h0 d;

        public a(j0 j0Var, k0 k0Var, i0 i0Var, Executor executor, h0 h0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j0Var, k0Var, i0Var, executor, h0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k0Var;
            this.b = i0Var;
            this.c = executor;
            this.d = h0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i0
        /* renamed from: a */
        public Void then(j0<TResult> j0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, j0Var)) == null) {
                j0.d(this.a, this.b, j0Var, this.c, this.d);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i0<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k0 a;
        public final /* synthetic */ i0 b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ h0 d;

        public b(j0 j0Var, k0 k0Var, i0 i0Var, Executor executor, h0 h0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j0Var, k0Var, i0Var, executor, h0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k0Var;
            this.b = i0Var;
            this.c = executor;
            this.d = h0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i0
        /* renamed from: a */
        public Void then(j0<TResult> j0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, j0Var)) == null) {
                j0.c(this.a, this.b, j0Var, this.c, this.d);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h0 a;
        public final /* synthetic */ k0 b;
        public final /* synthetic */ i0 c;
        public final /* synthetic */ j0 d;

        public c(h0 h0Var, k0 k0Var, i0 i0Var, j0 j0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h0Var, k0Var, i0Var, j0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h0Var;
            this.b = k0Var;
            this.c = i0Var;
            this.d = j0Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.k0 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h0 h0Var = this.a;
                if (h0Var != null && h0Var.a()) {
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

    /* loaded from: classes4.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h0 a;
        public final /* synthetic */ k0 b;
        public final /* synthetic */ i0 c;
        public final /* synthetic */ j0 d;

        /* loaded from: classes4.dex */
        public class a implements i0<TContinuationResult, Void> {
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
            /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.baidu.tieba.k0 */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.i0
            /* renamed from: a */
            public Void then(j0<TContinuationResult> j0Var) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, j0Var)) == null) {
                    h0 h0Var = this.a.a;
                    if (h0Var != null && h0Var.a()) {
                        this.a.b.b();
                        return null;
                    }
                    if (j0Var.n()) {
                        this.a.b.b();
                    } else if (j0Var.p()) {
                        this.a.b.c(j0Var.k());
                    } else {
                        this.a.b.setResult(j0Var.l());
                    }
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        }

        public d(h0 h0Var, k0 k0Var, i0 i0Var, j0 j0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h0Var, k0Var, i0Var, j0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h0Var;
            this.b = k0Var;
            this.c = i0Var;
            this.d = j0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h0 h0Var = this.a;
                if (h0Var != null && h0Var.a()) {
                    this.b.b();
                    return;
                }
                try {
                    j0 j0Var = (j0) this.c.then(this.d);
                    if (j0Var == null) {
                        this.b.setResult(null);
                    } else {
                        j0Var.e(new a(this));
                    }
                } catch (CancellationException unused) {
                    this.b.b();
                } catch (Exception e) {
                    this.b.c(e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h0 a;
        public final /* synthetic */ k0 b;
        public final /* synthetic */ Callable c;

        public e(h0 h0Var, k0 k0Var, Callable callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h0Var, k0Var, callable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h0Var;
            this.b = k0Var;
            this.c = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.k0 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h0 h0Var = this.a;
                if (h0Var != null && h0Var.a()) {
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

    /* loaded from: classes4.dex */
    public interface f {
        void a(j0<?> j0Var, UnobservedTaskException unobservedTaskException);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448306535, "Lcom/baidu/tieba/j0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448306535, "Lcom/baidu/tieba/j0;");
                return;
            }
        }
        g0.a();
        i = g0.b();
        f0.c();
        k = new j0<>((Object) null);
        l = new j0<>(Boolean.TRUE);
        m = new j0<>(Boolean.FALSE);
        new j0(true);
    }

    public j0() {
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

    public static <TContinuationResult, TResult> void c(k0<TContinuationResult> k0Var, i0<TResult, j0<TContinuationResult>> i0Var, j0<TResult> j0Var, Executor executor, h0 h0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, k0Var, i0Var, j0Var, executor, h0Var) == null) {
            try {
                executor.execute(new d(h0Var, k0Var, i0Var, j0Var));
            } catch (Exception e2) {
                k0Var.c(new ExecutorException(e2));
            }
        }
    }

    public static <TResult> j0<TResult> call(Callable<TResult> callable, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, callable, executor)) == null) ? call(callable, executor, null) : (j0) invokeLL.objValue;
    }

    public static <TContinuationResult, TResult> void d(k0<TContinuationResult> k0Var, i0<TResult, TContinuationResult> i0Var, j0<TResult> j0Var, Executor executor, h0 h0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65547, null, k0Var, i0Var, j0Var, executor, h0Var) == null) {
            try {
                executor.execute(new c(h0Var, k0Var, i0Var, j0Var));
            } catch (Exception e2) {
                k0Var.c(new ExecutorException(e2));
            }
        }
    }

    public static <TResult> j0<TResult> i(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, exc)) == null) {
            k0 k0Var = new k0();
            k0Var.c(exc);
            return k0Var.a();
        }
        return (j0) invokeL.objValue;
    }

    public static <TResult> j0<TResult> j(TResult tresult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, tresult)) == null) {
            if (tresult == null) {
                return (j0<TResult>) k;
            }
            if (tresult instanceof Boolean) {
                return ((Boolean) tresult).booleanValue() ? (j0<TResult>) l : (j0<TResult>) m;
            }
            k0 k0Var = new k0();
            k0Var.setResult(tresult);
            return k0Var.a();
        }
        return (j0) invokeL.objValue;
    }

    public static f m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? j : (f) invokeV.objValue;
    }

    public <TContinuationResult> j0<TContinuationResult> e(i0<TResult, TContinuationResult> i0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, i0Var)) == null) ? f(i0Var, i, null) : (j0) invokeL.objValue;
    }

    public <TContinuationResult> j0<TContinuationResult> f(i0<TResult, TContinuationResult> i0Var, Executor executor, h0 h0Var) {
        InterceptResult invokeLLL;
        boolean o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i0Var, executor, h0Var)) == null) {
            k0 k0Var = new k0();
            synchronized (this.a) {
                o = o();
                if (!o) {
                    this.h.add(new a(this, k0Var, i0Var, executor, h0Var));
                }
            }
            if (o) {
                d(k0Var, i0Var, this, executor, h0Var);
            }
            return k0Var.a();
        }
        return (j0) invokeLLL.objValue;
    }

    public <TContinuationResult> j0<TContinuationResult> g(i0<TResult, j0<TContinuationResult>> i0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i0Var)) == null) ? h(i0Var, i, null) : (j0) invokeL.objValue;
    }

    public <TContinuationResult> j0<TContinuationResult> h(i0<TResult, j0<TContinuationResult>> i0Var, Executor executor, h0 h0Var) {
        InterceptResult invokeLLL;
        boolean o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, i0Var, executor, h0Var)) == null) {
            k0 k0Var = new k0();
            synchronized (this.a) {
                o = o();
                if (!o) {
                    this.h.add(new b(this, k0Var, i0Var, executor, h0Var));
                }
            }
            if (o) {
                c(k0Var, i0Var, this, executor, h0Var);
            }
            return k0Var.a();
        }
        return (j0) invokeLLL.objValue;
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
                z = k() != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.a) {
                for (i0<TResult, Void> i0Var : this.h) {
                    try {
                        i0Var.then(this);
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
                    this.g = new l0(this);
                }
                return true;
            }
        }
        return invokeL.booleanValue;
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

    public static <TResult> j0<TResult> call(Callable<TResult> callable, Executor executor, h0 h0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, callable, executor, h0Var)) == null) {
            k0 k0Var = new k0();
            try {
                executor.execute(new e(h0Var, k0Var, callable));
            } catch (Exception e2) {
                k0Var.c(new ExecutorException(e2));
            }
            return k0Var.a();
        }
        return (j0) invokeLLL.objValue;
    }

    public j0(TResult tresult) {
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

    public static <TResult> j0<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, callable)) == null) ? call(callable, i, null) : (j0) invokeL.objValue;
    }

    public static <TResult> j0<TResult> call(Callable<TResult> callable, h0 h0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, callable, h0Var)) == null) ? call(callable, i, h0Var) : (j0) invokeLL.objValue;
    }

    public j0(boolean z) {
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
}
