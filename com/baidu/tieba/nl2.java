package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.tieba.ll2;
import com.baidu.tieba.re2;
import com.baidu.tieba.u1c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class nl2 extends ze2 implements so4, po4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public a2c<? super xk4> d;
    public a2c<xk4> e;
    public dp4 f;
    public final bn4 g;
    public mj4<xk4> h;
    public final Map<String, ml2> i;
    public final Map<String, to4> j;
    public final ll2 k;
    public final fn4<JSONArray> l;

    @Override // com.baidu.tieba.so4
    public qj4 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (qj4) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements fn4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nl2 a;

        public a(nl2 nl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nl2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fn4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray != null && !this.a.i.isEmpty()) {
                for (ml2 ml2Var : this.a.i.values()) {
                    if (ml2Var != null && ml2Var.r(this.a)) {
                        ml2Var.a(jSONArray);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements oq3<ml2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nl2 a;

        public b(nl2 nl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nl2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(ml2 ml2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ml2Var) == null) {
                if (nl2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + ml2Var);
                }
                if (ml2Var != null) {
                    this.a.k.c(ml2Var.k(), ml2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements oq3<ml2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nl2 a;

        public c(nl2 nl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nl2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(ml2 ml2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ml2Var) == null) && ml2Var != null) {
                this.a.k.d(ml2Var.k(), ml2Var.m());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements re2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk4 a;
        public final /* synthetic */ nl2 b;

        public d(nl2 nl2Var, xk4 xk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl2Var, xk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nl2Var;
            this.a = xk4Var;
        }

        @Override // com.baidu.tieba.re2.c
        public void b(PMSDownloadType pMSDownloadType, on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, on3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, on3Var));
                }
            }
        }

        @Override // com.baidu.tieba.re2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.f.m(this.a);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements u1c.a<xk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nl2 a;

        public e(nl2 nl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nl2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
        public void call(a2c<? super xk4> a2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, a2cVar) != null) {
                return;
            }
            this.a.d = a2cVar;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends a2c<xk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nl2 e;

        public f(nl2 nl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = nl2Var;
        }

        public /* synthetic */ f(nl2 nl2Var, a aVar) {
            this(nl2Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v1c
        /* renamed from: g */
        public void onNext(xk4 xk4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, xk4Var) == null) && nl2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + xk4Var.toString());
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (nl2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (nl2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends jj4<xk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nl2 a;

        public g(nl2 nl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nl2Var;
        }

        public /* synthetic */ g(nl2 nl2Var, a aVar) {
            this(nl2Var);
        }

        @Override // com.baidu.tieba.oj4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4
        /* renamed from: l */
        public String d(xk4 xk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xk4Var)) == null) {
                String g = kl2.d.g(xk4Var);
                if (nl2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + xk4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: q */
        public void a(xk4 xk4Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, xk4Var) == null) {
                super.a(xk4Var);
                to4 to4Var = (to4) this.a.j.get(xk4Var.g);
                nl2 nl2Var = this.a;
                if (to4Var == null) {
                    str = null;
                } else {
                    str = to4Var.a;
                }
                ml2 a0 = nl2Var.a0(str);
                if (a0 != null) {
                    a0.x(new ll2.b(xk4Var.b, xk4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: r */
        public void c(xk4 xk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, xk4Var) == null) {
                super.c(xk4Var);
                if (nl2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + xk4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: s */
        public void f(xk4 xk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, xk4Var) == null) {
                super.f(xk4Var);
                if (nl2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + xk4Var.g);
                }
                this.a.f0(xk4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: o */
        public void e(xk4 xk4Var, pk4 pk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xk4Var, pk4Var) == null) {
                super.e(xk4Var, pk4Var);
                if (nl2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + xk4Var.g + " err=" + pk4Var);
                }
                this.a.f.l(xk4Var);
                on3 on3Var = new on3();
                on3Var.k(13L);
                on3Var.i(pk4Var.a);
                on3Var.d("so包下载失败");
                on3Var.f(pk4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(xk4Var, on3Var));
                }
                re2.c().a(xk4Var, nl2.o, on3Var);
                zr4.k(xk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: p */
        public void i(xk4 xk4Var) {
            to4 to4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, xk4Var) == null) {
                super.i(xk4Var);
                if (nl2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + xk4Var);
                }
                String str2 = xk4Var.p;
                if (TextUtils.isEmpty(str2) && (to4Var = (to4) this.a.j.get(xk4Var.g)) != null) {
                    str2 = to4Var.a;
                }
                ml2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = ip3.a(new File(xk4Var.a), xk4Var.m);
                    if (nl2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + xk4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (nl2.m && !pp3.G() && u73.j() == 1) ? false : false;
                    if (a || z) {
                        sj4.i().m(xk4Var);
                        if (nl2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(xk4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(xk4Var);
                    this.a.d.onCompleted();
                }
                re2.c().b(xk4Var, nl2.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948006229, "Lcom/baidu/tieba/nl2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948006229, "Lcom/baidu/tieba/nl2;");
                return;
            }
        }
        m = fs1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    @Override // com.baidu.tieba.qj4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.qj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            if (m) {
                Log.e(this.c, "onNoPackage:");
            }
            e0(null);
        }
    }

    public final a2c<xk4> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (a2c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.so4
    public fn4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (fn4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.so4
    @Nullable
    public bn4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (bn4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj4
    public mj4<xk4> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (mj4) invokeV.objValue;
    }

    public nl2(bn4 bn4Var, ll2 ll2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bn4Var, ll2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = "SwanSoUpdater";
        this.i = new HashMap();
        this.j = new HashMap();
        this.l = new a(this);
        StringBuilder sb = new StringBuilder();
        sb.append(this.c);
        int i3 = n;
        n = i3 + 1;
        sb.append(i3);
        String sb2 = sb.toString();
        this.c = sb2;
        if (m) {
            Log.i(sb2, "SwanSoUpdater: config=" + ll2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = bn4Var;
        this.k = ll2Var;
        if (ll2Var != null) {
            Iterator<String> it = ll2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                il2 a2 = jl2.a(next);
                if (a2 == null) {
                    ll2Var.c(next, false);
                } else if (a2.f()) {
                    ll2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    ml2 t = kl2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(to4.b(e2));
                }
            }
        }
        if (m) {
            String str = this.c;
            Log.i(str, "SoNodeHandler() start mUpdatings=" + this.i.size());
        }
        if (this.i.isEmpty()) {
            e0(null);
        }
    }

    public final ml2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            ml2 ml2Var = this.i.get(str);
            if (ml2Var == null || !ml2Var.r(this)) {
                return null;
            }
            return ml2Var;
        }
        return (ml2) invokeL.objValue;
    }

    public final void f0(xk4 xk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, xk4Var) == null) {
            re2.c().d(xk4Var, new d(this, xk4Var));
        }
    }

    @Override // com.baidu.tieba.qj4
    public po4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.equals("so", str)) {
                return this;
            }
            return super.w(str);
        }
        return (po4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qj4
    public void C(pk4 pk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pk4Var) == null) {
            super.C(pk4Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + pk4Var.toString());
            }
            e0(new Exception("failed by fetch error = " + pk4Var));
        }
    }

    @Override // com.baidu.tieba.qj4
    public void G(dp4 dp4Var) {
        int n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dp4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                if (dp4Var == null) {
                    n2 = 0;
                } else {
                    n2 = dp4Var.n();
                }
                sb.append(n2);
                Log.i(str, sb.toString());
            }
            super.G(dp4Var);
            if (dp4Var == null) {
                return;
            }
            this.f = dp4Var;
            if (!dp4Var.k()) {
                c0();
            }
        }
    }

    public final void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
            }
            ll2 ll2Var = this.k;
            if (ll2Var != null) {
                ll2Var.b(exc);
            }
        }
    }

    @Override // com.baidu.tieba.po4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((xk4) cp4.j(jSONObject, new xk4()));
            }
        }
    }

    public final void Z(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "finishWithUpdatingCheck: updatings=" + this.i.size() + " e=" + exc);
            }
            for (ml2 ml2Var : this.i.values()) {
                if (!ml2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + ml2Var);
                        return;
                    }
                    return;
                }
            }
            d0(exc);
        }
    }

    public final void e0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "notifyPmsFinish: updatings=" + this.i.size() + " e=" + exc);
            }
            for (ml2 ml2Var : this.i.values()) {
                if (ml2Var != null && ml2Var.r(this) && !ml2Var.n() && !ml2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + ml2Var);
                    }
                    ml2Var.q();
                }
            }
            Z(exc);
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f.g()) {
                arrayList.add(u1c.d(new e(this)));
            }
            if (!arrayList.isEmpty()) {
                u1c.q(arrayList).F(b0());
            }
        }
    }

    public final void g0(xk4 xk4Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, xk4Var) == null) {
            if (m) {
                Log.i(this.c, "SoNodeHandler updateBestSo start so=" + xk4Var);
            }
            if (xk4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            to4 to4Var = this.j.get(xk4Var.g);
            if (to4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by illegal bundleId=" + xk4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(xk4Var.p)) {
                xk4Var.p = to4Var.a;
            }
            ml2 a0 = a0(xk4Var.p);
            if (a0 == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by no updating lib=" + xk4Var.p);
                    return;
                }
                return;
            }
            if (xk4Var.q == null) {
                xk4Var.q = to4Var.c;
            }
            if (!AbiType.currentAbi().compat(xk4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            xk4 l = a0.l();
            xk4 j2 = a0.j();
            long j3 = 0;
            if (l == null) {
                j = 0;
            } else {
                j = l.i;
            }
            if (j2 != null) {
                j3 = j2.i;
            }
            long max = Math.max(j3, j);
            long j4 = xk4Var.i;
            if (j4 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(xk4Var.i)));
                }
            } else if (j4 > max) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by update bestVer=" + xk4Var.i);
                }
                a0.w(this, xk4Var);
            } else {
                if (j2 == null || !j2.q.compat(xk4Var.q)) {
                    if (m) {
                        Log.i(this.c, "SoNodeHandler updateBestSo end by update abi update=" + xk4Var.q);
                    }
                    a0.w(this, xk4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.po4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            no4 no4Var = new no4();
            dp4 dp4Var = new dp4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !pp3.G() && u73.j() == 1) ? false : false) {
                String i = u73.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        xk4 xk4Var = (xk4) cp4.j(new JSONObject(i), new xk4());
                        xk4Var.g = "so_zeus_armeabi";
                        g0(xk4Var);
                        nb3.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1496)).G();
                    } catch (JSONException e2) {
                        nb3.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1495)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (ml2 ml2Var : this.i.values()) {
                if (ml2Var.r(this)) {
                    g0(ml2Var.l());
                    xk4 j = ml2Var.j();
                    if (ml2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        oo4.b(j, dp4Var);
                        if (no4Var.d == null) {
                            no4Var.d = new ArrayList();
                        }
                        no4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        ml2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + dp4Var.n());
            }
            if (dp4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(dp4Var);
            gl4.e(no4Var, this);
        }
    }
}
