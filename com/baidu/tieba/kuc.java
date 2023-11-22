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
public class kuc extends qoc {
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
                qoc.a(jSONObject, "icon", xyc.b(iconUrlInfo));
            }
            qoc.a(jSONObject, "title", bountyCard.title);
            qoc.a(jSONObject, SubtitleLog.TAG, bountyCard.subtitle);
            IconUrlInfo iconUrlInfo2 = bountyCard.bg_img;
            if (iconUrlInfo2 != null) {
                qoc.a(jSONObject, "bg_img", xyc.b(iconUrlInfo2));
            }
            qoc.a(jSONObject, "award_type", bountyCard.award_type);
            qoc.a(jSONObject, "bonus", bountyCard.bonus);
            qoc.a(jSONObject, "btn_text", bountyCard.btn_text);
            if (bountyCard.gift_imgs != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : bountyCard.gift_imgs) {
                    jSONArray.put(str);
                }
                qoc.a(jSONObject, "gift_imgs", jSONArray);
            }
            qoc.a(jSONObject, "url", bountyCard.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
