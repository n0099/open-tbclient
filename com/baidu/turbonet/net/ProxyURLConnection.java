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
/* loaded from: classes14.dex */
public class ProxyURLConnection extends HttpsURLConnection implements com.baidu.turbonet.net.proxy.b {
    private ProxyConfig oDI;
    private a oEL;
    private HttpURLConnection oEM;
    private d oEN;
    private TurbonetEngine oEw;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.oDI.ehs()) {
            this.oEN.addRequestProperty(str, str2);
        } else {
            this.oEM.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.oDI.toString());
        if (!this.oDI.ehs()) {
            this.oEN.connect();
            return;
        }
        try {
            this.oEM.connect();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.oDI.ehs() ? this.oEN.getConnectTimeout() : this.oEM.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.oDI.ehs()) {
            return this.oEN.getContent();
        }
        try {
            long contentLength = this.oEM.getContentLength();
            this.oEL.oDV = contentLength;
            onComplete(contentLength);
            return this.oEM.getContent();
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.oDI.ehs()) {
            return this.oEN.getContent(clsArr);
        }
        try {
            long contentLength = this.oEM.getContentLength();
            this.oEL.oDV = contentLength;
            onComplete(contentLength);
            return this.oEM.getContent(clsArr);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.oDI.ehs() ? this.oEN.getContentEncoding() : this.oEM.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.oDI.ehs() ? this.oEN.getContentLength() : this.oEM.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.oDI.ehs() ? this.oEN.getContentType() : this.oEM.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.oDI.ehs() ? this.oEN.getDate() : this.oEM.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.oDI.ehs() ? this.oEN.getDefaultUseCaches() : this.oEM.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.oDI.ehs() ? this.oEN.getDoInput() : this.oEM.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.oDI.ehs() ? this.oEN.getDoOutput() : this.oEM.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.oDI.ehs() ? this.oEN.getExpiration() : this.oEM.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.oDI.ehs()) {
            return this.oEN.getHeaderField(str);
        }
        String headerField = this.oEM.getHeaderField(str);
        this.oEL.eht();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.oDI.ehs()) {
            return this.oEN.getHeaderField(i);
        }
        return this.oEM.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.oDI.ehs() ? this.oEN.getHeaderFieldInt(str, i) : this.oEM.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.oDI.ehs() ? this.oEN.getHeaderFieldDate(str, j) : this.oEM.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.oDI.ehs() ? this.oEN.getHeaderFieldKey(i) : this.oEM.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.oDI.ehs()) {
            return this.oEN.getHeaderFields();
        }
        return this.oEM.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.oDI.ehs() ? this.oEN.getIfModifiedSince() : this.oEM.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.oDI.toString());
        if (!this.oDI.ehs()) {
            return this.oEN.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.oEM.getInputStream(), this);
        } catch (IOException e) {
            a(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.oDI.ehs() ? this.oEN.getOutputStream() : this.oEM.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.oDI.ehs() ? this.oEN.getLastModified() : this.oEM.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.oDI.ehs() ? this.oEN.getPermission() : this.oEM.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.oDI.ehs() ? this.oEN.getReadTimeout() : this.oEM.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.oDI.ehs() ? this.oEN.getRequestProperties() : this.oEM.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.oDI.ehs() ? this.oEN.getRequestProperty(str) : this.oEM.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.oDI.ehs() ? this.oEN.getURL() : this.oEM.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.oDI.ehs() ? this.oEN.getUseCaches() : this.oEM.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.oDI.ehs()) {
            this.oEN.setConnectTimeout(i);
        } else {
            this.oEM.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.oDI.ehs()) {
            this.oEN.setDefaultUseCaches(z);
        } else {
            this.oEM.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.oDI.ehs()) {
            this.oEN.setDoInput(z);
        } else {
            this.oEM.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.oDI.ehs()) {
            this.oEN.setDoOutput(z);
        } else {
            this.oEM.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.oDI.ehs()) {
            this.oEN.setIfModifiedSince(j);
        } else {
            this.oEM.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.oDI.ehs()) {
            this.oEN.setReadTimeout(i);
        } else {
            this.oEM.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.oDI.ehs()) {
            this.oEN.setRequestProperty(str, str2);
        } else {
            this.oEM.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.oDI.ehs()) {
            this.oEN.setUseCaches(z);
        } else {
            this.oEM.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.oDI.toString());
        if (!this.oDI.ehs()) {
            this.oEN.disconnect();
        } else {
            this.oEM.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.oDI.ehs() ? this.oEN.getErrorStream() : this.oEM.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.oDI.ehs() ? this.oEN.getInstanceFollowRedirects() : this.oEM.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.oDI.ehs() ? this.oEN.getRequestMethod() : this.oEM.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.oDI.ehs()) {
            responseCode = this.oEN.getResponseCode();
        } else {
            try {
                responseCode = this.oEM.getResponseCode();
                this.oEL.oDU = responseCode;
                this.oEL.eht();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                a(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.oDI.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.oDI.ehs()) {
            responseMessage = this.oEN.getResponseMessage();
        } else {
            responseMessage = this.oEM.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.oDI.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.oDI.ehs()) {
            this.oEN.setChunkedStreamingMode(i);
        } else {
            this.oEM.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.oDI.ehs()) {
            this.oEN.setFixedLengthStreamingMode(i);
        } else {
            this.oEM.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.oDI.ehs()) {
            this.oEN.setFixedLengthStreamingMode(j);
        } else {
            this.oEM.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.oDI.ehs()) {
            this.oEN.setInstanceFollowRedirects(z);
        } else {
            this.oEM.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.oDI.ehs()) {
            this.oEN.setRequestMethod(str);
            return;
        }
        this.oEM.setRequestMethod(str);
        this.oEL.dXK = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.oDI.ehs() ? this.oEN.usingProxy() : this.oEM.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.oEM instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oEM).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.oEM instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oEM).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.oEM instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oEM).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.oEM instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oEM).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.oEM instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oEM).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.oEM instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oEM).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.oEM instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oEM).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.oEM instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.oEM).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.oEM instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.oEM).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void a(Exception exc, long j) {
        this.oEL.oDV = j;
        this.oEL.ehu();
        this.oEL.A(exc);
        this.oEL.a(this.oEw);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.oEL.oDV = j;
        this.oEL.ehu();
        this.oEL.oDT = 0;
        this.oEL.a(this.oEw);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void hV(long j) {
        this.oEL.oDV = j;
        this.oEL.ehu();
        this.oEL.oDT = -12;
        this.oEL.a(this.oEw);
    }
}
