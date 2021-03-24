package com.baidubce.internal;

import com.baidubce.BceClientException;
import com.baidubce.util.CheckUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes5.dex */
public class RestartableFileInputStream extends RestartableInputStream {
    public File file;
    public FileInputStream input;

    public RestartableFileInputStream(File file) throws FileNotFoundException {
        CheckUtils.isNotNull(file, "file should not be null.");
        this.file = file;
        this.input = new FileInputStream(file);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.input.close();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.input.read(bArr, i, i2);
    }

    @Override // com.baidubce.internal.RestartableInputStream
    public void restart() {
        try {
            this.input.close();
            this.input = new FileInputStream(this.file);
        } catch (IOException e2) {
            throw new BceClientException("Fail to restart.", e2);
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.input.read();
    }
}
