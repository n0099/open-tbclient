package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.aw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(n13 n13Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{n13Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = m13.e();
            if (n13Var != null) {
                try {
                    e.put("page", n13Var.b);
                } catch (JSONException e2) {
                    if (db3.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", m13.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(n13 n13Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, n13Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (n13Var != null) {
                try {
                    if (n13Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (db3.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(n13 n13Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{n13Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(n13Var, i, false, null, z, i2);
        }
    }

    public static void d(n13 n13Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        aw2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{n13Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            wm3 wm3Var = new wm3();
            wm3Var.k(5L);
            wm3Var.i(i);
            if (!rh3.d || z2) {
                wm3Var.f(a(n13Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            ei3 ei3Var = new ei3();
            ei3Var.p(wm3Var);
            ei3Var.q(wh3.n(cb3.K().k()));
            ei3Var.m(cb3.K().getAppId());
            ei3Var.s = n13Var.b;
            ei3Var.n(false);
            db3 b0 = db3.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!rh3.d || z2) {
                ei3Var.s(valueOf);
                ei3Var.r(W);
                ei3Var.e(b(n13Var));
                ei3Var.e(dh3.d().e());
                ei3Var.e(dh3.d().g());
            }
            wh3.R(ei3Var);
        }
    }
}
