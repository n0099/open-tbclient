package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Icon;
import tbclient.Position;
import tbclient.Terminal;
/* loaded from: classes8.dex */
public class vyc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Icon icon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, icon)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "name", icon.name);
            poc.a(jSONObject, "weight", icon.weight);
            poc.a(jSONObject, "url", icon.url);
            poc.a(jSONObject, "icon", icon.icon);
            poc.a(jSONObject, "value", icon.value);
            Terminal terminal = icon.terminal;
            if (terminal != null) {
                poc.a(jSONObject, "terminal", l4d.b(terminal));
            }
            Position position = icon.position;
            if (position != null) {
                poc.a(jSONObject, CriusAttrConstants.POSITION, n1d.b(position));
            }
            if (icon.sprite_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : icon.sprite_info) {
                    jSONArray.put(str);
                }
                poc.a(jSONObject, "sprite_info", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
