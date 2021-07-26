package com.bytedance.sdk.openadsdk.dislike;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompatJellybean;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.e;
import com.bytedance.sdk.openadsdk.e.d;
/* loaded from: classes5.dex */
public class TTDislikeWebViewActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f31194a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f31195b;

    /* renamed from: c  reason: collision with root package name */
    public SSWebView f31196c;

    /* renamed from: d  reason: collision with root package name */
    public String f31197d;

    /* renamed from: e  reason: collision with root package name */
    public String f31198e;

    /* renamed from: f  reason: collision with root package name */
    public String f31199f;

    /* renamed from: g  reason: collision with root package name */
    public String f31200g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f31201h;

    public TTDislikeWebViewActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31201h = false;
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(t.f(this, "tt_activity_lite_web_layout"));
            this.f31194a = findViewById(t.e(this, "tt_lite_web_back"));
            this.f31195b = (TextView) findViewById(t.e(this, "tt_lite_web_title"));
            this.f31196c = (SSWebView) findViewById(t.e(this, "tt_lite_web_view"));
            this.f31194a.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeWebViewActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTDislikeWebViewActivity f31202a;

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
                    this.f31202a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f31202a.onBackPressed();
                    }
                }
            });
            if (getIntent() != null) {
                a();
                this.f31195b.setText(getIntent().getStringExtra("title"));
                this.f31199f = getIntent().getStringExtra(LegoListActivityConfig.AD_ID);
                this.f31198e = getIntent().getStringExtra("tag");
                this.f31197d = getIntent().getStringExtra("log_extra");
                this.f31200g = getIntent().getStringExtra(NotificationCompatJellybean.KEY_LABEL);
                this.f31196c.loadUrl(getIntent().getStringExtra("url"));
                return;
            }
            finish();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f31196c.getSettings().setJavaScriptEnabled(true);
            this.f31196c.getSettings().setDisplayZoomControls(false);
            this.f31196c.getSettings().setCacheMode(2);
            this.f31196c.setWebViewClient(new e(this, this, null, null) { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeWebViewActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTDislikeWebViewActivity f31203a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(this, r11, r12);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, this, r11, r12};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (w) objArr2[1], (String) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f31203a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        super.onPageFinished(webView, str);
                        k.b("TTDislikeWebViewActivity", "onPageFinished result : " + this.f31203a.f31201h);
                        if (this.f31203a.f31201h) {
                            return;
                        }
                        TTDislikeWebViewActivity tTDislikeWebViewActivity = this.f31203a;
                        d.a(tTDislikeWebViewActivity, tTDislikeWebViewActivity.f31199f, this.f31203a.f31197d, this.f31203a.f31198e, this.f31203a.f31200g);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, webResourceRequest, webResourceError) == null) {
                        super.onReceivedError(webView, webResourceRequest, webResourceError);
                        k.b("TTDislikeWebViewActivity", "onReceivedError error : " + webResourceError);
                        this.f31203a.f31201h = true;
                    }
                }
            });
        }
    }
}
