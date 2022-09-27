package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.io2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class xt2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(vt2 vt2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{vt2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = ut2.e();
            if (vt2Var != null) {
                try {
                    e.put("page", vt2Var.b);
                } catch (JSONException e2) {
                    if (l33.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", ut2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(vt2 vt2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vt2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (vt2Var != null) {
                try {
                    jSONObject.put("isH5Componet", vt2Var.g == 0 ? "0" : "1");
                } catch (JSONException e) {
                    if (l33.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(vt2 vt2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{vt2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(vt2Var, i, false, null, z, i2);
        }
    }

    public static void d(vt2 vt2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{vt2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            ef3 ef3Var = new ef3();
            ef3Var.k(5L);
            ef3Var.i(i);
            if (!z93.d || z2) {
                ef3Var.f(a(vt2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            ma3 ma3Var = new ma3();
            ma3Var.p(ef3Var);
            ma3Var.q(ea3.n(k33.K().k()));
            ma3Var.m(k33.K().getAppId());
            ma3Var.s = vt2Var.b;
            ma3Var.n(false);
            l33 b0 = l33.b0();
            io2.a W = b0 == null ? null : b0.W();
            if (!z93.d || z2) {
                ma3Var.s(valueOf);
                ma3Var.r(W);
                ma3Var.e(b(vt2Var));
                ma3Var.e(l93.d().e());
                ma3Var.e(l93.d().g());
            }
            ea3.R(ma3Var);
        }
    }
}
