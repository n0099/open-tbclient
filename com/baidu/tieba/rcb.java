package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes7.dex */
public class rcb {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948118232, "Lcom/baidu/tieba/rcb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948118232, "Lcom/baidu/tieba/rcb;");
                return;
            }
        }
        a = pbb.m();
    }

    public static boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            if (a) {
                Log.d("UBCFileUtils", "delete file:" + file);
            }
            if (file == null) {
                return false;
            }
            boolean z = true;
            if (file.exists()) {
                if (file.isFile()) {
                    return true & file.delete();
                }
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            z &= a(file2);
                        }
                    }
                    return z & file.delete();
                } else if (!a) {
                    return true;
                } else {
                    Log.d("UBCFileUtils", "a special file:" + file);
                    return true;
                }
            } else if (!a) {
                return true;
            } else {
                Log.d("UBCFileUtils", "not found the file to delete:" + file);
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
