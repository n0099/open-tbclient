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
public class v0d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LiveFuseForumData liveFuseForumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, liveFuseForumData)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "online_users", liveFuseForumData.online_users);
            if (liveFuseForumData.head_img != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : liveFuseForumData.head_img) {
                    jSONArray.put(str);
                }
                ktc.a(jSONObject, "head_img", jSONArray);
            }
            if (liveFuseForumData.title != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str2 : liveFuseForumData.title) {
                    jSONArray2.put(str2);
                }
                ktc.a(jSONObject, "title", jSONArray2);
            }
            ktc.a(jSONObject, "schema", liveFuseForumData.schema);
            ktc.a(jSONObject, "type", liveFuseForumData.type);
            ktc.a(jSONObject, "yyext", liveFuseForumData.yyext);
            ktc.a(jSONObject, "icon_url", liveFuseForumData.icon_url);
            ktc.a(jSONObject, "bjimg_dark_big", liveFuseForumData.bjimg_dark_big);
            ktc.a(jSONObject, "bjimg_light_big", liveFuseForumData.bjimg_light_big);
            ktc.a(jSONObject, "bjimg_dark_small", liveFuseForumData.bjimg_dark_small);
            ktc.a(jSONObject, "bjimg_light_small", liveFuseForumData.bjimg_light_small);
            ktc.a(jSONObject, "head_img_style", liveFuseForumData.head_img_style);
            if (liveFuseForumData.label_infos != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (TagLabelInfo tagLabelInfo : liveFuseForumData.label_infos) {
                    jSONArray3.put(h9d.b(tagLabelInfo));
                }
                ktc.a(jSONObject, "label_infos", jSONArray3);
            }
            NovelExt novelExt = liveFuseForumData.novel;
            if (novelExt != null) {
                ktc.a(jSONObject, "novel", f1d.b(novelExt));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
