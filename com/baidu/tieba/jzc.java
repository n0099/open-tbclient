package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.subtitle.SubtitleLog;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.BountyCard;
import tbclient.IconUrlInfo;
/* loaded from: classes7.dex */
public class jzc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BountyCard bountyCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bountyCard)) == null) {
            JSONObject jSONObject = new JSONObject();
            IconUrlInfo iconUrlInfo = bountyCard.icon;
            if (iconUrlInfo != null) {
                ltc.a(jSONObject, "icon", a4d.b(iconUrlInfo));
            }
            ltc.a(jSONObject, "title", bountyCard.title);
            ltc.a(jSONObject, SubtitleLog.TAG, bountyCard.subtitle);
            IconUrlInfo iconUrlInfo2 = bountyCard.bg_img;
            if (iconUrlInfo2 != null) {
                ltc.a(jSONObject, "bg_img", a4d.b(iconUrlInfo2));
            }
            ltc.a(jSONObject, "award_type", bountyCard.award_type);
            ltc.a(jSONObject, "bonus", bountyCard.bonus);
            ltc.a(jSONObject, "btn_text", bountyCard.btn_text);
            if (bountyCard.gift_imgs != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : bountyCard.gift_imgs) {
                    jSONArray.put(str);
                }
                ltc.a(jSONObject, "gift_imgs", jSONArray);
            }
            ltc.a(jSONObject, "url", bountyCard.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
