package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class to2 {
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

    public to2() {
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
    public static to2 a(@NonNull ew2 ew2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ew2Var)) == null) {
            to2 to2Var = new to2();
            to2Var.a = ew2Var.H();
            to2Var.c = ew2Var.K();
            to2Var.d = ew2Var.Q();
            to2Var.f = ew2Var.G();
            to2Var.i = ew2Var.T();
            to2Var.h = ew2Var.p1();
            to2Var.e = System.currentTimeMillis();
            to2Var.g = String.valueOf(ew2Var.getType());
            to2Var.b = ew2Var.I();
            to2Var.j = ew2Var.v1();
            return to2Var;
        }
        return (to2) invokeL.objValue;
    }

    public static to2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            to2 to2Var = new to2();
            to2Var.a = jSONObject.optString("bundle_id");
            to2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                to2Var.b = optJSONObject.optString("appkey");
                to2Var.g = optJSONObject.optString("pkg_type");
                to2Var.c = optJSONObject.optString("app_name");
                to2Var.d = optJSONObject.optString("app_icon");
                to2Var.j = optJSONObject.optString("version_code");
                to2Var.f = optJSONObject.optInt("frame_type");
                to2Var.h = optJSONObject.optInt("pay_protected");
            }
            return to2Var;
        }
        return (to2) invokeL.objValue;
    }
}
