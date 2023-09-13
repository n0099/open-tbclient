package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;
@Deprecated
/* loaded from: classes7.dex */
public class rzb extends SSLSocketFactory {
    public static /* synthetic */ Interceptable $ic;
    @Deprecated
    public static final X509HostnameVerifier i;
    public static final String j;
    public static volatile rzb k;
    public transient /* synthetic */ FieldHolder $fh;
    public SSLContext a;
    public SSLSocket b;
    public Context c;
    public String[] d;
    public X509TrustManager e;
    public String[] f;
    public String[] g;
    public String[] h;

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new String[0] : (String[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948140335, "Lcom/baidu/tieba/rzb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948140335, "Lcom/baidu/tieba/rzb;");
                return;
            }
        }
        new BrowserCompatHostnameVerifier();
        i = new StrictHostnameVerifier();
        j = rzb.class.getSimpleName();
        k = null;
    }

    public rzb(Context context) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        if (context == null) {
            d0c.d(j, "SecureSSLSocketFactory: context is null");
            return;
        }
        c(context);
        d(qzb.f());
        uzb a = tzb.a(context);
        this.e = a;
        this.a.init(null, new X509TrustManager[]{a}, null);
    }

    public static rzb b(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            a0c.b(context);
            if (k == null) {
                synchronized (rzb.class) {
                    if (k == null) {
                        k = new rzb(context);
                    }
                }
            }
            if (k.c == null && context != null) {
                k.c(context);
            }
            String str = j;
            d0c.b(str, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return k;
        }
        return (rzb) invokeL.objValue;
    }

    public final void a(Socket socket) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, socket) == null) {
            boolean z2 = true;
            if (!zzb.a(this.h)) {
                d0c.e(j, "set protocols");
                qzb.e((SSLSocket) socket, this.h);
                z = true;
            } else {
                z = false;
            }
            if (zzb.a(this.g) && zzb.a(this.f)) {
                z2 = false;
            } else {
                d0c.e(j, "set white cipher or black cipher");
                SSLSocket sSLSocket = (SSLSocket) socket;
                qzb.d(sSLSocket);
                if (!zzb.a(this.g)) {
                    qzb.h(sSLSocket, this.g);
                } else {
                    qzb.b(sSLSocket, this.f);
                }
            }
            if (!z) {
                d0c.e(j, "set default protocols");
                qzb.d((SSLSocket) socket);
            }
            if (!z2) {
                d0c.e(j, "set default cipher suites");
                qzb.c((SSLSocket) socket);
            }
        }
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.c = context.getApplicationContext();
        }
    }

    public void d(SSLContext sSLContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sSLContext) == null) {
            this.a = sSLContext;
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2)) == null) {
            d0c.e(j, "createSocket: host , port");
            Socket createSocket = this.a.getSocketFactory().createSocket(str, i2);
            if (createSocket instanceof SSLSocket) {
                a(createSocket);
                SSLSocket sSLSocket = (SSLSocket) createSocket;
                this.b = sSLSocket;
                this.d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
            }
            return createSocket;
        }
        return (Socket) invokeLI.objValue;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Integer.valueOf(i2), inetAddress, Integer.valueOf(i3)})) == null) {
            return createSocket(str, i2);
        }
        return (Socket) invokeCommon.objValue;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, inetAddress, i2)) == null) {
            return createSocket(inetAddress.getHostAddress(), i2);
        }
        return (Socket) invokeLI.objValue;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{inetAddress, Integer.valueOf(i2), inetAddress2, Integer.valueOf(i3)})) == null) {
            return createSocket(inetAddress.getHostAddress(), i2);
        }
        return (Socket) invokeCommon.objValue;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{socket, str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            d0c.e(j, "createSocket s host port autoClose");
            Socket createSocket = this.a.getSocketFactory().createSocket(socket, str, i2, z);
            if (createSocket instanceof SSLSocket) {
                a(createSocket);
                SSLSocket sSLSocket = (SSLSocket) createSocket;
                this.b = sSLSocket;
                this.d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
            }
            return createSocket;
        }
        return (Socket) invokeCommon.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (Context) invokeV.objValue;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String[] strArr = this.d;
            if (strArr != null) {
                return strArr;
            }
            return new String[0];
        }
        return (String[]) invokeV.objValue;
    }
}
