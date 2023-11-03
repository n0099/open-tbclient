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
/* loaded from: classes8.dex */
public class v<TResult> {
    public static /* synthetic */ Interceptable $ic;
    public static final ExecutorService i;
    public static final Executor j;
    public static final Executor k;
    public static volatile f l;
    public static v<?> m;
    public static v<Boolean> n;
    public static v<Boolean> o;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public boolean b;
    public boolean c;
    public TResult d;
    public Exception e;
    public boolean f;
    public x g;
    public List<u<TResult, Void>> h;

    /* loaded from: classes8.dex */
    public interface f {
        void a(v<?> vVar, UnobservedTaskException unobservedTaskException);
    }

    /* loaded from: classes8.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;
        public final /* synthetic */ w b;
        public final /* synthetic */ u c;
        public final /* synthetic */ v d;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* loaded from: classes8.dex */
        public class a<TContinuationResult> implements u<TContinuationResult, Void> {
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
            @Override // com.baidu.tieba.u
            /* renamed from: a */
            public Void then(v<TContinuationResult> vVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vVar)) == null) {
                    t tVar = this.a.a;
                    if (tVar != null && tVar.a()) {
                        this.a.b.b();
                        return null;
                    }
                    if (vVar.p()) {
                        this.a.b.b();
                    } else if (vVar.r()) {
                        this.a.b.c(vVar.m());
                    } else {
                        this.a.b.d(vVar.n());
                    }
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        }

        public d(t tVar, w wVar, u uVar, v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, wVar, uVar, vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
            this.b = wVar;
            this.c = uVar;
            this.d = vVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                t tVar = this.a;
                if (tVar != null && tVar.a()) {
                    this.b.b();
                    return;
                }
                try {
                    v vVar = (v) this.c.then(this.d);
                    if (vVar == null) {
                        this.b.d(null);
                    } else {
                        vVar.g(new a(this));
                    }
                } catch (CancellationException unused) {
                    this.b.b();
                } catch (Exception e) {
                    this.b.c(e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements u<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w a;
        public final /* synthetic */ u b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ t d;

        public a(v vVar, w wVar, u uVar, Executor executor, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, wVar, uVar, executor, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wVar;
            this.b = uVar;
            this.c = executor;
            this.d = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.u
        /* renamed from: a */
        public Void then(v<TResult> vVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, vVar)) != null) {
                return (Void) invokeL.objValue;
            }
            v.f(this.a, this.b, vVar, this.c, this.d);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements u<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w a;
        public final /* synthetic */ u b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ t d;

        public b(v vVar, w wVar, u uVar, Executor executor, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, wVar, uVar, executor, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wVar;
            this.b = uVar;
            this.c = executor;
            this.d = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.u
        /* renamed from: a */
        public Void then(v<TResult> vVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, vVar)) != null) {
                return (Void) invokeL.objValue;
            }
            v.e(this.a, this.b, vVar, this.c, this.d);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;
        public final /* synthetic */ w b;
        public final /* synthetic */ u c;
        public final /* synthetic */ v d;

        public c(t tVar, w wVar, u uVar, v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, wVar, uVar, vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
            this.b = wVar;
            this.c = uVar;
            this.d = vVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.w */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                t tVar = this.a;
                if (tVar != null && tVar.a()) {
                    this.b.b();
                    return;
                }
                try {
                    this.b.d(this.c.then(this.d));
                } catch (CancellationException unused) {
                    this.b.b();
                } catch (Exception e) {
                    this.b.c(e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;
        public final /* synthetic */ w b;
        public final /* synthetic */ Callable c;

        public e(t tVar, w wVar, Callable callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, wVar, callable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
            this.b = wVar;
            this.c = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.w */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                t tVar = this.a;
                if (tVar != null && tVar.a()) {
                    this.b.b();
                    return;
                }
                try {
                    this.b.d(this.c.call());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(323814611, "Lcom/baidu/tieba/v;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(323814611, "Lcom/baidu/tieba/v;");
                return;
            }
        }
        i = s.a();
        j = s.b();
        k = r.c();
        m = new v<>((Object) null);
        n = new v<>(Boolean.TRUE);
        o = new v<>(Boolean.FALSE);
        new v(true);
    }

    public v() {
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

    public static f o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return l;
        }
        return (f) invokeV.objValue;
    }

    public Exception m() {
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

    public TResult n() {
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

    public boolean p() {
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

    public boolean q() {
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

    public boolean r() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this.a) {
                if (m() != null) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean t() {
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
                s();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public v(TResult tresult) {
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
        v(tresult);
    }

    public static <TResult> v<TResult> l(TResult tresult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tresult)) == null) {
            if (tresult == null) {
                return (v<TResult>) m;
            }
            if (tresult instanceof Boolean) {
                if (((Boolean) tresult).booleanValue()) {
                    return (v<TResult>) n;
                }
                return (v<TResult>) o;
            }
            w wVar = new w();
            wVar.d(tresult);
            return wVar.a();
        }
        return (v) invokeL.objValue;
    }

    public boolean u(Exception exc) {
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
                s();
                if (!this.f && o() != null) {
                    this.g = new x(this);
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public v(boolean z) {
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
            t();
        } else {
            v(null);
        }
    }

    public static <TContinuationResult, TResult> void e(w<TContinuationResult> wVar, u<TResult, v<TContinuationResult>> uVar, v<TResult> vVar, Executor executor, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65544, null, wVar, uVar, vVar, executor, tVar) == null) {
            try {
                executor.execute(new d(tVar, wVar, uVar, vVar));
            } catch (Exception e2) {
                wVar.c(new ExecutorException(e2));
            }
        }
    }

    public static <TContinuationResult, TResult> void f(w<TContinuationResult> wVar, u<TResult, TContinuationResult> uVar, v<TResult> vVar, Executor executor, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65545, null, wVar, uVar, vVar, executor, tVar) == null) {
            try {
                executor.execute(new c(tVar, wVar, uVar, vVar));
            } catch (Exception e2) {
                wVar.c(new ExecutorException(e2));
            }
        }
    }

    public static <TResult> v<TResult> c(Callable<TResult> callable, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, callable, executor)) == null) {
            return d(callable, executor, null);
        }
        return (v) invokeLL.objValue;
    }

    public static <TResult> v<TResult> d(Callable<TResult> callable, Executor executor, t tVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, callable, executor, tVar)) == null) {
            w wVar = new w();
            try {
                executor.execute(new e(tVar, wVar, callable));
            } catch (Exception e2) {
                wVar.c(new ExecutorException(e2));
            }
            return wVar.a();
        }
        return (v) invokeLLL.objValue;
    }

    public static <TResult> v<TResult> k(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, exc)) == null) {
            w wVar = new w();
            wVar.c(exc);
            return wVar.a();
        }
        return (v) invokeL.objValue;
    }

    public <TContinuationResult> v<TContinuationResult> g(u<TResult, TContinuationResult> uVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uVar)) == null) {
            return h(uVar, j, null);
        }
        return (v) invokeL.objValue;
    }

    public <TContinuationResult> v<TContinuationResult> i(u<TResult, v<TContinuationResult>> uVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uVar)) == null) {
            return j(uVar, j, null);
        }
        return (v) invokeL.objValue;
    }

    public boolean v(TResult tresult) {
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
                s();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public <TContinuationResult> v<TContinuationResult> h(u<TResult, TContinuationResult> uVar, Executor executor, t tVar) {
        InterceptResult invokeLLL;
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uVar, executor, tVar)) == null) {
            w wVar = new w();
            synchronized (this.a) {
                q = q();
                if (!q) {
                    this.h.add(new a(this, wVar, uVar, executor, tVar));
                }
            }
            if (q) {
                f(wVar, uVar, this, executor, tVar);
            }
            return wVar.a();
        }
        return (v) invokeLLL.objValue;
    }

    public <TContinuationResult> v<TContinuationResult> j(u<TResult, v<TContinuationResult>> uVar, Executor executor, t tVar) {
        InterceptResult invokeLLL;
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, uVar, executor, tVar)) == null) {
            w wVar = new w();
            synchronized (this.a) {
                q = q();
                if (!q) {
                    this.h.add(new b(this, wVar, uVar, executor, tVar));
                }
            }
            if (q) {
                e(wVar, uVar, this, executor, tVar);
            }
            return wVar.a();
        }
        return (v) invokeLLL.objValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.a) {
                for (u<TResult, Void> uVar : this.h) {
                    try {
                        uVar.then(this);
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
