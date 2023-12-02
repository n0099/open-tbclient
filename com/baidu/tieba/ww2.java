package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.hr2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ww2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(uw2 uw2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{uw2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = tw2.e();
            if (uw2Var != null) {
                try {
                    e.put("page", uw2Var.b);
                } catch (JSONException e2) {
                    if (k63.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", tw2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(uw2 uw2Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uw2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (uw2Var != null) {
                try {
                    if (uw2Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (k63.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(uw2 uw2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{uw2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(uw2Var, i, false, null, z, i2);
        }
    }

    public static void d(uw2 uw2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        hr2.a X;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{uw2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            di3 di3Var = new di3();
            di3Var.k(5L);
            di3Var.i(i);
            if (!yc3.d || z2) {
                di3Var.f(a(uw2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            ld3 ld3Var = new ld3();
            ld3Var.p(di3Var);
            ld3Var.q(dd3.n(j63.K().k()));
            ld3Var.m(j63.K().getAppId());
            ld3Var.s = uw2Var.b;
            ld3Var.n(false);
            k63 c0 = k63.c0();
            if (c0 == null) {
                X = null;
            } else {
                X = c0.X();
            }
            if (!yc3.d || z2) {
                ld3Var.s(valueOf);
                ld3Var.r(X);
                ld3Var.e(b(uw2Var));
                ld3Var.e(kc3.d().e());
                ld3Var.e(kc3.d().g());
            }
            dd3.R(ld3Var);
        }
    }
}
