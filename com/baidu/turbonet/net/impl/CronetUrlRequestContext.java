package com.baidu.turbonet.net.impl;

import android.app.ActivityManager;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.PowerManager;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pma;
import com.baidu.tieba.sla;
import com.baidu.tieba.tla;
import com.baidu.tieba.xla;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.NetworkQualityListener;
import com.baidu.turbonet.net.RequestFinishedInfo;
import com.baidu.turbonet.net.TurbonetEngine;
import com.baidu.turbonet.net.UrlRequest;
import com.baidu.turbonet.net.impl.VersionSafeCallbacks;
import com.baidu.turbonet.net.proxy.ProxyConfig;
import java.util.ArrayList;
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
import org.chromium.base.Log;
import org.chromium.base.ObserverList;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.NativeClassQualifiedName;
import org.chromium.base.annotations.UsedByReflection;
@UsedByReflection("CronetEngine.java")
@JNINamespace("cronet")
@VisibleForTesting
/* loaded from: classes8.dex */
public class CronetUrlRequestContext extends sla {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String s = "CronetUrlRequestContext";
    public static volatile PowerManager t;
    public static volatile ActivityManager u;
    public static volatile String v;
    public static long w;
    @GuardedBy("sInUseStoragePaths")
    public static HashSet<String> x;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object b;
    public final ConditionVariable c;
    public final AtomicInteger d;
    @GuardedBy("mLock")
    public long e;
    public Thread f;
    public final Object g;
    public Executor h;
    public final Object i;
    public final Map<Object, HashSet<VersionSafeCallbacks.i>> j;
    public ProxyConfig k;
    public TurbonetEngine.TCPNetworkQualityStatus l;
    @GuardedBy("mDataTrafficMonitorLock")
    public final ObserverList<VersionSafeCallbacks.b> m;
    @GuardedBy("mNetworkQualityLock")
    public final ObserverList<VersionSafeCallbacks.d> n;
    public final Object o;
    @GuardedBy("mFinishedListenerLock")
    public final Map<RequestFinishedInfo.Listener, VersionSafeCallbacks.e> p;
    public volatile ConditionVariable q;
    public final String r;

    /* loaded from: classes8.dex */
    public interface f {
        long a(long j);

        void b(long j, String str);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void c(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, String str2, int i, int i2, long j2, long j3, long j4, long j5);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void d(long j, CronetUrlRequestContext cronetUrlRequestContext);

        long e(String str, String str2, boolean z, String str3, boolean z2, boolean z3, boolean z4, int i, long j, String str4, long j2, boolean z5, boolean z6, int i2);

        void f(long j, String str);

