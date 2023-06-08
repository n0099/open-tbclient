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
/* loaded from: classes7.dex */
public class rmb<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes7.dex */
    public interface c<T> extends bnb<smb<? super T>> {
        @Override // com.baidu.tieba.bnb
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes7.dex */
    public class a extends smb<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bnb b;
        public final /* synthetic */ bnb c;

        public a(rmb rmbVar, bnb bnbVar, bnb bnbVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rmbVar, bnbVar, bnbVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bnbVar;
            this.c = bnbVar2;
        }

        @Override // com.baidu.tieba.smb
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

        @Override // com.baidu.tieba.smb
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

    /* loaded from: classes7.dex */
    public class b implements bnb<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bnb a;

        public b(rmb rmbVar, bnb bnbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rmbVar, bnbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bnbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bnb
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public rmb(c<T> cVar) {
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
        this.a = xqb.i(cVar);
    }

    public final rmb<T> h(qmb qmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, qmbVar)) == null) {
            if (this instanceof apb) {
                return ((apb) this).n(qmbVar);
            }
            if (qmbVar != null) {
                return b(new hob(this.a, qmbVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (rmb) invokeL.objValue;
    }

    public static <T> nmb<T> a(rmb<T> rmbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, rmbVar)) == null) {
            return nmb.a(new iob(rmbVar.a));
        }
        return (nmb) invokeL.objValue;
    }

    public static <T> rmb<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new rmb<>(cVar);
        }
        return (rmb) invokeL.objValue;
    }

    public static <T> rmb<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return apb.m(t);
        }
        return (rmb) invokeL.objValue;
    }

    public final rmb<T> e(bnb<Throwable> bnbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bnbVar)) == null) {
            if (bnbVar != null) {
                return b(new eob(this, Actions.a(), new b(this, bnbVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (rmb) invokeL.objValue;
    }

    public final rmb<T> f(bnb<? super T> bnbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bnbVar)) == null) {
            if (bnbVar != null) {
                return b(new eob(this, bnbVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (rmb) invokeL.objValue;
    }

    public final rmb<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (rmb) invokeJL.objValue;
    }

    public final umb k(bnb<? super T> bnbVar, bnb<Throwable> bnbVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bnbVar, bnbVar2)) == null) {
            if (bnbVar != null) {
                if (bnbVar2 != null) {
                    return j(new a(this, bnbVar2, bnbVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (umb) invokeLL.objValue;
    }

    public final rmb<T> d(long j, TimeUnit timeUnit, qmb qmbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, qmbVar})) == null) {
            return b(new dob(this.a, j, timeUnit, qmbVar));
        }
        return (rmb) invokeCommon.objValue;
    }

    public final umb i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (umb) invokeV.objValue;
    }

    public final nmb<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (nmb) invokeV.objValue;
    }

    public final umb j(smb<? super T> smbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, smbVar)) == null) {
            if (smbVar != null) {
                try {
                    xqb.t(this, this.a).call(smbVar);
                    return xqb.s(smbVar);
                } catch (Throwable th) {
                    zmb.e(th);
                    try {
                        smbVar.b(xqb.r(th));
                        return nrb.b();
                    } catch (Throwable th2) {
                        zmb.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        xqb.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (umb) invokeL.objValue;
    }
}
