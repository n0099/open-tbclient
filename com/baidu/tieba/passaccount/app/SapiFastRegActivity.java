package com.baidu.tieba.passaccount.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class SapiFastRegActivity extends BaseActivity<SapiFastRegActivity> {
    private LinearLayout DF;
    private BdAsyncTask<?, ?, ?> aLs;
    private View afN;
    private View bmb;
    private TextView dIJ;
    private SapiWebView dIv;
    private boolean dIz;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.coreExtra.view.j avg = null;
    private String dII = null;
    private final a.InterfaceC0033a UB = new v(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(u.h.layout_sapi_webview_fastreg);
        initData(bundle);
        setupViews();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            bn.b(this.dIv, u.d.cp_link_tip_b, false);
        }
    }

    protected void setupViews() {
        this.DF = (LinearLayout) findViewById(u.g.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.sapi_reg_navi);
        this.afN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.afN.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(u.j.account_regedit));
        this.bmb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.dIJ = (TextView) this.bmb.findViewById(u.g.right_textview);
        this.dIJ.setText(getPageContext().getString(u.j.login));
        av.c(this.dIJ, u.d.navi_op_text, 1);
        this.dIJ.setOnClickListener(this);
        this.dIv = (SapiWebView) findViewById(u.g.sapi_webview);
        com.baidu.tbadk.core.a.d.c(getPageContext().getContext(), this.dIv);
        this.dIv.setOnFinishCallback(new w(this));
        this.dIv.setAuthorizationListener(new x(this));
        this.dIv.loadFastReg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.avg == null) {
            this.avg = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.avg.a(new y(this));
        }
        this.avg.zw();
        this.avg.h(accountData);
        this.avg.zs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCR() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.aLs != null) {
                this.aLs.cancel();
            }
            this.aLs = com.baidu.tbadk.core.a.a.oe().a(session.username, session.bduss, "", this.UB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(AccountData accountData) {
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        if (this.mFrom == 4) {
            Intent intent = new Intent();
            intent.putExtra(RegisterActivityConfig.FAST_REG_USER_TYPE, this.dII);
            setResult(-1, intent);
            finish();
            return;
        }
        Jb();
        aCN();
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
            this.dIz = getIntent().getBooleanExtra(IntentConfig.CLOSE, false);
            return;
        }
        this.mFrom = bundle.getInt("from", -1);
        this.dIz = bundle.getBoolean(IntentConfig.CLOSE, false);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.afN) {
            finish();
        } else if (view == this.dIJ) {
            if (this.mFrom == 1) {
                finish();
            } else {
                TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), 2, true, 11038)));
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

    private void aCN() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.m9getInst().onUserChanged();
        if (this.dIz) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra == -1) {
                if (com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                    intExtra = 1;
                } else {
                    intExtra = 1;
                }
            }
            com.baidu.tbadk.core.d.b.c(getPageContext().getPageActivity(), intExtra, false);
        }
        finish();
    }

    private void Jb() {
        if (this.mFrom == 3 && TbadkCoreApplication.m9getInst().getIsFirstUse()) {
            com.baidu.adp.lib.h.k.dN().b(new z(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.avg != null) {
            this.avg.onDestroy();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.DF != null) {
            this.DF.removeAllViews();
        }
        if (this.aLs != null) {
            this.aLs.cancel();
        }
    }
}
