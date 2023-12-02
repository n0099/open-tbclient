package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
/* loaded from: classes9.dex */
public class yj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948332008, "Lcom/baidu/tieba/yj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948332008, "Lcom/baidu/tieba/yj2;");
                return;
            }
        }
        boolean z = vm1.a;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String[] b = ki4.a().b();
            k32.b("SwanHistoryQueryHelper", "no history app list: " + Arrays.toString(b));
            if (b != null && b.length != 0 && (str == null || !str.equals("sync_state=?"))) {
                if (str != null && str.trim().length() > 0) {
                    str2 = String.format("(%s) AND ", str.trim());
                } else {
                    str2 = "";
                }
                String format = String.format("%s %s NOT IN ('%s')", str2, String.format("%s.%s", "ai_apps_history", "app_id"), TextUtils.join("','", b));
                k32.b("SwanHistoryQueryHelper", "origin Selection: " + str + ", created selection: " + format);
                return format;
            }
            k32.b("SwanHistoryQueryHelper", "origin Selection: " + str + ", created selection: " + str);
            return str;
        }
        return (String) invokeL.objValue;
    }
}
