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
import com.baidu.tieba.a72;
import com.baidu.tieba.b3a;
import com.baidu.tieba.ud2;
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
public final class wd2 extends i72 implements bh4, yg4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public h3a<? super gd4> d;
    public h3a<gd4> e;
    public mh4 f;
    public final kf4 g;
    public vb4<gd4> h;
    public final Map<String, vd2> i;
    public final Map<String, ch4> j;
    public final ud2 k;
    public final of4<JSONArray> l;

    @Override // com.baidu.tieba.bh4
    public zb4 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (zb4) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements of4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wd2 a;

        public a(wd2 wd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.of4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray != null && !this.a.i.isEmpty()) {
                for (vd2 vd2Var : this.a.i.values()) {
                    if (vd2Var != null && vd2Var.r(this.a)) {
                        vd2Var.a(jSONArray);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements xi3<vd2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wd2 a;

        public b(wd2 wd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(vd2 vd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vd2Var) == null) {
                if (wd2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + vd2Var);
                }
                if (vd2Var != null) {
                    this.a.k.c(vd2Var.k(), vd2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements xi3<vd2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wd2 a;

        public c(wd2 wd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(vd2 vd2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vd2Var) == null) && vd2Var != null) {
                this.a.k.d(vd2Var.k(), vd2Var.m());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements a72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gd4 a;
        public final /* synthetic */ wd2 b;

        public d(wd2 wd2Var, gd4 gd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd2Var, gd4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wd2Var;
            this.a = gd4Var;
        }

        @Override // com.baidu.tieba.a72.c
        public void b(PMSDownloadType pMSDownloadType, xf3 xf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, xf3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, xf3Var));
                }
            }
        }

        @Override // com.baidu.tieba.a72.c
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
    public class e implements b3a.a<gd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wd2 a;

        public e(wd2 wd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b3a.a, com.baidu.tieba.p3a
        public void call(h3a<? super gd4> h3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, h3aVar) != null) {
                return;
            }
            this.a.d = h3aVar;
        }
    }

    /* loaded from: classes6.dex */
    public class f extends h3a<gd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wd2 e;

        public f(wd2 wd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = wd2Var;
        }

        public /* synthetic */ f(wd2 wd2Var, a aVar) {
            this(wd2Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c3a
        /* renamed from: g */
        public void onNext(gd4 gd4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, gd4Var) == null) && wd2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + gd4Var.toString());
            }
        }

        @Override // com.baidu.tieba.c3a
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (wd2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.c3a
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (wd2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends sb4<gd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wd2 a;

        public g(wd2 wd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wd2Var;
        }

        public /* synthetic */ g(wd2 wd2Var, a aVar) {
            this(wd2Var);
        }

        @Override // com.baidu.tieba.xb4
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
        @Override // com.baidu.tieba.vb4
        /* renamed from: l */
        public String d(gd4 gd4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, gd4Var)) == null) {
                String g = td2.d.g(gd4Var);
                if (wd2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + gd4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: q */
        public void a(gd4 gd4Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, gd4Var) == null) {
                super.a(gd4Var);
                ch4 ch4Var = (ch4) this.a.j.get(gd4Var.g);
                wd2 wd2Var = this.a;
                if (ch4Var == null) {
                    str = null;
                } else {
                    str = ch4Var.a;
                }
                vd2 a0 = wd2Var.a0(str);
                if (a0 != null) {
                    a0.x(new ud2.b(gd4Var.b, gd4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: r */
        public void c(gd4 gd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, gd4Var) == null) {
                super.c(gd4Var);
                if (wd2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + gd4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: s */
        public void f(gd4 gd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, gd4Var) == null) {
                super.f(gd4Var);
                if (wd2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + gd4Var.g);
                }
                this.a.f0(gd4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: o */
        public void e(gd4 gd4Var, yc4 yc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gd4Var, yc4Var) == null) {
                super.e(gd4Var, yc4Var);
                if (wd2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + gd4Var.g + " err=" + yc4Var);
                }
                this.a.f.l(gd4Var);
                xf3 xf3Var = new xf3();
                xf3Var.k(13L);
                xf3Var.i(yc4Var.a);
                xf3Var.d("so包下载失败");
                xf3Var.f(yc4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(gd4Var, xf3Var));
                }
                a72.c().a(gd4Var, wd2.o, xf3Var);
                ik4.k(gd4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: p */
        public void i(gd4 gd4Var) {
            ch4 ch4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, gd4Var) == null) {
                super.i(gd4Var);
                if (wd2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + gd4Var);
                }
                String str2 = gd4Var.p;
                if (TextUtils.isEmpty(str2) && (ch4Var = (ch4) this.a.j.get(gd4Var.g)) != null) {
                    str2 = ch4Var.a;
                }
                vd2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = rh3.a(new File(gd4Var.a), gd4Var.m);
                    if (wd2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + gd4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (wd2.m && !yh3.G() && d03.j() == 1) ? false : false;
                    if (a || z) {
                        bc4.i().m(gd4Var);
                        if (wd2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(gd4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(gd4Var);
                    this.a.d.onCompleted();
                }
                a72.c().b(gd4Var, wd2.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948266660, "Lcom/baidu/tieba/wd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948266660, "Lcom/baidu/tieba/wd2;");
                return;
            }
        }
        m = ok1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    @Override // com.baidu.tieba.zb4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.zb4
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

    public final h3a<gd4> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (h3a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bh4
    public of4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (of4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bh4
    @Nullable
    public kf4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (kf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zb4
    public vb4<gd4> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (vb4) invokeV.objValue;
    }

    public wd2(kf4 kf4Var, ud2 ud2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kf4Var, ud2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + ud2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = kf4Var;
        this.k = ud2Var;
        if (ud2Var != null) {
            Iterator<String> it = ud2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                rd2 a2 = sd2.a(next);
                if (a2 == null) {
                    ud2Var.c(next, false);
                } else if (a2.f()) {
                    ud2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    vd2 t = td2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(ch4.b(e2));
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

    public final vd2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            vd2 vd2Var = this.i.get(str);
            if (vd2Var == null || !vd2Var.r(this)) {
                return null;
            }
            return vd2Var;
        }
        return (vd2) invokeL.objValue;
    }

    public final void f0(gd4 gd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gd4Var) == null) {
            a72.c().d(gd4Var, new d(this, gd4Var));
        }
    }

    @Override // com.baidu.tieba.zb4
    public yg4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.equals("so", str)) {
                return this;
            }
            return super.w(str);
        }
        return (yg4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zb4
    public void C(yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yc4Var) == null) {
            super.C(yc4Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + yc4Var.toString());
            }
            e0(new Exception("failed by fetch error = " + yc4Var));
        }
    }

    @Override // com.baidu.tieba.zb4
    public void G(mh4 mh4Var) {
        int n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mh4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                if (mh4Var == null) {
                    n2 = 0;
                } else {
                    n2 = mh4Var.n();
                }
                sb.append(n2);
                Log.i(str, sb.toString());
            }
            super.G(mh4Var);
            if (mh4Var == null) {
                return;
            }
            this.f = mh4Var;
            if (!mh4Var.k()) {
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
            ud2 ud2Var = this.k;
            if (ud2Var != null) {
                ud2Var.b(exc);
            }
        }
    }

    @Override // com.baidu.tieba.yg4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((gd4) lh4.j(jSONObject, new gd4()));
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
            for (vd2 vd2Var : this.i.values()) {
                if (!vd2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + vd2Var);
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
            for (vd2 vd2Var : this.i.values()) {
                if (vd2Var != null && vd2Var.r(this) && !vd2Var.n() && !vd2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + vd2Var);
                    }
                    vd2Var.q();
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
                arrayList.add(b3a.a(new e(this)));
            }
            if (!arrayList.isEmpty()) {
                b3a.i(arrayList).u(b0());
            }
        }
    }

    public final void g0(gd4 gd4Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, gd4Var) == null) {
            if (m) {
                Log.i(this.c, "SoNodeHandler updateBestSo start so=" + gd4Var);
            }
            if (gd4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            ch4 ch4Var = this.j.get(gd4Var.g);
            if (ch4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by illegal bundleId=" + gd4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(gd4Var.p)) {
                gd4Var.p = ch4Var.a;
            }
            vd2 a0 = a0(gd4Var.p);
            if (a0 == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by no updating lib=" + gd4Var.p);
                    return;
                }
                return;
            }
            if (gd4Var.q == null) {
                gd4Var.q = ch4Var.c;
            }
            if (!AbiType.currentAbi().compat(gd4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            gd4 l = a0.l();
            gd4 j2 = a0.j();
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
            long j4 = gd4Var.i;
            if (j4 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(gd4Var.i)));
                }
            } else if (j4 > max) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by update bestVer=" + gd4Var.i);
                }
                a0.w(this, gd4Var);
            } else {
                if (j2 == null || !j2.q.compat(gd4Var.q)) {
                    if (m) {
                        Log.i(this.c, "SoNodeHandler updateBestSo end by update abi update=" + gd4Var.q);
                    }
                    a0.w(this, gd4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.yg4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            wg4 wg4Var = new wg4();
            mh4 mh4Var = new mh4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !yh3.G() && d03.j() == 1) ? false : false) {
                String i = d03.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        gd4 gd4Var = (gd4) lh4.j(new JSONObject(i), new gd4());
                        gd4Var.g = "so_zeus_armeabi";
                        g0(gd4Var);
                        w33.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f12c7)).G();
                    } catch (JSONException e2) {
                        w33.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f12c6)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (vd2 vd2Var : this.i.values()) {
                if (vd2Var.r(this)) {
                    g0(vd2Var.l());
                    gd4 j = vd2Var.j();
                    if (vd2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        xg4.b(j, mh4Var);
                        if (wg4Var.d == null) {
                            wg4Var.d = new ArrayList();
                        }
                        wg4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        vd2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + mh4Var.n());
            }
            if (mh4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(mh4Var);
            pd4.e(wg4Var, this);
        }
    }
}
