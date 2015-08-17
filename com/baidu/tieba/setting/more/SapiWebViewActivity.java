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
import com.baidu.tbadk.core.atomData.SapiWebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class SapiWebViewActivity extends BaseActivity<SapiWebViewActivity> {
    private LinearLayout Mg;
    private NoNetworkView aNx;
    private SapiWebView agw;
    private NavigationBar mNavigationBar;
    private int mType = -1;
    private String wt = "";
    private boolean cyH = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(i.g.activity_sapi_webview);
        amr();
        Gy();
        ams();
        if (!checkUpIsLogin()) {
            finish();
        }
    }

    private void amr() {
        if (getIntent() != null) {
            this.mType = getIntent().getIntExtra(SapiWebViewActivityConfig.EXTRA_TYPE, -1);
            this.wt = getIntent().getStringExtra(SapiWebViewActivityConfig.EXTRA_BDUSS);
            this.cyH = getIntent().getBooleanExtra(SapiWebViewActivityConfig.EXTRA_NAV, true);
        }
    }

    private void Gy() {
        this.Mg = (LinearLayout) findViewById(i.f.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new af(this));
        this.aNx = (NoNetworkView) findViewById(i.f.no_network_view);
        this.agw = (SapiWebView) findViewById(i.f.sapi_webview);
        com.baidu.tbadk.core.a.d.a(getPageContext().getPageActivity(), this.agw);
        this.agw.setOnBackCallback(new ag(this));
        this.agw.setOnFinishCallback(new ah(this));
        this.agw.setChangePwdCallback(new ai(this));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            bb.a((View) this.agw, i.c.cp_link_tip_b, false);
        }
        this.aNx.a(new a());
    }

    private void ams() {
        if (!TextUtils.isEmpty(this.wt) && this.agw != null && this.mNavigationBar != null) {
            if (this.mType == 0) {
                this.agw.loadModifyPwd(this.wt);
                this.mNavigationBar.setTitleText(getPageContext().getString(i.C0057i.modify_pwd));
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
                this.agw.loadBindWidget(bindWidgetAction, this.wt);
            } else {
                this.mNavigationBar.setTitleText(getPageContext().getString(i.C0057i.account_safe));
            }
            if (!this.cyH) {
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
        if (this.agw != null && this.agw.canGoBack()) {
            this.agw.goBack();
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
        public void ay(boolean z) {
            if (SapiWebViewActivity.this.aNx != null) {
                if (z) {
                    SapiWebViewActivity.this.aNx.setVisibility(8);
                } else {
                    SapiWebViewActivity.this.aNx.setVisibility(0);
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
        if (this.Mg != null) {
            this.Mg.removeAllViews();
        }
    }
}
