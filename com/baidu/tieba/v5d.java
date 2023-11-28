package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.Agree;
import tbclient.AlaLiveInfo;
import tbclient.Baijiahao;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.Media;
import tbclient.OriginThreadInfo;
import tbclient.PbContent;
import tbclient.PbLinkInfo;
import tbclient.PollInfo;
import tbclient.User;
import tbclient.VideoInfo;
import tbclient.Voice;
/* loaded from: classes8.dex */
public class v5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull OriginThreadInfo originThreadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, originThreadInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "title", originThreadInfo.title);
            if (originThreadInfo.media != null) {
                JSONArray jSONArray = new JSONArray();
                for (Media media : originThreadInfo.media) {
                    jSONArray.put(c5d.b(media));
                }
                ltc.a(jSONObject, "media", jSONArray);
            }
            if (originThreadInfo._abstract != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Abstract r3 : originThreadInfo._abstract) {
                    jSONArray2.put(otc.b(r3));
                }
                ltc.a(jSONObject, "abstract", jSONArray2);
            }
            ltc.a(jSONObject, "fname", originThreadInfo.fname);
            ltc.a(jSONObject, "tid", originThreadInfo.tid);
            AlaLiveInfo alaLiveInfo = originThreadInfo.ala_info;
            if (alaLiveInfo != null) {
                ltc.a(jSONObject, "ala_info", iuc.b(alaLiveInfo));
            }
            ltc.a(jSONObject, "fid", originThreadInfo.fid);
            ltc.a(jSONObject, "thread_type", originThreadInfo.thread_type);
            ltc.a(jSONObject, "is_deleted", originThreadInfo.is_deleted);
            ltc.a(jSONObject, "is_ugc", originThreadInfo.is_ugc);
            Baijiahao baijiahao = originThreadInfo.ori_ugc_info;
            if (baijiahao != null) {
                ltc.a(jSONObject, "ori_ugc_info", zuc.b(baijiahao));
            }
            if (originThreadInfo.voice_info != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Voice voice : originThreadInfo.voice_info) {
                    jSONArray3.put(jbd.b(voice));
                }
                ltc.a(jSONObject, "voice_info", jSONArray3);
            }
            VideoInfo videoInfo = originThreadInfo.video_info;
            if (videoInfo != null) {
                ltc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, dbd.b(videoInfo));
            }
            if (originThreadInfo.content != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (PbContent pbContent : originThreadInfo.content) {
                    jSONArray4.put(a6d.b(pbContent));
                }
                ltc.a(jSONObject, "content", jSONArray4);
            }
            ltc.a(jSONObject, "is_new_style", originThreadInfo.is_new_style);
            ltc.a(jSONObject, "reply_num", originThreadInfo.reply_num);
            User user = originThreadInfo.author;
            if (user != null) {
                ltc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, qad.b(user));
            }
            Agree agree = originThreadInfo.agree;
            if (agree != null) {
                ltc.a(jSONObject, "agree", cuc.b(agree));
            }
            ltc.a(jSONObject, "shared_num", originThreadInfo.shared_num);
            PollInfo pollInfo = originThreadInfo.poll_info;
            if (pollInfo != null) {
                ltc.a(jSONObject, "poll_info", n6d.b(pollInfo));
            }
            Item item = originThreadInfo.item;
            if (item != null) {
                ltc.a(jSONObject, "item", c4d.b(item));
            }
            if (originThreadInfo.item_star != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (HeadItem headItem : originThreadInfo.item_star) {
                    jSONArray5.put(v3d.b(headItem));
                }
                ltc.a(jSONObject, "item_star", jSONArray5);
            }
            if (originThreadInfo.pb_link_info != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (PbLinkInfo pbLinkInfo : originThreadInfo.pb_link_info) {
                    jSONArray6.put(c6d.b(pbLinkInfo));
                }
                ltc.a(jSONObject, "pb_link_info", jSONArray6);
            }
            ltc.a(jSONObject, "pid", originThreadInfo.pid);
            ltc.a(jSONObject, "good_types", originThreadInfo.good_types);
            ltc.a(jSONObject, "top_types", originThreadInfo.top_types);
            ltc.a(jSONObject, "is_frs_mask", originThreadInfo.is_frs_mask);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
