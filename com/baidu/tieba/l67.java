package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public interface l67 extends Comparable<l67> {
    boolean D();

    Map<String, String> E();

    boolean F();

    String G();

    boolean M();

    int getPriority();

    void hide();

    int k(int i, int i2);

    void reset();

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static int a(l67 l67Var, l67 other) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, l67Var, other)) == null) {
                Intrinsics.checkNotNullParameter(other, "other");
                return Intrinsics.compare(other.getPriority(), l67Var.getPriority());
            }
            return invokeLL.intValue;
        }
    }
}
