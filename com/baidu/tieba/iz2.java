package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.tt2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class iz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(gz2 gz2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{gz2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = fz2.e();
            if (gz2Var != null) {
                try {
                    e.put("page", gz2Var.b);
                } catch (JSONException e2) {
                    if (w83.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", fz2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(gz2 gz2Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, gz2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (gz2Var != null) {
                try {
                    if (gz2Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (w83.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(gz2 gz2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{gz2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(gz2Var, i, false, null, z, i2);
        }
    }

    public static void d(gz2 gz2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        tt2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{gz2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            pk3 pk3Var = new pk3();
            pk3Var.k(5L);
            pk3Var.i(i);
            if (!kf3.d || z2) {
                pk3Var.f(a(gz2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            xf3 xf3Var = new xf3();
            xf3Var.p(pk3Var);
            xf3Var.q(pf3.n(v83.K().k()));
            xf3Var.m(v83.K().getAppId());
            xf3Var.s = gz2Var.b;
            xf3Var.n(false);
            w83 b0 = w83.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!kf3.d || z2) {
                xf3Var.s(valueOf);
                xf3Var.r(W);
                xf3Var.e(b(gz2Var));
                xf3Var.e(we3.d().e());
                xf3Var.e(we3.d().g());
            }
            pf3.R(xf3Var);
        }
    }
}
