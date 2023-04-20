package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class rf1 {
    public static /* synthetic */ Interceptable $ic;
    public static rf1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public sf1 a;

    public rf1(sf1 sf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sf1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = sf1Var;
    }

    public static void c(sf1 sf1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, sf1Var) == null) && b == null) {
            synchronized (rf1.class) {
                if (b == null) {
                    b = new rf1(sf1Var);
                }
            }
        }
    }

    public static rf1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (rf1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        sf1 sf1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (sf1Var = this.a) != null) {
            sf1Var.a(imageView, str);
        }
    }
}
