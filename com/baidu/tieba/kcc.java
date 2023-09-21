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
public class kcc<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes6.dex */
    public interface a<T> extends ycc<qcc<? super T>> {
        @Override // com.baidu.tieba.ycc
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes6.dex */
    public interface b<R, T> extends ddc<qcc<? super R>, qcc<? super T>> {
        @Override // com.baidu.tieba.ddc
        /* synthetic */ R call(T t);
    }

    public kcc(a<T> aVar) {
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

    public static <T> kcc<T> d(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, aVar)) == null) {
            return new kcc<>(ygc.h(aVar));
        }
        return (kcc) invokeL.objValue;
    }

    public static <T> kcc<T> m(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iterable)) == null) {
            return d(new OnSubscribeFromIterable(iterable));
        }
        return (kcc) invokeL.objValue;
    }

    public static <T> kcc<T> n(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, t)) == null) {
            return ScalarSynchronousObservable.P(t);
        }
        return (kcc) invokeL.objValue;
    }

    public static <T> kcc<T> q(Iterable<? extends kcc<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, iterable)) == null) {
            return r(m(iterable));
        }
        return (kcc) invokeL.objValue;
    }

    public static <T> kcc<T> r(kcc<? extends kcc<? extends T>> kccVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, kccVar)) == null) {
            if (kccVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) kccVar).S(UtilityFunctions.b());
            }
            return (kcc<T>) kccVar.o(OperatorMerge.a(false));
        }
        return (kcc) invokeL.objValue;
    }

    public final kcc<T> D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return (kcc<T>) o(new aec(i));
        }
        return (kcc) invokeI.objValue;
    }

    public final rcc F(qcc<? super T> qccVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, qccVar)) == null) {
            return G(qccVar, this);
        }
        return (rcc) invokeL.objValue;
    }

    public final rcc H(ycc<? super T> yccVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, yccVar)) == null) {
            if (yccVar != null) {
                return F(new wec(yccVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (rcc) invokeL.objValue;
    }

    public final kcc<T> J(ncc nccVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nccVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(nccVar);
            }
            return d(new bec(this, nccVar));
        }
        return (kcc) invokeL.objValue;
    }

    public final kcc<T> h(edc<? super T, ? super T, Boolean> edcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, edcVar)) == null) {
            return (kcc<T>) o(new tdc(edcVar));
        }
        return (kcc) invokeL.objValue;
    }

    public final kcc<T> i(ycc<? super T> yccVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, yccVar)) == null) {
            return d(new kdc(this, new vec(yccVar, Actions.a(), Actions.a())));
        }
        return (kcc) invokeL.objValue;
    }

    public final kcc<T> k(ddc<? super T, Boolean> ddcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, ddcVar)) == null) {
            return d(new ldc(this, ddcVar));
        }
        return (kcc) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.ddc<? super T, ? extends com.baidu.tieba.kcc<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> kcc<R> l(ddc<? super T, ? extends kcc<? extends R>> ddcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, ddcVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).S(ddcVar);
            }
            return r(p(ddcVar));
        }
        return (kcc) invokeL.objValue;
    }

    public final <R> kcc<R> o(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bVar)) == null) {
            return d(new mdc(this.a, bVar));
        }
        return (kcc) invokeL.objValue;
    }

    public final <R> kcc<R> p(ddc<? super T, ? extends R> ddcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, ddcVar)) == null) {
            return d(new ndc(this, ddcVar));
        }
        return (kcc) invokeL.objValue;
    }

    public final kcc<T> s(ncc nccVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, nccVar)) == null) {
            return t(nccVar, afc.c);
        }
        return (kcc) invokeL.objValue;
    }

    public final pgc<T> z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            return OperatorReplay.R(this, i);
        }
        return (pgc) invokeI.objValue;
    }

    public static <T> rcc G(qcc<? super T> qccVar, kcc<T> kccVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, qccVar, kccVar)) == null) {
            if (qccVar != null) {
                if (kccVar.a != null) {
                    qccVar.d();
                    if (!(qccVar instanceof sgc)) {
                        qccVar = new sgc(qccVar);
                    }
                    try {
                        ygc.p(kccVar, kccVar.a).call(qccVar);
                        return ygc.o(qccVar);
                    } catch (Throwable th) {
                        wcc.e(th);
                        if (qccVar.isUnsubscribed()) {
                            ygc.j(ygc.m(th));
                        } else {
                            try {
                                qccVar.onError(ygc.m(th));
                            } catch (Throwable th2) {
                                wcc.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                ygc.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return ohc.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (rcc) invokeLL.objValue;
    }

    public static kcc<Long> M(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, timeUnit)) == null) {
            return N(j, timeUnit, Schedulers.computation());
        }
        return (kcc) invokeJL.objValue;
    }

    public static <T, R> kcc<R> b(List<? extends kcc<? extends T>> list, fdc<? extends R> fdcVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, fdcVar)) == null) {
            return d(new OnSubscribeCombineLatest(list, fdcVar));
        }
        return (kcc) invokeLL.objValue;
    }

    public final kcc<T> K(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j, timeUnit)) == null) {
            return L(j, timeUnit, null, Schedulers.computation());
        }
        return (kcc) invokeJL.objValue;
    }

    public final kcc<T> e(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048589, this, j, timeUnit)) == null) {
            return f(j, timeUnit, Schedulers.computation());
        }
        return (kcc) invokeJL.objValue;
    }

    public final kcc<T> t(ncc nccVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, nccVar, i)) == null) {
            return u(nccVar, false, i);
        }
        return (kcc) invokeLI.objValue;
    }

    public static kcc<Long> N(long j, TimeUnit timeUnit, ncc nccVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), timeUnit, nccVar})) == null) {
            return d(new pdc(j, timeUnit, nccVar));
        }
        return (kcc) invokeCommon.objValue;
    }

    public static <T1, T2, R> kcc<R> c(kcc<? extends T1> kccVar, kcc<? extends T2> kccVar2, edc<? super T1, ? super T2, ? extends R> edcVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, kccVar, kccVar2, edcVar)) == null) {
            return b(Arrays.asList(kccVar, kccVar2), gdc.a(edcVar));
        }
        return (kcc) invokeLLL.objValue;
    }

    public final pgc<T> B(long j, TimeUnit timeUnit, ncc nccVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, nccVar})) == null) {
            return OperatorReplay.S(this, j, timeUnit, nccVar);
        }
        return (pgc) invokeCommon.objValue;
    }

    public final kcc<T> f(long j, TimeUnit timeUnit, ncc nccVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), timeUnit, nccVar})) == null) {
            return (kcc<T>) o(new sdc(j, timeUnit, nccVar));
        }
        return (kcc) invokeCommon.objValue;
    }

    public static <T> kcc<T> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (kcc) invokeV.objValue;
    }

    public final kcc<T> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return odc.a(this);
        }
        return (kcc) invokeV.objValue;
    }

    public final rcc E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return F(new wec(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (rcc) invokeV.objValue;
    }

    public final kcc<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (kcc<T>) o(rdc.a());
        }
        return (kcc) invokeV.objValue;
    }

    public final kcc<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return (kcc<T>) o(tdc.a());
        }
        return (kcc) invokeV.objValue;
    }

    public final kcc<T> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return (kcc<T>) o(xdc.a());
        }
        return (kcc) invokeV.objValue;
    }

    public final kcc<T> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return (kcc<T>) o(ydc.a());
        }
        return (kcc) invokeV.objValue;
    }

    public final kcc<T> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return (kcc<T>) o(OperatorOnBackpressureLatest.a());
        }
        return (kcc) invokeV.objValue;
    }

    public final pgc<T> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return OperatorReplay.Q(this);
        }
        return (pgc) invokeV.objValue;
    }

    public final pgc<T> A(int i, long j, TimeUnit timeUnit, ncc nccVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, nccVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.T(this, j, timeUnit, nccVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (pgc) invokeCommon.objValue;
    }

    public final kcc<T> L(long j, TimeUnit timeUnit, kcc<? extends T> kccVar, ncc nccVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), timeUnit, kccVar, nccVar})) == null) {
            return (kcc<T>) o(new cec(j, timeUnit, kccVar, nccVar));
        }
        return (kcc) invokeCommon.objValue;
    }

    public final rcc I(ycc<? super T> yccVar, ycc<Throwable> yccVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, yccVar, yccVar2)) == null) {
            if (yccVar != null) {
                if (yccVar2 != null) {
                    return F(new wec(yccVar, yccVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (rcc) invokeLL.objValue;
    }

    public final rcc O(qcc<? super T> qccVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, qccVar)) == null) {
            try {
                qccVar.d();
                ygc.p(this, this.a).call(qccVar);
                return ygc.o(qccVar);
            } catch (Throwable th) {
                wcc.e(th);
                try {
                    qccVar.onError(ygc.m(th));
                    return ohc.c();
                } catch (Throwable th2) {
                    wcc.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    ygc.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (rcc) invokeL.objValue;
    }

    public final kcc<T> u(ncc nccVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{nccVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(nccVar);
            }
            return (kcc<T>) o(new wdc(nccVar, z, i));
        }
        return (kcc) invokeCommon.objValue;
    }
}
