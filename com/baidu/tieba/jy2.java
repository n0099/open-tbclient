package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.us2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class jy2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(hy2 hy2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{hy2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = gy2.e();
            if (hy2Var != null) {
                try {
                    e.put("page", hy2Var.b);
                } catch (JSONException e2) {
                    if (x73.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", gy2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(hy2 hy2Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hy2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (hy2Var != null) {
                try {
                    if (hy2Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (x73.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(hy2 hy2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{hy2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(hy2Var, i, false, null, z, i2);
        }
    }

    public static void d(hy2 hy2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        us2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{hy2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            qj3 qj3Var = new qj3();
            qj3Var.k(5L);
            qj3Var.i(i);
            if (!le3.d || z2) {
                qj3Var.f(a(hy2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            ye3 ye3Var = new ye3();
            ye3Var.p(qj3Var);
            ye3Var.q(qe3.n(w73.K().k()));
            ye3Var.m(w73.K().getAppId());
            ye3Var.s = hy2Var.b;
            ye3Var.n(false);
            x73 b0 = x73.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!le3.d || z2) {
                ye3Var.s(valueOf);
                ye3Var.r(W);
                ye3Var.e(b(hy2Var));
                ye3Var.e(xd3.d().e());
                ye3Var.e(xd3.d().g());
            }
            qe3.R(ye3Var);
        }
    }
}
