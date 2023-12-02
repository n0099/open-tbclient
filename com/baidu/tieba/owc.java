package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.DownloadBar;
/* loaded from: classes7.dex */
public class owc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DownloadBar downloadBar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, downloadBar)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "type", downloadBar.type);
            ktc.a(jSONObject, GameGuideConfigInfo.KEY_BUTTON_TEXT, downloadBar.button_text);
            ktc.a(jSONObject, "schema", downloadBar.schema);
            ktc.a(jSONObject, "guide_text", downloadBar.guide_text);
            ktc.a(jSONObject, "icon", downloadBar.icon);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
