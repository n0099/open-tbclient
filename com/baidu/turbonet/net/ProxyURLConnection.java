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
    private TurbonetEngine onV;
    private ProxyConfig onh;
    private a ool;
    private HttpURLConnection oom;
    private d oon;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.onh.ebO()) {
            this.oon.addRequestProperty(str, str2);
        } else {
            this.oom.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.onh.toString());
        if (!this.onh.ebO()) {
            this.oon.connect();
            return;
        }
        try {
            this.oom.connect();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.onh.ebO() ? this.oon.getConnectTimeout() : this.oom.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.onh.ebO()) {
            return this.oon.getContent();
        }
        try {
            long contentLength = this.oom.getContentLength();
            this.ool.onu = contentLength;
            onComplete(contentLength);
            return this.oom.getContent();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.onh.ebO()) {
            return this.oon.getContent(clsArr);
        }
        try {
            long contentLength = this.oom.getContentLength();
            this.ool.onu = contentLength;
            onComplete(contentLength);
            return this.oom.getContent(clsArr);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.onh.ebO() ? this.oon.getContentEncoding() : this.oom.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.onh.ebO() ? this.oon.getContentLength() : this.oom.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.onh.ebO() ? this.oon.getContentType() : this.oom.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.onh.ebO() ? this.oon.getDate() : this.oom.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.onh.ebO() ? this.oon.getDefaultUseCaches() : this.oom.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.onh.ebO() ? this.oon.getDoInput() : this.oom.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.onh.ebO() ? this.oon.getDoOutput() : this.oom.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.onh.ebO() ? this.oon.getExpiration() : this.oom.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.onh.ebO()) {
            return this.oon.getHeaderField(str);
        }
        String headerField = this.oom.getHeaderField(str);
        this.ool.ebP();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.onh.ebO()) {
            return this.oon.getHeaderField(i);
        }
        return this.oom.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.onh.ebO() ? this.oon.getHeaderFieldInt(str, i) : this.oom.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.onh.ebO() ? this.oon.getHeaderFieldDate(str, j) : this.oom.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.onh.ebO() ? this.oon.getHeaderFieldKey(i) : this.oom.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.onh.ebO()) {
            return this.oon.getHeaderFields();
        }
        return this.oom.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.onh.ebO() ? this.oon.getIfModifiedSince() : this.oom.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.onh.toString());
        if (!this.onh.ebO()) {
            return this.oon.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.oom.getInputStream(), this);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.onh.ebO() ? this.oon.getOutputStream() : this.oom.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.onh.ebO() ? this.oon.getLastModified() : this.oom.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.onh.ebO() ? this.oon.getPermission() : this.oom.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.onh.ebO() ? this.oon.getReadTimeout() : this.oom.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.onh.ebO() ? this.oon.getRequestProperties() : this.oom.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.onh.ebO() ? this.oon.getRequestProperty(str) : this.oom.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.onh.ebO() ? this.oon.getURL() : this.oom.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.onh.ebO() ? this.oon.getUseCaches() : this.oom.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.onh.ebO()) {
            this.oon.setConnectTimeout(i);
        } else {
            this.oom.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.onh.ebO()) {
            this.oon.setDefaultUseCaches(z);
        } else {
            this.oom.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.onh.ebO()) {
            this.oon.setDoInput(z);
        } else {
            this.oom.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.onh.ebO()) {
            this.oon.setDoOutput(z);
        } else {
            this.oom.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.onh.ebO()) {
            this.oon.setIfModifiedSince(j);
        } else {
            this.oom.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.onh.ebO()) {
            this.oon.setReadTimeout(i);
        } else {
            this.oom.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.onh.ebO()) {
            this.oon.setRequestProperty(str, str2);
        } else {
            this.oom.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.onh.ebO()) {
            this.oon.setUseCaches(z);
        } else {
            this.oom.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.onh.toString());
        if (!this.onh.ebO()) {
            this.oon.disconnect();
        } else {
            this.oom.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.onh.ebO() ? this.oon.getErrorStream() : this.oom.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.onh.ebO() ? this.oon.getInstanceFollowRedirects() : this.oom.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.onh.ebO() ? this.oon.getRequestMethod() : this.oom.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.onh.ebO()) {
            responseCode = this.oon.getResponseCode();
        } else {
            try {
                responseCode = this.oom.getResponseCode();
                this.ool.ont = responseCode;
                this.ool.ebP();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                a(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.onh.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.onh.ebO()) {
            responseMessage = this.oon.getResponseMessage();
        } else {
            responseMessage = this.oom.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.onh.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.onh.ebO()) {
            this.oon.setChunkedStreamingMode(i);
        } else {
            this.oom.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.onh.ebO()) {
            this.oon.setFixedLengthStreamingMode(i);
        } else {
            this.oom.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.onh.ebO()) {
            this.oon.setFixedLengthStreamingMode(j);
        } else {
            this.oom.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.onh.ebO()) {
            this.oon.setInstanceFollowRedirects(z);
        } else {
            this.oom.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.onh.ebO()) {
            this.oon.setRequestMethod(str);
            return;
        }
        this.oom.setRequestMethod(str);
        this.ool.dSu = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.onh.ebO() ? this.oon.usingProxy() : this.oom.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.oom instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oom).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.oom instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oom).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.oom instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oom).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.oom instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oom).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.oom instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oom).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.oom instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oom).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.oom instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oom).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.oom instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.oom).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.oom instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.oom).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void a(Exception exc, long j) {
        this.ool.onu = j;
        this.ool.ebQ();
        this.ool.A(exc);
        this.ool.a(this.onV);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.ool.onu = j;
        this.ool.ebQ();
        this.ool.ons = 0;
        this.ool.a(this.onV);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void hn(long j) {
        this.ool.onu = j;
        this.ool.ebQ();
        this.ool.ons = -12;
        this.ool.a(this.onV);
    }
}
