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
public class r1b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes6.dex */
    public interface c<T> extends b2b<s1b<? super T>> {
        @Override // com.baidu.tieba.b2b
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes6.dex */
    public class a extends s1b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b2b b;
        public final /* synthetic */ b2b c;

        public a(r1b r1bVar, b2b b2bVar, b2b b2bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r1bVar, b2bVar, b2bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b2bVar;
            this.c = b2bVar2;
        }

        @Override // com.baidu.tieba.s1b
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

        @Override // com.baidu.tieba.s1b
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
    public class b implements b2b<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b2b a;

        public b(r1b r1bVar, b2b b2bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r1bVar, b2bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b2bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b2b
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public r1b(c<T> cVar) {
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
        this.a = u5b.i(cVar);
    }

    public final r1b<T> h(q1b q1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, q1bVar)) == null) {
            if (this instanceof x3b) {
                return ((x3b) this).n(q1bVar);
            }
            if (q1bVar != null) {
                return b(new e3b(this.a, q1bVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (r1b) invokeL.objValue;
    }

    public static <T> n1b<T> a(r1b<T> r1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, r1bVar)) == null) {
            return n1b.a(new f3b(r1bVar.a));
        }
        return (n1b) invokeL.objValue;
    }

    public static <T> r1b<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new r1b<>(cVar);
        }
        return (r1b) invokeL.objValue;
    }

    public static <T> r1b<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return x3b.m(t);
        }
        return (r1b) invokeL.objValue;
    }

    public final r1b<T> e(b2b<Throwable> b2bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2bVar)) == null) {
            if (b2bVar != null) {
                return b(new b3b(this, Actions.a(), new b(this, b2bVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (r1b) invokeL.objValue;
    }

    public final r1b<T> f(b2b<? super T> b2bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, b2bVar)) == null) {
            if (b2bVar != null) {
                return b(new b3b(this, b2bVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (r1b) invokeL.objValue;
    }

    public final r1b<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (r1b) invokeJL.objValue;
    }

    public final u1b k(b2b<? super T> b2bVar, b2b<Throwable> b2bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, b2bVar, b2bVar2)) == null) {
            if (b2bVar != null) {
                if (b2bVar2 != null) {
                    return j(new a(this, b2bVar2, b2bVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (u1b) invokeLL.objValue;
    }

    public final r1b<T> d(long j, TimeUnit timeUnit, q1b q1bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, q1bVar})) == null) {
            return b(new a3b(this.a, j, timeUnit, q1bVar));
        }
        return (r1b) invokeCommon.objValue;
    }

    public final u1b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (u1b) invokeV.objValue;
    }

    public final n1b<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (n1b) invokeV.objValue;
    }

    public final u1b j(s1b<? super T> s1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, s1bVar)) == null) {
            if (s1bVar != null) {
                try {
                    u5b.t(this, this.a).call(s1bVar);
                    return u5b.s(s1bVar);
                } catch (Throwable th) {
                    z1b.e(th);
                    try {
                        s1bVar.b(u5b.r(th));
                        return k6b.b();
                    } catch (Throwable th2) {
                        z1b.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        u5b.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (u1b) invokeL.objValue;
    }
}
