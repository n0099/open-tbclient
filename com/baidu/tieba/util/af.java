package com.baidu.tieba.util;

import com.baidu.zeus.NotificationProxy;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public class af {
    public static void a(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream;
        try {
            gZIPOutputStream = new GZIPOutputStream(outputStream);
        } catch (Throwable th) {
            th = th;
            gZIPOutputStream = null;
        }
        try {
            byte[] bArr = new byte[NotificationProxy.MAX_URL_LENGTH];
            while (true) {
                int read = inputStream.read(bArr, 0, NotificationProxy.MAX_URL_LENGTH);
                if (read != -1) {
                    gZIPOutputStream.write(bArr, 0, read);
                } else {
                    gZIPOutputStream.flush();
                    o.a((OutputStream) gZIPOutputStream);
                    return;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            o.a((OutputStream) gZIPOutputStream);
            throw th;
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
            byte[] bArr = new byte[NotificationProxy.MAX_URL_LENGTH];
            while (true) {
                int read = gZIPInputStream.read(bArr, 0, NotificationProxy.MAX_URL_LENGTH);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    o.a((InputStream) gZIPInputStream);
                    return;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            o.a((InputStream) gZIPInputStream);
            throw th;
        }
    }
}
