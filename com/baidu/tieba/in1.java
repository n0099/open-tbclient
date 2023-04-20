package com.baidu.tieba;

import android.util.Log;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
/* loaded from: classes5.dex */
public class in1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            try {
                return PreferencesUtil.LEFT_MOUNT + Thread.currentThread().getName() + ZeusCrashHandler.NAME_SEPERATOR + Thread.currentThread().getId() + "] " + str2;
            } catch (Throwable th) {
                c(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            try {
                Log.d("SSOSDK", a("", str));
            } catch (Throwable th) {
                c(th);
            }
        }
    }

    public static void c(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, th) == null) {
            en1.d(th);
        }
    }
}
