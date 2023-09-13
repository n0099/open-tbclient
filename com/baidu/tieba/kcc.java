package com.baidu.tieba;

import com.baidu.tieba.lcc;
import com.baidu.tieba.vac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class kcc<T> extends lcc<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements lcc.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ TimeUnit b;

        /* renamed from: com.baidu.tieba.kcc$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0369a implements fbc {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ lcc.c a;
            public final /* synthetic */ Long b;

            public C0369a(a aVar, lcc.c cVar, Long l) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cVar, l};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
                this.b = l;
            }

            @Override // com.baidu.tieba.fbc
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.g(this.b.longValue());
                }
            }
        }

        public a(long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = timeUnit;
        }

        public zac call(lcc.c<T> cVar, Long l, vac.a aVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, cVar, l, aVar)) == null) {
                return aVar.c(new C0369a(this, cVar, l), this.a, this.b);
            }
            return (zac) invokeLLL.objValue;
        }

        @Override // com.baidu.tieba.lcc.a
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3) {
            return call((lcc.c) ((lcc.c) obj), (Long) obj2, (vac.a) obj3);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements lcc.b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ TimeUnit b;

        /* loaded from: classes6.dex */
        public class a implements fbc {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ lcc.c a;
            public final /* synthetic */ Long b;

            public a(b bVar, lcc.c cVar, Long l) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cVar, l};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
                this.b = l;
            }

            @Override // com.baidu.tieba.fbc
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.g(this.b.longValue());
                }
            }
        }

        public b(long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = timeUnit;
        }

        public zac call(lcc.c<T> cVar, Long l, T t, vac.a aVar) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, cVar, l, t, aVar)) == null) {
                return aVar.c(new a(this, cVar, l), this.a, this.b);
            }
            return (zac) invokeLLLL.objValue;
        }

        @Override // com.baidu.tieba.lcc.b
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4) {
            return call((lcc.c<Long>) obj, (Long) obj2, (Long) obj3, (vac.a) obj4);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kcc(long j, TimeUnit timeUnit, sac<? extends T> sacVar, vac vacVar) {
        super(new a(j, timeUnit), new b(j, timeUnit), sacVar, vacVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), timeUnit, sacVar, vacVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((lcc.a) objArr2[0], (lcc.b) objArr2[1], (sac) objArr2[2], (vac) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.lcc
    public /* bridge */ /* synthetic */ yac call(yac yacVar) {
        return super.call(yacVar);
    }
}
