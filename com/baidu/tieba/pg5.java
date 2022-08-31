package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.view.NestedScrollWebView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.widget.floatball.FloatWebLayout;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class pg5 implements lb5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Context a;
    public LinearLayout b;
    public final FloatWebLayout c;
    public final NestedScrollWebView d;
    public final FrameLayout e;
    public l65 f;
    public k65 g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public String l;
    public final tl8 m;
    public final vl8 n;

    /* loaded from: classes5.dex */
    public class a implements vl8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pg5 a;

        public a(pg5 pg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pg5Var;
        }

        @Override // com.baidu.tieba.vl8
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.a.m != null) {
                    return this.a.m.b(this.a.d, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pg5 a;

        public b(pg5 pg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pg5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!pi.z()) {
                    ri.M(this.a.a, R.string.obfuscated_res_0x7f0f0c40);
                } else {
                    this.a.u();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pg5 a;

        public c(pg5 pg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pg5Var;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.a.h = false;
                if (this.a.d == null || this.a.e == null) {
                    return;
                }
                if (this.a.i) {
                    this.a.d.stopLoading();
                    this.a.d.setVisibility(8);
                    this.a.e.setVisibility(0);
                    this.a.w();
                    this.a.C();
                    return;
                }
                this.a.j = false;
                this.a.d.setVisibility(0);
                this.a.e.setVisibility(8);
                this.a.w();
                this.a.x();
                this.a.c.setCenterTitle(webView.getTitle());
                if (this.a.d.canGoBack()) {
                    this.a.c.k();
                } else {
                    this.a.c.d();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.a.d == null || this.a.e == null) {
                    return;
                }
                this.a.i = false;
                if (this.a.j) {
                    this.a.h = true;
                    this.a.e.setVisibility(0);
                    this.a.B();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                this.a.i = true;
                if (this.a.d == null || this.a.e == null) {
                    return;
                }
                this.a.d.stopLoading();
                this.a.d.setVisibility(8);
                this.a.e.setVisibility(0);
                this.a.w();
                this.a.C();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str) || this.a.d == null) {
                    return false;
                }
                if (this.a.j) {
                    this.a.j = false;
                    return false;
                } else if (this.a.t(str) && !TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.a);
                    return false;
                } else {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pg5 a;

        public d(pg5 pg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pg5Var;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) || StringUtils.isNull(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                this.a.a.startActivity(intent);
            }
        }

        public /* synthetic */ d(pg5 pg5Var, a aVar) {
            this(pg5Var);
        }
    }

    public pg5(@NonNull Context context, LinearLayout linearLayout, FloatWebLayout floatWebLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, linearLayout, floatWebLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = true;
        this.k = true;
        this.n = new a(this);
        this.a = context;
        this.b = linearLayout;
        this.c = floatWebLayout;
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0493, (ViewGroup) linearLayout, true);
        this.d = (NestedScrollWebView) inflate.findViewById(R.id.obfuscated_res_0x7f0925f5);
        this.e = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0913ed);
        tl8 tl8Var = new tl8();
        this.m = tl8Var;
        tl8Var.a(new CommonTbJsBridge(context));
        this.m.a(new UegTbJsBridge(context));
        km4.g(context);
        y();
    }

    public void A() {
        NestedScrollWebView nestedScrollWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (nestedScrollWebView = this.d) == null) {
            return;
        }
        try {
            nestedScrollWebView.onPause();
        } catch (Exception e) {
            e.printStackTrace();
        }
        r(MissionEvent.MESSAGE_PAUSE);
        tl8 tl8Var = this.m;
        if (tl8Var != null) {
            tl8Var.i(this.d, CommonTbJsBridge.RE_HIDE, null);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k65 k65Var = this.g;
            if (k65Var == null || !k65Var.isViewAttached()) {
                if (this.g == null) {
                    k65 k65Var2 = new k65(this.a);
                    this.g = k65Var2;
                    k65Var2.r(TbadkCoreApplication.getInst().getSkinType());
                    this.g.onChangeSkinType();
                }
                this.g.attachView(this.e, false);
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f == null) {
                this.f = new l65(this.a, new b(this));
            }
            this.f.n(this.a.getString(R.string.obfuscated_res_0x7f0f14d8));
            this.f.g(this.a.getString(R.string.obfuscated_res_0x7f0f0fba));
            this.f.i(R.drawable.new_pic_emotion_08);
            this.f.attachView(this.e, false);
            this.f.p();
        }
    }

    @Override // com.baidu.tieba.mb5
    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lb5
    public void J(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
        }
    }

    @Override // com.baidu.tieba.mb5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mb5
    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
        }
    }

    public void onDestroy() {
        tl8 tl8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (tl8Var = this.m) == null) {
            return;
        }
        tl8Var.g();
    }

    public void onResume() {
        NestedScrollWebView nestedScrollWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (nestedScrollWebView = this.d) == null) {
            return;
        }
        try {
            nestedScrollWebView.onResume();
        } catch (Exception e) {
            e.printStackTrace();
        }
        r("onResume");
        tl8 tl8Var = this.m;
        if (tl8Var != null) {
            tl8Var.i(this.d, CommonTbJsBridge.RE_SHOW, null);
            if (CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.WEB && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NONE && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NATIVE_WEB && !this.k) {
                this.m.i(this.d, CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
            }
        }
        this.k = false;
    }

    public final void r(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || this.d == null) {
            return;
        }
        try {
            WebView.class.getMethod(str, new Class[0]).invoke(this.d, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.mb5
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.d.getScrollY() == 0 : invokeV.booleanValue;
    }

    public final boolean t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.contains("tieba_check_login=1");
        }
        return invokeL.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.e == null || this.d == null || this.h || TextUtils.isEmpty(this.l) || !pi.z()) {
            return;
        }
        this.h = true;
        this.j = true;
        this.e.setVisibility(0);
        this.d.setVisibility(8);
        x();
        B();
        z(this.l, true);
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            NestedScrollWebView nestedScrollWebView = this.d;
            if (nestedScrollWebView == null || !nestedScrollWebView.canGoBack()) {
                return false;
            }
            this.d.goBack();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void w() {
        k65 k65Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (k65Var = this.g) == null) {
            return;
        }
        k65Var.dettachView(this.e);
    }

    public final void x() {
        l65 l65Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (l65Var = this.f) == null) {
            return;
        }
        l65Var.dettachView(this.e);
    }

    public void y() {
        NestedScrollWebView nestedScrollWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (nestedScrollWebView = this.d) == null) {
            return;
        }
        nestedScrollWebView.setNeedDisAllowParentInterceptTouchEvent(false);
        this.d.getSettings().setJavaScriptEnabled(true);
        this.d.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.d.getSettings().setAllowFileAccess(true);
        this.d.getSettings().setDatabaseEnabled(true);
        this.d.getSettings().setDomStorageEnabled(true);
        this.d.getSettings().setSupportZoom(true);
        this.d.getSettings().setBuiltInZoomControls(true);
        this.d.getSettings().setUseWideViewPort(true);
        this.d.getSettings().setLoadWithOverviewMode(true);
        this.d.getSettings().setDatabasePath(this.a.getApplicationContext().getDir(NgWebView.APP_DATABASE_PATH, 0).getAbsolutePath());
        this.d.setHorizontalScrollBarEnabled(false);
        this.d.setHorizontalScrollbarOverlay(false);
        this.d.setInitialScale(100);
        this.d.setScrollBarStyle(33554432);
        this.d.setWebViewClient(new c(this));
        this.d.setDownloadListener(new d(this, null));
        if (this.a instanceof Activity) {
            og5 og5Var = new og5((Activity) this.a);
            og5Var.b(this.n);
            this.d.setWebChromeClient(og5Var);
        }
        CompatibleUtile.getInstance().removeJavascriptInterface(this.d);
    }

    public void z(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048593, this, str, z) == null) || this.d == null) {
            return;
        }
        if (z || this.j) {
            this.l = str;
            CompatibleUtile.getInstance().loadUrl(this.d, str);
        }
    }
}
