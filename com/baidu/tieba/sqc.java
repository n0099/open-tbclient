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
public class sqc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull CardLinkInfo cardLinkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cardLinkInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "type", cardLinkInfo.type);
            poc.a(jSONObject, EditHeadActivityConfig.IMAGE_URL, cardLinkInfo.image_url);
            poc.a(jSONObject, "tag_text", cardLinkInfo.tag_text);
            poc.a(jSONObject, "tag_color", cardLinkInfo.tag_color);
            poc.a(jSONObject, "title", cardLinkInfo.title);
            poc.a(jSONObject, GameGuideConfigInfo.KEY_CONTENT1, cardLinkInfo.content1);
            poc.a(jSONObject, GameGuideConfigInfo.KEY_CONTENT2, cardLinkInfo.content2);
            poc.a(jSONObject, "btn_style", cardLinkInfo.btn_style);
            poc.a(jSONObject, "btn_text", cardLinkInfo.btn_text);
            poc.a(jSONObject, "text_btn_status", cardLinkInfo.text_btn_status);
            poc.a(jSONObject, "url", cardLinkInfo.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
