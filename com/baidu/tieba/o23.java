package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.zw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(m23 m23Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{m23Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = l23.e();
            if (m23Var != null) {
                try {
                    e.put("page", m23Var.b);
                } catch (JSONException e2) {
                    if (cc3.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", l23.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(m23 m23Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, m23Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (m23Var != null) {
                try {
                    if (m23Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (cc3.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(m23 m23Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{m23Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(m23Var, i, false, null, z, i2);
        }
    }

    public static void d(m23 m23Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        zw2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{m23Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            vn3 vn3Var = new vn3();
            vn3Var.k(5L);
            vn3Var.i(i);
            if (!qi3.d || z2) {
                vn3Var.f(a(m23Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            dj3 dj3Var = new dj3();
            dj3Var.p(vn3Var);
            dj3Var.q(vi3.n(bc3.K().k()));
            dj3Var.m(bc3.K().getAppId());
            dj3Var.s = m23Var.b;
            dj3Var.n(false);
            cc3 b0 = cc3.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!qi3.d || z2) {
                dj3Var.s(valueOf);
                dj3Var.r(W);
                dj3Var.e(b(m23Var));
                dj3Var.e(ci3.d().e());
                dj3Var.e(ci3.d().g());
            }
            vi3.R(dj3Var);
        }
    }
}
