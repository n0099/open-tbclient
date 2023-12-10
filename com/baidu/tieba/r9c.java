package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class r9c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public r9c() {
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

    public static void b(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, str, str2, th) == null) || str2.length() <= 4000) {
            return;
        }
        int i = 0;
        while (i < str2.length()) {
            int i2 = i + 4000;
            if (i2 < str2.length()) {
                str2.substring(i, i2);
            } else {
                str2.substring(i);
            }
            i = i2;
        }
    }

    public static void a(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
            int i = 2;
            while (true) {
                if (i < stackTrace.length) {
                    if (!stackTrace[i].getClass().equals(r9c.class)) {
                        String className = stackTrace[i].getClassName();
                        str2 = className.substring(className.lastIndexOf(46) + 1);
                        break;
                    }
                    i++;
                } else {
                    str2 = "";
                    break;
                }
            }
            b("HonorPush_" + str2, str, null);
        }
    }
}
