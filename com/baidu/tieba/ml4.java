package com.baidu.tieba;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import java.io.File;
/* loaded from: classes5.dex */
public class ml4 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947976500, "Lcom/baidu/tieba/ml4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947976500, "Lcom/baidu/tieba/ml4;");
                return;
            }
        }
        a = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + ZeusWebViewPreloadClass.ZEUS_FILE_DIR + File.separator + "libs";
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new File(a + File.separator + "libzeuswebviewchromium.so").exists();
        }
        return invokeV.booleanValue;
    }
}
