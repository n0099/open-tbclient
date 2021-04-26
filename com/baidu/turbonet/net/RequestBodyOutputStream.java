package com.baidu.turbonet.net;

import com.android.internal.http.multipart.Part;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class RequestBodyOutputStream extends OutputStream {

    /* renamed from: e  reason: collision with root package name */
    public final PipedOutputStreamAndroid25 f23209e;

    /* renamed from: f  reason: collision with root package name */
    public final PipedInputStreamAndroid25 f23210f;

    /* renamed from: g  reason: collision with root package name */
    public String f23211g;

    /* renamed from: h  reason: collision with root package name */
    public int f23212h;

    /* renamed from: i  reason: collision with root package name */
    public int f23213i;
    public byte[] j;

    public int c(ByteBuffer byteBuffer) throws IOException {
        int read;
        int min = Math.min(byteBuffer.remaining(), this.f23212h);
        int i2 = 0;
        do {
            read = this.f23210f.read(this.j, i2, min - i2);
            if (read > 0) {
                i2 += read;
            }
            if (i2 >= this.f23213i) {
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
        if (!"".equals(this.f23211g)) {
            String str = "\r\n--" + this.f23211g + "--" + Part.CRLF;
            write(str.getBytes(), 0, str.getBytes().length);
        }
        this.f23209e.close();
    }

    public int n() {
        return this.f23212h;
    }

    public void o() throws IOException {
        this.f23210f.close();
        this.f23209e.close();
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        this.f23209e.write(i2);
        this.f23209e.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.f23209e.write(bArr, i2, i3);
        this.f23209e.flush();
    }
}
