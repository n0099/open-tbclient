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
/* loaded from: classes5.dex */
public class ProxyURLConnection extends HttpsURLConnection implements com.baidu.turbonet.net.proxy.b {
    private ProxyConfig oSM;
    private a oTB;
    private HttpURLConnection oTC;
    private d oTD;
    private TurbonetEngine oTo;

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.oSM.egz()) {
            this.oTD.addRequestProperty(str, str2);
        } else {
            this.oTC.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "connect by libtype: " + this.oSM.toString());
        if (!this.oSM.egz()) {
            this.oTD.connect();
            return;
        }
        try {
            this.oTC.connect();
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return !this.oSM.egz() ? this.oTD.getConnectTimeout() : this.oTC.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.oSM.egz()) {
            return this.oTD.getContent();
        }
        try {
            long contentLength = this.oTC.getContentLength();
            this.oTB.oSY = contentLength;
            onComplete(contentLength);
            return this.oTC.getContent();
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.oSM.egz()) {
            return this.oTD.getContent(clsArr);
        }
        try {
            long contentLength = this.oTC.getContentLength();
            this.oTB.oSY = contentLength;
            onComplete(contentLength);
            return this.oTC.getContent(clsArr);
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return !this.oSM.egz() ? this.oTD.getContentEncoding() : this.oTC.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return !this.oSM.egz() ? this.oTD.getContentLength() : this.oTC.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return !this.oSM.egz() ? this.oTD.getContentType() : this.oTC.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return !this.oSM.egz() ? this.oTD.getDate() : this.oTC.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return !this.oSM.egz() ? this.oTD.getDefaultUseCaches() : this.oTC.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return !this.oSM.egz() ? this.oTD.getDoInput() : this.oTC.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return !this.oSM.egz() ? this.oTD.getDoOutput() : this.oTC.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return !this.oSM.egz() ? this.oTD.getExpiration() : this.oTC.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.oSM.egz()) {
            return this.oTD.getHeaderField(str);
        }
        String headerField = this.oTC.getHeaderField(str);
        this.oTB.egA();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.oSM.egz()) {
            return this.oTD.getHeaderField(i);
        }
        return this.oTC.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        return !this.oSM.egz() ? this.oTD.getHeaderFieldInt(str, i) : this.oTC.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        return !this.oSM.egz() ? this.oTD.getHeaderFieldDate(str, j) : this.oTC.getHeaderFieldDate(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return !this.oSM.egz() ? this.oTD.getHeaderFieldKey(i) : this.oTC.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.oSM.egz()) {
            return this.oTD.getHeaderFields();
        }
        return this.oTC.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return !this.oSM.egz() ? this.oTD.getIfModifiedSince() : this.oTC.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getInputStream by libtype: " + this.oSM.toString());
        if (!this.oSM.egz()) {
            return this.oTD.getInputStream();
        }
        try {
            return new com.baidu.turbonet.net.proxy.a(this.oTC.getInputStream(), this);
        } catch (IOException e) {
            b(e, 0L);
            throw e;
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return !this.oSM.egz() ? this.oTD.getOutputStream() : this.oTC.getOutputStream();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return !this.oSM.egz() ? this.oTD.getLastModified() : this.oTC.getLastModified();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return !this.oSM.egz() ? this.oTD.getPermission() : this.oTC.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return !this.oSM.egz() ? this.oTD.getReadTimeout() : this.oTC.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return !this.oSM.egz() ? this.oTD.getRequestProperties() : this.oTC.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return !this.oSM.egz() ? this.oTD.getRequestProperty(str) : this.oTC.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return !this.oSM.egz() ? this.oTD.getURL() : this.oTC.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return !this.oSM.egz() ? this.oTD.getUseCaches() : this.oTC.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.oSM.egz()) {
            this.oTD.setConnectTimeout(i);
        } else {
            this.oTC.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.oSM.egz()) {
            this.oTD.setDefaultUseCaches(z);
        } else {
            this.oTC.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.oSM.egz()) {
            this.oTD.setDoInput(z);
        } else {
            this.oTC.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.oSM.egz()) {
            this.oTD.setDoOutput(z);
        } else {
            this.oTC.setDoOutput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.oSM.egz()) {
            this.oTD.setIfModifiedSince(j);
        } else {
            this.oTC.setIfModifiedSince(j);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.oSM.egz()) {
            this.oTD.setReadTimeout(i);
        } else {
            this.oTC.setReadTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.oSM.egz()) {
            this.oTD.setRequestProperty(str, str2);
        } else {
            this.oTC.setRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.oSM.egz()) {
            this.oTD.setUseCaches(z);
        } else {
            this.oTC.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        com.baidu.turbonet.base.a.d("ProxyURLConn", "disconnect by libtype: " + this.oSM.toString());
        if (!this.oSM.egz()) {
            this.oTD.disconnect();
        } else {
            this.oTC.disconnect();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return !this.oSM.egz() ? this.oTD.getErrorStream() : this.oTC.getErrorStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return !this.oSM.egz() ? this.oTD.getInstanceFollowRedirects() : this.oTC.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return !this.oSM.egz() ? this.oTD.getRequestMethod() : this.oTC.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int responseCode;
        if (!this.oSM.egz()) {
            responseCode = this.oTD.getResponseCode();
        } else {
            try {
                responseCode = this.oTC.getResponseCode();
                this.oTB.mHttpStatusCode = responseCode;
                this.oTB.egA();
                if (responseCode != 200) {
                    onComplete(0L);
                }
            } catch (IOException e) {
                b(e, 0L);
                throw e;
            }
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseCode: " + responseCode + " by libtype: " + this.oSM.toString());
        return responseCode;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.oSM.egz()) {
            responseMessage = this.oTD.getResponseMessage();
        } else {
            responseMessage = this.oTC.getResponseMessage();
        }
        com.baidu.turbonet.base.a.d("ProxyURLConn", "getResponseMessage by libtype: " + this.oSM.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.oSM.egz()) {
            this.oTD.setChunkedStreamingMode(i);
        } else {
            this.oTC.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.oSM.egz()) {
            this.oTD.setFixedLengthStreamingMode(i);
        } else {
            this.oTC.setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.oSM.egz()) {
            this.oTD.setFixedLengthStreamingMode(j);
        } else {
            this.oTC.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.oSM.egz()) {
            this.oTD.setInstanceFollowRedirects(z);
        } else {
            this.oTC.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.oSM.egz()) {
            this.oTD.setRequestMethod(str);
            return;
        }
        this.oTC.setRequestMethod(str);
        this.oTB.mMethod = str;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return !this.oSM.egz() ? this.oTD.usingProxy() : this.oTC.usingProxy();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        if (this.oTC instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oTC).getCipherSuite();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        if (this.oTC instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oTC).getHostnameVerifier();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        if (this.oTC instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oTC).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        if (this.oTC instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oTC).getLocalPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (this.oTC instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oTC).getPeerPrincipal();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        if (this.oTC instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oTC).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        if (this.oTC instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) this.oTC).getServerCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (this.oTC instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.oTC).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (this.oTC instanceof HttpsURLConnection) {
            ((HttpsURLConnection) this.oTC).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void b(Exception exc, long j) {
        this.oTB.oSY = j;
        this.oTB.egB();
        this.oTB.A(exc);
        this.oTB.a(this.oTo);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void onComplete(long j) {
        this.oTB.oSY = j;
        this.oTB.egB();
        this.oTB.oSX = 0;
        this.oTB.a(this.oTo);
    }

    @Override // com.baidu.turbonet.net.proxy.b
    public void hS(long j) {
        this.oTB.oSY = j;
        this.oTB.egB();
        this.oTB.oSX = -12;
        this.oTB.a(this.oTo);
    }
}
