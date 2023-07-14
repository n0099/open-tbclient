package com.baidu.tieba;

import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes7.dex */
public class sc5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            synchronized (sc5.class) {
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

    public static rc5 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            rc5 rc5Var = new rc5();
            if (str == null) {
                rc5Var.f(6);
                rc5Var.g(rc5.a(rc5Var.b()));
                return rc5Var;
            }
            if (!FileHelper.CheckTempDir(FileHelper.getCacheDir() + "voice")) {
                rc5Var.f(7);
                rc5Var.g(rc5.a(rc5Var.b()));
                return rc5Var;
            }
            String b = fj.b(FileHelper.GetStreamFromTmpFile(str));
            if (b == null) {
                rc5Var.f(5);
                rc5Var.g(rc5.a(rc5Var.b()));
            } else {
                String filePath = FileHelper.getFilePath(b, 1, true);
                if (FileHelper.renameTo(str, filePath)) {
                    rc5Var.i(filePath);
                    rc5Var.h(b);
                } else {
                    rc5Var.f(1);
                    rc5Var.g(rc5.a(rc5Var.b()));
                }
            }
            return rc5Var;
        }
        return (rc5) invokeL.objValue;
    }
}
