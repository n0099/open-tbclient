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
public class pxa {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static pxa d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948078800, "Lcom/baidu/tieba/pxa;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948078800, "Lcom/baidu/tieba/pxa;");
        }
    }

    /* loaded from: classes7.dex */
    public class a implements xxa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oxa a;

        public a(pxa pxaVar, oxa oxaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pxaVar, oxaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oxaVar;
        }

        @Override // com.baidu.tieba.xxa
        public void a(yxa yxaVar) {
            nxa nxaVar;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, yxaVar) == null) {
                if (pxa.c) {
                    String str = pxa.b;
                    Log.d(str, "异步回调 结果:" + yxaVar);
                    String str2 = pxa.b;
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
                oxa oxaVar = this.a;
                if (oxaVar != null) {
                    if (yxaVar == null) {
                        nxaVar = null;
                    } else {
                        nxaVar = new nxa(yxaVar.c(), yxaVar.isSupport(), yxaVar.getOAID(), yxaVar.getAAID(), yxaVar.getVAID(), yxaVar.getStatusCode());
                    }
                    oxaVar.a(0, nxaVar);
                }
            }
        }
    }

    public pxa(Context context) {
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

    public static pxa c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (pxa.class) {
                    if (d == null) {
                        d = new pxa(context);
                        rxa.c(context);
                    }
                }
            }
            return d;
        }
        return (pxa) invokeL.objValue;
    }

    public void e(oxa oxaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oxaVar) == null) {
            qxa qxaVar = new qxa();
            qxaVar.b(1);
            qxaVar.a(false);
            d(qxaVar, oxaVar, Looper.getMainLooper());
        }
    }

    public void d(qxa qxaVar, oxa oxaVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, qxaVar, oxaVar, looper) == null) {
            vxa.o().i(this.a, looper, new a(this, oxaVar));
        }
    }
}
