package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.LinkInfo;
/* loaded from: classes8.dex */
public class qzc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LinkInfo linkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, linkInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "desc", linkInfo.desc);
            qoc.a(jSONObject, "link", linkInfo.link);
            qoc.a(jSONObject, "type", linkInfo.type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
