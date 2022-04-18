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
import com.repackage.i39;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public abstract class ResponseStreamCallbackForBidirectionalStream extends BidirectionalStream.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final Executor d;
    public transient /* synthetic */ FieldHolder $fh;
    public PipedOutputStreamAndroid25 a;
    public boolean b;
    public RequestBodyOutputStream c;

    /* loaded from: classes4.dex */
    public final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BidirectionalStream a;
        public UrlResponseInfo b;
        public InputStream c;
        public final /* synthetic */ ResponseStreamCallbackForBidirectionalStream d;

        public a(ResponseStreamCallbackForBidirectionalStream responseStreamCallbackForBidirectionalStream, BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, InputStream inputStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {responseStreamCallbackForBidirectionalStream, bidirectionalStream, urlResponseInfo, inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = responseStreamCallbackForBidirectionalStream;
            this.a = bidirectionalStream;
            this.b = urlResponseInfo;
            this.c = inputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.k(this.a, this.b, this.c);
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
        d = Executors.newCachedThreadPool();
    }

    public ResponseStreamCallbackForBidirectionalStream() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                this.c.e();
            } catch (Exception unused) {
                i39.h("ChromiumNetwork", "Exception when closing associated stream", new Object[0]);
            }
            try {
                this.a.close();
            } catch (Exception unused2) {
                i39.h("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
            }
            i(bidirectionalStream, urlResponseInfo);
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void b(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, TurbonetException turbonetException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bidirectionalStream, urlResponseInfo, turbonetException) == null) {
            i39.h("ChromiumNetwork", "****** onFailed, url is: %s, error is: %s", urlResponseInfo.h(), turbonetException);
            try {
                this.c.e();
            } catch (Exception unused) {
                i39.h("ChromiumNetwork", "Exception when closing associated stream", new Object[0]);
            }
            try {
                this.a.close();
            } catch (Exception unused2) {
                i39.h("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
            }
            if (this.b) {
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
            i39.h("ChromiumNetwork", "****** onReadCompleted ******%s", byteBuffer);
            this.a.write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
            this.a.flush();
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
            i39.h("ChromiumNetwork", "****** onResponseHeaderReceived ******", new Object[0]);
            i39.h("ChromiumNetwork", "*** Headers Are *** %s", urlResponseInfo.a());
            this.a = new PipedOutputStreamAndroid25();
            try {
                d.execute(new a(this, bidirectionalStream, urlResponseInfo, new PipedInputStreamAndroid25(this.a, 4096)));
                bidirectionalStream.a(ByteBuffer.allocateDirect(32768));
                this.b = true;
            } catch (Exception e) {
                i39.c("ChromiumNetwork", "Exception in onResponseStarted ", e);
                throw e;
            }
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void f(BidirectionalStream bidirectionalStream) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bidirectionalStream) == null) {
            i39.h("ChromiumNetwork", "****** onStreamReady ******", new Object[0]);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.c.c());
            int b = this.c.b(allocateDirect);
            allocateDirect.flip();
            bidirectionalStream.b(allocateDirect, b <= 0);
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream.Callback
    public final void g(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bidirectionalStream, urlResponseInfo) == null) {
            i39.h("ChromiumNetwork", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.h(), Integer.valueOf(urlResponseInfo.c()), Long.valueOf(urlResponseInfo.g()));
            try {
                this.a.close();
            } catch (Exception unused) {
                i39.c("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
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
        int b = this.c.b(byteBuffer);
        byteBuffer.flip();
        bidirectionalStream.b(byteBuffer, b <= 0);
        i39.h("ChromiumNetwork", "****** onWriteCompleted ******, total writen bytes is %d", Integer.valueOf(b));
    }

    public void i(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, bidirectionalStream, urlResponseInfo) == null) {
        }
    }

    public abstract void j(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

    public abstract void k(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, InputStream inputStream);
}
