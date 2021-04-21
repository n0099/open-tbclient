package com.baidu.tieba.passaccount.app;

import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginDialogActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import d.b.c.e.m.e;
import d.b.c.e.m.h;
import d.b.i0.b.d;
import d.b.i0.r.l.a;
/* loaded from: classes3.dex */
public class LoginDialogActivity extends SuspendedActivity implements d.b.i0.t0.a {
    public ViewGroup contentView;
    public d.b.j0.b2.c.a dialogControl;
    public String dialogType;
    public String locate;
    public BdAsyncTask<?, ?, ?> mAccountLoginTask;
    public final a.InterfaceC1117a mReLoginCallback = new a();
    public String operator;
    public String phoneNum;
    public String searchUrl;
    public String shareModelJSONStr;
    public String sign;

    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC1117a {
        public a() {
        }

        @Override // d.b.i0.r.l.a.InterfaceC1117a
        public void a(String str, int i, String str2) {
            LoginDialogActivity.this.closeLoadingDialog();
            LoginDialogActivity.this.showToast(str2);
        }

        @Override // d.b.i0.r.l.a.InterfaceC1117a
        public void b(String str) {
            LoginDialogActivity.this.showLoading();
        }

        @Override // d.b.i0.r.l.a.InterfaceC1117a
        public void c(AccountData accountData) {
            LoginDialogActivity.this.closeLoadingDialog();
            LoginDialogActivity.this.onLoginSuccess(accountData);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (StringUtils.isNull(LoginDialogActivity.this.searchUrl)) {
                return;
            }
            UrlManager.getInstance().dealOneLinkWithOutJumpWebView(LoginDialogActivity.this.getPageContext(), new String[]{LoginDialogActivity.this.searchUrl});
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountData f19094e;

        public c(AccountData accountData) {
            this.f19094e = accountData;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.i0.r.l.c.g(this.f19094e);
            d.b.i0.r.z.a.a("account", -1L, 0, "login_activity_save_account_to_db", 0, "", new Object[0]);
        }
    }

    private void continueDoSearchProcess() {
        e.a().post(new b());
    }

    private void initData() {
        this.shareModelJSONStr = getIntent().getStringExtra(LoginDialogActivityConfig.SHARE_MODEL_JSON_STRING);
        this.phoneNum = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_ENCRYPT_PHONE_NUM);
        this.operator = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_OPERATOR);
        this.sign = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_SIGN);
        this.searchUrl = getIntent().getStringExtra(LoginDialogActivityConfig.LOGIN_DIALOG_DATA_URL);
        this.locate = getIntent().getStringExtra(LoginDialogActivityConfig.LOGIN_DIALOG_DATA_LOCATE);
        this.dialogType = getIntent().getStringExtra(LoginDialogActivityConfig.LOGIN_DIALOG_DATA_TYPE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoginSuccess(AccountData accountData) {
        saveAccountInfo(accountData);
        d.b.i0.r.z.a.a("account", -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.getInst().onUserChanged(getIntent());
        finishForResult(-1);
        if (d.f()) {
            d.b.i0.a.c.y().r();
        }
        continueDoSearchProcess();
    }

    private void saveAccountInfo(AccountData accountData) {
        h.a().c(new c(accountData));
        d.b.i0.r.z.a.a("account", -1L, 0, "login_activity_save_account_to_application", 0, "", new Object[0]);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        d.b.i0.l.a.f(TbadkCoreApplication.getInst());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, Boolean.TRUE));
    }

    public void addLoginSuccessLog(String str) {
        if (getIntent() != null) {
            DialogLoginHelper.addLoginDialogSuccessLog(this.locate, this.dialogType, str);
        }
    }

    public void finishForResult(int i) {
        Intent intent = new Intent();
        intent.putExtra(HttpRequest.BDUSS, TbadkCoreApplication.getCurrentBduss());
        setResult(i, intent);
        finish();
    }

    @Override // d.b.i0.t0.a
    public Intent getResultIntent() {
        d.b.j0.b2.c.a aVar = this.dialogControl;
        if (aVar != null) {
            return aVar.getResultIntent();
        }
        return null;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public d.b.i0.t0.a getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        this.contentView = linearLayout;
        navigationBar.setVisibility(8);
        if (getIntent() == null) {
            finish();
            return this;
        }
        initData();
        if (TextUtils.isEmpty(this.shareModelJSONStr)) {
            this.dialogControl = new d.b.j0.b2.c.b(this.phoneNum, this.operator, this.sign);
        } else {
            this.dialogControl = new d.b.j0.b2.c.c(this.shareModelJSONStr);
        }
        this.dialogControl.a(this, linearLayout);
        return this;
    }

    @Override // d.b.i0.t0.a
    public boolean isOnViewCancel() {
        return false;
    }

    @Override // d.b.i0.t0.a
    public boolean isOnViewTop() {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // d.b.i0.t0.a
    public void onViewChangeSkinType(int i) {
        this.contentView.setBackgroundResource(R.color.transparent);
        d.b.j0.b2.c.a aVar = this.dialogControl;
        if (aVar != null) {
            aVar.onViewChangeSkinType(i);
        }
    }

    public void passLoginSucc() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(Boolean.TRUE));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
            this.mAccountLoginTask = d.b.i0.r.l.a.b().a(session.username, session.bduss, "", null, this.mReLoginCallback);
            return;
        }
        closeLoadingDialog();
        finishForResult(0);
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void requestData() {
    }

    public void showLoading() {
        if (getLoadingDialog() == null || !getLoadingDialog().c()) {
            showLoadingDialog(getPageContext().getString(R.string.sapi_logining));
            getLoadingDialog().f(false);
            getLoadingDialog().g(false);
        }
    }
}
