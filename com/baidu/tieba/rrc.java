package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.DownloadBar;
/* loaded from: classes8.dex */
public class rrc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DownloadBar downloadBar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, downloadBar)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "type", downloadBar.type);
            qoc.a(jSONObject, GameGuideConfigInfo.KEY_BUTTON_TEXT, downloadBar.button_text);
            qoc.a(jSONObject, "schema", downloadBar.schema);
            qoc.a(jSONObject, "guide_text", downloadBar.guide_text);
            qoc.a(jSONObject, "icon", downloadBar.icon);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
