package com.baidu.titan.sdk.internal.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.zip.ZipFile;
/* loaded from: classes4.dex */
public class Closes {
    public static boolean closeQuiet(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean closeQuiet(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean closeQuiet(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean closeQuiet(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean closeQuiet(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
