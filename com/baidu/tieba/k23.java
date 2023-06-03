package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.vw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(i23 i23Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{i23Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = h23.e();
            if (i23Var != null) {
                try {
                    e.put("page", i23Var.b);
                } catch (JSONException e2) {
                    if (yb3.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", h23.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(i23 i23Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, i23Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (i23Var != null) {
                try {
                    if (i23Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (yb3.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(i23 i23Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{i23Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(i23Var, i, false, null, z, i2);
        }
    }

    public static void d(i23 i23Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        vw2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{i23Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            rn3 rn3Var = new rn3();
            rn3Var.k(5L);
            rn3Var.i(i);
            if (!mi3.d || z2) {
                rn3Var.f(a(i23Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            zi3 zi3Var = new zi3();
            zi3Var.p(rn3Var);
            zi3Var.q(ri3.n(xb3.K().k()));
            zi3Var.m(xb3.K().getAppId());
            zi3Var.s = i23Var.b;
            zi3Var.n(false);
            yb3 b0 = yb3.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!mi3.d || z2) {
                zi3Var.s(valueOf);
                zi3Var.r(W);
                zi3Var.e(b(i23Var));
                zi3Var.e(yh3.d().e());
                zi3Var.e(yh3.d().g());
            }
            ri3.R(zi3Var);
        }
    }
}
