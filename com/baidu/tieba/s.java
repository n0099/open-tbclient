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
/* loaded from: classes6.dex */
public class s<TResult> {
    public static /* synthetic */ Interceptable $ic;
    public static final ExecutorService i;
    public static final Executor j;
    public static final Executor k;
    public static volatile f l;
    public static s<?> m;
    public static s<Boolean> n;
    public static s<Boolean> o;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public boolean b;
    public boolean c;
    public TResult d;
    public Exception e;
    public boolean f;
    public u g;
    public List<r<TResult, Void>> h;

    /* loaded from: classes6.dex */
    public interface f {
        void a(s<?> sVar, UnobservedTaskException unobservedTaskException);
    }

    /* loaded from: classes6.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;
        public final /* synthetic */ t b;
        public final /* synthetic */ r c;
        public final /* synthetic */ s d;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* loaded from: classes6.dex */
        public class a<TContinuationResult> implements r<TContinuationResult, Void> {
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
            @Override // com.baidu.tieba.r
            /* renamed from: a */
            public Void then(s<TContinuationResult> sVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sVar)) == null) {
                    q qVar = this.a.a;
                    if (qVar != null && qVar.a()) {
                        this.a.b.b();
                        return null;
                    }
                    if (sVar.n()) {
                        this.a.b.b();
                    } else if (sVar.p()) {
                        this.a.b.c(sVar.k());
                    } else {
                        this.a.b.setResult(sVar.l());
                    }
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        }

        public d(q qVar, t tVar, r rVar, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, tVar, rVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
            this.b = tVar;
            this.c = rVar;
            this.d = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q qVar = this.a;
                if (qVar != null && qVar.a()) {
                    this.b.b();
                    return;
                }
                try {
                    s sVar = (s) this.c.then(this.d);
                    if (sVar == null) {
                        this.b.setResult(null);
                    } else {
                        sVar.e(new a(this));
                    }
                } catch (CancellationException unused) {
                    this.b.b();
                } catch (Exception e) {
                    this.b.c(e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements r<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;
        public final /* synthetic */ r b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ q d;

        public a(s sVar, t tVar, r rVar, Executor executor, q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, tVar, rVar, executor, qVar};
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
            this.b = rVar;
            this.c = executor;
            this.d = qVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.r
        /* renamed from: a */
        public Void then(s<TResult> sVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, sVar)) != null) {
                return (Void) invokeL.objValue;
            }
            s.d(this.a, this.b, sVar, this.c, this.d);
            return null;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements r<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;
        public final /* synthetic */ r b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ q d;

        public b(s sVar, t tVar, r rVar, Executor executor, q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, tVar, rVar, executor, qVar};
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
            this.b = rVar;
            this.c = executor;
            this.d = qVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.r
        /* renamed from: a */
        public Void then(s<TResult> sVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, sVar)) != null) {
                return (Void) invokeL.objValue;
            }
            s.c(this.a, this.b, sVar, this.c, this.d);
            return null;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;
        public final /* synthetic */ t b;
        public final /* synthetic */ r c;
        public final /* synthetic */ s d;

        public c(q qVar, t tVar, r rVar, s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, tVar, rVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
            this.b = tVar;
            this.c = rVar;
            this.d = sVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.t */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q qVar = this.a;
                if (qVar != null && qVar.a()) {
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

    /* loaded from: classes6.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;
        public final /* synthetic */ t b;
        public final /* synthetic */ Callable c;

        public e(q qVar, t tVar, Callable callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, tVar, callable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
            this.b = tVar;
            this.c = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.t */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q qVar = this.a;
                if (qVar != null && qVar.a()) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(323814518, "Lcom/baidu/tieba/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(323814518, "Lcom/baidu/tieba/s;");
                return;
            }
        }
        i = p.a();
        j = p.b();
        k = o.c();
        m = new s<>((Object) null);
        n = new s<>(Boolean.TRUE);
        o = new s<>(Boolean.FALSE);
        new s(true);
    }

    public s() {
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

    public s(TResult tresult) {
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

    public static <TResult> s<TResult> j(TResult tresult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, tresult)) == null) {
            if (tresult == null) {
                return (s<TResult>) m;
            }
            if (tresult instanceof Boolean) {
                if (((Boolean) tresult).booleanValue()) {
                    return (s<TResult>) n;
                }
                return (s<TResult>) o;
            }
            t tVar = new t();
            tVar.setResult(tresult);
            return tVar.a();
        }
        return (s) invokeL.objValue;
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
                    this.g = new u(this);
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public s(boolean z) {
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

    public static <TContinuationResult, TResult> void c(t<TContinuationResult> tVar, r<TResult, s<TContinuationResult>> rVar, s<TResult> sVar, Executor executor, q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, tVar, rVar, sVar, executor, qVar) == null) {
            try {
                executor.execute(new d(qVar, tVar, rVar, sVar));
            } catch (Exception e2) {
                tVar.c(new ExecutorException(e2));
            }
        }
    }

    public static <TContinuationResult, TResult> void d(t<TContinuationResult> tVar, r<TResult, TContinuationResult> rVar, s<TResult> sVar, Executor executor, q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65547, null, tVar, rVar, sVar, executor, qVar) == null) {
            try {
                executor.execute(new c(qVar, tVar, rVar, sVar));
            } catch (Exception e2) {
                tVar.c(new ExecutorException(e2));
            }
        }
    }

    public static <TResult> s<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, callable)) == null) {
            return call(callable, j, null);
        }
        return (s) invokeL.objValue;
    }

    public static <TResult> s<TResult> i(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, exc)) == null) {
            t tVar = new t();
            tVar.c(exc);
            return tVar.a();
        }
        return (s) invokeL.objValue;
    }

    public <TContinuationResult> s<TContinuationResult> e(r<TResult, TContinuationResult> rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rVar)) == null) {
            return f(rVar, j, null);
        }
        return (s) invokeL.objValue;
    }

    public <TContinuationResult> s<TContinuationResult> g(r<TResult, s<TContinuationResult>> rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rVar)) == null) {
            return h(rVar, j, null);
        }
        return (s) invokeL.objValue;
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

    public static <TResult> s<TResult> call(Callable<TResult> callable, q qVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, callable, qVar)) == null) {
            return call(callable, j, qVar);
        }
        return (s) invokeLL.objValue;
    }

    public static <TResult> s<TResult> call(Callable<TResult> callable, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, callable, executor)) == null) {
            return call(callable, executor, null);
        }
        return (s) invokeLL.objValue;
    }

    public static <TResult> s<TResult> call(Callable<TResult> callable, Executor executor, q qVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, callable, executor, qVar)) == null) {
            t tVar = new t();
            try {
                executor.execute(new e(qVar, tVar, callable));
            } catch (Exception e2) {
                tVar.c(new ExecutorException(e2));
            }
            return tVar.a();
        }
        return (s) invokeLLL.objValue;
    }

    public <TContinuationResult> s<TContinuationResult> f(r<TResult, TContinuationResult> rVar, Executor executor, q qVar) {
        InterceptResult invokeLLL;
        boolean o2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rVar, executor, qVar)) == null) {
            t tVar = new t();
            synchronized (this.a) {
                o2 = o();
                if (!o2) {
                    this.h.add(new a(this, tVar, rVar, executor, qVar));
                }
            }
            if (o2) {
                d(tVar, rVar, this, executor, qVar);
            }
            return tVar.a();
        }
        return (s) invokeLLL.objValue;
    }

    public <TContinuationResult> s<TContinuationResult> h(r<TResult, s<TContinuationResult>> rVar, Executor executor, q qVar) {
        InterceptResult invokeLLL;
        boolean o2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, rVar, executor, qVar)) == null) {
            t tVar = new t();
            synchronized (this.a) {
                o2 = o();
                if (!o2) {
                    this.h.add(new b(this, tVar, rVar, executor, qVar));
                }
            }
            if (o2) {
                c(tVar, rVar, this, executor, qVar);
            }
            return tVar.a();
        }
        return (s) invokeLLL.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.a) {
                for (r<TResult, Void> rVar : this.h) {
                    try {
                        rVar.then(this);
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
