package com.bytedance.sdk.component.net.utils;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class Logger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LoggerDelegate mDelegate;
    public LogLevel mLogLevel;

    /* renamed from: com.bytedance.sdk.component.net.utils.Logger$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class LogLevel {
        public static final /* synthetic */ LogLevel[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LogLevel DEBUG;
        public static final LogLevel ERROR;
        public static final LogLevel INFO;
        public static final LogLevel OFF;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-158235812, "Lcom/bytedance/sdk/component/net/utils/Logger$LogLevel;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-158235812, "Lcom/bytedance/sdk/component/net/utils/Logger$LogLevel;");
                    return;
                }
            }
            DEBUG = new LogLevel("DEBUG", 0);
            INFO = new LogLevel("INFO", 1);
            ERROR = new LogLevel("ERROR", 2);
            LogLevel logLevel = new LogLevel("OFF", 3);
            OFF = logLevel;
            $VALUES = new LogLevel[]{DEBUG, INFO, ERROR, logLevel};
        }

        public LogLevel(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static LogLevel valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LogLevel) Enum.valueOf(LogLevel.class, str) : (LogLevel) invokeL.objValue;
        }

        public static LogLevel[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LogLevel[]) $VALUES.clone() : (LogLevel[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface LoggerDelegate {
        void debug(String str, String str2);

        void error(String str, String str2);

        void error(String str, String str2, Throwable th);

        void info(String str, String str2);
    }

    /* loaded from: classes6.dex */
    public static class SingletonHolder {
        public static /* synthetic */ Interceptable $ic;
        public static final Logger instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1574570147, "Lcom/bytedance/sdk/component/net/utils/Logger$SingletonHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1574570147, "Lcom/bytedance/sdk/component/net/utils/Logger$SingletonHolder;");
                    return;
                }
            }
            instance = new Logger(null);
        }

        public SingletonHolder() {
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
    }

    public /* synthetic */ Logger(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static void debug(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) || SingletonHolder.instance.mLogLevel.compareTo(LogLevel.DEBUG) > 0) {
            return;
        }
        SingletonHolder.instance.mDelegate.debug(str, str2);
    }

    public static void error(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || SingletonHolder.instance.mLogLevel.compareTo(LogLevel.ERROR) > 0) {
            return;
        }
        SingletonHolder.instance.mDelegate.error(str, str2);
    }

    public static void info(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) || SingletonHolder.instance.mLogLevel.compareTo(LogLevel.INFO) > 0) {
            return;
        }
        SingletonHolder.instance.mDelegate.info(str, str2);
    }

    public static void resetLoggerDelegate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            synchronized (Logger.class) {
                SingletonHolder.instance.mDelegate = new DefaultLoggerDelegate();
            }
        }
    }

    public static void setLogLevel(LogLevel logLevel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, logLevel) == null) {
            synchronized (Logger.class) {
                SingletonHolder.instance.mLogLevel = logLevel;
            }
        }
    }

    public static void setLoggerDelegate(LoggerDelegate loggerDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, loggerDelegate) == null) {
            if (loggerDelegate != null) {
                synchronized (Logger.class) {
                    SingletonHolder.instance.mDelegate = loggerDelegate;
                }
                return;
            }
            throw new IllegalArgumentException("delegate MUST not be null!");
        }
    }

    public Logger() {
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
        this.mLogLevel = LogLevel.OFF;
        this.mDelegate = new DefaultLoggerDelegate();
    }

    public static void error(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65540, null, str, str2, th) == null) || SingletonHolder.instance.mLogLevel.compareTo(LogLevel.ERROR) > 0) {
            return;
        }
        SingletonHolder.instance.mDelegate.error(str, str2, th);
    }
}
