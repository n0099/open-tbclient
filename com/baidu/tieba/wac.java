package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import rx.functions.Actions;
import rx.schedulers.Schedulers;
/* loaded from: classes8.dex */
public class wac<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes8.dex */
    public interface c<T> extends gbc<xac<? super T>> {
        @Override // com.baidu.tieba.gbc
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes8.dex */
    public class a extends xac<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gbc b;
        public final /* synthetic */ gbc c;

        public a(wac wacVar, gbc gbcVar, gbc gbcVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wacVar, gbcVar, gbcVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gbcVar;
            this.c = gbcVar2;
        }

        @Override // com.baidu.tieba.xac
        public final void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.b.call(th);
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // com.baidu.tieba.xac
        public final void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                } finally {
                    unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements gbc<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gbc a;

        public b(wac wacVar, gbc gbcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wacVar, gbcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gbcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gbc
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public wac(c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = gfc.i(cVar);
    }

    public final wac<T> h(vac vacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vacVar)) == null) {
            if (this instanceof jdc) {
                return ((jdc) this).n(vacVar);
            }
            if (vacVar != null) {
                return b(new qcc(this.a, vacVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (wac) invokeL.objValue;
    }

    public static <T> sac<T> a(wac<T> wacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, wacVar)) == null) {
            return sac.d(new rcc(wacVar.a));
        }
        return (sac) invokeL.objValue;
    }

    public static <T> wac<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new wac<>(cVar);
        }
        return (wac) invokeL.objValue;
    }

    public static <T> wac<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return jdc.m(t);
        }
        return (wac) invokeL.objValue;
    }

    public final wac<T> e(gbc<Throwable> gbcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gbcVar)) == null) {
            if (gbcVar != null) {
                return b(new ncc(this, Actions.a(), new b(this, gbcVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (wac) invokeL.objValue;
    }

    public final wac<T> f(gbc<? super T> gbcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, gbcVar)) == null) {
            if (gbcVar != null) {
                return b(new ncc(this, gbcVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (wac) invokeL.objValue;
    }

    public final wac<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (wac) invokeJL.objValue;
    }

    public final zac k(gbc<? super T> gbcVar, gbc<Throwable> gbcVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, gbcVar, gbcVar2)) == null) {
            if (gbcVar != null) {
                if (gbcVar2 != null) {
                    return j(new a(this, gbcVar2, gbcVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (zac) invokeLL.objValue;
    }

    public final wac<T> d(long j, TimeUnit timeUnit, vac vacVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, vacVar})) == null) {
            return b(new mcc(this.a, j, timeUnit, vacVar));
        }
        return (wac) invokeCommon.objValue;
    }

    public final zac i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (zac) invokeV.objValue;
    }

    public final sac<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (sac) invokeV.objValue;
    }

    public final zac j(xac<? super T> xacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xacVar)) == null) {
            if (xacVar != null) {
                try {
                    gfc.t(this, this.a).call(xacVar);
                    return gfc.s(xacVar);
                } catch (Throwable th) {
                    ebc.e(th);
                    try {
                        xacVar.b(gfc.r(th));
                        return wfc.b();
                    } catch (Throwable th2) {
                        ebc.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        gfc.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (zac) invokeL.objValue;
    }
}
