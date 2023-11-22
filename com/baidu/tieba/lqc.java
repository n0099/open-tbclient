package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BlockPopInfo;
/* loaded from: classes7.dex */
public class lqc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BlockPopInfo blockPopInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, blockPopInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "can_post", blockPopInfo.can_post);
            qoc.a(jSONObject, "block_info", blockPopInfo.block_info);
            qoc.a(jSONObject, "ahead_info", blockPopInfo.ahead_info);
            qoc.a(jSONObject, "ahead_url", blockPopInfo.ahead_url);
            qoc.a(jSONObject, "ok_info", blockPopInfo.ok_info);
            qoc.a(jSONObject, "ahead_type", blockPopInfo.ahead_type);
            qoc.a(jSONObject, "appeal_status", blockPopInfo.appeal_status);
            qoc.a(jSONObject, "appeal_msg", blockPopInfo.appeal_msg);
            qoc.a(jSONObject, "sub_block_info", blockPopInfo.sub_block_info);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
