package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.baidu.tieba.sg5;
import com.baidu.tieba.vg5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class yg5 {
    public static /* synthetic */ Interceptable $ic;
    public static yg5 l;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public boolean c;
    public boolean d;
    public List<String> e;
    public boolean f;
    public final Object g;
    public List<String> h;
    public boolean i;
    public BDHttpDnsResult j;
    public final cj k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948329218, "Lcom/baidu/tieba/yg5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948329218, "Lcom/baidu/tieba/yg5;");
        }
    }

    /* loaded from: classes8.dex */
    public class d implements vg5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yg5 a;

        /* loaded from: classes8.dex */
        public class a implements sg5.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.baidu.tieba.sg5.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.b = 0;
                this.a.a.e = sg5.f().g();
                if (this.a.a.e != null) {
                    this.a.a.A("change ip to reconnect with DNS' failed.");
                } else {
                    this.a.a.f = false;
                }
            }
        }

        public d(yg5 yg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yg5Var;
        }

        @Override // com.baidu.tieba.vg5.c
        public void a(boolean z) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                tg5 e = tg5.e();
                if (z) {
                    i = 2;
                } else {
                    i = 1;
                }
                e.a(i);
                if (z) {
                    this.a.e = sg5.f().g();
                    if (this.a.e == null) {
                        sg5.f().m(new a(this));
                        return;
                    } else {
                        this.a.A("change ip to reconnect with DNS' failed.");
                        return;
                    }
                }
                this.a.f = false;
                this.a.D();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements cj {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yg5 a;

        @Override // com.baidu.tieba.cj
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.cj
        public void c(yi yiVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yiVar) == null) {
            }
        }

        @Override // com.baidu.tieba.cj
        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            }
        }

        @Override // com.baidu.tieba.cj
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.tieba.cj
        public void f(gj gjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gjVar) == null) {
            }
        }

        @Override // com.baidu.tieba.cj
        public void g(int i, yi yiVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048582, this, i, yiVar) == null) {
            }
        }

        @Override // com.baidu.tieba.cj
        public void h(yi yiVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, yiVar) == null) {
            }
        }

        @Override // com.baidu.tieba.cj
        public void i(yi yiVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yiVar) == null) {
            }
        }

        public a(yg5 yg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yg5Var;
        }

        @Override // com.baidu.tieba.cj
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                if ((i == 2 || i == 9) && BdNetTypeUtil.isNetWorkAvailable()) {
                    yg5.d(this.a);
                    if (UseHttpdnsSdkSwitch.isOn()) {
                        if (this.a.h == null || this.a.h.isEmpty()) {
                            this.a.w();
                        } else {
                            this.a.a();
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("retryiplist_");
                        stringBuffer.append(ja.d());
                        if (this.a.j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.a.j.getIpv4List());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.a.j.getResolveType());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.a.j.getResolveStatus());
                        }
                        ka.a("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                        if (this.a.a >= 5) {
                            BdSocketLinkService.setAvailable(false);
                            this.a.B();
                        }
                    } else if (this.a.a >= 5) {
                        ka.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + ja.d());
                        this.a.C();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.cj
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (this.a.a > 0) {
                        this.a.i = false;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("URL_");
                        stringBuffer.append(ja.d());
                        if (this.a.j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.a.j.getIpv4List());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.a.j.getResolveType());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.a.j.getResolveStatus());
                        }
                        ka.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                    }
                } else if (this.a.a >= 5) {
                    ka.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + ja.d());
                    sg5.f().l(ja.d());
                    sg5.f().k();
                }
                this.a.a = 0;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements BDHttpDns.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yg5 a;

        public b(yg5 yg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yg5Var;
        }

        @Override // com.baidu.bdhttpdns.BDHttpDns.e
        public void a(BDHttpDnsResult bDHttpDnsResult) {
            ArrayList<String> ipv4List;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, bDHttpDnsResult) != null) {
                return;
            }
            this.a.i = false;
            this.a.j = bDHttpDnsResult;
            if (bDHttpDnsResult != null && (ipv4List = bDHttpDnsResult.getIpv4List()) != null && !ipv4List.isEmpty()) {
                synchronized (this.a.g) {
                    this.a.h = ipv4List;
                }
                this.a.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements sg5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ yg5 b;

        public c(yg5 yg5Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yg5Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yg5Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.sg5.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.b = 0;
            this.b.e = sg5.f().g();
            if (this.b.e != null) {
                this.b.A(this.a);
            } else {
                this.b.f = false;
            }
        }
    }

    public yg5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = false;
        this.d = false;
        this.e = null;
        this.f = false;
        this.g = new Object();
        this.h = new ArrayList();
        this.i = false;
        this.j = null;
        this.k = new a(this);
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.f) {
            return;
        }
        this.f = true;
        if (this.c) {
            this.c = false;
            tg5.e().d(TiebaIMConfig.url);
        }
        tg5.e().b();
        if (!this.d) {
            new vg5("www.baidu.com", new d(this));
            this.d = true;
            return;
        }
        A("change ip to reconnect with DNS' failed.");
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.g) {
                if (this.h != null && !this.h.isEmpty()) {
                    String remove = this.h.remove(0);
                    if (!TextUtils.isEmpty(remove)) {
                        ja.h("ws://" + remove + ":" + v(TiebaIMConfig.url));
                        BdSocketLinkService.init();
                    }
                }
            }
        }
    }

    public static /* synthetic */ int d(yg5 yg5Var) {
        int i = yg5Var.a;
        yg5Var.a = i + 1;
        return i;
    }

    public static String u(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) {
            if (str == null || (lastIndexOf = str.lastIndexOf(":")) < 5) {
                return null;
            }
            try {
                return str.substring(5, lastIndexOf);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String v(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if (str == null || (lastIndexOf = str.lastIndexOf(":")) < 5) {
                return null;
            }
            try {
                return str.substring(lastIndexOf + 1);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static synchronized yg5 y() {
        InterceptResult invokeV;
        yg5 yg5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            synchronized (yg5.class) {
                if (l == null) {
                    synchronized (yg5.class) {
                        if (l == null) {
                            l = new yg5();
                        }
                    }
                }
                yg5Var = l;
            }
            return yg5Var;
        }
        return (yg5) invokeV.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.i) {
            return;
        }
        try {
            String u = u(TiebaIMConfig.url);
            if (ei.isEmpty(u)) {
                B();
                return;
            }
            this.i = true;
            BDHttpDns.getService(BdBaseApplication.getInst().getApplicationContext()).asyncResolve(u, new b(this));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public final String x() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<String> list = this.e;
            if (list != null && (i = this.b) > -1 && i < list.size()) {
                return sg5.f().g().get(this.b);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            String x = x();
            if (x == null) {
                if (!sg5.f().i()) {
                    sg5.f().m(new c(this, str));
                }
                ja.h(TiebaIMConfig.url);
                BdSocketLinkService.setAvailable(false);
                D();
            } else if (u(x) == null) {
                D();
            } else {
                this.f = false;
                BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
                ja.h(x);
                BdSocketLinkService.init();
                BdSocketLinkService.startService(true, str);
                this.c = true;
                this.b++;
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NoNetworkView.updateUI();
            this.b = 0;
            this.i = false;
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NoNetworkView.updateUI();
            this.d = false;
            this.b = 0;
            this.f = false;
            this.c = false;
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            dj.h().c(this.k);
        }
    }
}
