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
import com.meizu.cloud.pushsdk.constants.PushConstants;
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
/* loaded from: classes.dex */
class CronetUrlRequestContext extends TurbonetEngine {
    private ActivityManager cOh;
    private String dvh;
    private PowerManager mAA;
    private boolean mAB;
    private Executor mAE;
    private long mAy;
    private Thread mAz;
    private static final Pattern mAv = Pattern.compile("^((([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9])\\.)*)([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9-]*[A-Za-z0-9])$");
    private static long mAC = 0;
    private final Object mLock = new Object();
    private final ConditionVariable mAw = new ConditionVariable(false);
    private final AtomicInteger mAx = new AtomicInteger(0);
    private final Object mAD = new Object();
    private final Object mAF = new Object();
    private final Map<Object, HashSet<UrlRequest>> mAG = new HashMap();
    private ProxyConfig mAH = ProxyConfig.mCK;
    private TurbonetEngine.QUICConnectStatus mAI = TurbonetEngine.QUICConnectStatus.UNKNOWN;
    private TurbonetEngine.TCPNetworkQualityStatus mAJ = TurbonetEngine.TCPNetworkQualityStatus.UNKNOWN;
    @GuardedBy("mDataTrafficMonitorLock")
    private final com.baidu.turbonet.base.b<DataTrafficListener> mAK = new com.baidu.turbonet.base.b<>();
    @GuardedBy("mNetworkQualityLock")
    private final com.baidu.turbonet.base.b<NetworkQualityListener> mAL = new com.baidu.turbonet.base.b<>();

    /* loaded from: classes.dex */
    private enum AppThreadState {
        APP_THREAD_ERROR,
        APP_THREAD_BACKGROUND,
        APP_THREAD_FOREGROUND
    }

    private static native void nativeApplyBaiduConfigDictionary(long j, String str);

    private static native void nativeApplyBaiduConfiguration(long j, String str);

    private static native long nativeCreateRequestContextAdapter(long j);

    private static native long nativeCreateRequestContextConfig(String str, String str2, boolean z, String str3, boolean z2, boolean z3, String str4, String str5, String str6, String str7, boolean z4, int i, long j, String str8, long j2, boolean z5);

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

    private static native byte[] nativeGetHistogramDeltas();

    @NativeClassQualifiedName
    private native void nativeGetNetworkQualityStats(long j, NetworkQualityListener networkQualityListener);

    @NativeClassQualifiedName
    private static native String nativeGetTurboNetVersion();

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

    private static native int nativeSetMinLogLevel(int i);

    @NativeClassQualifiedName
    private native void nativeStartNetLogToFile(long j, String str, boolean z);

    @NativeClassQualifiedName
    private native void nativeStopNetLog(long j);

    @NativeClassQualifiedName
    private native void nativeUploadNativeRequestLog(long j, String str, String str2, int i, int i2, long j2, long j3, long j4, long j5);

    @NativeClassQualifiedName
    private native void nativeUploadNetLog(long j, String str);

    /* loaded from: classes.dex */
    private static final class ResolveResult {
        String mResult = "";
        private final Object mLock = new Object();

        private ResolveResult() {
        }

        public void set(String str) {
            this.mResult = str;
        }

        public Object getLock() {
            return this.mLock;
        }
    }

