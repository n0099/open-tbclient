package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ko2 {
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

    public ko2() {
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
    public static ko2 a(@NonNull vv2 vv2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vv2Var)) == null) {
            ko2 ko2Var = new ko2();
            ko2Var.a = vv2Var.H();
            ko2Var.c = vv2Var.K();
            ko2Var.d = vv2Var.Q();
            ko2Var.f = vv2Var.G();
            ko2Var.i = vv2Var.T();
            ko2Var.h = vv2Var.p1();
            ko2Var.e = System.currentTimeMillis();
            ko2Var.g = String.valueOf(vv2Var.getType());
            ko2Var.b = vv2Var.I();
            ko2Var.j = vv2Var.v1();
            return ko2Var;
        }
        return (ko2) invokeL.objValue;
    }

    public static ko2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ko2 ko2Var = new ko2();
            ko2Var.a = jSONObject.optString("bundle_id");
            ko2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                ko2Var.b = optJSONObject.optString("appkey");
                ko2Var.g = optJSONObject.optString("pkg_type");
                ko2Var.c = optJSONObject.optString("app_name");
                ko2Var.d = optJSONObject.optString("app_icon");
                ko2Var.j = optJSONObject.optString("version_code");
                ko2Var.f = optJSONObject.optInt("frame_type");
                ko2Var.h = optJSONObject.optInt("pay_protected");
            }
            return ko2Var;
        }
        return (ko2) invokeL.objValue;
    }
}
