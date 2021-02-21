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
    private ProxyConfig oQH;
    private TurbonetEngine oRj;
    private a oRw;
    private HttpURLConnection oRx;
    private d oRy;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.oQH.egr()) {
            this.oRy.addRequestProperty(str, str2);
        } else {
            this.oRx.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.oQH.toString());
        if (!this.oQH.egr()) {
            this.oRy.connect();
            return;
        }
        try {
            this.oRx.connect();
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.oQH.egr() ? this.oRy.getConnectTimeout() : this.oRx.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.oQH.egr()) {
            return this.oRy.getContent();
        }
        try {
            long contentLength = this.oRx.getContentLength();
            this.oRw.oQT = contentLength;
            onComplete(contentLength);
            return this.oRx.getContent();
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.oQH.egr()) {
            return this.oRy.getContent(clsArr);
        }
        try {
            long contentLength = this.oRx.getContentLength();
            this.oRw.oQT = contentLength;
            onComplete(contentLength);
            return this.oRx.getContent(clsArr);
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.oQH.egr() ? this.oRy.getContentEncoding() : this.oRx.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.oQH.egr() ? this.oRy.getContentLength() : this.oRx.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.oQH.egr() ? this.oRy.getContentType() : this.oRx.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.oQH.egr() ? this.oRy.getDate() : this.oRx.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.oQH.egr() ? this.oRy.getDefaultUseCaches() : this.oRx.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.oQH.egr() ? this.oRy.getDoInput() : this.oRx.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.oQH.egr() ? this.oRy.getDoOutput() : this.oRx.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.oQH.egr() ? this.oRy.getExpiration() : this.oRx.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.oQH.egr()) {
            return this.oRy.getHeaderField(str);
        }
        String headerField = this.oRx.getHeaderField(str);
        this.oRw.egs();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.oQH.egr()) {
            return this.oRy.getHeaderField(i);
        }
        return this.oRx.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.oQH.egr() ? this.oRy.getHeaderFieldInt(str, i) : this.oRx.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.oQH.egr() ? this.oRy.getHeaderFieldDate(str, j) : this.oRx.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.oQH.egr() ? this.oRy.getHeaderFieldKey(i) : this.oRx.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.oQH.egr()) {
            return this.oRy.getHeaderFields();
        }
        return this.oRx.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.oQH.egr() ? this.oRy.getIfModifiedSince() : this.oRx.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.oQH.toString());
        if (!this.oQH.egr()) {
            return this.oRy.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.oRx.getInputStream(), this);
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.oQH.egr() ? this.oRy.getOutputStream() : this.oRx.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.oQH.egr() ? this.oRy.getLastModified() : this.oRx.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.oQH.egr() ? this.oRy.getPermission() : this.oRx.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.oQH.egr() ? this.oRy.getReadTimeout() : this.oRx.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.oQH.egr() ? this.oRy.getRequestProperties() : this.oRx.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.oQH.egr() ? this.oRy.getRequestProperty(str) : this.oRx.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.oQH.egr() ? this.oRy.getURL() : this.oRx.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.oQH.egr() ? this.oRy.getUseCaches() : this.oRx.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.oQH.egr()) {
            this.oRy.setConnectTimeout(i);
        } else {
            this.oRx.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.oQH.egr()) {
            this.oRy.setDefaultUseCaches(z);
        } else {
            this.oRx.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.oQH.egr()) {
            this.oRy.setDoInput(z);
        } else {
            this.oRx.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.oQH.egr()) {
            this.oRy.setDoOutput(z);
        } else {
            this.oRx.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.oQH.egr()) {
            this.oRy.setIfModifiedSince(j);
        } else {
            this.oRx.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.oQH.egr()) {
            this.oRy.setReadTimeout(i);
        } else {
            this.oRx.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.oQH.egr()) {
            this.oRy.setRequestProperty(str, str2);
        } else {
            this.oRx.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.oQH.egr()) {
            this.oRy.setUseCaches(z);
        } else {
            this.oRx.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.oQH.toString());
        if (!this.oQH.egr()) {
            this.oRy.disconnect();
        } else {
            this.oRx.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.oQH.egr() ? this.oRy.getErrorStream() : this.oRx.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.oQH.egr() ? this.oRy.getInstanceFollowRedirects() : this.oRx.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.oQH.egr() ? this.oRy.getRequestMethod() : this.oRx.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.oQH.egr()) {
            responseCode = this.oRy.getResponseCode();
        } else {
            try {
                responseCode = this.oRx.getResponseCode();
                this.oRw.mHttpStatusCode = responseCode;
                this.oRw.egs();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                b(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.oQH.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.oQH.egr()) {
            responseMessage = this.oRy.getResponseMessage();
        } else {
            responseMessage = this.oRx.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.oQH.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.oQH.egr()) {
            this.oRy.setChunkedStreamingMode(i);
        } else {
            this.oRx.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.oQH.egr()) {
            this.oRy.setFixedLengthStreamingMode(i);
        } else {
            this.oRx.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.oQH.egr()) {
            this.oRy.setFixedLengthStreamingMode(j);
        } else {
            this.oRx.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.oQH.egr()) {
            this.oRy.setInstanceFollowRedirects(z);
        } else {
            this.oRx.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.oQH.egr()) {
            this.oRy.setRequestMethod(str);
            return;
        }
        this.oRx.setRequestMethod(str);
        this.oRw.mMethod = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.oQH.egr() ? this.oRy.usingProxy() : this.oRx.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.oRx instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oRx).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.oRx instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oRx).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.oRx instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oRx).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.oRx instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oRx).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.oRx instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oRx).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.oRx instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oRx).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.oRx instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oRx).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.oRx instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.oRx).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.oRx instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.oRx).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void b(Exception exc, long j) {
        this.oRw.oQT = j;
        this.oRw.egt();
        this.oRw.A(exc);
        this.oRw.a(this.oRj);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.oRw.oQT = j;
        this.oRw.egt();
        this.oRw.oQS = 0;
        this.oRw.a(this.oRj);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void hS(long j) {
        this.oRw.oQT = j;
        this.oRw.egt();
        this.oRw.oQS = -12;
        this.oRw.a(this.oRj);
    }
}
