package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.widget.floatball.FloatWebLayout;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xz5 implements wz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Context a;
    public LinearLayout b;
    public final FloatWebLayout c;
    public final TbWebView d;
    public final FrameLayout e;
    public an5 f;
    public zm5 g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public String l;

    @Override // com.baidu.tieba.mt5
    public void P(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
        }
    }

    @Override // com.baidu.tieba.nt5
    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.nt5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nt5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz5 a;

        public a(xz5 xz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    wi.P(this.a.a, R.string.obfuscated_res_0x7f0f0df3);
                } else {
                    this.a.s();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz5 a;

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public b(xz5 xz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz5Var;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.a.h = false;
                if (this.a.d != null && this.a.e != null) {
                    if (this.a.i) {
                        this.a.d.getController().e();
                        this.a.d.setVisibility(8);
                        this.a.e.setVisibility(0);
                        this.a.t();
                        this.a.x();
                        return;
                    }
                    this.a.j = false;
                    this.a.d.setVisibility(0);
                    this.a.e.setVisibility(8);
                    this.a.t();
                    this.a.u();
                    this.a.c.setCenterTitle(webView.getTitle());
                    if (this.a.d.getController().a()) {
                        this.a.c.k();
                    } else {
                        this.a.c.d();
                    }
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.a.d != null && this.a.e != null) {
                    this.a.i = false;
                    if (this.a.j) {
                        this.a.h = true;
                        this.a.e.setVisibility(0);
                        this.a.w();
                    }
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                this.a.i = true;
                if (this.a.d != null && this.a.e != null) {
                    this.a.d.getController().e();
                    this.a.d.setVisibility(8);
                    this.a.e.setVisibility(0);
                    this.a.t();
                    this.a.x();
                }
            }
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
                } else if (this.a.r(str) && !TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.a);
                    return false;
                } else {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz5 a;

        public c(xz5 xz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz5Var;
        }

        public /* synthetic */ c(xz5 xz5Var, a aVar) {
            this(xz5Var);
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) != null) || StringUtils.isNull(str)) {
                return;
            }
            Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str));
            if (!UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                return;
            }
            this.a.a.startActivity(intent);
        }
    }

    public xz5(@NonNull Context context, LinearLayout linearLayout, FloatWebLayout floatWebLayout) {
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
        this.a = context;
        this.b = linearLayout;
        this.c = floatWebLayout;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_float_new_web_content_view, (ViewGroup) linearLayout, true);
        this.d = (TbWebView) inflate.findViewById(R.id.obfuscated_res_0x7f092929);
        this.e = (FrameLayout) inflate.findViewById(R.id.load_state_container);
        rx4.k(context);
        v();
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && this.d != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.d, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.contains("tieba_check_login=1");
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.wz5
    public void m1(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) && this.d != null) {
            if (z || this.j) {
                this.l = str;
                this.d.loadUrl(str);
            }
        }
    }

    @Override // com.baidu.tieba.wz5
    public boolean goBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TbWebView tbWebView = this.d;
            if (tbWebView != null && tbWebView.getController().a()) {
                this.d.getController().c();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.wz5
    public void onDestroy() {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (tbWebView = this.d) != null) {
            tbWebView.onDestroy();
        }
    }

    @Override // com.baidu.tieba.wz5
    public void onPause() {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (tbWebView = this.d) == null) {
            return;
        }
        try {
            tbWebView.onPause();
        } catch (Exception e) {
            e.printStackTrace();
        }
        p(MissionEvent.MESSAGE_PAUSE);
        am6.a().d(this.d, CommonTbJsBridge.RE_HIDE, null);
    }

    public final void t() {
        zm5 zm5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (zm5Var = this.g) != null) {
            zm5Var.dettachView(this.e);
        }
    }

    public final void u() {
        an5 an5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (an5Var = this.f) != null) {
            an5Var.dettachView(this.e);
        }
    }

    @Override // com.baidu.tieba.nt5
    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.d.getScrollY() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.wz5
    public void onResume() {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (tbWebView = this.d) == null) {
            return;
        }
        try {
            tbWebView.onResume();
        } catch (Exception e) {
            e.printStackTrace();
        }
        p("onResume");
        am6.a().d(this.d, CommonTbJsBridge.RE_SHOW, null);
        if (CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.WEB && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NONE && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NATIVE_WEB && !this.k) {
            am6.a().d(this.d, CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
        }
        this.k = false;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.e != null && this.d != null && !this.h && !TextUtils.isEmpty(this.l) && BdNetTypeUtil.isNetWorkAvailable()) {
            this.h = true;
            this.j = true;
            this.e.setVisibility(0);
            this.d.setVisibility(8);
            u();
            w();
            m1(this.l, true);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f == null) {
                this.f = new an5(this.a, new a(this));
            }
            this.f.n(this.a.getString(R.string.url_not_found));
            this.f.g(this.a.getString(R.string.obfuscated_res_0x7f0f11ca));
            this.f.i(R.drawable.new_pic_emotion_08);
            this.f.attachView(this.e, false);
            this.f.p();
        }
    }

    public void v() {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (tbWebView = this.d) != null) {
            tbWebView.setHorizontalScrollBarEnabled(false);
            this.d.setScrollBarStyle(33554432);
            this.d.setWebViewClient(new b(this));
            this.d.setDownloadListener(new c(this, null));
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            zm5 zm5Var = this.g;
            if (zm5Var != null && zm5Var.isViewAttached()) {
                return;
            }
            if (this.g == null) {
                zm5 zm5Var2 = new zm5(this.a);
                this.g = zm5Var2;
                zm5Var2.s(TbadkCoreApplication.getInst().getSkinType());
                this.g.onChangeSkinType();
            }
            this.g.attachView(this.e, false);
        }
    }
}
