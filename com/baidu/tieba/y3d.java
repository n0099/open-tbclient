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
public class y3d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Icon icon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, icon)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "name", icon.name);
            ktc.a(jSONObject, "weight", icon.weight);
            ktc.a(jSONObject, "url", icon.url);
            ktc.a(jSONObject, "icon", icon.icon);
            ktc.a(jSONObject, "value", icon.value);
            Terminal terminal = icon.terminal;
            if (terminal != null) {
                ktc.a(jSONObject, "terminal", o9d.b(terminal));
            }
            Position position = icon.position;
            if (position != null) {
                ktc.a(jSONObject, CriusAttrConstants.POSITION, q6d.b(position));
            }
            if (icon.sprite_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : icon.sprite_info) {
                    jSONArray.put(str);
                }
                ktc.a(jSONObject, "sprite_info", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
