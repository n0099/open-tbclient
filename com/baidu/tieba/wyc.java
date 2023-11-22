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
/* loaded from: classes9.dex */
public class wyc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Icon icon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, icon)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "name", icon.name);
            qoc.a(jSONObject, "weight", icon.weight);
            qoc.a(jSONObject, "url", icon.url);
            qoc.a(jSONObject, "icon", icon.icon);
            qoc.a(jSONObject, "value", icon.value);
            Terminal terminal = icon.terminal;
            if (terminal != null) {
                qoc.a(jSONObject, "terminal", m4d.b(terminal));
            }
            Position position = icon.position;
            if (position != null) {
                qoc.a(jSONObject, CriusAttrConstants.POSITION, o1d.b(position));
            }
            if (icon.sprite_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : icon.sprite_info) {
                    jSONArray.put(str);
                }
                qoc.a(jSONObject, "sprite_info", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
