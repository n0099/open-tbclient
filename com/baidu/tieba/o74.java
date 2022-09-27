package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.swan.hide.api.bypass.NativeHideApiBypass;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class o74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, obj, str)) == null) ? (obj == null || TextUtils.isEmpty(str)) ? false : true : invokeLL.booleanValue;
    }

    public static Method b(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, obj, str, clsArr)) == null) {
            if (a(obj, str)) {
                if (n74.g()) {
                    return NativeHideApiBypass.getDeclaredMethod(obj, str, clsArr);
                }
                return (Method) Class.class.getMethod("getDeclaredMethod", String.class, Class[].class).invoke(obj, str, clsArr);
            }
            return null;
        }
        return (Method) invokeLLL.objValue;
    }
}
