package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.LabelInfo;
/* loaded from: classes7.dex */
public class l4d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LabelInfo labelInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, labelInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "labelHot", labelInfo.labelHot);
            ktc.a(jSONObject, "labelContent", labelInfo.labelContent);
            ktc.a(jSONObject, "labelId", labelInfo.labelId);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
