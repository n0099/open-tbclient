package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class th1 {
    public static /* synthetic */ Interceptable $ic;
    public static th1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public uh1 a;

    public th1(uh1 uh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uh1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = uh1Var;
    }

    public static void c(uh1 uh1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, uh1Var) == null) && b == null) {
            synchronized (th1.class) {
                if (b == null) {
                    b = new th1(uh1Var);
                }
            }
        }
    }

    public static th1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (th1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        uh1 uh1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (uh1Var = this.a) != null) {
            uh1Var.a(imageView, str);
        }
    }
}
