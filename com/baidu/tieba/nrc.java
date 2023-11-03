package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.DeletedReasonInfo;
/* loaded from: classes7.dex */
public class nrc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DeletedReasonInfo deletedReasonInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, deletedReasonInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "is_grays_cale_forum", deletedReasonInfo.is_grays_cale_forum);
            poc.a(jSONObject, "is_boomgrow", deletedReasonInfo.is_boomgrow);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
