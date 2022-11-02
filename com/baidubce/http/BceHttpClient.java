package com.baidubce.http;

import android.annotation.SuppressLint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.BceClientConfiguration;
import com.baidubce.BceClientException;
import com.baidubce.BceServiceException;
import com.baidubce.ErrorCode;
import com.baidubce.auth.BceCredentials;
import com.baidubce.auth.SignOptions;
import com.baidubce.auth.Signer;
import com.baidubce.callback.BceProgressCallback;
import com.baidubce.http.handler.HttpResponseHandler;
import com.baidubce.internal.InternalRequest;
import com.baidubce.model.AbstractBceRequest;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.services.bos.model.GetObjectRequest;
import com.baidubce.util.BLog;
import com.baidubce.util.CheckUtils;
import com.baidubce.util.DateUtils;
import com.baidubce.util.HttpUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
@SuppressLint({"NewApi"})
/* loaded from: classes7.dex */
public class BceHttpClient {
    public static /* synthetic */ Interceptable $ic;
    public static final HttpClientFactory httpClientFactory;
    public transient /* synthetic */ FieldHolder $fh;
    public final BceClientConfiguration config;
    public long diffMillis;
    public OkHttpClient httpClient;
    public final Signer signer;

    /* loaded from: classes7.dex */
    public class BceServiceRequestBody<T extends AbstractBceRequest> extends RequestBody {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BceProgressCallback<T> callback;
        public long length;
        public MediaType mediaType;
        public T request;
        public InputStream restartableInputStream;
        public final /* synthetic */ BceHttpClient this$0;

        public BceServiceRequestBody(BceHttpClient bceHttpClient, InternalRequest<T> internalRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bceHttpClient, internalRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bceHttpClient;
            if (internalRequest.getContent() != null) {
                this.mediaType = MediaType.parse(internalRequest.getHeaders().get("Content-Type"));
                this.restartableInputStream = internalRequest.getContent();
                this.length = getContentLength(internalRequest);
                this.callback = null;
                this.request = internalRequest.getRequest();
            }
        }

        public BceServiceRequestBody(BceHttpClient bceHttpClient, InternalRequest<T> internalRequest, BceProgressCallback<T> bceProgressCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bceHttpClient, internalRequest, bceProgressCallback};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = bceHttpClient;
            if (internalRequest.getContent() != null) {
                this.mediaType = MediaType.parse(internalRequest.getHeaders().get("Content-Type"));
                this.restartableInputStream = internalRequest.getContent();
                this.length = getContentLength(internalRequest);
                this.callback = bceProgressCallback;
                this.request = internalRequest.getRequest();
            }
        }

