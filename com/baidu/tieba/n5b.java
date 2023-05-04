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
public class n5b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes5.dex */
    public interface c<T> extends x5b<o5b<? super T>> {
        @Override // com.baidu.tieba.x5b
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes5.dex */
    public class a extends o5b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x5b b;
        public final /* synthetic */ x5b c;

        public a(n5b n5bVar, x5b x5bVar, x5b x5bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n5bVar, x5bVar, x5bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x5bVar;
            this.c = x5bVar2;
        }

        @Override // com.baidu.tieba.o5b
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

        @Override // com.baidu.tieba.o5b
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
    public class b implements x5b<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x5b a;

        public b(n5b n5bVar, x5b x5bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n5bVar, x5bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x5bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x5b
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public n5b(c<T> cVar) {
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
        this.a = s9b.i(cVar);
    }

    public final n5b<T> h(m5b m5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, m5bVar)) == null) {
            if (this instanceof v7b) {
                return ((v7b) this).n(m5bVar);
            }
            if (m5bVar != null) {
                return b(new c7b(this.a, m5bVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (n5b) invokeL.objValue;
    }

    public static <T> j5b<T> a(n5b<T> n5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, n5bVar)) == null) {
            return j5b.a(new d7b(n5bVar.a));
        }
        return (j5b) invokeL.objValue;
    }

    public static <T> n5b<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new n5b<>(cVar);
        }
        return (n5b) invokeL.objValue;
    }

    public static <T> n5b<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return v7b.m(t);
        }
        return (n5b) invokeL.objValue;
    }

    public final n5b<T> e(x5b<Throwable> x5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x5bVar)) == null) {
            if (x5bVar != null) {
                return b(new z6b(this, Actions.a(), new b(this, x5bVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (n5b) invokeL.objValue;
    }

    public final n5b<T> f(x5b<? super T> x5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, x5bVar)) == null) {
            if (x5bVar != null) {
                return b(new z6b(this, x5bVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (n5b) invokeL.objValue;
    }

    public final n5b<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (n5b) invokeJL.objValue;
    }

    public final q5b k(x5b<? super T> x5bVar, x5b<Throwable> x5bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, x5bVar, x5bVar2)) == null) {
            if (x5bVar != null) {
                if (x5bVar2 != null) {
                    return j(new a(this, x5bVar2, x5bVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (q5b) invokeLL.objValue;
    }

    public final n5b<T> d(long j, TimeUnit timeUnit, m5b m5bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, m5bVar})) == null) {
            return b(new y6b(this.a, j, timeUnit, m5bVar));
        }
        return (n5b) invokeCommon.objValue;
    }

    public final q5b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (q5b) invokeV.objValue;
    }

    public final j5b<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (j5b) invokeV.objValue;
    }

    public final q5b j(o5b<? super T> o5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, o5bVar)) == null) {
            if (o5bVar != null) {
                try {
                    s9b.t(this, this.a).call(o5bVar);
                    return s9b.s(o5bVar);
                } catch (Throwable th) {
                    v5b.e(th);
                    try {
                        o5bVar.b(s9b.r(th));
                        return iab.b();
                    } catch (Throwable th2) {
                        v5b.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        s9b.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (q5b) invokeL.objValue;
    }
}
