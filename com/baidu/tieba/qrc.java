package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.DownloadBar;
/* loaded from: classes8.dex */
public class qrc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DownloadBar downloadBar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, downloadBar)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "type", downloadBar.type);
            poc.a(jSONObject, GameGuideConfigInfo.KEY_BUTTON_TEXT, downloadBar.button_text);
            poc.a(jSONObject, "schema", downloadBar.schema);
            poc.a(jSONObject, "guide_text", downloadBar.guide_text);
            poc.a(jSONObject, "icon", downloadBar.icon);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
