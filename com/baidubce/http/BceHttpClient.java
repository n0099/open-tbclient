package com.baidubce.http;

import android.annotation.SuppressLint;
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
/* loaded from: classes6.dex */
public class BceHttpClient {
    public static final HttpClientFactory httpClientFactory = new HttpClientFactory();
    public final BceClientConfiguration config;
    public long diffMillis;
    public OkHttpClient httpClient;
    public final Signer signer;

    public BceHttpClient(BceClientConfiguration bceClientConfiguration, Signer signer) {
        this(bceClientConfiguration, httpClientFactory.createHttpClient(bceClientConfiguration), signer);
    }

    public <T extends AbstractBceRequest> OkHttpClient addResponseProgressCallback(final T t, final BceProgressCallback<T> bceProgressCallback) {
        return this.httpClient.newBuilder().addNetworkInterceptor(new Interceptor() { // from class: com.baidubce.http.BceHttpClient.1
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Response proceed = chain.proceed(chain.request());
                return proceed.newBuilder().body(new BceServiceResponseBody(proceed.body(), t, bceProgressCallback)).build();
            }
        }).build();
    }

    public <T extends AbstractBceRequest> Request createHttpRequest(InternalRequest<T> internalRequest, BceProgressCallback<T> bceProgressCallback) {
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
                url.put(new BceServiceRequestBody(internalRequest, bceProgressCallback));
            } else {
                url.put(RequestBody.create((MediaType) null, new byte[0]));
            }
        } else if (internalRequest.getHttpMethod() == HttpMethodName.POST) {
            if (internalRequest.getContent() != null) {
                url.post(new BceServiceRequestBody(internalRequest, bceProgressCallback));
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

    public <T extends AbstractBceResponse, M extends AbstractBceRequest> T execute(InternalRequest<M> internalRequest, Class<T> cls, HttpResponseHandler[] httpResponseHandlerArr) {
        return (T) execute(internalRequest, cls, httpResponseHandlerArr, null);
    }

    public long getDelayBeforeNextRetryInMillis(InternalRequest internalRequest, BceClientException bceClientException, int i2, RetryPolicy retryPolicy) {
        int i3 = i2 - 1;
        if (i3 >= retryPolicy.getMaxErrorRetry()) {
            return -1L;
        }
        return Math.min(retryPolicy.getMaxDelayInMillis(), retryPolicy.getDelayBeforeNextRetryInMillis(bceClientException, i3));
    }

    public BceHttpClient(BceClientConfiguration bceClientConfiguration, OkHttpClient okHttpClient, Signer signer) {
        this.diffMillis = 0L;
        CheckUtils.isNotNull(bceClientConfiguration, "config should not be null.");
        CheckUtils.isNotNull(signer, "signer should not be null.");
        this.config = bceClientConfiguration;
        this.httpClient = okHttpClient;
        this.signer = signer;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0185 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T extends AbstractBceResponse, M extends AbstractBceRequest> T execute(InternalRequest<M> internalRequest, Class<T> cls, HttpResponseHandler[] httpResponseHandlerArr, BceProgressCallback<M> bceProgressCallback) {
        BceServiceException bceServiceException;
        long delayBeforeNextRetryInMillis;
        internalRequest.addHeader("User-Agent", this.config.getUserAgent());
        internalRequest.addHeader("Accept-Encoding", this.config.getAcceptEncoding());
        BceCredentials credentials = this.config.getCredentials();
        if (internalRequest.getCredentials() != null) {
            credentials = internalRequest.getCredentials();
        }
        BceCredentials bceCredentials = credentials;
        long j = 0;
        int i2 = 1;
        while (true) {
            try {
                j = Calendar.getInstance().getTimeInMillis();
                Date date = new Date(this.diffMillis + j);
                SignOptions signOptions = internalRequest.getSignOptions() == null ? SignOptions.DEFAULT : internalRequest.getSignOptions();
                signOptions.setTimestamp(date);
                internalRequest.setSignOptions(signOptions);
                if (this.diffMillis != 0) {
                    internalRequest.addHeader(Headers.BCE_DATE, DateUtils.alternateIso8601DateFormat(date));
                }
                if (bceCredentials != null) {
                    this.signer.sign(internalRequest, bceCredentials);
                }
                OkHttpClient okHttpClient = this.httpClient;
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
                    for (int i3 = 0; i3 < length && !httpResponseHandlerArr[i3].handle(bceHttpResponse, newInstance); i3++) {
                    }
                    return newInstance;
                } catch (BceServiceException e2) {
                    e = e2;
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
                    delayBeforeNextRetryInMillis = getDelayBeforeNextRetryInMillis(internalRequest, bceServiceException, i2, this.config.getRetryPolicy());
                    if (delayBeforeNextRetryInMillis >= 0) {
                        BLog.warn("Retriable error detected, will retry in " + delayBeforeNextRetryInMillis + " ms, attempt number: " + i2);
                        try {
                            Thread.sleep(delayBeforeNextRetryInMillis);
                            if (internalRequest.getContent() != null) {
                                internalRequest.getContent().restart();
                            }
                            i2++;
                        } catch (InterruptedException e3) {
                            throw new BceClientException("Delay interrupted", e3);
                        }
                    } else {
                        throw bceServiceException;
                    }
                } catch (BceClientException e4) {
                    e = e4;
                    bceServiceException = e;
                    BLog.warn("Unable to execute HTTP request");
                    delayBeforeNextRetryInMillis = getDelayBeforeNextRetryInMillis(internalRequest, bceServiceException, i2, this.config.getRetryPolicy());
                    if (delayBeforeNextRetryInMillis >= 0) {
                    }
                } catch (Exception e5) {
                    e = e5;
                    if (internalRequest.getRequest() != null && internalRequest.getRequest().isCanceled()) {
                        bceServiceException = new BceClientException("Request is canceled!", e);
                    } else {
                        bceServiceException = new BceClientException("Unable to execute HTTP request", e);
                    }
                    BLog.warn("Unable to execute HTTP request");
                    delayBeforeNextRetryInMillis = getDelayBeforeNextRetryInMillis(internalRequest, bceServiceException, i2, this.config.getRetryPolicy());
                    if (delayBeforeNextRetryInMillis >= 0) {
                    }
                }
            } catch (BceServiceException e6) {
                e = e6;
            } catch (BceClientException e7) {
                e = e7;
            } catch (Exception e8) {
                e = e8;
            }
            i2++;
        }
    }

    /* loaded from: classes6.dex */
    public class BceServiceRequestBody<T extends AbstractBceRequest> extends RequestBody {
        public BceProgressCallback<T> callback;
        public long length;
        public MediaType mediaType;
        public T request;
        public InputStream restartableInputStream;

        public BceServiceRequestBody(InternalRequest<T> internalRequest, BceProgressCallback<T> bceProgressCallback) {
            if (internalRequest.getContent() != null) {
                this.mediaType = MediaType.parse(internalRequest.getHeaders().get("Content-Type"));
                this.restartableInputStream = internalRequest.getContent();
                this.length = getContentLength(internalRequest);
                this.callback = bceProgressCallback;
                this.request = internalRequest.getRequest();
            }
        }

        private long getContentLength(InternalRequest<T> internalRequest) {
            String str = internalRequest.getHeaders().get("Content-Length");
            if (str != null) {
                return Long.parseLong(str);
            }
            return 0L;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.length;
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.mediaType;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            long contentLength = contentLength();
            Source source = Okio.source(this.restartableInputStream);
            long j = 0;
            while (j < contentLength) {
                long read = source.read(bufferedSink.buffer(), Math.min(contentLength - j, BceHttpClient.this.config.getUploadSegmentPart()));
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

        public BceServiceRequestBody(InternalRequest<T> internalRequest) {
            if (internalRequest.getContent() != null) {
                this.mediaType = MediaType.parse(internalRequest.getHeaders().get("Content-Type"));
                this.restartableInputStream = internalRequest.getContent();
                this.length = getContentLength(internalRequest);
                this.callback = null;
                this.request = internalRequest.getRequest();
            }
        }
    }
}
