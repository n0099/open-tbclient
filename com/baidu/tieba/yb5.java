package com.baidu.tieba;

import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes8.dex */
public class yb5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            synchronized (yb5.class) {
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

    public static xb5 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            xb5 xb5Var = new xb5();
            if (str == null) {
                xb5Var.f(6);
                xb5Var.g(xb5.a(xb5Var.b()));
                return xb5Var;
            }
            if (!FileHelper.CheckTempDir(FileHelper.getCacheDir() + "voice")) {
                xb5Var.f(7);
                xb5Var.g(xb5.a(xb5Var.b()));
                return xb5Var;
            }
            String b = ki.b(FileHelper.GetStreamFromTmpFile(str));
            if (b == null) {
                xb5Var.f(5);
                xb5Var.g(xb5.a(xb5Var.b()));
            } else {
                String filePath = FileHelper.getFilePath(b, 1, true);
                if (FileHelper.renameTo(str, filePath)) {
                    xb5Var.i(filePath);
                    xb5Var.h(b);
                } else {
                    xb5Var.f(1);
                    xb5Var.g(xb5.a(xb5Var.b()));
                }
            }
            return xb5Var;
        }
        return (xb5) invokeL.objValue;
    }
}
