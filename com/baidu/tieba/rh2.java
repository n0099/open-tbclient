package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class rh2 {
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

    public rh2() {
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
    public static rh2 a(@NonNull cp2 cp2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cp2Var)) == null) {
            rh2 rh2Var = new rh2();
            rh2Var.a = cp2Var.H();
            rh2Var.c = cp2Var.K();
            rh2Var.d = cp2Var.Q();
            rh2Var.f = cp2Var.G();
            rh2Var.i = cp2Var.T();
            rh2Var.h = cp2Var.p1();
            rh2Var.e = System.currentTimeMillis();
            rh2Var.g = String.valueOf(cp2Var.getType());
            rh2Var.b = cp2Var.I();
            rh2Var.j = cp2Var.v1();
            return rh2Var;
        }
        return (rh2) invokeL.objValue;
    }

    public static rh2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            rh2 rh2Var = new rh2();
            rh2Var.a = jSONObject.optString("bundle_id");
            rh2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                rh2Var.b = optJSONObject.optString("appkey");
                rh2Var.g = optJSONObject.optString("pkg_type");
                rh2Var.c = optJSONObject.optString("app_name");
                rh2Var.d = optJSONObject.optString("app_icon");
                rh2Var.j = optJSONObject.optString("version_code");
                rh2Var.f = optJSONObject.optInt("frame_type");
                rh2Var.h = optJSONObject.optInt("pay_protected");
            }
            return rh2Var;
        }
        return (rh2) invokeL.objValue;
    }
}
