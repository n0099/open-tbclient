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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class EditNickNameActivity extends BaseActivity<EditNickNameActivity> {
    private boolean DG;
    private com.baidu.tbadk.core.dialog.a TX;
    private com.baidu.tbadk.m.g djG;
    private final String imm = "https://tieba.baidu.com/n/interact/modifyname";
    private NavigationBar mNavigationBar;
    private TbPageContext<EditNickNameActivity> mPageContext;
    private com.baidu.tbadk.m.h mRefreshView;
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
        setContentView(R.layout.edit_nickname_activity);
        initView();
        com.baidu.tbadk.browser.a.cl(getApplicationContext());
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.mWebView = (BaseWebView) findViewById(R.id.webview);
        this.mWebView.setWebViewClient(new a());
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        if (this.mType == 0) {
            this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.modify_nickname));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditNickNameActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditNickNameActivity.this.cbH();
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.mWebView.loadUrl(tO(this.mUrl));
        } else {
            this.mWebView.loadUrl(this.mUrl);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private String tO(String str) {
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
    public void CF(String str) {
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
    public void cbH() {
        if (this.DG && this.mWebView != null && !TextUtils.isEmpty(this.mWebView.getUrl()) && this.mWebView.getUrl().contains("https://tieba.baidu.com/n/interact/modifyname")) {
            this.mWebView.loadUrl("javascript:__js_bridge_modify_name_back_action()");
        } else {
            CF(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbI() {
        this.mWebView.loadUrl("javascript:__js_bridge_modify_name_save_action()");
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.djG = new com.baidu.tbadk.m.g(this.mPageContext.getPageActivity());
            this.djG.attachView(this.mRootView, false);
            this.djG.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.djG != null) {
            this.djG.dettachView(this.mRootView);
            this.djG = null;
        }
    }

    public void aJg() {
        String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditNickNameActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EditNickNameActivity.this.aLr();
                }
            });
            this.mRefreshView.onChangeSkinType();
        }
        this.mWebView.setVisibility(8);
        this.mRefreshView.qN(string);
        this.mRefreshView.attachView(this.mRootView, false);
        this.mRefreshView.atI();
        this.mRefreshView.kK(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds280));
    }

    public void aLs() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
        this.mWebView.setVisibility(0);
    }

    public void aLr() {
        if (this.DG) {
            this.mWebView.loadUrl("javascript:window.reload_page()");
        } else {
            this.mWebView.loadUrl(this.mUrl);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cbH();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends WebViewClient {
        private a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!StringUtils.isNull(str)) {
                if (EditNickNameActivity.this.tQ(str)) {
                    return true;
                }
                int b = bb.ajC().b(EditNickNameActivity.this.mPageContext, new String[]{str});
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
            if (com.baidu.adp.lib.util.j.kc()) {
                EditNickNameActivity.this.aLs();
                EditNickNameActivity.this.DG = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            EditNickNameActivity.this.aJg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tQ(String str) {
        return CG(str);
    }

    private boolean CG(String str) {
        String bj = k.bj(str);
        if (bj.contains("modifyname://") && bj.contains("data=")) {
            try {
                JSONObject jSONObject = new JSONObject(bj.substring("data=".length() + bj.indexOf("data=")));
                boolean z = jSONObject.optInt("isclose") == 1;
                String optString = jSONObject.optString("nickname");
                if (z) {
                    CF(optString);
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
        if (this.TX == null) {
            this.TX = new com.baidu.tbadk.core.dialog.a(getActivity());
            this.TX.mO(getPageContext().getResources().getString(R.string.modify_user_dialog_msg));
            this.TX.a(R.string.save, new a.b() { // from class: com.baidu.tieba.personExtra.EditNickNameActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    EditNickNameActivity.this.cbI();
                }
            });
            this.TX.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personExtra.EditNickNameActivity.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    EditNickNameActivity.this.CF(null);
                }
            });
            this.TX.b(getPageContext());
        }
        this.TX.agI();
    }
}
