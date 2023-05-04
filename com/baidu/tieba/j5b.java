package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Actions;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorReplay;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.UtilityFunctions;
import rx.schedulers.Schedulers;
/* loaded from: classes5.dex */
public class j5b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes5.dex */
    public interface a<T> extends x5b<p5b<? super T>> {
        @Override // com.baidu.tieba.x5b
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes5.dex */
    public interface b<R, T> extends b6b<p5b<? super R>, p5b<? super T>> {
        @Override // com.baidu.tieba.b6b
        /* synthetic */ R call(T t);
    }

    public j5b(a<T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
    }

    public static <T> j5b<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            return new j5b<>(s9b.h(aVar));
        }
        return (j5b) invokeL.objValue;
    }

    public static <T> j5b<T> g(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (j5b) invokeL.objValue;
    }

    public static <T> j5b<T> h(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) {
            return ScalarSynchronousObservable.E(t);
        }
        return (j5b) invokeL.objValue;
    }

    public static <T> j5b<T> k(Iterable<? extends j5b<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return l(g(iterable));
        }
        return (j5b) invokeL.objValue;
    }

    public static <T> j5b<T> l(j5b<? extends j5b<? extends T>> j5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, j5bVar)) == null) {
            if (j5bVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) j5bVar).H(UtilityFunctions.b());
            }
            return (j5b<T>) j5bVar.i(OperatorMerge.a(false));
        }
        return (j5b) invokeL.objValue;
    }

    public final j5b<T> A(m5b m5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, m5bVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).I(m5bVar);
            }
            return a(new v6b(this, m5bVar));
        }
        return (j5b) invokeL.objValue;
    }

    public final j5b<T> b(c6b<? super T, ? super T, Boolean> c6bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, c6bVar)) == null) {
            return (j5b<T>) i(new o6b(c6bVar));
        }
        return (j5b) invokeL.objValue;
    }

    public final j5b<T> c(x5b<? super T> x5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, x5bVar)) == null) {
            return a(new i6b(this, new p7b(x5bVar, Actions.a(), Actions.a())));
        }
        return (j5b) invokeL.objValue;
    }

    public final j5b<T> e(b6b<? super T, Boolean> b6bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, b6bVar)) == null) {
            return a(new j6b(this, b6bVar));
        }
        return (j5b) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.b6b<? super T, ? extends com.baidu.tieba.j5b<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> j5b<R> f(b6b<? super T, ? extends j5b<? extends R>> b6bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, b6bVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).H(b6bVar);
            }
            return l(j(b6bVar));
        }
        return (j5b) invokeL.objValue;
    }

    public final <R> j5b<R> i(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            return a(new k6b(this.a, bVar));
        }
        return (j5b) invokeL.objValue;
    }

    public final <R> j5b<R> j(b6b<? super T, ? extends R> b6bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, b6bVar)) == null) {
            return a(new l6b(this, b6bVar));
        }
        return (j5b) invokeL.objValue;
    }

    public final j5b<T> m(m5b m5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, m5bVar)) == null) {
            return n(m5bVar, u7b.c);
        }
        return (j5b) invokeL.objValue;
    }

    public final j9b<T> r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            return OperatorReplay.G(this, i);
        }
        return (j9b) invokeI.objValue;
    }

    public final q5b w(p5b<? super T> p5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, p5bVar)) == null) {
            return x(p5bVar, this);
        }
        return (q5b) invokeL.objValue;
    }

    public final q5b y(x5b<? super T> x5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, x5bVar)) == null) {
            if (x5bVar != null) {
                return w(new q7b(x5bVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (q5b) invokeL.objValue;
    }

    public static <T> j5b<T> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (j5b) invokeV.objValue;
    }

    public final j5b<T> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return (j5b<T>) i(s6b.a());
        }
        return (j5b) invokeV.objValue;
    }

    public final j9b<T> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return OperatorReplay.F(this);
        }
        return (j9b) invokeV.objValue;
    }

    public final j5b<T> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return m6b.a(this);
        }
        return (j5b) invokeV.objValue;
    }

    public final q5b v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return w(new q7b(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (q5b) invokeV.objValue;
    }

    public static <T> q5b x(p5b<? super T> p5bVar, j5b<T> j5bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, p5bVar, j5bVar)) == null) {
            if (p5bVar != null) {
                if (j5bVar.a != null) {
                    p5bVar.d();
                    if (!(p5bVar instanceof m9b)) {
                        p5bVar = new m9b(p5bVar);
                    }
                    try {
                        s9b.p(j5bVar, j5bVar.a).call(p5bVar);
                        return s9b.o(p5bVar);
                    } catch (Throwable th) {
                        v5b.e(th);
                        if (p5bVar.isUnsubscribed()) {
                            s9b.j(s9b.m(th));
                        } else {
                            try {
                                p5bVar.onError(s9b.m(th));
                            } catch (Throwable th2) {
                                v5b.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                s9b.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return iab.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (q5b) invokeLL.objValue;
    }

    public final j5b<T> B(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, timeUnit)) == null) {
            return C(j, timeUnit, null, Schedulers.computation());
        }
        return (j5b) invokeJL.objValue;
    }

    public final j5b<T> n(m5b m5bVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, m5bVar, i)) == null) {
            return o(m5bVar, false, i);
        }
        return (j5b) invokeLI.objValue;
    }

    public final j5b<T> C(long j, TimeUnit timeUnit, j5b<? extends T> j5bVar, m5b m5bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), timeUnit, j5bVar, m5bVar})) == null) {
            return (j5b<T>) i(new w6b(j, timeUnit, j5bVar, m5bVar));
        }
        return (j5b) invokeCommon.objValue;
    }

    public final j9b<T> s(int i, long j, TimeUnit timeUnit, m5b m5bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, m5bVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.I(this, j, timeUnit, m5bVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (j9b) invokeCommon.objValue;
    }

    public final q5b D(p5b<? super T> p5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, p5bVar)) == null) {
            try {
                p5bVar.d();
                s9b.p(this, this.a).call(p5bVar);
                return s9b.o(p5bVar);
            } catch (Throwable th) {
                v5b.e(th);
                try {
                    p5bVar.onError(s9b.m(th));
                    return iab.c();
                } catch (Throwable th2) {
                    v5b.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    s9b.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (q5b) invokeL.objValue;
    }

    public final j5b<T> o(m5b m5bVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{m5bVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).I(m5bVar);
            }
            return (j5b<T>) i(new r6b(m5bVar, z, i));
        }
        return (j5b) invokeCommon.objValue;
    }

    public final j9b<T> t(long j, TimeUnit timeUnit, m5b m5bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j), timeUnit, m5bVar})) == null) {
            return OperatorReplay.H(this, j, timeUnit, m5bVar);
        }
        return (j9b) invokeCommon.objValue;
    }

    public final q5b z(x5b<? super T> x5bVar, x5b<Throwable> x5bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, x5bVar, x5bVar2)) == null) {
            if (x5bVar != null) {
                if (x5bVar2 != null) {
                    return w(new q7b(x5bVar, x5bVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (q5b) invokeLL.objValue;
    }
}
