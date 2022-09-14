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
public class zg9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static zg9 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes6.dex */
    public class a implements hh9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yg9 a;

        public a(zg9 zg9Var, yg9 yg9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zg9Var, yg9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yg9Var;
        }

        @Override // com.baidu.tieba.hh9
        public void a(ih9 ih9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ih9Var) == null) {
                if (zg9.c) {
                    String str = zg9.b;
                    Log.d(str, "异步回调 结果:" + ih9Var);
                    String str2 = zg9.b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("异步回调 (listener != null):");
                    sb.append(this.a != null);
                    Log.d(str2, sb.toString());
                }
                yg9 yg9Var = this.a;
                if (yg9Var != null) {
                    yg9Var.a(0, ih9Var == null ? null : new xg9(ih9Var.c(), ih9Var.isSupport(), ih9Var.getOAID(), ih9Var.getAAID(), ih9Var.getVAID(), ih9Var.getStatusCode()));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948359133, "Lcom/baidu/tieba/zg9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948359133, "Lcom/baidu/tieba/zg9;");
        }
    }

    public zg9(Context context) {
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

    public static zg9 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (zg9.class) {
                    if (d == null) {
                        d = new zg9(context);
                        bh9.c(context);
                    }
                }
            }
            return d;
        }
        return (zg9) invokeL.objValue;
    }

    public void d(ah9 ah9Var, yg9 yg9Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, ah9Var, yg9Var, looper) == null) {
            fh9.o().i(this.a, looper, new a(this, yg9Var));
        }
    }

    public void e(yg9 yg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg9Var) == null) {
            ah9 ah9Var = new ah9();
            ah9Var.b(1);
            ah9Var.a(false);
            d(ah9Var, yg9Var, Looper.getMainLooper());
        }
    }
}
