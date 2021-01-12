package com.baidubce.internal;

import com.baidubce.auth.BceCredentials;
import com.baidubce.auth.SignOptions;
import com.baidubce.http.HttpMethodName;
import com.baidubce.model.AbstractBceRequest;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class InternalRequest<T extends AbstractBceRequest> {
    private RestartableInputStream content;
    private BceCredentials credentials;
    private boolean expectContinueEnabled;
    private HttpMethodName httpMethod;
    private T request;
    private SignOptions signOptions;
    private URI uri;
    private Map<String, String> parameters = new HashMap();
    private Map<String, String> headers = new HashMap();

    public InternalRequest(HttpMethodName httpMethodName, URI uri) {
        this.httpMethod = httpMethodName;
        this.uri = uri;
    }

    public void addHeader(String str, String str2) {
        this.headers.put(str, str2);
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void addParameter(String str, String str2) {
        this.parameters.put(str, str2);
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public HttpMethodName getHttpMethod() {
        return this.httpMethod;
    }

    public URI getUri() {
        return this.uri;
    }

    public RestartableInputStream getContent() {
        return this.content;
    }

    public void setContent(RestartableInputStream restartableInputStream) {
        this.content = restartableInputStream;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers.clear();
        this.headers.putAll(map);
    }

    public void setParameters(Map<String, String> map) {
        this.parameters.clear();
        this.parameters.putAll(map);
    }

    public BceCredentials getCredentials() {
        return this.credentials;
    }

    public void setCredentials(BceCredentials bceCredentials) {
        this.credentials = bceCredentials;
    }

    public SignOptions getSignOptions() {
        return this.signOptions;
    }

    public void setSignOptions(SignOptions signOptions) {
        this.signOptions = signOptions;
    }

    public boolean isExpectContinueEnabled() {
        return this.expectContinueEnabled;
    }

    public void setExpectContinueEnabled(boolean z) {
        this.expectContinueEnabled = z;
    }

    public T getRequest() {
        return this.request;
    }

    public void setRequest(T t) {
        this.request = t;
    }

    public String toString() {
        return "InternalRequest [httpMethod=" + this.httpMethod + ", uri=" + this.uri + ", expectContinueEnabled=" + this.expectContinueEnabled + ", parameters=" + this.parameters + ", headers=" + this.headers + "]";
    }
}
