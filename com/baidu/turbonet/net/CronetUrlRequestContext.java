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
/* loaded from: classes14.dex */
class CronetUrlRequestContext extends TurbonetEngine {
    private ActivityManager dIC;
    private String mAppPackageName;
    private long oDB;
    private Thread oDC;
    private PowerManager oDD;
    private boolean oDE;
    private Executor oDH;
    private static final Pattern oDy = Pattern.compile("^((([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9])\\.)*)([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9-]*[A-Za-z0-9])$");
    private static long oDF = 0;
    private final Object mLock = new Object();
    private final ConditionVariable oDz = new ConditionVariable(false);
    private final AtomicInteger oDA = new AtomicInteger(0);
    private final Object oDG = new Object();
    private final Object oDI = new Object();
    private final Map<Object, HashSet<UrlRequest>> oDJ = new HashMap();
    private ProxyConfig oDK = ProxyConfig.oFJ;
    private TurbonetEngine.QUICConnectStatus oDL = TurbonetEngine.QUICConnectStatus.UNKNOWN;
    private TurbonetEngine.TCPNetworkQualityStatus oDM = TurbonetEngine.TCPNetworkQualityStatus.UNKNOWN;
    @GuardedBy("mDataTrafficMonitorLock")
    private final com.baidu.turbonet.base.b<DataTrafficListener> oDN = new com.baidu.turbonet.base.b<>();
    @GuardedBy("mNetworkQualityLock")
    private final com.baidu.turbonet.base.b<NetworkQualityListener> oDO = new com.baidu.turbonet.base.b<>();

    /* loaded from: classes14.dex */
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

    /* loaded from: classes14.dex */
    private static final class ResolveResult {
        String dnD = "";
        private final Object mLock = new Object();

        private ResolveResult() {
        }

        public void set(String str) {
            this.dnD = str;
        }

        public Object getLock() {
            return this.mLock;
        }
    }

