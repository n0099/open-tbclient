package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.EditInfo;
/* loaded from: classes8.dex */
public class urc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull EditInfo editInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, editInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "edit_status", editInfo.edit_status);
            qoc.a(jSONObject, "edit_enable", editInfo.edit_enable);
            qoc.a(jSONObject, "edit_error_msg", editInfo.edit_error_msg);
            qoc.a(jSONObject, "last_edit_time", editInfo.last_edit_time);
            qoc.a(jSONObject, "edit_from", editInfo.edit_from);
            qoc.a(jSONObject, "edit_error_no", editInfo.edit_error_no);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
