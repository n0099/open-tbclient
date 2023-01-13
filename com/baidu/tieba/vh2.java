package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class vh2 {
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

    public vh2() {
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
    public static vh2 a(@NonNull gp2 gp2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, gp2Var)) == null) {
            vh2 vh2Var = new vh2();
            vh2Var.a = gp2Var.H();
            vh2Var.c = gp2Var.K();
            vh2Var.d = gp2Var.Q();
            vh2Var.f = gp2Var.G();
            vh2Var.i = gp2Var.T();
            vh2Var.h = gp2Var.p1();
            vh2Var.e = System.currentTimeMillis();
            vh2Var.g = String.valueOf(gp2Var.getType());
            vh2Var.b = gp2Var.I();
            vh2Var.j = gp2Var.v1();
            return vh2Var;
        }
        return (vh2) invokeL.objValue;
    }

    public static vh2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            vh2 vh2Var = new vh2();
            vh2Var.a = jSONObject.optString("bundle_id");
            vh2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                vh2Var.b = optJSONObject.optString("appkey");
                vh2Var.g = optJSONObject.optString("pkg_type");
                vh2Var.c = optJSONObject.optString("app_name");
                vh2Var.d = optJSONObject.optString("app_icon");
                vh2Var.j = optJSONObject.optString("version_code");
                vh2Var.f = optJSONObject.optInt("frame_type");
                vh2Var.h = optJSONObject.optInt("pay_protected");
            }
            return vh2Var;
        }
        return (vh2) invokeL.objValue;
    }
}
