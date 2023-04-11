package com.baidu.tieba;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tv8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewStub a;
    public PbGiftListView b;
    public ViewStub c;
    public LinearLayout d;
    public View e;
    public BaseWebView f;

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements BaseWebView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public a(tv8 tv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(tv8 tv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tv8 a;

        public c(tv8 tv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tv8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a.f != null) {
                        this.a.f.destroy();
                        this.a.f = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    public tv8(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f090dc8);
        this.c = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09148f);
    }

    public void a() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (baseWebView = this.f) != null) {
            baseWebView.removeAllViews();
            this.f.getSettings().setBuiltInZoomControls(true);
            this.f.setVisibility(8);
            jg.a().postDelayed(new c(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void b(ny4 ny4Var, String str, String str2, long j, long j2, long j3) {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{ny4Var, str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            if (ny4Var != null && !ListUtils.isEmpty(ny4Var.a()) && (viewStub = this.a) != null) {
                if (this.b == null) {
                    this.b = (PbGiftListView) viewStub.inflate();
                }
                this.b.setVisibility(0);
                this.b.g(ny4Var, str, str2, j, j2, j3);
                this.b.i();
                return;
            }
            PbGiftListView pbGiftListView = this.b;
            if (pbGiftListView != null) {
                pbGiftListView.setVisibility(8);
            }
        }
    }

    public void c(cy4 cy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cy4Var) == null) && cy4Var != null && !hi.isEmpty(cy4Var.e())) {
            BaseWebView baseWebView = this.f;
            if ((baseWebView == null || !baseWebView.getIsLoaded()) && cy4Var.c() == cy4.g && this.c != null) {
                if (cy4Var.f()) {
                    LinearLayout linearLayout = this.d;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (this.d == null) {
                    LinearLayout linearLayout2 = (LinearLayout) this.c.inflate();
                    this.d = linearLayout2;
                    this.e = linearLayout2.findViewById(R.id.obfuscated_res_0x7f09148a);
                    this.f = (BaseWebView) this.d.findViewById(R.id.obfuscated_res_0x7f091490);
                }
                this.e.setVisibility(0);
                SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
                this.f.setVisibility(0);
                this.f.setFocusable(false);
                this.f.setBackgroundColor(0);
                this.f.getSettings().setCacheMode(-1);
                this.f.setVerticalScrollBarEnabled(false);
                this.f.setHorizontalScrollBarEnabled(false);
                this.f.getSettings().setAllowFileAccess(true);
                this.f.getSettings().setAppCacheEnabled(true);
                this.f.getSettings().setDomStorageEnabled(true);
                this.f.getSettings().setDatabaseEnabled(true);
                this.f.setOnLoadUrlListener(new a(this));
                this.f.setOnPageFinishedListener(new b(this));
                this.f.loadUrl(cy4Var.e());
            }
        }
    }

    public void d() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (baseWebView = this.f) != null) {
            try {
                baseWebView.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void e() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (baseWebView = this.f) != null) {
            try {
                baseWebView.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
