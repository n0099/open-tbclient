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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.e;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class EditNickNameActivity extends BaseActivity<EditNickNameActivity> {
    private boolean FT;
    private com.baidu.tbadk.core.dialog.a Td;
    private com.baidu.tbadk.k.f bKy;
    private final String gwH = "https://tieba.baidu.com/n/interact/modifyname";
    private NavigationBar mNavigationBar;
    private TbPageContext<EditNickNameActivity> mPageContext;
    private g mRefreshView;
    private View mRootView;
    private int mType;
    private String mUrl;
    private BaseWebView mWebView;

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
        setContentView(e.h.edit_nickname_activity);
        initView();
        com.baidu.tbadk.browser.a.br(getApplicationContext());
    }

    private void initView() {
        this.mRootView = findViewById(e.g.root_layout);
        this.mWebView = (BaseWebView) findViewById(e.g.webview);
        this.mWebView.setWebViewClient(new a());
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        if (this.mType == 0) {
            this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.modify_nickname));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditNickNameActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditNickNameActivity.this.bpQ();
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.mWebView.loadUrl(lf(this.mUrl));
        } else {
            this.mWebView.loadUrl(this.mUrl);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private String lf(String str) {
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
    public void tG(String str) {
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
    public void bpQ() {
        if (this.FT && this.mWebView != null && !TextUtils.isEmpty(this.mWebView.getUrl()) && this.mWebView.getUrl().contains("https://tieba.baidu.com/n/interact/modifyname")) {
            this.mWebView.loadUrl("javascript:__js_bridge_modify_name_back_action()");
        } else {
            tG(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpR() {
        this.mWebView.loadUrl("javascript:__js_bridge_modify_name_save_action()");
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.bKy = new com.baidu.tbadk.k.f(this.mPageContext.getPageActivity());
            this.bKy.attachView(this.mRootView, false);
            this.bKy.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.bKy != null) {
            this.bKy.dettachView(this.mRootView);
            this.bKy = null;
        }
    }

    public void aaZ() {
        String string = TbadkCoreApplication.getInst().getString(e.j.neterror);
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditNickNameActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EditNickNameActivity.this.ach();
                }
            });
            this.mRefreshView.onChangeSkinType();
        }
        this.mWebView.setVisibility(8);
        this.mRefreshView.io(string);
        this.mRefreshView.attachView(this.mRootView, false);
        this.mRefreshView.NM();
        this.mRefreshView.ge(this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds280));
    }

    public void aci() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
        this.mWebView.setVisibility(0);
    }

    public void ach() {
        if (this.FT) {
            this.mWebView.loadUrl("javascript:window.reload_page()");
        } else {
            this.mWebView.loadUrl(this.mUrl);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bpQ();
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
                if (EditNickNameActivity.this.lh(str)) {
                    return true;
                }
                int b = ay.Ef().b(EditNickNameActivity.this.mPageContext, new String[]{str});
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
            EditNickNameActivity.this.hideLoadingView();
            if (j.kV()) {
                EditNickNameActivity.this.aci();
                EditNickNameActivity.this.FT = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            EditNickNameActivity.this.aaZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lh(String str) {
        return tH(str);
    }

    private boolean tH(String str) {
        String by = k.by(str);
        if (by.contains("modifyname://") && by.contains("data=")) {
            try {
                JSONObject jSONObject = new JSONObject(by.substring("data=".length() + by.indexOf("data=")));
                boolean z = jSONObject.optInt("isclose") == 1;
                String optString = jSONObject.optString("nickname");
                if (z) {
                    tG(optString);
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
        if (this.Td == null) {
            this.Td = new com.baidu.tbadk.core.dialog.a(getActivity());
            this.Td.eB(getPageContext().getResources().getString(e.j.modify_user_dialog_msg));
            this.Td.a(e.j.save, new a.b() { // from class: com.baidu.tieba.personExtra.EditNickNameActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    EditNickNameActivity.this.bpR();
                }
            });
            this.Td.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.personExtra.EditNickNameActivity.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    EditNickNameActivity.this.tG(null);
                }
            });
            this.Td.b(getPageContext());
        }
        this.Td.BF();
    }
}
