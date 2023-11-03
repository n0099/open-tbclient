package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.net.TrafficStats;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.CronetException;
import com.baidu.turbonet.net.ExperimentalUrlRequest;
import com.baidu.turbonet.net.TurbonetEngine;
import com.baidu.turbonet.net.UrlRequest;
import com.baidu.turbonet.net.UrlResponseInfo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.chromium.base.Log;
/* loaded from: classes9.dex */
public class yjb extends HttpURLConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TurbonetEngine a;
    public final bkb b;
    public UrlRequest c;
    public final List<Pair<String, String>> d;
    public boolean e;
    public int f;
    public boolean g;
    public int h;
    public zjb i;
    public akb j;
    public UrlResponseInfo k;
    public IOException l;
    public boolean m;
    public boolean n;
    public List<Map.Entry<String, String>> o;
    public Map<String, List<String>> p;
    public boolean q;
    public boolean r;
    public String s;
    public String t;
    public int u;
    public boolean v;
    public boolean w;

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes9.dex */
    public class a extends UrlRequest.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yjb a;

        public a(yjb yjbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yjbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yjbVar;
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, urlRequest, urlResponseInfo) == null) {
                this.a.k = urlResponseInfo;
                g(new IOException("disconnect() called"));
            }
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void e(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, urlRequest, urlResponseInfo) == null) {
                this.a.k = urlResponseInfo;
                this.a.n = true;
                this.a.b.quit();
            }
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, urlRequest, urlResponseInfo, cronetException) == null) {
                if (cronetException != null) {
                    Log.e("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", this.a.getURL().toString(), cronetException);
                    this.a.k = urlResponseInfo;
                    g(cronetException);
                    return;
                }
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, urlRequest, urlResponseInfo, byteBuffer) == null) {
                this.a.k = urlResponseInfo;
                this.a.b.quit();
            }
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void d(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, urlRequest, urlResponseInfo, str) == null) {
                this.a.m = true;
                try {
                    URL url = new URL(str);
                    boolean equals = url.getProtocol().equals(((HttpURLConnection) this.a).url.getProtocol());
                    if (((HttpURLConnection) this.a).instanceFollowRedirects) {
                        ((HttpURLConnection) this.a).url = url;
                    }
                    if (((HttpURLConnection) this.a).instanceFollowRedirects && (equals || this.a.r)) {
                        this.a.c.c();
                        return;
                    }
                } catch (MalformedURLException e) {
                    android.util.Log.e("cr_CronetHttpURLConn", android.util.Log.getStackTraceString(e));
                }
                this.a.k = urlResponseInfo;
                this.a.c.a();
                g(null);
            }
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void f(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, urlRequest, urlResponseInfo) == null) {
                Log.i("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.f(), Integer.valueOf(urlResponseInfo.b()), Long.valueOf(urlResponseInfo.e()));
                this.a.k = urlResponseInfo;
                g(null);
            }
        }

        public final void g(IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, iOException) == null) {
                this.a.l = iOException;
                if (this.a.i != null) {
                    this.a.i.d(iOException);
                }
                if (this.a.j != null) {
                    this.a.j.h(iOException);
                }
                this.a.n = true;
                this.a.b.quit();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yjb(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {url, turbonetEngine};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((URL) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = turbonetEngine;
        this.b = new bkb(getURL().toString());
        this.i = new zjb(this);
        this.d = new ArrayList();
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            B(str, str2, false);
        }
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, str2) == null) {
            B(str, str2, true);
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            Map.Entry<String, String> u = u(i);
            if (u == null) {
                return null;
            }
            return u.getValue();
        }
        return (String) invokeI.objValue;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            Map.Entry<String, String> u = u(i);
            if (u == null) {
                return null;
            }
            return u.getKey();
        }
        return (String) invokeI.objValue;
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            int r = r(str);
            if (r >= 0) {
                return (String) this.d.get(r).second;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final int r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            for (int i = 0; i < this.d.size(); i++) {
                if (((String) this.d.get(i).first).equalsIgnoreCase(str)) {
                    return i;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void v(ByteBuffer byteBuffer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, byteBuffer) == null) {
            this.c.e(byteBuffer);
            this.b.b(getReadTimeout());
        }
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (((HttpURLConnection) this).chunkLength > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            getOutputStream();
            C();
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && ((HttpURLConnection) this).connected) {
            this.c.a();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                x();
                if (this.k.b() < 400) {
                    return null;
                }
                return this.i;
            } catch (IOException e) {
                android.util.Log.e("cr_CronetHttpURLConn", android.util.Log.getStackTraceString(e));
                return null;
            }
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            try {
                x();
                return s();
            } catch (IOException e) {
                android.util.Log.e("cr_CronetHttpURLConn", android.util.Log.getStackTraceString(e));
                return Collections.emptyMap();
            }
        }
        return (Map) invokeV.objValue;
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            x();
            return this.k.b();
        }
        return invokeV.intValue;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            x();
            return this.k.c();
        }
        return (String) invokeV.objValue;
    }

    public final void n() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.n) {
                IOException iOException = this.l;
                if (iOException == null) {
                    if (this.k != null) {
                        return;
                    }
                    throw new NullPointerException("Response info is null when there is no exception.");
                }
                throw iOException;
            }
            throw new IllegalStateException("No response.");
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.e) {
                return true;
            }
            int threadStatsTag = TrafficStats.getThreadStatsTag();
            if (threadStatsTag != -1) {
                this.f = threadStatsTag;
                this.e = true;
            }
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.g) {
                return true;
            }
            if (Build.VERSION.SDK_INT < 28) {
                return false;
            }
            int threadStatsUid = TrafficStats.getThreadStatsUid();
            if (threadStatsUid != -1) {
                this.h = threadStatsUid;
                this.g = true;
            }
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.r = true;
        }
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.u;
        }
        return invokeV.intValue;
    }

    public UrlResponseInfo z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.k;
        }
        return (UrlResponseInfo) invokeV.objValue;
    }

    public final void B(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, z) == null) {
            if (!((HttpURLConnection) this).connected) {
                int r = r(str);
                if (r >= 0) {
                    if (z) {
                        this.d.remove(r);
                    } else {
                        throw new UnsupportedOperationException("Cannot add multiple headers of the same key, " + str + ". crbug.com/432719.");
                    }
                }
                this.d.add(Pair.create(str, str2));
                return;
            }
            throw new IllegalStateException("Cannot modify request property after connection is made.");
        }
    }

    public final void C() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || ((HttpURLConnection) this).connected) {
            return;
        }
        ExperimentalUrlRequest.Builder builder = (ExperimentalUrlRequest.Builder) this.a.d(getURL().toString(), new a(this), this.b);
        if (((HttpURLConnection) this).doOutput) {
            if ("GET".equals(((HttpURLConnection) this).method)) {
                ((HttpURLConnection) this).method = "POST";
            }
            akb akbVar = this.j;
            if (akbVar != null) {
                builder.m(akbVar.f(), this.b);
                if (getRequestProperty("Content-Length") == null && !A()) {
                    addRequestProperty("Content-Length", Long.toString(this.j.f().a()));
                }
                this.j.g();
            } else if (getRequestProperty("Content-Length") == null) {
                addRequestProperty("Content-Length", "0");
            }
            if (getRequestProperty("Content-Type") == null) {
                addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            }
        }
        for (Pair<String, String> pair : this.d) {
            builder.a((String) pair.first, (String) pair.second);
        }
        if (!getUseCaches()) {
            builder.c();
        }
        builder.f(((HttpURLConnection) this).method);
        if (o()) {
            builder.k(this.f);
        }
        if (p()) {
            builder.l(this.h);
        }
        if (this.q) {
            builder.d();
        }
        if (!TextUtils.isEmpty(this.s)) {
            builder.e(this.s);
        }
        if (!TextUtils.isEmpty(this.t)) {
            builder.g(this.t);
        }
        builder.i(getConnectTimeout());
        builder.h(getReadTimeout());
        builder.j(w());
        ExperimentalUrlRequest b = builder.b();
        this.c = b;
        b.m();
        ((HttpURLConnection) this).connected = true;
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            try {
                x();
                Map<String, List<String>> s = s();
                if (!s.containsKey(str)) {
                    return null;
                }
                List<String> list = s.get(str);
                return list.get(list.size() - 1);
            } catch (IOException e) {
                android.util.Log.e("cr_CronetHttpURLConn", android.util.Log.getStackTraceString(e));
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public final Map.Entry<String, String> u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            try {
                x();
                List<Map.Entry<String, String>> t = t();
                if (i >= t.size()) {
                    return null;
                }
                return t.get(i);
            } catch (IOException e) {
                android.util.Log.e("cr_CronetHttpURLConn", android.util.Log.getStackTraceString(e));
                return null;
            }
        }
        return (Map.Entry) invokeI.objValue;
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            x();
            if (!((HttpURLConnection) this).instanceFollowRedirects && this.m) {
                throw new IOException("Cannot read response body of a redirect.");
            }
            if (this.k.b() < 400) {
                return this.i;
            }
            throw new FileNotFoundException(((HttpURLConnection) this).url.toString());
        }
        return (InputStream) invokeV.objValue;
    }

    public final void x() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            akb akbVar = this.j;
            if (akbVar != null) {
                akbVar.e();
                if (A()) {
                    this.j.close();
                }
            }
            if (!this.n) {
                C();
                this.b.b(getReadTimeout());
            }
            n();
        }
    }

    @SuppressLint({"NewApi"})
    public final long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            long j = ((HttpURLConnection) this).fixedContentLength;
            try {
                long j2 = getClass().getDeclaredField("fixedContentLengthLong").getLong(this);
                if (j2 != -1) {
                    return j2;
                }
                return j;
            } catch (IllegalAccessException | NoSuchFieldException e) {
                android.util.Log.e("cr_CronetHttpURLConn", android.util.Log.getStackTraceString(e));
                return j;
            }
        }
        return invokeV.longValue;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.j == null && ((HttpURLConnection) this).doOutput) {
                if (!((HttpURLConnection) this).connected) {
                    if (A()) {
                        this.j = new wjb(this, ((HttpURLConnection) this).chunkLength, this.b, this.v, this.w);
                        C();
                    } else {
                        long y = y();
                        if (y != -1) {
                            this.j = new xjb(this, y, this.b);
                            C();
                        } else {
                            android.util.Log.d("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                            String requestProperty = getRequestProperty("Content-Length");
                            if (requestProperty == null) {
                                this.j = new vjb(this);
                            } else {
                                try {
                                    this.j = new vjb(this, Long.parseLong(requestProperty));
                                } catch (NumberFormatException unused) {
                                    android.util.Log.e("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.");
                                    this.j = new vjb(this);
                                }
                            }
                        }
                    }
                } else {
                    throw new ProtocolException("Cannot write to OutputStream after receiving response.");
                }
            }
            return this.j;
        }
        return (OutputStream) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!((HttpURLConnection) this).connected) {
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (Pair<String, String> pair : this.d) {
                    if (!treeMap.containsKey(pair.first)) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add((String) pair.second);
                        treeMap.put((String) pair.first, Collections.unmodifiableList(arrayList));
                    } else {
                        throw new IllegalStateException("Should not have multiple values.");
                    }
                }
                return Collections.unmodifiableMap(treeMap);
            }
            throw new IllegalStateException("Cannot access request headers after connection is set.");
        }
        return (Map) invokeV.objValue;
    }

    public final Map<String, List<String>> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            Map<String, List<String>> map = this.p;
            if (map != null) {
                return map;
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (Map.Entry<String, String> entry : t()) {
                ArrayList arrayList = new ArrayList();
                if (treeMap.containsKey(entry.getKey())) {
                    arrayList.addAll((Collection) treeMap.get(entry.getKey()));
                }
                arrayList.add(entry.getValue());
                treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
            }
            Map<String, List<String>> unmodifiableMap = Collections.unmodifiableMap(treeMap);
            this.p = unmodifiableMap;
            return unmodifiableMap;
        }
        return (Map) invokeV.objValue;
    }

    public final List<Map.Entry<String, String>> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            List<Map.Entry<String, String>> list = this.o;
            if (list != null) {
                return list;
            }
            this.o = new ArrayList();
            for (Map.Entry<String, String> entry : this.k.a()) {
                if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                    this.o.add(new AbstractMap.SimpleImmutableEntry(entry));
                }
            }
            List<Map.Entry<String, String>> unmodifiableList = Collections.unmodifiableList(this.o);
            this.o = unmodifiableList;
            return unmodifiableList;
        }
        return (List) invokeV.objValue;
    }
}
