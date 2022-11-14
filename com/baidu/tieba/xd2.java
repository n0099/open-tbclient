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
import com.baidu.tieba.b72;
import com.baidu.tieba.rz9;
import com.baidu.tieba.vd2;
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
/* loaded from: classes6.dex */
public final class xd2 extends j72 implements ch4, zg4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public xz9<? super hd4> d;
    public xz9<hd4> e;
    public nh4 f;
    public final lf4 g;
    public wb4<hd4> h;
    public final Map<String, wd2> i;
    public final Map<String, dh4> j;
    public final vd2 k;
    public final pf4<JSONArray> l;

    @Override // com.baidu.tieba.ch4
    public ac4 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (ac4) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements pf4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xd2 a;

        public a(xd2 xd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pf4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray != null && !this.a.i.isEmpty()) {
                for (wd2 wd2Var : this.a.i.values()) {
                    if (wd2Var != null && wd2Var.r(this.a)) {
                        wd2Var.a(jSONArray);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements yi3<wd2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xd2 a;

        public b(xd2 xd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(wd2 wd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wd2Var) == null) {
                if (xd2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + wd2Var);
                }
                if (wd2Var != null) {
                    this.a.k.c(wd2Var.k(), wd2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements yi3<wd2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xd2 a;

        public c(xd2 xd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(wd2 wd2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wd2Var) == null) && wd2Var != null) {
                this.a.k.d(wd2Var.k(), wd2Var.m());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements b72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hd4 a;
        public final /* synthetic */ xd2 b;

        public d(xd2 xd2Var, hd4 hd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xd2Var, hd4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xd2Var;
            this.a = hd4Var;
        }

        @Override // com.baidu.tieba.b72.c
        public void b(PMSDownloadType pMSDownloadType, yf3 yf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, yf3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, yf3Var));
                }
            }
        }

        @Override // com.baidu.tieba.b72.c
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

    /* loaded from: classes6.dex */
    public class e implements rz9.a<hd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xd2 a;

        public e(xd2 xd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rz9.a, com.baidu.tieba.f0a
        public void call(xz9<? super hd4> xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, xz9Var) != null) {
                return;
            }
            this.a.d = xz9Var;
        }
    }

    /* loaded from: classes6.dex */
    public class f extends xz9<hd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xd2 e;

        public f(xd2 xd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = xd2Var;
        }

        public /* synthetic */ f(xd2 xd2Var, a aVar) {
            this(xd2Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sz9
        /* renamed from: g */
        public void onNext(hd4 hd4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hd4Var) == null) && xd2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + hd4Var.toString());
            }
        }

        @Override // com.baidu.tieba.sz9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (xd2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.sz9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (xd2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends tb4<hd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xd2 a;

        public g(xd2 xd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xd2Var;
        }

        public /* synthetic */ g(xd2 xd2Var, a aVar) {
            this(xd2Var);
        }

        @Override // com.baidu.tieba.yb4
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
        @Override // com.baidu.tieba.wb4
        /* renamed from: l */
        public String d(hd4 hd4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hd4Var)) == null) {
                String g = ud2.d.g(hd4Var);
                if (xd2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + hd4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: q */
        public void a(hd4 hd4Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, hd4Var) == null) {
                super.a(hd4Var);
                dh4 dh4Var = (dh4) this.a.j.get(hd4Var.g);
                xd2 xd2Var = this.a;
                if (dh4Var == null) {
                    str = null;
                } else {
                    str = dh4Var.a;
                }
                wd2 a0 = xd2Var.a0(str);
                if (a0 != null) {
                    a0.x(new vd2.b(hd4Var.b, hd4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: r */
        public void c(hd4 hd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, hd4Var) == null) {
                super.c(hd4Var);
                if (xd2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + hd4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: s */
        public void f(hd4 hd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, hd4Var) == null) {
                super.f(hd4Var);
                if (xd2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + hd4Var.g);
                }
                this.a.f0(hd4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: o */
        public void e(hd4 hd4Var, zc4 zc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hd4Var, zc4Var) == null) {
                super.e(hd4Var, zc4Var);
                if (xd2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + hd4Var.g + " err=" + zc4Var);
                }
                this.a.f.l(hd4Var);
                yf3 yf3Var = new yf3();
                yf3Var.k(13L);
                yf3Var.i(zc4Var.a);
                yf3Var.d("so包下载失败");
                yf3Var.f(zc4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(hd4Var, yf3Var));
                }
                b72.c().a(hd4Var, xd2.o, yf3Var);
                jk4.k(hd4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: p */
        public void i(hd4 hd4Var) {
            dh4 dh4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hd4Var) == null) {
                super.i(hd4Var);
                if (xd2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + hd4Var);
                }
                String str2 = hd4Var.p;
                if (TextUtils.isEmpty(str2) && (dh4Var = (dh4) this.a.j.get(hd4Var.g)) != null) {
                    str2 = dh4Var.a;
                }
                wd2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = sh3.a(new File(hd4Var.a), hd4Var.m);
                    if (xd2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + hd4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (xd2.m && !zh3.G() && e03.j() == 1) ? false : false;
                    if (a || z) {
                        cc4.i().m(hd4Var);
                        if (xd2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(hd4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(hd4Var);
                    this.a.d.onCompleted();
                }
                b72.c().b(hd4Var, xd2.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948296451, "Lcom/baidu/tieba/xd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948296451, "Lcom/baidu/tieba/xd2;");
                return;
            }
        }
        m = pk1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    @Override // com.baidu.tieba.ac4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.ac4
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

    public final xz9<hd4> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (xz9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ch4
    public pf4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (pf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ch4
    @Nullable
    public lf4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (lf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ac4
    public wb4<hd4> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (wb4) invokeV.objValue;
    }

    public xd2(lf4 lf4Var, vd2 vd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lf4Var, vd2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + vd2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = lf4Var;
        this.k = vd2Var;
        if (vd2Var != null) {
            Iterator<String> it = vd2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                sd2 a2 = td2.a(next);
                if (a2 == null) {
                    vd2Var.c(next, false);
                } else if (a2.f()) {
                    vd2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    wd2 t = ud2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(dh4.b(e2));
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

    public final wd2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            wd2 wd2Var = this.i.get(str);
            if (wd2Var == null || !wd2Var.r(this)) {
                return null;
            }
            return wd2Var;
        }
        return (wd2) invokeL.objValue;
    }

    public final void f0(hd4 hd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hd4Var) == null) {
            b72.c().d(hd4Var, new d(this, hd4Var));
        }
    }

    @Override // com.baidu.tieba.ac4
    public zg4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.equals("so", str)) {
                return this;
            }
            return super.w(str);
        }
        return (zg4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ac4
    public void C(zc4 zc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zc4Var) == null) {
            super.C(zc4Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + zc4Var.toString());
            }
            e0(new Exception("failed by fetch error = " + zc4Var));
        }
    }

    @Override // com.baidu.tieba.ac4
    public void G(nh4 nh4Var) {
        int n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nh4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                if (nh4Var == null) {
                    n2 = 0;
                } else {
                    n2 = nh4Var.n();
                }
                sb.append(n2);
                Log.i(str, sb.toString());
            }
            super.G(nh4Var);
            if (nh4Var == null) {
                return;
            }
            this.f = nh4Var;
            if (!nh4Var.k()) {
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
            vd2 vd2Var = this.k;
            if (vd2Var != null) {
                vd2Var.b(exc);
            }
        }
    }

    @Override // com.baidu.tieba.zg4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((hd4) mh4.j(jSONObject, new hd4()));
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
            for (wd2 wd2Var : this.i.values()) {
                if (!wd2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + wd2Var);
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
            for (wd2 wd2Var : this.i.values()) {
                if (wd2Var != null && wd2Var.r(this) && !wd2Var.n() && !wd2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + wd2Var);
                    }
                    wd2Var.q();
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
                arrayList.add(rz9.a(new e(this)));
            }
            if (!arrayList.isEmpty()) {
                rz9.i(arrayList).u(b0());
            }
        }
    }

    public final void g0(hd4 hd4Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, hd4Var) == null) {
            if (m) {
                Log.i(this.c, "SoNodeHandler updateBestSo start so=" + hd4Var);
            }
            if (hd4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            dh4 dh4Var = this.j.get(hd4Var.g);
            if (dh4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by illegal bundleId=" + hd4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(hd4Var.p)) {
                hd4Var.p = dh4Var.a;
            }
            wd2 a0 = a0(hd4Var.p);
            if (a0 == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by no updating lib=" + hd4Var.p);
                    return;
                }
                return;
            }
            if (hd4Var.q == null) {
                hd4Var.q = dh4Var.c;
            }
            if (!AbiType.currentAbi().compat(hd4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            hd4 l = a0.l();
            hd4 j2 = a0.j();
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
            long j4 = hd4Var.i;
            if (j4 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(hd4Var.i)));
                }
            } else if (j4 > max) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by update bestVer=" + hd4Var.i);
                }
                a0.w(this, hd4Var);
            } else {
                if (j2 == null || !j2.q.compat(hd4Var.q)) {
                    if (m) {
                        Log.i(this.c, "SoNodeHandler updateBestSo end by update abi update=" + hd4Var.q);
                    }
                    a0.w(this, hd4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.zg4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            xg4 xg4Var = new xg4();
            nh4 nh4Var = new nh4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !zh3.G() && e03.j() == 1) ? false : false) {
                String i = e03.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        hd4 hd4Var = (hd4) mh4.j(new JSONObject(i), new hd4());
                        hd4Var.g = "so_zeus_armeabi";
                        g0(hd4Var);
                        x33.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f128c)).G();
                    } catch (JSONException e2) {
                        x33.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f128b)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (wd2 wd2Var : this.i.values()) {
                if (wd2Var.r(this)) {
                    g0(wd2Var.l());
                    hd4 j = wd2Var.j();
                    if (wd2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        yg4.b(j, nh4Var);
                        if (xg4Var.d == null) {
                            xg4Var.d = new ArrayList();
                        }
                        xg4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        wd2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + nh4Var.n());
            }
            if (nh4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(nh4Var);
            qd4.e(xg4Var, this);
        }
    }
}
