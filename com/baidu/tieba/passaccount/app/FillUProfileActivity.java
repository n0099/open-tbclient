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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
public class FillUProfileActivity extends BaseActivity<FillUProfileActivity> {
    private BdAsyncTask<?, ?, ?> aHW;
    private String bduss;
    private SapiWebView dbO;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.coreExtra.view.j auq = null;
    private final a.InterfaceC0033a Uk = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(t.h.layout_sapi_webview_fill_uprofile);
        this.bduss = getIntent().getStringExtra("EXTRA_BDUSS");
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
        this.dbO = (SapiWebView) findViewById(t.g.sapi_webview);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.dbO);
        this.dbO.setOnBackCallback(new c(this));
        this.dbO.setOnFinishCallback(new d(this));
        this.dbO.setAuthorizationListener(new e(this));
        this.dbO.loadFillUProfile(this.bduss);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auI() {
        TbadkCoreApplication.m11getInst().onUserChanged();
        Intent intent = new Intent();
        intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auJ() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.aHW != null) {
                this.aHW.cancel();
            }
            this.aHW = com.baidu.tbadk.core.a.a.oj().a(session.username, session.bduss, "", this.Uk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.auq == null) {
            this.auq = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.auq.a(new f(this));
        }
        this.auq.zr();
        this.auq.h(accountData);
        this.auq.zn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aHW != null) {
            this.aHW.cancel();
        }
    }
}
