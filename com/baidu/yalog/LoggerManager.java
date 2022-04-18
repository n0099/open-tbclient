package com.baidu.yalog;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pe9;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class LoggerManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_SPACE = "default";
    public static final b a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b extends Logger {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.yalog.Logger
        public void executeRunnable(@NonNull Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            }
        }

        @Override // com.baidu.yalog.Logger
        public void flush(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // com.baidu.yalog.Logger
        public void log(String str, int i, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, str, i, str2, str3) == null) {
            }
        }

        @Override // com.baidu.yalog.Logger
        public void logSync(String str, int i, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048579, this, str, i, str2, str3) == null) {
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, Logger> a;

        public c() {
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
            this.a = new ConcurrentHashMap();
        }

        public abstract List<String> a(long j, long j2, String str, String str2, boolean z, boolean z2, String str3);

        public abstract String b();

        public Logger c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                Logger logger = this.a.get(str);
                if (logger == null) {
                    synchronized (this) {
                        logger = this.a.get(str);
                        if (logger == null) {
                            logger = d(str);
                            this.a.put(str, logger);
                        }
                    }
                }
                return logger;
            }
            return (Logger) invokeL.objValue;
        }

        public abstract Logger d(String str);

        public abstract List<String> e(long j, long j2, String str, String str2);

        public abstract void f();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-601737409, "Lcom/baidu/yalog/LoggerManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-601737409, "Lcom/baidu/yalog/LoggerManager;");
                return;
            }
        }
        a = new b(null);
    }

    public LoggerManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static List<String> createLogSnapShot(long j, long j2, String str, String str2, boolean z, boolean z2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), str3})) == null) {
            c a2 = pe9.a();
            if (a2 != null) {
                return a2.a(j, j2, str, str2, z, z2, str3);
            }
            return null;
        }
        return (List) invokeCommon.objValue;
    }

    public static String getBaseDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            c a2 = pe9.a();
            if (a2 != null) {
                String b2 = a2.b();
                return !TextUtils.isEmpty(b2) ? b2 : "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static Logger getDefaultLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? getLogger("default") : (Logger) invokeV.objValue;
    }

    public static Logger getLogger(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            c a2 = pe9.a();
            Logger c2 = a2 != null ? a2.c(str) : null;
            return c2 != null ? c2 : a;
        }
        return (Logger) invokeL.objValue;
    }

    public static List<String> queryLogFiles(long j, long j2, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2})) == null) {
            c a2 = pe9.a();
            if (a2 != null) {
                return a2.e(j, j2, str, str2);
            }
            return new ArrayList();
        }
        return (List) invokeCommon.objValue;
    }

    public static void requestCleanOverQuotaLog() {
        c a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, null) == null) || (a2 = pe9.a()) == null) {
            return;
        }
        a2.f();
    }
}
