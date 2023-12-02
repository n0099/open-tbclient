package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.EditInfo;
/* loaded from: classes8.dex */
public class rwc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull EditInfo editInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, editInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "edit_status", editInfo.edit_status);
            ktc.a(jSONObject, "edit_enable", editInfo.edit_enable);
            ktc.a(jSONObject, "edit_error_msg", editInfo.edit_error_msg);
            ktc.a(jSONObject, "last_edit_time", editInfo.last_edit_time);
            ktc.a(jSONObject, "edit_from", editInfo.edit_from);
            ktc.a(jSONObject, "edit_error_no", editInfo.edit_error_no);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
