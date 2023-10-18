package com.baidu.tieba;

import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class k65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            synchronized (k65.class) {
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

    public static j65 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            j65 j65Var = new j65();
            if (str == null) {
                j65Var.f(6);
                j65Var.g(j65.a(j65Var.b()));
                return j65Var;
            }
            if (!FileHelper.CheckTempDir(FileHelper.getCacheDir() + "voice")) {
                j65Var.f(7);
                j65Var.g(j65.a(j65Var.b()));
                return j65Var;
            }
            String b = gd.b(FileHelper.GetStreamFromTmpFile(str));
            if (b == null) {
                j65Var.f(5);
                j65Var.g(j65.a(j65Var.b()));
            } else {
                String filePath = FileHelper.getFilePath(b, 1, true);
                if (FileHelper.renameTo(str, filePath)) {
                    j65Var.i(filePath);
                    j65Var.h(b);
                } else {
                    j65Var.f(1);
                    j65Var.g(j65.a(j65Var.b()));
                }
            }
            return j65Var;
        }
        return (j65) invokeL.objValue;
    }
}
