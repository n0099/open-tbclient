package com.baidu.tieba;

import com.baidu.android.imsdk.BIMManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
@JvmName(name = "ChatUtil")
/* loaded from: classes7.dex */
public final class pe8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            try {
                String bdUidFromBdUK = BIMManager.getBdUidFromBdUK(str);
                Intrinsics.checkNotNullExpressionValue(bdUidFromBdUK, "getBdUidFromBdUK(this)");
                return Long.parseLong(bdUidFromBdUK);
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public static final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return BIMManager.getBdUKFromBdUid(str);
        }
        return (String) invokeL.objValue;
    }
}
