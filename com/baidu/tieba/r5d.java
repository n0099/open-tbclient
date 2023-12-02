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
public class r5d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NovelInfo novelInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, novelInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "novel_id", novelInfo.novel_id);
            ktc.a(jSONObject, "img", novelInfo.img);
            ktc.a(jSONObject, "name", novelInfo.name);
            ktc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, novelInfo.author);
            ktc.a(jSONObject, "desc", novelInfo.desc);
            ktc.a(jSONObject, "discount_price", novelInfo.discount_price);
            ktc.a(jSONObject, "percent", novelInfo.percent);
            ktc.a(jSONObject, "h5_url", novelInfo.h5_url);
            ktc.a(jSONObject, "is_pay", novelInfo.is_pay);
            ktc.a(jSONObject, "chapters", novelInfo.chapters);
            ktc.a(jSONObject, "member_text", novelInfo.member_text);
            ktc.a(jSONObject, "member_img", novelInfo.member_img);
            ktc.a(jSONObject, "buy_url", novelInfo.buy_url);
            if (novelInfo.category != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : novelInfo.category) {
                    jSONArray.put(str);
                }
                ktc.a(jSONObject, "category", jSONArray);
            }
            ktc.a(jSONObject, "story_channel_text", novelInfo.story_channel_text);
            ktc.a(jSONObject, "story_channel_url", novelInfo.story_channel_url);
            ktc.a(jSONObject, "tourist_text", novelInfo.tourist_text);
            ktc.a(jSONObject, "tourist_url", novelInfo.tourist_url);
            ktc.a(jSONObject, "reader_text", novelInfo.reader_text);
            ktc.a(jSONObject, "from", novelInfo.from);
            ktc.a(jSONObject, "yab_type", novelInfo.yab_type);
            ktc.a(jSONObject, "bottom_text", novelInfo.bottom_text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
