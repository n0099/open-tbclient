package com.baidu.tieba;

import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes5.dex */
public class mz4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            synchronized (mz4.class) {
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? FileHelper.renameTo(str, FileHelper.getFilePath(str2, 1, true)) : invokeLL.booleanValue;
    }

    public static lz4 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            lz4 lz4Var = new lz4();
            if (str == null) {
                lz4Var.c = 6;
                lz4Var.d = lz4.a(6);
                return lz4Var;
            }
            if (!FileHelper.CheckTempDir(FileHelper.getCacheDir() + "voice")) {
                lz4Var.c = 7;
                lz4Var.d = lz4.a(7);
                return lz4Var;
            }
            String b = lj.b(FileHelper.GetStreamFromTmpFile(str));
            if (b == null) {
                lz4Var.c = 5;
                lz4Var.d = lz4.a(5);
            } else {
                String filePath = FileHelper.getFilePath(b, 1, true);
                if (FileHelper.renameTo(str, filePath)) {
                    lz4Var.b = filePath;
                    lz4Var.a = b;
                } else {
                    lz4Var.c = 1;
                    lz4Var.d = lz4.a(1);
                }
            }
            return lz4Var;
        }
        return (lz4) invokeL.objValue;
    }
}
