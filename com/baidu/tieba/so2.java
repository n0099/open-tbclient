package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class so2 {
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

    public so2() {
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
    public static so2 a(@NonNull dw2 dw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dw2Var)) == null) {
            so2 so2Var = new so2();
            so2Var.a = dw2Var.H();
            so2Var.c = dw2Var.K();
            so2Var.d = dw2Var.Q();
            so2Var.f = dw2Var.G();
            so2Var.i = dw2Var.T();
            so2Var.h = dw2Var.p1();
            so2Var.e = System.currentTimeMillis();
            so2Var.g = String.valueOf(dw2Var.getType());
            so2Var.b = dw2Var.I();
            so2Var.j = dw2Var.v1();
            return so2Var;
        }
        return (so2) invokeL.objValue;
    }

    public static so2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            so2 so2Var = new so2();
            so2Var.a = jSONObject.optString("bundle_id");
            so2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                so2Var.b = optJSONObject.optString("appkey");
                so2Var.g = optJSONObject.optString("pkg_type");
                so2Var.c = optJSONObject.optString("app_name");
                so2Var.d = optJSONObject.optString("app_icon");
                so2Var.j = optJSONObject.optString("version_code");
                so2Var.f = optJSONObject.optInt("frame_type");
                so2Var.h = optJSONObject.optInt("pay_protected");
            }
            return so2Var;
        }
        return (so2) invokeL.objValue;
    }
}
