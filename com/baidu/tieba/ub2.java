package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ub2 extends rb2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap d;

    public ub2() {
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

    public static ub2 a(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, bitmap)) == null) {
            ub2 ub2Var = new ub2();
            ub2Var.a = 1;
            ub2Var.b = str;
            ub2Var.c = 0L;
            ub2Var.d = bitmap;
            return ub2Var;
        }
        return (ub2) invokeLL.objValue;
    }

    public static ub2 b(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, str, j)) == null) {
            ub2 ub2Var = new ub2();
            ub2Var.a = 1;
            ub2Var.b = str;
            ub2Var.c = j;
            return ub2Var;
        }
        return (ub2) invokeLJ.objValue;
    }
}
