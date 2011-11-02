package com.baidu.tieba.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public class GzipHelper {
    static final int BUFFERSIZE = 1024;

    public static void decompress(InputStream is, OutputStream os) throws Exception {
        GZIPInputStream gin = new GZIPInputStream(is);
        byte[] data = new byte[BUFFERSIZE];
        while (true) {
            int count = gin.read(data, 0, BUFFERSIZE);
            if (count != -1) {
                os.write(data, 0, count);
            } else {
                gin.close();
                return;
            }
        }
    }

    public static void compress(InputStream is, OutputStream os) throws Exception {
        GZIPOutputStream gos = new GZIPOutputStream(os);
        byte[] data = new byte[BUFFERSIZE];
        while (true) {
            int count = is.read(data, 0, BUFFERSIZE);
            if (count != -1) {
                gos.write(data, 0, count);
            } else {
                gos.flush();
                gos.finish();
                gos.close();
                return;
            }
        }
    }
}
