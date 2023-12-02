package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PkItem;
/* loaded from: classes6.dex */
public class j6d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PkItem pkItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pkItem)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "pk_num", pkItem.pk_num);
            ktc.a(jSONObject, "pk_desc", pkItem.pk_desc);
            ktc.a(jSONObject, "last_username", pkItem.last_username);
            ktc.a(jSONObject, "pk_icon", pkItem.pk_icon);
            ktc.a(jSONObject, "has_clicked", pkItem.has_clicked);
            ktc.a(jSONObject, "pk_index", pkItem.pk_index);
            ktc.a(jSONObject, "pk_icon_after", pkItem.pk_icon_after);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
