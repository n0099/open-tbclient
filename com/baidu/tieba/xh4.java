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
/* loaded from: classes9.dex */
public class xh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(@Nullable uh4<JSONArray> uh4Var, @Nullable uh4<JSONObject> uh4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, uh4Var, uh4Var2)) == null) {
            return b(Node.values(), uh4Var, uh4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static JSONObject b(Node[] nodeArr, @Nullable uh4<JSONArray> uh4Var, @Nullable uh4<JSONObject> uh4Var2) {
        InterceptResult invokeLLL;
        wh4 provider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, nodeArr, uh4Var, uh4Var2)) == null) {
            if (nodeArr == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                for (Node node : nodeArr) {
                    if (node != null && (provider = Node.getProvider(node)) != null) {
                        if (node.isDataArray()) {
                            jSONObject.put(node.getName(), provider.b(uh4Var));
                        } else {
                            jSONObject.put(node.getName(), provider.a(uh4Var2));
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

    public static void c(JSONObject jSONObject, fe4 fe4Var, @Nullable fe4 fe4Var2, @Nullable fe4 fe4Var3) {
        td4 b;
        vh4 a;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65538, null, jSONObject, fe4Var, fe4Var2, fe4Var3) != null) || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Node nodeByConfigName = Node.getNodeByConfigName(next);
            if (nodeByConfigName != null && (a = yh4.a(nodeByConfigName)) != null) {
                if (nodeByConfigName.isDataArray()) {
                    a.a(jSONObject.optJSONArray(next), fe4Var, fe4Var2, fe4Var3);
                } else {
                    a.b(jSONObject.optJSONObject(next), fe4Var, fe4Var2, fe4Var3);
                }
            }
        }
        if (qi4.a && (b = vd4.b()) != null) {
            b.C();
        }
    }
}
