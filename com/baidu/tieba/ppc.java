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
/* loaded from: classes7.dex */
public class ppc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AnchorInfo anchorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, anchorInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "portrait", anchorInfo.portrait);
            poc.a(jSONObject, "name", anchorInfo.name);
            poc.a(jSONObject, "start_time", anchorInfo.start_time);
            poc.a(jSONObject, "status", anchorInfo.status);
            poc.a(jSONObject, "author_id", anchorInfo.author_id);
            poc.a(jSONObject, NativeUnifiedADAppInfoImpl.Keys.AUTHOR_NAME, anchorInfo.author_name);
            poc.a(jSONObject, "listeners", anchorInfo.listeners);
            poc.a(jSONObject, "likers", anchorInfo.likers);
            poc.a(jSONObject, "group_id", anchorInfo.group_id);
            poc.a(jSONObject, "intro", anchorInfo.intro);
            poc.a(jSONObject, "publisherPortrait", anchorInfo.publisherPortrait);
            poc.a(jSONObject, "publisherName", anchorInfo.publisherName);
            poc.a(jSONObject, "publisherId", anchorInfo.publisherId);
            poc.a(jSONObject, ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, anchorInfo.forumName);
            poc.a(jSONObject, "from_type", anchorInfo.from_type);
            poc.a(jSONObject, VipUserInfoKt.KEY_VIP_MAIN_VIP_STATUS, anchorInfo.is_vip);
            poc.a(jSONObject, "label_id", anchorInfo.label_id);
            poc.a(jSONObject, "label_name", anchorInfo.label_name);
            poc.a(jSONObject, "type", anchorInfo.type);
            ZhiBoInfoTW zhiBoInfoTW = anchorInfo.twzhibo_info;
            if (zhiBoInfoTW != null) {
                poc.a(jSONObject, "twzhibo_info", q6d.b(zhiBoInfoTW));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