        int g(int i);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(117997000, "Lcom/baidu/turbonet/net/impl/CronetUrlRequestContext$AppThreadState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(117997000, "Lcom/baidu/turbonet/net/impl/CronetUrlRequestContext$AppThreadState;");
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

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CronetUrlRequestContext a;

        public a(CronetUrlRequestContext cronetUrlRequestContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequestContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cronetUrlRequestContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                CronetLibraryLoader.b();
                synchronized (this.a.b) {
                    xla.h().d(this.a.e, this.a);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
            synchronized (this.c.i) {
                Iterator it = this.c.m.iterator();
                while (it.hasNext()) {
                    ((VersionSafeCallbacks.b) it.next()).a(this.a, this.b);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VersionSafeCallbacks.d a;
        public final /* synthetic */ int b;

        public c(CronetUrlRequestContext cronetUrlRequestContext, VersionSafeCallbacks.d dVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequestContext, dVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
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

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VersionSafeCallbacks.d a;
        public final /* synthetic */ String b;

        public d(CronetUrlRequestContext cronetUrlRequestContext, VersionSafeCallbacks.d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequestContext, dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
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

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VersionSafeCallbacks.e a;
        public final /* synthetic */ RequestFinishedInfo b;

        public e(CronetUrlRequestContext cronetUrlRequestContext, VersionSafeCallbacks.e eVar, RequestFinishedInfo requestFinishedInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequestContext, eVar, requestFinishedInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = requestFinishedInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1541961788, "Lcom/baidu/turbonet/net/impl/CronetUrlRequestContext;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1541961788, "Lcom/baidu/turbonet/net/impl/CronetUrlRequestContext;");
                return;
            }
        }
        Pattern.compile("^((([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9])\\.)*)([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9-]*[A-Za-z0-9])$");
        x = new HashSet<>();
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (w == 0) {
                w = CronetLibraryLoader.c();
            }
            return w;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.k.a();
        }
        return invokeV.booleanValue;
    }

    @GuardedBy("mLock")
    public final void m() throws IllegalStateException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || r()) {
            return;
        }
        throw new IllegalStateException("Engine is shut down.");
    }

    public final int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (Log.isLoggable(s, 2)) {
                return -2;
            }
            if (!Log.isLoggable(s, 3)) {
                return 3;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @VisibleForTesting
    public long p() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this.b) {
                m();
                j = this.e;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this.o) {
                if (!this.p.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @GuardedBy("mLock")
    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.e != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @CalledByNative
    public void stopNetLogCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.q.open();
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.d.decrementAndGet();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.d.incrementAndGet();
        }
    }

    @UsedByReflection("TurbonetEngine.java")
    public CronetUrlRequestContext(tla tlaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tlaVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new Object();
        this.c = new ConditionVariable(false);
        this.d = new AtomicInteger(0);
        this.g = new Object();
        this.i = new Object();
        this.j = new HashMap();
        this.k = ProxyConfig.b;
        TurbonetEngine.QUICConnectStatus qUICConnectStatus = TurbonetEngine.QUICConnectStatus.UNKNOWN;
        this.l = TurbonetEngine.TCPNetworkQualityStatus.UNKNOWN;
        this.m = new ObserverList<>();
        this.n = new ObserverList<>();
        this.o = new Object();
        this.p = new HashMap();
        v = tlaVar.n();
        try {
            t = (PowerManager) tlaVar.getContext().getSystemService("power");
        } catch (Exception e2) {
            Log.e(s, e2.getMessage(), new Object[0]);
            t = null;
        }
        try {
            u = (ActivityManager) tlaVar.getContext().getSystemService("activity");
        } catch (Exception e3) {
            Log.e(s, e3.getMessage(), new Object[0]);
            u = null;
        }
        tlaVar.w();
        CronetLibraryLoader.a(tlaVar.getContext(), tlaVar);
        xla.h().g(o());
        if (tlaVar.u() == 1) {
            this.r = tlaVar.D();
            synchronized (x) {
                if (!x.add(this.r)) {
                    throw new IllegalStateException("Disk cache storage path already in use");
                }
            }
        } else {
            this.r = null;
        }
        synchronized (this.b) {
            long a2 = xla.h().a(n(tlaVar));
            this.e = a2;
            if (a2 == 0) {
                throw new NullPointerException("Context Adapter creation failed.");
            }
        }
        CronetLibraryLoader.e(new a(this));
    }

    @CalledByNative
    public static int getAppState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                if (u != null) {
                    if (t != null) {
                        if (Build.VERSION.SDK_INT >= 20) {
                            if (!t.isInteractive()) {
                                return AppThreadState.APP_THREAD_BACKGROUND.ordinal();
                            }
                        } else if (!t.isScreenOn()) {
                            return AppThreadState.APP_THREAD_BACKGROUND.ordinal();
                        }
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : u.getRunningAppProcesses()) {
                            if (runningAppProcessInfo.processName.equalsIgnoreCase(v)) {
                                if (runningAppProcessInfo.importance == 100) {
                                    return AppThreadState.APP_THREAD_FOREGROUND.ordinal();
                                }
                                return AppThreadState.APP_THREAD_BACKGROUND.ordinal();
                            }
                        }
                        return AppThreadState.APP_THREAD_BACKGROUND.ordinal();
                    }
                    throw new NullPointerException("Error: sPowerManager is null.");
                }
                throw new NullPointerException("Error: sActivityManager is null.");
            } catch (Exception e2) {
                Log.e(s, e2.getMessage(), new Object[0]);
                return AppThreadState.APP_THREAD_ERROR.ordinal();
            }
        }
        return invokeV.intValue;
    }

    @CalledByNative
    private void initNetworkThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, this, z) == null) {
            if (z) {
                this.k.b(ProxyConfig.LibType.NATIVE);
            }
            this.f = Thread.currentThread();
            this.c.open();
            Thread.currentThread().setName("TurboNet");
        }
    }

    @CalledByNative
    private void onEffectiveConnectionTypeChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, this, i) == null) {
            synchronized (this.g) {
            }
        }
    }

    @CalledByNative
    private void updateQUICConnectStatus(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65553, this, i) == null) && i >= 0 && i <= 2) {
            TurbonetEngine.QUICConnectStatus qUICConnectStatus = TurbonetEngine.QUICConnectStatus.values()[i];
        }
    }

    public boolean s(Thread thread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, thread)) == null) {
            if (thread == this.f) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void v(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, runnable) == null) {
            try {
                this.h.execute(runnable);
            } catch (RejectedExecutionException e2) {
                Log.e(s, "Exception posting task to executor", e2);
            }
        }
    }

    @CalledByNative
    private boolean isAppForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            try {
            } catch (Exception e2) {
                Log.e(s, e2.getMessage(), new Object[0]);
            }
            if (u != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : u.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.processName.equalsIgnoreCase(v)) {
                        if (runningAppProcessInfo.importance != 100) {
                            return false;
                        }
                        return true;
                    }
                }
                return false;
            }
            throw new NullPointerException("Error: sActivityManager is null.");
        }
        return invokeV.booleanValue;
    }

    @CalledByNative
    private boolean isInteractive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            try {
                if (t != null) {
                    if (Build.VERSION.SDK_INT >= 20) {
                        return t.isInteractive();
                    }
                    return t.isScreenOn();
                }
                throw new NullPointerException("Error: sPowerManager is null.");
            } catch (Exception e2) {
                Log.e(s, e2.getMessage(), new Object[0]);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @VisibleForTesting
    public static long n(tla tlaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tlaVar)) == null) {
            long e2 = xla.h().e(tlaVar.r(), tlaVar.D(), tlaVar.x(), "", tlaVar.s(), tlaVar.h(), tlaVar.i(), tlaVar.u(), tlaVar.t(), "", 0L, false, false, tlaVar.E(10));
            if (tlaVar.o() != null) {
                xla.h().f(e2, tlaVar.o());
            }
            if (tlaVar.p() != null) {
                xla.h().b(e2, tlaVar.p());
            }
            return e2;
        }
        return invokeL.longValue;
    }

    @CalledByNative
    private void onDataTrafficObservation(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65547, this, i, i2) == null) {
            v(new b(this, i, i2));
        }
    }

    @CalledByNative
    private void onGetNetworkQualityStatsComplete(NetworkQualityListener networkQualityListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, networkQualityListener, str) == null) {
            VersionSafeCallbacks.d dVar = new VersionSafeCallbacks.d(networkQualityListener);
            d dVar2 = new d(this, dVar, str);
            if (dVar.a() != null) {
                w(dVar.a(), dVar2);
                return;
            }
            throw new NullPointerException("Executor of listener is null");
        }
    }

    @CalledByNative
    private void onResolveComplete(ResolveResult resolveResult, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, this, resolveResult, str) == null) {
            synchronized (resolveResult.a()) {
                resolveResult.b(str);
                resolveResult.a().notifyAll();
            }
        }
    }

    public static void w(Executor executor, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, executor, runnable) == null) {
            try {
                executor.execute(runnable);
            } catch (RejectedExecutionException e2) {
                Log.e(s, "Exception posting task to executor", e2);
            }
        }
    }

    @CalledByNative
    private void onNetworkQualityObservation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, this, i) == null) {
            synchronized (this.g) {
                Iterator<VersionSafeCallbacks.d> it = this.n.iterator();
                while (it.hasNext()) {
                    VersionSafeCallbacks.d next = it.next();
                    c cVar = new c(this, next, i);
                    if (next.a() != null) {
                        w(next.a(), cVar);
                    } else {
                        throw new NullPointerException("Executor of listener is null");
                    }
                }
            }
            x(i);
        }
    }

    public void y(UrlRequest urlRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, urlRequest) == null) {
            synchronized (this.j) {
                VersionSafeCallbacks.i iVar = new VersionSafeCallbacks.i(urlRequest);
                HashSet<VersionSafeCallbacks.i> hashSet = this.j.get(iVar.a());
                if (hashSet == null) {
                    Log.e(s, "Remove a tagged request which is not in mTaggedRequestList", new Object[0]);
                } else {
                    hashSet.remove(iVar);
                    if (hashSet.isEmpty()) {
                        this.j.remove(iVar.a());
                    }
                }
            }
        }
    }

    public void z(RequestFinishedInfo requestFinishedInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, requestFinishedInfo) == null) {
            synchronized (this.o) {
                if (this.p.isEmpty()) {
                    return;
                }
                Iterator it = new ArrayList(this.p.values()).iterator();
                while (it.hasNext()) {
                    VersionSafeCallbacks.e eVar = (VersionSafeCallbacks.e) it.next();
                    w(eVar.a(), new e(this, eVar, requestFinishedInfo));
                }
            }
        }
    }

    @CalledByNative
    private void onRTTOrThroughputEstimatesComputed(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65551, this, i, i2, i3) == null) {
            synchronized (this.g) {
            }
        }
    }

    @Override // com.baidu.turbonet.net.ExperimentalCronetEngine, com.baidu.turbonet.net.TurbonetEngine
    public /* bridge */ /* synthetic */ UrlRequest.Builder d(String str, UrlRequest.Callback callback, Executor executor) {
        return super.f(str, callback, executor);
    }

    @Override // com.baidu.turbonet.net.TurbonetEngine
    public void e(String str, String str2, int i, int i2, long j, long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            synchronized (this.b) {
                try {
                    try {
                        m();
                        xla.h().c(this.e, this, str, str2, i, i2, j, j2, j3, j4);
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        }
    }

    @Override // com.baidu.tieba.sla
    public pma g(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, RequestFinishedInfo.Listener listener, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, callback, executor, Integer.valueOf(i), collection, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i2), Boolean.valueOf(z5), Integer.valueOf(i3), listener, Integer.valueOf(i4)})) == null) {
            synchronized (this.b) {
                try {
                    try {
                        m();
                        return new CronetUrlRequest(this, str, i, callback, executor, collection, z, z2, z3, z4, i2, z5, i3, listener, i4);
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } else {
            return (pma) invokeCommon.objValue;
        }
    }

    public void l(UrlRequest urlRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, urlRequest) == null) {
            synchronized (this.j) {
                VersionSafeCallbacks.i iVar = new VersionSafeCallbacks.i(urlRequest);
                HashSet<VersionSafeCallbacks.i> hashSet = this.j.get(iVar.a());
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    this.j.put(iVar.a(), hashSet);
                }
                hashSet.add(iVar);
            }
        }
    }

    public final void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            if (this.l != TurbonetEngine.TCPNetworkQualityStatus.WEAK && i == 7) {
                this.l = TurbonetEngine.TCPNetworkQualityStatus.NORMAL;
            } else if (i != 3 && i != 6) {
                if (i != 0 && i != 4) {
                    return;
                }
                this.l = TurbonetEngine.TCPNetworkQualityStatus.UNKNOWN;
            } else {
                this.l = TurbonetEngine.TCPNetworkQualityStatus.WEAK;
            }
        }
    }
}
