package com.baidu.webkit.internal.brotli;

import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.brotli.DecoderJNI;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes19.dex */
public class Decoder implements INoProGuard {
    private static final ByteBuffer EMPTY_BUFER = ByteBuffer.allocate(0);
    ByteBuffer buffer;
    boolean closed;
    private final DecoderJNI.Wrapper decoder;
    boolean eager;
    private final ReadableByteChannel source;

    public Decoder(ReadableByteChannel readableByteChannel, int i) throws IOException {
        if (i <= 0) {
            throw new IllegalArgumentException("buffer size must be positive");
        }
        if (readableByteChannel == null) {
            throw new NullPointerException("source can not be null");
        }
        this.source = readableByteChannel;
        this.decoder = new DecoderJNI.Wrapper(i);
    }

    public static byte[] decompress(byte[] bArr) throws IOException {
        DecoderJNI.Wrapper wrapper = new DecoderJNI.Wrapper(bArr.length);
        ArrayList arrayList = new ArrayList();
        try {
            wrapper.getInputBuffer().put(bArr);
            wrapper.push(bArr.length);
            int i = 0;
            while (wrapper.getStatus() != DecoderJNI.a.DONE) {
                switch (wrapper.getStatus()) {
                    case OK:
                        wrapper.push(0);
                        break;
                    case NEEDS_MORE_INPUT:
                    default:
                        throw new IOException("corrupted input");
                    case NEEDS_MORE_OUTPUT:
                        ByteBuffer pull = wrapper.pull();
                        byte[] bArr2 = new byte[pull.remaining()];
                        pull.get(bArr2);
                        arrayList.add(bArr2);
                        i += bArr2.length;
                        break;
                }
            }
            wrapper.destroy();
            if (arrayList.size() == 1) {
                return (byte[]) arrayList.get(0);
            }
            byte[] bArr3 = new byte[i];
            Iterator it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                byte[] bArr4 = (byte[]) it.next();
                System.arraycopy(bArr4, 0, bArr3, i2, bArr4.length);
                i2 = bArr4.length + i2;
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IOException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.decoder.destroy();
        this.source.close();
    }

    int consume(ByteBuffer byteBuffer) {
        ByteBuffer slice = this.buffer.slice();
        int min = Math.min(slice.remaining(), byteBuffer.remaining());
        slice.limit(min);
        byteBuffer.put(slice);
        discard(min);
        return min;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int decode() throws IOException {
        while (true) {
            if (this.buffer != null) {
                if (this.buffer.hasRemaining()) {
                    return this.buffer.remaining();
                }
                this.buffer = null;
            }
            switch (this.decoder.getStatus()) {
                case DONE:
                    return -1;
                case OK:
                    this.decoder.push(0);
                    break;
                case NEEDS_MORE_INPUT:
                    if (!this.eager || !this.decoder.hasOutput()) {
                        ByteBuffer inputBuffer = this.decoder.getInputBuffer();
                        inputBuffer.clear();
                        int read = this.source.read(inputBuffer);
                        if (read == -1) {
                            fail("unexpected end of input");
                        }
                        if (read != 0) {
                            this.decoder.push(read);
                            break;
                        } else {
                            this.buffer = EMPTY_BUFER;
                            return 0;
                        }
                    } else {
                        this.buffer = this.decoder.pull();
                        break;
                    }
                case NEEDS_MORE_OUTPUT:
                    this.buffer = this.decoder.pull();
                    break;
                default:
                    fail("corrupted input");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void discard(int i) {
        this.buffer.position(this.buffer.position() + i);
        if (this.buffer.hasRemaining()) {
            return;
        }
        this.buffer = null;
    }

    public void enableEagerOutput() {
        this.eager = true;
    }
}
