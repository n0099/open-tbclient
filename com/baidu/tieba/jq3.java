package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.tieba.lq3;
import com.baidu.tieba.zr3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class jq3 implements kr3, lq3.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public String c;
    public nq3 d;
    public kq3 e;
    public yr3 f;
    public AdElementInfo g;
    public lq3 h;
    public boolean i;
    public String j;
    public boolean k;
    public rq3 l;
    public Map<String, String> m;
    public or3 n;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq3 a;

        public a(jq3 jq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jq3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.h == null || this.a.h.f() == null || !this.a.n.c(this.a.h.f())) {
                return;
            }
            this.a.n.removeView(this.a.h.f());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements mr3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq3 a;

        public b(jq3 jq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jq3Var;
        }

        @Override // com.baidu.tieba.mr3
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // com.baidu.tieba.mr3
        public void f(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && this.a.k) {
                this.a.A(view2);
                if (this.a.d != null) {
                    this.a.d.onClick();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ir3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq3 a;

        public c(jq3 jq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jq3Var;
        }

        @Override // com.baidu.tieba.ir3
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.a.g == null) {
                return;
            }
            String clickUrl = this.a.g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", hs3.b("landingPageLoad", this.a.m));
            } catch (JSONException unused) {
            }
            this.a.n.a(clickUrl, jSONObject);
            hs3.g(this.a.g, this.a.f);
            hs3.n("lpClick", this.a.m, this.a.f);
            hs3.n("click", this.a.m, this.a.f);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ jq3 b;

        public d(jq3 jq3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jq3Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kq3 kq3Var = this.b.e;
                boolean z = kq3Var.c != kq3Var.e;
                this.b.x();
                if (this.b.h != null) {
                    this.b.h.e(this.b.e.c);
                    this.b.n.f(this.b.h.f(), new iq3(rs3.a(this.b.e.a), rs3.a(this.b.e.b), rs3.a(this.b.e.e), rs3.a(this.b.e.f)));
                }
                if (this.a.equals("width") && z && this.b.d != null) {
                    nq3 nq3Var = this.b.d;
                    kq3 kq3Var2 = this.b.e;
                    nq3Var.c(kq3Var2.e, kq3Var2.f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq3 a;

        public e(jq3 jq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jq3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.h == null || !this.a.n.c(this.a.h.f())) {
                    if (this.a.d != null) {
                        this.a.d.b(false);
                        this.a.d.onError("3010010");
                        return;
                    }
                    return;
                }
                this.a.h.l();
                if (this.a.d != null) {
                    this.a.d.b(true);
                }
                hs3.n("showSuccess", this.a.m, this.a.f);
                if (this.a.i) {
                    return;
                }
                this.a.i = true;
                if (this.a.k) {
                    js3.f(this.a.g, this.a.f);
                    return;
                }
                hs3.j(this.a.g, this.a.f);
                String str = this.a.c;
                jq3 jq3Var = this.a;
                hs3.f(str, jq3Var.b, jq3Var.j, this.a.f);
                hs3.n("show", this.a.m, this.a.f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements mr3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq3 a;

        public f(jq3 jq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jq3Var;
        }

        @Override // com.baidu.tieba.mr3
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (this.a.l == null) {
                    this.a.l = new rq3(this.a.a, this.a.g, this.a.f);
                }
                this.a.l.k(str);
                qr3.b().d(this.a.a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.l);
            } catch (JSONException unused) {
            }
        }

        @Override // com.baidu.tieba.mr3
        public void f(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq3 a;

        public g(jq3 jq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jq3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.h == null) {
                return;
            }
            this.a.h.g();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq3 a;

        public h(jq3 jq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jq3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.h != null) {
                    this.a.n.removeView(this.a.h.f());
                }
                this.a.h = null;
                this.a.d = null;
                this.a.g = null;
                if (this.a.l != null) {
                    this.a.l.i();
                    this.a.l = null;
                }
            }
        }
    }

    public jq3(String str, String str2, nq3 nq3Var, or3 or3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, nq3Var, or3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = null;
        this.m = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.a = appContext;
        this.c = str;
        this.b = str2;
        this.d = nq3Var;
        this.n = or3Var;
        this.f = new yr3(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
    }

    public final void A(View view2) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || !this.k || (adElementInfo = this.g) == null || this.e == null || view2 == null) {
            return;
        }
        js3.d(adElementInfo, this.f);
        gs3 gs3Var = new gs3();
        gs3Var.a = String.valueOf(this.e.c);
        gs3Var.b = String.valueOf(this.e.d);
        gs3Var.c = String.valueOf(this.e.c);
        gs3Var.d = String.valueOf(this.e.d);
        gs3Var.e = String.valueOf((int) view2.getX());
        gs3Var.f = String.valueOf((int) view2.getY());
        gs3Var.g = String.valueOf((int) view2.getX());
        gs3Var.h = String.valueOf((int) view2.getY());
        if (this.g.getActionType() == 2) {
            js3.a(gs3Var, this.g, this.f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.g;
        if (adElementInfo2 != null) {
            this.n.a(js3.c(adElementInfo2.getClickUrl(), gs3Var), new JSONObject());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ns3.c(new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            lq3 lq3Var = new lq3(this.a, this.g, this.b, this.k);
            this.h = lq3Var;
            lq3Var.i(this);
            if (this.k) {
                this.h.k(new b(this));
            } else {
                this.h.j(new c(this));
            }
            this.h.e(this.e.c);
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            if (this.n.d(this.h.f(), new iq3(rs3.a(this.e.a), rs3.a(this.e.b), rs3.a(this.e.e), rs3.a(this.e.f)))) {
                nq3 nq3Var = this.d;
                if (nq3Var != null) {
                    nq3Var.a(true, "");
                    return;
                }
                return;
            }
            nq3 nq3Var2 = this.d;
            if (nq3Var2 != null) {
                nq3Var2.onError("3010000");
            }
        }
    }

    public final void D() {
        bs3 as3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            hs3.n("loadApi", this.m, this.f);
            String appKey = qr3.b().getAppKey();
            zr3.b bVar = new zr3.b();
            bVar.m(this.c);
            bVar.j(this.b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k(SpeedStatsUtils.UBC_VALUE_BANNER);
            bVar.l(this.e.c);
            bVar.i(this.e.d);
            zr3 h2 = bVar.h();
            if (this.k) {
                as3Var = new cs3(this.a, h2, 1, z());
            } else {
                as3Var = new as3(this.a, h2);
                this.j = as3Var.c();
            }
            wr3 wr3Var = new wr3(this.a, false);
            wr3Var.k(this);
            wr3Var.i(as3Var, this.f);
        }
    }

    public void E(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
            this.e = new kq3(i, i2, i3, i4);
            x();
        }
    }

    public void F(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, map) == null) {
            this.m = map;
        }
    }

    public void G(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) {
            ns3.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            ns3.c(new d(this, str));
        }
    }

    @Override // com.baidu.tieba.kr3
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            nq3 nq3Var = this.d;
            if (nq3Var != null) {
                nq3Var.onError(str);
            }
            String appId = qr3.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            nq3 nq3Var2 = this.d;
            if (nq3Var2 != null) {
                nq3Var2.a(false, "");
            }
        }
    }

    @Override // com.baidu.tieba.lq3.e
    public void b() {
        nq3 nq3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (nq3Var = this.d) == null) {
            return;
        }
        nq3Var.onClose();
    }

    @Override // com.baidu.tieba.kr3
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.g = adElementInfo;
            C();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            lq3 lq3Var = new lq3(this.a);
            this.h = lq3Var;
            lq3Var.e(this.e.c);
            if (this.h.f() == null) {
                return;
            }
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            this.n.d(this.h.f(), new iq3(rs3.a(this.e.a), rs3.a(this.e.b), rs3.a(this.e.e), rs3.a(this.e.f)));
            this.h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        kq3 kq3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (kq3Var = this.e) == null) {
            return;
        }
        if (rs3.a(kq3Var.c) < 300) {
            this.e.c = rs3.p(300.0f);
        }
        int k = qr3.b().k();
        int j = qr3.b().j();
        if (rs3.a(this.e.c) > k) {
            this.e.c = rs3.p(k);
        }
        kq3 kq3Var2 = this.e;
        kq3Var2.d = (int) (kq3Var2.c / mq3.a);
        if (kq3Var2.a < 0) {
            kq3Var2.a = 0;
        }
        int p = rs3.p(k);
        kq3 kq3Var3 = this.e;
        int i = p - kq3Var3.c;
        if (kq3Var3.a > i) {
            kq3Var3.a = i;
        }
        kq3 kq3Var4 = this.e;
        if (kq3Var4.b < 0) {
            kq3Var4.b = 0;
        }
        int p2 = rs3.p(j);
        kq3 kq3Var5 = this.e;
        int i2 = p2 - kq3Var5.d;
        if (kq3Var5.b > i2) {
            kq3Var5.b = i2;
        }
        kq3 kq3Var6 = this.e;
        kq3Var6.e = kq3Var6.c;
        kq3Var6.f = kq3Var6.d;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ns3.c(new h(this));
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.e == null) {
                return 2;
            }
            int p = rs3.p(qr3.b().j());
            int i = this.e.b;
            int i2 = p / 3;
            if (i < i2) {
                return 1;
            }
            return i < i2 * 2 ? 4 : 2;
        }
        return invokeV.intValue;
    }
}
