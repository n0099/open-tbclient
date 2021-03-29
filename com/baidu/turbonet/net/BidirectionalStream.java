package com.baidu.turbonet.net;

import com.baidu.turbonet.net.UrlResponseInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public abstract class BidirectionalStream {

    /* loaded from: classes5.dex */
    public static class Builder {

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes5.dex */
        public @interface StreamPriority {
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class Callback {
        public void a(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
        }

        public abstract void b(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, TurbonetException turbonetException);

        public abstract void c(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z) throws Exception;

        public abstract void d(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) throws Exception;

        public void e(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, UrlResponseInfo.HeaderBlock headerBlock) {
        }

        public abstract void f(BidirectionalStream bidirectionalStream) throws Exception;

        public abstract void g(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo);

        public abstract void h(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z) throws Exception;
    }

    public abstract void a(ByteBuffer byteBuffer);

    public abstract void b(ByteBuffer byteBuffer, boolean z);
}
