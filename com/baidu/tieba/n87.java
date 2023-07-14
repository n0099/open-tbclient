package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public interface n87 extends Comparable<n87> {
    boolean D();

    boolean E();

    String J();

    boolean R();

    int getPriority();

    void hide();

    int o(int i, int i2);

    void reset();

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static int a(n87 n87Var, n87 other) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, n87Var, other)) == null) {
                Intrinsics.checkNotNullParameter(other, "other");
                return Intrinsics.compare(other.getPriority(), n87Var.getPriority());
            }
            return invokeLL.intValue;
        }
    }
}
