package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class p3b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "h";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948012522, "Lcom/baidu/tieba/p3b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948012522, "Lcom/baidu/tieba/p3b;");
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            Context a2 = l3b.a();
            if (a2 == null) {
                return "";
            }
            try {
                return a2.getPackageManager().getPackageInfo(str, 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                String str2 = a;
                o3b.d(str2, "getVersion NameNotFoundException : " + e.getMessage());
                return "";
            } catch (Exception e2) {
                String str3 = a;
                o3b.d(str3, "getVersion: " + e2.getMessage());
                return "";
            } catch (Throwable unused) {
                o3b.d(a, "throwable");
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
