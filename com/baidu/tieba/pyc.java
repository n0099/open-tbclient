package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.GraffitiInfo;
/* loaded from: classes7.dex */
public class pyc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GraffitiInfo graffitiInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, graffitiInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "url", graffitiInfo.url);
            poc.a(jSONObject, TbEnum.ParamKey.GID, graffitiInfo.gid);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
