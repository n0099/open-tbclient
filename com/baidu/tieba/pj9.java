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
public class pj9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static pj9 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948064106, "Lcom/baidu/tieba/pj9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948064106, "Lcom/baidu/tieba/pj9;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements xj9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oj9 a;

        public a(pj9 pj9Var, oj9 oj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pj9Var, oj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oj9Var;
        }

        @Override // com.baidu.tieba.xj9
        public void a(yj9 yj9Var) {
            nj9 nj9Var;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, yj9Var) == null) {
                if (pj9.c) {
                    String str = pj9.b;
                    Log.d(str, "异步回调 结果:" + yj9Var);
                    String str2 = pj9.b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("异步回调 (listener != null):");
                    if (this.a != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sb.append(z);
                    Log.d(str2, sb.toString());
                }
                oj9 oj9Var = this.a;
                if (oj9Var != null) {
                    if (yj9Var == null) {
                        nj9Var = null;
                    } else {
                        nj9Var = new nj9(yj9Var.c(), yj9Var.isSupport(), yj9Var.getOAID(), yj9Var.getAAID(), yj9Var.getVAID(), yj9Var.getStatusCode());
                    }
                    oj9Var.a(0, nj9Var);
                }
            }
        }
    }

    public pj9(Context context) {
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

    public static pj9 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (pj9.class) {
                    if (d == null) {
                        d = new pj9(context);
                        rj9.c(context);
                    }
                }
            }
            return d;
        }
        return (pj9) invokeL.objValue;
    }

    public void e(oj9 oj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oj9Var) == null) {
            qj9 qj9Var = new qj9();
            qj9Var.b(1);
            qj9Var.a(false);
            d(qj9Var, oj9Var, Looper.getMainLooper());
        }
    }

    public void d(qj9 qj9Var, oj9 oj9Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, qj9Var, oj9Var, looper) == null) {
            vj9.o().i(this.a, looper, new a(this, oj9Var));
        }
    }
}
