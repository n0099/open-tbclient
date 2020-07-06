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
    private ProxyConfig mAH;
    private a mBN;
    private HttpURLConnection mBO;
    private d mBP;
    private TurbonetEngine mBw;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.mAH.dvu()) {
            this.mBP.addRequestProperty(str, str2);
        } else {
            this.mBO.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.mAH.toString());
        if (!this.mAH.dvu()) {
            this.mBP.connect();
            return;
        }
        try {
            this.mBO.connect();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.mAH.dvu() ? this.mBP.getConnectTimeout() : this.mBO.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.mAH.dvu()) {
            return this.mBP.getContent();
        }
        try {
            long contentLength = this.mBO.getContentLength();
            this.mBN.mAU = contentLength;
            onComplete(contentLength);
            return this.mBO.getContent();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.mAH.dvu()) {
            return this.mBP.getContent(clsArr);
        }
        try {
            long contentLength = this.mBO.getContentLength();
            this.mBN.mAU = contentLength;
            onComplete(contentLength);
            return this.mBO.getContent(clsArr);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.mAH.dvu() ? this.mBP.getContentEncoding() : this.mBO.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.mAH.dvu() ? this.mBP.getContentLength() : this.mBO.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.mAH.dvu() ? this.mBP.getContentType() : this.mBO.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.mAH.dvu() ? this.mBP.getDate() : this.mBO.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.mAH.dvu() ? this.mBP.getDefaultUseCaches() : this.mBO.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.mAH.dvu() ? this.mBP.getDoInput() : this.mBO.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.mAH.dvu() ? this.mBP.getDoOutput() : this.mBO.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.mAH.dvu() ? this.mBP.getExpiration() : this.mBO.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.mAH.dvu()) {
            return this.mBP.getHeaderField(str);
        }
        String headerField = this.mBO.getHeaderField(str);
        this.mBN.dvv();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.mAH.dvu()) {
            return this.mBP.getHeaderField(i);
        }
        return this.mBO.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.mAH.dvu() ? this.mBP.getHeaderFieldInt(str, i) : this.mBO.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.mAH.dvu() ? this.mBP.getHeaderFieldDate(str, j) : this.mBO.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.mAH.dvu() ? this.mBP.getHeaderFieldKey(i) : this.mBO.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.mAH.dvu()) {
            return this.mBP.getHeaderFields();
        }
        return this.mBO.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.mAH.dvu() ? this.mBP.getIfModifiedSince() : this.mBO.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.mAH.toString());
        if (!this.mAH.dvu()) {
            return this.mBP.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.mBO.getInputStream(), this);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.mAH.dvu() ? this.mBP.getOutputStream() : this.mBO.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.mAH.dvu() ? this.mBP.getLastModified() : this.mBO.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.mAH.dvu() ? this.mBP.getPermission() : this.mBO.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.mAH.dvu() ? this.mBP.getReadTimeout() : this.mBO.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.mAH.dvu() ? this.mBP.getRequestProperties() : this.mBO.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.mAH.dvu() ? this.mBP.getRequestProperty(str) : this.mBO.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.mAH.dvu() ? this.mBP.getURL() : this.mBO.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.mAH.dvu() ? this.mBP.getUseCaches() : this.mBO.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.mAH.dvu()) {
            this.mBP.setConnectTimeout(i);
        } else {
            this.mBO.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.mAH.dvu()) {
            this.mBP.setDefaultUseCaches(z);
        } else {
            this.mBO.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.mAH.dvu()) {
            this.mBP.setDoInput(z);
        } else {
            this.mBO.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.mAH.dvu()) {
            this.mBP.setDoOutput(z);
        } else {
            this.mBO.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.mAH.dvu()) {
            this.mBP.setIfModifiedSince(j);
        } else {
            this.mBO.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.mAH.dvu()) {
            this.mBP.setReadTimeout(i);
        } else {
            this.mBO.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.mAH.dvu()) {
            this.mBP.setRequestProperty(str, str2);
        } else {
            this.mBO.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.mAH.dvu()) {
            this.mBP.setUseCaches(z);
        } else {
            this.mBO.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.mAH.toString());
        if (!this.mAH.dvu()) {
            this.mBP.disconnect();
        } else {
            this.mBO.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.mAH.dvu() ? this.mBP.getErrorStream() : this.mBO.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.mAH.dvu() ? this.mBP.getInstanceFollowRedirects() : this.mBO.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.mAH.dvu() ? this.mBP.getRequestMethod() : this.mBO.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.mAH.dvu()) {
            responseCode = this.mBP.getResponseCode();
        } else {
            try {
                responseCode = this.mBO.getResponseCode();
                this.mBN.mAT = responseCode;
                this.mBN.dvv();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                a(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.mAH.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.mAH.dvu()) {
            responseMessage = this.mBP.getResponseMessage();
        } else {
            responseMessage = this.mBO.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.mAH.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.mAH.dvu()) {
            this.mBP.setChunkedStreamingMode(i);
        } else {
            this.mBO.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.mAH.dvu()) {
            this.mBP.setFixedLengthStreamingMode(i);
        } else {
            this.mBO.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.mAH.dvu()) {
            this.mBP.setFixedLengthStreamingMode(j);
        } else {
            this.mBO.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.mAH.dvu()) {
            this.mBP.setInstanceFollowRedirects(z);
        } else {
            this.mBO.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.mAH.dvu()) {
            this.mBP.setRequestMethod(str);
            return;
        }
        this.mBO.setRequestMethod(str);
        this.mBN.dac = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.mAH.dvu() ? this.mBP.usingProxy() : this.mBO.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.mBO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mBO).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.mBO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mBO).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.mBO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mBO).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.mBO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mBO).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.mBO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mBO).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.mBO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mBO).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.mBO instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mBO).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.mBO instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.mBO).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.mBO instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.mBO).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void a(Exception exc, long j) {
        this.mBN.mAU = j;
        this.mBN.dvw();
        this.mBN.w(exc);
        this.mBN.a(this.mBw);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.mBN.mAU = j;
        this.mBN.dvw();
        this.mBN.mAS = 0;
        this.mBN.a(this.mBw);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void fD(long j) {
        this.mBN.mAU = j;
        this.mBN.dvw();
        this.mBN.mAS = -12;
        this.mBN.a(this.mBw);
    }
}
