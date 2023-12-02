package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.GraffitiInfo;
/* loaded from: classes8.dex */
public class s3d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GraffitiInfo graffitiInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, graffitiInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "url", graffitiInfo.url);
            ktc.a(jSONObject, TbEnum.ParamKey.GID, graffitiInfo.gid);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
