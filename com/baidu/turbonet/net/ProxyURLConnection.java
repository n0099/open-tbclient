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
/* loaded from: classes15.dex */
public class ProxyURLConnection extends HttpsURLConnection implements com.baidu.turbonet.net.proxy.b {
    private TurbonetEngine nmS;
    private ProxyConfig nme;
    private a nnj;
    private HttpURLConnection nnk;
    private d nnl;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.nme.dOC()) {
            this.nnl.addRequestProperty(str, str2);
        } else {
            this.nnk.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.nme.toString());
        if (!this.nme.dOC()) {
            this.nnl.connect();
            return;
        }
        try {
            this.nnk.connect();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.nme.dOC() ? this.nnl.getConnectTimeout() : this.nnk.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.nme.dOC()) {
            return this.nnl.getContent();
        }
        try {
            long contentLength = this.nnk.getContentLength();
            this.nnj.nmr = contentLength;
            onComplete(contentLength);
            return this.nnk.getContent();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.nme.dOC()) {
            return this.nnl.getContent(clsArr);
        }
        try {
            long contentLength = this.nnk.getContentLength();
            this.nnj.nmr = contentLength;
            onComplete(contentLength);
            return this.nnk.getContent(clsArr);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.nme.dOC() ? this.nnl.getContentEncoding() : this.nnk.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.nme.dOC() ? this.nnl.getContentLength() : this.nnk.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.nme.dOC() ? this.nnl.getContentType() : this.nnk.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.nme.dOC() ? this.nnl.getDate() : this.nnk.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.nme.dOC() ? this.nnl.getDefaultUseCaches() : this.nnk.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.nme.dOC() ? this.nnl.getDoInput() : this.nnk.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.nme.dOC() ? this.nnl.getDoOutput() : this.nnk.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.nme.dOC() ? this.nnl.getExpiration() : this.nnk.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.nme.dOC()) {
            return this.nnl.getHeaderField(str);
        }
        String headerField = this.nnk.getHeaderField(str);
        this.nnj.dOD();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.nme.dOC()) {
            return this.nnl.getHeaderField(i);
        }
        return this.nnk.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.nme.dOC() ? this.nnl.getHeaderFieldInt(str, i) : this.nnk.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.nme.dOC() ? this.nnl.getHeaderFieldDate(str, j) : this.nnk.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.nme.dOC() ? this.nnl.getHeaderFieldKey(i) : this.nnk.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.nme.dOC()) {
            return this.nnl.getHeaderFields();
        }
        return this.nnk.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.nme.dOC() ? this.nnl.getIfModifiedSince() : this.nnk.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.nme.toString());
        if (!this.nme.dOC()) {
            return this.nnl.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.nnk.getInputStream(), this);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.nme.dOC() ? this.nnl.getOutputStream() : this.nnk.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.nme.dOC() ? this.nnl.getLastModified() : this.nnk.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.nme.dOC() ? this.nnl.getPermission() : this.nnk.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.nme.dOC() ? this.nnl.getReadTimeout() : this.nnk.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.nme.dOC() ? this.nnl.getRequestProperties() : this.nnk.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.nme.dOC() ? this.nnl.getRequestProperty(str) : this.nnk.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.nme.dOC() ? this.nnl.getURL() : this.nnk.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.nme.dOC() ? this.nnl.getUseCaches() : this.nnk.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.nme.dOC()) {
            this.nnl.setConnectTimeout(i);
        } else {
            this.nnk.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.nme.dOC()) {
            this.nnl.setDefaultUseCaches(z);
        } else {
            this.nnk.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.nme.dOC()) {
            this.nnl.setDoInput(z);
        } else {
            this.nnk.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.nme.dOC()) {
            this.nnl.setDoOutput(z);
        } else {
            this.nnk.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.nme.dOC()) {
            this.nnl.setIfModifiedSince(j);
        } else {
            this.nnk.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.nme.dOC()) {
            this.nnl.setReadTimeout(i);
        } else {
            this.nnk.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.nme.dOC()) {
            this.nnl.setRequestProperty(str, str2);
        } else {
            this.nnk.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.nme.dOC()) {
            this.nnl.setUseCaches(z);
        } else {
            this.nnk.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.nme.toString());
        if (!this.nme.dOC()) {
            this.nnl.disconnect();
        } else {
            this.nnk.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.nme.dOC() ? this.nnl.getErrorStream() : this.nnk.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.nme.dOC() ? this.nnl.getInstanceFollowRedirects() : this.nnk.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.nme.dOC() ? this.nnl.getRequestMethod() : this.nnk.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.nme.dOC()) {
            responseCode = this.nnl.getResponseCode();
        } else {
            try {
                responseCode = this.nnk.getResponseCode();
                this.nnj.nmq = responseCode;
                this.nnj.dOD();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                a(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.nme.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.nme.dOC()) {
            responseMessage = this.nnl.getResponseMessage();
        } else {
            responseMessage = this.nnk.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.nme.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.nme.dOC()) {
            this.nnl.setChunkedStreamingMode(i);
        } else {
            this.nnk.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.nme.dOC()) {
            this.nnl.setFixedLengthStreamingMode(i);
        } else {
            this.nnk.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.nme.dOC()) {
            this.nnl.setFixedLengthStreamingMode(j);
        } else {
            this.nnk.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.nme.dOC()) {
            this.nnl.setInstanceFollowRedirects(z);
        } else {
            this.nnk.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.nme.dOC()) {
            this.nnl.setRequestMethod(str);
            return;
        }
        this.nnk.setRequestMethod(str);
        this.nnj.dsc = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.nme.dOC() ? this.nnl.usingProxy() : this.nnk.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.nnk instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.nnk).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.nnk instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.nnk).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.nnk instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.nnk).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.nnk instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.nnk).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.nnk instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.nnk).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.nnk instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.nnk).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.nnk instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.nnk).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.nnk instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.nnk).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.nnk instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.nnk).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void a(Exception exc, long j) {
        this.nnj.nmr = j;
        this.nnj.dOE();
        this.nnj.A(exc);
        this.nnj.a(this.nmS);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.nnj.nmr = j;
        this.nnj.dOE();
        this.nnj.nmp = 0;
        this.nnj.a(this.nmS);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void gs(long j) {
        this.nnj.nmr = j;
        this.nnj.dOE();
        this.nnj.nmp = -12;
        this.nnj.a(this.nmS);
    }
}
