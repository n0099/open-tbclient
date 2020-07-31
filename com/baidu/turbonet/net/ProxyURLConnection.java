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
/* loaded from: classes19.dex */
public class ProxyURLConnection extends HttpsURLConnection implements com.baidu.turbonet.net.proxy.b {
    private ProxyConfig mIQ;
    private TurbonetEngine mJE;
    private a mJV;
    private HttpURLConnection mJW;
    private d mJX;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.mIQ.dyH()) {
            this.mJX.addRequestProperty(str, str2);
        } else {
            this.mJW.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.mIQ.toString());
        if (!this.mIQ.dyH()) {
            this.mJX.connect();
            return;
        }
        try {
            this.mJW.connect();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.mIQ.dyH() ? this.mJX.getConnectTimeout() : this.mJW.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.mIQ.dyH()) {
            return this.mJX.getContent();
        }
        try {
            long contentLength = this.mJW.getContentLength();
            this.mJV.mJd = contentLength;
            onComplete(contentLength);
            return this.mJW.getContent();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.mIQ.dyH()) {
            return this.mJX.getContent(clsArr);
        }
        try {
            long contentLength = this.mJW.getContentLength();
            this.mJV.mJd = contentLength;
            onComplete(contentLength);
            return this.mJW.getContent(clsArr);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.mIQ.dyH() ? this.mJX.getContentEncoding() : this.mJW.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.mIQ.dyH() ? this.mJX.getContentLength() : this.mJW.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.mIQ.dyH() ? this.mJX.getContentType() : this.mJW.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.mIQ.dyH() ? this.mJX.getDate() : this.mJW.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.mIQ.dyH() ? this.mJX.getDefaultUseCaches() : this.mJW.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.mIQ.dyH() ? this.mJX.getDoInput() : this.mJW.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.mIQ.dyH() ? this.mJX.getDoOutput() : this.mJW.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.mIQ.dyH() ? this.mJX.getExpiration() : this.mJW.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.mIQ.dyH()) {
            return this.mJX.getHeaderField(str);
        }
        String headerField = this.mJW.getHeaderField(str);
        this.mJV.dyI();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.mIQ.dyH()) {
            return this.mJX.getHeaderField(i);
        }
        return this.mJW.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.mIQ.dyH() ? this.mJX.getHeaderFieldInt(str, i) : this.mJW.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.mIQ.dyH() ? this.mJX.getHeaderFieldDate(str, j) : this.mJW.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.mIQ.dyH() ? this.mJX.getHeaderFieldKey(i) : this.mJW.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.mIQ.dyH()) {
            return this.mJX.getHeaderFields();
        }
        return this.mJW.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.mIQ.dyH() ? this.mJX.getIfModifiedSince() : this.mJW.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.mIQ.toString());
        if (!this.mIQ.dyH()) {
            return this.mJX.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.mJW.getInputStream(), this);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.mIQ.dyH() ? this.mJX.getOutputStream() : this.mJW.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.mIQ.dyH() ? this.mJX.getLastModified() : this.mJW.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.mIQ.dyH() ? this.mJX.getPermission() : this.mJW.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.mIQ.dyH() ? this.mJX.getReadTimeout() : this.mJW.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.mIQ.dyH() ? this.mJX.getRequestProperties() : this.mJW.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.mIQ.dyH() ? this.mJX.getRequestProperty(str) : this.mJW.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.mIQ.dyH() ? this.mJX.getURL() : this.mJW.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.mIQ.dyH() ? this.mJX.getUseCaches() : this.mJW.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.mIQ.dyH()) {
            this.mJX.setConnectTimeout(i);
        } else {
            this.mJW.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.mIQ.dyH()) {
            this.mJX.setDefaultUseCaches(z);
        } else {
            this.mJW.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.mIQ.dyH()) {
            this.mJX.setDoInput(z);
        } else {
            this.mJW.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.mIQ.dyH()) {
            this.mJX.setDoOutput(z);
        } else {
            this.mJW.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.mIQ.dyH()) {
            this.mJX.setIfModifiedSince(j);
        } else {
            this.mJW.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.mIQ.dyH()) {
            this.mJX.setReadTimeout(i);
        } else {
            this.mJW.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.mIQ.dyH()) {
            this.mJX.setRequestProperty(str, str2);
        } else {
            this.mJW.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.mIQ.dyH()) {
            this.mJX.setUseCaches(z);
        } else {
            this.mJW.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.mIQ.toString());
        if (!this.mIQ.dyH()) {
            this.mJX.disconnect();
        } else {
            this.mJW.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.mIQ.dyH() ? this.mJX.getErrorStream() : this.mJW.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.mIQ.dyH() ? this.mJX.getInstanceFollowRedirects() : this.mJW.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.mIQ.dyH() ? this.mJX.getRequestMethod() : this.mJW.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.mIQ.dyH()) {
            responseCode = this.mJX.getResponseCode();
        } else {
            try {
                responseCode = this.mJW.getResponseCode();
                this.mJV.mJc = responseCode;
                this.mJV.dyI();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                a(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.mIQ.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.mIQ.dyH()) {
            responseMessage = this.mJX.getResponseMessage();
        } else {
            responseMessage = this.mJW.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.mIQ.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.mIQ.dyH()) {
            this.mJX.setChunkedStreamingMode(i);
        } else {
            this.mJW.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.mIQ.dyH()) {
            this.mJX.setFixedLengthStreamingMode(i);
        } else {
            this.mJW.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.mIQ.dyH()) {
            this.mJX.setFixedLengthStreamingMode(j);
        } else {
            this.mJW.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.mIQ.dyH()) {
            this.mJX.setInstanceFollowRedirects(z);
        } else {
            this.mJW.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.mIQ.dyH()) {
            this.mJX.setRequestMethod(str);
            return;
        }
        this.mJW.setRequestMethod(str);
        this.mJV.dfN = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.mIQ.dyH() ? this.mJX.usingProxy() : this.mJW.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.mJW instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mJW).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.mJW instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mJW).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.mJW instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mJW).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.mJW instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mJW).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.mJW instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mJW).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.mJW instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mJW).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.mJW instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mJW).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.mJW instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.mJW).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.mJW instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.mJW).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void a(Exception exc, long j) {
        this.mJV.mJd = j;
        this.mJV.dyJ();
        this.mJV.w(exc);
        this.mJV.a(this.mJE);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.mJV.mJd = j;
        this.mJV.dyJ();
        this.mJV.mJb = 0;
        this.mJV.a(this.mJE);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void fQ(long j) {
        this.mJV.mJd = j;
        this.mJV.dyJ();
        this.mJV.mJb = -12;
        this.mJV.a(this.mJE);
    }
}
