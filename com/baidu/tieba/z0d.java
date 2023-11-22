package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PbLinkInfo;
/* loaded from: classes9.dex */
public class z0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PbLinkInfo pbLinkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pbLinkInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "title", pbLinkInfo.title);
            qoc.a(jSONObject, "to_url", pbLinkInfo.to_url);
            qoc.a(jSONObject, "pic_url", pbLinkInfo.pic_url);
            qoc.a(jSONObject, "link_from", pbLinkInfo.link_from);
            qoc.a(jSONObject, "ext_txt", pbLinkInfo.ext_txt);
            qoc.a(jSONObject, QuickPersistConfigConst.KEY_SPLASH_SORT, pbLinkInfo.sort);
            qoc.a(jSONObject, "url_type", pbLinkInfo.url_type);
            qoc.a(jSONObject, GameGuideConfigInfo.KEY_CONTENT1, pbLinkInfo.content1);
            qoc.a(jSONObject, GameGuideConfigInfo.KEY_CONTENT2, pbLinkInfo.content2);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
