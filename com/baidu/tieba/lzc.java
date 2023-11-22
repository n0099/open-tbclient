package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.LayoutManageInfo;
/* loaded from: classes7.dex */
public class lzc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LayoutManageInfo layoutManageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, layoutManageInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "text", layoutManageInfo.text);
            qoc.a(jSONObject, "type", layoutManageInfo.type);
            qoc.a(jSONObject, "ext", layoutManageInfo.ext);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
