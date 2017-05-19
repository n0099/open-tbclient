package com.baidu.tieba.passaccount.app;

import android.os.Bundle;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ForgetPwdActivity extends BaseActivity<ForgetPwdActivity> {
    private SapiWebView dZG;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(w.j.layout_sapi_webview_forget_pwd);
        setupViews();
    }

    protected void setupViews() {
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(w.l.sapi_forget_password_title));
        this.dZG = (SapiWebView) findViewById(w.h.sapi_webview);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.dZG);
        this.dZG.setOnBackCallback(new b(this));
        this.dZG.setChangePwdCallback(new c(this));
        this.dZG.setOnFinishCallback(new d(this));
        this.dZG.loadForgetPwd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
