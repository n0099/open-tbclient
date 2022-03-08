package com.baidu.tieba.write.vcode.newVcode;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.q0.r.l0.a;
import c.a.q0.r.l0.c;
import c.a.r0.q4.s.a.a.b;
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
/* loaded from: classes6.dex */
public class NewVcodeView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;

    /* renamed from: b  reason: collision with root package name */
    public b f48261b;

    /* renamed from: c  reason: collision with root package name */
    public BaseWebView f48262c;

    /* renamed from: d  reason: collision with root package name */
    public View f48263d;

    /* renamed from: e  reason: collision with root package name */
    public a f48264e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f48265f;

    /* renamed from: g  reason: collision with root package name */
    public c f48266g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48267h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f48268i;

    /* renamed from: j  reason: collision with root package name */
    public float f48269j;

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
        this.f48262c = null;
        this.f48263d = null;
        this.f48264e = null;
        this.f48265f = null;
        this.f48266g = null;
        this.f48267h = false;
        this.f48268i = new Runnable(this) { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ NewVcodeView f48270e;

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
                this.f48270e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f48270e.f48262c == null) {
                    return;
                }
                this.f48270e.showWebView(true);
            }
        };
        this.a = newVcodeActivity;
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
            View findViewById = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
            this.f48263d = findViewById;
            TextView textView = (TextView) findViewById.findViewById(R.id.custom_loading_text);
            this.f48265f = textView;
            textView.setText(newVcodeActivity.getResources().getString(R.string.sending));
            c cVar = new c();
            this.f48266g = cVar;
            cVar.a = 1000L;
            if (this.f48262c == null) {
                try {
                    this.f48262c = (BaseWebView) newVcodeActivity.findViewById(R.id.new_vcode_webview);
                    UtilHelper.setSupportHeight(newVcodeActivity.getPageContext().getPageActivity(), this.f48262c, 1.2631578f);
                    this.f48262c.setBackgroundColor(newVcodeActivity.getResources().getColor(17170443));
                    this.f48262c.setInitialScale(100);
                    this.f48262c.getSettings().setJavaScriptEnabled(true);
                    this.f48262c.removeJavascriptInterface("searchBoxJavaBridge_");
                    this.f48262c.setWebViewClient(new WebViewClient(this) { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ NewVcodeView a;

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
                            this.a = this;
                        }

                        @Override // android.webkit.WebViewClient
                        public void onPageFinished(WebView webView, String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                                super.onPageFinished(webView, str);
                                this.a.f48267h = true;
                                if (this.a.f48261b != null) {
                                    this.a.f48261b.onPageFinished(webView, str);
                                }
                            }
                        }

                        @Override // android.webkit.WebViewClient
                        public void onReceivedError(WebView webView, int i2, String str, String str2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i2, str, str2) == null) {
                                super.onReceivedError(webView, i2, str, str2);
                                this.a.h(false);
                                this.a.a.showToast(R.string.neterror);
                                this.a.a.finish();
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
                                if (!this.a.f48267h) {
                                    this.a.f48267h = true;
                                    e.a().postDelayed(this.a.f48268i, 500L);
                                    if (this.a.f48261b != null) {
                                        this.a.f48261b.onPageFinished(webView, str);
                                    }
                                }
                                if (this.a.f48261b == null) {
                                    return false;
                                }
                                return this.a.f48261b.b(webView, str);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (BaseActivity) invokeV.objValue;
    }

    public WebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f48262c : (WebView) invokeV.objValue;
    }

    public final void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (this.f48264e == null) {
                a aVar = new a(this.a.getPageContext());
                this.f48264e = aVar;
                aVar.e(new DialogInterface.OnCancelListener(this) { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ NewVcodeView f48271e;

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
                        this.f48271e = this;
                    }

                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            this.f48271e.a.finish();
                        }
                    }
                });
            }
            this.f48264e.h(z);
        }
    }

    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e.a().removeCallbacks(this.f48268i);
        }
    }

    public void runJsMethod(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) || this.f48262c == null) {
            return;
        }
        this.f48262c.loadUrl("javascript:window." + str + "(" + str2 + SmallTailInfo.EMOTION_SUFFIX);
    }

    public void setPresenter(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f48261b = bVar;
            this.f48267h = false;
        }
    }

    public void setRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            this.f48269j = f2;
        }
    }

    public void showPostThreadLoadingView(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (view = this.f48263d) == null) {
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
                this.f48266g.c(str);
            } else {
                this.f48266g.b(str);
            }
        }
    }

    public void showWebView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            h(!z);
            BaseWebView baseWebView = this.f48262c;
            if (baseWebView != null) {
                if (z) {
                    UtilHelper.setSupportHeight(this.a.getPageContext().getPageActivity(), this.f48262c, this.f48269j);
                    this.f48262c.setVisibility(0);
                    return;
                }
                baseWebView.setVisibility(8);
            }
        }
    }

    public void showWebViewDelay(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            e.a().postDelayed(this.f48268i, i2);
        }
    }
}
