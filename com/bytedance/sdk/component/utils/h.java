package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile HandlerThread f28996a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Handler f28997b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1410335818, "Lcom/bytedance/sdk/component/utils/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1410335818, "Lcom/bytedance/sdk/component/utils/h;");
                return;
            }
        }
        f28996a = new HandlerThread("tt_pangle_thread_io_handler");
        f28996a.start();
        f28997b = new Handler(f28996a.getLooper());
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Handler a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f28996a == null || !f28996a.isAlive()) {
                synchronized (h.class) {
                    if (f28996a == null || !f28996a.isAlive()) {
                        f28996a = new HandlerThread("tt_pangle_thread_io_handler");
                        f28996a.start();
                        f28997b = new Handler(f28996a.getLooper());
                    }
                }
            }
            return f28997b;
        }
        return (Handler) invokeV.objValue;
    }
}
