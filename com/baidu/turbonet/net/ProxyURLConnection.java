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
/* loaded from: classes4.dex */
public class ProxyURLConnection extends HttpsURLConnection implements com.baidu.turbonet.net.proxy.b {
    private ProxyConfig oFZ;
    private TurbonetEngine oGB;
    private a oGO;
    private HttpURLConnection oGP;
    private d oGQ;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.oFZ.edR()) {
            this.oGQ.addRequestProperty(str, str2);
        } else {
            this.oGP.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.oFZ.toString());
        if (!this.oFZ.edR()) {
            this.oGQ.connect();
            return;
        }
        try {
            this.oGP.connect();
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.oFZ.edR() ? this.oGQ.getConnectTimeout() : this.oGP.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.oFZ.edR()) {
            return this.oGQ.getContent();
        }
        try {
            long contentLength = this.oGP.getContentLength();
            this.oGO.oGl = contentLength;
            onComplete(contentLength);
            return this.oGP.getContent();
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.oFZ.edR()) {
            return this.oGQ.getContent(clsArr);
        }
        try {
            long contentLength = this.oGP.getContentLength();
            this.oGO.oGl = contentLength;
            onComplete(contentLength);
            return this.oGP.getContent(clsArr);
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.oFZ.edR() ? this.oGQ.getContentEncoding() : this.oGP.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.oFZ.edR() ? this.oGQ.getContentLength() : this.oGP.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.oFZ.edR() ? this.oGQ.getContentType() : this.oGP.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.oFZ.edR() ? this.oGQ.getDate() : this.oGP.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.oFZ.edR() ? this.oGQ.getDefaultUseCaches() : this.oGP.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.oFZ.edR() ? this.oGQ.getDoInput() : this.oGP.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.oFZ.edR() ? this.oGQ.getDoOutput() : this.oGP.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.oFZ.edR() ? this.oGQ.getExpiration() : this.oGP.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.oFZ.edR()) {
            return this.oGQ.getHeaderField(str);
        }
        String headerField = this.oGP.getHeaderField(str);
        this.oGO.edS();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.oFZ.edR()) {
            return this.oGQ.getHeaderField(i);
        }
        return this.oGP.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.oFZ.edR() ? this.oGQ.getHeaderFieldInt(str, i) : this.oGP.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.oFZ.edR() ? this.oGQ.getHeaderFieldDate(str, j) : this.oGP.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.oFZ.edR() ? this.oGQ.getHeaderFieldKey(i) : this.oGP.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.oFZ.edR()) {
            return this.oGQ.getHeaderFields();
        }
        return this.oGP.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.oFZ.edR() ? this.oGQ.getIfModifiedSince() : this.oGP.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.oFZ.toString());
        if (!this.oFZ.edR()) {
            return this.oGQ.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.oGP.getInputStream(), this);
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.oFZ.edR() ? this.oGQ.getOutputStream() : this.oGP.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.oFZ.edR() ? this.oGQ.getLastModified() : this.oGP.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.oFZ.edR() ? this.oGQ.getPermission() : this.oGP.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.oFZ.edR() ? this.oGQ.getReadTimeout() : this.oGP.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.oFZ.edR() ? this.oGQ.getRequestProperties() : this.oGP.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.oFZ.edR() ? this.oGQ.getRequestProperty(str) : this.oGP.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.oFZ.edR() ? this.oGQ.getURL() : this.oGP.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.oFZ.edR() ? this.oGQ.getUseCaches() : this.oGP.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.oFZ.edR()) {
            this.oGQ.setConnectTimeout(i);
        } else {
            this.oGP.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.oFZ.edR()) {
            this.oGQ.setDefaultUseCaches(z);
        } else {
            this.oGP.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.oFZ.edR()) {
            this.oGQ.setDoInput(z);
        } else {
            this.oGP.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.oFZ.edR()) {
            this.oGQ.setDoOutput(z);
        } else {
            this.oGP.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.oFZ.edR()) {
            this.oGQ.setIfModifiedSince(j);
        } else {
            this.oGP.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.oFZ.edR()) {
            this.oGQ.setReadTimeout(i);
        } else {
            this.oGP.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.oFZ.edR()) {
            this.oGQ.setRequestProperty(str, str2);
        } else {
            this.oGP.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.oFZ.edR()) {
            this.oGQ.setUseCaches(z);
        } else {
            this.oGP.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.oFZ.toString());
        if (!this.oFZ.edR()) {
            this.oGQ.disconnect();
        } else {
            this.oGP.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.oFZ.edR() ? this.oGQ.getErrorStream() : this.oGP.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.oFZ.edR() ? this.oGQ.getInstanceFollowRedirects() : this.oGP.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.oFZ.edR() ? this.oGQ.getRequestMethod() : this.oGP.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.oFZ.edR()) {
            responseCode = this.oGQ.getResponseCode();
        } else {
            try {
                responseCode = this.oGP.getResponseCode();
                this.oGO.mHttpStatusCode = responseCode;
                this.oGO.edS();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                b(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.oFZ.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.oFZ.edR()) {
            responseMessage = this.oGQ.getResponseMessage();
        } else {
            responseMessage = this.oGP.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.oFZ.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.oFZ.edR()) {
            this.oGQ.setChunkedStreamingMode(i);
        } else {
            this.oGP.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.oFZ.edR()) {
            this.oGQ.setFixedLengthStreamingMode(i);
        } else {
            this.oGP.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.oFZ.edR()) {
            this.oGQ.setFixedLengthStreamingMode(j);
        } else {
            this.oGP.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.oFZ.edR()) {
            this.oGQ.setInstanceFollowRedirects(z);
        } else {
            this.oGP.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.oFZ.edR()) {
            this.oGQ.setRequestMethod(str);
            return;
        }
        this.oGP.setRequestMethod(str);
        this.oGO.mMethod = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.oFZ.edR() ? this.oGQ.usingProxy() : this.oGP.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.oGP instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oGP).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.oGP instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oGP).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.oGP instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oGP).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.oGP instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oGP).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.oGP instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oGP).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.oGP instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oGP).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.oGP instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oGP).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.oGP instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.oGP).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.oGP instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.oGP).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void b(Exception exc, long j) {
        this.oGO.oGl = j;
        this.oGO.edT();
        this.oGO.A(exc);
        this.oGO.a(this.oGB);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.oGO.oGl = j;
        this.oGO.edT();
        this.oGO.oGk = 0;
        this.oGO.a(this.oGB);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void hP(long j) {
        this.oGO.oGl = j;
        this.oGO.edT();
        this.oGO.oGk = -12;
        this.oGO.a(this.oGB);
    }
}
