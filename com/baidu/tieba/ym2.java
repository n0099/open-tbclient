package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ym2 {
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

    public ym2() {
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
    public static ym2 a(@NonNull ju2 ju2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ju2Var)) == null) {
            ym2 ym2Var = new ym2();
            ym2Var.a = ju2Var.H();
            ym2Var.c = ju2Var.K();
            ym2Var.d = ju2Var.Q();
            ym2Var.f = ju2Var.G();
            ym2Var.i = ju2Var.T();
            ym2Var.h = ju2Var.p1();
            ym2Var.e = System.currentTimeMillis();
            ym2Var.g = String.valueOf(ju2Var.getType());
            ym2Var.b = ju2Var.I();
            ym2Var.j = ju2Var.v1();
            return ym2Var;
        }
        return (ym2) invokeL.objValue;
    }

    public static ym2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ym2 ym2Var = new ym2();
            ym2Var.a = jSONObject.optString("bundle_id");
            ym2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                ym2Var.b = optJSONObject.optString("appkey");
                ym2Var.g = optJSONObject.optString("pkg_type");
                ym2Var.c = optJSONObject.optString("app_name");
                ym2Var.d = optJSONObject.optString("app_icon");
                ym2Var.j = optJSONObject.optString("version_code");
                ym2Var.f = optJSONObject.optInt("frame_type");
                ym2Var.h = optJSONObject.optInt("pay_protected");
            }
            return ym2Var;
        }
        return (ym2) invokeL.objValue;
    }
}
