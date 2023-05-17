package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.du2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(qz2 qz2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{qz2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = pz2.e();
            if (qz2Var != null) {
                try {
                    e.put("page", qz2Var.b);
                } catch (JSONException e2) {
                    if (g93.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", pz2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(qz2 qz2Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, qz2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (qz2Var != null) {
                try {
                    if (qz2Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (g93.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(qz2 qz2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{qz2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(qz2Var, i, false, null, z, i2);
        }
    }

    public static void d(qz2 qz2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        du2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{qz2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            zk3 zk3Var = new zk3();
            zk3Var.k(5L);
            zk3Var.i(i);
            if (!uf3.d || z2) {
                zk3Var.f(a(qz2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            hg3 hg3Var = new hg3();
            hg3Var.p(zk3Var);
            hg3Var.q(zf3.n(f93.K().k()));
            hg3Var.m(f93.K().getAppId());
            hg3Var.s = qz2Var.b;
            hg3Var.n(false);
            g93 b0 = g93.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!uf3.d || z2) {
                hg3Var.s(valueOf);
                hg3Var.r(W);
                hg3Var.e(b(qz2Var));
                hg3Var.e(gf3.d().e());
                hg3Var.e(gf3.d().g());
            }
            zf3.R(hg3Var);
        }
    }
}
