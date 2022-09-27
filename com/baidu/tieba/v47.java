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
public class v47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t47 a;
    public ArrayList<u47> b;

    public v47() {
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

    public static v47 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            v47 v47Var = new v47();
            JSONObject optJSONObject = jSONObject.optJSONObject("guide_content");
            JSONArray optJSONArray = jSONObject.optJSONArray("hot_topic");
            v47Var.a = t47.a(optJSONObject);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                v47Var.b = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        u47 a = u47.a(optJSONArray.getJSONObject(i));
                        if (a != null) {
                            v47Var.b.add(a);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            return v47Var;
        }
        return (v47) invokeL.objValue;
    }
}
