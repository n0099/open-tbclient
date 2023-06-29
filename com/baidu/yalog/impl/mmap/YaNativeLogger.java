package com.baidu.yalog.impl.mmap;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class YaNativeLogger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static native void createLogSnapShot(long j, long j2, String str, String str2, boolean z, boolean z2, String str3, List<String> list);

    public static native void flush(String str, boolean z);

    public static native void log(String str, String str2, String str3, String str4, String str5);

    public static native void queryLogFiles(long j, long j2, String str, String str2, List<String> list);

    public static native void requestCleanOverQuotaLog();

    public static native void setBaseDir(String str);

    public static native void setDefaultLogIdEnable(boolean z);

    public static native void setDefaultLogIdMaxSize(long j);

    public static native void setDefaultMaxAliveTimeForSpace(long j);

    public static native void setDefaultSpaceEnable(boolean z);

    public static native void setDefaultSpaceMaxSize(long j);

    public static native void setLogIdEnable(String str, boolean z);

    public static native void setLogIdMaxSize(String str, long j);

    public static native void setMainController(boolean z);

    public static native void setMaxAliveTimeForSpace(String str, long j);

    public static native void setMaxSizeAllLogFile(long j);

    public static native void setMaxSizePerLogFile(long j);

    public static native void setProcessName(String str);

    public static native void setSpaceEnable(String str, boolean z);

    public static native void setSpaceMaxSize(String str, long j);

    public static native void start();

    public static native void stop();

    public YaNativeLogger() {
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

    public static void a() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            System.loadLibrary("yalog");
        }
    }

    public static boolean b(String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, str, str2, str3, str4, str5)) == null) {
            try {
                log(str, str2, str3, str4, str5);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }
}
