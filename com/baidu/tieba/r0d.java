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
public class r0d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull OriginThreadInfo originThreadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, originThreadInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "title", originThreadInfo.title);
            if (originThreadInfo.media != null) {
                JSONArray jSONArray = new JSONArray();
                for (Media media : originThreadInfo.media) {
                    jSONArray.put(yzc.b(media));
                }
                poc.a(jSONObject, "media", jSONArray);
            }
            if (originThreadInfo._abstract != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Abstract r3 : originThreadInfo._abstract) {
                    jSONArray2.put(soc.b(r3));
                }
                poc.a(jSONObject, "abstract", jSONArray2);
            }
            poc.a(jSONObject, "fname", originThreadInfo.fname);
            poc.a(jSONObject, "tid", originThreadInfo.tid);
            AlaLiveInfo alaLiveInfo = originThreadInfo.ala_info;
            if (alaLiveInfo != null) {
                poc.a(jSONObject, "ala_info", kpc.b(alaLiveInfo));
            }
            poc.a(jSONObject, "fid", originThreadInfo.fid);
            poc.a(jSONObject, "thread_type", originThreadInfo.thread_type);
            poc.a(jSONObject, "is_deleted", originThreadInfo.is_deleted);
            poc.a(jSONObject, "is_ugc", originThreadInfo.is_ugc);
            Baijiahao baijiahao = originThreadInfo.ori_ugc_info;
            if (baijiahao != null) {
                poc.a(jSONObject, "ori_ugc_info", bqc.b(baijiahao));
            }
            if (originThreadInfo.voice_info != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Voice voice : originThreadInfo.voice_info) {
                    jSONArray3.put(e6d.b(voice));
                }
                poc.a(jSONObject, "voice_info", jSONArray3);
            }
            VideoInfo videoInfo = originThreadInfo.video_info;
            if (videoInfo != null) {
                poc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, y5d.b(videoInfo));
            }
            if (originThreadInfo.content != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (PbContent pbContent : originThreadInfo.content) {
                    jSONArray4.put(w0d.b(pbContent));
                }
                poc.a(jSONObject, "content", jSONArray4);
            }
            poc.a(jSONObject, "is_new_style", originThreadInfo.is_new_style);
            poc.a(jSONObject, "reply_num", originThreadInfo.reply_num);
            User user = originThreadInfo.author;
            if (user != null) {
                poc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, m5d.b(user));
            }
            Agree agree = originThreadInfo.agree;
            if (agree != null) {
                poc.a(jSONObject, "agree", gpc.b(agree));
            }
            poc.a(jSONObject, "shared_num", originThreadInfo.shared_num);
            PollInfo pollInfo = originThreadInfo.poll_info;
            if (pollInfo != null) {
                poc.a(jSONObject, "poll_info", j1d.b(pollInfo));
            }
            Item item = originThreadInfo.item;
            if (item != null) {
                poc.a(jSONObject, "item", yyc.b(item));
            }
            if (originThreadInfo.item_star != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (HeadItem headItem : originThreadInfo.item_star) {
                    jSONArray5.put(ryc.b(headItem));
                }
                poc.a(jSONObject, "item_star", jSONArray5);
            }
            if (originThreadInfo.pb_link_info != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (PbLinkInfo pbLinkInfo : originThreadInfo.pb_link_info) {
                    jSONArray6.put(y0d.b(pbLinkInfo));
                }
                poc.a(jSONObject, "pb_link_info", jSONArray6);
            }
            poc.a(jSONObject, "pid", originThreadInfo.pid);
            poc.a(jSONObject, "good_types", originThreadInfo.good_types);
            poc.a(jSONObject, "top_types", originThreadInfo.top_types);
            poc.a(jSONObject, "is_frs_mask", originThreadInfo.is_frs_mask);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
