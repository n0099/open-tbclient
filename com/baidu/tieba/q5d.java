package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.NovelFansInfo;
/* loaded from: classes7.dex */
public class q5d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NovelFansInfo novelFansInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, novelFansInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "level", novelFansInfo.level);
            ktc.a(jSONObject, "level_name", novelFansInfo.level_name);
            ktc.a(jSONObject, "level_icon", novelFansInfo.level_icon);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
