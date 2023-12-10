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
public class rxb {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static rxb d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948138413, "Lcom/baidu/tieba/rxb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948138413, "Lcom/baidu/tieba/rxb;");
        }
    }

    /* loaded from: classes8.dex */
    public class a implements zxb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qxb a;

        public a(rxb rxbVar, qxb qxbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rxbVar, qxbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qxbVar;
        }

        @Override // com.baidu.tieba.zxb
        public void a(ayb aybVar) {
            pxb pxbVar;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aybVar) == null) {
                if (rxb.c) {
                    String str = rxb.b;
                    Log.d(str, "异步回调 结果:" + aybVar);
                    String str2 = rxb.b;
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
                qxb qxbVar = this.a;
                if (qxbVar != null) {
                    if (aybVar == null) {
                        pxbVar = null;
                    } else {
                        pxbVar = new pxb(aybVar.c(), aybVar.isSupport(), aybVar.getOAID(), aybVar.getAAID(), aybVar.getVAID(), aybVar.getStatusCode());
                    }
                    qxbVar.a(0, pxbVar);
                }
            }
        }
    }

    public rxb(Context context) {
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

    public static rxb c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (rxb.class) {
                    if (d == null) {
                        d = new rxb(context);
                        txb.c(context);
                    }
                }
            }
            return d;
        }
        return (rxb) invokeL.objValue;
    }

    public void e(qxb qxbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qxbVar) == null) {
            sxb sxbVar = new sxb();
            sxbVar.b(1);
            sxbVar.a(false);
            d(sxbVar, qxbVar, Looper.getMainLooper());
        }
    }

    public void d(sxb sxbVar, qxb qxbVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, sxbVar, qxbVar, looper) == null) {
            xxb.o().i(this.a, looper, new a(this, qxbVar));
        }
    }
}
