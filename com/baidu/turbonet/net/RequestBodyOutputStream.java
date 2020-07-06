package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class RequestBodyOutputStream extends OutputStream {
    private final PipedOutputStreamAndroid25 mBQ;
    private String mBoundary;

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.mBQ.write(i);
        this.mBQ.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.mBQ.write(bArr, i, i2);
        this.mBQ.flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!"".equals(this.mBoundary)) {
            String str = "\r\n--" + this.mBoundary + "--\r\n";
            write(str.getBytes(), 0, str.getBytes().length);
        }
        this.mBQ.close();
    }
}
