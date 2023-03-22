package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.pq2;
import com.baidu.tieba.sq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class mb2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947966828, "Lcom/baidu/tieba/mb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947966828, "Lcom/baidu/tieba/mb2;");
                return;
            }
        }
        a = do1.a;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return e(str, "swan_sub_package_zip");
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return e(str, "swan_sub_package_zip");
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(List<tg4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return false;
            }
            return list.get(0).r;
        }
        return invokeL.booleanValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            return a(pq2.e.i(str, str2).getPath());
        }
        return (String) invokeLL.objValue;
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            File a2 = br2.g().a(str, str2);
            if (a2 != null) {
                return c(a2.getPath());
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str, str2);
                if (file.exists()) {
                    return file.getPath();
                }
                if (file.mkdirs()) {
                    return file.getPath();
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean g(tg4 tg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, tg4Var)) == null) {
            if (tg4Var != null && !TextUtils.isEmpty(tg4Var.o)) {
                return h(new File(tg4Var.a), new File(pq2.e.i(tg4Var.o, String.valueOf(tg4Var.i)).getPath(), tg4Var.p));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean h(File file, File file2) {
        InterceptResult invokeLL;
        boolean U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, file, file2)) == null) {
            if (file != null && file2 != null) {
                if (!file.exists()) {
                    if (a) {
                        Log.e("SubPkgDownloadUtil", "解压分包时，ZIP包不存在 zipFile=" + file);
                    }
                    return false;
                } else if (!file2.exists() && !file2.mkdirs()) {
                    if (a) {
                        Log.e("SubPkgDownloadUtil", "创建分包解压文件夹失败 unzipFolder=" + file2);
                    }
                    return false;
                } else {
                    sq2.c j = sq2.j(file);
                    int i = j.b;
                    if (i != -1) {
                        U = sq2.d(j.a, file2, i).a;
                    } else {
                        U = xn4.U(file.getAbsolutePath(), file2.getAbsolutePath());
                    }
                    if (U) {
                        if (a) {
                            Log.i("SubPkgDownloadUtil", "分包解压成功");
                            return true;
                        }
                        return true;
                    } else if (a) {
                        Log.e("SubPkgDownloadUtil", "分包解压文件失败, file:" + file.getAbsolutePath() + " folder:" + file2.getAbsolutePath());
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
