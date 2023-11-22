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
/* loaded from: classes7.dex */
public class lpc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AlaLiveInfo alaLiveInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, alaLiveInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "live_id", alaLiveInfo.live_id);
            qoc.a(jSONObject, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, alaLiveInfo.cover);
            qoc.a(jSONObject, "session_id", alaLiveInfo.session_id);
            qoc.a(jSONObject, "rtmp_url", alaLiveInfo.rtmp_url);
            qoc.a(jSONObject, "hls_url", alaLiveInfo.hls_url);
            qoc.a(jSONObject, "group_id", alaLiveInfo.group_id);
            qoc.a(jSONObject, "media_url", alaLiveInfo.media_url);
            qoc.a(jSONObject, "media_pic", alaLiveInfo.media_pic);
            qoc.a(jSONObject, "media_id", alaLiveInfo.media_id);
            qoc.a(jSONObject, "media_subtitle", alaLiveInfo.media_subtitle);
            qoc.a(jSONObject, "description", alaLiveInfo.description);
            AlaUserInfo alaUserInfo = alaLiveInfo.user_info;
            if (alaUserInfo != null) {
                qoc.a(jSONObject, SourceConstant.SOURCE_USER_INFO, ppc.b(alaUserInfo));
            }
            qoc.a(jSONObject, "duration", alaLiveInfo.duration);
            qoc.a(jSONObject, "audience_count", alaLiveInfo.audience_count);
            qoc.a(jSONObject, "live_type", alaLiveInfo.live_type);
            qoc.a(jSONObject, "screen_direction", alaLiveInfo.screen_direction);
            qoc.a(jSONObject, "label_name", alaLiveInfo.label_name);
            qoc.a(jSONObject, IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS, alaLiveInfo.live_status);
            AlaShareInfo alaShareInfo = alaLiveInfo.share_info;
            if (alaShareInfo != null) {
                qoc.a(jSONObject, "share_info", npc.b(alaShareInfo));
            }
            qoc.a(jSONObject, "distance", alaLiveInfo.distance);
            qoc.a(jSONObject, "third_app_id", alaLiveInfo.third_app_id);
            qoc.a(jSONObject, "thread_id", alaLiveInfo.thread_id);
            if (alaLiveInfo.stage_dislike_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (AlaStageDislikeInfo alaStageDislikeInfo : alaLiveInfo.stage_dislike_info) {
                    jSONArray.put(opc.b(alaStageDislikeInfo));
                }
                qoc.a(jSONObject, "stage_dislike_info", jSONArray);
            }
            AlaCoverLabel alaCoverLabel = alaLiveInfo.label;
            if (alaCoverLabel != null) {
                qoc.a(jSONObject, "label", kpc.b(alaCoverLabel));
            }
            AlaChallengeInfo alaChallengeInfo = alaLiveInfo.challenge_info;
            if (alaChallengeInfo != null) {
                qoc.a(jSONObject, "challenge_info", jpc.b(alaChallengeInfo));
            }
            qoc.a(jSONObject, "frs_toplive_type", alaLiveInfo.frs_toplive_type);
            qoc.a(jSONObject, "frs_toplive_pic", alaLiveInfo.frs_toplive_pic);
            qoc.a(jSONObject, "frs_toplive_force", alaLiveInfo.frs_toplive_force);
            qoc.a(jSONObject, "live_from", alaLiveInfo.live_from);
            qoc.a(jSONObject, "third_room_id", alaLiveInfo.third_room_id);
            qoc.a(jSONObject, "router_type", alaLiveInfo.router_type);
            qoc.a(jSONObject, "third_live_type", alaLiveInfo.third_live_type);
            qoc.a(jSONObject, "first_headline", alaLiveInfo.first_headline);
            qoc.a(jSONObject, "second_headline", alaLiveInfo.second_headline);
            qoc.a(jSONObject, "pb_display_type", alaLiveInfo.pb_display_type);
            qoc.a(jSONObject, "recom_reason", alaLiveInfo.recom_reason);
            qoc.a(jSONObject, "open_recom_reason", alaLiveInfo.open_recom_reason);
            qoc.a(jSONObject, "open_recom_location", alaLiveInfo.open_recom_location);
            qoc.a(jSONObject, "open_recom_fans", alaLiveInfo.open_recom_fans);
            qoc.a(jSONObject, "open_recom_duration", alaLiveInfo.open_recom_duration);
            if (alaLiveInfo.dislike_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (DislikeInfo dislikeInfo : alaLiveInfo.dislike_info) {
                    jSONArray2.put(qrc.b(dislikeInfo));
                }
                qoc.a(jSONObject, "dislike_info", jSONArray2);
            }
            qoc.a(jSONObject, "room_id", alaLiveInfo.room_id);
            qoc.a(jSONObject, "room_status", alaLiveInfo.room_status);
            qoc.a(jSONObject, DpStatConstants.KEY_ROOM_NAME, alaLiveInfo.room_name);
            qoc.a(jSONObject, "forum_user_live_msg", alaLiveInfo.forum_user_live_msg);
            qoc.a(jSONObject, "cover_wide", alaLiveInfo.cover_wide);
            YyExt yyExt = alaLiveInfo.yy_ext;
            if (yyExt != null) {
                qoc.a(jSONObject, "yy_ext", p6d.b(yyExt));
            }
            qoc.a(jSONObject, "show_page", alaLiveInfo.show_page);
            UniversalLabel universalLabel = alaLiveInfo.user_label;
            if (universalLabel != null) {
                qoc.a(jSONObject, "user_label", m5d.b(universalLabel));
            }
            qoc.a(jSONObject, "flv", alaLiveInfo.flv);
            qoc.a(jSONObject, "page_from", alaLiveInfo.page_from);
            qoc.a(jSONObject, "scheme", alaLiveInfo.scheme);
            WidthHeight widthHeight = alaLiveInfo.player_size;
            if (widthHeight != null) {
                qoc.a(jSONObject, "player_size", j6d.b(widthHeight));
            }
            WidthHeight widthHeight2 = alaLiveInfo.container_size;
            if (widthHeight2 != null) {
                qoc.a(jSONObject, "container_size", j6d.b(widthHeight2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
