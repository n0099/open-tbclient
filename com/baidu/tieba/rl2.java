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
import com.baidu.tieba.gob;
import com.baidu.tieba.pl2;
import com.baidu.tieba.ve2;
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
public final class rl2 extends df2 implements wo4, to4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public mob<? super bl4> d;
    public mob<bl4> e;
    public hp4 f;
    public final fn4 g;
    public qj4<bl4> h;
    public final Map<String, ql2> i;
    public final Map<String, xo4> j;
    public final pl2 k;
    public final jn4<JSONArray> l;

    @Override // com.baidu.tieba.wo4
    public uj4 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (uj4) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements jn4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl2 a;

        public a(rl2 rl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jn4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray != null && !this.a.i.isEmpty()) {
                for (ql2 ql2Var : this.a.i.values()) {
                    if (ql2Var != null && ql2Var.r(this.a)) {
                        ql2Var.a(jSONArray);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements sq3<ql2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl2 a;

        public b(rl2 rl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(ql2 ql2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ql2Var) == null) {
                if (rl2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + ql2Var);
                }
                if (ql2Var != null) {
                    this.a.k.c(ql2Var.k(), ql2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements sq3<ql2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl2 a;

        public c(rl2 rl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(ql2 ql2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ql2Var) == null) && ql2Var != null) {
                this.a.k.d(ql2Var.k(), ql2Var.m());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ve2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bl4 a;
        public final /* synthetic */ rl2 b;

        public d(rl2 rl2Var, bl4 bl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl2Var, bl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rl2Var;
            this.a = bl4Var;
        }

        @Override // com.baidu.tieba.ve2.c
        public void b(PMSDownloadType pMSDownloadType, sn3 sn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, sn3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, sn3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ve2.c
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
    public class e implements gob.a<bl4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl2 a;

        public e(rl2 rl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
        public void call(mob<? super bl4> mobVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, mobVar) != null) {
                return;
            }
            this.a.d = mobVar;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends mob<bl4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl2 e;

        public f(rl2 rl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = rl2Var;
        }

        public /* synthetic */ f(rl2 rl2Var, a aVar) {
            this(rl2Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hob
        /* renamed from: g */
        public void onNext(bl4 bl4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bl4Var) == null) && rl2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + bl4Var.toString());
            }
        }

        @Override // com.baidu.tieba.hob
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (rl2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.hob
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (rl2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends nj4<bl4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl2 a;

        public g(rl2 rl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl2Var;
        }

        public /* synthetic */ g(rl2 rl2Var, a aVar) {
            this(rl2Var);
        }

        @Override // com.baidu.tieba.sj4
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
        @Override // com.baidu.tieba.qj4
        /* renamed from: l */
        public String d(bl4 bl4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bl4Var)) == null) {
                String g = ol2.d.g(bl4Var);
                if (rl2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + bl4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: q */
        public void a(bl4 bl4Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bl4Var) == null) {
                super.a(bl4Var);
                xo4 xo4Var = (xo4) this.a.j.get(bl4Var.g);
                rl2 rl2Var = this.a;
                if (xo4Var == null) {
                    str = null;
                } else {
                    str = xo4Var.a;
                }
                ql2 a0 = rl2Var.a0(str);
                if (a0 != null) {
                    a0.x(new pl2.b(bl4Var.b, bl4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: r */
        public void c(bl4 bl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, bl4Var) == null) {
                super.c(bl4Var);
                if (rl2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + bl4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: s */
        public void f(bl4 bl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, bl4Var) == null) {
                super.f(bl4Var);
                if (rl2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + bl4Var.g);
                }
                this.a.f0(bl4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: o */
        public void e(bl4 bl4Var, tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bl4Var, tk4Var) == null) {
                super.e(bl4Var, tk4Var);
                if (rl2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + bl4Var.g + " err=" + tk4Var);
                }
                this.a.f.l(bl4Var);
                sn3 sn3Var = new sn3();
                sn3Var.k(13L);
                sn3Var.i(tk4Var.a);
                sn3Var.d("so包下载失败");
                sn3Var.f(tk4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(bl4Var, sn3Var));
                }
                ve2.c().a(bl4Var, rl2.o, sn3Var);
                ds4.k(bl4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: p */
        public void i(bl4 bl4Var) {
            xo4 xo4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bl4Var) == null) {
                super.i(bl4Var);
                if (rl2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + bl4Var);
                }
                String str2 = bl4Var.p;
                if (TextUtils.isEmpty(str2) && (xo4Var = (xo4) this.a.j.get(bl4Var.g)) != null) {
                    str2 = xo4Var.a;
                }
                ql2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = mp3.a(new File(bl4Var.a), bl4Var.m);
                    if (rl2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + bl4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (rl2.m && !tp3.G() && y73.j() == 1) ? false : false;
                    if (a || z) {
                        wj4.i().m(bl4Var);
                        if (rl2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(bl4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(bl4Var);
                    this.a.d.onCompleted();
                }
                ve2.c().b(bl4Var, rl2.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948125393, "Lcom/baidu/tieba/rl2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948125393, "Lcom/baidu/tieba/rl2;");
                return;
            }
        }
        m = js1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    @Override // com.baidu.tieba.uj4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.uj4
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

    public final mob<bl4> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (mob) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wo4
    public jn4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (jn4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wo4
    @Nullable
    public fn4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (fn4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uj4
    public qj4<bl4> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (qj4) invokeV.objValue;
    }

    public rl2(fn4 fn4Var, pl2 pl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fn4Var, pl2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + pl2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = fn4Var;
        this.k = pl2Var;
        if (pl2Var != null) {
            Iterator<String> it = pl2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                ml2 a2 = nl2.a(next);
                if (a2 == null) {
                    pl2Var.c(next, false);
                } else if (a2.f()) {
                    pl2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    ql2 t = ol2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(xo4.b(e2));
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

    public final ql2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            ql2 ql2Var = this.i.get(str);
            if (ql2Var == null || !ql2Var.r(this)) {
                return null;
            }
            return ql2Var;
        }
        return (ql2) invokeL.objValue;
    }

    public final void f0(bl4 bl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bl4Var) == null) {
            ve2.c().d(bl4Var, new d(this, bl4Var));
        }
    }

    @Override // com.baidu.tieba.uj4
    public to4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.equals("so", str)) {
                return this;
            }
            return super.w(str);
        }
        return (to4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.uj4
    public void C(tk4 tk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tk4Var) == null) {
            super.C(tk4Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + tk4Var.toString());
            }
            e0(new Exception("failed by fetch error = " + tk4Var));
        }
    }

    @Override // com.baidu.tieba.uj4
    public void G(hp4 hp4Var) {
        int n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hp4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                if (hp4Var == null) {
                    n2 = 0;
                } else {
                    n2 = hp4Var.n();
                }
                sb.append(n2);
                Log.i(str, sb.toString());
            }
            super.G(hp4Var);
            if (hp4Var == null) {
                return;
            }
            this.f = hp4Var;
            if (!hp4Var.k()) {
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
            pl2 pl2Var = this.k;
            if (pl2Var != null) {
                pl2Var.b(exc);
            }
        }
    }

    @Override // com.baidu.tieba.to4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((bl4) gp4.j(jSONObject, new bl4()));
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
            for (ql2 ql2Var : this.i.values()) {
                if (!ql2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + ql2Var);
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
            for (ql2 ql2Var : this.i.values()) {
                if (ql2Var != null && ql2Var.r(this) && !ql2Var.n() && !ql2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + ql2Var);
                    }
                    ql2Var.q();
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
                arrayList.add(gob.a(new e(this)));
            }
            if (!arrayList.isEmpty()) {
                gob.k(arrayList).w(b0());
            }
        }
    }

    public final void g0(bl4 bl4Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bl4Var) == null) {
            if (m) {
                Log.i(this.c, "SoNodeHandler updateBestSo start so=" + bl4Var);
            }
            if (bl4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            xo4 xo4Var = this.j.get(bl4Var.g);
            if (xo4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by illegal bundleId=" + bl4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(bl4Var.p)) {
                bl4Var.p = xo4Var.a;
            }
            ql2 a0 = a0(bl4Var.p);
            if (a0 == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by no updating lib=" + bl4Var.p);
                    return;
                }
                return;
            }
            if (bl4Var.q == null) {
                bl4Var.q = xo4Var.c;
            }
            if (!AbiType.currentAbi().compat(bl4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            bl4 l = a0.l();
            bl4 j2 = a0.j();
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
            long j4 = bl4Var.i;
            if (j4 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(bl4Var.i)));
                }
            } else if (j4 > max) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by update bestVer=" + bl4Var.i);
                }
                a0.w(this, bl4Var);
            } else {
                if (j2 == null || !j2.q.compat(bl4Var.q)) {
                    if (m) {
                        Log.i(this.c, "SoNodeHandler updateBestSo end by update abi update=" + bl4Var.q);
                    }
                    a0.w(this, bl4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.to4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ro4 ro4Var = new ro4();
            hp4 hp4Var = new hp4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !tp3.G() && y73.j() == 1) ? false : false) {
                String i = y73.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        bl4 bl4Var = (bl4) gp4.j(new JSONObject(i), new bl4());
                        bl4Var.g = "so_zeus_armeabi";
                        g0(bl4Var);
                        rb3.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1463)).G();
                    } catch (JSONException e2) {
                        rb3.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1462)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (ql2 ql2Var : this.i.values()) {
                if (ql2Var.r(this)) {
                    g0(ql2Var.l());
                    bl4 j = ql2Var.j();
                    if (ql2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        so4.b(j, hp4Var);
                        if (ro4Var.d == null) {
                            ro4Var.d = new ArrayList();
                        }
                        ro4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        ql2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + hp4Var.n());
            }
            if (hp4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(hp4Var);
            kl4.e(ro4Var, this);
        }
    }
}
