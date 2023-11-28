package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.NovelInfo;
/* loaded from: classes8.dex */
public class s5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NovelInfo novelInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, novelInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "novel_id", novelInfo.novel_id);
            ltc.a(jSONObject, "img", novelInfo.img);
            ltc.a(jSONObject, "name", novelInfo.name);
            ltc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, novelInfo.author);
            ltc.a(jSONObject, "desc", novelInfo.desc);
            ltc.a(jSONObject, "discount_price", novelInfo.discount_price);
            ltc.a(jSONObject, "percent", novelInfo.percent);
            ltc.a(jSONObject, "h5_url", novelInfo.h5_url);
            ltc.a(jSONObject, "is_pay", novelInfo.is_pay);
            ltc.a(jSONObject, "chapters", novelInfo.chapters);
            ltc.a(jSONObject, "member_text", novelInfo.member_text);
            ltc.a(jSONObject, "member_img", novelInfo.member_img);
            ltc.a(jSONObject, "buy_url", novelInfo.buy_url);
            if (novelInfo.category != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : novelInfo.category) {
                    jSONArray.put(str);
                }
                ltc.a(jSONObject, "category", jSONArray);
            }
            ltc.a(jSONObject, "story_channel_text", novelInfo.story_channel_text);
            ltc.a(jSONObject, "story_channel_url", novelInfo.story_channel_url);
            ltc.a(jSONObject, "tourist_text", novelInfo.tourist_text);
            ltc.a(jSONObject, "tourist_url", novelInfo.tourist_url);
            ltc.a(jSONObject, "reader_text", novelInfo.reader_text);
            ltc.a(jSONObject, "from", novelInfo.from);
            ltc.a(jSONObject, "yab_type", novelInfo.yab_type);
            ltc.a(jSONObject, "bottom_text", novelInfo.bottom_text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
