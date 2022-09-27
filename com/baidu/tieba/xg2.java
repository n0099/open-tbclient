package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class xg2 {
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

    public xg2() {
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
    public static xg2 a(@NonNull io2 io2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, io2Var)) == null) {
            xg2 xg2Var = new xg2();
            xg2Var.a = io2Var.H();
            xg2Var.c = io2Var.K();
            xg2Var.d = io2Var.Q();
            xg2Var.f = io2Var.G();
            xg2Var.i = io2Var.T();
            xg2Var.h = io2Var.p1();
            xg2Var.e = System.currentTimeMillis();
            xg2Var.g = String.valueOf(io2Var.getType());
            xg2Var.b = io2Var.I();
            xg2Var.j = io2Var.v1();
            return xg2Var;
        }
        return (xg2) invokeL.objValue;
    }

    public static xg2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            xg2 xg2Var = new xg2();
            xg2Var.a = jSONObject.optString("bundle_id");
            xg2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                xg2Var.b = optJSONObject.optString("appkey");
                xg2Var.g = optJSONObject.optString("pkg_type");
                xg2Var.c = optJSONObject.optString("app_name");
                xg2Var.d = optJSONObject.optString("app_icon");
                xg2Var.j = optJSONObject.optString("version_code");
                xg2Var.f = optJSONObject.optInt("frame_type");
                xg2Var.h = optJSONObject.optInt("pay_protected");
            }
            return xg2Var;
        }
        return (xg2) invokeL.objValue;
    }
}
