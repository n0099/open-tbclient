package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public interface k77 extends Comparable<k77> {
    boolean D();

    boolean E();

    String F();

    boolean L();

    int getPriority();

    void hide();

    int m(int i, int i2);

    void reset();

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static int a(k77 k77Var, k77 other) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, k77Var, other)) == null) {
                Intrinsics.checkNotNullParameter(other, "other");
                return Intrinsics.compare(other.getPriority(), k77Var.getPriority());
            }
            return invokeLL.intValue;
        }
    }
}
