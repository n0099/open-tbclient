package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class x77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v77 a;
    public ArrayList<w77> b;

    public x77() {
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

    public static x77 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            x77 x77Var = new x77();
            JSONObject optJSONObject = jSONObject.optJSONObject("guide_content");
            JSONArray optJSONArray = jSONObject.optJSONArray("hot_topic");
            x77Var.a = v77.a(optJSONObject);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                x77Var.b = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        w77 a = w77.a(optJSONArray.getJSONObject(i));
                        if (a != null) {
                            x77Var.b.add(a);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            return x77Var;
        }
        return (x77) invokeL.objValue;
    }
}
