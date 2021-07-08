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
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public abstract class ResponseStreamCallbackForUrlRequest extends UrlRequest.Callback {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static ExecutorService f23207c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PipedOutputStreamAndroid25 f23208a;

    /* renamed from: b  reason: collision with root package name */
    public RequestBodyOutputStream f23209b;

    /* loaded from: classes4.dex */
    public final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public UrlRequest f23210e;

        /* renamed from: f  reason: collision with root package name */
        public UrlResponseInfo f23211f;

        /* renamed from: g  reason: collision with root package name */
        public InputStream f23212g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ResponseStreamCallbackForUrlRequest f23213h;

        public a(ResponseStreamCallbackForUrlRequest responseStreamCallbackForUrlRequest, UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, InputStream inputStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {responseStreamCallbackForUrlRequest, urlRequest, urlResponseInfo, inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23213h = responseStreamCallbackForUrlRequest;
            this.f23210e = urlRequest;
            this.f23211f = urlResponseInfo;
            this.f23212g = inputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23213h.i(this.f23210e, this.f23211f, this.f23212g);
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
        f23207c = Executors.newCachedThreadPool();
    }

    public ResponseStreamCallbackForUrlRequest() {
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

    @Override // com.baidu.turbonet.net.UrlRequest.Callback
    public final void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, urlRequest, urlResponseInfo) == null) {
            RequestBodyOutputStream requestBodyOutputStream = this.f23209b;
            if (requestBodyOutputStream != null) {
                try {
                    requestBodyOutputStream.n();
                } catch (Exception unused) {
                    d.a.q0.a.a.h("ChromiumNetwork", "Exception when closing associated stream", new Object[0]);
                }
            }
            try {
                this.f23208a.close();
            } catch (Exception unused2) {
                d.a.q0.a.a.h("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
            }
            g(urlRequest, urlResponseInfo);
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest.Callback
    public final void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, urlRequest, urlResponseInfo, urlRequestException) == null) {
            d.a.q0.a.a.c("ChromiumNetwork", "****** onFailed, url is: %s, error is: %s", urlResponseInfo.h(), urlRequestException);
            RequestBodyOutputStream requestBodyOutputStream = this.f23209b;
            if (requestBodyOutputStream != null) {
                try {
                    requestBodyOutputStream.n();
                } catch (Exception unused) {
                    d.a.q0.a.a.h("ChromiumNetwork", "Exception when closing associated stream", new Object[0]);
                }
            }
            try {
                this.f23208a.close();
            } catch (Exception unused2) {
                d.a.q0.a.a.h("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
            }
            h(urlRequest, urlResponseInfo, urlRequestException);
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest.Callback
    public final void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, urlRequest, urlResponseInfo, byteBuffer) == null) {
            byteBuffer.flip();
            d.a.q0.a.a.h("ChromiumNetwork", "****** onReadCompleted ******%s", byteBuffer);
            this.f23208a.write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
            this.f23208a.flush();
            byteBuffer.clear();
            urlRequest.read(byteBuffer);
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest.Callback
    public final void e(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, urlRequest, urlResponseInfo) == null) {
            d.a.q0.a.a.h("ChromiumNetwork", "****** Response Started ******", new Object[0]);
            d.a.q0.a.a.h("ChromiumNetwork", "*** Headers Are *** %s", urlResponseInfo.a());
            this.f23208a = new PipedOutputStreamAndroid25();
            try {
                f23207c.execute(new a(this, urlRequest, urlResponseInfo, new PipedInputStreamAndroid25(this.f23208a, 4096)));
                urlRequest.read(ByteBuffer.allocateDirect(32768));
            } catch (Exception e2) {
                d.a.q0.a.a.c("ChromiumNetwork", "Exception in onResponseStarted ", e2);
                throw e2;
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest.Callback
    public final void f(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, urlRequest, urlResponseInfo) == null) {
            d.a.q0.a.a.h("ChromiumNetwork", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.h(), Integer.valueOf(urlResponseInfo.c()), Long.valueOf(urlResponseInfo.g()));
            try {
                this.f23208a.close();
            } catch (Exception unused) {
                d.a.q0.a.a.c("ChromiumNetwork", "Exception when closing output stream", new Object[0]);
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
