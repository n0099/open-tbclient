package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.LinkInfo;
/* loaded from: classes7.dex */
public class pzc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LinkInfo linkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, linkInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "desc", linkInfo.desc);
            poc.a(jSONObject, "link", linkInfo.link);
            poc.a(jSONObject, "type", linkInfo.type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
