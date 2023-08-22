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
import com.baidu.tieba.e04;
import com.baidu.tieba.qy3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class oy3 implements pz3, qy3.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public String c;
    public sy3 d;
    public py3 e;
    public d04 f;
    public AdElementInfo g;
    public qy3 h;
    public boolean i;
    public String j;
    public boolean k;
    public wy3 l;
    public Map<String, String> m;
    public tz3 n;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy3 a;

        public a(oy3 oy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h != null && this.a.h.f() != null && this.a.n.c(this.a.h.f())) {
                this.a.n.removeView(this.a.h.f());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements rz3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy3 a;

        @Override // com.baidu.tieba.rz3
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        public b(oy3 oy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy3Var;
        }

        @Override // com.baidu.tieba.rz3
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

    /* loaded from: classes7.dex */
    public class c implements nz3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy3 a;

        public c(oy3 oy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy3Var;
        }

        @Override // com.baidu.tieba.nz3
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) && this.a.g != null) {
                String clickUrl = this.a.g.getClickUrl();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("monitorUrl", m04.b("landingPageLoad", this.a.m));
                } catch (JSONException unused) {
                }
                this.a.n.a(clickUrl, jSONObject);
                m04.g(this.a.g, this.a.f);
                m04.n("lpClick", this.a.m, this.a.f);
                m04.n("click", this.a.m, this.a.f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ oy3 b;

        public d(oy3 oy3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oy3Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                py3 py3Var = this.b.e;
                if (py3Var.c != py3Var.e) {
                    z = true;
                } else {
                    z = false;
                }
                this.b.x();
                if (this.b.h != null) {
                    this.b.h.e(this.b.e.c);
                    this.b.n.f(this.b.h.f(), new ny3(w04.a(this.b.e.a), w04.a(this.b.e.b), w04.a(this.b.e.e), w04.a(this.b.e.f)));
                }
                if (this.a.equals("width") && z && this.b.d != null) {
                    sy3 sy3Var = this.b.d;
                    py3 py3Var2 = this.b.e;
                    sy3Var.c(py3Var2.e, py3Var2.f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy3 a;

        public e(oy3 oy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy3Var;
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
                    m04.n("showSuccess", this.a.m, this.a.f);
                    if (this.a.i) {
                        return;
                    }
                    this.a.i = true;
                    if (this.a.k) {
                        o04.f(this.a.g, this.a.f);
                        return;
                    }
                    m04.j(this.a.g, this.a.f);
                    String str = this.a.c;
                    oy3 oy3Var = this.a;
                    m04.f(str, oy3Var.b, oy3Var.j, this.a.f);
                    m04.n("show", this.a.m, this.a.f);
                } else if (this.a.d != null) {
                    this.a.d.b(false);
                    this.a.d.onError("3010010");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements rz3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy3 a;

        @Override // com.baidu.tieba.rz3
        public void f(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            }
        }

        public f(oy3 oy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy3Var;
        }

        @Override // com.baidu.tieba.rz3
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && !TextUtils.isEmpty(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", str2);
                    if (this.a.l == null) {
                        this.a.l = new wy3(this.a.a, this.a.g, this.a.f);
                    }
                    this.a.l.k(str);
                    vz3.b().d(this.a.a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.l);
                } catch (JSONException unused) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy3 a;

        public g(oy3 oy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h != null) {
                this.a.h.g();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy3 a;

        public h(oy3 oy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy3Var;
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

    public oy3(String str, String str2, sy3 sy3Var, tz3 tz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, sy3Var, tz3Var};
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
        this.d = sy3Var;
        this.n = tz3Var;
        this.f = new d04(appContext);
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
            s04.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            s04.c(new d(this, str));
        }
    }

    @Override // com.baidu.tieba.pz3
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
            o04.d(adElementInfo, this.f);
            l04 l04Var = new l04();
            l04Var.a = String.valueOf(this.e.c);
            l04Var.b = String.valueOf(this.e.d);
            l04Var.c = String.valueOf(this.e.c);
            l04Var.d = String.valueOf(this.e.d);
            l04Var.e = String.valueOf((int) view2.getX());
            l04Var.f = String.valueOf((int) view2.getY());
            l04Var.g = String.valueOf((int) view2.getX());
            l04Var.h = String.valueOf((int) view2.getY());
            if (this.g.getActionType() == 2) {
                o04.a(l04Var, this.g, this.f, new f(this));
                return;
            }
            AdElementInfo adElementInfo2 = this.g;
            if (adElementInfo2 != null) {
                this.n.a(o04.c(adElementInfo2.getClickUrl(), l04Var), new JSONObject());
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            s04.c(new g(this));
        }
    }

    @Override // com.baidu.tieba.qy3.e
    public void b() {
        sy3 sy3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (sy3Var = this.d) != null) {
            sy3Var.onClose();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            s04.c(new h(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            qy3 qy3Var = new qy3(this.a, this.g, this.b, this.k);
            this.h = qy3Var;
            qy3Var.i(this);
            if (this.k) {
                this.h.k(new b(this));
            } else {
                this.h.j(new c(this));
            }
            this.h.e(this.e.c);
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            if (this.n.d(this.h.f(), new ny3(w04.a(this.e.a), w04.a(this.e.b), w04.a(this.e.e), w04.a(this.e.f)))) {
                sy3 sy3Var = this.d;
                if (sy3Var != null) {
                    sy3Var.a(true, "");
                    return;
                }
                return;
            }
            sy3 sy3Var2 = this.d;
            if (sy3Var2 != null) {
                sy3Var2.onError("3010000");
            }
        }
    }

    public final void D() {
        g04 f04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            m04.n("loadApi", this.m, this.f);
            String appKey = vz3.b().getAppKey();
            e04.b bVar = new e04.b();
            bVar.m(this.c);
            bVar.j(this.b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k(SpeedStatsUtils.UBC_VALUE_BANNER);
            bVar.l(this.e.c);
            bVar.i(this.e.d);
            e04 h2 = bVar.h();
            if (this.k) {
                f04Var = new h04(this.a, h2, 1, z());
            } else {
                f04Var = new f04(this.a, h2);
                this.j = f04Var.c();
            }
            b04 b04Var = new b04(this.a, false);
            b04Var.k(this);
            b04Var.i(f04Var, this.f);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            qy3 qy3Var = new qy3(this.a);
            this.h = qy3Var;
            qy3Var.e(this.e.c);
            if (this.h.f() == null) {
                return;
            }
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            this.n.d(this.h.f(), new ny3(w04.a(this.e.a), w04.a(this.e.b), w04.a(this.e.e), w04.a(this.e.f)));
            this.h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        py3 py3Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || (py3Var = this.e) == null) {
            return;
        }
        if (w04.a(py3Var.c) < 300) {
            this.e.c = w04.p(300.0f);
        }
        int k = vz3.b().k();
        int j = vz3.b().j();
        if (w04.a(this.e.c) > k) {
            this.e.c = w04.p(k);
        }
        py3 py3Var2 = this.e;
        py3Var2.d = (int) (py3Var2.c / ry3.a);
        if (py3Var2.a < 0) {
            py3Var2.a = 0;
        }
        int p = w04.p(k);
        py3 py3Var3 = this.e;
        int i = p - py3Var3.c;
        if (py3Var3.a > i) {
            py3Var3.a = i;
        }
        py3 py3Var4 = this.e;
        if (py3Var4.b < 0) {
            py3Var4.b = 0;
        }
        int p2 = w04.p(j);
        py3 py3Var5 = this.e;
        int i2 = p2 - py3Var5.d;
        if (py3Var5.b > i2) {
            py3Var5.b = i2;
        }
        py3 py3Var6 = this.e;
        py3Var6.e = py3Var6.c;
        py3Var6.f = py3Var6.d;
    }

    public void E(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
            this.e = new py3(i, i2, i3, i4);
            x();
        }
    }

    @Override // com.baidu.tieba.pz3
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            sy3 sy3Var = this.d;
            if (sy3Var != null) {
                sy3Var.onError(str);
            }
            String appId = vz3.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            sy3 sy3Var2 = this.d;
            if (sy3Var2 != null) {
                sy3Var2.a(false, "");
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
            int p = w04.p(vz3.b().j());
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
