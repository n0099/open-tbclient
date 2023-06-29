package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wh1 {
    public static /* synthetic */ Interceptable $ic;
    public static wh1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public xh1 a;

    public wh1(xh1 xh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xh1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xh1Var;
    }

    public static void c(xh1 xh1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, xh1Var) == null) && b == null) {
            synchronized (wh1.class) {
                if (b == null) {
                    b = new wh1(xh1Var);
                }
            }
        }
    }

    public static wh1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (wh1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        xh1 xh1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (xh1Var = this.a) != null) {
            xh1Var.a(imageView, str);
        }
    }
}
