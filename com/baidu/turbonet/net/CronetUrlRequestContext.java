package com.baidu.turbonet.net;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.PowerManager;
import android.os.Process;
import android.util.Log;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.base.annotations.UsedByReflection;
import com.baidu.turbonet.net.TurbonetEngine;
import com.baidu.turbonet.net.UrlRequest;
import com.baidu.turbonet.net.proxy.ProxyConfig;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;
@UsedByReflection
@JNINamespace
/* loaded from: classes5.dex */
public class CronetUrlRequestContext extends TurbonetEngine {
    public static long p;

    /* renamed from: d  reason: collision with root package name */
    public long f22736d;

    /* renamed from: e  reason: collision with root package name */
    public PowerManager f22737e;

    /* renamed from: f  reason: collision with root package name */
    public ActivityManager f22738f;

    /* renamed from: g  reason: collision with root package name */
    public String f22739g;
    public Executor i;
    public TurbonetEngine.TCPNetworkQualityStatus m;
    @GuardedBy("mDataTrafficMonitorLock")
    public final d.b.j0.a.b<DataTrafficListener> n;
    @GuardedBy("mNetworkQualityLock")
    public final d.b.j0.a.b<NetworkQualityListener> o;

    /* renamed from: a  reason: collision with root package name */
    public final Object f22733a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final ConditionVariable f22734b = new ConditionVariable(false);

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f22735c = new AtomicInteger(0);

    /* renamed from: h  reason: collision with root package name */
    public final Object f22740h = new Object();
    public final Object j = new Object();
    public final Map<Object, HashSet<UrlRequest>> k = new HashMap();
    public ProxyConfig l = ProxyConfig.f22882b;

    /* loaded from: classes5.dex */
    public enum AppThreadState {
        APP_THREAD_ERROR,
        APP_THREAD_BACKGROUND,
        APP_THREAD_FOREGROUND
    }

    /* loaded from: classes5.dex */
    public static final class ResolveResult {

        /* renamed from: a  reason: collision with root package name */
        public final Object f22741a = new Object();

        public Object a() {
            return this.f22741a;
        }

        public void b(String str) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TurbonetEngine.Builder f22742e;

