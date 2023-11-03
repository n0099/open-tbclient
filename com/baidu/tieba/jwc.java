package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.PostPrefix;
/* loaded from: classes6.dex */
public class jwc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PostPrefix postPrefix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, postPrefix)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "mode", postPrefix.mode);
            poc.a(jSONObject, "text", postPrefix.text);
            poc.a(jSONObject, "type", postPrefix.type);
            poc.a(jSONObject, "time", postPrefix.time);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
