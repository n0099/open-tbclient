package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BlockPopInfo;
/* loaded from: classes6.dex */
public class ivc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BlockPopInfo blockPopInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, blockPopInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "can_post", blockPopInfo.can_post);
            ltc.a(jSONObject, "block_info", blockPopInfo.block_info);
            ltc.a(jSONObject, "ahead_info", blockPopInfo.ahead_info);
            ltc.a(jSONObject, "ahead_url", blockPopInfo.ahead_url);
            ltc.a(jSONObject, "ok_info", blockPopInfo.ok_info);
            ltc.a(jSONObject, "ahead_type", blockPopInfo.ahead_type);
            ltc.a(jSONObject, "appeal_status", blockPopInfo.appeal_status);
            ltc.a(jSONObject, "appeal_msg", blockPopInfo.appeal_msg);
            ltc.a(jSONObject, "sub_block_info", blockPopInfo.sub_block_info);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
