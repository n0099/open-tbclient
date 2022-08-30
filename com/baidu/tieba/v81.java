package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class v81 {
    public static /* synthetic */ Interceptable $ic;
    public static v81 b;
    public transient /* synthetic */ FieldHolder $fh;
    public w81 a;

    public v81(w81 w81Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w81Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = w81Var;
    }

    public static v81 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? b : (v81) invokeV.objValue;
    }

    public static void c(w81 w81Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, w81Var) == null) && b == null) {
            synchronized (v81.class) {
                if (b == null) {
                    b = new v81(w81Var);
                }
            }
        }
    }

    public void a(ImageView imageView, String str) {
        w81 w81Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) || (w81Var = this.a) == null) {
            return;
        }
        w81Var.a(imageView, str);
    }
}
