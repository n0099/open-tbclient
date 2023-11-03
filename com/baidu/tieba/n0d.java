package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.NovelFansInfo;
/* loaded from: classes7.dex */
public class n0d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NovelFansInfo novelFansInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, novelFansInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "level", novelFansInfo.level);
            poc.a(jSONObject, "level_name", novelFansInfo.level_name);
            poc.a(jSONObject, "level_icon", novelFansInfo.level_icon);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
