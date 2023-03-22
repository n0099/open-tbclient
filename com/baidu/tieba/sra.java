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
/* loaded from: classes6.dex */
public class sra<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes6.dex */
    public interface c<T> extends csa<tra<? super T>> {
        @Override // com.baidu.tieba.csa
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes6.dex */
    public class a extends tra<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ csa b;
        public final /* synthetic */ csa c;

        public a(sra sraVar, csa csaVar, csa csaVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sraVar, csaVar, csaVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = csaVar;
            this.c = csaVar2;
        }

        @Override // com.baidu.tieba.tra
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

        @Override // com.baidu.tieba.tra
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

    /* loaded from: classes6.dex */
    public class b implements csa<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ csa a;

        public b(sra sraVar, csa csaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sraVar, csaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = csaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.csa
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public sra(c<T> cVar) {
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
        this.a = vva.i(cVar);
    }

    public final sra<T> h(rra rraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rraVar)) == null) {
            if (this instanceof yta) {
                return ((yta) this).n(rraVar);
            }
            if (rraVar != null) {
                return b(new fta(this.a, rraVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (sra) invokeL.objValue;
    }

    public static <T> ora<T> a(sra<T> sraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sraVar)) == null) {
            return ora.a(new gta(sraVar.a));
        }
        return (ora) invokeL.objValue;
    }

    public static <T> sra<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new sra<>(cVar);
        }
        return (sra) invokeL.objValue;
    }

    public static <T> sra<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return yta.m(t);
        }
        return (sra) invokeL.objValue;
    }

    public final sra<T> e(csa<Throwable> csaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, csaVar)) == null) {
            if (csaVar != null) {
                return b(new cta(this, Actions.a(), new b(this, csaVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (sra) invokeL.objValue;
    }

    public final sra<T> f(csa<? super T> csaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, csaVar)) == null) {
            if (csaVar != null) {
                return b(new cta(this, csaVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (sra) invokeL.objValue;
    }

    public final sra<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (sra) invokeJL.objValue;
    }

    public final vra k(csa<? super T> csaVar, csa<Throwable> csaVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, csaVar, csaVar2)) == null) {
            if (csaVar != null) {
                if (csaVar2 != null) {
                    return j(new a(this, csaVar2, csaVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (vra) invokeLL.objValue;
    }

    public final sra<T> d(long j, TimeUnit timeUnit, rra rraVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, rraVar})) == null) {
            return b(new bta(this.a, j, timeUnit, rraVar));
        }
        return (sra) invokeCommon.objValue;
    }

    public final vra i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (vra) invokeV.objValue;
    }

    public final ora<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (ora) invokeV.objValue;
    }

    public final vra j(tra<? super T> traVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, traVar)) == null) {
            if (traVar != null) {
                try {
                    vva.t(this, this.a).call(traVar);
                    return vva.s(traVar);
                } catch (Throwable th) {
                    asa.e(th);
                    try {
                        traVar.b(vva.r(th));
                        return lwa.b();
                    } catch (Throwable th2) {
                        asa.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        vva.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (vra) invokeL.objValue;
    }
}
