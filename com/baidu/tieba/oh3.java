package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.tieba.gh3;
import com.baidu.tieba.hh3;
import com.baidu.tieba.zv1;
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
/* loaded from: classes7.dex */
public final class oh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean p;
    public static final Map<String, oh3> q;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final String b;
    public final String c;
    public boolean d;
    public final Set<vq3<oh3>> e;
    public TaskState f;
    public JSONObject g;
    public boolean h;
    public cc3 i;
    public final vn3 j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public final qq3 o;

    /* loaded from: classes7.dex */
    public class c implements zv1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ch3 b;
        public final /* synthetic */ oh3 c;

        /* loaded from: classes7.dex */
        public class a implements zv1.c {
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

            @Override // com.baidu.tieba.zv1.c
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    c92.i("OpenData", "bindPhoneNumber check onSuccess isBind =" + z + ". needAuth = " + this.a.a);
                    if (!z) {
                        this.a.c.j.b(10006L);
                        this.a.c.A();
                        return;
                    }
                    this.a.c.m = true;
                    this.a.c.J();
                }
            }

            @Override // com.baidu.tieba.zv1.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c92.i("OpenData", "bindPhoneNumber check onFail. needAuth = " + this.a.a);
                    c cVar = this.a;
                    if (cVar.a) {
                        cVar.c.K(cVar.b);
                    } else {
                        cVar.c.A();
                    }
                }
            }
        }

        public c(oh3 oh3Var, boolean z, ch3 ch3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh3Var, Boolean.valueOf(z), ch3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oh3Var;
            this.a = z;
            this.b = ch3Var;
        }

        @Override // com.baidu.tieba.zv1.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c92.i("OpenData", "bindPhoneNumber onFinish. needAuth = " + this.a);
                jv2.h0().g(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a extends qq3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oh3 b;

        public a(oh3 oh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oh3Var;
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

    /* loaded from: classes7.dex */
    public class b implements vq3<fh3<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oh3 a;

        public b(oh3 oh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oh3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(fh3<JSONObject> fh3Var) {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fh3Var) == null) {
                if (fh3Var != null && fh3Var.c() && (jSONObject = fh3Var.a) != null) {
                    c92.b("OpenData", "opendata=", jSONObject);
                    this.a.j.b(fh3Var.a.optInt("errno", 10001));
                    this.a.j.f(fh3Var.a.optString("errmsg", "internal error"));
                    if (0 != this.a.j.h()) {
                        ah3.k("by errno", Boolean.TRUE);
                        this.a.j.b(10001L);
                        this.a.A();
                        this.a.y(10001);
                        return;
                    }
                    JSONObject optJSONObject = fh3Var.a.optJSONObject("data");
                    if (optJSONObject == null) {
                        ah3.k("by data parse", Boolean.TRUE);
                        this.a.j.b(10001L);
                        this.a.A();
                        this.a.y(10001);
                        return;
                    }
                    ch3 g = ch3.g(optJSONObject.optJSONObject("scope"));
                    if (g == null) {
                        ah3.k("illegal scope", Boolean.TRUE);
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
                        if (!this.a.h || !TextUtils.equals(g.b, "mobile") || (jSONObject2 = this.a.g) == null || jSONObject2.optInt("errno") != 1129) {
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
                        vi3.T(this.a.n, "phoneNumberLogin");
                        return;
                    } else if (TextUtils.equals(g.b, "mobile")) {
                        this.a.v(g);
                        return;
                    } else {
                        this.a.K(g);
                        return;
                    }
                }
                ah3.k("bad MaOpenData response", Boolean.TRUE);
                this.a.j.b(10001L);
                this.a.A();
                this.a.y(10001);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements xg3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oh3 a;

        public d(oh3 oh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oh3Var;
        }

        @Override // com.baidu.tieba.xg3
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

    /* loaded from: classes7.dex */
    public class e implements os1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oh3 a;

        public e(oh3 oh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oh3Var;
        }

        @Override // com.baidu.tieba.os1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                ah3.k("onResult :: " + i, Boolean.FALSE);
                if (i != -2) {
                    if (i != 0) {
                        ah3.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                        this.a.j.b(10004L);
                        this.a.A();
                        return;
                    }
                    ah3.k("Login Preparation ok, is already login", Boolean.FALSE);
                    this.a.h = true;
                    this.a.l = true;
                    this.a.J();
                    return;
                }
                ah3.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                this.a.j.b(10004L);
                this.a.A();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements os1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oh3 a;

        public f(oh3 oh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oh3Var;
        }

        @Override // com.baidu.tieba.os1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                ah3.k("onResult :: " + i, Boolean.FALSE);
                if (i != -2) {
                    if (i != 0) {
                        ah3.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                        this.a.j.b(10004L);
                        this.a.A();
                        return;
                    }
                    ah3.k("Login Preparation ok, is already login", Boolean.FALSE);
                    this.a.h = true;
                    this.a.J();
                    return;
                }
                ah3.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                this.a.j.b(10004L);
                this.a.A();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements vq3<fh3<gh3.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ oh3 b;

        public g(oh3 oh3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oh3Var;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(fh3<gh3.b> fh3Var) {
            gh3.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fh3Var) == null) {
                if (this.a || this.b.k) {
                    if (fh3Var != null && fh3Var.c() && (bVar = fh3Var.a) != null && bVar.c != null) {
                        oh3 oh3Var = this.b;
                        oh3Var.g = bVar.c;
                        oh3Var.A();
                        return;
                    }
                    vn3 vn3Var = this.b.j;
                    vn3Var.b(10002L);
                    vn3Var.f("bad Accredit response");
                    this.b.A();
                    this.b.y(10002);
                    return;
                }
                this.b.A();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements vq3<fh3<hh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oh3 a;

        public h(oh3 oh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oh3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(fh3<hh3.e> fh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fh3Var) == null) {
                if (fh3Var == null || !fh3Var.c()) {
                    vn3 vn3Var = this.a.j;
                    vn3Var.b(10002L);
                    vn3Var.f("bad authorize response");
                    this.a.y(10002);
                }
                this.a.A();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oh3 a;

        public i(oh3 oh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oh3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            synchronized (this.a.e) {
                for (vq3 vq3Var : this.a.e) {
                    vq3Var.a(this.a);
                }
                this.a.e.clear();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948032207, "Lcom/baidu/tieba/oh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948032207, "Lcom/baidu/tieba/oh3;");
                return;
            }
        }
        p = ms1.a;
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
            jv2.h0().j(new e(this));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.h = this.i.N().e(this.a);
            J();
        }
    }

    public oh3(Activity activity, String str, String str2, boolean z, String str3) {
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
        vn3 vn3Var = new vn3();
        vn3Var.k(8L);
        vn3Var.f("OpenData");
        this.j = vn3Var;
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

    public static void B(Activity activity, String str, String str2, boolean z, String str3, vq3<oh3> vq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{activity, str, str2, Boolean.valueOf(z), str3, vq3Var}) == null) {
            synchronized (q) {
                String C = C(str, z);
                oh3 oh3Var = q.get(C);
                if (oh3Var == null) {
                    oh3 oh3Var2 = new oh3(activity, str, str2, z, str3);
                    q.put(C, oh3Var2);
                    oh3Var2.L(vq3Var);
                } else {
                    c92.i("OpenData", "reuse session : " + oh3Var.toString());
                    oh3Var.u(vq3Var);
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

    public final void w(ch3 ch3Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, ch3Var, z) == null) {
            jv2.h0().a(new c(this, z, ch3Var));
        }
    }

    public final void K(@NonNull ch3 ch3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ch3Var) == null) {
            ah3.u(this.a, this.i, ch3Var, this.g, new d(this));
        }
    }

    public final oh3 u(vq3<oh3> vq3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, vq3Var)) == null) {
            if (vq3Var == null) {
                return this;
            }
            synchronized (this.e) {
                this.e.add(vq3Var);
            }
            return this;
        }
        return (oh3) invokeL.objValue;
    }

    public final void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            z(i2, ch3.f(this.b, new JSONObject()));
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
            c92.i("OpenData", "onFinish" + toString());
            ah3.l(new i(this));
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
                gh3 a2 = bc3.K().x().a().b().a(this.a, z, this.b, this.c);
                a2.q(this.n);
                a2.o(new g(this, z));
                a2.call();
                return;
            }
            hh3 d2 = bc3.K().x().a().b().d(this.a, true, z, new String[]{this.b}, this.c, true);
            d2.q(this.n);
            d2.o(new h(this));
            d2.call();
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            vi3.T(this.n, "requestOpenData");
            mh3 c2 = bc3.K().x().a().b().c(this.a, this.b, this.c, this.d, this.h);
            c2.q(this.n);
            c2.o(new b(this));
            c2.call();
        }
    }

    public final void L(vq3<oh3> vq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, vq3Var) == null) {
            c92.i("OpenData", "start session : " + this.b);
            this.f = TaskState.CALLING;
            this.k = TextUtils.equals(this.b, "snsapi_userinfo");
            u(vq3Var);
            cc3 M = cc3.M();
            this.i = M;
            if (M == null) {
                ah3.k("SwanApp is null", Boolean.TRUE);
                this.j.b(10001L);
                A();
                y(10001);
                return;
            }
            M.e0().f.d(this.o);
        }
    }

    public final void v(ch3 ch3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ch3Var) == null) {
            if (this.l) {
                I(true);
            } else if (this.m) {
                K(ch3Var);
            } else {
                JSONObject jSONObject = this.g;
                if (jSONObject != null && jSONObject.optInt("errno") == 1129) {
                    w(ch3Var, true);
                } else {
                    K(ch3Var);
                }
            }
        }
    }

    public final void z(int i2, ch3 ch3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, ch3Var) == null) {
            cc3 b0 = cc3.b0();
            if (b0 == null) {
                if (p) {
                    Log.e("OpenData", "failedStatistic-swanApp is null");
                    return;
                }
                return;
            }
            dj3 dj3Var = new dj3();
            dj3Var.o(i2);
            dj3Var.r(b0.Y());
            dj3Var.q(vi3.n(b0.k()));
            dj3Var.m(b0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", b0.getAppId());
                jSONObject.put("msg", ah3.f(i2));
                if (ch3Var != null) {
                    jSONObject.put("scope", ch3Var.b);
                    jSONObject.put("scopeData", ch3Var.a);
                }
            } catch (JSONException e2) {
                if (p) {
                    e2.printStackTrace();
                }
            }
            dj3Var.e(jSONObject);
            vi3.R(dj3Var);
        }
    }
}
