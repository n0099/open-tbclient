package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class wj2 {
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

    public wj2() {
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
    public static wj2 a(@NonNull hr2 hr2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hr2Var)) == null) {
            wj2 wj2Var = new wj2();
            wj2Var.a = hr2Var.I();
            wj2Var.c = hr2Var.L();
            wj2Var.d = hr2Var.R();
            wj2Var.f = hr2Var.H();
            wj2Var.i = hr2Var.U();
            wj2Var.h = hr2Var.q1();
            wj2Var.e = System.currentTimeMillis();
            wj2Var.g = String.valueOf(hr2Var.w1());
            wj2Var.b = hr2Var.J();
            wj2Var.j = hr2Var.x1();
            return wj2Var;
        }
        return (wj2) invokeL.objValue;
    }

    public static wj2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            wj2 wj2Var = new wj2();
            wj2Var.a = jSONObject.optString("bundle_id");
            wj2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                wj2Var.b = optJSONObject.optString("appkey");
                wj2Var.g = optJSONObject.optString("pkg_type");
                wj2Var.c = optJSONObject.optString("app_name");
                wj2Var.d = optJSONObject.optString("app_icon");
                wj2Var.j = optJSONObject.optString("version_code");
                wj2Var.f = optJSONObject.optInt("frame_type");
                wj2Var.h = optJSONObject.optInt("pay_protected");
            }
            return wj2Var;
        }
        return (wj2) invokeL.objValue;
    }
}
