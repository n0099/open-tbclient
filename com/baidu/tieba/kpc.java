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
public class kpc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AlaLiveInfo alaLiveInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, alaLiveInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "live_id", alaLiveInfo.live_id);
            poc.a(jSONObject, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, alaLiveInfo.cover);
            poc.a(jSONObject, "session_id", alaLiveInfo.session_id);
            poc.a(jSONObject, "rtmp_url", alaLiveInfo.rtmp_url);
            poc.a(jSONObject, "hls_url", alaLiveInfo.hls_url);
            poc.a(jSONObject, "group_id", alaLiveInfo.group_id);
            poc.a(jSONObject, "media_url", alaLiveInfo.media_url);
            poc.a(jSONObject, "media_pic", alaLiveInfo.media_pic);
            poc.a(jSONObject, "media_id", alaLiveInfo.media_id);
            poc.a(jSONObject, "media_subtitle", alaLiveInfo.media_subtitle);
            poc.a(jSONObject, "description", alaLiveInfo.description);
            AlaUserInfo alaUserInfo = alaLiveInfo.user_info;
            if (alaUserInfo != null) {
                poc.a(jSONObject, SourceConstant.SOURCE_USER_INFO, opc.b(alaUserInfo));
            }
            poc.a(jSONObject, "duration", alaLiveInfo.duration);
            poc.a(jSONObject, "audience_count", alaLiveInfo.audience_count);
            poc.a(jSONObject, "live_type", alaLiveInfo.live_type);
            poc.a(jSONObject, "screen_direction", alaLiveInfo.screen_direction);
            poc.a(jSONObject, "label_name", alaLiveInfo.label_name);
            poc.a(jSONObject, IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS, alaLiveInfo.live_status);
            AlaShareInfo alaShareInfo = alaLiveInfo.share_info;
            if (alaShareInfo != null) {
                poc.a(jSONObject, "share_info", mpc.b(alaShareInfo));
            }
            poc.a(jSONObject, "distance", alaLiveInfo.distance);
            poc.a(jSONObject, "third_app_id", alaLiveInfo.third_app_id);
            poc.a(jSONObject, "thread_id", alaLiveInfo.thread_id);
            if (alaLiveInfo.stage_dislike_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (AlaStageDislikeInfo alaStageDislikeInfo : alaLiveInfo.stage_dislike_info) {
                    jSONArray.put(npc.b(alaStageDislikeInfo));
                }
                poc.a(jSONObject, "stage_dislike_info", jSONArray);
            }
            AlaCoverLabel alaCoverLabel = alaLiveInfo.label;
            if (alaCoverLabel != null) {
                poc.a(jSONObject, "label", jpc.b(alaCoverLabel));
            }
            AlaChallengeInfo alaChallengeInfo = alaLiveInfo.challenge_info;
            if (alaChallengeInfo != null) {
                poc.a(jSONObject, "challenge_info", ipc.b(alaChallengeInfo));
            }
            poc.a(jSONObject, "frs_toplive_type", alaLiveInfo.frs_toplive_type);
            poc.a(jSONObject, "frs_toplive_pic", alaLiveInfo.frs_toplive_pic);
            poc.a(jSONObject, "frs_toplive_force", alaLiveInfo.frs_toplive_force);
            poc.a(jSONObject, "live_from", alaLiveInfo.live_from);
            poc.a(jSONObject, "third_room_id", alaLiveInfo.third_room_id);
            poc.a(jSONObject, "router_type", alaLiveInfo.router_type);
            poc.a(jSONObject, "third_live_type", alaLiveInfo.third_live_type);
            poc.a(jSONObject, "first_headline", alaLiveInfo.first_headline);
            poc.a(jSONObject, "second_headline", alaLiveInfo.second_headline);
            poc.a(jSONObject, "pb_display_type", alaLiveInfo.pb_display_type);
            poc.a(jSONObject, "recom_reason", alaLiveInfo.recom_reason);
            poc.a(jSONObject, "open_recom_reason", alaLiveInfo.open_recom_reason);
            poc.a(jSONObject, "open_recom_location", alaLiveInfo.open_recom_location);
            poc.a(jSONObject, "open_recom_fans", alaLiveInfo.open_recom_fans);
            poc.a(jSONObject, "open_recom_duration", alaLiveInfo.open_recom_duration);
            if (alaLiveInfo.dislike_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (DislikeInfo dislikeInfo : alaLiveInfo.dislike_info) {
                    jSONArray2.put(prc.b(dislikeInfo));
                }
                poc.a(jSONObject, "dislike_info", jSONArray2);
            }
            poc.a(jSONObject, "room_id", alaLiveInfo.room_id);
            poc.a(jSONObject, "room_status", alaLiveInfo.room_status);
            poc.a(jSONObject, DpStatConstants.KEY_ROOM_NAME, alaLiveInfo.room_name);
            poc.a(jSONObject, "forum_user_live_msg", alaLiveInfo.forum_user_live_msg);
            poc.a(jSONObject, "cover_wide", alaLiveInfo.cover_wide);
            YyExt yyExt = alaLiveInfo.yy_ext;
            if (yyExt != null) {
                poc.a(jSONObject, "yy_ext", o6d.b(yyExt));
            }
            poc.a(jSONObject, "show_page", alaLiveInfo.show_page);
            UniversalLabel universalLabel = alaLiveInfo.user_label;
            if (universalLabel != null) {
                poc.a(jSONObject, "user_label", l5d.b(universalLabel));
            }
            poc.a(jSONObject, "flv", alaLiveInfo.flv);
            poc.a(jSONObject, "page_from", alaLiveInfo.page_from);
            poc.a(jSONObject, "scheme", alaLiveInfo.scheme);
            WidthHeight widthHeight = alaLiveInfo.player_size;
            if (widthHeight != null) {
                poc.a(jSONObject, "player_size", i6d.b(widthHeight));
            }
            WidthHeight widthHeight2 = alaLiveInfo.container_size;
            if (widthHeight2 != null) {
                poc.a(jSONObject, "container_size", i6d.b(widthHeight2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
