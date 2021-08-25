package com.baidu.util;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class LogUtil {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static LogUtil f59824a;

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f59825c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f59826b;

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
        f59825c = Boolean.FALSE;
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
        this.f59826b = context;
    }

    public static synchronized LogUtil getInstance(Context context) {
        InterceptResult invokeL;
        LogUtil logUtil;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (LogUtil.class) {
                if (f59824a == null) {
                    f59824a = new LogUtil(context);
                }
                logUtil = f59824a;
            }
            return logUtil;
        }
        return (LogUtil) invokeL.objValue;
    }

    public static void logD(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            f59825c.booleanValue();
        }
    }

    public static void logE(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            f59825c.booleanValue();
        }
    }

    public static void logI(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) {
            f59825c.booleanValue();
        }
    }

    public static void syso(Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bool) == null) && f59825c.booleanValue()) {
            System.out.println(String.valueOf(bool));
        }
    }

    public static void syso(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, obj) == null) && f59825c.booleanValue()) {
            System.out.println(String.valueOf(obj));
        }
    }

    public static void syso(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, str) == null) && f59825c.booleanValue()) {
            System.out.println(str);
        }
    }

    public void setSysoLog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            f59825c = Boolean.valueOf(z);
        }
    }
}
