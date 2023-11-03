package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class sj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public long e;
    public int f;
    public String g;
    public int h;
    public String i;
    public String j;

    public sj2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    public static sj2 a(@NonNull dr2 dr2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dr2Var)) == null) {
            sj2 sj2Var = new sj2();
            sj2Var.a = dr2Var.I();
            sj2Var.c = dr2Var.L();
            sj2Var.d = dr2Var.R();
            sj2Var.f = dr2Var.H();
            sj2Var.i = dr2Var.U();
            sj2Var.h = dr2Var.q1();
            sj2Var.e = System.currentTimeMillis();
            sj2Var.g = String.valueOf(dr2Var.w1());
            sj2Var.b = dr2Var.J();
            sj2Var.j = dr2Var.x1();
            return sj2Var;
        }
        return (sj2) invokeL.objValue;
    }

    public static sj2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            sj2 sj2Var = new sj2();
            sj2Var.a = jSONObject.optString("bundle_id");
            sj2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                sj2Var.b = optJSONObject.optString("appkey");
                sj2Var.g = optJSONObject.optString("pkg_type");
                sj2Var.c = optJSONObject.optString("app_name");
                sj2Var.d = optJSONObject.optString("app_icon");
                sj2Var.j = optJSONObject.optString("version_code");
                sj2Var.f = optJSONObject.optInt("frame_type");
                sj2Var.h = optJSONObject.optInt("pay_protected");
            }
            return sj2Var;
        }
        return (sj2) invokeL.objValue;
    }
}
