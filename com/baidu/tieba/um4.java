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
/* loaded from: classes8.dex */
public class um4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(@Nullable rm4<JSONArray> rm4Var, @Nullable rm4<JSONObject> rm4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, rm4Var, rm4Var2)) == null) {
            return b(Node.values(), rm4Var, rm4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static JSONObject b(Node[] nodeArr, @Nullable rm4<JSONArray> rm4Var, @Nullable rm4<JSONObject> rm4Var2) {
        InterceptResult invokeLLL;
        tm4 provider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, nodeArr, rm4Var, rm4Var2)) == null) {
            if (nodeArr == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                for (Node node : nodeArr) {
                    if (node != null && (provider = Node.getProvider(node)) != null) {
                        if (node.isDataArray()) {
                            jSONObject.put(node.getName(), provider.b(rm4Var));
                        } else {
                            jSONObject.put(node.getName(), provider.a(rm4Var2));
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

    public static void c(JSONObject jSONObject, cj4 cj4Var, @Nullable cj4 cj4Var2, @Nullable cj4 cj4Var3) {
        qi4 b;
        sm4 a;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65538, null, jSONObject, cj4Var, cj4Var2, cj4Var3) != null) || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Node nodeByConfigName = Node.getNodeByConfigName(next);
            if (nodeByConfigName != null && (a = vm4.a(nodeByConfigName)) != null) {
                if (nodeByConfigName.isDataArray()) {
                    a.a(jSONObject.optJSONArray(next), cj4Var, cj4Var2, cj4Var3);
                } else {
                    a.b(jSONObject.optJSONObject(next), cj4Var, cj4Var2, cj4Var3);
                }
            }
        }
        if (nn4.a && (b = si4.b()) != null) {
            b.C();
        }
    }
}
