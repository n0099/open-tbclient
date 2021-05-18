package com.baidu.turbonet.net;

import android.annotation.TargetApi;
import com.baidu.turbonet.net.proxy.ProxyConfig;
import d.a.l0.b.a;
import d.a.l0.b.d.b;
import d.a.l0.b.e.d;
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
    public a f22449a;

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f22450b;

    /* renamed from: c  reason: collision with root package name */
    public d f22451c;

    /* renamed from: d  reason: collision with root package name */
    public TurbonetEngine f22452d;

    /* renamed from: e  reason: collision with root package name */
    public ProxyConfig f22453e;

    @Override // d.a.l0.b.d.b
    public void a(long j) {
        a aVar = this.f22449a;
        aVar.f63791e = j;
        aVar.c();
        a aVar2 = this.f22449a;
        aVar2.f63789c = -12;
        aVar2.d(this.f22452d);
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.f22453e.a()) {
            this.f22451c.addRequestProperty(str, str2);
        } else {
            this.f22450b.addRequestProperty(str, str2);
        }
    }

    @Override // d.a.l0.b.d.b
    public void b(Exception exc, long j) {
        a aVar = this.f22449a;
        aVar.f63791e = j;
        aVar.c();
        this.f22449a.a(exc);
        this.f22449a.d(this.f22452d);
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        d.a.l0.a.a.a("ProxyURLConn", "connect by libtype: " + this.f22453e.toString());
        if (!this.f22453e.a()) {
            this.f22451c.connect();
            return;
        }
        try {
            this.f22450b.connect();
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        d.a.l0.a.a.a("ProxyURLConn", "disconnect by libtype: " + this.f22453e.toString());
        if (!this.f22453e.a()) {
            this.f22451c.disconnect();
        } else {
            this.f22450b.disconnect();
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        HttpURLConnection httpURLConnection = this.f22450b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getCipherSuite();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        if (!this.f22453e.a()) {
            return this.f22451c.getConnectTimeout();
        }
        return this.f22450b.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.f22453e.a()) {
            return this.f22451c.getContent();
        }
        try {
            long contentLength = this.f22450b.getContentLength();
            this.f22449a.f63791e = contentLength;
            onComplete(contentLength);
            return this.f22450b.getContent();
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        if (!this.f22453e.a()) {
            return this.f22451c.getContentEncoding();
        }
        return this.f22450b.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        if (!this.f22453e.a()) {
            return this.f22451c.getContentLength();
        }
        return this.f22450b.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        if (!this.f22453e.a()) {
            return this.f22451c.getContentType();
        }
        return this.f22450b.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        if (!this.f22453e.a()) {
            return this.f22451c.getDate();
        }
        return this.f22450b.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        if (!this.f22453e.a()) {
            return this.f22451c.getDefaultUseCaches();
        }
        return this.f22450b.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        if (!this.f22453e.a()) {
            return this.f22451c.getDoInput();
        }
        return this.f22450b.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        if (!this.f22453e.a()) {
            return this.f22451c.getDoOutput();
        }
        return this.f22450b.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        if (!this.f22453e.a()) {
            return this.f22451c.getErrorStream();
        }
        return this.f22450b.getErrorStream();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        if (!this.f22453e.a()) {
            return this.f22451c.getExpiration();
        }
        return this.f22450b.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.f22453e.a()) {
            return this.f22451c.getHeaderField(str);
        }
        String headerField = this.f22450b.getHeaderField(str);
        this.f22449a.b();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        if (!this.f22453e.a()) {
            return this.f22451c.getHeaderFieldDate(str, j);
        }
        return this.f22450b.getHeaderFieldDate(str, j);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i2) {
        if (!this.f22453e.a()) {
            return this.f22451c.getHeaderFieldInt(str, i2);
        }
        return this.f22450b.getHeaderFieldInt(str, i2);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i2) {
        if (!this.f22453e.a()) {
            return this.f22451c.getHeaderFieldKey(i2);
        }
        return this.f22450b.getHeaderFieldKey(i2);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.f22453e.a()) {
            return this.f22451c.getHeaderFields();
        }
        return this.f22450b.getHeaderFields();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        HttpURLConnection httpURLConnection = this.f22450b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getHostnameVerifier();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        if (!this.f22453e.a()) {
            return this.f22451c.getIfModifiedSince();
        }
        return this.f22450b.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        d.a.l0.a.a.a("ProxyURLConn", "getInputStream by libtype: " + this.f22453e.toString());
        if (!this.f22453e.a()) {
            return this.f22451c.getInputStream();
        }
        try {
            return new d.a.l0.b.d.a(this.f22450b.getInputStream(), this);
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        if (!this.f22453e.a()) {
            return this.f22451c.getInstanceFollowRedirects();
        }
        return this.f22450b.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        if (!this.f22453e.a()) {
            return this.f22451c.getLastModified();
        }
        return this.f22450b.getLastModified();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        HttpURLConnection httpURLConnection = this.f22450b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        HttpURLConnection httpURLConnection = this.f22450b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getLocalPrincipal();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (!this.f22453e.a()) {
            return this.f22451c.getOutputStream();
        }
        return this.f22450b.getOutputStream();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        HttpURLConnection httpURLConnection = this.f22450b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getPeerPrincipal();
        }
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        if (!this.f22453e.a()) {
            return this.f22451c.getPermission();
        }
        return this.f22450b.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        if (!this.f22453e.a()) {
            return this.f22451c.getReadTimeout();
        }
        return this.f22450b.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        if (!this.f22453e.a()) {
            return this.f22451c.getRequestMethod();
        }
        return this.f22450b.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (!this.f22453e.a()) {
            return this.f22451c.getRequestProperties();
        }
        return this.f22450b.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        if (!this.f22453e.a()) {
            return this.f22451c.getRequestProperty(str);
        }
        return this.f22450b.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int i2;
        if (!this.f22453e.a()) {
            i2 = this.f22451c.getResponseCode();
        } else {
            try {
                int responseCode = this.f22450b.getResponseCode();
                this.f22449a.f63790d = responseCode;
                this.f22449a.b();
                if (responseCode != 200) {
                    onComplete(0L);
                }
                i2 = responseCode;
            } catch (IOException e2) {
                b(e2, 0L);
                throw e2;
            }
        }
        d.a.l0.a.a.a("ProxyURLConn", "getResponseCode: " + i2 + " by libtype: " + this.f22453e.toString());
        return i2;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.f22453e.a()) {
            responseMessage = this.f22451c.getResponseMessage();
        } else {
            responseMessage = this.f22450b.getResponseMessage();
        }
        d.a.l0.a.a.a("ProxyURLConn", "getResponseMessage by libtype: " + this.f22453e.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        HttpURLConnection httpURLConnection = this.f22450b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        HttpURLConnection httpURLConnection = this.f22450b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getServerCertificates();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        if (!this.f22453e.a()) {
            return this.f22451c.getURL();
        }
        return this.f22450b.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        if (!this.f22453e.a()) {
            return this.f22451c.getUseCaches();
        }
        return this.f22450b.getUseCaches();
    }

    @Override // d.a.l0.b.d.b
    public void onComplete(long j) {
        a aVar = this.f22449a;
        aVar.f63791e = j;
        aVar.c();
        a aVar2 = this.f22449a;
        aVar2.f63789c = 0;
        aVar2.d(this.f22452d);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i2) {
        if (!this.f22453e.a()) {
            this.f22451c.setChunkedStreamingMode(i2);
        } else {
            this.f22450b.setChunkedStreamingMode(i2);
        }
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i2) {
        if (!this.f22453e.a()) {
            this.f22451c.setConnectTimeout(i2);
        } else {
            this.f22450b.setConnectTimeout(i2);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.f22453e.a()) {
            this.f22451c.setDefaultUseCaches(z);
        } else {
            this.f22450b.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.f22453e.a()) {
            this.f22451c.setDoInput(z);
        } else {
            this.f22450b.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.f22453e.a()) {
            this.f22451c.setDoOutput(z);
        } else {
            this.f22450b.setDoOutput(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i2) {
        if (!this.f22453e.a()) {
            this.f22451c.setFixedLengthStreamingMode(i2);
        } else {
            this.f22450b.setFixedLengthStreamingMode(i2);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        HttpURLConnection httpURLConnection = this.f22450b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.f22453e.a()) {
            this.f22451c.setIfModifiedSince(j);
        } else {
            this.f22450b.setIfModifiedSince(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.f22453e.a()) {
            this.f22451c.setInstanceFollowRedirects(z);
        } else {
            this.f22450b.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i2) {
        if (!this.f22453e.a()) {
            this.f22451c.setReadTimeout(i2);
        } else {
            this.f22450b.setReadTimeout(i2);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.f22453e.a()) {
            this.f22451c.setRequestMethod(str);
            return;
        }
        this.f22450b.setRequestMethod(str);
        this.f22449a.f63788b = str;
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.f22453e.a()) {
            this.f22451c.setRequestProperty(str, str2);
        } else {
            this.f22450b.setRequestProperty(str, str2);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        HttpURLConnection httpURLConnection = this.f22450b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.f22453e.a()) {
            this.f22451c.setUseCaches(z);
        } else {
            this.f22450b.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        if (!this.f22453e.a()) {
            return this.f22451c.usingProxy();
        }
        return this.f22450b.usingProxy();
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.f22453e.a()) {
            this.f22451c.setFixedLengthStreamingMode(j);
        } else {
            this.f22450b.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i2) {
        if (!this.f22453e.a()) {
            return this.f22451c.getHeaderField(i2);
        }
        return this.f22450b.getHeaderField(i2);
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.f22453e.a()) {
            return this.f22451c.getContent(clsArr);
        }
        try {
            long contentLength = this.f22450b.getContentLength();
            this.f22449a.f63791e = contentLength;
            onComplete(contentLength);
            return this.f22450b.getContent(clsArr);
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }
}
