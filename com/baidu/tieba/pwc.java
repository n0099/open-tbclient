package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.DownloadBar;
/* loaded from: classes7.dex */
public class pwc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DownloadBar downloadBar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, downloadBar)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "type", downloadBar.type);
            ltc.a(jSONObject, GameGuideConfigInfo.KEY_BUTTON_TEXT, downloadBar.button_text);
            ltc.a(jSONObject, "schema", downloadBar.schema);
            ltc.a(jSONObject, "guide_text", downloadBar.guide_text);
            ltc.a(jSONObject, "icon", downloadBar.icon);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
