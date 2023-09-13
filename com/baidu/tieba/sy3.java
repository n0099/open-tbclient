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
import com.baidu.tieba.i04;
import com.baidu.tieba.uy3;
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
public class sy3 implements tz3, uy3.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public String c;
    public wy3 d;
    public ty3 e;
    public h04 f;
    public AdElementInfo g;
    public uy3 h;
    public boolean i;
    public String j;
    public boolean k;
    public az3 l;
    public Map<String, String> m;
    public xz3 n;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy3 a;

        public a(sy3 sy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy3Var;
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
    public class b implements vz3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy3 a;

        @Override // com.baidu.tieba.vz3
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        public b(sy3 sy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy3Var;
        }

        @Override // com.baidu.tieba.vz3
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
    public class c implements rz3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy3 a;

        public c(sy3 sy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy3Var;
        }

        @Override // com.baidu.tieba.rz3
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) && this.a.g != null) {
                String clickUrl = this.a.g.getClickUrl();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("monitorUrl", q04.b("landingPageLoad", this.a.m));
                } catch (JSONException unused) {
                }
                this.a.n.a(clickUrl, jSONObject);
                q04.g(this.a.g, this.a.f);
                q04.n("lpClick", this.a.m, this.a.f);
                q04.n("click", this.a.m, this.a.f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ sy3 b;

        public d(sy3 sy3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sy3Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ty3 ty3Var = this.b.e;
                if (ty3Var.c != ty3Var.e) {
                    z = true;
                } else {
                    z = false;
                }
                this.b.x();
                if (this.b.h != null) {
                    this.b.h.e(this.b.e.c);
                    this.b.n.f(this.b.h.f(), new ry3(a14.a(this.b.e.a), a14.a(this.b.e.b), a14.a(this.b.e.e), a14.a(this.b.e.f)));
                }
                if (this.a.equals("width") && z && this.b.d != null) {
                    wy3 wy3Var = this.b.d;
                    ty3 ty3Var2 = this.b.e;
                    wy3Var.c(ty3Var2.e, ty3Var2.f);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy3 a;

        public e(sy3 sy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy3Var;
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
                    q04.n("showSuccess", this.a.m, this.a.f);
                    if (this.a.i) {
                        return;
                    }
                    this.a.i = true;
                    if (this.a.k) {
                        s04.f(this.a.g, this.a.f);
                        return;
                    }
                    q04.j(this.a.g, this.a.f);
                    String str = this.a.c;
                    sy3 sy3Var = this.a;
                    q04.f(str, sy3Var.b, sy3Var.j, this.a.f);
                    q04.n("show", this.a.m, this.a.f);
                } else if (this.a.d != null) {
                    this.a.d.b(false);
                    this.a.d.onError("3010010");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements vz3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy3 a;

        @Override // com.baidu.tieba.vz3
        public void f(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            }
        }

        public f(sy3 sy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy3Var;
        }

        @Override // com.baidu.tieba.vz3
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && !TextUtils.isEmpty(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", str2);
                    if (this.a.l == null) {
                        this.a.l = new az3(this.a.a, this.a.g, this.a.f);
                    }
                    this.a.l.k(str);
                    zz3.b().d(this.a.a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.l);
                } catch (JSONException unused) {
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy3 a;

        public g(sy3 sy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy3Var;
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
        public final /* synthetic */ sy3 a;

        public h(sy3 sy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy3Var;
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

    public sy3(String str, String str2, wy3 wy3Var, xz3 xz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, wy3Var, xz3Var};
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
        this.d = wy3Var;
        this.n = xz3Var;
        this.f = new h04(appContext);
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
            w04.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            w04.c(new d(this, str));
        }
    }

    @Override // com.baidu.tieba.tz3
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
            s04.d(adElementInfo, this.f);
            p04 p04Var = new p04();
            p04Var.a = String.valueOf(this.e.c);
            p04Var.b = String.valueOf(this.e.d);
            p04Var.c = String.valueOf(this.e.c);
            p04Var.d = String.valueOf(this.e.d);
            p04Var.e = String.valueOf((int) view2.getX());
            p04Var.f = String.valueOf((int) view2.getY());
            p04Var.g = String.valueOf((int) view2.getX());
            p04Var.h = String.valueOf((int) view2.getY());
            if (this.g.getActionType() == 2) {
                s04.a(p04Var, this.g, this.f, new f(this));
                return;
            }
            AdElementInfo adElementInfo2 = this.g;
            if (adElementInfo2 != null) {
                this.n.a(s04.c(adElementInfo2.getClickUrl(), p04Var), new JSONObject());
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            w04.c(new g(this));
        }
    }

    @Override // com.baidu.tieba.uy3.e
    public void b() {
        wy3 wy3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (wy3Var = this.d) != null) {
            wy3Var.onClose();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            w04.c(new h(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            uy3 uy3Var = new uy3(this.a, this.g, this.b, this.k);
            this.h = uy3Var;
            uy3Var.i(this);
            if (this.k) {
                this.h.k(new b(this));
            } else {
                this.h.j(new c(this));
            }
            this.h.e(this.e.c);
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            if (this.n.d(this.h.f(), new ry3(a14.a(this.e.a), a14.a(this.e.b), a14.a(this.e.e), a14.a(this.e.f)))) {
                wy3 wy3Var = this.d;
                if (wy3Var != null) {
                    wy3Var.a(true, "");
                    return;
                }
                return;
            }
            wy3 wy3Var2 = this.d;
            if (wy3Var2 != null) {
                wy3Var2.onError("3010000");
            }
        }
    }

    public final void D() {
        k04 j04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            q04.n("loadApi", this.m, this.f);
            String appKey = zz3.b().getAppKey();
            i04.b bVar = new i04.b();
            bVar.m(this.c);
            bVar.j(this.b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k(SpeedStatsUtils.UBC_VALUE_BANNER);
            bVar.l(this.e.c);
            bVar.i(this.e.d);
            i04 h2 = bVar.h();
            if (this.k) {
                j04Var = new l04(this.a, h2, 1, z());
            } else {
                j04Var = new j04(this.a, h2);
                this.j = j04Var.c();
            }
            f04 f04Var = new f04(this.a, false);
            f04Var.k(this);
            f04Var.i(j04Var, this.f);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            uy3 uy3Var = new uy3(this.a);
            this.h = uy3Var;
            uy3Var.e(this.e.c);
            if (this.h.f() == null) {
                return;
            }
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            this.n.d(this.h.f(), new ry3(a14.a(this.e.a), a14.a(this.e.b), a14.a(this.e.e), a14.a(this.e.f)));
            this.h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        ty3 ty3Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || (ty3Var = this.e) == null) {
            return;
        }
        if (a14.a(ty3Var.c) < 300) {
            this.e.c = a14.p(300.0f);
        }
        int k = zz3.b().k();
        int j = zz3.b().j();
        if (a14.a(this.e.c) > k) {
            this.e.c = a14.p(k);
        }
        ty3 ty3Var2 = this.e;
        ty3Var2.d = (int) (ty3Var2.c / vy3.a);
        if (ty3Var2.a < 0) {
            ty3Var2.a = 0;
        }
        int p = a14.p(k);
        ty3 ty3Var3 = this.e;
        int i = p - ty3Var3.c;
        if (ty3Var3.a > i) {
            ty3Var3.a = i;
        }
        ty3 ty3Var4 = this.e;
        if (ty3Var4.b < 0) {
            ty3Var4.b = 0;
        }
        int p2 = a14.p(j);
        ty3 ty3Var5 = this.e;
        int i2 = p2 - ty3Var5.d;
        if (ty3Var5.b > i2) {
            ty3Var5.b = i2;
        }
        ty3 ty3Var6 = this.e;
        ty3Var6.e = ty3Var6.c;
        ty3Var6.f = ty3Var6.d;
    }

    public void E(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
            this.e = new ty3(i, i2, i3, i4);
            x();
        }
    }

    @Override // com.baidu.tieba.tz3
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            wy3 wy3Var = this.d;
            if (wy3Var != null) {
                wy3Var.onError(str);
            }
            String appId = zz3.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            wy3 wy3Var2 = this.d;
            if (wy3Var2 != null) {
                wy3Var2.a(false, "");
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
            int p = a14.p(zz3.b().j());
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
