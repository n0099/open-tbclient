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
import com.baidu.tieba.ce2;
import com.baidu.tieba.kcc;
import com.baidu.tieba.wk2;
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
public final class yk2 extends ke2 implements do4, ao4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public qcc<? super ik4> d;
    public qcc<ik4> e;
    public oo4 f;
    public final mm4 g;
    public xi4<ik4> h;
    public final Map<String, xk2> i;
    public final Map<String, eo4> j;
    public final wk2 k;
    public final qm4<JSONArray> l;

    @Override // com.baidu.tieba.do4
    public bj4 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (bj4) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements qm4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yk2 a;

        public a(yk2 yk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yk2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray != null && !this.a.i.isEmpty()) {
                for (xk2 xk2Var : this.a.i.values()) {
                    if (xk2Var != null && xk2Var.r(this.a)) {
                        xk2Var.a(jSONArray);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements zp3<xk2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yk2 a;

        public b(yk2 yk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yk2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(xk2 xk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xk2Var) == null) {
                if (yk2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + xk2Var);
                }
                if (xk2Var != null) {
                    this.a.k.c(xk2Var.k(), xk2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements zp3<xk2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yk2 a;

        public c(yk2 yk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yk2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(xk2 xk2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xk2Var) == null) && xk2Var != null) {
                this.a.k.d(xk2Var.k(), xk2Var.m());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ce2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik4 a;
        public final /* synthetic */ yk2 b;

        public d(yk2 yk2Var, ik4 ik4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk2Var, ik4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yk2Var;
            this.a = ik4Var;
        }

        @Override // com.baidu.tieba.ce2.c
        public void b(PMSDownloadType pMSDownloadType, zm3 zm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zm3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, zm3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ce2.c
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
    public class e implements kcc.a<ik4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yk2 a;

        public e(yk2 yk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yk2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
        public void call(qcc<? super ik4> qccVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, qccVar) != null) {
                return;
            }
            this.a.d = qccVar;
        }
    }

    /* loaded from: classes8.dex */
    public class f extends qcc<ik4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yk2 e;

        public f(yk2 yk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yk2Var;
        }

        public /* synthetic */ f(yk2 yk2Var, a aVar) {
            this(yk2Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lcc
        /* renamed from: g */
        public void onNext(ik4 ik4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, ik4Var) == null) && yk2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + ik4Var.toString());
            }
        }

        @Override // com.baidu.tieba.lcc
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (yk2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.lcc
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (yk2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends ui4<ik4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yk2 a;

        public g(yk2 yk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yk2Var;
        }

        public /* synthetic */ g(yk2 yk2Var, a aVar) {
            this(yk2Var);
        }

        @Override // com.baidu.tieba.zi4
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
        @Override // com.baidu.tieba.xi4
        /* renamed from: l */
        public String d(ik4 ik4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ik4Var)) == null) {
                String g = vk2.d.g(ik4Var);
                if (yk2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + ik4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: q */
        public void a(ik4 ik4Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ik4Var) == null) {
                super.a(ik4Var);
                eo4 eo4Var = (eo4) this.a.j.get(ik4Var.g);
                yk2 yk2Var = this.a;
                if (eo4Var == null) {
                    str = null;
                } else {
                    str = eo4Var.a;
                }
                xk2 a0 = yk2Var.a0(str);
                if (a0 != null) {
                    a0.x(new wk2.b(ik4Var.b, ik4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: r */
        public void c(ik4 ik4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, ik4Var) == null) {
                super.c(ik4Var);
                if (yk2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + ik4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: s */
        public void f(ik4 ik4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, ik4Var) == null) {
                super.f(ik4Var);
                if (yk2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + ik4Var.g);
                }
                this.a.f0(ik4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: o */
        public void e(ik4 ik4Var, ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ik4Var, ak4Var) == null) {
                super.e(ik4Var, ak4Var);
                if (yk2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + ik4Var.g + " err=" + ak4Var);
                }
                this.a.f.l(ik4Var);
                zm3 zm3Var = new zm3();
                zm3Var.k(13L);
                zm3Var.i(ak4Var.a);
                zm3Var.d("so包下载失败");
                zm3Var.f(ak4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(ik4Var, zm3Var));
                }
                ce2.c().a(ik4Var, yk2.o, zm3Var);
                kr4.k(ik4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: p */
        public void i(ik4 ik4Var) {
            eo4 eo4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ik4Var) == null) {
                super.i(ik4Var);
                if (yk2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + ik4Var);
                }
                String str2 = ik4Var.p;
                if (TextUtils.isEmpty(str2) && (eo4Var = (eo4) this.a.j.get(ik4Var.g)) != null) {
                    str2 = eo4Var.a;
                }
                xk2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = to3.a(new File(ik4Var.a), ik4Var.m);
                    if (yk2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + ik4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (yk2.m && !ap3.G() && f73.j() == 1) ? false : false;
                    if (a || z) {
                        dj4.i().m(ik4Var);
                        if (yk2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(ik4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(ik4Var);
                    this.a.d.onCompleted();
                }
                ce2.c().b(ik4Var, yk2.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948332969, "Lcom/baidu/tieba/yk2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948332969, "Lcom/baidu/tieba/yk2;");
                return;
            }
        }
        m = qr1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    @Override // com.baidu.tieba.bj4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.bj4
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

    public final qcc<ik4> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (qcc) invokeV.objValue;
    }

    @Override // com.baidu.tieba.do4
    public qm4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (qm4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.do4
    @Nullable
    public mm4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (mm4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bj4
    public xi4<ik4> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (xi4) invokeV.objValue;
    }

    public yk2(mm4 mm4Var, wk2 wk2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mm4Var, wk2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + wk2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = mm4Var;
        this.k = wk2Var;
        if (wk2Var != null) {
            Iterator<String> it = wk2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                tk2 a2 = uk2.a(next);
                if (a2 == null) {
                    wk2Var.c(next, false);
                } else if (a2.f()) {
                    wk2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    xk2 t = vk2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(eo4.b(e2));
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

    public final xk2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            xk2 xk2Var = this.i.get(str);
            if (xk2Var == null || !xk2Var.r(this)) {
                return null;
            }
            return xk2Var;
        }
        return (xk2) invokeL.objValue;
    }

    public final void f0(ik4 ik4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ik4Var) == null) {
            ce2.c().d(ik4Var, new d(this, ik4Var));
        }
    }

    @Override // com.baidu.tieba.bj4
    public ao4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.equals("so", str)) {
                return this;
            }
            return super.w(str);
        }
        return (ao4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bj4
    public void C(ak4 ak4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ak4Var) == null) {
            super.C(ak4Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + ak4Var.toString());
            }
            e0(new Exception("failed by fetch error = " + ak4Var));
        }
    }

    @Override // com.baidu.tieba.bj4
    public void G(oo4 oo4Var) {
        int n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, oo4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                if (oo4Var == null) {
                    n2 = 0;
                } else {
                    n2 = oo4Var.n();
                }
                sb.append(n2);
                Log.i(str, sb.toString());
            }
            super.G(oo4Var);
            if (oo4Var == null) {
                return;
            }
            this.f = oo4Var;
            if (!oo4Var.k()) {
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
            wk2 wk2Var = this.k;
            if (wk2Var != null) {
                wk2Var.b(exc);
            }
        }
    }

    @Override // com.baidu.tieba.ao4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((ik4) no4.j(jSONObject, new ik4()));
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
            for (xk2 xk2Var : this.i.values()) {
                if (!xk2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + xk2Var);
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
            for (xk2 xk2Var : this.i.values()) {
                if (xk2Var != null && xk2Var.r(this) && !xk2Var.n() && !xk2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + xk2Var);
                    }
                    xk2Var.q();
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
                arrayList.add(kcc.d(new e(this)));
            }
            if (!arrayList.isEmpty()) {
                kcc.q(arrayList).F(b0());
            }
        }
    }

    public final void g0(ik4 ik4Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ik4Var) == null) {
            if (m) {
                Log.i(this.c, "SoNodeHandler updateBestSo start so=" + ik4Var);
            }
            if (ik4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            eo4 eo4Var = this.j.get(ik4Var.g);
            if (eo4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by illegal bundleId=" + ik4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(ik4Var.p)) {
                ik4Var.p = eo4Var.a;
            }
            xk2 a0 = a0(ik4Var.p);
            if (a0 == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by no updating lib=" + ik4Var.p);
                    return;
                }
                return;
            }
            if (ik4Var.q == null) {
                ik4Var.q = eo4Var.c;
            }
            if (!AbiType.currentAbi().compat(ik4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            ik4 l = a0.l();
            ik4 j2 = a0.j();
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
            long j4 = ik4Var.i;
            if (j4 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(ik4Var.i)));
                }
            } else if (j4 > max) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by update bestVer=" + ik4Var.i);
                }
                a0.w(this, ik4Var);
            } else {
                if (j2 == null || !j2.q.compat(ik4Var.q)) {
                    if (m) {
                        Log.i(this.c, "SoNodeHandler updateBestSo end by update abi update=" + ik4Var.q);
                    }
                    a0.w(this, ik4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.ao4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            yn4 yn4Var = new yn4();
            oo4 oo4Var = new oo4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !ap3.G() && f73.j() == 1) ? false : false) {
                String i = f73.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        ik4 ik4Var = (ik4) no4.j(new JSONObject(i), new ik4());
                        ik4Var.g = "so_zeus_armeabi";
                        g0(ik4Var);
                        ya3.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f14c4)).G();
                    } catch (JSONException e2) {
                        ya3.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f14c3)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (xk2 xk2Var : this.i.values()) {
                if (xk2Var.r(this)) {
                    g0(xk2Var.l());
                    ik4 j = xk2Var.j();
                    if (xk2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        zn4.b(j, oo4Var);
                        if (yn4Var.d == null) {
                            yn4Var.d = new ArrayList();
                        }
                        yn4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        xk2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + oo4Var.n());
            }
            if (oo4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(oo4Var);
            rk4.e(yn4Var, this);
        }
    }
}
