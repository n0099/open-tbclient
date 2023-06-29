package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ty2 implements b23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vy2 a;
    public int b;
    public int c;
    public int d;
    public float e;

    public ty2() {
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

    @Override // com.baidu.tieba.b23
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            vy2 vy2Var = this.a;
            if (vy2Var != null && vy2Var.isValid() && this.d != -1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.b23
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null || !jSONObject.has("radius")) {
            return;
        }
        vy2 vy2Var = new vy2();
        this.a = vy2Var;
        vy2Var.a(jSONObject);
        if (!this.a.isValid()) {
            return;
        }
        this.b = py2.a(jSONObject.optString("color"), 0);
        this.c = py2.a(jSONObject.optString("fillColor"), -16777216);
        this.d = jSONObject.optInt("radius", -1);
        this.e = Math.abs(py2.b(jSONObject.optDouble("strokeWidth", 0.0d)));
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
