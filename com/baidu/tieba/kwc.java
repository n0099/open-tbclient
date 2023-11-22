package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.PostPrefix;
/* loaded from: classes7.dex */
public class kwc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PostPrefix postPrefix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, postPrefix)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "mode", postPrefix.mode);
            qoc.a(jSONObject, "text", postPrefix.text);
            qoc.a(jSONObject, "type", postPrefix.type);
            qoc.a(jSONObject, "time", postPrefix.time);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
