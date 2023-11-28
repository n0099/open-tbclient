package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AlaChallengeInfo;
import tbclient.AlaCoverLabel;
import tbclient.AlaLiveInfo;
import tbclient.AlaShareInfo;
import tbclient.AlaStageDislikeInfo;
import tbclient.AlaUserInfo;
import tbclient.DislikeInfo;
import tbclient.UniversalLabel;
import tbclient.WidthHeight;
import tbclient.YyExt;
/* loaded from: classes6.dex */
public class iuc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AlaLiveInfo alaLiveInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, alaLiveInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "live_id", alaLiveInfo.live_id);
            ltc.a(jSONObject, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, alaLiveInfo.cover);
            ltc.a(jSONObject, "session_id", alaLiveInfo.session_id);
            ltc.a(jSONObject, "rtmp_url", alaLiveInfo.rtmp_url);
            ltc.a(jSONObject, "hls_url", alaLiveInfo.hls_url);
            ltc.a(jSONObject, "group_id", alaLiveInfo.group_id);
            ltc.a(jSONObject, "media_url", alaLiveInfo.media_url);
            ltc.a(jSONObject, "media_pic", alaLiveInfo.media_pic);
            ltc.a(jSONObject, "media_id", alaLiveInfo.media_id);
            ltc.a(jSONObject, "media_subtitle", alaLiveInfo.media_subtitle);
            ltc.a(jSONObject, "description", alaLiveInfo.description);
            AlaUserInfo alaUserInfo = alaLiveInfo.user_info;
            if (alaUserInfo != null) {
                ltc.a(jSONObject, SourceConstant.SOURCE_USER_INFO, muc.b(alaUserInfo));
            }
            ltc.a(jSONObject, "duration", alaLiveInfo.duration);
            ltc.a(jSONObject, "audience_count", alaLiveInfo.audience_count);
            ltc.a(jSONObject, "live_type", alaLiveInfo.live_type);
            ltc.a(jSONObject, "screen_direction", alaLiveInfo.screen_direction);
            ltc.a(jSONObject, "label_name", alaLiveInfo.label_name);
            ltc.a(jSONObject, IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS, alaLiveInfo.live_status);
            AlaShareInfo alaShareInfo = alaLiveInfo.share_info;
            if (alaShareInfo != null) {
                ltc.a(jSONObject, "share_info", kuc.b(alaShareInfo));
            }
            ltc.a(jSONObject, "distance", alaLiveInfo.distance);
            ltc.a(jSONObject, "third_app_id", alaLiveInfo.third_app_id);
            ltc.a(jSONObject, "thread_id", alaLiveInfo.thread_id);
            if (alaLiveInfo.stage_dislike_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (AlaStageDislikeInfo alaStageDislikeInfo : alaLiveInfo.stage_dislike_info) {
                    jSONArray.put(luc.b(alaStageDislikeInfo));
                }
                ltc.a(jSONObject, "stage_dislike_info", jSONArray);
            }
            AlaCoverLabel alaCoverLabel = alaLiveInfo.label;
            if (alaCoverLabel != null) {
                ltc.a(jSONObject, "label", huc.b(alaCoverLabel));
            }
            AlaChallengeInfo alaChallengeInfo = alaLiveInfo.challenge_info;
            if (alaChallengeInfo != null) {
                ltc.a(jSONObject, "challenge_info", guc.b(alaChallengeInfo));
            }
            ltc.a(jSONObject, "frs_toplive_type", alaLiveInfo.frs_toplive_type);
            ltc.a(jSONObject, "frs_toplive_pic", alaLiveInfo.frs_toplive_pic);
            ltc.a(jSONObject, "frs_toplive_force", alaLiveInfo.frs_toplive_force);
            ltc.a(jSONObject, "live_from", alaLiveInfo.live_from);
            ltc.a(jSONObject, "third_room_id", alaLiveInfo.third_room_id);
            ltc.a(jSONObject, "router_type", alaLiveInfo.router_type);
            ltc.a(jSONObject, "third_live_type", alaLiveInfo.third_live_type);
            ltc.a(jSONObject, "first_headline", alaLiveInfo.first_headline);
            ltc.a(jSONObject, "second_headline", alaLiveInfo.second_headline);
            ltc.a(jSONObject, "pb_display_type", alaLiveInfo.pb_display_type);
            ltc.a(jSONObject, "recom_reason", alaLiveInfo.recom_reason);
            ltc.a(jSONObject, "open_recom_reason", alaLiveInfo.open_recom_reason);
            ltc.a(jSONObject, "open_recom_location", alaLiveInfo.open_recom_location);
            ltc.a(jSONObject, "open_recom_fans", alaLiveInfo.open_recom_fans);
            ltc.a(jSONObject, "open_recom_duration", alaLiveInfo.open_recom_duration);
            if (alaLiveInfo.dislike_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (DislikeInfo dislikeInfo : alaLiveInfo.dislike_info) {
                    jSONArray2.put(owc.b(dislikeInfo));
                }
                ltc.a(jSONObject, "dislike_info", jSONArray2);
            }
            ltc.a(jSONObject, "room_id", alaLiveInfo.room_id);
            ltc.a(jSONObject, "room_status", alaLiveInfo.room_status);
            ltc.a(jSONObject, DpStatConstants.KEY_ROOM_NAME, alaLiveInfo.room_name);
            ltc.a(jSONObject, "forum_user_live_msg", alaLiveInfo.forum_user_live_msg);
            ltc.a(jSONObject, "cover_wide", alaLiveInfo.cover_wide);
            YyExt yyExt = alaLiveInfo.yy_ext;
            if (yyExt != null) {
                ltc.a(jSONObject, "yy_ext", tbd.b(yyExt));
            }
            ltc.a(jSONObject, "show_page", alaLiveInfo.show_page);
            UniversalLabel universalLabel = alaLiveInfo.user_label;
            if (universalLabel != null) {
                ltc.a(jSONObject, "user_label", pad.b(universalLabel));
            }
            ltc.a(jSONObject, "flv", alaLiveInfo.flv);
            ltc.a(jSONObject, "page_from", alaLiveInfo.page_from);
            ltc.a(jSONObject, "scheme", alaLiveInfo.scheme);
            WidthHeight widthHeight = alaLiveInfo.player_size;
            if (widthHeight != null) {
                ltc.a(jSONObject, "player_size", nbd.b(widthHeight));
            }
            WidthHeight widthHeight2 = alaLiveInfo.container_size;
            if (widthHeight2 != null) {
                ltc.a(jSONObject, "container_size", nbd.b(widthHeight2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
