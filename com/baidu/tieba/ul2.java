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
import com.baidu.tieba.sl2;
import com.baidu.tieba.xsb;
import com.baidu.tieba.ye2;
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
public final class ul2 extends gf2 implements zo4, wo4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public dtb<? super el4> d;
    public dtb<el4> e;
    public kp4 f;
    public final in4 g;
    public tj4<el4> h;
    public final Map<String, tl2> i;
    public final Map<String, ap4> j;
    public final sl2 k;
    public final mn4<JSONArray> l;

    @Override // com.baidu.tieba.zo4
    public xj4 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (xj4) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements mn4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ul2 a;

        public a(ul2 ul2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ul2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ul2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mn4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray != null && !this.a.i.isEmpty()) {
                for (tl2 tl2Var : this.a.i.values()) {
                    if (tl2Var != null && tl2Var.r(this.a)) {
                        tl2Var.a(jSONArray);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements vq3<tl2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ul2 a;

        public b(ul2 ul2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ul2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ul2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(tl2 tl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tl2Var) == null) {
                if (ul2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + tl2Var);
                }
                if (tl2Var != null) {
                    this.a.k.c(tl2Var.k(), tl2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements vq3<tl2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ul2 a;

        public c(ul2 ul2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ul2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ul2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(tl2 tl2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tl2Var) == null) && tl2Var != null) {
                this.a.k.d(tl2Var.k(), tl2Var.m());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ye2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ el4 a;
        public final /* synthetic */ ul2 b;

        public d(ul2 ul2Var, el4 el4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ul2Var, el4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ul2Var;
            this.a = el4Var;
        }

        @Override // com.baidu.tieba.ye2.c
        public void b(PMSDownloadType pMSDownloadType, vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, vn3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, vn3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ye2.c
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
    public class e implements xsb.a<el4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ul2 a;

        public e(ul2 ul2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ul2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ul2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
        public void call(dtb<? super el4> dtbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dtbVar) != null) {
                return;
            }
            this.a.d = dtbVar;
        }
    }

    /* loaded from: classes8.dex */
    public class f extends dtb<el4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ul2 e;

        public f(ul2 ul2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ul2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ul2Var;
        }

        public /* synthetic */ f(ul2 ul2Var, a aVar) {
            this(ul2Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ysb
        /* renamed from: g */
        public void onNext(el4 el4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, el4Var) == null) && ul2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + el4Var.toString());
            }
        }

        @Override // com.baidu.tieba.ysb
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (ul2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.ysb
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (ul2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends qj4<el4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ul2 a;

        public g(ul2 ul2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ul2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ul2Var;
        }

        public /* synthetic */ g(ul2 ul2Var, a aVar) {
            this(ul2Var);
        }

        @Override // com.baidu.tieba.vj4
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
        @Override // com.baidu.tieba.tj4
        /* renamed from: l */
        public String d(el4 el4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, el4Var)) == null) {
                String g = rl2.d.g(el4Var);
                if (ul2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + el4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: q */
        public void a(el4 el4Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, el4Var) == null) {
                super.a(el4Var);
                ap4 ap4Var = (ap4) this.a.j.get(el4Var.g);
                ul2 ul2Var = this.a;
                if (ap4Var == null) {
                    str = null;
                } else {
                    str = ap4Var.a;
                }
                tl2 a0 = ul2Var.a0(str);
                if (a0 != null) {
                    a0.x(new sl2.b(el4Var.b, el4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: r */
        public void c(el4 el4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, el4Var) == null) {
                super.c(el4Var);
                if (ul2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + el4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: s */
        public void f(el4 el4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, el4Var) == null) {
                super.f(el4Var);
                if (ul2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + el4Var.g);
                }
                this.a.f0(el4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: o */
        public void e(el4 el4Var, wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, el4Var, wk4Var) == null) {
                super.e(el4Var, wk4Var);
                if (ul2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + el4Var.g + " err=" + wk4Var);
                }
                this.a.f.l(el4Var);
                vn3 vn3Var = new vn3();
                vn3Var.k(13L);
                vn3Var.i(wk4Var.a);
                vn3Var.d("so包下载失败");
                vn3Var.f(wk4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(el4Var, vn3Var));
                }
                ye2.c().a(el4Var, ul2.o, vn3Var);
                gs4.k(el4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: p */
        public void i(el4 el4Var) {
            ap4 ap4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, el4Var) == null) {
                super.i(el4Var);
                if (ul2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + el4Var);
                }
                String str2 = el4Var.p;
                if (TextUtils.isEmpty(str2) && (ap4Var = (ap4) this.a.j.get(el4Var.g)) != null) {
                    str2 = ap4Var.a;
                }
                tl2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = pp3.a(new File(el4Var.a), el4Var.m);
                    if (ul2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + el4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (ul2.m && !wp3.G() && b83.j() == 1) ? false : false;
                    if (a || z) {
                        zj4.i().m(el4Var);
                        if (ul2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(el4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(el4Var);
                    this.a.d.onCompleted();
                }
                ye2.c().b(el4Var, ul2.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948214766, "Lcom/baidu/tieba/ul2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948214766, "Lcom/baidu/tieba/ul2;");
                return;
            }
        }
        m = ms1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    @Override // com.baidu.tieba.xj4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.xj4
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

    public final dtb<el4> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (dtb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zo4
    public mn4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (mn4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zo4
    @Nullable
    public in4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (in4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xj4
    public tj4<el4> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (tj4) invokeV.objValue;
    }

    public ul2(in4 in4Var, sl2 sl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {in4Var, sl2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + sl2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = in4Var;
        this.k = sl2Var;
        if (sl2Var != null) {
            Iterator<String> it = sl2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                pl2 a2 = ql2.a(next);
                if (a2 == null) {
                    sl2Var.c(next, false);
                } else if (a2.f()) {
                    sl2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    tl2 t = rl2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(ap4.b(e2));
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

    public final tl2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            tl2 tl2Var = this.i.get(str);
            if (tl2Var == null || !tl2Var.r(this)) {
                return null;
            }
            return tl2Var;
        }
        return (tl2) invokeL.objValue;
    }

    public final void f0(el4 el4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, el4Var) == null) {
            ye2.c().d(el4Var, new d(this, el4Var));
        }
    }

    @Override // com.baidu.tieba.xj4
    public wo4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.equals("so", str)) {
                return this;
            }
            return super.w(str);
        }
        return (wo4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xj4
    public void C(wk4 wk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wk4Var) == null) {
            super.C(wk4Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + wk4Var.toString());
            }
            e0(new Exception("failed by fetch error = " + wk4Var));
        }
    }

    @Override // com.baidu.tieba.xj4
    public void G(kp4 kp4Var) {
        int n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kp4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                if (kp4Var == null) {
                    n2 = 0;
                } else {
                    n2 = kp4Var.n();
                }
                sb.append(n2);
                Log.i(str, sb.toString());
            }
            super.G(kp4Var);
            if (kp4Var == null) {
                return;
            }
            this.f = kp4Var;
            if (!kp4Var.k()) {
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
            sl2 sl2Var = this.k;
            if (sl2Var != null) {
                sl2Var.b(exc);
            }
        }
    }

    @Override // com.baidu.tieba.wo4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((el4) jp4.j(jSONObject, new el4()));
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
            for (tl2 tl2Var : this.i.values()) {
                if (!tl2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + tl2Var);
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
            for (tl2 tl2Var : this.i.values()) {
                if (tl2Var != null && tl2Var.r(this) && !tl2Var.n() && !tl2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + tl2Var);
                    }
                    tl2Var.q();
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
                arrayList.add(xsb.d(new e(this)));
            }
            if (!arrayList.isEmpty()) {
                xsb.q(arrayList).D(b0());
            }
        }
    }

    public final void g0(el4 el4Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, el4Var) == null) {
            if (m) {
                Log.i(this.c, "SoNodeHandler updateBestSo start so=" + el4Var);
            }
            if (el4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            ap4 ap4Var = this.j.get(el4Var.g);
            if (ap4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by illegal bundleId=" + el4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(el4Var.p)) {
                el4Var.p = ap4Var.a;
            }
            tl2 a0 = a0(el4Var.p);
            if (a0 == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by no updating lib=" + el4Var.p);
                    return;
                }
                return;
            }
            if (el4Var.q == null) {
                el4Var.q = ap4Var.c;
            }
            if (!AbiType.currentAbi().compat(el4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            el4 l = a0.l();
            el4 j2 = a0.j();
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
            long j4 = el4Var.i;
            if (j4 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(el4Var.i)));
                }
            } else if (j4 > max) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by update bestVer=" + el4Var.i);
                }
                a0.w(this, el4Var);
            } else {
                if (j2 == null || !j2.q.compat(el4Var.q)) {
                    if (m) {
                        Log.i(this.c, "SoNodeHandler updateBestSo end by update abi update=" + el4Var.q);
                    }
                    a0.w(this, el4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.wo4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            uo4 uo4Var = new uo4();
            kp4 kp4Var = new kp4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !wp3.G() && b83.j() == 1) ? false : false) {
                String i = b83.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        el4 el4Var = (el4) jp4.j(new JSONObject(i), new el4());
                        el4Var.g = "so_zeus_armeabi";
                        g0(el4Var);
                        ub3.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1480)).G();
                    } catch (JSONException e2) {
                        ub3.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f147f)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (tl2 tl2Var : this.i.values()) {
                if (tl2Var.r(this)) {
                    g0(tl2Var.l());
                    el4 j = tl2Var.j();
                    if (tl2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        vo4.b(j, kp4Var);
                        if (uo4Var.d == null) {
                            uo4Var.d = new ArrayList();
                        }
                        uo4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        tl2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + kp4Var.n());
            }
            if (kp4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(kp4Var);
            nl4.e(uo4Var, this);
        }
    }
}
