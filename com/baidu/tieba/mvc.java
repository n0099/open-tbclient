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
public class mvc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BottomMenu bottomMenu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bottomMenu)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "name", bottomMenu.name);
            ltc.a(jSONObject, "url", bottomMenu.url);
            if (bottomMenu.submenu != null) {
                JSONArray jSONArray = new JSONArray();
                for (SubBottomMenu subBottomMenu : bottomMenu.submenu) {
                    jSONArray.put(a9d.b(subBottomMenu));
                }
                ltc.a(jSONObject, "submenu", jSONArray);
            }
            ltc.a(jSONObject, "type", bottomMenu.type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
