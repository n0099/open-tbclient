package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zg1 {
    public static /* synthetic */ Interceptable $ic;
    public static zg1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ah1 a;

    public zg1(ah1 ah1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ah1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ah1Var;
    }

    public static void c(ah1 ah1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, ah1Var) == null) && b == null) {
            synchronized (zg1.class) {
                if (b == null) {
                    b = new zg1(ah1Var);
                }
            }
        }
    }

    public static zg1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (zg1) invokeV.objValue;
    }

    public void a(ImageView imageView, String str) {
        ah1 ah1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) && (ah1Var = this.a) != null) {
            ah1Var.a(imageView, str);
        }
    }
}
