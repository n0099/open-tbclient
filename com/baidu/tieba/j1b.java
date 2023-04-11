package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import rx.functions.Actions;
import rx.schedulers.Schedulers;
/* loaded from: classes5.dex */
public class j1b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes5.dex */
    public interface c<T> extends t1b<k1b<? super T>> {
        @Override // com.baidu.tieba.t1b
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes5.dex */
    public class a extends k1b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t1b b;
        public final /* synthetic */ t1b c;

        public a(j1b j1bVar, t1b t1bVar, t1b t1bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j1bVar, t1bVar, t1bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t1bVar;
            this.c = t1bVar2;
        }

        @Override // com.baidu.tieba.k1b
        public final void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.b.call(th);
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // com.baidu.tieba.k1b
        public final void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                } finally {
                    unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements t1b<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t1b a;

        public b(j1b j1bVar, t1b t1bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j1bVar, t1bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t1bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.t1b
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public j1b(c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = m5b.i(cVar);
    }

    public final j1b<T> h(i1b i1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, i1bVar)) == null) {
            if (this instanceof p3b) {
                return ((p3b) this).n(i1bVar);
            }
            if (i1bVar != null) {
                return b(new w2b(this.a, i1bVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (j1b) invokeL.objValue;
    }

    public static <T> f1b<T> a(j1b<T> j1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, j1bVar)) == null) {
            return f1b.a(new x2b(j1bVar.a));
        }
        return (f1b) invokeL.objValue;
    }

    public static <T> j1b<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new j1b<>(cVar);
        }
        return (j1b) invokeL.objValue;
    }

    public static <T> j1b<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return p3b.m(t);
        }
        return (j1b) invokeL.objValue;
    }

    public final j1b<T> e(t1b<Throwable> t1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t1bVar)) == null) {
            if (t1bVar != null) {
                return b(new t2b(this, Actions.a(), new b(this, t1bVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (j1b) invokeL.objValue;
    }

    public final j1b<T> f(t1b<? super T> t1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t1bVar)) == null) {
            if (t1bVar != null) {
                return b(new t2b(this, t1bVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (j1b) invokeL.objValue;
    }

    public final j1b<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (j1b) invokeJL.objValue;
    }

    public final m1b k(t1b<? super T> t1bVar, t1b<Throwable> t1bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, t1bVar, t1bVar2)) == null) {
            if (t1bVar != null) {
                if (t1bVar2 != null) {
                    return j(new a(this, t1bVar2, t1bVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (m1b) invokeLL.objValue;
    }

    public final j1b<T> d(long j, TimeUnit timeUnit, i1b i1bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, i1bVar})) == null) {
            return b(new s2b(this.a, j, timeUnit, i1bVar));
        }
        return (j1b) invokeCommon.objValue;
    }

    public final m1b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (m1b) invokeV.objValue;
    }

    public final f1b<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (f1b) invokeV.objValue;
    }

    public final m1b j(k1b<? super T> k1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k1bVar)) == null) {
            if (k1bVar != null) {
                try {
                    m5b.t(this, this.a).call(k1bVar);
                    return m5b.s(k1bVar);
                } catch (Throwable th) {
                    r1b.e(th);
                    try {
                        k1bVar.b(m5b.r(th));
                        return c6b.b();
                    } catch (Throwable th2) {
                        r1b.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        m5b.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (m1b) invokeL.objValue;
    }
}
