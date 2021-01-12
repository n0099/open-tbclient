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
/* loaded from: classes4.dex */
public class ProxyURLConnection extends HttpsURLConnection implements com.baidu.turbonet.net.proxy.b {
    private ProxyConfig oFY;
    private TurbonetEngine oGA;
    private a oGN;
    private HttpURLConnection oGO;
    private d oGP;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.oFY.edR()) {
            this.oGP.addRequestProperty(str, str2);
        } else {
            this.oGO.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.oFY.toString());
        if (!this.oFY.edR()) {
            this.oGP.connect();
            return;
        }
        try {
            this.oGO.connect();
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.oFY.edR() ? this.oGP.getConnectTimeout() : this.oGO.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.oFY.edR()) {
            return this.oGP.getContent();
        }
        try {
            long contentLength = this.oGO.getContentLength();
            this.oGN.oGk = contentLength;
            onComplete(contentLength);
            return this.oGO.getContent();
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.oFY.edR()) {
            return this.oGP.getContent(clsArr);
        }
        try {
            long contentLength = this.oGO.getContentLength();
            this.oGN.oGk = contentLength;
            onComplete(contentLength);
            return this.oGO.getContent(clsArr);
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.oFY.edR() ? this.oGP.getContentEncoding() : this.oGO.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.oFY.edR() ? this.oGP.getContentLength() : this.oGO.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.oFY.edR() ? this.oGP.getContentType() : this.oGO.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.oFY.edR() ? this.oGP.getDate() : this.oGO.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.oFY.edR() ? this.oGP.getDefaultUseCaches() : this.oGO.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.oFY.edR() ? this.oGP.getDoInput() : this.oGO.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.oFY.edR() ? this.oGP.getDoOutput() : this.oGO.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.oFY.edR() ? this.oGP.getExpiration() : this.oGO.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.oFY.edR()) {
            return this.oGP.getHeaderField(str);
        }
        String headerField = this.oGO.getHeaderField(str);
        this.oGN.edS();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.oFY.edR()) {
            return this.oGP.getHeaderField(i);
        }
        return this.oGO.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.oFY.edR() ? this.oGP.getHeaderFieldInt(str, i) : this.oGO.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.oFY.edR() ? this.oGP.getHeaderFieldDate(str, j) : this.oGO.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.oFY.edR() ? this.oGP.getHeaderFieldKey(i) : this.oGO.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.oFY.edR()) {
            return this.oGP.getHeaderFields();
        }
        return this.oGO.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.oFY.edR() ? this.oGP.getIfModifiedSince() : this.oGO.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.oFY.toString());
        if (!this.oFY.edR()) {
            return this.oGP.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.oGO.getInputStream(), this);
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.oFY.edR() ? this.oGP.getOutputStream() : this.oGO.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.oFY.edR() ? this.oGP.getLastModified() : this.oGO.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.oFY.edR() ? this.oGP.getPermission() : this.oGO.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.oFY.edR() ? this.oGP.getReadTimeout() : this.oGO.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.oFY.edR() ? this.oGP.getRequestProperties() : this.oGO.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.oFY.edR() ? this.oGP.getRequestProperty(str) : this.oGO.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.oFY.edR() ? this.oGP.getURL() : this.oGO.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.oFY.edR() ? this.oGP.getUseCaches() : this.oGO.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.oFY.edR()) {
            this.oGP.setConnectTimeout(i);
        } else {
            this.oGO.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.oFY.edR()) {
            this.oGP.setDefaultUseCaches(z);
        } else {
            this.oGO.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.oFY.edR()) {
            this.oGP.setDoInput(z);
        } else {
            this.oGO.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.oFY.edR()) {
            this.oGP.setDoOutput(z);
        } else {
            this.oGO.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.oFY.edR()) {
            this.oGP.setIfModifiedSince(j);
        } else {
            this.oGO.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.oFY.edR()) {
            this.oGP.setReadTimeout(i);
        } else {
            this.oGO.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.oFY.edR()) {
            this.oGP.setRequestProperty(str, str2);
        } else {
            this.oGO.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.oFY.edR()) {
            this.oGP.setUseCaches(z);
        } else {
            this.oGO.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.oFY.toString());
        if (!this.oFY.edR()) {
            this.oGP.disconnect();
        } else {
            this.oGO.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.oFY.edR() ? this.oGP.getErrorStream() : this.oGO.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.oFY.edR() ? this.oGP.getInstanceFollowRedirects() : this.oGO.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.oFY.edR() ? this.oGP.getRequestMethod() : this.oGO.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.oFY.edR()) {
            responseCode = this.oGP.getResponseCode();
        } else {
            try {
                responseCode = this.oGO.getResponseCode();
                this.oGN.mHttpStatusCode = responseCode;
                this.oGN.edS();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                b(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.oFY.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.oFY.edR()) {
            responseMessage = this.oGP.getResponseMessage();
        } else {
            responseMessage = this.oGO.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.oFY.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.oFY.edR()) {
            this.oGP.setChunkedStreamingMode(i);
        } else {
            this.oGO.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.oFY.edR()) {
            this.oGP.setFixedLengthStreamingMode(i);
        } else {
            this.oGO.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.oFY.edR()) {
            this.oGP.setFixedLengthStreamingMode(j);
        } else {
            this.oGO.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.oFY.edR()) {
            this.oGP.setInstanceFollowRedirects(z);
        } else {
            this.oGO.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.oFY.edR()) {
            this.oGP.setRequestMethod(str);
            return;
        }
        this.oGO.setRequestMethod(str);
        this.oGN.mMethod = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.oFY.edR() ? this.oGP.usingProxy() : this.oGO.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.oGO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oGO).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.oGO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oGO).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.oGO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oGO).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.oGO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oGO).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.oGO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oGO).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.oGO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oGO).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.oGO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oGO).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.oGO instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.oGO).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.oGO instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.oGO).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void b(Exception exc, long j) {
        this.oGN.oGk = j;
        this.oGN.edT();
        this.oGN.A(exc);
        this.oGN.a(this.oGA);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.oGN.oGk = j;
        this.oGN.edT();
        this.oGN.oGj = 0;
        this.oGN.a(this.oGA);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void hP(long j) {
        this.oGN.oGk = j;
        this.oGN.edT();
        this.oGN.oGj = -12;
        this.oGN.a(this.oGA);
    }
}
