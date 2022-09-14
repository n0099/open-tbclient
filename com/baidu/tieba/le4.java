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
/* loaded from: classes4.dex */
public class le4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(@Nullable ie4<JSONArray> ie4Var, @Nullable ie4<JSONObject> ie4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, ie4Var, ie4Var2)) == null) ? b(Node.values(), ie4Var, ie4Var2) : (JSONObject) invokeLL.objValue;
    }

    public static JSONObject b(Node[] nodeArr, @Nullable ie4<JSONArray> ie4Var, @Nullable ie4<JSONObject> ie4Var2) {
        InterceptResult invokeLLL;
        ke4 provider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, nodeArr, ie4Var, ie4Var2)) == null) {
            if (nodeArr == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                for (Node node : nodeArr) {
                    if (node != null && (provider = Node.getProvider(node)) != null) {
                        if (node.isDataArray()) {
                            jSONObject.put(node.getName(), provider.b(ie4Var));
                        } else {
                            jSONObject.put(node.getName(), provider.a(ie4Var2));
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

    public static void c(JSONObject jSONObject, ta4 ta4Var, @Nullable ta4 ta4Var2, @Nullable ta4 ta4Var3) {
        ha4 b;
        je4 a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, jSONObject, ta4Var, ta4Var2, ta4Var3) == null) || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Node nodeByConfigName = Node.getNodeByConfigName(next);
            if (nodeByConfigName != null && (a = me4.a(nodeByConfigName)) != null) {
                if (nodeByConfigName.isDataArray()) {
                    a.a(jSONObject.optJSONArray(next), ta4Var, ta4Var2, ta4Var3);
                } else {
                    a.b(jSONObject.optJSONObject(next), ta4Var, ta4Var2, ta4Var3);
                }
            }
        }
        if (!ef4.a || (b = ja4.b()) == null) {
            return;
        }
        b.C();
    }
}
