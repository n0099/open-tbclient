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
public class o2d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TopCode topCode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topCode)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, BigdayActivityConfig.IMG_URL, topCode.img_url);
            ltc.a(jSONObject, "game_link", topCode.game_link);
            ltc.a(jSONObject, "summary", topCode.summary);
            ltc.a(jSONObject, "code_link", topCode.code_link);
            ltc.a(jSONObject, "get_type", topCode.get_type);
            ltc.a(jSONObject, "surplusgift", topCode.surplusgift);
            ltc.a(jSONObject, "giftworth", topCode.giftworth);
            ltc.a(jSONObject, "type_text", topCode.type_text);
            ltc.a(jSONObject, SubtitleLog.TAG, topCode.subtitle);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
