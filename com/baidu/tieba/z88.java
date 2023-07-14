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
/* loaded from: classes8.dex */
public class z88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x88 a;
    public ArrayList<y88> b;

    public z88() {
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

    public static z88 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            z88 z88Var = new z88();
            JSONObject optJSONObject = jSONObject.optJSONObject("guide_content");
            JSONArray optJSONArray = jSONObject.optJSONArray("hot_topic");
            z88Var.a = x88.a(optJSONObject);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                z88Var.b = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        y88 a = y88.a(optJSONArray.getJSONObject(i));
                        if (a != null) {
                            z88Var.b.add(a);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            return z88Var;
        }
        return (z88) invokeL.objValue;
    }
}
