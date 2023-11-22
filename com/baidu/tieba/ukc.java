package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jjc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.internal.util.UtilityFunctions;
/* loaded from: classes8.dex */
public final class ukc<T, U> implements jjc.b<T, T>, dkc<U, U, Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ckc<? super T, ? extends U> a;
    public final dkc<? super U, ? super U, Boolean> b;

    /* loaded from: classes8.dex */
    public class a extends pjc<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public U e;
        public boolean f;
        public final /* synthetic */ pjc g;
        public final /* synthetic */ ukc h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ukc ukcVar, pjc pjcVar, pjc pjcVar2) {
            super(pjcVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ukcVar, pjcVar, pjcVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((pjc) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = ukcVar;
            this.g = pjcVar2;
        }

        @Override // com.baidu.tieba.kjc
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.onCompleted();
            }
        }

        @Override // com.baidu.tieba.kjc
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.g.onError(th);
            }
        }

        @Override // com.baidu.tieba.kjc
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
                            if (!this.h.b.a(u, call).booleanValue()) {
                                this.g.onNext(t);
                                return;
                            } else {
                                e(1L);
                                return;
                            }
                        } catch (Throwable th) {
                            vjc.g(th, this.g, obj);
                            return;
                        }
                    }
                    this.f = true;
                    this.g.onNext(t);
                } catch (Throwable th2) {
                    vjc.g(th2, this.g, t);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ukc<?, ?> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-370833698, "Lcom/baidu/tieba/ukc$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-370833698, "Lcom/baidu/tieba/ukc$b;");
                    return;
                }
            }
            a = new ukc<>(UtilityFunctions.b());
        }
    }

    public ukc(ckc<? super T, ? extends U> ckcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ckcVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ckcVar;
        this.b = this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ckc
    /* renamed from: c */
    public pjc<? super T> call(pjc<? super T> pjcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pjcVar)) == null) {
            return new a(this, pjcVar, pjcVar);
        }
        return (pjc) invokeL.objValue;
    }

    public ukc(dkc<? super U, ? super U, Boolean> dkcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dkcVar};
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
        this.b = dkcVar;
    }

    public static <T> ukc<T, T> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return (ukc<T, T>) b.a;
        }
        return (ukc) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dkc
    /* renamed from: b */
    public Boolean a(U u, U u2) {
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
}
