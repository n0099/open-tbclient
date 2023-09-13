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
public class u<TResult> {
    public static /* synthetic */ Interceptable $ic;
    public static final ExecutorService i;
    public static final Executor j;
    public static final Executor k;
    public static volatile f l;
    public static u<?> m;
    public static u<Boolean> n;
    public static u<Boolean> o;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public boolean b;
    public boolean c;
    public TResult d;
    public Exception e;
    public boolean f;
    public w g;
    public List<t<TResult, Void>> h;

    /* loaded from: classes8.dex */
    public interface f {
        void a(u<?> uVar, UnobservedTaskException unobservedTaskException);
    }

    /* loaded from: classes8.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;
        public final /* synthetic */ v b;
        public final /* synthetic */ t c;
        public final /* synthetic */ u d;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* loaded from: classes8.dex */
        public class a<TContinuationResult> implements t<TContinuationResult, Void> {
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
            @Override // com.baidu.tieba.t
            /* renamed from: a */
            public Void then(u<TContinuationResult> uVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uVar)) == null) {
                    s sVar = this.a.a;
                    if (sVar != null && sVar.a()) {
                        this.a.b.b();
                        return null;
                    }
                    if (uVar.n()) {
                        this.a.b.b();
                    } else if (uVar.p()) {
                        this.a.b.c(uVar.k());
                    } else {
                        this.a.b.setResult(uVar.l());
                    }
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        }

        public d(s sVar, v vVar, t tVar, u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, vVar, tVar, uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
            this.b = vVar;
            this.c = tVar;
            this.d = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s sVar = this.a;
                if (sVar != null && sVar.a()) {
                    this.b.b();
                    return;
                }
                try {
                    u uVar = (u) this.c.then(this.d);
                    if (uVar == null) {
                        this.b.setResult(null);
                    } else {
                        uVar.e(new a(this));
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
    public class a implements t<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v a;
        public final /* synthetic */ t b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ s d;

        public a(u uVar, v vVar, t tVar, Executor executor, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, vVar, tVar, executor, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vVar;
            this.b = tVar;
            this.c = executor;
            this.d = sVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.t
        /* renamed from: a */
        public Void then(u<TResult> uVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, uVar)) != null) {
                return (Void) invokeL.objValue;
            }
            u.d(this.a, this.b, uVar, this.c, this.d);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements t<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v a;
        public final /* synthetic */ t b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ s d;

        public b(u uVar, v vVar, t tVar, Executor executor, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, vVar, tVar, executor, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vVar;
            this.b = tVar;
            this.c = executor;
            this.d = sVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.t
        /* renamed from: a */
        public Void then(u<TResult> uVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, uVar)) != null) {
                return (Void) invokeL.objValue;
            }
            u.c(this.a, this.b, uVar, this.c, this.d);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;
        public final /* synthetic */ v b;
        public final /* synthetic */ t c;
        public final /* synthetic */ u d;

        public c(s sVar, v vVar, t tVar, u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, vVar, tVar, uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
            this.b = vVar;
            this.c = tVar;
            this.d = uVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.v */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s sVar = this.a;
                if (sVar != null && sVar.a()) {
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

    /* loaded from: classes8.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;
        public final /* synthetic */ v b;
        public final /* synthetic */ Callable c;

        public e(s sVar, v vVar, Callable callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, vVar, callable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
            this.b = vVar;
            this.c = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.v */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s sVar = this.a;
                if (sVar != null && sVar.a()) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(323814580, "Lcom/baidu/tieba/u;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(323814580, "Lcom/baidu/tieba/u;");
                return;
            }
        }
        i = r.a();
        j = r.b();
        k = q.c();
        m = new u<>((Object) null);
        n = new u<>(Boolean.TRUE);
        o = new u<>(Boolean.FALSE);
        new u(true);
    }

    public u() {
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

    public u(TResult tresult) {
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

    public static <TResult> u<TResult> j(TResult tresult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, tresult)) == null) {
            if (tresult == null) {
                return (u<TResult>) m;
            }
            if (tresult instanceof Boolean) {
                if (((Boolean) tresult).booleanValue()) {
                    return (u<TResult>) n;
                }
                return (u<TResult>) o;
            }
            v vVar = new v();
            vVar.setResult(tresult);
            return vVar.a();
        }
        return (u) invokeL.objValue;
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
                    this.g = new w(this);
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public u(boolean z) {
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

    public static <TContinuationResult, TResult> void c(v<TContinuationResult> vVar, t<TResult, u<TContinuationResult>> tVar, u<TResult> uVar, Executor executor, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, vVar, tVar, uVar, executor, sVar) == null) {
            try {
                executor.execute(new d(sVar, vVar, tVar, uVar));
            } catch (Exception e2) {
                vVar.c(new ExecutorException(e2));
            }
        }
    }

    public static <TContinuationResult, TResult> void d(v<TContinuationResult> vVar, t<TResult, TContinuationResult> tVar, u<TResult> uVar, Executor executor, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65547, null, vVar, tVar, uVar, executor, sVar) == null) {
            try {
                executor.execute(new c(sVar, vVar, tVar, uVar));
            } catch (Exception e2) {
                vVar.c(new ExecutorException(e2));
            }
        }
    }

    public static <TResult> u<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, callable)) == null) {
            return call(callable, j, null);
        }
        return (u) invokeL.objValue;
    }

    public static <TResult> u<TResult> i(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, exc)) == null) {
            v vVar = new v();
            vVar.c(exc);
            return vVar.a();
        }
        return (u) invokeL.objValue;
    }

    public <TContinuationResult> u<TContinuationResult> e(t<TResult, TContinuationResult> tVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tVar)) == null) {
            return f(tVar, j, null);
        }
        return (u) invokeL.objValue;
    }

    public <TContinuationResult> u<TContinuationResult> g(t<TResult, u<TContinuationResult>> tVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tVar)) == null) {
            return h(tVar, j, null);
        }
        return (u) invokeL.objValue;
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

    public static <TResult> u<TResult> call(Callable<TResult> callable, s sVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, callable, sVar)) == null) {
            return call(callable, j, sVar);
        }
        return (u) invokeLL.objValue;
    }

    public static <TResult> u<TResult> call(Callable<TResult> callable, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, callable, executor)) == null) {
            return call(callable, executor, null);
        }
        return (u) invokeLL.objValue;
    }

    public static <TResult> u<TResult> call(Callable<TResult> callable, Executor executor, s sVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, callable, executor, sVar)) == null) {
            v vVar = new v();
            try {
                executor.execute(new e(sVar, vVar, callable));
            } catch (Exception e2) {
                vVar.c(new ExecutorException(e2));
            }
            return vVar.a();
        }
        return (u) invokeLLL.objValue;
    }

    public <TContinuationResult> u<TContinuationResult> f(t<TResult, TContinuationResult> tVar, Executor executor, s sVar) {
        InterceptResult invokeLLL;
        boolean o2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tVar, executor, sVar)) == null) {
            v vVar = new v();
            synchronized (this.a) {
                o2 = o();
                if (!o2) {
                    this.h.add(new a(this, vVar, tVar, executor, sVar));
                }
            }
            if (o2) {
                d(vVar, tVar, this, executor, sVar);
            }
            return vVar.a();
        }
        return (u) invokeLLL.objValue;
    }

    public <TContinuationResult> u<TContinuationResult> h(t<TResult, u<TContinuationResult>> tVar, Executor executor, s sVar) {
        InterceptResult invokeLLL;
        boolean o2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, tVar, executor, sVar)) == null) {
            v vVar = new v();
            synchronized (this.a) {
                o2 = o();
                if (!o2) {
                    this.h.add(new b(this, vVar, tVar, executor, sVar));
                }
            }
            if (o2) {
                c(vVar, tVar, this, executor, sVar);
            }
            return vVar.a();
        }
        return (u) invokeLLL.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.a) {
                for (t<TResult, Void> tVar : this.h) {
                    try {
                        tVar.then(this);
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
