package com.baidu.turbonet.net;

import android.annotation.TargetApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ab9;
import com.baidu.tieba.eb9;
import com.baidu.tieba.ta9;
import com.baidu.tieba.wa9;
import com.baidu.tieba.za9;
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
/* loaded from: classes6.dex */
public class ProxyURLConnection extends HttpsURLConnection implements ab9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wa9 a;
    public HttpURLConnection b;
    public eb9 c;
    public TurbonetEngine d;
    public ProxyConfig e;

    @Override // com.baidu.tieba.ab9
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            wa9 wa9Var = this.a;
            wa9Var.e = j;
            wa9Var.c();
            wa9 wa9Var2 = this.a;
            wa9Var2.c = -12;
            wa9Var2.d(this.d);
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            if (!this.e.a()) {
                return this.c.getHeaderField(i);
            }
            return this.b.getHeaderField(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            if (!this.e.a()) {
                return this.c.getHeaderFieldKey(i);
            }
            return this.b.getHeaderFieldKey(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            if (!this.e.a()) {
                return this.c.getRequestProperty(str);
            }
            return this.b.getRequestProperty(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ab9
    public void onComplete(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048620, this, j) == null) {
            wa9 wa9Var = this.a;
            wa9Var.e = j;
            wa9Var.c();
            wa9 wa9Var2 = this.a;
            wa9Var2.c = 0;
            wa9Var2.d(this.d);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            if (!this.e.a()) {
                this.c.setChunkedStreamingMode(i);
            } else {
                this.b.setChunkedStreamingMode(i);
            }
        }
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            if (!this.e.a()) {
                this.c.setConnectTimeout(i);
            } else {
                this.b.setConnectTimeout(i);
            }
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            if (!this.e.a()) {
                this.c.setDefaultUseCaches(z);
            } else {
                this.b.setDefaultUseCaches(z);
            }
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            if (!this.e.a()) {
                this.c.setDoInput(z);
            } else {
                this.b.setDoInput(z);
            }
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            if (!this.e.a()) {
                this.c.setDoOutput(z);
            } else {
                this.b.setDoOutput(z);
            }
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
            if (!this.e.a()) {
                this.c.setFixedLengthStreamingMode(i);
            } else {
                this.b.setFixedLengthStreamingMode(i);
            }
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, hostnameVerifier) == null) {
            HttpURLConnection httpURLConnection = this.b;
            if (httpURLConnection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(hostnameVerifier);
            }
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048629, this, j) == null) {
            if (!this.e.a()) {
                this.c.setIfModifiedSince(j);
            } else {
                this.b.setIfModifiedSince(j);
            }
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            if (!this.e.a()) {
                this.c.setInstanceFollowRedirects(z);
            } else {
                this.b.setInstanceFollowRedirects(z);
            }
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            if (!this.e.a()) {
                this.c.setReadTimeout(i);
            } else {
                this.b.setReadTimeout(i);
            }
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            if (!this.e.a()) {
                this.c.setRequestMethod(str);
                return;
            }
            this.b.setRequestMethod(str);
            this.a.b = str;
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, sSLSocketFactory) == null) {
            HttpURLConnection httpURLConnection = this.b;
            if (httpURLConnection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
            }
        }
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            if (!this.e.a()) {
                this.c.setUseCaches(z);
            } else {
                this.b.setUseCaches(z);
            }
        }
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            if (!this.e.a()) {
                this.c.addRequestProperty(str, str2);
            } else {
                this.b.addRequestProperty(str, str2);
            }
        }
    }

    @Override // com.baidu.tieba.ab9
    public void b(Exception exc, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, exc, j) == null) {
            wa9 wa9Var = this.a;
            wa9Var.e = j;
            wa9Var.c();
            this.a.a(exc);
            this.a.d(this.d);
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048596, this, str, j)) == null) {
            if (!this.e.a()) {
                return this.c.getHeaderFieldDate(str, j);
            }
            return this.b.getHeaderFieldDate(str, j);
        }
        return invokeLJ.longValue;
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, str, i)) == null) {
            if (!this.e.a()) {
                return this.c.getHeaderFieldInt(str, i);
            }
            return this.b.getHeaderFieldInt(str, i);
        }
        return invokeLI.intValue;
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, str, str2) == null) {
            if (!this.e.a()) {
                this.c.setRequestProperty(str, str2);
            } else {
                this.b.setRequestProperty(str, str2);
            }
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ta9.a("ProxyURLConn", "connect by libtype: " + this.e.toString());
            if (!this.e.a()) {
                this.c.connect();
                return;
            }
            try {
                this.b.connect();
            } catch (IOException e) {
                b(e, 0L);
                throw e;
            }
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ta9.a("ProxyURLConn", "disconnect by libtype: " + this.e.toString());
            if (!this.e.a()) {
                this.c.disconnect();
            } else {
                this.b.disconnect();
            }
        }
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!this.e.a()) {
                return this.c.getContent();
            }
            try {
                long contentLength = this.b.getContentLength();
                this.a.e = contentLength;
                onComplete(contentLength);
                return this.b.getContent();
            } catch (IOException e) {
                b(e, 0L);
                throw e;
            }
        }
        return invokeV.objValue;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            HttpURLConnection httpURLConnection = this.b;
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
            if (!this.e.a()) {
                return this.c.getConnectTimeout();
            }
            return this.b.getConnectTimeout();
        }
        return invokeV.intValue;
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.e.a()) {
                return this.c.getContentEncoding();
            }
            return this.b.getContentEncoding();
        }
        return (String) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!this.e.a()) {
                return this.c.getContentLength();
            }
            return this.b.getContentLength();
        }
        return invokeV.intValue;
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!this.e.a()) {
                return this.c.getContentType();
            }
            return this.b.getContentType();
        }
        return (String) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public long getDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (!this.e.a()) {
                return this.c.getDate();
            }
            return this.b.getDate();
        }
        return invokeV.longValue;
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!this.e.a()) {
                return this.c.getDefaultUseCaches();
            }
            return this.b.getDefaultUseCaches();
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!this.e.a()) {
                return this.c.getDoInput();
            }
            return this.b.getDoInput();
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (!this.e.a()) {
                return this.c.getDoOutput();
            }
            return this.b.getDoOutput();
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!this.e.a()) {
                return this.c.getErrorStream();
            }
            return this.b.getErrorStream();
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (!this.e.a()) {
                return this.c.getExpiration();
            }
            return this.b.getExpiration();
        }
        return invokeV.longValue;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (!this.e.a()) {
                return this.c.getHeaderFields();
            }
            return this.b.getHeaderFields();
        }
        return (Map) invokeV.objValue;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            HttpURLConnection httpURLConnection = this.b;
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
            if (!this.e.a()) {
                return this.c.getIfModifiedSince();
            }
            return this.b.getIfModifiedSince();
        }
        return invokeV.longValue;
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (!this.e.a()) {
                return this.c.getInstanceFollowRedirects();
            }
            return this.b.getInstanceFollowRedirects();
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (!this.e.a()) {
                return this.c.getLastModified();
            }
            return this.b.getLastModified();
        }
        return invokeV.longValue;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            HttpURLConnection httpURLConnection = this.b;
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
            HttpURLConnection httpURLConnection = this.b;
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
            if (!this.e.a()) {
                return this.c.getOutputStream();
            }
            return this.b.getOutputStream();
        }
        return (OutputStream) invokeV.objValue;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            HttpURLConnection httpURLConnection = this.b;
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
            if (!this.e.a()) {
                return this.c.getPermission();
            }
            return this.b.getPermission();
        }
        return (Permission) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (!this.e.a()) {
                return this.c.getReadTimeout();
            }
            return this.b.getReadTimeout();
        }
        return invokeV.intValue;
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (!this.e.a()) {
                return this.c.getRequestMethod();
            }
            return this.b.getRequestMethod();
        }
        return (String) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (!this.e.a()) {
                return this.c.getRequestProperties();
            }
            return this.b.getRequestProperties();
        }
        return (Map) invokeV.objValue;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            HttpURLConnection httpURLConnection = this.b;
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
            HttpURLConnection httpURLConnection = this.b;
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
            if (!this.e.a()) {
                return this.c.getURL();
            }
            return this.b.getURL();
        }
        return (URL) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (!this.e.a()) {
                return this.c.getUseCaches();
            }
            return this.b.getUseCaches();
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (!this.e.a()) {
                return this.c.usingProxy();
            }
            return this.b.usingProxy();
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, clsArr)) == null) {
            if (!this.e.a()) {
                return this.c.getContent(clsArr);
            }
            try {
                long contentLength = this.b.getContentLength();
                this.a.e = contentLength;
                onComplete(contentLength);
                return this.b.getContent(clsArr);
            } catch (IOException e) {
                b(e, 0L);
                throw e;
            }
        }
        return invokeL.objValue;
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (!this.e.a()) {
                return this.c.getHeaderField(str);
            }
            String headerField = this.b.getHeaderField(str);
            this.a.b();
            return headerField;
        }
        return (String) invokeL.objValue;
    }

    @Override // java.net.HttpURLConnection
    @TargetApi(19)
    public void setFixedLengthStreamingMode(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048627, this, j) == null) {
            if (!this.e.a()) {
                this.c.setFixedLengthStreamingMode(j);
            } else {
                this.b.setFixedLengthStreamingMode(j);
            }
        }
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            ta9.a("ProxyURLConn", "getInputStream by libtype: " + this.e.toString());
            if (!this.e.a()) {
                return this.c.getInputStream();
            }
            try {
                return new za9(this.b.getInputStream(), this);
            } catch (IOException e) {
                b(e, 0L);
                throw e;
            }
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (!this.e.a()) {
                i = this.c.getResponseCode();
            } else {
                try {
                    int responseCode = this.b.getResponseCode();
                    this.a.d = responseCode;
                    this.a.b();
                    if (responseCode != 200) {
                        onComplete(0L);
                    }
                    i = responseCode;
                } catch (IOException e) {
                    b(e, 0L);
                    throw e;
                }
            }
            ta9.a("ProxyURLConn", "getResponseCode: " + i + " by libtype: " + this.e.toString());
            return i;
        }
        return invokeV.intValue;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        InterceptResult invokeV;
        String responseMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (!this.e.a()) {
                responseMessage = this.c.getResponseMessage();
            } else {
                responseMessage = this.b.getResponseMessage();
            }
            ta9.a("ProxyURLConn", "getResponseMessage by libtype: " + this.e.toString() + " Message: " + responseMessage);
            return responseMessage;
        }
        return (String) invokeV.objValue;
    }
}
