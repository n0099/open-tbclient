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
/* loaded from: classes17.dex */
public class ProxyURLConnection extends HttpsURLConnection implements com.baidu.turbonet.net.proxy.b {
    private ProxyConfig nBB;
    private a nCF;
    private HttpURLConnection nCG;
    private d nCH;
    private TurbonetEngine nCp;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.nBB.dSo()) {
            this.nCH.addRequestProperty(str, str2);
        } else {
            this.nCG.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.nBB.toString());
        if (!this.nBB.dSo()) {
            this.nCH.connect();
            return;
        }
        try {
            this.nCG.connect();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.nBB.dSo() ? this.nCH.getConnectTimeout() : this.nCG.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.nBB.dSo()) {
            return this.nCH.getContent();
        }
        try {
            long contentLength = this.nCG.getContentLength();
            this.nCF.nBO = contentLength;
            onComplete(contentLength);
            return this.nCG.getContent();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.nBB.dSo()) {
            return this.nCH.getContent(clsArr);
        }
        try {
            long contentLength = this.nCG.getContentLength();
            this.nCF.nBO = contentLength;
            onComplete(contentLength);
            return this.nCG.getContent(clsArr);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.nBB.dSo() ? this.nCH.getContentEncoding() : this.nCG.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.nBB.dSo() ? this.nCH.getContentLength() : this.nCG.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.nBB.dSo() ? this.nCH.getContentType() : this.nCG.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.nBB.dSo() ? this.nCH.getDate() : this.nCG.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.nBB.dSo() ? this.nCH.getDefaultUseCaches() : this.nCG.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.nBB.dSo() ? this.nCH.getDoInput() : this.nCG.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.nBB.dSo() ? this.nCH.getDoOutput() : this.nCG.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.nBB.dSo() ? this.nCH.getExpiration() : this.nCG.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.nBB.dSo()) {
            return this.nCH.getHeaderField(str);
        }
        String headerField = this.nCG.getHeaderField(str);
        this.nCF.dSp();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.nBB.dSo()) {
            return this.nCH.getHeaderField(i);
        }
        return this.nCG.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.nBB.dSo() ? this.nCH.getHeaderFieldInt(str, i) : this.nCG.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.nBB.dSo() ? this.nCH.getHeaderFieldDate(str, j) : this.nCG.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.nBB.dSo() ? this.nCH.getHeaderFieldKey(i) : this.nCG.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.nBB.dSo()) {
            return this.nCH.getHeaderFields();
        }
        return this.nCG.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.nBB.dSo() ? this.nCH.getIfModifiedSince() : this.nCG.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.nBB.toString());
        if (!this.nBB.dSo()) {
            return this.nCH.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.nCG.getInputStream(), this);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.nBB.dSo() ? this.nCH.getOutputStream() : this.nCG.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.nBB.dSo() ? this.nCH.getLastModified() : this.nCG.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.nBB.dSo() ? this.nCH.getPermission() : this.nCG.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.nBB.dSo() ? this.nCH.getReadTimeout() : this.nCG.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.nBB.dSo() ? this.nCH.getRequestProperties() : this.nCG.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.nBB.dSo() ? this.nCH.getRequestProperty(str) : this.nCG.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.nBB.dSo() ? this.nCH.getURL() : this.nCG.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.nBB.dSo() ? this.nCH.getUseCaches() : this.nCG.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.nBB.dSo()) {
            this.nCH.setConnectTimeout(i);
        } else {
            this.nCG.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.nBB.dSo()) {
            this.nCH.setDefaultUseCaches(z);
        } else {
            this.nCG.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.nBB.dSo()) {
            this.nCH.setDoInput(z);
        } else {
            this.nCG.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.nBB.dSo()) {
            this.nCH.setDoOutput(z);
        } else {
            this.nCG.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.nBB.dSo()) {
            this.nCH.setIfModifiedSince(j);
        } else {
            this.nCG.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.nBB.dSo()) {
            this.nCH.setReadTimeout(i);
        } else {
            this.nCG.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.nBB.dSo()) {
            this.nCH.setRequestProperty(str, str2);
        } else {
            this.nCG.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.nBB.dSo()) {
            this.nCH.setUseCaches(z);
        } else {
            this.nCG.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.nBB.toString());
        if (!this.nBB.dSo()) {
            this.nCH.disconnect();
        } else {
            this.nCG.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.nBB.dSo() ? this.nCH.getErrorStream() : this.nCG.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.nBB.dSo() ? this.nCH.getInstanceFollowRedirects() : this.nCG.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.nBB.dSo() ? this.nCH.getRequestMethod() : this.nCG.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.nBB.dSo()) {
            responseCode = this.nCH.getResponseCode();
        } else {
            try {
                responseCode = this.nCG.getResponseCode();
                this.nCF.nBN = responseCode;
                this.nCF.dSp();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                a(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.nBB.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.nBB.dSo()) {
            responseMessage = this.nCH.getResponseMessage();
        } else {
            responseMessage = this.nCG.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.nBB.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.nBB.dSo()) {
            this.nCH.setChunkedStreamingMode(i);
        } else {
            this.nCG.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.nBB.dSo()) {
            this.nCH.setFixedLengthStreamingMode(i);
        } else {
            this.nCG.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.nBB.dSo()) {
            this.nCH.setFixedLengthStreamingMode(j);
        } else {
            this.nCG.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.nBB.dSo()) {
            this.nCH.setInstanceFollowRedirects(z);
        } else {
            this.nCG.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.nBB.dSo()) {
            this.nCH.setRequestMethod(str);
            return;
        }
        this.nCG.setRequestMethod(str);
        this.nCF.dEf = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.nBB.dSo() ? this.nCH.usingProxy() : this.nCG.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.nCG instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.nCG).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.nCG instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.nCG).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.nCG instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.nCG).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.nCG instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.nCG).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.nCG instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.nCG).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.nCG instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.nCG).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.nCG instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.nCG).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.nCG instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.nCG).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.nCG instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.nCG).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void a(Exception exc, long j) {
        this.nCF.nBO = j;
        this.nCF.dSq();
        this.nCF.A(exc);
        this.nCF.a(this.nCp);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.nCF.nBO = j;
        this.nCF.dSq();
        this.nCF.nBM = 0;
        this.nCF.a(this.nCp);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void gK(long j) {
        this.nCF.nBO = j;
        this.nCF.dSq();
        this.nCF.nBM = -12;
        this.nCF.a(this.nCp);
    }
}
