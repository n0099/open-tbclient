package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.er2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class tw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(rw2 rw2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{rw2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = qw2.e();
            if (rw2Var != null) {
                try {
                    e.put("page", rw2Var.b);
                } catch (JSONException e2) {
                    if (h63.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", qw2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(rw2 rw2Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, rw2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (rw2Var != null) {
                try {
                    if (rw2Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (h63.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(rw2 rw2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{rw2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(rw2Var, i, false, null, z, i2);
        }
    }

    public static void d(rw2 rw2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        er2.a X;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{rw2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            ai3 ai3Var = new ai3();
            ai3Var.k(5L);
            ai3Var.i(i);
            if (!vc3.d || z2) {
                ai3Var.f(a(rw2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            id3 id3Var = new id3();
            id3Var.p(ai3Var);
            id3Var.q(ad3.n(g63.K().k()));
            id3Var.m(g63.K().getAppId());
            id3Var.s = rw2Var.b;
            id3Var.n(false);
            h63 c0 = h63.c0();
            if (c0 == null) {
                X = null;
            } else {
                X = c0.X();
            }
            if (!vc3.d || z2) {
                id3Var.s(valueOf);
                id3Var.r(X);
                id3Var.e(b(rw2Var));
                id3Var.e(hc3.d().e());
                id3Var.e(hc3.d().g());
            }
            ad3.R(id3Var);
        }
    }
}
