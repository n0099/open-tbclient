package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public interface p87 extends Comparable<p87> {
    boolean D();

    boolean E();

    String F();

    boolean K();

    int getPriority();

    void hide();

    int l(int i, int i2);

    void reset();

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static int a(p87 p87Var, p87 other) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, p87Var, other)) == null) {
                Intrinsics.checkNotNullParameter(other, "other");
                return Intrinsics.compare(other.getPriority(), p87Var.getPriority());
            }
            return invokeLL.intValue;
        }
    }
}
