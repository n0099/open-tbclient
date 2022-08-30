package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class me2 {
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

    public me2() {
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
    public static me2 a(@NonNull xl2 xl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, xl2Var)) == null) {
            me2 me2Var = new me2();
            me2Var.a = xl2Var.H();
            me2Var.c = xl2Var.K();
            me2Var.d = xl2Var.Q();
            me2Var.f = xl2Var.G();
            me2Var.i = xl2Var.T();
            me2Var.h = xl2Var.p1();
            me2Var.e = System.currentTimeMillis();
            me2Var.g = String.valueOf(xl2Var.getType());
            me2Var.b = xl2Var.I();
            me2Var.j = xl2Var.v1();
            return me2Var;
        }
        return (me2) invokeL.objValue;
    }

    public static me2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            me2 me2Var = new me2();
            me2Var.a = jSONObject.optString("bundle_id");
            me2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                me2Var.b = optJSONObject.optString("appkey");
                me2Var.g = optJSONObject.optString("pkg_type");
                me2Var.c = optJSONObject.optString("app_name");
                me2Var.d = optJSONObject.optString("app_icon");
                me2Var.j = optJSONObject.optString("version_code");
                me2Var.f = optJSONObject.optInt("frame_type");
                me2Var.h = optJSONObject.optInt("pay_protected");
            }
            return me2Var;
        }
        return (me2) invokeL.objValue;
    }
}
