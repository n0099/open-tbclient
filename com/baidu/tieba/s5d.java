package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.UserVideoChannelInfo;
/* loaded from: classes8.dex */
public class s5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UserVideoChannelInfo userVideoChannelInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userVideoChannelInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "man_channel", userVideoChannelInfo.man_channel);
            poc.a(jSONObject, "follow_channel", userVideoChannelInfo.follow_channel);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
