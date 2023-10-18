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
public class tfb {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static tfb d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948180697, "Lcom/baidu/tieba/tfb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948180697, "Lcom/baidu/tieba/tfb;");
        }
    }

    /* loaded from: classes8.dex */
    public class a implements bgb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sfb a;

        public a(tfb tfbVar, sfb sfbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tfbVar, sfbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sfbVar;
        }

        @Override // com.baidu.tieba.bgb
        public void a(cgb cgbVar) {
            rfb rfbVar;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cgbVar) == null) {
                if (tfb.c) {
                    String str = tfb.b;
                    Log.d(str, "异步回调 结果:" + cgbVar);
                    String str2 = tfb.b;
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
                sfb sfbVar = this.a;
                if (sfbVar != null) {
                    if (cgbVar == null) {
                        rfbVar = null;
                    } else {
                        rfbVar = new rfb(cgbVar.c(), cgbVar.isSupport(), cgbVar.getOAID(), cgbVar.getAAID(), cgbVar.getVAID(), cgbVar.getStatusCode());
                    }
                    sfbVar.a(0, rfbVar);
                }
            }
        }
    }

    public tfb(Context context) {
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

    public static tfb c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (tfb.class) {
                    if (d == null) {
                        d = new tfb(context);
                        vfb.c(context);
                    }
                }
            }
            return d;
        }
        return (tfb) invokeL.objValue;
    }

    public void e(sfb sfbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sfbVar) == null) {
            ufb ufbVar = new ufb();
            ufbVar.b(1);
            ufbVar.a(false);
            d(ufbVar, sfbVar, Looper.getMainLooper());
        }
    }

    public void d(ufb ufbVar, sfb sfbVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, ufbVar, sfbVar, looper) == null) {
            zfb.o().i(this.a, looper, new a(this, sfbVar));
        }
    }
}
