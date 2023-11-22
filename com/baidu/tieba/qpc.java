package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.vip.models.VipUserInfoKt;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import org.json.JSONObject;
import tbclient.AnchorInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes8.dex */
public class qpc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AnchorInfo anchorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, anchorInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "portrait", anchorInfo.portrait);
            qoc.a(jSONObject, "name", anchorInfo.name);
            qoc.a(jSONObject, "start_time", anchorInfo.start_time);
            qoc.a(jSONObject, "status", anchorInfo.status);
            qoc.a(jSONObject, "author_id", anchorInfo.author_id);
            qoc.a(jSONObject, NativeUnifiedADAppInfoImpl.Keys.AUTHOR_NAME, anchorInfo.author_name);
            qoc.a(jSONObject, "listeners", anchorInfo.listeners);
            qoc.a(jSONObject, "likers", anchorInfo.likers);
            qoc.a(jSONObject, "group_id", anchorInfo.group_id);
            qoc.a(jSONObject, "intro", anchorInfo.intro);
            qoc.a(jSONObject, "publisherPortrait", anchorInfo.publisherPortrait);
            qoc.a(jSONObject, "publisherName", anchorInfo.publisherName);
            qoc.a(jSONObject, "publisherId", anchorInfo.publisherId);
            qoc.a(jSONObject, ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, anchorInfo.forumName);
            qoc.a(jSONObject, "from_type", anchorInfo.from_type);
            qoc.a(jSONObject, VipUserInfoKt.KEY_VIP_MAIN_VIP_STATUS, anchorInfo.is_vip);
            qoc.a(jSONObject, "label_id", anchorInfo.label_id);
            qoc.a(jSONObject, "label_name", anchorInfo.label_name);
            qoc.a(jSONObject, "type", anchorInfo.type);
            ZhiBoInfoTW zhiBoInfoTW = anchorInfo.twzhibo_info;
            if (zhiBoInfoTW != null) {
                qoc.a(jSONObject, "twzhibo_info", r6d.b(zhiBoInfoTW));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
