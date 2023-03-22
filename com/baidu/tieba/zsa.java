package com.baidu.tieba;

import com.baidu.tieba.ata;
import com.baidu.tieba.rra;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class zsa<T> extends ata<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements ata.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ TimeUnit b;

        /* renamed from: com.baidu.tieba.zsa$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0502a implements bsa {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ata.c a;
            public final /* synthetic */ Long b;

            public C0502a(a aVar, ata.c cVar, Long l) {
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

            @Override // com.baidu.tieba.bsa
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

        public vra call(ata.c<T> cVar, Long l, rra.a aVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, cVar, l, aVar)) == null) {
                return aVar.c(new C0502a(this, cVar, l), this.a, this.b);
            }
            return (vra) invokeLLL.objValue;
        }

        @Override // com.baidu.tieba.ata.a
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3) {
            return call((ata.c) ((ata.c) obj), (Long) obj2, (rra.a) obj3);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ata.b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ TimeUnit b;

        /* loaded from: classes7.dex */
        public class a implements bsa {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ata.c a;
            public final /* synthetic */ Long b;

            public a(b bVar, ata.c cVar, Long l) {
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

            @Override // com.baidu.tieba.bsa
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

        public vra call(ata.c<T> cVar, Long l, T t, rra.a aVar) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, cVar, l, t, aVar)) == null) {
                return aVar.c(new a(this, cVar, l), this.a, this.b);
            }
            return (vra) invokeLLLL.objValue;
        }

        @Override // com.baidu.tieba.ata.b
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4) {
            return call((ata.c<Long>) obj, (Long) obj2, (Long) obj3, (rra.a) obj4);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zsa(long j, TimeUnit timeUnit, ora<? extends T> oraVar, rra rraVar) {
        super(new a(j, timeUnit), new b(j, timeUnit), oraVar, rraVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), timeUnit, oraVar, rraVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ata.a) objArr2[0], (ata.b) objArr2[1], (ora) objArr2[2], (rra) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ata
    public /* bridge */ /* synthetic */ ura call(ura uraVar) {
        return super.call(uraVar);
    }
}
