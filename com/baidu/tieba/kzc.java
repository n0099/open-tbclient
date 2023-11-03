package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.LayoutManageInfo;
/* loaded from: classes7.dex */
public class kzc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LayoutManageInfo layoutManageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, layoutManageInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "text", layoutManageInfo.text);
            poc.a(jSONObject, "type", layoutManageInfo.type);
            poc.a(jSONObject, "ext", layoutManageInfo.ext);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
