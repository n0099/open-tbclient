package com.baidu.tieba.write.vcode.newVcode;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.m.e;
import d.a.p0.s.f0.a;
import d.a.p0.s.f0.c;
import d.a.q0.a4.s.a.a.b;
/* loaded from: classes4.dex */
public class NewVcodeView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f22787a;

    /* renamed from: b  reason: collision with root package name */
    public b f22788b;

    /* renamed from: c  reason: collision with root package name */
    public BaseWebView f22789c;

    /* renamed from: d  reason: collision with root package name */
    public View f22790d;

    /* renamed from: e  reason: collision with root package name */
    public View f22791e;

    /* renamed from: f  reason: collision with root package name */
    public a f22792f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22793g;

    /* renamed from: h  reason: collision with root package name */
    public c f22794h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f22795i;
    public Runnable j;
    public float k;

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newVcodeActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22789c = null;
        this.f22790d = null;
        this.f22791e = null;
        this.f22792f = null;
        this.f22793g = null;
        this.f22794h = null;
        this.f22795i = false;
        this.j = new Runnable(this) { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ NewVcodeView f22796e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f22796e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f22796e.f22789c == null) {
                    return;
                }
                this.f22796e.showWebView(true);
            }
        };
        this.f22787a = newVcodeActivity;
        if (initUI(newVcodeActivity)) {
            return;
        }
        newVcodeActivity.finish();
    }

    @JavascriptInterface
    @SuppressLint({"SetJavaScriptEnabled"})
    private boolean initUI(NewVcodeActivity newVcodeActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, newVcodeActivity)) == null) {
            newVcodeActivity.setActivityBgTransparent();
            newVcodeActivity.setSwipeBackEnabled(false);
            newVcodeActivity.setContentView(R.layout.new_vcode_activity);
            View findViewById = newVcodeActivity.findViewById(R.id.new_vcode_black_layout);
            this.f22790d = findViewById;
            findViewById.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ NewVcodeView f22797e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f22797e = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f22797e.f22788b.d();
                        this.f22797e.f22787a.finish();
                    }
                }
            });
            View findViewById2 = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
            this.f22791e = findViewById2;
            TextView textView = (TextView) findViewById2.findViewById(R.id.custom_loading_text);
            this.f22793g = textView;
            textView.setText(newVcodeActivity.getResources().getString(R.string.sending));
            c cVar = new c();
            this.f22794h = cVar;
            cVar.f52989a = 1000L;
            if (this.f22789c == null) {
                try {
                    this.f22789c = (BaseWebView) newVcodeActivity.findViewById(R.id.new_vcode_webview);
                    UtilHelper.setSupportHeight(newVcodeActivity.getPageContext().getPageActivity(), this.f22789c, 1.2631578f);
                    this.f22789c.setBackgroundColor(newVcodeActivity.getResources().getColor(17170443));
                    this.f22789c.setInitialScale(100);
                    this.f22789c.getSettings().setJavaScriptEnabled(true);
                    this.f22789c.removeJavascriptInterface("searchBoxJavaBridge_");
                    this.f22789c.setWebViewClient(new WebViewClient(this) { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ NewVcodeView f22798a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f22798a = this;
                        }

                        @Override // android.webkit.WebViewClient
                        public void onPageFinished(WebView webView, String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                                super.onPageFinished(webView, str);
                                this.f22798a.f22795i = true;
                                if (this.f22798a.f22788b != null) {
                                    this.f22798a.f22788b.onPageFinished(webView, str);
                                }
                            }
                        }

                        @Override // android.webkit.WebViewClient
                        public void onReceivedError(WebView webView, int i2, String str, String str2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i2, str, str2) == null) {
                                super.onReceivedError(webView, i2, str, str2);
                                this.f22798a.h(false);
                                this.f22798a.f22787a.showToast(R.string.neterror);
                                this.f22798a.f22787a.finish();
                            }
                        }

                        @Override // android.webkit.WebViewClient
                        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                            InterceptResult invokeLL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str)) == null) {
                                if (StringUtils.isNull(str)) {
                                    return false;
                                }
                                if (!this.f22798a.f22795i) {
                                    this.f22798a.f22795i = true;
                                    e.a().postDelayed(this.f22798a.j, 500L);
                                    if (this.f22798a.f22788b != null) {
                                        this.f22798a.f22788b.onPageFinished(webView, str);
                                    }
                                }
                                if (this.f22798a.f22788b == null) {
                                    return false;
                                }
                                return this.f22798a.f22788b.b(webView, str);
                            }
                            return invokeLL.booleanValue;
                        }
                    });
                    return true;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    TbadkCoreApplication.getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() + 1);
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public BaseActivity getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22787a : (BaseActivity) invokeV.objValue;
    }

    public WebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22789c : (WebView) invokeV.objValue;
    }

    public final void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (this.f22792f == null) {
                a aVar = new a(this.f22787a.getPageContext());
                this.f22792f = aVar;
                aVar.e(new DialogInterface.OnCancelListener(this) { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ NewVcodeView f22799e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f22799e = this;
                    }

                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            this.f22799e.f22787a.finish();
                        }
                    }
                });
            }
            this.f22792f.h(z);
        }
    }

    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e.a().removeCallbacks(this.j);
        }
    }

    public void runJsMethod(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) || this.f22789c == null) {
            return;
        }
        this.f22789c.loadUrl("javascript:window." + str + "(" + str2 + SmallTailInfo.EMOTION_SUFFIX);
    }

    public void setPresenter(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f22788b = bVar;
            this.f22795i = false;
        }
    }

    public void setRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            this.k = f2;
        }
    }

    public void showPostThreadLoadingView(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (view = this.f22791e) == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void showToast(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, str) == null) {
            if (z) {
                this.f22794h.c(str);
            } else {
                this.f22794h.b(str);
            }
        }
    }

    public void showWebView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            h(!z);
            BaseWebView baseWebView = this.f22789c;
            if (baseWebView != null) {
                if (z) {
                    UtilHelper.setSupportHeight(this.f22787a.getPageContext().getPageActivity(), this.f22789c, this.k);
                    this.f22789c.setVisibility(0);
                    return;
                }
                baseWebView.setVisibility(8);
            }
        }
    }

    public void showWebViewDelay(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            e.a().postDelayed(this.j, i2);
        }
    }
}
