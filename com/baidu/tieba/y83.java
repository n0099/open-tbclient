package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.tieba.jn1;
import com.baidu.tieba.q83;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class y83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean p;
    public static final Map q;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final String b;
    public final String c;
    public boolean d;
    public final Set e;
    public TaskState f;
    public JSONObject g;
    public boolean h;
    public m33 i;
    public final ff3 j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public final ai3 o;

    /* loaded from: classes6.dex */
    public class c implements jn1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ m83 b;
        public final /* synthetic */ y83 c;

        /* loaded from: classes6.dex */
        public class a implements jn1.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.tieba.jn1.c
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    m02.i("OpenData", "bindPhoneNumber check onSuccess isBind =" + z + ". needAuth = " + this.a.a);
                    if (!z) {
                        this.a.c.j.b(10006L);
                        this.a.c.A();
                        return;
                    }
                    this.a.c.m = true;
                    this.a.c.J();
                }
            }

            @Override // com.baidu.tieba.jn1.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    m02.i("OpenData", "bindPhoneNumber check onFail. needAuth = " + this.a.a);
                    c cVar = this.a;
                    if (cVar.a) {
                        cVar.c.K(cVar.b);
                    } else {
                        cVar.c.A();
                    }
                }
            }
        }

        public c(y83 y83Var, boolean z, m83 m83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y83Var, Boolean.valueOf(z), m83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = y83Var;
            this.a = z;
            this.b = m83Var;
        }

        @Override // com.baidu.tieba.jn1.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m02.i("OpenData", "bindPhoneNumber onFinish. needAuth = " + this.a);
                tm2.h0().g(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends ai3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y83 b;

        public a(y83 y83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y83Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.H();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y83 a;

        public b(y83 y83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y83Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(p83 p83Var) {
            Object obj;
            JSONObject jSONObject;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p83Var) == null) {
                if (p83Var != null && p83Var.c() && (obj = p83Var.a) != null) {
                    m02.b("OpenData", "opendata=", obj);
                    this.a.j.b(((JSONObject) p83Var.a).optInt("errno", 10001));
                    this.a.j.f(((JSONObject) p83Var.a).optString("errmsg", "internal error"));
                    if (0 != this.a.j.h()) {
                        k83.k("by errno", Boolean.TRUE);
                        this.a.j.b(10001L);
                        this.a.A();
                        this.a.y(10001);
                        return;
                    }
                    JSONObject optJSONObject = ((JSONObject) p83Var.a).optJSONObject("data");
                    if (optJSONObject == null) {
                        k83.k("by data parse", Boolean.TRUE);
                        this.a.j.b(10001L);
                        this.a.A();
                        this.a.y(10001);
                        return;
                    }
                    m83 g = m83.g(optJSONObject.optJSONObject("scope"));
                    if (g == null) {
                        k83.k("illegal scope", Boolean.TRUE);
                        this.a.j.b(10001L);
                        this.a.A();
                        this.a.y(10001);
                        return;
                    }
                    this.a.g = optJSONObject.optJSONObject("opendata");
                    if (!this.a.d && (i = g.j) < 0) {
                        if (i == -2) {
                            this.a.j.b(10006L);
                        } else {
                            this.a.j.b(10005L);
                            this.a.z(10005, g);
                        }
                        this.a.A();
                        return;
                    } else if (g.j > 0) {
                        if (!this.a.h || !TextUtils.equals(g.b, "mobile") || (jSONObject = this.a.g) == null || jSONObject.optInt("errno") != 1129) {
                            this.a.A();
                            return;
                        } else {
                            this.a.w(g, false);
                            return;
                        }
                    } else if (this.a.i.n0()) {
                        this.a.j.b(10005L);
                        this.a.A();
                        this.a.z(10005, g);
                        return;
                    } else if (!this.a.h && g.e()) {
                        if (!TextUtils.equals(g.b, "mobile") || SwanAppAllianceLoginHelper.d.f()) {
                            this.a.F();
                        } else {
                            this.a.G();
                        }
                        fa3.T(this.a.n, "phoneNumberLogin");
                        return;
                    } else if (TextUtils.equals(g.b, "mobile")) {
                        this.a.v(g);
                        return;
                    } else {
                        this.a.K(g);
                        return;
                    }
                }
                k83.k("bad MaOpenData response", Boolean.TRUE);
                this.a.j.b(10001L);
                this.a.A();
                this.a.y(10001);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements h83 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y83 a;

        public d(y83 y83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y83Var;
        }

        @Override // com.baidu.tieba.h83
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.a.j.b(10003L);
                }
                this.a.I(z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements yj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y83 a;

        public e(y83 y83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y83Var;
        }

        @Override // com.baidu.tieba.yj1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                k83.k("onResult :: " + i, Boolean.FALSE);
                if (i != -2) {
                    if (i != 0) {
                        k83.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                        this.a.j.b(10004L);
                        this.a.A();
                        return;
                    }
                    k83.k("Login Preparation ok, is already login", Boolean.FALSE);
                    this.a.h = true;
                    this.a.l = true;
                    this.a.J();
                    return;
                }
                k83.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                this.a.j.b(10004L);
                this.a.A();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements yj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y83 a;

        public f(y83 y83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y83Var;
        }

        @Override // com.baidu.tieba.yj1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                k83.k("onResult :: " + i, Boolean.FALSE);
                if (i != -2) {
                    if (i != 0) {
                        k83.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                        this.a.j.b(10004L);
                        this.a.A();
                        return;
                    }
                    k83.k("Login Preparation ok, is already login", Boolean.FALSE);
                    this.a.h = true;
                    this.a.J();
                    return;
                }
                k83.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                this.a.j.b(10004L);
                this.a.A();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ y83 b;

        public g(y83 y83Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y83Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y83Var;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(p83 p83Var) {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p83Var) == null) {
                if (this.a || this.b.k) {
                    if (p83Var != null && p83Var.c() && (obj = p83Var.a) != null && ((q83.b) obj).c != null) {
                        y83 y83Var = this.b;
                        y83Var.g = ((q83.b) obj).c;
                        y83Var.A();
                        return;
                    }
                    ff3 ff3Var = this.b.j;
                    ff3Var.b(10002L);
                    ff3Var.f("bad Accredit response");
                    this.b.A();
                    this.b.y(10002);
                    return;
                }
                this.b.A();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y83 a;

        public h(y83 y83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y83Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(p83 p83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p83Var) == null) {
                if (p83Var == null || !p83Var.c()) {
                    ff3 ff3Var = this.a.j;
                    ff3Var.b(10002L);
                    ff3Var.f("bad authorize response");
                    this.a.y(10002);
                }
                this.a.A();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y83 a;

        public i(y83 y83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y83Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            synchronized (this.a.e) {
                for (fi3 fi3Var : this.a.e) {
                    fi3Var.a(this.a);
                }
                this.a.e.clear();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948283989, "Lcom/baidu/tieba/y83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948283989, "Lcom/baidu/tieba/y83;");
                return;
            }
        }
        p = wj1.a;
        q = new HashMap();
    }

    public static void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, null) == null) {
            synchronized (q) {
                q.clear();
            }
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TaskState.FINISHED == this.f && 0 == this.j.a() && this.g != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TaskState.FINISHED == this.f && this.g != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.i.N().f(this.a, null, new f(this));
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            tm2.h0().j(new e(this));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.h = this.i.N().e(this.a);
            J();
        }
    }

    public y83(Activity activity, String str, String str2, boolean z, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, Boolean.valueOf(z), str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new HashSet();
        this.f = TaskState.INIT;
        this.h = false;
        ff3 ff3Var = new ff3();
        ff3Var.k(8L);
        ff3Var.f("OpenData");
        this.j = ff3Var;
        this.k = false;
        this.l = false;
        this.m = false;
        this.o = new a(this);
        this.a = activity;
        this.b = str;
        this.c = str2;
        this.d = z;
        this.n = str3;
    }

    public static void B(Activity activity, String str, String str2, boolean z, String str3, fi3 fi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{activity, str, str2, Boolean.valueOf(z), str3, fi3Var}) == null) {
            synchronized (q) {
                String C = C(str, z);
                y83 y83Var = (y83) q.get(C);
                if (y83Var == null) {
                    y83 y83Var2 = new y83(activity, str, str2, z, str3);
                    q.put(C, y83Var2);
                    y83Var2.L(fi3Var);
                } else {
                    m02.i("OpenData", "reuse session : " + y83Var.toString());
                    y83Var.u(fi3Var);
                }
            }
        }
    }

    public static String C(String str, boolean z) {
        InterceptResult invokeLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("/");
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            sb.append(str2);
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public final void w(m83 m83Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, m83Var, z) == null) {
            tm2.h0().a(new c(this, z, m83Var));
        }
    }

    public final void K(m83 m83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, m83Var) == null) {
            k83.u(this.a, this.i, m83Var, this.g, new d(this));
        }
    }

    public final y83 u(fi3 fi3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, fi3Var)) == null) {
            if (fi3Var == null) {
                return this;
            }
            synchronized (this.e) {
                this.e.add(fi3Var);
            }
            return this;
        }
        return (y83) invokeL.objValue;
    }

    public final void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            z(i2, m83.f(this.b, new JSONObject()));
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.o.a();
            synchronized (q) {
                q.remove(C(this.b, this.d));
            }
            this.f = TaskState.FINISHED;
            if (this.g == null && 0 == this.j.a()) {
                if (this.h) {
                    this.j.b(10001L);
                } else {
                    this.j.b(10004L);
                }
            }
            m02.i("OpenData", "onFinish" + toString());
            k83.l(new i(this));
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.b, Boolean.valueOf(D()), super.toString()));
            sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.j));
            if (this.g != null) {
                sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.g));
            }
            sb.append(String.format(Locale.getDefault(), "state=%s\n", this.f));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (TextUtils.isEmpty(this.c)) {
                q83 a2 = l33.K().x().a().b().a(this.a, z, this.b, this.c);
                a2.q(this.n);
                a2.o(new g(this, z));
                a2.call();
                return;
            }
            r83 d2 = l33.K().x().a().b().d(this.a, true, z, new String[]{this.b}, this.c, true);
            d2.q(this.n);
            d2.o(new h(this));
            d2.call();
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            fa3.T(this.n, "requestOpenData");
            w83 c2 = l33.K().x().a().b().c(this.a, this.b, this.c, this.d, this.h);
            c2.q(this.n);
            c2.o(new b(this));
            c2.call();
        }
    }

    public final void L(fi3 fi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fi3Var) == null) {
            m02.i("OpenData", "start session : " + this.b);
            this.f = TaskState.CALLING;
            this.k = TextUtils.equals(this.b, "snsapi_userinfo");
            u(fi3Var);
            m33 M = m33.M();
            this.i = M;
            if (M == null) {
                k83.k("SwanApp is null", Boolean.TRUE);
                this.j.b(10001L);
                A();
                y(10001);
                return;
            }
            M.e0().f.d(this.o);
        }
    }

    public final void v(m83 m83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, m83Var) == null) {
            if (this.l) {
                I(true);
            } else if (this.m) {
                K(m83Var);
            } else {
                JSONObject jSONObject = this.g;
                if (jSONObject != null && jSONObject.optInt("errno") == 1129) {
                    w(m83Var, true);
                } else {
                    K(m83Var);
                }
            }
        }
    }

    public final void z(int i2, m83 m83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, m83Var) == null) {
            m33 b0 = m33.b0();
            if (b0 == null) {
                if (p) {
                    Log.e("OpenData", "failedStatistic-swanApp is null");
                    return;
                }
                return;
            }
            na3 na3Var = new na3();
            na3Var.o(i2);
            na3Var.r(b0.Y());
            na3Var.q(fa3.n(b0.k()));
            na3Var.m(b0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", b0.getAppId());
                jSONObject.put("msg", k83.f(i2));
                if (m83Var != null) {
                    jSONObject.put("scope", m83Var.b);
                    jSONObject.put("scopeData", m83Var.a);
                }
            } catch (JSONException e2) {
                if (p) {
                    e2.printStackTrace();
                }
            }
            na3Var.e(jSONObject);
            fa3.R(na3Var);
        }
    }
}
