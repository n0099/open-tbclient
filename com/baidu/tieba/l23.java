package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.ww2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(j23 j23Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{j23Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = i23.e();
            if (j23Var != null) {
                try {
                    e.put("page", j23Var.b);
                } catch (JSONException e2) {
                    if (zb3.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", i23.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(j23 j23Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, j23Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (j23Var != null) {
                try {
                    if (j23Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (zb3.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(j23 j23Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{j23Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(j23Var, i, false, null, z, i2);
        }
    }

    public static void d(j23 j23Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        ww2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{j23Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            sn3 sn3Var = new sn3();
            sn3Var.k(5L);
            sn3Var.i(i);
            if (!ni3.d || z2) {
                sn3Var.f(a(j23Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            aj3 aj3Var = new aj3();
            aj3Var.p(sn3Var);
            aj3Var.q(si3.n(yb3.K().k()));
            aj3Var.m(yb3.K().getAppId());
            aj3Var.s = j23Var.b;
            aj3Var.n(false);
            zb3 b0 = zb3.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!ni3.d || z2) {
                aj3Var.s(valueOf);
                aj3Var.r(W);
                aj3Var.e(b(j23Var));
                aj3Var.e(zh3.d().e());
                aj3Var.e(zh3.d().g());
            }
            si3.R(aj3Var);
        }
    }
}
