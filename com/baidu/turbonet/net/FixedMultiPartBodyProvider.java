package com.baidu.turbonet.net;

import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class FixedMultiPartBodyProvider extends UploadDataProvider {

    /* renamed from: e  reason: collision with root package name */
    public String f22499e;

    /* renamed from: f  reason: collision with root package name */
    public int f22500f;

    @Override // com.baidu.turbonet.net.UploadDataProvider
    public long n() {
        return this.f22499e.getBytes().length;
    }

    @Override // com.baidu.turbonet.net.UploadDataProvider
    public void o(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            if (byteBuffer.remaining() >= this.f22499e.length() - this.f22500f) {
                byteBuffer.put(this.f22499e.getBytes(), this.f22500f, this.f22499e.getBytes().length - this.f22500f);
            } else {
                byteBuffer.put(this.f22499e.getBytes(), this.f22500f, byteBuffer.remaining());
                this.f22500f += byteBuffer.remaining();
            }
            uploadDataSink.c(false);
            return;
        }
        throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
    }

    @Override // com.baidu.turbonet.net.UploadDataProvider
    public void p(UploadDataSink uploadDataSink) {
        this.f22500f = 0;
        uploadDataSink.a();
    }
}
