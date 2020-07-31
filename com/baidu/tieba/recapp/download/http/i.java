package com.baidu.tieba.recapp.download.http;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes20.dex */
public class i {
    public Map<String, List<String>> Lf;
    public int downSize;
    public byte[] retBytes;
    public volatile boolean Le = false;
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
            this.Lf = httpURLConnection.getHeaderFields();
        }
    }
}
