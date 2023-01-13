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
public class ts9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static ts9 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948191919, "Lcom/baidu/tieba/ts9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948191919, "Lcom/baidu/tieba/ts9;");
        }
    }

    /* loaded from: classes6.dex */
    public class a implements bt9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ss9 a;

        public a(ts9 ts9Var, ss9 ss9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts9Var, ss9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ss9Var;
        }

        @Override // com.baidu.tieba.bt9
        public void a(ct9 ct9Var) {
            rs9 rs9Var;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ct9Var) == null) {
                if (ts9.c) {
                    String str = ts9.b;
                    Log.d(str, "异步回调 结果:" + ct9Var);
                    String str2 = ts9.b;
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
                ss9 ss9Var = this.a;
                if (ss9Var != null) {
                    if (ct9Var == null) {
                        rs9Var = null;
                    } else {
                        rs9Var = new rs9(ct9Var.c(), ct9Var.isSupport(), ct9Var.getOAID(), ct9Var.getAAID(), ct9Var.getVAID(), ct9Var.getStatusCode());
                    }
                    ss9Var.a(0, rs9Var);
                }
            }
        }
    }

    public ts9(Context context) {
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

    public static ts9 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (ts9.class) {
                    if (d == null) {
                        d = new ts9(context);
                        vs9.c(context);
                    }
                }
            }
            return d;
        }
        return (ts9) invokeL.objValue;
    }

    public void e(ss9 ss9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ss9Var) == null) {
            us9 us9Var = new us9();
            us9Var.b(1);
            us9Var.a(false);
            d(us9Var, ss9Var, Looper.getMainLooper());
        }
    }

    public void d(us9 us9Var, ss9 ss9Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, us9Var, ss9Var, looper) == null) {
            zs9.o().i(this.a, looper, new a(this, ss9Var));
        }
    }
}
