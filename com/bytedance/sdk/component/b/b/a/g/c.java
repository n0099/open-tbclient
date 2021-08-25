package com.bytedance.sdk.component.b.b.a.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.x;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
/* loaded from: classes9.dex */
public class c extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Method f64604a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f64605b;

    /* renamed from: c  reason: collision with root package name */
    public final Method f64606c;

    /* renamed from: d  reason: collision with root package name */
    public final Class<?> f64607d;

    /* renamed from: e  reason: collision with root package name */
    public final Class<?> f64608e;

    /* loaded from: classes9.dex */
    public static class a implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f64609a;

        /* renamed from: b  reason: collision with root package name */
        public String f64610b;

        /* renamed from: c  reason: collision with root package name */
        public final List<String> f64611c;

        public a(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64611c = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                String name = method.getName();
                Class<?> returnType = method.getReturnType();
                if (objArr == null) {
                    objArr = com.bytedance.sdk.component.b.b.a.c.f64364b;
                }
                if (name.equals("supports") && Boolean.TYPE == returnType) {
                    return Boolean.TRUE;
                }
                if (name.equals("unsupported") && Void.TYPE == returnType) {
                    this.f64609a = true;
                    return null;
                } else if (name.equals(WebSocketRequest.PARAM_KEY_PROTOCOLS) && objArr.length == 0) {
                    return this.f64611c;
                } else {
                    if ((name.equals("selectProtocol") || name.equals(InvoiceBuildActivity.EXTRA_PARAMS_TYPE)) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                        List list = (List) objArr[0];
                        int size = list.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            if (this.f64611c.contains(list.get(i2))) {
                                String str = (String) list.get(i2);
                                this.f64610b = str;
                                return str;
                            }
                        }
                        String str2 = this.f64611c.get(0);
                        this.f64610b = str2;
                        return str2;
                    } else if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                        this.f64610b = (String) objArr[0];
                        return null;
                    } else {
                        return method.invoke(this, objArr);
                    }
                }
            }
            return invokeLLL.objValue;
        }
    }

    public c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {method, method2, method3, cls, cls2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64604a = method;
        this.f64605b = method2;
        this.f64606c = method3;
        this.f64607d = cls;
        this.f64608e = cls2;
    }

    @Override // com.bytedance.sdk.component.b.b.a.g.e
    public void a(SSLSocket sSLSocket, String str, List<x> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sSLSocket, str, list) == null) {
            try {
                this.f64604a.invoke(null, sSLSocket, Proxy.newProxyInstance(e.class.getClassLoader(), new Class[]{this.f64607d, this.f64608e}, new a(e.a(list))));
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw com.bytedance.sdk.component.b.b.a.c.a("unable to set alpn", (Exception) e2);
            }
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.g.e
    public void b(SSLSocket sSLSocket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sSLSocket) == null) {
            try {
                this.f64606c.invoke(null, sSLSocket);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw com.bytedance.sdk.component.b.b.a.c.a("unable to remove alpn", (Exception) e2);
            }
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.g.e
    public String a(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sSLSocket)) == null) {
            try {
                a aVar = (a) Proxy.getInvocationHandler(this.f64605b.invoke(null, sSLSocket));
                if (!aVar.f64609a && aVar.f64610b == null) {
                    e.b().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                    return null;
                } else if (aVar.f64609a) {
                    return null;
                } else {
                    return aVar.f64610b;
                }
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw com.bytedance.sdk.component.b.b.a.c.a("unable to get selected protocol", (Exception) e2);
            }
        }
        return (String) invokeL.objValue;
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
                Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider");
                return new c(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), cls3, Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                return null;
            }
        }
        return (e) invokeV.objValue;
    }
}
