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
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
public class SapiFastRegActivity extends BaseActivity<SapiFastRegActivity> {
    private BdAsyncTask<?, ?, ?> aXb;
    private View arn;
    private TextView eCH;
    private SapiWebView eCq;
    private View eCw;
    private boolean mClose;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private LinearLayout mRootLayout;
    private d aHa = null;
    private String eCG = null;
    private final a.InterfaceC0040a aeT = new a.InterfaceC0040a() { // from class: com.baidu.tieba.passaccount.app.SapiFastRegActivity.3
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
        public void cw(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_cslogin_success", 0, "", new Object[0]);
            if (TextUtils.isEmpty(accountData.getAccount())) {
                SapiFastRegActivity.this.k(accountData);
                return;
            }
            SapiFastRegActivity.this.eCG = RegisterActivityConfig.LOGIN_USER;
            SapiFastRegActivity.this.r(accountData);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.passaccount.app.SapiFastRegActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
        public void b(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_cslogin_fail", i, str2, new Object[0]);
            SapiFastRegActivity.this.showToast(d.l.register_retry);
            TbadkCoreApplication.getInst().login(SapiFastRegActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) SapiFastRegActivity.this.getPageContext().getPageActivity(), (String) null, true, 11003)));
            SapiFastRegActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.j.layout_sapi_webview_fastreg);
        initData(bundle);
        setupViews();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            aw.b(this.eCq, d.e.cp_link_tip_b, false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    protected void setupViews() {
        this.mRootLayout = (LinearLayout) findViewById(d.h.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.sapi_reg_navi);
        this.arn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.arn.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.l.register));
        this.eCw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.navigation_right_button_layout, (View.OnClickListener) null);
        this.eCH = (TextView) this.eCw.findViewById(d.h.right_textview);
        this.eCH.setText(getPageContext().getString(d.l.login));
        ai.c(this.eCH, d.e.navi_op_text, 1);
        this.eCH.setOnClickListener(this);
        this.eCq = (SapiWebView) findViewById(d.h.sapi_webview);
        com.baidu.tbadk.core.a.d.c(getPageContext().getContext(), this.eCq);
        this.eCq.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.tieba.passaccount.app.SapiFastRegActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                SapiFastRegActivity.this.finish();
            }
        });
        this.eCq.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.tieba.passaccount.app.SapiFastRegActivity.2
            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess() {
                com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_success", 0, "", new Object[0]);
                SapiFastRegActivity.this.aOU();
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i, String str) {
                com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_fail", i, str, new Object[0]);
                if (str != null && !"".equals(str)) {
                    SapiFastRegActivity.this.showToast(str);
                } else {
                    SapiFastRegActivity.this.showToast(d.l.data_load_error);
                }
                SapiFastRegActivity.this.finish();
            }
        });
        this.eCq.loadRegist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.aHa == null) {
            this.aHa = new com.baidu.tbadk.coreExtra.view.d(getPageContext());
            this.aHa.a(new d.a() { // from class: com.baidu.tieba.passaccount.app.SapiFastRegActivity.4
                @Override // com.baidu.tbadk.coreExtra.view.d.a
                public void j(AccountData accountData2) {
                    SapiFastRegActivity.this.eCG = RegisterActivityConfig.REGIST_USER;
                    SapiFastRegActivity.this.r(accountData2);
                }
            });
        }
        this.aHa.Bn();
        this.aHa.i(accountData);
        this.aHa.Bj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOU() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.aXb != null) {
                this.aXb.cancel();
            }
            this.aXb = a.pf().a(session.username, session.bduss, "", null, this.aeT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(AccountData accountData) {
        b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        if (this.mFrom == 4 || this.mFrom == 1) {
            Intent intent = new Intent();
            intent.putExtra(RegisterActivityConfig.FAST_REG_USER_TYPE, this.eCG);
            setResult(-1, intent);
            finish();
            return;
        }
        aOS();
        aOQ();
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
            this.mClose = getIntent().getBooleanExtra(IntentConfig.CLOSE, false);
            return;
        }
        this.mFrom = bundle.getInt("from", -1);
        this.mClose = bundle.getBoolean(IntentConfig.CLOSE, false);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.arn) {
            finish();
        } else if (view == this.eCH) {
            if (this.mFrom == 1) {
                finish();
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), 2, true, 11038)));
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

    private void aOQ() {
        int i = 1;
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_pass_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.getInst().onUserChanged();
        if (this.mClose) {
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
            com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), i, false);
        }
        finish();
    }

    private void aOS() {
        if (this.mFrom == 3 && TbadkCoreApplication.getInst().getIsFirstUse()) {
            h.gb().e(new Runnable() { // from class: com.baidu.tieba.passaccount.app.SapiFastRegActivity.5
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
        if (this.aHa != null) {
            this.aHa.onDestroy();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.mRootLayout != null) {
            this.mRootLayout.removeAllViews();
        }
        if (this.aXb != null) {
            this.aXb.cancel();
        }
    }
}
