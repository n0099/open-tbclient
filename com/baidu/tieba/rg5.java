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
import com.baidu.tieba.lg5;
import com.baidu.tieba.og5;
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
/* loaded from: classes7.dex */
public class rg5 {
    public static /* synthetic */ Interceptable $ic;
    public static rg5 l;
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
    public final wj k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948120681, "Lcom/baidu/tieba/rg5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948120681, "Lcom/baidu/tieba/rg5;");
        }
    }

    /* loaded from: classes7.dex */
    public class d implements og5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rg5 a;

        /* loaded from: classes7.dex */
        public class a implements lg5.b {
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

            @Override // com.baidu.tieba.lg5.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.b = 0;
                this.a.a.e = lg5.f().g();
                if (this.a.a.e != null) {
                    this.a.a.A("change ip to reconnect with DNS' failed.");
                } else {
                    this.a.a.f = false;
                }
            }
        }

        public d(rg5 rg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rg5Var;
        }

        @Override // com.baidu.tieba.og5.c
        public void a(boolean z) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                mg5 e = mg5.e();
                if (z) {
                    i = 2;
                } else {
                    i = 1;
                }
                e.a(i);
                if (z) {
                    this.a.e = lg5.f().g();
                    if (this.a.e == null) {
                        lg5.f().m(new a(this));
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

    /* loaded from: classes7.dex */
    public class a implements wj {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rg5 a;

        @Override // com.baidu.tieba.wj
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.wj
        public void c(sj sjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sjVar) == null) {
            }
        }

        @Override // com.baidu.tieba.wj
        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            }
        }

        @Override // com.baidu.tieba.wj
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.tieba.wj
        public void f(ak akVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, akVar) == null) {
            }
        }

        @Override // com.baidu.tieba.wj
        public void g(int i, sj sjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048582, this, i, sjVar) == null) {
            }
        }

        @Override // com.baidu.tieba.wj
        public void h(sj sjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, sjVar) == null) {
            }
        }

        @Override // com.baidu.tieba.wj
        public void i(sj sjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sjVar) == null) {
            }
        }

        public a(rg5 rg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rg5Var;
        }

        @Override // com.baidu.tieba.wj
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                if ((i == 2 || i == 9) && BdNetTypeUtil.isNetWorkAvailable()) {
                    rg5.d(this.a);
                    if (UseHttpdnsSdkSwitch.isOn()) {
                        if (this.a.h == null || this.a.h.isEmpty()) {
                            this.a.w();
                        } else {
                            this.a.a();
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("retryiplist_");
                        stringBuffer.append(oa.d());
                        if (this.a.j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.a.j.a());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.a.j.d());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.a.j.c());
                        }
                        pa.a("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                        if (this.a.a >= 5) {
                            BdSocketLinkService.setAvailable(false);
                            this.a.B();
                        }
                    } else if (this.a.a >= 5) {
                        pa.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + oa.d());
                        this.a.C();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.wj
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (this.a.a > 0) {
                        this.a.i = false;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("URL_");
                        stringBuffer.append(oa.d());
                        if (this.a.j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.a.j.a());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.a.j.d());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.a.j.c());
                        }
                        pa.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                    }
                } else if (this.a.a >= 5) {
                    pa.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + oa.d());
                    lg5.f().l(oa.d());
                    lg5.f().k();
                }
                this.a.a = 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BDHttpDns.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rg5 a;

        public b(rg5 rg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rg5Var;
        }

        @Override // com.baidu.bdhttpdns.BDHttpDns.e
        public void a(BDHttpDnsResult bDHttpDnsResult) {
            ArrayList<String> a;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, bDHttpDnsResult) != null) {
                return;
            }
            this.a.i = false;
            this.a.j = bDHttpDnsResult;
            if (bDHttpDnsResult != null && (a = bDHttpDnsResult.a()) != null && !a.isEmpty()) {
                synchronized (this.a.g) {
                    this.a.h = a;
                }
                this.a.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements lg5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ rg5 b;

        public c(rg5 rg5Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rg5Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rg5Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.lg5.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.b = 0;
            this.b.e = lg5.f().g();
            if (this.b.e != null) {
                this.b.A(this.a);
            } else {
                this.b.f = false;
            }
        }
    }

    public rg5() {
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
            mg5.e().d(TiebaIMConfig.url);
        }
        mg5.e().b();
        if (!this.d) {
            new og5("www.baidu.com", new d(this));
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
                        oa.h("ws://" + remove + ":" + v(TiebaIMConfig.url));
                        BdSocketLinkService.init();
                    }
                }
            }
        }
    }

    public static /* synthetic */ int d(rg5 rg5Var) {
        int i = rg5Var.a;
        rg5Var.a = i + 1;
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

    public static synchronized rg5 y() {
        InterceptResult invokeV;
        rg5 rg5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            synchronized (rg5.class) {
                if (l == null) {
                    synchronized (rg5.class) {
                        if (l == null) {
                            l = new rg5();
                        }
                    }
                }
                rg5Var = l;
            }
            return rg5Var;
        }
        return (rg5) invokeV.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.i) {
            return;
        }
        try {
            String u = u(TiebaIMConfig.url);
            if (wi.isEmpty(u)) {
                B();
                return;
            }
            this.i = true;
            BDHttpDns.h(BdBaseApplication.getInst().getApplicationContext()).b(u, new b(this));
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
                return lg5.f().g().get(this.b);
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
                if (!lg5.f().i()) {
                    lg5.f().m(new c(this, str));
                }
                oa.h(TiebaIMConfig.url);
                BdSocketLinkService.setAvailable(false);
                D();
            } else if (u(x) == null) {
                D();
            } else {
                this.f = false;
                BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
                oa.h(x);
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
            NoNetworkView.f();
            this.b = 0;
            this.i = false;
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NoNetworkView.f();
            this.d = false;
            this.b = 0;
            this.f = false;
            this.c = false;
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            xj.j().c(this.k);
        }
    }
}
