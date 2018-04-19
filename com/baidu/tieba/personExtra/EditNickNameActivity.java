package com.baidu.tieba.personExtra;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.j.g;
import com.baidu.tieba.d;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class EditNickNameActivity extends BaseActivity<EditNickNameActivity> {
    private com.baidu.tbadk.core.dialog.a JV;
    private com.baidu.tbadk.j.f bha;
    private final String fFU = "https://tieba.baidu.com/n/interact/modifyname";
    private NavigationBar mNavigationBar;
    private TbPageContext<EditNickNameActivity> mPageContext;
    private g mRefreshView;
    private View mRootView;
    private int mType;
    private String mUrl;
    private BaseWebView mWebView;
    private boolean wI;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        this.mType = getIntent().getIntExtra(EditNickNameActivityConfig.PARAM_TYPE, 0);
        this.mUrl = getIntent().getStringExtra(EditNickNameActivityConfig.PARAM_URL);
        if (TextUtils.isEmpty(this.mUrl)) {
            this.mUrl = "https://tieba.baidu.com/n/interact/modifyname";
        }
        setContentView(d.i.edit_nickname_activity);
        initView();
        com.baidu.tbadk.browser.a.ar(getApplicationContext());
    }

    private void initView() {
        this.mRootView = findViewById(d.g.root_layout);
        this.mWebView = (BaseWebView) findViewById(d.g.webview);
        this.mWebView.setWebViewClient(new a());
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        if (this.mType == 0) {
            this.mNavigationBar.setCenterTextTitle(getResources().getString(d.k.modify_nickname));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditNickNameActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EditNickNameActivity.this.bej();
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.mWebView.loadUrl(iW(this.mUrl));
        } else {
            this.mWebView.loadUrl(this.mUrl);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private String iW(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        try {
            if (StringUtils.isNull(new URL(str).getQuery())) {
                str = str + "?isNightModel=1";
            } else {
                str = str + "&isNightModel=1";
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc(String str) {
        if (this.mWebView != null && this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921033, str));
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bej() {
        if (this.wI && this.mWebView != null && !TextUtils.isEmpty(this.mWebView.getUrl()) && this.mWebView.getUrl().contains("https://tieba.baidu.com/n/interact/modifyname")) {
            this.mWebView.loadUrl("javascript:__js_bridge_modify_name_back_action()");
        } else {
            rc(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bek() {
        this.mWebView.loadUrl("javascript:__js_bridge_modify_name_save_action()");
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.bha = new com.baidu.tbadk.j.f(this.mPageContext.getPageActivity());
            this.bha.d(this.mRootView, false);
            this.bha.onChangeSkinType();
        }
    }

    public void Ou() {
        if (this.bha != null) {
            this.bha.P(this.mRootView);
            this.bha = null;
        }
    }

    public void Qm() {
        String string = TbadkCoreApplication.getInst().getString(d.k.neterror);
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditNickNameActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    EditNickNameActivity.this.Rs();
                }
            });
            this.mRefreshView.onChangeSkinType();
        }
        this.mWebView.setVisibility(8);
        this.mRefreshView.setSubText(string);
        this.mRefreshView.d(this.mRootView, false);
        this.mRefreshView.Fu();
        this.mRefreshView.fa(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds280));
    }

    public void Rt() {
        if (this.mRefreshView != null) {
            this.mRefreshView.P(this.mRootView);
            this.mRefreshView = null;
        }
        this.mWebView.setVisibility(0);
    }

    public void Rs() {
        if (this.wI) {
            this.mWebView.loadUrl("javascript:window.reload_page()");
        } else {
            this.mWebView.loadUrl(this.mUrl);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bej();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends WebViewClient {
        private a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!StringUtils.isNull(str)) {
                if (EditNickNameActivity.this.iY(str)) {
                    return true;
                }
                int b = ax.wg().b(EditNickNameActivity.this.mPageContext, new String[]{str});
                if (b == 1) {
                    EditNickNameActivity.this.finish();
                    return true;
                } else if (b != 0) {
                    EditNickNameActivity.this.mWebView.loadUrl(str);
                    return true;
                } else {
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            EditNickNameActivity.this.showLoadingView();
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            String title = EditNickNameActivity.this.mWebView.getTitle();
            if (!StringUtils.isNull(title)) {
                EditNickNameActivity.this.mNavigationBar.setCenterTextTitle(title);
            }
            EditNickNameActivity.this.Ou();
            if (j.gP()) {
                EditNickNameActivity.this.Rt();
                EditNickNameActivity.this.wI = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            EditNickNameActivity.this.Qm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iY(String str) {
        return rd(str);
    }

    private boolean rd(String str) {
        String aT = k.aT(str);
        if (aT.contains("modifyname://") && aT.contains("data=")) {
            try {
                JSONObject jSONObject = new JSONObject(aT.substring("data=".length() + aT.indexOf("data=")));
                boolean z = jSONObject.optInt("isclose") == 1;
                String optString = jSONObject.optString("nickname");
                if (z) {
                    rc(optString);
                } else {
                    showDialog();
                }
                return true;
            } catch (JSONException e) {
                return false;
            }
        }
        return false;
    }

    private void showDialog() {
        if (this.JV == null) {
            this.JV = new com.baidu.tbadk.core.dialog.a(getActivity());
            this.JV.dc(getPageContext().getResources().getString(d.k.modify_user_dialog_msg));
            this.JV.a(d.k.save, new a.b() { // from class: com.baidu.tieba.personExtra.EditNickNameActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    EditNickNameActivity.this.bek();
                }
            });
            this.JV.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.personExtra.EditNickNameActivity.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    EditNickNameActivity.this.rc(null);
                }
            });
            this.JV.b(getPageContext());
        }
        this.JV.tD();
    }
}
