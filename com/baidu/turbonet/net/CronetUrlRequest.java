package com.baidu.turbonet.net;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
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
/* loaded from: classes5.dex */
public final class CronetUrlRequest implements UrlRequest {
    public String A;
    public String B;
    public CronetUploadDataStream C;
    public UrlResponseInfo D;
    public h E;
    public Runnable F;
    @GuardedBy("mUrlRequestAdapterLock")

    /* renamed from: a  reason: collision with root package name */
    public long f22708a;
    @Nullable
    @GuardedBy("mUrlRequestAdapterLock")

    /* renamed from: e  reason: collision with root package name */
    public final i f22712e;

    /* renamed from: g  reason: collision with root package name */
    public final CronetUrlRequestContext f22714g;

    /* renamed from: h  reason: collision with root package name */
    public final Executor f22715h;
    public long j;
    public final UrlRequest.Callback k;
    public RequestTimeInfo l;
    public final String m;
    public final int n;
    public String o;
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
    @GuardedBy("mUrlRequestAdapterLock")

    /* renamed from: b  reason: collision with root package name */
    public boolean f22709b = false;
    @GuardedBy("mUrlRequestAdapterLock")

    /* renamed from: c  reason: collision with root package name */
    public boolean f22710c = false;
    @GuardedBy("mUrlRequestAdapterLock")

    /* renamed from: d  reason: collision with root package name */
    public boolean f22711d = false;

    /* renamed from: f  reason: collision with root package name */
    public final Object f22713f = new Object();
    public final List<String> i = new ArrayList();
    public final HeadersList p = new HeadersList(null);

    /* loaded from: classes5.dex */
    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        public HeadersList() {
        }

