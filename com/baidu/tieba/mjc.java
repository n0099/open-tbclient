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
public class mjc<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes7.dex */
    public interface c<T> extends wjc<njc<? super T>> {
    }

    /* loaded from: classes7.dex */
    public class a extends njc<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wjc b;
        public final /* synthetic */ wjc c;

        public a(mjc mjcVar, wjc wjcVar, wjc wjcVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mjcVar, wjcVar, wjcVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wjcVar;
            this.c = wjcVar2;
        }

        @Override // com.baidu.tieba.njc
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

        @Override // com.baidu.tieba.njc
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
    public class b implements wjc<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wjc a;

        public b(mjc mjcVar, wjc wjcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mjcVar, wjcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wjcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wjc
        /* renamed from: a */
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public mjc(c<T> cVar) {
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
        this.a = ync.i(cVar);
    }

    public final mjc<T> h(ljc ljcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ljcVar)) == null) {
            if (this instanceof bmc) {
                return ((bmc) this).n(ljcVar);
            }
            if (ljcVar != null) {
                return b(new ilc(this.a, ljcVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (mjc) invokeL.objValue;
    }

    public static <T> ijc<T> a(mjc<T> mjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mjcVar)) == null) {
            return ijc.d(new jlc(mjcVar.a));
        }
        return (ijc) invokeL.objValue;
    }

    public static <T> mjc<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new mjc<>(cVar);
        }
        return (mjc) invokeL.objValue;
    }

    public static <T> mjc<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return bmc.m(t);
        }
        return (mjc) invokeL.objValue;
    }

    public final mjc<T> e(wjc<Throwable> wjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wjcVar)) == null) {
            if (wjcVar != null) {
                return b(new flc(this, Actions.a(), new b(this, wjcVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (mjc) invokeL.objValue;
    }

    public final mjc<T> f(wjc<? super T> wjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, wjcVar)) == null) {
            if (wjcVar != null) {
                return b(new flc(this, wjcVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (mjc) invokeL.objValue;
    }

    public final mjc<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (mjc) invokeJL.objValue;
    }

    public final pjc k(wjc<? super T> wjcVar, wjc<Throwable> wjcVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, wjcVar, wjcVar2)) == null) {
            if (wjcVar != null) {
                if (wjcVar2 != null) {
                    return j(new a(this, wjcVar2, wjcVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (pjc) invokeLL.objValue;
    }

    public final mjc<T> d(long j, TimeUnit timeUnit, ljc ljcVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, ljcVar})) == null) {
            return b(new elc(this.a, j, timeUnit, ljcVar));
        }
        return (mjc) invokeCommon.objValue;
    }

    public final pjc i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (pjc) invokeV.objValue;
    }

    public final ijc<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (ijc) invokeV.objValue;
    }

    public final pjc j(njc<? super T> njcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, njcVar)) == null) {
            if (njcVar != null) {
                try {
                    ync.t(this, this.a).call(njcVar);
                    return ync.s(njcVar);
                } catch (Throwable th) {
                    ujc.e(th);
                    try {
                        njcVar.b(ync.r(th));
                        return ooc.b();
                    } catch (Throwable th2) {
                        ujc.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        ync.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (pjc) invokeL.objValue;
    }
}
