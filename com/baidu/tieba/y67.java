package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class y67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final z67 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        int optInt;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            if (jSONObject == null || (optInt = jSONObject.optInt("id", -1)) < 0) {
                return null;
            }
            String name = jSONObject.optString("name");
            boolean z2 = false;
            if (name != null && name.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return null;
            }
            if (jSONObject.optInt("enable", 0) == 1) {
                z2 = true;
            }
            Intrinsics.checkNotNullExpressionValue(name, "name");
            return new z67(optInt, name, z2);
        }
        return (z67) invokeL.objValue;
    }
}
