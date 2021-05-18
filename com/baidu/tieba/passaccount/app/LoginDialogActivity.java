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
import com.baidu.tbadk.ala.ILoginListener;
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
import d.a.c.e.m.e;
import d.a.c.e.m.h;
import d.a.j0.b.d;
import d.a.j0.r.l.a;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class LoginDialogActivity extends SuspendedActivity implements d.a.j0.t0.a {
    public ViewGroup contentView;
    public d.a.k0.b2.c.a dialogControl;
    public String dialogType;
    public String locate;
    public ILoginListener loginListener;
    public BdAsyncTask<?, ?, ?> mAccountLoginTask;
    public final a.InterfaceC1132a mReLoginCallback = new a();
    public String operator;
    public String phoneNum;
    public String searchUrl;
    public String shareModelJSONStr;
    public String sign;

    /* loaded from: classes4.dex */
    public class a implements a.InterfaceC1132a {
        public a() {
        }

        @Override // d.a.j0.r.l.a.InterfaceC1132a
        public void a(String str, int i2, String str2) {
            LoginDialogActivity.this.closeLoadingDialog();
            LoginDialogActivity.this.showToast(str2);
        }

        @Override // d.a.j0.r.l.a.InterfaceC1132a
        public void b(String str) {
            LoginDialogActivity.this.showLoading();
        }

        @Override // d.a.j0.r.l.a.InterfaceC1132a
        public void c(AccountData accountData) {
            LoginDialogActivity.this.closeLoadingDialog();
            LoginDialogActivity.this.onLoginSuccess(accountData);
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountData f18838e;

        public c(AccountData accountData) {
            this.f18838e = accountData;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.j0.r.l.c.g(this.f18838e);
            d.a.j0.r.z.a.a("account", -1L, 0, "login_activity_save_account_to_db", 0, "", new Object[0]);
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
        Serializable serializableExtra = getIntent().getSerializableExtra("login_dialog_login_listener");
        if (serializableExtra instanceof ILoginListener) {
            this.loginListener = (ILoginListener) serializableExtra;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoginSuccess(AccountData accountData) {
        saveAccountInfo(accountData);
        d.a.j0.r.z.a.a("account", -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.getInst().onUserChanged(getIntent());
        finishForResult(-1);
        if (d.f()) {
            d.a.j0.a.c.y().r();
        }
        continueDoSearchProcess();
    }

    private void saveAccountInfo(AccountData accountData) {
        h.a().c(new c(accountData));
        d.a.j0.r.z.a.a("account", -1L, 0, "login_activity_save_account_to_application", 0, "", new Object[0]);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        d.a.j0.l.a.f(TbadkCoreApplication.getInst());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, Boolean.TRUE));
    }

    public void addLoginSuccessLog(String str) {
        if (getIntent() != null) {
            DialogLoginHelper.addLoginDialogSuccessLog(this.locate, this.dialogType, str);
        }
    }

    public void finishForResult(int i2) {
        ILoginListener iLoginListener = this.loginListener;
        if (iLoginListener != null) {
            if (i2 == 0) {
                iLoginListener.onFail();
            } else if (i2 == -1) {
                iLoginListener.onSuccess();
            } else {
                iLoginListener.onCancel();
            }
            this.loginListener = null;
        }
        Intent intent = new Intent();
        intent.putExtra(HttpRequest.BDUSS, TbadkCoreApplication.getCurrentBduss());
        setResult(i2, intent);
        finish();
    }

    public ILoginListener getLoginListener() {
        return this.loginListener;
    }

    @Override // d.a.j0.t0.a
    public Intent getResultIntent() {
        d.a.k0.b2.c.a aVar = this.dialogControl;
        if (aVar != null) {
            return aVar.getResultIntent();
        }
        return null;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public d.a.j0.t0.a getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        this.contentView = linearLayout;
        navigationBar.setVisibility(8);
        if (getIntent() == null) {
            finish();
            return this;
        }
        initData();
        if (TextUtils.isEmpty(this.shareModelJSONStr)) {
            this.dialogControl = new d.a.k0.b2.c.b(this.phoneNum, this.operator, this.sign);
        } else {
            this.dialogControl = new d.a.k0.b2.c.c(this.shareModelJSONStr);
        }
        this.dialogControl.a(this, linearLayout);
        return this;
    }

    @Override // d.a.j0.t0.a
    public boolean isOnViewCancel() {
        return false;
    }

    @Override // d.a.j0.t0.a
    public boolean isOnViewTop() {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Override // d.a.j0.t0.a
    public void onViewChangeSkinType(int i2) {
        this.contentView.setBackgroundResource(R.color.transparent);
        d.a.k0.b2.c.a aVar = this.dialogControl;
        if (aVar != null) {
            aVar.onViewChangeSkinType(i2);
        }
    }

    public void passLoginCancel() {
        ILoginListener iLoginListener = this.loginListener;
        if (iLoginListener != null) {
            iLoginListener.onCancel();
            this.loginListener = null;
        }
    }

    public void passLoginFail() {
        finishForResult(0);
    }

    public void passLoginSucc() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(Boolean.TRUE));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
            this.mAccountLoginTask = d.a.j0.r.l.a.b().a(session.username, session.bduss, "", null, this.mReLoginCallback);
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
