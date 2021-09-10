package com.bytedance.sdk.component.b.a;

import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes9.dex */
public class a extends t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f64392a;

    /* renamed from: b  reason: collision with root package name */
    public static final long f64393b;

    /* renamed from: d  reason: collision with root package name */
    public static final long f64394d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64395e;

    /* renamed from: f  reason: collision with root package name */
    public a f64396f;

    /* renamed from: g  reason: collision with root package name */
    public long f64397g;

    /* renamed from: com.bytedance.sdk.component.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1883a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1883a() {
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
                        if (d2 == a.f64392a) {
                            a.f64392a = null;
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
        f64393b = TimeUnit.SECONDS.toMillis(60L);
        f64394d = TimeUnit.MILLISECONDS.toNanos(f64393b);
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
            a aVar = f64392a.f64396f;
            if (aVar == null) {
                long nanoTime = System.nanoTime();
                a.class.wait(f64393b);
                if (f64392a.f64396f != null || System.nanoTime() - nanoTime < f64394d) {
                    return null;
                }
                return f64392a;
            }
            long b2 = aVar.b(System.nanoTime());
            if (b2 > 0) {
                long j2 = b2 / 1000000;
                a.class.wait(j2, (int) (b2 - (1000000 * j2)));
                return null;
            }
            f64392a.f64396f = aVar.f64396f;
            aVar.f64396f = null;
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!this.f64395e) {
                long b_ = b_();
                boolean c2 = c();
                if (b_ != 0 || c2) {
                    this.f64395e = true;
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
            if (this.f64395e) {
                this.f64395e = false;
                return a(this);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private long b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j2)) == null) ? this.f64397g - j2 : invokeJ.longValue;
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

    public static synchronized void a(a aVar, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{aVar, Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            synchronized (a.class) {
                if (f64392a == null) {
                    f64392a = new a();
                    C1883a c1883a = new C1883a();
                    c1883a.setName("tt_pangle_thread_watch_dog");
                    c1883a.start();
                }
                long nanoTime = System.nanoTime();
                int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (i2 != 0 && z) {
                    aVar.f64397g = Math.min(j2, aVar.c_() - nanoTime) + nanoTime;
                } else if (i2 != 0) {
                    aVar.f64397g = j2 + nanoTime;
                } else if (z) {
                    aVar.f64397g = aVar.c_();
                } else {
                    throw new AssertionError();
                }
                long b2 = aVar.b(nanoTime);
                a aVar2 = f64392a;
                while (aVar2.f64396f != null && b2 >= aVar2.f64396f.b(nanoTime)) {
                    aVar2 = aVar2.f64396f;
                }
                aVar.f64396f = aVar2.f64396f;
                aVar2.f64396f = aVar;
                if (aVar2 == f64392a) {
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
                for (a aVar2 = f64392a; aVar2 != null; aVar2 = aVar2.f64396f) {
                    if (aVar2.f64396f == aVar) {
                        aVar2.f64396f = aVar.f64396f;
                        aVar.f64396f = null;
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
            public final /* synthetic */ r f64398a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f64399b;

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
                this.f64399b = this;
                this.f64398a = rVar;
            }

            @Override // com.bytedance.sdk.component.b.a.r
            public t a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f64399b : (t) invokeV.objValue;
            }

            @Override // com.bytedance.sdk.component.b.a.r
            public void a_(c cVar, long j2) throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, j2) != null) {
                    return;
                }
                u.a(cVar.f64406b, 0L, j2);
                while (true) {
                    long j3 = 0;
                    if (j2 <= 0) {
                        return;
                    }
                    o oVar = cVar.f64405a;
                    while (true) {
                        if (j3 >= 65536) {
                            break;
                        }
                        j3 += oVar.f64440c - oVar.f64439b;
                        if (j3 >= j2) {
                            j3 = j2;
                            break;
                        }
                        oVar = oVar.f64443f;
                    }
                    this.f64399b.a();
                    try {
                        try {
                            this.f64398a.a_(cVar, j3);
                            j2 -= j3;
                            this.f64399b.a(true);
                        } catch (IOException e2) {
                            throw this.f64399b.a(e2);
                        }
                    } catch (Throwable th) {
                        this.f64399b.a(false);
                        throw th;
                    }
                }
            }

            @Override // com.bytedance.sdk.component.b.a.r, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f64399b.a();
                    try {
                        try {
                            this.f64398a.close();
                            this.f64399b.a(true);
                        } catch (IOException e2) {
                            throw this.f64399b.a(e2);
                        }
                    } catch (Throwable th) {
                        this.f64399b.a(false);
                        throw th;
                    }
                }
            }

            @Override // com.bytedance.sdk.component.b.a.r, java.io.Flushable
            public void flush() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f64399b.a();
                    try {
                        try {
                            this.f64398a.flush();
                            this.f64399b.a(true);
                        } catch (IOException e2) {
                            throw this.f64399b.a(e2);
                        }
                    } catch (Throwable th) {
                        this.f64399b.a(false);
                        throw th;
                    }
                }
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                    return "AsyncTimeout.sink(" + this.f64398a + SmallTailInfo.EMOTION_SUFFIX;
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
            public final /* synthetic */ s f64400a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f64401b;

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
                this.f64401b = this;
                this.f64400a = sVar;
            }

            @Override // com.bytedance.sdk.component.b.a.s
            public long a(c cVar, long j2) throws IOException {
                InterceptResult invokeLJ;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLJ = interceptable2.invokeLJ(1048576, this, cVar, j2)) == null) {
                    this.f64401b.a();
                    try {
                        try {
                            long a2 = this.f64400a.a(cVar, j2);
                            this.f64401b.a(true);
                            return a2;
                        } catch (IOException e2) {
                            throw this.f64401b.a(e2);
                        }
                    } catch (Throwable th) {
                        this.f64401b.a(false);
                        throw th;
                    }
                }
                return invokeLJ.longValue;
            }

            @Override // com.bytedance.sdk.component.b.a.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f64401b.a();
                    try {
                        try {
                            this.f64400a.close();
                            this.f64401b.a(true);
                        } catch (IOException e2) {
                            throw this.f64401b.a(e2);
                        }
                    } catch (Throwable th) {
                        this.f64401b.a(false);
                        throw th;
                    }
                }
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return "AsyncTimeout.source(" + this.f64400a + SmallTailInfo.EMOTION_SUFFIX;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.bytedance.sdk.component.b.a.s
            public t a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64401b : (t) invokeV.objValue;
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
