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
public class z3d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Icon icon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, icon)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "name", icon.name);
            ltc.a(jSONObject, "weight", icon.weight);
            ltc.a(jSONObject, "url", icon.url);
            ltc.a(jSONObject, "icon", icon.icon);
            ltc.a(jSONObject, "value", icon.value);
            Terminal terminal = icon.terminal;
            if (terminal != null) {
                ltc.a(jSONObject, "terminal", p9d.b(terminal));
            }
            Position position = icon.position;
            if (position != null) {
                ltc.a(jSONObject, CriusAttrConstants.POSITION, r6d.b(position));
            }
            if (icon.sprite_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : icon.sprite_info) {
                    jSONArray.put(str);
                }
                ltc.a(jSONObject, "sprite_info", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
