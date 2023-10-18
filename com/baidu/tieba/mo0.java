package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes7.dex */
public final class mo0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (!TextUtils.equals(str, "GET") && !TextUtils.equals(str, "HEAD")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.equals(str, "POST") && !TextUtils.equals(str, "PATCH") && !TextUtils.equals(str, HttpPut.METHOD_NAME) && !TextUtils.equals(str, "PROPPATCH") && !TextUtils.equals(str, "REPORT")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
