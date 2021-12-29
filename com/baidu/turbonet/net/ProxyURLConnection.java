package com.baidu.turbonet.net;

import android.annotation.TargetApi;
import androidx.core.view.InputDeviceCompat;
import c.a.u0.b.a;
import c.a.u0.b.d.b;
import c.a.u0.b.e.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
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
/* loaded from: classes13.dex */
public class ProxyURLConnection extends HttpsURLConnection implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f52236b;

    /* renamed from: c  reason: collision with root package name */
    public d f52237c;

    /* renamed from: d  reason: collision with root package name */
    public TurbonetEngine f52238d;

    /* renamed from: e  reason: collision with root package name */
    public ProxyConfig f52239e;

    @Override // c.a.u0.b.d.b
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            a aVar = this.a;
            aVar.f27100e = j2;
            aVar.c();
            a aVar2 = this.a;
            aVar2.f27098c = -12;
            aVar2.d(this.f52238d);
        }
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            if (!this.f52239e.a()) {
                this.f52237c.addRequestProperty(str, str2);
            } else {
                this.f52236b.addRequestProperty(str, str2);
            }
        }
    }

    @Override // c.a.u0.b.d.b
    public void b(Exception exc, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, exc, j2) == null) {
            a aVar = this.a;
            aVar.f27100e = j2;
            aVar.c();
            this.a.a(exc);
            this.a.d(this.f52238d);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.u0.a.a.a("ProxyURLConn", "connect by libtype: " + this.f52239e.toString());
            if (!this.f52239e.a()) {
                this.f52237c.connect();
                return;
            }
            try {
                this.f52236b.connect();
            } catch (IOException e2) {
                b(e2, 0L);
                throw e2;
            }
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.u0.a.a.a("ProxyURLConn", "disconnect by libtype: " + this.f52239e.toString());
            if (!this.f52239e.a()) {
                this.f52237c.disconnect();
            } else {
                this.f52236b.disconnect();
            }
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            HttpURLConnection httpURLConnection = this.f52236b;
            if (httpURLConnection instanceof HttpsURLConnection) {
                return ((HttpsURLConnection) httpURLConnection).getCipherSuite();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getConnectTimeout();
            }
            return this.f52236b.getConnectTimeout();
        }
        return invokeV.intValue;
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getContent();
            }
            try {
                long contentLength = this.f52236b.getContentLength();
                this.a.f27100e = contentLength;
                onComplete(contentLength);
                return this.f52236b.getContent();
            } catch (IOException e2) {
                b(e2, 0L);
                throw e2;
            }
        }
        return invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getContentEncoding();
            }
            return this.f52236b.getContentEncoding();
        }
        return (String) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getContentLength();
            }
            return this.f52236b.getContentLength();
        }
        return invokeV.intValue;
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getContentType();
            }
            return this.f52236b.getContentType();
        }
        return (String) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public long getDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getDate();
            }
            return this.f52236b.getDate();
        }
        return invokeV.longValue;
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getDefaultUseCaches();
            }
            return this.f52236b.getDefaultUseCaches();
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getDoInput();
            }
            return this.f52236b.getDoInput();
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getDoOutput();
            }
            return this.f52236b.getDoOutput();
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getErrorStream();
            }
            return this.f52236b.getErrorStream();
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getExpiration();
            }
            return this.f52236b.getExpiration();
        }
        return invokeV.longValue;
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getHeaderField(str);
            }
            String headerField = this.f52236b.getHeaderField(str);
            this.a.b();
            return headerField;
        }
        return (String) invokeL.objValue;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048596, this, str, j2)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getHeaderFieldDate(str, j2);
            }
            return this.f52236b.getHeaderFieldDate(str, j2);
        }
        return invokeLJ.longValue;
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, str, i2)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getHeaderFieldInt(str, i2);
            }
            return this.f52236b.getHeaderFieldInt(str, i2);
        }
        return invokeLI.intValue;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getHeaderFieldKey(i2);
            }
            return this.f52236b.getHeaderFieldKey(i2);
        }
        return (String) invokeI.objValue;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getHeaderFields();
            }
            return this.f52236b.getHeaderFields();
        }
        return (Map) invokeV.objValue;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            HttpURLConnection httpURLConnection = this.f52236b;
            if (httpURLConnection instanceof HttpsURLConnection) {
                return ((HttpsURLConnection) httpURLConnection).getHostnameVerifier();
            }
            return null;
        }
        return (HostnameVerifier) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getIfModifiedSince();
            }
            return this.f52236b.getIfModifiedSince();
        }
        return invokeV.longValue;
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            c.a.u0.a.a.a("ProxyURLConn", "getInputStream by libtype: " + this.f52239e.toString());
            if (!this.f52239e.a()) {
                return this.f52237c.getInputStream();
            }
            try {
                return new c.a.u0.b.d.a(this.f52236b.getInputStream(), this);
            } catch (IOException e2) {
                b(e2, 0L);
                throw e2;
            }
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getInstanceFollowRedirects();
            }
            return this.f52236b.getInstanceFollowRedirects();
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getLastModified();
            }
            return this.f52236b.getLastModified();
        }
        return invokeV.longValue;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            HttpURLConnection httpURLConnection = this.f52236b;
            if (httpURLConnection instanceof HttpsURLConnection) {
                return ((HttpsURLConnection) httpURLConnection).getLocalCertificates();
            }
            return null;
        }
        return (Certificate[]) invokeV.objValue;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            HttpURLConnection httpURLConnection = this.f52236b;
            if (httpURLConnection instanceof HttpsURLConnection) {
                return ((HttpsURLConnection) httpURLConnection).getLocalPrincipal();
            }
            return null;
        }
        return (Principal) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getOutputStream();
            }
            return this.f52236b.getOutputStream();
        }
        return (OutputStream) invokeV.objValue;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            HttpURLConnection httpURLConnection = this.f52236b;
            if (httpURLConnection instanceof HttpsURLConnection) {
                return ((HttpsURLConnection) httpURLConnection).getPeerPrincipal();
            }
            return null;
        }
        return (Principal) invokeV.objValue;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getPermission();
            }
            return this.f52236b.getPermission();
        }
        return (Permission) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getReadTimeout();
            }
            return this.f52236b.getReadTimeout();
        }
        return invokeV.intValue;
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getRequestMethod();
            }
            return this.f52236b.getRequestMethod();
        }
        return (String) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getRequestProperties();
            }
            return this.f52236b.getRequestProperties();
        }
        return (Map) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getRequestProperty(str);
            }
            return this.f52236b.getRequestProperty(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (!this.f52239e.a()) {
                i2 = this.f52237c.getResponseCode();
            } else {
                try {
                    int responseCode = this.f52236b.getResponseCode();
                    this.a.f27099d = responseCode;
                    this.a.b();
                    if (responseCode != 200) {
                        onComplete(0L);
                    }
                    i2 = responseCode;
                } catch (IOException e2) {
                    b(e2, 0L);
                    throw e2;
                }
            }
            c.a.u0.a.a.a("ProxyURLConn", "getResponseCode: " + i2 + " by libtype: " + this.f52239e.toString());
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        InterceptResult invokeV;
        String responseMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (!this.f52239e.a()) {
                responseMessage = this.f52237c.getResponseMessage();
            } else {
                responseMessage = this.f52236b.getResponseMessage();
            }
            c.a.u0.a.a.a("ProxyURLConn", "getResponseMessage by libtype: " + this.f52239e.toString() + " Message: " + responseMessage);
            return responseMessage;
        }
        return (String) invokeV.objValue;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            HttpURLConnection httpURLConnection = this.f52236b;
            if (httpURLConnection instanceof HttpsURLConnection) {
                return ((HttpsURLConnection) httpURLConnection).getSSLSocketFactory();
            }
            return null;
        }
        return (SSLSocketFactory) invokeV.objValue;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            HttpURLConnection httpURLConnection = this.f52236b;
            if (httpURLConnection instanceof HttpsURLConnection) {
                return ((HttpsURLConnection) httpURLConnection).getServerCertificates();
            }
            return null;
        }
        return (Certificate[]) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getURL();
            }
            return this.f52236b.getURL();
        }
        return (URL) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getUseCaches();
            }
            return this.f52236b.getUseCaches();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.u0.b.d.b
    public void onComplete(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048620, this, j2) == null) {
            a aVar = this.a;
            aVar.f27100e = j2;
            aVar.c();
            a aVar2 = this.a;
            aVar2.f27098c = 0;
            aVar2.d(this.f52238d);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            if (!this.f52239e.a()) {
                this.f52237c.setChunkedStreamingMode(i2);
            } else {
                this.f52236b.setChunkedStreamingMode(i2);
            }
        }
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            if (!this.f52239e.a()) {
                this.f52237c.setConnectTimeout(i2);
            } else {
                this.f52236b.setConnectTimeout(i2);
            }
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            if (!this.f52239e.a()) {
                this.f52237c.setDefaultUseCaches(z);
            } else {
                this.f52236b.setDefaultUseCaches(z);
            }
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            if (!this.f52239e.a()) {
                this.f52237c.setDoInput(z);
            } else {
                this.f52236b.setDoInput(z);
            }
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            if (!this.f52239e.a()) {
                this.f52237c.setDoOutput(z);
            } else {
                this.f52236b.setDoOutput(z);
            }
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            if (!this.f52239e.a()) {
                this.f52237c.setFixedLengthStreamingMode(i2);
            } else {
                this.f52236b.setFixedLengthStreamingMode(i2);
            }
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, hostnameVerifier) == null) {
            HttpURLConnection httpURLConnection = this.f52236b;
            if (httpURLConnection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(hostnameVerifier);
            }
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048629, this, j2) == null) {
            if (!this.f52239e.a()) {
                this.f52237c.setIfModifiedSince(j2);
            } else {
                this.f52236b.setIfModifiedSince(j2);
            }
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            if (!this.f52239e.a()) {
                this.f52237c.setInstanceFollowRedirects(z);
            } else {
                this.f52236b.setInstanceFollowRedirects(z);
            }
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            if (!this.f52239e.a()) {
                this.f52237c.setReadTimeout(i2);
            } else {
                this.f52236b.setReadTimeout(i2);
            }
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            if (!this.f52239e.a()) {
                this.f52237c.setRequestMethod(str);
                return;
            }
            this.f52236b.setRequestMethod(str);
            this.a.f27097b = str;
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, str, str2) == null) {
            if (!this.f52239e.a()) {
                this.f52237c.setRequestProperty(str, str2);
            } else {
                this.f52236b.setRequestProperty(str, str2);
            }
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, sSLSocketFactory) == null) {
            HttpURLConnection httpURLConnection = this.f52236b;
            if (httpURLConnection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
            }
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            if (!this.f52239e.a()) {
                this.f52237c.setUseCaches(z);
            } else {
                this.f52236b.setUseCaches(z);
            }
        }
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.usingProxy();
            }
            return this.f52236b.usingProxy();
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048627, this, j2) == null) {
            if (!this.f52239e.a()) {
                this.f52237c.setFixedLengthStreamingMode(j2);
            } else {
                this.f52236b.setFixedLengthStreamingMode(j2);
            }
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getHeaderField(i2);
            }
            return this.f52236b.getHeaderField(i2);
        }
        return (String) invokeI.objValue;
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, clsArr)) == null) {
            if (!this.f52239e.a()) {
                return this.f52237c.getContent(clsArr);
            }
            try {
                long contentLength = this.f52236b.getContentLength();
                this.a.f27100e = contentLength;
                onComplete(contentLength);
                return this.f52236b.getContent(clsArr);
            } catch (IOException e2) {
                b(e2, 0L);
                throw e2;
            }
        }
        return invokeL.objValue;
    }
}
