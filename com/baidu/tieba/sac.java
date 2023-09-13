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
public class sac<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes7.dex */
    public interface a<T> extends gbc<yac<? super T>> {
        @Override // com.baidu.tieba.gbc
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes7.dex */
    public interface b<R, T> extends lbc<yac<? super R>, yac<? super T>> {
        @Override // com.baidu.tieba.lbc
        /* synthetic */ R call(T t);
    }

    public sac(a<T> aVar) {
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

    public static <T> sac<T> d(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, aVar)) == null) {
            return new sac<>(gfc.h(aVar));
        }
        return (sac) invokeL.objValue;
    }

    public static <T> sac<T> m(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iterable)) == null) {
            return d(new OnSubscribeFromIterable(iterable));
        }
        return (sac) invokeL.objValue;
    }

    public static <T> sac<T> n(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, t)) == null) {
            return ScalarSynchronousObservable.P(t);
        }
        return (sac) invokeL.objValue;
    }

    public static <T> sac<T> q(Iterable<? extends sac<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, iterable)) == null) {
            return r(m(iterable));
        }
        return (sac) invokeL.objValue;
    }

    public static <T> sac<T> r(sac<? extends sac<? extends T>> sacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, sacVar)) == null) {
            if (sacVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) sacVar).S(UtilityFunctions.b());
            }
            return (sac<T>) sacVar.o(OperatorMerge.a(false));
        }
        return (sac) invokeL.objValue;
    }

    public final sac<T> D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return (sac<T>) o(new icc(i));
        }
        return (sac) invokeI.objValue;
    }

    public final zac F(yac<? super T> yacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, yacVar)) == null) {
            return G(yacVar, this);
        }
        return (zac) invokeL.objValue;
    }

    public final zac H(gbc<? super T> gbcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, gbcVar)) == null) {
            if (gbcVar != null) {
                return F(new edc(gbcVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (zac) invokeL.objValue;
    }

    public final sac<T> J(vac vacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vacVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(vacVar);
            }
            return d(new jcc(this, vacVar));
        }
        return (sac) invokeL.objValue;
    }

    public final sac<T> h(mbc<? super T, ? super T, Boolean> mbcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, mbcVar)) == null) {
            return (sac<T>) o(new bcc(mbcVar));
        }
        return (sac) invokeL.objValue;
    }

    public final sac<T> i(gbc<? super T> gbcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, gbcVar)) == null) {
            return d(new sbc(this, new ddc(gbcVar, Actions.a(), Actions.a())));
        }
        return (sac) invokeL.objValue;
    }

    public final sac<T> k(lbc<? super T, Boolean> lbcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, lbcVar)) == null) {
            return d(new tbc(this, lbcVar));
        }
        return (sac) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.lbc<? super T, ? extends com.baidu.tieba.sac<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> sac<R> l(lbc<? super T, ? extends sac<? extends R>> lbcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, lbcVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).S(lbcVar);
            }
            return r(p(lbcVar));
        }
        return (sac) invokeL.objValue;
    }

    public final <R> sac<R> o(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bVar)) == null) {
            return d(new ubc(this.a, bVar));
        }
        return (sac) invokeL.objValue;
    }

    public final <R> sac<R> p(lbc<? super T, ? extends R> lbcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, lbcVar)) == null) {
            return d(new vbc(this, lbcVar));
        }
        return (sac) invokeL.objValue;
    }

    public final sac<T> s(vac vacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, vacVar)) == null) {
            return t(vacVar, idc.c);
        }
        return (sac) invokeL.objValue;
    }

    public final xec<T> z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            return OperatorReplay.R(this, i);
        }
        return (xec) invokeI.objValue;
    }

    public static <T> zac G(yac<? super T> yacVar, sac<T> sacVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, yacVar, sacVar)) == null) {
            if (yacVar != null) {
                if (sacVar.a != null) {
                    yacVar.d();
                    if (!(yacVar instanceof afc)) {
                        yacVar = new afc(yacVar);
                    }
                    try {
                        gfc.p(sacVar, sacVar.a).call(yacVar);
                        return gfc.o(yacVar);
                    } catch (Throwable th) {
                        ebc.e(th);
                        if (yacVar.isUnsubscribed()) {
                            gfc.j(gfc.m(th));
                        } else {
                            try {
                                yacVar.onError(gfc.m(th));
                            } catch (Throwable th2) {
                                ebc.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                gfc.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return wfc.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (zac) invokeLL.objValue;
    }

    public static sac<Long> M(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, timeUnit)) == null) {
            return N(j, timeUnit, Schedulers.computation());
        }
        return (sac) invokeJL.objValue;
    }

    public static <T, R> sac<R> b(List<? extends sac<? extends T>> list, nbc<? extends R> nbcVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, nbcVar)) == null) {
            return d(new OnSubscribeCombineLatest(list, nbcVar));
        }
        return (sac) invokeLL.objValue;
    }

    public final sac<T> K(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j, timeUnit)) == null) {
            return L(j, timeUnit, null, Schedulers.computation());
        }
        return (sac) invokeJL.objValue;
    }

    public final sac<T> e(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048589, this, j, timeUnit)) == null) {
            return f(j, timeUnit, Schedulers.computation());
        }
        return (sac) invokeJL.objValue;
    }

    public final sac<T> t(vac vacVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, vacVar, i)) == null) {
            return u(vacVar, false, i);
        }
        return (sac) invokeLI.objValue;
    }

    public static sac<Long> N(long j, TimeUnit timeUnit, vac vacVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), timeUnit, vacVar})) == null) {
            return d(new xbc(j, timeUnit, vacVar));
        }
        return (sac) invokeCommon.objValue;
    }

    public static <T1, T2, R> sac<R> c(sac<? extends T1> sacVar, sac<? extends T2> sacVar2, mbc<? super T1, ? super T2, ? extends R> mbcVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, sacVar, sacVar2, mbcVar)) == null) {
            return b(Arrays.asList(sacVar, sacVar2), obc.a(mbcVar));
        }
        return (sac) invokeLLL.objValue;
    }

    public final xec<T> B(long j, TimeUnit timeUnit, vac vacVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, vacVar})) == null) {
            return OperatorReplay.S(this, j, timeUnit, vacVar);
        }
        return (xec) invokeCommon.objValue;
    }

    public final sac<T> f(long j, TimeUnit timeUnit, vac vacVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), timeUnit, vacVar})) == null) {
            return (sac<T>) o(new acc(j, timeUnit, vacVar));
        }
        return (sac) invokeCommon.objValue;
    }

    public static <T> sac<T> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (sac) invokeV.objValue;
    }

    public final sac<T> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return wbc.a(this);
        }
        return (sac) invokeV.objValue;
    }

    public final zac E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return F(new edc(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (zac) invokeV.objValue;
    }

    public final sac<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (sac<T>) o(zbc.a());
        }
        return (sac) invokeV.objValue;
    }

    public final sac<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return (sac<T>) o(bcc.a());
        }
        return (sac) invokeV.objValue;
    }

    public final sac<T> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return (sac<T>) o(fcc.a());
        }
        return (sac) invokeV.objValue;
    }

    public final sac<T> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return (sac<T>) o(gcc.a());
        }
        return (sac) invokeV.objValue;
    }

    public final sac<T> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return (sac<T>) o(OperatorOnBackpressureLatest.a());
        }
        return (sac) invokeV.objValue;
    }

    public final xec<T> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return OperatorReplay.Q(this);
        }
        return (xec) invokeV.objValue;
    }

    public final xec<T> A(int i, long j, TimeUnit timeUnit, vac vacVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, vacVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.T(this, j, timeUnit, vacVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (xec) invokeCommon.objValue;
    }

    public final sac<T> L(long j, TimeUnit timeUnit, sac<? extends T> sacVar, vac vacVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), timeUnit, sacVar, vacVar})) == null) {
            return (sac<T>) o(new kcc(j, timeUnit, sacVar, vacVar));
        }
        return (sac) invokeCommon.objValue;
    }

    public final zac I(gbc<? super T> gbcVar, gbc<Throwable> gbcVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, gbcVar, gbcVar2)) == null) {
            if (gbcVar != null) {
                if (gbcVar2 != null) {
                    return F(new edc(gbcVar, gbcVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (zac) invokeLL.objValue;
    }

    public final zac O(yac<? super T> yacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, yacVar)) == null) {
            try {
                yacVar.d();
                gfc.p(this, this.a).call(yacVar);
                return gfc.o(yacVar);
            } catch (Throwable th) {
                ebc.e(th);
                try {
                    yacVar.onError(gfc.m(th));
                    return wfc.c();
                } catch (Throwable th2) {
                    ebc.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    gfc.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (zac) invokeL.objValue;
    }

    public final sac<T> u(vac vacVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{vacVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(vacVar);
            }
            return (sac<T>) o(new ecc(vacVar, z, i));
        }
        return (sac) invokeCommon.objValue;
    }
}
