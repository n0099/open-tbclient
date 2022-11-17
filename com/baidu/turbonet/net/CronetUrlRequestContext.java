package com.baidu.turbonet.net;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.PowerManager;
import android.os.Process;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.va9;
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
/* loaded from: classes6.dex */
public class CronetUrlRequestContext extends TurbonetEngine {
    public static /* synthetic */ Interceptable $ic;
    public static long p;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public final ConditionVariable b;
    public final AtomicInteger c;
    public long d;
    public PowerManager e;
    public ActivityManager f;
    public String g;
    public final Object h;
    public Executor i;
    public final Object j;
    public final Map<Object, HashSet<UrlRequest>> k;
    public ProxyConfig l;
    public TurbonetEngine.TCPNetworkQualityStatus m;
    @GuardedBy("mDataTrafficMonitorLock")
    public final va9<DataTrafficListener> n;
    @GuardedBy("mNetworkQualityLock")
    public final va9<NetworkQualityListener> o;

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

    @NativeClassQualifiedName
    private native void nativeSetDualStackBdnsCachePolicy(long j, int i);

    public static native int nativeSetMinLogLevel(int i);

    @NativeClassQualifiedName
    private native void nativeStartNetLogToFile(long j, String str, boolean z);

    @NativeClassQualifiedName
    private native void nativeStopNetLog(long j);

    @NativeClassQualifiedName
    private native void nativeUploadNativeRequestLog(long j, String str, String str2, int i, int i2, long j2, long j3, long j4, long j5);

