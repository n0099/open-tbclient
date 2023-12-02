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
/* loaded from: classes7.dex */
public class qxb {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static qxb d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948108622, "Lcom/baidu/tieba/qxb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948108622, "Lcom/baidu/tieba/qxb;");
        }
    }

    /* loaded from: classes7.dex */
    public class a implements yxb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pxb a;

        public a(qxb qxbVar, pxb pxbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qxbVar, pxbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pxbVar;
        }

        @Override // com.baidu.tieba.yxb
        public void a(zxb zxbVar) {
            oxb oxbVar;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zxbVar) == null) {
                if (qxb.c) {
                    String str = qxb.b;
                    Log.d(str, "异步回调 结果:" + zxbVar);
                    String str2 = qxb.b;
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
                pxb pxbVar = this.a;
                if (pxbVar != null) {
                    if (zxbVar == null) {
                        oxbVar = null;
                    } else {
                        oxbVar = new oxb(zxbVar.c(), zxbVar.isSupport(), zxbVar.getOAID(), zxbVar.getAAID(), zxbVar.getVAID(), zxbVar.getStatusCode());
                    }
                    pxbVar.a(0, oxbVar);
                }
            }
        }
    }

    public qxb(Context context) {
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

    public static qxb c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (qxb.class) {
                    if (d == null) {
                        d = new qxb(context);
                        sxb.c(context);
                    }
                }
            }
            return d;
        }
        return (qxb) invokeL.objValue;
    }

    public void e(pxb pxbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pxbVar) == null) {
            rxb rxbVar = new rxb();
            rxbVar.b(1);
            rxbVar.a(false);
            d(rxbVar, pxbVar, Looper.getMainLooper());
        }
    }

    public void d(rxb rxbVar, pxb pxbVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, rxbVar, pxbVar, looper) == null) {
            wxb.o().i(this.a, looper, new a(this, pxbVar));
        }
    }
}
