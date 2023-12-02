package com.baidu.tieba;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class np5 extends sp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mp5 b;
    public boolean c;
    public boolean d;

    public np5() {
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
            mp5 mp5Var = this.b;
            if (mp5Var != null) {
                return mp5Var.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void c() {
        mp5 mp5Var;
        wp5 wp5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.d && (mp5Var = this.b) != null && mp5Var.b() >= 0 && (wp5Var = (wp5) PerformanceLoggerHelper.getInstance().getLoggerWithType(this.a)) != null) {
            wp5Var.d(this);
            this.d = true;
        }
    }

    public void e() {
        mp5 mp5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && Build.VERSION.SDK_INT >= 16 && (mp5Var = this.b) != null) {
            mp5Var.d();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.c && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            this.c = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.b == null) {
                    this.b = new mp5();
                }
                this.b.c();
            }
        }
    }
}
