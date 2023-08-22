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
public class r7c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes7.dex */
    public interface c<T> extends b8c<s7c<? super T>> {
        @Override // com.baidu.tieba.b8c
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes7.dex */
    public class a extends s7c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b8c b;
        public final /* synthetic */ b8c c;

        public a(r7c r7cVar, b8c b8cVar, b8c b8cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r7cVar, b8cVar, b8cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b8cVar;
            this.c = b8cVar2;
        }

        @Override // com.baidu.tieba.s7c
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

        @Override // com.baidu.tieba.s7c
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
    public class b implements b8c<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b8c a;

        public b(r7c r7cVar, b8c b8cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r7cVar, b8cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b8cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b8c
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public r7c(c<T> cVar) {
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
        this.a = bcc.i(cVar);
    }

    public final r7c<T> h(q7c q7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, q7cVar)) == null) {
            if (this instanceof eac) {
                return ((eac) this).n(q7cVar);
            }
            if (q7cVar != null) {
                return b(new l9c(this.a, q7cVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (r7c) invokeL.objValue;
    }

    public static <T> n7c<T> a(r7c<T> r7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, r7cVar)) == null) {
            return n7c.d(new m9c(r7cVar.a));
        }
        return (n7c) invokeL.objValue;
    }

    public static <T> r7c<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new r7c<>(cVar);
        }
        return (r7c) invokeL.objValue;
    }

    public static <T> r7c<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return eac.m(t);
        }
        return (r7c) invokeL.objValue;
    }

    public final r7c<T> e(b8c<Throwable> b8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b8cVar)) == null) {
            if (b8cVar != null) {
                return b(new i9c(this, Actions.a(), new b(this, b8cVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (r7c) invokeL.objValue;
    }

    public final r7c<T> f(b8c<? super T> b8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, b8cVar)) == null) {
            if (b8cVar != null) {
                return b(new i9c(this, b8cVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (r7c) invokeL.objValue;
    }

    public final r7c<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (r7c) invokeJL.objValue;
    }

    public final u7c k(b8c<? super T> b8cVar, b8c<Throwable> b8cVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, b8cVar, b8cVar2)) == null) {
            if (b8cVar != null) {
                if (b8cVar2 != null) {
                    return j(new a(this, b8cVar2, b8cVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (u7c) invokeLL.objValue;
    }

    public final r7c<T> d(long j, TimeUnit timeUnit, q7c q7cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, q7cVar})) == null) {
            return b(new h9c(this.a, j, timeUnit, q7cVar));
        }
        return (r7c) invokeCommon.objValue;
    }

    public final u7c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (u7c) invokeV.objValue;
    }

    public final n7c<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (n7c) invokeV.objValue;
    }

    public final u7c j(s7c<? super T> s7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, s7cVar)) == null) {
            if (s7cVar != null) {
                try {
                    bcc.t(this, this.a).call(s7cVar);
                    return bcc.s(s7cVar);
                } catch (Throwable th) {
                    z7c.e(th);
                    try {
                        s7cVar.b(bcc.r(th));
                        return rcc.b();
                    } catch (Throwable th2) {
                        z7c.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        bcc.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (u7c) invokeL.objValue;
    }
}
