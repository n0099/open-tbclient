package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AlaStageDislikeInfo;
/* loaded from: classes7.dex */
public class opc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AlaStageDislikeInfo alaStageDislikeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, alaStageDislikeInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "dislike_reason", alaStageDislikeInfo.dislike_reason);
            qoc.a(jSONObject, "dislike_id", alaStageDislikeInfo.dislike_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
