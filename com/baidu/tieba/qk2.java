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
import com.baidu.tieba.ok2;
import com.baidu.tieba.ud2;
import com.baidu.tieba.y0c;
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
public final class qk2 extends ce2 implements vn4, sn4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public e1c<? super ak4> d;
    public e1c<ak4> e;
    public go4 f;
    public final em4 g;
    public pi4<ak4> h;
    public final Map<String, pk2> i;
    public final Map<String, wn4> j;
    public final ok2 k;
    public final im4<JSONArray> l;

    @Override // com.baidu.tieba.vn4
    public ti4 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (ti4) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements im4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qk2 a;

        public a(qk2 qk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qk2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.im4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray != null && !this.a.i.isEmpty()) {
                for (pk2 pk2Var : this.a.i.values()) {
                    if (pk2Var != null && pk2Var.r(this.a)) {
                        pk2Var.a(jSONArray);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements rp3<pk2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qk2 a;

        public b(qk2 qk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qk2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(pk2 pk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pk2Var) == null) {
                if (qk2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + pk2Var);
                }
                if (pk2Var != null) {
                    this.a.k.c(pk2Var.k(), pk2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements rp3<pk2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qk2 a;

        public c(qk2 qk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qk2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(pk2 pk2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pk2Var) == null) && pk2Var != null) {
                this.a.k.d(pk2Var.k(), pk2Var.m());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ud2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ak4 a;
        public final /* synthetic */ qk2 b;

        public d(qk2 qk2Var, ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk2Var, ak4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qk2Var;
            this.a = ak4Var;
        }

        @Override // com.baidu.tieba.ud2.c
        public void b(PMSDownloadType pMSDownloadType, rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, rm3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, rm3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ud2.c
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
    public class e implements y0c.a<ak4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qk2 a;

        public e(qk2 qk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qk2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.y0c.a, com.baidu.tieba.m1c
        public void call(e1c<? super ak4> e1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, e1cVar) != null) {
                return;
            }
            this.a.d = e1cVar;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends e1c<ak4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qk2 e;

        public f(qk2 qk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = qk2Var;
        }

        public /* synthetic */ f(qk2 qk2Var, a aVar) {
            this(qk2Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z0c
        /* renamed from: g */
        public void onNext(ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, ak4Var) == null) && qk2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + ak4Var.toString());
            }
        }

        @Override // com.baidu.tieba.z0c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (qk2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.z0c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (qk2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends mi4<ak4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qk2 a;

        public g(qk2 qk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qk2Var;
        }

        public /* synthetic */ g(qk2 qk2Var, a aVar) {
            this(qk2Var);
        }

        @Override // com.baidu.tieba.ri4
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
        @Override // com.baidu.tieba.pi4
        /* renamed from: l */
        public String d(ak4 ak4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ak4Var)) == null) {
                String g = nk2.d.g(ak4Var);
                if (qk2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + ak4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: q */
        public void a(ak4 ak4Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ak4Var) == null) {
                super.a(ak4Var);
                wn4 wn4Var = (wn4) this.a.j.get(ak4Var.g);
                qk2 qk2Var = this.a;
                if (wn4Var == null) {
                    str = null;
                } else {
                    str = wn4Var.a;
                }
                pk2 a0 = qk2Var.a0(str);
                if (a0 != null) {
                    a0.x(new ok2.b(ak4Var.b, ak4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: r */
        public void c(ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, ak4Var) == null) {
                super.c(ak4Var);
                if (qk2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + ak4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: s */
        public void f(ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, ak4Var) == null) {
                super.f(ak4Var);
                if (qk2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + ak4Var.g);
                }
                this.a.f0(ak4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: o */
        public void e(ak4 ak4Var, sj4 sj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ak4Var, sj4Var) == null) {
                super.e(ak4Var, sj4Var);
                if (qk2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + ak4Var.g + " err=" + sj4Var);
                }
                this.a.f.l(ak4Var);
                rm3 rm3Var = new rm3();
                rm3Var.k(13L);
                rm3Var.i(sj4Var.a);
                rm3Var.d("so包下载失败");
                rm3Var.f(sj4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(ak4Var, rm3Var));
                }
                ud2.c().a(ak4Var, qk2.o, rm3Var);
                cr4.k(ak4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: p */
        public void i(ak4 ak4Var) {
            wn4 wn4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ak4Var) == null) {
                super.i(ak4Var);
                if (qk2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + ak4Var);
                }
                String str2 = ak4Var.p;
                if (TextUtils.isEmpty(str2) && (wn4Var = (wn4) this.a.j.get(ak4Var.g)) != null) {
                    str2 = wn4Var.a;
                }
                pk2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = lo3.a(new File(ak4Var.a), ak4Var.m);
                    if (qk2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + ak4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (qk2.m && !so3.G() && x63.j() == 1) ? false : false;
                    if (a || z) {
                        vi4.i().m(ak4Var);
                        if (qk2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(ak4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(ak4Var);
                    this.a.d.onCompleted();
                }
                ud2.c().b(ak4Var, qk2.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948094641, "Lcom/baidu/tieba/qk2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948094641, "Lcom/baidu/tieba/qk2;");
                return;
            }
        }
        m = ir1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    @Override // com.baidu.tieba.ti4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.ti4
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

    public final e1c<ak4> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (e1c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vn4
    public im4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (im4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vn4
    @Nullable
    public em4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (em4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti4
    public pi4<ak4> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (pi4) invokeV.objValue;
    }

    public qk2(em4 em4Var, ok2 ok2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {em4Var, ok2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + ok2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = em4Var;
        this.k = ok2Var;
        if (ok2Var != null) {
            Iterator<String> it = ok2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                lk2 a2 = mk2.a(next);
                if (a2 == null) {
                    ok2Var.c(next, false);
                } else if (a2.f()) {
                    ok2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    pk2 t = nk2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(wn4.b(e2));
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

    public final pk2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            pk2 pk2Var = this.i.get(str);
            if (pk2Var == null || !pk2Var.r(this)) {
                return null;
            }
            return pk2Var;
        }
        return (pk2) invokeL.objValue;
    }

    public final void f0(ak4 ak4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ak4Var) == null) {
            ud2.c().d(ak4Var, new d(this, ak4Var));
        }
    }

    @Override // com.baidu.tieba.ti4
    public sn4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.equals("so", str)) {
                return this;
            }
            return super.w(str);
        }
        return (sn4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ti4
    public void C(sj4 sj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sj4Var) == null) {
            super.C(sj4Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + sj4Var.toString());
            }
            e0(new Exception("failed by fetch error = " + sj4Var));
        }
    }

    @Override // com.baidu.tieba.ti4
    public void G(go4 go4Var) {
        int n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, go4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                if (go4Var == null) {
                    n2 = 0;
                } else {
                    n2 = go4Var.n();
                }
                sb.append(n2);
                Log.i(str, sb.toString());
            }
            super.G(go4Var);
            if (go4Var == null) {
                return;
            }
            this.f = go4Var;
            if (!go4Var.k()) {
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
            ok2 ok2Var = this.k;
            if (ok2Var != null) {
                ok2Var.b(exc);
            }
        }
    }

    @Override // com.baidu.tieba.sn4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((ak4) fo4.j(jSONObject, new ak4()));
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
            for (pk2 pk2Var : this.i.values()) {
                if (!pk2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + pk2Var);
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
            for (pk2 pk2Var : this.i.values()) {
                if (pk2Var != null && pk2Var.r(this) && !pk2Var.n() && !pk2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + pk2Var);
                    }
                    pk2Var.q();
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
                arrayList.add(y0c.d(new e(this)));
            }
            if (!arrayList.isEmpty()) {
                y0c.q(arrayList).F(b0());
            }
        }
    }

    public final void g0(ak4 ak4Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ak4Var) == null) {
            if (m) {
                Log.i(this.c, "SoNodeHandler updateBestSo start so=" + ak4Var);
            }
            if (ak4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            wn4 wn4Var = this.j.get(ak4Var.g);
            if (wn4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by illegal bundleId=" + ak4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(ak4Var.p)) {
                ak4Var.p = wn4Var.a;
            }
            pk2 a0 = a0(ak4Var.p);
            if (a0 == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by no updating lib=" + ak4Var.p);
                    return;
                }
                return;
            }
            if (ak4Var.q == null) {
                ak4Var.q = wn4Var.c;
            }
            if (!AbiType.currentAbi().compat(ak4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            ak4 l = a0.l();
            ak4 j2 = a0.j();
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
            long j4 = ak4Var.i;
            if (j4 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(ak4Var.i)));
                }
            } else if (j4 > max) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by update bestVer=" + ak4Var.i);
                }
                a0.w(this, ak4Var);
            } else {
                if (j2 == null || !j2.q.compat(ak4Var.q)) {
                    if (m) {
                        Log.i(this.c, "SoNodeHandler updateBestSo end by update abi update=" + ak4Var.q);
                    }
                    a0.w(this, ak4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.sn4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            qn4 qn4Var = new qn4();
            go4 go4Var = new go4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !so3.G() && x63.j() == 1) ? false : false) {
                String i = x63.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        ak4 ak4Var = (ak4) fo4.j(new JSONObject(i), new ak4());
                        ak4Var.g = "so_zeus_armeabi";
                        g0(ak4Var);
                        qa3.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f149a)).G();
                    } catch (JSONException e2) {
                        qa3.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1499)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (pk2 pk2Var : this.i.values()) {
                if (pk2Var.r(this)) {
                    g0(pk2Var.l());
                    ak4 j = pk2Var.j();
                    if (pk2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        rn4.b(j, go4Var);
                        if (qn4Var.d == null) {
                            qn4Var.d = new ArrayList();
                        }
                        qn4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        pk2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + go4Var.n());
            }
            if (go4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(go4Var);
            jk4.e(qn4Var, this);
        }
    }
}
