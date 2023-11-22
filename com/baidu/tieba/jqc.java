package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BazhuSign;
/* loaded from: classes6.dex */
public class jqc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BazhuSign bazhuSign) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bazhuSign)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "desc", bazhuSign.desc);
            qoc.a(jSONObject, "level", bazhuSign.level);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
