package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class sg1 {
    public static /* synthetic */ Interceptable $ic;
    public static sg1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public tg1 a;

    public sg1(tg1 tg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tg1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tg1Var;
    }

    public static void c(tg1 tg1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, tg1Var) == null) && b == null) {
            synchronized (sg1.class) {
                if (b == null) {
                    b = new sg1(tg1Var);
                }
            }
        }
    }

    public static sg1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (sg1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        tg1 tg1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (tg1Var = this.a) != null) {
            tg1Var.a(imageView, str);
        }
    }
}
