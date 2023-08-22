package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class po2 {
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

    public po2() {
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
    public static po2 a(@NonNull aw2 aw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aw2Var)) == null) {
            po2 po2Var = new po2();
            po2Var.a = aw2Var.H();
            po2Var.c = aw2Var.K();
            po2Var.d = aw2Var.Q();
            po2Var.f = aw2Var.G();
            po2Var.i = aw2Var.T();
            po2Var.h = aw2Var.p1();
            po2Var.e = System.currentTimeMillis();
            po2Var.g = String.valueOf(aw2Var.getType());
            po2Var.b = aw2Var.I();
            po2Var.j = aw2Var.v1();
            return po2Var;
        }
        return (po2) invokeL.objValue;
    }

    public static po2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            po2 po2Var = new po2();
            po2Var.a = jSONObject.optString("bundle_id");
            po2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                po2Var.b = optJSONObject.optString("appkey");
                po2Var.g = optJSONObject.optString("pkg_type");
                po2Var.c = optJSONObject.optString("app_name");
                po2Var.d = optJSONObject.optString("app_icon");
                po2Var.j = optJSONObject.optString("version_code");
                po2Var.f = optJSONObject.optInt("frame_type");
                po2Var.h = optJSONObject.optInt("pay_protected");
            }
            return po2Var;
        }
        return (po2) invokeL.objValue;
    }
}
