package com.baidu.turbonet.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.base.BaseChromiumApplication;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@JNINamespace
/* loaded from: classes4.dex */
public class ApplicationStatus {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Object f22999a;

    /* renamed from: b  reason: collision with root package name */
    public static Integer f23000b;

    /* renamed from: c  reason: collision with root package name */
    public static Activity f23001c;

    /* renamed from: d  reason: collision with root package name */
    public static f f23002d;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<Activity, d> f23003e;

    /* renamed from: f  reason: collision with root package name */
    public static final d.a.q0.a.b<e> f23004f;

    /* renamed from: g  reason: collision with root package name */
    public static final d.a.q0.a.b<f> f23005g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements BaseChromiumApplication.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.turbonet.base.BaseChromiumApplication.c
        public void a(Activity activity, boolean z) {
            int h2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, activity, z) == null) || !z || activity == ApplicationStatus.f23001c || (h2 = ApplicationStatus.h(activity)) == 6 || h2 == 5) {
                return;
            }
            Activity unused = ApplicationStatus.f23001c = activity;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
                ApplicationStatus.j(activity, 1);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                ApplicationStatus.j(activity, 6);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
                ApplicationStatus.j(activity, 4);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
                ApplicationStatus.j(activity, 3);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
                ApplicationStatus.j(activity, 2);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
                ApplicationStatus.j(activity, 5);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.turbonet.base.ApplicationStatus.f
            public void a(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                    ApplicationStatus.nativeOnApplicationStateChange(i2);
                }
            }
        }

        public c() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && ApplicationStatus.f23002d == null) {
                f unused = ApplicationStatus.f23002d = new a(this);
                ApplicationStatus.k(ApplicationStatus.f23002d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(Activity activity, int i2);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(461310709, "Lcom/baidu/turbonet/base/ApplicationStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(461310709, "Lcom/baidu/turbonet/base/ApplicationStatus;");
                return;
            }
        }
        f22999a = new Object();
        f23003e = new ConcurrentHashMap();
        f23004f = new d.a.q0.a.b<>();
        f23005g = new d.a.q0.a.b<>();
    }

    public ApplicationStatus() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            boolean z = false;
            boolean z2 = false;
            for (d dVar : f23003e.values()) {
                int b2 = dVar.b();
                if (b2 != 4 && b2 != 5 && b2 != 6) {
                    return 1;
                }
                if (b2 == 4) {
                    z = true;
                } else if (b2 == 5) {
                    z2 = true;
                }
            }
            if (z) {
                return 2;
            }
            return z2 ? 3 : 4;
        }
        return invokeV.intValue;
    }

    @CalledByNative
    public static int getStateForApplication() {
        InterceptResult invokeV;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (f22999a) {
                if (f23000b == null) {
                    f23000b = Integer.valueOf(g());
                }
                intValue = f23000b.intValue();
            }
            return intValue;
        }
        return invokeV.intValue;
    }

    public static int h(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, activity)) == null) {
            d dVar = f23003e.get(activity);
            if (dVar != null) {
                return dVar.b();
            }
            return 6;
        }
        return invokeL.intValue;
    }

    public static void i(BaseChromiumApplication baseChromiumApplication) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, baseChromiumApplication) == null) {
            baseChromiumApplication.registerWindowFocusChangedListener(new a());
            baseChromiumApplication.registerActivityLifecycleCallbacks(new b());
        }
    }

    public static void j(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, activity, i2) == null) {
            if (activity != null) {
                if (f23001c == null || i2 == 1 || i2 == 3 || i2 == 2) {
                    f23001c = activity;
                }
                int stateForApplication = getStateForApplication();
                if (i2 == 1) {
                    f23003e.put(activity, new d(null));
                }
                synchronized (f22999a) {
                    f23000b = null;
                }
                d dVar = f23003e.get(activity);
                dVar.c(i2);
                Iterator<e> it = dVar.a().iterator();
                while (it.hasNext()) {
                    it.next().a(activity, i2);
                }
                Iterator<e> it2 = f23004f.iterator();
                while (it2.hasNext()) {
                    it2.next().a(activity, i2);
                }
                int stateForApplication2 = getStateForApplication();
                if (stateForApplication2 != stateForApplication) {
                    Iterator<f> it3 = f23005g.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(stateForApplication2);
                    }
                }
                if (i2 == 6) {
                    f23003e.remove(activity);
                    if (activity == f23001c) {
                        f23001c = null;
                        return;
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("null activity is not supported");
        }
    }

    public static void k(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, fVar) == null) {
            f23005g.e(fVar);
        }
    }

    public static native void nativeOnApplicationStateChange(int i2);

    @CalledByNative
    public static void registerThreadSafeNativeApplicationStateListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            ThreadUtils.c(new c());
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f23006a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.q0.a.b<e> f23007b;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23006a = 6;
            this.f23007b = new d.a.q0.a.b<>();
        }

        public d.a.q0.a.b<e> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23007b : (d.a.q0.a.b) invokeV.objValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23006a : invokeV.intValue;
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f23006a = i2;
            }
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }
}
