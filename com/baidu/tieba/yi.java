package com.baidu.tieba;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
/* loaded from: classes8.dex */
public class yi {
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

    public static void b(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, sQLiteDatabase) == null) && sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void c(SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, sQLiteStatement) == null) && sQLiteStatement != null) {
            try {
                sQLiteStatement.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void d(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public static void e(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream) == null) && inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void f(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, outputStream) == null) && outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void g(Reader reader) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, reader) == null) && reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void h(Writer writer) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, writer) == null) && writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
