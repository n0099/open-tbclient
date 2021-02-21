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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class EditNickNameActivity extends BaseActivity<EditNickNameActivity> {
    private com.baidu.tbadk.core.dialog.a acU;
    private com.baidu.tbadk.l.g gJB;
    private boolean mLoadSuccess;
    private NavigationBar mNavigationBar;
    private TbPageContext<EditNickNameActivity> mPageContext;
    private com.baidu.tbadk.l.h mRefreshView;
    private View mRootView;
    private int mType;
    private String mUrl;
    private BaseWebView mWebView;
    private final String mwv = "https://tieba.baidu.com/n/interact/modifyname";

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
        com.baidu.tbadk.browser.a.initCookie(getApplicationContext());
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
                EditNickNameActivity.this.onBackClick();
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1 || i == 4) {
            this.mWebView.loadUrl(GF(this.mUrl));
        } else {
            this.mWebView.loadUrl(this.mUrl);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private String GF(String str) {
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
    public void Qo(String str) {
        if (this.mWebView != null && this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED, str));
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBackClick() {
        if (this.mLoadSuccess && this.mWebView != null && !TextUtils.isEmpty(this.mWebView.getUrl()) && this.mWebView.getUrl().contains("https://tieba.baidu.com/n/interact/modifyname")) {
            this.mWebView.loadUrl("javascript:__js_bridge_modify_name_back_action()");
        } else {
            Qo(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxo() {
        this.mWebView.loadUrl("javascript:__js_bridge_modify_name_save_action()");
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.gJB = new com.baidu.tbadk.l.g(this.mPageContext.getPageActivity());
            this.gJB.attachView(this.mRootView, false);
            this.gJB.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this.mRootView);
            this.gJB = null;
        }
    }

    public void bRB() {
        String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.l.h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditNickNameActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EditNickNameActivity.this.bVv();
                }
            });
            this.mRefreshView.onChangeSkinType();
        }
        this.mWebView.setVisibility(8);
        this.mRefreshView.setSubText(string);
        this.mRefreshView.attachView(this.mRootView, false);
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds280));
    }

    public void bTZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
        this.mWebView.setVisibility(0);
    }

    public void bVv() {
        if (this.mLoadSuccess) {
            this.mWebView.loadUrl("javascript:window.reload_page()");
        } else {
            this.mWebView.loadUrl(this.mUrl);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            onBackClick();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends WebViewClient {
        private a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!StringUtils.isNull(str)) {
                if (EditNickNameActivity.this.GH(str)) {
                    return true;
                }
                int a2 = bf.bsV().a(EditNickNameActivity.this.mPageContext, new String[]{str});
                if (a2 == 1) {
                    EditNickNameActivity.this.finish();
                    return true;
                } else if (a2 != 0) {
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
            if (j.isNetWorkAvailable()) {
                EditNickNameActivity.this.bTZ();
                EditNickNameActivity.this.mLoadSuccess = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            EditNickNameActivity.this.bRB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GH(String str) {
        return Qp(str);
    }

    private boolean Qp(String str) {
        String urlDecode = k.getUrlDecode(str);
        if (urlDecode.contains(UrlSchemaHelper.SCHEMA_TYPE_MODIFY_NAME) && urlDecode.contains("data=")) {
            try {
                JSONObject jSONObject = new JSONObject(urlDecode.substring("data=".length() + urlDecode.indexOf("data=")));
                boolean z = jSONObject.optInt("isclose") == 1;
                String optString = jSONObject.optString("nickname");
                if (z) {
                    Qo(optString);
                } else {
                    QE();
                }
                return true;
            } catch (JSONException e) {
                return false;
            }
        }
        return false;
    }

    private void QE() {
        if (this.acU == null) {
            this.acU = new com.baidu.tbadk.core.dialog.a(getActivity());
            this.acU.Au(getPageContext().getResources().getString(R.string.modify_user_dialog_msg));
            this.acU.a(R.string.save, new a.b() { // from class: com.baidu.tieba.personExtra.EditNickNameActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    EditNickNameActivity.this.dxo();
                }
            });
            this.acU.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personExtra.EditNickNameActivity.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    EditNickNameActivity.this.Qo(null);
                }
            });
            this.acU.b(getPageContext());
        }
        this.acU.bqx();
    }
}
