package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.NovelFansInfo;
/* loaded from: classes8.dex */
public class r5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NovelFansInfo novelFansInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, novelFansInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "level", novelFansInfo.level);
            ltc.a(jSONObject, "level_name", novelFansInfo.level_name);
            ltc.a(jSONObject, "level_icon", novelFansInfo.level_icon);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
