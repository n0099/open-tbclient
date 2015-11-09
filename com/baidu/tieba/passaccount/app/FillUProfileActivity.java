package com.baidu.tieba.passaccount.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.SapiWebViewActivityConfig;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
public class FillUProfileActivity extends BaseActivity<FillUProfileActivity> {
    private String bduss;
    private SapiWebView cdD;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.coreExtra.view.k atj = null;
    private final a.InterfaceC0040a XW = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(i.g.layout_sapi_webview_fill_uprofile);
        this.bduss = getIntent().getStringExtra(SapiWebViewActivityConfig.EXTRA_BDUSS);
        aeo();
    }

    protected void aeo() {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(i.h.sapi_filluprofile));
        if (TextUtils.isEmpty(this.bduss)) {
            Toast.makeText(getPageContext().getPageActivity(), "参数错误，无法正常化", 0).show();
            finish();
        }
        this.cdD = (SapiWebView) findViewById(i.f.sapi_webview);
        com.baidu.tbadk.core.a.d.a(getPageContext().getPageActivity(), this.cdD);
        this.cdD.setOnBackCallback(new c(this));
        this.cdD.setOnFinishCallback(new d(this));
        this.cdD.setAuthorizationListener(new e(this));
        this.cdD.loadFillUProfile(this.bduss);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aep() {
        TbadkCoreApplication.m411getInst().onUserChanged();
        Intent intent = new Intent();
        intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeq() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.a.a.rb().a(session.username, session.bduss, session.ptoken, this.XW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(AccountData accountData) {
        if (this.atj == null) {
            this.atj = new com.baidu.tbadk.coreExtra.view.k(getPageContext());
            this.atj.a(new f(this));
        }
        this.atj.yT();
        this.atj.h(accountData);
        this.atj.yP();
    }
}
