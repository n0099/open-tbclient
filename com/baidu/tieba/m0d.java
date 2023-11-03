package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Novel;
/* loaded from: classes7.dex */
public class m0d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Novel novel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, novel)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "book_id", novel.book_id);
            poc.a(jSONObject, TbEnum.ParamKey.GID, novel.gid);
            poc.a(jSONObject, "book_name", novel.book_name);
            poc.a(jSONObject, "author_id", novel.author_id);
            poc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, novel.author);
            poc.a(jSONObject, "description", novel.description);
            poc.a(jSONObject, "last_chapter_id", novel.last_chapter_id);
            poc.a(jSONObject, "last_chapter_index", novel.last_chapter_index);
            poc.a(jSONObject, "last_chapter_title", novel.last_chapter_title);
            poc.a(jSONObject, "last_chapter_page_id", novel.last_chapter_page_id);
            poc.a(jSONObject, "last_chapter_update_time", novel.last_chapter_update_time);
            poc.a(jSONObject, "ios_detail_params", novel.ios_detail_params);
            poc.a(jSONObject, "android_detail_params", novel.android_detail_params);
            poc.a(jSONObject, "ios_last_charpter_params", novel.ios_last_charpter_params);
            poc.a(jSONObject, "android_last_charpter_params", novel.android_last_charpter_params);
            poc.a(jSONObject, "android_last_read_params", novel.android_last_read_params);
            poc.a(jSONObject, "ios_last_read_params", novel.ios_last_read_params);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
