package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AppCode;
/* loaded from: classes8.dex */
public class upc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AppCode appCode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, appCode)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "game_icon", appCode.game_icon);
            qoc.a(jSONObject, "post_url", appCode.post_url);
            qoc.a(jSONObject, GameGuideConfigInfo.KEY_BUTTON_TEXT, appCode.button_text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
