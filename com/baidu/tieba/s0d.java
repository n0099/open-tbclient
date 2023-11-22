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
public class s0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull OriginThreadInfo originThreadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, originThreadInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "title", originThreadInfo.title);
            if (originThreadInfo.media != null) {
                JSONArray jSONArray = new JSONArray();
                for (Media media : originThreadInfo.media) {
                    jSONArray.put(zzc.b(media));
                }
                qoc.a(jSONObject, "media", jSONArray);
            }
            if (originThreadInfo._abstract != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Abstract r3 : originThreadInfo._abstract) {
                    jSONArray2.put(toc.b(r3));
                }
                qoc.a(jSONObject, "abstract", jSONArray2);
            }
            qoc.a(jSONObject, "fname", originThreadInfo.fname);
            qoc.a(jSONObject, "tid", originThreadInfo.tid);
            AlaLiveInfo alaLiveInfo = originThreadInfo.ala_info;
            if (alaLiveInfo != null) {
                qoc.a(jSONObject, "ala_info", lpc.b(alaLiveInfo));
            }
            qoc.a(jSONObject, "fid", originThreadInfo.fid);
            qoc.a(jSONObject, "thread_type", originThreadInfo.thread_type);
            qoc.a(jSONObject, "is_deleted", originThreadInfo.is_deleted);
            qoc.a(jSONObject, "is_ugc", originThreadInfo.is_ugc);
            Baijiahao baijiahao = originThreadInfo.ori_ugc_info;
            if (baijiahao != null) {
                qoc.a(jSONObject, "ori_ugc_info", cqc.b(baijiahao));
            }
            if (originThreadInfo.voice_info != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Voice voice : originThreadInfo.voice_info) {
                    jSONArray3.put(f6d.b(voice));
                }
                qoc.a(jSONObject, "voice_info", jSONArray3);
            }
            VideoInfo videoInfo = originThreadInfo.video_info;
            if (videoInfo != null) {
                qoc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, z5d.b(videoInfo));
            }
            if (originThreadInfo.content != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (PbContent pbContent : originThreadInfo.content) {
                    jSONArray4.put(x0d.b(pbContent));
                }
                qoc.a(jSONObject, "content", jSONArray4);
            }
            qoc.a(jSONObject, "is_new_style", originThreadInfo.is_new_style);
            qoc.a(jSONObject, "reply_num", originThreadInfo.reply_num);
            User user = originThreadInfo.author;
            if (user != null) {
                qoc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, n5d.b(user));
            }
            Agree agree = originThreadInfo.agree;
            if (agree != null) {
                qoc.a(jSONObject, "agree", hpc.b(agree));
            }
            qoc.a(jSONObject, "shared_num", originThreadInfo.shared_num);
            PollInfo pollInfo = originThreadInfo.poll_info;
            if (pollInfo != null) {
                qoc.a(jSONObject, "poll_info", k1d.b(pollInfo));
            }
            Item item = originThreadInfo.item;
            if (item != null) {
                qoc.a(jSONObject, "item", zyc.b(item));
            }
            if (originThreadInfo.item_star != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (HeadItem headItem : originThreadInfo.item_star) {
                    jSONArray5.put(syc.b(headItem));
                }
                qoc.a(jSONObject, "item_star", jSONArray5);
            }
            if (originThreadInfo.pb_link_info != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (PbLinkInfo pbLinkInfo : originThreadInfo.pb_link_info) {
                    jSONArray6.put(z0d.b(pbLinkInfo));
                }
                qoc.a(jSONObject, "pb_link_info", jSONArray6);
            }
            qoc.a(jSONObject, "pid", originThreadInfo.pid);
            qoc.a(jSONObject, "good_types", originThreadInfo.good_types);
            qoc.a(jSONObject, "top_types", originThreadInfo.top_types);
            qoc.a(jSONObject, "is_frs_mask", originThreadInfo.is_frs_mask);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
