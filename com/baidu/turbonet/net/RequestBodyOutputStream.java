package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class RequestBodyOutputStream extends OutputStream {
    private String mBoundary;
    private final PipedOutputStreamAndroid25 meM;

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.meM.write(i);
        this.meM.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.meM.write(bArr, i, i2);
        this.meM.flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!"".equals(this.mBoundary)) {
            String str = "\r\n--" + this.mBoundary + "--\r\n";
            write(str.getBytes(), 0, str.getBytes().length);
        }
        this.meM.close();
    }
}
