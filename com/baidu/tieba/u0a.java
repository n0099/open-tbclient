package com.baidu.tieba;

import com.baidu.adp.log.DefaultLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class u0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            StringBuilder sb = new StringBuilder();
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length > 4) {
                StackTraceElement stackTraceElement = stackTrace[4];
                String methodName = stackTraceElement.getMethodName();
                sb.append(stackTraceElement.getClassName());
                sb.append(":");
                sb.append(methodName);
                sb.append(":");
            }
            sb.append(str);
            DefaultLog.getInstance().c("MainTab", sb.toString());
        }
    }
}
