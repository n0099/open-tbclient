package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.DetailInfo;
/* loaded from: classes7.dex */
public class prc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DetailInfo detailInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, detailInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "text", detailInfo.text);
            qoc.a(jSONObject, "url", detailInfo.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
