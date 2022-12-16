package com.baidu.ufosdk;

import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
/* loaded from: classes7.dex */
public class u1 {
    public static /* synthetic */ Interceptable $ic;
    public static Method a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1174246874, "Lcom/baidu/ufosdk/u1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1174246874, "Lcom/baidu/ufosdk/u1;");
                return;
            }
        }
        try {
            a = SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
        } catch (Exception unused) {
            a = null;
        }
        try {
            Class[] clsArr = {String.class, Set.class};
            SharedPreferences.class.getMethod("getStringSet", clsArr);
            SharedPreferences.Editor.class.getMethod("putStringSet", clsArr);
        } catch (Exception unused2) {
        }
    }

    public static void a(SharedPreferences.Editor editor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, editor) == null) {
            Method method = a;
            if (method != null) {
                try {
                    method.invoke(editor, new Object[0]);
                    return;
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            editor.commit();
        }
    }
}
