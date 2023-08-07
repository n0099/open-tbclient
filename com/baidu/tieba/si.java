package com.baidu.tieba;

import android.app.Application;
import android.os.Build;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class si {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 0;
    public static int b = 3;
    public static final String[] c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448316951, "Lcom/baidu/tieba/si;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448316951, "Lcom/baidu/tieba/si;");
                return;
            }
        }
        c = new String[]{"meizu"};
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = Build.BRAND;
            if (str == null) {
                return false;
            }
            String lowerCase = str.toLowerCase();
            int i = 0;
            while (true) {
                String[] strArr = c;
                if (i >= strArr.length) {
                    return false;
                }
                if (strArr[i].equals(lowerCase)) {
                    return true;
                }
                i++;
            }
        } else {
            return invokeV.booleanValue;
        }
    }

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (app == null) {
                return "";
            }
            return app.getString(i);
        }
        return (String) invokeI.objValue;
    }
}
