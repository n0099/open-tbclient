package com.baidu.webkit.internal.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f53006b = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1860953226, "Lcom/baidu/webkit/internal/utils/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1860953226, "Lcom/baidu/webkit/internal/utils/b;");
        }
    }

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            synchronized (b.class) {
                File filesDir = WebViewFactory.getContext().getFilesDir();
                try {
                    new File(filesDir, WebKitFactory.getProcessTypeString() + "zeus_init_model_opt").createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static synchronized int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (b.class) {
                if (!a) {
                    File filesDir = WebViewFactory.getContext().getFilesDir();
                    StringBuilder sb = new StringBuilder();
                    sb.append(WebKitFactory.getProcessTypeString());
                    sb.append("zeus_init_model_opt");
                    f53006b = new File(filesDir, sb.toString()).exists() ? 1 : -1;
                    a = true;
                }
            }
            return 1;
        }
        return invokeV.intValue;
    }
}
