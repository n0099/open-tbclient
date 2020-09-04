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
/* loaded from: classes10.dex */
public class ProxyURLConnection extends HttpsURLConnection implements com.baidu.turbonet.net.proxy.b {
    private TurbonetEngine ncT;
    private ProxyConfig ncf;
    private a ndk;
    private HttpURLConnection ndl;
    private d ndm;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.ncf.dKE()) {
            this.ndm.addRequestProperty(str, str2);
        } else {
            this.ndl.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.ncf.toString());
        if (!this.ncf.dKE()) {
            this.ndm.connect();
            return;
        }
        try {
            this.ndl.connect();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.ncf.dKE() ? this.ndm.getConnectTimeout() : this.ndl.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.ncf.dKE()) {
            return this.ndm.getContent();
        }
        try {
            long contentLength = this.ndl.getContentLength();
            this.ndk.ncs = contentLength;
            onComplete(contentLength);
            return this.ndl.getContent();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.ncf.dKE()) {
            return this.ndm.getContent(clsArr);
        }
        try {
            long contentLength = this.ndl.getContentLength();
            this.ndk.ncs = contentLength;
            onComplete(contentLength);
            return this.ndl.getContent(clsArr);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.ncf.dKE() ? this.ndm.getContentEncoding() : this.ndl.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.ncf.dKE() ? this.ndm.getContentLength() : this.ndl.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.ncf.dKE() ? this.ndm.getContentType() : this.ndl.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.ncf.dKE() ? this.ndm.getDate() : this.ndl.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.ncf.dKE() ? this.ndm.getDefaultUseCaches() : this.ndl.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.ncf.dKE() ? this.ndm.getDoInput() : this.ndl.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.ncf.dKE() ? this.ndm.getDoOutput() : this.ndl.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.ncf.dKE() ? this.ndm.getExpiration() : this.ndl.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.ncf.dKE()) {
            return this.ndm.getHeaderField(str);
        }
        String headerField = this.ndl.getHeaderField(str);
        this.ndk.dKF();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.ncf.dKE()) {
            return this.ndm.getHeaderField(i);
        }
        return this.ndl.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.ncf.dKE() ? this.ndm.getHeaderFieldInt(str, i) : this.ndl.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.ncf.dKE() ? this.ndm.getHeaderFieldDate(str, j) : this.ndl.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.ncf.dKE() ? this.ndm.getHeaderFieldKey(i) : this.ndl.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.ncf.dKE()) {
            return this.ndm.getHeaderFields();
        }
        return this.ndl.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.ncf.dKE() ? this.ndm.getIfModifiedSince() : this.ndl.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.ncf.toString());
        if (!this.ncf.dKE()) {
            return this.ndm.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.ndl.getInputStream(), this);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.ncf.dKE() ? this.ndm.getOutputStream() : this.ndl.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.ncf.dKE() ? this.ndm.getLastModified() : this.ndl.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.ncf.dKE() ? this.ndm.getPermission() : this.ndl.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.ncf.dKE() ? this.ndm.getReadTimeout() : this.ndl.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.ncf.dKE() ? this.ndm.getRequestProperties() : this.ndl.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.ncf.dKE() ? this.ndm.getRequestProperty(str) : this.ndl.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.ncf.dKE() ? this.ndm.getURL() : this.ndl.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.ncf.dKE() ? this.ndm.getUseCaches() : this.ndl.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.ncf.dKE()) {
            this.ndm.setConnectTimeout(i);
        } else {
            this.ndl.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.ncf.dKE()) {
            this.ndm.setDefaultUseCaches(z);
        } else {
            this.ndl.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.ncf.dKE()) {
            this.ndm.setDoInput(z);
        } else {
            this.ndl.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.ncf.dKE()) {
            this.ndm.setDoOutput(z);
        } else {
            this.ndl.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.ncf.dKE()) {
            this.ndm.setIfModifiedSince(j);
        } else {
            this.ndl.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.ncf.dKE()) {
            this.ndm.setReadTimeout(i);
        } else {
            this.ndl.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.ncf.dKE()) {
            this.ndm.setRequestProperty(str, str2);
        } else {
            this.ndl.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.ncf.dKE()) {
            this.ndm.setUseCaches(z);
        } else {
            this.ndl.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.ncf.toString());
        if (!this.ncf.dKE()) {
            this.ndm.disconnect();
        } else {
            this.ndl.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.ncf.dKE() ? this.ndm.getErrorStream() : this.ndl.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.ncf.dKE() ? this.ndm.getInstanceFollowRedirects() : this.ndl.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.ncf.dKE() ? this.ndm.getRequestMethod() : this.ndl.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.ncf.dKE()) {
            responseCode = this.ndm.getResponseCode();
        } else {
            try {
                responseCode = this.ndl.getResponseCode();
                this.ndk.ncr = responseCode;
                this.ndk.dKF();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                a(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.ncf.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.ncf.dKE()) {
            responseMessage = this.ndm.getResponseMessage();
        } else {
            responseMessage = this.ndl.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.ncf.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.ncf.dKE()) {
            this.ndm.setChunkedStreamingMode(i);
        } else {
            this.ndl.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.ncf.dKE()) {
            this.ndm.setFixedLengthStreamingMode(i);
        } else {
            this.ndl.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.ncf.dKE()) {
            this.ndm.setFixedLengthStreamingMode(j);
        } else {
            this.ndl.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.ncf.dKE()) {
            this.ndm.setInstanceFollowRedirects(z);
        } else {
            this.ndl.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.ncf.dKE()) {
            this.ndm.setRequestMethod(str);
            return;
        }
        this.ndl.setRequestMethod(str);
        this.ndk.dqa = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.ncf.dKE() ? this.ndm.usingProxy() : this.ndl.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.ndl instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ndl).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.ndl instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ndl).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.ndl instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ndl).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.ndl instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ndl).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.ndl instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ndl).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.ndl instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ndl).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.ndl instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ndl).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.ndl instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.ndl).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.ndl instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.ndl).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void a(Exception exc, long j) {
        this.ndk.ncs = j;
        this.ndk.dKG();
        this.ndk.A(exc);
        this.ndk.a(this.ncT);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.ndk.ncs = j;
        this.ndk.dKG();
        this.ndk.ncq = 0;
        this.ndk.a(this.ncT);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void ge(long j) {
        this.ndk.ncs = j;
        this.ndk.dKG();
        this.ndk.ncq = -12;
        this.ndk.a(this.ncT);
    }
}
