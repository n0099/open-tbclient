package com.baidu.tieba;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.webpanel.PanelScrollView;
import com.baidu.nadcore.webpanel.model.AdData;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class p41 extends q41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Object e;
    public m41 f;
    public h41 g;
    public o41 h;
    public boolean i;
    public final r41 j;

    /* loaded from: classes7.dex */
    public static final class a extends wi0<p31> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p41 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(p41 p41Var, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p41Var, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p41Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wi0
        public void onEvent(p31 event) {
            AbsNadBrowserView m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (!TextUtils.isEmpty(event.a()) && (m = this.b.j.m()) != null) {
                    AbsNadBrowserView.C(m, event.a(), null, 2, null);
                }
            }
        }
    }

    public p41(r41 container) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {container};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(container, "container");
        this.j = container;
        this.a = "bdmedialive://bdmedialive/common/closeWebview";
        this.b = "bdmedialive://bdmedialive/common/panelSwitchHalfScreen";
        this.c = "bdmedialive://bdmedialive/common/panelSwitchFullScreen";
        this.d = "nadcorevendor://vendor/ad/webPanelControl";
        this.e = new Object();
    }

    public final void l(int i) {
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (d = this.j.d()) != null) {
            ViewGroup.LayoutParams layoutParams = d.getLayoutParams();
            layoutParams.height = i;
            d.setLayoutParams(layoutParams);
        }
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.i = z;
        }
    }

    public final void o(h41 helper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, helper) == null) {
            Intrinsics.checkNotNullParameter(helper, "helper");
            this.g = helper;
        }
    }

    public final void p(m41 m41Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, m41Var) == null) {
            this.f = m41Var;
        }
    }

    public final void q(o41 o41Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, o41Var) == null) {
            this.h = o41Var;
        }
    }

    @Override // com.baidu.tieba.q41
    public boolean c(s41 container, String url) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, container, url)) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(url, "url");
            if (TextUtils.isEmpty(url)) {
                return false;
            }
            if (TextUtils.equals(this.a, url)) {
                g();
                return true;
            } else if (TextUtils.equals(this.b, url)) {
                s();
                return true;
            } else if (TextUtils.equals(this.c, url)) {
                r();
                return true;
            } else if (!StringsKt__StringsJVMKt.startsWith$default(url, this.d, false, 2, null)) {
                return false;
            } else {
                return f(new ue0(url));
            }
        }
        return invokeLL.booleanValue;
    }

    public final void i(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            AbsNadBrowserView m = this.j.m();
            if (z) {
                if (i == 1) {
                    if (m != null) {
                        AbsNadBrowserView.C(m, "javascript:window.onDxdInvoke({'key':'1','value':'start'})", null, 2, null);
                    }
                } else if (i == 2 && m != null) {
                    AbsNadBrowserView.C(m, "javascript:window.onDxdInvoke({'key':'2','value':'start'})", null, 2, null);
                }
            } else if (i == 1) {
                if (m != null) {
                    AbsNadBrowserView.C(m, "javascript:window.onDxdInvoke({'key':'1','value':'end'})", null, 2, null);
                }
            } else if (i == 2) {
                c41.b.b(true);
                if (m != null) {
                    AbsNadBrowserView.C(m, "javascript:window.onDxdInvoke({'key':'2','value':'end'})", null, 2, null);
                }
            }
        }
    }

    @Override // com.baidu.tieba.q41
    public void d(s41 container, String url) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, container, url) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(url, "url");
            AbsNadBrowserView m = container.m();
            if (m != null) {
                AbsNadBrowserView.C(m, "javascript:window.onDxdInvoke({'key':'0'})", null, 2, null);
            }
        }
    }

    public final boolean f(ue0 ue0Var) {
        InterceptResult invokeL;
        boolean z;
        h41 h41Var;
        h41 h41Var2;
        h41 h41Var3;
        h41 h41Var4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ue0Var)) == null) {
            HashMap<String, String> d = ue0Var.d();
            Intrinsics.checkNotNullExpressionValue(d, "model.params");
            String str = (String) my0.b(d, "params");
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            JSONObject c = ly0.c(str);
            Intrinsics.checkNotNullExpressionValue(c, "JSONUtils.newJSONObject(paramsJson)");
            String optString = c.optString("type");
            if (c.optInt(PackageTable.DISABLE, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (optString != null) {
                switch (optString.hashCode()) {
                    case -2119262164:
                        if (optString.equals("slideUp") && (h41Var = this.g) != null) {
                            h41Var.j(z);
                            break;
                        }
                        break;
                    case -796944909:
                        if (optString.equals("slideDown") && (h41Var2 = this.g) != null) {
                            h41Var2.i(z);
                            break;
                        }
                        break;
                    case -102095252:
                        if (optString.equals("slideControl") && (h41Var3 = this.g) != null) {
                            h41Var3.h(z);
                            break;
                        }
                        break;
                    case 1538155302:
                        if (optString.equals("topAreaClick") && (h41Var4 = this.g) != null) {
                            h41Var4.k(z);
                            break;
                        }
                        break;
                }
            }
            String str2 = (String) my0.b(d, WebChromeClient.KEY_ARG_CALLBACK);
            if (!TextUtils.isEmpty(str2)) {
                Map<String, String> v = df0.v(optString, c.optInt(PackageTable.DISABLE, 0));
                my0.e(v, WebChromeClient.KEY_ARG_CALLBACK, str2);
                AbsNadBrowserView m = this.j.m();
                if (m != null) {
                    AbsNadBrowserView.C(m, df0.p(v), null, 2, null);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void g() {
        m41 m41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (m41Var = this.f) != null) {
            m41Var.a(1);
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (m = this.j.m()) != null) {
            AbsNadBrowserView.C(m, "javascript:window.onDxdInvoke({'key':'3'})", null, 2, null);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            si0.a().d(this.e, 1, new a(this, p31.class));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            si0.a().a(this.e);
        }
    }

    public final void m(int i) {
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && (d = this.j.d()) != null && (d.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            ViewGroup.LayoutParams layoutParams = d.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = i;
                d.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    public final void r() {
        AdData adData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            h41 h41Var = this.g;
            if (h41Var != null) {
                l(h41Var.f() + PanelScrollView.B);
                m(0);
                ui0 a2 = si0.a();
                o41 o41Var = this.h;
                if (o41Var != null) {
                    adData = o41Var.a();
                } else {
                    adData = null;
                }
                a2.b(new j41(3, adData));
                this.i = true;
            }
            o41 o41Var2 = this.h;
            if (o41Var2 != null) {
                v41.a(ClogBuilder.LogType.DAZZLE_TRANS_SLIDING_COUNT, "", MapBundleKey.OfflineMapKey.OFFLINE_UPDATE, o41Var2.f());
            }
            c41.b.b(true);
        }
    }

    public final void s() {
        AdData adData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            h41 h41Var = this.g;
            if (h41Var != null) {
                l((h41Var.f() - h41Var.e()) + PanelScrollView.B);
                m(h41Var.e());
                ui0 a2 = si0.a();
                o41 o41Var = this.h;
                if (o41Var != null) {
                    adData = o41Var.a();
                } else {
                    adData = null;
                }
                a2.b(new j41(4, adData));
                this.i = true;
            }
            o41 o41Var2 = this.h;
            if (o41Var2 != null) {
                v41.a(ClogBuilder.LogType.DAZZLE_TRANS_SLIDING_COUNT, "", "down", o41Var2.f());
            }
            c41.b.b(false);
        }
    }
}
