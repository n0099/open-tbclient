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
    private ProxyConfig mdF;
    private a meJ;
    private HttpURLConnection meK;
    private d meL;
    private TurbonetEngine met;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.mdF.dqx()) {
            this.meL.addRequestProperty(str, str2);
        } else {
            this.meK.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.mdF.toString());
        if (!this.mdF.dqx()) {
            this.meL.connect();
            return;
        }
        try {
            this.meK.connect();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.mdF.dqx() ? this.meL.getConnectTimeout() : this.meK.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.mdF.dqx()) {
            return this.meL.getContent();
        }
        try {
            long contentLength = this.meK.getContentLength();
            this.meJ.mdS = contentLength;
            onComplete(contentLength);
            return this.meK.getContent();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.mdF.dqx()) {
            return this.meL.getContent(clsArr);
        }
        try {
            long contentLength = this.meK.getContentLength();
            this.meJ.mdS = contentLength;
            onComplete(contentLength);
            return this.meK.getContent(clsArr);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.mdF.dqx() ? this.meL.getContentEncoding() : this.meK.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.mdF.dqx() ? this.meL.getContentLength() : this.meK.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.mdF.dqx() ? this.meL.getContentType() : this.meK.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.mdF.dqx() ? this.meL.getDate() : this.meK.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.mdF.dqx() ? this.meL.getDefaultUseCaches() : this.meK.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.mdF.dqx() ? this.meL.getDoInput() : this.meK.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.mdF.dqx() ? this.meL.getDoOutput() : this.meK.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.mdF.dqx() ? this.meL.getExpiration() : this.meK.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.mdF.dqx()) {
            return this.meL.getHeaderField(str);
        }
        String headerField = this.meK.getHeaderField(str);
        this.meJ.dqy();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.mdF.dqx()) {
            return this.meL.getHeaderField(i);
        }
        return this.meK.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.mdF.dqx() ? this.meL.getHeaderFieldInt(str, i) : this.meK.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.mdF.dqx() ? this.meL.getHeaderFieldDate(str, j) : this.meK.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.mdF.dqx() ? this.meL.getHeaderFieldKey(i) : this.meK.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.mdF.dqx()) {
            return this.meL.getHeaderFields();
        }
        return this.meK.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.mdF.dqx() ? this.meL.getIfModifiedSince() : this.meK.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.mdF.toString());
        if (!this.mdF.dqx()) {
            return this.meL.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.meK.getInputStream(), this);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.mdF.dqx() ? this.meL.getOutputStream() : this.meK.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.mdF.dqx() ? this.meL.getLastModified() : this.meK.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.mdF.dqx() ? this.meL.getPermission() : this.meK.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.mdF.dqx() ? this.meL.getReadTimeout() : this.meK.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.mdF.dqx() ? this.meL.getRequestProperties() : this.meK.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.mdF.dqx() ? this.meL.getRequestProperty(str) : this.meK.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.mdF.dqx() ? this.meL.getURL() : this.meK.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.mdF.dqx() ? this.meL.getUseCaches() : this.meK.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.mdF.dqx()) {
            this.meL.setConnectTimeout(i);
        } else {
            this.meK.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.mdF.dqx()) {
            this.meL.setDefaultUseCaches(z);
        } else {
            this.meK.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.mdF.dqx()) {
            this.meL.setDoInput(z);
        } else {
            this.meK.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.mdF.dqx()) {
            this.meL.setDoOutput(z);
        } else {
            this.meK.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.mdF.dqx()) {
            this.meL.setIfModifiedSince(j);
        } else {
            this.meK.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.mdF.dqx()) {
            this.meL.setReadTimeout(i);
        } else {
            this.meK.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.mdF.dqx()) {
            this.meL.setRequestProperty(str, str2);
        } else {
            this.meK.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.mdF.dqx()) {
            this.meL.setUseCaches(z);
        } else {
            this.meK.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.mdF.toString());
        if (!this.mdF.dqx()) {
            this.meL.disconnect();
        } else {
            this.meK.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.mdF.dqx() ? this.meL.getErrorStream() : this.meK.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.mdF.dqx() ? this.meL.getInstanceFollowRedirects() : this.meK.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.mdF.dqx() ? this.meL.getRequestMethod() : this.meK.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.mdF.dqx()) {
            responseCode = this.meL.getResponseCode();
        } else {
            try {
                responseCode = this.meK.getResponseCode();
                this.meJ.mdR = responseCode;
                this.meJ.dqy();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                a(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.mdF.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.mdF.dqx()) {
            responseMessage = this.meL.getResponseMessage();
        } else {
            responseMessage = this.meK.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.mdF.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.mdF.dqx()) {
            this.meL.setChunkedStreamingMode(i);
        } else {
            this.meK.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.mdF.dqx()) {
            this.meL.setFixedLengthStreamingMode(i);
        } else {
            this.meK.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.mdF.dqx()) {
            this.meL.setFixedLengthStreamingMode(j);
        } else {
            this.meK.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.mdF.dqx()) {
            this.meL.setInstanceFollowRedirects(z);
        } else {
            this.meK.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.mdF.dqx()) {
            this.meL.setRequestMethod(str);
            return;
        }
        this.meK.setRequestMethod(str);
        this.meJ.cVs = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.mdF.dqx() ? this.meL.usingProxy() : this.meK.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.meK instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.meK).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.meK instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.meK).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.meK instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.meK).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.meK instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.meK).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.meK instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.meK).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.meK instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.meK).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.meK instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.meK).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.meK instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.meK).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.meK instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.meK).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void a(Exception exc, long j) {
        this.meJ.mdS = j;
        this.meJ.dqz();
        this.meJ.w(exc);
        this.meJ.a(this.met);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.meJ.mdS = j;
        this.meJ.dqz();
        this.meJ.mdQ = 0;
        this.meJ.a(this.met);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void fy(long j) {
        this.meJ.mdS = j;
        this.meJ.dqz();
        this.meJ.mdQ = -12;
        this.meJ.a(this.met);
    }
}
