package com.baidu.tieba;

import android.content.ContentResolver;
import android.content.ContentValues;
import androidx.annotation.AnyThread;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j03 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947829436, "Lcom/baidu/tieba/j03;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947829436, "Lcom/baidu/tieba/j03;");
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            k63 c0;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (c0 = k63.c0()) == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("appKey", c0.getAppId());
            contentValues.put("launch_type", Integer.valueOf(cd3.c()));
            contentValues.put("source", c0.X().U());
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            ContentResolver contentResolver = rp2.c().getContentResolver();
            if (contentResolver != null) {
                contentResolver.insert(ld2.b(), contentValues);
            }
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            int i = a;
            if (i != -1) {
                return i;
            }
            rp2.g0().getSwitch("swan_backstage_policy", 0);
            a = 300;
            if (300 < 60) {
                a = 60;
            } else if (300 > 3600) {
                a = 3600;
            }
            return a;
        }
        return invokeV.intValue;
    }

    @AnyThread
    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            ej3.k(new a(), "SwanLaunchBehavior");
        }
    }
}
