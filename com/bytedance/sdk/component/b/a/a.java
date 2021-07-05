package com.bytedance.sdk.component.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class a extends t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f27965a;

    /* renamed from: b  reason: collision with root package name */
    public static final long f27966b;

    /* renamed from: d  reason: collision with root package name */
    public static final long f27967d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f27968e;

    /* renamed from: f  reason: collision with root package name */
    public a f27969f;

    /* renamed from: g  reason: collision with root package name */
    public long f27970g;

    /* renamed from: com.bytedance.sdk.component.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0317a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0317a() {
            super("Okio Watchdog");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0019, code lost:
            r1.a_();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            while (true) {
                synchronized (a.class) {
                    a d2 = a.d();
                    if (d2 != null) {
                        if (d2 == a.f27965a) {
                            a.f27965a = null;
                            return;
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(731338746, "Lcom/bytedance/sdk/component/b/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(731338746, "Lcom/bytedance/sdk/component/b/a/a;");
                return;
            }
        }
        f27966b = TimeUnit.SECONDS.toMillis(60L);
        f27967d = TimeUnit.MILLISECONDS.toNanos(f27966b);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a d() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            a aVar = f27965a.f27969f;
            if (aVar == null) {
                long nanoTime = System.nanoTime();
                a.class.wait(f27966b);
                if (f27965a.f27969f != null || System.nanoTime() - nanoTime < f27967d) {
                    return null;
                }
                return f27965a;
            }
            long b2 = aVar.b(System.nanoTime());
            if (b2 > 0) {
                long j = b2 / 1000000;
                a.class.wait(j, (int) (b2 - (1000000 * j)));
                return null;
            }
            f27965a.f27969f = aVar.f27969f;
            aVar.f27969f = null;
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!this.f27968e) {
                long b_ = b_();
                boolean c2 = c();
                if (b_ != 0 || c2) {
                    this.f27968e = true;
                    a(this, b_, c2);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Unbalanced enter/exit");
        }
    }

    public void a_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f27968e) {
                this.f27968e = false;
                return a(this);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private long b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65540, this, j)) == null) ? this.f27970g - j : invokeJ.longValue;
    }

    public IOException b(IOException iOException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iOException)) == null) {
            InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
            return interruptedIOException;
        }
        return (IOException) invokeL.objValue;
    }

    public static synchronized void a(a aVar, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{aVar, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            synchronized (a.class) {
                if (f27965a == null) {
                    f27965a = new a();
                    C0317a c0317a = new C0317a();
                    c0317a.setName("tt_pangle_thread_watch_dog");
                    c0317a.start();
                }
                long nanoTime = System.nanoTime();
                int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i2 != 0 && z) {
                    aVar.f27970g = Math.min(j, aVar.c_() - nanoTime) + nanoTime;
                } else if (i2 != 0) {
                    aVar.f27970g = j + nanoTime;
                } else if (z) {
                    aVar.f27970g = aVar.c_();
                } else {
                    throw new AssertionError();
                }
                long b2 = aVar.b(nanoTime);
                a aVar2 = f27965a;
                while (aVar2.f27969f != null && b2 >= aVar2.f27969f.b(nanoTime)) {
                    aVar2 = aVar2.f27969f;
                }
                aVar.f27969f = aVar2.f27969f;
                aVar2.f27969f = aVar;
                if (aVar2 == f27965a) {
                    a.class.notify();
                }
            }
        }
    }

    public static synchronized boolean a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) {
            synchronized (a.class) {
                for (a aVar2 = f27965a; aVar2 != null; aVar2 = aVar2.f27969f) {
                    if (aVar2.f27969f == aVar) {
                        aVar2.f27969f = aVar.f27969f;
                        aVar.f27969f = null;
                        return false;
                    }
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final r a(r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rVar)) == null) ? new r(this, rVar) { // from class: com.bytedance.sdk.component.b.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ r f27971a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f27972b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, rVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27972b = this;
                this.f27971a = rVar;
            }

            @Override // com.bytedance.sdk.component.b.a.r
            public t a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f27972b : (t) invokeV.objValue;
            }

            @Override // com.bytedance.sdk.component.b.a.r
            public void a_(c cVar, long j) throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, j) != null) {
                    return;
                }
                u.a(cVar.f27979b, 0L, j);
                while (true) {
                    long j2 = 0;
                    if (j <= 0) {
                        return;
                    }
                    o oVar = cVar.f27978a;
                    while (true) {
                        if (j2 >= 65536) {
                            break;
                        }
                        j2 += oVar.f28013c - oVar.f28012b;
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        }
                        oVar = oVar.f28016f;
                    }
                    this.f27972b.a();
                    try {
                        try {
                            this.f27971a.a_(cVar, j2);
                            j -= j2;
                            this.f27972b.a(true);
                        } catch (IOException e2) {
                            throw this.f27972b.a(e2);
                        }
                    } catch (Throwable th) {
                        this.f27972b.a(false);
                        throw th;
                    }
                }
            }

            @Override // com.bytedance.sdk.component.b.a.r, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f27972b.a();
                    try {
                        try {
                            this.f27971a.close();
                            this.f27972b.a(true);
                        } catch (IOException e2) {
                            throw this.f27972b.a(e2);
                        }
                    } catch (Throwable th) {
                        this.f27972b.a(false);
                        throw th;
                    }
                }
            }

            @Override // com.bytedance.sdk.component.b.a.r, java.io.Flushable
            public void flush() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f27972b.a();
                    try {
                        try {
                            this.f27971a.flush();
                            this.f27972b.a(true);
                        } catch (IOException e2) {
                            throw this.f27972b.a(e2);
                        }
                    } catch (Throwable th) {
                        this.f27972b.a(false);
                        throw th;
                    }
                }
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                    return "AsyncTimeout.sink(" + this.f27971a + SmallTailInfo.EMOTION_SUFFIX;
                }
                return (String) invokeV.objValue;
            }
        } : (r) invokeL.objValue;
    }

    public final s a(s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sVar)) == null) ? new s(this, sVar) { // from class: com.bytedance.sdk.component.b.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ s f27973a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f27974b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, sVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27974b = this;
                this.f27973a = sVar;
            }

            @Override // com.bytedance.sdk.component.b.a.s
            public long a(c cVar, long j) throws IOException {
                InterceptResult invokeLJ;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLJ = interceptable2.invokeLJ(1048576, this, cVar, j)) == null) {
                    this.f27974b.a();
                    try {
                        try {
                            long a2 = this.f27973a.a(cVar, j);
                            this.f27974b.a(true);
                            return a2;
                        } catch (IOException e2) {
                            throw this.f27974b.a(e2);
                        }
                    } catch (Throwable th) {
                        this.f27974b.a(false);
                        throw th;
                    }
                }
                return invokeLJ.longValue;
            }

            @Override // com.bytedance.sdk.component.b.a.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f27974b.a();
                    try {
                        try {
                            this.f27973a.close();
                            this.f27974b.a(true);
                        } catch (IOException e2) {
                            throw this.f27974b.a(e2);
                        }
                    } catch (Throwable th) {
                        this.f27974b.a(false);
                        throw th;
                    }
                }
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return "AsyncTimeout.source(" + this.f27973a + SmallTailInfo.EMOTION_SUFFIX;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.bytedance.sdk.component.b.a.s
            public t a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27974b : (t) invokeV.objValue;
            }
        } : (s) invokeL.objValue;
    }

    public final void a(boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && b() && z) {
            throw b((IOException) null);
        }
    }

    public final IOException a(IOException iOException) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iOException)) == null) ? !b() ? iOException : b(iOException) : (IOException) invokeL.objValue;
    }
}
