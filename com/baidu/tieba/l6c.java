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
/* loaded from: classes7.dex */
public class l6c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes7.dex */
    public interface c<T> extends v6c<m6c<? super T>> {
    }

    /* loaded from: classes7.dex */
    public class a extends m6c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v6c b;
        public final /* synthetic */ v6c c;

        public a(l6c l6cVar, v6c v6cVar, v6c v6cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l6cVar, v6cVar, v6cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v6cVar;
            this.c = v6cVar2;
        }

        @Override // com.baidu.tieba.m6c
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

        @Override // com.baidu.tieba.m6c
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

    /* loaded from: classes7.dex */
    public class b implements v6c<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v6c a;

        public b(l6c l6cVar, v6c v6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l6cVar, v6cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v6cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: a */
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public l6c(c<T> cVar) {
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
        this.a = xac.i(cVar);
    }

    public final l6c<T> h(k6c k6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, k6cVar)) == null) {
            if (this instanceof a9c) {
                return ((a9c) this).n(k6cVar);
            }
            if (k6cVar != null) {
                return b(new h8c(this.a, k6cVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (l6c) invokeL.objValue;
    }

    public static <T> h6c<T> a(l6c<T> l6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, l6cVar)) == null) {
            return h6c.d(new i8c(l6cVar.a));
        }
        return (h6c) invokeL.objValue;
    }

    public static <T> l6c<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new l6c<>(cVar);
        }
        return (l6c) invokeL.objValue;
    }

    public static <T> l6c<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return a9c.m(t);
        }
        return (l6c) invokeL.objValue;
    }

    public final l6c<T> e(v6c<Throwable> v6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v6cVar)) == null) {
            if (v6cVar != null) {
                return b(new e8c(this, Actions.a(), new b(this, v6cVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (l6c) invokeL.objValue;
    }

    public final l6c<T> f(v6c<? super T> v6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, v6cVar)) == null) {
            if (v6cVar != null) {
                return b(new e8c(this, v6cVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (l6c) invokeL.objValue;
    }

    public final l6c<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (l6c) invokeJL.objValue;
    }

    public final o6c k(v6c<? super T> v6cVar, v6c<Throwable> v6cVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, v6cVar, v6cVar2)) == null) {
            if (v6cVar != null) {
                if (v6cVar2 != null) {
                    return j(new a(this, v6cVar2, v6cVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (o6c) invokeLL.objValue;
    }

    public final l6c<T> d(long j, TimeUnit timeUnit, k6c k6cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, k6cVar})) == null) {
            return b(new d8c(this.a, j, timeUnit, k6cVar));
        }
        return (l6c) invokeCommon.objValue;
    }

    public final o6c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (o6c) invokeV.objValue;
    }

    public final h6c<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (h6c) invokeV.objValue;
    }

    public final o6c j(m6c<? super T> m6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, m6cVar)) == null) {
            if (m6cVar != null) {
                try {
                    xac.t(this, this.a).call(m6cVar);
                    return xac.s(m6cVar);
                } catch (Throwable th) {
                    t6c.e(th);
                    try {
                        m6cVar.b(xac.r(th));
                        return nbc.b();
                    } catch (Throwable th2) {
                        t6c.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        xac.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (o6c) invokeL.objValue;
    }
}
