package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.DeclareInfo;
/* loaded from: classes6.dex */
public class jwc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DeclareInfo declareInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, declareInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "declare_id", declareInfo.declare_id);
            ktc.a(jSONObject, "declare_url", declareInfo.declare_url);
            ktc.a(jSONObject, "declare_text", declareInfo.declare_text);
            ktc.a(jSONObject, "declare_num", declareInfo.declare_num);
            ktc.a(jSONObject, "is_declare", declareInfo.is_declare);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
