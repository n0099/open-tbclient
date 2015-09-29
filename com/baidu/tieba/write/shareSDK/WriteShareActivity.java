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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.view.ShareSDKImageView;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private com.baidu.tieba.tbadkCore.writeModel.a arV;
    private String bOW;
    private String cWb;
    private String dlB;
    private String dlC;
    private String dlD;
    private String dlE;
    private PackageManager dlF;
    private PackageInfo dlG;
    private int dlH;
    private o dlI;
    com.baidu.tieba.write.shareSDK.a dlJ;
    private com.baidu.tieba.write.view.e dlM;
    private com.baidu.tieba.write.view.e dlN;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData daX = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener cpM = null;
    private boolean dlK = false;
    private boolean dlL = false;
    private e.b dlO = new c(this);
    private e.b dlP = new g(this);
    private e.b dlQ = new h(this);
    private final a.b dlR = new i(this);
    private final a.c dlS = new j(this);
    private DialogInterface.OnKeyListener dlT = new k(this);
    private View.OnClickListener dlU = new l(this);
    private View.OnClickListener dlV = new m(this);
    private View.OnClickListener dlW = new n(this);
    private final View.OnFocusChangeListener dlX = new d(this);

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
        this.dlF = getPageContext().getPageActivity().getPackageManager();
        aBK();
        boolean aBL = aBL();
        initData(bundle);
        initUI();
        if (!aBL) {
            if (TextUtils.isEmpty(this.cWb)) {
                lO(i.h.share_parameter_invalid_tip);
            } else {
                lO(i.h.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            aBN();
        } else {
            aBM();
        }
        TiebaStatic.log("share4sdk");
    }

    private void aBK() {
        this.packageName = getCallingPackage();
        if (this.dlF != null && this.packageName != null) {
            try {
                this.dlG = this.dlF.getPackageInfo(this.packageName, 64);
                if (this.dlG != null) {
                    if (this.dlG.applicationInfo != null && this.dlG.applicationInfo.loadLabel(this.dlF) != null) {
                        this.bOW = this.dlG.applicationInfo.loadLabel(this.dlF).toString();
                    }
                    if (this.dlG.signatures != null && this.dlG.signatures.length > 0 && this.dlG.signatures[0] != null) {
                        this.dlE = at.P(this.dlG.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.bOW = null;
                this.dlE = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.dlB = extras.getString("ShareUrl");
            this.dlC = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.dlD = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.bOW)) {
                this.bOW = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.dlE)) {
                this.dlE = extras.getString("appSign");
            }
            this.cWb = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean aBL() {
        return (TextUtils.isEmpty(this.cWb) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.dlC) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void aBM() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
    }

    private void aBN() {
        if (TextUtils.isEmpty(this.dlD)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            aBO();
        }
    }

    private void aBO() {
        this.dlI.aBW();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.dlJ.mo(this.daX.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBP() {
        if (this.dlM == null) {
            this.dlM = new com.baidu.tieba.write.view.e(getActivity());
            this.dlM.gV(false);
            this.dlM.lR(i.e.icon_send_ok);
            this.dlM.lU(i.h.share_alert_success);
            this.dlM.a(i.h.share_stay_in_tieba, this.dlO);
            this.dlM.b(i.h.back, this.dlQ);
            this.dlM.a(this.dlT);
            this.dlM.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBQ() {
        if (this.dlN == null) {
            this.dlN = new com.baidu.tieba.write.view.e(getActivity());
            this.dlN.lR(i.e.icon_send_error);
            this.dlN.lS(i.e.btn_w_square);
            this.dlN.lT(i.c.dialog_bdalert_title);
            this.dlN.lU(i.h.share_alert_fail);
            this.dlN.a(i.h.share_keep_sending, this.dlP);
            this.dlN.b(i.h.back, this.dlQ);
            this.dlN.a(this.dlT);
            this.dlN.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aBR() {
        if (this.arV != null) {
            this.arV.cancelLoadData();
        }
    }

    protected void aBS() {
        if (this.arV != null) {
            this.arV.axH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        aBR();
        aBS();
        FJ();
        super.onDestroy();
    }

    private void FJ() {
        ShareSDKImageView aCg;
        if (this.dlI != null && (aCg = this.dlI.aCg()) != null) {
            aCg.setImageBitmap(null);
        }
    }

    public WriteData axE() {
        return this.daX;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dlI != null && this.dlI.aCc() != null && this.dlI.aCc().isShowing()) {
                com.baidu.adp.lib.g.j.a(this.dlI.aCc(), getPageContext().getPageActivity());
                return true;
            }
            aBR();
            if (this.dlL) {
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
        if (this.dlI != null) {
            this.dlI.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(i.g.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.dlI = new o(this);
        this.dlI.K(this.dlU);
        this.dlI.L(this.dlV);
        this.dlI.a(this.dlX);
        this.dlI.M(this.dlW);
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

    public void lO(int i) {
        com.baidu.adp.lib.util.k.c(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.arV = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.arV.a(this.dlS);
        this.arV.a(this.dlR);
        this.dlJ = new com.baidu.tieba.write.shareSDK.a(this, new e(this));
        this.cpM = new f(this);
        this.daX = new WriteData();
        this.daX.setType(3);
        if (bundle != null) {
            this.daX.setForumName(bundle.getString("forum_name"));
            this.daX.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.daX.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.daX.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.daX.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.daX.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.daX.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.daX.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.daX.setForumName(this.dlD);
            this.daX.setShareSummaryTitle(this.mShareTitle);
            this.daX.setShareSummaryContent(this.mShareContent);
            this.daX.setShareApiKey(this.cWb);
            this.daX.setShareAppName(this.bOW);
            this.daX.setShareSignKey(this.dlE);
            this.daX.setShareReferUrl(this.dlB);
            boolean cT = com.baidu.tbadk.core.util.n.cT(this.dlC);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || cT) {
                this.arV.c(this.mShareLocalImageData, this.dlC);
                this.daX.setShareLocalImageUri(this.dlC);
                this.daX.setShareLocalImageData(this.mShareLocalImageData);
                this.arV.JI();
                this.daX.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.daX.setShareSummaryImg(this.dlC);
                this.daX.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.daX.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.daX.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.daX.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.daX.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.daX.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.daX.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.daX.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.daX.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.daX.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.daX.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.daX.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.daX.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.daX.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.daX.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.daX.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.daX.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.daX.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.dlI != null && this.dlI.amS() != null && (editable = this.dlI.amS().getEditableText().toString()) != null) {
            this.dlI.amS().setText(TbFaceManager.Ce().G(getPageContext().getContext(), editable));
            this.dlI.amS().setSelection(this.dlI.amS().getText().length());
        }
    }

    public void lP(int i) {
        this.dlH = i;
    }

    public int aBT() {
        return this.dlH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBU() {
        aBR();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.dlH != this.mPrefixData.getPrefixs().size() - 1) {
            this.daX.setTitle(String.valueOf(this.dlI.aCf().getText().toString()) + this.dlI.aCb().getText().toString());
        } else {
            this.daX.setTitle(this.dlI.aCb().getText().toString());
        }
        this.daX.setContent(this.dlI.amS().getText().toString());
        this.arV.c(this.daX);
        this.daX.setVcode(null);
        this.arV.axE().setVoice(null);
        this.arV.axE().setVoiceDuringTime(-1);
        if (this.arV.axF()) {
            showLoadingDialog(getPageContext().getString(i.h.sending), this.cpM);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.dlK = false;
            if (i2 == -1) {
                aBP();
                if (this.dlM != null) {
                    this.dlL = true;
                    this.dlM.aCj();
                }
                setResult(-1);
                return;
            }
            aBQ();
            if (this.dlN != null) {
                this.dlL = false;
                this.dlN.aCj();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.dlD = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.daX.setForumName(this.dlD);
                    aBO();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                aBN();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.dlI.aCb());
        HidenSoftKeyPad(this.mInputManager, this.dlI.amS());
        super.onPause();
    }

    public void aBV() {
        HidenSoftKeyPad(this.mInputManager, this.dlI.aCb());
        HidenSoftKeyPad(this.mInputManager, this.dlI.amS());
    }
}
