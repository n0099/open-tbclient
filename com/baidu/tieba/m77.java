package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class m77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final n77 a(JSONObject jSONObject) {
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
            return new n77(optInt, name, z2);
        }
        return (n77) invokeL.objValue;
    }
}
