package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.model.AbstractBceRequest;
/* loaded from: classes5.dex */
public class ResponseHeaderOverrides extends AbstractBceRequest {
    public String cacheControl;
    public String contentDisposition;
    public String contentEncoding;
    public String contentLanguage;
    public String contentType;
    public String expires;
    public static final String RESPONSE_HEADER_CACHE_CONTROL = "responseCacheControl";
    public static final String RESPONSE_HEADER_CONTENT_DISPOSITION = "responseContentDisposition";
    public static final String RESPONSE_HEADER_CONTENT_ENCODING = "responseContentEncoding";
    public static final String RESPONSE_HEADER_CONTENT_LANGUAGE = "responseContentLanguage";
    public static final String RESPONSE_HEADER_CONTENT_TYPE = "responseContentType";
    public static final String RESPONSE_HEADER_EXPIRES = "responseExpires";
    public static final String[] PARAMETER_ORDER = {RESPONSE_HEADER_CACHE_CONTROL, RESPONSE_HEADER_CONTENT_DISPOSITION, RESPONSE_HEADER_CONTENT_ENCODING, RESPONSE_HEADER_CONTENT_LANGUAGE, RESPONSE_HEADER_CONTENT_TYPE, RESPONSE_HEADER_EXPIRES};

    public String getCacheControl() {
        return this.cacheControl;
    }

    public String getContentDisposition() {
        return this.contentDisposition;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public String getContentLanguage() {
        return this.contentLanguage;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getExpires() {
        return this.expires;
    }

    public void setCacheControl(String str) {
        this.cacheControl = str;
    }

    public void setContentDisposition(String str) {
        this.contentDisposition = str;
    }

    public void setContentEncoding(String str) {
        this.contentEncoding = str;
    }

    public void setContentLanguage(String str) {
        this.contentLanguage = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setExpires(String str) {
        this.expires = str;
    }

    public ResponseHeaderOverrides withCacheControl(String str) {
        setCacheControl(str);
        return this;
    }

    public ResponseHeaderOverrides withContentDisposition(String str) {
        setContentDisposition(str);
        return this;
    }

    public ResponseHeaderOverrides withContentEncoding(String str) {
        setContentEncoding(str);
        return this;
    }

    public ResponseHeaderOverrides withContentLanguage(String str) {
        setContentLanguage(str);
        return this;
    }

    public ResponseHeaderOverrides withContentType(String str) {
        setContentType(str);
        return this;
    }

    public ResponseHeaderOverrides withExpires(String str) {
        setExpires(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public ResponseHeaderOverrides withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }
}
