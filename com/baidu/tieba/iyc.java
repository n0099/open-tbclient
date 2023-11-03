package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FullLengthNovel;
/* loaded from: classes6.dex */
public class iyc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FullLengthNovel fullLengthNovel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fullLengthNovel)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "schema", fullLengthNovel.schema);
            poc.a(jSONObject, "has_truncate", fullLengthNovel.has_truncate);
            poc.a(jSONObject, "button_heigh", fullLengthNovel.button_heigh);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
