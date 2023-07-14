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
public class t<TResult> {
    public static /* synthetic */ Interceptable $ic;
    public static final ExecutorService i;
    public static final Executor j;
    public static final Executor k;
    public static volatile f l;
    public static t<?> m;
    public static t<Boolean> n;
    public static t<Boolean> o;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public boolean b;
    public boolean c;
    public TResult d;
    public Exception e;
    public boolean f;
    public v g;
    public List<s<TResult, Void>> h;

    /* loaded from: classes8.dex */
    public interface f {
        void a(t<?> tVar, UnobservedTaskException unobservedTaskException);
    }

    /* loaded from: classes8.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;
        public final /* synthetic */ u b;
        public final /* synthetic */ s c;
        public final /* synthetic */ t d;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* loaded from: classes8.dex */
        public class a<TContinuationResult> implements s<TContinuationResult, Void> {
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
            @Override // com.baidu.tieba.s
            /* renamed from: a */
            public Void then(t<TContinuationResult> tVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tVar)) == null) {
                    r rVar = this.a.a;
                    if (rVar != null && rVar.a()) {
                        this.a.b.b();
                        return null;
                    }
                    if (tVar.n()) {
                        this.a.b.b();
                    } else if (tVar.p()) {
                        this.a.b.c(tVar.k());
                    } else {
                        this.a.b.setResult(tVar.l());
                    }
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        }

        public d(r rVar, u uVar, s sVar, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, uVar, sVar, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
            this.b = uVar;
            this.c = sVar;
            this.d = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r rVar = this.a;
                if (rVar != null && rVar.a()) {
                    this.b.b();
                    return;
                }
                try {
                    t tVar = (t) this.c.then(this.d);
                    if (tVar == null) {
                        this.b.setResult(null);
                    } else {
                        tVar.e(new a(this));
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
    public class a implements s<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u a;
        public final /* synthetic */ s b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ r d;

        public a(t tVar, u uVar, s sVar, Executor executor, r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, uVar, sVar, executor, rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uVar;
            this.b = sVar;
            this.c = executor;
            this.d = rVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.s
        /* renamed from: a */
        public Void then(t<TResult> tVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, tVar)) != null) {
                return (Void) invokeL.objValue;
            }
            t.d(this.a, this.b, tVar, this.c, this.d);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements s<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u a;
        public final /* synthetic */ s b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ r d;

        public b(t tVar, u uVar, s sVar, Executor executor, r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, uVar, sVar, executor, rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uVar;
            this.b = sVar;
            this.c = executor;
            this.d = rVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.s
        /* renamed from: a */
        public Void then(t<TResult> tVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, tVar)) != null) {
                return (Void) invokeL.objValue;
            }
            t.c(this.a, this.b, tVar, this.c, this.d);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;
        public final /* synthetic */ u b;
        public final /* synthetic */ s c;
        public final /* synthetic */ t d;

        public c(r rVar, u uVar, s sVar, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, uVar, sVar, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
            this.b = uVar;
            this.c = sVar;
            this.d = tVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.u */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r rVar = this.a;
                if (rVar != null && rVar.a()) {
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
        public final /* synthetic */ r a;
        public final /* synthetic */ u b;
        public final /* synthetic */ Callable c;

        public e(r rVar, u uVar, Callable callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, uVar, callable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
            this.b = uVar;
            this.c = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.u */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r rVar = this.a;
                if (rVar != null && rVar.a()) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(323814549, "Lcom/baidu/tieba/t;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(323814549, "Lcom/baidu/tieba/t;");
                return;
            }
        }
        i = q.a();
        j = q.b();
        k = p.c();
        m = new t<>((Object) null);
        n = new t<>(Boolean.TRUE);
        o = new t<>(Boolean.FALSE);
        new t(true);
    }

    public t() {
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

    public t(TResult tresult) {
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

    public static <TResult> t<TResult> j(TResult tresult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, tresult)) == null) {
            if (tresult == null) {
                return (t<TResult>) m;
            }
            if (tresult instanceof Boolean) {
                if (((Boolean) tresult).booleanValue()) {
                    return (t<TResult>) n;
                }
                return (t<TResult>) o;
            }
            u uVar = new u();
            uVar.setResult(tresult);
            return uVar.a();
        }
        return (t) invokeL.objValue;
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
                    this.g = new v(this);
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public t(boolean z) {
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

    public static <TContinuationResult, TResult> void c(u<TContinuationResult> uVar, s<TResult, t<TContinuationResult>> sVar, t<TResult> tVar, Executor executor, r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, uVar, sVar, tVar, executor, rVar) == null) {
            try {
                executor.execute(new d(rVar, uVar, sVar, tVar));
            } catch (Exception e2) {
                uVar.c(new ExecutorException(e2));
            }
        }
    }

    public static <TContinuationResult, TResult> void d(u<TContinuationResult> uVar, s<TResult, TContinuationResult> sVar, t<TResult> tVar, Executor executor, r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65547, null, uVar, sVar, tVar, executor, rVar) == null) {
            try {
                executor.execute(new c(rVar, uVar, sVar, tVar));
            } catch (Exception e2) {
                uVar.c(new ExecutorException(e2));
            }
        }
    }

    public static <TResult> t<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, callable)) == null) {
            return call(callable, j, null);
        }
        return (t) invokeL.objValue;
    }

    public static <TResult> t<TResult> i(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, exc)) == null) {
            u uVar = new u();
            uVar.c(exc);
            return uVar.a();
        }
        return (t) invokeL.objValue;
    }

    public <TContinuationResult> t<TContinuationResult> e(s<TResult, TContinuationResult> sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sVar)) == null) {
            return f(sVar, j, null);
        }
        return (t) invokeL.objValue;
    }

    public <TContinuationResult> t<TContinuationResult> g(s<TResult, t<TContinuationResult>> sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sVar)) == null) {
            return h(sVar, j, null);
        }
        return (t) invokeL.objValue;
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

    public static <TResult> t<TResult> call(Callable<TResult> callable, r rVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, callable, rVar)) == null) {
            return call(callable, j, rVar);
        }
        return (t) invokeLL.objValue;
    }

    public static <TResult> t<TResult> call(Callable<TResult> callable, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, callable, executor)) == null) {
            return call(callable, executor, null);
        }
        return (t) invokeLL.objValue;
    }

    public static <TResult> t<TResult> call(Callable<TResult> callable, Executor executor, r rVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, callable, executor, rVar)) == null) {
            u uVar = new u();
            try {
                executor.execute(new e(rVar, uVar, callable));
            } catch (Exception e2) {
                uVar.c(new ExecutorException(e2));
            }
            return uVar.a();
        }
        return (t) invokeLLL.objValue;
    }

    public <TContinuationResult> t<TContinuationResult> f(s<TResult, TContinuationResult> sVar, Executor executor, r rVar) {
        InterceptResult invokeLLL;
        boolean o2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sVar, executor, rVar)) == null) {
            u uVar = new u();
            synchronized (this.a) {
                o2 = o();
                if (!o2) {
                    this.h.add(new a(this, uVar, sVar, executor, rVar));
                }
            }
            if (o2) {
                d(uVar, sVar, this, executor, rVar);
            }
            return uVar.a();
        }
        return (t) invokeLLL.objValue;
    }

    public <TContinuationResult> t<TContinuationResult> h(s<TResult, t<TContinuationResult>> sVar, Executor executor, r rVar) {
        InterceptResult invokeLLL;
        boolean o2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, sVar, executor, rVar)) == null) {
            u uVar = new u();
            synchronized (this.a) {
                o2 = o();
                if (!o2) {
                    this.h.add(new b(this, uVar, sVar, executor, rVar));
                }
            }
            if (o2) {
                c(uVar, sVar, this, executor, rVar);
            }
            return uVar.a();
        }
        return (t) invokeLLL.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.a) {
                for (s<TResult, Void> sVar : this.h) {
                    try {
                        sVar.then(this);
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
