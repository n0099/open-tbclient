package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kb1 {
    public static /* synthetic */ Interceptable $ic;
    public static kb1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public lb1 a;

    public kb1(lb1 lb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lb1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = lb1Var;
    }

    public static void c(lb1 lb1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, lb1Var) == null) && b == null) {
            synchronized (kb1.class) {
                if (b == null) {
                    b = new kb1(lb1Var);
                }
            }
        }
    }

    public static kb1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (kb1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        lb1 lb1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (lb1Var = this.a) != null) {
            lb1Var.a(imageView, str);
        }
    }
}
