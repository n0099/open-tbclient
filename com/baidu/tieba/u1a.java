package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.uz9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public final class u1a extends uz9 {
    public static /* synthetic */ Interceptable $ic;
    public static final u1a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i, i2)) == null) {
            if (i < i2) {
                return -1;
            }
            return i == i2 ? 0 : 1;
        }
        return invokeII.intValue;
    }

    /* loaded from: classes6.dex */
    public static final class a extends uz9.a implements yz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicInteger a;
        public final PriorityBlockingQueue<b> b;
        public final k4a c;
        public final AtomicInteger d;

        /* renamed from: com.baidu.tieba.u1a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0440a implements e0a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;
            public final /* synthetic */ a b;

            public C0440a(a aVar, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = bVar;
            }

            @Override // com.baidu.tieba.e0a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.remove(this.a);
                }
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new AtomicInteger();
            this.b = new PriorityBlockingQueue<>();
            this.c = new k4a();
            this.d = new AtomicInteger();
        }

        @Override // com.baidu.tieba.uz9.a
        public yz9 b(e0a e0aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e0aVar)) == null) {
                return d(e0aVar, a());
            }
            return (yz9) invokeL.objValue;
        }

        @Override // com.baidu.tieba.uz9.a
        public yz9 c(e0a e0aVar, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{e0aVar, Long.valueOf(j), timeUnit})) == null) {
                long a = a() + timeUnit.toMillis(j);
                return d(new t1a(e0aVar, this, a), a);
            }
            return (yz9) invokeCommon.objValue;
        }

        public final yz9 d(e0a e0aVar, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, e0aVar, j)) == null) {
                if (this.c.isUnsubscribed()) {
                    return o4a.c();
                }
                b bVar = new b(e0aVar, Long.valueOf(j), this.a.incrementAndGet());
                this.b.add(bVar);
                if (this.d.getAndIncrement() == 0) {
                    do {
                        b poll = this.b.poll();
                        if (poll != null) {
                            poll.a.call();
                        }
                    } while (this.d.decrementAndGet() > 0);
                    return o4a.c();
                }
                return o4a.a(new C0440a(this, bVar));
            }
            return (yz9) invokeLJ.objValue;
        }

        @Override // com.baidu.tieba.yz9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.isUnsubscribed();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.yz9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.c.unsubscribe();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements Comparable<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final e0a a;
        public final Long b;
        public final int c;

        public b(e0a e0aVar, Long l, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e0aVar, l, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e0aVar;
            this.b = l;
            this.c = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                int compareTo = this.b.compareTo(bVar.b);
                if (compareTo == 0) {
                    return u1a.a(this.c, bVar.c);
                }
                return compareTo;
            }
            return invokeL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948159524, "Lcom/baidu/tieba/u1a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948159524, "Lcom/baidu/tieba/u1a;");
                return;
            }
        }
        a = new u1a();
    }

    public u1a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.uz9
    public uz9.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a();
        }
        return (uz9.a) invokeV.objValue;
    }
}
