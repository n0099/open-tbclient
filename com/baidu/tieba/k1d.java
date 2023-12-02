package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.PostPrefix;
/* loaded from: classes6.dex */
public class k1d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PostPrefix postPrefix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, postPrefix)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "mode", postPrefix.mode);
            ktc.a(jSONObject, "text", postPrefix.text);
            ktc.a(jSONObject, "type", postPrefix.type);
            ktc.a(jSONObject, "time", postPrefix.time);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
