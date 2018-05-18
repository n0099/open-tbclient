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
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.tieba.thirdparty.message.AddUserAttrResponsedMessage;
/* loaded from: classes2.dex */
public class AccountBundlingActivity extends BaseActivity<AccountBundlingActivity> {
    private com.baidu.tbadk.core.util.b.a baE;
    private BdAsyncTask<?, ?, ?> bcg;
    private com.baidu.tieba.thirdparty.a.a gJt;
    private SapiAccount gJu;
    private String gJv;
    private HeadChangeType gJw;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private a gJx = null;
    private b gJy = null;
    private c gJz = null;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass7) aVar, str, i);
            if (aVar != null) {
                if (AccountBundlingActivity.this.gJz != null) {
                    AccountBundlingActivity.this.gJz.cancel();
                }
                AccountBundlingActivity.this.gJz = new c(aVar.ko());
                AccountBundlingActivity.this.gJz.execute(new String[0]);
            }
        }
    };
    private final a.InterfaceC0083a bcD = new a.InterfaceC0083a() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.8
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0083a
        public void cE(String str) {
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0083a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_cslogin_success", 0, "", new Object[0]);
            AccountBundlingActivity.this.closeLoadingDialog();
            AccountBundlingActivity.this.showLoadingDialog(AccountBundlingActivity.this.getResources().getString(d.k.account_bunding_add_user_attr), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.8.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                }
            });
            p(accountData);
            AccountBundlingActivity.this.tC(String.valueOf(AccountBundlingActivity.this.gJu.getSocialType().getType()));
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0083a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_cslogin_fail", i, str2, "uname", str);
            AccountBundlingActivity.this.closeLoadingDialog();
            AccountBundlingActivity.this.tE(str2);
        }

        private void p(final AccountData accountData) {
            h.fx().c(new Runnable() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.8.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.core.a.b.b(accountData);
                }
            });
            TbadkCoreApplication.setCurrentAccount(accountData, AccountBundlingActivity.this.getPageContext().getPageActivity());
            com.baidu.tbadk.browser.a.ar(TbadkCoreApplication.getInst());
        }
    };
    private HttpMessageListener gJA = new HttpMessageListener(CmdConfigHttp.CMD_ADD_USER_ATTR_URL) { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            AccountBundlingActivity.this.closeLoadingDialog();
            if (httpResponsedMessage instanceof AddUserAttrResponsedMessage) {
                if (!((AddUserAttrResponsedMessage) httpResponsedMessage).hasError()) {
                    if (AccountBundlingActivity.this.gJw != null) {
                        if (AccountBundlingActivity.this.gJw == HeadChangeType.NET) {
                            AccountBundlingActivity.this.bvn();
                            return;
                        } else if (AccountBundlingActivity.this.gJw == HeadChangeType.LOCAL) {
                            AccountBundlingActivity.this.bvm();
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
        setContentView(d.i.account_bunding_activty);
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
        if (this.gJx != null) {
            this.gJx.cancel();
        }
        if (this.gJy != null) {
            this.gJy.cancel();
        }
        if (this.gJz != null) {
            this.gJz.cancel();
        }
        if (this.bcg != null) {
            this.bcg.cancel();
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
            AccountBundlingActivity.this.showLoadingDialog(AccountBundlingActivity.this.getResources().getString(d.k.account_bunding_change_user_head), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.b.1
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
                str = this.mNetwork.ea(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.vi().wi().isRequestSuccess()) {
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
            AccountBundlingActivity.this.gJy = null;
            if (this.mNetwork != null) {
                this.mNetwork.eW();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.mNetwork != null) {
                if (!this.mNetwork.vi().wi().isRequestSuccess()) {
                    AccountBundlingActivity.this.tE(this.mNetwork.getErrorString());
                }
                AccountBundlingActivity.this.setResult(-1);
                AccountBundlingActivity.this.closeActivity();
            }
        }
    }

    private void initData() {
        this.gJu = SapiAccountManager.getInstance().getSession();
        if (this.gJu == null || !TextUtils.isEmpty(this.gJu.username)) {
            closeActivity();
        }
        registerTask();
        registerListener(this.gJA);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_USER_ATTR_URL, TbConfig.SERVER_ADDRESS + TbConfig.ADD_USER_ATTR_URL);
        tbHttpMessageTask.setResponsedClass(AddUserAttrResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tC(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_USER_ATTR_URL);
        httpMessage.addParam("type", 1);
        httpMessage.addParam("type_val", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void initUI() {
        this.gJt = new com.baidu.tieba.thirdparty.a.a(this);
        this.gJt.bvq().addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AccountBundlingActivity.this.gJt.tF(editable.toString());
            }
        });
        this.gJt.bvs().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AccountBundlingActivity.this.gJt.bvr();
            }
        });
        this.gJt.bvo().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AccountBundlingActivity.this.beD();
            }
        });
        this.gJt.c(this.gJu);
        this.gJt.ZJ().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                l.b(AccountBundlingActivity.this.getPageContext().getPageActivity(), AccountBundlingActivity.this.gJt.bvq());
                return false;
            }
        });
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.gJt.bvp()) {
            l.b(getPageContext().getPageActivity(), this.gJt.bvq());
            String obj = this.gJt.bvq().getText().toString();
            if (TextUtils.isEmpty(obj.trim())) {
                tE(getResources().getString(d.k.input_name));
            } else {
                tD(obj);
            }
        }
    }

    private void tD(String str) {
        SapiAccountService accountService = SapiAccountManager.getInstance().getAccountService();
        if (accountService != null && this.gJu != null) {
            accountService.fillUsername(new FillUsernameCallback() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: a */
                public void onSuccess(FillUsernameResult fillUsernameResult) {
                    com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_fill_success", 0, "", new Object[0]);
                    AccountBundlingActivity.this.closeLoadingDialog();
                    AccountBundlingActivity.this.showLoadingDialog(AccountBundlingActivity.this.getResources().getString(d.k.account_bunding_teiba_login), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.6.1
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    AccountBundlingActivity.this.bvl();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: b */
                public void onFailure(FillUsernameResult fillUsernameResult) {
                    AccountBundlingActivity.this.a(fillUsernameResult, AccountBundlingActivity.this.getResources().getString(d.k.fail));
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                    AccountBundlingActivity.this.showLoadingDialog(AccountBundlingActivity.this.getResources().getString(d.k.account_bunding_fillusername), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.6.2
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
                    AccountBundlingActivity.this.a(fillUsernameResult, AccountBundlingActivity.this.getResources().getString(d.k.account_bunding_error_invalidbduss));
                }

                @Override // com.baidu.sapi2.callback.FillUsernameCallback
                public void onUserHaveUsername(FillUsernameResult fillUsernameResult) {
                    AccountBundlingActivity.this.a(fillUsernameResult, AccountBundlingActivity.this.getResources().getString(d.k.account_bunding_error_have_username));
                    AccountBundlingActivity.this.gJt.mN(true);
                }
            }, this.gJu.bduss, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FillUsernameResult fillUsernameResult, String str) {
        String format = fillUsernameResult != null ? String.format(getString(d.k.account_bundling_error), fillUsernameResult.getResultMsg(), Integer.valueOf(fillUsernameResult.getResultCode())) : str;
        tE(format);
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_third_fill_error", -1, format, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvl() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.bcg != null) {
                this.bcg.cancel();
            }
            this.bcg = com.baidu.tbadk.core.a.a.qe().a(session.username, session.bduss, "", null, this.bcD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        private byte[] gJF;
        private x mNetwork = null;

        public c(byte[] bArr) {
            this.gJF = bArr;
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
                this.mNetwork.d("pic", this.gJF);
                str = this.mNetwork.uN();
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.vi().wi().isRequestSuccess()) {
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
            AccountBundlingActivity.this.gJz = null;
            if (this.mNetwork != null) {
                this.mNetwork.eW();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (this.mNetwork != null) {
                if (!this.mNetwork.vi().wi().isRequestSuccess()) {
                    AccountBundlingActivity.this.tE(this.mNetwork.getErrorString());
                }
                AccountBundlingActivity.this.setResult(-1);
                AccountBundlingActivity.this.closeActivity();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gJt.onChangeSkinType(i);
    }

    public void beD() {
        String[] strArr = {getPageContext().getString(d.k.change_photo), getPageContext().getString(d.k.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.a(strArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view2) {
                if (i == 0) {
                    Activity pageActivity = AccountBundlingActivity.this.getPageContext().getPageActivity();
                    if (AccountBundlingActivity.this.baE == null) {
                        AccountBundlingActivity.this.baE = new com.baidu.tbadk.core.util.b.a();
                    }
                    AccountBundlingActivity.this.baE.wt();
                    AccountBundlingActivity.this.baE.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!AccountBundlingActivity.this.baE.v(pageActivity)) {
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
        bVar.tF();
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
                            V(intent);
                            return;
                        } else {
                            O(intent);
                            return;
                        }
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.gJw = HeadChangeType.LOCAL;
                    beG();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    if (intent != null) {
                        this.gJw = HeadChangeType.NET;
                        this.gJt.bvo().setImageBitmap(null);
                        this.gJv = intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL);
                        this.gJt.bvo().startLoad(this.gJv, 10, false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void O(Intent intent) {
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

    private void beG() {
        if (this.gJx != null) {
            this.gJx.cancel();
        }
        this.gJx = new a();
        this.gJx.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvm() {
        if (this.gJy != null) {
            this.gJy.cancel();
        }
        this.gJy = new b();
        this.gJy.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvn() {
        showLoadingDialog(getResources().getString(d.k.account_bunding_change_user_head), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.thirdparty.AccountBundlingActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
            }
        });
        com.baidu.adp.lib.f.c.fp().a(this.gJv, 10, this.mCallback, 0, 0, getUniqueId(), new Object[0]);
    }

    public void tE(String str) {
        new com.baidu.tbadk.core.view.b().j(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AccountBundlingActivity.this.gJt.bvo().setImageDrawable(null);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public Bitmap doInBackground(Object... objArr) {
            return k.Y(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AccountBundlingActivity.this.gJx = null;
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
            AccountBundlingActivity.this.gJx = null;
            if (bitmap != null) {
                new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null).a(AccountBundlingActivity.this.gJt.bvo());
            }
        }
    }

    private void V(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig((Context) getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f, false)));
    }
}
