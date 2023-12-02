package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.doc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public class tpc<T> implements doc.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final roc<? super T> a;

    /* loaded from: classes8.dex */
    public class a implements foc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicLong a;

        public a(tpc tpcVar, AtomicLong atomicLong) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tpcVar, atomicLong};
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

        @Override // com.baidu.tieba.foc
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                cpc.b(this.a, j);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends joc<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean e;
        public final /* synthetic */ joc f;
        public final /* synthetic */ AtomicLong g;
        public final /* synthetic */ tpc h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(tpc tpcVar, joc jocVar, joc jocVar2, AtomicLong atomicLong) {
            super(jocVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tpcVar, jocVar, jocVar2, atomicLong};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((joc) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = tpcVar;
            this.f = jocVar2;
            this.g = atomicLong;
        }

        @Override // com.baidu.tieba.joc
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e(Long.MAX_VALUE);
            }
        }

        @Override // com.baidu.tieba.eoc
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.e) {
                this.e = true;
                this.f.onCompleted();
            }
        }

        @Override // com.baidu.tieba.eoc
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (!this.e) {
                    this.e = true;
                    this.f.onError(th);
                    return;
                }
                tsc.j(th);
            }
        }

        @Override // com.baidu.tieba.eoc
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
            roc<? super T> rocVar = this.h.a;
            if (rocVar != null) {
                try {
                    rocVar.call(t);
                } catch (Throwable th) {
                    poc.g(th, this, t);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final tpc<Object> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-394845213, "Lcom/baidu/tieba/tpc$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-394845213, "Lcom/baidu/tieba/tpc$c;");
                    return;
                }
            }
            a = new tpc<>();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public tpc() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((roc) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static <T> tpc<T> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return (tpc<T>) c.a;
        }
        return (tpc) invokeV.objValue;
    }

    public tpc(roc<? super T> rocVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rocVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = rocVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.woc
    /* renamed from: a */
    public joc<? super T> call(joc<? super T> jocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jocVar)) == null) {
            AtomicLong atomicLong = new AtomicLong();
            jocVar.f(new a(this, atomicLong));
            return new b(this, jocVar, jocVar, atomicLong);
        }
        return (joc) invokeL.objValue;
    }
}
