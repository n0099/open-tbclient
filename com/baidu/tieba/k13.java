package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.vv2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(i13 i13Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{i13Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = h13.e();
            if (i13Var != null) {
                try {
                    e.put("page", i13Var.b);
                } catch (JSONException e2) {
                    if (ya3.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", h13.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(i13 i13Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, i13Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (i13Var != null) {
                try {
                    if (i13Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (ya3.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(i13 i13Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{i13Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(i13Var, i, false, null, z, i2);
        }
    }

    public static void d(i13 i13Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        vv2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{i13Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            rm3 rm3Var = new rm3();
            rm3Var.k(5L);
            rm3Var.i(i);
            if (!mh3.d || z2) {
                rm3Var.f(a(i13Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            zh3 zh3Var = new zh3();
            zh3Var.p(rm3Var);
            zh3Var.q(rh3.n(xa3.K().k()));
            zh3Var.m(xa3.K().getAppId());
            zh3Var.s = i13Var.b;
            zh3Var.n(false);
            ya3 b0 = ya3.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!mh3.d || z2) {
                zh3Var.s(valueOf);
                zh3Var.r(W);
                zh3Var.e(b(i13Var));
                zh3Var.e(yg3.d().e());
                zh3Var.e(yg3.d().g());
            }
            rh3.R(zh3Var);
        }
    }
}
