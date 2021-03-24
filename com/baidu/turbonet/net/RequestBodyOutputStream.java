package com.baidu.turbonet.net;

import com.android.internal.http.multipart.Part;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class RequestBodyOutputStream extends OutputStream {

    /* renamed from: e  reason: collision with root package name */
    public final PipedOutputStreamAndroid25 f22818e;

    /* renamed from: f  reason: collision with root package name */
    public final PipedInputStreamAndroid25 f22819f;

    /* renamed from: g  reason: collision with root package name */
    public String f22820g;

    /* renamed from: h  reason: collision with root package name */
    public int f22821h;
    public int i;
    public byte[] j;

    public int c(ByteBuffer byteBuffer) throws IOException {
        int read;
        int min = Math.min(byteBuffer.remaining(), this.f22821h);
        int i = 0;
        do {
            read = this.f22819f.read(this.j, i, min - i);
            if (read > 0) {
                i += read;
            }
            if (i >= this.i) {
                break;
            }
        } while (read >= 0);
        if (i > 0) {
            byteBuffer.put(this.j, 0, i);
        }
        return i;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!"".equals(this.f22820g)) {
            String str = "\r\n--" + this.f22820g + "--" + Part.CRLF;
            write(str.getBytes(), 0, str.getBytes().length);
        }
        this.f22818e.close();
    }

    public int n() {
        return this.f22821h;
    }

    public void o() throws IOException {
        this.f22819f.close();
        this.f22818e.close();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.f22818e.write(i);
        this.f22818e.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f22818e.write(bArr, i, i2);
        this.f22818e.flush();
    }
}
