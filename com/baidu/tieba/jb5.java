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
import com.baidu.tieba.db5;
import com.baidu.tieba.gb5;
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
/* loaded from: classes6.dex */
public class jb5 {
    public static /* synthetic */ Interceptable $ic;
    public static jb5 l;
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
    public final yd k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947877548, "Lcom/baidu/tieba/jb5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947877548, "Lcom/baidu/tieba/jb5;");
        }
    }

    /* loaded from: classes6.dex */
    public class d implements gb5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jb5 a;

        /* loaded from: classes6.dex */
        public class a implements db5.b {
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

            @Override // com.baidu.tieba.db5.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.b = 0;
                this.a.a.e = db5.f().g();
                if (this.a.a.e != null) {
                    this.a.a.A("change ip to reconnect with DNS' failed.");
                } else {
                    this.a.a.f = false;
                }
            }
        }

        public d(jb5 jb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jb5Var;
        }

        @Override // com.baidu.tieba.gb5.c
        public void a(boolean z) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                eb5 e = eb5.e();
                if (z) {
                    i = 2;
                } else {
                    i = 1;
                }
                e.a(i);
                if (z) {
                    this.a.e = db5.f().g();
                    if (this.a.e == null) {
                        db5.f().m(new a(this));
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

    /* loaded from: classes6.dex */
    public class a implements yd {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jb5 a;

        @Override // com.baidu.tieba.yd
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.yd
        public void c(ud udVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, udVar) == null) {
            }
        }

        @Override // com.baidu.tieba.yd
        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            }
        }

        @Override // com.baidu.tieba.yd
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.tieba.yd
        public void f(ce ceVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, ceVar) == null) {
            }
        }

        @Override // com.baidu.tieba.yd
        public void g(int i, ud udVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048582, this, i, udVar) == null) {
            }
        }

        @Override // com.baidu.tieba.yd
        public void h(ud udVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, udVar) == null) {
            }
        }

        @Override // com.baidu.tieba.yd
        public void i(ud udVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, udVar) == null) {
            }
        }

        public a(jb5 jb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jb5Var;
        }

        @Override // com.baidu.tieba.yd
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                if ((i == 2 || i == 9) && BdNetTypeUtil.isNetWorkAvailable()) {
                    jb5.d(this.a);
                    if (UseHttpdnsSdkSwitch.isOn()) {
                        if (this.a.h == null || this.a.h.isEmpty()) {
                            this.a.w();
                        } else {
                            this.a.a();
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("retryiplist_");
                        stringBuffer.append(h5.d());
                        if (this.a.j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.a.j.getIpv4List());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.a.j.getResolveType());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.a.j.getResolveStatus());
                        }
                        i5.a("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                        if (this.a.a >= 5) {
                            BdSocketLinkService.setAvailable(false);
                            this.a.B();
                        }
                    } else if (this.a.a >= 5) {
                        i5.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + h5.d());
                        this.a.C();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.yd
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (this.a.a > 0) {
                        this.a.i = false;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("URL_");
                        stringBuffer.append(h5.d());
                        if (this.a.j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.a.j.getIpv4List());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.a.j.getResolveType());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.a.j.getResolveStatus());
                        }
                        i5.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                    }
                } else if (this.a.a >= 5) {
                    i5.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + h5.d());
                    db5.f().l(h5.d());
                    db5.f().k();
                }
                this.a.a = 0;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BDHttpDns.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jb5 a;

        public b(jb5 jb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jb5Var;
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

    /* loaded from: classes6.dex */
    public class c implements db5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ jb5 b;

        public c(jb5 jb5Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb5Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jb5Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.db5.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.b = 0;
            this.b.e = db5.f().g();
            if (this.b.e != null) {
                this.b.A(this.a);
            } else {
                this.b.f = false;
            }
        }
    }

    public jb5() {
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
            eb5.e().d(TiebaIMConfig.url);
        }
        eb5.e().b();
        if (!this.d) {
            new gb5("www.baidu.com", new d(this));
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
                        h5.h("ws://" + remove + ":" + v(TiebaIMConfig.url));
                        BdSocketLinkService.init();
                    }
                }
            }
        }
    }

    public static /* synthetic */ int d(jb5 jb5Var) {
        int i = jb5Var.a;
        jb5Var.a = i + 1;
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

    public static synchronized jb5 y() {
        InterceptResult invokeV;
        jb5 jb5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            synchronized (jb5.class) {
                if (l == null) {
                    synchronized (jb5.class) {
                        if (l == null) {
                            l = new jb5();
                        }
                    }
                }
                jb5Var = l;
            }
            return jb5Var;
        }
        return (jb5) invokeV.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.i) {
            return;
        }
        try {
            String u = u(TiebaIMConfig.url);
            if (ad.isEmpty(u)) {
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
                return db5.f().g().get(this.b);
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
                if (!db5.f().i()) {
                    db5.f().m(new c(this, str));
                }
                h5.h(TiebaIMConfig.url);
                BdSocketLinkService.setAvailable(false);
                D();
            } else if (u(x) == null) {
                D();
            } else {
                this.f = false;
                BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
                h5.h(x);
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
            zd.h().c(this.k);
        }
    }
}
