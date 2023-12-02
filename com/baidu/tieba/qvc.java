package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.CardLinkInfo;
/* loaded from: classes7.dex */
public class qvc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull CardLinkInfo cardLinkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cardLinkInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "type", cardLinkInfo.type);
            ktc.a(jSONObject, EditHeadActivityConfig.IMAGE_URL, cardLinkInfo.image_url);
            ktc.a(jSONObject, "tag_text", cardLinkInfo.tag_text);
            ktc.a(jSONObject, "tag_color", cardLinkInfo.tag_color);
            ktc.a(jSONObject, "title", cardLinkInfo.title);
            ktc.a(jSONObject, GameGuideConfigInfo.KEY_CONTENT1, cardLinkInfo.content1);
            ktc.a(jSONObject, GameGuideConfigInfo.KEY_CONTENT2, cardLinkInfo.content2);
            ktc.a(jSONObject, "btn_style", cardLinkInfo.btn_style);
            ktc.a(jSONObject, "btn_text", cardLinkInfo.btn_text);
            ktc.a(jSONObject, "text_btn_status", cardLinkInfo.text_btn_status);
            ktc.a(jSONObject, "url", cardLinkInfo.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