    @UsedByReflection
    public CronetUrlRequestContext(final TurbonetEngine.Builder builder) {
        this.oDB = 0L;
        this.mAppPackageName = builder.getAppPackageName();
        try {
            this.oDD = (PowerManager) builder.getContext().getSystemService("power");
        } catch (Exception e) {
            Log.e("ChromiumNetwork", e.getMessage());
            this.oDD = null;
        }
        try {
            this.dIC = (ActivityManager) builder.getContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        } catch (Exception e2) {
            Log.e("ChromiumNetwork", e2.getMessage());
            this.dIC = null;
        }
        CronetLibraryLoader.a(builder.getContext(), builder);
        nativeSetMinLogLevel(ehs());
        synchronized (this.mLock) {
            this.oDB = nativeCreateRequestContextAdapter(b(builder.getContext(), builder));
            if (this.oDB == 0) {
                throw new NullPointerException("Context Adapter creation failed.");
            }
            this.oDE = builder.ehW();
        }
        CronetLibraryLoader.A(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequestContext.1
            @Override // java.lang.Runnable
            public void run() {
                CronetLibraryLoader.gU(builder.getContext());
                synchronized (CronetUrlRequestContext.this.mLock) {
                    CronetUrlRequestContext.this.nativeInitRequestContextOnInitThread(CronetUrlRequestContext.this.oDB);
                }
            }
        });
    }

    static long b(Context context, TurbonetEngine.Builder builder) {
        long nativeCreateRequestContextConfig = nativeCreateRequestContextConfig(builder.getUserAgent(), builder.ehN(), builder.ehT(), "", builder.ehS(), false, "", "", "", "", builder.cacheDisabled(), builder.ehV(), builder.ehU(), "", 0L, false);
        if (builder.ehX() != null) {
            nativeApplyBaiduConfiguration(nativeCreateRequestContextConfig, builder.ehX());
        }
        if (builder.ehY() != null) {
            nativeApplyBaiduConfigDictionary(nativeCreateRequestContextConfig, builder.ehY());
        }
        return nativeCreateRequestContextConfig;
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public UrlRequest a(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3) {
        CronetUrlRequest cronetUrlRequest;
        synchronized (this.mLock) {
            ehq();
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
            ehq();
            nativeUploadNativeRequestLog(this.oDB, str, str2, i, i2, j, j2, j3, j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(UrlRequest urlRequest) {
        synchronized (this.oDJ) {
            HashSet<UrlRequest> hashSet = this.oDJ.get(urlRequest.getTag());
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.oDJ.put(urlRequest.getTag(), hashSet);
            }
            hashSet.add(urlRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(UrlRequest urlRequest) {
        synchronized (this.oDJ) {
            HashSet<UrlRequest> hashSet = this.oDJ.get(urlRequest.getTag());
            if (hashSet == null) {
                Log.e("ChromiumNetwork", "Remove a tagged request which is not in mTaggedRequestList");
            } else {
                hashSet.remove(urlRequest);
                if (hashSet.isEmpty()) {
                    this.oDJ.remove(urlRequest.getTag());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ehl() {
        this.oDA.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eho() {
        this.oDA.decrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ehp() {
        long j;
        synchronized (this.mLock) {
            ehq();
            j = this.oDB;
        }
        return j;
    }

    private void ehq() throws IllegalStateException {
        if (!ehr()) {
            throw new IllegalStateException("Engine is shut down.");
        }
    }

    private boolean ehr() {
        return this.oDB != 0;
    }

    private int ehs() {
        if (Log.isLoggable("ChromiumNetwork", 2)) {
            return -2;
        }
        return Log.isLoggable("ChromiumNetwork", 3) ? -1 : 3;
    }

    @CalledByNative
    private void initNetworkThread(boolean z) {
        if (z) {
            this.oDK.a(ProxyConfig.LibType.NATIVE);
        }
        synchronized (this.mLock) {
            this.oDC = Thread.currentThread();
            this.oDz.open();
        }
        Thread.currentThread().setName("TurboNet");
        Process.setThreadPriority(10);
    }

    @CalledByNative
    private boolean isInteractive() {
        try {
            if (this.oDD == null) {
                throw new NullPointerException("Error: mPowerManager is null.");
            }
            if (Build.VERSION.SDK_INT >= 20) {
                return this.oDD.isInteractive();
            }
            return this.oDD.isScreenOn();
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
        if (this.dIC == null) {
            throw new NullPointerException("Error: mActivityManager is null.");
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : this.dIC.getRunningAppProcesses()) {
            if (runningAppProcessInfo.processName.equalsIgnoreCase(this.mAppPackageName)) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    @CalledByNative
    private int getAppState() {
        try {
            if (this.dIC == null) {
                throw new NullPointerException("Error: mActivityManager is null.");
            }
            if (this.oDD == null) {
                throw new NullPointerException("Error: mPowerManager is null.");
            }
            if (Build.VERSION.SDK_INT >= 20) {
                if (!this.oDD.isInteractive()) {
                    return AppThreadState.APP_THREAD_BACKGROUND.ordinal();
                }
            } else if (!this.oDD.isScreenOn()) {
                return AppThreadState.APP_THREAD_BACKGROUND.ordinal();
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : this.dIC.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equalsIgnoreCase(this.mAppPackageName)) {
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
        B(new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequestContext.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequestContext.this.oDI) {
                    Iterator it = CronetUrlRequestContext.this.oDN.iterator();
                    while (it.hasNext()) {
                        ((DataTrafficListener) it.next()).onDataTrafficObservation(i, i2);
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onNetworkQualityObservation(final int i) {
        synchronized (this.oDG) {
            Iterator<NetworkQualityListener> it = this.oDO.iterator();
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
        Oi(i);
    }

    @CalledByNative
    private void onGetNetworkQualityStatsComplete(final NetworkQualityListener networkQualityListener, final String str) {
        Runnable runnable = new Runnable() { // from class: com.baidu.turbonet.net.CronetUrlRequestContext.4
            @Override // java.lang.Runnable
            public void run() {
                networkQualityListener.Xo(str);
            }
        };
        if (networkQualityListener.getExecutor() == null) {
            throw new NullPointerException("Executor of listener is null");
        }
        a(networkQualityListener.getExecutor(), runnable);
    }

    private void Oi(int i) {
        if (this.oDM != TurbonetEngine.TCPNetworkQualityStatus.WEAK && i == 7) {
            this.oDM = TurbonetEngine.TCPNetworkQualityStatus.NORMAL;
        } else if (i == 3 || i == 6) {
            this.oDM = TurbonetEngine.TCPNetworkQualityStatus.WEAK;
        } else if (i == 0 || i == 4) {
            this.oDM = TurbonetEngine.TCPNetworkQualityStatus.UNKNOWN;
        }
    }

    @CalledByNative
    private void updateQUICConnectStatus(int i) {
        if (i >= 0 && i <= 2) {
            this.oDL = TurbonetEngine.QUICConnectStatus.values()[i];
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

    void B(Runnable runnable) {
        try {
            this.oDH.execute(runnable);
        } catch (RejectedExecutionException e) {
            Log.e("ChromiumNetwork", "Exception posting task to executor", e);
        }
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public boolean eht() {
        return this.oDK.eht();
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public long eha() {
        if (oDF == 0) {
            oDF = CronetLibraryLoader.eha();
        }
        return oDF;
    }
}
