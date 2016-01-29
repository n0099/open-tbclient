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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
public class SapiFastRegActivity extends BaseActivity<SapiFastRegActivity> {
    private LinearLayout Nf;
    private View ajk;
    private TextView cGA;
    private SapiWebView cGl;
    private boolean cGp;
    private View cGs;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.coreExtra.view.j axI = null;
    private String cGz = null;
    private final a.InterfaceC0042a ZI = new u(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(t.h.layout_sapi_webview_fastreg);
        initData(bundle);
        setupViews();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            bi.b(this.cGl, t.d.cp_link_tip_b, false);
        }
    }

    protected void setupViews() {
        this.Nf = (LinearLayout) findViewById(t.g.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.sapi_reg_navi);
        this.ajk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ajk.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.account_regedit));
        this.cGs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.cGA = (TextView) this.cGs.findViewById(t.g.right_textview);
        this.cGA.setText(getPageContext().getString(t.j.login));
        ar.b(this.cGA, t.d.navi_op_text, 1);
        this.cGA.setOnClickListener(this);
        this.cGl = (SapiWebView) findViewById(t.g.sapi_webview);
        com.baidu.tbadk.core.a.d.c(getPageContext().getContext(), this.cGl);
        this.cGl.setOnFinishCallback(new v(this));
        this.cGl.setAuthorizationListener(new w(this));
        this.cGl.loadFastReg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.axI == null) {
            this.axI = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.axI.a(new x(this));
        }
        this.axI.AT();
        this.axI.h(accountData);
        this.axI.AP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anP() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.a.a.rv().a(session.username, session.bduss, session.ptoken, this.ZI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(AccountData accountData) {
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        if (this.mFrom == 4) {
            Intent intent = new Intent();
            intent.putExtra(RegisterActivityConfig.FAST_REG_USER_TYPE, this.cGz);
            setResult(-1, intent);
            finish();
            return;
        }
        In();
        anL();
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
            this.cGp = getIntent().getBooleanExtra(IntentConfig.CLOSE, false);
            return;
        }
        this.mFrom = bundle.getInt("from", -1);
        this.cGp = bundle.getBoolean(IntentConfig.CLOSE, false);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ajk) {
            finish();
        } else if (view == this.cGA) {
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
            Intent intent2 = new Intent();
            intent2.putExtra(RegisterActivityConfig.FAST_REG_USER_TYPE, RegisterActivityConfig.LOGIN_USER);
            setResult(-1, intent2);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
    }

    private void anL() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.m411getInst().onUserChanged();
        if (this.cGp) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra == -1) {
                if (com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                    intExtra = 1;
                } else {
                    intExtra = 1;
                }
            }
            com.baidu.tbadk.core.c.b.b(getPageContext().getPageActivity(), intExtra, false);
        }
        finish();
    }

    private void In() {
        if (this.mFrom == 3 && TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            com.baidu.adp.lib.h.k.hs().b(new y(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.axI != null) {
            this.axI.onDestroy();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.Nf != null) {
            this.Nf.removeAllViews();
        }
    }
}
