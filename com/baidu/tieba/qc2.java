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
import com.baidu.tieba.oc2;
import com.baidu.tieba.qw9;
import com.baidu.tieba.u52;
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
public final class qc2 extends c62 implements vf4, sf4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public ww9<? super ac4> d;
    public ww9<ac4> e;
    public gg4 f;
    public final ee4 g;
    public pa4<ac4> h;
    public final Map<String, pc2> i;
    public final Map<String, wf4> j;
    public final oc2 k;
    public final ie4<JSONArray> l;

    /* loaded from: classes5.dex */
    public class a implements ie4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc2 a;

        public a(qc2 qc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ie4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null || this.a.i.isEmpty()) {
                return;
            }
            for (pc2 pc2Var : this.a.i.values()) {
                if (pc2Var != null && pc2Var.r(this.a)) {
                    pc2Var.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements rh3<pc2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc2 a;

        public b(qc2 qc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(pc2 pc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pc2Var) == null) {
                if (qc2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + pc2Var);
                }
                if (pc2Var != null) {
                    this.a.k.c(pc2Var.k(), pc2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements rh3<pc2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc2 a;

        public c(qc2 qc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(pc2 pc2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pc2Var) == null) || pc2Var == null) {
                return;
            }
            this.a.k.d(pc2Var.k(), pc2Var.m());
        }
    }

    /* loaded from: classes5.dex */
    public class d implements u52.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ac4 a;
        public final /* synthetic */ qc2 b;

        public d(qc2 qc2Var, ac4 ac4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc2Var, ac4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qc2Var;
            this.a = ac4Var;
        }

        @Override // com.baidu.tieba.u52.c
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

        @Override // com.baidu.tieba.u52.c
        public void b(PMSDownloadType pMSDownloadType, re3 re3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, re3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, re3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements qw9.a<ac4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc2 a;

        public e(qc2 qc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qw9.a, com.baidu.tieba.ex9
        public void call(ww9<? super ac4> ww9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ww9Var) == null) {
                this.a.d = ww9Var;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends ww9<ac4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc2 e;

        public f(qc2 qc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = qc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rw9
        /* renamed from: g */
        public void onNext(ac4 ac4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, ac4Var) == null) && qc2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + ac4Var.toString());
            }
        }

        @Override // com.baidu.tieba.rw9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (qc2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }

        @Override // com.baidu.tieba.rw9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (qc2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        public /* synthetic */ f(qc2 qc2Var, a aVar) {
            this(qc2Var);
        }
    }

    /* loaded from: classes5.dex */
    public class g extends ma4<ac4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc2 a;

        public g(qc2 qc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pa4
        /* renamed from: l */
        public String d(ac4 ac4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ac4Var)) == null) {
                String g = nc2.d.g(ac4Var);
                if (qc2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + ac4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ra4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: o */
        public void e(ac4 ac4Var, sb4 sb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ac4Var, sb4Var) == null) {
                super.e(ac4Var, sb4Var);
                if (qc2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + ac4Var.g + " err=" + sb4Var);
                }
                this.a.f.l(ac4Var);
                re3 re3Var = new re3();
                re3Var.k(13L);
                re3Var.i(sb4Var.a);
                re3Var.d("so包下载失败");
                re3Var.f(sb4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(ac4Var, re3Var));
                }
                u52.c().a(ac4Var, qc2.o, re3Var);
                cj4.k(ac4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: p */
        public void i(ac4 ac4Var) {
            wf4 wf4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ac4Var) == null) {
                super.i(ac4Var);
                if (qc2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + ac4Var);
                }
                String str2 = ac4Var.p;
                if (TextUtils.isEmpty(str2) && (wf4Var = (wf4) this.a.j.get(ac4Var.g)) != null) {
                    str2 = wf4Var.a;
                }
                pc2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = lg3.a(new File(ac4Var.a), ac4Var.m);
                    if (qc2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + ac4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (qc2.m && !sg3.G() && xy2.j() == 1) ? false : false;
                    if (a || z) {
                        va4.i().m(ac4Var);
                        if (qc2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(ac4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(ac4Var);
                    this.a.d.onCompleted();
                }
                u52.c().b(ac4Var, qc2.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: q */
        public void a(ac4 ac4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ac4Var) == null) {
                super.a(ac4Var);
                wf4 wf4Var = (wf4) this.a.j.get(ac4Var.g);
                pc2 a0 = this.a.a0(wf4Var == null ? null : wf4Var.a);
                if (a0 != null) {
                    a0.x(new oc2.b(ac4Var.b, ac4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: r */
        public void c(ac4 ac4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, ac4Var) == null) {
                super.c(ac4Var);
                if (qc2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + ac4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: s */
        public void f(ac4 ac4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, ac4Var) == null) {
                super.f(ac4Var);
                if (qc2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + ac4Var.g);
                }
                this.a.f0(ac4Var);
            }
        }

        public /* synthetic */ g(qc2 qc2Var, a aVar) {
            this(qc2Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948086953, "Lcom/baidu/tieba/qc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948086953, "Lcom/baidu/tieba/qc2;");
                return;
            }
        }
        m = ij1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    public qc2(ee4 ee4Var, oc2 oc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ee4Var, oc2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + oc2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = ee4Var;
        this.k = oc2Var;
        if (oc2Var != null) {
            Iterator<String> it = oc2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                lc2 a2 = mc2.a(next);
                if (a2 == null) {
                    oc2Var.c(next, false);
                } else if (a2.f()) {
                    oc2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    pc2 t = nc2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(wf4.b(e2));
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

    @Override // com.baidu.tieba.ta4
    public void C(sb4 sb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sb4Var) == null) {
            super.C(sb4Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + sb4Var.toString());
            }
            e0(new Exception("failed by fetch error = " + sb4Var));
        }
    }

    @Override // com.baidu.tieba.ta4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.ta4
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

    @Override // com.baidu.tieba.ta4
    public void G(gg4 gg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gg4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                sb.append(gg4Var == null ? 0 : gg4Var.n());
                Log.i(str, sb.toString());
            }
            super.G(gg4Var);
            if (gg4Var == null) {
                return;
            }
            this.f = gg4Var;
            if (gg4Var.k()) {
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
            for (pc2 pc2Var : this.i.values()) {
                if (!pc2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + pc2Var);
                        return;
                    }
                    return;
                }
            }
            d0(exc);
        }
    }

    public final pc2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            pc2 pc2Var = this.i.get(str);
            if (pc2Var == null || !pc2Var.r(this)) {
                return null;
            }
            return pc2Var;
        }
        return (pc2) invokeL.objValue;
    }

    public final ww9<ac4> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (ww9) invokeV.objValue;
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.f.g()) {
                arrayList.add(qw9.a(new e(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            qw9.i(arrayList).u(b0());
        }
    }

    public final void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
            }
            oc2 oc2Var = this.k;
            if (oc2Var != null) {
                oc2Var.b(exc);
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
            for (pc2 pc2Var : this.i.values()) {
                if (pc2Var != null && pc2Var.r(this) && !pc2Var.n() && !pc2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + pc2Var);
                    }
                    pc2Var.q();
                }
            }
            Z(exc);
        }
    }

    public final void f0(ac4 ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ac4Var) == null) {
            u52.c().d(ac4Var, new d(this, ac4Var));
        }
    }

    @Override // com.baidu.tieba.vf4
    public ie4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : (ie4) invokeV.objValue;
    }

    public final void g0(ac4 ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ac4Var) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler updateBestSo start so=" + ac4Var);
            }
            if (ac4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            wf4 wf4Var = this.j.get(ac4Var.g);
            if (wf4Var == null) {
                if (m) {
                    String str2 = this.c;
                    Log.i(str2, "SoNodeHandler updateBestSo end by illegal bundleId=" + ac4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(ac4Var.p)) {
                ac4Var.p = wf4Var.a;
            }
            pc2 a0 = a0(ac4Var.p);
            if (a0 == null) {
                if (m) {
                    String str3 = this.c;
                    Log.i(str3, "SoNodeHandler updateBestSo end by no updating lib=" + ac4Var.p);
                    return;
                }
                return;
            }
            if (ac4Var.q == null) {
                ac4Var.q = wf4Var.c;
            }
            if (!AbiType.currentAbi().compat(ac4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            ac4 l = a0.l();
            ac4 j = a0.j();
            long max = Math.max(j != null ? j.i : 0L, l == null ? 0L : l.i);
            long j2 = ac4Var.i;
            if (j2 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(ac4Var.i)));
                }
            } else if (j2 > max) {
                if (m) {
                    String str4 = this.c;
                    Log.i(str4, "SoNodeHandler updateBestSo end by update bestVer=" + ac4Var.i);
                }
                a0.w(this, ac4Var);
            } else {
                if (j == null || !j.q.compat(ac4Var.q)) {
                    if (m) {
                        String str5 = this.c;
                        Log.i(str5, "SoNodeHandler updateBestSo end by update abi update=" + ac4Var.q);
                    }
                    a0.w(this, ac4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.vf4
    public ta4 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (ta4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vf4
    @Nullable
    public ee4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.g : (ee4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sf4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((ac4) fg4.j(jSONObject, new ac4()));
            }
        }
    }

    @Override // com.baidu.tieba.sf4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            qf4 qf4Var = new qf4();
            gg4 gg4Var = new gg4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !sg3.G() && xy2.j() == 1) ? false : false) {
                String i = xy2.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        ac4 ac4Var = (ac4) fg4.j(new JSONObject(i), new ac4());
                        ac4Var.g = "so_zeus_armeabi";
                        g0(ac4Var);
                        q23.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1253)).G();
                    } catch (JSONException e2) {
                        q23.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1252)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (pc2 pc2Var : this.i.values()) {
                if (pc2Var.r(this)) {
                    g0(pc2Var.l());
                    ac4 j = pc2Var.j();
                    if (pc2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        rf4.b(j, gg4Var);
                        if (qf4Var.d == null) {
                            qf4Var.d = new ArrayList();
                        }
                        qf4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        pc2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + gg4Var.n());
            }
            if (gg4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(gg4Var);
            jc4.e(qf4Var, this);
        }
    }

    @Override // com.baidu.tieba.ta4
    public sf4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? TextUtils.equals("so", str) ? this : super.w(str) : (sf4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ta4
    public pa4<ac4> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (pa4) invokeV.objValue;
    }
}
