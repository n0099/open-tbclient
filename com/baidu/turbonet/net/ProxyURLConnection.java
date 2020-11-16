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
/* loaded from: classes12.dex */
public class ProxyURLConnection extends HttpsURLConnection implements com.baidu.turbonet.net.proxy.b {
    private ProxyConfig ooK;
    private a opP;
    private HttpURLConnection opQ;
    private d opR;
    private TurbonetEngine opz;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.ooK.ebN()) {
            this.opR.addRequestProperty(str, str2);
        } else {
            this.opQ.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.ooK.toString());
        if (!this.ooK.ebN()) {
            this.opR.connect();
            return;
        }
        try {
            this.opQ.connect();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.ooK.ebN() ? this.opR.getConnectTimeout() : this.opQ.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.ooK.ebN()) {
            return this.opR.getContent();
        }
        try {
            long contentLength = this.opQ.getContentLength();
            this.opP.ooX = contentLength;
            onComplete(contentLength);
            return this.opQ.getContent();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.ooK.ebN()) {
            return this.opR.getContent(clsArr);
        }
        try {
            long contentLength = this.opQ.getContentLength();
            this.opP.ooX = contentLength;
            onComplete(contentLength);
            return this.opQ.getContent(clsArr);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.ooK.ebN() ? this.opR.getContentEncoding() : this.opQ.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.ooK.ebN() ? this.opR.getContentLength() : this.opQ.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.ooK.ebN() ? this.opR.getContentType() : this.opQ.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.ooK.ebN() ? this.opR.getDate() : this.opQ.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.ooK.ebN() ? this.opR.getDefaultUseCaches() : this.opQ.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.ooK.ebN() ? this.opR.getDoInput() : this.opQ.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.ooK.ebN() ? this.opR.getDoOutput() : this.opQ.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.ooK.ebN() ? this.opR.getExpiration() : this.opQ.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.ooK.ebN()) {
            return this.opR.getHeaderField(str);
        }
        String headerField = this.opQ.getHeaderField(str);
        this.opP.ebO();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.ooK.ebN()) {
            return this.opR.getHeaderField(i);
        }
        return this.opQ.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.ooK.ebN() ? this.opR.getHeaderFieldInt(str, i) : this.opQ.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.ooK.ebN() ? this.opR.getHeaderFieldDate(str, j) : this.opQ.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.ooK.ebN() ? this.opR.getHeaderFieldKey(i) : this.opQ.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.ooK.ebN()) {
            return this.opR.getHeaderFields();
        }
        return this.opQ.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.ooK.ebN() ? this.opR.getIfModifiedSince() : this.opQ.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.ooK.toString());
        if (!this.ooK.ebN()) {
            return this.opR.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.opQ.getInputStream(), this);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.ooK.ebN() ? this.opR.getOutputStream() : this.opQ.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.ooK.ebN() ? this.opR.getLastModified() : this.opQ.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.ooK.ebN() ? this.opR.getPermission() : this.opQ.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.ooK.ebN() ? this.opR.getReadTimeout() : this.opQ.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.ooK.ebN() ? this.opR.getRequestProperties() : this.opQ.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.ooK.ebN() ? this.opR.getRequestProperty(str) : this.opQ.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.ooK.ebN() ? this.opR.getURL() : this.opQ.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.ooK.ebN() ? this.opR.getUseCaches() : this.opQ.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.ooK.ebN()) {
            this.opR.setConnectTimeout(i);
        } else {
            this.opQ.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.ooK.ebN()) {
            this.opR.setDefaultUseCaches(z);
        } else {
            this.opQ.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.ooK.ebN()) {
            this.opR.setDoInput(z);
        } else {
            this.opQ.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.ooK.ebN()) {
            this.opR.setDoOutput(z);
        } else {
            this.opQ.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.ooK.ebN()) {
            this.opR.setIfModifiedSince(j);
        } else {
            this.opQ.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.ooK.ebN()) {
            this.opR.setReadTimeout(i);
        } else {
            this.opQ.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.ooK.ebN()) {
            this.opR.setRequestProperty(str, str2);
        } else {
            this.opQ.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.ooK.ebN()) {
            this.opR.setUseCaches(z);
        } else {
            this.opQ.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.ooK.toString());
        if (!this.ooK.ebN()) {
            this.opR.disconnect();
        } else {
            this.opQ.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.ooK.ebN() ? this.opR.getErrorStream() : this.opQ.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.ooK.ebN() ? this.opR.getInstanceFollowRedirects() : this.opQ.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.ooK.ebN() ? this.opR.getRequestMethod() : this.opQ.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.ooK.ebN()) {
            responseCode = this.opR.getResponseCode();
        } else {
            try {
                responseCode = this.opQ.getResponseCode();
                this.opP.ooW = responseCode;
                this.opP.ebO();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                a(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.ooK.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.ooK.ebN()) {
            responseMessage = this.opR.getResponseMessage();
        } else {
            responseMessage = this.opQ.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.ooK.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.ooK.ebN()) {
            this.opR.setChunkedStreamingMode(i);
        } else {
            this.opQ.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.ooK.ebN()) {
            this.opR.setFixedLengthStreamingMode(i);
        } else {
            this.opQ.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.ooK.ebN()) {
            this.opR.setFixedLengthStreamingMode(j);
        } else {
            this.opQ.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.ooK.ebN()) {
            this.opR.setInstanceFollowRedirects(z);
        } else {
            this.opQ.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.ooK.ebN()) {
            this.opR.setRequestMethod(str);
            return;
        }
        this.opQ.setRequestMethod(str);
        this.opP.dQM = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.ooK.ebN() ? this.opR.usingProxy() : this.opQ.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.opQ instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.opQ).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.opQ instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.opQ).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.opQ instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.opQ).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.opQ instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.opQ).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.opQ instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.opQ).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.opQ instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.opQ).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.opQ instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.opQ).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.opQ instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.opQ).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.opQ instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.opQ).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void a(Exception exc, long j) {
        this.opP.ooX = j;
        this.opP.ebP();
        this.opP.A(exc);
        this.opP.a(this.opz);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.opP.ooX = j;
        this.opP.ebP();
        this.opP.ooV = 0;
        this.opP.a(this.opz);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void hq(long j) {
        this.opP.ooX = j;
        this.opP.ebP();
        this.opP.ooV = -12;
        this.opP.a(this.opz);
    }
}
