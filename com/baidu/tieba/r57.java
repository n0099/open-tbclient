package com.baidu.tieba;

import com.baidu.tbadk.core.data.IMUserExtraData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class r57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final q57 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt("total_recommend_num", 0);
            int optInt2 = jSONObject.optInt("used_recommend_num", 0);
            String optString = jSONObject.optString(IMUserExtraData.KEY_BAZHU_LEVEL);
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"bazhu_level\")");
            return new q57(optInt, optInt2, optString);
        }
        return (q57) invokeL.objValue;
    }
}
