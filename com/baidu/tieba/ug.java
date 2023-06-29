package com.baidu.tieba;

import android.database.Cursor;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
/* loaded from: classes8.dex */
public class ug {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, cursor) == null) && cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void b(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public static void c(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, inputStream) == null) && inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void d(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, outputStream) == null) && outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void e(Reader reader) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, reader) == null) && reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void f(HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, httpURLConnection) == null) && httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
