package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.jo2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class yt2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(wt2 wt2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{wt2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = vt2.e();
            if (wt2Var != null) {
                try {
                    e.put("page", wt2Var.b);
                } catch (JSONException e2) {
                    if (m33.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", vt2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(wt2 wt2Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, wt2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (wt2Var != null) {
                try {
                    if (wt2Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (m33.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(wt2 wt2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{wt2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(wt2Var, i, false, null, z, i2);
        }
    }

    public static void d(wt2 wt2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        jo2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{wt2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            ff3 ff3Var = new ff3();
            ff3Var.k(5L);
            ff3Var.i(i);
            if (!aa3.d || z2) {
                ff3Var.f(a(wt2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            na3 na3Var = new na3();
            na3Var.p(ff3Var);
            na3Var.q(fa3.n(l33.K().k()));
            na3Var.m(l33.K().getAppId());
            na3Var.s = wt2Var.b;
            na3Var.n(false);
            m33 b0 = m33.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!aa3.d || z2) {
                na3Var.s(valueOf);
                na3Var.r(W);
                na3Var.e(b(wt2Var));
                na3Var.e(m93.d().e());
                na3Var.e(m93.d().g());
            }
            fa3.R(na3Var);
        }
    }
}
