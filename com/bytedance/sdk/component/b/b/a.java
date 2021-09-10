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
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final t f64454a;

    /* renamed from: b  reason: collision with root package name */
    public final o f64455b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f64456c;

    /* renamed from: d  reason: collision with root package name */
    public final b f64457d;

    /* renamed from: e  reason: collision with root package name */
    public final List<x> f64458e;

    /* renamed from: f  reason: collision with root package name */
    public final List<k> f64459f;

    /* renamed from: g  reason: collision with root package name */
    public final ProxySelector f64460g;

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f64461h;

    /* renamed from: i  reason: collision with root package name */
    public final SSLSocketFactory f64462i;

    /* renamed from: j  reason: collision with root package name */
    public final HostnameVerifier f64463j;
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
        this.f64454a = new t.a().a(sSLSocketFactory != null ? "https" : "http").d(str).a(i2).c();
        if (oVar != null) {
            this.f64455b = oVar;
            if (socketFactory != null) {
                this.f64456c = socketFactory;
                if (bVar != null) {
                    this.f64457d = bVar;
                    if (list != null) {
                        this.f64458e = com.bytedance.sdk.component.b.b.a.c.a(list);
                        if (list2 != null) {
                            this.f64459f = com.bytedance.sdk.component.b.b.a.c.a(list2);
                            if (proxySelector != null) {
                                this.f64460g = proxySelector;
                                this.f64461h = proxy;
                                this.f64462i = sSLSocketFactory;
                                this.f64463j = hostnameVerifier;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64454a : (t) invokeV.objValue;
    }

    public o b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64455b : (o) invokeV.objValue;
    }

    public SocketFactory c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64456c : (SocketFactory) invokeV.objValue;
    }

    public b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f64457d : (b) invokeV.objValue;
    }

    public List<x> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f64458e : (List) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f64454a.equals(aVar.f64454a) && a(aVar)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f64459f : (List) invokeV.objValue;
    }

    public ProxySelector g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f64460g : (ProxySelector) invokeV.objValue;
    }

    public Proxy h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f64461h : (Proxy) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int hashCode = (((((((((((527 + this.f64454a.hashCode()) * 31) + this.f64455b.hashCode()) * 31) + this.f64457d.hashCode()) * 31) + this.f64458e.hashCode()) * 31) + this.f64459f.hashCode()) * 31) + this.f64460g.hashCode()) * 31;
            Proxy proxy = this.f64461h;
            int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
            SSLSocketFactory sSLSocketFactory = this.f64462i;
            int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
            HostnameVerifier hostnameVerifier = this.f64463j;
            int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
            g gVar = this.k;
            return hashCode4 + (gVar != null ? gVar.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public SSLSocketFactory i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f64462i : (SSLSocketFactory) invokeV.objValue;
    }

    public HostnameVerifier j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f64463j : (HostnameVerifier) invokeV.objValue;
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
            sb.append(this.f64454a.g());
            sb.append(":");
            sb.append(this.f64454a.h());
            if (this.f64461h != null) {
                sb.append(", proxy=");
                sb.append(this.f64461h);
            } else {
                sb.append(", proxySelector=");
                sb.append(this.f64460g);
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? this.f64455b.equals(aVar.f64455b) && this.f64457d.equals(aVar.f64457d) && this.f64458e.equals(aVar.f64458e) && this.f64459f.equals(aVar.f64459f) && this.f64460g.equals(aVar.f64460g) && com.bytedance.sdk.component.b.b.a.c.a(this.f64461h, aVar.f64461h) && com.bytedance.sdk.component.b.b.a.c.a(this.f64462i, aVar.f64462i) && com.bytedance.sdk.component.b.b.a.c.a(this.f64463j, aVar.f64463j) && com.bytedance.sdk.component.b.b.a.c.a(this.k, aVar.k) && a().h() == aVar.a().h() : invokeL.booleanValue;
    }
}
