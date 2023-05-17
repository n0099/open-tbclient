package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class m8 {
    public static /* synthetic */ Interceptable $ic;
    public static m8 b;
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448309666, "Lcom/baidu/tieba/m8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448309666, "Lcom/baidu/tieba/m8;");
        }
    }

    public m8(Context context) {
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
        this.a = context;
    }

    public static synchronized m8 d(Context context) {
        InterceptResult invokeL;
        m8 m8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (m8.class) {
                if (b == null) {
                    b = new m8(context);
                }
                m8Var = b;
            }
            return m8Var;
        }
        return (m8) invokeL.objValue;
    }

    public long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1L;
            }
            String[] split = Pattern.compile("\\.").split(str);
            return (Integer.parseInt(split[0]) << 23) + (Integer.parseInt(split[1]) << 18) + (Integer.parseInt(split[2]) << 12) + (Integer.parseInt(split[3]) << 7) + Integer.parseInt(split[4]);
        }
        return invokeL.longValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (c == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (c == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
        r3 = r4.split(":");
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006d, code lost:
        if (r3.length <= 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006f, code lost:
        java.util.Collections.addAll(r2, r3[1].trim().substring(1, r3[1].length() - 2).split(","));
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x008f -> B:28:0x009c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<String> c() {
        InterceptResult invokeV;
        Process process;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                process = new ProcessBuilder(new String[0]).command("/system/bin/getprop").redirectErrorStream(true).start();
            } catch (IOException e) {
                e.printStackTrace();
                process = null;
            }
            if (process == null) {
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            ArrayList arrayList = new ArrayList();
            String str = "debug." + AppRuntime.getAppContext().getPackageName() + ".csp";
            while (true) {
                try {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                if (readLine.contains(str)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } catch (Throwable th) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        bufferedReader.close();
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            bufferedReader.close();
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
