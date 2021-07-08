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
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final t f28137a;

    /* renamed from: b  reason: collision with root package name */
    public final o f28138b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f28139c;

    /* renamed from: d  reason: collision with root package name */
    public final b f28140d;

    /* renamed from: e  reason: collision with root package name */
    public final List<x> f28141e;

    /* renamed from: f  reason: collision with root package name */
    public final List<k> f28142f;

    /* renamed from: g  reason: collision with root package name */
    public final ProxySelector f28143g;

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f28144h;

    /* renamed from: i  reason: collision with root package name */
    public final SSLSocketFactory f28145i;
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
        this.f28137a = new t.a().a(sSLSocketFactory != null ? "https" : "http").d(str).a(i2).c();
        if (oVar != null) {
            this.f28138b = oVar;
            if (socketFactory != null) {
                this.f28139c = socketFactory;
                if (bVar != null) {
                    this.f28140d = bVar;
                    if (list != null) {
                        this.f28141e = com.bytedance.sdk.component.b.b.a.c.a(list);
                        if (list2 != null) {
                            this.f28142f = com.bytedance.sdk.component.b.b.a.c.a(list2);
                            if (proxySelector != null) {
                                this.f28143g = proxySelector;
                                this.f28144h = proxy;
                                this.f28145i = sSLSocketFactory;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28137a : (t) invokeV.objValue;
    }

    public o b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28138b : (o) invokeV.objValue;
    }

    public SocketFactory c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28139c : (SocketFactory) invokeV.objValue;
    }

    public b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28140d : (b) invokeV.objValue;
    }

    public List<x> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28141e : (List) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f28137a.equals(aVar.f28137a) && a(aVar)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28142f : (List) invokeV.objValue;
    }

    public ProxySelector g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28143g : (ProxySelector) invokeV.objValue;
    }

    public Proxy h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f28144h : (Proxy) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int hashCode = (((((((((((527 + this.f28137a.hashCode()) * 31) + this.f28138b.hashCode()) * 31) + this.f28140d.hashCode()) * 31) + this.f28141e.hashCode()) * 31) + this.f28142f.hashCode()) * 31) + this.f28143g.hashCode()) * 31;
            Proxy proxy = this.f28144h;
            int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
            SSLSocketFactory sSLSocketFactory = this.f28145i;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f28145i : (SSLSocketFactory) invokeV.objValue;
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
            sb.append(this.f28137a.g());
            sb.append(":");
            sb.append(this.f28137a.h());
            if (this.f28144h != null) {
                sb.append(", proxy=");
                sb.append(this.f28144h);
            } else {
                sb.append(", proxySelector=");
                sb.append(this.f28143g);
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? this.f28138b.equals(aVar.f28138b) && this.f28140d.equals(aVar.f28140d) && this.f28141e.equals(aVar.f28141e) && this.f28142f.equals(aVar.f28142f) && this.f28143g.equals(aVar.f28143g) && com.bytedance.sdk.component.b.b.a.c.a(this.f28144h, aVar.f28144h) && com.bytedance.sdk.component.b.b.a.c.a(this.f28145i, aVar.f28145i) && com.bytedance.sdk.component.b.b.a.c.a(this.j, aVar.j) && com.bytedance.sdk.component.b.b.a.c.a(this.k, aVar.k) && a().h() == aVar.a().h() : invokeL.booleanValue;
    }
}
