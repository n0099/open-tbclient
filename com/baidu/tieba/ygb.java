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
/* loaded from: classes8.dex */
public class ygb {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static ygb d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948330613, "Lcom/baidu/tieba/ygb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948330613, "Lcom/baidu/tieba/ygb;");
        }
    }

    /* loaded from: classes8.dex */
    public class a implements ghb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xgb a;

        public a(ygb ygbVar, xgb xgbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ygbVar, xgbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xgbVar;
        }

        @Override // com.baidu.tieba.ghb
        public void a(hhb hhbVar) {
            wgb wgbVar;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hhbVar) == null) {
                if (ygb.c) {
                    String str = ygb.b;
                    Log.d(str, "异步回调 结果:" + hhbVar);
                    String str2 = ygb.b;
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
                xgb xgbVar = this.a;
                if (xgbVar != null) {
                    if (hhbVar == null) {
                        wgbVar = null;
                    } else {
                        wgbVar = new wgb(hhbVar.c(), hhbVar.isSupport(), hhbVar.getOAID(), hhbVar.getAAID(), hhbVar.getVAID(), hhbVar.getStatusCode());
                    }
                    xgbVar.a(0, wgbVar);
                }
            }
        }
    }

    public ygb(Context context) {
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

    public static ygb c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (ygb.class) {
                    if (d == null) {
                        d = new ygb(context);
                        ahb.c(context);
                    }
                }
            }
            return d;
        }
        return (ygb) invokeL.objValue;
    }

    public void e(xgb xgbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xgbVar) == null) {
            zgb zgbVar = new zgb();
            zgbVar.b(1);
            zgbVar.a(false);
            d(zgbVar, xgbVar, Looper.getMainLooper());
        }
    }

    public void d(zgb zgbVar, xgb xgbVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, zgbVar, xgbVar, looper) == null) {
            ehb.o().i(this.a, looper, new a(this, xgbVar));
        }
    }
}
