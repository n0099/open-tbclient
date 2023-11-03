package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PollOption;
/* loaded from: classes7.dex */
public class k1d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PollOption pollOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pollOption)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "id", pollOption.id);
            poc.a(jSONObject, "num", pollOption.num);
            poc.a(jSONObject, "text", pollOption.text);
            poc.a(jSONObject, "image", pollOption.image);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
