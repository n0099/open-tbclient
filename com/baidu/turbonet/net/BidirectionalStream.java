package com.baidu.turbonet.net;

import com.baidu.turbonet.net.UrlResponseInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public abstract class BidirectionalStream {

    /* loaded from: classes10.dex */
    public static class Builder {

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes10.dex */
        public @interface StreamPriority {
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class Callback {
        public abstract void a(BidirectionalStream bidirectionalStream) throws Exception;

        public abstract void a(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) throws Exception;

        public abstract void a(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, TurbonetException turbonetException);

        public abstract void a(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z) throws Exception;

        public abstract void b(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo);

        public abstract void b(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z) throws Exception;

        public void a(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, UrlResponseInfo.HeaderBlock headerBlock) {
        }

        public void c(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
        }
    }
}
