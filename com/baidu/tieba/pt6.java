package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public interface pt6 {
    int a();

    float b();

    int c();

    float d();

    float e();

    int getHeight();

    int getWidth();

    void setHeight(int i);

    void setWidth(int i);

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static float a(pt6 pt6Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pt6Var)) == null) {
                return 1 / (pt6Var.b() - 0.6f);
            }
            return invokeL.floatValue;
        }
    }
}
