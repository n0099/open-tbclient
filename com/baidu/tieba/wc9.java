package com.baidu.tieba;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class wc9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static wc9 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes6.dex */
    public class a implements ed9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vc9 a;

        public a(wc9 wc9Var, vc9 vc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wc9Var, vc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vc9Var;
        }

        @Override // com.baidu.tieba.ed9
        public void a(fd9 fd9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fd9Var) == null) {
                if (wc9.c) {
                    String str = wc9.b;
                    Log.d(str, "异步回调 结果:" + fd9Var);
                    String str2 = wc9.b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("异步回调 (listener != null):");
                    sb.append(this.a != null);
                    Log.d(str2, sb.toString());
                }
                vc9 vc9Var = this.a;
                if (vc9Var != null) {
                    vc9Var.a(0, fd9Var == null ? null : new uc9(fd9Var.c(), fd9Var.isSupport(), fd9Var.getOAID(), fd9Var.getAAID(), fd9Var.getVAID(), fd9Var.getStatusCode()));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948265916, "Lcom/baidu/tieba/wc9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948265916, "Lcom/baidu/tieba/wc9;");
        }
    }

    public wc9(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
    }

    public static wc9 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (wc9.class) {
                    if (d == null) {
                        d = new wc9(context);
                        yc9.c(context);
                    }
                }
            }
            return d;
        }
        return (wc9) invokeL.objValue;
    }

    public uc9 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            fd9 u = cd9.p().u(this.a);
            if (c) {
                String str = b;
                Log.d(str, "同步 结果:" + u);
            }
            if (u == null) {
                return null;
            }
            return new uc9(u.c(), u.isSupport(), u.getOAID(), u.getAAID(), u.getVAID(), u.getStatusCode());
        }
        return (uc9) invokeV.objValue;
    }

    public void e(xc9 xc9Var, vc9 vc9Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xc9Var, vc9Var, looper) == null) {
            cd9.p().j(this.a, looper, new a(this, vc9Var));
        }
    }

    public void f(vc9 vc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vc9Var) == null) {
            xc9 xc9Var = new xc9();
            xc9Var.b(1);
            xc9Var.a(false);
            e(xc9Var, vc9Var, Looper.getMainLooper());
        }
    }
}
