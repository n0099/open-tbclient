package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.vn2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class kt2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(it2 it2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{it2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = ht2.e();
            if (it2Var != null) {
                try {
                    e.put("page", it2Var.b);
                } catch (JSONException e2) {
                    if (y23.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", ht2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(it2 it2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, it2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (it2Var != null) {
                try {
                    jSONObject.put("isH5Componet", it2Var.g == 0 ? "0" : "1");
                } catch (JSONException e) {
                    if (y23.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(it2 it2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{it2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(it2Var, i, false, null, z, i2);
        }
    }

    public static void d(it2 it2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{it2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            re3 re3Var = new re3();
            re3Var.k(5L);
            re3Var.i(i);
            if (!m93.d || z2) {
                re3Var.f(a(it2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            z93 z93Var = new z93();
            z93Var.p(re3Var);
            z93Var.q(r93.n(x23.K().k()));
            z93Var.m(x23.K().getAppId());
            z93Var.s = it2Var.b;
            z93Var.n(false);
            y23 b0 = y23.b0();
            vn2.a W = b0 == null ? null : b0.W();
            if (!m93.d || z2) {
                z93Var.s(valueOf);
                z93Var.r(W);
                z93Var.e(b(it2Var));
                z93Var.e(y83.d().e());
                z93Var.e(y83.d().g());
            }
            r93.R(z93Var);
        }
    }
}
