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
public class ubd extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ZhiBoInfoTW zhiBoInfoTW) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, zhiBoInfoTW)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "thread_id", zhiBoInfoTW.thread_id);
            ktc.a(jSONObject, "livecover_src", zhiBoInfoTW.livecover_src);
            ktc.a(jSONObject, "livecover_src_bsize", zhiBoInfoTW.livecover_src_bsize);
            ktc.a(jSONObject, "post_num", zhiBoInfoTW.post_num);
            ktc.a(jSONObject, "reply_num", zhiBoInfoTW.reply_num);
            Zan zan = zhiBoInfoTW.zan;
            if (zan != null) {
                ktc.a(jSONObject, FeedData.TYPE_ZAN, tbd.b(zan));
            }
            ktc.a(jSONObject, "forum_name", zhiBoInfoTW.forum_name);
            ktc.a(jSONObject, "forum_id", zhiBoInfoTW.forum_id);
            ktc.a(jSONObject, "last_modified_time", zhiBoInfoTW.last_modified_time);
            ktc.a(jSONObject, "title", zhiBoInfoTW.title);
            ktc.a(jSONObject, "content", zhiBoInfoTW.content);
            User user = zhiBoInfoTW.user;
            if (user != null) {
                ktc.a(jSONObject, "user", pad.b(user));
            }
            HotTWThreadInfo hotTWThreadInfo = zhiBoInfoTW.hot_tw_info;
            if (hotTWThreadInfo != null) {
                ktc.a(jSONObject, "hot_tw_info", w3d.b(hotTWThreadInfo));
            }
            if (zhiBoInfoTW.labelInfo != null) {
                JSONArray jSONArray = new JSONArray();
                for (LabelInfo labelInfo : zhiBoInfoTW.labelInfo) {
                    jSONArray.put(l4d.b(labelInfo));
                }
                ktc.a(jSONObject, "labelInfo", jSONArray);
            }
            ktc.a(jSONObject, "livecover_src_status", zhiBoInfoTW.livecover_src_status);
            NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
            if (noticeInfo != null) {
                ktc.a(jSONObject, "notice_info", n5d.b(noticeInfo));
            }
            ktc.a(jSONObject, "is_headline", zhiBoInfoTW.is_headline);
            LiveCoverStatus liveCoverStatus = zhiBoInfoTW.livecover_status;
            if (liveCoverStatus != null) {
                ktc.a(jSONObject, "livecover_status", v4d.b(liveCoverStatus));
            }
            ktc.a(jSONObject, "freq_num", zhiBoInfoTW.freq_num);
            ktc.a(jSONObject, "copythread_remind", zhiBoInfoTW.copythread_remind);
            ktc.a(jSONObject, "is_copytwzhibo", zhiBoInfoTW.is_copytwzhibo);
            ktc.a(jSONObject, "field_ex", zhiBoInfoTW.field_ex);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
