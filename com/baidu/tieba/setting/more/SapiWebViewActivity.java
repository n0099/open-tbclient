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
    private LinearLayout MO;
    private NoNetworkView aUd;
    private SapiWebView czI;
    private NavigationBar mNavigationBar;
    private int mType = -1;
    private String wA = "";
    private boolean dvK = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(n.h.activity_sapi_webview);
        aBi();
        initViews();
        aBj();
        if (!checkUpIsLogin()) {
            finish();
        }
    }

    private void aBi() {
        if (getIntent() != null) {
            this.mType = getIntent().getIntExtra(SapiWebViewActivityConfig.EXTRA_TYPE, -1);
            this.wA = getIntent().getStringExtra(SapiWebViewActivityConfig.EXTRA_BDUSS);
            this.dvK = getIntent().getBooleanExtra(SapiWebViewActivityConfig.EXTRA_NAV, true);
        }
    }

    private void initViews() {
        this.MO = (LinearLayout) findViewById(n.g.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ai(this));
        this.aUd = (NoNetworkView) findViewById(n.g.no_network_view);
        this.czI = (SapiWebView) findViewById(n.g.sapi_webview);
        com.baidu.tbadk.core.a.d.a(getPageContext().getPageActivity(), this.czI);
        this.czI.setOnBackCallback(new aj(this));
        this.czI.setOnFinishCallback(new ak(this));
        this.czI.setChangePwdCallback(new al(this));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            bj.a((View) this.czI, n.d.cp_link_tip_b, false);
        }
        this.aUd.a(new a());
    }

    private void aBj() {
        if (!TextUtils.isEmpty(this.wA) && this.czI != null && this.mNavigationBar != null) {
            if (this.mType == 0) {
                this.czI.loadModifyPwd(this.wA);
                this.mNavigationBar.setTitleText(getPageContext().getString(n.j.modify_pwd));
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
                this.czI.loadBindWidget(bindWidgetAction, this.wA);
            } else {
                this.mNavigationBar.setTitleText(getPageContext().getString(n.j.account_safe));
            }
            if (!this.dvK) {
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
        if (this.czI != null && this.czI.canGoBack()) {
            this.czI.goBack();
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
        public void ax(boolean z) {
            if (SapiWebViewActivity.this.aUd != null) {
                if (z) {
                    SapiWebViewActivity.this.aUd.setVisibility(8);
                } else {
                    SapiWebViewActivity.this.aUd.setVisibility(0);
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
        if (this.MO != null) {
            this.MO.removeAllViews();
        }
    }
}
