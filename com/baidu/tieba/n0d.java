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
public class n0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Novel novel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, novel)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "book_id", novel.book_id);
            qoc.a(jSONObject, TbEnum.ParamKey.GID, novel.gid);
            qoc.a(jSONObject, "book_name", novel.book_name);
            qoc.a(jSONObject, "author_id", novel.author_id);
            qoc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, novel.author);
            qoc.a(jSONObject, "description", novel.description);
            qoc.a(jSONObject, "last_chapter_id", novel.last_chapter_id);
            qoc.a(jSONObject, "last_chapter_index", novel.last_chapter_index);
            qoc.a(jSONObject, "last_chapter_title", novel.last_chapter_title);
            qoc.a(jSONObject, "last_chapter_page_id", novel.last_chapter_page_id);
            qoc.a(jSONObject, "last_chapter_update_time", novel.last_chapter_update_time);
            qoc.a(jSONObject, "ios_detail_params", novel.ios_detail_params);
            qoc.a(jSONObject, "android_detail_params", novel.android_detail_params);
            qoc.a(jSONObject, "ios_last_charpter_params", novel.ios_last_charpter_params);
            qoc.a(jSONObject, "android_last_charpter_params", novel.android_last_charpter_params);
            qoc.a(jSONObject, "android_last_read_params", novel.android_last_read_params);
            qoc.a(jSONObject, "ios_last_read_params", novel.ios_last_read_params);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
