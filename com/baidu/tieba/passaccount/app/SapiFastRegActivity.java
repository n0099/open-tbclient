package com.baidu.tieba.passaccount.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
public class SapiFastRegActivity extends BaseActivity<SapiFastRegActivity> {
    private LinearLayout Mh;
    private SapiWebView cdD;
    private boolean cdH;
    private View cdK;
    private TextView cdS;
    private View mBack;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.coreExtra.view.k atj = null;
    private String cdR = null;
    private final a.InterfaceC0040a XW = new u(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(i.g.layout_sapi_webview_fastreg);
        initData(bundle);
        aeo();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            bd.a((View) this.cdD, i.c.cp_link_tip_b, false);
        }
    }

    protected void aeo() {
        this.Mh = (LinearLayout) findViewById(i.f.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.sapi_reg_navi);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mBack.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(i.h.account_regedit));
        this.cdK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null);
        this.cdS = (TextView) this.cdK.findViewById(i.f.right_textview);
        this.cdS.setText(getPageContext().getString(i.h.login));
        an.b(this.cdS, i.c.navi_op_text, 1);
        this.cdS.setOnClickListener(this);
        this.cdD = (SapiWebView) findViewById(i.f.sapi_webview);
        com.baidu.tbadk.core.a.d.a(getPageContext().getContext(), this.cdD);
        this.cdD.setOnFinishCallback(new v(this));
        this.cdD.setAuthorizationListener(new w(this));
        this.cdD.loadFastReg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(AccountData accountData) {
        if (this.atj == null) {
            this.atj = new com.baidu.tbadk.coreExtra.view.k(getPageContext());
            this.atj.a(new x(this));
        }
        this.atj.yT();
        this.atj.h(accountData);
        this.atj.yP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aet() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.a.a.rb().a(session.username, session.bduss, session.ptoken, this.XW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(AccountData accountData) {
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        if (this.mFrom == 4) {
            Intent intent = new Intent();
            intent.putExtra(RegisterActivityConfig.FAST_REG_USER_TYPE, this.cdR);
            setResult(-1, intent);
            finish();
            return;
        }
        FQ();
        aep();
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
            this.cdH = getIntent().getBooleanExtra(IntentConfig.CLOSE, false);
            return;
        }
        this.mFrom = bundle.getInt("from", -1);
        this.cdH = bundle.getBoolean(IntentConfig.CLOSE, false);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mBack) {
            finish();
        } else if (view == this.cdS) {
            if (this.mFrom == 1) {
                finish();
            } else {
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), 2, true, 11038)));
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 11038 && i2 == -1) {
            setResult(-1);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
    }

    private void aep() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.m411getInst().onUserChanged();
        if (this.cdH) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra == -1) {
                if (com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                    intExtra = 1;
                } else {
                    intExtra = 1;
                }
            }
            com.baidu.tbadk.core.c.b.b(getPageContext().getPageActivity(), intExtra, false);
        }
        finish();
    }

    private void FQ() {
        if (this.mFrom == 3 && TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            com.baidu.adp.lib.g.k.hi().b(new y(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.atj != null) {
            this.atj.onDestroy();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.Mh != null) {
            this.Mh.removeAllViews();
        }
    }
}
