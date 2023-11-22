package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.NovelInfo;
/* loaded from: classes7.dex */
public class p0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NovelInfo novelInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, novelInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "novel_id", novelInfo.novel_id);
            qoc.a(jSONObject, "img", novelInfo.img);
            qoc.a(jSONObject, "name", novelInfo.name);
            qoc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, novelInfo.author);
            qoc.a(jSONObject, "desc", novelInfo.desc);
            qoc.a(jSONObject, "discount_price", novelInfo.discount_price);
            qoc.a(jSONObject, "percent", novelInfo.percent);
            qoc.a(jSONObject, "h5_url", novelInfo.h5_url);
            qoc.a(jSONObject, "is_pay", novelInfo.is_pay);
            qoc.a(jSONObject, "chapters", novelInfo.chapters);
            qoc.a(jSONObject, "member_text", novelInfo.member_text);
            qoc.a(jSONObject, "member_img", novelInfo.member_img);
            qoc.a(jSONObject, "buy_url", novelInfo.buy_url);
            if (novelInfo.category != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : novelInfo.category) {
                    jSONArray.put(str);
                }
                qoc.a(jSONObject, "category", jSONArray);
            }
            qoc.a(jSONObject, "story_channel_text", novelInfo.story_channel_text);
            qoc.a(jSONObject, "story_channel_url", novelInfo.story_channel_url);
            qoc.a(jSONObject, "tourist_text", novelInfo.tourist_text);
            qoc.a(jSONObject, "tourist_url", novelInfo.tourist_url);
            qoc.a(jSONObject, "reader_text", novelInfo.reader_text);
            qoc.a(jSONObject, "from", novelInfo.from);
            qoc.a(jSONObject, "yab_type", novelInfo.yab_type);
            qoc.a(jSONObject, "bottom_text", novelInfo.bottom_text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
