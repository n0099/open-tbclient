package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.RecommendTip;
/* loaded from: classes7.dex */
public class o7d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecommendTip recommendTip) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recommendTip)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "reason", recommendTip.reason);
            ktc.a(jSONObject, TiebaStatic.Params.IS_FOLLOW, recommendTip.is_follow);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
