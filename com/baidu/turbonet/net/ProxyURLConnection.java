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
    private ProxyConfig nbN;
    private TurbonetEngine ncB;
    private a ncS;
    private HttpURLConnection ncT;
    private d ncU;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.nbN.dKv()) {
            this.ncU.addRequestProperty(str, str2);
        } else {
            this.ncT.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.nbN.toString());
        if (!this.nbN.dKv()) {
            this.ncU.connect();
            return;
        }
        try {
            this.ncT.connect();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.nbN.dKv() ? this.ncU.getConnectTimeout() : this.ncT.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.nbN.dKv()) {
            return this.ncU.getContent();
        }
        try {
            long contentLength = this.ncT.getContentLength();
            this.ncS.nca = contentLength;
            onComplete(contentLength);
            return this.ncT.getContent();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.nbN.dKv()) {
            return this.ncU.getContent(clsArr);
        }
        try {
            long contentLength = this.ncT.getContentLength();
            this.ncS.nca = contentLength;
            onComplete(contentLength);
            return this.ncT.getContent(clsArr);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.nbN.dKv() ? this.ncU.getContentEncoding() : this.ncT.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.nbN.dKv() ? this.ncU.getContentLength() : this.ncT.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.nbN.dKv() ? this.ncU.getContentType() : this.ncT.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.nbN.dKv() ? this.ncU.getDate() : this.ncT.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.nbN.dKv() ? this.ncU.getDefaultUseCaches() : this.ncT.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.nbN.dKv() ? this.ncU.getDoInput() : this.ncT.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.nbN.dKv() ? this.ncU.getDoOutput() : this.ncT.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.nbN.dKv() ? this.ncU.getExpiration() : this.ncT.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.nbN.dKv()) {
            return this.ncU.getHeaderField(str);
        }
        String headerField = this.ncT.getHeaderField(str);
        this.ncS.dKw();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.nbN.dKv()) {
            return this.ncU.getHeaderField(i);
        }
        return this.ncT.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.nbN.dKv() ? this.ncU.getHeaderFieldInt(str, i) : this.ncT.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.nbN.dKv() ? this.ncU.getHeaderFieldDate(str, j) : this.ncT.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.nbN.dKv() ? this.ncU.getHeaderFieldKey(i) : this.ncT.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.nbN.dKv()) {
            return this.ncU.getHeaderFields();
        }
        return this.ncT.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.nbN.dKv() ? this.ncU.getIfModifiedSince() : this.ncT.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.nbN.toString());
        if (!this.nbN.dKv()) {
            return this.ncU.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.ncT.getInputStream(), this);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.nbN.dKv() ? this.ncU.getOutputStream() : this.ncT.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.nbN.dKv() ? this.ncU.getLastModified() : this.ncT.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.nbN.dKv() ? this.ncU.getPermission() : this.ncT.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.nbN.dKv() ? this.ncU.getReadTimeout() : this.ncT.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.nbN.dKv() ? this.ncU.getRequestProperties() : this.ncT.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.nbN.dKv() ? this.ncU.getRequestProperty(str) : this.ncT.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.nbN.dKv() ? this.ncU.getURL() : this.ncT.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.nbN.dKv() ? this.ncU.getUseCaches() : this.ncT.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.nbN.dKv()) {
            this.ncU.setConnectTimeout(i);
        } else {
            this.ncT.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.nbN.dKv()) {
            this.ncU.setDefaultUseCaches(z);
        } else {
            this.ncT.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.nbN.dKv()) {
            this.ncU.setDoInput(z);
        } else {
            this.ncT.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.nbN.dKv()) {
            this.ncU.setDoOutput(z);
        } else {
            this.ncT.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.nbN.dKv()) {
            this.ncU.setIfModifiedSince(j);
        } else {
            this.ncT.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.nbN.dKv()) {
            this.ncU.setReadTimeout(i);
        } else {
            this.ncT.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.nbN.dKv()) {
            this.ncU.setRequestProperty(str, str2);
        } else {
            this.ncT.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.nbN.dKv()) {
            this.ncU.setUseCaches(z);
        } else {
            this.ncT.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.nbN.toString());
        if (!this.nbN.dKv()) {
            this.ncU.disconnect();
        } else {
            this.ncT.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.nbN.dKv() ? this.ncU.getErrorStream() : this.ncT.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.nbN.dKv() ? this.ncU.getInstanceFollowRedirects() : this.ncT.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.nbN.dKv() ? this.ncU.getRequestMethod() : this.ncT.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.nbN.dKv()) {
            responseCode = this.ncU.getResponseCode();
        } else {
            try {
                responseCode = this.ncT.getResponseCode();
                this.ncS.nbZ = responseCode;
                this.ncS.dKw();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                a(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.nbN.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.nbN.dKv()) {
            responseMessage = this.ncU.getResponseMessage();
        } else {
            responseMessage = this.ncT.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.nbN.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.nbN.dKv()) {
            this.ncU.setChunkedStreamingMode(i);
        } else {
            this.ncT.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.nbN.dKv()) {
            this.ncU.setFixedLengthStreamingMode(i);
        } else {
            this.ncT.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.nbN.dKv()) {
            this.ncU.setFixedLengthStreamingMode(j);
        } else {
            this.ncT.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.nbN.dKv()) {
            this.ncU.setInstanceFollowRedirects(z);
        } else {
            this.ncT.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.nbN.dKv()) {
            this.ncU.setRequestMethod(str);
            return;
        }
        this.ncT.setRequestMethod(str);
        this.ncS.dpW = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.nbN.dKv() ? this.ncU.usingProxy() : this.ncT.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.ncT instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ncT).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.ncT instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ncT).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.ncT instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ncT).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.ncT instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ncT).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.ncT instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ncT).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.ncT instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ncT).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.ncT instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.ncT).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.ncT instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.ncT).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.ncT instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.ncT).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void a(Exception exc, long j) {
        this.ncS.nca = j;
        this.ncS.dKx();
        this.ncS.A(exc);
        this.ncS.a(this.ncB);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.ncS.nca = j;
        this.ncS.dKx();
        this.ncS.nbY = 0;
        this.ncS.a(this.ncB);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void gc(long j) {
        this.ncS.nca = j;
        this.ncS.dKx();
        this.ncS.nbY = -12;
        this.ncS.a(this.ncB);
    }
}
