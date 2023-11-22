package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PollOption;
/* loaded from: classes7.dex */
public class l1d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PollOption pollOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pollOption)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "id", pollOption.id);
            qoc.a(jSONObject, "num", pollOption.num);
            qoc.a(jSONObject, "text", pollOption.text);
            qoc.a(jSONObject, "image", pollOption.image);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
