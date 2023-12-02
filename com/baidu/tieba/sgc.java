package com.baidu.tieba;

import android.content.Context;
import android.os.Process;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.transvod.player.log.TLog;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class sgc {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948151898, "Lcom/baidu/tieba/sgc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948151898, "Lcom/baidu/tieba/sgc;");
                return;
            }
        }
        a = new AtomicBoolean(false);
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.get();
        }
        return invokeV.booleanValue;
    }

    public static synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (sgc.class) {
                if (a.get()) {
                    return;
                }
                TLog.h("[LibraryLoad]", "loadAllLibrary return for this version need dynamic download library!");
            }
        }
    }

    public static synchronized void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            synchronized (sgc.class) {
                if (a.get()) {
                    return;
                }
                TLog.h("[LibraryLoad]", "loadAllLibrary with context");
                whc.d();
                if (a.compareAndSet(false, true)) {
                    boolean z = uic.z(context);
                    a.set(z);
                    if (z) {
                        TLog.h("[LibraryLoad]", "load transvod success, processId:" + Process.myPid());
                    }
                }
            }
        }
    }
}
