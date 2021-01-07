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
/* loaded from: classes5.dex */
public class ProxyURLConnection extends HttpsURLConnection implements com.baidu.turbonet.net.proxy.b {
    private ProxyConfig oKD;
    private TurbonetEngine oLf;
    private a oLs;
    private HttpURLConnection oLt;
    private d oLu;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.oKD.ehJ()) {
            this.oLu.addRequestProperty(str, str2);
        } else {
            this.oLt.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.oKD.toString());
        if (!this.oKD.ehJ()) {
            this.oLu.connect();
            return;
        }
        try {
            this.oLt.connect();
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.oKD.ehJ() ? this.oLu.getConnectTimeout() : this.oLt.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.oKD.ehJ()) {
            return this.oLu.getContent();
        }
        try {
            long contentLength = this.oLt.getContentLength();
            this.oLs.oKP = contentLength;
            onComplete(contentLength);
            return this.oLt.getContent();
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.oKD.ehJ()) {
            return this.oLu.getContent(clsArr);
        }
        try {
            long contentLength = this.oLt.getContentLength();
            this.oLs.oKP = contentLength;
            onComplete(contentLength);
            return this.oLt.getContent(clsArr);
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.oKD.ehJ() ? this.oLu.getContentEncoding() : this.oLt.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.oKD.ehJ() ? this.oLu.getContentLength() : this.oLt.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.oKD.ehJ() ? this.oLu.getContentType() : this.oLt.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.oKD.ehJ() ? this.oLu.getDate() : this.oLt.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.oKD.ehJ() ? this.oLu.getDefaultUseCaches() : this.oLt.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.oKD.ehJ() ? this.oLu.getDoInput() : this.oLt.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.oKD.ehJ() ? this.oLu.getDoOutput() : this.oLt.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.oKD.ehJ() ? this.oLu.getExpiration() : this.oLt.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.oKD.ehJ()) {
            return this.oLu.getHeaderField(str);
        }
        String headerField = this.oLt.getHeaderField(str);
        this.oLs.ehK();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.oKD.ehJ()) {
            return this.oLu.getHeaderField(i);
        }
        return this.oLt.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.oKD.ehJ() ? this.oLu.getHeaderFieldInt(str, i) : this.oLt.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.oKD.ehJ() ? this.oLu.getHeaderFieldDate(str, j) : this.oLt.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.oKD.ehJ() ? this.oLu.getHeaderFieldKey(i) : this.oLt.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.oKD.ehJ()) {
            return this.oLu.getHeaderFields();
        }
        return this.oLt.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.oKD.ehJ() ? this.oLu.getIfModifiedSince() : this.oLt.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.oKD.toString());
        if (!this.oKD.ehJ()) {
            return this.oLu.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.oLt.getInputStream(), this);
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.oKD.ehJ() ? this.oLu.getOutputStream() : this.oLt.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.oKD.ehJ() ? this.oLu.getLastModified() : this.oLt.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.oKD.ehJ() ? this.oLu.getPermission() : this.oLt.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.oKD.ehJ() ? this.oLu.getReadTimeout() : this.oLt.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.oKD.ehJ() ? this.oLu.getRequestProperties() : this.oLt.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.oKD.ehJ() ? this.oLu.getRequestProperty(str) : this.oLt.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.oKD.ehJ() ? this.oLu.getURL() : this.oLt.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.oKD.ehJ() ? this.oLu.getUseCaches() : this.oLt.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.oKD.ehJ()) {
            this.oLu.setConnectTimeout(i);
        } else {
            this.oLt.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.oKD.ehJ()) {
            this.oLu.setDefaultUseCaches(z);
        } else {
            this.oLt.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.oKD.ehJ()) {
            this.oLu.setDoInput(z);
        } else {
            this.oLt.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.oKD.ehJ()) {
            this.oLu.setDoOutput(z);
        } else {
            this.oLt.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.oKD.ehJ()) {
            this.oLu.setIfModifiedSince(j);
        } else {
            this.oLt.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.oKD.ehJ()) {
            this.oLu.setReadTimeout(i);
        } else {
            this.oLt.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.oKD.ehJ()) {
            this.oLu.setRequestProperty(str, str2);
        } else {
            this.oLt.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.oKD.ehJ()) {
            this.oLu.setUseCaches(z);
        } else {
            this.oLt.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.oKD.toString());
        if (!this.oKD.ehJ()) {
            this.oLu.disconnect();
        } else {
            this.oLt.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.oKD.ehJ() ? this.oLu.getErrorStream() : this.oLt.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.oKD.ehJ() ? this.oLu.getInstanceFollowRedirects() : this.oLt.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.oKD.ehJ() ? this.oLu.getRequestMethod() : this.oLt.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.oKD.ehJ()) {
            responseCode = this.oLu.getResponseCode();
        } else {
            try {
                responseCode = this.oLt.getResponseCode();
                this.oLs.mHttpStatusCode = responseCode;
                this.oLs.ehK();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                b(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.oKD.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.oKD.ehJ()) {
            responseMessage = this.oLu.getResponseMessage();
        } else {
            responseMessage = this.oLt.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.oKD.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.oKD.ehJ()) {
            this.oLu.setChunkedStreamingMode(i);
        } else {
            this.oLt.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.oKD.ehJ()) {
            this.oLu.setFixedLengthStreamingMode(i);
        } else {
            this.oLt.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.oKD.ehJ()) {
            this.oLu.setFixedLengthStreamingMode(j);
        } else {
            this.oLt.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.oKD.ehJ()) {
            this.oLu.setInstanceFollowRedirects(z);
        } else {
            this.oLt.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.oKD.ehJ()) {
            this.oLu.setRequestMethod(str);
            return;
        }
        this.oLt.setRequestMethod(str);
        this.oLs.mMethod = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.oKD.ehJ() ? this.oLu.usingProxy() : this.oLt.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.oLt instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oLt).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.oLt instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oLt).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.oLt instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oLt).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.oLt instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oLt).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.oLt instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oLt).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.oLt instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oLt).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.oLt instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oLt).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.oLt instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.oLt).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.oLt instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.oLt).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void b(Exception exc, long j) {
        this.oLs.oKP = j;
        this.oLs.ehL();
        this.oLs.A(exc);
        this.oLs.a(this.oLf);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.oLs.oKP = j;
        this.oLs.ehL();
        this.oLs.oKO = 0;
        this.oLs.a(this.oLf);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void hP(long j) {
        this.oLs.oKP = j;
        this.oLs.ehL();
        this.oLs.oKO = -12;
        this.oLs.a(this.oLf);
    }
}
