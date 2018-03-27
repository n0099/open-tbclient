package com.baidu.tieba.thirdparty;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SocialLoginActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class SocialLoginActivity extends BaseActivity<SocialLoginActivity> {
    private NavigationBar bVs;
    private SocialType socialType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().runTask(2921332, (Class) null);
        setContentView(d.h.layout_sapi_webview);
        setSwipeBackEnabled(false);
        this.socialType = (SocialType) getIntent().getSerializableExtra(SocialLoginActivityConfig.SOCIAL_TYPE);
        if (this.socialType == null) {
            finish();
        }
        setupViews();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    protected void setupViews() {
        final SapiWebView sapiWebView = (SapiWebView) findViewById(d.g.sapi_webview);
        this.bVs = (NavigationBar) findViewById(d.g.sapi_navi);
        this.bVs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bVs.setTitleText(getPageContext().getString(d.j.login));
        com.baidu.tbadk.core.a.d.addCustomView(getPageContext().getPageActivity(), sapiWebView);
        sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.tieba.thirdparty.SocialLoginActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                if (sapiWebView.canGoBack()) {
                    sapiWebView.goBack();
                } else {
                    SocialLoginActivity.this.finish();
                }
            }
        });
        sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.tieba.thirdparty.SocialLoginActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                SocialLoginActivity.this.finish();
            }
        });
        sapiWebView.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.tieba.thirdparty.SocialLoginActivity.3
            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess() {
                SocialLoginActivity.this.setResult(230013);
                SocialLoginActivity.this.finish();
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i, String str) {
                Intent intent = new Intent();
                intent.putExtra("result_code", i);
                intent.putExtra("result_msg", str);
                SocialLoginActivity.this.setResult(230014);
                SocialLoginActivity.this.finish();
            }
        });
        sapiWebView.loadSocialLogin(this.socialType, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bVs != null) {
            this.bVs.onChangeSkinType(getPageContext(), i);
        }
    }
}
