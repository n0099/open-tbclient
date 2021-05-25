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
    public a f22378a;

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f22379b;

    /* renamed from: c  reason: collision with root package name */
    public d f22380c;

    /* renamed from: d  reason: collision with root package name */
    public TurbonetEngine f22381d;

    /* renamed from: e  reason: collision with root package name */
    public ProxyConfig f22382e;

    @Override // d.a.o0.b.d.b
    public void a(long j) {
        a aVar = this.f22378a;
        aVar.f63841e = j;
        aVar.c();
        a aVar2 = this.f22378a;
        aVar2.f63839c = -12;
        aVar2.d(this.f22381d);
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.f22382e.a()) {
            this.f22380c.addRequestProperty(str, str2);
        } else {
            this.f22379b.addRequestProperty(str, str2);
        }
    }

    @Override // d.a.o0.b.d.b
    public void b(Exception exc, long j) {
        a aVar = this.f22378a;
        aVar.f63841e = j;
        aVar.c();
        this.f22378a.a(exc);
        this.f22378a.d(this.f22381d);
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        d.a.o0.a.a.a("ProxyURLConn", "connect by libtype: " + this.f22382e.toString());
        if (!this.f22382e.a()) {
            this.f22380c.connect();
            return;
        }
        try {
            this.f22379b.connect();
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        d.a.o0.a.a.a("ProxyURLConn", "disconnect by libtype: " + this.f22382e.toString());
        if (!this.f22382e.a()) {
            this.f22380c.disconnect();
        } else {
            this.f22379b.disconnect();
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        HttpURLConnection httpURLConnection = this.f22379b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getCipherSuite();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        if (!this.f22382e.a()) {
            return this.f22380c.getConnectTimeout();
        }
        return this.f22379b.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.f22382e.a()) {
            return this.f22380c.getContent();
        }
        try {
            long contentLength = this.f22379b.getContentLength();
            this.f22378a.f63841e = contentLength;
            onComplete(contentLength);
            return this.f22379b.getContent();
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        if (!this.f22382e.a()) {
            return this.f22380c.getContentEncoding();
        }
        return this.f22379b.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        if (!this.f22382e.a()) {
            return this.f22380c.getContentLength();
        }
        return this.f22379b.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        if (!this.f22382e.a()) {
            return this.f22380c.getContentType();
        }
        return this.f22379b.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        if (!this.f22382e.a()) {
            return this.f22380c.getDate();
        }
        return this.f22379b.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        if (!this.f22382e.a()) {
            return this.f22380c.getDefaultUseCaches();
        }
        return this.f22379b.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        if (!this.f22382e.a()) {
            return this.f22380c.getDoInput();
        }
        return this.f22379b.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        if (!this.f22382e.a()) {
            return this.f22380c.getDoOutput();
        }
        return this.f22379b.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        if (!this.f22382e.a()) {
            return this.f22380c.getErrorStream();
        }
        return this.f22379b.getErrorStream();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        if (!this.f22382e.a()) {
            return this.f22380c.getExpiration();
        }
        return this.f22379b.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.f22382e.a()) {
            return this.f22380c.getHeaderField(str);
        }
        String headerField = this.f22379b.getHeaderField(str);
        this.f22378a.b();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        if (!this.f22382e.a()) {
            return this.f22380c.getHeaderFieldDate(str, j);
        }
        return this.f22379b.getHeaderFieldDate(str, j);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i2) {
        if (!this.f22382e.a()) {
            return this.f22380c.getHeaderFieldInt(str, i2);
        }
        return this.f22379b.getHeaderFieldInt(str, i2);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i2) {
        if (!this.f22382e.a()) {
            return this.f22380c.getHeaderFieldKey(i2);
        }
        return this.f22379b.getHeaderFieldKey(i2);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.f22382e.a()) {
            return this.f22380c.getHeaderFields();
        }
        return this.f22379b.getHeaderFields();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        HttpURLConnection httpURLConnection = this.f22379b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getHostnameVerifier();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        if (!this.f22382e.a()) {
            return this.f22380c.getIfModifiedSince();
        }
        return this.f22379b.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        d.a.o0.a.a.a("ProxyURLConn", "getInputStream by libtype: " + this.f22382e.toString());
        if (!this.f22382e.a()) {
            return this.f22380c.getInputStream();
        }
        try {
            return new d.a.o0.b.d.a(this.f22379b.getInputStream(), this);
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        if (!this.f22382e.a()) {
            return this.f22380c.getInstanceFollowRedirects();
        }
        return this.f22379b.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        if (!this.f22382e.a()) {
            return this.f22380c.getLastModified();
        }
        return this.f22379b.getLastModified();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        HttpURLConnection httpURLConnection = this.f22379b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        HttpURLConnection httpURLConnection = this.f22379b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getLocalPrincipal();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (!this.f22382e.a()) {
            return this.f22380c.getOutputStream();
        }
        return this.f22379b.getOutputStream();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        HttpURLConnection httpURLConnection = this.f22379b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getPeerPrincipal();
        }
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        if (!this.f22382e.a()) {
            return this.f22380c.getPermission();
        }
        return this.f22379b.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        if (!this.f22382e.a()) {
            return this.f22380c.getReadTimeout();
        }
        return this.f22379b.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        if (!this.f22382e.a()) {
            return this.f22380c.getRequestMethod();
        }
        return this.f22379b.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (!this.f22382e.a()) {
            return this.f22380c.getRequestProperties();
        }
        return this.f22379b.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        if (!this.f22382e.a()) {
            return this.f22380c.getRequestProperty(str);
        }
        return this.f22379b.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int i2;
        if (!this.f22382e.a()) {
            i2 = this.f22380c.getResponseCode();
        } else {
            try {
                int responseCode = this.f22379b.getResponseCode();
                this.f22378a.f63840d = responseCode;
                this.f22378a.b();
                if (responseCode != 200) {
                    onComplete(0L);
                }
                i2 = responseCode;
            } catch (IOException e2) {
                b(e2, 0L);
                throw e2;
            }
        }
        d.a.o0.a.a.a("ProxyURLConn", "getResponseCode: " + i2 + " by libtype: " + this.f22382e.toString());
        return i2;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.f22382e.a()) {
            responseMessage = this.f22380c.getResponseMessage();
        } else {
            responseMessage = this.f22379b.getResponseMessage();
        }
        d.a.o0.a.a.a("ProxyURLConn", "getResponseMessage by libtype: " + this.f22382e.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        HttpURLConnection httpURLConnection = this.f22379b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        HttpURLConnection httpURLConnection = this.f22379b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getServerCertificates();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        if (!this.f22382e.a()) {
            return this.f22380c.getURL();
        }
        return this.f22379b.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        if (!this.f22382e.a()) {
            return this.f22380c.getUseCaches();
        }
        return this.f22379b.getUseCaches();
    }

    @Override // d.a.o0.b.d.b
    public void onComplete(long j) {
        a aVar = this.f22378a;
        aVar.f63841e = j;
        aVar.c();
        a aVar2 = this.f22378a;
        aVar2.f63839c = 0;
        aVar2.d(this.f22381d);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i2) {
        if (!this.f22382e.a()) {
            this.f22380c.setChunkedStreamingMode(i2);
        } else {
            this.f22379b.setChunkedStreamingMode(i2);
        }
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i2) {
        if (!this.f22382e.a()) {
            this.f22380c.setConnectTimeout(i2);
        } else {
            this.f22379b.setConnectTimeout(i2);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.f22382e.a()) {
            this.f22380c.setDefaultUseCaches(z);
        } else {
            this.f22379b.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.f22382e.a()) {
            this.f22380c.setDoInput(z);
        } else {
            this.f22379b.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.f22382e.a()) {
            this.f22380c.setDoOutput(z);
        } else {
            this.f22379b.setDoOutput(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i2) {
        if (!this.f22382e.a()) {
            this.f22380c.setFixedLengthStreamingMode(i2);
        } else {
            this.f22379b.setFixedLengthStreamingMode(i2);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        HttpURLConnection httpURLConnection = this.f22379b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.f22382e.a()) {
            this.f22380c.setIfModifiedSince(j);
        } else {
            this.f22379b.setIfModifiedSince(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.f22382e.a()) {
            this.f22380c.setInstanceFollowRedirects(z);
        } else {
            this.f22379b.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i2) {
        if (!this.f22382e.a()) {
            this.f22380c.setReadTimeout(i2);
        } else {
            this.f22379b.setReadTimeout(i2);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.f22382e.a()) {
            this.f22380c.setRequestMethod(str);
            return;
        }
        this.f22379b.setRequestMethod(str);
        this.f22378a.f63838b = str;
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.f22382e.a()) {
            this.f22380c.setRequestProperty(str, str2);
        } else {
            this.f22379b.setRequestProperty(str, str2);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        HttpURLConnection httpURLConnection = this.f22379b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.f22382e.a()) {
            this.f22380c.setUseCaches(z);
        } else {
            this.f22379b.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        if (!this.f22382e.a()) {
            return this.f22380c.usingProxy();
        }
        return this.f22379b.usingProxy();
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.f22382e.a()) {
            this.f22380c.setFixedLengthStreamingMode(j);
        } else {
            this.f22379b.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i2) {
        if (!this.f22382e.a()) {
            return this.f22380c.getHeaderField(i2);
        }
        return this.f22379b.getHeaderField(i2);
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.f22382e.a()) {
            return this.f22380c.getContent(clsArr);
        }
        try {
            long contentLength = this.f22379b.getContentLength();
            this.f22378a.f63841e = contentLength;
            onComplete(contentLength);
            return this.f22379b.getContent(clsArr);
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }
}
