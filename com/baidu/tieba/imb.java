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
public class imb<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes6.dex */
    public interface a<T> extends wmb<omb<? super T>> {
        @Override // com.baidu.tieba.wmb
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes6.dex */
    public interface b<R, T> extends anb<omb<? super R>, omb<? super T>> {
        @Override // com.baidu.tieba.anb
        /* synthetic */ R call(T t);
    }

    public imb(a<T> aVar) {
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

    public static <T> imb<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) {
            return new imb<>(sqb.h(aVar));
        }
        return (imb) invokeL.objValue;
    }

    public static <T> imb<T> g(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (imb) invokeL.objValue;
    }

    public static <T> imb<T> h(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, t)) == null) {
            return ScalarSynchronousObservable.G(t);
        }
        return (imb) invokeL.objValue;
    }

    public static <T> imb<T> k(Iterable<? extends imb<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iterable)) == null) {
            return l(g(iterable));
        }
        return (imb) invokeL.objValue;
    }

    public static <T> imb<T> l(imb<? extends imb<? extends T>> imbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, imbVar)) == null) {
            if (imbVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) imbVar).J(UtilityFunctions.b());
            }
            return (imb<T>) imbVar.i(OperatorMerge.a(false));
        }
        return (imb) invokeL.objValue;
    }

    public final imb<T> A(lmb lmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lmbVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).K(lmbVar);
            }
            return a(new vnb(this, lmbVar));
        }
        return (imb) invokeL.objValue;
    }

    public final imb<T> b(bnb<? super T, ? super T, Boolean> bnbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bnbVar)) == null) {
            return (imb<T>) i(new onb(bnbVar));
        }
        return (imb) invokeL.objValue;
    }

    public final imb<T> c(wmb<? super T> wmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, wmbVar)) == null) {
            return a(new hnb(this, new pob(wmbVar, Actions.a(), Actions.a())));
        }
        return (imb) invokeL.objValue;
    }

    public final imb<T> e(anb<? super T, Boolean> anbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, anbVar)) == null) {
            return a(new inb(this, anbVar));
        }
        return (imb) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.anb<? super T, ? extends com.baidu.tieba.imb<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> imb<R> f(anb<? super T, ? extends imb<? extends R>> anbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, anbVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).J(anbVar);
            }
            return l(j(anbVar));
        }
        return (imb) invokeL.objValue;
    }

    public final <R> imb<R> i(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            return a(new jnb(this.a, bVar));
        }
        return (imb) invokeL.objValue;
    }

    public final <R> imb<R> j(anb<? super T, ? extends R> anbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, anbVar)) == null) {
            return a(new knb(this, anbVar));
        }
        return (imb) invokeL.objValue;
    }

    public final imb<T> m(lmb lmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, lmbVar)) == null) {
            return n(lmbVar, uob.c);
        }
        return (imb) invokeL.objValue;
    }

    public final jqb<T> r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            return OperatorReplay.I(this, i);
        }
        return (jqb) invokeI.objValue;
    }

    public final pmb w(omb<? super T> ombVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, ombVar)) == null) {
            return x(ombVar, this);
        }
        return (pmb) invokeL.objValue;
    }

    public final pmb y(wmb<? super T> wmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, wmbVar)) == null) {
            if (wmbVar != null) {
                return w(new qob(wmbVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (pmb) invokeL.objValue;
    }

    public static imb<Long> D(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65537, null, j, timeUnit)) == null) {
            return E(j, timeUnit, Schedulers.computation());
        }
        return (imb) invokeJL.objValue;
    }

    public final imb<T> B(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, timeUnit)) == null) {
            return C(j, timeUnit, null, Schedulers.computation());
        }
        return (imb) invokeJL.objValue;
    }

    public final imb<T> n(lmb lmbVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, lmbVar, i)) == null) {
            return o(lmbVar, false, i);
        }
        return (imb) invokeLI.objValue;
    }

    public static imb<Long> E(long j, TimeUnit timeUnit, lmb lmbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), timeUnit, lmbVar})) == null) {
            return a(new mnb(j, timeUnit, lmbVar));
        }
        return (imb) invokeCommon.objValue;
    }

    public final jqb<T> t(long j, TimeUnit timeUnit, lmb lmbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j), timeUnit, lmbVar})) == null) {
            return OperatorReplay.J(this, j, timeUnit, lmbVar);
        }
        return (jqb) invokeCommon.objValue;
    }

    public static <T> imb<T> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (imb) invokeV.objValue;
    }

    public final imb<T> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return (imb<T>) i(snb.a());
        }
        return (imb) invokeV.objValue;
    }

    public final jqb<T> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return OperatorReplay.H(this);
        }
        return (jqb) invokeV.objValue;
    }

    public final imb<T> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return lnb.a(this);
        }
        return (imb) invokeV.objValue;
    }

    public final pmb v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return w(new qob(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (pmb) invokeV.objValue;
    }

    public static <T> pmb x(omb<? super T> ombVar, imb<T> imbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, ombVar, imbVar)) == null) {
            if (ombVar != null) {
                if (imbVar.a != null) {
                    ombVar.d();
                    if (!(ombVar instanceof mqb)) {
                        ombVar = new mqb(ombVar);
                    }
                    try {
                        sqb.p(imbVar, imbVar.a).call(ombVar);
                        return sqb.o(ombVar);
                    } catch (Throwable th) {
                        umb.e(th);
                        if (ombVar.isUnsubscribed()) {
                            sqb.j(sqb.m(th));
                        } else {
                            try {
                                ombVar.onError(sqb.m(th));
                            } catch (Throwable th2) {
                                umb.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                sqb.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return irb.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (pmb) invokeLL.objValue;
    }

    public final imb<T> C(long j, TimeUnit timeUnit, imb<? extends T> imbVar, lmb lmbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), timeUnit, imbVar, lmbVar})) == null) {
            return (imb<T>) i(new wnb(j, timeUnit, imbVar, lmbVar));
        }
        return (imb) invokeCommon.objValue;
    }

    public final jqb<T> s(int i, long j, TimeUnit timeUnit, lmb lmbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, lmbVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.K(this, j, timeUnit, lmbVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (jqb) invokeCommon.objValue;
    }

    public final pmb F(omb<? super T> ombVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ombVar)) == null) {
            try {
                ombVar.d();
                sqb.p(this, this.a).call(ombVar);
                return sqb.o(ombVar);
            } catch (Throwable th) {
                umb.e(th);
                try {
                    ombVar.onError(sqb.m(th));
                    return irb.c();
                } catch (Throwable th2) {
                    umb.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    sqb.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (pmb) invokeL.objValue;
    }

    public final imb<T> o(lmb lmbVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{lmbVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).K(lmbVar);
            }
            return (imb<T>) i(new rnb(lmbVar, z, i));
        }
        return (imb) invokeCommon.objValue;
    }

    public final pmb z(wmb<? super T> wmbVar, wmb<Throwable> wmbVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, wmbVar, wmbVar2)) == null) {
            if (wmbVar != null) {
                if (wmbVar2 != null) {
                    return w(new qob(wmbVar, wmbVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (pmb) invokeLL.objValue;
    }
}
