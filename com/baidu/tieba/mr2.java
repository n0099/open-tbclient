package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.xl2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class mr2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(kr2 kr2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{kr2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = jr2.e();
            if (kr2Var != null) {
                try {
                    e.put("page", kr2Var.b);
                } catch (JSONException e2) {
                    if (a13.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", jr2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(kr2 kr2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, kr2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (kr2Var != null) {
                try {
                    jSONObject.put("isH5Componet", kr2Var.g == 0 ? "0" : "1");
                } catch (JSONException e) {
                    if (a13.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(kr2 kr2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{kr2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(kr2Var, i, false, null, z, i2);
        }
    }

    public static void d(kr2 kr2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{kr2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            tc3 tc3Var = new tc3();
            tc3Var.k(5L);
            tc3Var.i(i);
            if (!o73.d || z2) {
                tc3Var.f(a(kr2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            b83 b83Var = new b83();
            b83Var.p(tc3Var);
            b83Var.q(t73.n(z03.K().k()));
            b83Var.m(z03.K().getAppId());
            b83Var.s = kr2Var.b;
            b83Var.n(false);
            a13 b0 = a13.b0();
            xl2.a W = b0 == null ? null : b0.W();
            if (!o73.d || z2) {
                b83Var.s(valueOf);
                b83Var.r(W);
                b83Var.e(b(kr2Var));
                b83Var.e(a73.d().e());
                b83Var.e(a73.d().g());
            }
            t73.R(b83Var);
        }
    }
}
