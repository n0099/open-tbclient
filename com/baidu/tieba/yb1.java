package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class yb1 {
    public static /* synthetic */ Interceptable $ic;
    public static yb1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public zb1 a;

    public yb1(zb1 zb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zb1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zb1Var;
    }

    public static void c(zb1 zb1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, zb1Var) == null) && b == null) {
            synchronized (yb1.class) {
                if (b == null) {
                    b = new yb1(zb1Var);
                }
            }
        }
    }

    public static yb1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (yb1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        zb1 zb1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (zb1Var = this.a) != null) {
            zb1Var.a(imageView, str);
        }
    }
}
