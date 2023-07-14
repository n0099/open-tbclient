package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class y13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948277262, "Lcom/baidu/tieba/y13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948277262, "Lcom/baidu/tieba/y13;");
                return;
            }
        }
        a = fs1.a;
    }

    public static String a(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pMSAppInfo)) == null) {
            if (pMSAppInfo == null) {
                if (a) {
                    Log.e("AppInfoExt", "appInfo can not be null, please check");
                    return "";
                }
                return "";
            }
            String str = pMSAppInfo.serverExt;
            if (a) {
                Log.d("AppInfoExt", "appId - " + pMSAppInfo.appId + ",get app info' ext - " + str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
