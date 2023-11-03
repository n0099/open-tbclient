package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.subtitle.SubtitleLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes7.dex */
public class mxc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TopCode topCode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topCode)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, BigdayActivityConfig.IMG_URL, topCode.img_url);
            poc.a(jSONObject, "game_link", topCode.game_link);
            poc.a(jSONObject, "summary", topCode.summary);
            poc.a(jSONObject, "code_link", topCode.code_link);
            poc.a(jSONObject, "get_type", topCode.get_type);
            poc.a(jSONObject, "surplusgift", topCode.surplusgift);
            poc.a(jSONObject, "giftworth", topCode.giftworth);
            poc.a(jSONObject, "type_text", topCode.type_text);
            poc.a(jSONObject, SubtitleLog.TAG, topCode.subtitle);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
