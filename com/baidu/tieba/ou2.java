package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ou2 implements wx2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qu2 a;
    public int b;
    public int c;
    public int d;
    public float e;

    public ou2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = -16777216;
        this.d = -1;
        this.e = 0.0f;
    }

    @Override // com.baidu.tieba.wx2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            qu2 qu2Var = this.a;
            if (qu2Var != null && qu2Var.isValid() && this.d != -1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.wx2
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null || !jSONObject.has("radius")) {
            return;
        }
        qu2 qu2Var = new qu2();
        this.a = qu2Var;
        qu2Var.a(jSONObject);
        if (!this.a.isValid()) {
            return;
        }
        this.b = ku2.a(jSONObject.optString("color"), 0);
        this.c = ku2.a(jSONObject.optString("fillColor"), -16777216);
        this.d = jSONObject.optInt("radius", -1);
        this.e = Math.abs(ku2.b(jSONObject.optDouble("strokeWidth", 0.0d)));
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "coordinate ->" + this.a + "color ->" + this.b + "fillColor ->" + this.c + "radius ->" + this.d + "strokeWidth ->" + this.e;
        }
        return (String) invokeV.objValue;
    }
}
