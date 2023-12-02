package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SortButton;
/* loaded from: classes7.dex */
public class n8d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SortButton sortButton) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, sortButton)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "text", sortButton.text);
            ktc.a(jSONObject, "source_id", sortButton.source_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
