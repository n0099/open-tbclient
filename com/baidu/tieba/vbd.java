package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.immessagecenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.HotTWThreadInfo;
import tbclient.LabelInfo;
import tbclient.LiveCoverStatus;
import tbclient.NoticeInfo;
import tbclient.User;
import tbclient.Zan;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes8.dex */
public class vbd extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ZhiBoInfoTW zhiBoInfoTW) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, zhiBoInfoTW)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "thread_id", zhiBoInfoTW.thread_id);
            ltc.a(jSONObject, "livecover_src", zhiBoInfoTW.livecover_src);
            ltc.a(jSONObject, "livecover_src_bsize", zhiBoInfoTW.livecover_src_bsize);
            ltc.a(jSONObject, "post_num", zhiBoInfoTW.post_num);
            ltc.a(jSONObject, "reply_num", zhiBoInfoTW.reply_num);
            Zan zan = zhiBoInfoTW.zan;
            if (zan != null) {
                ltc.a(jSONObject, FeedData.TYPE_ZAN, ubd.b(zan));
            }
            ltc.a(jSONObject, "forum_name", zhiBoInfoTW.forum_name);
            ltc.a(jSONObject, "forum_id", zhiBoInfoTW.forum_id);
            ltc.a(jSONObject, "last_modified_time", zhiBoInfoTW.last_modified_time);
            ltc.a(jSONObject, "title", zhiBoInfoTW.title);
            ltc.a(jSONObject, "content", zhiBoInfoTW.content);
            User user = zhiBoInfoTW.user;
            if (user != null) {
                ltc.a(jSONObject, "user", qad.b(user));
            }
            HotTWThreadInfo hotTWThreadInfo = zhiBoInfoTW.hot_tw_info;
            if (hotTWThreadInfo != null) {
                ltc.a(jSONObject, "hot_tw_info", x3d.b(hotTWThreadInfo));
            }
            if (zhiBoInfoTW.labelInfo != null) {
                JSONArray jSONArray = new JSONArray();
                for (LabelInfo labelInfo : zhiBoInfoTW.labelInfo) {
                    jSONArray.put(m4d.b(labelInfo));
                }
                ltc.a(jSONObject, "labelInfo", jSONArray);
            }
            ltc.a(jSONObject, "livecover_src_status", zhiBoInfoTW.livecover_src_status);
            NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
            if (noticeInfo != null) {
                ltc.a(jSONObject, "notice_info", o5d.b(noticeInfo));
            }
            ltc.a(jSONObject, "is_headline", zhiBoInfoTW.is_headline);
            LiveCoverStatus liveCoverStatus = zhiBoInfoTW.livecover_status;
            if (liveCoverStatus != null) {
                ltc.a(jSONObject, "livecover_status", w4d.b(liveCoverStatus));
            }
            ltc.a(jSONObject, "freq_num", zhiBoInfoTW.freq_num);
            ltc.a(jSONObject, "copythread_remind", zhiBoInfoTW.copythread_remind);
            ltc.a(jSONObject, "is_copytwzhibo", zhiBoInfoTW.is_copytwzhibo);
            ltc.a(jSONObject, "field_ex", zhiBoInfoTW.field_ex);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
