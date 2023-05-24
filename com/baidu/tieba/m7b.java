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
/* loaded from: classes6.dex */
public class m7b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes6.dex */
    public interface c<T> extends w7b<n7b<? super T>> {
        @Override // com.baidu.tieba.w7b
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes6.dex */
    public class a extends n7b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w7b b;
        public final /* synthetic */ w7b c;

        public a(m7b m7bVar, w7b w7bVar, w7b w7bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m7bVar, w7bVar, w7bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w7bVar;
            this.c = w7bVar2;
        }

        @Override // com.baidu.tieba.n7b
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

        @Override // com.baidu.tieba.n7b
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

    /* loaded from: classes6.dex */
    public class b implements w7b<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w7b a;

        public b(m7b m7bVar, w7b w7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m7bVar, w7bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w7bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.w7b
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public m7b(c<T> cVar) {
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
        this.a = sbb.i(cVar);
    }

    public final m7b<T> h(l7b l7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, l7bVar)) == null) {
            if (this instanceof v9b) {
                return ((v9b) this).n(l7bVar);
            }
            if (l7bVar != null) {
                return b(new c9b(this.a, l7bVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (m7b) invokeL.objValue;
    }

    public static <T> i7b<T> a(m7b<T> m7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, m7bVar)) == null) {
            return i7b.a(new d9b(m7bVar.a));
        }
        return (i7b) invokeL.objValue;
    }

    public static <T> m7b<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new m7b<>(cVar);
        }
        return (m7b) invokeL.objValue;
    }

    public static <T> m7b<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return v9b.m(t);
        }
        return (m7b) invokeL.objValue;
    }

    public final m7b<T> e(w7b<Throwable> w7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w7bVar)) == null) {
            if (w7bVar != null) {
                return b(new z8b(this, Actions.a(), new b(this, w7bVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (m7b) invokeL.objValue;
    }

    public final m7b<T> f(w7b<? super T> w7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, w7bVar)) == null) {
            if (w7bVar != null) {
                return b(new z8b(this, w7bVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (m7b) invokeL.objValue;
    }

    public final m7b<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (m7b) invokeJL.objValue;
    }

    public final p7b k(w7b<? super T> w7bVar, w7b<Throwable> w7bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, w7bVar, w7bVar2)) == null) {
            if (w7bVar != null) {
                if (w7bVar2 != null) {
                    return j(new a(this, w7bVar2, w7bVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (p7b) invokeLL.objValue;
    }

    public final m7b<T> d(long j, TimeUnit timeUnit, l7b l7bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, l7bVar})) == null) {
            return b(new y8b(this.a, j, timeUnit, l7bVar));
        }
        return (m7b) invokeCommon.objValue;
    }

    public final p7b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (p7b) invokeV.objValue;
    }

    public final i7b<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (i7b) invokeV.objValue;
    }

    public final p7b j(n7b<? super T> n7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, n7bVar)) == null) {
            if (n7bVar != null) {
                try {
                    sbb.t(this, this.a).call(n7bVar);
                    return sbb.s(n7bVar);
                } catch (Throwable th) {
                    u7b.e(th);
                    try {
                        n7bVar.b(sbb.r(th));
                        return icb.b();
                    } catch (Throwable th2) {
                        u7b.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        sbb.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (p7b) invokeL.objValue;
    }
}