    @NativeClassQualifiedName
    private native void nativeUploadNetLog(long j, String str);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class AppThreadState {
        public static final /* synthetic */ AppThreadState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AppThreadState APP_THREAD_BACKGROUND;
        public static final AppThreadState APP_THREAD_ERROR;
        public static final AppThreadState APP_THREAD_FOREGROUND;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1661292495, "Lcom/baidu/turbonet/net/CronetUrlRequestContext$AppThreadState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1661292495, "Lcom/baidu/turbonet/net/CronetUrlRequestContext$AppThreadState;");
                    return;
                }
            }
            APP_THREAD_ERROR = new AppThreadState("APP_THREAD_ERROR", 0);
            APP_THREAD_BACKGROUND = new AppThreadState("APP_THREAD_BACKGROUND", 1);
            AppThreadState appThreadState = new AppThreadState("APP_THREAD_FOREGROUND", 2);
            APP_THREAD_FOREGROUND = appThreadState;
            $VALUES = new AppThreadState[]{APP_THREAD_ERROR, APP_THREAD_BACKGROUND, appThreadState};
        }

        public AppThreadState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static AppThreadState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (AppThreadState) Enum.valueOf(AppThreadState.class, str);
            }
            return (AppThreadState) invokeL.objValue;
        }

        public static AppThreadState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (AppThreadState[]) $VALUES.clone();
            }
            return (AppThreadState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class ResolveResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object a;

        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        public ResolveResult() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new Object();
        }

        public Object a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TurbonetEngine.Builder a;
        public final /* synthetic */ CronetUrlRequestContext b;

        public a(CronetUrlRequestContext cronetUrlRequestContext, TurbonetEngine.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequestContext, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cronetUrlRequestContext;
            this.a = builder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                CronetLibraryLoader.b(this.a.getContext());
                synchronized (this.b.a) {
                    this.b.nativeInitRequestContextOnInitThread(this.b.d);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ CronetUrlRequestContext c;

        public b(CronetUrlRequestContext cronetUrlRequestContext, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequestContext, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cronetUrlRequestContext;
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            synchronized (this.c.j) {
                Iterator it = this.c.n.iterator();
                while (it.hasNext()) {
                    ((DataTrafficListener) it.next()).a(this.a, this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NetworkQualityListener a;
        public final /* synthetic */ int b;

        public c(CronetUrlRequestContext cronetUrlRequestContext, NetworkQualityListener networkQualityListener, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequestContext, networkQualityListener, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = networkQualityListener;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NetworkQualityListener a;
        public final /* synthetic */ String b;

        public d(CronetUrlRequestContext cronetUrlRequestContext, NetworkQualityListener networkQualityListener, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequestContext, networkQualityListener, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = networkQualityListener;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(808962205, "Lcom/baidu/turbonet/net/CronetUrlRequestContext;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(808962205, "Lcom/baidu/turbonet/net/CronetUrlRequestContext;");
                return;
            }
        }
        Pattern.compile("^((([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9])\\.)*)([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9-]*[A-Za-z0-9])$");
        p = 0L;
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (p == 0) {
                p = CronetLibraryLoader.c();
            }
            return p;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (Build.VERSION.SDK_INT >= 14) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.l.a();
        }
        return invokeV.booleanValue;
    }

    public final void n() throws IllegalStateException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || r()) {
            return;
        }
        throw new IllegalStateException("Engine is shut down.");
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (Log.isLoggable("ChromiumNetwork", 2)) {
                return -2;
            }
            if (!Log.isLoggable("ChromiumNetwork", 3)) {
                return 3;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public long q() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this.a) {
                n();
                j = this.d;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.d != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.c.decrementAndGet();
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.c.incrementAndGet();
        }
    }

    @UsedByReflection
    public CronetUrlRequestContext(TurbonetEngine.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Object();
        this.b = new ConditionVariable(false);
        this.c = new AtomicInteger(0);
        this.d = 0L;
        this.h = new Object();
        this.j = new Object();
        this.k = new HashMap();
        this.l = ProxyConfig.b;
        TurbonetEngine.QUICConnectStatus qUICConnectStatus = TurbonetEngine.QUICConnectStatus.UNKNOWN;
        this.m = TurbonetEngine.TCPNetworkQualityStatus.UNKNOWN;
        this.n = new va9<>();
        this.o = new va9<>();
        this.g = builder.f();
        try {
            this.e = (PowerManager) builder.getContext().getSystemService("power");
        } catch (Exception e) {
            Log.e("ChromiumNetwork", e.getMessage());
            this.e = null;
        }
        try {
            this.f = (ActivityManager) builder.getContext().getSystemService("activity");
        } catch (Exception e2) {
            Log.e("ChromiumNetwork", e2.getMessage());
            this.f = null;
        }
        CronetLibraryLoader.a(builder.getContext(), builder);
        nativeSetMinLogLevel(p());
        synchronized (this.a) {
            long nativeCreateRequestContextAdapter = nativeCreateRequestContextAdapter(o(builder.getContext(), builder));
            this.d = nativeCreateRequestContextAdapter;
            if (nativeCreateRequestContextAdapter != 0) {
                builder.n();
            } else {
                throw new NullPointerException("Context Adapter creation failed.");
            }
        }
        CronetLibraryLoader.e(new a(this, builder));
    }

    @CalledByNative
    private int getAppState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            try {
                if (this.f != null) {
                    if (this.e != null) {
                        if (Build.VERSION.SDK_INT >= 20) {
                            if (!this.e.isInteractive()) {
                                return AppThreadState.APP_THREAD_BACKGROUND.ordinal();
                            }
                        } else if (!this.e.isScreenOn()) {
                            return AppThreadState.APP_THREAD_BACKGROUND.ordinal();
                        }
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : this.f.getRunningAppProcesses()) {
                            if (runningAppProcessInfo.processName.equalsIgnoreCase(this.g)) {
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
            } catch (Exception e) {
                Log.e("ChromiumNetwork", e.getMessage());
                return AppThreadState.APP_THREAD_ERROR.ordinal();
            }
        }
        return invokeV.intValue;
    }

    @CalledByNative
    private void updateQUICConnectStatus(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65582, this, i) == null) && i >= 0 && i <= 2) {
            TurbonetEngine.QUICConnectStatus qUICConnectStatus = TurbonetEngine.QUICConnectStatus.values()[i];
        }
    }

    public void u(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, runnable) == null) {
            try {
                this.i.execute(runnable);
            } catch (RejectedExecutionException e) {
                Log.e("ChromiumNetwork", "Exception posting task to executor", e);
            }
        }
    }

    @CalledByNative
    private void initNetworkThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, this, z) == null) {
            if (z) {
                this.l.b(ProxyConfig.LibType.NATIVE);
            }
            synchronized (this.a) {
                Thread.currentThread();
                this.b.open();
            }
            Thread.currentThread().setName("TurboNet");
            Process.setThreadPriority(10);
        }
    }

    public void m(UrlRequest urlRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, urlRequest) == null) {
            synchronized (this.k) {
                HashSet<UrlRequest> hashSet = this.k.get(urlRequest.getTag());
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    this.k.put(urlRequest.getTag(), hashSet);
                }
                hashSet.add(urlRequest);
            }
        }
    }

    public final void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            if (this.m != TurbonetEngine.TCPNetworkQualityStatus.WEAK && i == 7) {
                this.m = TurbonetEngine.TCPNetworkQualityStatus.NORMAL;
            } else if (i != 3 && i != 6) {
                if (i != 0 && i != 4) {
                    return;
                }
                this.m = TurbonetEngine.TCPNetworkQualityStatus.UNKNOWN;
            } else {
                this.m = TurbonetEngine.TCPNetworkQualityStatus.WEAK;
            }
        }
    }

    public void x(UrlRequest urlRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, urlRequest) == null) {
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

    @CalledByNative
    private boolean isAppForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            try {
            } catch (Exception e) {
                Log.e("ChromiumNetwork", e.getMessage());
            }
            if (this.f != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : this.f.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.processName.equalsIgnoreCase(this.g)) {
                        if (runningAppProcessInfo.importance != 100) {
                            return false;
                        }
                        return true;
                    }
                }
                return false;
            }
            throw new NullPointerException("Error: mActivityManager is null.");
        }
        return invokeV.booleanValue;
    }

    @CalledByNative
    private boolean isInteractive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            try {
                if (this.e != null) {
                    if (Build.VERSION.SDK_INT >= 20) {
                        return this.e.isInteractive();
                    }
                    return this.e.isScreenOn();
                }
                throw new NullPointerException("Error: mPowerManager is null.");
            } catch (Exception e) {
                Log.e("ChromiumNetwork", e.getMessage());
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @CalledByNative
    private void onDataTrafficObservation(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65578, this, i, i2) == null) {
            u(new b(this, i, i2));
        }
    }

    @CalledByNative
    private void onGetNetworkQualityStatsComplete(NetworkQualityListener networkQualityListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65579, this, networkQualityListener, str) == null) {
            d dVar = new d(this, networkQualityListener, str);
            if (networkQualityListener.a() != null) {
                v(networkQualityListener.a(), dVar);
                return;
            }
            throw new NullPointerException("Executor of listener is null");
        }
    }

    @CalledByNative
    private void onResolveComplete(ResolveResult resolveResult, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65581, this, resolveResult, str) == null) {
            synchronized (resolveResult.a()) {
                resolveResult.b(str);
                resolveResult.a().notifyAll();
            }
        }
    }

    public static void v(Executor executor, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65583, null, executor, runnable) == null) {
            try {
                executor.execute(runnable);
            } catch (RejectedExecutionException e) {
                Log.e("ChromiumNetwork", "Exception posting task to executor", e);
            }
        }
    }

    public static long o(Context context, TurbonetEngine.Builder builder) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65577, null, context, builder)) == null) {
            long nativeCreateRequestContextConfig = nativeCreateRequestContextConfig(builder.i(), builder.v(), builder.o(), "", builder.j(), false, "", "", "", "", builder.c(), builder.l(), builder.k(), "", 0L, false);
            if (builder.g() != null) {
                nativeApplyBaiduConfiguration(nativeCreateRequestContextConfig, builder.g());
            }
            if (builder.h() != null) {
                nativeApplyBaiduConfigDictionary(nativeCreateRequestContextConfig, builder.h());
            }
            return nativeCreateRequestContextConfig;
        }
        return invokeLL.longValue;
    }

    @CalledByNative
    private void onNetworkQualityObservation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65580, this, i) == null) {
            synchronized (this.h) {
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
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public UrlRequest b(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        CronetUrlRequest cronetUrlRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, callback, executor, Integer.valueOf(i), collection, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            synchronized (this.a) {
                n();
                cronetUrlRequest = new CronetUrlRequest(this, str, i, callback, executor, collection, false, z, z2, z3);
            }
            return cronetUrlRequest;
        }
        return (UrlRequest) invokeCommon.objValue;
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public void g(String str, String str2, int i, int i2, long j, long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            synchronized (this.a) {
                try {
                    try {
                        n();
                        nativeUploadNativeRequestLog(this.d, str, str2, i, i2, j, j2, j3, j4);
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
    }
}
