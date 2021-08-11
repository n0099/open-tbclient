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
    public final t f64074a;

    /* renamed from: b  reason: collision with root package name */
    public final o f64075b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f64076c;

    /* renamed from: d  reason: collision with root package name */
    public final b f64077d;

    /* renamed from: e  reason: collision with root package name */
    public final List<x> f64078e;

    /* renamed from: f  reason: collision with root package name */
    public final List<k> f64079f;

    /* renamed from: g  reason: collision with root package name */
    public final ProxySelector f64080g;

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f64081h;

    /* renamed from: i  reason: collision with root package name */
    public final SSLSocketFactory f64082i;

    /* renamed from: j  reason: collision with root package name */
    public final HostnameVerifier f64083j;
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
        this.f64074a = new t.a().a(sSLSocketFactory != null ? "https" : "http").d(str).a(i2).c();
        if (oVar != null) {
            this.f64075b = oVar;
            if (socketFactory != null) {
                this.f64076c = socketFactory;
                if (bVar != null) {
                    this.f64077d = bVar;
                    if (list != null) {
                        this.f64078e = com.bytedance.sdk.component.b.b.a.c.a(list);
                        if (list2 != null) {
                            this.f64079f = com.bytedance.sdk.component.b.b.a.c.a(list2);
                            if (proxySelector != null) {
                                this.f64080g = proxySelector;
                                this.f64081h = proxy;
                                this.f64082i = sSLSocketFactory;
                                this.f64083j = hostnameVerifier;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64074a : (t) invokeV.objValue;
    }

    public o b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64075b : (o) invokeV.objValue;
    }

    public SocketFactory c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64076c : (SocketFactory) invokeV.objValue;
    }

    public b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f64077d : (b) invokeV.objValue;
    }

    public List<x> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f64078e : (List) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f64074a.equals(aVar.f64074a) && a(aVar)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f64079f : (List) invokeV.objValue;
    }

    public ProxySelector g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f64080g : (ProxySelector) invokeV.objValue;
    }

    public Proxy h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f64081h : (Proxy) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int hashCode = (((((((((((527 + this.f64074a.hashCode()) * 31) + this.f64075b.hashCode()) * 31) + this.f64077d.hashCode()) * 31) + this.f64078e.hashCode()) * 31) + this.f64079f.hashCode()) * 31) + this.f64080g.hashCode()) * 31;
            Proxy proxy = this.f64081h;
            int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
            SSLSocketFactory sSLSocketFactory = this.f64082i;
            int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
            HostnameVerifier hostnameVerifier = this.f64083j;
            int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
            g gVar = this.k;
            return hashCode4 + (gVar != null ? gVar.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public SSLSocketFactory i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f64082i : (SSLSocketFactory) invokeV.objValue;
    }

    public HostnameVerifier j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f64083j : (HostnameVerifier) invokeV.objValue;
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
            sb.append(this.f64074a.g());
            sb.append(":");
            sb.append(this.f64074a.h());
            if (this.f64081h != null) {
                sb.append(", proxy=");
                sb.append(this.f64081h);
            } else {
                sb.append(", proxySelector=");
                sb.append(this.f64080g);
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? this.f64075b.equals(aVar.f64075b) && this.f64077d.equals(aVar.f64077d) && this.f64078e.equals(aVar.f64078e) && this.f64079f.equals(aVar.f64079f) && this.f64080g.equals(aVar.f64080g) && com.bytedance.sdk.component.b.b.a.c.a(this.f64081h, aVar.f64081h) && com.bytedance.sdk.component.b.b.a.c.a(this.f64082i, aVar.f64082i) && com.bytedance.sdk.component.b.b.a.c.a(this.f64083j, aVar.f64083j) && com.bytedance.sdk.component.b.b.a.c.a(this.k, aVar.k) && a().h() == aVar.a().h() : invokeL.booleanValue;
    }
}
