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
import com.baidu.tieba.qa2;
import com.baidu.tieba.w32;
import com.baidu.tieba.yu9;
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
public final class sa2 extends e42 implements vd4, sd4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public ev9<? super aa4> d;
    public ev9<aa4> e;
    public ge4 f;
    public final ec4 g;
    public p84<aa4> h;
    public final Map<String, ra2> i;
    public final Map<String, wd4> j;
    public final qa2 k;
    public final ic4<JSONArray> l;

    /* loaded from: classes5.dex */
    public class a implements ic4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa2 a;

        public a(sa2 sa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ic4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null || this.a.i.isEmpty()) {
                return;
            }
            for (ra2 ra2Var : this.a.i.values()) {
                if (ra2Var != null && ra2Var.r(this.a)) {
                    ra2Var.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements tf3<ra2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa2 a;

        public b(sa2 sa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tf3
        /* renamed from: b */
        public void a(ra2 ra2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ra2Var) == null) {
                if (sa2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + ra2Var);
                }
                if (ra2Var != null) {
                    this.a.k.c(ra2Var.k(), ra2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements tf3<ra2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa2 a;

        public c(sa2 sa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tf3
        /* renamed from: b */
        public void a(ra2 ra2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ra2Var) == null) || ra2Var == null) {
                return;
            }
            this.a.k.d(ra2Var.k(), ra2Var.m());
        }
    }

    /* loaded from: classes5.dex */
    public class d implements w32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa4 a;
        public final /* synthetic */ sa2 b;

        public d(sa2 sa2Var, aa4 aa4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sa2Var, aa4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sa2Var;
            this.a = aa4Var;
        }

        @Override // com.baidu.tieba.w32.c
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

        @Override // com.baidu.tieba.w32.c
        public void b(PMSDownloadType pMSDownloadType, tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, tc3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, tc3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements yu9.a<aa4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa2 a;

        public e(sa2 sa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yu9.a, com.baidu.tieba.mv9
        public void call(ev9<? super aa4> ev9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ev9Var) == null) {
                this.a.d = ev9Var;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends ev9<aa4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa2 e;

        public f(sa2 sa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = sa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zu9
        /* renamed from: g */
        public void onNext(aa4 aa4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, aa4Var) == null) && sa2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + aa4Var.toString());
            }
        }

        @Override // com.baidu.tieba.zu9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (sa2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }

        @Override // com.baidu.tieba.zu9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (sa2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        public /* synthetic */ f(sa2 sa2Var, a aVar) {
            this(sa2Var);
        }
    }

    /* loaded from: classes5.dex */
    public class g extends m84<aa4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa2 a;

        public g(sa2 sa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p84
        /* renamed from: l */
        public String d(aa4 aa4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aa4Var)) == null) {
                String g = pa2.d.g(aa4Var);
                if (sa2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + aa4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.r84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: o */
        public void e(aa4 aa4Var, s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aa4Var, s94Var) == null) {
                super.e(aa4Var, s94Var);
                if (sa2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + aa4Var.g + " err=" + s94Var);
                }
                this.a.f.l(aa4Var);
                tc3 tc3Var = new tc3();
                tc3Var.k(13L);
                tc3Var.i(s94Var.a);
                tc3Var.d("so包下载失败");
                tc3Var.f(s94Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(aa4Var, tc3Var));
                }
                w32.c().a(aa4Var, sa2.o, tc3Var);
                ch4.k(aa4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: p */
        public void i(aa4 aa4Var) {
            wd4 wd4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, aa4Var) == null) {
                super.i(aa4Var);
                if (sa2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + aa4Var);
                }
                String str2 = aa4Var.p;
                if (TextUtils.isEmpty(str2) && (wd4Var = (wd4) this.a.j.get(aa4Var.g)) != null) {
                    str2 = wd4Var.a;
                }
                ra2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = ne3.a(new File(aa4Var.a), aa4Var.m);
                    if (sa2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + aa4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (sa2.m && !ue3.G() && zw2.j() == 1) ? false : false;
                    if (a || z) {
                        v84.i().m(aa4Var);
                        if (sa2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(aa4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(aa4Var);
                    this.a.d.onCompleted();
                }
                w32.c().b(aa4Var, sa2.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: q */
        public void a(aa4 aa4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, aa4Var) == null) {
                super.a(aa4Var);
                wd4 wd4Var = (wd4) this.a.j.get(aa4Var.g);
                ra2 a0 = this.a.a0(wd4Var == null ? null : wd4Var.a);
                if (a0 != null) {
                    a0.x(new qa2.b(aa4Var.b, aa4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: r */
        public void c(aa4 aa4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, aa4Var) == null) {
                super.c(aa4Var);
                if (sa2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + aa4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: s */
        public void f(aa4 aa4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, aa4Var) == null) {
                super.f(aa4Var);
                if (sa2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + aa4Var.g);
                }
                this.a.f0(aa4Var);
            }
        }

        public /* synthetic */ g(sa2 sa2Var, a aVar) {
            this(sa2Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948144613, "Lcom/baidu/tieba/sa2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948144613, "Lcom/baidu/tieba/sa2;");
                return;
            }
        }
        m = kh1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    public sa2(ec4 ec4Var, qa2 qa2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec4Var, qa2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + qa2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = ec4Var;
        this.k = qa2Var;
        if (qa2Var != null) {
            Iterator<String> it = qa2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                na2 a2 = oa2.a(next);
                if (a2 == null) {
                    qa2Var.c(next, false);
                } else if (a2.f()) {
                    qa2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    ra2 t = pa2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(wd4.b(e2));
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

    @Override // com.baidu.tieba.t84
    public void C(s94 s94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, s94Var) == null) {
            super.C(s94Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + s94Var.toString());
            }
            e0(new Exception("failed by fetch error = " + s94Var));
        }
    }

    @Override // com.baidu.tieba.t84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.t84
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

    @Override // com.baidu.tieba.t84
    public void G(ge4 ge4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ge4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                sb.append(ge4Var == null ? 0 : ge4Var.n());
                Log.i(str, sb.toString());
            }
            super.G(ge4Var);
            if (ge4Var == null) {
                return;
            }
            this.f = ge4Var;
            if (ge4Var.k()) {
                return;
            }
            c0();
        }
    }

    public final void Z(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "finishWithUpdatingCheck: updatings=" + this.i.size() + " e=" + exc);
            }
            for (ra2 ra2Var : this.i.values()) {
                if (!ra2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + ra2Var);
                        return;
                    }
                    return;
                }
            }
            d0(exc);
        }
    }

    public final ra2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            ra2 ra2Var = this.i.get(str);
            if (ra2Var == null || !ra2Var.r(this)) {
                return null;
            }
            return ra2Var;
        }
        return (ra2) invokeL.objValue;
    }

    public final ev9<aa4> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (ev9) invokeV.objValue;
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f.g()) {
                arrayList.add(yu9.a(new e(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            yu9.i(arrayList).u(b0());
        }
    }

    public final void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
            }
            qa2 qa2Var = this.k;
            if (qa2Var != null) {
                qa2Var.b(exc);
            }
        }
    }

    public final void e0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "notifyPmsFinish: updatings=" + this.i.size() + " e=" + exc);
            }
            for (ra2 ra2Var : this.i.values()) {
                if (ra2Var != null && ra2Var.r(this) && !ra2Var.n() && !ra2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + ra2Var);
                    }
                    ra2Var.q();
                }
            }
            Z(exc);
        }
    }

    public final void f0(aa4 aa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aa4Var) == null) {
            w32.c().d(aa4Var, new d(this, aa4Var));
        }
    }

    @Override // com.baidu.tieba.vd4
    public ic4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : (ic4) invokeV.objValue;
    }

    public final void g0(aa4 aa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aa4Var) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler updateBestSo start so=" + aa4Var);
            }
            if (aa4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            wd4 wd4Var = this.j.get(aa4Var.g);
            if (wd4Var == null) {
                if (m) {
                    String str2 = this.c;
                    Log.i(str2, "SoNodeHandler updateBestSo end by illegal bundleId=" + aa4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(aa4Var.p)) {
                aa4Var.p = wd4Var.a;
            }
            ra2 a0 = a0(aa4Var.p);
            if (a0 == null) {
                if (m) {
                    String str3 = this.c;
                    Log.i(str3, "SoNodeHandler updateBestSo end by no updating lib=" + aa4Var.p);
                    return;
                }
                return;
            }
            if (aa4Var.q == null) {
                aa4Var.q = wd4Var.c;
            }
            if (!AbiType.currentAbi().compat(aa4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            aa4 l = a0.l();
            aa4 j = a0.j();
            long max = Math.max(j != null ? j.i : 0L, l == null ? 0L : l.i);
            long j2 = aa4Var.i;
            if (j2 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(aa4Var.i)));
                }
            } else if (j2 > max) {
                if (m) {
                    String str4 = this.c;
                    Log.i(str4, "SoNodeHandler updateBestSo end by update bestVer=" + aa4Var.i);
                }
                a0.w(this, aa4Var);
            } else {
                if (j == null || !j.q.compat(aa4Var.q)) {
                    if (m) {
                        String str5 = this.c;
                        Log.i(str5, "SoNodeHandler updateBestSo end by update abi update=" + aa4Var.q);
                    }
                    a0.w(this, aa4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.vd4
    public t84 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (t84) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vd4
    @Nullable
    public ec4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.g : (ec4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sd4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((aa4) fe4.j(jSONObject, new aa4()));
            }
        }
    }

    @Override // com.baidu.tieba.sd4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            qd4 qd4Var = new qd4();
            ge4 ge4Var = new ge4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !ue3.G() && zw2.j() == 1) ? false : false) {
                String i = zw2.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        aa4 aa4Var = (aa4) fe4.j(new JSONObject(i), new aa4());
                        aa4Var.g = "so_zeus_armeabi";
                        g0(aa4Var);
                        s03.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1235)).G();
                    } catch (JSONException e2) {
                        s03.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1234)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (ra2 ra2Var : this.i.values()) {
                if (ra2Var.r(this)) {
                    g0(ra2Var.l());
                    aa4 j = ra2Var.j();
                    if (ra2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        rd4.b(j, ge4Var);
                        if (qd4Var.d == null) {
                            qd4Var.d = new ArrayList();
                        }
                        qd4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        ra2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + ge4Var.n());
            }
            if (ge4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(ge4Var);
            ja4.e(qd4Var, this);
        }
    }

    @Override // com.baidu.tieba.t84
    public sd4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? TextUtils.equals("so", str) ? this : super.w(str) : (sd4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.t84
    public p84<aa4> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (p84) invokeV.objValue;
    }
}
