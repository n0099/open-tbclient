package com.baidu.tieba.write.shareSDK;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.view.ShareSDKImageView;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private com.baidu.tieba.tbadkCore.writeModel.a arW;
    private String bPh;
    private String cWA;
    private String dmb;
    private String dmc;
    private String dmd;
    private String dme;
    private PackageManager dmf;
    private PackageInfo dmg;
    private int dmh;
    private o dmi;
    com.baidu.tieba.write.shareSDK.a dmj;
    private com.baidu.tieba.write.view.e dmm;
    private com.baidu.tieba.write.view.e dmn;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData dbx = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener cpX = null;
    private boolean dmk = false;
    private boolean dml = false;
    private e.b dmo = new c(this);
    private e.b dmp = new g(this);
    private e.b dmq = new h(this);
    private final a.b dmr = new i(this);
    private final a.c dms = new j(this);
    private DialogInterface.OnKeyListener dmt = new k(this);
    private View.OnClickListener dmu = new l(this);
    private View.OnClickListener dmv = new m(this);
    private View.OnClickListener dmw = new n(this);
    private final View.OnFocusChangeListener dmx = new d(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getWindow().setSoftInputMode(18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdLog.addLogPackage(WriteShareActivity.class.getPackage().getName());
        super.onCreate(bundle);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        setSwipeBackEnabled(false);
        this.dmf = getPageContext().getPageActivity().getPackageManager();
        aBQ();
        boolean aBR = aBR();
        initData(bundle);
        initUI();
        if (!aBR) {
            if (TextUtils.isEmpty(this.cWA)) {
                lQ(i.h.share_parameter_invalid_tip);
            } else {
                lQ(i.h.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            aBT();
        } else {
            aBS();
        }
        TiebaStatic.log("share4sdk");
    }

    private void aBQ() {
        this.packageName = getCallingPackage();
        if (this.dmf != null && this.packageName != null) {
            try {
                this.dmg = this.dmf.getPackageInfo(this.packageName, 64);
                if (this.dmg != null) {
                    if (this.dmg.applicationInfo != null && this.dmg.applicationInfo.loadLabel(this.dmf) != null) {
                        this.bPh = this.dmg.applicationInfo.loadLabel(this.dmf).toString();
                    }
                    if (this.dmg.signatures != null && this.dmg.signatures.length > 0 && this.dmg.signatures[0] != null) {
                        this.dme = au.P(this.dmg.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.bPh = null;
                this.dme = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.dmb = extras.getString("ShareUrl");
            this.dmc = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.dmd = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.bPh)) {
                this.bPh = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.dme)) {
                this.dme = extras.getString("appSign");
            }
            this.cWA = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean aBR() {
        return (TextUtils.isEmpty(this.cWA) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.dmc) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void aBS() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
    }

    private void aBT() {
        if (TextUtils.isEmpty(this.dmd)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            aBU();
        }
    }

    private void aBU() {
        this.dmi.aCc();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.dmj.mr(this.dbx.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBV() {
        if (this.dmm == null) {
            this.dmm = new com.baidu.tieba.write.view.e(getActivity());
            this.dmm.gV(false);
            this.dmm.lT(i.e.icon_send_ok);
            this.dmm.lW(i.h.share_alert_success);
            this.dmm.a(i.h.share_stay_in_tieba, this.dmo);
            this.dmm.b(i.h.back, this.dmq);
            this.dmm.a(this.dmt);
            this.dmm.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBW() {
        if (this.dmn == null) {
            this.dmn = new com.baidu.tieba.write.view.e(getActivity());
            this.dmn.lT(i.e.icon_send_error);
            this.dmn.lU(i.e.btn_w_square);
            this.dmn.lV(i.c.dialog_bdalert_title);
            this.dmn.lW(i.h.share_alert_fail);
            this.dmn.a(i.h.share_keep_sending, this.dmp);
            this.dmn.b(i.h.back, this.dmq);
            this.dmn.a(this.dmt);
            this.dmn.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aBX() {
        if (this.arW != null) {
            this.arW.cancelLoadData();
        }
    }

    protected void aBY() {
        if (this.arW != null) {
            this.arW.axN();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        aBX();
        aBY();
        FF();
        super.onDestroy();
    }

    private void FF() {
        ShareSDKImageView aCm;
        if (this.dmi != null && (aCm = this.dmi.aCm()) != null) {
            aCm.setImageBitmap(null);
        }
    }

    public WriteData axK() {
        return this.dbx;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dmi != null && this.dmi.aCi() != null && this.dmi.aCi().isShowing()) {
                com.baidu.adp.lib.g.j.a(this.dmi.aCi(), getPageContext().getPageActivity());
                return true;
            }
            aBX();
            if (this.dml) {
                setResult(-1);
            } else {
                setResult(0);
            }
            com.baidu.tbadk.core.c.b.b(getPageContext().getPageActivity(), 200, false);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dmi != null) {
            this.dmi.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(i.g.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.dmi = new o(this);
        this.dmi.K(this.dmu);
        this.dmi.L(this.dmv);
        this.dmi.a(this.dmx);
        this.dmi.M(this.dmw);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private Activity mActivity;

        public a(Activity activity) {
            this.mActivity = null;
            this.mActivity = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mActivity != null) {
                WriteShareActivity.this.setResult(0);
                com.baidu.tbadk.core.c.b.b(this.mActivity, 200, false);
                this.mActivity.finish();
            }
        }
    }

    public void lQ(int i) {
        com.baidu.adp.lib.util.k.c(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.arW = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.arW.a(this.dms);
        this.arW.a(this.dmr);
        this.dmj = new com.baidu.tieba.write.shareSDK.a(this, new e(this));
        this.cpX = new f(this);
        this.dbx = new WriteData();
        this.dbx.setType(3);
        if (bundle != null) {
            this.dbx.setForumName(bundle.getString("forum_name"));
            this.dbx.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.dbx.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.dbx.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.dbx.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.dbx.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.dbx.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.dbx.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.dbx.setForumName(this.dmd);
            this.dbx.setShareSummaryTitle(this.mShareTitle);
            this.dbx.setShareSummaryContent(this.mShareContent);
            this.dbx.setShareApiKey(this.cWA);
            this.dbx.setShareAppName(this.bPh);
            this.dbx.setShareSignKey(this.dme);
            this.dbx.setShareReferUrl(this.dmb);
            boolean cU = com.baidu.tbadk.core.util.n.cU(this.dmc);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || cU) {
                this.arW.c(this.mShareLocalImageData, this.dmc);
                this.dbx.setShareLocalImageUri(this.dmc);
                this.dbx.setShareLocalImageData(this.mShareLocalImageData);
                this.arW.JE();
                this.dbx.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.dbx.setShareSummaryImg(this.dmc);
                this.dbx.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.dbx.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.dbx.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.dbx.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.dbx.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.dbx.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.dbx.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.dbx.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.dbx.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.dbx.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.dbx.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.dbx.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.dbx.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.dbx.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.dbx.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.dbx.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.dbx.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.dbx.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.dmi != null && this.dmi.amO() != null && (editable = this.dmi.amO().getEditableText().toString()) != null) {
            this.dmi.amO().setText(TbFaceManager.Cb().G(getPageContext().getContext(), editable));
            this.dmi.amO().setSelection(this.dmi.amO().getText().length());
        }
    }

    public void lR(int i) {
        this.dmh = i;
    }

    public int aBZ() {
        return this.dmh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCa() {
        aBX();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.dmh != this.mPrefixData.getPrefixs().size() - 1) {
            this.dbx.setTitle(String.valueOf(this.dmi.aCl().getText().toString()) + this.dmi.aCh().getText().toString());
        } else {
            this.dbx.setTitle(this.dmi.aCh().getText().toString());
        }
        this.dbx.setContent(this.dmi.amO().getText().toString());
        this.arW.c(this.dbx);
        this.dbx.setVcode(null);
        this.arW.axK().setVoice(null);
        this.arW.axK().setVoiceDuringTime(-1);
        if (this.arW.axL()) {
            showLoadingDialog(getPageContext().getString(i.h.sending), this.cpX);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.dmk = false;
            if (i2 == -1) {
                aBV();
                if (this.dmm != null) {
                    this.dml = true;
                    this.dmm.aCp();
                }
                setResult(-1);
                return;
            }
            aBW();
            if (this.dmn != null) {
                this.dml = false;
                this.dmn.aCp();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.dmd = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.dbx.setForumName(this.dmd);
                    aBU();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                aBT();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.dmi.aCh());
        HidenSoftKeyPad(this.mInputManager, this.dmi.amO());
        super.onPause();
    }

    public void aCb() {
        HidenSoftKeyPad(this.mInputManager, this.dmi.aCh());
        HidenSoftKeyPad(this.mInputManager, this.dmi.amO());
    }
}
