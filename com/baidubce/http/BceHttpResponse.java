package com.baidubce.http;

import com.baidubce.util.BLog;
import com.baidubce.util.DateUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
/* loaded from: classes.dex */
public class BceHttpResponse {
    private InputStream content;
    private Response httpResponse;

    public BceHttpResponse(Response response) throws IOException {
        this.httpResponse = response;
        try {
            this.content = response.body().byteStream();
        } catch (Exception e) {
            this.content = null;
        }
    }

    public String getHeader(String str) {
        return this.httpResponse.header(str, null);
    }

    public long getHeaderAsLong(String str) {
        String header = getHeader(str);
        if (header == null) {
            return -1L;
        }
        try {
            return Long.valueOf(header).longValue();
        } catch (Exception e) {
            BLog.error("Invalid " + str + ":" + header, (Throwable) e);
            return -1L;
        }
    }

    public Date getHeaderAsRfc822Date(String str) {
        String header = getHeader(str);
        if (header == null) {
            return null;
        }
        try {
            return DateUtils.parseRfc822Date(header);
        } catch (Exception e) {
            BLog.error("Invalid " + str + ":" + header, (Throwable) e);
            return null;
        }
    }

    public InputStream getContent() {
        return this.content;
    }

    public String getStatusText() {
        return this.httpResponse.message();
    }

    public int getStatusCode() {
        return this.httpResponse.code();
    }

    public Response getHttpResponse() {
        return this.httpResponse;
    }

    public Map<String, String> getHeaders() {
        okhttp3.Headers headers = getHttpResponse().headers();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < headers.size(); i++) {
            hashMap.put(headers.name(i), headers.value(i));
        }
        return hashMap;
    }
}
