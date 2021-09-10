package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.webmanager.SafeWebView;
import com.dxmpay.wallet.base.widget.BdActionBar;
import com.dxmpay.wallet.core.SDKBaseActivity;
/* loaded from: classes8.dex */
public class PostWebviewActivity extends DxmPayBaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SafeWebView f63037a;

    /* loaded from: classes8.dex */
    public class a extends SafeWebView.SafeChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PostWebviewActivity f63039a;

        public a(PostWebviewActivity postWebviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postWebviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63039a = postWebviewActivity;
        }

        @Override // com.dxmpay.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onReceivedTitle(webView, str);
                PostWebviewActivity postWebviewActivity = this.f63039a;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                postWebviewActivity.a(str);
            }
        }
    }

    public PostWebviewActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void startPostWebview(Context context, String str, byte[] bArr, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65539, null, context, str, bArr, str2) == null) || context == null) {
            return;
        }
        Intent intent = new Intent(context, PostWebviewActivity.class);
        intent.putExtra("jump_url", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("web_title", str2);
        }
        if (bArr != null && bArr.length > 0) {
            intent.putExtra("url_post_data", bArr);
        }
        context.startActivity(intent);
    }

    @Override // com.dxmpay.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SDKBaseActivity.BottomBarType.NONE : (SDKBaseActivity.BottomBarType) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        byte[] bArr;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(ResUtils.layout(getActivity(), "dxm_wallet_base_webview_layout"));
            Bundle extras = getIntent().getExtras();
            String str2 = "";
            if (extras != null) {
                str = extras.getString("jump_url");
                bArr = extras.getByteArray("url_post_data");
                str2 = extras.getString("web_title", "");
            } else {
                bArr = null;
                str = "";
            }
            this.f63037a = (SafeWebView) findViewById(ResUtils.id(getActivity(), "dxm_cust_webview"));
            if (TextUtils.isEmpty(str2)) {
                this.f63037a.setWebChromeClient(new a());
            }
            this.f63037a.getSettings().setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT <= 18) {
                this.f63037a.getSettings().setSavePassword(false);
            }
            this.f63037a.setScrollBarStyle(0);
            this.f63037a.clearCache(false);
            this.f63037a.resumeTimers();
            if (Build.VERSION.SDK_INT >= 11) {
                this.f63037a.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f63037a.removeJavascriptInterface("accessibility");
                this.f63037a.removeJavascriptInterface("accessibilityTraversal");
            }
            if (bArr != null) {
                try {
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (bArr.length != 0) {
                    this.f63037a.postUrl(str.trim(), bArr);
                    a(str2);
                }
            }
            this.f63037a.loadUrl(str.trim());
            a(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        BdActionBar bdActionBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, str) == null) || (bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"))) == null) {
            return;
        }
        bdActionBar.setTitle(str);
        bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PostWebviewActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PostWebviewActivity f63038a;

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
                this.f63038a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    GlobalUtils.hideKeyboard(this.f63038a.getActivity());
                    this.f63038a.onBackPressed();
                }
            }
        });
    }
}
