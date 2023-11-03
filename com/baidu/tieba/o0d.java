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
public class o0d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NovelInfo novelInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, novelInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "novel_id", novelInfo.novel_id);
            poc.a(jSONObject, "img", novelInfo.img);
            poc.a(jSONObject, "name", novelInfo.name);
            poc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, novelInfo.author);
            poc.a(jSONObject, "desc", novelInfo.desc);
            poc.a(jSONObject, "discount_price", novelInfo.discount_price);
            poc.a(jSONObject, "percent", novelInfo.percent);
            poc.a(jSONObject, "h5_url", novelInfo.h5_url);
            poc.a(jSONObject, "is_pay", novelInfo.is_pay);
            poc.a(jSONObject, "chapters", novelInfo.chapters);
            poc.a(jSONObject, "member_text", novelInfo.member_text);
            poc.a(jSONObject, "member_img", novelInfo.member_img);
            poc.a(jSONObject, "buy_url", novelInfo.buy_url);
            if (novelInfo.category != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : novelInfo.category) {
                    jSONArray.put(str);
                }
                poc.a(jSONObject, "category", jSONArray);
            }
            poc.a(jSONObject, "story_channel_text", novelInfo.story_channel_text);
            poc.a(jSONObject, "story_channel_url", novelInfo.story_channel_url);
            poc.a(jSONObject, "tourist_text", novelInfo.tourist_text);
            poc.a(jSONObject, "tourist_url", novelInfo.tourist_url);
            poc.a(jSONObject, "reader_text", novelInfo.reader_text);
            poc.a(jSONObject, "from", novelInfo.from);
            poc.a(jSONObject, "yab_type", novelInfo.yab_type);
            poc.a(jSONObject, "bottom_text", novelInfo.bottom_text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
