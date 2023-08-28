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
/* loaded from: classes8.dex */
public class t7c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes8.dex */
    public interface c<T> extends d8c<u7c<? super T>> {
        @Override // com.baidu.tieba.d8c
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes8.dex */
    public class a extends u7c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d8c b;
        public final /* synthetic */ d8c c;

        public a(t7c t7cVar, d8c d8cVar, d8c d8cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t7cVar, d8cVar, d8cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d8cVar;
            this.c = d8cVar2;
        }

        @Override // com.baidu.tieba.u7c
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

        @Override // com.baidu.tieba.u7c
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

    /* loaded from: classes8.dex */
    public class b implements d8c<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d8c a;

        public b(t7c t7cVar, d8c d8cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t7cVar, d8cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d8cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.d8c
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public t7c(c<T> cVar) {
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
        this.a = dcc.i(cVar);
    }

    public final t7c<T> h(s7c s7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, s7cVar)) == null) {
            if (this instanceof gac) {
                return ((gac) this).n(s7cVar);
            }
            if (s7cVar != null) {
                return b(new n9c(this.a, s7cVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (t7c) invokeL.objValue;
    }

    public static <T> p7c<T> a(t7c<T> t7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, t7cVar)) == null) {
            return p7c.d(new o9c(t7cVar.a));
        }
        return (p7c) invokeL.objValue;
    }

    public static <T> t7c<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new t7c<>(cVar);
        }
        return (t7c) invokeL.objValue;
    }

    public static <T> t7c<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return gac.m(t);
        }
        return (t7c) invokeL.objValue;
    }

    public final t7c<T> e(d8c<Throwable> d8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d8cVar)) == null) {
            if (d8cVar != null) {
                return b(new k9c(this, Actions.a(), new b(this, d8cVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (t7c) invokeL.objValue;
    }

    public final t7c<T> f(d8c<? super T> d8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, d8cVar)) == null) {
            if (d8cVar != null) {
                return b(new k9c(this, d8cVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (t7c) invokeL.objValue;
    }

    public final t7c<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (t7c) invokeJL.objValue;
    }

    public final w7c k(d8c<? super T> d8cVar, d8c<Throwable> d8cVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, d8cVar, d8cVar2)) == null) {
            if (d8cVar != null) {
                if (d8cVar2 != null) {
                    return j(new a(this, d8cVar2, d8cVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (w7c) invokeLL.objValue;
    }

    public final t7c<T> d(long j, TimeUnit timeUnit, s7c s7cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, s7cVar})) == null) {
            return b(new j9c(this.a, j, timeUnit, s7cVar));
        }
        return (t7c) invokeCommon.objValue;
    }

    public final w7c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (w7c) invokeV.objValue;
    }

    public final p7c<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (p7c) invokeV.objValue;
    }

    public final w7c j(u7c<? super T> u7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, u7cVar)) == null) {
            if (u7cVar != null) {
                try {
                    dcc.t(this, this.a).call(u7cVar);
                    return dcc.s(u7cVar);
                } catch (Throwable th) {
                    b8c.e(th);
                    try {
                        u7cVar.b(dcc.r(th));
                        return tcc.b();
                    } catch (Throwable th2) {
                        b8c.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        dcc.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (w7c) invokeL.objValue;
    }
}
