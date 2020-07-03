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
    private ProxyConfig mAE;
    private a mBK;
    private HttpURLConnection mBL;
    private d mBM;
    private TurbonetEngine mBt;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.mAE.dvq()) {
            this.mBM.addRequestProperty(str, str2);
        } else {
            this.mBL.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.mAE.toString());
        if (!this.mAE.dvq()) {
            this.mBM.connect();
            return;
        }
        try {
            this.mBL.connect();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.mAE.dvq() ? this.mBM.getConnectTimeout() : this.mBL.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.mAE.dvq()) {
            return this.mBM.getContent();
        }
        try {
            long contentLength = this.mBL.getContentLength();
            this.mBK.mAR = contentLength;
            onComplete(contentLength);
            return this.mBL.getContent();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.mAE.dvq()) {
            return this.mBM.getContent(clsArr);
        }
        try {
            long contentLength = this.mBL.getContentLength();
            this.mBK.mAR = contentLength;
            onComplete(contentLength);
            return this.mBL.getContent(clsArr);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.mAE.dvq() ? this.mBM.getContentEncoding() : this.mBL.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.mAE.dvq() ? this.mBM.getContentLength() : this.mBL.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.mAE.dvq() ? this.mBM.getContentType() : this.mBL.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.mAE.dvq() ? this.mBM.getDate() : this.mBL.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.mAE.dvq() ? this.mBM.getDefaultUseCaches() : this.mBL.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.mAE.dvq() ? this.mBM.getDoInput() : this.mBL.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.mAE.dvq() ? this.mBM.getDoOutput() : this.mBL.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.mAE.dvq() ? this.mBM.getExpiration() : this.mBL.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.mAE.dvq()) {
            return this.mBM.getHeaderField(str);
        }
        String headerField = this.mBL.getHeaderField(str);
        this.mBK.dvr();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.mAE.dvq()) {
            return this.mBM.getHeaderField(i);
        }
        return this.mBL.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.mAE.dvq() ? this.mBM.getHeaderFieldInt(str, i) : this.mBL.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.mAE.dvq() ? this.mBM.getHeaderFieldDate(str, j) : this.mBL.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.mAE.dvq() ? this.mBM.getHeaderFieldKey(i) : this.mBL.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.mAE.dvq()) {
            return this.mBM.getHeaderFields();
        }
        return this.mBL.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.mAE.dvq() ? this.mBM.getIfModifiedSince() : this.mBL.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.mAE.toString());
        if (!this.mAE.dvq()) {
            return this.mBM.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.mBL.getInputStream(), this);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.mAE.dvq() ? this.mBM.getOutputStream() : this.mBL.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.mAE.dvq() ? this.mBM.getLastModified() : this.mBL.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.mAE.dvq() ? this.mBM.getPermission() : this.mBL.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.mAE.dvq() ? this.mBM.getReadTimeout() : this.mBL.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.mAE.dvq() ? this.mBM.getRequestProperties() : this.mBL.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.mAE.dvq() ? this.mBM.getRequestProperty(str) : this.mBL.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.mAE.dvq() ? this.mBM.getURL() : this.mBL.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.mAE.dvq() ? this.mBM.getUseCaches() : this.mBL.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.mAE.dvq()) {
            this.mBM.setConnectTimeout(i);
        } else {
            this.mBL.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.mAE.dvq()) {
            this.mBM.setDefaultUseCaches(z);
        } else {
            this.mBL.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.mAE.dvq()) {
            this.mBM.setDoInput(z);
        } else {
            this.mBL.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.mAE.dvq()) {
            this.mBM.setDoOutput(z);
        } else {
            this.mBL.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.mAE.dvq()) {
            this.mBM.setIfModifiedSince(j);
        } else {
            this.mBL.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.mAE.dvq()) {
            this.mBM.setReadTimeout(i);
        } else {
            this.mBL.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.mAE.dvq()) {
            this.mBM.setRequestProperty(str, str2);
        } else {
            this.mBL.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.mAE.dvq()) {
            this.mBM.setUseCaches(z);
        } else {
            this.mBL.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.mAE.toString());
        if (!this.mAE.dvq()) {
            this.mBM.disconnect();
        } else {
            this.mBL.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.mAE.dvq() ? this.mBM.getErrorStream() : this.mBL.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.mAE.dvq() ? this.mBM.getInstanceFollowRedirects() : this.mBL.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.mAE.dvq() ? this.mBM.getRequestMethod() : this.mBL.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.mAE.dvq()) {
            responseCode = this.mBM.getResponseCode();
        } else {
            try {
                responseCode = this.mBL.getResponseCode();
                this.mBK.mAQ = responseCode;
                this.mBK.dvr();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                a(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.mAE.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.mAE.dvq()) {
            responseMessage = this.mBM.getResponseMessage();
        } else {
            responseMessage = this.mBL.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.mAE.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.mAE.dvq()) {
            this.mBM.setChunkedStreamingMode(i);
        } else {
            this.mBL.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.mAE.dvq()) {
            this.mBM.setFixedLengthStreamingMode(i);
        } else {
            this.mBL.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.mAE.dvq()) {
            this.mBM.setFixedLengthStreamingMode(j);
        } else {
            this.mBL.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.mAE.dvq()) {
            this.mBM.setInstanceFollowRedirects(z);
        } else {
            this.mBL.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.mAE.dvq()) {
            this.mBM.setRequestMethod(str);
            return;
        }
        this.mBL.setRequestMethod(str);
        this.mBK.dac = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.mAE.dvq() ? this.mBM.usingProxy() : this.mBL.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.mBL instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mBL).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.mBL instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mBL).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.mBL instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mBL).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.mBL instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mBL).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.mBL instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mBL).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.mBL instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mBL).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.mBL instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mBL).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.mBL instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.mBL).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.mBL instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.mBL).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void a(Exception exc, long j) {
        this.mBK.mAR = j;
        this.mBK.dvs();
        this.mBK.w(exc);
        this.mBK.a(this.mBt);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.mBK.mAR = j;
        this.mBK.dvs();
        this.mBK.mAP = 0;
        this.mBK.a(this.mBt);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void fD(long j) {
        this.mBK.mAR = j;
        this.mBK.dvs();
        this.mBK.mAP = -12;
        this.mBK.a(this.mBt);
    }
}
