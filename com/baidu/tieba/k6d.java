package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PkItem;
/* loaded from: classes6.dex */
public class k6d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PkItem pkItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pkItem)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "pk_num", pkItem.pk_num);
            ltc.a(jSONObject, "pk_desc", pkItem.pk_desc);
            ltc.a(jSONObject, "last_username", pkItem.last_username);
            ltc.a(jSONObject, "pk_icon", pkItem.pk_icon);
            ltc.a(jSONObject, "has_clicked", pkItem.has_clicked);
            ltc.a(jSONObject, "pk_index", pkItem.pk_index);
            ltc.a(jSONObject, "pk_icon_after", pkItem.pk_icon_after);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
