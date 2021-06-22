package com.baidu.turbonet.net;

import android.annotation.TargetApi;
import com.baidu.turbonet.net.proxy.ProxyConfig;
import d.a.p0.b.a;
import d.a.p0.b.d.b;
import d.a.p0.b.e.d;
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
    public a f22563a;

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f22564b;

    /* renamed from: c  reason: collision with root package name */
    public d f22565c;

    /* renamed from: d  reason: collision with root package name */
    public TurbonetEngine f22566d;

    /* renamed from: e  reason: collision with root package name */
    public ProxyConfig f22567e;

    @Override // d.a.p0.b.d.b
    public void a(long j) {
        a aVar = this.f22563a;
        aVar.f67663e = j;
        aVar.c();
        a aVar2 = this.f22563a;
        aVar2.f67661c = -12;
        aVar2.d(this.f22566d);
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.f22567e.a()) {
            this.f22565c.addRequestProperty(str, str2);
        } else {
            this.f22564b.addRequestProperty(str, str2);
        }
    }

    @Override // d.a.p0.b.d.b
    public void b(Exception exc, long j) {
        a aVar = this.f22563a;
        aVar.f67663e = j;
        aVar.c();
        this.f22563a.a(exc);
        this.f22563a.d(this.f22566d);
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        d.a.p0.a.a.a("ProxyURLConn", "connect by libtype: " + this.f22567e.toString());
        if (!this.f22567e.a()) {
            this.f22565c.connect();
            return;
        }
        try {
            this.f22564b.connect();
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        d.a.p0.a.a.a("ProxyURLConn", "disconnect by libtype: " + this.f22567e.toString());
        if (!this.f22567e.a()) {
            this.f22565c.disconnect();
        } else {
            this.f22564b.disconnect();
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        HttpURLConnection httpURLConnection = this.f22564b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getCipherSuite();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        if (!this.f22567e.a()) {
            return this.f22565c.getConnectTimeout();
        }
        return this.f22564b.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.f22567e.a()) {
            return this.f22565c.getContent();
        }
        try {
            long contentLength = this.f22564b.getContentLength();
            this.f22563a.f67663e = contentLength;
            onComplete(contentLength);
            return this.f22564b.getContent();
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        if (!this.f22567e.a()) {
            return this.f22565c.getContentEncoding();
        }
        return this.f22564b.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        if (!this.f22567e.a()) {
            return this.f22565c.getContentLength();
        }
        return this.f22564b.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        if (!this.f22567e.a()) {
            return this.f22565c.getContentType();
        }
        return this.f22564b.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        if (!this.f22567e.a()) {
            return this.f22565c.getDate();
        }
        return this.f22564b.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        if (!this.f22567e.a()) {
            return this.f22565c.getDefaultUseCaches();
        }
        return this.f22564b.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        if (!this.f22567e.a()) {
            return this.f22565c.getDoInput();
        }
        return this.f22564b.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        if (!this.f22567e.a()) {
            return this.f22565c.getDoOutput();
        }
        return this.f22564b.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        if (!this.f22567e.a()) {
            return this.f22565c.getErrorStream();
        }
        return this.f22564b.getErrorStream();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        if (!this.f22567e.a()) {
            return this.f22565c.getExpiration();
        }
        return this.f22564b.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.f22567e.a()) {
            return this.f22565c.getHeaderField(str);
        }
        String headerField = this.f22564b.getHeaderField(str);
        this.f22563a.b();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        if (!this.f22567e.a()) {
            return this.f22565c.getHeaderFieldDate(str, j);
        }
        return this.f22564b.getHeaderFieldDate(str, j);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i2) {
        if (!this.f22567e.a()) {
            return this.f22565c.getHeaderFieldInt(str, i2);
        }
        return this.f22564b.getHeaderFieldInt(str, i2);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i2) {
        if (!this.f22567e.a()) {
            return this.f22565c.getHeaderFieldKey(i2);
        }
        return this.f22564b.getHeaderFieldKey(i2);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.f22567e.a()) {
            return this.f22565c.getHeaderFields();
        }
        return this.f22564b.getHeaderFields();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        HttpURLConnection httpURLConnection = this.f22564b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getHostnameVerifier();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        if (!this.f22567e.a()) {
            return this.f22565c.getIfModifiedSince();
        }
        return this.f22564b.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        d.a.p0.a.a.a("ProxyURLConn", "getInputStream by libtype: " + this.f22567e.toString());
        if (!this.f22567e.a()) {
            return this.f22565c.getInputStream();
        }
        try {
            return new d.a.p0.b.d.a(this.f22564b.getInputStream(), this);
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        if (!this.f22567e.a()) {
            return this.f22565c.getInstanceFollowRedirects();
        }
        return this.f22564b.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        if (!this.f22567e.a()) {
            return this.f22565c.getLastModified();
        }
        return this.f22564b.getLastModified();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        HttpURLConnection httpURLConnection = this.f22564b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        HttpURLConnection httpURLConnection = this.f22564b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getLocalPrincipal();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (!this.f22567e.a()) {
            return this.f22565c.getOutputStream();
        }
        return this.f22564b.getOutputStream();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        HttpURLConnection httpURLConnection = this.f22564b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getPeerPrincipal();
        }
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        if (!this.f22567e.a()) {
            return this.f22565c.getPermission();
        }
        return this.f22564b.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        if (!this.f22567e.a()) {
            return this.f22565c.getReadTimeout();
        }
        return this.f22564b.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        if (!this.f22567e.a()) {
            return this.f22565c.getRequestMethod();
        }
        return this.f22564b.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (!this.f22567e.a()) {
            return this.f22565c.getRequestProperties();
        }
        return this.f22564b.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        if (!this.f22567e.a()) {
            return this.f22565c.getRequestProperty(str);
        }
        return this.f22564b.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int i2;
        if (!this.f22567e.a()) {
            i2 = this.f22565c.getResponseCode();
        } else {
            try {
                int responseCode = this.f22564b.getResponseCode();
                this.f22563a.f67662d = responseCode;
                this.f22563a.b();
                if (responseCode != 200) {
                    onComplete(0L);
                }
                i2 = responseCode;
            } catch (IOException e2) {
                b(e2, 0L);
                throw e2;
            }
        }
        d.a.p0.a.a.a("ProxyURLConn", "getResponseCode: " + i2 + " by libtype: " + this.f22567e.toString());
        return i2;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.f22567e.a()) {
            responseMessage = this.f22565c.getResponseMessage();
        } else {
            responseMessage = this.f22564b.getResponseMessage();
        }
        d.a.p0.a.a.a("ProxyURLConn", "getResponseMessage by libtype: " + this.f22567e.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        HttpURLConnection httpURLConnection = this.f22564b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        HttpURLConnection httpURLConnection = this.f22564b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getServerCertificates();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        if (!this.f22567e.a()) {
            return this.f22565c.getURL();
        }
        return this.f22564b.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        if (!this.f22567e.a()) {
            return this.f22565c.getUseCaches();
        }
        return this.f22564b.getUseCaches();
    }

    @Override // d.a.p0.b.d.b
    public void onComplete(long j) {
        a aVar = this.f22563a;
        aVar.f67663e = j;
        aVar.c();
        a aVar2 = this.f22563a;
        aVar2.f67661c = 0;
        aVar2.d(this.f22566d);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i2) {
        if (!this.f22567e.a()) {
            this.f22565c.setChunkedStreamingMode(i2);
        } else {
            this.f22564b.setChunkedStreamingMode(i2);
        }
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i2) {
        if (!this.f22567e.a()) {
            this.f22565c.setConnectTimeout(i2);
        } else {
            this.f22564b.setConnectTimeout(i2);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.f22567e.a()) {
            this.f22565c.setDefaultUseCaches(z);
        } else {
            this.f22564b.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.f22567e.a()) {
            this.f22565c.setDoInput(z);
        } else {
            this.f22564b.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.f22567e.a()) {
            this.f22565c.setDoOutput(z);
        } else {
            this.f22564b.setDoOutput(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i2) {
        if (!this.f22567e.a()) {
            this.f22565c.setFixedLengthStreamingMode(i2);
        } else {
            this.f22564b.setFixedLengthStreamingMode(i2);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        HttpURLConnection httpURLConnection = this.f22564b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.f22567e.a()) {
            this.f22565c.setIfModifiedSince(j);
        } else {
            this.f22564b.setIfModifiedSince(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.f22567e.a()) {
            this.f22565c.setInstanceFollowRedirects(z);
        } else {
            this.f22564b.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i2) {
        if (!this.f22567e.a()) {
            this.f22565c.setReadTimeout(i2);
        } else {
            this.f22564b.setReadTimeout(i2);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.f22567e.a()) {
            this.f22565c.setRequestMethod(str);
            return;
        }
        this.f22564b.setRequestMethod(str);
        this.f22563a.f67660b = str;
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.f22567e.a()) {
            this.f22565c.setRequestProperty(str, str2);
        } else {
            this.f22564b.setRequestProperty(str, str2);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        HttpURLConnection httpURLConnection = this.f22564b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.f22567e.a()) {
            this.f22565c.setUseCaches(z);
        } else {
            this.f22564b.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        if (!this.f22567e.a()) {
            return this.f22565c.usingProxy();
        }
        return this.f22564b.usingProxy();
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.f22567e.a()) {
            this.f22565c.setFixedLengthStreamingMode(j);
        } else {
            this.f22564b.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i2) {
        if (!this.f22567e.a()) {
            return this.f22565c.getHeaderField(i2);
        }
        return this.f22564b.getHeaderField(i2);
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.f22567e.a()) {
            return this.f22565c.getContent(clsArr);
        }
        try {
            long contentLength = this.f22564b.getContentLength();
            this.f22563a.f67663e = contentLength;
            onComplete(contentLength);
            return this.f22564b.getContent(clsArr);
        } catch (IOException e2) {
            b(e2, 0L);
            throw e2;
        }
    }
}
