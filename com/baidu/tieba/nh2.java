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
import com.baidu.tieba.lh2;
import com.baidu.tieba.n1b;
import com.baidu.tieba.ra2;
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
public final class nh2 extends za2 implements sk4, pk4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static int n;
    public static final PMSDownloadType o;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public t1b<? super xg4> d;
    public t1b<xg4> e;
    public dl4 f;
    public final bj4 g;
    public mf4<xg4> h;
    public final Map<String, mh2> i;
    public final Map<String, tk4> j;
    public final lh2 k;
    public final fj4<JSONArray> l;

    @Override // com.baidu.tieba.sk4
    public qf4 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (qf4) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements fj4<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh2 a;

        public a(nh2 nh2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nh2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nh2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fj4
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray != null && !this.a.i.isEmpty()) {
                for (mh2 mh2Var : this.a.i.values()) {
                    if (mh2Var != null && mh2Var.r(this.a)) {
                        mh2Var.a(jSONArray);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements om3<mh2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh2 a;

        public b(nh2 nh2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nh2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nh2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(mh2 mh2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mh2Var) == null) {
                if (nh2.m) {
                    String str = this.a.c;
                    Log.i(str, "onCallback: SoUpdating=" + mh2Var);
                }
                if (mh2Var != null) {
                    this.a.k.c(mh2Var.k(), mh2Var.o());
                }
                this.a.Z(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements om3<mh2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh2 a;

        public c(nh2 nh2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nh2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nh2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(mh2 mh2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mh2Var) == null) && mh2Var != null) {
                this.a.k.d(mh2Var.k(), mh2Var.m());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ra2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xg4 a;
        public final /* synthetic */ nh2 b;

        public d(nh2 nh2Var, xg4 xg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nh2Var, xg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nh2Var;
            this.a = xg4Var;
        }

        @Override // com.baidu.tieba.ra2.c
        public void b(PMSDownloadType pMSDownloadType, oj3 oj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, oj3Var) == null) {
                this.b.f.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, oj3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ra2.c
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
    public class e implements n1b.a<xg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh2 a;

        public e(nh2 nh2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nh2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nh2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
        public void call(t1b<? super xg4> t1bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, t1bVar) != null) {
                return;
            }
            this.a.d = t1bVar;
        }
    }

    /* loaded from: classes5.dex */
    public class f extends t1b<xg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh2 e;

        public f(nh2 nh2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nh2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = nh2Var;
        }

        public /* synthetic */ f(nh2 nh2Var, a aVar) {
            this(nh2Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o1b
        /* renamed from: g */
        public void onNext(xg4 xg4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, xg4Var) == null) && nh2.m) {
                String str = this.e.c;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + xg4Var.toString());
            }
        }

        @Override // com.baidu.tieba.o1b
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (nh2.m) {
                    String str = this.e.c;
                    Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
                }
                this.e.e0(new Exception("failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.o1b
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (nh2.m) {
                    Log.e(this.e.c, "PkgDlSubscriber 包下载完成");
                }
                this.e.e0(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends jf4<xg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh2 a;

        public g(nh2 nh2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nh2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nh2Var;
        }

        public /* synthetic */ g(nh2 nh2Var, a aVar) {
            this(nh2Var);
        }

        @Override // com.baidu.tieba.of4
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
        @Override // com.baidu.tieba.mf4
        /* renamed from: l */
        public String d(xg4 xg4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xg4Var)) == null) {
                String g = kh2.d.g(xg4Var);
                if (nh2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback getDownloadPath: so=" + xg4Var.g + " path=" + g);
                }
                return g;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: q */
        public void a(xg4 xg4Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, xg4Var) == null) {
                super.a(xg4Var);
                tk4 tk4Var = (tk4) this.a.j.get(xg4Var.g);
                nh2 nh2Var = this.a;
                if (tk4Var == null) {
                    str = null;
                } else {
                    str = tk4Var.a;
                }
                mh2 a0 = nh2Var.a0(str);
                if (a0 != null) {
                    a0.x(new lh2.b(xg4Var.b, xg4Var.k));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: r */
        public void c(xg4 xg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, xg4Var) == null) {
                super.c(xg4Var);
                if (nh2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadStart: so=" + xg4Var.g);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: s */
        public void f(xg4 xg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, xg4Var) == null) {
                super.f(xg4Var);
                if (nh2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloading: so=" + xg4Var.g);
                }
                this.a.f0(xg4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: o */
        public void e(xg4 xg4Var, pg4 pg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xg4Var, pg4Var) == null) {
                super.e(xg4Var, pg4Var);
                if (nh2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadError: so=" + xg4Var.g + " err=" + pg4Var);
                }
                this.a.f.l(xg4Var);
                oj3 oj3Var = new oj3();
                oj3Var.k(13L);
                oj3Var.i(pg4Var.a);
                oj3Var.d("so包下载失败");
                oj3Var.f(pg4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(xg4Var, oj3Var));
                }
                ra2.c().a(xg4Var, nh2.o, oj3Var);
                zn4.k(xg4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: p */
        public void i(xg4 xg4Var) {
            tk4 tk4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, xg4Var) == null) {
                super.i(xg4Var);
                if (nh2.m) {
                    String str = this.a.c;
                    Log.i(str, "SoDlCallback onDownloadFinish: so=" + xg4Var);
                }
                String str2 = xg4Var.p;
                if (TextUtils.isEmpty(str2) && (tk4Var = (tk4) this.a.j.get(xg4Var.g)) != null) {
                    str2 = tk4Var.a;
                }
                mh2 a0 = this.a.a0(str2);
                if (a0 != null) {
                    boolean a = il3.a(new File(xg4Var.a), xg4Var.m);
                    if (nh2.m) {
                        String str3 = this.a.c;
                        Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + xg4Var.g + " checkSign=" + a);
                    }
                    boolean z = true;
                    z = (nh2.m && !pl3.G() && u33.j() == 1) ? false : false;
                    if (a || z) {
                        sf4.i().m(xg4Var);
                        if (nh2.m) {
                            String str4 = this.a.c;
                            Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + a0 + " libName=" + str2);
                        }
                    }
                    a0.q();
                }
                this.a.f.m(xg4Var);
                if (this.a.d != null) {
                    this.a.d.onNext(xg4Var);
                    this.a.d.onCompleted();
                }
                ra2.c().b(xg4Var, nh2.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948002385, "Lcom/baidu/tieba/nh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948002385, "Lcom/baidu/tieba/nh2;");
                return;
            }
        }
        m = fo1.a;
        n = 0;
        o = PMSDownloadType.SO_LIB;
    }

    @Override // com.baidu.tieba.qf4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (m) {
                Log.e(this.c, "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.qf4
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

    public final t1b<xg4> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
            }
            return this.e;
        }
        return (t1b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sk4
    public fj4<JSONArray> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (fj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sk4
    @Nullable
    public bj4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (bj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qf4
    public mf4<xg4> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.h == null) {
                this.h = new g(this, null);
            }
            return this.h;
        }
        return (mf4) invokeV.objValue;
    }

    public nh2(bj4 bj4Var, lh2 lh2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bj4Var, lh2Var};
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
            Log.i(sb2, "SwanSoUpdater: config=" + lh2Var + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.g = bj4Var;
        this.k = lh2Var;
        if (lh2Var != null) {
            Iterator<String> it = lh2Var.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                ih2 a2 = jh2.a(next);
                if (a2 == null) {
                    lh2Var.c(next, false);
                } else if (a2.f()) {
                    lh2Var.c(next, true);
                } else {
                    String e2 = a2.e();
                    mh2 t = kh2.d.t(this, e2);
                    b bVar = new b(this);
                    c cVar = new c(this);
                    t.u(bVar);
                    t.v(cVar);
                    this.i.put(e2, t);
                    this.j.putAll(tk4.b(e2));
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

    public final mh2 a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            mh2 mh2Var = this.i.get(str);
            if (mh2Var == null || !mh2Var.r(this)) {
                return null;
            }
            return mh2Var;
        }
        return (mh2) invokeL.objValue;
    }

    public final void f0(xg4 xg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, xg4Var) == null) {
            ra2.c().d(xg4Var, new d(this, xg4Var));
        }
    }

    @Override // com.baidu.tieba.qf4
    public pk4 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.equals("so", str)) {
                return this;
            }
            return super.w(str);
        }
        return (pk4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qf4
    public void C(pg4 pg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pg4Var) == null) {
            super.C(pg4Var);
            if (m) {
                String str = this.c;
                Log.e(str, "onFetchError: " + pg4Var.toString());
            }
            e0(new Exception("failed by fetch error = " + pg4Var));
        }
    }

    @Override // com.baidu.tieba.qf4
    public void G(dl4 dl4Var) {
        int n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dl4Var) == null) {
            if (m) {
                String str = this.c;
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepareDownload: countSet.size=");
                if (dl4Var == null) {
                    n2 = 0;
                } else {
                    n2 = dl4Var.n();
                }
                sb.append(n2);
                Log.i(str, sb.toString());
            }
            super.G(dl4Var);
            if (dl4Var == null) {
                return;
            }
            this.f = dl4Var;
            if (!dl4Var.k()) {
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
            lh2 lh2Var = this.k;
            if (lh2Var != null) {
                lh2Var.b(exc);
            }
        }
    }

    @Override // com.baidu.tieba.pk4
    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (m) {
                String str = this.c;
                Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
            }
            if (jSONObject != null) {
                g0((xg4) cl4.j(jSONObject, new xg4()));
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
            for (mh2 mh2Var : this.i.values()) {
                if (!mh2Var.n()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + mh2Var);
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
            for (mh2 mh2Var : this.i.values()) {
                if (mh2Var != null && mh2Var.r(this) && !mh2Var.n() && !mh2Var.s()) {
                    if (m) {
                        String str2 = this.c;
                        Log.i(str2, "notifyPmsFinish: try install updating=" + mh2Var);
                    }
                    mh2Var.q();
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
                arrayList.add(n1b.a(new e(this)));
            }
            if (!arrayList.isEmpty()) {
                n1b.i(arrayList).u(b0());
            }
        }
    }

    public final void g0(xg4 xg4Var) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, xg4Var) == null) {
            if (m) {
                Log.i(this.c, "SoNodeHandler updateBestSo start so=" + xg4Var);
            }
            if (xg4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by null so");
                    return;
                }
                return;
            }
            tk4 tk4Var = this.j.get(xg4Var.g);
            if (tk4Var == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by illegal bundleId=" + xg4Var.g);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(xg4Var.p)) {
                xg4Var.p = tk4Var.a;
            }
            mh2 a0 = a0(xg4Var.p);
            if (a0 == null) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by no updating lib=" + xg4Var.p);
                    return;
                }
                return;
            }
            if (xg4Var.q == null) {
                xg4Var.q = tk4Var.c;
            }
            if (!AbiType.currentAbi().compat(xg4Var.q)) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by currentAbi");
                    return;
                }
                return;
            }
            xg4 l = a0.l();
            xg4 j2 = a0.j();
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
            long j4 = xg4Var.i;
            if (j4 < max) {
                if (m) {
                    Log.i(this.c, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(xg4Var.i)));
                }
            } else if (j4 > max) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by update bestVer=" + xg4Var.i);
                }
                a0.w(this, xg4Var);
            } else {
                if (j2 == null || !j2.q.compat(xg4Var.q)) {
                    if (m) {
                        Log.i(this.c, "SoNodeHandler updateBestSo end by update abi update=" + xg4Var.q);
                    }
                    a0.w(this, xg4Var);
                }
                if (m) {
                    Log.i(this.c, "SoNodeHandler updateBestSo end by should not exec here");
                }
            }
        }
    }

    @Override // com.baidu.tieba.pk4
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            nk4 nk4Var = new nk4();
            dl4 dl4Var = new dl4();
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop start");
            }
            boolean z = true;
            if ((m && !pl3.G() && u33.j() == 1) ? false : false) {
                String i = u33.i();
                if (!TextUtils.isEmpty(i)) {
                    try {
                        xg4 xg4Var = (xg4) cl4.j(new JSONObject(i), new xg4());
                        xg4Var.g = "so_zeus_armeabi";
                        g0(xg4Var);
                        n73.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1322)).G();
                    } catch (JSONException e2) {
                        n73.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1321)).G();
                        e2.printStackTrace();
                    }
                }
            }
            for (mh2 mh2Var : this.i.values()) {
                if (mh2Var.r(this)) {
                    g0(mh2Var.l());
                    xg4 j = mh2Var.j();
                    if (mh2Var.p() && j != null) {
                        if (m) {
                            String str = this.c;
                            Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                        }
                        ok4.b(j, dl4Var);
                        if (nk4Var.d == null) {
                            nk4Var.d = new ArrayList();
                        }
                        nk4Var.d.add(j);
                    } else {
                        if (m) {
                            Log.i(this.c, "SoNodeHandler localSo not update, just check for install");
                        }
                        mh2Var.q();
                    }
                }
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle for loop end");
                String str2 = this.c;
                Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + dl4Var.n());
            }
            if (dl4Var.n() == 0) {
                if (m) {
                    Log.i(this.c, "SoNodeHandler handle end by no pkg");
                }
                F();
                return;
            }
            if (m) {
                Log.i(this.c, "SoNodeHandler handle end by start dl");
            }
            G(dl4Var);
            gh4.e(nk4Var, this);
        }
    }
}
