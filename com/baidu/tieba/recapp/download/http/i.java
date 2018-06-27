package com.baidu.tieba.recapp.download.http;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class i {
    public Map<String, List<String>> Aa;
    public byte[] Ab;
    public int Ac;
    public volatile boolean zY = false;
    public int responseCode = -1;
    public int zZ = -1;
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
            this.Aa = httpURLConnection.getHeaderFields();
        }
    }
}
