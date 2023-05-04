package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class jl2 {
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

    public jl2() {
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
    public static jl2 a(@NonNull us2 us2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, us2Var)) == null) {
            jl2 jl2Var = new jl2();
            jl2Var.a = us2Var.H();
            jl2Var.c = us2Var.K();
            jl2Var.d = us2Var.Q();
            jl2Var.f = us2Var.G();
            jl2Var.i = us2Var.T();
            jl2Var.h = us2Var.p1();
            jl2Var.e = System.currentTimeMillis();
            jl2Var.g = String.valueOf(us2Var.getType());
            jl2Var.b = us2Var.I();
            jl2Var.j = us2Var.v1();
            return jl2Var;
        }
        return (jl2) invokeL.objValue;
    }

    public static jl2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            jl2 jl2Var = new jl2();
            jl2Var.a = jSONObject.optString("bundle_id");
            jl2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                jl2Var.b = optJSONObject.optString("appkey");
                jl2Var.g = optJSONObject.optString("pkg_type");
                jl2Var.c = optJSONObject.optString("app_name");
                jl2Var.d = optJSONObject.optString("app_icon");
                jl2Var.j = optJSONObject.optString("version_code");
                jl2Var.f = optJSONObject.optInt("frame_type");
                jl2Var.h = optJSONObject.optInt("pay_protected");
            }
            return jl2Var;
        }
        return (jl2) invokeL.objValue;
    }
}
