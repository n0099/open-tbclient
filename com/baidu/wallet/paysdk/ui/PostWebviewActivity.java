package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.webmanager.SafeWebView;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity;
/* loaded from: classes5.dex */
public class PostWebviewActivity extends DxmPayBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public SafeWebView f25864a;

    /* loaded from: classes5.dex */
    public class a extends SafeWebView.SafeChromeClient {
        public a() {
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            PostWebviewActivity postWebviewActivity = PostWebviewActivity.this;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            postWebviewActivity.a(str);
        }
    }

    public static void startPostWebview(Context context, String str, byte[] bArr, String str2) {
        if (context == null) {
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

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        byte[] bArr;
        String str;
        super.onCreate(bundle);
        setContentView(ResUtils.layout(getActivity(), "wallet_base_webview_layout"));
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
        this.f25864a = (SafeWebView) findViewById(ResUtils.id(getActivity(), "cust_webview"));
        if (TextUtils.isEmpty(str2)) {
            this.f25864a.setWebChromeClient(new a());
        }
        this.f25864a.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT <= 18) {
            this.f25864a.getSettings().setSavePassword(false);
        }
        this.f25864a.setScrollBarStyle(0);
        this.f25864a.clearCache(false);
        this.f25864a.resumeTimers();
        if (Build.VERSION.SDK_INT >= 11) {
            this.f25864a.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f25864a.removeJavascriptInterface("accessibility");
            this.f25864a.removeJavascriptInterface("accessibilityTraversal");
        }
        if (bArr != null) {
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (bArr.length != 0) {
                this.f25864a.postUrl(str.trim(), bArr);
                a(str2);
            }
        }
        this.f25864a.loadUrl(str.trim());
        a(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
        if (bdActionBar != null) {
            bdActionBar.setTitle(str);
            bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PostWebviewActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(PostWebviewActivity.this.getActivity());
                    PostWebviewActivity.this.onBackPressed();
                }
            });
        }
    }
}
