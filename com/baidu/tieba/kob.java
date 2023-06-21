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
public class kob<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes6.dex */
    public interface c<T> extends uob<lob<? super T>> {
        @Override // com.baidu.tieba.uob
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes6.dex */
    public class a extends lob<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uob b;
        public final /* synthetic */ uob c;

        public a(kob kobVar, uob uobVar, uob uobVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kobVar, uobVar, uobVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uobVar;
            this.c = uobVar2;
        }

        @Override // com.baidu.tieba.lob
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

        @Override // com.baidu.tieba.lob
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
    public class b implements uob<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uob a;

        public b(kob kobVar, uob uobVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kobVar, uobVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uobVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.uob
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public kob(c<T> cVar) {
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
        this.a = qsb.i(cVar);
    }

    public final kob<T> h(job jobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jobVar)) == null) {
            if (this instanceof tqb) {
                return ((tqb) this).n(jobVar);
            }
            if (jobVar != null) {
                return b(new aqb(this.a, jobVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (kob) invokeL.objValue;
    }

    public static <T> gob<T> a(kob<T> kobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, kobVar)) == null) {
            return gob.a(new bqb(kobVar.a));
        }
        return (gob) invokeL.objValue;
    }

    public static <T> kob<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new kob<>(cVar);
        }
        return (kob) invokeL.objValue;
    }

    public static <T> kob<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return tqb.m(t);
        }
        return (kob) invokeL.objValue;
    }

    public final kob<T> e(uob<Throwable> uobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uobVar)) == null) {
            if (uobVar != null) {
                return b(new xpb(this, Actions.a(), new b(this, uobVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (kob) invokeL.objValue;
    }

    public final kob<T> f(uob<? super T> uobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, uobVar)) == null) {
            if (uobVar != null) {
                return b(new xpb(this, uobVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (kob) invokeL.objValue;
    }

    public final kob<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (kob) invokeJL.objValue;
    }

    public final nob k(uob<? super T> uobVar, uob<Throwable> uobVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, uobVar, uobVar2)) == null) {
            if (uobVar != null) {
                if (uobVar2 != null) {
                    return j(new a(this, uobVar2, uobVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (nob) invokeLL.objValue;
    }

    public final kob<T> d(long j, TimeUnit timeUnit, job jobVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, jobVar})) == null) {
            return b(new wpb(this.a, j, timeUnit, jobVar));
        }
        return (kob) invokeCommon.objValue;
    }

    public final nob i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (nob) invokeV.objValue;
    }

    public final gob<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (gob) invokeV.objValue;
    }

    public final nob j(lob<? super T> lobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, lobVar)) == null) {
            if (lobVar != null) {
                try {
                    qsb.t(this, this.a).call(lobVar);
                    return qsb.s(lobVar);
                } catch (Throwable th) {
                    sob.e(th);
                    try {
                        lobVar.b(qsb.r(th));
                        return gtb.b();
                    } catch (Throwable th2) {
                        sob.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        qsb.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (nob) invokeL.objValue;
    }
}
