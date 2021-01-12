package com.bytedance.sdk.adnet.core;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.core.p;
import com.bytedance.sdk.adnet.core.r;
import com.bytedance.sdk.adnet.e.b;
import com.bytedance.sdk.adnet.err.VAdError;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public abstract class Request<T> implements Comparable<Request<T>> {
    public static final int METHOD_DELETE = 3;
    public static final int METHOD_DEPRECATED_GET_OR_POST = -1;
    public static final int METHOD_GET = 0;
    public static final int METHOD_HEAD = 4;
    public static final int METHOD_OPTIONS = 5;
    public static final int METHOD_PATCH = 7;
    public static final int METHOD_POST = 1;
    public static final int METHOD_PUT = 2;
    public static final int METHOD_TRACE = 6;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: a  reason: collision with root package name */
    protected p.a<T> f6009a;

    /* renamed from: b  reason: collision with root package name */
    protected Handler f6010b;
    private final r.a c;
    private final int d;
    private String e;
    private String f;
    private final int g;
    private final Object h;
    private Integer i;
    private o j;
    private boolean k;
    @GuardedBy("mLock")
    private boolean l;
    @GuardedBy("mLock")
    private boolean m;
    private boolean n;
    private com.bytedance.sdk.adnet.e.e o;
    private b.a p;
    private Object q;
    private long r;
    private long s;
    private boolean t;
    private String u;
    private Map<String, Object> v;
    @GuardedBy("mLock")
    private a w;

    /* loaded from: classes4.dex */
    interface a {
        void a(Request<?> request, p<?> pVar);

        void b(Request<?> request);
    }

    /* loaded from: classes4.dex */
    public enum b {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract p<T> a(l lVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(p<T> pVar);

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((Request) ((Request) obj));
    }

    @Deprecated
    public Request(String str, p.a aVar) {
        this(-1, str, aVar);
    }

    public Request(int i, String str, @Nullable p.a aVar) {
        this.c = r.a.f6048a ? new r.a() : null;
        this.f = "VADNetAgent/0";
        this.h = new Object();
        this.k = true;
        this.l = false;
        this.m = false;
        this.n = false;
        this.p = null;
        this.r = 0L;
        this.s = 0L;
        this.t = true;
        this.f6010b = new Handler(Looper.getMainLooper());
        this.d = i;
        this.e = str;
        this.f6009a = aVar;
        setRetryPolicy(new g());
        this.g = b(str);
    }

    public Request addExtra(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (this.v == null) {
                this.v = new HashMap();
            }
            this.v.put(str, obj);
        }
        return this;
    }

    public Map<String, Object> getExtra() {
        return this.v;
    }

    public long getStartTime() {
        return this.r;
    }

    public void setStartTime() {
        this.r = SystemClock.elapsedRealtime();
    }

    public long getNetDuration() {
        return this.s;
    }

    public void setNetDuration(long j) {
        this.s = j;
    }

    public boolean isResponseOnMain() {
        return this.t;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setResponseOnMain(boolean z) {
        this.t = z;
        return this;
    }

    public int getMethod() {
        return this.d;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setTag(Object obj) {
        this.q = obj;
        return this;
    }

    public Object getTag() {
        return this.q;
    }

    @Nullable
    public p.a getBaseListener() {
        p.a<T> aVar;
        synchronized (this.h) {
            aVar = this.f6009a;
        }
        return aVar;
    }

    public int getTrafficStatsTag() {
        return this.g;
    }

    private static int b(String str) {
        Uri parse;
        String host;
        try {
            if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && (host = parse.getHost()) != null) {
                return host.hashCode();
            }
        } catch (Throwable th) {
        }
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRetryPolicy(com.bytedance.sdk.adnet.e.e eVar) {
        this.o = eVar;
        return this;
    }

    public void addMarker(String str) {
        if (r.a.f6048a) {
            this.c.a(str, Thread.currentThread().getId());
        }
    }

    public String getUserAgent() {
        return this.f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setUserAgent(String str) {
        this.f = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final String str) {
        if (this.j != null) {
            this.j.k(this);
        }
        if (r.a.f6048a) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.f6010b.post(new Runnable() { // from class: com.bytedance.sdk.adnet.core.Request.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Request.this.c.a(str, id);
                        Request.this.c.a(Request.this.toString());
                    }
                });
                return;
            }
            this.c.a(str, id);
            this.c.a(toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (this.j != null) {
            this.j.a(this, i);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRequestQueue(o oVar) {
        this.j = oVar;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setSequence(int i) {
        this.i = Integer.valueOf(i);
        return this;
    }

    public final o getRequestQueue() {
        return this.j;
    }

    public final int getSequence() {
        if (this.i == null) {
            throw new IllegalStateException("getSequence called before setSequence");
        }
        return this.i.intValue();
    }

    public String getUrl() {
        return this.e;
    }

    public void setUrl(String str) {
        this.e = str;
    }

    public String getCacheKey() {
        String url = getUrl();
        int method = getMethod();
        return (method == 0 || method == -1) ? url : Integer.toString(method) + '-' + url;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setCacheEntry(b.a aVar) {
        this.p = aVar;
        return this;
    }

    public b.a getCacheEntry() {
        return this.p;
    }

    @CallSuper
    public void cancel() {
        synchronized (this.h) {
            this.l = true;
            this.f6009a = null;
        }
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.h) {
            z = this.l;
        }
        return z;
    }

    public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
        return Collections.emptyMap();
    }

    @Deprecated
    protected Map<String, String> a() throws com.bytedance.sdk.adnet.err.a {
        return c();
    }

    @Deprecated
    protected String b() {
        return d();
    }

    @Deprecated
    public byte[] getPostBody() throws com.bytedance.sdk.adnet.err.a {
        Map<String, String> a2 = a();
        if (a2 == null || a2.size() <= 0) {
            return null;
        }
        return a(a2, b());
    }

    protected Map<String, String> c() throws com.bytedance.sdk.adnet.err.a {
        return null;
    }

    protected String d() {
        return "UTF-8";
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + d();
    }

    public byte[] getBody() throws com.bytedance.sdk.adnet.err.a {
        Map<String, String> c = c();
        if (c == null || c.size() <= 0) {
            return null;
        }
        return a(c, d());
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", entry.getKey(), entry.getValue()));
                }
                sb.append(URLEncoder.encode(entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldCache(boolean z) {
        this.k = z;
        return this;
    }

    public final boolean shouldCache() {
        return this.k;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldRetryServerErrors(boolean z) {
        this.n = z;
        return this;
    }

    public final boolean shouldRetryServerErrors() {
        return this.n;
    }

    public b getPriority() {
        return b.NORMAL;
    }

    public final int getTimeoutMs() {
        return getRetryPolicy().a();
    }

    public com.bytedance.sdk.adnet.e.e getRetryPolicy() {
        return this.o;
    }

    public void markDelivered() {
        synchronized (this.h) {
            this.m = true;
        }
    }

    public boolean hasHadResponseDelivered() {
        boolean z;
        synchronized (this.h) {
            z = this.m;
        }
        return z;
    }

    public void build(o oVar) {
        if (oVar != null) {
            oVar.j(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VAdError a(VAdError vAdError) {
        return vAdError;
    }

    protected void a(long j, long j2) {
    }

    public void deliverError(p<T> pVar) {
        p.a<T> aVar;
        synchronized (this.h) {
            aVar = this.f6009a;
        }
        if (aVar != null) {
            aVar.b(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        synchronized (this.h) {
            this.w = aVar;
        }
    }

    public String getIpAddrStr() {
        return this.u;
    }

    public void setIpAddrStr(String str) {
        this.u = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(p<?> pVar) {
        a aVar;
        synchronized (this.h) {
            aVar = this.w;
        }
        if (aVar != null) {
            aVar.a(this, pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        a aVar;
        synchronized (this.h) {
            aVar = this.w;
        }
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public int compareTo(Request<T> request) {
        b priority = getPriority();
        b priority2 = request.getPriority();
        return priority == priority2 ? this.i.intValue() - request.i.intValue() : priority2.ordinal() - priority.ordinal();
    }

    public String toString() {
        return (isCanceled() ? "[X] " : "[ ] ") + getUrl() + " " + ("0x" + Integer.toHexString(getTrafficStatsTag())) + " " + getPriority() + " " + this.i;
    }
}
