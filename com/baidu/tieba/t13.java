package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.ew2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class t13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(r13 r13Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{r13Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = q13.e();
            if (r13Var != null) {
                try {
                    e.put("page", r13Var.b);
                } catch (JSONException e2) {
                    if (hb3.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", q13.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(r13 r13Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, r13Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (r13Var != null) {
                try {
                    if (r13Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (hb3.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(r13 r13Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{r13Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(r13Var, i, false, null, z, i2);
        }
    }

    public static void d(r13 r13Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        ew2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{r13Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            an3 an3Var = new an3();
            an3Var.k(5L);
            an3Var.i(i);
            if (!vh3.d || z2) {
                an3Var.f(a(r13Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            ii3 ii3Var = new ii3();
            ii3Var.p(an3Var);
            ii3Var.q(ai3.n(gb3.K().k()));
            ii3Var.m(gb3.K().getAppId());
            ii3Var.s = r13Var.b;
            ii3Var.n(false);
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!vh3.d || z2) {
                ii3Var.s(valueOf);
                ii3Var.r(W);
                ii3Var.e(b(r13Var));
                ii3Var.e(hh3.d().e());
                ii3Var.e(hh3.d().g());
            }
            ai3.R(ii3Var);
        }
    }
}
