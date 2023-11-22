package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.subtitle.SubtitleLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.CoverImageColor;
import tbclient.FrsPage.HeadImgs;
import tbclient.FrsPage.VideoImageColor;
/* loaded from: classes8.dex */
public class rvc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static HeadImgs b(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        JSONArray optJSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            HeadImgs.Builder builder = new HeadImgs.Builder();
            if (jSONObject.has(BigdayActivityConfig.IMG_URL)) {
                builder.img_url = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            }
            if (jSONObject.has("pc_url")) {
                builder.pc_url = jSONObject.optString("pc_url");
            }
            if (jSONObject.has("title")) {
                builder.title = jSONObject.optString("title");
            }
            if (jSONObject.has(SubtitleLog.TAG)) {
                builder.subtitle = jSONObject.optString(SubtitleLog.TAG);
            }
            if (jSONObject.has("btn_text")) {
                builder.btn_text = jSONObject.optString("btn_text");
            }
            if (jSONObject.has("tag_name_url")) {
                builder.tag_name_url = jSONObject.optString("tag_name_url");
            }
            if (jSONObject.has("tag_name_wh")) {
                builder.tag_name_wh = jSONObject.optString("tag_name_wh");
            }
            if (jSONObject.has("schema")) {
                builder.schema = jSONObject.optString("schema");
            }
            if (jSONObject.has("third_statistics_url") && (optJSONArray2 = jSONObject.optJSONArray("third_statistics_url")) != null) {
                builder.third_statistics_url = new ArrayList();
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    builder.third_statistics_url.add(optJSONArray2.optString(i));
                }
            }
            if (jSONObject.has("has_second_page")) {
                builder.has_second_page = Integer.valueOf(jSONObject.optInt("has_second_page"));
            }
            if (jSONObject.has("package_name")) {
                builder.package_name = jSONObject.optString("package_name");
            }
            if (jSONObject.has("download_is_thirdpage")) {
                builder.download_is_thirdpage = Integer.valueOf(jSONObject.optInt("download_is_thirdpage"));
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
            if (jSONObject.has("download_privacy_policy")) {
                builder.download_privacy_policy = jSONObject.optString("download_privacy_policy");
            }
            if (jSONObject.has("download_package_name")) {
                builder.download_package_name = jSONObject.optString("download_package_name");
            }
            if (jSONObject.has("download_item_id")) {
                builder.download_item_id = Integer.valueOf(jSONObject.optInt("download_item_id"));
            }
            if (jSONObject.has("download_appid")) {
                builder.download_appid = jSONObject.optString("download_appid");
            }
            if (jSONObject.has(NetDiskFileMsg.NetDiskFile.JSON_KEY_COVER_URL)) {
                builder.cover_url = jSONObject.optString(NetDiskFileMsg.NetDiskFile.JSON_KEY_COVER_URL);
            }
            if (jSONObject.has("play_url")) {
                builder.play_url = jSONObject.optString("play_url");
            }
            if (jSONObject.has("cover_image_color") && (optJSONObject = jSONObject.optJSONObject("cover_image_color")) != null) {
                builder.cover_image_color = wuc.b(optJSONObject);
            }
            if (jSONObject.has("video_image_color") && (optJSONArray = jSONObject.optJSONArray("video_image_color")) != null) {
                builder.video_image_color = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject2 != null) {
                        builder.video_image_color.add(txc.b(optJSONObject2));
                    }
                }
            }
            if (jSONObject.has("type")) {
                builder.type = Integer.valueOf(jSONObject.optInt("type"));
            }
            return builder.build(true);
        }
        return (HeadImgs) invokeL.objValue;
    }

    @NonNull
    public static JSONObject c(@NonNull HeadImgs headImgs) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, headImgs)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, BigdayActivityConfig.IMG_URL, headImgs.img_url);
            qoc.a(jSONObject, "pc_url", headImgs.pc_url);
            qoc.a(jSONObject, "title", headImgs.title);
            qoc.a(jSONObject, SubtitleLog.TAG, headImgs.subtitle);
            qoc.a(jSONObject, "btn_text", headImgs.btn_text);
            qoc.a(jSONObject, "tag_name_url", headImgs.tag_name_url);
            qoc.a(jSONObject, "tag_name_wh", headImgs.tag_name_wh);
            qoc.a(jSONObject, "schema", headImgs.schema);
            if (headImgs.third_statistics_url != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : headImgs.third_statistics_url) {
                    jSONArray.put(str);
                }
                qoc.a(jSONObject, "third_statistics_url", jSONArray);
            }
            qoc.a(jSONObject, "has_second_page", headImgs.has_second_page);
            qoc.a(jSONObject, "package_name", headImgs.package_name);
            qoc.a(jSONObject, "download_is_thirdpage", headImgs.download_is_thirdpage);
            qoc.a(jSONObject, "download_appname", headImgs.download_appname);
            qoc.a(jSONObject, "download_developer", headImgs.download_developer);
            qoc.a(jSONObject, "download_package_size", headImgs.download_package_size);
            qoc.a(jSONObject, "download_url", headImgs.download_url);
            qoc.a(jSONObject, "download_img", headImgs.download_img);
            qoc.a(jSONObject, "download_version", headImgs.download_version);
            qoc.a(jSONObject, "download_user_power", headImgs.download_user_power);
            qoc.a(jSONObject, "download_privacy_policy", headImgs.download_privacy_policy);
            qoc.a(jSONObject, "download_package_name", headImgs.download_package_name);
            qoc.a(jSONObject, "download_item_id", headImgs.download_item_id);
            qoc.a(jSONObject, "download_appid", headImgs.download_appid);
            qoc.a(jSONObject, NetDiskFileMsg.NetDiskFile.JSON_KEY_COVER_URL, headImgs.cover_url);
            qoc.a(jSONObject, "play_url", headImgs.play_url);
            CoverImageColor coverImageColor = headImgs.cover_image_color;
            if (coverImageColor != null) {
                qoc.a(jSONObject, "cover_image_color", wuc.c(coverImageColor));
            }
            if (headImgs.video_image_color != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (VideoImageColor videoImageColor : headImgs.video_image_color) {
                    jSONArray2.put(txc.c(videoImageColor));
                }
                qoc.a(jSONObject, "video_image_color", jSONArray2);
            }
            qoc.a(jSONObject, "type", headImgs.type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
