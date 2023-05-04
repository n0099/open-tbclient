package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tf1 {
    public static /* synthetic */ Interceptable $ic;
    public static tf1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public uf1 a;

    public tf1(uf1 uf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uf1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = uf1Var;
    }

    public static void c(uf1 uf1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, uf1Var) == null) && b == null) {
            synchronized (tf1.class) {
                if (b == null) {
                    b = new tf1(uf1Var);
                }
            }
        }
    }

    public static tf1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (tf1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        uf1 uf1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (uf1Var = this.a) != null) {
            uf1Var.a(imageView, str);
        }
    }
}
