package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class im2 {
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

    public im2() {
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
    public static im2 a(@NonNull tt2 tt2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tt2Var)) == null) {
            im2 im2Var = new im2();
            im2Var.a = tt2Var.H();
            im2Var.c = tt2Var.K();
            im2Var.d = tt2Var.Q();
            im2Var.f = tt2Var.G();
            im2Var.i = tt2Var.T();
            im2Var.h = tt2Var.p1();
            im2Var.e = System.currentTimeMillis();
            im2Var.g = String.valueOf(tt2Var.getType());
            im2Var.b = tt2Var.I();
            im2Var.j = tt2Var.v1();
            return im2Var;
        }
        return (im2) invokeL.objValue;
    }

    public static im2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            im2 im2Var = new im2();
            im2Var.a = jSONObject.optString("bundle_id");
            im2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                im2Var.b = optJSONObject.optString("appkey");
                im2Var.g = optJSONObject.optString("pkg_type");
                im2Var.c = optJSONObject.optString("app_name");
                im2Var.d = optJSONObject.optString("app_icon");
                im2Var.j = optJSONObject.optString("version_code");
                im2Var.f = optJSONObject.optInt("frame_type");
                im2Var.h = optJSONObject.optInt("pay_protected");
            }
            return im2Var;
        }
        return (im2) invokeL.objValue;
    }
}
