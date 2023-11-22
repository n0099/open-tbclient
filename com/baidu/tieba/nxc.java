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
public class nxc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TopCode topCode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topCode)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, BigdayActivityConfig.IMG_URL, topCode.img_url);
            qoc.a(jSONObject, "game_link", topCode.game_link);
            qoc.a(jSONObject, "summary", topCode.summary);
            qoc.a(jSONObject, "code_link", topCode.code_link);
            qoc.a(jSONObject, "get_type", topCode.get_type);
            qoc.a(jSONObject, "surplusgift", topCode.surplusgift);
            qoc.a(jSONObject, "giftworth", topCode.giftworth);
            qoc.a(jSONObject, "type_text", topCode.type_text);
            qoc.a(jSONObject, SubtitleLog.TAG, topCode.subtitle);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
