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
/* loaded from: classes7.dex */
public class nmb<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes7.dex */
    public interface a<T> extends bnb<tmb<? super T>> {
        @Override // com.baidu.tieba.bnb
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes7.dex */
    public interface b<R, T> extends fnb<tmb<? super R>, tmb<? super T>> {
        @Override // com.baidu.tieba.fnb
        /* synthetic */ R call(T t);
    }

    public nmb(a<T> aVar) {
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

    public static <T> nmb<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) {
            return new nmb<>(xqb.h(aVar));
        }
        return (nmb) invokeL.objValue;
    }

    public static <T> nmb<T> g(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (nmb) invokeL.objValue;
    }

    public static <T> nmb<T> h(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, t)) == null) {
            return ScalarSynchronousObservable.G(t);
        }
        return (nmb) invokeL.objValue;
    }

    public static <T> nmb<T> k(Iterable<? extends nmb<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iterable)) == null) {
            return l(g(iterable));
        }
        return (nmb) invokeL.objValue;
    }

    public static <T> nmb<T> l(nmb<? extends nmb<? extends T>> nmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, nmbVar)) == null) {
            if (nmbVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) nmbVar).J(UtilityFunctions.b());
            }
            return (nmb<T>) nmbVar.i(OperatorMerge.a(false));
        }
        return (nmb) invokeL.objValue;
    }

    public final nmb<T> A(qmb qmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qmbVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).K(qmbVar);
            }
            return a(new aob(this, qmbVar));
        }
        return (nmb) invokeL.objValue;
    }

    public final nmb<T> b(gnb<? super T, ? super T, Boolean> gnbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gnbVar)) == null) {
            return (nmb<T>) i(new tnb(gnbVar));
        }
        return (nmb) invokeL.objValue;
    }

    public final nmb<T> c(bnb<? super T> bnbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bnbVar)) == null) {
            return a(new mnb(this, new uob(bnbVar, Actions.a(), Actions.a())));
        }
        return (nmb) invokeL.objValue;
    }

    public final nmb<T> e(fnb<? super T, Boolean> fnbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fnbVar)) == null) {
            return a(new nnb(this, fnbVar));
        }
        return (nmb) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.fnb<? super T, ? extends com.baidu.tieba.nmb<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> nmb<R> f(fnb<? super T, ? extends nmb<? extends R>> fnbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fnbVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).J(fnbVar);
            }
            return l(j(fnbVar));
        }
        return (nmb) invokeL.objValue;
    }

    public final <R> nmb<R> i(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            return a(new onb(this.a, bVar));
        }
        return (nmb) invokeL.objValue;
    }

    public final <R> nmb<R> j(fnb<? super T, ? extends R> fnbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, fnbVar)) == null) {
            return a(new pnb(this, fnbVar));
        }
        return (nmb) invokeL.objValue;
    }

    public final nmb<T> m(qmb qmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, qmbVar)) == null) {
            return n(qmbVar, zob.c);
        }
        return (nmb) invokeL.objValue;
    }

    public final oqb<T> r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            return OperatorReplay.I(this, i);
        }
        return (oqb) invokeI.objValue;
    }

    public final umb w(tmb<? super T> tmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, tmbVar)) == null) {
            return x(tmbVar, this);
        }
        return (umb) invokeL.objValue;
    }

    public final umb y(bnb<? super T> bnbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bnbVar)) == null) {
            if (bnbVar != null) {
                return w(new vob(bnbVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (umb) invokeL.objValue;
    }

    public static nmb<Long> D(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65537, null, j, timeUnit)) == null) {
            return E(j, timeUnit, Schedulers.computation());
        }
        return (nmb) invokeJL.objValue;
    }

    public final nmb<T> B(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, timeUnit)) == null) {
            return C(j, timeUnit, null, Schedulers.computation());
        }
        return (nmb) invokeJL.objValue;
    }

    public final nmb<T> n(qmb qmbVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, qmbVar, i)) == null) {
            return o(qmbVar, false, i);
        }
        return (nmb) invokeLI.objValue;
    }

    public static nmb<Long> E(long j, TimeUnit timeUnit, qmb qmbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), timeUnit, qmbVar})) == null) {
            return a(new rnb(j, timeUnit, qmbVar));
        }
        return (nmb) invokeCommon.objValue;
    }

    public final oqb<T> t(long j, TimeUnit timeUnit, qmb qmbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j), timeUnit, qmbVar})) == null) {
            return OperatorReplay.J(this, j, timeUnit, qmbVar);
        }
        return (oqb) invokeCommon.objValue;
    }

    public static <T> nmb<T> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (nmb) invokeV.objValue;
    }

    public final nmb<T> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return (nmb<T>) i(xnb.a());
        }
        return (nmb) invokeV.objValue;
    }

    public final oqb<T> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return OperatorReplay.H(this);
        }
        return (oqb) invokeV.objValue;
    }

    public final nmb<T> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return qnb.a(this);
        }
        return (nmb) invokeV.objValue;
    }

    public final umb v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return w(new vob(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (umb) invokeV.objValue;
    }

    public static <T> umb x(tmb<? super T> tmbVar, nmb<T> nmbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, tmbVar, nmbVar)) == null) {
            if (tmbVar != null) {
                if (nmbVar.a != null) {
                    tmbVar.d();
                    if (!(tmbVar instanceof rqb)) {
                        tmbVar = new rqb(tmbVar);
                    }
                    try {
                        xqb.p(nmbVar, nmbVar.a).call(tmbVar);
                        return xqb.o(tmbVar);
                    } catch (Throwable th) {
                        zmb.e(th);
                        if (tmbVar.isUnsubscribed()) {
                            xqb.j(xqb.m(th));
                        } else {
                            try {
                                tmbVar.onError(xqb.m(th));
                            } catch (Throwable th2) {
                                zmb.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                xqb.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return nrb.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (umb) invokeLL.objValue;
    }

    public final nmb<T> C(long j, TimeUnit timeUnit, nmb<? extends T> nmbVar, qmb qmbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), timeUnit, nmbVar, qmbVar})) == null) {
            return (nmb<T>) i(new bob(j, timeUnit, nmbVar, qmbVar));
        }
        return (nmb) invokeCommon.objValue;
    }

    public final oqb<T> s(int i, long j, TimeUnit timeUnit, qmb qmbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, qmbVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.K(this, j, timeUnit, qmbVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (oqb) invokeCommon.objValue;
    }

    public final umb F(tmb<? super T> tmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tmbVar)) == null) {
            try {
                tmbVar.d();
                xqb.p(this, this.a).call(tmbVar);
                return xqb.o(tmbVar);
            } catch (Throwable th) {
                zmb.e(th);
                try {
                    tmbVar.onError(xqb.m(th));
                    return nrb.c();
                } catch (Throwable th2) {
                    zmb.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    xqb.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (umb) invokeL.objValue;
    }

    public final nmb<T> o(qmb qmbVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{qmbVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).K(qmbVar);
            }
            return (nmb<T>) i(new wnb(qmbVar, z, i));
        }
        return (nmb) invokeCommon.objValue;
    }

    public final umb z(bnb<? super T> bnbVar, bnb<Throwable> bnbVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, bnbVar, bnbVar2)) == null) {
            if (bnbVar != null) {
                if (bnbVar2 != null) {
                    return w(new vob(bnbVar, bnbVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (umb) invokeLL.objValue;
    }
}
