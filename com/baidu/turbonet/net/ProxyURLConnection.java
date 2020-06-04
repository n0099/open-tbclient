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
    private ProxyConfig meP;
    private TurbonetEngine mfD;
    private a mfT;
    private HttpURLConnection mfU;
    private d mfV;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.meP.dqL()) {
            this.mfV.addRequestProperty(str, str2);
        } else {
            this.mfU.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.meP.toString());
        if (!this.meP.dqL()) {
            this.mfV.connect();
            return;
        }
        try {
            this.mfU.connect();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.meP.dqL() ? this.mfV.getConnectTimeout() : this.mfU.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.meP.dqL()) {
            return this.mfV.getContent();
        }
        try {
            long contentLength = this.mfU.getContentLength();
            this.mfT.mfc = contentLength;
            onComplete(contentLength);
            return this.mfU.getContent();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.meP.dqL()) {
            return this.mfV.getContent(clsArr);
        }
        try {
            long contentLength = this.mfU.getContentLength();
            this.mfT.mfc = contentLength;
            onComplete(contentLength);
            return this.mfU.getContent(clsArr);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.meP.dqL() ? this.mfV.getContentEncoding() : this.mfU.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.meP.dqL() ? this.mfV.getContentLength() : this.mfU.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.meP.dqL() ? this.mfV.getContentType() : this.mfU.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.meP.dqL() ? this.mfV.getDate() : this.mfU.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.meP.dqL() ? this.mfV.getDefaultUseCaches() : this.mfU.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.meP.dqL() ? this.mfV.getDoInput() : this.mfU.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.meP.dqL() ? this.mfV.getDoOutput() : this.mfU.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.meP.dqL() ? this.mfV.getExpiration() : this.mfU.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.meP.dqL()) {
            return this.mfV.getHeaderField(str);
        }
        String headerField = this.mfU.getHeaderField(str);
        this.mfT.dqM();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.meP.dqL()) {
            return this.mfV.getHeaderField(i);
        }
        return this.mfU.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.meP.dqL() ? this.mfV.getHeaderFieldInt(str, i) : this.mfU.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.meP.dqL() ? this.mfV.getHeaderFieldDate(str, j) : this.mfU.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.meP.dqL() ? this.mfV.getHeaderFieldKey(i) : this.mfU.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.meP.dqL()) {
            return this.mfV.getHeaderFields();
        }
        return this.mfU.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.meP.dqL() ? this.mfV.getIfModifiedSince() : this.mfU.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.meP.toString());
        if (!this.meP.dqL()) {
            return this.mfV.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.mfU.getInputStream(), this);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.meP.dqL() ? this.mfV.getOutputStream() : this.mfU.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.meP.dqL() ? this.mfV.getLastModified() : this.mfU.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.meP.dqL() ? this.mfV.getPermission() : this.mfU.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.meP.dqL() ? this.mfV.getReadTimeout() : this.mfU.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.meP.dqL() ? this.mfV.getRequestProperties() : this.mfU.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.meP.dqL() ? this.mfV.getRequestProperty(str) : this.mfU.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.meP.dqL() ? this.mfV.getURL() : this.mfU.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.meP.dqL() ? this.mfV.getUseCaches() : this.mfU.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.meP.dqL()) {
            this.mfV.setConnectTimeout(i);
        } else {
            this.mfU.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.meP.dqL()) {
            this.mfV.setDefaultUseCaches(z);
        } else {
            this.mfU.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.meP.dqL()) {
            this.mfV.setDoInput(z);
        } else {
            this.mfU.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.meP.dqL()) {
            this.mfV.setDoOutput(z);
        } else {
            this.mfU.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.meP.dqL()) {
            this.mfV.setIfModifiedSince(j);
        } else {
            this.mfU.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.meP.dqL()) {
            this.mfV.setReadTimeout(i);
        } else {
            this.mfU.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.meP.dqL()) {
            this.mfV.setRequestProperty(str, str2);
        } else {
            this.mfU.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.meP.dqL()) {
            this.mfV.setUseCaches(z);
        } else {
            this.mfU.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.meP.toString());
        if (!this.meP.dqL()) {
            this.mfV.disconnect();
        } else {
            this.mfU.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.meP.dqL() ? this.mfV.getErrorStream() : this.mfU.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.meP.dqL() ? this.mfV.getInstanceFollowRedirects() : this.mfU.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.meP.dqL() ? this.mfV.getRequestMethod() : this.mfU.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.meP.dqL()) {
            responseCode = this.mfV.getResponseCode();
        } else {
            try {
                responseCode = this.mfU.getResponseCode();
                this.mfT.mfb = responseCode;
                this.mfT.dqM();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                a(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.meP.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.meP.dqL()) {
            responseMessage = this.mfV.getResponseMessage();
        } else {
            responseMessage = this.mfU.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.meP.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.meP.dqL()) {
            this.mfV.setChunkedStreamingMode(i);
        } else {
            this.mfU.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.meP.dqL()) {
            this.mfV.setFixedLengthStreamingMode(i);
        } else {
            this.mfU.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.meP.dqL()) {
            this.mfV.setFixedLengthStreamingMode(j);
        } else {
            this.mfU.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.meP.dqL()) {
            this.mfV.setInstanceFollowRedirects(z);
        } else {
            this.mfU.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.meP.dqL()) {
            this.mfV.setRequestMethod(str);
            return;
        }
        this.mfU.setRequestMethod(str);
        this.mfT.cVs = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.meP.dqL() ? this.mfV.usingProxy() : this.mfU.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.mfU instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mfU).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.mfU instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mfU).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.mfU instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mfU).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.mfU instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mfU).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.mfU instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mfU).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.mfU instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mfU).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.mfU instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mfU).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.mfU instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.mfU).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.mfU instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.mfU).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void a(Exception exc, long j) {
        this.mfT.mfc = j;
        this.mfT.dqN();
        this.mfT.w(exc);
        this.mfT.a(this.mfD);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.mfT.mfc = j;
        this.mfT.dqN();
        this.mfT.mfa = 0;
        this.mfT.a(this.mfD);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void fy(long j) {
        this.mfT.mfc = j;
        this.mfT.dqN();
        this.mfT.mfa = -12;
        this.mfT.a(this.mfD);
    }
}
