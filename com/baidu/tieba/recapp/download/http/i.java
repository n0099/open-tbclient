package com.baidu.tieba.recapp.download.http;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class i {
    public Map<String, List<String>> ajD;
    public byte[] ajE;
    public int ajF;
    public volatile boolean ajB = false;
    public int responseCode = -1;
    public int ajC = -1;
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
            this.ajD = httpURLConnection.getHeaderFields();
        }
    }
}
