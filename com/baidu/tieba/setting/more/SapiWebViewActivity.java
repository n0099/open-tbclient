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
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.setting.SapiWebViewActivityConfig;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class SapiWebViewActivity extends BaseActivity<SapiWebViewActivity> {
    private LinearLayout Nm;
    private NoNetworkView baT;
    private SapiWebView cZw;
    private NavigationBar mNavigationBar;
    private int mType = -1;
    private String xa = "";
    private boolean eeo = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(t.h.activity_sapi_webview);
        aPe();
        initViews();
        aPf();
        if (!checkUpIsLogin()) {
            finish();
        }
    }

    private void aPe() {
        if (getIntent() != null) {
            this.mType = getIntent().getIntExtra(SapiWebViewActivityConfig.EXTRA_TYPE, -1);
            this.xa = getIntent().getStringExtra(SapiWebViewActivityConfig.EXTRA_BDUSS);
            this.eeo = getIntent().getBooleanExtra(SapiWebViewActivityConfig.EXTRA_NAV, true);
        }
    }

    private void initViews() {
        this.Nm = (LinearLayout) findViewById(t.g.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ak(this));
        this.baT = (NoNetworkView) findViewById(t.g.no_network_view);
        this.cZw = (SapiWebView) findViewById(t.g.sapi_webview);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.cZw);
        this.cZw.setOnBackCallback(new al(this));
        this.cZw.setOnFinishCallback(new am(this));
        this.cZw.setChangePwdCallback(new an(this));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            bl.b(this.cZw, t.d.cp_link_tip_b, false);
        }
        this.baT.a(new a());
    }

    private void aPf() {
        if (!TextUtils.isEmpty(this.xa) && this.cZw != null && this.mNavigationBar != null) {
            if (this.mType == 0) {
                this.cZw.loadModifyPwd(this.xa);
                this.mNavigationBar.setTitleText(getPageContext().getString(t.j.modify_pwd));
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
                this.cZw.loadBindWidget(bindWidgetAction, this.xa);
            } else {
                this.mNavigationBar.setTitleText(getPageContext().getString(t.j.account_safe));
            }
            if (!this.eeo) {
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
            aEd();
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
        if (this.cZw != null && this.cZw.canGoBack()) {
            this.cZw.goBack();
        } else {
            aEd();
        }
    }

    private void aEd() {
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
            if (SapiWebViewActivity.this.baT != null) {
                if (z) {
                    SapiWebViewActivity.this.baT.setVisibility(8);
                } else {
                    SapiWebViewActivity.this.baT.setVisibility(0);
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
        if (this.Nm != null) {
            this.Nm.removeAllViews();
        }
    }
}
