package com.baidu.turbonet.net;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.UrlRequest;
import com.repackage.d29;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public abstract class ResponseStreamCallbackForUrlRequest extends UrlRequest.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static ExecutorService c;
    public transient /* synthetic */ FieldHolder $fh;
    public PipedOutputStreamAndroid25 a;
    public RequestBodyOutputStream b;

    /* loaded from: classes4.dex */
    public final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public UrlRequest a;
        public UrlResponseInfo b;
        public InputStream c;
        public final /* synthetic */ ResponseStreamCallbackForUrlRequest d;

        public a(ResponseStreamCallbackForUrlRequest responseStreamCallbackForUrlRequest, UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, InputStream inputStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {responseStreamCallbackForUrlRequest, urlRequest, urlResponseInfo, inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = responseStreamCallbackForUrlRequest;
            this.a = urlRequest;
            this.b = urlResponseInfo;
            this.c = inputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.i(this.a, this.b, this.c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(734052108, "Lcom/baidu/turbonet/net/ResponseStreamCallbackForUrlRequest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(734052108, "Lcom/baidu/turbonet/net/ResponseStreamCallbackForUrlRequest;");
                return;
            }
        }
        c = Executors.newCachedThreadPool();
    }

    public ResponseStreamCallbackForUrlRequest() {
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

    @Override // com.baidu.turbonet.net.UrlRequest.Callback
    public final void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, urlRequest, urlResponseInfo) == null) {
            RequestBodyOutputStream requestBodyOutputStream = this.b;
            if (requestBodyOutputStream != null) {
                try {
                    requestBodyOutputStream.e();
                } catch (Exception unused) {
                    d29.h("ChromiumNetwork", "Exception when closing associated stream", new Object[0]);
                }
            }
            try {
                this.a.close();
            } catch (Exception unused2) {
                d29.h("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
            }
            g(urlRequest, urlResponseInfo);
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest.Callback
    public final void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, urlRequest, urlResponseInfo, urlRequestException) == null) {
            d29.c("ChromiumNetwork", "****** onFailed, url is: %s, error is: %s", urlResponseInfo.h(), urlRequestException);
            RequestBodyOutputStream requestBodyOutputStream = this.b;
            if (requestBodyOutputStream != null) {
                try {
                    requestBodyOutputStream.e();
                } catch (Exception unused) {
                    d29.h("ChromiumNetwork", "Exception when closing associated stream", new Object[0]);
                }
            }
            try {
                this.a.close();
            } catch (Exception unused2) {
                d29.h("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
            }
            h(urlRequest, urlResponseInfo, urlRequestException);
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest.Callback
    public final void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, urlRequest, urlResponseInfo, byteBuffer) == null) {
            byteBuffer.flip();
            d29.h("ChromiumNetwork", "****** onReadCompleted ******%s", byteBuffer);
            this.a.write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
            this.a.flush();
            byteBuffer.clear();
            urlRequest.read(byteBuffer);
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest.Callback
    public final void e(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, urlRequest, urlResponseInfo) == null) {
            d29.h("ChromiumNetwork", "****** Response Started ******", new Object[0]);
            d29.h("ChromiumNetwork", "*** Headers Are *** %s", urlResponseInfo.a());
            this.a = new PipedOutputStreamAndroid25();
            try {
                c.execute(new a(this, urlRequest, urlResponseInfo, new PipedInputStreamAndroid25(this.a, 4096)));
                urlRequest.read(ByteBuffer.allocateDirect(32768));
            } catch (Exception e) {
                d29.c("ChromiumNetwork", "Exception in onResponseStarted ", e);
                throw e;
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest.Callback
    public final void f(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, urlRequest, urlResponseInfo) == null) {
            d29.h("ChromiumNetwork", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.h(), Integer.valueOf(urlResponseInfo.c()), Long.valueOf(urlResponseInfo.g()));
            try {
                this.a.close();
            } catch (Exception unused) {
                d29.c("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
            }
        }
    }

    public void g(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, urlRequest, urlResponseInfo) == null) {
        }
    }

    public abstract void h(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException);

    public abstract void i(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, InputStream inputStream);
}
