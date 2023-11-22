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
/* loaded from: classes6.dex */
public class jjc<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes6.dex */
    public interface a<T> extends xjc<pjc<? super T>> {
    }

    /* loaded from: classes6.dex */
    public interface b<R, T> extends ckc<pjc<? super R>, pjc<? super T>> {
    }

    public jjc(a<T> aVar) {
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

    public static <T> jjc<T> d(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, aVar)) == null) {
            return new jjc<>(znc.h(aVar));
        }
        return (jjc) invokeL.objValue;
    }

    public static <T> jjc<T> m(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iterable)) == null) {
            return d(new OnSubscribeFromIterable(iterable));
        }
        return (jjc) invokeL.objValue;
    }

    public static <T> jjc<T> n(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, t)) == null) {
            return ScalarSynchronousObservable.P(t);
        }
        return (jjc) invokeL.objValue;
    }

    public static <T> jjc<T> q(Iterable<? extends jjc<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, iterable)) == null) {
            return r(m(iterable));
        }
        return (jjc) invokeL.objValue;
    }

    public static <T> jjc<T> r(jjc<? extends jjc<? extends T>> jjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jjcVar)) == null) {
            if (jjcVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) jjcVar).S(UtilityFunctions.b());
            }
            return (jjc<T>) jjcVar.o(OperatorMerge.b(false));
        }
        return (jjc) invokeL.objValue;
    }

    public final jjc<T> D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return (jjc<T>) o(new blc(i));
        }
        return (jjc) invokeI.objValue;
    }

    public final qjc F(pjc<? super T> pjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pjcVar)) == null) {
            return G(pjcVar, this);
        }
        return (qjc) invokeL.objValue;
    }

    public final qjc H(xjc<? super T> xjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xjcVar)) == null) {
            if (xjcVar != null) {
                return F(new xlc(xjcVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (qjc) invokeL.objValue;
    }

    public final jjc<T> J(mjc mjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mjcVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(mjcVar);
            }
            return d(new clc(this, mjcVar));
        }
        return (jjc) invokeL.objValue;
    }

    public final jjc<T> h(dkc<? super T, ? super T, Boolean> dkcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, dkcVar)) == null) {
            return (jjc<T>) o(new ukc(dkcVar));
        }
        return (jjc) invokeL.objValue;
    }

    public final jjc<T> i(xjc<? super T> xjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, xjcVar)) == null) {
            return d(new lkc(this, new wlc(xjcVar, Actions.a(), Actions.a())));
        }
        return (jjc) invokeL.objValue;
    }

    public final jjc<T> k(ckc<? super T, Boolean> ckcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, ckcVar)) == null) {
            return d(new mkc(this, ckcVar));
        }
        return (jjc) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.ckc<? super T, ? extends com.baidu.tieba.jjc<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> jjc<R> l(ckc<? super T, ? extends jjc<? extends R>> ckcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, ckcVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).S(ckcVar);
            }
            return r(p(ckcVar));
        }
        return (jjc) invokeL.objValue;
    }

    public final <R> jjc<R> o(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bVar)) == null) {
            return d(new nkc(this.a, bVar));
        }
        return (jjc) invokeL.objValue;
    }

    public final <R> jjc<R> p(ckc<? super T, ? extends R> ckcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, ckcVar)) == null) {
            return d(new okc(this, ckcVar));
        }
        return (jjc) invokeL.objValue;
    }

    public final jjc<T> s(mjc mjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, mjcVar)) == null) {
            return t(mjcVar, bmc.c);
        }
        return (jjc) invokeL.objValue;
    }

    public final qnc<T> z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            return OperatorReplay.R(this, i);
        }
        return (qnc) invokeI.objValue;
    }

    public static <T> qjc G(pjc<? super T> pjcVar, jjc<T> jjcVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pjcVar, jjcVar)) == null) {
            if (pjcVar != null) {
                if (jjcVar.a != null) {
                    pjcVar.d();
                    if (!(pjcVar instanceof tnc)) {
                        pjcVar = new tnc(pjcVar);
                    }
                    try {
                        znc.p(jjcVar, jjcVar.a).call(pjcVar);
                        return znc.o(pjcVar);
                    } catch (Throwable th) {
                        vjc.e(th);
                        if (pjcVar.isUnsubscribed()) {
                            znc.j(znc.m(th));
                        } else {
                            try {
                                pjcVar.onError(znc.m(th));
                            } catch (Throwable th2) {
                                vjc.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                znc.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return poc.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (qjc) invokeLL.objValue;
    }

    public static jjc<Long> M(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, timeUnit)) == null) {
            return N(j, timeUnit, Schedulers.computation());
        }
        return (jjc) invokeJL.objValue;
    }

    public static <T, R> jjc<R> b(List<? extends jjc<? extends T>> list, gkc<? extends R> gkcVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, gkcVar)) == null) {
            return d(new OnSubscribeCombineLatest(list, gkcVar));
        }
        return (jjc) invokeLL.objValue;
    }

    public final jjc<T> K(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j, timeUnit)) == null) {
            return L(j, timeUnit, null, Schedulers.computation());
        }
        return (jjc) invokeJL.objValue;
    }

    public final jjc<T> e(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048589, this, j, timeUnit)) == null) {
            return f(j, timeUnit, Schedulers.computation());
        }
        return (jjc) invokeJL.objValue;
    }

    public final jjc<T> t(mjc mjcVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, mjcVar, i)) == null) {
            return u(mjcVar, false, i);
        }
        return (jjc) invokeLI.objValue;
    }

    public static jjc<Long> N(long j, TimeUnit timeUnit, mjc mjcVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), timeUnit, mjcVar})) == null) {
            return d(new qkc(j, timeUnit, mjcVar));
        }
        return (jjc) invokeCommon.objValue;
    }

    public static <T1, T2, R> jjc<R> c(jjc<? extends T1> jjcVar, jjc<? extends T2> jjcVar2, dkc<? super T1, ? super T2, ? extends R> dkcVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, jjcVar, jjcVar2, dkcVar)) == null) {
            return b(Arrays.asList(jjcVar, jjcVar2), hkc.a(dkcVar));
        }
        return (jjc) invokeLLL.objValue;
    }

    public final qnc<T> B(long j, TimeUnit timeUnit, mjc mjcVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, mjcVar})) == null) {
            return OperatorReplay.S(this, j, timeUnit, mjcVar);
        }
        return (qnc) invokeCommon.objValue;
    }

    public final jjc<T> f(long j, TimeUnit timeUnit, mjc mjcVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), timeUnit, mjcVar})) == null) {
            return (jjc<T>) o(new tkc(j, timeUnit, mjcVar));
        }
        return (jjc) invokeCommon.objValue;
    }

    public static <T> jjc<T> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (jjc) invokeV.objValue;
    }

    public final jjc<T> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return pkc.b(this);
        }
        return (jjc) invokeV.objValue;
    }

    public final qjc E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return F(new xlc(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (qjc) invokeV.objValue;
    }

    public final jjc<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (jjc<T>) o(skc.b());
        }
        return (jjc) invokeV.objValue;
    }

    public final jjc<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return (jjc<T>) o(ukc.d());
        }
        return (jjc) invokeV.objValue;
    }

    public final jjc<T> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return (jjc<T>) o(ykc.b());
        }
        return (jjc) invokeV.objValue;
    }

    public final jjc<T> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return (jjc<T>) o(zkc.b());
        }
        return (jjc) invokeV.objValue;
    }

    public final jjc<T> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return (jjc<T>) o(OperatorOnBackpressureLatest.b());
        }
        return (jjc) invokeV.objValue;
    }

    public final qnc<T> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return OperatorReplay.Q(this);
        }
        return (qnc) invokeV.objValue;
    }

    public final qnc<T> A(int i, long j, TimeUnit timeUnit, mjc mjcVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, mjcVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.T(this, j, timeUnit, mjcVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (qnc) invokeCommon.objValue;
    }

    public final jjc<T> L(long j, TimeUnit timeUnit, jjc<? extends T> jjcVar, mjc mjcVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), timeUnit, jjcVar, mjcVar})) == null) {
            return (jjc<T>) o(new dlc(j, timeUnit, jjcVar, mjcVar));
        }
        return (jjc) invokeCommon.objValue;
    }

    public final qjc I(xjc<? super T> xjcVar, xjc<Throwable> xjcVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, xjcVar, xjcVar2)) == null) {
            if (xjcVar != null) {
                if (xjcVar2 != null) {
                    return F(new xlc(xjcVar, xjcVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (qjc) invokeLL.objValue;
    }

    public final qjc O(pjc<? super T> pjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, pjcVar)) == null) {
            try {
                pjcVar.d();
                znc.p(this, this.a).call(pjcVar);
                return znc.o(pjcVar);
            } catch (Throwable th) {
                vjc.e(th);
                try {
                    pjcVar.onError(znc.m(th));
                    return poc.c();
                } catch (Throwable th2) {
                    vjc.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    znc.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (qjc) invokeL.objValue;
    }

    public final jjc<T> u(mjc mjcVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{mjcVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(mjcVar);
            }
            return (jjc<T>) o(new xkc(mjcVar, z, i));
        }
        return (jjc) invokeCommon.objValue;
    }
}
