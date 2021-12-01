package com.baidu.util;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class LogUtil {
    public static /* synthetic */ Interceptable $ic;
    public static LogUtil a;

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f51777c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f51778b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-22248748, "Lcom/baidu/util/LogUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-22248748, "Lcom/baidu/util/LogUtil;");
                return;
            }
        }
        f51777c = Boolean.FALSE;
    }

    public LogUtil(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51778b = context;
    }

    public static synchronized LogUtil getInstance(Context context) {
        InterceptResult invokeL;
        LogUtil logUtil;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (LogUtil.class) {
                if (a == null) {
                    a = new LogUtil(context);
                }
                logUtil = a;
            }
            return logUtil;
        }
        return (LogUtil) invokeL.objValue;
    }

    public static void logD(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            f51777c.booleanValue();
        }
    }

    public static void logE(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            f51777c.booleanValue();
        }
    }

    public static void logI(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) {
            f51777c.booleanValue();
        }
    }

    public static void syso(Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, bool) == null) && f51777c.booleanValue()) {
            System.out.println(String.valueOf(bool));
        }
    }

    public static void syso(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, obj) == null) && f51777c.booleanValue()) {
            System.out.println(String.valueOf(obj));
        }
    }

    public static void syso(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, str) == null) && f51777c.booleanValue()) {
            System.out.println(str);
        }
    }

    public void setSysoLog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            f51777c = Boolean.valueOf(z);
        }
    }
}
