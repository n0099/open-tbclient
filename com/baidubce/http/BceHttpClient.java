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
    private static final HttpClientFactory httpClientFactory = new HttpClientFactory();
    private final BceClientConfiguration config;
    private long diffMillis;
    private OkHttpClient httpClient;
    private final Signer signer;

    public BceHttpClient(BceClientConfiguration bceClientConfiguration, Signer signer) {
        this(bceClientConfiguration, httpClientFactory.createHttpClient(bceClientConfiguration), signer);
    }

    public BceHttpClient(BceClientConfiguration bceClientConfiguration, OkHttpClient okHttpClient, Signer signer) {
        this.diffMillis = 0L;
        CheckUtils.isNotNull(bceClientConfiguration, "config should not be null.");
        CheckUtils.isNotNull(signer, "signer should not be null.");
        this.config = bceClientConfiguration;
        this.httpClient = okHttpClient;
        this.signer = signer;
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

    public <T extends AbstractBceResponse, M extends AbstractBceRequest> T execute(InternalRequest<M> internalRequest, Class<T> cls, HttpResponseHandler[] httpResponseHandlerArr) {
        return (T) execute(internalRequest, cls, httpResponseHandlerArr, null);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:61:0x0185 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00e4: INVOKE  (r10 I:long) = 
      (r14v0 ?? I:com.baidubce.http.BceHttpClient)
      (r15v0 ?? I:com.baidubce.internal.InternalRequest)
      (r2v13 ?? I:com.baidubce.BceClientException)
      (r8 I:int)
      (r7 I:com.baidubce.http.RetryPolicy)
     type: VIRTUAL call: com.baidubce.http.BceHttpClient.getDelayBeforeNextRetryInMillis(com.baidubce.internal.InternalRequest, com.baidubce.BceClientException, int, com.baidubce.http.RetryPolicy):long, block:B:32:0x00d8 */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.baidubce.http.BceHttpClient] */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.baidubce.BceClientException] */
    /* JADX WARN: Type inference failed for: r2v12, types: [com.baidubce.BceClientException] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Throwable, com.baidubce.BceClientException] */
    /* JADX WARN: Type inference failed for: r2v24, types: [com.baidubce.BceServiceException] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.baidubce.BceClientException] */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T extends AbstractBceResponse, M extends AbstractBceRequest> T execute(InternalRequest<M> internalRequest, Class<T> cls, HttpResponseHandler[] httpResponseHandlerArr, BceProgressCallback<M> bceProgressCallback) {
        ?? e;
        ?? delayBeforeNextRetryInMillis;
        long delayBeforeNextRetryInMillis2;
        internalRequest.addHeader("User-Agent", this.config.getUserAgent());
        internalRequest.addHeader(Headers.ACCEPT_ENCODING, this.config.getAcceptEncoding());
        BceCredentials credentials = internalRequest.getCredentials() != null ? internalRequest.getCredentials() : this.config.getCredentials();
        int i = 1;
        while (true) {
            try {
                Date date = new Date(this.diffMillis + Calendar.getInstance().getTimeInMillis());
                SignOptions signOptions = internalRequest.getSignOptions() == null ? SignOptions.DEFAULT : internalRequest.getSignOptions();
                signOptions.setTimestamp(date);
                internalRequest.setSignOptions(signOptions);
                if (this.diffMillis != 0) {
                    internalRequest.addHeader(Headers.BCE_DATE, DateUtils.alternateIso8601DateFormat(date));
                }
                if (credentials != null) {
                    this.signer.sign(internalRequest, credentials);
                }
                OkHttpClient okHttpClient = this.httpClient;
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
            } catch (BceServiceException e2) {
                e = e2;
                if (ErrorCode.REQUEST_TIME_TOO_SKEWED.equals(e.getErrorCode())) {
                    Date parseRfc822Date = DateUtils.parseRfc822Date("");
                    if (!"".equals("") && parseRfc822Date != null) {
                        synchronized (this) {
                            this.diffMillis = parseRfc822Date.getTime() - 0;
                        }
                    }
                }
                BLog.warn("Unable to execute HTTP request");
                delayBeforeNextRetryInMillis2 = getDelayBeforeNextRetryInMillis(internalRequest, e, delayBeforeNextRetryInMillis, this.config.getRetryPolicy());
                if (delayBeforeNextRetryInMillis2 < 0) {
                    throw e;
                }
                BLog.warn("Retriable error detected, will retry in " + delayBeforeNextRetryInMillis2 + " ms, attempt number: " + ((int) delayBeforeNextRetryInMillis));
                try {
                    Thread.sleep(delayBeforeNextRetryInMillis2);
                    if (internalRequest.getContent() != null) {
                        internalRequest.getContent().restart();
                    }
                    i = delayBeforeNextRetryInMillis + 1;
                } catch (InterruptedException e3) {
                    throw new BceClientException("Delay interrupted", e3);
                }
            } catch (BceClientException e4) {
                e = e4;
                BLog.warn("Unable to execute HTTP request");
                delayBeforeNextRetryInMillis2 = getDelayBeforeNextRetryInMillis(internalRequest, e, delayBeforeNextRetryInMillis, this.config.getRetryPolicy());
                if (delayBeforeNextRetryInMillis2 < 0) {
                }
            } catch (Exception e5) {
                e = (internalRequest.getRequest() == null || !internalRequest.getRequest().isCanceled()) ? new BceClientException("Unable to execute HTTP request", e5) : new BceClientException("Request is canceled!", e5);
                BLog.warn("Unable to execute HTTP request");
                delayBeforeNextRetryInMillis2 = getDelayBeforeNextRetryInMillis(internalRequest, e, delayBeforeNextRetryInMillis, this.config.getRetryPolicy());
                if (delayBeforeNextRetryInMillis2 < 0) {
                }
            }
            i = delayBeforeNextRetryInMillis + 1;
        }
    }

    protected long getDelayBeforeNextRetryInMillis(InternalRequest internalRequest, BceClientException bceClientException, int i, RetryPolicy retryPolicy) {
        int i2 = i - 1;
        if (i2 >= retryPolicy.getMaxErrorRetry()) {
            return -1L;
        }
        return Math.min(retryPolicy.getMaxDelayInMillis(), retryPolicy.getDelayBeforeNextRetryInMillis(bceClientException, i2));
    }

    protected <T extends AbstractBceRequest> Request createHttpRequest(InternalRequest<T> internalRequest, BceProgressCallback<T> bceProgressCallback) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class BceServiceRequestBody<T extends AbstractBceRequest> extends RequestBody {
        private BceProgressCallback<T> callback;
        private long length;
        private MediaType mediaType;
        private T request;
        private InputStream restartableInputStream;

        BceServiceRequestBody(InternalRequest<T> internalRequest, BceProgressCallback<T> bceProgressCallback) {
            if (internalRequest.getContent() != null) {
                this.mediaType = MediaType.parse(internalRequest.getHeaders().get("Content-Type"));
                this.restartableInputStream = internalRequest.getContent();
                this.length = getContentLength(internalRequest);
                this.callback = bceProgressCallback;
                this.request = internalRequest.getRequest();
            }
        }

        BceServiceRequestBody(InternalRequest<T> internalRequest) {
            if (internalRequest.getContent() != null) {
                this.mediaType = MediaType.parse(internalRequest.getHeaders().get("Content-Type"));
                this.restartableInputStream = internalRequest.getContent();
                this.length = getContentLength(internalRequest);
                this.callback = null;
                this.request = internalRequest.getRequest();
            }
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.mediaType;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            long j = 0;
            long contentLength = contentLength();
            Source source = Okio.source(this.restartableInputStream);
            while (j < contentLength) {
                long read = source.read(bufferedSink.buffer(), Math.min(contentLength - j, BceHttpClient.this.config.getUploadSegmentPart()));
                if (read == -1) {
                    break;
                }
                j += read;
                bufferedSink.flush();
                if (this.callback != null) {
                    this.callback.onProgress(this.request, j, contentLength);
                }
            }
            if (source != null) {
                source.close();
            }
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.length;
        }

        private long getContentLength(InternalRequest<T> internalRequest) {
            String str = internalRequest.getHeaders().get("Content-Length");
            if (str == null) {
                return 0L;
            }
            return Long.parseLong(str);
        }
    }
}
