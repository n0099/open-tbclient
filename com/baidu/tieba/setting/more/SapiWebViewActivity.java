package com.baidu.tieba.setting.more;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.n;
import com.baidu.tieba.setting.SapiWebViewActivityConfig;
/* loaded from: classes.dex */
public class SapiWebViewActivity extends BaseActivity<SapiWebViewActivity> {
    private LinearLayout My;
    private NoNetworkView aQl;
    private SapiWebView cwe;
    private NavigationBar mNavigationBar;
    private int mType = -1;
    private String wy = "";
    private boolean dox = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(n.g.activity_sapi_webview);
        azc();
        initViews();
        azd();
        if (!checkUpIsLogin()) {
            finish();
        }
    }

    private void azc() {
        if (getIntent() != null) {
            this.mType = getIntent().getIntExtra(SapiWebViewActivityConfig.EXTRA_TYPE, -1);
            this.wy = getIntent().getStringExtra(SapiWebViewActivityConfig.EXTRA_BDUSS);
            this.dox = getIntent().getBooleanExtra(SapiWebViewActivityConfig.EXTRA_NAV, true);
        }
    }

    private void initViews() {
        this.My = (LinearLayout) findViewById(n.f.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ah(this));
        this.aQl = (NoNetworkView) findViewById(n.f.no_network_view);
        this.cwe = (SapiWebView) findViewById(n.f.sapi_webview);
        com.baidu.tbadk.core.a.d.a(getPageContext().getPageActivity(), this.cwe);
        this.cwe.setOnBackCallback(new ai(this));
        this.cwe.setOnFinishCallback(new aj(this));
        this.cwe.setChangePwdCallback(new ak(this));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            bj.a((View) this.cwe, n.c.cp_link_tip_b, false);
        }
        this.aQl.a(new a());
    }

    private void azd() {
        if (!TextUtils.isEmpty(this.wy) && this.cwe != null && this.mNavigationBar != null) {
            if (this.mType == 0) {
                this.cwe.loadModifyPwd(this.wy);
                this.mNavigationBar.setTitleText(getPageContext().getString(n.i.modify_pwd));
                return;
            }
            BindWidgetAction bindWidgetAction = null;
            if (this.mType == 1) {
                bindWidgetAction = BindWidgetAction.BIND_MOBILE;
            } else if (this.mType == 2) {
                bindWidgetAction = BindWidgetAction.BIND_EMAIL;
            } else if (this.mType == 3) {
                bindWidgetAction = BindWidgetAction.REBIND_MOBILE;
            } else if (this.mType == 4) {
                bindWidgetAction = BindWidgetAction.REBIND_EMAIL;
            }
            if (bindWidgetAction != null && !TextUtils.isEmpty(bindWidgetAction.getName())) {
                this.mNavigationBar.setTitleText(bindWidgetAction.getName());
                this.cwe.loadBindWidget(bindWidgetAction, this.wy);
            } else {
                this.mNavigationBar.setTitleText(getPageContext().getString(n.i.account_safe));
            }
            if (!this.dox) {
                this.mNavigationBar.setVisibility(8);
            } else {
                this.mNavigationBar.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBack() {
        if (this.cwe != null && this.cwe.canGoBack()) {
            this.cwe.goBack();
        } else {
            finishActivity();
        }
    }

    private void finishActivity() {
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aA(boolean z) {
            if (SapiWebViewActivity.this.aQl != null) {
                if (z) {
                    SapiWebViewActivity.this.aQl.setVisibility(8);
                } else {
                    SapiWebViewActivity.this.aQl.setVisibility(0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.My != null) {
            this.My.removeAllViews();
        }
    }
}
