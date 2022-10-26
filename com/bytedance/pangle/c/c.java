package com.bytedance.pangle.c;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusConstants;
import java.io.File;
/* loaded from: classes7.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public static File a;
    public static File b;
    public static File c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-294229934, "Lcom/bytedance/pangle/c/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-294229934, "Lcom/bytedance/pangle/c/c;");
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            Application appApplication = Zeus.getAppApplication();
            if (b == null) {
                File downloadDir = GlobalParam.getInstance().getDownloadDir();
                if (downloadDir == null) {
                    File filesDir = appApplication.getFilesDir();
                    downloadDir = new File(filesDir, "." + ZeusConstants.BASE_LIB_NAME + ZeusConstants.b);
                }
                b = downloadDir;
            }
            return a(b);
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            Application appApplication = Zeus.getAppApplication();
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    File externalFilesDir = appApplication.getExternalFilesDir("." + ZeusConstants.BASE_LIB_NAME + ZeusConstants.b);
                    if (externalFilesDir != null) {
                        return a(externalFilesDir);
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
            if (file != null) {
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file.getPath();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return a(str);
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i)) == null) {
            d();
            File file = a;
            String[] strArr = {str, "version-".concat(String.valueOf(i))};
            for (int i2 = 0; i2 < 2; i2++) {
                String str2 = strArr[i2];
                if (!TextUtils.isEmpty(str2)) {
                    file = new File(file, str2);
                }
            }
            if (file != null) {
                return file.getPath();
            }
            return null;
        }
        return (String) invokeLI.objValue;
    }

    public static String a(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, strArr)) == null) {
            d();
            File file = a;
            if (strArr.length > 0) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        file = new File(file, str);
                    }
                }
            }
            return a(file);
        }
        return (String) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            Application appApplication = Zeus.getAppApplication();
            if (c == null) {
                File filesDir = appApplication.getFilesDir();
                c = new File(filesDir, "." + ZeusConstants.BASE_LIB_NAME + ZeusConstants.a);
            }
            return a(c);
        }
        return (String) invokeV.objValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, null) == null) && a == null) {
            File filesDir = Zeus.getAppApplication().getFilesDir();
            File file = new File(filesDir, ZeusConstants.BASE_LIB_NAME + ZeusConstants.c);
            a = file;
            a(file);
        }
    }

    public static String b(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, str, i)) == null) {
            return new File(a(str, "version-".concat(String.valueOf(i)), "apk"), "base-1.apk").getPath();
        }
        return (String) invokeLI.objValue;
    }

    public static String c(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, str, i)) == null) {
            return a(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
        }
        return (String) invokeLI.objValue;
    }

    public static String d(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, str, i)) == null) {
            return a(str, "version-".concat(String.valueOf(i)), "lib");
        }
        return (String) invokeLI.objValue;
    }
}
