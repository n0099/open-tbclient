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
public class u5d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull OriginThreadInfo originThreadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, originThreadInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "title", originThreadInfo.title);
            if (originThreadInfo.media != null) {
                JSONArray jSONArray = new JSONArray();
                for (Media media : originThreadInfo.media) {
                    jSONArray.put(b5d.b(media));
                }
                ktc.a(jSONObject, "media", jSONArray);
            }
            if (originThreadInfo._abstract != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Abstract r3 : originThreadInfo._abstract) {
                    jSONArray2.put(ntc.b(r3));
                }
                ktc.a(jSONObject, "abstract", jSONArray2);
            }
            ktc.a(jSONObject, "fname", originThreadInfo.fname);
            ktc.a(jSONObject, "tid", originThreadInfo.tid);
            AlaLiveInfo alaLiveInfo = originThreadInfo.ala_info;
            if (alaLiveInfo != null) {
                ktc.a(jSONObject, "ala_info", huc.b(alaLiveInfo));
            }
            ktc.a(jSONObject, "fid", originThreadInfo.fid);
            ktc.a(jSONObject, "thread_type", originThreadInfo.thread_type);
            ktc.a(jSONObject, "is_deleted", originThreadInfo.is_deleted);
            ktc.a(jSONObject, "is_ugc", originThreadInfo.is_ugc);
            Baijiahao baijiahao = originThreadInfo.ori_ugc_info;
            if (baijiahao != null) {
                ktc.a(jSONObject, "ori_ugc_info", yuc.b(baijiahao));
            }
            if (originThreadInfo.voice_info != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Voice voice : originThreadInfo.voice_info) {
                    jSONArray3.put(ibd.b(voice));
                }
                ktc.a(jSONObject, "voice_info", jSONArray3);
            }
            VideoInfo videoInfo = originThreadInfo.video_info;
            if (videoInfo != null) {
                ktc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, cbd.b(videoInfo));
            }
            if (originThreadInfo.content != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (PbContent pbContent : originThreadInfo.content) {
                    jSONArray4.put(z5d.b(pbContent));
                }
                ktc.a(jSONObject, "content", jSONArray4);
            }
            ktc.a(jSONObject, "is_new_style", originThreadInfo.is_new_style);
            ktc.a(jSONObject, "reply_num", originThreadInfo.reply_num);
            User user = originThreadInfo.author;
            if (user != null) {
                ktc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, pad.b(user));
            }
            Agree agree = originThreadInfo.agree;
            if (agree != null) {
                ktc.a(jSONObject, "agree", buc.b(agree));
            }
            ktc.a(jSONObject, "shared_num", originThreadInfo.shared_num);
            PollInfo pollInfo = originThreadInfo.poll_info;
            if (pollInfo != null) {
                ktc.a(jSONObject, "poll_info", m6d.b(pollInfo));
            }
            Item item = originThreadInfo.item;
            if (item != null) {
                ktc.a(jSONObject, "item", b4d.b(item));
            }
            if (originThreadInfo.item_star != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (HeadItem headItem : originThreadInfo.item_star) {
                    jSONArray5.put(u3d.b(headItem));
                }
                ktc.a(jSONObject, "item_star", jSONArray5);
            }
            if (originThreadInfo.pb_link_info != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (PbLinkInfo pbLinkInfo : originThreadInfo.pb_link_info) {
                    jSONArray6.put(b6d.b(pbLinkInfo));
                }
                ktc.a(jSONObject, "pb_link_info", jSONArray6);
            }
            ktc.a(jSONObject, "pid", originThreadInfo.pid);
            ktc.a(jSONObject, "good_types", originThreadInfo.good_types);
            ktc.a(jSONObject, "top_types", originThreadInfo.top_types);
            ktc.a(jSONObject, "is_frs_mask", originThreadInfo.is_frs_mask);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
