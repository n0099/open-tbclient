package com.baidu.webkit.internal.brotli;

import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.brotli.DecoderJNI;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class Decoder implements INoProGuard {
    public static final ByteBuffer EMPTY_BUFER = ByteBuffer.allocate(0);
    public ByteBuffer buffer;
    public boolean closed;
    public final DecoderJNI.Wrapper decoder;
    public boolean eager;
    public final ReadableByteChannel source;

    /* renamed from: com.baidu.webkit.internal.brotli.Decoder$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26661a;

        static {
            int[] iArr = new int[DecoderJNI.a.values().length];
            f26661a = iArr;
            try {
                iArr[DecoderJNI.a.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26661a[DecoderJNI.a.OK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26661a[DecoderJNI.a.NEEDS_MORE_INPUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26661a[DecoderJNI.a.NEEDS_MORE_OUTPUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public Decoder(ReadableByteChannel readableByteChannel, int i2) throws IOException {
        if (i2 <= 0) {
            throw new IllegalArgumentException("buffer size must be positive");
        }
        if (readableByteChannel == null) {
            throw new NullPointerException("source can not be null");
        }
        this.source = readableByteChannel;
        this.decoder = new DecoderJNI.Wrapper(i2);
    }

    public static byte[] decompress(byte[] bArr) throws IOException {
        DecoderJNI.Wrapper wrapper = new DecoderJNI.Wrapper(bArr.length);
        ArrayList arrayList = new ArrayList();
        try {
            wrapper.getInputBuffer().put(bArr);
            wrapper.push(bArr.length);
            int i2 = 0;
            while (wrapper.getStatus() != DecoderJNI.a.DONE) {
                int i3 = AnonymousClass1.f26661a[wrapper.getStatus().ordinal()];
                if (i3 == 2) {
                    wrapper.push(0);
                } else if (i3 != 4) {
                    throw new IOException("corrupted input");
                } else {
                    ByteBuffer pull = wrapper.pull();
                    int remaining = pull.remaining();
                    byte[] bArr2 = new byte[remaining];
                    pull.get(bArr2);
                    arrayList.add(bArr2);
                    i2 += remaining;
                }
            }
            wrapper.destroy();
            if (arrayList.size() == 1) {
                return (byte[]) arrayList.get(0);
            }
            byte[] bArr3 = new byte[i2];
            Iterator it = arrayList.iterator();
            int i4 = 0;
            while (it.hasNext()) {
                byte[] bArr4 = (byte[]) it.next();
                System.arraycopy(bArr4, 0, bArr3, i4, bArr4.length);
                i4 += bArr4.length;
            }
            return bArr3;
        } catch (Throwable th) {
            wrapper.destroy();
            throw th;
        }
    }

    private void fail(String str) throws IOException {
        try {
            close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        throw new IOException(str);
    }

    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.decoder.destroy();
        this.source.close();
    }

    public int consume(ByteBuffer byteBuffer) {
        ByteBuffer slice = this.buffer.slice();
        int min = Math.min(slice.remaining(), byteBuffer.remaining());
        slice.limit(min);
        byteBuffer.put(slice);
        discard(min);
        return min;
    }

    public int decode() throws IOException {
        while (true) {
            ByteBuffer byteBuffer = this.buffer;
            if (byteBuffer != null) {
                if (byteBuffer.hasRemaining()) {
                    return this.buffer.remaining();
                }
                this.buffer = null;
            }
            int i2 = AnonymousClass1.f26661a[this.decoder.getStatus().ordinal()];
            if (i2 == 1) {
                return -1;
            }
            if (i2 == 2) {
                this.decoder.push(0);
            } else if (i2 != 3) {
                if (i2 != 4) {
                    fail("corrupted input");
                } else {
                    this.buffer = this.decoder.pull();
                }
            } else if (this.eager && this.decoder.hasOutput()) {
                this.buffer = this.decoder.pull();
            } else {
                ByteBuffer inputBuffer = this.decoder.getInputBuffer();
                inputBuffer.clear();
                int read = this.source.read(inputBuffer);
                if (read == -1) {
                    fail("unexpected end of input");
                }
                if (read == 0) {
                    this.buffer = EMPTY_BUFER;
                    return 0;
                }
                this.decoder.push(read);
            }
        }
    }

    public void discard(int i2) {
        ByteBuffer byteBuffer = this.buffer;
        byteBuffer.position(byteBuffer.position() + i2);
        if (this.buffer.hasRemaining()) {
            return;
        }
        this.buffer = null;
    }

    public void enableEagerOutput() {
        this.eager = true;
    }
}
