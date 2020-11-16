package com.baidubce;

import com.baidubce.auth.BceV1Signer;
import com.baidubce.callback.BceProgressCallback;
import com.baidubce.http.BceHttpClient;
import com.baidubce.http.handler.HttpResponseHandler;
import com.baidubce.internal.InternalRequest;
import com.baidubce.model.AbstractBceRequest;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.util.DateUtils;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes24.dex */
public abstract class AbstractBceClient {
    public static final String DEFAULT_CONTENT_TYPE = "application/json; charset=utf-8";
    public static final String DEFAULT_SERVICE_DOMAIN = "baidubce.com";
    public static final String URL_PREFIX = "v1";
    public BceHttpClient client;
    protected BceClientConfiguration config;
    private HttpResponseHandler[] responseHandlers;
    private String serviceId = computeServiceId();
    private URI endpoint = computeEndpoint();

    public AbstractBceClient(BceClientConfiguration bceClientConfiguration, HttpResponseHandler[] httpResponseHandlerArr) {
        this.config = bceClientConfiguration;
        this.client = new BceHttpClient(bceClientConfiguration, new BceV1Signer());
        this.responseHandlers = httpResponseHandlerArr;
    }

    public boolean isRegionSupported() {
        return true;
    }

    public URI getEndpoint() {
        return this.endpoint;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public BceHttpClient getClient() {
        return this.client;
    }

    public void setClient(BceHttpClient bceHttpClient) {
        this.client = bceHttpClient;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends AbstractBceResponse, M extends AbstractBceRequest> T invokeHttpClient(InternalRequest<M> internalRequest, Class<T> cls) {
        return (T) invokeHttpClient(internalRequest, cls, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends AbstractBceResponse, M extends AbstractBceRequest> T invokeHttpClient(InternalRequest<M> internalRequest, Class<T> cls, BceProgressCallback<M> bceProgressCallback) {
        if (!internalRequest.getHeaders().containsKey("Content-Type")) {
            internalRequest.addHeader("Content-Type", DEFAULT_CONTENT_TYPE);
        }
        if (!internalRequest.getHeaders().containsKey("Date")) {
            internalRequest.addHeader("Date", DateUtils.rfc822DateFormat());
        }
        return (T) this.client.execute(internalRequest, cls, this.responseHandlers, bceProgressCallback);
    }

    private String computeServiceId() {
        String name = getClass().getPackage().getName();
        String str = AbstractBceClient.class.getPackage().getName() + ".services.";
        if (!name.startsWith(str)) {
            throw new IllegalStateException("Unrecognized prefix for the client package : " + name + ", '" + str + "' expected");
        }
        String substring = name.substring(str.length());
        if (substring.indexOf(46) != -1) {
            throw new IllegalStateException("The client class should be put in package like " + str + "XXX");
        }
        String name2 = getClass().getName();
        String str2 = name + '.' + Character.toUpperCase(substring.charAt(0)) + substring.substring(1) + "Client";
        if (!name2.equals(str2)) {
            throw new IllegalStateException("Invalid class name " + name2 + ", " + str2 + " expected");
        }
        return substring;
    }

    private URI computeEndpoint() {
        String endpoint = this.config.getEndpoint();
        if (endpoint == null) {
            try {
                if (isRegionSupported()) {
                    endpoint = String.format("%s://%s.%s.%s", this.config.getProtocol(), this.serviceId, this.config.getRegion(), DEFAULT_SERVICE_DOMAIN);
                } else {
                    endpoint = String.format("%s://%s.%s", this.config.getProtocol(), this.serviceId, DEFAULT_SERVICE_DOMAIN);
                }
            } catch (URISyntaxException e) {
                throw new IllegalArgumentException("Invalid endpoint." + endpoint, e);
            }
        }
        return new URI(endpoint);
    }
}
