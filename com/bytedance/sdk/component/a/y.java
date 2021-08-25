package com.bytedance.sdk.component.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f64016a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? "" : (String) invokeV.objValue;
    }

    public static String a(@Nullable Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, th)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("{\"code\":");
            sb.append(th instanceof s ? ((s) th).f63984a : 0);
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "{\"code\":1}";
            }
            String substring = f64016a ? str.substring(1, str.length() - 1) : "";
            String str2 = "{\"code\":1,\"__data\":" + str;
            if (!substring.isEmpty()) {
                return str2 + "," + substring + "}";
            }
            return str2 + "}";
        }
        return (String) invokeL.objValue;
    }

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            f64016a = z;
        }
    }
}
