package com.baidu.turbonet.net;

import java.nio.ByteBuffer;
/* loaded from: classes17.dex */
public class FixedMultiPartBodyProvider extends UploadDataProvider {
    private String mContent;
    private int mOffset;

    @Override // com.baidu.turbonet.net.UploadDataProvider
    public long getLength() {
        return this.mContent.getBytes().length;
    }

    @Override // com.baidu.turbonet.net.UploadDataProvider
    public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
        }
        if (byteBuffer.remaining() >= this.mContent.length() - this.mOffset) {
            byteBuffer.put(this.mContent.getBytes(), this.mOffset, this.mContent.getBytes().length - this.mOffset);
        } else {
            byteBuffer.put(this.mContent.getBytes(), this.mOffset, byteBuffer.remaining());
            this.mOffset += byteBuffer.remaining();
        }
        uploadDataSink.zr(false);
    }

    @Override // com.baidu.turbonet.net.UploadDataProvider
    public void a(UploadDataSink uploadDataSink) {
        this.mOffset = 0;
        uploadDataSink.ebx();
    }
}
