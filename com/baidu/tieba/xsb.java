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
import rx.internal.operators.OperatorReplay;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.UtilityFunctions;
import rx.schedulers.Schedulers;
/* loaded from: classes8.dex */
public class xsb<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes8.dex */
    public interface a<T> extends ltb<dtb<? super T>> {
        @Override // com.baidu.tieba.ltb
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes8.dex */
    public interface b<R, T> extends ptb<dtb<? super R>, dtb<? super T>> {
        @Override // com.baidu.tieba.ptb
        /* synthetic */ R call(T t);
    }

    public xsb(a<T> aVar) {
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

    public static <T> xsb<T> d(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, aVar)) == null) {
            return new xsb<>(kxb.h(aVar));
        }
        return (xsb) invokeL.objValue;
    }

    public static <T> xsb<T> m(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iterable)) == null) {
            return d(new OnSubscribeFromIterable(iterable));
        }
        return (xsb) invokeL.objValue;
    }

    public static <T> xsb<T> n(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, t)) == null) {
            return ScalarSynchronousObservable.N(t);
        }
        return (xsb) invokeL.objValue;
    }

    public static <T> xsb<T> q(Iterable<? extends xsb<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, iterable)) == null) {
            return r(m(iterable));
        }
        return (xsb) invokeL.objValue;
    }

    public static <T> xsb<T> r(xsb<? extends xsb<? extends T>> xsbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, xsbVar)) == null) {
            if (xsbVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) xsbVar).Q(UtilityFunctions.b());
            }
            return (xsb<T>) xsbVar.o(OperatorMerge.a(false));
        }
        return (xsb) invokeL.objValue;
    }

    public final etb D(dtb<? super T> dtbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dtbVar)) == null) {
            return E(dtbVar, this);
        }
        return (etb) invokeL.objValue;
    }

    public final etb F(ltb<? super T> ltbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ltbVar)) == null) {
            if (ltbVar != null) {
                return D(new ivb(ltbVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (etb) invokeL.objValue;
    }

    public final xsb<T> H(atb atbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, atbVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).R(atbVar);
            }
            return d(new nub(this, atbVar));
        }
        return (xsb) invokeL.objValue;
    }

    public final xsb<T> h(qtb<? super T, ? super T, Boolean> qtbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, qtbVar)) == null) {
            return (xsb<T>) o(new fub(qtbVar));
        }
        return (xsb) invokeL.objValue;
    }

    public final xsb<T> i(ltb<? super T> ltbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, ltbVar)) == null) {
            return d(new wtb(this, new hvb(ltbVar, Actions.a(), Actions.a())));
        }
        return (xsb) invokeL.objValue;
    }

    public final xsb<T> k(ptb<? super T, Boolean> ptbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, ptbVar)) == null) {
            return d(new xtb(this, ptbVar));
        }
        return (xsb) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.ptb<? super T, ? extends com.baidu.tieba.xsb<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> xsb<R> l(ptb<? super T, ? extends xsb<? extends R>> ptbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, ptbVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).Q(ptbVar);
            }
            return r(p(ptbVar));
        }
        return (xsb) invokeL.objValue;
    }

    public final <R> xsb<R> o(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, bVar)) == null) {
            return d(new ytb(this.a, bVar));
        }
        return (xsb) invokeL.objValue;
    }

    public final <R> xsb<R> p(ptb<? super T, ? extends R> ptbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, ptbVar)) == null) {
            return d(new ztb(this, ptbVar));
        }
        return (xsb) invokeL.objValue;
    }

    public final xsb<T> s(atb atbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, atbVar)) == null) {
            return t(atbVar, mvb.c);
        }
        return (xsb) invokeL.objValue;
    }

    public final bxb<T> y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) {
            return OperatorReplay.P(this, i);
        }
        return (bxb) invokeI.objValue;
    }

    public static <T> etb E(dtb<? super T> dtbVar, xsb<T> xsbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, dtbVar, xsbVar)) == null) {
            if (dtbVar != null) {
                if (xsbVar.a != null) {
                    dtbVar.d();
                    if (!(dtbVar instanceof exb)) {
                        dtbVar = new exb(dtbVar);
                    }
                    try {
                        kxb.p(xsbVar, xsbVar.a).call(dtbVar);
                        return kxb.o(dtbVar);
                    } catch (Throwable th) {
                        jtb.e(th);
                        if (dtbVar.isUnsubscribed()) {
                            kxb.j(kxb.m(th));
                        } else {
                            try {
                                dtbVar.onError(kxb.m(th));
                            } catch (Throwable th2) {
                                jtb.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                kxb.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return ayb.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (etb) invokeLL.objValue;
    }

    public static xsb<Long> K(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, timeUnit)) == null) {
            return L(j, timeUnit, Schedulers.computation());
        }
        return (xsb) invokeJL.objValue;
    }

    public static <T, R> xsb<R> b(List<? extends xsb<? extends T>> list, rtb<? extends R> rtbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, rtbVar)) == null) {
            return d(new OnSubscribeCombineLatest(list, rtbVar));
        }
        return (xsb) invokeLL.objValue;
    }

    public final xsb<T> I(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048583, this, j, timeUnit)) == null) {
            return J(j, timeUnit, null, Schedulers.computation());
        }
        return (xsb) invokeJL.objValue;
    }

    public final xsb<T> e(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048587, this, j, timeUnit)) == null) {
            return f(j, timeUnit, Schedulers.computation());
        }
        return (xsb) invokeJL.objValue;
    }

    public final xsb<T> t(atb atbVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, atbVar, i)) == null) {
            return u(atbVar, false, i);
        }
        return (xsb) invokeLI.objValue;
    }

    public static xsb<Long> L(long j, TimeUnit timeUnit, atb atbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), timeUnit, atbVar})) == null) {
            return d(new bub(j, timeUnit, atbVar));
        }
        return (xsb) invokeCommon.objValue;
    }

    public static <T1, T2, R> xsb<R> c(xsb<? extends T1> xsbVar, xsb<? extends T2> xsbVar2, qtb<? super T1, ? super T2, ? extends R> qtbVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, xsbVar, xsbVar2, qtbVar)) == null) {
            return b(Arrays.asList(xsbVar, xsbVar2), stb.a(qtbVar));
        }
        return (xsb) invokeLLL.objValue;
    }

    public final bxb<T> A(long j, TimeUnit timeUnit, atb atbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, atbVar})) == null) {
            return OperatorReplay.Q(this, j, timeUnit, atbVar);
        }
        return (bxb) invokeCommon.objValue;
    }

    public final xsb<T> f(long j, TimeUnit timeUnit, atb atbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), timeUnit, atbVar})) == null) {
            return (xsb<T>) o(new eub(j, timeUnit, atbVar));
        }
        return (xsb) invokeCommon.objValue;
    }

    public static <T> xsb<T> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (xsb) invokeV.objValue;
    }

    public final xsb<T> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return aub.a(this);
        }
        return (xsb) invokeV.objValue;
    }

    public final etb C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return D(new ivb(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (etb) invokeV.objValue;
    }

    public final xsb<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return (xsb<T>) o(dub.a());
        }
        return (xsb) invokeV.objValue;
    }

    public final xsb<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return (xsb<T>) o(fub.a());
        }
        return (xsb) invokeV.objValue;
    }

    public final xsb<T> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return (xsb<T>) o(jub.a());
        }
        return (xsb) invokeV.objValue;
    }

    public final xsb<T> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return (xsb<T>) o(kub.a());
        }
        return (xsb) invokeV.objValue;
    }

    public final bxb<T> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return OperatorReplay.O(this);
        }
        return (bxb) invokeV.objValue;
    }

    public final etb G(ltb<? super T> ltbVar, ltb<Throwable> ltbVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, ltbVar, ltbVar2)) == null) {
            if (ltbVar != null) {
                if (ltbVar2 != null) {
                    return D(new ivb(ltbVar, ltbVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (etb) invokeLL.objValue;
    }

    public final xsb<T> J(long j, TimeUnit timeUnit, xsb<? extends T> xsbVar, atb atbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), timeUnit, xsbVar, atbVar})) == null) {
            return (xsb<T>) o(new oub(j, timeUnit, xsbVar, atbVar));
        }
        return (xsb) invokeCommon.objValue;
    }

    public final bxb<T> z(int i, long j, TimeUnit timeUnit, atb atbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, atbVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.R(this, j, timeUnit, atbVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (bxb) invokeCommon.objValue;
    }

    public final etb M(dtb<? super T> dtbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, dtbVar)) == null) {
            try {
                dtbVar.d();
                kxb.p(this, this.a).call(dtbVar);
                return kxb.o(dtbVar);
            } catch (Throwable th) {
                jtb.e(th);
                try {
                    dtbVar.onError(kxb.m(th));
                    return ayb.c();
                } catch (Throwable th2) {
                    jtb.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    kxb.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (etb) invokeL.objValue;
    }

    public final xsb<T> u(atb atbVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{atbVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).R(atbVar);
            }
            return (xsb<T>) o(new iub(atbVar, z, i));
        }
        return (xsb) invokeCommon.objValue;
    }
}