        public /* synthetic */ HeadersList(a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static class SpendTimeType {
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetUrlRequest.this.C.o();
            synchronized (CronetUrlRequest.this.f22713f) {
                if (CronetUrlRequest.this.C()) {
                    return;
                }
                CronetUrlRequest.this.C.k(CronetUrlRequest.this.f22708a);
                CronetUrlRequest.this.H();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlRequestException f22717e;

        public b(UrlRequestException urlRequestException) {
            this.f22717e = urlRequestException;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUrlRequest.this.f22713f) {
                if (CronetUrlRequest.this.C()) {
                    return;
                }
                CronetUrlRequest.this.A(false);
                try {
                    CronetUrlRequest.this.k.b(CronetUrlRequest.this, CronetUrlRequest.this.D, this.f22717e);
                } catch (Exception e2) {
                    d.b.j0.a.a.c("ChromiumNetwork", "Exception in onError method", e2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlResponseInfo f22719e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f22720f;

        public c(UrlResponseInfo urlResponseInfo, String str) {
            this.f22719e = urlResponseInfo;
            this.f22720f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUrlRequest.this.f22713f) {
                if (CronetUrlRequest.this.C()) {
                    return;
                }
                CronetUrlRequest.this.f22710c = true;
                try {
                    CronetUrlRequest.this.k.d(CronetUrlRequest.this, this.f22719e, this.f22720f);
                } catch (Exception e2) {
                    CronetUrlRequest.this.D(e2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUrlRequest.this.f22713f) {
                if (CronetUrlRequest.this.C()) {
                    return;
                }
                if (CronetUrlRequest.this.f22712e != null) {
                    CronetUrlRequest.this.f22712e.f();
                }
                CronetUrlRequest.this.f22711d = true;
                try {
                    CronetUrlRequest.this.k.e(CronetUrlRequest.this, CronetUrlRequest.this.D);
                } catch (Exception e2) {
                    CronetUrlRequest.this.D(e2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUrlRequest.this.f22713f) {
                if (CronetUrlRequest.this.C()) {
                    return;
                }
                CronetUrlRequest.this.A(false);
                try {
                    CronetUrlRequest.this.k.f(CronetUrlRequest.this, CronetUrlRequest.this.D);
                } catch (Exception e2) {
                    d.b.j0.a.a.c("ChromiumNetwork", "Exception in onComplete method", e2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.b.j0.a.a.c("ChromiumNetwork", "****** onCanceled, url is: %s", CronetUrlRequest.this.D.h());
                CronetUrlRequest.this.k.a(CronetUrlRequest.this, CronetUrlRequest.this.D);
            } catch (Exception e2) {
                d.b.j0.a.a.c("ChromiumNetwork", "Exception in onCanceled method", e2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlRequest.StatusListener f22725e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f22726f;

        public g(CronetUrlRequest cronetUrlRequest, UrlRequest.StatusListener statusListener, int i) {
            this.f22725e = statusListener;
            this.f22726f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f22725e.a(UrlRequest.Status.a(this.f22726f));
        }
    }

    /* loaded from: classes5.dex */
    public final class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public ByteBuffer f22727e;

        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer byteBuffer = this.f22727e;
            this.f22727e = null;
            try {
                synchronized (CronetUrlRequest.this.f22713f) {
                    if (CronetUrlRequest.this.C()) {
                        return;
                    }
                    CronetUrlRequest.this.f22711d = true;
                    CronetUrlRequest.this.k.c(CronetUrlRequest.this, CronetUrlRequest.this.D, byteBuffer);
                }
            } catch (Exception e2) {
                CronetUrlRequest.this.D(e2);
            }
        }

        public /* synthetic */ h(CronetUrlRequest cronetUrlRequest, a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public final class i {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public Long f22729a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public Long f22730b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public Long f22731c;

        public i(CronetUrlRequest cronetUrlRequest) {
        }

        public final void d() {
            if (this.f22729a == null || this.f22731c != null) {
                return;
            }
            this.f22731c = Long.valueOf(SystemClock.elapsedRealtime() - this.f22729a.longValue());
        }

        public final void e() {
            if (this.f22729a == null) {
                this.f22729a = Long.valueOf(SystemClock.elapsedRealtime());
                return;
            }
            throw new IllegalStateException("onRequestStarted called repeatedly");
        }

        public final void f() {
            if (this.f22729a == null || this.f22730b != null) {
                return;
            }
            this.f22730b = Long.valueOf(SystemClock.elapsedRealtime() - this.f22729a.longValue());
        }

        public /* synthetic */ i(CronetUrlRequest cronetUrlRequest, a aVar) {
            this(cronetUrlRequest);
        }
    }

    public CronetUrlRequest(CronetUrlRequestContext cronetUrlRequestContext, String str, int i2, UrlRequest.Callback callback, Executor executor, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4) {
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
            this.f22714g = cronetUrlRequestContext;
            this.m = str;
            this.i.add(str);
            this.n = z(i2);
            this.k = callback;
            this.f22715h = executor;
            this.f22712e = z ? new i(this, null) : null;
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

    @CalledByNative
    public static RequestTimeInfo createObject(long j, long j2, long j3, long j4, long j5) {
        return new RequestTimeInfo(j, j2, j3, j4, j5);
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

    @CalledByNative
    private void onCanceled() {
        F(new f());
    }

    @CalledByNative
    private void onError(int i2, int i3, int i4, String str, long j) {
        UrlResponseInfo urlResponseInfo = this.D;
        if (urlResponseInfo != null) {
            urlResponseInfo.j(this.j + j);
        }
        B(new UrlRequestException("Exception in CronetUrlRequest: " + str, i2, i3));
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i2, int i3, int i4, long j) {
        this.D.j(this.j + j);
        if (byteBuffer.position() == i3 && byteBuffer.limit() == i4) {
            if (this.E == null) {
                this.E = new h(this, null);
            }
            byteBuffer.position(i3 + i2);
            h hVar = this.E;
            hVar.f22727e = byteBuffer;
            F(hVar);
            return;
        }
        B(new UrlRequestException("ByteBuffer modified externally during read", null));
    }

    @CalledByNative
    private void onRedirectReceived(String str, int i2, String str2, String[] strArr, boolean z, String str3, String str4, long j) {
        UrlResponseInfo G = G(i2, str2, strArr, z, str3, str4);
        long j2 = this.j + j;
        this.j = j2;
        G.j(j2);
        this.i.add(str);
        F(new c(G, str));
    }

    @CalledByNative
    private void onResponseStarted(int i2, String str, String[] strArr, boolean z, String str2, String str3) {
        this.D = G(i2, str, strArr, z, str2, str3);
        F(new d());
    }

    @CalledByNative
    private void onStatus(UrlRequest.StatusListener statusListener, int i2) {
        F(new g(this, statusListener, i2));
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.D.j(this.j + j);
        F(new e());
    }

    public static int z(int i2) {
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

    public final void A(boolean z) {
        synchronized (this.f22713f) {
            if (this.f22708a == 0) {
                return;
            }
            nativeGetDNSNameServers(this.f22708a).isEmpty();
            nativeGetDNSResults(this.f22708a).isEmpty();
            nativeGetDNSErrorCode(this.f22708a).isEmpty();
            nativeGetConnectionAttempts(this.f22708a, false).isEmpty();
            nativeGetConnectionAttempts(this.f22708a, true).isEmpty();
            nativeGetRemoteEndpoint(this.f22708a).isEmpty();
            nativeGetSuperPipeInfo(this.f22708a).isEmpty();
            int i2 = (nativeRequestTimeGap(this.f22708a, 1) > 0L ? 1 : (nativeRequestTimeGap(this.f22708a, 1) == 0L ? 0 : -1));
            int i3 = (nativeRequestTimeGap(this.f22708a, 2) > 0L ? 1 : (nativeRequestTimeGap(this.f22708a, 2) == 0L ? 0 : -1));
            int i4 = (nativeRequestTimeGap(this.f22708a, 3) > 0L ? 1 : (nativeRequestTimeGap(this.f22708a, 3) == 0L ? 0 : -1));
            int i5 = (nativeRequestTimeGap(this.f22708a, 4) > 0L ? 1 : (nativeRequestTimeGap(this.f22708a, 4) == 0L ? 0 : -1));
            int i6 = (nativeRequestTimeGap(this.f22708a, 5) > 0L ? 1 : (nativeRequestTimeGap(this.f22708a, 5) == 0L ? 0 : -1));
            RequestTimeInfo nativeGetRequestTimeInfo = nativeGetRequestTimeInfo(this.f22708a);
            this.l = nativeGetRequestTimeInfo;
            if (nativeGetRequestTimeInfo == null) {
                this.l = new RequestTimeInfo();
            }
            if (this.f22712e != null) {
                this.f22712e.d();
            }
            nativeDestroy(this.f22708a, z);
            if (this.z != null) {
                this.f22714g.x(this);
            }
            this.f22714g.s();
            this.f22708a = 0L;
            if (this.F != null) {
                this.F.run();
            }
        }
    }

    public final void B(UrlRequestException urlRequestException) {
        F(new b(urlRequestException));
    }

    @GuardedBy("mUrlRequestAdapterLock")
    public final boolean C() {
        return this.f22709b && this.f22708a == 0;
    }

    public final void D(Exception exc) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UrlRequest.Callback", exc);
        d.b.j0.a.a.c("ChromiumNetwork", "Exception in CalledByNative method", exc);
        synchronized (this.f22713f) {
            if (C()) {
                return;
            }
            A(false);
            try {
                this.k.b(this, this.D, urlRequestException);
            } catch (Exception e2) {
                d.b.j0.a.a.c("ChromiumNetwork", "Exception notifying of failed request", e2);
            }
        }
    }

    public void E(Throwable th) {
        UrlRequestException urlRequestException = new UrlRequestException("Exception received from UploadDataProvider", th);
        d.b.j0.a.a.c("ChromiumNetwork", "Exception in upload method", th);
        B(urlRequestException);
    }

    public final void F(Runnable runnable) {
        try {
            this.f22715h.execute(runnable);
        } catch (RejectedExecutionException e2) {
            d.b.j0.a.a.c("ChromiumNetwork", "Exception posting task to executor", e2);
            A(false);
        }
    }

    public final UrlResponseInfo G(int i2, String str, String[] strArr, boolean z, String str2, String str3) {
        HeadersList headersList = new HeadersList(null);
        for (int i3 = 0; i3 < strArr.length; i3 += 2) {
            headersList.add(new AbstractMap.SimpleImmutableEntry(strArr[i3], strArr[i3 + 1]));
        }
        return new UrlResponseInfo(new ArrayList(this.i), i2, str, headersList, z, str2, str3);
    }

    @GuardedBy("mUrlRequestAdapterLock")
    public final void H() {
        i iVar = this.f22712e;
        if (iVar != null) {
            iVar.e();
        }
        nativeStart(this.f22708a);
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a(String str) {
        y();
        this.B = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void addHeader(String str, String str2) {
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

    @Override // com.baidu.turbonet.net.UrlRequest
    public void b(int i2) {
        y();
        this.y = i2;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void c(int i2) {
        y();
        this.v = i2;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void cancel() {
        synchronized (this.f22713f) {
            d.b.j0.a.a.h("ChromiumNetwork", "****** Request cancel, url is: %s", this.m);
            if (!C() && this.f22709b) {
                A(true);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void d(String str) {
        y();
        this.A = str;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void e(int i2) {
        y();
        this.x = i2;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void f() {
        synchronized (this.f22713f) {
            if (this.f22710c) {
                this.f22710c = false;
                if (C()) {
                    return;
                }
                nativeFollowDeferredRedirect(this.f22708a);
                return;
            }
            throw new IllegalStateException("No redirect to follow.");
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void g(String str) {
        y();
        if (str != null) {
            this.o = str;
            return;
        }
        throw new NullPointerException("Method is required.");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public Object getTag() {
        return this.z;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void h(int i2) {
        y();
        this.w = i2;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void i(Object obj) {
        y();
        this.z = obj;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void j() {
        y();
        this.u = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void k() {
        y();
        this.t = true;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void l(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider != null) {
            if (this.o == null) {
                this.o = "POST";
            }
            this.C = new CronetUploadDataStream(uploadDataProvider, executor, this);
            return;
        }
        throw new NullPointerException("Invalid UploadDataProvider.");
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void read(ByteBuffer byteBuffer) {
        d.b.j0.b.b.b(byteBuffer);
        d.b.j0.b.b.a(byteBuffer);
        synchronized (this.f22713f) {
            if (this.f22711d) {
                this.f22711d = false;
                if (C()) {
                    return;
                }
                if (nativeReadData(this.f22708a, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    return;
                }
                this.f22711d = true;
                throw new IllegalArgumentException("Unable to call native read");
            }
            throw new IllegalStateException("Unexpected read attempt.");
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void start() {
        synchronized (this.f22713f) {
            d.b.j0.a.a.h("ChromiumNetwork", "****** Request start, url is: %s", this.m);
            y();
            try {
                this.f22708a = nativeCreateRequestAdapter(this.f22714g.q(), this.m, this.n, this.q, this.r, this.s);
                this.f22714g.t();
                if (this.o != null && !nativeSetHttpMethod(this.f22708a, this.o)) {
                    throw new IllegalArgumentException("Invalid http method " + this.o);
                }
                if (this.z != null) {
                    this.f22714g.m(this);
                }
                if (this.t) {
                    nativeDisableResponseAutoUngzip(this.f22708a);
                }
                if (this.u) {
                    nativeEnableBrotliByRequest(this.f22708a);
                }
                if (this.v > 0) {
                    nativeSetTimeout(this.f22708a, this.v);
                }
                if (this.w > 0) {
                    nativeSetTCPConnectTimeout(this.f22708a, this.w);
                }
                if (this.x > 0) {
                    nativeSetResponseHeaderRecvTimeout(this.f22708a, this.x);
                }
                if (this.y > 0) {
                    nativeSetResponseBodyReadTimeout(this.f22708a, this.y);
                }
                if (!TextUtils.isEmpty(this.A)) {
                    nativeSetDestinationAddress(this.f22708a, this.A);
                }
                if (!TextUtils.isEmpty(this.B)) {
                    nativeSetRequestTag(this.f22708a, this.B);
                }
                Iterator<Map.Entry<String, String>> it = this.p.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    if (next.getKey().equalsIgnoreCase("Content-Type") && !next.getValue().isEmpty()) {
                        z = true;
                    }
                    if (!nativeAddRequestHeader(this.f22708a, next.getKey(), next.getValue())) {
                        throw new IllegalArgumentException("Invalid header " + next.getKey() + "=" + next.getValue());
                    }
                }
                if (this.C == null) {
                    this.f22709b = true;
                    H();
                } else if (z) {
                    this.f22709b = true;
                    this.C.q(new a());
                } else {
                    throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                }
            } catch (RuntimeException e2) {
                A(false);
                throw e2;
            }
        }
    }

    public final void y() {
        synchronized (this.f22713f) {
            if (this.f22709b || C()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }
}
