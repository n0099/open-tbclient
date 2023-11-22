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
public class r6d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ZhiBoInfoTW zhiBoInfoTW) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, zhiBoInfoTW)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "thread_id", zhiBoInfoTW.thread_id);
            qoc.a(jSONObject, "livecover_src", zhiBoInfoTW.livecover_src);
            qoc.a(jSONObject, "livecover_src_bsize", zhiBoInfoTW.livecover_src_bsize);
            qoc.a(jSONObject, "post_num", zhiBoInfoTW.post_num);
            qoc.a(jSONObject, "reply_num", zhiBoInfoTW.reply_num);
            Zan zan = zhiBoInfoTW.zan;
            if (zan != null) {
                qoc.a(jSONObject, FeedData.TYPE_ZAN, q6d.b(zan));
            }
            qoc.a(jSONObject, "forum_name", zhiBoInfoTW.forum_name);
            qoc.a(jSONObject, "forum_id", zhiBoInfoTW.forum_id);
            qoc.a(jSONObject, "last_modified_time", zhiBoInfoTW.last_modified_time);
            qoc.a(jSONObject, "title", zhiBoInfoTW.title);
            qoc.a(jSONObject, "content", zhiBoInfoTW.content);
            User user = zhiBoInfoTW.user;
            if (user != null) {
                qoc.a(jSONObject, "user", n5d.b(user));
            }
            HotTWThreadInfo hotTWThreadInfo = zhiBoInfoTW.hot_tw_info;
            if (hotTWThreadInfo != null) {
                qoc.a(jSONObject, "hot_tw_info", uyc.b(hotTWThreadInfo));
            }
            if (zhiBoInfoTW.labelInfo != null) {
                JSONArray jSONArray = new JSONArray();
                for (LabelInfo labelInfo : zhiBoInfoTW.labelInfo) {
                    jSONArray.put(jzc.b(labelInfo));
                }
                qoc.a(jSONObject, "labelInfo", jSONArray);
            }
            qoc.a(jSONObject, "livecover_src_status", zhiBoInfoTW.livecover_src_status);
            NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
            if (noticeInfo != null) {
                qoc.a(jSONObject, "notice_info", l0d.b(noticeInfo));
            }
            qoc.a(jSONObject, "is_headline", zhiBoInfoTW.is_headline);
            LiveCoverStatus liveCoverStatus = zhiBoInfoTW.livecover_status;
            if (liveCoverStatus != null) {
                qoc.a(jSONObject, "livecover_status", tzc.b(liveCoverStatus));
            }
            qoc.a(jSONObject, "freq_num", zhiBoInfoTW.freq_num);
            qoc.a(jSONObject, "copythread_remind", zhiBoInfoTW.copythread_remind);
            qoc.a(jSONObject, "is_copytwzhibo", zhiBoInfoTW.is_copytwzhibo);
            qoc.a(jSONObject, "field_ex", zhiBoInfoTW.field_ex);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
