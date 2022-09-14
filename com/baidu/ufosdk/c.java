package com.baidu.ufosdk;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public static String b = "";
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                if (TextUtils.isEmpty(b)) {
                    return b.i(b.d()).getString("app_pkg", "");
                }
                return b;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                if (TextUtils.isEmpty(a)) {
                    return b.i(b.d()).getString("app_vn", "");
                }
                return a;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
