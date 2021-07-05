package com.bytedance.sdk.component.b.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.t;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final t f28027a;

    /* renamed from: b  reason: collision with root package name */
    public final o f28028b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f28029c;

    /* renamed from: d  reason: collision with root package name */
    public final b f28030d;

    /* renamed from: e  reason: collision with root package name */
    public final List<x> f28031e;

    /* renamed from: f  reason: collision with root package name */
    public final List<k> f28032f;

    /* renamed from: g  reason: collision with root package name */
    public final ProxySelector f28033g;

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f28034h;

    /* renamed from: i  reason: collision with root package name */
    public final SSLSocketFactory f28035i;
    public final HostnameVerifier j;
    public final g k;

    public a(String str, int i2, o oVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, b bVar, Proxy proxy, List<x> list, List<k> list2, ProxySelector proxySelector) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str, Integer.valueOf(i2), oVar, socketFactory, sSLSocketFactory, hostnameVerifier, gVar, bVar, proxy, list, list2, proxySelector};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28027a = new t.a().a(sSLSocketFactory != null ? "https" : "http").d(str).a(i2).c();
        if (oVar != null) {
            this.f28028b = oVar;
            if (socketFactory != null) {
                this.f28029c = socketFactory;
                if (bVar != null) {
                    this.f28030d = bVar;
                    if (list != null) {
                        this.f28031e = com.bytedance.sdk.component.b.b.a.c.a(list);
                        if (list2 != null) {
                            this.f28032f = com.bytedance.sdk.component.b.b.a.c.a(list2);
                            if (proxySelector != null) {
                                this.f28033g = proxySelector;
                                this.f28034h = proxy;
                                this.f28035i = sSLSocketFactory;
                                this.j = hostnameVerifier;
                                this.k = gVar;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    public t a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28027a : (t) invokeV.objValue;
    }

    public o b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28028b : (o) invokeV.objValue;
    }

    public SocketFactory c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28029c : (SocketFactory) invokeV.objValue;
    }

    public b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28030d : (b) invokeV.objValue;
    }

    public List<x> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28031e : (List) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f28027a.equals(aVar.f28027a) && a(aVar)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public List<k> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28032f : (List) invokeV.objValue;
    }

    public ProxySelector g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28033g : (ProxySelector) invokeV.objValue;
    }

    public Proxy h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f28034h : (Proxy) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int hashCode = (((((((((((527 + this.f28027a.hashCode()) * 31) + this.f28028b.hashCode()) * 31) + this.f28030d.hashCode()) * 31) + this.f28031e.hashCode()) * 31) + this.f28032f.hashCode()) * 31) + this.f28033g.hashCode()) * 31;
            Proxy proxy = this.f28034h;
            int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
            SSLSocketFactory sSLSocketFactory = this.f28035i;
            int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
            HostnameVerifier hostnameVerifier = this.j;
            int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
            g gVar = this.k;
            return hashCode4 + (gVar != null ? gVar.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public SSLSocketFactory i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f28035i : (SSLSocketFactory) invokeV.objValue;
    }

    public HostnameVerifier j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j : (HostnameVerifier) invokeV.objValue;
    }

    public g k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : (g) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Address{");
            sb.append(this.f28027a.g());
            sb.append(":");
            sb.append(this.f28027a.h());
            if (this.f28034h != null) {
                sb.append(", proxy=");
                sb.append(this.f28034h);
            } else {
                sb.append(", proxySelector=");
                sb.append(this.f28033g);
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? this.f28028b.equals(aVar.f28028b) && this.f28030d.equals(aVar.f28030d) && this.f28031e.equals(aVar.f28031e) && this.f28032f.equals(aVar.f28032f) && this.f28033g.equals(aVar.f28033g) && com.bytedance.sdk.component.b.b.a.c.a(this.f28034h, aVar.f28034h) && com.bytedance.sdk.component.b.b.a.c.a(this.f28035i, aVar.f28035i) && com.bytedance.sdk.component.b.b.a.c.a(this.j, aVar.j) && com.bytedance.sdk.component.b.b.a.c.a(this.k, aVar.k) && a().h() == aVar.a().h() : invokeL.booleanValue;
    }
}
