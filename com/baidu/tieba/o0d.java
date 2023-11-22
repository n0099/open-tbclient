package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.NovelFansInfo;
/* loaded from: classes7.dex */
public class o0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NovelFansInfo novelFansInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, novelFansInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "level", novelFansInfo.level);
            qoc.a(jSONObject, "level_name", novelFansInfo.level_name);
            qoc.a(jSONObject, "level_icon", novelFansInfo.level_icon);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
