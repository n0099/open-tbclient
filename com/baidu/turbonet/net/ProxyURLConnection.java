package com.baidu.turbonet.net;

import android.annotation.TargetApi;
import com.baidu.turbonet.net.proxy.ProxyConfig;
import d.a.k0.b.a;
import d.a.k0.b.d.b;
import d.a.k0.b.e.d;
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
    public a f23204a;

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f23205b;

    /* renamed from: c  reason: collision with root package name */
    public d f23206c;

    /* renamed from: d  reason: collision with root package name */
    public TurbonetEngine f23207d;

    /* renamed from: e  reason: collision with root package name */
    public ProxyConfig f23208e;

    @Override // d.a.k0.b.d.b
    public void a(long j) {
        a aVar = this.f23204a;
        aVar.f63087e = j;
        aVar.c();
        a aVar2 = this.f23204a;
        aVar2.f63085c = -12;
        aVar2.d(this.f23207d);
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.f23208e.a()) {
            this.f23206c.addRequestProperty(str, str2);
        } else {
            this.f23205b.addRequestProperty(str, str2);
        }
    }

    @Override // d.a.k0.b.d.b
    public void b(Exception exc, long j) {
        a aVar = this.f23204a;
        aVar.f63087e = j;
        aVar.c();
        this.f23204a.a(exc);
        this.f23204a.d(this.f23207d);
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        d.a.k0.a.a.a("ProxyURLConn", "connect by libtype: " + this.f23208e.toString());
        if (!this.f23208e.a()) {
            this.f23206c.connect();
            return;
        }
        try {
            this.f23205b.connect();
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        d.a.k0.a.a.a("ProxyURLConn", "disconnect by libtype: " + this.f23208e.toString());
        if (!this.f23208e.a()) {
            this.f23206c.disconnect();
        } else {
            this.f23205b.disconnect();
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        HttpURLConnection httpURLConnection = this.f23205b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getCipherSuite();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        if (!this.f23208e.a()) {
            return this.f23206c.getConnectTimeout();
        }
        return this.f23205b.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.f23208e.a()) {
            return this.f23206c.getContent();
        }
        try {
            long contentLength = this.f23205b.getContentLength();
            this.f23204a.f63087e = contentLength;
            onComplete(contentLength);
            return this.f23205b.getContent();
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        if (!this.f23208e.a()) {
            return this.f23206c.getContentEncoding();
        }
        return this.f23205b.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        if (!this.f23208e.a()) {
            return this.f23206c.getContentLength();
        }
        return this.f23205b.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        if (!this.f23208e.a()) {
            return this.f23206c.getContentType();
        }
        return this.f23205b.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        if (!this.f23208e.a()) {
            return this.f23206c.getDate();
        }
        return this.f23205b.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        if (!this.f23208e.a()) {
            return this.f23206c.getDefaultUseCaches();
        }
        return this.f23205b.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        if (!this.f23208e.a()) {
            return this.f23206c.getDoInput();
        }
        return this.f23205b.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        if (!this.f23208e.a()) {
            return this.f23206c.getDoOutput();
        }
        return this.f23205b.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        if (!this.f23208e.a()) {
            return this.f23206c.getErrorStream();
        }
        return this.f23205b.getErrorStream();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        if (!this.f23208e.a()) {
            return this.f23206c.getExpiration();
        }
        return this.f23205b.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.f23208e.a()) {
            return this.f23206c.getHeaderField(str);
        }
        String headerField = this.f23205b.getHeaderField(str);
        this.f23204a.b();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        if (!this.f23208e.a()) {
            return this.f23206c.getHeaderFieldDate(str, j);
        }
        return this.f23205b.getHeaderFieldDate(str, j);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i2) {
        if (!this.f23208e.a()) {
            return this.f23206c.getHeaderFieldInt(str, i2);
        }
        return this.f23205b.getHeaderFieldInt(str, i2);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i2) {
        if (!this.f23208e.a()) {
            return this.f23206c.getHeaderFieldKey(i2);
        }
        return this.f23205b.getHeaderFieldKey(i2);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.f23208e.a()) {
            return this.f23206c.getHeaderFields();
        }
        return this.f23205b.getHeaderFields();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        HttpURLConnection httpURLConnection = this.f23205b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getHostnameVerifier();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        if (!this.f23208e.a()) {
            return this.f23206c.getIfModifiedSince();
        }
        return this.f23205b.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        d.a.k0.a.a.a("ProxyURLConn", "getInputStream by libtype: " + this.f23208e.toString());
        if (!this.f23208e.a()) {
            return this.f23206c.getInputStream();
        }
        try {
            return new d.a.k0.b.d.a(this.f23205b.getInputStream(), this);
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        if (!this.f23208e.a()) {
            return this.f23206c.getInstanceFollowRedirects();
        }
        return this.f23205b.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        if (!this.f23208e.a()) {
            return this.f23206c.getLastModified();
        }
        return this.f23205b.getLastModified();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        HttpURLConnection httpURLConnection = this.f23205b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        HttpURLConnection httpURLConnection = this.f23205b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getLocalPrincipal();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (!this.f23208e.a()) {
            return this.f23206c.getOutputStream();
        }
        return this.f23205b.getOutputStream();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        HttpURLConnection httpURLConnection = this.f23205b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getPeerPrincipal();
        }
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        if (!this.f23208e.a()) {
            return this.f23206c.getPermission();
        }
        return this.f23205b.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        if (!this.f23208e.a()) {
            return this.f23206c.getReadTimeout();
        }
        return this.f23205b.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        if (!this.f23208e.a()) {
            return this.f23206c.getRequestMethod();
        }
        return this.f23205b.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (!this.f23208e.a()) {
            return this.f23206c.getRequestProperties();
        }
        return this.f23205b.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        if (!this.f23208e.a()) {
            return this.f23206c.getRequestProperty(str);
        }
        return this.f23205b.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int i2;
        if (!this.f23208e.a()) {
            i2 = this.f23206c.getResponseCode();
        } else {
            try {
                int responseCode = this.f23205b.getResponseCode();
                this.f23204a.f63086d = responseCode;
                this.f23204a.b();
                if (responseCode != 200) {
                    onComplete(0L);
                }
                i2 = responseCode;
            } catch (IOException e2) {
                b(e2, 0L);
                throw e2;
            }
        }
        d.a.k0.a.a.a("ProxyURLConn", "getResponseCode: " + i2 + " by libtype: " + this.f23208e.toString());
        return i2;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.f23208e.a()) {
            responseMessage = this.f23206c.getResponseMessage();
        } else {
            responseMessage = this.f23205b.getResponseMessage();
        }
        d.a.k0.a.a.a("ProxyURLConn", "getResponseMessage by libtype: " + this.f23208e.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        HttpURLConnection httpURLConnection = this.f23205b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        HttpURLConnection httpURLConnection = this.f23205b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getServerCertificates();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        if (!this.f23208e.a()) {
            return this.f23206c.getURL();
        }
        return this.f23205b.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        if (!this.f23208e.a()) {
            return this.f23206c.getUseCaches();
        }
        return this.f23205b.getUseCaches();
    }

    @Override // d.a.k0.b.d.b
    public void onComplete(long j) {
        a aVar = this.f23204a;
        aVar.f63087e = j;
        aVar.c();
        a aVar2 = this.f23204a;
        aVar2.f63085c = 0;
        aVar2.d(this.f23207d);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i2) {
        if (!this.f23208e.a()) {
            this.f23206c.setChunkedStreamingMode(i2);
        } else {
            this.f23205b.setChunkedStreamingMode(i2);
        }
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i2) {
        if (!this.f23208e.a()) {
            this.f23206c.setConnectTimeout(i2);
        } else {
            this.f23205b.setConnectTimeout(i2);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.f23208e.a()) {
            this.f23206c.setDefaultUseCaches(z);
        } else {
            this.f23205b.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.f23208e.a()) {
            this.f23206c.setDoInput(z);
        } else {
            this.f23205b.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.f23208e.a()) {
            this.f23206c.setDoOutput(z);
        } else {
            this.f23205b.setDoOutput(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i2) {
        if (!this.f23208e.a()) {
            this.f23206c.setFixedLengthStreamingMode(i2);
        } else {
            this.f23205b.setFixedLengthStreamingMode(i2);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        HttpURLConnection httpURLConnection = this.f23205b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.f23208e.a()) {
            this.f23206c.setIfModifiedSince(j);
        } else {
            this.f23205b.setIfModifiedSince(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.f23208e.a()) {
            this.f23206c.setInstanceFollowRedirects(z);
        } else {
            this.f23205b.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i2) {
        if (!this.f23208e.a()) {
            this.f23206c.setReadTimeout(i2);
        } else {
            this.f23205b.setReadTimeout(i2);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.f23208e.a()) {
            this.f23206c.setRequestMethod(str);
            return;
        }
        this.f23205b.setRequestMethod(str);
        this.f23204a.f63084b = str;
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.f23208e.a()) {
            this.f23206c.setRequestProperty(str, str2);
        } else {
            this.f23205b.setRequestProperty(str, str2);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        HttpURLConnection httpURLConnection = this.f23205b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.f23208e.a()) {
            this.f23206c.setUseCaches(z);
        } else {
            this.f23205b.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        if (!this.f23208e.a()) {
            return this.f23206c.usingProxy();
        }
        return this.f23205b.usingProxy();
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.f23208e.a()) {
            this.f23206c.setFixedLengthStreamingMode(j);
        } else {
            this.f23205b.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i2) {
        if (!this.f23208e.a()) {
            return this.f23206c.getHeaderField(i2);
        }
        return this.f23205b.getHeaderField(i2);
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.f23208e.a()) {
            return this.f23206c.getContent(clsArr);
        }
        try {
            long contentLength = this.f23205b.getContentLength();
            this.f23204a.f63087e = contentLength;
            onComplete(contentLength);
            return this.f23205b.getContent(clsArr);
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }
}
