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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.i0.d0.g;
import d.a.i0.d0.h;
import d.a.i0.r.s.a;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class EditNickNameActivity extends BaseActivity<EditNickNameActivity> {
    public final String MODIFY_NICKNAME_URL = "https://tieba.baidu.com/n/interact/modifyname";
    public d.a.i0.r.s.a mDialog;
    public boolean mLoadSuccess;
    public g mLoadingView;
    public NavigationBar mNavigationBar;
    public TbPageContext<EditNickNameActivity> mPageContext;
    public h mRefreshView;
    public View mRootView;
    public int mType;
    public String mUrl;
    public BaseWebView mWebView;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditNickNameActivity.this.onBackClick();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditNickNameActivity.this.reloadPage();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
            EditNickNameActivity.this.onSaveClick();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
            EditNickNameActivity.this.goBackOrFinish(null);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends WebViewClient {
        public e() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            String title = EditNickNameActivity.this.mWebView.getTitle();
            if (!StringUtils.isNull(title)) {
                EditNickNameActivity.this.mNavigationBar.setCenterTextTitle(title);
            }
            EditNickNameActivity.this.hideLoadingView();
            if (j.z()) {
                EditNickNameActivity.this.showNormalView();
                EditNickNameActivity.this.mLoadSuccess = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            EditNickNameActivity.this.showLoadingView();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            EditNickNameActivity.this.showNetRefreshView();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!StringUtils.isNull(str)) {
                if (!EditNickNameActivity.this.nativeJump(str)) {
                    int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(EditNickNameActivity.this.mPageContext, new String[]{str});
                    if (dealOneLinkWithOutJumpWebView == 1) {
                        EditNickNameActivity.this.finish();
                        return true;
                    } else if (dealOneLinkWithOutJumpWebView == 0) {
                        return true;
                    } else {
                        EditNickNameActivity.this.mWebView.loadUrl(str);
                    }
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public /* synthetic */ e(EditNickNameActivity editNickNameActivity, a aVar) {
            this();
        }
    }

    private String createUrlNightType(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        try {
            if (StringUtils.isNull(new URL(str).getQuery())) {
                return str + "?isNightModel=1";
            }
            return str + "&isNightModel=1";
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBackOrFinish(String str) {
        BaseWebView baseWebView = this.mWebView;
        if (baseWebView != null && baseWebView.canGoBack()) {
            this.mWebView.goBack();
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921033, str));
        }
        finish();
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        BaseWebView baseWebView = (BaseWebView) findViewById(R.id.webview);
        this.mWebView = baseWebView;
        baseWebView.setWebViewClient(new e(this, null));
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        if (this.mType == 0) {
            navigationBar.setCenterTextTitle(getResources().getString(R.string.modify_nickname));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
    }

    private boolean jumpOrFinish(String str) {
        String urlDecode = k.getUrlDecode(str);
        if (urlDecode.contains(UrlSchemaHelper.SCHEMA_TYPE_MODIFY_NAME) && urlDecode.contains("data=")) {
            try {
                JSONObject jSONObject = new JSONObject(urlDecode.substring(urlDecode.indexOf("data=") + 5));
                boolean z = jSONObject.optInt("isclose") == 1;
                String optString = jSONObject.optString("nickname");
                if (z) {
                    goBackOrFinish(optString);
                } else {
                    showDialog();
                }
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nativeJump(String str) {
        return jumpOrFinish(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBackClick() {
        BaseWebView baseWebView;
        if (this.mLoadSuccess && (baseWebView = this.mWebView) != null && !TextUtils.isEmpty(baseWebView.getUrl()) && this.mWebView.getUrl().contains("https://tieba.baidu.com/n/interact/modifyname")) {
            this.mWebView.loadUrl("javascript:__js_bridge_modify_name_back_action()");
        } else {
            goBackOrFinish(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSaveClick() {
        this.mWebView.loadUrl("javascript:__js_bridge_modify_name_save_action()");
    }

    private void showDialog() {
        if (this.mDialog == null) {
            d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(getActivity());
            this.mDialog = aVar;
            aVar.setMessage(getPageContext().getResources().getString(R.string.modify_user_dialog_msg));
            this.mDialog.setPositiveButton(R.string.save, new c());
            this.mDialog.setNegativeButton(R.string.cancel, new d());
            this.mDialog.create(getPageContext());
        }
        this.mDialog.show();
    }

    public void hideLoadingView() {
        g gVar = this.mLoadingView;
        if (gVar != null) {
            gVar.dettachView(this.mRootView);
            this.mLoadingView = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        if (i2 != 1 && i2 != 4) {
            this.mWebView.loadUrl(this.mUrl);
        } else {
            this.mWebView.loadUrl(createUrlNightType(this.mUrl));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        this.mType = getIntent().getIntExtra(EditNickNameActivityConfig.PARAM_TYPE, 0);
        String stringExtra = getIntent().getStringExtra(EditNickNameActivityConfig.PARAM_URL);
        this.mUrl = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.mUrl = "https://tieba.baidu.com/n/interact/modifyname";
        }
        setContentView(R.layout.edit_nickname_activity);
        initView();
        d.a.i0.l.a.f(getApplicationContext());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            onBackClick();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void reloadPage() {
        if (this.mLoadSuccess) {
            this.mWebView.loadUrl("javascript:window.reload_page()");
        } else {
            this.mWebView.loadUrl(this.mUrl);
        }
    }

    public void showLoadingView() {
        TbPageContext<EditNickNameActivity> tbPageContext = this.mPageContext;
        if (tbPageContext == null || this.mRootView == null) {
            return;
        }
        g gVar = new g(tbPageContext.getPageActivity());
        this.mLoadingView = gVar;
        gVar.attachView(this.mRootView, false);
        this.mLoadingView.onChangeSkinType();
    }

    public void showNetRefreshView() {
        String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
        if (this.mRefreshView == null) {
            h hVar = new h(this.mPageContext.getPageActivity(), new b());
            this.mRefreshView = hVar;
            hVar.onChangeSkinType();
        }
        this.mWebView.setVisibility(8);
        this.mRefreshView.l(string);
        this.mRefreshView.attachView(this.mRootView, false);
        this.mRefreshView.o();
        this.mRefreshView.j(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds280));
    }

    public void showNormalView() {
        h hVar = this.mRefreshView;
        if (hVar != null) {
            hVar.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
        this.mWebView.setVisibility(0);
    }
}
