package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class lp2 {
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

    public lp2() {
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
    public static lp2 a(@NonNull ww2 ww2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ww2Var)) == null) {
            lp2 lp2Var = new lp2();
            lp2Var.a = ww2Var.H();
            lp2Var.c = ww2Var.K();
            lp2Var.d = ww2Var.Q();
            lp2Var.f = ww2Var.G();
            lp2Var.i = ww2Var.T();
            lp2Var.h = ww2Var.p1();
            lp2Var.e = System.currentTimeMillis();
            lp2Var.g = String.valueOf(ww2Var.getType());
            lp2Var.b = ww2Var.I();
            lp2Var.j = ww2Var.v1();
            return lp2Var;
        }
        return (lp2) invokeL.objValue;
    }

    public static lp2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            lp2 lp2Var = new lp2();
            lp2Var.a = jSONObject.optString("bundle_id");
            lp2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                lp2Var.b = optJSONObject.optString("appkey");
                lp2Var.g = optJSONObject.optString("pkg_type");
                lp2Var.c = optJSONObject.optString("app_name");
                lp2Var.d = optJSONObject.optString("app_icon");
                lp2Var.j = optJSONObject.optString("version_code");
                lp2Var.f = optJSONObject.optInt("frame_type");
                lp2Var.h = optJSONObject.optInt("pay_protected");
            }
            return lp2Var;
        }
        return (lp2) invokeL.objValue;
    }
}
