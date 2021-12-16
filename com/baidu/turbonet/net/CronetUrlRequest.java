package com.baidu.turbonet.net;

import android.os.SystemClock;
import android.text.TextUtils;
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
/* loaded from: classes12.dex */
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

    /* renamed from: b  reason: collision with root package name */
    public boolean f51884b;
    @GuardedBy("mUrlRequestAdapterLock")

    /* renamed from: c  reason: collision with root package name */
    public boolean f51885c;
    @GuardedBy("mUrlRequestAdapterLock")

    /* renamed from: d  reason: collision with root package name */
    public boolean f51886d;
    @Nullable
    @GuardedBy("mUrlRequestAdapterLock")

    /* renamed from: e  reason: collision with root package name */
    public final i f51887e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f51888f;

    /* renamed from: g  reason: collision with root package name */
    public final CronetUrlRequestContext f51889g;

    /* renamed from: h  reason: collision with root package name */
    public final Executor f51890h;

    /* renamed from: i  reason: collision with root package name */
    public final List<String> f51891i;

    /* renamed from: j  reason: collision with root package name */
    public long f51892j;

    /* renamed from: k  reason: collision with root package name */
    public final UrlRequest.Callback f51893k;
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

    /* loaded from: classes12.dex */
    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public HeadersList() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ HeadersList(a aVar) {
            this();
        }
    }

    /* loaded from: classes12.dex */
    public static class SpendTimeType {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public SpendTimeType() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequest f51894e;

        public a(CronetUrlRequest cronetUrlRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51894e = cronetUrlRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51894e.C.o();
                synchronized (this.f51894e.f51888f) {
                    if (this.f51894e.C()) {
                        return;
                    }
                    this.f51894e.C.k(this.f51894e.a);
                    this.f51894e.H();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlRequestException f51895e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequest f51896f;

        public b(CronetUrlRequest cronetUrlRequest, UrlRequestException urlRequestException) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest, urlRequestException};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51896f = cronetUrlRequest;
            this.f51895e = urlRequestException;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f51896f.f51888f) {
                    if (this.f51896f.C()) {
                        return;
                    }
                    this.f51896f.A(false);
                    try {
                        this.f51896f.f51893k.b(this.f51896f, this.f51896f.D, this.f51895e);
                    } catch (Exception e2) {
                        c.a.t0.a.a.c("ChromiumNetwork", "Exception in onError method", e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlResponseInfo f51897e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f51898f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequest f51899g;

        public c(CronetUrlRequest cronetUrlRequest, UrlResponseInfo urlResponseInfo, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest, urlResponseInfo, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51899g = cronetUrlRequest;
            this.f51897e = urlResponseInfo;
            this.f51898f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f51899g.f51888f) {
                    if (this.f51899g.C()) {
                        return;
                    }
                    this.f51899g.f51885c = true;
                    try {
                        this.f51899g.f51893k.d(this.f51899g, this.f51897e, this.f51898f);
                    } catch (Exception e2) {
                        this.f51899g.D(e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequest f51900e;

        public d(CronetUrlRequest cronetUrlRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51900e = cronetUrlRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f51900e.f51888f) {
                    if (this.f51900e.C()) {
                        return;
                    }
                    if (this.f51900e.f51887e != null) {
                        this.f51900e.f51887e.f();
                    }
                    this.f51900e.f51886d = true;
                    try {
                        this.f51900e.f51893k.e(this.f51900e, this.f51900e.D);
                    } catch (Exception e2) {
                        this.f51900e.D(e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequest f51901e;

        public e(CronetUrlRequest cronetUrlRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51901e = cronetUrlRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f51901e.f51888f) {
                    if (this.f51901e.C()) {
                        return;
                    }
                    this.f51901e.A(false);
                    try {
                        this.f51901e.f51893k.f(this.f51901e, this.f51901e.D);
                    } catch (Exception e2) {
                        c.a.t0.a.a.c("ChromiumNetwork", "Exception in onComplete method", e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequest f51902e;

        public f(CronetUrlRequest cronetUrlRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51902e = cronetUrlRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.a.t0.a.a.c("ChromiumNetwork", "****** onCanceled, url is: %s", this.f51902e.D.h());
                    this.f51902e.f51893k.a(this.f51902e, this.f51902e.D);
                } catch (Exception e2) {
                    c.a.t0.a.a.c("ChromiumNetwork", "Exception in onCanceled method", e2);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlRequest.StatusListener f51903e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f51904f;

        public g(CronetUrlRequest cronetUrlRequest, UrlRequest.StatusListener statusListener, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest, statusListener, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51903e = statusListener;
            this.f51904f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51903e.a(UrlRequest.Status.a(this.f51904f));
            }
        }
    }

    /* loaded from: classes12.dex */
    public final class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public ByteBuffer f51905e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequest f51906f;

        public h(CronetUrlRequest cronetUrlRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51906f = cronetUrlRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ByteBuffer byteBuffer = this.f51905e;
                this.f51905e = null;
                try {
                    synchronized (this.f51906f.f51888f) {
                        if (this.f51906f.C()) {
                            return;
                        }
                        this.f51906f.f51886d = true;
                        this.f51906f.f51893k.c(this.f51906f, this.f51906f.D, byteBuffer);
                    }
                } catch (Exception e2) {
                    this.f51906f.D(e2);
                }
            }
        }

        public /* synthetic */ h(CronetUrlRequest cronetUrlRequest, a aVar) {
            this(cronetUrlRequest);
        }
    }

    /* loaded from: classes12.dex */
    public final class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public Long a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public Long f51907b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public Long f51908c;

        public i(CronetUrlRequest cronetUrlRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a != null && this.f51908c == null) {
                this.f51908c = Long.valueOf(SystemClock.elapsedRealtime() - this.a.longValue());
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
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a != null && this.f51907b == null) {
                this.f51907b = Long.valueOf(SystemClock.elapsedRealtime() - this.a.longValue());
            }
        }

        public /* synthetic */ i(CronetUrlRequest cronetUrlRequest, a aVar) {
            this(cronetUrlRequest);
        }
    }

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

    public CronetUrlRequest(CronetUrlRequestContext cronetUrlRequestContext, String str, int i2, UrlRequest.Callback callback, Executor executor, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4) {
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
        this.f51884b = false;
        this.f51885c = false;
        this.f51886d = false;
        this.f51888f = new Object();
        this.f51891i = new ArrayList();
        this.p = new HeadersList(null);
        if (str == null) {
            throw new NullPointerException("URL is required");
        }
        if (callback == null) {
            throw new NullPointerException("Listener is required");
        }
        if (executor == null) {
            throw new NullPointerException("Executor is required");
        }
        if (collection != null) {
            this.f51889g = cronetUrlRequestContext;
            this.m = str;
            this.f51891i.add(str);
            this.n = z(i2);
            this.f51893k = callback;
            this.f51890h = executor;
            this.f51887e = z ? new i(this, null) : null;
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
            this.D = new UrlResponseInfo(new ArrayList(this.f51891i), 0, "", new HeadersList(null), false, "", "");
            return;
        }
        throw new NullPointerException("requestAnnotations is required");
    }

    @CalledByNative
    public static RequestTimeInfo createObject(long j2, long j3, long j4, long j5, long j6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)})) == null) ? new RequestTimeInfo(j2, j3, j4, j5, j6) : (RequestTimeInfo) invokeCommon.objValue;
    }

    @NativeClassQualifiedName
    private native boolean nativeAddRequestHeader(long j2, String str, String str2);

    private native long nativeCreateRequestAdapter(long j2, String str, int i2, boolean z, boolean z2, boolean z3);

    @NativeClassQualifiedName
    private native void nativeDestroy(long j2, boolean z);

    @NativeClassQualifiedName
    private native void nativeDisableResponseAutoUngzip(long j2);

    @NativeClassQualifiedName
    private native void nativeEnableBrotliByRequest(long j2);

    @NativeClassQualifiedName
    private native void nativeFollowDeferredRedirect(long j2);

    @NativeClassQualifiedName
    private native String nativeGetConnectionAttempts(long j2, boolean z);

    @NativeClassQualifiedName
    private native String nativeGetDNSErrorCode(long j2);

    @NativeClassQualifiedName
    private native String nativeGetDNSNameServers(long j2);

    @NativeClassQualifiedName
    private native String nativeGetDNSResults(long j2);

    @NativeClassQualifiedName
    private native String nativeGetRemoteEndpoint(long j2);

    @NativeClassQualifiedName
    private native RequestTimeInfo nativeGetRequestTimeInfo(long j2);

    @NativeClassQualifiedName
    private native void nativeGetStatus(long j2, UrlRequest.StatusListener statusListener);

    @NativeClassQualifiedName
    private native String nativeGetSuperPipeInfo(long j2);

    @NativeClassQualifiedName
    private native boolean nativeReadData(long j2, ByteBuffer byteBuffer, int i2, int i3);

    @NativeClassQualifiedName
    private native long nativeRequestTimeGap(long j2, int i2);

    @NativeClassQualifiedName
    private native void nativeSetDestinationAddress(long j2, String str);

    @NativeClassQualifiedName
    private native boolean nativeSetHttpMethod(long j2, String str);

    @NativeClassQualifiedName
    private native void nativeSetRequestTag(long j2, String str);

    @NativeClassQualifiedName
    private native void nativeSetResponseBodyReadTimeout(long j2, int i2);

    @NativeClassQualifiedName
    private native void nativeSetResponseHeaderRecvTimeout(long j2, int i2);

    @NativeClassQualifiedName
    private native void nativeSetTCPConnectTimeout(long j2, int i2);

    @NativeClassQualifiedName
    private native void nativeSetTimeout(long j2, int i2);

    @NativeClassQualifiedName
    private native void nativeStart(long j2);

    @NativeClassQualifiedName
    private native int nativeSynGetStatus(long j2);

    @CalledByNative
    private void onCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            F(new f(this));
        }
    }

    @CalledByNative
    private void onError(int i2, int i3, int i4, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65568, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(j2)}) == null) {
            UrlResponseInfo urlResponseInfo = this.D;
            if (urlResponseInfo != null) {
                urlResponseInfo.j(this.f51892j + j2);
            }
            B(new UrlRequestException("Exception in CronetUrlRequest: " + str, i2, i3));
        }
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i2, int i3, int i4, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65569, this, new Object[]{byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)}) == null) {
            this.D.j(this.f51892j + j2);
            if (byteBuffer.position() == i3 && byteBuffer.limit() == i4) {
                if (this.E == null) {
                    this.E = new h(this, null);
                }
                byteBuffer.position(i3 + i2);
                h hVar = this.E;
                hVar.f51905e = byteBuffer;
                F(hVar);
                return;
            }
            B(new UrlRequestException("ByteBuffer modified externally during read", null));
        }
    }

    @CalledByNative
    private void onRedirectReceived(String str, int i2, String str2, String[] strArr, boolean z, String str3, String str4, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65570, this, new Object[]{str, Integer.valueOf(i2), str2, strArr, Boolean.valueOf(z), str3, str4, Long.valueOf(j2)}) == null) {
            UrlResponseInfo G = G(i2, str2, strArr, z, str3, str4);
            long j3 = this.f51892j + j2;
            this.f51892j = j3;
            G.j(j3);
            this.f51891i.add(str);
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

    @CalledByNative
    private void onStatus(UrlRequest.StatusListener statusListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65572, this, statusListener, i2) == null) {
            F(new g(this, statusListener, i2));
        }
    }

    @CalledByNative
    private void onSucceeded(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65573, this, j2) == null) {
            this.D.j(this.f51892j + j2);
            F(new e(this));
        }
    }

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

    public final void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            synchronized (this.f51888f) {
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
                if (this.f51887e != null) {
                    this.f51887e.d();
                }
                nativeDestroy(this.a, z);
                if (this.z != null) {
                    this.f51889g.x(this);
                }
                this.f51889g.s();
                this.a = 0L;
                if (this.F != null) {
                    this.F.run();
                }
            }
        }
    }

    public final void B(UrlRequestException urlRequestException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, urlRequestException) == null) {
            F(new b(this, urlRequestException));
        }
    }

    @GuardedBy("mUrlRequestAdapterLock")
    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f51884b && this.a == 0 : invokeV.booleanValue;
    }

    public final void D(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, exc) == null) {
            UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
            c.a.t0.a.a.c("ChromiumNetwork", "Exception in CalledByNative method", exc);
            synchronized (this.f51888f) {
                if (C()) {
                    return;
                }
                A(false);
                try {
                    this.f51893k.b(this, this.D, urlRequestException);
                } catch (Exception e2) {
                    c.a.t0.a.a.c("ChromiumNetwork", "Exception notifying of failed request", e2);
                }
            }
        }
    }

    public void E(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
            UrlRequestException urlRequestException = new UrlRequestException("Exception received from UploadDataProvider", th);
            c.a.t0.a.a.c("ChromiumNetwork", "Exception in upload method", th);
            B(urlRequestException);
        }
    }

    public final void F(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, runnable) == null) {
            try {
                this.f51890h.execute(runnable);
            } catch (RejectedExecutionException e2) {
                c.a.t0.a.a.c("ChromiumNetwork", "Exception posting task to executor", e2);
                A(false);
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
            return new UrlResponseInfo(new ArrayList(this.f51891i), i2, str, headersList, z, str2, str3);
        }
        return (UrlResponseInfo) invokeCommon.objValue;
    }

    @GuardedBy("mUrlRequestAdapterLock")
    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            i iVar = this.f51887e;
            if (iVar != null) {
                iVar.e();
            }
            nativeStart(this.a);
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
    public void addHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            y();
            if (str == null) {
                throw new NullPointerException("Invalid header name.");
            }
            if (str2 != null) {
                this.p.add(new AbstractMap.SimpleImmutableEntry(str, str2));
                return;
            }
            throw new NullPointerException("Invalid header value.");
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
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this.f51888f) {
                c.a.t0.a.a.h("ChromiumNetwork", "****** Request cancel, url is: %s", this.m);
                if (!C() && this.f51884b) {
                    A(true);
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this.f51888f) {
                if (this.f51885c) {
                    this.f51885c = false;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.z : invokeV.objValue;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            y();
            this.t = true;
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

    @Override // com.baidu.turbonet.net.UrlRequest
    public void read(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, byteBuffer) == null) {
            c.a.t0.b.b.b(byteBuffer);
            c.a.t0.b.b.a(byteBuffer);
            synchronized (this.f51888f) {
                if (this.f51886d) {
                    this.f51886d = false;
                    if (C()) {
                        return;
                    }
                    if (nativeReadData(this.a, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                        return;
                    }
                    this.f51886d = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
                throw new IllegalStateException("Unexpected read attempt.");
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            synchronized (this.f51888f) {
                c.a.t0.a.a.h("ChromiumNetwork", "****** Request start, url is: %s", this.m);
                y();
                try {
                    this.a = nativeCreateRequestAdapter(this.f51889g.q(), this.m, this.n, this.q, this.r, this.s);
                    this.f51889g.t();
                    if (this.o != null && !nativeSetHttpMethod(this.a, this.o)) {
                        throw new IllegalArgumentException("Invalid http method " + this.o);
                    }
                    if (this.z != null) {
                        this.f51889g.m(this);
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
                    if (this.C == null) {
                        this.f51884b = true;
                        H();
                    } else if (z) {
                        this.f51884b = true;
                        this.C.q(new a(this));
                    } else {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    }
                } catch (RuntimeException e2) {
                    A(false);
                    throw e2;
                }
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this.f51888f) {
                if (this.f51884b || C()) {
                    throw new IllegalStateException("Request is already started.");
                }
            }
        }
    }
}
