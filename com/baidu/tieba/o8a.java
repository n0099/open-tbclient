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
/* loaded from: classes5.dex */
public class o8a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes5.dex */
    public interface c<T> extends y8a<p8a<? super T>> {
        @Override // com.baidu.tieba.y8a
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes5.dex */
    public class a extends p8a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y8a b;
        public final /* synthetic */ y8a c;

        public a(o8a o8aVar, y8a y8aVar, y8a y8aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o8aVar, y8aVar, y8aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y8aVar;
            this.c = y8aVar2;
        }

        @Override // com.baidu.tieba.p8a
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

        @Override // com.baidu.tieba.p8a
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

    /* loaded from: classes5.dex */
    public class b implements y8a<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y8a a;

        public b(o8a o8aVar, y8a y8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o8aVar, y8aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y8aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.y8a
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public o8a(c<T> cVar) {
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
        this.a = rca.i(cVar);
    }

    public final o8a<T> h(n8a n8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, n8aVar)) == null) {
            if (this instanceof uaa) {
                return ((uaa) this).n(n8aVar);
            }
            if (n8aVar != null) {
                return b(new baa(this.a, n8aVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (o8a) invokeL.objValue;
    }

    public static <T> k8a<T> a(o8a<T> o8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, o8aVar)) == null) {
            return k8a.a(new caa(o8aVar.a));
        }
        return (k8a) invokeL.objValue;
    }

    public static <T> o8a<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new o8a<>(cVar);
        }
        return (o8a) invokeL.objValue;
    }

    public static <T> o8a<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return uaa.m(t);
        }
        return (o8a) invokeL.objValue;
    }

    public final o8a<T> e(y8a<Throwable> y8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y8aVar)) == null) {
            if (y8aVar != null) {
                return b(new y9a(this, Actions.a(), new b(this, y8aVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (o8a) invokeL.objValue;
    }

    public final o8a<T> f(y8a<? super T> y8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, y8aVar)) == null) {
            if (y8aVar != null) {
                return b(new y9a(this, y8aVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (o8a) invokeL.objValue;
    }

    public final o8a<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (o8a) invokeJL.objValue;
    }

    public final r8a k(y8a<? super T> y8aVar, y8a<Throwable> y8aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, y8aVar, y8aVar2)) == null) {
            if (y8aVar != null) {
                if (y8aVar2 != null) {
                    return j(new a(this, y8aVar2, y8aVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (r8a) invokeLL.objValue;
    }

    public final o8a<T> d(long j, TimeUnit timeUnit, n8a n8aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, n8aVar})) == null) {
            return b(new x9a(this.a, j, timeUnit, n8aVar));
        }
        return (o8a) invokeCommon.objValue;
    }

    public final r8a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (r8a) invokeV.objValue;
    }

    public final k8a<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (k8a) invokeV.objValue;
    }

    public final r8a j(p8a<? super T> p8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, p8aVar)) == null) {
            if (p8aVar != null) {
                try {
                    rca.t(this, this.a).call(p8aVar);
                    return rca.s(p8aVar);
                } catch (Throwable th) {
                    w8a.e(th);
                    try {
                        p8aVar.b(rca.r(th));
                        return hda.b();
                    } catch (Throwable th2) {
                        w8a.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        rca.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (r8a) invokeL.objValue;
    }
}
