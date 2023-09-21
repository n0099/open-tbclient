package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.kcc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.internal.util.UtilityFunctions;
/* loaded from: classes8.dex */
public final class tdc<T, U> implements kcc.b<T, T>, edc<U, U, Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ddc<? super T, ? extends U> a;
    public final edc<? super U, ? super U, Boolean> b;

    /* loaded from: classes8.dex */
    public class a extends qcc<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public U e;
        public boolean f;
        public final /* synthetic */ qcc g;
        public final /* synthetic */ tdc h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(tdc tdcVar, qcc qccVar, qcc qccVar2) {
            super(qccVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tdcVar, qccVar, qccVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((qcc) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = tdcVar;
            this.g = qccVar2;
        }

        @Override // com.baidu.tieba.lcc
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.onCompleted();
            }
        }

        @Override // com.baidu.tieba.lcc
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.g.onError(th);
            }
        }

        @Override // com.baidu.tieba.lcc
        public void onNext(T t) {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                try {
                    U call = this.h.a.call(t);
                    U u = this.e;
                    this.e = call;
                    if (this.f) {
                        try {
                            if (!this.h.b.call(u, call).booleanValue()) {
                                this.g.onNext(t);
                                return;
                            } else {
                                e(1L);
                                return;
                            }
                        } catch (Throwable th) {
                            wcc.g(th, this.g, obj);
                            return;
                        }
                    }
                    this.f = true;
                    this.g.onNext(t);
                } catch (Throwable th2) {
                    wcc.g(th2, this.g, t);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final tdc<?, ?> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-405927496, "Lcom/baidu/tieba/tdc$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-405927496, "Lcom/baidu/tieba/tdc$b;");
                    return;
                }
            }
            a = new tdc<>(UtilityFunctions.b());
        }
    }

    public tdc(ddc<? super T, ? extends U> ddcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ddcVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ddcVar;
        this.b = this;
    }

    public qcc<? super T> call(qcc<? super T> qccVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qccVar)) == null) {
            return new a(this, qccVar, qccVar);
        }
        return (qcc) invokeL.objValue;
    }

    public tdc(edc<? super U, ? super U, Boolean> edcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {edcVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = UtilityFunctions.b();
        this.b = edcVar;
    }

    public static <T> tdc<T, T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return (tdc<T, T>) b.a;
        }
        return (tdc) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.edc
    public Boolean call(U u, U u2) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u, u2)) == null) {
            if (u != u2 && (u == null || !u.equals(u2))) {
                z = false;
            } else {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.kcc.b, com.baidu.tieba.ddc
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((qcc) ((qcc) obj));
    }
}
