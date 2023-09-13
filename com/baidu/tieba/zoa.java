package com.baidu.tieba;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes9.dex */
public class zoa {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Object> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948368061, "Lcom/baidu/tieba/zoa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948368061, "Lcom/baidu/tieba/zoa;");
                return;
            }
        }
        a = new TreeMap();
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            boolean z = false;
            if (context != null && str != null) {
                if (a.containsKey(str) && (a.get(str) instanceof Boolean)) {
                    return ((Boolean) a.get(str)).booleanValue();
                }
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null) {
                        bundle = applicationInfo.metaData;
                    } else {
                        bundle = null;
                    }
                    if (bundle != null) {
                        z = bundle.getBoolean(str);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
                a.put(str, Boolean.valueOf(z));
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static int b(Context context, String str) {
        InterceptResult invokeLL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            int i = 0;
            if (context != null && str != null) {
                if (a.containsKey(str) && (a.get(str) instanceof Integer)) {
                    return ((Integer) a.get(str)).intValue();
                }
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null) {
                        bundle = applicationInfo.metaData;
                    } else {
                        bundle = null;
                    }
                    if (bundle != null) {
                        i = bundle.getInt(str);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
                a.put(str, Integer.valueOf(i));
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            String str2 = null;
            if (context != null && str != null) {
                if (a.containsKey(str) && (a.get(str) instanceof String)) {
                    return (String) a.get(str);
                }
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null) {
                        bundle = applicationInfo.metaData;
                    } else {
                        bundle = null;
                    }
                    if (bundle != null) {
                        str2 = bundle.getString(str);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
                a.put(str, str2);
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }
}
