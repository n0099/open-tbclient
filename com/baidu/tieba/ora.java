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
public class ora<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes5.dex */
    public interface a<T> extends csa<ura<? super T>> {
        @Override // com.baidu.tieba.csa
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes5.dex */
    public interface b<R, T> extends gsa<ura<? super R>, ura<? super T>> {
        @Override // com.baidu.tieba.gsa
        /* synthetic */ R call(T t);
    }

    public ora(a<T> aVar) {
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

    public static <T> ora<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            return new ora<>(vva.h(aVar));
        }
        return (ora) invokeL.objValue;
    }

    public static <T> ora<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (ora) invokeL.objValue;
    }

    public static <T> ora<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) {
            return ScalarSynchronousObservable.C(t);
        }
        return (ora) invokeL.objValue;
    }

    public static <T> ora<T> i(Iterable<? extends ora<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return j(e(iterable));
        }
        return (ora) invokeL.objValue;
    }

    public static <T> ora<T> j(ora<? extends ora<? extends T>> oraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, oraVar)) == null) {
            if (oraVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) oraVar).F(UtilityFunctions.b());
            }
            return (ora<T>) oraVar.g(OperatorMerge.a(false));
        }
        return (ora) invokeL.objValue;
    }

    public final ora<T> b(csa<? super T> csaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, csaVar)) == null) {
            return a(new nsa(this, new sta(csaVar, Actions.a(), Actions.a())));
        }
        return (ora) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.gsa<? super T, ? extends com.baidu.tieba.ora<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> ora<R> d(gsa<? super T, ? extends ora<? extends R>> gsaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, gsaVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(gsaVar);
            }
            return j(h(gsaVar));
        }
        return (ora) invokeL.objValue;
    }

    public final <R> ora<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            return a(new osa(this.a, bVar));
        }
        return (ora) invokeL.objValue;
    }

    public final <R> ora<R> h(gsa<? super T, ? extends R> gsaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gsaVar)) == null) {
            return a(new psa(this, gsaVar));
        }
        return (ora) invokeL.objValue;
    }

    public final ora<T> k(rra rraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rraVar)) == null) {
            return l(rraVar, xta.c);
        }
        return (ora) invokeL.objValue;
    }

    public final mva<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return OperatorReplay.E(this, i);
        }
        return (mva) invokeI.objValue;
    }

    public final vra u(ura<? super T> uraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, uraVar)) == null) {
            return v(uraVar, this);
        }
        return (vra) invokeL.objValue;
    }

    public final vra w(csa<? super T> csaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, csaVar)) == null) {
            if (csaVar != null) {
                return u(new tta(csaVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (vra) invokeL.objValue;
    }

    public final ora<T> y(rra rraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, rraVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(rraVar);
            }
            return a(new ysa(this, rraVar));
        }
        return (ora) invokeL.objValue;
    }

    public static <T> ora<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (ora) invokeV.objValue;
    }

    public final ora<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (ora<T>) g(vsa.a());
        }
        return (ora) invokeV.objValue;
    }

    public final mva<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return OperatorReplay.D(this);
        }
        return (mva) invokeV.objValue;
    }

    public final ora<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return qsa.a(this);
        }
        return (ora) invokeV.objValue;
    }

    public final vra t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return u(new tta(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (vra) invokeV.objValue;
    }

    public static <T> vra v(ura<? super T> uraVar, ora<T> oraVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, uraVar, oraVar)) == null) {
            if (uraVar != null) {
                if (oraVar.a != null) {
                    uraVar.d();
                    if (!(uraVar instanceof pva)) {
                        uraVar = new pva(uraVar);
                    }
                    try {
                        vva.p(oraVar, oraVar.a).call(uraVar);
                        return vva.o(uraVar);
                    } catch (Throwable th) {
                        asa.e(th);
                        if (uraVar.isUnsubscribed()) {
                            vva.j(vva.m(th));
                        } else {
                            try {
                                uraVar.onError(vva.m(th));
                            } catch (Throwable th2) {
                                asa.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                vva.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return lwa.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (vra) invokeLL.objValue;
    }

    public final ora<T> A(long j, TimeUnit timeUnit, ora<? extends T> oraVar, rra rraVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, oraVar, rraVar})) == null) {
            return (ora<T>) g(new zsa(j, timeUnit, oraVar, rraVar));
        }
        return (ora) invokeCommon.objValue;
    }

    public final mva<T> q(int i, long j, TimeUnit timeUnit, rra rraVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, rraVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, rraVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (mva) invokeCommon.objValue;
    }

    public final vra B(ura<? super T> uraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uraVar)) == null) {
            try {
                uraVar.d();
                vva.p(this, this.a).call(uraVar);
                return vva.o(uraVar);
            } catch (Throwable th) {
                asa.e(th);
                try {
                    uraVar.onError(vva.m(th));
                    return lwa.c();
                } catch (Throwable th2) {
                    asa.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    vva.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (vra) invokeL.objValue;
    }

    public final ora<T> l(rra rraVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, rraVar, i)) == null) {
            return m(rraVar, false, i);
        }
        return (ora) invokeLI.objValue;
    }

    public final ora<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) {
            return A(j, timeUnit, null, Schedulers.computation());
        }
        return (ora) invokeJL.objValue;
    }

    public final ora<T> m(rra rraVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{rraVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(rraVar);
            }
            return (ora<T>) g(new usa(rraVar, z, i));
        }
        return (ora) invokeCommon.objValue;
    }

    public final mva<T> r(long j, TimeUnit timeUnit, rra rraVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, rraVar})) == null) {
            return OperatorReplay.F(this, j, timeUnit, rraVar);
        }
        return (mva) invokeCommon.objValue;
    }

    public final vra x(csa<? super T> csaVar, csa<Throwable> csaVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, csaVar, csaVar2)) == null) {
            if (csaVar != null) {
                if (csaVar2 != null) {
                    return u(new tta(csaVar, csaVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (vra) invokeLL.objValue;
    }
}
