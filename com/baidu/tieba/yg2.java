package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class yg2 {
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

    public yg2() {
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

    public static yg2 a(jo2 jo2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jo2Var)) == null) {
            yg2 yg2Var = new yg2();
            yg2Var.a = jo2Var.H();
            yg2Var.c = jo2Var.K();
            yg2Var.d = jo2Var.Q();
            yg2Var.f = jo2Var.G();
            yg2Var.i = jo2Var.T();
            yg2Var.h = jo2Var.p1();
            yg2Var.e = System.currentTimeMillis();
            yg2Var.g = String.valueOf(jo2Var.getType());
            yg2Var.b = jo2Var.I();
            yg2Var.j = jo2Var.v1();
            return yg2Var;
        }
        return (yg2) invokeL.objValue;
    }

    public static yg2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            yg2 yg2Var = new yg2();
            yg2Var.a = jSONObject.optString("bundle_id");
            yg2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                yg2Var.b = optJSONObject.optString("appkey");
                yg2Var.g = optJSONObject.optString("pkg_type");
                yg2Var.c = optJSONObject.optString("app_name");
                yg2Var.d = optJSONObject.optString("app_icon");
                yg2Var.j = optJSONObject.optString("version_code");
                yg2Var.f = optJSONObject.optInt("frame_type");
                yg2Var.h = optJSONObject.optInt("pay_protected");
            }
            return yg2Var;
        }
        return (yg2) invokeL.objValue;
    }
}
