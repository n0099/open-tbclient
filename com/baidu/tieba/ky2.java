package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ky2 extends hy2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oy2 A;
    public double B;
    public int C;
    public String z;

    public ky2() {
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
        this.z = "";
        this.C = 1000;
    }

    @Override // com.baidu.tieba.hy2, com.baidu.tieba.l72, com.baidu.tieba.u13
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.z = jSONObject.optString("markerId");
        oy2 oy2Var = new oy2();
        this.A = oy2Var;
        oy2Var.a(jSONObject.optJSONObject("destination"));
        jSONObject.optBoolean("autoRotate");
        this.B = jSONObject.optDouble("rotate");
        this.C = Math.abs(jSONObject.optInt("duration", this.C));
    }

    @Override // com.baidu.tieba.l72, com.baidu.tieba.u13
    public boolean isValid() {
        InterceptResult invokeV;
        oy2 oy2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.z) && (oy2Var = this.A) != null && oy2Var.isValid()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
