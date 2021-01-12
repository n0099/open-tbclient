package com.baidu.tieba.recapp.download.http;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class i {
    public Map<String, List<String>> MG;
    public int downSize;
    public byte[] retBytes;
    public volatile boolean MF = false;
    public int responseCode = -1;
    public int mNetErrorCode = -1;
    public String contentEncoding = "";
    public String contentType = "";
    public String contentLength = "";

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.responseCode = httpURLConnection.getResponseCode();
            this.contentEncoding = httpURLConnection.getContentEncoding();
            this.contentType = httpURLConnection.getContentType();
            this.contentLength = httpURLConnection.getContentLength() + "";
            this.MG = httpURLConnection.getHeaderFields();
        }
    }
}
