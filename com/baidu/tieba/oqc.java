package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes7.dex */
public class oqc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BottomMenu bottomMenu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bottomMenu)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "name", bottomMenu.name);
            poc.a(jSONObject, "url", bottomMenu.url);
            if (bottomMenu.submenu != null) {
                JSONArray jSONArray = new JSONArray();
                for (SubBottomMenu subBottomMenu : bottomMenu.submenu) {
                    jSONArray.put(w3d.b(subBottomMenu));
                }
                poc.a(jSONObject, "submenu", jSONArray);
            }
            poc.a(jSONObject, "type", bottomMenu.type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
