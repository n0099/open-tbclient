package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class t57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final s57 a(Map<String, String> businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            try {
                String str = businessInfo.get("forum_id");
                nd7.b(str, null, 1, null);
                String str2 = businessInfo.get("thread_id");
                nd7.b(str2, null, 1, null);
                return new s57(str, str2);
            } catch (Exception unused) {
                return null;
            }
        }
        return (s57) invokeL.objValue;
    }
}
