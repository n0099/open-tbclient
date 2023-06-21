package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p80 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] a = s80.a(str.getBytes());
            if (a != null && a.length > 2) {
                a[0] = 117;
                a[1] = 123;
            }
            return a;
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean b(Context context, JSONArray jSONArray, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, jSONArray, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (jSONArray != null && jSONArray.length() != 0) {
                t80.a("UBCUploader", "uploadjson:" + jSONArray.toString() + ", isReal:" + z + ", isSave:" + z2);
                if (z2) {
                    t80.a("UBCUploader", "save ubcdata");
                    return true;
                }
                c(context, jSONArray, z, z2, z3);
                return true;
            }
            t80.a("UBCUploader", "upload json is null");
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static void c(Context context, JSONArray jSONArray, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, jSONArray, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            JSONObject b = new q80(z, jSONArray).b();
            if (b == null) {
                t80.a("UBCUploader", "uploadJsonData is null");
                return;
            }
            byte[] a = a(b.toString());
            if (a != null && a.length >= 3) {
                t80.a("UBCUploader", "gzip success, length:" + a.length);
                t80.a("UBCUploader", "start execute http upload data");
                n80 n80Var = new n80(context);
                k80.e(context).b(context, n80Var, n80Var, a, z3);
                return;
            }
            t80.a("UBCUploader", "uploadGzip is null or uploadGzip length<3");
        }
    }
}
