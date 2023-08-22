package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.pms.node.Node;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(@Nullable nm4<JSONArray> nm4Var, @Nullable nm4<JSONObject> nm4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, nm4Var, nm4Var2)) == null) {
            return b(Node.values(), nm4Var, nm4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static JSONObject b(Node[] nodeArr, @Nullable nm4<JSONArray> nm4Var, @Nullable nm4<JSONObject> nm4Var2) {
        InterceptResult invokeLLL;
        pm4 provider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, nodeArr, nm4Var, nm4Var2)) == null) {
            if (nodeArr == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                for (Node node : nodeArr) {
                    if (node != null && (provider = Node.getProvider(node)) != null) {
                        if (node.isDataArray()) {
                            jSONObject.put(node.getName(), provider.b(nm4Var));
                        } else {
                            jSONObject.put(node.getName(), provider.a(nm4Var2));
                        }
                    }
                }
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static void c(JSONObject jSONObject, yi4 yi4Var, @Nullable yi4 yi4Var2, @Nullable yi4 yi4Var3) {
        mi4 b;
        om4 a;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65538, null, jSONObject, yi4Var, yi4Var2, yi4Var3) != null) || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Node nodeByConfigName = Node.getNodeByConfigName(next);
            if (nodeByConfigName != null && (a = rm4.a(nodeByConfigName)) != null) {
                if (nodeByConfigName.isDataArray()) {
                    a.a(jSONObject.optJSONArray(next), yi4Var, yi4Var2, yi4Var3);
                } else {
                    a.b(jSONObject.optJSONObject(next), yi4Var, yi4Var2, yi4Var3);
                }
            }
        }
        if (jn4.a && (b = oi4.b()) != null) {
            b.C();
        }
    }
}
