package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes8.dex */
public class v5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VideoChannelInfo videoChannelInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, videoChannelInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "channel_id", videoChannelInfo.channel_id);
            poc.a(jSONObject, "channel_name", videoChannelInfo.channel_name);
            poc.a(jSONObject, "channel_avatar", videoChannelInfo.channel_avatar);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
