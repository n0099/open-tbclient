package com.baidu.tieba;

import android.content.Context;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.transvod.player.log.TLog;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class xeb {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948298900, "Lcom/baidu/tieba/xeb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948298900, "Lcom/baidu/tieba/xeb;");
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
            synchronized (xeb.class) {
                TLog.h("[LibraryLoad]", "loadAllLibrary return for this version need dynamic download library!");
            }
        }
    }

    public static synchronized void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            synchronized (xeb.class) {
                TLog.h("[LibraryLoad]", "loadAllLibrary with context");
                if (a.get()) {
                    TLog.h("[LibraryLoad]", "loadAllLibrary with context is loading or already loaded");
                    return;
                }
                if (a.compareAndSet(false, true)) {
                    d();
                    boolean y = zgb.y(context);
                    a.set(y);
                    if (y) {
                        TLog.h("[LibraryLoad]", "load transvod success, processId:" + Process.myPid());
                    }
                }
            }
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String[] strArr = {SwanKV.LIB_CPP_SHARED, "cyber-ffmpeg", "ssl.1.1.1j", "crypto.1.1.1j"};
            boolean z = true;
            for (int i = 0; i < strArr.length; i++) {
                try {
                    TLog.h("[LibraryLoad]", "loadLibrary: " + strArr[i]);
                    System.loadLibrary(strArr[i]);
                } catch (UnsatisfiedLinkError e) {
                    TLog.d("[LibraryLoad]", "load transvod failed, UnsatisfiedLinkError " + e.getMessage());
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }
}
