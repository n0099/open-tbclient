package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.McnAdInfo;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class z5d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VideoInfo videoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, videoInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, VideoFinishResult.KEY_VIDEO_MD5, videoInfo.video_md5);
            qoc.a(jSONObject, "video_url", videoInfo.video_url);
            qoc.a(jSONObject, AdWebVideoActivityConfig.KEY_VIDEO_DURATION, videoInfo.video_duration);
            qoc.a(jSONObject, "video_width", videoInfo.video_width);
            qoc.a(jSONObject, "video_height", videoInfo.video_height);
            qoc.a(jSONObject, "thumbnail_url", videoInfo.thumbnail_url);
            qoc.a(jSONObject, "thumbnail_width", videoInfo.thumbnail_width);
            qoc.a(jSONObject, "thumbnail_height", videoInfo.thumbnail_height);
            qoc.a(jSONObject, "video_length", videoInfo.video_length);
            qoc.a(jSONObject, "play_count", videoInfo.play_count);
            qoc.a(jSONObject, "media_subtitle", videoInfo.media_subtitle);
            if (videoInfo.video_desc != null) {
                JSONArray jSONArray = new JSONArray();
                for (VideoDesc videoDesc : videoInfo.video_desc) {
                    jSONArray.put(x5d.b(videoDesc));
                }
                qoc.a(jSONObject, "video_desc", jSONArray);
            }
            qoc.a(jSONObject, "video_select_flag", videoInfo.video_select_flag);
            qoc.a(jSONObject, "video_type", videoInfo.video_type);
            qoc.a(jSONObject, TiebaStatic.Params.IS_VERTICAL, videoInfo.is_vertical);
            VideoDesc videoDesc2 = videoInfo.video_h265;
            if (videoDesc2 != null) {
                qoc.a(jSONObject, "video_h265", x5d.b(videoDesc2));
            }
            qoc.a(jSONObject, "mcn_lead_page", videoInfo.mcn_lead_page);
            McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
            if (mcnAdInfo != null) {
                qoc.a(jSONObject, "mcn_ad_card", yzc.b(mcnAdInfo));
            }
            qoc.a(jSONObject, "wth_mid_loc", videoInfo.wth_mid_loc);
            qoc.a(jSONObject, "hth_mid_loc", videoInfo.hth_mid_loc);
            qoc.a(jSONObject, "small_thumbnail_url", videoInfo.small_thumbnail_url);
            qoc.a(jSONObject, "first_frame_thumbnail", videoInfo.first_frame_thumbnail);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
