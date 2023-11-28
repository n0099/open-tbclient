package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class tj2 {
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

    public tj2() {
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
    public static tj2 a(@NonNull er2 er2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, er2Var)) == null) {
            tj2 tj2Var = new tj2();
            tj2Var.a = er2Var.I();
            tj2Var.c = er2Var.L();
            tj2Var.d = er2Var.R();
            tj2Var.f = er2Var.H();
            tj2Var.i = er2Var.U();
            tj2Var.h = er2Var.q1();
            tj2Var.e = System.currentTimeMillis();
            tj2Var.g = String.valueOf(er2Var.w1());
            tj2Var.b = er2Var.J();
            tj2Var.j = er2Var.x1();
            return tj2Var;
        }
        return (tj2) invokeL.objValue;
    }

    public static tj2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            tj2 tj2Var = new tj2();
            tj2Var.a = jSONObject.optString("bundle_id");
            tj2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                tj2Var.b = optJSONObject.optString("appkey");
                tj2Var.g = optJSONObject.optString("pkg_type");
                tj2Var.c = optJSONObject.optString("app_name");
                tj2Var.d = optJSONObject.optString("app_icon");
                tj2Var.j = optJSONObject.optString("version_code");
                tj2Var.f = optJSONObject.optInt("frame_type");
                tj2Var.h = optJSONObject.optInt("pay_protected");
            }
            return tj2Var;
        }
        return (tj2) invokeL.objValue;
    }
}
