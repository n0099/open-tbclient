package com.baidu.tieba;

import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes7.dex */
public class ob5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            synchronized (ob5.class) {
                File file = new File(FileHelper.getCacheDir() + "voice");
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles == null) {
                        return;
                    }
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            return FileHelper.renameTo(str, FileHelper.getFilePath(str2, 1, true));
        }
        return invokeLL.booleanValue;
    }

    public static nb5 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            nb5 nb5Var = new nb5();
            if (str == null) {
                nb5Var.f(6);
                nb5Var.g(nb5.a(nb5Var.b()));
                return nb5Var;
            }
            if (!FileHelper.CheckTempDir(FileHelper.getCacheDir() + "voice")) {
                nb5Var.f(7);
                nb5Var.g(nb5.a(nb5Var.b()));
                return nb5Var;
            }
            String b = ji.b(FileHelper.GetStreamFromTmpFile(str));
            if (b == null) {
                nb5Var.f(5);
                nb5Var.g(nb5.a(nb5Var.b()));
            } else {
                String filePath = FileHelper.getFilePath(b, 1, true);
                if (FileHelper.renameTo(str, filePath)) {
                    nb5Var.i(filePath);
                    nb5Var.h(b);
                } else {
                    nb5Var.f(1);
                    nb5Var.g(nb5.a(nb5Var.b()));
                }
            }
            return nb5Var;
        }
        return (nb5) invokeL.objValue;
    }
}
