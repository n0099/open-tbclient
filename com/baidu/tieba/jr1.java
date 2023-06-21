package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class jr1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
            } catch (Throwable th) {
                ir1.d(th);
            }
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            a = sp1.g(context).F();
            return a;
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                if (!TextUtils.isEmpty(b)) {
                    return b;
                }
                String c = c(context);
                b = c;
                if (!TextUtils.isEmpty(c)) {
                    return b;
                }
                String a2 = new vp1(context).a();
                b = a2;
                if (!TextUtils.isEmpty(a2)) {
                    return b;
                }
                return "";
            } catch (Throwable th) {
                ir1.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                Class<?> cls = Class.forName("com.baidu.sofire.ac.F");
                Object invoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(cls, new Object[0]);
                if (invoke == null) {
                    return "";
                }
                return (String) cls.getDeclaredMethod("gzd", Context.class).invoke(invoke, context);
            } catch (Throwable th) {
                ir1.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
