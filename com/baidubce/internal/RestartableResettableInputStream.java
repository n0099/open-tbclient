package com.baidubce.internal;

import com.baidubce.BceClientException;
import com.baidubce.util.CheckUtils;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class RestartableResettableInputStream extends RestartableInputStream {
    public InputStream input;

    public RestartableResettableInputStream(InputStream inputStream) {
        CheckUtils.isNotNull(inputStream, "input should not be null.");
        CheckUtils.checkArgument(inputStream.markSupported(), "input does not support mark.");
        this.input = inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.input.close();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        return this.input.read(bArr, i2, i3);
    }

    @Override // com.baidubce.internal.RestartableInputStream
    public void restart() {
        try {
            this.input.reset();
        } catch (IOException e2) {
            throw new BceClientException("Fail to reset the underlying input stream.", e2);
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.input.read();
    }
}