        public a(TurbonetEngine.Builder builder) {
            this.f22742e = builder;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetLibraryLoader.b(this.f22742e.i());
            synchronized (CronetUrlRequestContext.this.f22733a) {
                CronetUrlRequestContext.this.nativeInitRequestContextOnInitThread(CronetUrlRequestContext.this.f22736d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f22744e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f22745f;

        public b(int i, int i2) {
            this.f22744e = i;
            this.f22745f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUrlRequestContext.this.j) {
                Iterator it = CronetUrlRequestContext.this.n.iterator();
                while (it.hasNext()) {
                    ((DataTrafficListener) it.next()).a(this.f22744e, this.f22745f);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NetworkQualityListener f22747e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f22748f;

        public c(CronetUrlRequestContext cronetUrlRequestContext, NetworkQualityListener networkQualityListener, int i) {
            this.f22747e = networkQualityListener;
            this.f22748f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f22747e.b(this.f22748f);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NetworkQualityListener f22749e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f22750f;

        public d(CronetUrlRequestContext cronetUrlRequestContext, NetworkQualityListener networkQualityListener, String str) {
            this.f22749e = networkQualityListener;
            this.f22750f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f22749e.c(this.f22750f);
        }
    }

    static {
        Pattern.compile("^((([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9])\\.)*)([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9-]*[A-Za-z0-9])$");
        p = 0L;
    }

    @UsedByReflection
    public CronetUrlRequestContext(TurbonetEngine.Builder builder) {
        this.f22736d = 0L;
        TurbonetEngine.QUICConnectStatus qUICConnectStatus = TurbonetEngine.QUICConnectStatus.UNKNOWN;
        this.m = TurbonetEngine.TCPNetworkQualityStatus.UNKNOWN;
        this.n = new d.b.j0.a.b<>();
        this.o = new d.b.j0.a.b<>();
        this.f22739g = builder.f();
        try {
            this.f22737e = (PowerManager) builder.i().getSystemService("power");
        } catch (Exception e2) {
            Log.e("ChromiumNetwork", e2.getMessage());
            this.f22737e = null;
        }
        try {
            this.f22738f = (ActivityManager) builder.i().getSystemService("activity");
        } catch (Exception e3) {
            Log.e("ChromiumNetwork", e3.getMessage());
            this.f22738f = null;
        }
        CronetLibraryLoader.a(builder.i(), builder);
        nativeSetMinLogLevel(p());
        synchronized (this.f22733a) {
            long nativeCreateRequestContextAdapter = nativeCreateRequestContextAdapter(o(builder.i(), builder));
            this.f22736d = nativeCreateRequestContextAdapter;
            if (nativeCreateRequestContextAdapter != 0) {
                builder.o();
            } else {
                throw new NullPointerException("Context Adapter creation failed.");
            }
        }
        CronetLibraryLoader.e(new a(builder));
    }

    @CalledByNative
    private int getAppState() {
        try {
            if (this.f22738f != null) {
                if (this.f22737e != null) {
                    if (Build.VERSION.SDK_INT >= 20) {
                        if (!this.f22737e.isInteractive()) {
                            return AppThreadState.APP_THREAD_BACKGROUND.ordinal();
                        }
                    } else if (!this.f22737e.isScreenOn()) {
                        return AppThreadState.APP_THREAD_BACKGROUND.ordinal();
                    }
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : this.f22738f.getRunningAppProcesses()) {
                        if (runningAppProcessInfo.processName.equalsIgnoreCase(this.f22739g)) {
                            if (runningAppProcessInfo.importance == 100) {
                                return AppThreadState.APP_THREAD_FOREGROUND.ordinal();
                            }
                            return AppThreadState.APP_THREAD_BACKGROUND.ordinal();
                        }
                    }
                    return AppThreadState.APP_THREAD_BACKGROUND.ordinal();
                }
                throw new NullPointerException("Error: mPowerManager is null.");
            }
            throw new NullPointerException("Error: mActivityManager is null.");
        } catch (Exception e2) {
            Log.e("ChromiumNetwork", e2.getMessage());
            return AppThreadState.APP_THREAD_ERROR.ordinal();
        }
    }

    @CalledByNative
    private void initNetworkThread(boolean z) {
        if (z) {
            this.l.b(ProxyConfig.LibType.NATIVE);
        }
        synchronized (this.f22733a) {
            Thread.currentThread();
            this.f22734b.open();
        }
        Thread.currentThread().setName("TurboNet");
        Process.setThreadPriority(10);
    }

    @CalledByNative
    private boolean isAppForeground() {
        try {
        } catch (Exception e2) {
            Log.e("ChromiumNetwork", e2.getMessage());
        }
        if (this.f22738f != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : this.f22738f.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equalsIgnoreCase(this.f22739g)) {
                    return runningAppProcessInfo.importance == 100;
                }
            }
            return false;
        }
        throw new NullPointerException("Error: mActivityManager is null.");
    }

    @CalledByNative
    private boolean isInteractive() {
        try {
            if (this.f22737e != null) {
                if (Build.VERSION.SDK_INT >= 20) {
                    return this.f22737e.isInteractive();
                }
                return this.f22737e.isScreenOn();
            }
            throw new NullPointerException("Error: mPowerManager is null.");
        } catch (Exception e2) {
            Log.e("ChromiumNetwork", e2.getMessage());
            return false;
        }
    }

    public static native void nativeApplyBaiduConfigDictionary(long j, String str);

    public static native void nativeApplyBaiduConfiguration(long j, String str);

    public static native long nativeCreateRequestContextAdapter(long j);

    public static native long nativeCreateRequestContextConfig(String str, String str2, boolean z, String str3, boolean z2, boolean z3, String str4, String str5, String str6, String str7, boolean z4, int i, long j, String str8, long j2, boolean z5);

    @NativeClassQualifiedName
    private native void nativeDestroy(long j);

    @NativeClassQualifiedName
    private native void nativeDetectQuicConnectStatusByPreconnect(long j);

    @NativeClassQualifiedName
    private native void nativeDisableSpdyPingByHost(long j, String str);

    @NativeClassQualifiedName
    private native void nativeEnableCustomProxy(long j, boolean z);

    @NativeClassQualifiedName
    private native void nativeEnableDataTrafficMonitor(long j);

    @NativeClassQualifiedName
    private native void nativeEnableMulConnect(long j, boolean z);

    @NativeClassQualifiedName
    private native void nativeEnableSpdyPingByHost(long j, String str, int i, int i2);

    @NativeClassQualifiedName
    private native void nativeForceDisableQuic(long j, boolean z);

    public static native byte[] nativeGetHistogramDeltas();

    @NativeClassQualifiedName
    private native void nativeGetNetworkQualityStats(long j, NetworkQualityListener networkQualityListener);

    @NativeClassQualifiedName
    public static native String nativeGetTurboNetVersion();

    /* JADX INFO: Access modifiers changed from: private */
    @NativeClassQualifiedName
    public native void nativeInitRequestContextOnInitThread(long j);

    @NativeClassQualifiedName
    private native void nativeOnBdAppStatusChange(long j, int i);

    @NativeClassQualifiedName
    private native void nativePreconnectURL(long j, String str, int i, boolean z);

    @NativeClassQualifiedName
    private native void nativeProvideDataTrafficObservations(long j, boolean z);

    @NativeClassQualifiedName
    private native void nativeProvideNetworkQualityObservations(long j, boolean z);

    @NativeClassQualifiedName
    private native void nativeResolveHost(long j, ResolveResult resolveResult, String str, boolean z);

    @NativeClassQualifiedName
    private native void nativeSetAltQuicInterceptor(long j, boolean z);

    @NativeClassQualifiedName
    private native void nativeSetAltQuicInterceptorWhitelist(long j, String str);

    @NativeClassQualifiedName
    private native void nativeSetDataTrafficThreshold(long j, int i, int i2, int i3);

    public static native int nativeSetMinLogLevel(int i);

    @NativeClassQualifiedName
    private native void nativeStartNetLogToFile(long j, String str, boolean z);

    @NativeClassQualifiedName
    private native void nativeStopNetLog(long j);

    @NativeClassQualifiedName
    private native void nativeUploadNativeRequestLog(long j, String str, String str2, int i, int i2, long j2, long j3, long j4, long j5);

    @NativeClassQualifiedName
    private native void nativeUploadNetLog(long j, String str);

    public static long o(Context context, TurbonetEngine.Builder builder) {
        long nativeCreateRequestContextConfig = nativeCreateRequestContextConfig(builder.j(), builder.w(), builder.p(), "", builder.k(), false, "", "", "", "", builder.c(), builder.m(), builder.l(), "", 0L, false);
        if (builder.g() != null) {
            nativeApplyBaiduConfiguration(nativeCreateRequestContextConfig, builder.g());
        }
        if (builder.h() != null) {
            nativeApplyBaiduConfigDictionary(nativeCreateRequestContextConfig, builder.h());
        }
        return nativeCreateRequestContextConfig;
    }

    @CalledByNative
    private void onDataTrafficObservation(int i, int i2) {
        u(new b(i, i2));
    }

    @CalledByNative
    private void onGetNetworkQualityStatsComplete(NetworkQualityListener networkQualityListener, String str) {
        d dVar = new d(this, networkQualityListener, str);
        if (networkQualityListener.a() != null) {
            v(networkQualityListener.a(), dVar);
            return;
        }
        throw new NullPointerException("Executor of listener is null");
    }

    @CalledByNative
    private void onNetworkQualityObservation(int i) {
        synchronized (this.f22740h) {
            Iterator<NetworkQualityListener> it = this.o.iterator();
            while (it.hasNext()) {
                NetworkQualityListener next = it.next();
                c cVar = new c(this, next, i);
                if (next.a() != null) {
                    v(next.a(), cVar);
                } else {
                    throw new NullPointerException("Executor of listener is null");
                }
            }
        }
        w(i);
    }

    @CalledByNative
    private void onResolveComplete(ResolveResult resolveResult, String str) {
        synchronized (resolveResult.a()) {
            resolveResult.b(str);
            resolveResult.a().notifyAll();
        }
    }

    @CalledByNative
    private void updateQUICConnectStatus(int i) {
        if (i < 0 || i > 2) {
            return;
        }
        TurbonetEngine.QUICConnectStatus qUICConnectStatus = TurbonetEngine.QUICConnectStatus.values()[i];
    }

    public static void v(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (RejectedExecutionException e2) {
            Log.e("ChromiumNetwork", "Exception posting task to executor", e2);
        }
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public UrlRequest b(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3) {
        CronetUrlRequest cronetUrlRequest;
        synchronized (this.f22733a) {
            n();
            cronetUrlRequest = new CronetUrlRequest(this, str, i, callback, executor, collection, false, z, z2, z3);
        }
        return cronetUrlRequest;
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public long d() {
        if (p == 0) {
            p = CronetLibraryLoader.c();
        }
        return p;
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public boolean e() {
        return Build.VERSION.SDK_INT >= 14;
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public boolean f() {
        return this.l.a();
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public void g(String str, String str2, int i, int i2, long j, long j2, long j3, long j4) {
        synchronized (this.f22733a) {
            try {
                try {
                    n();
                    nativeUploadNativeRequestLog(this.f22736d, str, str2, i, i2, j, j2, j3, j4);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public void m(UrlRequest urlRequest) {
        synchronized (this.k) {
            HashSet<UrlRequest> hashSet = this.k.get(urlRequest.getTag());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.k.put(urlRequest.getTag(), hashSet);
            }
            hashSet.add(urlRequest);
        }
    }

    public final void n() throws IllegalStateException {
        if (!r()) {
            throw new IllegalStateException("Engine is shut down.");
        }
    }

    public final int p() {
        if (Log.isLoggable("ChromiumNetwork", 2)) {
            return -2;
        }
        return Log.isLoggable("ChromiumNetwork", 3) ? -1 : 3;
    }

    public long q() {
        long j;
        synchronized (this.f22733a) {
            n();
            j = this.f22736d;
        }
        return j;
    }

    public final boolean r() {
        return this.f22736d != 0;
    }

    public void s() {
        this.f22735c.decrementAndGet();
    }

    public void t() {
        this.f22735c.incrementAndGet();
    }

    public void u(Runnable runnable) {
        try {
            this.i.execute(runnable);
        } catch (RejectedExecutionException e2) {
            Log.e("ChromiumNetwork", "Exception posting task to executor", e2);
        }
    }

    public final void w(int i) {
        if (this.m != TurbonetEngine.TCPNetworkQualityStatus.WEAK && i == 7) {
            this.m = TurbonetEngine.TCPNetworkQualityStatus.NORMAL;
        } else if (i == 3 || i == 6) {
            this.m = TurbonetEngine.TCPNetworkQualityStatus.WEAK;
        } else if (i == 0 || i == 4) {
            this.m = TurbonetEngine.TCPNetworkQualityStatus.UNKNOWN;
        }
    }

    public void x(UrlRequest urlRequest) {
        synchronized (this.k) {
            HashSet<UrlRequest> hashSet = this.k.get(urlRequest.getTag());
            if (hashSet == null) {
                Log.e("ChromiumNetwork", "Remove a tagged request which is not in mTaggedRequestList");
            } else {
                hashSet.remove(urlRequest);
                if (hashSet.isEmpty()) {
                    this.k.remove(urlRequest.getTag());
                }
            }
        }
    }
}
