package com.baidu.turbonet.net;

import com.baidu.turbonet.net.BidirectionalStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public abstract class ResponseStreamCallbackForBidirectionalStream extends BidirectionalStream.Callback {

    /* renamed from: d  reason: collision with root package name */
    public static final Executor f22508d = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    public PipedOutputStreamAndroid25 f22509a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22510b;

    /* renamed from: c  reason: collision with root package name */
    public RequestBodyOutputStream f22511c;

    /* loaded from: classes5.dex */
    public final class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public BidirectionalStream f22512e;

        /* renamed from: f  reason: collision with root package name */
        public UrlResponseInfo f22513f;

        /* renamed from: g  reason: collision with root package name */
        public InputStream f22514g;

        public a(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, InputStream inputStream) {
            this.f22512e = bidirectionalStream;
            this.f22513f = urlResponseInfo;
            this.f22514g = inputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResponseStreamCallbackForBidirectionalStream.this.k(this.f22512e, this.f22513f, this.f22514g);
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void a(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
        try {
            this.f22511c.o();
        } catch (Exception unused) {
            d.b.j0.a.a.h("ChromiumNetwork", "Exception when closing associated stream", new Object[0]);
        }
        try {
            this.f22509a.close();
        } catch (Exception unused2) {
            d.b.j0.a.a.h("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
        }
        i(bidirectionalStream, urlResponseInfo);
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void b(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, TurbonetException turbonetException) {
        d.b.j0.a.a.h("ChromiumNetwork", "****** onFailed, url is: %s, error is: %s", urlResponseInfo.h(), turbonetException);
        try {
            this.f22511c.o();
        } catch (Exception unused) {
            d.b.j0.a.a.h("ChromiumNetwork", "Exception when closing associated stream", new Object[0]);
        }
        try {
            this.f22509a.close();
        } catch (Exception unused2) {
            d.b.j0.a.a.h("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
        }
        if (this.f22510b) {
            return;
        }
        j(bidirectionalStream, urlResponseInfo, turbonetException);
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void c(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z) throws Exception {
        byteBuffer.flip();
        d.b.j0.a.a.h("ChromiumNetwork", "****** onReadCompleted ******%s", byteBuffer);
        this.f22509a.write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        this.f22509a.flush();
        if (z) {
            return;
        }
        byteBuffer.clear();
        bidirectionalStream.a(byteBuffer);
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void d(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) throws Exception {
        d.b.j0.a.a.h("ChromiumNetwork", "****** onResponseHeaderReceived ******", new Object[0]);
        d.b.j0.a.a.h("ChromiumNetwork", "*** Headers Are *** %s", urlResponseInfo.a());
        this.f22509a = new PipedOutputStreamAndroid25();
        try {
            f22508d.execute(new a(bidirectionalStream, urlResponseInfo, new PipedInputStreamAndroid25(this.f22509a, 4096)));
            bidirectionalStream.a(ByteBuffer.allocateDirect(32768));
            this.f22510b = true;
        } catch (Exception e2) {
            d.b.j0.a.a.c("ChromiumNetwork", "Exception in onResponseStarted ", e2);
            throw e2;
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void f(BidirectionalStream bidirectionalStream) throws Exception {
        d.b.j0.a.a.h("ChromiumNetwork", "****** onStreamReady ******", new Object[0]);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f22511c.n());
        int c2 = this.f22511c.c(allocateDirect);
        allocateDirect.flip();
        bidirectionalStream.b(allocateDirect, c2 <= 0);
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void g(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
        d.b.j0.a.a.h("ChromiumNetwork", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.h(), Integer.valueOf(urlResponseInfo.c()), Long.valueOf(urlResponseInfo.g()));
        try {
            this.f22509a.close();
        } catch (Exception unused) {
            d.b.j0.a.a.c("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void h(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z) throws Exception {
        if (z) {
            return;
        }
        byteBuffer.clear();
        int c2 = this.f22511c.c(byteBuffer);
        byteBuffer.flip();
        bidirectionalStream.b(byteBuffer, c2 <= 0);
        d.b.j0.a.a.h("ChromiumNetwork", "****** onWriteCompleted ******, total writen bytes is %d", Integer.valueOf(c2));
    }

    public void i(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
    }

    public abstract void j(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

    public abstract void k(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, InputStream inputStream);
}
