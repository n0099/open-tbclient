package com.baidu.tieba;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class s23 implements bt2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Runnable, String> c;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final s23 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-482162665, "Lcom/baidu/tieba/s23$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-482162665, "Lcom/baidu/tieba/s23$b;");
                    return;
                }
            }
            a = new s23(null);
        }
    }

    public s23() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ConcurrentHashMap();
    }

    public static s23 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (s23) invokeV.objValue;
    }

    public /* synthetic */ s23(a aVar) {
        this();
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (bt2.a) {
                Log.e("SwanPerformance", "main process launch start，appId = " + str);
            }
            System.currentTimeMillis();
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.c.isEmpty()) {
            return;
        }
        if (bt2.a) {
            Log.d("SwanPerformance", "main process batch handle thread, size = " + this.c.size());
        }
        for (Map.Entry<Runnable, String> entry : this.c.entrySet()) {
            if (entry != null) {
                ExecutorUtilsExt.postOnElastic(entry.getKey(), entry.getValue(), 2);
            }
        }
        this.c.clear();
    }

    public void c(Message message) {
        Object obj;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) != null) || message == null || (obj = message.obj) == null || !(obj instanceof Bundle)) {
            return;
        }
        Bundle bundle = (Bundle) obj;
        boolean z = bundle.getBoolean("is_timeout", false);
        String string = bundle.getString("app_id", null);
        if (bt2.a) {
            Log.e("SwanPerformance", "main process launch end，timeout = " + z + " ; appId = " + string);
        }
        a();
    }
}
