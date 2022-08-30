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
public class yc9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static yc9 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes6.dex */
    public class a implements gd9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xc9 a;

        public a(yc9 yc9Var, xc9 xc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc9Var, xc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xc9Var;
        }

        @Override // com.baidu.tieba.gd9
        public void a(hd9 hd9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hd9Var) == null) {
                if (yc9.c) {
                    String str = yc9.b;
                    Log.d(str, "异步回调 结果:" + hd9Var);
                    String str2 = yc9.b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("异步回调 (listener != null):");
                    sb.append(this.a != null);
                    Log.d(str2, sb.toString());
                }
                xc9 xc9Var = this.a;
                if (xc9Var != null) {
                    xc9Var.a(0, hd9Var == null ? null : new wc9(hd9Var.c(), hd9Var.isSupport(), hd9Var.getOAID(), hd9Var.getAAID(), hd9Var.getVAID(), hd9Var.getStatusCode()));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948325498, "Lcom/baidu/tieba/yc9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948325498, "Lcom/baidu/tieba/yc9;");
        }
    }

    public yc9(Context context) {
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

    public static yc9 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (yc9.class) {
                    if (d == null) {
                        d = new yc9(context);
                        ad9.c(context);
                    }
                }
            }
            return d;
        }
        return (yc9) invokeL.objValue;
    }

    public wc9 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            hd9 u = ed9.p().u(this.a);
            if (c) {
                String str = b;
                Log.d(str, "同步 结果:" + u);
            }
            if (u == null) {
                return null;
            }
            return new wc9(u.c(), u.isSupport(), u.getOAID(), u.getAAID(), u.getVAID(), u.getStatusCode());
        }
        return (wc9) invokeV.objValue;
    }

    public void e(zc9 zc9Var, xc9 xc9Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zc9Var, xc9Var, looper) == null) {
            ed9.p().j(this.a, looper, new a(this, xc9Var));
        }
    }

    public void f(xc9 xc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xc9Var) == null) {
            zc9 zc9Var = new zc9();
            zc9Var.b(1);
            zc9Var.a(false);
            e(zc9Var, xc9Var, Looper.getMainLooper());
        }
    }
}
