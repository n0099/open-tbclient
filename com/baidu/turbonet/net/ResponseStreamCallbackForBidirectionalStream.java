package com.baidu.turbonet.net;

import com.baidu.turbonet.net.BidirectionalStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public abstract class ResponseStreamCallbackForBidirectionalStream extends BidirectionalStream.Callback {

    /* renamed from: d  reason: collision with root package name */
    public static final Executor f23214d = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    public PipedOutputStreamAndroid25 f23215a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23216b;

    /* renamed from: c  reason: collision with root package name */
    public RequestBodyOutputStream f23217c;

    /* loaded from: classes5.dex */
    public final class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public BidirectionalStream f23218e;

        /* renamed from: f  reason: collision with root package name */
        public UrlResponseInfo f23219f;

        /* renamed from: g  reason: collision with root package name */
        public InputStream f23220g;

        public a(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, InputStream inputStream) {
            this.f23218e = bidirectionalStream;
            this.f23219f = urlResponseInfo;
            this.f23220g = inputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResponseStreamCallbackForBidirectionalStream.this.k(this.f23218e, this.f23219f, this.f23220g);
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void a(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
        try {
            this.f23217c.o();
        } catch (Exception unused) {
            d.a.k0.a.a.h("ChromiumNetwork", "Exception when closing associated stream", new Object[0]);
        }
        try {
            this.f23215a.close();
        } catch (Exception unused2) {
            d.a.k0.a.a.h("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
        }
        i(bidirectionalStream, urlResponseInfo);
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void b(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, TurbonetException turbonetException) {
        d.a.k0.a.a.h("ChromiumNetwork", "****** onFailed, url is: %s, error is: %s", urlResponseInfo.h(), turbonetException);
        try {
            this.f23217c.o();
        } catch (Exception unused) {
            d.a.k0.a.a.h("ChromiumNetwork", "Exception when closing associated stream", new Object[0]);
        }
        try {
            this.f23215a.close();
        } catch (Exception unused2) {
            d.a.k0.a.a.h("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
        }
        if (this.f23216b) {
            return;
        }
        j(bidirectionalStream, urlResponseInfo, turbonetException);
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void c(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z) throws Exception {
        byteBuffer.flip();
        d.a.k0.a.a.h("ChromiumNetwork", "****** onReadCompleted ******%s", byteBuffer);
        this.f23215a.write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        this.f23215a.flush();
        if (z) {
            return;
        }
        byteBuffer.clear();
        bidirectionalStream.a(byteBuffer);
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void d(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) throws Exception {
        d.a.k0.a.a.h("ChromiumNetwork", "****** onResponseHeaderReceived ******", new Object[0]);
        d.a.k0.a.a.h("ChromiumNetwork", "*** Headers Are *** %s", urlResponseInfo.a());
        this.f23215a = new PipedOutputStreamAndroid25();
        try {
            f23214d.execute(new a(bidirectionalStream, urlResponseInfo, new PipedInputStreamAndroid25(this.f23215a, 4096)));
            bidirectionalStream.a(ByteBuffer.allocateDirect(32768));
            this.f23216b = true;
        } catch (Exception e2) {
            d.a.k0.a.a.c("ChromiumNetwork", "Exception in onResponseStarted ", e2);
            throw e2;
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void f(BidirectionalStream bidirectionalStream) throws Exception {
        d.a.k0.a.a.h("ChromiumNetwork", "****** onStreamReady ******", new Object[0]);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f23217c.n());
        int c2 = this.f23217c.c(allocateDirect);
        allocateDirect.flip();
        bidirectionalStream.b(allocateDirect, c2 <= 0);
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void g(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
        d.a.k0.a.a.h("ChromiumNetwork", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.h(), Integer.valueOf(urlResponseInfo.c()), Long.valueOf(urlResponseInfo.g()));
        try {
            this.f23215a.close();
        } catch (Exception unused) {
            d.a.k0.a.a.c("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void h(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z) throws Exception {
        if (z) {
            return;
        }
        byteBuffer.clear();
        int c2 = this.f23217c.c(byteBuffer);
        byteBuffer.flip();
        bidirectionalStream.b(byteBuffer, c2 <= 0);
        d.a.k0.a.a.h("ChromiumNetwork", "****** onWriteCompleted ******, total writen bytes is %d", Integer.valueOf(c2));
    }

    public void i(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
    }

    public abstract void j(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

    public abstract void k(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, InputStream inputStream);
}
