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
import com.baidu.tieba.d92;
import com.baidu.tieba.eoc;
import com.baidu.tieba.xf2;
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
public final class zf2 extends l92 implements ej4, bj4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public koc<? super jf4> d;
    public koc<jf4> e;
    public pj4 f;
    public final nh4 g;
    public yd4<jf4> h;
    public final Map<String, yf2> i;
    public final Map<String, fj4> j;
    public final xf2 k;
    public final rh4<JSONArray> l;

    @Override // com.baidu.tieba.ej4
    public ce4 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (ce4) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public class a implements rh4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zf2 a;

        public a(zf2 zf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray != null && !this.a.i.isEmpty()) {
                for (yf2 yf2Var : this.a.i.values()) {
                    if (yf2Var != null && yf2Var.r(this.a)) {
                        yf2Var.a(jSONArray);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements al3<yf2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zf2 a;

        public b(zf2 zf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(yf2 yf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yf2Var) == null) {
                if (zf2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + yf2Var);
                }
                if (yf2Var != null) {
                    this.a.k.c(yf2Var.k(), yf2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements al3<yf2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zf2 a;

        public c(zf2 zf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(yf2 yf2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yf2Var) == null) && yf2Var != null) {
                this.a.k.d(yf2Var.k(), yf2Var.m());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements d92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jf4 a;
        public final /* synthetic */ zf2 b;

        public d(zf2 zf2Var, jf4 jf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf2Var, jf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zf2Var;
            this.a = jf4Var;
        }

        @Override // com.baidu.tieba.d92.c
        public void b(PMSDownloadType pMSDownloadType, ai3 ai3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ai3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, ai3Var));
                }
            }
        }

        @Override // com.baidu.tieba.d92.c
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
    public class e implements eoc.a<jf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zf2 a;

        public e(zf2 zf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.soc
        /* renamed from: a */
        public void call(koc<? super jf4> kocVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, kocVar) != null) {
                return;
            }
            this.a.d = kocVar;
        }
    }

    /* loaded from: classes9.dex */
    public class f extends koc<jf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zf2 e;

        public f(zf2 zf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zf2Var;
        }

        public /* synthetic */ f(zf2 zf2Var, a aVar) {
            this(zf2Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.foc
        /* renamed from: g */
        public void onNext(jf4 jf4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jf4Var) == null) && zf2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + jf4Var.toString());
            }
        }

        @Override // com.baidu.tieba.foc
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (zf2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.foc
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (zf2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends vd4<jf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zf2 a;

        public g(zf2 zf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zf2Var;
        }

        public /* synthetic */ g(zf2 zf2Var, a aVar) {
            this(zf2Var);
        }

        @Override // com.baidu.tieba.ae4
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
        @Override // com.baidu.tieba.yd4
        /* renamed from: l */
        public String d(jf4 jf4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jf4Var)) == null) {
                String g = wf2.d.g(jf4Var);
                if (zf2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + jf4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: q */
        public void a(jf4 jf4Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, jf4Var) == null) {
                super.a(jf4Var);
                fj4 fj4Var = (fj4) this.a.j.get(jf4Var.g);
                zf2 zf2Var = this.a;
                if (fj4Var == null) {
                    str = null;
                } else {
                    str = fj4Var.a;
                }
                yf2 a0 = zf2Var.a0(str);
                if (a0 != null) {
                    a0.x(new xf2.b(jf4Var.b, jf4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: r */
        public void c(jf4 jf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, jf4Var) == null) {
                super.c(jf4Var);
                if (zf2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + jf4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: s */
        public void f(jf4 jf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, jf4Var) == null) {
                super.f(jf4Var);
                if (zf2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + jf4Var.g);
                }
                this.a.f0(jf4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: o */
        public void e(jf4 jf4Var, bf4 bf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jf4Var, bf4Var) == null) {
                super.e(jf4Var, bf4Var);
                if (zf2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + jf4Var.g + " err=" + bf4Var);
                }
                this.a.f.l(jf4Var);
                ai3 ai3Var = new ai3();
                ai3Var.k(13L);
                ai3Var.i(bf4Var.a);
                ai3Var.d("so包下载失败");
                ai3Var.f(bf4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(jf4Var, ai3Var));
                }
                d92.c().a(jf4Var, zf2.o, ai3Var);
                km4.k(jf4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: p */
        public void i(jf4 jf4Var) {
            fj4 fj4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, jf4Var) == null) {
                super.i(jf4Var);
                if (zf2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + jf4Var);
                }
                String str2 = jf4Var.p;
                if (TextUtils.isEmpty(str2) && (fj4Var = (fj4) this.a.j.get(jf4Var.g)) != null) {
                    str2 = fj4Var.a;
                }
                yf2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = uj3.a(new File(jf4Var.a), jf4Var.m);
                    if (zf2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + jf4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (zf2.m && !bk3.G() && g23.j() == 1) ? false : false;
                    if (a || z) {
                        ee4.i().m(jf4Var);
                        if (zf2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(jf4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(jf4Var);
                    this.a.d.onCompleted();
                }
                d92.c().b(jf4Var, zf2.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948357955, "Lcom/baidu/tieba/zf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948357955, "Lcom/baidu/tieba/zf2;");
                return;
            }
        }
        m = sm1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    @Override // com.baidu.tieba.ce4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.ce4
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

    public final koc<jf4> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (koc) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ej4
    public rh4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (rh4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ej4
    @Nullable
    public nh4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (nh4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ce4
    public yd4<jf4> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (yd4) invokeV.objValue;
    }

    public zf2(nh4 nh4Var, xf2 xf2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nh4Var, xf2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + xf2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = nh4Var;
        this.k = xf2Var;
        if (xf2Var != null) {
            Iterator<String> it = xf2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                uf2 a2 = vf2.a(next);
                if (a2 == null) {
                    xf2Var.c(next, false);
                } else if (a2.f()) {
                    xf2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    yf2 t = wf2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(fj4.b(e2));
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

    public final yf2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            yf2 yf2Var = this.i.get(str);
            if (yf2Var == null || !yf2Var.r(this)) {
                return null;
            }
            return yf2Var;
        }
        return (yf2) invokeL.objValue;
    }

    public final void f0(jf4 jf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jf4Var) == null) {
            d92.c().d(jf4Var, new d(this, jf4Var));
        }
    }

    @Override // com.baidu.tieba.ce4
    public bj4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.equals("so", str)) {
                return this;
            }
            return super.w(str);
        }
        return (bj4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ce4
    public void C(bf4 bf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bf4Var) == null) {
            super.C(bf4Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + bf4Var.toString());
            }
            e0(new Exception("failed by fetch error = " + bf4Var));
        }
    }

    @Override // com.baidu.tieba.ce4
    public void G(pj4 pj4Var) {
        int n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pj4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                if (pj4Var == null) {
                    n2 = 0;
                } else {
                    n2 = pj4Var.n();
                }
                sb.append(n2);
                Log.i(str, sb.toString());
            }
            super.G(pj4Var);
            if (pj4Var == null) {
                return;
            }
            this.f = pj4Var;
            if (!pj4Var.k()) {
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
            xf2 xf2Var = this.k;
            if (xf2Var != null) {
                xf2Var.b(exc);
            }
        }
    }

    @Override // com.baidu.tieba.bj4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((jf4) oj4.j(jSONObject, new jf4()));
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
            for (yf2 yf2Var : this.i.values()) {
                if (!yf2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + yf2Var);
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
            for (yf2 yf2Var : this.i.values()) {
                if (yf2Var != null && yf2Var.r(this) && !yf2Var.n() && !yf2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + yf2Var);
                    }
                    yf2Var.q();
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
                arrayList.add(eoc.d(new e(this)));
            }
            if (!arrayList.isEmpty()) {
                eoc.q(arrayList).F(b0());
            }
        }
    }

    public final void g0(jf4 jf4Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jf4Var) == null) {
            if (m) {
                Log.i(this.c, "SoNodeHandler updateBestSo start so=" + jf4Var);
            }
            if (jf4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            fj4 fj4Var = this.j.get(jf4Var.g);
            if (fj4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by illegal bundleId=" + jf4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(jf4Var.p)) {
                jf4Var.p = fj4Var.a;
            }
            yf2 a0 = a0(jf4Var.p);
            if (a0 == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by no updating lib=" + jf4Var.p);
                    return;
                }
                return;
            }
            if (jf4Var.q == null) {
                jf4Var.q = fj4Var.c;
            }
            if (!AbiType.currentAbi().compat(jf4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            jf4 l = a0.l();
            jf4 j2 = a0.j();
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
            long j4 = jf4Var.i;
            if (j4 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(jf4Var.i)));
                }
            } else if (j4 > max) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by update bestVer=" + jf4Var.i);
                }
                a0.w(this, jf4Var);
            } else {
                if (j2 == null || !j2.q.compat(jf4Var.q)) {
                    if (m) {
                        Log.i(this.c, "SoNodeHandler updateBestSo end by update abi update=" + jf4Var.q);
                    }
                    a0.w(this, jf4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.bj4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            zi4 zi4Var = new zi4();
            pj4 pj4Var = new pj4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !bk3.G() && g23.j() == 1) ? false : false) {
                String i = g23.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        jf4 jf4Var = (jf4) oj4.j(new JSONObject(i), new jf4());
                        jf4Var.g = "so_zeus_armeabi";
                        g0(jf4Var);
                        z53.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f14fc)).G();
                    } catch (JSONException e2) {
                        z53.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f14fb)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (yf2 yf2Var : this.i.values()) {
                if (yf2Var.r(this)) {
                    g0(yf2Var.l());
                    jf4 j = yf2Var.j();
                    if (yf2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        aj4.b(j, pj4Var);
                        if (zi4Var.d == null) {
                            zi4Var.d = new ArrayList();
                        }
                        zi4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        yf2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + pj4Var.n());
            }
            if (pj4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(pj4Var);
            sf4.e(zi4Var, this);
        }
    }
}
