package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PollOption;
/* loaded from: classes7.dex */
public class n6d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PollOption pollOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pollOption)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "id", pollOption.id);
            ktc.a(jSONObject, "num", pollOption.num);
            ktc.a(jSONObject, "text", pollOption.text);
            ktc.a(jSONObject, "image", pollOption.image);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
