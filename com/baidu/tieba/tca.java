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
/* loaded from: classes6.dex */
public class tca<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes6.dex */
    public interface a<T> extends hda<zca<? super T>> {
        @Override // com.baidu.tieba.hda
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes6.dex */
    public interface b<R, T> extends lda<zca<? super R>, zca<? super T>> {
        @Override // com.baidu.tieba.lda
        /* synthetic */ R call(T t);
    }

    public tca(a<T> aVar) {
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

    public static <T> tca<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            return new tca<>(aha.h(aVar));
        }
        return (tca) invokeL.objValue;
    }

    public static <T> tca<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (tca) invokeL.objValue;
    }

    public static <T> tca<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) {
            return ScalarSynchronousObservable.C(t);
        }
        return (tca) invokeL.objValue;
    }

    public static <T> tca<T> i(Iterable<? extends tca<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return j(e(iterable));
        }
        return (tca) invokeL.objValue;
    }

    public static <T> tca<T> j(tca<? extends tca<? extends T>> tcaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tcaVar)) == null) {
            if (tcaVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) tcaVar).F(UtilityFunctions.b());
            }
            return (tca<T>) tcaVar.g(OperatorMerge.a(false));
        }
        return (tca) invokeL.objValue;
    }

    public final tca<T> b(hda<? super T> hdaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hdaVar)) == null) {
            return a(new sda(this, new xea(hdaVar, Actions.a(), Actions.a())));
        }
        return (tca) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.lda<? super T, ? extends com.baidu.tieba.tca<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> tca<R> d(lda<? super T, ? extends tca<? extends R>> ldaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ldaVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(ldaVar);
            }
            return j(h(ldaVar));
        }
        return (tca) invokeL.objValue;
    }

    public final <R> tca<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            return a(new tda(this.a, bVar));
        }
        return (tca) invokeL.objValue;
    }

    public final <R> tca<R> h(lda<? super T, ? extends R> ldaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ldaVar)) == null) {
            return a(new uda(this, ldaVar));
        }
        return (tca) invokeL.objValue;
    }

    public final tca<T> k(wca wcaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, wcaVar)) == null) {
            return l(wcaVar, cfa.c);
        }
        return (tca) invokeL.objValue;
    }

    public final rga<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return OperatorReplay.E(this, i);
        }
        return (rga) invokeI.objValue;
    }

    public final ada u(zca<? super T> zcaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, zcaVar)) == null) {
            return v(zcaVar, this);
        }
        return (ada) invokeL.objValue;
    }

    public final ada w(hda<? super T> hdaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, hdaVar)) == null) {
            if (hdaVar != null) {
                return u(new yea(hdaVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (ada) invokeL.objValue;
    }

    public final tca<T> y(wca wcaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, wcaVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(wcaVar);
            }
            return a(new dea(this, wcaVar));
        }
        return (tca) invokeL.objValue;
    }

    public static <T> tca<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (tca) invokeV.objValue;
    }

    public final tca<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (tca<T>) g(aea.a());
        }
        return (tca) invokeV.objValue;
    }

    public final rga<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return OperatorReplay.D(this);
        }
        return (rga) invokeV.objValue;
    }

    public final tca<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return vda.a(this);
        }
        return (tca) invokeV.objValue;
    }

    public final ada t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return u(new yea(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (ada) invokeV.objValue;
    }

    public static <T> ada v(zca<? super T> zcaVar, tca<T> tcaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, zcaVar, tcaVar)) == null) {
            if (zcaVar != null) {
                if (tcaVar.a != null) {
                    zcaVar.d();
                    if (!(zcaVar instanceof uga)) {
                        zcaVar = new uga(zcaVar);
                    }
                    try {
                        aha.p(tcaVar, tcaVar.a).call(zcaVar);
                        return aha.o(zcaVar);
                    } catch (Throwable th) {
                        fda.e(th);
                        if (zcaVar.isUnsubscribed()) {
                            aha.j(aha.m(th));
                        } else {
                            try {
                                zcaVar.onError(aha.m(th));
                            } catch (Throwable th2) {
                                fda.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                aha.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return qha.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (ada) invokeLL.objValue;
    }

    public final tca<T> A(long j, TimeUnit timeUnit, tca<? extends T> tcaVar, wca wcaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, tcaVar, wcaVar})) == null) {
            return (tca<T>) g(new eea(j, timeUnit, tcaVar, wcaVar));
        }
        return (tca) invokeCommon.objValue;
    }

    public final rga<T> q(int i, long j, TimeUnit timeUnit, wca wcaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, wcaVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, wcaVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (rga) invokeCommon.objValue;
    }

    public final ada B(zca<? super T> zcaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zcaVar)) == null) {
            try {
                zcaVar.d();
                aha.p(this, this.a).call(zcaVar);
                return aha.o(zcaVar);
            } catch (Throwable th) {
                fda.e(th);
                try {
                    zcaVar.onError(aha.m(th));
                    return qha.c();
                } catch (Throwable th2) {
                    fda.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    aha.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (ada) invokeL.objValue;
    }

    public final tca<T> l(wca wcaVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, wcaVar, i)) == null) {
            return m(wcaVar, false, i);
        }
        return (tca) invokeLI.objValue;
    }

    public final tca<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) {
            return A(j, timeUnit, null, Schedulers.computation());
        }
        return (tca) invokeJL.objValue;
    }

    public final tca<T> m(wca wcaVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{wcaVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(wcaVar);
            }
            return (tca<T>) g(new zda(wcaVar, z, i));
        }
        return (tca) invokeCommon.objValue;
    }

    public final rga<T> r(long j, TimeUnit timeUnit, wca wcaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, wcaVar})) == null) {
            return OperatorReplay.F(this, j, timeUnit, wcaVar);
        }
        return (rga) invokeCommon.objValue;
    }

    public final ada x(hda<? super T> hdaVar, hda<Throwable> hdaVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, hdaVar, hdaVar2)) == null) {
            if (hdaVar != null) {
                if (hdaVar2 != null) {
                    return u(new yea(hdaVar, hdaVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (ada) invokeLL.objValue;
    }
}
