package com.bytedance.sdk.component.b.b.a.g;

import android.net.ssl.SSLSockets;
import android.os.Build;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.a.i.f;
import com.bytedance.sdk.component.b.b.x;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes9.dex */
public class a extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f65080a;

    /* renamed from: b  reason: collision with root package name */
    public final d<Socket> f65081b;

    /* renamed from: c  reason: collision with root package name */
    public final d<Socket> f65082c;

    /* renamed from: d  reason: collision with root package name */
    public final d<Socket> f65083d;

    /* renamed from: e  reason: collision with root package name */
    public final d<Socket> f65084e;

    /* renamed from: f  reason: collision with root package name */
    public final c f65085f;

    /* renamed from: com.bytedance.sdk.component.b.b.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1889a extends com.bytedance.sdk.component.b.b.a.i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Object f65086a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f65087b;

        public C1889a(Object obj, Method method) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, method};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65086a = obj;
            this.f65087b = method;
        }

        @Override // com.bytedance.sdk.component.b.b.a.i.c
        public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, str)) == null) {
                try {
                    return (List) this.f65087b.invoke(this.f65086a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
                } catch (IllegalAccessException e2) {
                    throw new AssertionError(e2);
                } catch (InvocationTargetException e3) {
                    SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e3.getMessage());
                    sSLPeerUnverifiedException.initCause(e3);
                    throw sSLPeerUnverifiedException;
                }
            }
            return (List) invokeLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? obj instanceof C1889a : invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final X509TrustManager f65088a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f65089b;

        public b(X509TrustManager x509TrustManager, Method method) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x509TrustManager, method};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65089b = method;
            this.f65088a = x509TrustManager;
        }

        @Override // com.bytedance.sdk.component.b.b.a.i.f
        public X509Certificate a(X509Certificate x509Certificate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, x509Certificate)) == null) {
                try {
                    TrustAnchor trustAnchor = (TrustAnchor) this.f65089b.invoke(this.f65088a, x509Certificate);
                    if (trustAnchor != null) {
                        return trustAnchor.getTrustedCert();
                    }
                    return null;
                } catch (IllegalAccessException e2) {
                    throw com.bytedance.sdk.component.b.b.a.c.a("unable to get issues and signature", (Exception) e2);
                } catch (InvocationTargetException unused) {
                    return null;
                }
            }
            return (X509Certificate) invokeL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    return this.f65088a.equals(bVar.f65088a) && this.f65089b.equals(bVar.f65089b);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f65088a.hashCode() + (this.f65089b.hashCode() * 31) : invokeV.intValue;
        }
    }

    public a(Class<?> cls, d<Socket> dVar, d<Socket> dVar2, d<Socket> dVar3, d<Socket> dVar4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, dVar, dVar2, dVar3, dVar4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65085f = c.a();
        this.f65080a = cls;
        this.f65081b = dVar;
        this.f65082c = dVar2;
        this.f65083d = dVar3;
        this.f65084e = dVar4;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (Security.getProvider("GMSCore_OpenSSL") != null) {
                return true;
            }
            try {
                Class.forName("android.net.Network");
                return true;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.component.b.b.a.g.e
    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, socket, inetSocketAddress, i2) == null) {
            try {
                socket.connect(inetSocketAddress, i2);
            } catch (AssertionError e2) {
                if (!com.bytedance.sdk.component.b.b.a.c.a(e2)) {
                    throw e2;
                }
                throw new IOException(e2);
            } catch (ClassCastException e3) {
                if (Build.VERSION.SDK_INT == 26) {
                    IOException iOException = new IOException("Exception in connect");
                    iOException.initCause(e3);
                    throw iOException;
                }
                throw e3;
            } catch (SecurityException e4) {
                IOException iOException2 = new IOException("Exception in connect");
                iOException2.initCause(e4);
                throw iOException2;
            }
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.g.e
    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            try {
                Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
                return a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                return super.b(str);
            } catch (IllegalAccessException e2) {
                e = e2;
                throw com.bytedance.sdk.component.b.b.a.c.a("unable to determine cleartext support", e);
            } catch (IllegalArgumentException e3) {
                e = e3;
                throw com.bytedance.sdk.component.b.b.a.c.a("unable to determine cleartext support", e);
            } catch (InvocationTargetException e4) {
                e = e4;
                throw com.bytedance.sdk.component.b.b.a.c.a("unable to determine cleartext support", e);
            }
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes9.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Method f65090a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f65091b;

        /* renamed from: c  reason: collision with root package name */
        public final Method f65092c;

        public c(Method method, Method method2, Method method3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {method, method2, method3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65090a = method;
            this.f65091b = method2;
            this.f65092c = method3;
        }

        public Object a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                Method method = this.f65090a;
                if (method != null) {
                    try {
                        Object invoke = method.invoke(null, new Object[0]);
                        this.f65091b.invoke(invoke, str);
                        return invoke;
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return invokeL.objValue;
        }

        public boolean a(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj != null) {
                    try {
                        this.f65092c.invoke(obj, new Object[0]);
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public static c a() {
            InterceptResult invokeV;
            Method method;
            Method method2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                Method method3 = null;
                try {
                    Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                    Method method4 = cls.getMethod("get", new Class[0]);
                    method2 = cls.getMethod("open", String.class);
                    method = cls.getMethod("warnIfOpen", new Class[0]);
                    method3 = method4;
                } catch (Exception unused) {
                    method = null;
                    method2 = null;
                }
                return new c(method3, method2, method);
            }
            return (c) invokeV.objValue;
        }
    }

    private boolean b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, str, cls, obj)) == null) {
            try {
                return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
            } catch (NoSuchMethodException unused) {
                return super.b(str);
            }
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.bytedance.sdk.component.b.b.a.g.e
    public f b(X509TrustManager x509TrustManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, x509TrustManager)) == null) {
            try {
                Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
                declaredMethod.setAccessible(true);
                return new b(x509TrustManager, declaredMethod);
            } catch (NoSuchMethodException unused) {
                return super.b(x509TrustManager);
            }
        }
        return (f) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.a.g.e
    public void a(SSLSocket sSLSocket, String str, List<x> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, sSLSocket, str, list) == null) {
            if (str != null) {
                if (Build.VERSION.SDK_INT >= 30) {
                    try {
                        SSLSockets.setUseSessionTickets(sSLSocket, true);
                        SNIHostName sNIHostName = new SNIHostName(str);
                        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                        sSLParameters.setServerNames(Collections.singletonList(sNIHostName));
                        sSLSocket.setSSLParameters(sSLParameters);
                    } catch (Exception unused) {
                    }
                } else {
                    this.f65081b.b(sSLSocket, Boolean.TRUE);
                    this.f65082c.b(sSLSocket, str);
                }
            }
            d<Socket> dVar = this.f65084e;
            if (dVar == null || !dVar.a((d<Socket>) sSLSocket)) {
                return;
            }
            this.f65084e.d(sSLSocket, e.b(list));
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.g.e
    public String a(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sSLSocket)) == null) {
            d<Socket> dVar = this.f65083d;
            if (dVar == null || !dVar.a((d<Socket>) sSLSocket) || (bArr = (byte[]) this.f65083d.d(sSLSocket, new Object[0])) == null) {
                return null;
            }
            return new String(bArr, com.bytedance.sdk.component.b.b.a.c.f64858e);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.a.g.e
    public void a(int i2, String str, Throwable th) {
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, str, th) == null) {
            int i3 = i2 != 5 ? 3 : 5;
            if (th != null) {
                str = str + '\n' + Log.getStackTraceString(th);
            }
            int i4 = 0;
            int length = str.length();
            while (i4 < length) {
                int indexOf = str.indexOf(10, i4);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = Math.min(indexOf, i4 + 4000);
                    Log.println(i3, "OkHttp", str.substring(i4, min));
                    if (min >= indexOf) {
                        break;
                    }
                    i4 = min;
                }
                i4 = min + 1;
            }
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.g.e
    public Object a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f65085f.a(str) : invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.a.g.e
    public void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, obj) == null) || this.f65085f.a(obj)) {
            return;
        }
        a(5, str, (Throwable) null);
    }

    private boolean a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, str, cls, obj)) == null) {
            try {
                return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
            } catch (NoSuchMethodException unused) {
                return b(str, cls, obj);
            }
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.bytedance.sdk.component.b.b.a.g.e
    public com.bytedance.sdk.component.b.b.a.i.c a(X509TrustManager x509TrustManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, x509TrustManager)) == null) {
            try {
                Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
                return new C1889a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
            } catch (Exception unused) {
                return super.a(x509TrustManager);
            }
        }
        return (com.bytedance.sdk.component.b.b.a.i.c) invokeL.objValue;
    }

    public static e a() {
        InterceptResult invokeV;
        Class<?> cls;
        d dVar;
        d dVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                try {
                    cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
                } catch (ClassNotFoundException unused) {
                    cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
                }
                Class<?> cls2 = cls;
                d dVar3 = new d(null, "setUseSessionTickets", Boolean.TYPE);
                d dVar4 = new d(null, "setHostname", String.class);
                if (c()) {
                    d dVar5 = new d(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                    dVar2 = new d(null, "setAlpnProtocols", byte[].class);
                    dVar = dVar5;
                } else {
                    dVar = null;
                    dVar2 = null;
                }
                return new a(cls2, dVar3, dVar4, dVar, dVar2);
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        return (e) invokeV.objValue;
    }
}
