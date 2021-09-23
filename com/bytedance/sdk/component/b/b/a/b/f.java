package com.bytedance.sdk.component.b.b.a.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.ad;
import com.bytedance.sdk.component.b.b.p;
import com.bytedance.sdk.component.b.b.t;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: classes9.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.a f64833a;

    /* renamed from: b  reason: collision with root package name */
    public final d f64834b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.e f64835c;

    /* renamed from: d  reason: collision with root package name */
    public final p f64836d;

    /* renamed from: e  reason: collision with root package name */
    public List<Proxy> f64837e;

    /* renamed from: f  reason: collision with root package name */
    public int f64838f;

    /* renamed from: g  reason: collision with root package name */
    public List<InetSocketAddress> f64839g;

    /* renamed from: h  reason: collision with root package name */
    public final List<ad> f64840h;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<ad> f64841a;

        /* renamed from: b  reason: collision with root package name */
        public int f64842b;

        public a(List<ad> list) {
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
            this.f64842b = 0;
            this.f64841a = list;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64842b < this.f64841a.size() : invokeV.booleanValue;
        }

        public ad b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (a()) {
                    List<ad> list = this.f64841a;
                    int i2 = this.f64842b;
                    this.f64842b = i2 + 1;
                    return list.get(i2);
                }
                throw new NoSuchElementException();
            }
            return (ad) invokeV.objValue;
        }

        public List<ad> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new ArrayList(this.f64841a) : (List) invokeV.objValue;
        }
    }

    public f(com.bytedance.sdk.component.b.b.a aVar, d dVar, com.bytedance.sdk.component.b.b.e eVar, p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, dVar, eVar, pVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64837e = Collections.emptyList();
        this.f64839g = Collections.emptyList();
        this.f64840h = new ArrayList();
        this.f64833a = aVar;
        this.f64834b = dVar;
        this.f64835c = eVar;
        this.f64836d = pVar;
        a(aVar.a(), aVar.h());
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.f64838f < this.f64837e.size() : invokeV.booleanValue;
    }

    private Proxy d() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            if (c()) {
                List<Proxy> list = this.f64837e;
                int i2 = this.f64838f;
                this.f64838f = i2 + 1;
                Proxy proxy = list.get(i2);
                a(proxy);
                return proxy;
            }
            throw new SocketException("No route to " + this.f64833a.a().g() + "; exhausted proxy configurations: " + this.f64837e);
        }
        return (Proxy) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c() || !this.f64840h.isEmpty() : invokeV.booleanValue;
    }

    public a b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (a()) {
                ArrayList arrayList = new ArrayList();
                while (c()) {
                    Proxy d2 = d();
                    int size = this.f64839g.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ad adVar = new ad(this.f64833a, d2, this.f64839g.get(i2));
                        if (this.f64834b.c(adVar)) {
                            this.f64840h.add(adVar);
                        } else {
                            arrayList.add(adVar);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        break;
                    }
                }
                if (arrayList.isEmpty()) {
                    arrayList.addAll(this.f64840h);
                    this.f64840h.clear();
                }
                return new a(arrayList);
            }
            throw new NoSuchElementException();
        }
        return (a) invokeV.objValue;
    }

    public void a(ad adVar, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adVar, iOException) == null) {
            if (adVar.b().type() != Proxy.Type.DIRECT && this.f64833a.g() != null) {
                this.f64833a.g().connectFailed(this.f64833a.a().b(), adVar.b().address(), iOException);
            }
            this.f64834b.a(adVar);
        }
    }

    private void a(t tVar, Proxy proxy) {
        List<Proxy> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, tVar, proxy) == null) {
            if (proxy != null) {
                this.f64837e = Collections.singletonList(proxy);
            } else {
                List<Proxy> select = this.f64833a.g().select(tVar.b());
                if (select != null && !select.isEmpty()) {
                    a2 = com.bytedance.sdk.component.b.b.a.c.a(select);
                } else {
                    a2 = com.bytedance.sdk.component.b.b.a.c.a(Proxy.NO_PROXY);
                }
                this.f64837e = a2;
            }
            this.f64838f = 0;
        }
    }

    private void a(Proxy proxy) throws IOException {
        String g2;
        int h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, proxy) == null) {
            this.f64839g = new ArrayList();
            if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
                SocketAddress address = proxy.address();
                if (address instanceof InetSocketAddress) {
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                    g2 = a(inetSocketAddress);
                    h2 = inetSocketAddress.getPort();
                } else {
                    throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
                }
            } else {
                g2 = this.f64833a.a().g();
                h2 = this.f64833a.a().h();
            }
            if (h2 >= 1 && h2 <= 65535) {
                if (proxy.type() == Proxy.Type.SOCKS) {
                    this.f64839g.add(InetSocketAddress.createUnresolved(g2, h2));
                    return;
                }
                this.f64836d.a(this.f64835c, g2);
                List<InetAddress> a2 = this.f64833a.b().a(g2);
                if (!a2.isEmpty()) {
                    this.f64836d.a(this.f64835c, g2, a2);
                    int size = a2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        this.f64839g.add(new InetSocketAddress(a2.get(i2), h2));
                    }
                    return;
                }
                throw new UnknownHostException(this.f64833a.b() + " returned no addresses for " + g2);
            }
            throw new SocketException("No route to " + g2 + ":" + h2 + "; port is out of range");
        }
    }

    public static String a(InetSocketAddress inetSocketAddress) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, inetSocketAddress)) == null) {
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                return inetSocketAddress.getHostName();
            }
            return address.getHostAddress();
        }
        return (String) invokeL.objValue;
    }
}
