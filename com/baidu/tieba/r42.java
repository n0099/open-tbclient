package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class r42 extends o42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap d;

    public r42() {
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

    public static r42 a(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, bitmap)) == null) {
            r42 r42Var = new r42();
            r42Var.a = 1;
            r42Var.b = str;
            r42Var.c = 0L;
            r42Var.d = bitmap;
            return r42Var;
        }
        return (r42) invokeLL.objValue;
    }

    public static r42 b(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, str, j)) == null) {
            r42 r42Var = new r42();
            r42Var.a = 1;
            r42Var.b = str;
            r42Var.c = j;
            return r42Var;
        }
        return (r42) invokeLJ.objValue;
    }
}
