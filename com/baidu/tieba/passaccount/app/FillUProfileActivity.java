package com.baidu.tieba.passaccount.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.setting.SapiWebViewActivityConfig;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
public class FillUProfileActivity extends BaseActivity<FillUProfileActivity> {
    private BdAsyncTask<?, ?, ?> aLL;
    private String bduss;
    private SapiWebView cZt;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.coreExtra.view.j ayp = null;
    private final a.InterfaceC0042a YU = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(t.h.layout_sapi_webview_fill_uprofile);
        this.bduss = getIntent().getStringExtra(SapiWebViewActivityConfig.EXTRA_BDUSS);
        setupViews();
    }

    protected void setupViews() {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.sapi_filluprofile));
        if (TextUtils.isEmpty(this.bduss)) {
            Toast.makeText(getPageContext().getPageActivity(), "参数错误，无法正常化", 0).show();
            finish();
        }
        this.cZt = (SapiWebView) findViewById(t.g.sapi_webview);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.cZt);
        this.cZt.setOnBackCallback(new c(this));
        this.cZt.setOnFinishCallback(new d(this));
        this.cZt.setAuthorizationListener(new e(this));
        this.cZt.loadFillUProfile(this.bduss);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auz() {
        TbadkCoreApplication.m411getInst().onUserChanged();
        Intent intent = new Intent();
        intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auA() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.aLL != null) {
                this.aLL.cancel();
            }
            this.aLL = com.baidu.tbadk.core.a.a.qM().a(session.username, session.bduss, session.ptoken, this.YU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.ayp == null) {
            this.ayp = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.ayp.a(new f(this));
        }
        this.ayp.Bw();
        this.ayp.h(accountData);
        this.ayp.Bs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aLL != null) {
            this.aLL.cancel();
        }
    }
}
