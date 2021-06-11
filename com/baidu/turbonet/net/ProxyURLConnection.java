package com.baidu.turbonet.net;

import android.annotation.TargetApi;
import com.baidu.turbonet.net.proxy.ProxyConfig;
import d.a.o0.b.a;
import d.a.o0.b.d.b;
import d.a.o0.b.e.d;
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
public class ProxyURLConnection extends HttpsURLConnection implements b {

    /* renamed from: a  reason: collision with root package name */
    public a f22481a;

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f22482b;

    /* renamed from: c  reason: collision with root package name */
    public d f22483c;

    /* renamed from: d  reason: collision with root package name */
    public TurbonetEngine f22484d;

    /* renamed from: e  reason: collision with root package name */
    public ProxyConfig f22485e;

    @Override // d.a.o0.b.d.b
    public void a(long j) {
        a aVar = this.f22481a;
        aVar.f67559e = j;
        aVar.c();
        a aVar2 = this.f22481a;
        aVar2.f67557c = -12;
        aVar2.d(this.f22484d);
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.f22485e.a()) {
            this.f22483c.addRequestProperty(str, str2);
        } else {
            this.f22482b.addRequestProperty(str, str2);
        }
    }

    @Override // d.a.o0.b.d.b
    public void b(Exception exc, long j) {
        a aVar = this.f22481a;
        aVar.f67559e = j;
        aVar.c();
        this.f22481a.a(exc);
        this.f22481a.d(this.f22484d);
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        d.a.o0.a.a.a("ProxyURLConn", "connect by libtype: " + this.f22485e.toString());
        if (!this.f22485e.a()) {
            this.f22483c.connect();
            return;
        }
        try {
            this.f22482b.connect();
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        d.a.o0.a.a.a("ProxyURLConn", "disconnect by libtype: " + this.f22485e.toString());
        if (!this.f22485e.a()) {
            this.f22483c.disconnect();
        } else {
            this.f22482b.disconnect();
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        HttpURLConnection httpURLConnection = this.f22482b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getCipherSuite();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        if (!this.f22485e.a()) {
            return this.f22483c.getConnectTimeout();
        }
        return this.f22482b.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.f22485e.a()) {
            return this.f22483c.getContent();
        }
        try {
            long contentLength = this.f22482b.getContentLength();
            this.f22481a.f67559e = contentLength;
            onComplete(contentLength);
            return this.f22482b.getContent();
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        if (!this.f22485e.a()) {
            return this.f22483c.getContentEncoding();
        }
        return this.f22482b.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        if (!this.f22485e.a()) {
            return this.f22483c.getContentLength();
        }
        return this.f22482b.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        if (!this.f22485e.a()) {
            return this.f22483c.getContentType();
        }
        return this.f22482b.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        if (!this.f22485e.a()) {
            return this.f22483c.getDate();
        }
        return this.f22482b.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        if (!this.f22485e.a()) {
            return this.f22483c.getDefaultUseCaches();
        }
        return this.f22482b.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        if (!this.f22485e.a()) {
            return this.f22483c.getDoInput();
        }
        return this.f22482b.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        if (!this.f22485e.a()) {
            return this.f22483c.getDoOutput();
        }
        return this.f22482b.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        if (!this.f22485e.a()) {
            return this.f22483c.getErrorStream();
        }
        return this.f22482b.getErrorStream();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        if (!this.f22485e.a()) {
            return this.f22483c.getExpiration();
        }
        return this.f22482b.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.f22485e.a()) {
            return this.f22483c.getHeaderField(str);
        }
        String headerField = this.f22482b.getHeaderField(str);
        this.f22481a.b();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        if (!this.f22485e.a()) {
            return this.f22483c.getHeaderFieldDate(str, j);
        }
        return this.f22482b.getHeaderFieldDate(str, j);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i2) {
        if (!this.f22485e.a()) {
            return this.f22483c.getHeaderFieldInt(str, i2);
        }
        return this.f22482b.getHeaderFieldInt(str, i2);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i2) {
        if (!this.f22485e.a()) {
            return this.f22483c.getHeaderFieldKey(i2);
        }
        return this.f22482b.getHeaderFieldKey(i2);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.f22485e.a()) {
            return this.f22483c.getHeaderFields();
        }
        return this.f22482b.getHeaderFields();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        HttpURLConnection httpURLConnection = this.f22482b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getHostnameVerifier();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        if (!this.f22485e.a()) {
            return this.f22483c.getIfModifiedSince();
        }
        return this.f22482b.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        d.a.o0.a.a.a("ProxyURLConn", "getInputStream by libtype: " + this.f22485e.toString());
        if (!this.f22485e.a()) {
            return this.f22483c.getInputStream();
        }
        try {
            return new d.a.o0.b.d.a(this.f22482b.getInputStream(), this);
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        if (!this.f22485e.a()) {
            return this.f22483c.getInstanceFollowRedirects();
        }
        return this.f22482b.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        if (!this.f22485e.a()) {
            return this.f22483c.getLastModified();
        }
        return this.f22482b.getLastModified();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        HttpURLConnection httpURLConnection = this.f22482b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        HttpURLConnection httpURLConnection = this.f22482b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getLocalPrincipal();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (!this.f22485e.a()) {
            return this.f22483c.getOutputStream();
        }
        return this.f22482b.getOutputStream();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        HttpURLConnection httpURLConnection = this.f22482b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getPeerPrincipal();
        }
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        if (!this.f22485e.a()) {
            return this.f22483c.getPermission();
        }
        return this.f22482b.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        if (!this.f22485e.a()) {
            return this.f22483c.getReadTimeout();
        }
        return this.f22482b.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        if (!this.f22485e.a()) {
            return this.f22483c.getRequestMethod();
        }
        return this.f22482b.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (!this.f22485e.a()) {
            return this.f22483c.getRequestProperties();
        }
        return this.f22482b.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        if (!this.f22485e.a()) {
            return this.f22483c.getRequestProperty(str);
        }
        return this.f22482b.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int i2;
        if (!this.f22485e.a()) {
            i2 = this.f22483c.getResponseCode();
        } else {
            try {
                int responseCode = this.f22482b.getResponseCode();
                this.f22481a.f67558d = responseCode;
                this.f22481a.b();
                if (responseCode != 200) {
                    onComplete(0L);
                }
                i2 = responseCode;
            } catch (IOException e2) {
                b(e2, 0L);
                throw e2;
            }
        }
        d.a.o0.a.a.a("ProxyURLConn", "getResponseCode: " + i2 + " by libtype: " + this.f22485e.toString());
        return i2;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.f22485e.a()) {
            responseMessage = this.f22483c.getResponseMessage();
        } else {
            responseMessage = this.f22482b.getResponseMessage();
        }
        d.a.o0.a.a.a("ProxyURLConn", "getResponseMessage by libtype: " + this.f22485e.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        HttpURLConnection httpURLConnection = this.f22482b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        HttpURLConnection httpURLConnection = this.f22482b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getServerCertificates();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        if (!this.f22485e.a()) {
            return this.f22483c.getURL();
        }
        return this.f22482b.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        if (!this.f22485e.a()) {
            return this.f22483c.getUseCaches();
        }
        return this.f22482b.getUseCaches();
    }

    @Override // d.a.o0.b.d.b
    public void onComplete(long j) {
        a aVar = this.f22481a;
        aVar.f67559e = j;
        aVar.c();
        a aVar2 = this.f22481a;
        aVar2.f67557c = 0;
        aVar2.d(this.f22484d);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i2) {
        if (!this.f22485e.a()) {
            this.f22483c.setChunkedStreamingMode(i2);
        } else {
            this.f22482b.setChunkedStreamingMode(i2);
        }
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i2) {
        if (!this.f22485e.a()) {
            this.f22483c.setConnectTimeout(i2);
        } else {
            this.f22482b.setConnectTimeout(i2);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.f22485e.a()) {
            this.f22483c.setDefaultUseCaches(z);
        } else {
            this.f22482b.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.f22485e.a()) {
            this.f22483c.setDoInput(z);
        } else {
            this.f22482b.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.f22485e.a()) {
            this.f22483c.setDoOutput(z);
        } else {
            this.f22482b.setDoOutput(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i2) {
        if (!this.f22485e.a()) {
            this.f22483c.setFixedLengthStreamingMode(i2);
        } else {
            this.f22482b.setFixedLengthStreamingMode(i2);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        HttpURLConnection httpURLConnection = this.f22482b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.f22485e.a()) {
            this.f22483c.setIfModifiedSince(j);
        } else {
            this.f22482b.setIfModifiedSince(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.f22485e.a()) {
            this.f22483c.setInstanceFollowRedirects(z);
        } else {
            this.f22482b.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i2) {
        if (!this.f22485e.a()) {
            this.f22483c.setReadTimeout(i2);
        } else {
            this.f22482b.setReadTimeout(i2);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.f22485e.a()) {
            this.f22483c.setRequestMethod(str);
            return;
        }
        this.f22482b.setRequestMethod(str);
        this.f22481a.f67556b = str;
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.f22485e.a()) {
            this.f22483c.setRequestProperty(str, str2);
        } else {
            this.f22482b.setRequestProperty(str, str2);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        HttpURLConnection httpURLConnection = this.f22482b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.f22485e.a()) {
            this.f22483c.setUseCaches(z);
        } else {
            this.f22482b.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        if (!this.f22485e.a()) {
            return this.f22483c.usingProxy();
        }
        return this.f22482b.usingProxy();
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.f22485e.a()) {
            this.f22483c.setFixedLengthStreamingMode(j);
        } else {
            this.f22482b.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i2) {
        if (!this.f22485e.a()) {
            return this.f22483c.getHeaderField(i2);
        }
        return this.f22482b.getHeaderField(i2);
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.f22485e.a()) {
            return this.f22483c.getContent(clsArr);
        }
        try {
            long contentLength = this.f22482b.getContentLength();
            this.f22481a.f67559e = contentLength;
            onComplete(contentLength);
            return this.f22482b.getContent(clsArr);
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }
}
