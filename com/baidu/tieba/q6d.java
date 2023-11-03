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
/* loaded from: classes7.dex */
public class q6d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ZhiBoInfoTW zhiBoInfoTW) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, zhiBoInfoTW)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "thread_id", zhiBoInfoTW.thread_id);
            poc.a(jSONObject, "livecover_src", zhiBoInfoTW.livecover_src);
            poc.a(jSONObject, "livecover_src_bsize", zhiBoInfoTW.livecover_src_bsize);
            poc.a(jSONObject, "post_num", zhiBoInfoTW.post_num);
            poc.a(jSONObject, "reply_num", zhiBoInfoTW.reply_num);
            Zan zan = zhiBoInfoTW.zan;
            if (zan != null) {
                poc.a(jSONObject, FeedData.TYPE_ZAN, p6d.b(zan));
            }
            poc.a(jSONObject, "forum_name", zhiBoInfoTW.forum_name);
            poc.a(jSONObject, "forum_id", zhiBoInfoTW.forum_id);
            poc.a(jSONObject, "last_modified_time", zhiBoInfoTW.last_modified_time);
            poc.a(jSONObject, "title", zhiBoInfoTW.title);
            poc.a(jSONObject, "content", zhiBoInfoTW.content);
            User user = zhiBoInfoTW.user;
            if (user != null) {
                poc.a(jSONObject, "user", m5d.b(user));
            }
            HotTWThreadInfo hotTWThreadInfo = zhiBoInfoTW.hot_tw_info;
            if (hotTWThreadInfo != null) {
                poc.a(jSONObject, "hot_tw_info", tyc.b(hotTWThreadInfo));
            }
            if (zhiBoInfoTW.labelInfo != null) {
                JSONArray jSONArray = new JSONArray();
                for (LabelInfo labelInfo : zhiBoInfoTW.labelInfo) {
                    jSONArray.put(izc.b(labelInfo));
                }
                poc.a(jSONObject, "labelInfo", jSONArray);
            }
            poc.a(jSONObject, "livecover_src_status", zhiBoInfoTW.livecover_src_status);
            NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
            if (noticeInfo != null) {
                poc.a(jSONObject, "notice_info", k0d.b(noticeInfo));
            }
            poc.a(jSONObject, "is_headline", zhiBoInfoTW.is_headline);
            LiveCoverStatus liveCoverStatus = zhiBoInfoTW.livecover_status;
            if (liveCoverStatus != null) {
                poc.a(jSONObject, "livecover_status", szc.b(liveCoverStatus));
            }
            poc.a(jSONObject, "freq_num", zhiBoInfoTW.freq_num);
            poc.a(jSONObject, "copythread_remind", zhiBoInfoTW.copythread_remind);
            poc.a(jSONObject, "is_copytwzhibo", zhiBoInfoTW.is_copytwzhibo);
            poc.a(jSONObject, "field_ex", zhiBoInfoTW.field_ex);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
