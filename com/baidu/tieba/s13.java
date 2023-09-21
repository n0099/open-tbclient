package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.dw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class s13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(q13 q13Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{q13Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = p13.e();
            if (q13Var != null) {
                try {
                    e.put("page", q13Var.b);
                } catch (JSONException e2) {
                    if (gb3.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", p13.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(q13 q13Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, q13Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (q13Var != null) {
                try {
                    if (q13Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (gb3.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(q13 q13Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{q13Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(q13Var, i, false, null, z, i2);
        }
    }

    public static void d(q13 q13Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        dw2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{q13Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            zm3 zm3Var = new zm3();
            zm3Var.k(5L);
            zm3Var.i(i);
            if (!uh3.d || z2) {
                zm3Var.f(a(q13Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            hi3 hi3Var = new hi3();
            hi3Var.p(zm3Var);
            hi3Var.q(zh3.n(fb3.K().k()));
            hi3Var.m(fb3.K().getAppId());
            hi3Var.s = q13Var.b;
            hi3Var.n(false);
            gb3 b0 = gb3.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!uh3.d || z2) {
                hi3Var.s(valueOf);
                hi3Var.r(W);
                hi3Var.e(b(q13Var));
                hi3Var.e(gh3.d().e());
                hi3Var.e(gh3.d().g());
            }
            zh3.R(hi3Var);
        }
    }
}
