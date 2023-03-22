package com.baidu.turbonet.net;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dz9;
import com.baidu.tieba.hz9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.net.UrlRequest;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.concurrent.GuardedBy;
@JNINamespace
/* loaded from: classes7.dex */
public final class CronetUrlRequest implements UrlRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public CronetUploadDataStream C;
    public UrlResponseInfo D;
    public h E;
    public Runnable F;
    @GuardedBy("mUrlRequestAdapterLock")
    public long a;
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean b;
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean c;
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean d;
    @Nullable
    @GuardedBy("mUrlRequestAdapterLock")
    public final i e;
    public final Object f;
    public final CronetUrlRequestContext g;
    public final Executor h;
    public final List<String> i;
    public long j;
    public final UrlRequest.Callback k;
    public RequestTimeInfo l;
    public final String m;
    public final int n;
    public String o;
    public final HeadersList p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public int w;
    public int x;
    public int y;
    public Object z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(267984202, "Lcom/baidu/turbonet/net/CronetUrlRequest;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(267984202, "Lcom/baidu/turbonet/net/CronetUrlRequest;");
        }
    }

    @NativeClassQualifiedName
    private native boolean nativeAddRequestHeader(long j, String str, String str2);

    private native long nativeCreateRequestAdapter(long j, String str, int i2, boolean z, boolean z2, boolean z3);

    @NativeClassQualifiedName
    private native void nativeDestroy(long j, boolean z);

    @NativeClassQualifiedName
    private native void nativeDisableResponseAutoUngzip(long j);

    @NativeClassQualifiedName
    private native void nativeEnableBrotliByRequest(long j);

    @NativeClassQualifiedName
    private native void nativeFollowDeferredRedirect(long j);

    @NativeClassQualifiedName
    private native String nativeGetConnectionAttempts(long j, boolean z);

    @NativeClassQualifiedName
    private native String nativeGetDNSErrorCode(long j);

    @NativeClassQualifiedName
    private native String nativeGetDNSNameServers(long j);

    @NativeClassQualifiedName
    private native String nativeGetDNSResults(long j);

    @NativeClassQualifiedName
    private native String nativeGetRemoteEndpoint(long j);

    @NativeClassQualifiedName
    private native RequestTimeInfo nativeGetRequestTimeInfo(long j);

    @NativeClassQualifiedName
    private native void nativeGetStatus(long j, UrlRequest.StatusListener statusListener);

    @NativeClassQualifiedName
    private native String nativeGetSuperPipeInfo(long j);

    @NativeClassQualifiedName
    private native boolean nativeReadData(long j, ByteBuffer byteBuffer, int i2, int i3);

    @NativeClassQualifiedName
    private native long nativeRequestTimeGap(long j, int i2);

    @NativeClassQualifiedName
    private native void nativeSetDestinationAddress(long j, String str);

    @NativeClassQualifiedName
    private native boolean nativeSetHttpMethod(long j, String str);

    @NativeClassQualifiedName
    private native void nativeSetRequestTag(long j, String str);

    @NativeClassQualifiedName
    private native void nativeSetResponseBodyReadTimeout(long j, int i2);

    @NativeClassQualifiedName
    private native void nativeSetResponseHeaderRecvTimeout(long j, int i2);

    @NativeClassQualifiedName
    private native void nativeSetTCPConnectTimeout(long j, int i2);

    @NativeClassQualifiedName
    private native void nativeSetTimeout(long j, int i2);

    @NativeClassQualifiedName
    private native void nativeStart(long j);

    @NativeClassQualifiedName
    private native int nativeSynGetStatus(long j);

    public static int z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65583, null, i2)) == null) {
            if (i2 != 0) {
                int i3 = 1;
                if (i2 != 1) {
                    i3 = 2;
                    if (i2 != 2) {
                        i3 = 4;
                        if (i2 != 4) {
                            return 3;
                        }
                    }
                }
                return i3;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    /* loaded from: classes7.dex */
    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public HeadersList() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ HeadersList(a aVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static class SpendTimeType {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public SpendTimeType() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CronetUrlRequest a;

        public a(CronetUrlRequest cronetUrlRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cronetUrlRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C.o();
                synchronized (this.a.f) {
                    if (this.a.C()) {
                        return;
                    }
                    this.a.C.k(this.a.a);
                    this.a.H();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlRequestException a;
        public final /* synthetic */ CronetUrlRequest b;

        public b(CronetUrlRequest cronetUrlRequest, UrlRequestException urlRequestException) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest, urlRequestException};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cronetUrlRequest;
            this.a = urlRequestException;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            synchronized (this.b.f) {
                if (this.b.C()) {
                    return;
                }
                this.b.A(false);
                try {
                    this.b.k.b(this.b, this.b.D, this.a);
                } catch (Exception e) {
                    dz9.c("ChromiumNetwork", "Exception in onError method", e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlResponseInfo a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CronetUrlRequest c;

        public c(CronetUrlRequest cronetUrlRequest, UrlResponseInfo urlResponseInfo, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest, urlResponseInfo, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cronetUrlRequest;
            this.a = urlResponseInfo;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            synchronized (this.c.f) {
                if (this.c.C()) {
                    return;
                }
                this.c.c = true;
                try {
                    this.c.k.d(this.c, this.a, this.b);
                } catch (Exception e) {
                    this.c.D(e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CronetUrlRequest a;

        public d(CronetUrlRequest cronetUrlRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cronetUrlRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            synchronized (this.a.f) {
                if (this.a.C()) {
                    return;
                }
                if (this.a.e != null) {
                    this.a.e.f();
                }
                this.a.d = true;
                try {
                    this.a.k.e(this.a, this.a.D);
                } catch (Exception e) {
                    this.a.D(e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CronetUrlRequest a;

        public e(CronetUrlRequest cronetUrlRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cronetUrlRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            synchronized (this.a.f) {
                if (this.a.C()) {
                    return;
                }
                this.a.A(false);
                try {
                    this.a.k.f(this.a, this.a.D);
                } catch (Exception e) {
                    dz9.c("ChromiumNetwork", "Exception in onComplete method", e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CronetUrlRequest a;

        public f(CronetUrlRequest cronetUrlRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cronetUrlRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    dz9.c("ChromiumNetwork", "****** onCanceled, url is: %s", this.a.D.h());
                    this.a.k.a(this.a, this.a.D);
                } catch (Exception e) {
                    dz9.c("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlRequest.StatusListener a;
        public final /* synthetic */ int b;

        public g(CronetUrlRequest cronetUrlRequest, UrlRequest.StatusListener statusListener, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest, statusListener, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = statusListener;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(UrlRequest.Status.a(this.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteBuffer a;
        public final /* synthetic */ CronetUrlRequest b;

        public h(CronetUrlRequest cronetUrlRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cronetUrlRequest;
        }

        public /* synthetic */ h(CronetUrlRequest cronetUrlRequest, a aVar) {
            this(cronetUrlRequest);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ByteBuffer byteBuffer = this.a;
                this.a = null;
                try {
                    synchronized (this.b.f) {
                        if (this.b.C()) {
                            return;
                        }
                        this.b.d = true;
                        this.b.k.c(this.b, this.b.D, byteBuffer);
                    }
                } catch (Exception e) {
                    this.b.D(e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public Long a;
        @Nullable
        public Long b;
        @Nullable
        public Long c;

        public i(CronetUrlRequest cronetUrlRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ i(CronetUrlRequest cronetUrlRequest, a aVar) {
            this(cronetUrlRequest);
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a != null && this.c == null) {
                this.c = Long.valueOf(SystemClock.elapsedRealtime() - this.a.longValue());
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a == null) {
                    this.a = Long.valueOf(SystemClock.elapsedRealtime());
                    return;
                }
                throw new IllegalStateException("onRequestStarted called repeatedly");
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a != null && this.b == null) {
                this.b = Long.valueOf(SystemClock.elapsedRealtime() - this.a.longValue());
            }
        }
    }

    public CronetUrlRequest(CronetUrlRequestContext cronetUrlRequestContext, String str, int i2, UrlRequest.Callback callback, Executor executor, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4) {
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cronetUrlRequestContext, str, Integer.valueOf(i2), callback, executor, collection, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = false;
        this.d = false;
        this.f = new Object();
        this.i = new ArrayList();
        this.p = new HeadersList(null);
        if (str != null) {
            if (callback != null) {
                if (executor != null) {
                    if (collection != null) {
                        this.g = cronetUrlRequestContext;
                        this.m = str;
                        this.i.add(str);
                        this.n = z(i2);
                        this.k = callback;
                        this.h = executor;
                        if (z) {
                            iVar = new i(this, null);
                        } else {
                            iVar = null;
                        }
                        this.e = iVar;
                        this.q = z2;
                        this.r = z3;
                        this.s = z4;
                        this.t = false;
                        this.u = false;
                        this.v = 0;
                        this.w = 0;
                        this.x = 0;
                        this.y = 0;
                        this.z = null;
                        this.A = null;
                        this.B = null;
                        this.D = new UrlResponseInfo(new ArrayList(this.i), 0, "", new HeadersList(null), false, "", "");
                        return;
                    }
                    throw new NullPointerException("requestAnnotations is required");
                }
                throw new NullPointerException("Executor is required");
            }
            throw new NullPointerException("Listener is required");
        }
        throw new NullPointerException("URL is required");
    }

    @CalledByNative
    public static RequestTimeInfo createObject(long j, long j2, long j3, long j4, long j5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)})) == null) {
            return new RequestTimeInfo(j, j2, j3, j4, j5);
        }
        return (RequestTimeInfo) invokeCommon.objValue;
    }

    @CalledByNative
    private void onError(int i2, int i3, int i4, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65568, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(j)}) == null) {
            UrlResponseInfo urlResponseInfo = this.D;
            if (urlResponseInfo != null) {
                urlResponseInfo.j(this.j + j);
            }
            B(new UrlRequestException("Exception in CronetUrlRequest: " + str, i2, i3));
        }
    }

    @CalledByNative
    private void onSucceeded(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65573, this, j) == null) {
            this.D.j(this.j + j);
            F(new e(this));
        }
    }

    public final void B(UrlRequestException urlRequestException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, urlRequestException) == null) {
            F(new b(this, urlRequestException));
        }
    }

    public void E(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
            UrlRequestException urlRequestException = new UrlRequestException("Exception received from UploadDataProvider", th);
            dz9.c("ChromiumNetwork", "Exception in upload method", th);
            B(urlRequestException);
        }
    }

    public final void F(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, runnable) == null) {
            try {
                this.h.execute(runnable);
            } catch (RejectedExecutionException e2) {
                dz9.c("ChromiumNetwork", "Exception posting task to executor", e2);
                A(false);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            y();
            this.y = i2;
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            y();
            this.v = i2;
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            y();
            this.x = i2;
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            y();
            if (str != null) {
                this.o = str;
                return;
            }
            throw new NullPointerException("Method is required.");
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void f(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, obj) == null) {
            y();
            this.z = obj;
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            y();
            this.B = str;
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            y();
            this.A = str;
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            y();
            this.w = i2;
        }
    }

    @CalledByNative
    private void onStatus(UrlRequest.StatusListener statusListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65572, this, statusListener, i2) == null) {
            F(new g(this, statusListener, i2));
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            y();
            if (str != null) {
                if (str2 != null) {
                    this.p.add(new AbstractMap.SimpleImmutableEntry(str, str2));
                    return;
                }
                throw new NullPointerException("Invalid header value.");
            }
            throw new NullPointerException("Invalid header name.");
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void i(UploadDataProvider uploadDataProvider, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, uploadDataProvider, executor) == null) {
            if (uploadDataProvider != null) {
                if (this.o == null) {
                    this.o = "POST";
                }
                this.C = new CronetUploadDataStream(uploadDataProvider, executor, this);
                return;
            }
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
    }

    @CalledByNative
    private void onCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            F(new f(this));
        }
    }

    @GuardedBy("mUrlRequestAdapterLock")
    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b && this.a == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @GuardedBy("mUrlRequestAdapterLock")
    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            i iVar = this.e;
            if (iVar != null) {
                iVar.e();
            }
            nativeStart(this.a);
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            y();
            this.u = true;
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public Object getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.z;
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            y();
            this.t = true;
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this.f) {
                if (this.b || C()) {
                    throw new IllegalStateException("Request is already started.");
                }
            }
        }
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i2, int i3, int i4, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65569, this, new Object[]{byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)}) == null) {
            this.D.j(this.j + j);
            if (byteBuffer.position() == i3 && byteBuffer.limit() == i4) {
                if (this.E == null) {
                    this.E = new h(this, null);
                }
                byteBuffer.position(i3 + i2);
                h hVar = this.E;
                hVar.a = byteBuffer;
                F(hVar);
                return;
            }
            B(new UrlRequestException("ByteBuffer modified externally during read", null));
        }
    }

    @CalledByNative
    private void onRedirectReceived(String str, int i2, String str2, String[] strArr, boolean z, String str3, String str4, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65570, this, new Object[]{str, Integer.valueOf(i2), str2, strArr, Boolean.valueOf(z), str3, str4, Long.valueOf(j)}) == null) {
            UrlResponseInfo G = G(i2, str2, strArr, z, str3, str4);
            long j2 = this.j + j;
            this.j = j2;
            G.j(j2);
            this.i.add(str);
            F(new c(this, G, str));
        }
    }

    @CalledByNative
    private void onResponseStarted(int i2, String str, String[] strArr, boolean z, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65571, this, new Object[]{Integer.valueOf(i2), str, strArr, Boolean.valueOf(z), str2, str3}) == null) {
            this.D = G(i2, str, strArr, z, str2, str3);
            F(new d(this));
        }
    }

    public final void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            synchronized (this.f) {
                if (this.a == 0) {
                    return;
                }
                nativeGetDNSNameServers(this.a).isEmpty();
                nativeGetDNSResults(this.a).isEmpty();
                nativeGetDNSErrorCode(this.a).isEmpty();
                nativeGetConnectionAttempts(this.a, false).isEmpty();
                nativeGetConnectionAttempts(this.a, true).isEmpty();
                nativeGetRemoteEndpoint(this.a).isEmpty();
                nativeGetSuperPipeInfo(this.a).isEmpty();
                int i2 = (nativeRequestTimeGap(this.a, 1) > 0L ? 1 : (nativeRequestTimeGap(this.a, 1) == 0L ? 0 : -1));
                int i3 = (nativeRequestTimeGap(this.a, 2) > 0L ? 1 : (nativeRequestTimeGap(this.a, 2) == 0L ? 0 : -1));
                int i4 = (nativeRequestTimeGap(this.a, 3) > 0L ? 1 : (nativeRequestTimeGap(this.a, 3) == 0L ? 0 : -1));
                int i5 = (nativeRequestTimeGap(this.a, 4) > 0L ? 1 : (nativeRequestTimeGap(this.a, 4) == 0L ? 0 : -1));
                int i6 = (nativeRequestTimeGap(this.a, 5) > 0L ? 1 : (nativeRequestTimeGap(this.a, 5) == 0L ? 0 : -1));
                RequestTimeInfo nativeGetRequestTimeInfo = nativeGetRequestTimeInfo(this.a);
                this.l = nativeGetRequestTimeInfo;
                if (nativeGetRequestTimeInfo == null) {
                    this.l = new RequestTimeInfo();
                }
                if (this.e != null) {
                    this.e.d();
                }
                nativeDestroy(this.a, z);
                if (this.z != null) {
                    this.g.x(this);
                }
                this.g.s();
                this.a = 0L;
                if (this.F != null) {
                    this.F.run();
                }
            }
        }
    }

    public final void D(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, exc) == null) {
            UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
            dz9.c("ChromiumNetwork", "Exception in CalledByNative method", exc);
            synchronized (this.f) {
                if (C()) {
                    return;
                }
                A(false);
                try {
                    this.k.b(this, this.D, urlRequestException);
                } catch (Exception e2) {
                    dz9.c("ChromiumNetwork", "Exception notifying of failed request", e2);
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void read(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, byteBuffer) == null) {
            hz9.b(byteBuffer);
            hz9.a(byteBuffer);
            synchronized (this.f) {
                if (this.d) {
                    this.d = false;
                    if (C()) {
                        return;
                    }
                    if (nativeReadData(this.a, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                        return;
                    }
                    this.d = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
                throw new IllegalStateException("Unexpected read attempt.");
            }
        }
    }

    public final UrlResponseInfo G(int i2, String str, String[] strArr, boolean z, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), str, strArr, Boolean.valueOf(z), str2, str3})) == null) {
            HeadersList headersList = new HeadersList(null);
            for (int i3 = 0; i3 < strArr.length; i3 += 2) {
                headersList.add(new AbstractMap.SimpleImmutableEntry(strArr[i3], strArr[i3 + 1]));
            }
            return new UrlResponseInfo(new ArrayList(this.i), i2, str, headersList, z, str2, str3);
        }
        return (UrlResponseInfo) invokeCommon.objValue;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this.f) {
                dz9.h("ChromiumNetwork", "****** Request cancel, url is: %s", this.m);
                if (!C() && this.b) {
                    A(true);
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this.f) {
                if (this.c) {
                    this.c = false;
                    if (C()) {
                        return;
                    }
                    nativeFollowDeferredRedirect(this.a);
                    return;
                }
                throw new IllegalStateException("No redirect to follow.");
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            synchronized (this.f) {
                dz9.h("ChromiumNetwork", "****** Request start, url is: %s", this.m);
                y();
                try {
                    this.a = nativeCreateRequestAdapter(this.g.q(), this.m, this.n, this.q, this.r, this.s);
                    this.g.t();
                    if (this.o != null && !nativeSetHttpMethod(this.a, this.o)) {
                        throw new IllegalArgumentException("Invalid http method " + this.o);
                    }
                    if (this.z != null) {
                        this.g.m(this);
                    }
                    if (this.t) {
                        nativeDisableResponseAutoUngzip(this.a);
                    }
                    if (this.u) {
                        nativeEnableBrotliByRequest(this.a);
                    }
                    if (this.v > 0) {
                        nativeSetTimeout(this.a, this.v);
                    }
                    if (this.w > 0) {
                        nativeSetTCPConnectTimeout(this.a, this.w);
                    }
                    if (this.x > 0) {
                        nativeSetResponseHeaderRecvTimeout(this.a, this.x);
                    }
                    if (this.y > 0) {
                        nativeSetResponseBodyReadTimeout(this.a, this.y);
                    }
                    if (!TextUtils.isEmpty(this.A)) {
                        nativeSetDestinationAddress(this.a, this.A);
                    }
                    if (!TextUtils.isEmpty(this.B)) {
                        nativeSetRequestTag(this.a, this.B);
                    }
                    Iterator<Map.Entry<String, String>> it = this.p.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        Map.Entry<String, String> next = it.next();
                        if (next.getKey().equalsIgnoreCase("Content-Type") && !next.getValue().isEmpty()) {
                            z = true;
                        }
                        if (!nativeAddRequestHeader(this.a, next.getKey(), next.getValue())) {
                            throw new IllegalArgumentException("Invalid header " + next.getKey() + "=" + next.getValue());
                        }
                    }
                    if (this.C != null) {
                        if (z) {
                            this.b = true;
                            this.C.q(new a(this));
                            return;
                        }
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                    this.b = true;
                    H();
                } catch (RuntimeException e2) {
                    A(false);
                    throw e2;
                }
            }
        }
    }
}
