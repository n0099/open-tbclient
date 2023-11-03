package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.dr2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class sw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(qw2 qw2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{qw2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = pw2.e();
            if (qw2Var != null) {
                try {
                    e.put("page", qw2Var.b);
                } catch (JSONException e2) {
                    if (g63.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", pw2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(qw2 qw2Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, qw2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (qw2Var != null) {
                try {
                    if (qw2Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (g63.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(qw2 qw2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{qw2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(qw2Var, i, false, null, z, i2);
        }
    }

    public static void d(qw2 qw2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        dr2.a X;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{qw2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            zh3 zh3Var = new zh3();
            zh3Var.k(5L);
            zh3Var.i(i);
            if (!uc3.d || z2) {
                zh3Var.f(a(qw2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            hd3 hd3Var = new hd3();
            hd3Var.p(zh3Var);
            hd3Var.q(zc3.n(f63.K().k()));
            hd3Var.m(f63.K().getAppId());
            hd3Var.s = qw2Var.b;
            hd3Var.n(false);
            g63 c0 = g63.c0();
            if (c0 == null) {
                X = null;
            } else {
                X = c0.X();
            }
            if (!uc3.d || z2) {
                hd3Var.s(valueOf);
                hd3Var.r(X);
                hd3Var.e(b(qw2Var));
                hd3Var.e(gc3.d().e());
                hd3Var.e(gc3.d().g());
            }
            zc3.R(hd3Var);
        }
    }
}
