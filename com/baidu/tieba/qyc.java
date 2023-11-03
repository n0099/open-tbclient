package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Guess;
/* loaded from: classes8.dex */
public class qyc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Guess guess) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, guess)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "title", guess.title);
            poc.a(jSONObject, "url", guess.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
