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
/* loaded from: classes5.dex */
public class o {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f28039a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f28040b = "VNetLog";
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
        f28039a = Log.isLoggable("VNetLog", 2);
    }

    public static void a(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, str, objArr) == null) && f28039a) {
            Log.v(f28040b, e(str, objArr));
        }
    }

    public static void b(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, objArr) == null) {
            Log.d(f28040b, e(str, objArr));
        }
    }

    public static void c(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, objArr) == null) {
            Log.e(f28040b, e(str, objArr));
        }
    }

    public static void d(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, objArr) == null) {
            Log.wtf(f28040b, e(str, objArr));
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
            Log.e(f28040b, e(str, objArr), th);
        }
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f28041a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final List<C0315a> f28042b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f28043c;

        /* renamed from: com.bytedance.sdk.component.adnet.core.o$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0315a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final String f28044a;

            /* renamed from: b  reason: collision with root package name */
            public final long f28045b;

            /* renamed from: c  reason: collision with root package name */
            public final long f28046c;

            public C0315a(String str, long j, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Long.valueOf(j), Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28044a = str;
                this.f28045b = j;
                this.f28046c = j2;
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
            f28041a = o.f28039a;
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
            this.f28042b = new ArrayList();
            this.f28043c = false;
        }

        public synchronized void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                synchronized (this) {
                    if (!this.f28043c) {
                        this.f28042b.add(new C0315a(str, j, SystemClock.elapsedRealtime()));
                    } else {
                        throw new IllegalStateException("Marker added to finished log");
                    }
                }
            }
        }

        public void finalize() throws Throwable {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f28043c) {
                return;
            }
            a("Request on the loose");
            o.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public synchronized void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                synchronized (this) {
                    this.f28043c = true;
                    long a2 = a();
                    if (a2 <= 0) {
                        return;
                    }
                    long j = this.f28042b.get(0).f28046c;
                    o.b("(%-4d ms) %s", Long.valueOf(a2), str);
                    for (C0315a c0315a : this.f28042b) {
                        long j2 = c0315a.f28046c;
                        o.b("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(c0315a.f28045b), c0315a.f28044a);
                        j = j2;
                    }
                }
            }
        }

        private long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                if (this.f28042b.size() == 0) {
                    return 0L;
                }
                long j = this.f28042b.get(0).f28046c;
                List<C0315a> list = this.f28042b;
                return list.get(list.size() - 1).f28046c - j;
            }
            return invokeV.longValue;
        }
    }
}
