package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.so.SoLoader;
import com.baidu.swan.apps.so.SoUtils;
import com.baidu.tieba.fe3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: classes5.dex */
public class pd3 implements SoUtils.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948058154, "Lcom/baidu/tieba/pd3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948058154, "Lcom/baidu/tieba/pd3;");
                return;
            }
        }
        a = ho1.a;
    }

    public pd3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final String a(String str) {
        InterceptResult invokeL;
        String absolutePath;
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(er2.c(), str);
            if (findSoFilesInLibrary == null) {
                absolutePath = null;
            } else {
                absolutePath = findSoFilesInLibrary.getAbsolutePath();
            }
            if (findSoFilesInLibrary == null) {
                length = 0;
            } else {
                length = findSoFilesInLibrary.length();
            }
            return String.format(Locale.CHINA, "[%s:%s,size:%d]", str, absolutePath, Long.valueOf(length));
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.swan.apps.so.SoUtils.a
    public void onEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) != null) || TextUtils.isEmpty(str2)) {
            return;
        }
        String[] strArr = {Build.CPU_ABI, Build.CPU_ABI2};
        String str3 = Arrays.toString(strArr) + "\n" + io1.a() + "\n" + a("v8.engine") + "\n" + a("zeusv8") + "\n" + str2;
        if (a) {
            Log.d("SoUbcDefaultImpl", "reportSoLoadInfo: " + str3);
        }
        fe3.b bVar = new fe3.b(10007);
        bVar.j(str);
        bVar.i(str3);
        bVar.h(x73.g0());
        bVar.m();
    }
}
