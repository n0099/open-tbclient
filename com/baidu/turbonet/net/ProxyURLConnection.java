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
    private ProxyConfig lKl;
    private TurbonetEngine lLa;
    private a lLq;
    private HttpURLConnection lLr;
    private d lLs;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.lKl.djj()) {
            this.lLs.addRequestProperty(str, str2);
        } else {
            this.lLr.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.lKl.toString());
        if (!this.lKl.djj()) {
            this.lLs.connect();
            return;
        }
        try {
            this.lLr.connect();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.lKl.djj() ? this.lLs.getConnectTimeout() : this.lLr.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.lKl.djj()) {
            return this.lLs.getContent();
        }
        try {
            long contentLength = this.lLr.getContentLength();
            this.lLq.lKz = contentLength;
            onComplete(contentLength);
            return this.lLr.getContent();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.lKl.djj()) {
            return this.lLs.getContent(clsArr);
        }
        try {
            long contentLength = this.lLr.getContentLength();
            this.lLq.lKz = contentLength;
            onComplete(contentLength);
            return this.lLr.getContent(clsArr);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.lKl.djj() ? this.lLs.getContentEncoding() : this.lLr.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.lKl.djj() ? this.lLs.getContentLength() : this.lLr.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.lKl.djj() ? this.lLs.getContentType() : this.lLr.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.lKl.djj() ? this.lLs.getDate() : this.lLr.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.lKl.djj() ? this.lLs.getDefaultUseCaches() : this.lLr.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.lKl.djj() ? this.lLs.getDoInput() : this.lLr.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.lKl.djj() ? this.lLs.getDoOutput() : this.lLr.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.lKl.djj() ? this.lLs.getExpiration() : this.lLr.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.lKl.djj()) {
            return this.lLs.getHeaderField(str);
        }
        String headerField = this.lLr.getHeaderField(str);
        this.lLq.djk();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.lKl.djj()) {
            return this.lLs.getHeaderField(i);
        }
        return this.lLr.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.lKl.djj() ? this.lLs.getHeaderFieldInt(str, i) : this.lLr.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.lKl.djj() ? this.lLs.getHeaderFieldDate(str, j) : this.lLr.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.lKl.djj() ? this.lLs.getHeaderFieldKey(i) : this.lLr.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.lKl.djj()) {
            return this.lLs.getHeaderFields();
        }
        return this.lLr.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.lKl.djj() ? this.lLs.getIfModifiedSince() : this.lLr.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.lKl.toString());
        if (!this.lKl.djj()) {
            return this.lLs.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.lLr.getInputStream(), this);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.lKl.djj() ? this.lLs.getOutputStream() : this.lLr.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.lKl.djj() ? this.lLs.getLastModified() : this.lLr.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.lKl.djj() ? this.lLs.getPermission() : this.lLr.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.lKl.djj() ? this.lLs.getReadTimeout() : this.lLr.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.lKl.djj() ? this.lLs.getRequestProperties() : this.lLr.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.lKl.djj() ? this.lLs.getRequestProperty(str) : this.lLr.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.lKl.djj() ? this.lLs.getURL() : this.lLr.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.lKl.djj() ? this.lLs.getUseCaches() : this.lLr.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.lKl.djj()) {
            this.lLs.setConnectTimeout(i);
        } else {
            this.lLr.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.lKl.djj()) {
            this.lLs.setDefaultUseCaches(z);
        } else {
            this.lLr.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.lKl.djj()) {
            this.lLs.setDoInput(z);
        } else {
            this.lLr.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.lKl.djj()) {
            this.lLs.setDoOutput(z);
        } else {
            this.lLr.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.lKl.djj()) {
            this.lLs.setIfModifiedSince(j);
        } else {
            this.lLr.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.lKl.djj()) {
            this.lLs.setReadTimeout(i);
        } else {
            this.lLr.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.lKl.djj()) {
            this.lLs.setRequestProperty(str, str2);
        } else {
            this.lLr.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.lKl.djj()) {
            this.lLs.setUseCaches(z);
        } else {
            this.lLr.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.lKl.toString());
        if (!this.lKl.djj()) {
            this.lLs.disconnect();
        } else {
            this.lLr.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.lKl.djj() ? this.lLs.getErrorStream() : this.lLr.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.lKl.djj() ? this.lLs.getInstanceFollowRedirects() : this.lLr.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.lKl.djj() ? this.lLs.getRequestMethod() : this.lLr.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.lKl.djj()) {
            responseCode = this.lLs.getResponseCode();
        } else {
            try {
                responseCode = this.lLr.getResponseCode();
                this.lLq.lKy = responseCode;
                this.lLq.djk();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                a(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.lKl.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.lKl.djj()) {
            responseMessage = this.lLs.getResponseMessage();
        } else {
            responseMessage = this.lLr.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.lKl.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.lKl.djj()) {
            this.lLs.setChunkedStreamingMode(i);
        } else {
            this.lLr.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.lKl.djj()) {
            this.lLs.setFixedLengthStreamingMode(i);
        } else {
            this.lLr.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.lKl.djj()) {
            this.lLs.setFixedLengthStreamingMode(j);
        } else {
            this.lLr.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.lKl.djj()) {
            this.lLs.setInstanceFollowRedirects(z);
        } else {
            this.lLr.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.lKl.djj()) {
            this.lLs.setRequestMethod(str);
            return;
        }
        this.lLr.setRequestMethod(str);
        this.lLq.lKw = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.lKl.djj() ? this.lLs.usingProxy() : this.lLr.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.lLr instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.lLr).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.lLr instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.lLr).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.lLr instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.lLr).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.lLr instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.lLr).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.lLr instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.lLr).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.lLr instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.lLr).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.lLr instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.lLr).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.lLr instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.lLr).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.lLr instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.lLr).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void a(Exception exc, long j) {
        this.lLq.lKz = j;
        this.lLq.djl();
        this.lLq.o(exc);
        this.lLq.a(this.lLa);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.lLq.lKz = j;
        this.lLq.djl();
        this.lLq.lKx = 0;
        this.lLq.a(this.lLa);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void fy(long j) {
        this.lLq.lKz = j;
        this.lLq.djl();
        this.lLq.lKx = -12;
        this.lLq.a(this.lLa);
    }
}