        private long getContentLength(InternalRequest<T> internalRequest) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, internalRequest)) == null) {
                String str = internalRequest.getHeaders().get("Content-Length");
                if (str != null) {
                    return Long.parseLong(str);
                }
                return 0L;
            }
            return invokeL.longValue;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.length;
            }
            return invokeV.longValue;
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mediaType;
            }
            return (MediaType) invokeV.objValue;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bufferedSink) == null) {
                long contentLength = contentLength();
                Source source = Okio.source(this.restartableInputStream);
                long j = 0;
                while (j < contentLength) {
                    long read = source.read(bufferedSink.buffer(), Math.min(contentLength - j, this.this$0.config.getUploadSegmentPart()));
                    if (read == -1) {
                        break;
                    }
                    long j2 = j + read;
                    bufferedSink.flush();
                    BceProgressCallback<T> bceProgressCallback = this.callback;
                    if (bceProgressCallback != null) {
                        bceProgressCallback.onProgress(this.request, j2, contentLength);
                    }
                    j = j2;
                }
                if (source != null) {
                    source.close();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(33667359, "Lcom/baidubce/http/BceHttpClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(33667359, "Lcom/baidubce/http/BceHttpClient;");
                return;
            }
        }
        httpClientFactory = new HttpClientFactory();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BceHttpClient(BceClientConfiguration bceClientConfiguration, Signer signer) {
        this(bceClientConfiguration, httpClientFactory.createHttpClient(bceClientConfiguration), signer);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bceClientConfiguration, signer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((BceClientConfiguration) objArr2[0], (OkHttpClient) objArr2[1], (Signer) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public BceHttpClient(BceClientConfiguration bceClientConfiguration, OkHttpClient okHttpClient, Signer signer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bceClientConfiguration, okHttpClient, signer};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.diffMillis = 0L;
        CheckUtils.isNotNull(bceClientConfiguration, "config should not be null.");
        CheckUtils.isNotNull(signer, "signer should not be null.");
        this.config = bceClientConfiguration;
        this.httpClient = okHttpClient;
        this.signer = signer;
    }

    public <T extends AbstractBceRequest> OkHttpClient addResponseProgressCallback(T t, BceProgressCallback<T> bceProgressCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t, bceProgressCallback)) == null) {
            return this.httpClient.newBuilder().addNetworkInterceptor(new Interceptor(this, t, bceProgressCallback) { // from class: com.baidubce.http.BceHttpClient.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BceHttpClient this$0;
                public final /* synthetic */ BceProgressCallback val$callback;
                public final /* synthetic */ AbstractBceRequest val$request;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, t, bceProgressCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$request = t;
                    this.val$callback = bceProgressCallback;
                }

                @Override // okhttp3.Interceptor
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, chain)) == null) {
                        Response proceed = chain.proceed(chain.request());
                        return proceed.newBuilder().body(new BceServiceResponseBody(proceed.body(), this.val$request, this.val$callback)).build();
                    }
                    return (Response) invokeL.objValue;
                }
            }).build();
        }
        return (OkHttpClient) invokeLL.objValue;
    }

    public <T extends AbstractBceRequest> Request createHttpRequest(InternalRequest<T> internalRequest, BceProgressCallback<T> bceProgressCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, internalRequest, bceProgressCallback)) == null) {
            String aSCIIString = internalRequest.getUri().toASCIIString();
            String canonicalQueryString = HttpUtils.getCanonicalQueryString(internalRequest.getParameters(), false);
            if (canonicalQueryString.length() > 0) {
                aSCIIString = aSCIIString + "?" + canonicalQueryString;
            }
            Request.Builder url = new Request.Builder().url(aSCIIString);
            if (internalRequest.getHttpMethod() == HttpMethodName.GET) {
                url.get();
            } else if (internalRequest.getHttpMethod() == HttpMethodName.PUT) {
                if (internalRequest.getContent() != null) {
                    url.put(new BceServiceRequestBody(this, internalRequest, bceProgressCallback));
                } else {
                    url.put(RequestBody.create((MediaType) null, new byte[0]));
                }
            } else if (internalRequest.getHttpMethod() == HttpMethodName.POST) {
                if (internalRequest.getContent() != null) {
                    url.post(new BceServiceRequestBody(this, internalRequest, bceProgressCallback));
                } else {
                    url.post(RequestBody.create((MediaType) null, new byte[0]));
                }
            } else if (internalRequest.getHttpMethod() == HttpMethodName.DELETE) {
                url.delete();
            } else if (internalRequest.getHttpMethod() == HttpMethodName.HEAD) {
                url.head();
            } else {
                throw new BceClientException("Unknown HTTP method name: " + internalRequest.getHttpMethod());
            }
            for (Map.Entry<String, String> entry : internalRequest.getHeaders().entrySet()) {
                if (!entry.getKey().equalsIgnoreCase("Content-Length") && !entry.getKey().equalsIgnoreCase("Host")) {
                    url.addHeader(entry.getKey(), entry.getValue());
                }
            }
            return url.build();
        }
        return (Request) invokeLL.objValue;
    }

    public <T extends AbstractBceResponse, M extends AbstractBceRequest> T execute(InternalRequest<M> internalRequest, Class<T> cls, HttpResponseHandler[] httpResponseHandlerArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, internalRequest, cls, httpResponseHandlerArr)) == null) {
            return (T) execute(internalRequest, cls, httpResponseHandlerArr, null);
        }
        return (T) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x018a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T extends AbstractBceResponse, M extends AbstractBceRequest> T execute(InternalRequest<M> internalRequest, Class<T> cls, HttpResponseHandler[] httpResponseHandlerArr, BceProgressCallback<M> bceProgressCallback) {
        InterceptResult invokeLLLL;
        BceServiceException bceServiceException;
        long delayBeforeNextRetryInMillis;
        SignOptions signOptions;
        OkHttpClient okHttpClient;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, internalRequest, cls, httpResponseHandlerArr, bceProgressCallback)) == null) {
            internalRequest.addHeader("User-Agent", this.config.getUserAgent());
            internalRequest.addHeader("Accept-Encoding", this.config.getAcceptEncoding());
            BceCredentials credentials = this.config.getCredentials();
            if (internalRequest.getCredentials() != null) {
                credentials = internalRequest.getCredentials();
            }
            BceCredentials bceCredentials = credentials;
            long j = 0;
            int i = 1;
            while (true) {
                try {
                    j = Calendar.getInstance().getTimeInMillis();
                    Date date = new Date(this.diffMillis + j);
                    if (internalRequest.getSignOptions() == null) {
                        signOptions = SignOptions.DEFAULT;
                    } else {
                        signOptions = internalRequest.getSignOptions();
                    }
                    signOptions.setTimestamp(date);
                    internalRequest.setSignOptions(signOptions);
                    if (this.diffMillis != 0) {
                        internalRequest.addHeader(Headers.BCE_DATE, DateUtils.alternateIso8601DateFormat(date));
                    }
                    if (bceCredentials != null) {
                        this.signer.sign(internalRequest, bceCredentials);
                    }
                    okHttpClient = this.httpClient;
                } catch (BceServiceException e) {
                    e = e;
                } catch (BceClientException e2) {
                    e = e2;
                } catch (Exception e3) {
                    e = e3;
                }
                try {
                    Request createHttpRequest = createHttpRequest(internalRequest, bceProgressCallback);
                    if (internalRequest.getRequest() instanceof GetObjectRequest) {
                        okHttpClient = addResponseProgressCallback(internalRequest.getRequest(), ((GetObjectRequest) internalRequest.getRequest()).getProgressCallback());
                        BLog.debug("getObject");
                    }
                    Call newCall = okHttpClient.newCall(createHttpRequest);
                    if (internalRequest.getRequest() != null) {
                        internalRequest.getRequest().setCall(newCall);
                        if (internalRequest.getRequest().getCanceled()) {
                            throw new BceClientException("Request is canceled!");
                        }
                    }
                    BceHttpResponse bceHttpResponse = new BceHttpResponse(newCall.execute());
                    bceHttpResponse.getHeader("Date");
                    T newInstance = cls.newInstance();
                    int length = httpResponseHandlerArr.length;
                    for (int i2 = 0; i2 < length && !httpResponseHandlerArr[i2].handle(bceHttpResponse, newInstance); i2++) {
                    }
                    return newInstance;
                } catch (BceServiceException e4) {
                    e = e4;
                    BceServiceException bceServiceException2 = e;
                    boolean equals = ErrorCode.REQUEST_TIME_TOO_SKEWED.equals(bceServiceException2.getErrorCode());
                    bceServiceException = bceServiceException2;
                    if (equals) {
                        Date parseRfc822Date = DateUtils.parseRfc822Date("");
                        bceServiceException = bceServiceException2;
                        bceServiceException = bceServiceException2;
                        if (!"".equals("") && parseRfc822Date != null) {
                            synchronized (this) {
                                this.diffMillis = parseRfc822Date.getTime() - j;
                            }
                            bceServiceException = bceServiceException2;
                        }
                    }
                    BLog.warn("Unable to execute HTTP request");
                    delayBeforeNextRetryInMillis = getDelayBeforeNextRetryInMillis(internalRequest, bceServiceException, i, this.config.getRetryPolicy());
                    if (delayBeforeNextRetryInMillis >= 0) {
                        BLog.warn("Retriable error detected, will retry in " + delayBeforeNextRetryInMillis + " ms, attempt number: " + i);
                        try {
                            Thread.sleep(delayBeforeNextRetryInMillis);
                            if (internalRequest.getContent() != null) {
                                internalRequest.getContent().restart();
                            }
                            i++;
                        } catch (InterruptedException e5) {
                            throw new BceClientException("Delay interrupted", e5);
                        }
                    } else {
                        throw bceServiceException;
                    }
                } catch (BceClientException e6) {
                    e = e6;
                    bceServiceException = e;
                    BLog.warn("Unable to execute HTTP request");
                    delayBeforeNextRetryInMillis = getDelayBeforeNextRetryInMillis(internalRequest, bceServiceException, i, this.config.getRetryPolicy());
                    if (delayBeforeNextRetryInMillis >= 0) {
                    }
                } catch (Exception e7) {
                    e = e7;
                    if (internalRequest.getRequest() != null && internalRequest.getRequest().isCanceled()) {
                        bceServiceException = new BceClientException("Request is canceled!", e);
                    } else {
                        bceServiceException = new BceClientException("Unable to execute HTTP request", e);
                    }
                    BLog.warn("Unable to execute HTTP request");
                    delayBeforeNextRetryInMillis = getDelayBeforeNextRetryInMillis(internalRequest, bceServiceException, i, this.config.getRetryPolicy());
                    if (delayBeforeNextRetryInMillis >= 0) {
                    }
                }
                i++;
            }
        } else {
            return (T) invokeLLLL.objValue;
        }
    }

    public long getDelayBeforeNextRetryInMillis(InternalRequest internalRequest, BceClientException bceClientException, int i, RetryPolicy retryPolicy) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048580, this, internalRequest, bceClientException, i, retryPolicy)) == null) {
            int i2 = i - 1;
            if (i2 >= retryPolicy.getMaxErrorRetry()) {
                return -1L;
            }
            return Math.min(retryPolicy.getMaxDelayInMillis(), retryPolicy.getDelayBeforeNextRetryInMillis(bceClientException, i2));
        }
        return invokeLLIL.longValue;
    }
}
