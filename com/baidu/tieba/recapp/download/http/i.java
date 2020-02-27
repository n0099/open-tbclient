package com.baidu.tieba.recapp.download.http;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes13.dex */
public class i {
    public int downSize;
    public byte[] retBytes;
    public Map<String, List<String>> rq;
    public volatile boolean rp = false;
    public int responseCode = -1;
    public int mNetErrorCode = -1;
    public String contentEncoding = "";
    public String contentType = "";
    public String contentLength = "";

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.responseCode = httpURLConnection.getResponseCode();
            this.contentEncoding = httpURLConnection.getContentEncoding();
            this.contentType = httpURLConnection.getContentType();
            this.contentLength = httpURLConnection.getContentLength() + "";
            this.rq = httpURLConnection.getHeaderFields();
        }
    }
}
