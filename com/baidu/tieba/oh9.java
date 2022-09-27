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
/* loaded from: classes5.dex */
public class oh9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static oh9 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes5.dex */
    public class a implements wh9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh9 a;

        public a(oh9 oh9Var, nh9 nh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh9Var, nh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nh9Var;
        }

        @Override // com.baidu.tieba.wh9
        public void a(xh9 xh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xh9Var) == null) {
                if (oh9.c) {
                    String str = oh9.b;
                    Log.d(str, "异步回调 结果:" + xh9Var);
                    String str2 = oh9.b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("异步回调 (listener != null):");
                    sb.append(this.a != null);
                    Log.d(str2, sb.toString());
                }
                nh9 nh9Var = this.a;
                if (nh9Var != null) {
                    nh9Var.a(0, xh9Var == null ? null : new mh9(xh9Var.c(), xh9Var.isSupport(), xh9Var.getOAID(), xh9Var.getAAID(), xh9Var.getVAID(), xh9Var.getStatusCode()));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948032393, "Lcom/baidu/tieba/oh9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948032393, "Lcom/baidu/tieba/oh9;");
        }
    }

    public oh9(Context context) {
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

    public static oh9 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (oh9.class) {
                    if (d == null) {
                        d = new oh9(context);
                        qh9.c(context);
                    }
                }
            }
            return d;
        }
        return (oh9) invokeL.objValue;
    }

    public void d(ph9 ph9Var, nh9 nh9Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, ph9Var, nh9Var, looper) == null) {
            uh9.o().i(this.a, looper, new a(this, nh9Var));
        }
    }

    public void e(nh9 nh9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nh9Var) == null) {
            ph9 ph9Var = new ph9();
            ph9Var.b(1);
            ph9Var.a(false);
            d(ph9Var, nh9Var, Looper.getMainLooper());
        }
    }
}
