package com.bytedance.sdk.component.b.b.a.g;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.a.i.f;
import com.bytedance.sdk.component.b.b.w;
import com.bytedance.sdk.component.b.b.x;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final e f28467a;

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f28468b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-952210197, "Lcom/bytedance/sdk/component/b/b/a/g/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-952210197, "Lcom/bytedance/sdk/component/b/b/a/g/e;");
                return;
            }
        }
        f28467a = a();
        f28468b = Logger.getLogger(w.class.getName());
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f28467a : (e) invokeV.objValue;
    }

    public String a(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sSLSocket)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, socket, inetSocketAddress, i2) == null) {
            socket.connect(inetSocketAddress, i2);
        }
    }

    public void a(SSLSocket sSLSocket, String str, List<x> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, sSLSocket, str, list) == null) {
        }
    }

    public void b(SSLSocket sSLSocket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sSLSocket) == null) {
        }
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public static byte[] b(List<x> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, list)) == null) {
            com.bytedance.sdk.component.b.a.c cVar = new com.bytedance.sdk.component.b.a.c();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                x xVar = list.get(i2);
                if (xVar != x.f28659a) {
                    cVar.i(xVar.toString().length());
                    cVar.b(xVar.toString());
                }
            }
            return cVar.q();
        }
        return (byte[]) invokeL.objValue;
    }

    public void a(int i2, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, str, th) == null) {
            f28468b.log(i2 == 5 ? Level.WARNING : Level.INFO, str, th);
        }
    }

    public Object a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (f28468b.isLoggable(Level.FINE)) {
                return new Throwable(str);
            }
            return null;
        }
        return invokeL.objValue;
    }

    public void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, obj) == null) {
            if (obj == null) {
                str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
            }
            a(5, str, (Throwable) obj);
        }
    }

    public static List<String> a(List<x> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                x xVar = list.get(i2);
                if (xVar != x.f28659a) {
                    arrayList.add(xVar.toString());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public f b(X509TrustManager x509TrustManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, x509TrustManager)) == null) ? new com.bytedance.sdk.component.b.b.a.i.b(x509TrustManager.getAcceptedIssuers()) : (f) invokeL.objValue;
    }

    public com.bytedance.sdk.component.b.b.a.i.c a(X509TrustManager x509TrustManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, x509TrustManager)) == null) ? new com.bytedance.sdk.component.b.b.a.i.a(b(x509TrustManager)) : (com.bytedance.sdk.component.b.b.a.i.c) invokeL.objValue;
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            e a2 = a.a();
            if (a2 != null) {
                return a2;
            }
            b a3 = b.a();
            if (a3 != null) {
                return a3;
            }
            e a4 = c.a();
            return a4 != null ? a4 : new e();
        }
        return (e) invokeV.objValue;
    }
}
