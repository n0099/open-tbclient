package com.baidu.tieba.thirdparty;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class QQSSOLoginActivity extends BaseActivity {
    private SapiWebView eYG;
    private AuthorizationListener gIG = new AuthorizationListener() { // from class: com.baidu.tieba.thirdparty.QQSSOLoginActivity.1
        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onSuccess() {
            QQSSOLoginActivity.this.setResult(230013);
            QQSSOLoginActivity.this.finish();
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onFailed(int i, String str) {
            Intent intent = new Intent();
            intent.putExtra("result_code", i);
            intent.putExtra("result_msg", str);
            QQSSOLoginActivity.this.setResult(230014);
            l.showToast(QQSSOLoginActivity.this, String.format(QQSSOLoginActivity.this.getString(d.k.qq_login_fail), str, Integer.valueOf(i)));
            QQSSOLoginActivity.this.finish();
        }
    };
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setSwipeBackEnabled(false);
        super.onCreate(bundle);
        MessageManager.getInstance().runTask(2921332, (Class) null);
        setContentView(d.i.layout_sapi_webview);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.sapi_navi);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.k.login));
        this.eYG = (SapiWebView) findViewById(d.g.sapi_webview);
        com.baidu.tbadk.core.a.d.addCustomView(this, this.eYG);
        this.eYG.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.tieba.thirdparty.QQSSOLoginActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                QQSSOLoginActivity.this.finish();
            }
        });
        this.eYG.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.tieba.thirdparty.QQSSOLoginActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                QQSSOLoginActivity.this.finish();
            }
        });
        this.eYG.setAuthorizationListener(this.gIG);
        this.eYG.setQQSSOHandler(new SapiWebView.QQSSOHandler() { // from class: com.baidu.tieba.thirdparty.QQSSOLoginActivity.4
            @Override // com.baidu.sapi2.SapiWebView.QQSSOHandler
            public void handleQQSSOLoginFailure() {
            }
        });
        this.eYG.loadQQSSOLogin();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.eYG.onActivityResultData(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }
}
