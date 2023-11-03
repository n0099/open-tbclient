package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.EditInfo;
/* loaded from: classes8.dex */
public class trc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull EditInfo editInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, editInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "edit_status", editInfo.edit_status);
            poc.a(jSONObject, "edit_enable", editInfo.edit_enable);
            poc.a(jSONObject, "edit_error_msg", editInfo.edit_error_msg);
            poc.a(jSONObject, "last_edit_time", editInfo.last_edit_time);
            poc.a(jSONObject, "edit_from", editInfo.edit_from);
            poc.a(jSONObject, "edit_error_no", editInfo.edit_error_no);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
