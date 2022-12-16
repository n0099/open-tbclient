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
public class kn9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static kn9 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947918995, "Lcom/baidu/tieba/kn9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947918995, "Lcom/baidu/tieba/kn9;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements sn9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jn9 a;

        public a(kn9 kn9Var, jn9 jn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kn9Var, jn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jn9Var;
        }

        @Override // com.baidu.tieba.sn9
        public void a(tn9 tn9Var) {
            in9 in9Var;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tn9Var) == null) {
                if (kn9.c) {
                    String str = kn9.b;
                    Log.d(str, "异步回调 结果:" + tn9Var);
                    String str2 = kn9.b;
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
                jn9 jn9Var = this.a;
                if (jn9Var != null) {
                    if (tn9Var == null) {
                        in9Var = null;
                    } else {
                        in9Var = new in9(tn9Var.c(), tn9Var.isSupport(), tn9Var.getOAID(), tn9Var.getAAID(), tn9Var.getVAID(), tn9Var.getStatusCode());
                    }
                    jn9Var.a(0, in9Var);
                }
            }
        }
    }

    public kn9(Context context) {
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

    public static kn9 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (kn9.class) {
                    if (d == null) {
                        d = new kn9(context);
                        mn9.c(context);
                    }
                }
            }
            return d;
        }
        return (kn9) invokeL.objValue;
    }

    public void e(jn9 jn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jn9Var) == null) {
            ln9 ln9Var = new ln9();
            ln9Var.b(1);
            ln9Var.a(false);
            d(ln9Var, jn9Var, Looper.getMainLooper());
        }
    }

    public void d(ln9 ln9Var, jn9 jn9Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, ln9Var, jn9Var, looper) == null) {
            qn9.o().i(this.a, looper, new a(this, jn9Var));
        }
    }
}
