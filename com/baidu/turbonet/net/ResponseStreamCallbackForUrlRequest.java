package com.baidu.turbonet.net;

import com.baidu.turbonet.net.UrlRequest;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public abstract class ResponseStreamCallbackForUrlRequest extends UrlRequest.Callback {

    /* renamed from: c  reason: collision with root package name */
    public static ExecutorService f22516c = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    public PipedOutputStreamAndroid25 f22517a;

    /* renamed from: b  reason: collision with root package name */
    public RequestBodyOutputStream f22518b;

    /* loaded from: classes5.dex */
    public final class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public UrlRequest f22519e;

        /* renamed from: f  reason: collision with root package name */
        public UrlResponseInfo f22520f;

        /* renamed from: g  reason: collision with root package name */
        public InputStream f22521g;

        public a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, InputStream inputStream) {
            this.f22519e = urlRequest;
            this.f22520f = urlResponseInfo;
            this.f22521g = inputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResponseStreamCallbackForUrlRequest.this.i(this.f22519e, this.f22520f, this.f22521g);
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest.Callback
    public final void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        RequestBodyOutputStream requestBodyOutputStream = this.f22518b;
        if (requestBodyOutputStream != null) {
            try {
                requestBodyOutputStream.o();
            } catch (Exception unused) {
                d.b.j0.a.a.h("ChromiumNetwork", "Exception when closing associated stream", new Object[0]);
            }
        }
        try {
            this.f22517a.close();
        } catch (Exception unused2) {
            d.b.j0.a.a.h("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
        }
        g(urlRequest, urlResponseInfo);
    }

    @Override // com.baidu.turbonet.net.UrlRequest.Callback
    public final void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
        d.b.j0.a.a.c("ChromiumNetwork", "****** onFailed, url is: %s, error is: %s", urlResponseInfo.h(), urlRequestException);
        RequestBodyOutputStream requestBodyOutputStream = this.f22518b;
        if (requestBodyOutputStream != null) {
            try {
                requestBodyOutputStream.o();
            } catch (Exception unused) {
                d.b.j0.a.a.h("ChromiumNetwork", "Exception when closing associated stream", new Object[0]);
            }
        }
        try {
            this.f22517a.close();
        } catch (Exception unused2) {
            d.b.j0.a.a.h("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
        }
        h(urlRequest, urlResponseInfo, urlRequestException);
    }

    @Override // com.baidu.turbonet.net.UrlRequest.Callback
    public final void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception {
        byteBuffer.flip();
        d.b.j0.a.a.h("ChromiumNetwork", "****** onReadCompleted ******%s", byteBuffer);
        this.f22517a.write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        this.f22517a.flush();
        byteBuffer.clear();
        urlRequest.read(byteBuffer);
    }

    @Override // com.baidu.turbonet.net.UrlRequest.Callback
    public final void e(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception {
        d.b.j0.a.a.h("ChromiumNetwork", "****** Response Started ******", new Object[0]);
        d.b.j0.a.a.h("ChromiumNetwork", "*** Headers Are *** %s", urlResponseInfo.a());
        this.f22517a = new PipedOutputStreamAndroid25();
        try {
            f22516c.execute(new a(urlRequest, urlResponseInfo, new PipedInputStreamAndroid25(this.f22517a, 4096)));
            urlRequest.read(ByteBuffer.allocateDirect(32768));
        } catch (Exception e2) {
            d.b.j0.a.a.c("ChromiumNetwork", "Exception in onResponseStarted ", e2);
            throw e2;
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest.Callback
    public final void f(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        d.b.j0.a.a.h("ChromiumNetwork", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.h(), Integer.valueOf(urlResponseInfo.c()), Long.valueOf(urlResponseInfo.g()));
        try {
            this.f22517a.close();
        } catch (Exception unused) {
            d.b.j0.a.a.c("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
        }
    }

    public void g(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
    }

    public abstract void h(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

    public abstract void i(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, InputStream inputStream);
}
