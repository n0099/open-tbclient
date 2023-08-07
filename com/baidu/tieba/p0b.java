package com.baidu.tieba;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.CronetException;
import com.baidu.turbonet.net.InlineExecutionProhibitedException;
import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UrlRequest;
import com.baidu.turbonet.net.UrlResponseInfo;
import com.baidu.turbonet.net.impl.CallbackExceptionImpl;
import com.baidu.turbonet.net.impl.CronetExceptionImpl;
import com.baidu.turbonet.net.impl.VersionSafeCallbacks;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.chromium.net.ThreadStatsUid;
@TargetApi(14)
/* loaded from: classes7.dex */
public final class p0b extends z0b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String s = "p0b";
    public transient /* synthetic */ FieldHolder $fh;
    public final n a;
    public final Executor b;
    public final String c;
    public final Map<String, String> d;
    public final List<String> e;
    public final AtomicInteger f;
    public final AtomicBoolean g;
    public final boolean h;
    public String i;
    public VersionSafeCallbacks.g j;
    public Executor k;
    public volatile int l;
    public String m;
    @Nullable
    public ReadableByteChannel n;
    public b1b o;
    public String p;
    public HttpURLConnection q;
    public o r;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948009639, "Lcom/baidu/tieba/p0b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948009639, "Lcom/baidu/tieba/p0b;");
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public Object d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void k(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, obj) == null) {
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Executor a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;

        /* renamed from: com.baidu.tieba.p0b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0424a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Runnable a;
            public final /* synthetic */ a b;

            public RunnableC0424a(a aVar, Runnable runnable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, runnable};
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
                this.a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int threadStatsTag = TrafficStats.getThreadStatsTag();
                    TrafficStats.setThreadStatsTag(this.b.b);
                    a aVar = this.b;
                    if (aVar.c) {
                        ThreadStatsUid.set(aVar.d);
                    }
                    try {
                        this.a.run();
                    } finally {
                        if (this.b.c) {
                            ThreadStatsUid.clear();
                        }
                        TrafficStats.setThreadStatsTag(threadStatsTag);
                    }
                }
            }
        }

        public a(p0b p0bVar, Executor executor, int i, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar, executor, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = executor;
            this.b = i;
            this.c = z;
            this.d = i2;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                this.a.execute(new RunnableC0424a(this, runnable));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ByteBuffer a;
        public final /* synthetic */ p0b b;

        /* loaded from: classes7.dex */
        public class a implements r0b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
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
                this.a = cVar;
            }

            @Override // com.baidu.tieba.r0b
            public void run() throws Exception {
                int read;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.b.n == null) {
                        read = -1;
                    } else {
                        read = this.a.b.n.read(this.a.a);
                    }
                    c cVar = this.a;
                    cVar.b.r0(read, cVar.a);
                }
            }
        }

        public c(p0b p0bVar, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar, byteBuffer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p0bVar;
            this.a = byteBuffer;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.execute(this.b.k0(new a(this)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ p0b b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.a.e(this.a.b.o, this.a.b.p);
                }
            }
        }

        public j(p0b p0bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p0bVar;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p0b p0bVar = this.b;
                p0bVar.p = URI.create(p0bVar.m).resolve(this.a).toString();
                this.b.e.add(this.b.p);
                this.b.t0(2, 3, new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final VersionSafeCallbacks.h a;
        public final Executor b;
        public final Executor c;
        public final /* synthetic */ p0b d;

        /* loaded from: classes7.dex */
        public class a implements r0b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ UrlResponseInfo a;
            public final /* synthetic */ String b;
            public final /* synthetic */ n c;

            public a(n nVar, UrlResponseInfo urlResponseInfo, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, urlResponseInfo, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = nVar;
                this.a = urlResponseInfo;
                this.b = str;
            }

            @Override // com.baidu.tieba.r0b
            public void run() throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    n nVar = this.c;
                    nVar.a.d(nVar.d, this.a, this.b);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements r0b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            public b(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = nVar;
            }

            @Override // com.baidu.tieba.r0b
            public void run() throws Exception {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d.f.compareAndSet(1, 4)) {
                    n nVar = this.a;
                    VersionSafeCallbacks.h hVar = nVar.a;
                    p0b p0bVar = nVar.d;
                    hVar.e(p0bVar, p0bVar.o);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements r0b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ UrlResponseInfo a;
            public final /* synthetic */ ByteBuffer b;
            public final /* synthetic */ n c;

            public c(n nVar, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, urlResponseInfo, byteBuffer};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = nVar;
                this.a = urlResponseInfo;
                this.b = byteBuffer;
            }

            @Override // com.baidu.tieba.r0b
            public void run() throws Exception {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c.d.f.compareAndSet(5, 4)) {
                    n nVar = this.c;
                    nVar.a.c(nVar.d, this.a, this.b);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ UrlResponseInfo a;
            public final /* synthetic */ n b;

            public d(n nVar, UrlResponseInfo urlResponseInfo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, urlResponseInfo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = nVar;
                this.a = urlResponseInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.b.a.a(this.b.d, this.a);
                    } catch (Exception e) {
                        Log.e(p0b.s, "Exception in onCanceled method", e);
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ UrlResponseInfo a;
            public final /* synthetic */ n b;

            public e(n nVar, UrlResponseInfo urlResponseInfo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, urlResponseInfo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = nVar;
                this.a = urlResponseInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.b.a.f(this.b.d, this.a);
                    } catch (Exception e) {
                        Log.e(p0b.s, "Exception in onSucceeded method", e);
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class f implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ UrlResponseInfo a;
            public final /* synthetic */ CronetException b;
            public final /* synthetic */ n c;

            public f(n nVar, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, urlResponseInfo, cronetException};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = nVar;
                this.a = urlResponseInfo;
                this.b = cronetException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.c.a.b(this.c.d, this.a, this.b);
                    } catch (Exception e) {
                        Log.e(p0b.s, "Exception in onFailed method", e);
                    }
                }
            }
        }

        public n(p0b p0bVar, UrlRequest.Callback callback, Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar, callback, executor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = p0bVar;
            this.a = new VersionSafeCallbacks.h(callback);
            if (p0bVar.h) {
                this.b = executor;
                this.c = null;
                return;
            }
            this.b = new s0b(executor);
            this.c = executor;
        }

        public void a(r0b r0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r0bVar) == null) {
                try {
                    this.b.execute(this.d.v0(r0bVar));
                } catch (RejectedExecutionException e2) {
                    this.d.h0(new CronetExceptionImpl("Exception posting task to executor", e2));
                }
            }
        }

        public void b(UrlResponseInfo urlResponseInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, urlResponseInfo) != null) {
                return;
            }
            this.d.f0();
            this.b.execute(new d(this, urlResponseInfo));
        }

        public void f(UrlResponseInfo urlResponseInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, urlResponseInfo) == null) {
                a(new b(this));
            }
        }

        public void g(UrlResponseInfo urlResponseInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, urlResponseInfo) == null) {
                this.b.execute(new e(this, urlResponseInfo));
            }
        }

        public void c(UrlResponseInfo urlResponseInfo, CronetException cronetException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, urlResponseInfo, cronetException) == null) {
                this.d.f0();
                f fVar = new f(this, urlResponseInfo, cronetException);
                try {
                    this.b.execute(fVar);
                } catch (InlineExecutionProhibitedException e2) {
                    Log.e(p0b.s, "execute fail", e2);
                    Executor executor = this.c;
                    if (executor != null) {
                        executor.execute(fVar);
                    }
                }
            }
        }

        public void d(UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, urlResponseInfo, byteBuffer) == null) {
                a(new c(this, urlResponseInfo, byteBuffer));
            }
        }

        public void e(UrlResponseInfo urlResponseInfo, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, urlResponseInfo, str) == null) {
                a(new a(this, urlResponseInfo, str));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class p implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Executor a;
        public final Runnable b;
        @GuardedBy("mTaskQueue")
        public final ArrayDeque<Runnable> c;
        @GuardedBy("mTaskQueue")
        public boolean d;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p a;

            public a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = pVar;
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                boolean z2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    synchronized (this.a.c) {
                        if (this.a.d) {
                            return;
                        }
                        Runnable runnable = (Runnable) this.a.c.pollFirst();
                        p pVar = this.a;
                        if (runnable != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        pVar.d = z;
                        while (runnable != null) {
                            try {
                                runnable.run();
                                synchronized (this.a.c) {
                                    runnable = (Runnable) this.a.c.pollFirst();
                                    p pVar2 = this.a;
                                    if (runnable != null) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    pVar2.d = z2;
                                }
                            } catch (Throwable th) {
                                synchronized (this.a.c) {
                                    this.a.d = false;
                                    try {
                                        this.a.a.execute(this.a.b);
                                    } catch (RejectedExecutionException e) {
                                        Log.e(p0b.s, Log.getStackTraceString(e));
                                    }
                                    throw th;
                                }
                            }
                        }
                    }
                }
            }
        }

        public p(Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {executor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new a(this);
            this.c = new ArrayDeque<>();
            this.a = executor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                synchronized (this.c) {
                    this.c.addLast(runnable);
                    try {
                        this.a.execute(this.b);
                    } catch (RejectedExecutionException e) {
                        this.c.removeLast();
                        Log.e(p0b.s, Log.getStackTraceString(e));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r0b a;
        public final /* synthetic */ p0b b;

        public b(p0b p0bVar, r0b r0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar, r0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p0bVar;
            this.a = r0bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.run();
                } catch (Throwable th) {
                    this.b.i0(th);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p0b a;

        public d(p0b p0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p0bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.r != null) {
                    try {
                        this.a.r.x();
                    } catch (IOException e) {
                        Log.e(p0b.s, "Exception when closing OutputChannel", e);
                    }
                }
                if (this.a.q != null) {
                    this.a.q.disconnect();
                    this.a.q = null;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p0b a;

        public e(p0b p0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p0bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.n != null) {
                try {
                    this.a.n.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.a.n = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p0b a;

        public f(p0b p0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p0bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e.add(this.a.m);
                this.a.o0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p0b a;

        public g(p0b p0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p0bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p0b p0bVar = this.a;
                p0bVar.m = p0bVar.p;
                this.a.p = null;
                this.a.o0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements r0b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p0b a;

        public h(p0b p0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p0bVar;
        }

        @Override // com.baidu.tieba.r0b
        public void run() throws Exception {
            ReadableByteChannel a;
            List<String> list;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.q == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            String str = "http/1.1";
            int i = 0;
            while (true) {
                String headerFieldKey = this.a.q.getHeaderFieldKey(i);
                if (headerFieldKey == null) {
                    break;
                }
                if ("X-Android-Selected-Transport".equalsIgnoreCase(headerFieldKey)) {
                    str = this.a.q.getHeaderField(i);
                }
                if (!headerFieldKey.startsWith("X-Android")) {
                    arrayList.add(new AbstractMap.SimpleEntry(headerFieldKey, this.a.q.getHeaderField(i)));
                }
                i++;
            }
            int responseCode = this.a.q.getResponseCode();
            this.a.o = new b1b(new ArrayList(this.a.e), responseCode, this.a.q.getResponseMessage(), Collections.unmodifiableList(arrayList), false, str, "", 0L);
            if (responseCode >= 300 && responseCode < 400 && (list = this.a.o.g().get("location")) != null) {
                this.a.p0(list.get(0));
                return;
            }
            this.a.l0();
            if (responseCode >= 400) {
                InputStream errorStream = this.a.q.getErrorStream();
                p0b p0bVar = this.a;
                if (errorStream == null) {
                    a = null;
                } else {
                    a = l0b.a(errorStream);
                }
                p0bVar.n = a;
                this.a.a.f(this.a.o);
                return;
            }
            p0b p0bVar2 = this.a;
            p0bVar2.n = l0b.a(p0bVar2.q.getInputStream());
            this.a.a.f(this.a.o);
        }
    }

    /* loaded from: classes7.dex */
    public class i implements r0b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p0b a;

        public i(p0b p0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p0bVar;
        }

        @Override // com.baidu.tieba.r0b
        public void run() throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j.close();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements r0b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p0b a;

        public k(p0b p0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p0bVar;
        }

        @Override // com.baidu.tieba.r0b
        public void run() throws Exception {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.f.get() == 8) {
                return;
            }
            URL url = new URL(this.a.m);
            if (this.a.q != null) {
                this.a.q.disconnect();
                this.a.q = null;
            }
            this.a.q = (HttpURLConnection) url.openConnection();
            boolean z = false;
            this.a.q.setInstanceFollowRedirects(false);
            if (!this.a.d.containsKey("User-Agent")) {
                this.a.d.put("User-Agent", this.a.c);
            }
            for (Map.Entry entry : this.a.d.entrySet()) {
                this.a.q.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            if (this.a.i == null) {
                this.a.i = "GET";
            }
            this.a.q.setRequestMethod(this.a.i);
            if (this.a.j == null) {
                this.a.l = 10;
                this.a.q.connect();
                this.a.n0();
                return;
            }
            p0b p0bVar = this.a;
            p0bVar.r = new o(p0bVar, p0bVar.k, this.a.b, this.a.q, this.a.j);
            o oVar = this.a.r;
            if (this.a.e.size() == 1) {
                z = true;
            }
            oVar.v(z);
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r0b a;
        public final /* synthetic */ p0b b;

        public l(p0b p0bVar, r0b r0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar, r0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p0bVar;
            this.a = r0bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.run();
                } catch (Throwable th) {
                    this.b.g0(th);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r0b a;
        public final /* synthetic */ p0b b;

        public m(p0b p0bVar, r0b r0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar, r0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p0bVar;
            this.a = r0bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.run();
                } catch (Throwable th) {
                    this.b.j0(th);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class o extends o0b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final HttpURLConnection h;
        public final AtomicBoolean i;
        public WritableByteChannel j;
        public OutputStream k;
        public final /* synthetic */ p0b l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(p0b p0bVar, Executor executor, Executor executor2, HttpURLConnection httpURLConnection, VersionSafeCallbacks.g gVar) {
            super(executor, executor2, gVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar, executor, executor2, httpURLConnection, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Executor) objArr2[0], (Executor) objArr2[1], (UploadDataProvider) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = p0bVar;
            this.i = new AtomicBoolean(false);
            this.h = httpURLConnection;
        }

        @Override // com.baidu.tieba.o0b
        public void o() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                x();
                this.l.n0();
            }
        }

        public void x() throws IOException {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.j != null && this.i.compareAndSet(false, true)) {
                this.j.close();
            }
        }

        @Override // com.baidu.tieba.o0b
        public Runnable p(r0b r0bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r0bVar)) == null) {
                return this.l.k0(r0bVar);
            }
            return (Runnable) invokeL.objValue;
        }

        @Override // com.baidu.tieba.o0b
        public Runnable q(r0b r0bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r0bVar)) == null) {
                return this.l.u0(r0bVar);
            }
            return (Runnable) invokeL.objValue;
        }

        @Override // com.baidu.tieba.o0b
        public int t(ByteBuffer byteBuffer) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, byteBuffer)) == null) {
                int i = 0;
                while (byteBuffer.hasRemaining()) {
                    i += this.j.write(byteBuffer);
                }
                this.k.flush();
                return i;
            }
            return invokeL.intValue;
        }

        @Override // com.baidu.tieba.o0b
        public void u(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, th) == null) {
                this.l.i0(th);
            }
        }

        @Override // com.baidu.tieba.o0b
        public void r() throws IOException {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.j == null) {
                this.l.l = 10;
                this.h.setDoOutput(true);
                this.h.connect();
                this.l.l = 12;
                OutputStream outputStream = this.h.getOutputStream();
                this.k = outputStream;
                this.j = Channels.newChannel(outputStream);
            }
        }

        @Override // com.baidu.tieba.o0b
        public void s(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
                if (j > 0 && j <= 2147483647L) {
                    this.h.setFixedLengthStreamingMode((int) j);
                } else if (j > 2147483647L && Build.VERSION.SDK_INT >= 19) {
                    this.h.setFixedLengthStreamingMode(j);
                } else {
                    this.h.setChunkedStreamingMode(8192);
                }
            }
        }
    }

    public p0b(UrlRequest.Callback callback, Executor executor, Executor executor2, String str, String str2, boolean z, boolean z2, int i2, boolean z3, int i3) {
        int threadStatsTag;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback, executor, executor2, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.e = new ArrayList();
        this.f = new AtomicInteger(0);
        this.g = new AtomicBoolean(false);
        if (str != null) {
            if (callback != null) {
                if (executor != null) {
                    if (executor2 != null) {
                        this.h = z;
                        this.a = new n(this, callback, executor2);
                        if (z2) {
                            threadStatsTag = i2;
                        } else {
                            threadStatsTag = TrafficStats.getThreadStatsTag();
                        }
                        this.b = new p(new a(this, executor, threadStatsTag, z3, i3));
                        this.m = str;
                        this.c = str2;
                        return;
                    }
                    throw new NullPointerException("userExecutor is required");
                }
                throw new NullPointerException("Executor is required");
            }
            throw new NullPointerException("Listener is required");
        }
        throw new NullPointerException("URL is required");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void e(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, byteBuffer) == null) {
            v0b.a(byteBuffer);
            v0b.b(byteBuffer);
            t0(4, 5, new c(this, byteBuffer));
        }
    }

    public final void g0(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, th) == null) {
            h0(new CronetExceptionImpl("System error", th));
        }
    }

    public final void h0(CronetException cronetException) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, cronetException) == null) && s0(6)) {
            m0();
            l0();
            this.a.c(this.o, cronetException);
        }
    }

    public final void i0(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, th) == null) {
            h0(new CallbackExceptionImpl("Exception received from UploadDataProvider", th));
        }
    }

    public final void j0(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, th) == null) {
            h0(new CallbackExceptionImpl("Exception received from UrlRequest.Callback", th));
        }
    }

    public final Runnable k0(r0b r0bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, r0bVar)) == null) {
            return new l(this, r0bVar);
        }
        return (Runnable) invokeL.objValue;
    }

    public final void p0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            t0(1, 2, new j(this, str));
        }
    }

    public final Runnable u0(r0b r0bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, r0bVar)) == null) {
            return new b(this, r0bVar);
        }
        return (Runnable) invokeL.objValue;
    }

    public final Runnable v0(r0b r0bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, r0bVar)) == null) {
            return new m(this, r0bVar);
        }
        return (Runnable) invokeL.objValue;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            t0(3, 1, new g(this));
        }
    }

    public final void e0() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || (i2 = this.f.get()) == 0) {
            return;
        }
        throw new IllegalStateException("Request is already started. State is: " + i2);
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.execute(new e(this));
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            t0(0, 1, new f(this));
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.b.execute(new d(this));
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.b.execute(k0(new h(this)));
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.b.execute(k0(new k(this)));
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int andSet = this.f.getAndSet(8);
            if (andSet == 1 || andSet == 2 || andSet == 3 || andSet == 4 || andSet == 5) {
                m0();
                l0();
                this.a.b(this.o);
            }
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.j != null && this.g.compareAndSet(false, true)) {
            try {
                this.k.execute(u0(new i(this)));
            } catch (RejectedExecutionException e2) {
                Log.e(s, "Exception when closing uploadDataProvider", e2);
            }
        }
    }

    @Override // com.baidu.tieba.z0b
    public void n(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) {
            e0();
            if (q0(str) && !str2.contains("\r\n")) {
                if (this.d.containsKey(str)) {
                    this.d.remove(str);
                }
                this.d.put(str, str2);
                return;
            }
            throw new IllegalArgumentException("Invalid header " + str + "=" + str2);
        }
    }

    @Override // com.baidu.tieba.z0b
    public void q(UploadDataProvider uploadDataProvider, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, uploadDataProvider, executor) == null) {
            if (uploadDataProvider != null) {
                if (this.d.containsKey("Content-Type")) {
                    e0();
                    if (this.i == null) {
                        this.i = "POST";
                    }
                    this.j = new VersionSafeCallbacks.g(uploadDataProvider);
                    if (this.h) {
                        this.k = executor;
                        return;
                    } else {
                        this.k = new s0b(executor);
                        return;
                    }
                }
                throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
            }
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
    }

    @Override // com.baidu.tieba.z0b
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            e0();
            if (str != null) {
                if (!HttpOptions.METHOD_NAME.equalsIgnoreCase(str) && !"GET".equalsIgnoreCase(str) && !"HEAD".equalsIgnoreCase(str) && !"POST".equalsIgnoreCase(str) && !HttpPut.METHOD_NAME.equalsIgnoreCase(str) && !HttpDelete.METHOD_NAME.equalsIgnoreCase(str) && !HttpTrace.METHOD_NAME.equalsIgnoreCase(str) && !"PATCH".equalsIgnoreCase(str)) {
                    throw new IllegalArgumentException("Invalid http method " + str);
                }
                this.i = str;
                return;
            }
            throw new NullPointerException("Method is required.");
        }
    }

    public final boolean q0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt != ',' && charAt != '/' && charAt != '{' && charAt != '}') {
                    switch (charAt) {
                        case '\'':
                        case '(':
                        case ')':
                            break;
                        default:
                            switch (charAt) {
                                case ':':
                                case ';':
                                case '<':
                                case '=':
                                case '>':
                                case '?':
                                case '@':
                                    break;
                                default:
                                    switch (charAt) {
                                        case '[':
                                        case '\\':
                                        case ']':
                                            break;
                                        default:
                                            if (!Character.isISOControl(charAt) && !Character.isWhitespace(charAt)) {
                                            }
                                            break;
                                    }
                            }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void r0(int i2, ByteBuffer byteBuffer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048605, this, i2, byteBuffer) == null) {
            if (i2 != -1) {
                this.a.d(this.o, byteBuffer);
                return;
            }
            ReadableByteChannel readableByteChannel = this.n;
            if (readableByteChannel != null) {
                readableByteChannel.close();
            }
            if (this.f.compareAndSet(5, 7)) {
                m0();
                this.a.g(this.o);
            }
        }
    }

    public final boolean s0(int i2) {
        int i3;
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
            do {
                i3 = this.f.get();
                if (i3 != 0) {
                    if (i3 == 6 || i3 == 7 || i3 == 8) {
                        return false;
                    }
                } else {
                    throw new IllegalStateException("Can't enter error state before start");
                }
            } while (!this.f.compareAndSet(i3, i2));
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void t0(int i2, int i3, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048607, this, i2, i3, runnable) == null) {
            if (!this.f.compareAndSet(i2, i3)) {
                int i4 = this.f.get();
                if (i4 != 8 && i4 != 6) {
                    throw new IllegalStateException("Invalid state transition - expected " + i2 + " but was " + i4);
                }
                return;
            }
            runnable.run();
        }
    }
}
