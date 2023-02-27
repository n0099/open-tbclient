package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.ju2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(wz2 wz2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{wz2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = vz2.e();
            if (wz2Var != null) {
                try {
                    e.put("page", wz2Var.b);
                } catch (JSONException e2) {
                    if (m93.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", vz2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(wz2 wz2Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, wz2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (wz2Var != null) {
                try {
                    if (wz2Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (m93.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(wz2 wz2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{wz2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(wz2Var, i, false, null, z, i2);
        }
    }

    public static void d(wz2 wz2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        ju2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{wz2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            fl3 fl3Var = new fl3();
            fl3Var.k(5L);
            fl3Var.i(i);
            if (!ag3.d || z2) {
                fl3Var.f(a(wz2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            ng3 ng3Var = new ng3();
            ng3Var.p(fl3Var);
            ng3Var.q(fg3.n(l93.K().k()));
            ng3Var.m(l93.K().getAppId());
            ng3Var.s = wz2Var.b;
            ng3Var.n(false);
            m93 b0 = m93.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!ag3.d || z2) {
                ng3Var.s(valueOf);
                ng3Var.r(W);
                ng3Var.e(b(wz2Var));
                ng3Var.e(mf3.d().e());
                ng3Var.e(mf3.d().g());
            }
            fg3.R(ng3Var);
        }
    }
}
