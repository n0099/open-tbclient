package com.baidu.turbonet.net;

import com.android.internal.http.multipart.Part;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class RequestBodyOutputStream extends OutputStream {

    /* renamed from: e  reason: collision with root package name */
    public final PipedOutputStreamAndroid25 f22568e;

    /* renamed from: f  reason: collision with root package name */
    public final PipedInputStreamAndroid25 f22569f;

    /* renamed from: g  reason: collision with root package name */
    public String f22570g;

    /* renamed from: h  reason: collision with root package name */
    public int f22571h;

    /* renamed from: i  reason: collision with root package name */
    public int f22572i;
    public byte[] j;

    public int c(ByteBuffer byteBuffer) throws IOException {
        int read;
        int min = Math.min(byteBuffer.remaining(), this.f22571h);
        int i2 = 0;
        do {
            read = this.f22569f.read(this.j, i2, min - i2);
            if (read > 0) {
                i2 += read;
            }
            if (i2 >= this.f22572i) {
                break;
            }
        } while (read >= 0);
        if (i2 > 0) {
            byteBuffer.put(this.j, 0, i2);
        }
        return i2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!"".equals(this.f22570g)) {
            String str = "\r\n--" + this.f22570g + "--" + Part.CRLF;
            write(str.getBytes(), 0, str.getBytes().length);
        }
        this.f22568e.close();
    }

    public int n() {
        return this.f22571h;
    }

    public void o() throws IOException {
        this.f22569f.close();
        this.f22568e.close();
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        this.f22568e.write(i2);
        this.f22568e.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.f22568e.write(bArr, i2, i3);
        this.f22568e.flush();
    }
}
