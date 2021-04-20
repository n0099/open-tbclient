package com.baidu.turbonet.net;

import android.annotation.TargetApi;
import com.baidu.turbonet.net.proxy.ProxyConfig;
import d.b.j0.b.a;
import d.b.j0.b.d.b;
import d.b.j0.b.e.d;
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
    public a f22499a;

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f22500b;

    /* renamed from: c  reason: collision with root package name */
    public d f22501c;

    /* renamed from: d  reason: collision with root package name */
    public TurbonetEngine f22502d;

    /* renamed from: e  reason: collision with root package name */
    public ProxyConfig f22503e;

    @Override // d.b.j0.b.d.b
    public void a(Exception exc, long j) {
        a aVar = this.f22499a;
        aVar.f64496e = j;
        aVar.c();
        this.f22499a.a(exc);
        this.f22499a.d(this.f22502d);
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (!this.f22503e.a()) {
            this.f22501c.addRequestProperty(str, str2);
        } else {
            this.f22500b.addRequestProperty(str, str2);
        }
    }

    @Override // d.b.j0.b.d.b
    public void b(long j) {
        a aVar = this.f22499a;
        aVar.f64496e = j;
        aVar.c();
        a aVar2 = this.f22499a;
        aVar2.f64494c = -12;
        aVar2.d(this.f22502d);
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        d.b.j0.a.a.a("ProxyURLConn", "connect by libtype: " + this.f22503e.toString());
        if (!this.f22503e.a()) {
            this.f22501c.connect();
            return;
        }
        try {
            this.f22500b.connect();
        } catch (IOException e2) {
            a(e2, 0L);
            throw e2;
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        d.b.j0.a.a.a("ProxyURLConn", "disconnect by libtype: " + this.f22503e.toString());
        if (!this.f22503e.a()) {
            this.f22501c.disconnect();
        } else {
            this.f22500b.disconnect();
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        HttpURLConnection httpURLConnection = this.f22500b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getCipherSuite();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        if (!this.f22503e.a()) {
            return this.f22501c.getConnectTimeout();
        }
        return this.f22500b.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        if (!this.f22503e.a()) {
            return this.f22501c.getContent();
        }
        try {
            long contentLength = this.f22500b.getContentLength();
            this.f22499a.f64496e = contentLength;
            onComplete(contentLength);
            return this.f22500b.getContent();
        } catch (IOException e2) {
            a(e2, 0L);
            throw e2;
        }
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        if (!this.f22503e.a()) {
            return this.f22501c.getContentEncoding();
        }
        return this.f22500b.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        if (!this.f22503e.a()) {
            return this.f22501c.getContentLength();
        }
        return this.f22500b.getContentLength();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        if (!this.f22503e.a()) {
            return this.f22501c.getContentType();
        }
        return this.f22500b.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        if (!this.f22503e.a()) {
            return this.f22501c.getDate();
        }
        return this.f22500b.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        if (!this.f22503e.a()) {
            return this.f22501c.getDefaultUseCaches();
        }
        return this.f22500b.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        if (!this.f22503e.a()) {
            return this.f22501c.getDoInput();
        }
        return this.f22500b.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        if (!this.f22503e.a()) {
            return this.f22501c.getDoOutput();
        }
        return this.f22500b.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        if (!this.f22503e.a()) {
            return this.f22501c.getErrorStream();
        }
        return this.f22500b.getErrorStream();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        if (!this.f22503e.a()) {
            return this.f22501c.getExpiration();
        }
        return this.f22500b.getExpiration();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        if (!this.f22503e.a()) {
            return this.f22501c.getHeaderField(str);
        }
        String headerField = this.f22500b.getHeaderField(str);
        this.f22499a.b();
        return headerField;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        if (!this.f22503e.a()) {
            return this.f22501c.getHeaderFieldDate(str, j);
        }
        return this.f22500b.getHeaderFieldDate(str, j);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        if (!this.f22503e.a()) {
            return this.f22501c.getHeaderFieldInt(str, i);
        }
        return this.f22500b.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        if (!this.f22503e.a()) {
            return this.f22501c.getHeaderFieldKey(i);
        }
        return this.f22500b.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        if (!this.f22503e.a()) {
            return this.f22501c.getHeaderFields();
        }
        return this.f22500b.getHeaderFields();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        HttpURLConnection httpURLConnection = this.f22500b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getHostnameVerifier();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        if (!this.f22503e.a()) {
            return this.f22501c.getIfModifiedSince();
        }
        return this.f22500b.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        d.b.j0.a.a.a("ProxyURLConn", "getInputStream by libtype: " + this.f22503e.toString());
        if (!this.f22503e.a()) {
            return this.f22501c.getInputStream();
        }
        try {
            return new d.b.j0.b.d.a(this.f22500b.getInputStream(), this);
        } catch (IOException e2) {
            a(e2, 0L);
            throw e2;
        }
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        if (!this.f22503e.a()) {
            return this.f22501c.getInstanceFollowRedirects();
        }
        return this.f22500b.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        if (!this.f22503e.a()) {
            return this.f22501c.getLastModified();
        }
        return this.f22500b.getLastModified();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        HttpURLConnection httpURLConnection = this.f22500b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getLocalCertificates();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        HttpURLConnection httpURLConnection = this.f22500b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getLocalPrincipal();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (!this.f22503e.a()) {
            return this.f22501c.getOutputStream();
        }
        return this.f22500b.getOutputStream();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        HttpURLConnection httpURLConnection = this.f22500b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getPeerPrincipal();
        }
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        if (!this.f22503e.a()) {
            return this.f22501c.getPermission();
        }
        return this.f22500b.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        if (!this.f22503e.a()) {
            return this.f22501c.getReadTimeout();
        }
        return this.f22500b.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        if (!this.f22503e.a()) {
            return this.f22501c.getRequestMethod();
        }
        return this.f22500b.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (!this.f22503e.a()) {
            return this.f22501c.getRequestProperties();
        }
        return this.f22500b.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        if (!this.f22503e.a()) {
            return this.f22501c.getRequestProperty(str);
        }
        return this.f22500b.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        int i;
        if (!this.f22503e.a()) {
            i = this.f22501c.getResponseCode();
        } else {
            try {
                int responseCode = this.f22500b.getResponseCode();
                this.f22499a.f64495d = responseCode;
                this.f22499a.b();
                if (responseCode != 200) {
                    onComplete(0L);
                }
                i = responseCode;
            } catch (IOException e2) {
                a(e2, 0L);
                throw e2;
            }
        }
        d.b.j0.a.a.a("ProxyURLConn", "getResponseCode: " + i + " by libtype: " + this.f22503e.toString());
        return i;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        String responseMessage;
        if (!this.f22503e.a()) {
            responseMessage = this.f22501c.getResponseMessage();
        } else {
            responseMessage = this.f22500b.getResponseMessage();
        }
        d.b.j0.a.a.a("ProxyURLConn", "getResponseMessage by libtype: " + this.f22503e.toString() + " Message: " + responseMessage);
        return responseMessage;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        HttpURLConnection httpURLConnection = this.f22500b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getSSLSocketFactory();
        }
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        HttpURLConnection httpURLConnection = this.f22500b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) httpURLConnection).getServerCertificates();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        if (!this.f22503e.a()) {
            return this.f22501c.getURL();
        }
        return this.f22500b.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        if (!this.f22503e.a()) {
            return this.f22501c.getUseCaches();
        }
        return this.f22500b.getUseCaches();
    }

    @Override // d.b.j0.b.d.b
    public void onComplete(long j) {
        a aVar = this.f22499a;
        aVar.f64496e = j;
        aVar.c();
        a aVar2 = this.f22499a;
        aVar2.f64494c = 0;
        aVar2.d(this.f22502d);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        if (!this.f22503e.a()) {
            this.f22501c.setChunkedStreamingMode(i);
        } else {
            this.f22500b.setChunkedStreamingMode(i);
        }
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        if (!this.f22503e.a()) {
            this.f22501c.setConnectTimeout(i);
        } else {
            this.f22500b.setConnectTimeout(i);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        if (!this.f22503e.a()) {
            this.f22501c.setDefaultUseCaches(z);
        } else {
            this.f22500b.setDefaultUseCaches(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        if (!this.f22503e.a()) {
            this.f22501c.setDoInput(z);
        } else {
            this.f22500b.setDoInput(z);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        if (!this.f22503e.a()) {
            this.f22501c.setDoOutput(z);
        } else {
            this.f22500b.setDoOutput(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        if (!this.f22503e.a()) {
            this.f22501c.setFixedLengthStreamingMode(i);
        } else {
            this.f22500b.setFixedLengthStreamingMode(i);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        HttpURLConnection httpURLConnection = this.f22500b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(hostnameVerifier);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        if (!this.f22503e.a()) {
            this.f22501c.setIfModifiedSince(j);
        } else {
            this.f22500b.setIfModifiedSince(j);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        if (!this.f22503e.a()) {
            this.f22501c.setInstanceFollowRedirects(z);
        } else {
            this.f22500b.setInstanceFollowRedirects(z);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        if (!this.f22503e.a()) {
            this.f22501c.setReadTimeout(i);
        } else {
            this.f22500b.setReadTimeout(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        if (!this.f22503e.a()) {
            this.f22501c.setRequestMethod(str);
            return;
        }
        this.f22500b.setRequestMethod(str);
        this.f22499a.f64493b = str;
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (!this.f22503e.a()) {
            this.f22501c.setRequestProperty(str, str2);
        } else {
            this.f22500b.setRequestProperty(str, str2);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        HttpURLConnection httpURLConnection = this.f22500b;
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        if (!this.f22503e.a()) {
            this.f22501c.setUseCaches(z);
        } else {
            this.f22500b.setUseCaches(z);
        }
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        if (!this.f22503e.a()) {
            return this.f22501c.usingProxy();
        }
        return this.f22500b.usingProxy();
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        if (!this.f22503e.a()) {
            this.f22501c.setFixedLengthStreamingMode(j);
        } else {
            this.f22500b.setFixedLengthStreamingMode(j);
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        if (!this.f22503e.a()) {
            return this.f22501c.getHeaderField(i);
        }
        return this.f22500b.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        if (!this.f22503e.a()) {
            return this.f22501c.getContent(clsArr);
        }
        try {
            long contentLength = this.f22500b.getContentLength();
            this.f22499a.f64496e = contentLength;
            onComplete(contentLength);
            return this.f22500b.getContent(clsArr);
        } catch (IOException e2) {
            a(e2, 0L);
            throw e2;
        }
    }
}
