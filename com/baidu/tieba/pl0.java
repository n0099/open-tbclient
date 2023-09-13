package com.baidu.tieba;

import com.baidu.nadcore.model.ParseError;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class pl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public as0 b;
    public String c;

    public pl0() {
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

    public static pl0 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            pl0 pl0Var = new pl0();
            pl0Var.a = jSONObject.optInt("download_state");
            JSONObject optJSONObject = jSONObject.optJSONObject("app_info");
            if (optJSONObject != null) {
                try {
                    pl0Var.b = as0.d(optJSONObject);
                } catch (ParseError e) {
                    e.printStackTrace();
                }
            }
            pl0Var.c = jSONObject.optString("download_hint");
            return pl0Var;
        }
        return (pl0) invokeL.objValue;
    }
}
