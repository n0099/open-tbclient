package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Actions;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.OnSubscribeCombineLatest;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorOnBackpressureLatest;
import rx.internal.operators.OperatorReplay;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.UtilityFunctions;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public class n7c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes7.dex */
    public interface a<T> extends b8c<t7c<? super T>> {
        @Override // com.baidu.tieba.b8c
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes7.dex */
    public interface b<R, T> extends g8c<t7c<? super R>, t7c<? super T>> {
        @Override // com.baidu.tieba.g8c
        /* synthetic */ R call(T t);
    }

    public n7c(a<T> aVar) {
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

    public static <T> n7c<T> d(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, aVar)) == null) {
            return new n7c<>(bcc.h(aVar));
        }
        return (n7c) invokeL.objValue;
    }

    public static <T> n7c<T> m(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iterable)) == null) {
            return d(new OnSubscribeFromIterable(iterable));
        }
        return (n7c) invokeL.objValue;
    }

    public static <T> n7c<T> n(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, t)) == null) {
            return ScalarSynchronousObservable.P(t);
        }
        return (n7c) invokeL.objValue;
    }

    public static <T> n7c<T> q(Iterable<? extends n7c<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, iterable)) == null) {
            return r(m(iterable));
        }
        return (n7c) invokeL.objValue;
    }

    public static <T> n7c<T> r(n7c<? extends n7c<? extends T>> n7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, n7cVar)) == null) {
            if (n7cVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) n7cVar).S(UtilityFunctions.b());
            }
            return (n7c<T>) n7cVar.o(OperatorMerge.a(false));
        }
        return (n7c) invokeL.objValue;
    }

    public final n7c<T> D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return (n7c<T>) o(new d9c(i));
        }
        return (n7c) invokeI.objValue;
    }

    public final u7c F(t7c<? super T> t7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t7cVar)) == null) {
            return G(t7cVar, this);
        }
        return (u7c) invokeL.objValue;
    }

    public final u7c H(b8c<? super T> b8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, b8cVar)) == null) {
            if (b8cVar != null) {
                return F(new z9c(b8cVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (u7c) invokeL.objValue;
    }

    public final n7c<T> J(q7c q7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, q7cVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(q7cVar);
            }
            return d(new e9c(this, q7cVar));
        }
        return (n7c) invokeL.objValue;
    }

    public final n7c<T> h(h8c<? super T, ? super T, Boolean> h8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, h8cVar)) == null) {
            return (n7c<T>) o(new w8c(h8cVar));
        }
        return (n7c) invokeL.objValue;
    }

    public final n7c<T> i(b8c<? super T> b8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, b8cVar)) == null) {
            return d(new n8c(this, new y9c(b8cVar, Actions.a(), Actions.a())));
        }
        return (n7c) invokeL.objValue;
    }

    public final n7c<T> k(g8c<? super T, Boolean> g8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, g8cVar)) == null) {
            return d(new o8c(this, g8cVar));
        }
        return (n7c) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.g8c<? super T, ? extends com.baidu.tieba.n7c<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> n7c<R> l(g8c<? super T, ? extends n7c<? extends R>> g8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, g8cVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).S(g8cVar);
            }
            return r(p(g8cVar));
        }
        return (n7c) invokeL.objValue;
    }

    public final <R> n7c<R> o(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bVar)) == null) {
            return d(new p8c(this.a, bVar));
        }
        return (n7c) invokeL.objValue;
    }

    public final <R> n7c<R> p(g8c<? super T, ? extends R> g8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, g8cVar)) == null) {
            return d(new q8c(this, g8cVar));
        }
        return (n7c) invokeL.objValue;
    }

    public final n7c<T> s(q7c q7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, q7cVar)) == null) {
            return t(q7cVar, dac.c);
        }
        return (n7c) invokeL.objValue;
    }

    public final sbc<T> z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            return OperatorReplay.R(this, i);
        }
        return (sbc) invokeI.objValue;
    }

    public static <T> u7c G(t7c<? super T> t7cVar, n7c<T> n7cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t7cVar, n7cVar)) == null) {
            if (t7cVar != null) {
                if (n7cVar.a != null) {
                    t7cVar.d();
                    if (!(t7cVar instanceof vbc)) {
                        t7cVar = new vbc(t7cVar);
                    }
                    try {
                        bcc.p(n7cVar, n7cVar.a).call(t7cVar);
                        return bcc.o(t7cVar);
                    } catch (Throwable th) {
                        z7c.e(th);
                        if (t7cVar.isUnsubscribed()) {
                            bcc.j(bcc.m(th));
                        } else {
                            try {
                                t7cVar.onError(bcc.m(th));
                            } catch (Throwable th2) {
                                z7c.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                bcc.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return rcc.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (u7c) invokeLL.objValue;
    }

    public static n7c<Long> M(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, timeUnit)) == null) {
            return N(j, timeUnit, Schedulers.computation());
        }
        return (n7c) invokeJL.objValue;
    }

    public static <T, R> n7c<R> b(List<? extends n7c<? extends T>> list, i8c<? extends R> i8cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, i8cVar)) == null) {
            return d(new OnSubscribeCombineLatest(list, i8cVar));
        }
        return (n7c) invokeLL.objValue;
    }

    public final n7c<T> K(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j, timeUnit)) == null) {
            return L(j, timeUnit, null, Schedulers.computation());
        }
        return (n7c) invokeJL.objValue;
    }

    public final n7c<T> e(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048589, this, j, timeUnit)) == null) {
            return f(j, timeUnit, Schedulers.computation());
        }
        return (n7c) invokeJL.objValue;
    }

    public final n7c<T> t(q7c q7cVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, q7cVar, i)) == null) {
            return u(q7cVar, false, i);
        }
        return (n7c) invokeLI.objValue;
    }

    public static n7c<Long> N(long j, TimeUnit timeUnit, q7c q7cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), timeUnit, q7cVar})) == null) {
            return d(new s8c(j, timeUnit, q7cVar));
        }
        return (n7c) invokeCommon.objValue;
    }

    public static <T1, T2, R> n7c<R> c(n7c<? extends T1> n7cVar, n7c<? extends T2> n7cVar2, h8c<? super T1, ? super T2, ? extends R> h8cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, n7cVar, n7cVar2, h8cVar)) == null) {
            return b(Arrays.asList(n7cVar, n7cVar2), j8c.a(h8cVar));
        }
        return (n7c) invokeLLL.objValue;
    }

    public final sbc<T> B(long j, TimeUnit timeUnit, q7c q7cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, q7cVar})) == null) {
            return OperatorReplay.S(this, j, timeUnit, q7cVar);
        }
        return (sbc) invokeCommon.objValue;
    }

    public final n7c<T> f(long j, TimeUnit timeUnit, q7c q7cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), timeUnit, q7cVar})) == null) {
            return (n7c<T>) o(new v8c(j, timeUnit, q7cVar));
        }
        return (n7c) invokeCommon.objValue;
    }

    public static <T> n7c<T> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (n7c) invokeV.objValue;
    }

    public final n7c<T> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return r8c.a(this);
        }
        return (n7c) invokeV.objValue;
    }

    public final u7c E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return F(new z9c(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (u7c) invokeV.objValue;
    }

    public final n7c<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (n7c<T>) o(u8c.a());
        }
        return (n7c) invokeV.objValue;
    }

    public final n7c<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return (n7c<T>) o(w8c.a());
        }
        return (n7c) invokeV.objValue;
    }

    public final n7c<T> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return (n7c<T>) o(a9c.a());
        }
        return (n7c) invokeV.objValue;
    }

    public final n7c<T> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return (n7c<T>) o(b9c.a());
        }
        return (n7c) invokeV.objValue;
    }

    public final n7c<T> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return (n7c<T>) o(OperatorOnBackpressureLatest.a());
        }
        return (n7c) invokeV.objValue;
    }

    public final sbc<T> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return OperatorReplay.Q(this);
        }
        return (sbc) invokeV.objValue;
    }

    public final sbc<T> A(int i, long j, TimeUnit timeUnit, q7c q7cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, q7cVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.T(this, j, timeUnit, q7cVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (sbc) invokeCommon.objValue;
    }

    public final n7c<T> L(long j, TimeUnit timeUnit, n7c<? extends T> n7cVar, q7c q7cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), timeUnit, n7cVar, q7cVar})) == null) {
            return (n7c<T>) o(new f9c(j, timeUnit, n7cVar, q7cVar));
        }
        return (n7c) invokeCommon.objValue;
    }

    public final u7c I(b8c<? super T> b8cVar, b8c<Throwable> b8cVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, b8cVar, b8cVar2)) == null) {
            if (b8cVar != null) {
                if (b8cVar2 != null) {
                    return F(new z9c(b8cVar, b8cVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (u7c) invokeLL.objValue;
    }

    public final u7c O(t7c<? super T> t7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, t7cVar)) == null) {
            try {
                t7cVar.d();
                bcc.p(this, this.a).call(t7cVar);
                return bcc.o(t7cVar);
            } catch (Throwable th) {
                z7c.e(th);
                try {
                    t7cVar.onError(bcc.m(th));
                    return rcc.c();
                } catch (Throwable th2) {
                    z7c.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    bcc.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (u7c) invokeL.objValue;
    }

    public final n7c<T> u(q7c q7cVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{q7cVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(q7cVar);
            }
            return (n7c<T>) o(new z8c(q7cVar, z, i));
        }
        return (n7c) invokeCommon.objValue;
    }
}
