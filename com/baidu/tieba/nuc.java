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
public class nuc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AnchorInfo anchorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, anchorInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "portrait", anchorInfo.portrait);
            ltc.a(jSONObject, "name", anchorInfo.name);
            ltc.a(jSONObject, "start_time", anchorInfo.start_time);
            ltc.a(jSONObject, "status", anchorInfo.status);
            ltc.a(jSONObject, "author_id", anchorInfo.author_id);
            ltc.a(jSONObject, NativeUnifiedADAppInfoImpl.Keys.AUTHOR_NAME, anchorInfo.author_name);
            ltc.a(jSONObject, "listeners", anchorInfo.listeners);
            ltc.a(jSONObject, "likers", anchorInfo.likers);
            ltc.a(jSONObject, "group_id", anchorInfo.group_id);
            ltc.a(jSONObject, "intro", anchorInfo.intro);
            ltc.a(jSONObject, "publisherPortrait", anchorInfo.publisherPortrait);
            ltc.a(jSONObject, "publisherName", anchorInfo.publisherName);
            ltc.a(jSONObject, "publisherId", anchorInfo.publisherId);
            ltc.a(jSONObject, ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, anchorInfo.forumName);
            ltc.a(jSONObject, "from_type", anchorInfo.from_type);
            ltc.a(jSONObject, VipUserInfoKt.KEY_VIP_MAIN_VIP_STATUS, anchorInfo.is_vip);
            ltc.a(jSONObject, "label_id", anchorInfo.label_id);
            ltc.a(jSONObject, "label_name", anchorInfo.label_name);
            ltc.a(jSONObject, "type", anchorInfo.type);
            ZhiBoInfoTW zhiBoInfoTW = anchorInfo.twzhibo_info;
            if (zhiBoInfoTW != null) {
                ltc.a(jSONObject, "twzhibo_info", vbd.b(zhiBoInfoTW));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
