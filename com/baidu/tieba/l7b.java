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
public class l7b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes6.dex */
    public interface c<T> extends v7b<m7b<? super T>> {
        @Override // com.baidu.tieba.v7b
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes6.dex */
    public class a extends m7b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v7b b;
        public final /* synthetic */ v7b c;

        public a(l7b l7bVar, v7b v7bVar, v7b v7bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l7bVar, v7bVar, v7bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v7bVar;
            this.c = v7bVar2;
        }

        @Override // com.baidu.tieba.m7b
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

        @Override // com.baidu.tieba.m7b
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
    public class b implements v7b<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v7b a;

        public b(l7b l7bVar, v7b v7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l7bVar, v7bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v7bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v7b
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public l7b(c<T> cVar) {
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
        this.a = rbb.i(cVar);
    }

    public final l7b<T> h(k7b k7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, k7bVar)) == null) {
            if (this instanceof u9b) {
                return ((u9b) this).n(k7bVar);
            }
            if (k7bVar != null) {
                return b(new b9b(this.a, k7bVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (l7b) invokeL.objValue;
    }

    public static <T> h7b<T> a(l7b<T> l7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, l7bVar)) == null) {
            return h7b.a(new c9b(l7bVar.a));
        }
        return (h7b) invokeL.objValue;
    }

    public static <T> l7b<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new l7b<>(cVar);
        }
        return (l7b) invokeL.objValue;
    }

    public static <T> l7b<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return u9b.m(t);
        }
        return (l7b) invokeL.objValue;
    }

    public final l7b<T> e(v7b<Throwable> v7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v7bVar)) == null) {
            if (v7bVar != null) {
                return b(new y8b(this, Actions.a(), new b(this, v7bVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (l7b) invokeL.objValue;
    }

    public final l7b<T> f(v7b<? super T> v7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, v7bVar)) == null) {
            if (v7bVar != null) {
                return b(new y8b(this, v7bVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (l7b) invokeL.objValue;
    }

    public final l7b<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (l7b) invokeJL.objValue;
    }

    public final o7b k(v7b<? super T> v7bVar, v7b<Throwable> v7bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, v7bVar, v7bVar2)) == null) {
            if (v7bVar != null) {
                if (v7bVar2 != null) {
                    return j(new a(this, v7bVar2, v7bVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (o7b) invokeLL.objValue;
    }

    public final l7b<T> d(long j, TimeUnit timeUnit, k7b k7bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, k7bVar})) == null) {
            return b(new x8b(this.a, j, timeUnit, k7bVar));
        }
        return (l7b) invokeCommon.objValue;
    }

    public final o7b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (o7b) invokeV.objValue;
    }

    public final h7b<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (h7b) invokeV.objValue;
    }

    public final o7b j(m7b<? super T> m7bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, m7bVar)) == null) {
            if (m7bVar != null) {
                try {
                    rbb.t(this, this.a).call(m7bVar);
                    return rbb.s(m7bVar);
                } catch (Throwable th) {
                    t7b.e(th);
                    try {
                        m7bVar.b(rbb.r(th));
                        return hcb.b();
                    } catch (Throwable th2) {
                        t7b.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        rbb.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (o7b) invokeL.objValue;
    }
}
