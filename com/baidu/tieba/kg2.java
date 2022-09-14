package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class kg2 {
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

    public kg2() {
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
    public static kg2 a(@NonNull vn2 vn2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vn2Var)) == null) {
            kg2 kg2Var = new kg2();
            kg2Var.a = vn2Var.H();
            kg2Var.c = vn2Var.K();
            kg2Var.d = vn2Var.Q();
            kg2Var.f = vn2Var.G();
            kg2Var.i = vn2Var.T();
            kg2Var.h = vn2Var.p1();
            kg2Var.e = System.currentTimeMillis();
            kg2Var.g = String.valueOf(vn2Var.getType());
            kg2Var.b = vn2Var.I();
            kg2Var.j = vn2Var.v1();
            return kg2Var;
        }
        return (kg2) invokeL.objValue;
    }

    public static kg2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            kg2 kg2Var = new kg2();
            kg2Var.a = jSONObject.optString("bundle_id");
            kg2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                kg2Var.b = optJSONObject.optString("appkey");
                kg2Var.g = optJSONObject.optString("pkg_type");
                kg2Var.c = optJSONObject.optString("app_name");
                kg2Var.d = optJSONObject.optString("app_icon");
                kg2Var.j = optJSONObject.optString("version_code");
                kg2Var.f = optJSONObject.optInt("frame_type");
                kg2Var.h = optJSONObject.optInt("pay_protected");
            }
            return kg2Var;
        }
        return (kg2) invokeL.objValue;
    }
}
