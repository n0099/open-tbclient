package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kp2 {
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

    public kp2() {
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
    public static kp2 a(@NonNull vw2 vw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vw2Var)) == null) {
            kp2 kp2Var = new kp2();
            kp2Var.a = vw2Var.H();
            kp2Var.c = vw2Var.K();
            kp2Var.d = vw2Var.Q();
            kp2Var.f = vw2Var.G();
            kp2Var.i = vw2Var.T();
            kp2Var.h = vw2Var.p1();
            kp2Var.e = System.currentTimeMillis();
            kp2Var.g = String.valueOf(vw2Var.getType());
            kp2Var.b = vw2Var.I();
            kp2Var.j = vw2Var.v1();
            return kp2Var;
        }
        return (kp2) invokeL.objValue;
    }

    public static kp2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            kp2 kp2Var = new kp2();
            kp2Var.a = jSONObject.optString("bundle_id");
            kp2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                kp2Var.b = optJSONObject.optString("appkey");
                kp2Var.g = optJSONObject.optString("pkg_type");
                kp2Var.c = optJSONObject.optString("app_name");
                kp2Var.d = optJSONObject.optString("app_icon");
                kp2Var.j = optJSONObject.optString("version_code");
                kp2Var.f = optJSONObject.optInt("frame_type");
                kp2Var.h = optJSONObject.optInt("pay_protected");
            }
            return kp2Var;
        }
        return (kp2) invokeL.objValue;
    }
}
