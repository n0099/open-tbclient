package com.baidu.tieba.passaccount.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.g.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.b;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
public class SapiFastRegActivity extends BaseActivity<SapiFastRegActivity> {
    private BdAsyncTask<?, ?, ?> bQc;
    private View beR;
    private TextView fAH;
    private SapiWebView fAp;
    private boolean fAs;
    private View fAw;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private LinearLayout mRootLayout;
    private d bQb = null;
    private String fAG = null;
    private final a.InterfaceC0070a aSq = new a.InterfaceC0070a() { // from class: com.baidu.tieba.passaccount.app.SapiFastRegActivity.3
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0070a
        public void cB(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0070a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_cslogin_success", 0, "", new Object[0]);
            if (TextUtils.isEmpty(accountData.getAccount())) {
                SapiFastRegActivity.this.j(accountData);
                return;
            }
            SapiFastRegActivity.this.fAG = RegisterActivityConfig.LOGIN_USER;
            SapiFastRegActivity.this.q(accountData);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.passaccount.app.SapiFastRegActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0070a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_cslogin_fail", i, str2, new Object[0]);
            SapiFastRegActivity.this.showToast(d.j.register_retry);
            TbadkCoreApplication.getInst().login(SapiFastRegActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) SapiFastRegActivity.this.getPageContext().getPageActivity(), (String) null, true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
            SapiFastRegActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.layout_sapi_webview_fastreg);
        initData(bundle);
        setupViews();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ax.e(this.fAp, d.C0108d.cp_link_tip_b, false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    protected void setupViews() {
        this.mRootLayout = (LinearLayout) findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.sapi_reg_navi);
        this.beR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.beR.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.j.register));
        this.fAw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.fAH = (TextView) this.fAw.findViewById(d.g.right_textview);
        this.fAH.setText(getPageContext().getString(d.j.login));
        aj.e(this.fAH, d.C0108d.navi_op_text, 1);
        this.fAH.setOnClickListener(this);
        try {
            this.fAp = new SapiWebView(getActivity());
        } catch (Exception e) {
            BdLog.e(e.toString());
            finish();
        }
        this.mRootLayout.addView(this.fAp, new LinearLayout.LayoutParams(-1, -1));
        com.baidu.tbadk.core.a.d.c(getPageContext().getContext(), this.fAp);
        this.fAp.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.tieba.passaccount.app.SapiFastRegActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                SapiFastRegActivity.this.finish();
            }
        });
        this.fAp.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.tieba.passaccount.app.SapiFastRegActivity.2
            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess() {
                com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_success", 0, "", new Object[0]);
                SapiFastRegActivity.this.aXO();
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i, String str) {
                com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_fail", i, str, new Object[0]);
                if (str != null && !"".equals(str)) {
                    SapiFastRegActivity.this.showToast(str);
                } else {
                    SapiFastRegActivity.this.showToast(d.j.data_load_error);
                }
                SapiFastRegActivity.this.finish();
            }
        });
        this.fAp.loadRegist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.bQb == null) {
            this.bQb = new com.baidu.tbadk.coreExtra.view.d(getPageContext());
            this.bQb.a(new d.a() { // from class: com.baidu.tieba.passaccount.app.SapiFastRegActivity.4
                @Override // com.baidu.tbadk.coreExtra.view.d.a
                public void i(AccountData accountData2) {
                    SapiFastRegActivity.this.fAG = RegisterActivityConfig.REGIST_USER;
                    SapiFastRegActivity.this.q(accountData2);
                }
            });
        }
        this.bQb.ID();
        this.bQb.h(accountData);
        this.bQb.Iz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXO() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.bQc != null) {
                this.bQc.cancel();
            }
            this.bQc = a.wI().a(session.username, session.bduss, "", null, this.aSq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(AccountData accountData) {
        b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        if (this.mFrom == 4 || this.mFrom == 1) {
            Intent intent = new Intent();
            intent.putExtra(RegisterActivityConfig.FAST_REG_USER_TYPE, this.fAG);
            setResult(-1, intent);
            finish();
            return;
        }
        aXM();
        aXK();
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
            this.fAs = getIntent().getBooleanExtra(IntentConfig.CLOSE, false);
            return;
        }
        this.mFrom = bundle.getInt("from", -1);
        this.fAs = bundle.getBoolean(IntentConfig.CLOSE, false);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.beR) {
            finish();
        } else if (view == this.fAH) {
            if (this.mFrom == 1) {
                finish();
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), 2, true, 11038)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
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

    private void aXK() {
        int i = 1;
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.getInst().onUserChanged();
        if (this.fAs) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra != -1) {
                i = intExtra;
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            com.baidu.tbadk.core.e.b.e(getPageContext().getPageActivity(), i, false);
        }
        finish();
    }

    private void aXM() {
        if (this.mFrom == 3 && TbadkCoreApplication.getInst().getIsFirstUse()) {
            h.nt().d(new Runnable() { // from class: com.baidu.tieba.passaccount.app.SapiFastRegActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    TbadkCoreApplication.getInst().setUsed();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bQb != null) {
            this.bQb.onDestroy();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.mRootLayout != null) {
            this.mRootLayout.removeAllViews();
        }
        if (this.bQc != null) {
            this.bQc.cancel();
        }
    }
}
