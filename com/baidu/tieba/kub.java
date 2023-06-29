package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.xsb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public class kub<T> implements xsb.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ltb<? super T> a;

    /* loaded from: classes6.dex */
    public class a implements zsb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicLong a;

        public a(kub kubVar, AtomicLong atomicLong) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kubVar, atomicLong};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atomicLong;
        }

        @Override // com.baidu.tieba.zsb
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ttb.b(this.a, j);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends dtb<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean e;
        public final /* synthetic */ dtb f;
        public final /* synthetic */ AtomicLong g;
        public final /* synthetic */ kub h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kub kubVar, dtb dtbVar, dtb dtbVar2, AtomicLong atomicLong) {
            super(dtbVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kubVar, dtbVar, dtbVar2, atomicLong};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((dtb) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = kubVar;
            this.f = dtbVar2;
            this.g = atomicLong;
        }

        @Override // com.baidu.tieba.dtb
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e(Long.MAX_VALUE);
            }
        }

        @Override // com.baidu.tieba.ysb
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.e) {
                this.e = true;
                this.f.onCompleted();
            }
        }

        @Override // com.baidu.tieba.ysb
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (!this.e) {
                    this.e = true;
                    this.f.onError(th);
                    return;
                }
                kxb.j(th);
            }
        }

        @Override // com.baidu.tieba.ysb
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048579, this, t) != null) || this.e) {
                return;
            }
            if (this.g.get() > 0) {
                this.f.onNext(t);
                this.g.decrementAndGet();
                return;
            }
            ltb<? super T> ltbVar = this.h.a;
            if (ltbVar != null) {
                try {
                    ltbVar.call(t);
                } catch (Throwable th) {
                    jtb.g(th, this, t);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final kub<Object> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-647919758, "Lcom/baidu/tieba/kub$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-647919758, "Lcom/baidu/tieba/kub$c;");
                    return;
                }
            }
            a = new kub<>();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public kub() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((ltb) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static <T> kub<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return (kub<T>) c.a;
        }
        return (kub) invokeV.objValue;
    }

    public kub(ltb<? super T> ltbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ltbVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ltbVar;
    }

    public dtb<? super T> call(dtb<? super T> dtbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dtbVar)) == null) {
            AtomicLong atomicLong = new AtomicLong();
            dtbVar.f(new a(this, atomicLong));
            return new b(this, dtbVar, dtbVar, atomicLong);
        }
        return (dtb) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xsb.b, com.baidu.tieba.ptb
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((dtb) ((dtb) obj));
    }
}
