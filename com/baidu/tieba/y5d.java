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
public class y5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VideoInfo videoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, videoInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, VideoFinishResult.KEY_VIDEO_MD5, videoInfo.video_md5);
            poc.a(jSONObject, "video_url", videoInfo.video_url);
            poc.a(jSONObject, AdWebVideoActivityConfig.KEY_VIDEO_DURATION, videoInfo.video_duration);
            poc.a(jSONObject, "video_width", videoInfo.video_width);
            poc.a(jSONObject, "video_height", videoInfo.video_height);
            poc.a(jSONObject, "thumbnail_url", videoInfo.thumbnail_url);
            poc.a(jSONObject, "thumbnail_width", videoInfo.thumbnail_width);
            poc.a(jSONObject, "thumbnail_height", videoInfo.thumbnail_height);
            poc.a(jSONObject, "video_length", videoInfo.video_length);
            poc.a(jSONObject, "play_count", videoInfo.play_count);
            poc.a(jSONObject, "media_subtitle", videoInfo.media_subtitle);
            if (videoInfo.video_desc != null) {
                JSONArray jSONArray = new JSONArray();
                for (VideoDesc videoDesc : videoInfo.video_desc) {
                    jSONArray.put(w5d.b(videoDesc));
                }
                poc.a(jSONObject, "video_desc", jSONArray);
            }
            poc.a(jSONObject, "video_select_flag", videoInfo.video_select_flag);
            poc.a(jSONObject, "video_type", videoInfo.video_type);
            poc.a(jSONObject, TiebaStatic.Params.IS_VERTICAL, videoInfo.is_vertical);
            VideoDesc videoDesc2 = videoInfo.video_h265;
            if (videoDesc2 != null) {
                poc.a(jSONObject, "video_h265", w5d.b(videoDesc2));
            }
            poc.a(jSONObject, "mcn_lead_page", videoInfo.mcn_lead_page);
            McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
            if (mcnAdInfo != null) {
                poc.a(jSONObject, "mcn_ad_card", xzc.b(mcnAdInfo));
            }
            poc.a(jSONObject, "wth_mid_loc", videoInfo.wth_mid_loc);
            poc.a(jSONObject, "hth_mid_loc", videoInfo.hth_mid_loc);
            poc.a(jSONObject, "small_thumbnail_url", videoInfo.small_thumbnail_url);
            poc.a(jSONObject, "first_frame_thumbnail", videoInfo.first_frame_thumbnail);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
