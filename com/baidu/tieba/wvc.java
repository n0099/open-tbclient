package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.LiveFuseForumData;
import tbclient.FrsPage.NovelExt;
import tbclient.TagLabelInfo;
/* loaded from: classes9.dex */
public class wvc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LiveFuseForumData liveFuseForumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, liveFuseForumData)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "online_users", liveFuseForumData.online_users);
            if (liveFuseForumData.head_img != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : liveFuseForumData.head_img) {
                    jSONArray.put(str);
                }
                qoc.a(jSONObject, "head_img", jSONArray);
            }
            if (liveFuseForumData.title != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str2 : liveFuseForumData.title) {
                    jSONArray2.put(str2);
                }
                qoc.a(jSONObject, "title", jSONArray2);
            }
            qoc.a(jSONObject, "schema", liveFuseForumData.schema);
            qoc.a(jSONObject, "type", liveFuseForumData.type);
            qoc.a(jSONObject, "yyext", liveFuseForumData.yyext);
            qoc.a(jSONObject, "icon_url", liveFuseForumData.icon_url);
            qoc.a(jSONObject, "bjimg_dark_big", liveFuseForumData.bjimg_dark_big);
            qoc.a(jSONObject, "bjimg_light_big", liveFuseForumData.bjimg_light_big);
            qoc.a(jSONObject, "bjimg_dark_small", liveFuseForumData.bjimg_dark_small);
            qoc.a(jSONObject, "bjimg_light_small", liveFuseForumData.bjimg_light_small);
            qoc.a(jSONObject, "head_img_style", liveFuseForumData.head_img_style);
            if (liveFuseForumData.label_infos != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (TagLabelInfo tagLabelInfo : liveFuseForumData.label_infos) {
                    jSONArray3.put(f4d.b(tagLabelInfo));
                }
                qoc.a(jSONObject, "label_infos", jSONArray3);
            }
            NovelExt novelExt = liveFuseForumData.novel;
            if (novelExt != null) {
                qoc.a(jSONObject, "novel", fwc.b(novelExt));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
