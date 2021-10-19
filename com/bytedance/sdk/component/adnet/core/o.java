package com.bytedance.sdk.component.adnet.core;

import android.os.SystemClock;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes9.dex */
public class o {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f64706a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f64707b = "VNetLog";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(8116738, "Lcom/bytedance/sdk/component/adnet/core/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(8116738, "Lcom/bytedance/sdk/component/adnet/core/o;");
                return;
            }
        }
        f64706a = Log.isLoggable("VNetLog", 2);
    }

    public static void a(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, str, objArr) == null) && f64706a) {
            e(str, objArr);
        }
    }

    public static void b(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, objArr) == null) {
            e(str, objArr);
        }
    }

    public static void c(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, objArr) == null) {
            e(str, objArr);
        }
    }

    public static void d(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, objArr) == null) {
            Log.wtf(f64707b, e(str, objArr));
        }
    }

    public static String e(String str, Object... objArr) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, objArr)) == null) {
            if (objArr != null) {
                str = String.format(Locale.US, str, objArr);
            }
            StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
            int i2 = 2;
            while (true) {
                if (i2 >= stackTrace.length) {
                    str2 = "<unknown>";
                    break;
                } else if (!stackTrace[i2].getClassName().equals("com.bytedance.sdk.component.adnet.VNetLog")) {
                    String className = stackTrace[i2].getClassName();
                    String substring = className.substring(className.lastIndexOf(46) + 1);
                    str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i2].getMethodName();
                    break;
                } else {
                    i2++;
                }
            }
            return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
        }
        return (String) invokeLL.objValue;
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, th, str, objArr) == null) {
            e(str, objArr);
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f64708a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final List<C1886a> f64709b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f64710c;

        /* renamed from: com.bytedance.sdk.component.adnet.core.o$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static class C1886a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final String f64711a;

            /* renamed from: b  reason: collision with root package name */
            public final long f64712b;

            /* renamed from: c  reason: collision with root package name */
            public final long f64713c;

            public C1886a(String str, long j2, long j3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Long.valueOf(j2), Long.valueOf(j3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64711a = str;
                this.f64712b = j2;
                this.f64713c = j3;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-789768411, "Lcom/bytedance/sdk/component/adnet/core/o$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-789768411, "Lcom/bytedance/sdk/component/adnet/core/o$a;");
                    return;
                }
            }
            f64708a = o.f64706a;
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f64709b = new ArrayList();
            this.f64710c = false;
        }

        public synchronized void a(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
                synchronized (this) {
                    if (!this.f64710c) {
                        this.f64709b.add(new C1886a(str, j2, SystemClock.elapsedRealtime()));
                    } else {
                        throw new IllegalStateException("Marker added to finished log");
                    }
                }
            }
        }

        public void finalize() throws Throwable {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f64710c) {
                return;
            }
            a("Request on the loose");
            o.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public synchronized void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                synchronized (this) {
                    this.f64710c = true;
                    long a2 = a();
                    if (a2 <= 0) {
                        return;
                    }
                    long j2 = this.f64709b.get(0).f64713c;
                    o.b("(%-4d ms) %s", Long.valueOf(a2), str);
                    for (C1886a c1886a : this.f64709b) {
                        long j3 = c1886a.f64713c;
                        o.b("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(c1886a.f64712b), c1886a.f64711a);
                        j2 = j3;
                    }
                }
            }
        }

        private long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                if (this.f64709b.size() == 0) {
                    return 0L;
                }
                long j2 = this.f64709b.get(0).f64713c;
                List<C1886a> list = this.f64709b;
                return list.get(list.size() - 1).f64713c - j2;
            }
            return invokeV.longValue;
        }
    }
}
