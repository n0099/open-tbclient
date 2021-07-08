package com.baidu.turbonet.net;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.BidirectionalStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public abstract class ResponseStreamCallbackForBidirectionalStream extends BidirectionalStream.Callback {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final Executor f23199d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PipedOutputStreamAndroid25 f23200a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23201b;

    /* renamed from: c  reason: collision with root package name */
    public RequestBodyOutputStream f23202c;

    /* loaded from: classes4.dex */
    public final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public BidirectionalStream f23203e;

        /* renamed from: f  reason: collision with root package name */
        public UrlResponseInfo f23204f;

        /* renamed from: g  reason: collision with root package name */
        public InputStream f23205g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ResponseStreamCallbackForBidirectionalStream f23206h;

        public a(ResponseStreamCallbackForBidirectionalStream responseStreamCallbackForBidirectionalStream, BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, InputStream inputStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {responseStreamCallbackForBidirectionalStream, bidirectionalStream, urlResponseInfo, inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23206h = responseStreamCallbackForBidirectionalStream;
            this.f23203e = bidirectionalStream;
            this.f23204f = urlResponseInfo;
            this.f23205g = inputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23206h.k(this.f23203e, this.f23204f, this.f23205g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1187823577, "Lcom/baidu/turbonet/net/ResponseStreamCallbackForBidirectionalStream;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1187823577, "Lcom/baidu/turbonet/net/ResponseStreamCallbackForBidirectionalStream;");
                return;
            }
        }
        f23199d = Executors.newCachedThreadPool();
    }

    public ResponseStreamCallbackForBidirectionalStream() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void a(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bidirectionalStream, urlResponseInfo) == null) {
            try {
                this.f23202c.n();
            } catch (Exception unused) {
                d.a.q0.a.a.h("ChromiumNetwork", "Exception when closing associated stream", new Object[0]);
            }
            try {
                this.f23200a.close();
            } catch (Exception unused2) {
                d.a.q0.a.a.h("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
            }
            i(bidirectionalStream, urlResponseInfo);
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void b(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, TurbonetException turbonetException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bidirectionalStream, urlResponseInfo, turbonetException) == null) {
            d.a.q0.a.a.h("ChromiumNetwork", "****** onFailed, url is: %s, error is: %s", urlResponseInfo.h(), turbonetException);
            try {
                this.f23202c.n();
            } catch (Exception unused) {
                d.a.q0.a.a.h("ChromiumNetwork", "Exception when closing associated stream", new Object[0]);
            }
            try {
                this.f23200a.close();
            } catch (Exception unused2) {
                d.a.q0.a.a.h("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
            }
            if (this.f23201b) {
                return;
            }
            j(bidirectionalStream, urlResponseInfo, turbonetException);
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void c(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bidirectionalStream, urlResponseInfo, byteBuffer, Boolean.valueOf(z)}) == null) {
            byteBuffer.flip();
            d.a.q0.a.a.h("ChromiumNetwork", "****** onReadCompleted ******%s", byteBuffer);
            this.f23200a.write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
            this.f23200a.flush();
            if (z) {
                return;
            }
            byteBuffer.clear();
            bidirectionalStream.a(byteBuffer);
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void d(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bidirectionalStream, urlResponseInfo) == null) {
            d.a.q0.a.a.h("ChromiumNetwork", "****** onResponseHeaderReceived ******", new Object[0]);
            d.a.q0.a.a.h("ChromiumNetwork", "*** Headers Are *** %s", urlResponseInfo.a());
            this.f23200a = new PipedOutputStreamAndroid25();
            try {
                f23199d.execute(new a(this, bidirectionalStream, urlResponseInfo, new PipedInputStreamAndroid25(this.f23200a, 4096)));
                bidirectionalStream.a(ByteBuffer.allocateDirect(32768));
                this.f23201b = true;
            } catch (Exception e2) {
                d.a.q0.a.a.c("ChromiumNetwork", "Exception in onResponseStarted ", e2);
                throw e2;
            }
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void f(BidirectionalStream bidirectionalStream) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bidirectionalStream) == null) {
            d.a.q0.a.a.h("ChromiumNetwork", "****** onStreamReady ******", new Object[0]);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f23202c.g());
            int b2 = this.f23202c.b(allocateDirect);
            allocateDirect.flip();
            bidirectionalStream.b(allocateDirect, b2 <= 0);
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void g(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bidirectionalStream, urlResponseInfo) == null) {
            d.a.q0.a.a.h("ChromiumNetwork", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.h(), Integer.valueOf(urlResponseInfo.c()), Long.valueOf(urlResponseInfo.g()));
            try {
                this.f23200a.close();
            } catch (Exception unused) {
                d.a.q0.a.a.c("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
            }
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void h(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{bidirectionalStream, urlResponseInfo, byteBuffer, Boolean.valueOf(z)}) == null) || z) {
            return;
        }
        byteBuffer.clear();
        int b2 = this.f23202c.b(byteBuffer);
        byteBuffer.flip();
        bidirectionalStream.b(byteBuffer, b2 <= 0);
        d.a.q0.a.a.h("ChromiumNetwork", "****** onWriteCompleted ******, total writen bytes is %d", Integer.valueOf(b2));
    }

    public void i(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, bidirectionalStream, urlResponseInfo) == null) {
        }
    }

    public abstract void j(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

    public abstract void k(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, InputStream inputStream);
}
