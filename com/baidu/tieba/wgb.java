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
public class wgb {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static wgb d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948271031, "Lcom/baidu/tieba/wgb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948271031, "Lcom/baidu/tieba/wgb;");
        }
    }

    /* loaded from: classes8.dex */
    public class a implements ehb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vgb a;

        public a(wgb wgbVar, vgb vgbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wgbVar, vgbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vgbVar;
        }

        @Override // com.baidu.tieba.ehb
        public void a(fhb fhbVar) {
            ugb ugbVar;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fhbVar) == null) {
                if (wgb.c) {
                    String str = wgb.b;
                    Log.d(str, "异步回调 结果:" + fhbVar);
                    String str2 = wgb.b;
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
                vgb vgbVar = this.a;
                if (vgbVar != null) {
                    if (fhbVar == null) {
                        ugbVar = null;
                    } else {
                        ugbVar = new ugb(fhbVar.c(), fhbVar.isSupport(), fhbVar.getOAID(), fhbVar.getAAID(), fhbVar.getVAID(), fhbVar.getStatusCode());
                    }
                    vgbVar.a(0, ugbVar);
                }
            }
        }
    }

    public wgb(Context context) {
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

    public static wgb c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (wgb.class) {
                    if (d == null) {
                        d = new wgb(context);
                        ygb.c(context);
                    }
                }
            }
            return d;
        }
        return (wgb) invokeL.objValue;
    }

    public void e(vgb vgbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vgbVar) == null) {
            xgb xgbVar = new xgb();
            xgbVar.b(1);
            xgbVar.a(false);
            d(xgbVar, vgbVar, Looper.getMainLooper());
        }
    }

    public void d(xgb xgbVar, vgb vgbVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, xgbVar, vgbVar, looper) == null) {
            chb.o().i(this.a, looper, new a(this, vgbVar));
        }
    }
}
