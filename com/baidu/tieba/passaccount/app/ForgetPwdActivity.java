package com.baidu.tieba.passaccount.app;

import android.os.Bundle;
import android.view.View;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ForgetPwdActivity extends BaseActivity<ForgetPwdActivity> {
    private SapiWebView eDf;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.layout_sapi_webview_forget_pwd);
        setupViews();
    }

    protected void setupViews() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.passaccount.app.ForgetPwdActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForgetPwdActivity.this.eDf.canGoBack()) {
                    ForgetPwdActivity.this.eDf.goBack();
                } else {
                    ForgetPwdActivity.this.finish();
                }
            }
        });
        this.mNavigationBar.setTitleText(getPageContext().getString(d.j.sapi_forget_password_title));
        this.eDf = (SapiWebView) findViewById(d.g.sapi_webview);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.eDf);
        this.eDf.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.tieba.passaccount.app.ForgetPwdActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                if (ForgetPwdActivity.this.eDf.canGoBack()) {
                    ForgetPwdActivity.this.eDf.goBack();
                } else {
                    ForgetPwdActivity.this.finish();
                }
            }
        });
        this.eDf.setChangePwdCallback(new SapiWebView.ChangePwdCallback() { // from class: com.baidu.tieba.passaccount.app.ForgetPwdActivity.3
            @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
            public void onSuccess() {
                ForgetPwdActivity.this.finish();
            }
        });
        this.eDf.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.tieba.passaccount.app.ForgetPwdActivity.4
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                ForgetPwdActivity.this.finish();
            }
        });
        this.eDf.loadForgetPwd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
