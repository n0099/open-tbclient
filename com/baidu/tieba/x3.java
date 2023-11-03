package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes9.dex */
public class x3 {
    public static /* synthetic */ Interceptable $ic;
    public static x3 b;
    public transient /* synthetic */ FieldHolder $fh;
    public a4 a;

    public x3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static x3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                b = new x3();
            }
            return b;
        }
        return (x3) invokeV.objValue;
    }

    public <T> void b(T[] tArr, Comparator<? super T> comparator, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048576, this, tArr, comparator, i, i2) == null) {
            if (this.a == null) {
                this.a = new a4();
            }
            this.a.c(tArr, comparator, i, i2);
        }
    }
}
