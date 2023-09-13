package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class u53 implements s53 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public t53 a;
    public long b;
    public long c;

    /* loaded from: classes8.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u53 a;

        public a(u53 u53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u53Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (this.a.j()) {
                    this.a.k();
                    return true;
                }
                this.a.l();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948161942, "Lcom/baidu/tieba/u53;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948161942, "Lcom/baidu/tieba/u53;");
                return;
            }
        }
        d = rr1.a;
    }

    public u53() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (j()) {
            this.a = new t53();
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!d) {
                return false;
            }
            return AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).getBoolean("light_info_switch", false);
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", false).apply();
            t53 t53Var = this.a;
            if (t53Var != null) {
                t53Var.c();
            }
        }
    }

    @Override // com.baidu.tieba.s53
    public void a(long j) {
        t53 t53Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && j() && (t53Var = this.a) != null) {
            t53Var.f(j - this.b);
        }
    }

    @Override // com.baidu.tieba.s53
    public void c(long j) {
        t53 t53Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && j() && (t53Var = this.a) != null) {
            t53Var.h(j - this.b);
        }
    }

    @Override // com.baidu.tieba.s53
    public void d(long j) {
        t53 t53Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) && j() && (t53Var = this.a) != null) {
            t53Var.i(j - this.b);
        }
    }

    @Override // com.baidu.tieba.s53
    public void e(long j) {
        t53 t53Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048579, this, j) == null) && j() && (t53Var = this.a) != null) {
            t53Var.g(j - this.b);
        }
    }

    @Override // com.baidu.tieba.t43
    public void end(long j) {
        t53 t53Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048580, this, j) == null) && j() && (t53Var = this.a) != null) {
            this.c = j;
            t53Var.l(this.b, j);
            this.a.a();
        }
    }

    @Override // com.baidu.tieba.s53
    public void f(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && d && view2 != null) {
            view2.setOnLongClickListener(new a(this));
        }
    }

    @Override // com.baidu.tieba.t43
    public void start(long j) {
        t53 t53Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048585, this, j) == null) && j() && (t53Var = this.a) != null) {
            this.b = j;
            t53Var.e();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AppRuntime.getAppContext().getSharedPreferences("light_info_debug", 0).edit().putBoolean("light_info_switch", true).apply();
            if (this.a == null) {
                this.a = new t53();
            }
            this.a.k();
        }
    }
}
