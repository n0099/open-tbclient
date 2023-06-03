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
public class mmb<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes6.dex */
    public interface c<T> extends wmb<nmb<? super T>> {
        @Override // com.baidu.tieba.wmb
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes6.dex */
    public class a extends nmb<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wmb b;
        public final /* synthetic */ wmb c;

        public a(mmb mmbVar, wmb wmbVar, wmb wmbVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mmbVar, wmbVar, wmbVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wmbVar;
            this.c = wmbVar2;
        }

        @Override // com.baidu.tieba.nmb
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

        @Override // com.baidu.tieba.nmb
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
    public class b implements wmb<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wmb a;

        public b(mmb mmbVar, wmb wmbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mmbVar, wmbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wmbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wmb
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public mmb(c<T> cVar) {
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
        this.a = sqb.i(cVar);
    }

    public final mmb<T> h(lmb lmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, lmbVar)) == null) {
            if (this instanceof vob) {
                return ((vob) this).n(lmbVar);
            }
            if (lmbVar != null) {
                return b(new cob(this.a, lmbVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (mmb) invokeL.objValue;
    }

    public static <T> imb<T> a(mmb<T> mmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mmbVar)) == null) {
            return imb.a(new dob(mmbVar.a));
        }
        return (imb) invokeL.objValue;
    }

    public static <T> mmb<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new mmb<>(cVar);
        }
        return (mmb) invokeL.objValue;
    }

    public static <T> mmb<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return vob.m(t);
        }
        return (mmb) invokeL.objValue;
    }

    public final mmb<T> e(wmb<Throwable> wmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wmbVar)) == null) {
            if (wmbVar != null) {
                return b(new znb(this, Actions.a(), new b(this, wmbVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (mmb) invokeL.objValue;
    }

    public final mmb<T> f(wmb<? super T> wmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, wmbVar)) == null) {
            if (wmbVar != null) {
                return b(new znb(this, wmbVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (mmb) invokeL.objValue;
    }

    public final mmb<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (mmb) invokeJL.objValue;
    }

    public final pmb k(wmb<? super T> wmbVar, wmb<Throwable> wmbVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, wmbVar, wmbVar2)) == null) {
            if (wmbVar != null) {
                if (wmbVar2 != null) {
                    return j(new a(this, wmbVar2, wmbVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (pmb) invokeLL.objValue;
    }

    public final mmb<T> d(long j, TimeUnit timeUnit, lmb lmbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, lmbVar})) == null) {
            return b(new ynb(this.a, j, timeUnit, lmbVar));
        }
        return (mmb) invokeCommon.objValue;
    }

    public final pmb i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (pmb) invokeV.objValue;
    }

    public final imb<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (imb) invokeV.objValue;
    }

    public final pmb j(nmb<? super T> nmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, nmbVar)) == null) {
            if (nmbVar != null) {
                try {
                    sqb.t(this, this.a).call(nmbVar);
                    return sqb.s(nmbVar);
                } catch (Throwable th) {
                    umb.e(th);
                    try {
                        nmbVar.b(sqb.r(th));
                        return irb.b();
                    } catch (Throwable th2) {
                        umb.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        sqb.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (pmb) invokeL.objValue;
    }
}
