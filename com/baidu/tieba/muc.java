package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.BusinessPromot;
import tbclient.FrsPage.BusinessPromotCommentList;
/* loaded from: classes7.dex */
public class muc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static BusinessPromot b(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            BusinessPromot.Builder builder = new BusinessPromot.Builder();
            if (jSONObject.has("title")) {
                builder.title = jSONObject.optString("title");
            }
            if (jSONObject.has("img")) {
                builder.img = jSONObject.optString("img");
            }
            if (jSONObject.has("img_popup")) {
                builder.img_popup = jSONObject.optString("img_popup");
            }
            if (jSONObject.has("type")) {
                builder.type = Integer.valueOf(jSONObject.optInt("type"));
            }
            if (jSONObject.has("thread_id")) {
                builder.thread_id = jSONObject.optString("thread_id");
            }
            if (jSONObject.has("url")) {
                builder.url = jSONObject.optString("url");
            }
            if (jSONObject.has("join_num")) {
                builder.join_num = Integer.valueOf(jSONObject.optInt("join_num"));
            }
            if (jSONObject.has("comment_list") && (optJSONArray2 = jSONObject.optJSONArray("comment_list")) != null) {
                builder.comment_list = new ArrayList();
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i);
                    if (optJSONObject != null) {
                        builder.comment_list.add(luc.b(optJSONObject));
                    }
                }
            }
            if (jSONObject.has("id")) {
                builder.id = Long.valueOf(jSONObject.optLong("id"));
            }
            if (jSONObject.has("thread_type")) {
                builder.thread_type = Integer.valueOf(jSONObject.optInt("thread_type"));
            }
            if (jSONObject.has("schema")) {
                builder.schema = jSONObject.optString("schema");
            }
            if (jSONObject.has("third_statistics_url") && (optJSONArray = jSONObject.optJSONArray("third_statistics_url")) != null) {
                builder.third_statistics_url = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    builder.third_statistics_url.add(optJSONArray.optString(i2));
                }
            }
            if (jSONObject.has("is_allow_shake")) {
                builder.is_allow_shake = Boolean.valueOf(jSONObject.optBoolean("is_allow_shake"));
            }
            if (jSONObject.has("is_ad")) {
                builder.is_ad = Boolean.valueOf(jSONObject.optBoolean("is_ad"));
            }
            if (jSONObject.has("package_name")) {
                builder.package_name = jSONObject.optString("package_name");
            }
            if (jSONObject.has("download_appname")) {
                builder.download_appname = jSONObject.optString("download_appname");
            }
            if (jSONObject.has("download_developer")) {
                builder.download_developer = jSONObject.optString("download_developer");
            }
            if (jSONObject.has("download_package_size")) {
                builder.download_package_size = jSONObject.optString("download_package_size");
            }
            if (jSONObject.has("download_privacy_policy")) {
                builder.download_privacy_policy = jSONObject.optString("download_privacy_policy");
            }
            if (jSONObject.has("download_url")) {
                builder.download_url = jSONObject.optString("download_url");
            }
            if (jSONObject.has("download_img")) {
                builder.download_img = jSONObject.optString("download_img");
            }
            if (jSONObject.has("download_version")) {
                builder.download_version = jSONObject.optString("download_version");
            }
            if (jSONObject.has("download_user_power")) {
                builder.download_user_power = jSONObject.optString("download_user_power");
            }
            if (jSONObject.has("is_download")) {
                builder.is_download = Boolean.valueOf(jSONObject.optBoolean("is_download"));
            }
            if (jSONObject.has("download_item_id")) {
                builder.download_item_id = jSONObject.optString("download_item_id");
            }
            if (jSONObject.has("download_package_name")) {
                builder.download_package_name = jSONObject.optString("download_package_name");
            }
            if (jSONObject.has("download_appid")) {
                builder.download_appid = jSONObject.optString("download_appid");
            }
            if (jSONObject.has(NetDiskFileMsg.NetDiskFile.JSON_KEY_COVER_URL)) {
                builder.cover_url = jSONObject.optString(NetDiskFileMsg.NetDiskFile.JSON_KEY_COVER_URL);
            }
            if (jSONObject.has("video_url")) {
                builder.video_url = jSONObject.optString("video_url");
            }
            if (jSONObject.has("ban_dialog")) {
                builder.ban_dialog = Integer.valueOf(jSONObject.optInt("ban_dialog"));
            }
            if (jSONObject.has("download_effect")) {
                builder.download_effect = jSONObject.optString("download_effect");
            }
            return builder.build(true);
        }
        return (BusinessPromot) invokeL.objValue;
    }

    @NonNull
    public static JSONObject c(@NonNull BusinessPromot businessPromot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, businessPromot)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "title", businessPromot.title);
            poc.a(jSONObject, "img", businessPromot.img);
            poc.a(jSONObject, "img_popup", businessPromot.img_popup);
            poc.a(jSONObject, "type", businessPromot.type);
            poc.a(jSONObject, "thread_id", businessPromot.thread_id);
            poc.a(jSONObject, "url", businessPromot.url);
            poc.a(jSONObject, "join_num", businessPromot.join_num);
            if (businessPromot.comment_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (BusinessPromotCommentList businessPromotCommentList : businessPromot.comment_list) {
                    jSONArray.put(luc.c(businessPromotCommentList));
                }
                poc.a(jSONObject, "comment_list", jSONArray);
            }
            poc.a(jSONObject, "id", businessPromot.id);
            poc.a(jSONObject, "thread_type", businessPromot.thread_type);
            poc.a(jSONObject, "schema", businessPromot.schema);
            if (businessPromot.third_statistics_url != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : businessPromot.third_statistics_url) {
                    jSONArray2.put(str);
                }
                poc.a(jSONObject, "third_statistics_url", jSONArray2);
            }
            poc.a(jSONObject, "is_allow_shake", businessPromot.is_allow_shake);
            poc.a(jSONObject, "is_ad", businessPromot.is_ad);
            poc.a(jSONObject, "package_name", businessPromot.package_name);
            poc.a(jSONObject, "download_appname", businessPromot.download_appname);
            poc.a(jSONObject, "download_developer", businessPromot.download_developer);
            poc.a(jSONObject, "download_package_size", businessPromot.download_package_size);
            poc.a(jSONObject, "download_privacy_policy", businessPromot.download_privacy_policy);
            poc.a(jSONObject, "download_url", businessPromot.download_url);
            poc.a(jSONObject, "download_img", businessPromot.download_img);
            poc.a(jSONObject, "download_version", businessPromot.download_version);
            poc.a(jSONObject, "download_user_power", businessPromot.download_user_power);
            poc.a(jSONObject, "is_download", businessPromot.is_download);
            poc.a(jSONObject, "download_item_id", businessPromot.download_item_id);
            poc.a(jSONObject, "download_package_name", businessPromot.download_package_name);
            poc.a(jSONObject, "download_appid", businessPromot.download_appid);
            poc.a(jSONObject, NetDiskFileMsg.NetDiskFile.JSON_KEY_COVER_URL, businessPromot.cover_url);
            poc.a(jSONObject, "video_url", businessPromot.video_url);
            poc.a(jSONObject, "ban_dialog", businessPromot.ban_dialog);
            poc.a(jSONObject, "download_effect", businessPromot.download_effect);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
