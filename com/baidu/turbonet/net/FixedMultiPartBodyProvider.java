package com.baidu.turbonet.net;

import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class FixedMultiPartBodyProvider extends UploadDataProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f23140e;

    /* renamed from: f  reason: collision with root package name */
    public int f23141f;

    @Override // com.baidu.turbonet.net.UploadDataProvider
    public long n() {
        return this.f23140e.getBytes().length;
    }

    @Override // com.baidu.turbonet.net.UploadDataProvider
    public void o(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            if (byteBuffer.remaining() >= this.f23140e.length() - this.f23141f) {
                byteBuffer.put(this.f23140e.getBytes(), this.f23141f, this.f23140e.getBytes().length - this.f23141f);
            } else {
                byteBuffer.put(this.f23140e.getBytes(), this.f23141f, byteBuffer.remaining());
                this.f23141f += byteBuffer.remaining();
            }
            uploadDataSink.c(false);
            return;
        }
        throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
    }

    @Override // com.baidu.turbonet.net.UploadDataProvider
    public void p(UploadDataSink uploadDataSink) {
        this.f23141f = 0;
        uploadDataSink.a();
    }
}
