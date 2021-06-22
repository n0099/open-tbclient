package com.baidubce.http;

import com.baidubce.callback.BceProgressCallback;
import com.baidubce.model.AbstractBceRequest;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes6.dex */
public class BceServiceResponseBody<T extends AbstractBceRequest> extends ResponseBody {
    public BceProgressCallback<T> bceProgressCallback;
    public BufferedSource bceRespBufferedSource;
    public final ResponseBody bceResponseBody;
    public T request;

    public BceServiceResponseBody(ResponseBody responseBody, T t, BceProgressCallback<T> bceProgressCallback) {
        this.bceResponseBody = responseBody;
        this.request = t;
        this.bceProgressCallback = bceProgressCallback;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.bceResponseBody.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.bceResponseBody.contentType();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.bceRespBufferedSource == null) {
            this.bceRespBufferedSource = Okio.buffer(source(this.bceResponseBody.source()));
        }
        return this.bceRespBufferedSource;
    }

    private Source source(BufferedSource bufferedSource) {
        return new ForwardingSource(bufferedSource) { // from class: com.baidubce.http.BceServiceResponseBody.1
            public long totalBytesRead = 0;

            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidubce.callback.BceProgressCallback */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.totalBytesRead += read != -1 ? read : 0L;
                if (BceServiceResponseBody.this.bceProgressCallback != null && this.totalBytesRead > 0) {
                    BceServiceResponseBody.this.bceProgressCallback.onProgress(BceServiceResponseBody.this.request, this.totalBytesRead, BceServiceResponseBody.this.bceResponseBody.contentLength());
                }
                return read;
            }
        };
    }
}
