package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class mo4 {
    public static /* synthetic */ Interceptable $ic;
    public static final io4 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947979383, "Lcom/baidu/tieba/mo4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947979383, "Lcom/baidu/tieba/mo4;");
                return;
            }
        }
        a = io4.d();
    }

    public static String a(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, strArr)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (strArr != null) {
                try {
                    if (strArr.length > 0 && strArr.length % 2 == 0) {
                        for (int i = 0; i < strArr.length; i += 2) {
                            String str = strArr[i];
                            String str2 = strArr[i + 1];
                            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                jSONObject.put(str, str2);
                            }
                        }
                    }
                } catch (Exception e) {
                    ri4.b().G("PMSFileUtil", "#createErrorJson put异常", e);
                }
            }
            return "errmsg:" + jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static hk4 b(String str, long j, long j2, @Nullable List<hk4> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), list})) == null) {
            List<hk4> s = dj4.i().s(str, j, j2);
            if (s != null) {
                while (!s.isEmpty()) {
                    hk4 remove = s.remove(0);
                    if (ri4.b().r(remove)) {
                        return remove;
                    }
                    if (list != null) {
                        list.add(remove);
                    }
                }
                return null;
            }
            return null;
        }
        return (hk4) invokeCommon.objValue;
    }

    public static File c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                a.i("PMSFileUtil", "#generateFilePath parentDir为空 fileName=" + str2);
                return null;
            }
            File file = new File(str);
            if (!file.exists() && !file.mkdirs()) {
                ri4.b().y("PMSFileUtil", "cannot mkdir in : " + file);
                return null;
            }
            String e = e(str, str2);
            String str3 = e;
            for (int i = 0; i < 1000; i++) {
                File file2 = new File(str3);
                try {
                    if (!file2.exists() && file2.createNewFile()) {
                        return file2;
                    }
                } catch (IOException e2) {
                    a.g("PMSFileUtil", "#generateFilePath 失败", e2);
                }
                str3 = e + "_" + i;
            }
            a.i("PMSFileUtil", "#generateFilePath 创建临时路径失败");
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public static File d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            File dir = context.getDir("pms_dir", 0);
            if (!dir.exists()) {
                dir.mkdir();
            }
            return dir;
        }
        return (File) invokeL.objValue;
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            return f(str, str2, File.separator);
        }
        return (String) invokeLL.objValue;
    }

    public static String f(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            if (str.endsWith(str3)) {
                if (str2.startsWith(str3)) {
                    return str.concat(str2.substring(str3.length()));
                }
                return str.concat(str2);
            } else if (str2.startsWith(str3)) {
                return str.concat(str2);
            } else {
                return str.concat(str3).concat(str2);
            }
        }
        return (String) invokeLLL.objValue;
    }
}
