package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class sa1 {
    public static /* synthetic */ Interceptable $ic;
    public static sa1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ta1 a;

    public sa1(ta1 ta1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ta1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ta1Var;
    }

    public static sa1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? b : (sa1) invokeV.objValue;
    }

    public static void c(ta1 ta1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, ta1Var) == null) && b == null) {
            synchronized (sa1.class) {
                if (b == null) {
                    b = new sa1(ta1Var);
                }
            }
        }
    }

    public void a(ImageView imageView, String str) {
        ta1 ta1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) || (ta1Var = this.a) == null) {
            return;
        }
        ta1Var.a(imageView, str);
    }
}
