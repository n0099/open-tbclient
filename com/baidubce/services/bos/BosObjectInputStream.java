package com.baidubce.services.bos;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import okhttp3.Response;
/* loaded from: classes24.dex */
public class BosObjectInputStream extends FilterInputStream {
    private Response httpResponse;

    public BosObjectInputStream(InputStream inputStream, Response response) {
        super(inputStream);
        this.httpResponse = response;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            super.close();
        } catch (SocketException e) {
        }
    }
}
