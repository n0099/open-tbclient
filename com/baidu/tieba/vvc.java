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
/* loaded from: classes8.dex */
public class vvc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LiveFuseForumData liveFuseForumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, liveFuseForumData)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "online_users", liveFuseForumData.online_users);
            if (liveFuseForumData.head_img != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : liveFuseForumData.head_img) {
                    jSONArray.put(str);
                }
                poc.a(jSONObject, "head_img", jSONArray);
            }
            if (liveFuseForumData.title != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str2 : liveFuseForumData.title) {
                    jSONArray2.put(str2);
                }
                poc.a(jSONObject, "title", jSONArray2);
            }
            poc.a(jSONObject, "schema", liveFuseForumData.schema);
            poc.a(jSONObject, "type", liveFuseForumData.type);
            poc.a(jSONObject, "yyext", liveFuseForumData.yyext);
            poc.a(jSONObject, "icon_url", liveFuseForumData.icon_url);
            poc.a(jSONObject, "bjimg_dark_big", liveFuseForumData.bjimg_dark_big);
            poc.a(jSONObject, "bjimg_light_big", liveFuseForumData.bjimg_light_big);
            poc.a(jSONObject, "bjimg_dark_small", liveFuseForumData.bjimg_dark_small);
            poc.a(jSONObject, "bjimg_light_small", liveFuseForumData.bjimg_light_small);
            poc.a(jSONObject, "head_img_style", liveFuseForumData.head_img_style);
            if (liveFuseForumData.label_infos != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (TagLabelInfo tagLabelInfo : liveFuseForumData.label_infos) {
                    jSONArray3.put(e4d.b(tagLabelInfo));
                }
                poc.a(jSONObject, "label_infos", jSONArray3);
            }
            NovelExt novelExt = liveFuseForumData.novel;
            if (novelExt != null) {
                poc.a(jSONObject, "novel", ewc.b(novelExt));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
