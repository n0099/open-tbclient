package com.baidu.tieba.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public final class am {
    public static void a(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream;
        try {
            gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read != -1) {
                        gZIPOutputStream.write(bArr, 0, read);
                    } else {
                        gZIPOutputStream.flush();
                        r.a((OutputStream) gZIPOutputStream);
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                r.a((OutputStream) gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream = null;
        }
    }

    public static void b(InputStream inputStream, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream;
        try {
            gZIPInputStream = new GZIPInputStream(inputStream);
        } catch (Throwable th) {
            th = th;
            gZIPInputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    r.a((InputStream) gZIPInputStream);
                    return;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            r.a((InputStream) gZIPInputStream);
            throw th;
        }
    }
}
