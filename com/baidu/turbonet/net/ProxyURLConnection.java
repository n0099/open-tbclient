package com.baidu.turbonet.net;

import android.annotation.TargetApi;
import com.baidu.turbonet.net.a.d;
import com.baidu.turbonet.net.proxy.ProxyConfig;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes.dex */
public class ProxyURLConnection extends HttpsURLConnection implements com.baidu.turbonet.net.proxy.b {
    private ProxyConfig lKp;
    private TurbonetEngine lLe;
    private a lLu;
    private HttpURLConnection lLv;
    private d lLw;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.lKp.djh()) {
            this.lLw.addRequestProperty(str, str2);
        } else {
            this.lLv.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.lKp.toString());
        if (!this.lKp.djh()) {
            this.lLw.connect();
            return;
        }
        try {
            this.lLv.connect();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.lKp.djh() ? this.lLw.getConnectTimeout() : this.lLv.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.lKp.djh()) {
            return this.lLw.getContent();
        }
        try {
            long contentLength = this.lLv.getContentLength();
            this.lLu.lKD = contentLength;
            onComplete(contentLength);
            return this.lLv.getContent();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.lKp.djh()) {
            return this.lLw.getContent(clsArr);
        }
        try {
            long contentLength = this.lLv.getContentLength();
            this.lLu.lKD = contentLength;
            onComplete(contentLength);
            return this.lLv.getContent(clsArr);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.lKp.djh() ? this.lLw.getContentEncoding() : this.lLv.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.lKp.djh() ? this.lLw.getContentLength() : this.lLv.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.lKp.djh() ? this.lLw.getContentType() : this.lLv.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.lKp.djh() ? this.lLw.getDate() : this.lLv.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.lKp.djh() ? this.lLw.getDefaultUseCaches() : this.lLv.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.lKp.djh() ? this.lLw.getDoInput() : this.lLv.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.lKp.djh() ? this.lLw.getDoOutput() : this.lLv.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.lKp.djh() ? this.lLw.getExpiration() : this.lLv.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.lKp.djh()) {
            return this.lLw.getHeaderField(str);
        }
        String headerField = this.lLv.getHeaderField(str);
        this.lLu.dji();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.lKp.djh()) {
            return this.lLw.getHeaderField(i);
        }
        return this.lLv.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.lKp.djh() ? this.lLw.getHeaderFieldInt(str, i) : this.lLv.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.lKp.djh() ? this.lLw.getHeaderFieldDate(str, j) : this.lLv.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.lKp.djh() ? this.lLw.getHeaderFieldKey(i) : this.lLv.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.lKp.djh()) {
            return this.lLw.getHeaderFields();
        }
        return this.lLv.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.lKp.djh() ? this.lLw.getIfModifiedSince() : this.lLv.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.lKp.toString());
        if (!this.lKp.djh()) {
            return this.lLw.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.lLv.getInputStream(), this);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.lKp.djh() ? this.lLw.getOutputStream() : this.lLv.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.lKp.djh() ? this.lLw.getLastModified() : this.lLv.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.lKp.djh() ? this.lLw.getPermission() : this.lLv.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.lKp.djh() ? this.lLw.getReadTimeout() : this.lLv.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.lKp.djh() ? this.lLw.getRequestProperties() : this.lLv.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.lKp.djh() ? this.lLw.getRequestProperty(str) : this.lLv.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.lKp.djh() ? this.lLw.getURL() : this.lLv.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.lKp.djh() ? this.lLw.getUseCaches() : this.lLv.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.lKp.djh()) {
            this.lLw.setConnectTimeout(i);
        } else {
            this.lLv.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.lKp.djh()) {
            this.lLw.setDefaultUseCaches(z);
        } else {
            this.lLv.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.lKp.djh()) {
            this.lLw.setDoInput(z);
        } else {
            this.lLv.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.lKp.djh()) {
            this.lLw.setDoOutput(z);
        } else {
            this.lLv.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.lKp.djh()) {
            this.lLw.setIfModifiedSince(j);
        } else {
            this.lLv.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.lKp.djh()) {
            this.lLw.setReadTimeout(i);
        } else {
            this.lLv.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.lKp.djh()) {
            this.lLw.setRequestProperty(str, str2);
        } else {
            this.lLv.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.lKp.djh()) {
            this.lLw.setUseCaches(z);
        } else {
            this.lLv.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.lKp.toString());
        if (!this.lKp.djh()) {
            this.lLw.disconnect();
        } else {
            this.lLv.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.lKp.djh() ? this.lLw.getErrorStream() : this.lLv.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.lKp.djh() ? this.lLw.getInstanceFollowRedirects() : this.lLv.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.lKp.djh() ? this.lLw.getRequestMethod() : this.lLv.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.lKp.djh()) {
            responseCode = this.lLw.getResponseCode();
        } else {
            try {
                responseCode = this.lLv.getResponseCode();
                this.lLu.lKC = responseCode;
                this.lLu.dji();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                a(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.lKp.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.lKp.djh()) {
            responseMessage = this.lLw.getResponseMessage();
        } else {
            responseMessage = this.lLv.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.lKp.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.lKp.djh()) {
            this.lLw.setChunkedStreamingMode(i);
        } else {
            this.lLv.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.lKp.djh()) {
            this.lLw.setFixedLengthStreamingMode(i);
        } else {
            this.lLv.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.lKp.djh()) {
            this.lLw.setFixedLengthStreamingMode(j);
        } else {
            this.lLv.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.lKp.djh()) {
            this.lLw.setInstanceFollowRedirects(z);
        } else {
            this.lLv.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.lKp.djh()) {
            this.lLw.setRequestMethod(str);
            return;
        }
        this.lLv.setRequestMethod(str);
        this.lLu.lKA = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.lKp.djh() ? this.lLw.usingProxy() : this.lLv.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.lLv instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.lLv).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.lLv instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.lLv).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.lLv instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.lLv).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.lLv instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.lLv).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.lLv instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.lLv).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.lLv instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.lLv).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.lLv instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.lLv).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.lLv instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.lLv).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.lLv instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.lLv).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void a(Exception exc, long j) {
        this.lLu.lKD = j;
        this.lLu.djj();
        this.lLu.p(exc);
        this.lLu.a(this.lLe);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.lLu.lKD = j;
        this.lLu.djj();
        this.lLu.lKB = 0;
        this.lLu.a(this.lLe);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void fy(long j) {
        this.lLu.lKD = j;
        this.lLu.djj();
        this.lLu.lKB = -12;
        this.lLu.a(this.lLe);
    }
}
