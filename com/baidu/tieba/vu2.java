package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.gp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class vu2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(tu2 tu2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{tu2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = su2.e();
            if (tu2Var != null) {
                try {
                    e.put("page", tu2Var.b);
                } catch (JSONException e2) {
                    if (j43.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", su2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(tu2 tu2Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tu2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (tu2Var != null) {
                try {
                    if (tu2Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (j43.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(tu2 tu2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{tu2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(tu2Var, i, false, null, z, i2);
        }
    }

    public static void d(tu2 tu2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        gp2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{tu2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            cg3 cg3Var = new cg3();
            cg3Var.k(5L);
            cg3Var.i(i);
            if (!xa3.d || z2) {
                cg3Var.f(a(tu2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            kb3 kb3Var = new kb3();
            kb3Var.p(cg3Var);
            kb3Var.q(cb3.n(i43.K().k()));
            kb3Var.m(i43.K().getAppId());
            kb3Var.s = tu2Var.b;
            kb3Var.n(false);
            j43 b0 = j43.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!xa3.d || z2) {
                kb3Var.s(valueOf);
                kb3Var.r(W);
                kb3Var.e(b(tu2Var));
                kb3Var.e(ja3.d().e());
                kb3Var.e(ja3.d().g());
            }
            cb3.R(kb3Var);
        }
    }
}
