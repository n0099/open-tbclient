package com.bytedance.sdk.adnet.core;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.err.VAdError;
import d.b.c.b.d.g;
import d.b.c.b.d.k;
import d.b.c.b.d.n;
import d.b.c.b.d.o;
import d.b.c.b.d.q;
import d.b.c.b.f.b;
import d.b.c.b.f.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;
/* loaded from: classes6.dex */
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
    public o.a<T> f26999a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f27000b;

    /* renamed from: c  reason: collision with root package name */
    public final q.a f27001c;

    /* renamed from: d  reason: collision with root package name */
    public final int f27002d;

    /* renamed from: e  reason: collision with root package name */
    public String f27003e;

    /* renamed from: f  reason: collision with root package name */
    public String f27004f;

    /* renamed from: g  reason: collision with root package name */
    public final int f27005g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f27006h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f27007i;
    public n j;
    public boolean k;
    @GuardedBy("mLock")
    public boolean l;
    @GuardedBy("mLock")
    public boolean m;
    public boolean n;
    public e o;
    public b.a p;
    public Object q;
    public long r;
    public long s;
    public boolean t;
    public String u;
    public Map<String, Object> v;
    @GuardedBy("mLock")
    public c w;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f27008e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f27009f;

        public a(String str, long j) {
            this.f27008e = str;
            this.f27009f = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Request.this.f27001c.c(this.f27008e, this.f27009f);
            Request.this.f27001c.b(Request.this.toString());
        }
    }

    /* loaded from: classes6.dex */
    public enum b {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(Request<?> request);

        void b(Request<?> request, o<?> oVar);
    }

    @Deprecated
    public Request(String str, o.a aVar) {
        this(-1, str, aVar);
    }

    public static int b(String str) {
        Uri parse;
        String host;
        try {
            if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
                return 0;
            }
            return host.hashCode();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public VAdError a(VAdError vAdError) {
        return vAdError;
    }

    public abstract o<T> a(k kVar);

    public void a(long j, long j2) {
    }

    public abstract void a(o<T> oVar);

    public Request addExtra(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (this.v == null) {
                this.v = new HashMap();
            }
            this.v.put(str, obj);
        }
        return this;
    }

    public void addMarker(String str) {
        if (q.a.f69550c) {
            this.f27001c.c(str, Thread.currentThread().getId());
        }
    }

    public void build(n nVar) {
        if (nVar != null) {
            nVar.a(this);
        }
    }

    public Map<String, String> c() throws com.bytedance.sdk.adnet.err.a {
        return null;
    }

    @CallSuper
    public void cancel() {
        synchronized (this.f27006h) {
            this.l = true;
            this.f26999a = null;
        }
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((Request) ((Request) obj));
    }

    public String d() {
        return "UTF-8";
    }

    public void deliverError(o<T> oVar) {
        o.a<T> aVar;
        synchronized (this.f27006h) {
            aVar = this.f26999a;
        }
        if (aVar != null) {
            aVar.b(oVar);
        }
    }

    public void e() {
        c cVar;
        synchronized (this.f27006h) {
            cVar = this.w;
        }
        if (cVar != null) {
            cVar.a(this);
        }
    }

    @Nullable
    public o.a getBaseListener() {
        o.a<T> aVar;
        synchronized (this.f27006h) {
            aVar = this.f26999a;
        }
        return aVar;
    }

    public byte[] getBody() throws com.bytedance.sdk.adnet.err.a {
        Map<String, String> c2 = c();
        if (c2 == null || c2.size() <= 0) {
            return null;
        }
        return a(c2, d());
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + d();
    }

    public b.a getCacheEntry() {
        return this.p;
    }

    public String getCacheKey() {
        String url = getUrl();
        int method = getMethod();
        if (method == 0 || method == -1) {
            return url;
        }
        return Integer.toString(method) + '-' + url;
    }

    public Map<String, Object> getExtra() {
        return this.v;
    }

    public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
        return Collections.emptyMap();
    }

    public String getIpAddrStr() {
        return this.u;
    }

    public int getMethod() {
        return this.f27002d;
    }

    public long getNetDuration() {
        return this.s;
    }

    @Deprecated
    public byte[] getPostBody() throws com.bytedance.sdk.adnet.err.a {
        Map<String, String> a2 = a();
        if (a2 == null || a2.size() <= 0) {
            return null;
        }
        return a(a2, b());
    }

    public b getPriority() {
        return b.NORMAL;
    }

    public final n getRequestQueue() {
        return this.j;
    }

    public e getRetryPolicy() {
        return this.o;
    }

    public final int getSequence() {
        Integer num = this.f27007i;
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public long getStartTime() {
        return this.r;
    }

    public Object getTag() {
        return this.q;
    }

    public final int getTimeoutMs() {
        return getRetryPolicy().a();
    }

    public int getTrafficStatsTag() {
        return this.f27005g;
    }

    public String getUrl() {
        return this.f27003e;
    }

    public String getUserAgent() {
        return this.f27004f;
    }

    public boolean hasHadResponseDelivered() {
        boolean z;
        synchronized (this.f27006h) {
            z = this.m;
        }
        return z;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.f27006h) {
            z = this.l;
        }
        return z;
    }

    public boolean isResponseOnMain() {
        return this.t;
    }

    public void markDelivered() {
        synchronized (this.f27006h) {
            this.m = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setCacheEntry(b.a aVar) {
        this.p = aVar;
        return this;
    }

    public void setIpAddrStr(String str) {
        this.u = str;
    }

    public void setNetDuration(long j) {
        this.s = j;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRequestQueue(n nVar) {
        this.j = nVar;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setResponseOnMain(boolean z) {
        this.t = z;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRetryPolicy(e eVar) {
        this.o = eVar;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setSequence(int i2) {
        this.f27007i = Integer.valueOf(i2);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldCache(boolean z) {
        this.k = z;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldRetryServerErrors(boolean z) {
        this.n = z;
        return this;
    }

    public void setStartTime() {
        this.r = SystemClock.elapsedRealtime();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setTag(Object obj) {
        this.q = obj;
        return this;
    }

    public void setUrl(String str) {
        this.f27003e = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setUserAgent(String str) {
        this.f27004f = str;
        return this;
    }

    public final boolean shouldCache() {
        return this.k;
    }

    public final boolean shouldRetryServerErrors() {
        return this.n;
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(getTrafficStatsTag());
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "[X] " : "[ ] ");
        sb.append(getUrl());
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(getPriority());
        sb.append(" ");
        sb.append(this.f27007i);
        return sb.toString();
    }

    public Request(int i2, String str, @Nullable o.a aVar) {
        this.f27001c = q.a.f69550c ? new q.a() : null;
        this.f27004f = "VADNetAgent/0";
        this.f27006h = new Object();
        this.k = true;
        this.l = false;
        this.m = false;
        this.n = false;
        this.p = null;
        this.r = 0L;
        this.s = 0L;
        this.t = true;
        this.f27000b = new Handler(Looper.getMainLooper());
        this.f27002d = i2;
        this.f27003e = str;
        this.f26999a = aVar;
        setRetryPolicy(new g());
        this.f27005g = b(str);
    }

    public void a(String str) {
        n nVar = this.j;
        if (nVar != null) {
            nVar.g(this);
        }
        if (q.a.f69550c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.f27000b.post(new a(str, id));
                return;
            }
            this.f27001c.c(str, id);
            this.f27001c.b(toString());
        }
    }

    public int compareTo(Request<T> request) {
        b priority = getPriority();
        b priority2 = request.getPriority();
        return priority == priority2 ? this.f27007i.intValue() - request.f27007i.intValue() : priority2.ordinal() - priority.ordinal();
    }

    @Deprecated
    public String b() {
        return d();
    }

    public void b(o<?> oVar) {
        c cVar;
        synchronized (this.f27006h) {
            cVar = this.w;
        }
        if (cVar != null) {
            cVar.b(this, oVar);
        }
    }

    public void a(int i2) {
        n nVar = this.j;
        if (nVar != null) {
            nVar.c(this, i2);
        }
    }

    @Deprecated
    public Map<String, String> a() throws com.bytedance.sdk.adnet.err.a {
        return c();
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    sb.append(URLEncoder.encode(entry.getKey(), str));
                    sb.append(com.alipay.sdk.encrypt.a.f1886h);
                    sb.append(URLEncoder.encode(entry.getValue(), str));
                    sb.append(Typography.amp);
                } else {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", entry.getKey(), entry.getValue()));
                }
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Encoding not supported: " + str, e2);
        }
    }

    public void a(c cVar) {
        synchronized (this.f27006h) {
            this.w = cVar;
        }
    }
}
