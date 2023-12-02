package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FullLengthNovel;
/* loaded from: classes7.dex */
public class l3d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FullLengthNovel fullLengthNovel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fullLengthNovel)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "schema", fullLengthNovel.schema);
            ktc.a(jSONObject, "has_truncate", fullLengthNovel.has_truncate);
            ktc.a(jSONObject, "button_heigh", fullLengthNovel.button_heigh);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
