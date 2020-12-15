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
/* loaded from: classes14.dex */
public class ProxyURLConnection extends HttpsURLConnection implements com.baidu.turbonet.net.proxy.b {
    private ProxyConfig oDK;
    private a oEN;
    private HttpURLConnection oEO;
    private d oEP;
    private TurbonetEngine oEy;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.oDK.eht()) {
            this.oEP.addRequestProperty(str, str2);
        } else {
            this.oEO.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.oDK.toString());
        if (!this.oDK.eht()) {
            this.oEP.connect();
            return;
        }
        try {
            this.oEO.connect();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.oDK.eht() ? this.oEP.getConnectTimeout() : this.oEO.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.oDK.eht()) {
            return this.oEP.getContent();
        }
        try {
            long contentLength = this.oEO.getContentLength();
            this.oEN.oDX = contentLength;
            onComplete(contentLength);
            return this.oEO.getContent();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.oDK.eht()) {
            return this.oEP.getContent(clsArr);
        }
        try {
            long contentLength = this.oEO.getContentLength();
            this.oEN.oDX = contentLength;
            onComplete(contentLength);
            return this.oEO.getContent(clsArr);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.oDK.eht() ? this.oEP.getContentEncoding() : this.oEO.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.oDK.eht() ? this.oEP.getContentLength() : this.oEO.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.oDK.eht() ? this.oEP.getContentType() : this.oEO.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.oDK.eht() ? this.oEP.getDate() : this.oEO.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.oDK.eht() ? this.oEP.getDefaultUseCaches() : this.oEO.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.oDK.eht() ? this.oEP.getDoInput() : this.oEO.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.oDK.eht() ? this.oEP.getDoOutput() : this.oEO.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.oDK.eht() ? this.oEP.getExpiration() : this.oEO.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.oDK.eht()) {
            return this.oEP.getHeaderField(str);
        }
        String headerField = this.oEO.getHeaderField(str);
        this.oEN.ehu();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.oDK.eht()) {
            return this.oEP.getHeaderField(i);
        }
        return this.oEO.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.oDK.eht() ? this.oEP.getHeaderFieldInt(str, i) : this.oEO.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.oDK.eht() ? this.oEP.getHeaderFieldDate(str, j) : this.oEO.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.oDK.eht() ? this.oEP.getHeaderFieldKey(i) : this.oEO.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.oDK.eht()) {
            return this.oEP.getHeaderFields();
        }
        return this.oEO.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.oDK.eht() ? this.oEP.getIfModifiedSince() : this.oEO.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.oDK.toString());
        if (!this.oDK.eht()) {
            return this.oEP.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.oEO.getInputStream(), this);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.oDK.eht() ? this.oEP.getOutputStream() : this.oEO.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.oDK.eht() ? this.oEP.getLastModified() : this.oEO.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.oDK.eht() ? this.oEP.getPermission() : this.oEO.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.oDK.eht() ? this.oEP.getReadTimeout() : this.oEO.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.oDK.eht() ? this.oEP.getRequestProperties() : this.oEO.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.oDK.eht() ? this.oEP.getRequestProperty(str) : this.oEO.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.oDK.eht() ? this.oEP.getURL() : this.oEO.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.oDK.eht() ? this.oEP.getUseCaches() : this.oEO.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.oDK.eht()) {
            this.oEP.setConnectTimeout(i);
        } else {
            this.oEO.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.oDK.eht()) {
            this.oEP.setDefaultUseCaches(z);
        } else {
            this.oEO.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.oDK.eht()) {
            this.oEP.setDoInput(z);
        } else {
            this.oEO.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.oDK.eht()) {
            this.oEP.setDoOutput(z);
        } else {
            this.oEO.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.oDK.eht()) {
            this.oEP.setIfModifiedSince(j);
        } else {
            this.oEO.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.oDK.eht()) {
            this.oEP.setReadTimeout(i);
        } else {
            this.oEO.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.oDK.eht()) {
            this.oEP.setRequestProperty(str, str2);
        } else {
            this.oEO.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.oDK.eht()) {
            this.oEP.setUseCaches(z);
        } else {
            this.oEO.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.oDK.toString());
        if (!this.oDK.eht()) {
            this.oEP.disconnect();
        } else {
            this.oEO.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.oDK.eht() ? this.oEP.getErrorStream() : this.oEO.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.oDK.eht() ? this.oEP.getInstanceFollowRedirects() : this.oEO.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.oDK.eht() ? this.oEP.getRequestMethod() : this.oEO.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.oDK.eht()) {
            responseCode = this.oEP.getResponseCode();
        } else {
            try {
                responseCode = this.oEO.getResponseCode();
                this.oEN.oDW = responseCode;
                this.oEN.ehu();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                a(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.oDK.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.oDK.eht()) {
            responseMessage = this.oEP.getResponseMessage();
        } else {
            responseMessage = this.oEO.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.oDK.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.oDK.eht()) {
            this.oEP.setChunkedStreamingMode(i);
        } else {
            this.oEO.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.oDK.eht()) {
            this.oEP.setFixedLengthStreamingMode(i);
        } else {
            this.oEO.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.oDK.eht()) {
            this.oEP.setFixedLengthStreamingMode(j);
        } else {
            this.oEO.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.oDK.eht()) {
            this.oEP.setInstanceFollowRedirects(z);
        } else {
            this.oEO.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.oDK.eht()) {
            this.oEP.setRequestMethod(str);
            return;
        }
        this.oEO.setRequestMethod(str);
        this.oEN.dXK = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.oDK.eht() ? this.oEP.usingProxy() : this.oEO.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.oEO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oEO).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.oEO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oEO).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.oEO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oEO).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.oEO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oEO).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.oEO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oEO).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.oEO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oEO).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.oEO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oEO).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.oEO instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.oEO).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.oEO instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.oEO).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void a(Exception exc, long j) {
        this.oEN.oDX = j;
        this.oEN.ehv();
        this.oEN.A(exc);
        this.oEN.a(this.oEy);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.oEN.oDX = j;
        this.oEN.ehv();
        this.oEN.oDV = 0;
        this.oEN.a(this.oEy);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void hV(long j) {
        this.oEN.oDX = j;
        this.oEN.ehv();
        this.oEN.oDV = -12;
        this.oEN.a(this.oEy);
    }
}
