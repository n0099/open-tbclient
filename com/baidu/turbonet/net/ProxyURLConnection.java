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
/* loaded from: classes6.dex */
public class ProxyURLConnection extends HttpsURLConnection implements com.baidu.turbonet.net.proxy.b {
    private TurbonetEngine oQJ;
    private a oQW;
    private HttpURLConnection oQX;
    private d oQY;
    private ProxyConfig oQh;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.oQh.egj()) {
            this.oQY.addRequestProperty(str, str2);
        } else {
            this.oQX.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.oQh.toString());
        if (!this.oQh.egj()) {
            this.oQY.connect();
            return;
        }
        try {
            this.oQX.connect();
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.oQh.egj() ? this.oQY.getConnectTimeout() : this.oQX.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.oQh.egj()) {
            return this.oQY.getContent();
        }
        try {
            long contentLength = this.oQX.getContentLength();
            this.oQW.oQt = contentLength;
            onComplete(contentLength);
            return this.oQX.getContent();
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.oQh.egj()) {
            return this.oQY.getContent(clsArr);
        }
        try {
            long contentLength = this.oQX.getContentLength();
            this.oQW.oQt = contentLength;
            onComplete(contentLength);
            return this.oQX.getContent(clsArr);
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.oQh.egj() ? this.oQY.getContentEncoding() : this.oQX.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.oQh.egj() ? this.oQY.getContentLength() : this.oQX.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.oQh.egj() ? this.oQY.getContentType() : this.oQX.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.oQh.egj() ? this.oQY.getDate() : this.oQX.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.oQh.egj() ? this.oQY.getDefaultUseCaches() : this.oQX.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.oQh.egj() ? this.oQY.getDoInput() : this.oQX.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.oQh.egj() ? this.oQY.getDoOutput() : this.oQX.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.oQh.egj() ? this.oQY.getExpiration() : this.oQX.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.oQh.egj()) {
            return this.oQY.getHeaderField(str);
        }
        String headerField = this.oQX.getHeaderField(str);
        this.oQW.egk();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.oQh.egj()) {
            return this.oQY.getHeaderField(i);
        }
        return this.oQX.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.oQh.egj() ? this.oQY.getHeaderFieldInt(str, i) : this.oQX.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.oQh.egj() ? this.oQY.getHeaderFieldDate(str, j) : this.oQX.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.oQh.egj() ? this.oQY.getHeaderFieldKey(i) : this.oQX.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.oQh.egj()) {
            return this.oQY.getHeaderFields();
        }
        return this.oQX.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.oQh.egj() ? this.oQY.getIfModifiedSince() : this.oQX.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.oQh.toString());
        if (!this.oQh.egj()) {
            return this.oQY.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.oQX.getInputStream(), this);
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.oQh.egj() ? this.oQY.getOutputStream() : this.oQX.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.oQh.egj() ? this.oQY.getLastModified() : this.oQX.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.oQh.egj() ? this.oQY.getPermission() : this.oQX.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.oQh.egj() ? this.oQY.getReadTimeout() : this.oQX.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.oQh.egj() ? this.oQY.getRequestProperties() : this.oQX.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.oQh.egj() ? this.oQY.getRequestProperty(str) : this.oQX.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.oQh.egj() ? this.oQY.getURL() : this.oQX.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.oQh.egj() ? this.oQY.getUseCaches() : this.oQX.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.oQh.egj()) {
            this.oQY.setConnectTimeout(i);
        } else {
            this.oQX.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.oQh.egj()) {
            this.oQY.setDefaultUseCaches(z);
        } else {
            this.oQX.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.oQh.egj()) {
            this.oQY.setDoInput(z);
        } else {
            this.oQX.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.oQh.egj()) {
            this.oQY.setDoOutput(z);
        } else {
            this.oQX.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.oQh.egj()) {
            this.oQY.setIfModifiedSince(j);
        } else {
            this.oQX.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.oQh.egj()) {
            this.oQY.setReadTimeout(i);
        } else {
            this.oQX.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.oQh.egj()) {
            this.oQY.setRequestProperty(str, str2);
        } else {
            this.oQX.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.oQh.egj()) {
            this.oQY.setUseCaches(z);
        } else {
            this.oQX.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.oQh.toString());
        if (!this.oQh.egj()) {
            this.oQY.disconnect();
        } else {
            this.oQX.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.oQh.egj() ? this.oQY.getErrorStream() : this.oQX.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.oQh.egj() ? this.oQY.getInstanceFollowRedirects() : this.oQX.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.oQh.egj() ? this.oQY.getRequestMethod() : this.oQX.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.oQh.egj()) {
            responseCode = this.oQY.getResponseCode();
        } else {
            try {
                responseCode = this.oQX.getResponseCode();
                this.oQW.mHttpStatusCode = responseCode;
                this.oQW.egk();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                b(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.oQh.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.oQh.egj()) {
            responseMessage = this.oQY.getResponseMessage();
        } else {
            responseMessage = this.oQX.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.oQh.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.oQh.egj()) {
            this.oQY.setChunkedStreamingMode(i);
        } else {
            this.oQX.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.oQh.egj()) {
            this.oQY.setFixedLengthStreamingMode(i);
        } else {
            this.oQX.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.oQh.egj()) {
            this.oQY.setFixedLengthStreamingMode(j);
        } else {
            this.oQX.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.oQh.egj()) {
            this.oQY.setInstanceFollowRedirects(z);
        } else {
            this.oQX.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.oQh.egj()) {
            this.oQY.setRequestMethod(str);
            return;
        }
        this.oQX.setRequestMethod(str);
        this.oQW.mMethod = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.oQh.egj() ? this.oQY.usingProxy() : this.oQX.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.oQX instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oQX).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.oQX instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oQX).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.oQX instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oQX).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.oQX instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oQX).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.oQX instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oQX).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.oQX instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oQX).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.oQX instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oQX).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.oQX instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.oQX).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.oQX instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.oQX).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void b(Exception exc, long j) {
        this.oQW.oQt = j;
        this.oQW.egl();
        this.oQW.A(exc);
        this.oQW.a(this.oQJ);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.oQW.oQt = j;
        this.oQW.egl();
        this.oQW.oQs = 0;
        this.oQW.a(this.oQJ);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void hS(long j) {
        this.oQW.oQt = j;
        this.oQW.egl();
        this.oQW.oQs = -12;
        this.oQW.a(this.oQJ);
    }
}
