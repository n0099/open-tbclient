package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class qf1 {
    public static /* synthetic */ Interceptable $ic;
    public static qf1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public rf1 a;

    public qf1(rf1 rf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rf1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = rf1Var;
    }

    public static void c(rf1 rf1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, rf1Var) == null) && b == null) {
            synchronized (qf1.class) {
                if (b == null) {
                    b = new qf1(rf1Var);
                }
            }
        }
    }

    public static qf1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (qf1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        rf1 rf1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (rf1Var = this.a) != null) {
            rf1Var.a(imageView, str);
        }
    }
}
