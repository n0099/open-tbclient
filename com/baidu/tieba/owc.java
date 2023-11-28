package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.DislikeInfo;
/* loaded from: classes7.dex */
public class owc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DislikeInfo dislikeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dislikeInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "dislike_reason", dislikeInfo.dislike_reason);
            ltc.a(jSONObject, "dislike_id", dislikeInfo.dislike_id);
            ltc.a(jSONObject, "extra", dislikeInfo.extra);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
