package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.http.HttpMethodName;
import com.baidubce.model.AbstractBceRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes25.dex */
public class GeneratePresignedUrlRequest extends AbstractBceRequest {
    private String bucketName;
    private String contentMd5;
    private String contentType;
    private int expirationInSeconds;
    private String key;
    private HttpMethodName method;
    private Map<String, String> requestHeaders;
    private Map<String, String> requestParameters;
    private ResponseHeaderOverrides responseHeaders;

    public GeneratePresignedUrlRequest(String str, String str2) {
        this(str, str2, HttpMethodName.GET);
    }

    public GeneratePresignedUrlRequest(String str, String str2, HttpMethodName httpMethodName) {
        this.expirationInSeconds = -1;
        this.requestParameters = new HashMap();
        this.requestHeaders = new HashMap();
        this.bucketName = str;
        this.key = str2;
        this.method = httpMethodName;
    }

    public HttpMethodName getMethod() {
        return this.method;
    }

    public void setMethod(HttpMethodName httpMethodName) {
        this.method = httpMethodName;
    }

    public GeneratePresignedUrlRequest withMethod(HttpMethodName httpMethodName) {
        setMethod(httpMethodName);
        return this;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public GeneratePresignedUrlRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public GeneratePresignedUrlRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public int getExpiration() {
        return this.expirationInSeconds;
    }

    public void setExpiration(int i) {
        this.expirationInSeconds = i;
    }

    public GeneratePresignedUrlRequest withExpiration(int i) {
        setExpiration(i);
        return this;
    }

    public void addRequestParameter(String str, String str2) {
        this.requestParameters.put(str, str2);
    }

    public Map<String, String> getRequestParameters() {
        return this.requestParameters;
    }

    public ResponseHeaderOverrides getResponseHeaders() {
        return this.responseHeaders;
    }

    public void setResponseHeaders(ResponseHeaderOverrides responseHeaderOverrides) {
        this.responseHeaders = responseHeaderOverrides;
    }

    public GeneratePresignedUrlRequest withResponseHeaders(ResponseHeaderOverrides responseHeaderOverrides) {
        setResponseHeaders(responseHeaderOverrides);
        return this;
    }

    public void addRequestHeaders(String str, String str2) {
        this.requestHeaders.put(str, str2);
    }

    public Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public GeneratePresignedUrlRequest withContentType(String str) {
        setContentType(str);
        return this;
    }

    public String getContentMd5() {
        return this.contentMd5;
    }

    public void setContentMd5(String str) {
        this.contentMd5 = str;
    }

    public GeneratePresignedUrlRequest withContentMd5(String str) {
        this.contentMd5 = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public GeneratePresignedUrlRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }
}
