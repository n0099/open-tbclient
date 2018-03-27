package com.baidu.tieba.thirdparty;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.g.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.sapi2.result.FillUsernameResult;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.tieba.thirdparty.message.AddUserAttrResponsedMessage;
/* loaded from: classes2.dex */
public class AccountBundlingActivity extends BaseActivity<AccountBundlingActivity> {
    private com.baidu.tbadk.core.util.b.a bQG;
    private BdAsyncTask<?, ?, ?> bSb;
    private com.baidu.tieba.thirdparty.a.a hmS;
    private SapiAccount hmT;
    private String hmU;
    private HeadChangeType hmV;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private a hmW = null;
    private b hmX = null;
    private c hmY = null;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass7) aVar, str, i);
            if (aVar != null) {
                if (AccountBundlingActivity.this.hmY != null) {
                    AccountBundlingActivity.this.hmY.cancel();
                }
                AccountBundlingActivity.this.hmY = new c(aVar.sk());
                AccountBundlingActivity.this.hmY.execute(new String[0]);
            }
        }
    };
    private final a.InterfaceC0094a bSy = new a.InterfaceC0094a() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.8
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0094a
        public void cM(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0094a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_cslogin_success", 0, "", new Object[0]);
            AccountBundlingActivity.this.closeLoadingDialog();
            AccountBundlingActivity.this.showLoadingDialog(AccountBundlingActivity.this.getResources().getString(d.j.account_bunding_add_user_attr), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.8.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                }
            });
            p(accountData);
            AccountBundlingActivity.this.ts(String.valueOf(AccountBundlingActivity.this.hmT.getSocialType().getType()));
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0094a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_cslogin_fail", i, str2, "uname", str);
            AccountBundlingActivity.this.closeLoadingDialog();
            AccountBundlingActivity.this.tu(str2);
        }

        private void p(final AccountData accountData) {
            h.nt().d(new Runnable() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.8.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.a.b.b(accountData);
                }
            });
            TbadkCoreApplication.setCurrentAccount(accountData, AccountBundlingActivity.this.getPageContext().getPageActivity());
            com.baidu.tbadk.browser.b.aH(TbadkCoreApplication.getInst());
        }
    };
    private HttpMessageListener hmZ = new HttpMessageListener(CmdConfigHttp.CMD_ADD_USER_ATTR_URL) { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            AccountBundlingActivity.this.closeLoadingDialog();
            if (httpResponsedMessage instanceof AddUserAttrResponsedMessage) {
                if (!((AddUserAttrResponsedMessage) httpResponsedMessage).hasError()) {
                    if (AccountBundlingActivity.this.hmV != null) {
                        if (AccountBundlingActivity.this.hmV == HeadChangeType.NET) {
                            AccountBundlingActivity.this.bAn();
                            return;
                        } else if (AccountBundlingActivity.this.hmV == HeadChangeType.LOCAL) {
                            AccountBundlingActivity.this.bAm();
                            return;
                        } else {
                            return;
                        }
                    }
                    AccountBundlingActivity.this.setResult(-1);
                    AccountBundlingActivity.this.closeActivity();
                    return;
                }
                AccountBundlingActivity.this.setResult(-1);
                AccountBundlingActivity.this.closeActivity();
            }
        }
    };

    /* loaded from: classes2.dex */
    public enum HeadChangeType {
        LOCAL,
        NET
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.account_bunding_activty);
        initData();
        initUI();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hmW != null) {
            this.hmW.cancel();
        }
        if (this.hmX != null) {
            this.hmX.cancel();
        }
        if (this.hmY != null) {
            this.hmY.cancel();
        }
        if (this.bSb != null) {
            this.bSb.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private x mNetwork;

        private b() {
            this.mNetwork = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AccountBundlingActivity.this.showLoadingDialog(AccountBundlingActivity.this.getResources().getString(d.j.account_bunding_change_user_head), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.b.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.mNetwork.ei(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
                    return str;
                }
                return null;
            } catch (Exception e3) {
                e = e3;
                BdLog.e(e.getMessage());
                return str;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AccountBundlingActivity.this.hmX = null;
            if (this.mNetwork != null) {
                this.mNetwork.mS();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.mNetwork != null) {
                if (!this.mNetwork.Cz().Dx().isRequestSuccess()) {
                    AccountBundlingActivity.this.tu(this.mNetwork.getErrorString());
                }
                AccountBundlingActivity.this.setResult(-1);
                AccountBundlingActivity.this.closeActivity();
            }
        }
    }

    private void initData() {
        this.hmT = SapiAccountManager.getInstance().getSession();
        if (this.hmT == null || !TextUtils.isEmpty(this.hmT.username)) {
            closeActivity();
        }
        HQ();
        registerListener(this.hmZ);
    }

    private void HQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_USER_ATTR_URL, TbConfig.SERVER_ADDRESS + TbConfig.ADD_USER_ATTR_URL);
        tbHttpMessageTask.setResponsedClass(AddUserAttrResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ts(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_USER_ATTR_URL);
        httpMessage.addParam("type", 1);
        httpMessage.addParam("type_val", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void initUI() {
        this.hmS = new com.baidu.tieba.thirdparty.a.a(this);
        this.hmS.bAq().addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AccountBundlingActivity.this.hmS.tv(editable.toString());
            }
        });
        this.hmS.bAs().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AccountBundlingActivity.this.hmS.bAr();
            }
        });
        this.hmS.bAo().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AccountBundlingActivity.this.bjB();
            }
        });
        this.hmS.c(this.hmT);
        this.hmS.afu().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                l.a(AccountBundlingActivity.this.getPageContext().getPageActivity(), AccountBundlingActivity.this.hmS.bAq());
                return false;
            }
        });
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hmS.bAp()) {
            l.a(getPageContext().getPageActivity(), this.hmS.bAq());
            String obj = this.hmS.bAq().getText().toString();
            if (TextUtils.isEmpty(obj.trim())) {
                tu(getResources().getString(d.j.input_name));
            } else {
                tt(obj);
            }
        }
    }

    private void tt(String str) {
        SapiAccountService accountService = SapiAccountManager.getInstance().getAccountService();
        if (accountService != null && this.hmT != null) {
            accountService.fillUsername(new FillUsernameCallback() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: a */
                public void onSuccess(FillUsernameResult fillUsernameResult) {
                    com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_fill_success", 0, "", new Object[0]);
                    AccountBundlingActivity.this.closeLoadingDialog();
                    AccountBundlingActivity.this.showLoadingDialog(AccountBundlingActivity.this.getResources().getString(d.j.account_bunding_teiba_login), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.6.1
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    AccountBundlingActivity.this.bAl();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: b */
                public void onFailure(FillUsernameResult fillUsernameResult) {
                    AccountBundlingActivity.this.a(fillUsernameResult, AccountBundlingActivity.this.getResources().getString(d.j.fail));
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                    AccountBundlingActivity.this.showLoadingDialog(AccountBundlingActivity.this.getResources().getString(d.j.account_bunding_fillusername), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.6.2
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                    AccountBundlingActivity.this.closeLoadingDialog();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.LoginStatusAware
                /* renamed from: c */
                public void onBdussExpired(FillUsernameResult fillUsernameResult) {
                    AccountBundlingActivity.this.a(fillUsernameResult, AccountBundlingActivity.this.getResources().getString(d.j.account_bunding_error_invalidbduss));
                }

                @Override // com.baidu.sapi2.callback.FillUsernameCallback
                public void onUserHaveUsername(FillUsernameResult fillUsernameResult) {
                    AccountBundlingActivity.this.a(fillUsernameResult, AccountBundlingActivity.this.getResources().getString(d.j.account_bunding_error_have_username));
                    AccountBundlingActivity.this.hmS.nk(true);
                }
            }, this.hmT.bduss, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FillUsernameResult fillUsernameResult, String str) {
        String format = fillUsernameResult != null ? String.format(getString(d.j.account_bundling_error), fillUsernameResult.getResultMsg(), Integer.valueOf(fillUsernameResult.getResultCode())) : str;
        tu(format);
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_fill_error", -1, format, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAl() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.bSb != null) {
                this.bSb.cancel();
            }
            this.bSb = com.baidu.tbadk.core.a.a.xv().a(session.username, session.bduss, "", null, this.bSy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private byte[] hnf;
        private x mNetwork = null;

        public c(byte[] bArr) {
            this.hnf = bArr;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                this.mNetwork.d("pic", this.hnf);
                str = this.mNetwork.Ce();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
                    return str;
                }
                return null;
            } catch (Exception e3) {
                e = e3;
                BdLog.e(e.getMessage());
                return str;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AccountBundlingActivity.this.hmY = null;
            if (this.mNetwork != null) {
                this.mNetwork.mS();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.mNetwork != null) {
                if (!this.mNetwork.Cz().Dx().isRequestSuccess()) {
                    AccountBundlingActivity.this.tu(this.mNetwork.getErrorString());
                }
                AccountBundlingActivity.this.setResult(-1);
                AccountBundlingActivity.this.closeActivity();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hmS.onChangeSkinType(i);
    }

    public void bjB() {
        String[] strArr = {getPageContext().getString(d.j.change_photo), getPageContext().getString(d.j.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.a(strArr, new b.InterfaceC0097b() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                if (i == 0) {
                    Activity pageActivity = AccountBundlingActivity.this.getPageContext().getPageActivity();
                    if (AccountBundlingActivity.this.bQG == null) {
                        AccountBundlingActivity.this.bQG = new com.baidu.tbadk.core.util.b.a();
                    }
                    AccountBundlingActivity.this.bQG.DI();
                    AccountBundlingActivity.this.bQG.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!AccountBundlingActivity.this.bQG.v(pageActivity)) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(AccountBundlingActivity.this.getPageContext().getPageActivity(), AccountBundlingActivity.this.mWriteImagesInfo.toJsonString());
                        albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    } else {
                        return;
                    }
                } else if (i == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(AccountBundlingActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO, false)));
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext());
        bVar.AY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            W(intent);
                            return;
                        } else {
                            P(intent);
                            return;
                        }
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.hmV = HeadChangeType.LOCAL;
                    bjE();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    if (intent != null) {
                        this.hmV = HeadChangeType.NET;
                        this.hmS.bAo().setImageBitmap(null);
                        this.hmU = intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL);
                        this.hmS.bAo().startLoad(this.hmU, 10, false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void P(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
            if (this.mWriteImagesInfo.getChosedFiles() != null && this.mWriteImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig((Context) getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.mWriteImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, false)));
            }
            this.mWriteImagesInfo.clear();
        }
    }

    private void bjE() {
        if (this.hmW != null) {
            this.hmW.cancel();
        }
        this.hmW = new a();
        this.hmW.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAm() {
        if (this.hmX != null) {
            this.hmX.cancel();
        }
        this.hmX = new b();
        this.hmX.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAn() {
        showLoadingDialog(getResources().getString(d.j.account_bunding_change_user_head), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
            }
        });
        com.baidu.adp.lib.f.c.nm().a(this.hmU, 10, this.mCallback, 0, 0, getUniqueId(), new Object[0]);
    }

    public void tu(String str) {
        new e().r(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AccountBundlingActivity.this.hmS.bAo().setImageDrawable(null);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public Bitmap doInBackground(Object... objArr) {
            return k.X(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AccountBundlingActivity.this.hmW = null;
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            AccountBundlingActivity.this.hmW = null;
            if (bitmap != null) {
                new com.baidu.adp.widget.a.a(bitmap, false, (String) null).a(AccountBundlingActivity.this.hmS.bAo());
            }
        }
    }

    private void W(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig((Context) getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f, false)));
    }
}
