package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class s57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final r57 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            boolean z = false;
            int optInt = jSONObject.optInt("text_id", 0);
            String info = jSONObject.optString("text_info");
            if ((info == null || info.length() == 0) ? true : true) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(info, "info");
            return new r57(optInt, info);
        }
        return (r57) invokeL.objValue;
    }
}
