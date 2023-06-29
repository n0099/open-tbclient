package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes7.dex */
public class pib {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.e("IOUtil", "closeSecure IOException");
            }
        }
    }

    public static void b(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, inputStream) == null) {
            a(inputStream);
        }
    }

    public static void c(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, outputStream) == null) {
            a(outputStream);
        }
    }

    public static void d(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, file) == null) && file != null && file.exists() && !file.delete()) {
            Log.e("IOUtil", "deleteSecure exception");
        }
    }
}
