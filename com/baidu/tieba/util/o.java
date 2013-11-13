package com.baidu.tieba.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class o {
    public static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                bg.b("CloseUtil", "error on close the inputstream.", e.getMessage());
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                bg.b("CloseUtil", "error on close the Closeable.", th.getMessage());
            }
        }
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                bg.b("CloseUtil", "error on close the outputstream.", e.getMessage());
            }
        }
    }

    public static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
                bg.b("CloseUtil", "error on close android.database.Cursor.", e.getMessage());
            }
        }
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception e) {
                bg.b("CloseUtil", "error on close android.database.SQLiteDatabase.", e.getMessage());
            }
        }
    }
}
