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
    public final com.bytedance.sdk.component.b.b.a f64142a;

    /* renamed from: b  reason: collision with root package name */
    public final d f64143b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.e f64144c;

    /* renamed from: d  reason: collision with root package name */
    public final p f64145d;

    /* renamed from: e  reason: collision with root package name */
    public List<Proxy> f64146e;

    /* renamed from: f  reason: collision with root package name */
    public int f64147f;

    /* renamed from: g  reason: collision with root package name */
    public List<InetSocketAddress> f64148g;

    /* renamed from: h  reason: collision with root package name */
    public final List<ad> f64149h;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<ad> f64150a;

        /* renamed from: b  reason: collision with root package name */
        public int f64151b;

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
            this.f64151b = 0;
            this.f64150a = list;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64151b < this.f64150a.size() : invokeV.booleanValue;
        }

        public ad b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (a()) {
                    List<ad> list = this.f64150a;
                    int i2 = this.f64151b;
                    this.f64151b = i2 + 1;
                    return list.get(i2);
                }
                throw new NoSuchElementException();
            }
            return (ad) invokeV.objValue;
        }

        public List<ad> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new ArrayList(this.f64150a) : (List) invokeV.objValue;
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
        this.f64146e = Collections.emptyList();
        this.f64148g = Collections.emptyList();
        this.f64149h = new ArrayList();
        this.f64142a = aVar;
        this.f64143b = dVar;
        this.f64144c = eVar;
        this.f64145d = pVar;
        a(aVar.a(), aVar.h());
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.f64147f < this.f64146e.size() : invokeV.booleanValue;
    }

    private Proxy d() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            if (c()) {
                List<Proxy> list = this.f64146e;
                int i2 = this.f64147f;
                this.f64147f = i2 + 1;
                Proxy proxy = list.get(i2);
                a(proxy);
                return proxy;
            }
            throw new SocketException("No route to " + this.f64142a.a().g() + "; exhausted proxy configurations: " + this.f64146e);
        }
        return (Proxy) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c() || !this.f64149h.isEmpty() : invokeV.booleanValue;
    }

    public a b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (a()) {
                ArrayList arrayList = new ArrayList();
                while (c()) {
                    Proxy d2 = d();
                    int size = this.f64148g.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ad adVar = new ad(this.f64142a, d2, this.f64148g.get(i2));
                        if (this.f64143b.c(adVar)) {
                            this.f64149h.add(adVar);
                        } else {
                            arrayList.add(adVar);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        break;
                    }
                }
                if (arrayList.isEmpty()) {
                    arrayList.addAll(this.f64149h);
                    this.f64149h.clear();
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
            if (adVar.b().type() != Proxy.Type.DIRECT && this.f64142a.g() != null) {
                this.f64142a.g().connectFailed(this.f64142a.a().b(), adVar.b().address(), iOException);
            }
            this.f64143b.a(adVar);
        }
    }

    private void a(t tVar, Proxy proxy) {
        List<Proxy> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, tVar, proxy) == null) {
            if (proxy != null) {
                this.f64146e = Collections.singletonList(proxy);
            } else {
                List<Proxy> select = this.f64142a.g().select(tVar.b());
                if (select != null && !select.isEmpty()) {
                    a2 = com.bytedance.sdk.component.b.b.a.c.a(select);
                } else {
                    a2 = com.bytedance.sdk.component.b.b.a.c.a(Proxy.NO_PROXY);
                }
                this.f64146e = a2;
            }
            this.f64147f = 0;
        }
    }

    private void a(Proxy proxy) throws IOException {
        String g2;
        int h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, proxy) == null) {
            this.f64148g = new ArrayList();
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
                g2 = this.f64142a.a().g();
                h2 = this.f64142a.a().h();
            }
            if (h2 >= 1 && h2 <= 65535) {
                if (proxy.type() == Proxy.Type.SOCKS) {
                    this.f64148g.add(InetSocketAddress.createUnresolved(g2, h2));
                    return;
                }
                this.f64145d.a(this.f64144c, g2);
                List<InetAddress> a2 = this.f64142a.b().a(g2);
                if (!a2.isEmpty()) {
                    this.f64145d.a(this.f64144c, g2, a2);
                    int size = a2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        this.f64148g.add(new InetSocketAddress(a2.get(i2), h2));
                    }
                    return;
                }
                throw new UnknownHostException(this.f64142a.b() + " returned no addresses for " + g2);
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
