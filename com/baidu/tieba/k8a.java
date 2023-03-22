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
public class k8a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static k8a d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947868341, "Lcom/baidu/tieba/k8a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947868341, "Lcom/baidu/tieba/k8a;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements s8a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j8a a;

        public a(k8a k8aVar, j8a j8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k8aVar, j8aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j8aVar;
        }

        @Override // com.baidu.tieba.s8a
        public void a(t8a t8aVar) {
            i8a i8aVar;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t8aVar) == null) {
                if (k8a.c) {
                    String str = k8a.b;
                    Log.d(str, "异步回调 结果:" + t8aVar);
                    String str2 = k8a.b;
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
                j8a j8aVar = this.a;
                if (j8aVar != null) {
                    if (t8aVar == null) {
                        i8aVar = null;
                    } else {
                        i8aVar = new i8a(t8aVar.c(), t8aVar.isSupport(), t8aVar.getOAID(), t8aVar.getAAID(), t8aVar.getVAID(), t8aVar.getStatusCode());
                    }
                    j8aVar.a(0, i8aVar);
                }
            }
        }
    }

    public k8a(Context context) {
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

    public static k8a c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (k8a.class) {
                    if (d == null) {
                        d = new k8a(context);
                        m8a.c(context);
                    }
                }
            }
            return d;
        }
        return (k8a) invokeL.objValue;
    }

    public void e(j8a j8aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j8aVar) == null) {
            l8a l8aVar = new l8a();
            l8aVar.b(1);
            l8aVar.a(false);
            d(l8aVar, j8aVar, Looper.getMainLooper());
        }
    }

    public void d(l8a l8aVar, j8a j8aVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, l8aVar, j8aVar, looper) == null) {
            q8a.o().i(this.a, looper, new a(this, j8aVar));
        }
    }
}
