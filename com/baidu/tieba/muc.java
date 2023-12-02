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
public class muc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AnchorInfo anchorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, anchorInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "portrait", anchorInfo.portrait);
            ktc.a(jSONObject, "name", anchorInfo.name);
            ktc.a(jSONObject, "start_time", anchorInfo.start_time);
            ktc.a(jSONObject, "status", anchorInfo.status);
            ktc.a(jSONObject, "author_id", anchorInfo.author_id);
            ktc.a(jSONObject, NativeUnifiedADAppInfoImpl.Keys.AUTHOR_NAME, anchorInfo.author_name);
            ktc.a(jSONObject, "listeners", anchorInfo.listeners);
            ktc.a(jSONObject, "likers", anchorInfo.likers);
            ktc.a(jSONObject, "group_id", anchorInfo.group_id);
            ktc.a(jSONObject, "intro", anchorInfo.intro);
            ktc.a(jSONObject, "publisherPortrait", anchorInfo.publisherPortrait);
            ktc.a(jSONObject, "publisherName", anchorInfo.publisherName);
            ktc.a(jSONObject, "publisherId", anchorInfo.publisherId);
            ktc.a(jSONObject, ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, anchorInfo.forumName);
            ktc.a(jSONObject, "from_type", anchorInfo.from_type);
            ktc.a(jSONObject, VipUserInfoKt.KEY_VIP_MAIN_VIP_STATUS, anchorInfo.is_vip);
            ktc.a(jSONObject, "label_id", anchorInfo.label_id);
            ktc.a(jSONObject, "label_name", anchorInfo.label_name);
            ktc.a(jSONObject, "type", anchorInfo.type);
            ZhiBoInfoTW zhiBoInfoTW = anchorInfo.twzhibo_info;
            if (zhiBoInfoTW != null) {
                ktc.a(jSONObject, "twzhibo_info", ubd.b(zhiBoInfoTW));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
