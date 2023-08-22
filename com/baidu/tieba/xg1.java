package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xg1 {
    public static /* synthetic */ Interceptable $ic;
    public static xg1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public yg1 a;

    public xg1(yg1 yg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yg1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = yg1Var;
    }

    public static void c(yg1 yg1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, yg1Var) == null) && b == null) {
            synchronized (xg1.class) {
                if (b == null) {
                    b = new xg1(yg1Var);
                }
            }
        }
    }

    public static xg1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (xg1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        yg1 yg1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (yg1Var = this.a) != null) {
            yg1Var.a(imageView, str);
        }
    }
}
