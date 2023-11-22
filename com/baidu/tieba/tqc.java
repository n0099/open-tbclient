package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.CardLinkInfo;
/* loaded from: classes8.dex */
public class tqc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull CardLinkInfo cardLinkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cardLinkInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "type", cardLinkInfo.type);
            qoc.a(jSONObject, EditHeadActivityConfig.IMAGE_URL, cardLinkInfo.image_url);
            qoc.a(jSONObject, "tag_text", cardLinkInfo.tag_text);
            qoc.a(jSONObject, "tag_color", cardLinkInfo.tag_color);
            qoc.a(jSONObject, "title", cardLinkInfo.title);
            qoc.a(jSONObject, GameGuideConfigInfo.KEY_CONTENT1, cardLinkInfo.content1);
            qoc.a(jSONObject, GameGuideConfigInfo.KEY_CONTENT2, cardLinkInfo.content2);
            qoc.a(jSONObject, "btn_style", cardLinkInfo.btn_style);
            qoc.a(jSONObject, "btn_text", cardLinkInfo.btn_text);
            qoc.a(jSONObject, "text_btn_status", cardLinkInfo.text_btn_status);
            qoc.a(jSONObject, "url", cardLinkInfo.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
