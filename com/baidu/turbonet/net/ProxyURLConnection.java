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
    private ProxyConfig mIS;
    private TurbonetEngine mJG;
    private a mJX;
    private HttpURLConnection mJY;
    private d mJZ;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.mIS.dyI()) {
            this.mJZ.addRequestProperty(str, str2);
        } else {
            this.mJY.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.mIS.toString());
        if (!this.mIS.dyI()) {
            this.mJZ.connect();
            return;
        }
        try {
            this.mJY.connect();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.mIS.dyI() ? this.mJZ.getConnectTimeout() : this.mJY.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.mIS.dyI()) {
            return this.mJZ.getContent();
        }
        try {
            long contentLength = this.mJY.getContentLength();
            this.mJX.mJf = contentLength;
            onComplete(contentLength);
            return this.mJY.getContent();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.mIS.dyI()) {
            return this.mJZ.getContent(clsArr);
        }
        try {
            long contentLength = this.mJY.getContentLength();
            this.mJX.mJf = contentLength;
            onComplete(contentLength);
            return this.mJY.getContent(clsArr);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.mIS.dyI() ? this.mJZ.getContentEncoding() : this.mJY.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.mIS.dyI() ? this.mJZ.getContentLength() : this.mJY.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.mIS.dyI() ? this.mJZ.getContentType() : this.mJY.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.mIS.dyI() ? this.mJZ.getDate() : this.mJY.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.mIS.dyI() ? this.mJZ.getDefaultUseCaches() : this.mJY.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.mIS.dyI() ? this.mJZ.getDoInput() : this.mJY.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.mIS.dyI() ? this.mJZ.getDoOutput() : this.mJY.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.mIS.dyI() ? this.mJZ.getExpiration() : this.mJY.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.mIS.dyI()) {
            return this.mJZ.getHeaderField(str);
        }
        String headerField = this.mJY.getHeaderField(str);
        this.mJX.dyJ();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.mIS.dyI()) {
            return this.mJZ.getHeaderField(i);
        }
        return this.mJY.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.mIS.dyI() ? this.mJZ.getHeaderFieldInt(str, i) : this.mJY.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.mIS.dyI() ? this.mJZ.getHeaderFieldDate(str, j) : this.mJY.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.mIS.dyI() ? this.mJZ.getHeaderFieldKey(i) : this.mJY.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.mIS.dyI()) {
            return this.mJZ.getHeaderFields();
        }
        return this.mJY.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.mIS.dyI() ? this.mJZ.getIfModifiedSince() : this.mJY.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.mIS.toString());
        if (!this.mIS.dyI()) {
            return this.mJZ.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.mJY.getInputStream(), this);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.mIS.dyI() ? this.mJZ.getOutputStream() : this.mJY.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.mIS.dyI() ? this.mJZ.getLastModified() : this.mJY.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.mIS.dyI() ? this.mJZ.getPermission() : this.mJY.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.mIS.dyI() ? this.mJZ.getReadTimeout() : this.mJY.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.mIS.dyI() ? this.mJZ.getRequestProperties() : this.mJY.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.mIS.dyI() ? this.mJZ.getRequestProperty(str) : this.mJY.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.mIS.dyI() ? this.mJZ.getURL() : this.mJY.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.mIS.dyI() ? this.mJZ.getUseCaches() : this.mJY.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.mIS.dyI()) {
            this.mJZ.setConnectTimeout(i);
        } else {
            this.mJY.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.mIS.dyI()) {
            this.mJZ.setDefaultUseCaches(z);
        } else {
            this.mJY.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.mIS.dyI()) {
            this.mJZ.setDoInput(z);
        } else {
            this.mJY.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.mIS.dyI()) {
            this.mJZ.setDoOutput(z);
        } else {
            this.mJY.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.mIS.dyI()) {
            this.mJZ.setIfModifiedSince(j);
        } else {
            this.mJY.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.mIS.dyI()) {
            this.mJZ.setReadTimeout(i);
        } else {
            this.mJY.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.mIS.dyI()) {
            this.mJZ.setRequestProperty(str, str2);
        } else {
            this.mJY.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.mIS.dyI()) {
            this.mJZ.setUseCaches(z);
        } else {
            this.mJY.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.mIS.toString());
        if (!this.mIS.dyI()) {
            this.mJZ.disconnect();
        } else {
            this.mJY.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.mIS.dyI() ? this.mJZ.getErrorStream() : this.mJY.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.mIS.dyI() ? this.mJZ.getInstanceFollowRedirects() : this.mJY.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.mIS.dyI() ? this.mJZ.getRequestMethod() : this.mJY.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.mIS.dyI()) {
            responseCode = this.mJZ.getResponseCode();
        } else {
            try {
                responseCode = this.mJY.getResponseCode();
                this.mJX.mJe = responseCode;
                this.mJX.dyJ();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                a(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.mIS.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.mIS.dyI()) {
            responseMessage = this.mJZ.getResponseMessage();
        } else {
            responseMessage = this.mJY.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.mIS.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.mIS.dyI()) {
            this.mJZ.setChunkedStreamingMode(i);
        } else {
            this.mJY.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.mIS.dyI()) {
            this.mJZ.setFixedLengthStreamingMode(i);
        } else {
            this.mJY.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.mIS.dyI()) {
            this.mJZ.setFixedLengthStreamingMode(j);
        } else {
            this.mJY.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.mIS.dyI()) {
            this.mJZ.setInstanceFollowRedirects(z);
        } else {
            this.mJY.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.mIS.dyI()) {
            this.mJZ.setRequestMethod(str);
            return;
        }
        this.mJY.setRequestMethod(str);
        this.mJX.dfN = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.mIS.dyI() ? this.mJZ.usingProxy() : this.mJY.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.mJY instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mJY).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.mJY instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mJY).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.mJY instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mJY).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.mJY instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mJY).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.mJY instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mJY).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.mJY instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mJY).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.mJY instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.mJY).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.mJY instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.mJY).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.mJY instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.mJY).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void a(Exception exc, long j) {
        this.mJX.mJf = j;
        this.mJX.dyK();
        this.mJX.w(exc);
        this.mJX.a(this.mJG);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.mJX.mJf = j;
        this.mJX.dyK();
        this.mJX.mJd = 0;
        this.mJX.a(this.mJG);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void fQ(long j) {
        this.mJX.mJf = j;
        this.mJX.dyK();
        this.mJX.mJd = -12;
        this.mJX.a(this.mJG);
    }
}
