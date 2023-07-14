package com.baidu.tieba;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xt5 extends cu5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wt5 b;
    public boolean c;
    public boolean d;

    public xt5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            wt5 wt5Var = this.b;
            if (wt5Var != null) {
                return wt5Var.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void c() {
        wt5 wt5Var;
        hu5 hu5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.d && (wt5Var = this.b) != null && wt5Var.b() >= 0 && (hu5Var = (hu5) PerformanceLoggerHelper.getInstance().getLoggerWithType(this.a)) != null) {
            hu5Var.e(this);
            this.d = true;
        }
    }

    public void e() {
        wt5 wt5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && Build.VERSION.SDK_INT >= 16 && (wt5Var = this.b) != null) {
            wt5Var.d();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.c && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            this.c = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.b == null) {
                    this.b = new wt5();
                }
                this.b.c();
            }
        }
    }
}
