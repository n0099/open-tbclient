package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BlockPopInfo;
/* loaded from: classes7.dex */
public class kqc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BlockPopInfo blockPopInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, blockPopInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "can_post", blockPopInfo.can_post);
            poc.a(jSONObject, "block_info", blockPopInfo.block_info);
            poc.a(jSONObject, "ahead_info", blockPopInfo.ahead_info);
            poc.a(jSONObject, "ahead_url", blockPopInfo.ahead_url);
            poc.a(jSONObject, "ok_info", blockPopInfo.ok_info);
            poc.a(jSONObject, "ahead_type", blockPopInfo.ahead_type);
            poc.a(jSONObject, "appeal_status", blockPopInfo.appeal_status);
            poc.a(jSONObject, "appeal_msg", blockPopInfo.appeal_msg);
            poc.a(jSONObject, "sub_block_info", blockPopInfo.sub_block_info);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
