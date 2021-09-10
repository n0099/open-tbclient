package com.bytedance.sdk.component.b.b.a.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.x;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
/* loaded from: classes9.dex */
public final class b extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Method f64782a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f64783b;

    public b(Method method, Method method2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {method, method2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64782a = method;
        this.f64783b = method2;
    }

    @Override // com.bytedance.sdk.component.b.b.a.g.e
    public void a(SSLSocket sSLSocket, String str, List<x> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sSLSocket, str, list) == null) {
            try {
                SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                List<String> a2 = e.a(list);
                this.f64782a.invoke(sSLParameters, a2.toArray(new String[a2.size()]));
                sSLSocket.setSSLParameters(sSLParameters);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw com.bytedance.sdk.component.b.b.a.c.a("unable to set ssl parameters", (Exception) e2);
            }
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.g.e
    public String a(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sSLSocket)) == null) {
            try {
                String str = (String) this.f64783b.invoke(sSLSocket, new Object[0]);
                if (str != null) {
                    if (str.equals("")) {
                        return null;
                    }
                    return str;
                }
                return null;
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw com.bytedance.sdk.component.b.b.a.c.a("unable to get selected protocols", (Exception) e2);
            }
        }
        return (String) invokeL.objValue;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                return new b(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
        return (b) invokeV.objValue;
    }
}
