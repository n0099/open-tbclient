package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import tbclient.Personalized.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public final class rh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final qh8 a(DataRes.Builder builderData, ThreadInfo threadInfo) {
        InterceptResult invokeLL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, builderData, threadInfo)) == null) {
            Intrinsics.checkNotNullParameter(builderData, "builderData");
            Intrinsics.checkNotNullParameter(threadInfo, "threadInfo");
            Long l = threadInfo.tid;
            Intrinsics.checkNotNullExpressionValue(l, "threadInfo.tid");
            qh8 qh8Var = new qh8(l.longValue(), false, 2, null);
            Integer num2 = builderData.is_need_live_ununiq;
            if (num2 != null && num2.intValue() == 1 && (num = threadInfo.thread_type) != null && num.intValue() == 69) {
                qh8Var.b(false);
            }
            return qh8Var;
        }
        return (qh8) invokeLL.objValue;
    }
}
