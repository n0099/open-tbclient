package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class oqb {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "h";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948042313, "Lcom/baidu/tieba/oqb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948042313, "Lcom/baidu/tieba/oqb;");
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            Context a2 = kqb.a();
            if (a2 == null) {
                return "";
            }
            try {
                return a2.getPackageManager().getPackageInfo(str, 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                String str2 = a;
                nqb.d(str2, "getVersion NameNotFoundException : " + e.getMessage());
                return "";
            } catch (Exception e2) {
                String str3 = a;
                nqb.d(str3, "getVersion: " + e2.getMessage());
                return "";
            } catch (Throwable unused) {
                nqb.d(a, "throwable");
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
