package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sm2 {
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

    public sm2() {
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
    public static sm2 a(@NonNull du2 du2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, du2Var)) == null) {
            sm2 sm2Var = new sm2();
            sm2Var.a = du2Var.H();
            sm2Var.c = du2Var.K();
            sm2Var.d = du2Var.Q();
            sm2Var.f = du2Var.G();
            sm2Var.i = du2Var.T();
            sm2Var.h = du2Var.p1();
            sm2Var.e = System.currentTimeMillis();
            sm2Var.g = String.valueOf(du2Var.getType());
            sm2Var.b = du2Var.I();
            sm2Var.j = du2Var.v1();
            return sm2Var;
        }
        return (sm2) invokeL.objValue;
    }

    public static sm2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            sm2 sm2Var = new sm2();
            sm2Var.a = jSONObject.optString("bundle_id");
            sm2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                sm2Var.b = optJSONObject.optString("appkey");
                sm2Var.g = optJSONObject.optString("pkg_type");
                sm2Var.c = optJSONObject.optString("app_name");
                sm2Var.d = optJSONObject.optString("app_icon");
                sm2Var.j = optJSONObject.optString("version_code");
                sm2Var.f = optJSONObject.optInt("frame_type");
                sm2Var.h = optJSONObject.optInt("pay_protected");
            }
            return sm2Var;
        }
        return (sm2) invokeL.objValue;
    }
}
