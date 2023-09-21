package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class mg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                return Process.is64Bit();
            }
            if (i >= 21) {
                return c(context);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                String[] strArr = Build.SUPPORTED_ABIS;
                if (strArr.length > 0) {
                    str = strArr[0];
                } else {
                    str = null;
                }
            } else {
                str = Build.CPU_ABI;
            }
            if (str == null || !str.contains("arm64")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return false;
            }
            try {
                Object invoke = ClassLoader.class.getDeclaredMethod("findLibrary", String.class).invoke(context.getClassLoader(), "art");
                if (invoke == null) {
                    return false;
                }
                return ((String) invoke).contains("lib64");
            } catch (Exception unused) {
                return b();
            }
        }
        return invokeL.booleanValue;
    }
}
