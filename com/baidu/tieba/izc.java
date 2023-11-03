package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.LabelInfo;
/* loaded from: classes6.dex */
public class izc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LabelInfo labelInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, labelInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "labelHot", labelInfo.labelHot);
            poc.a(jSONObject, "labelContent", labelInfo.labelContent);
            poc.a(jSONObject, "labelId", labelInfo.labelId);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
