package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class ji1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
            } catch (Throwable th) {
                ii1.d(th);
            }
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            a = wg1.f(context).J();
            return a;
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                zg1 zg1Var = new zg1(context);
                String c = zg1Var.c();
                if (!TextUtils.isEmpty(c)) {
                    return new String(gi1.b("30212102dicudiab".getBytes(), Base64.decode(c, 10), true), "UTF-8");
                }
                String a2 = zg1Var.a();
                if (TextUtils.isEmpty(a2)) {
                    return "";
                }
                zg1Var.b(new String(Base64.encode(gi1.a("30212102dicudiab".getBytes(), a2.getBytes("UTF-8")), 10), "UTF-8"));
                return a2;
            } catch (Throwable th) {
                ii1.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
