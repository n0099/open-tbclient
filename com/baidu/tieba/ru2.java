package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.cp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ru2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(pu2 pu2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{pu2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = ou2.e();
            if (pu2Var != null) {
                try {
                    e.put("page", pu2Var.b);
                } catch (JSONException e2) {
                    if (f43.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", ou2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(pu2 pu2Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pu2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (pu2Var != null) {
                try {
                    if (pu2Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (f43.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(pu2 pu2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{pu2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(pu2Var, i, false, null, z, i2);
        }
    }

    public static void d(pu2 pu2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        cp2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{pu2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            yf3 yf3Var = new yf3();
            yf3Var.k(5L);
            yf3Var.i(i);
            if (!ta3.d || z2) {
                yf3Var.f(a(pu2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            gb3 gb3Var = new gb3();
            gb3Var.p(yf3Var);
            gb3Var.q(ya3.n(e43.K().k()));
            gb3Var.m(e43.K().getAppId());
            gb3Var.s = pu2Var.b;
            gb3Var.n(false);
            f43 b0 = f43.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!ta3.d || z2) {
                gb3Var.s(valueOf);
                gb3Var.r(W);
                gb3Var.e(b(pu2Var));
                gb3Var.e(fa3.d().e());
                gb3Var.e(fa3.d().g());
            }
            ya3.R(gb3Var);
        }
    }
}