    @UsedByReflection
    public CronetUrlRequestContext(final TurbonetEngine.Builder builder) {
        this.mAy = 0L;
        this.dvh = builder.getAppPackageName();
        try {
            this.mAA = (PowerManager) builder.getContext().getSystemService("power");
        } catch (Exception e) {
            Log.e("ChromiumNetwork", e.getMessage());
            this.mAA = null;
        }
        try {
            this.cOh = (ActivityManager) builder.getContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        } catch (Exception e2) {
            Log.e("ChromiumNetwork", e2.getMessage());
            this.cOh = null;
        }
        CronetLibraryLoader.a(builder.getContext(), builder);
        nativeSetMinLogLevel(dvt());
        synchronized (this.mLock) {
            this.mAy = nativeCreateRequestContextAdapter(b(builder.getContext(), builder));
            if (this.mAy == 0) {
                throw new NullPointerException("Context Adapter creation failed.");
            }
            this.mAB = builder.dvY();
        }
        CronetLibraryLoader.D(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequestContext.1
            @Override // java.lang.Runnable
            public void run() {
                CronetLibraryLoader.fF(builder.getContext());
                synchronized (CronetUrlRequestContext.this.mLock) {
                    CronetUrlRequestContext.this.nativeInitRequestContextOnInitThread(CronetUrlRequestContext.this.mAy);
                }
            }
        });
    }

    static long b(Context context, TurbonetEngine.Builder builder) {
        long nativeCreateRequestContextConfig = nativeCreateRequestContextConfig(builder.getUserAgent(), builder.dvP(), builder.dvV(), "", builder.dvU(), false, "", "", "", "", builder.cacheDisabled(), builder.dvX(), builder.dvW(), "", 0L, false);
        if (builder.dvZ() != null) {
            nativeApplyBaiduConfiguration(nativeCreateRequestContextConfig, builder.dvZ());
        }
        if (builder.dwa() != null) {
            nativeApplyBaiduConfigDictionary(nativeCreateRequestContextConfig, builder.dwa());
        }
        return nativeCreateRequestContextConfig;
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public UrlRequest a(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3) {
        CronetUrlRequest cronetUrlRequest;
        synchronized (this.mLock) {
            dvr();
            cronetUrlRequest = new CronetUrlRequest(this, str, i, callback, executor, collection, false, z, z2, z3);
        }
        return cronetUrlRequest;
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public boolean isEnabled() {
        return Build.VERSION.SDK_INT >= 14;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.TurbonetEngine
    public void a(String str, String str2, int i, int i2, long j, long j2, long j3, long j4) {
        synchronized (this.mLock) {
            dvr();
            nativeUploadNativeRequestLog(this.mAy, str, str2, i, i2, j, j2, j3, j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(UrlRequest urlRequest) {
        synchronized (this.mAG) {
            HashSet<UrlRequest> hashSet = this.mAG.get(urlRequest.getTag());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.mAG.put(urlRequest.getTag(), hashSet);
            }
            hashSet.add(urlRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(UrlRequest urlRequest) {
        synchronized (this.mAG) {
            HashSet<UrlRequest> hashSet = this.mAG.get(urlRequest.getTag());
            if (hashSet == null) {
                Log.e("ChromiumNetwork", "Remove a tagged request which is not in mTaggedRequestList");
            } else {
                hashSet.remove(urlRequest);
                if (hashSet.isEmpty()) {
                    this.mAG.remove(urlRequest.getTag());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dvm() {
        this.mAx.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dvp() {
        this.mAx.decrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dvq() {
        long j;
        synchronized (this.mLock) {
            dvr();
            j = this.mAy;
        }
        return j;
    }

    private void dvr() throws IllegalStateException {
        if (!dvs()) {
            throw new IllegalStateException("Engine is shut down.");
        }
    }

    private boolean dvs() {
        return this.mAy != 0;
    }

    private int dvt() {
        if (Log.isLoggable("ChromiumNetwork", 2)) {
            return -2;
        }
        return Log.isLoggable("ChromiumNetwork", 3) ? -1 : 3;
    }

    @CalledByNative
    private void initNetworkThread(boolean z) {
        if (z) {
            this.mAH.a(ProxyConfig.LibType.NATIVE);
        }
        synchronized (this.mLock) {
            this.mAz = Thread.currentThread();
            this.mAw.open();
        }
        Thread.currentThread().setName("TurboNet");
        Process.setThreadPriority(10);
    }

    @CalledByNative
    private boolean isInteractive() {
        try {
            if (this.mAA == null) {
                throw new NullPointerException("Error: mPowerManager is null.");
            }
            if (Build.VERSION.SDK_INT >= 20) {
                return this.mAA.isInteractive();
            }
            return this.mAA.isScreenOn();
        } catch (Exception e) {
            Log.e("ChromiumNetwork", e.getMessage());
            return false;
        }
    }

    @CalledByNative
    private boolean isAppForeground() {
        try {
        } catch (Exception e) {
            Log.e("ChromiumNetwork", e.getMessage());
        }
        if (this.cOh == null) {
            throw new NullPointerException("Error: mActivityManager is null.");
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : this.cOh.getRunningAppProcesses()) {
            if (runningAppProcessInfo.processName.equalsIgnoreCase(this.dvh)) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    @CalledByNative
    private int getAppState() {
        try {
            if (this.cOh == null) {
                throw new NullPointerException("Error: mActivityManager is null.");
            }
            if (this.mAA == null) {
                throw new NullPointerException("Error: mPowerManager is null.");
            }
            if (Build.VERSION.SDK_INT >= 20) {
                if (!this.mAA.isInteractive()) {
                    return AppThreadState.APP_THREAD_BACKGROUND.ordinal();
                }
            } else if (!this.mAA.isScreenOn()) {
                return AppThreadState.APP_THREAD_BACKGROUND.ordinal();
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : this.cOh.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equalsIgnoreCase(this.dvh)) {
                    if (runningAppProcessInfo.importance == 100) {
                        return AppThreadState.APP_THREAD_FOREGROUND.ordinal();
                    }
                    return AppThreadState.APP_THREAD_BACKGROUND.ordinal();
                }
            }
            return AppThreadState.APP_THREAD_BACKGROUND.ordinal();
        } catch (Exception e) {
            Log.e("ChromiumNetwork", e.getMessage());
            return AppThreadState.APP_THREAD_ERROR.ordinal();
        }
    }

    @CalledByNative
    private void onDataTrafficObservation(final int i, final int i2) {
        E(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequestContext.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequestContext.this.mAF) {
                    Iterator it = CronetUrlRequestContext.this.mAK.iterator();
                    while (it.hasNext()) {
                        ((DataTrafficListener) it.next()).onDataTrafficObservation(i, i2);
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onNetworkQualityObservation(final int i) {
        synchronized (this.mAD) {
            Iterator<NetworkQualityListener> it = this.mAL.iterator();
            while (it.hasNext()) {
                final NetworkQualityListener next = it.next();
                Runnable runnable = new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequestContext.3
                    @Override // java.lang.Runnable
                    public void run() {
                        next.onNetworkQualityObservation(i);
                    }
                };
                if (next.getExecutor() == null) {
                    throw new NullPointerException("Executor of listener is null");
                }
                a(next.getExecutor(), runnable);
            }
        }
        Hm(i);
    }

    @CalledByNative
    private void onGetNetworkQualityStatsComplete(final NetworkQualityListener networkQualityListener, final String str) {
        Runnable runnable = new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequestContext.4
            @Override // java.lang.Runnable
            public void run() {
                networkQualityListener.PA(str);
            }
        };
        if (networkQualityListener.getExecutor() == null) {
            throw new NullPointerException("Executor of listener is null");
        }
        a(networkQualityListener.getExecutor(), runnable);
    }

    private void Hm(int i) {
        if (this.mAJ != TurbonetEngine.TCPNetworkQualityStatus.WEAK && i == 7) {
            this.mAJ = TurbonetEngine.TCPNetworkQualityStatus.NORMAL;
        } else if (i == 3 || i == 6) {
            this.mAJ = TurbonetEngine.TCPNetworkQualityStatus.WEAK;
        } else if (i == 0 || i == 4) {
            this.mAJ = TurbonetEngine.TCPNetworkQualityStatus.UNKNOWN;
        }
    }

    @CalledByNative
    private void updateQUICConnectStatus(int i) {
        if (i >= 0 && i <= 2) {
            this.mAI = TurbonetEngine.QUICConnectStatus.values()[i];
        }
    }

    private static void a(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (RejectedExecutionException e) {
            Log.e("ChromiumNetwork", "Exception posting task to executor", e);
        }
    }

    @CalledByNative
    private void onResolveComplete(ResolveResult resolveResult, String str) {
        synchronized (resolveResult.getLock()) {
            resolveResult.set(str);
            resolveResult.getLock().notifyAll();
        }
    }

    void E(Runnable runnable) {
        try {
            this.mAE.execute(runnable);
        } catch (RejectedExecutionException e) {
            Log.e("ChromiumNetwork", "Exception posting task to executor", e);
        }
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public boolean dvu() {
        return this.mAH.dvu();
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public long dvb() {
        if (mAC == 0) {
            mAC = CronetLibraryLoader.dvb();
        }
        return mAC;
    }
}
