package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qh2 {
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

    public qh2() {
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
    public static qh2 a(@NonNull bp2 bp2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bp2Var)) == null) {
            qh2 qh2Var = new qh2();
            qh2Var.a = bp2Var.H();
            qh2Var.c = bp2Var.K();
            qh2Var.d = bp2Var.Q();
            qh2Var.f = bp2Var.G();
            qh2Var.i = bp2Var.T();
            qh2Var.h = bp2Var.p1();
            qh2Var.e = System.currentTimeMillis();
            qh2Var.g = String.valueOf(bp2Var.getType());
            qh2Var.b = bp2Var.I();
            qh2Var.j = bp2Var.v1();
            return qh2Var;
        }
        return (qh2) invokeL.objValue;
    }

    public static qh2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            qh2 qh2Var = new qh2();
            qh2Var.a = jSONObject.optString("bundle_id");
            qh2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                qh2Var.b = optJSONObject.optString("appkey");
                qh2Var.g = optJSONObject.optString("pkg_type");
                qh2Var.c = optJSONObject.optString("app_name");
                qh2Var.d = optJSONObject.optString("app_icon");
                qh2Var.j = optJSONObject.optString("version_code");
                qh2Var.f = optJSONObject.optInt("frame_type");
                qh2Var.h = optJSONObject.optInt("pay_protected");
            }
            return qh2Var;
        }
        return (qh2) invokeL.objValue;
    }
}
