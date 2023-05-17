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
import com.baidu.tieba.cc2;
import com.baidu.tieba.h7b;
import com.baidu.tieba.wi2;
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
/* loaded from: classes8.dex */
public final class yi2 extends kc2 implements dm4, am4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public n7b<? super ii4> d;
    public n7b<ii4> e;
    public om4 f;
    public final mk4 g;
    public xg4<ii4> h;
    public final Map<String, xi2> i;
    public final Map<String, em4> j;
    public final wi2 k;
    public final qk4<JSONArray> l;

    @Override // com.baidu.tieba.dm4
    public bh4 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (bh4) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements qk4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yi2 a;

        public a(yi2 yi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yi2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qk4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray != null && !this.a.i.isEmpty()) {
                for (xi2 xi2Var : this.a.i.values()) {
                    if (xi2Var != null && xi2Var.r(this.a)) {
                        xi2Var.a(jSONArray);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements zn3<xi2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yi2 a;

        public b(yi2 yi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yi2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(xi2 xi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xi2Var) == null) {
                if (yi2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + xi2Var);
                }
                if (xi2Var != null) {
                    this.a.k.c(xi2Var.k(), xi2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements zn3<xi2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yi2 a;

        public c(yi2 yi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yi2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(xi2 xi2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xi2Var) == null) && xi2Var != null) {
                this.a.k.d(xi2Var.k(), xi2Var.m());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements cc2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ii4 a;
        public final /* synthetic */ yi2 b;

        public d(yi2 yi2Var, ii4 ii4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yi2Var, ii4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yi2Var;
            this.a = ii4Var;
        }

        @Override // com.baidu.tieba.cc2.c
        public void b(PMSDownloadType pMSDownloadType, zk3 zk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zk3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, zk3Var));
                }
            }
        }

        @Override // com.baidu.tieba.cc2.c
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

    /* loaded from: classes8.dex */
    public class e implements h7b.a<ii4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yi2 a;

        public e(yi2 yi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yi2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h7b.a, com.baidu.tieba.v7b
        public void call(n7b<? super ii4> n7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, n7bVar) != null) {
                return;
            }
            this.a.d = n7bVar;
        }
    }

    /* loaded from: classes8.dex */
    public class f extends n7b<ii4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yi2 e;

        public f(yi2 yi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yi2Var;
        }

        public /* synthetic */ f(yi2 yi2Var, a aVar) {
            this(yi2Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i7b
        /* renamed from: g */
        public void onNext(ii4 ii4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, ii4Var) == null) && yi2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + ii4Var.toString());
            }
        }

        @Override // com.baidu.tieba.i7b
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (yi2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.i7b
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (yi2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends ug4<ii4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yi2 a;

        public g(yi2 yi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yi2Var;
        }

        public /* synthetic */ g(yi2 yi2Var, a aVar) {
            this(yi2Var);
        }

        @Override // com.baidu.tieba.zg4
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
        @Override // com.baidu.tieba.xg4
        /* renamed from: l */
        public String d(ii4 ii4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ii4Var)) == null) {
                String g = vi2.d.g(ii4Var);
                if (yi2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + ii4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: q */
        public void a(ii4 ii4Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ii4Var) == null) {
                super.a(ii4Var);
                em4 em4Var = (em4) this.a.j.get(ii4Var.g);
                yi2 yi2Var = this.a;
                if (em4Var == null) {
                    str = null;
                } else {
                    str = em4Var.a;
                }
                xi2 a0 = yi2Var.a0(str);
                if (a0 != null) {
                    a0.x(new wi2.b(ii4Var.b, ii4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: r */
        public void c(ii4 ii4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, ii4Var) == null) {
                super.c(ii4Var);
                if (yi2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + ii4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: s */
        public void f(ii4 ii4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, ii4Var) == null) {
                super.f(ii4Var);
                if (yi2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + ii4Var.g);
                }
                this.a.f0(ii4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: o */
        public void e(ii4 ii4Var, ai4 ai4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ii4Var, ai4Var) == null) {
                super.e(ii4Var, ai4Var);
                if (yi2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + ii4Var.g + " err=" + ai4Var);
                }
                this.a.f.l(ii4Var);
                zk3 zk3Var = new zk3();
                zk3Var.k(13L);
                zk3Var.i(ai4Var.a);
                zk3Var.d("so包下载失败");
                zk3Var.f(ai4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(ii4Var, zk3Var));
                }
                cc2.c().a(ii4Var, yi2.o, zk3Var);
                kp4.k(ii4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: p */
        public void i(ii4 ii4Var) {
            em4 em4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ii4Var) == null) {
                super.i(ii4Var);
                if (yi2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + ii4Var);
                }
                String str2 = ii4Var.p;
                if (TextUtils.isEmpty(str2) && (em4Var = (em4) this.a.j.get(ii4Var.g)) != null) {
                    str2 = em4Var.a;
                }
                xi2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = tm3.a(new File(ii4Var.a), ii4Var.m);
                    if (yi2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + ii4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (yi2.m && !an3.G() && f53.j() == 1) ? false : false;
                    if (a || z) {
                        dh4.i().m(ii4Var);
                        if (yi2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(ii4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(ii4Var);
                    this.a.d.onCompleted();
                }
                cc2.c().b(ii4Var, yi2.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948331047, "Lcom/baidu/tieba/yi2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948331047, "Lcom/baidu/tieba/yi2;");
                return;
            }
        }
        m = qp1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    @Override // com.baidu.tieba.bh4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.bh4
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

    public final n7b<ii4> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (n7b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dm4
    public qk4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (qk4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dm4
    @Nullable
    public mk4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (mk4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bh4
    public xg4<ii4> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (xg4) invokeV.objValue;
    }

    public yi2(mk4 mk4Var, wi2 wi2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mk4Var, wi2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + wi2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = mk4Var;
        this.k = wi2Var;
        if (wi2Var != null) {
            Iterator<String> it = wi2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                ti2 a2 = ui2.a(next);
                if (a2 == null) {
                    wi2Var.c(next, false);
                } else if (a2.f()) {
                    wi2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    xi2 t = vi2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(em4.b(e2));
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

    public final xi2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            xi2 xi2Var = this.i.get(str);
            if (xi2Var == null || !xi2Var.r(this)) {
                return null;
            }
            return xi2Var;
        }
        return (xi2) invokeL.objValue;
    }

    public final void f0(ii4 ii4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ii4Var) == null) {
            cc2.c().d(ii4Var, new d(this, ii4Var));
        }
    }

    @Override // com.baidu.tieba.bh4
    public am4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.equals("so", str)) {
                return this;
            }
            return super.w(str);
        }
        return (am4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bh4
    public void C(ai4 ai4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ai4Var) == null) {
            super.C(ai4Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + ai4Var.toString());
            }
            e0(new Exception("failed by fetch error = " + ai4Var));
        }
    }

    @Override // com.baidu.tieba.bh4
    public void G(om4 om4Var) {
        int n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, om4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                if (om4Var == null) {
                    n2 = 0;
                } else {
                    n2 = om4Var.n();
                }
                sb.append(n2);
                Log.i(str, sb.toString());
            }
            super.G(om4Var);
            if (om4Var == null) {
                return;
            }
            this.f = om4Var;
            if (!om4Var.k()) {
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
            wi2 wi2Var = this.k;
            if (wi2Var != null) {
                wi2Var.b(exc);
            }
        }
    }

    @Override // com.baidu.tieba.am4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((ii4) nm4.j(jSONObject, new ii4()));
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
            for (xi2 xi2Var : this.i.values()) {
                if (!xi2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + xi2Var);
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
            for (xi2 xi2Var : this.i.values()) {
                if (xi2Var != null && xi2Var.r(this) && !xi2Var.n() && !xi2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + xi2Var);
                    }
                    xi2Var.q();
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
                arrayList.add(h7b.a(new e(this)));
            }
            if (!arrayList.isEmpty()) {
                h7b.k(arrayList).w(b0());
            }
        }
    }

    public final void g0(ii4 ii4Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ii4Var) == null) {
            if (m) {
                Log.i(this.c, "SoNodeHandler updateBestSo start so=" + ii4Var);
            }
            if (ii4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            em4 em4Var = this.j.get(ii4Var.g);
            if (em4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by illegal bundleId=" + ii4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(ii4Var.p)) {
                ii4Var.p = em4Var.a;
            }
            xi2 a0 = a0(ii4Var.p);
            if (a0 == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by no updating lib=" + ii4Var.p);
                    return;
                }
                return;
            }
            if (ii4Var.q == null) {
                ii4Var.q = em4Var.c;
            }
            if (!AbiType.currentAbi().compat(ii4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            ii4 l = a0.l();
            ii4 j2 = a0.j();
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
            long j4 = ii4Var.i;
            if (j4 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(ii4Var.i)));
                }
            } else if (j4 > max) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by update bestVer=" + ii4Var.i);
                }
                a0.w(this, ii4Var);
            } else {
                if (j2 == null || !j2.q.compat(ii4Var.q)) {
                    if (m) {
                        Log.i(this.c, "SoNodeHandler updateBestSo end by update abi update=" + ii4Var.q);
                    }
                    a0.w(this, ii4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.am4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            yl4 yl4Var = new yl4();
            om4 om4Var = new om4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !an3.G() && f53.j() == 1) ? false : false) {
                String i = f53.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        ii4 ii4Var = (ii4) nm4.j(new JSONObject(i), new ii4());
                        ii4Var.g = "so_zeus_armeabi";
                        g0(ii4Var);
                        y83.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f140d)).G();
                    } catch (JSONException e2) {
                        y83.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f140c)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (xi2 xi2Var : this.i.values()) {
                if (xi2Var.r(this)) {
                    g0(xi2Var.l());
                    ii4 j = xi2Var.j();
                    if (xi2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        zl4.b(j, om4Var);
                        if (yl4Var.d == null) {
                            yl4Var.d = new ArrayList();
                        }
                        yl4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        xi2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + om4Var.n());
            }
            if (om4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(om4Var);
            ri4.e(yl4Var, this);
        }
    }
}
