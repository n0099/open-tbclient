package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.bp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qu2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(ou2 ou2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{ou2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = nu2.e();
            if (ou2Var != null) {
                try {
                    e.put("page", ou2Var.b);
                } catch (JSONException e2) {
                    if (e43.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", nu2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(ou2 ou2Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ou2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (ou2Var != null) {
                try {
                    if (ou2Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (e43.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(ou2 ou2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{ou2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(ou2Var, i, false, null, z, i2);
        }
    }

    public static void d(ou2 ou2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        bp2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{ou2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            xf3 xf3Var = new xf3();
            xf3Var.k(5L);
            xf3Var.i(i);
            if (!sa3.d || z2) {
                xf3Var.f(a(ou2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            fb3 fb3Var = new fb3();
            fb3Var.p(xf3Var);
            fb3Var.q(xa3.n(d43.K().k()));
            fb3Var.m(d43.K().getAppId());
            fb3Var.s = ou2Var.b;
            fb3Var.n(false);
            e43 b0 = e43.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!sa3.d || z2) {
                fb3Var.s(valueOf);
                fb3Var.r(W);
                fb3Var.e(b(ou2Var));
                fb3Var.e(ea3.d().e());
                fb3Var.e(ea3.d().g());
            }
            xa3.R(fb3Var);
        }
    }
}
