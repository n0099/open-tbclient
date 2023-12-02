package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.tieba.lv3;
import com.baidu.tieba.xt3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class vt3 implements wu3, xt3.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public String c;
    public zt3 d;
    public wt3 e;
    public kv3 f;
    public AdElementInfo g;
    public xt3 h;
    public boolean i;
    public String j;
    public boolean k;
    public du3 l;
    public Map<String, String> m;
    public av3 n;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vt3 a;

        public a(vt3 vt3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vt3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h != null && this.a.h.f() != null && this.a.n.c(this.a.h.f())) {
                this.a.n.removeView(this.a.h.f());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements yu3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vt3 a;

        @Override // com.baidu.tieba.yu3
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        public b(vt3 vt3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vt3Var;
        }

        @Override // com.baidu.tieba.yu3
        public void f(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) != null) || !this.a.k) {
                return;
            }
            this.a.A(view2);
            if (this.a.d != null) {
                this.a.d.onClick();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements uu3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vt3 a;

        public c(vt3 vt3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vt3Var;
        }

        @Override // com.baidu.tieba.uu3
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) && this.a.g != null) {
                String clickUrl = this.a.g.getClickUrl();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("monitorUrl", tv3.b("landingPageLoad", this.a.m));
                } catch (JSONException unused) {
                }
                this.a.n.a(clickUrl, jSONObject);
                tv3.g(this.a.g, this.a.f);
                tv3.n("lpClick", this.a.m, this.a.f);
                tv3.n("click", this.a.m, this.a.f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ vt3 b;

        public d(vt3 vt3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vt3Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wt3 wt3Var = this.b.e;
                if (wt3Var.c != wt3Var.e) {
                    z = true;
                } else {
                    z = false;
                }
                this.b.x();
                if (this.b.h != null) {
                    this.b.h.e(this.b.e.c);
                    this.b.n.f(this.b.h.f(), new ut3(dw3.a(this.b.e.a), dw3.a(this.b.e.b), dw3.a(this.b.e.e), dw3.a(this.b.e.f)));
                }
                if (this.a.equals("width") && z && this.b.d != null) {
                    zt3 zt3Var = this.b.d;
                    wt3 wt3Var2 = this.b.e;
                    zt3Var.c(wt3Var2.e, wt3Var2.f);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vt3 a;

        public e(vt3 vt3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vt3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.h != null && this.a.n.c(this.a.h.f())) {
                    this.a.h.l();
                    if (this.a.d != null) {
                        this.a.d.b(true);
                    }
                    tv3.n("showSuccess", this.a.m, this.a.f);
                    if (this.a.i) {
                        return;
                    }
                    this.a.i = true;
                    if (this.a.k) {
                        vv3.f(this.a.g, this.a.f);
                        return;
                    }
                    tv3.j(this.a.g, this.a.f);
                    String str = this.a.c;
                    vt3 vt3Var = this.a;
                    tv3.f(str, vt3Var.b, vt3Var.j, this.a.f);
                    tv3.n("show", this.a.m, this.a.f);
                } else if (this.a.d != null) {
                    this.a.d.b(false);
                    this.a.d.onError("3010010");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements yu3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vt3 a;

        @Override // com.baidu.tieba.yu3
        public void f(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            }
        }

        public f(vt3 vt3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vt3Var;
        }

        @Override // com.baidu.tieba.yu3
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && !TextUtils.isEmpty(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", str2);
                    if (this.a.l == null) {
                        this.a.l = new du3(this.a.a, this.a.g, this.a.f);
                    }
                    this.a.l.k(str);
                    cv3.b().d(this.a.a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.l);
                } catch (JSONException unused) {
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vt3 a;

        public g(vt3 vt3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vt3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h != null) {
                this.a.h.g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vt3 a;

        public h(vt3 vt3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vt3Var;
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

    public vt3(String str, String str2, zt3 zt3Var, av3 av3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, zt3Var, av3Var};
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
        this.d = zt3Var;
        this.n = av3Var;
        this.f = new kv3(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
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
            zv3.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            zv3.c(new d(this, str));
        }
    }

    @Override // com.baidu.tieba.wu3
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.g = adElementInfo;
            C();
        }
    }

    public final void A(View view2) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.k && (adElementInfo = this.g) != null && this.e != null && view2 != null) {
            vv3.d(adElementInfo, this.f);
            sv3 sv3Var = new sv3();
            sv3Var.a = String.valueOf(this.e.c);
            sv3Var.b = String.valueOf(this.e.d);
            sv3Var.c = String.valueOf(this.e.c);
            sv3Var.d = String.valueOf(this.e.d);
            sv3Var.e = String.valueOf((int) view2.getX());
            sv3Var.f = String.valueOf((int) view2.getY());
            sv3Var.g = String.valueOf((int) view2.getX());
            sv3Var.h = String.valueOf((int) view2.getY());
            if (this.g.getActionType() == 2) {
                vv3.a(sv3Var, this.g, this.f, new f(this));
                return;
            }
            AdElementInfo adElementInfo2 = this.g;
            if (adElementInfo2 != null) {
                this.n.a(vv3.c(adElementInfo2.getClickUrl(), sv3Var), new JSONObject());
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            zv3.c(new g(this));
        }
    }

    @Override // com.baidu.tieba.xt3.e
    public void b() {
        zt3 zt3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (zt3Var = this.d) != null) {
            zt3Var.onClose();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            zv3.c(new h(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            xt3 xt3Var = new xt3(this.a, this.g, this.b, this.k);
            this.h = xt3Var;
            xt3Var.i(this);
            if (this.k) {
                this.h.k(new b(this));
            } else {
                this.h.j(new c(this));
            }
            this.h.e(this.e.c);
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            if (this.n.d(this.h.f(), new ut3(dw3.a(this.e.a), dw3.a(this.e.b), dw3.a(this.e.e), dw3.a(this.e.f)))) {
                zt3 zt3Var = this.d;
                if (zt3Var != null) {
                    zt3Var.a(true, "");
                    return;
                }
                return;
            }
            zt3 zt3Var2 = this.d;
            if (zt3Var2 != null) {
                zt3Var2.onError("3010000");
            }
        }
    }

    public final void D() {
        nv3 mv3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            tv3.n("loadApi", this.m, this.f);
            String appKey = cv3.b().getAppKey();
            lv3.b bVar = new lv3.b();
            bVar.m(this.c);
            bVar.j(this.b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k("banner");
            bVar.l(this.e.c);
            bVar.i(this.e.d);
            lv3 h2 = bVar.h();
            if (this.k) {
                mv3Var = new ov3(this.a, h2, 1, z());
            } else {
                mv3Var = new mv3(this.a, h2);
                this.j = mv3Var.c();
            }
            iv3 iv3Var = new iv3(this.a, false);
            iv3Var.k(this);
            iv3Var.i(mv3Var, this.f);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            xt3 xt3Var = new xt3(this.a);
            this.h = xt3Var;
            xt3Var.e(this.e.c);
            if (this.h.f() == null) {
                return;
            }
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            this.n.d(this.h.f(), new ut3(dw3.a(this.e.a), dw3.a(this.e.b), dw3.a(this.e.e), dw3.a(this.e.f)));
            this.h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        wt3 wt3Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || (wt3Var = this.e) == null) {
            return;
        }
        if (dw3.a(wt3Var.c) < 300) {
            this.e.c = dw3.p(300.0f);
        }
        int k = cv3.b().k();
        int j = cv3.b().j();
        if (dw3.a(this.e.c) > k) {
            this.e.c = dw3.p(k);
        }
        wt3 wt3Var2 = this.e;
        wt3Var2.d = (int) (wt3Var2.c / yt3.a);
        if (wt3Var2.a < 0) {
            wt3Var2.a = 0;
        }
        int p = dw3.p(k);
        wt3 wt3Var3 = this.e;
        int i = p - wt3Var3.c;
        if (wt3Var3.a > i) {
            wt3Var3.a = i;
        }
        wt3 wt3Var4 = this.e;
        if (wt3Var4.b < 0) {
            wt3Var4.b = 0;
        }
        int p2 = dw3.p(j);
        wt3 wt3Var5 = this.e;
        int i2 = p2 - wt3Var5.d;
        if (wt3Var5.b > i2) {
            wt3Var5.b = i2;
        }
        wt3 wt3Var6 = this.e;
        wt3Var6.e = wt3Var6.c;
        wt3Var6.f = wt3Var6.d;
    }

    public void E(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
            this.e = new wt3(i, i2, i3, i4);
            x();
        }
    }

    @Override // com.baidu.tieba.wu3
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            zt3 zt3Var = this.d;
            if (zt3Var != null) {
                zt3Var.onError(str);
            }
            String appId = cv3.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            zt3 zt3Var2 = this.d;
            if (zt3Var2 != null) {
                zt3Var2.a(false, "");
            }
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.e == null) {
                return 2;
            }
            int p = dw3.p(cv3.b().j());
            int i = this.e.b;
            int i2 = p / 3;
            if (i < i2) {
                return 1;
            }
            if (i >= i2 * 2) {
                return 2;
            }
            return 4;
        }
        return invokeV.intValue;
    }
}
