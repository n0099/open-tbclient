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
import com.baidu.tieba.de2;
import com.baidu.tieba.sac;
import com.baidu.tieba.xk2;
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
/* loaded from: classes9.dex */
public final class zk2 extends le2 implements eo4, bo4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public yac<? super jk4> d;
    public yac<jk4> e;
    public po4 f;
    public final nm4 g;
    public yi4<jk4> h;
    public final Map<String, yk2> i;
    public final Map<String, fo4> j;
    public final xk2 k;
    public final rm4<JSONArray> l;

    @Override // com.baidu.tieba.eo4
    public cj4 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (cj4) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public class a implements rm4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk2 a;

        public a(zk2 zk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rm4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray != null && !this.a.i.isEmpty()) {
                for (yk2 yk2Var : this.a.i.values()) {
                    if (yk2Var != null && yk2Var.r(this.a)) {
                        yk2Var.a(jSONArray);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements aq3<yk2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk2 a;

        public b(zk2 zk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(yk2 yk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yk2Var) == null) {
                if (zk2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + yk2Var);
                }
                if (yk2Var != null) {
                    this.a.k.c(yk2Var.k(), yk2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements aq3<yk2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk2 a;

        public c(zk2 zk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(yk2 yk2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yk2Var) == null) && yk2Var != null) {
                this.a.k.d(yk2Var.k(), yk2Var.m());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements de2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jk4 a;
        public final /* synthetic */ zk2 b;

        public d(zk2 zk2Var, jk4 jk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk2Var, jk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zk2Var;
            this.a = jk4Var;
        }

        @Override // com.baidu.tieba.de2.c
        public void b(PMSDownloadType pMSDownloadType, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, an3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, an3Var));
                }
            }
        }

        @Override // com.baidu.tieba.de2.c
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

    /* loaded from: classes9.dex */
    public class e implements sac.a<jk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk2 a;

        public e(zk2 zk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
        public void call(yac<? super jk4> yacVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, yacVar) != null) {
                return;
            }
            this.a.d = yacVar;
        }
    }

    /* loaded from: classes9.dex */
    public class f extends yac<jk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk2 e;

        public f(zk2 zk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zk2Var;
        }

        public /* synthetic */ f(zk2 zk2Var, a aVar) {
            this(zk2Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tac
        /* renamed from: g */
        public void onNext(jk4 jk4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jk4Var) == null) && zk2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + jk4Var.toString());
            }
        }

        @Override // com.baidu.tieba.tac
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (zk2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.tac
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (zk2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends vi4<jk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk2 a;

        public g(zk2 zk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk2Var;
        }

        public /* synthetic */ g(zk2 zk2Var, a aVar) {
            this(zk2Var);
        }

        @Override // com.baidu.tieba.aj4
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
        @Override // com.baidu.tieba.yi4
        /* renamed from: l */
        public String d(jk4 jk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jk4Var)) == null) {
                String g = wk2.d.g(jk4Var);
                if (zk2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + jk4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: q */
        public void a(jk4 jk4Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, jk4Var) == null) {
                super.a(jk4Var);
                fo4 fo4Var = (fo4) this.a.j.get(jk4Var.g);
                zk2 zk2Var = this.a;
                if (fo4Var == null) {
                    str = null;
                } else {
                    str = fo4Var.a;
                }
                yk2 a0 = zk2Var.a0(str);
                if (a0 != null) {
                    a0.x(new xk2.b(jk4Var.b, jk4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: r */
        public void c(jk4 jk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, jk4Var) == null) {
                super.c(jk4Var);
                if (zk2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + jk4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: s */
        public void f(jk4 jk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, jk4Var) == null) {
                super.f(jk4Var);
                if (zk2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + jk4Var.g);
                }
                this.a.f0(jk4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: o */
        public void e(jk4 jk4Var, bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jk4Var, bk4Var) == null) {
                super.e(jk4Var, bk4Var);
                if (zk2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + jk4Var.g + " err=" + bk4Var);
                }
                this.a.f.l(jk4Var);
                an3 an3Var = new an3();
                an3Var.k(13L);
                an3Var.i(bk4Var.a);
                an3Var.d("so包下载失败");
                an3Var.f(bk4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(jk4Var, an3Var));
                }
                de2.c().a(jk4Var, zk2.o, an3Var);
                lr4.k(jk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: p */
        public void i(jk4 jk4Var) {
            fo4 fo4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, jk4Var) == null) {
                super.i(jk4Var);
                if (zk2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + jk4Var);
                }
                String str2 = jk4Var.p;
                if (TextUtils.isEmpty(str2) && (fo4Var = (fo4) this.a.j.get(jk4Var.g)) != null) {
                    str2 = fo4Var.a;
                }
                yk2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = uo3.a(new File(jk4Var.a), jk4Var.m);
                    if (zk2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + jk4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (zk2.m && !bp3.G() && g73.j() == 1) ? false : false;
                    if (a || z) {
                        ej4.i().m(jk4Var);
                        if (zk2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(jk4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(jk4Var);
                    this.a.d.onCompleted();
                }
                de2.c().b(jk4Var, zk2.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948362760, "Lcom/baidu/tieba/zk2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948362760, "Lcom/baidu/tieba/zk2;");
                return;
            }
        }
        m = rr1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    @Override // com.baidu.tieba.cj4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.cj4
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

    public final yac<jk4> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (yac) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eo4
    public rm4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (rm4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eo4
    @Nullable
    public nm4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (nm4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cj4
    public yi4<jk4> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (yi4) invokeV.objValue;
    }

    public zk2(nm4 nm4Var, xk2 xk2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nm4Var, xk2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + xk2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = nm4Var;
        this.k = xk2Var;
        if (xk2Var != null) {
            Iterator<String> it = xk2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                uk2 a2 = vk2.a(next);
                if (a2 == null) {
                    xk2Var.c(next, false);
                } else if (a2.f()) {
                    xk2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    yk2 t = wk2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(fo4.b(e2));
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

    public final yk2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            yk2 yk2Var = this.i.get(str);
            if (yk2Var == null || !yk2Var.r(this)) {
                return null;
            }
            return yk2Var;
        }
        return (yk2) invokeL.objValue;
    }

    public final void f0(jk4 jk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jk4Var) == null) {
            de2.c().d(jk4Var, new d(this, jk4Var));
        }
    }

    @Override // com.baidu.tieba.cj4
    public bo4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.equals("so", str)) {
                return this;
            }
            return super.w(str);
        }
        return (bo4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.cj4
    public void C(bk4 bk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bk4Var) == null) {
            super.C(bk4Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + bk4Var.toString());
            }
            e0(new Exception("failed by fetch error = " + bk4Var));
        }
    }

    @Override // com.baidu.tieba.cj4
    public void G(po4 po4Var) {
        int n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, po4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                if (po4Var == null) {
                    n2 = 0;
                } else {
                    n2 = po4Var.n();
                }
                sb.append(n2);
                Log.i(str, sb.toString());
            }
            super.G(po4Var);
            if (po4Var == null) {
                return;
            }
            this.f = po4Var;
            if (!po4Var.k()) {
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
            xk2 xk2Var = this.k;
            if (xk2Var != null) {
                xk2Var.b(exc);
            }
        }
    }

    @Override // com.baidu.tieba.bo4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((jk4) oo4.j(jSONObject, new jk4()));
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
            for (yk2 yk2Var : this.i.values()) {
                if (!yk2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + yk2Var);
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
            for (yk2 yk2Var : this.i.values()) {
                if (yk2Var != null && yk2Var.r(this) && !yk2Var.n() && !yk2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + yk2Var);
                    }
                    yk2Var.q();
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
                arrayList.add(sac.d(new e(this)));
            }
            if (!arrayList.isEmpty()) {
                sac.q(arrayList).F(b0());
            }
        }
    }

    public final void g0(jk4 jk4Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jk4Var) == null) {
            if (m) {
                Log.i(this.c, "SoNodeHandler updateBestSo start so=" + jk4Var);
            }
            if (jk4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            fo4 fo4Var = this.j.get(jk4Var.g);
            if (fo4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by illegal bundleId=" + jk4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(jk4Var.p)) {
                jk4Var.p = fo4Var.a;
            }
            yk2 a0 = a0(jk4Var.p);
            if (a0 == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by no updating lib=" + jk4Var.p);
                    return;
                }
                return;
            }
            if (jk4Var.q == null) {
                jk4Var.q = fo4Var.c;
            }
            if (!AbiType.currentAbi().compat(jk4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            jk4 l = a0.l();
            jk4 j2 = a0.j();
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
            long j4 = jk4Var.i;
            if (j4 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(jk4Var.i)));
                }
            } else if (j4 > max) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by update bestVer=" + jk4Var.i);
                }
                a0.w(this, jk4Var);
            } else {
                if (j2 == null || !j2.q.compat(jk4Var.q)) {
                    if (m) {
                        Log.i(this.c, "SoNodeHandler updateBestSo end by update abi update=" + jk4Var.q);
                    }
                    a0.w(this, jk4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.bo4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            zn4 zn4Var = new zn4();
            po4 po4Var = new po4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !bp3.G() && g73.j() == 1) ? false : false) {
                String i = g73.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        jk4 jk4Var = (jk4) oo4.j(new JSONObject(i), new jk4());
                        jk4Var.g = "so_zeus_armeabi";
                        g0(jk4Var);
                        za3.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f14c1)).G();
                    } catch (JSONException e2) {
                        za3.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f14c0)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (yk2 yk2Var : this.i.values()) {
                if (yk2Var.r(this)) {
                    g0(yk2Var.l());
                    jk4 j = yk2Var.j();
                    if (yk2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        ao4.b(j, po4Var);
                        if (zn4Var.d == null) {
                            zn4Var.d = new ArrayList();
                        }
                        zn4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        yk2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + po4Var.n());
            }
            if (po4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(po4Var);
            sk4.e(zn4Var, this);
        }
    }
}
