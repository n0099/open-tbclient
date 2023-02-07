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
import com.baidu.tieba.mi2;
import com.baidu.tieba.sb2;
import com.baidu.tieba.tca;
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
/* loaded from: classes5.dex */
public final class oi2 extends ac2 implements tl4, ql4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public zca<? super yh4> d;
    public zca<yh4> e;
    public em4 f;
    public final ck4 g;
    public ng4<yh4> h;
    public final Map<String, ni2> i;
    public final Map<String, ul4> j;
    public final mi2 k;
    public final gk4<JSONArray> l;

    @Override // com.baidu.tieba.tl4
    public rg4 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (rg4) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements gk4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi2 a;

        public a(oi2 oi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gk4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray != null && !this.a.i.isEmpty()) {
                for (ni2 ni2Var : this.a.i.values()) {
                    if (ni2Var != null && ni2Var.r(this.a)) {
                        ni2Var.a(jSONArray);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements pn3<ni2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi2 a;

        public b(oi2 oi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pn3
        /* renamed from: b */
        public void a(ni2 ni2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ni2Var) == null) {
                if (oi2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + ni2Var);
                }
                if (ni2Var != null) {
                    this.a.k.c(ni2Var.k(), ni2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements pn3<ni2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi2 a;

        public c(oi2 oi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pn3
        /* renamed from: b */
        public void a(ni2 ni2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ni2Var) == null) && ni2Var != null) {
                this.a.k.d(ni2Var.k(), ni2Var.m());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements sb2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yh4 a;
        public final /* synthetic */ oi2 b;

        public d(oi2 oi2Var, yh4 yh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi2Var, yh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oi2Var;
            this.a = yh4Var;
        }

        @Override // com.baidu.tieba.sb2.c
        public void b(PMSDownloadType pMSDownloadType, pk3 pk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, pk3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, pk3Var));
                }
            }
        }

        @Override // com.baidu.tieba.sb2.c
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

    /* loaded from: classes5.dex */
    public class e implements tca.a<yh4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi2 a;

        public e(oi2 oi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tca.a, com.baidu.tieba.hda
        public void call(zca<? super yh4> zcaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, zcaVar) != null) {
                return;
            }
            this.a.d = zcaVar;
        }
    }

    /* loaded from: classes5.dex */
    public class f extends zca<yh4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi2 e;

        public f(oi2 oi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = oi2Var;
        }

        public /* synthetic */ f(oi2 oi2Var, a aVar) {
            this(oi2Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.uca
        /* renamed from: g */
        public void onNext(yh4 yh4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, yh4Var) == null) && oi2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + yh4Var.toString());
            }
        }

        @Override // com.baidu.tieba.uca
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (oi2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.uca
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (oi2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends kg4<yh4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi2 a;

        public g(oi2 oi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi2Var;
        }

        public /* synthetic */ g(oi2 oi2Var, a aVar) {
            this(oi2Var);
        }

        @Override // com.baidu.tieba.pg4
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
        @Override // com.baidu.tieba.ng4
        /* renamed from: l */
        public String d(yh4 yh4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, yh4Var)) == null) {
                String g = li2.d.g(yh4Var);
                if (oi2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + yh4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
        /* renamed from: q */
        public void a(yh4 yh4Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, yh4Var) == null) {
                super.a(yh4Var);
                ul4 ul4Var = (ul4) this.a.j.get(yh4Var.g);
                oi2 oi2Var = this.a;
                if (ul4Var == null) {
                    str = null;
                } else {
                    str = ul4Var.a;
                }
                ni2 a0 = oi2Var.a0(str);
                if (a0 != null) {
                    a0.x(new mi2.b(yh4Var.b, yh4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
        /* renamed from: r */
        public void c(yh4 yh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, yh4Var) == null) {
                super.c(yh4Var);
                if (oi2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + yh4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
        /* renamed from: s */
        public void f(yh4 yh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, yh4Var) == null) {
                super.f(yh4Var);
                if (oi2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + yh4Var.g);
                }
                this.a.f0(yh4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
        /* renamed from: o */
        public void e(yh4 yh4Var, qh4 qh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yh4Var, qh4Var) == null) {
                super.e(yh4Var, qh4Var);
                if (oi2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + yh4Var.g + " err=" + qh4Var);
                }
                this.a.f.l(yh4Var);
                pk3 pk3Var = new pk3();
                pk3Var.k(13L);
                pk3Var.i(qh4Var.a);
                pk3Var.d("so包下载失败");
                pk3Var.f(qh4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(yh4Var, pk3Var));
                }
                sb2.c().a(yh4Var, oi2.o, pk3Var);
                ap4.k(yh4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
        /* renamed from: p */
        public void i(yh4 yh4Var) {
            ul4 ul4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, yh4Var) == null) {
                super.i(yh4Var);
                if (oi2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + yh4Var);
                }
                String str2 = yh4Var.p;
                if (TextUtils.isEmpty(str2) && (ul4Var = (ul4) this.a.j.get(yh4Var.g)) != null) {
                    str2 = ul4Var.a;
                }
                ni2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = jm3.a(new File(yh4Var.a), yh4Var.m);
                    if (oi2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + yh4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (oi2.m && !qm3.G() && v43.j() == 1) ? false : false;
                    if (a || z) {
                        tg4.i().m(yh4Var);
                        if (oi2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(yh4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(yh4Var);
                    this.a.d.onCompleted();
                }
                sb2.c().b(yh4Var, oi2.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948033137, "Lcom/baidu/tieba/oi2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948033137, "Lcom/baidu/tieba/oi2;");
                return;
            }
        }
        m = gp1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    @Override // com.baidu.tieba.rg4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.rg4
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

    public final zca<yh4> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (zca) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tl4
    public gk4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (gk4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tl4
    @Nullable
    public ck4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (ck4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rg4
    public ng4<yh4> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (ng4) invokeV.objValue;
    }

    public oi2(ck4 ck4Var, mi2 mi2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ck4Var, mi2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + mi2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = ck4Var;
        this.k = mi2Var;
        if (mi2Var != null) {
            Iterator<String> it = mi2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                ji2 a2 = ki2.a(next);
                if (a2 == null) {
                    mi2Var.c(next, false);
                } else if (a2.f()) {
                    mi2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    ni2 t = li2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(ul4.b(e2));
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

    public final ni2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            ni2 ni2Var = this.i.get(str);
            if (ni2Var == null || !ni2Var.r(this)) {
                return null;
            }
            return ni2Var;
        }
        return (ni2) invokeL.objValue;
    }

    public final void f0(yh4 yh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, yh4Var) == null) {
            sb2.c().d(yh4Var, new d(this, yh4Var));
        }
    }

    @Override // com.baidu.tieba.rg4
    public ql4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.equals("so", str)) {
                return this;
            }
            return super.w(str);
        }
        return (ql4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rg4
    public void C(qh4 qh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qh4Var) == null) {
            super.C(qh4Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + qh4Var.toString());
            }
            e0(new Exception("failed by fetch error = " + qh4Var));
        }
    }

    @Override // com.baidu.tieba.rg4
    public void G(em4 em4Var) {
        int n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, em4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                if (em4Var == null) {
                    n2 = 0;
                } else {
                    n2 = em4Var.n();
                }
                sb.append(n2);
                Log.i(str, sb.toString());
            }
            super.G(em4Var);
            if (em4Var == null) {
                return;
            }
            this.f = em4Var;
            if (!em4Var.k()) {
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
            mi2 mi2Var = this.k;
            if (mi2Var != null) {
                mi2Var.b(exc);
            }
        }
    }

    @Override // com.baidu.tieba.ql4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((yh4) dm4.j(jSONObject, new yh4()));
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
            for (ni2 ni2Var : this.i.values()) {
                if (!ni2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + ni2Var);
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
            for (ni2 ni2Var : this.i.values()) {
                if (ni2Var != null && ni2Var.r(this) && !ni2Var.n() && !ni2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + ni2Var);
                    }
                    ni2Var.q();
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
                arrayList.add(tca.a(new e(this)));
            }
            if (!arrayList.isEmpty()) {
                tca.i(arrayList).u(b0());
            }
        }
    }

    public final void g0(yh4 yh4Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, yh4Var) == null) {
            if (m) {
                Log.i(this.c, "SoNodeHandler updateBestSo start so=" + yh4Var);
            }
            if (yh4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            ul4 ul4Var = this.j.get(yh4Var.g);
            if (ul4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by illegal bundleId=" + yh4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(yh4Var.p)) {
                yh4Var.p = ul4Var.a;
            }
            ni2 a0 = a0(yh4Var.p);
            if (a0 == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by no updating lib=" + yh4Var.p);
                    return;
                }
                return;
            }
            if (yh4Var.q == null) {
                yh4Var.q = ul4Var.c;
            }
            if (!AbiType.currentAbi().compat(yh4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            yh4 l = a0.l();
            yh4 j2 = a0.j();
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
            long j4 = yh4Var.i;
            if (j4 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(yh4Var.i)));
                }
            } else if (j4 > max) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by update bestVer=" + yh4Var.i);
                }
                a0.w(this, yh4Var);
            } else {
                if (j2 == null || !j2.q.compat(yh4Var.q)) {
                    if (m) {
                        Log.i(this.c, "SoNodeHandler updateBestSo end by update abi update=" + yh4Var.q);
                    }
                    a0.w(this, yh4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.ql4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ol4 ol4Var = new ol4();
            em4 em4Var = new em4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !qm3.G() && v43.j() == 1) ? false : false) {
                String i = v43.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        yh4 yh4Var = (yh4) dm4.j(new JSONObject(i), new yh4());
                        yh4Var.g = "so_zeus_armeabi";
                        g0(yh4Var);
                        o83.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f12fe)).G();
                    } catch (JSONException e2) {
                        o83.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f12fd)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (ni2 ni2Var : this.i.values()) {
                if (ni2Var.r(this)) {
                    g0(ni2Var.l());
                    yh4 j = ni2Var.j();
                    if (ni2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        pl4.b(j, em4Var);
                        if (ol4Var.d == null) {
                            ol4Var.d = new ArrayList();
                        }
                        ol4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        ni2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + em4Var.n());
            }
            if (em4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(em4Var);
            hi4.e(ol4Var, this);
        }
    }
}
