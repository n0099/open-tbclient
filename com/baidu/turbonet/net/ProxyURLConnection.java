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
/* loaded from: classes17.dex */
public class ProxyURLConnection extends HttpsURLConnection implements com.baidu.turbonet.net.proxy.b {
    private TurbonetEngine oeQ;
    private ProxyConfig oec;
    private a ofh;
    private HttpURLConnection ofi;
    private d ofj;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.oec.dYg()) {
            this.ofj.addRequestProperty(str, str2);
        } else {
            this.ofi.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.oec.toString());
        if (!this.oec.dYg()) {
            this.ofj.connect();
            return;
        }
        try {
            this.ofi.connect();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.oec.dYg() ? this.ofj.getConnectTimeout() : this.ofi.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.oec.dYg()) {
            return this.ofj.getContent();
        }
        try {
            long contentLength = this.ofi.getContentLength();
            this.ofh.oep = contentLength;
            onComplete(contentLength);
            return this.ofi.getContent();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.oec.dYg()) {
            return this.ofj.getContent(clsArr);
        }
        try {
            long contentLength = this.ofi.getContentLength();
            this.ofh.oep = contentLength;
            onComplete(contentLength);
            return this.ofi.getContent(clsArr);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.oec.dYg() ? this.ofj.getContentEncoding() : this.ofi.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.oec.dYg() ? this.ofj.getContentLength() : this.ofi.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.oec.dYg() ? this.ofj.getContentType() : this.ofi.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.oec.dYg() ? this.ofj.getDate() : this.ofi.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.oec.dYg() ? this.ofj.getDefaultUseCaches() : this.ofi.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.oec.dYg() ? this.ofj.getDoInput() : this.ofi.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.oec.dYg() ? this.ofj.getDoOutput() : this.ofi.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.oec.dYg() ? this.ofj.getExpiration() : this.ofi.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.oec.dYg()) {
            return this.ofj.getHeaderField(str);
        }
        String headerField = this.ofi.getHeaderField(str);
        this.ofh.dYh();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.oec.dYg()) {
            return this.ofj.getHeaderField(i);
        }
        return this.ofi.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.oec.dYg() ? this.ofj.getHeaderFieldInt(str, i) : this.ofi.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.oec.dYg() ? this.ofj.getHeaderFieldDate(str, j) : this.ofi.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.oec.dYg() ? this.ofj.getHeaderFieldKey(i) : this.ofi.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.oec.dYg()) {
            return this.ofj.getHeaderFields();
        }
        return this.ofi.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.oec.dYg() ? this.ofj.getIfModifiedSince() : this.ofi.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.oec.toString());
        if (!this.oec.dYg()) {
            return this.ofj.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.ofi.getInputStream(), this);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.oec.dYg() ? this.ofj.getOutputStream() : this.ofi.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.oec.dYg() ? this.ofj.getLastModified() : this.ofi.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.oec.dYg() ? this.ofj.getPermission() : this.ofi.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.oec.dYg() ? this.ofj.getReadTimeout() : this.ofi.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.oec.dYg() ? this.ofj.getRequestProperties() : this.ofi.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.oec.dYg() ? this.ofj.getRequestProperty(str) : this.ofi.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.oec.dYg() ? this.ofj.getURL() : this.ofi.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.oec.dYg() ? this.ofj.getUseCaches() : this.ofi.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.oec.dYg()) {
            this.ofj.setConnectTimeout(i);
        } else {
            this.ofi.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.oec.dYg()) {
            this.ofj.setDefaultUseCaches(z);
        } else {
            this.ofi.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.oec.dYg()) {
            this.ofj.setDoInput(z);
        } else {
            this.ofi.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.oec.dYg()) {
            this.ofj.setDoOutput(z);
        } else {
            this.ofi.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.oec.dYg()) {
            this.ofj.setIfModifiedSince(j);
        } else {
            this.ofi.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.oec.dYg()) {
            this.ofj.setReadTimeout(i);
        } else {
            this.ofi.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.oec.dYg()) {
            this.ofj.setRequestProperty(str, str2);
        } else {
            this.ofi.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.oec.dYg()) {
            this.ofj.setUseCaches(z);
        } else {
            this.ofi.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.oec.toString());
        if (!this.oec.dYg()) {
            this.ofj.disconnect();
        } else {
            this.ofi.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.oec.dYg() ? this.ofj.getErrorStream() : this.ofi.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.oec.dYg() ? this.ofj.getInstanceFollowRedirects() : this.ofi.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.oec.dYg() ? this.ofj.getRequestMethod() : this.ofi.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.oec.dYg()) {
            responseCode = this.ofj.getResponseCode();
        } else {
            try {
                responseCode = this.ofi.getResponseCode();
                this.ofh.oeo = responseCode;
                this.ofh.dYh();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                a(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.oec.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.oec.dYg()) {
            responseMessage = this.ofj.getResponseMessage();
        } else {
            responseMessage = this.ofi.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.oec.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.oec.dYg()) {
            this.ofj.setChunkedStreamingMode(i);
        } else {
            this.ofi.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.oec.dYg()) {
            this.ofj.setFixedLengthStreamingMode(i);
        } else {
            this.ofi.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.oec.dYg()) {
            this.ofj.setFixedLengthStreamingMode(j);
        } else {
            this.ofi.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.oec.dYg()) {
            this.ofj.setInstanceFollowRedirects(z);
        } else {
            this.ofi.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.oec.dYg()) {
            this.ofj.setRequestMethod(str);
            return;
        }
        this.ofi.setRequestMethod(str);
        this.ofh.dMC = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.oec.dYg() ? this.ofj.usingProxy() : this.ofi.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.ofi instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ofi).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.ofi instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ofi).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.ofi instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ofi).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.ofi instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ofi).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.ofi instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ofi).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.ofi instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ofi).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.ofi instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ofi).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.ofi instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.ofi).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.ofi instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.ofi).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void a(Exception exc, long j) {
        this.ofh.oep = j;
        this.ofh.dYi();
        this.ofh.A(exc);
        this.ofh.a(this.oeQ);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.ofh.oep = j;
        this.ofh.dYi();
        this.ofh.oen = 0;
        this.ofh.a(this.oeQ);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void gR(long j) {
        this.ofh.oep = j;
        this.ofh.dYi();
        this.ofh.oen = -12;
        this.ofh.a(this.oeQ);
    }
}
