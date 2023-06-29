package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class op2 {
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

    public op2() {
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
    public static op2 a(@NonNull zw2 zw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, zw2Var)) == null) {
            op2 op2Var = new op2();
            op2Var.a = zw2Var.H();
            op2Var.c = zw2Var.K();
            op2Var.d = zw2Var.Q();
            op2Var.f = zw2Var.G();
            op2Var.i = zw2Var.T();
            op2Var.h = zw2Var.p1();
            op2Var.e = System.currentTimeMillis();
            op2Var.g = String.valueOf(zw2Var.getType());
            op2Var.b = zw2Var.I();
            op2Var.j = zw2Var.v1();
            return op2Var;
        }
        return (op2) invokeL.objValue;
    }

    public static op2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            op2 op2Var = new op2();
            op2Var.a = jSONObject.optString("bundle_id");
            op2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                op2Var.b = optJSONObject.optString("appkey");
                op2Var.g = optJSONObject.optString("pkg_type");
                op2Var.c = optJSONObject.optString("app_name");
                op2Var.d = optJSONObject.optString("app_icon");
                op2Var.j = optJSONObject.optString("version_code");
                op2Var.f = optJSONObject.optInt("frame_type");
                op2Var.h = optJSONObject.optInt("pay_protected");
            }
            return op2Var;
        }
        return (op2) invokeL.objValue;
    }
}
