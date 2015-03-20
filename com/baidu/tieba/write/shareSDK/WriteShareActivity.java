package com.baidu.tieba.write.shareSDK;

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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
/* loaded from: classes.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private com.baidu.tieba.tbadkCore.writeModel.a aHC;
    private String ccI;
    private String ccJ;
    private String ccK;
    private String ccL;
    private String ccM;
    private PackageManager ccN;
    private PackageInfo ccO;
    private com.baidu.tieba.write.view.f cvC;
    private com.baidu.tieba.write.view.f cvD;
    private int cvx;
    private q cvy;
    a cvz;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData cpU = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener ccA = null;
    private boolean cvA = false;
    private boolean cvB = false;
    private com.baidu.tieba.write.view.i cvE = new d(this);
    private com.baidu.tieba.write.view.i cvF = new h(this);
    private com.baidu.tieba.write.view.i cvG = new i(this);
    private final com.baidu.tieba.tbadkCore.writeModel.c cvH = new j(this);
    private final com.baidu.tieba.tbadkCore.writeModel.d aHG = new k(this);
    private DialogInterface.OnKeyListener cvI = new l(this);
    private View.OnClickListener cvJ = new m(this);
    private View.OnClickListener cvK = new n(this);
    private View.OnClickListener cvL = new o(this);
    private final View.OnFocusChangeListener cvM = new e(this);

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
        this.ccN = getPageContext().getPageActivity().getPackageManager();
        aib();
        boolean aqo = aqo();
        initData(bundle);
        initUI();
        if (!aqo) {
            if (TextUtils.isEmpty(this.ccL)) {
                iU(com.baidu.tieba.y.share_parameter_invalid_tip);
            } else {
                iU(com.baidu.tieba.y.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            aid();
        } else {
            EB();
        }
        com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "share4sdk");
    }

    private void aib() {
        this.packageName = getCallingPackage();
        if (this.ccN != null && this.packageName != null) {
            try {
                this.ccO = this.ccN.getPackageInfo(this.packageName, 64);
                if (this.ccO != null) {
                    if (this.ccO.applicationInfo != null && this.ccO.applicationInfo.loadLabel(this.ccN) != null) {
                        this.mAppName = this.ccO.applicationInfo.loadLabel(this.ccN).toString();
                    }
                    if (this.ccO.signatures != null && this.ccO.signatures.length > 0 && this.ccO.signatures[0] != null) {
                        this.ccM = bf.y(this.ccO.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.ccM = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.ccI = extras.getString("ShareUrl");
            this.ccJ = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.ccK = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.ccM)) {
                this.ccM = extras.getString("appSign");
            }
            this.ccL = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean aqo() {
        return (TextUtils.isEmpty(this.ccL) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.ccJ) && this.mShareLocalImageData == null && TextUtils.isEmpty(this.mShareTitle))) ? false : true;
    }

    private void EB() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
    }

    private void aid() {
        if (TextUtils.isEmpty(this.ccK)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            aqp();
        }
    }

    private void aqp() {
        this.cvy.aqx();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.cvz.jf(this.cpU.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqq() {
        if (this.cvC == null) {
            this.cvC = new com.baidu.tieba.write.view.f(getActivity());
            this.cvC.fh(false);
            this.cvC.iX(com.baidu.tieba.u.icon_send_ok);
            this.cvC.ja(com.baidu.tieba.y.share_alert_success);
            this.cvC.a(com.baidu.tieba.y.share_stay_in_tieba, this.cvE);
            this.cvC.b(com.baidu.tieba.y.back, this.cvG);
            this.cvC.a(this.cvI);
            this.cvC.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqr() {
        if (this.cvD == null) {
            this.cvD = new com.baidu.tieba.write.view.f(getActivity());
            this.cvD.iX(com.baidu.tieba.u.icon_send_error);
            this.cvD.iY(com.baidu.tieba.u.btn_w_square);
            this.cvD.iZ(com.baidu.tieba.s.dialog_bdalert_title);
            this.cvD.ja(com.baidu.tieba.y.share_alert_fail);
            this.cvD.a(com.baidu.tieba.y.share_keep_sending, this.cvF);
            this.cvD.b(com.baidu.tieba.y.back, this.cvG);
            this.cvD.a(this.cvI);
            this.cvD.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqs() {
        if (this.aHC != null) {
            this.aHC.cancelLoadData();
        }
    }

    protected void aqt() {
        if (this.aHC != null) {
            this.aHC.anB();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        aqs();
        aqt();
        DV();
        super.onDestroy();
    }

    private void DV() {
        ShareSDKImageView aqI;
        if (this.cvy != null && (aqI = this.cvy.aqI()) != null) {
            aqI.setImageBitmap(null);
        }
    }

    public WriteData IM() {
        return this.cpU;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cvy != null && this.cvy.aqE() != null && this.cvy.aqE().isShowing()) {
                com.baidu.adp.lib.g.k.a(this.cvy.aqE(), getPageContext().getPageActivity());
                return true;
            }
            aqs();
            if (this.cvB) {
                setResult(-1);
            } else {
                setResult(0);
            }
            com.baidu.tbadk.core.c.b.a(getPageContext().getPageActivity(), 200, false);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cvy != null) {
            this.cvy.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(com.baidu.tieba.w.write_share_activity);
        addGlobalLayoutListener();
        this.cvy = new q(this);
        this.cvy.C(this.cvJ);
        this.cvy.D(this.cvK);
        this.cvy.a(this.cvM);
        this.cvy.E(this.cvL);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    public void iU(int i) {
        com.baidu.adp.lib.util.n.c(getPageContext().getContext(), i);
        new Handler().postDelayed(new p(this, getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.aHC = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aHC.a(this.aHG);
        this.aHC.a(this.cvH);
        this.cvz = new a(this, new f(this));
        this.ccA = new g(this);
        this.cpU = new WriteData();
        this.cpU.setType(3);
        if (bundle != null) {
            this.cpU.setForumName(bundle.getString("forum_name"));
            this.cpU.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.cpU.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.cpU.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.cpU.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.cpU.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.cpU.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.cpU.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.cpU.setForumName(this.ccK);
            this.cpU.setShareSummaryTitle(this.mShareTitle);
            this.cpU.setShareSummaryContent(this.mShareContent);
            this.cpU.setShareApiKey(this.ccL);
            this.cpU.setShareAppName(this.mAppName);
            this.cpU.setShareSignKey(this.ccM);
            this.cpU.setShareReferUrl(this.ccI);
            boolean cu = com.baidu.tbadk.core.util.o.cu(this.ccJ);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || cu) {
                this.aHC.c(this.mShareLocalImageData, this.ccJ);
                this.cpU.setShareLocalImageUri(this.ccJ);
                this.cpU.setShareLocalImageData(this.mShareLocalImageData);
                this.aHC.Ie();
                this.cpU.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.cpU.setShareSummaryImg(this.ccJ);
                this.cpU.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.cpU.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.cpU.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.cpU.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.cpU.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.cpU.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.cpU.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.cpU.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.cpU.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.cpU.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.cpU.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.cpU.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.cpU.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.cpU.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.cpU.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.cpU.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.cpU.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.cpU.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.cvy != null && this.cvy.aqD() != null && (editable = this.cvy.aqD().getEditableText().toString()) != null) {
            this.cvy.aqD().setText(TbFaceManager.zr().E(getPageContext().getContext(), editable));
            this.cvy.aqD().setSelection(this.cvy.aqD().getText().length());
        }
    }

    public void iV(int i) {
        this.cvx = i;
    }

    public int aqu() {
        return this.cvx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqv() {
        aqs();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.cvx != this.mPrefixData.getPrefixs().size() - 1) {
            this.cpU.setTitle(String.valueOf(this.cvy.aqH().getText().toString()) + this.cvy.aqC().getText().toString());
        } else {
            this.cpU.setTitle(this.cvy.aqC().getText().toString());
        }
        this.cpU.setContent(this.cvy.aqD().getText().toString());
        this.aHC.c(this.cpU);
        this.cpU.setVcode(null);
        this.aHC.IM().setVoice(null);
        this.aHC.IM().setVoiceDuringTime(-1);
        if (this.aHC.anA()) {
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.y.sending), this.ccA);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.cvA = false;
            if (i2 == -1) {
                aqq();
                if (this.cvC != null) {
                    this.cvB = true;
                    this.cvC.aqK();
                }
                setResult(-1);
                return;
            }
            aqr();
            if (this.cvD != null) {
                this.cvB = false;
                this.cvD.aqK();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.ccK = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.cpU.setForumName(this.ccK);
                    aqp();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                aid();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.cvy.aqC());
        HidenSoftKeyPad(this.mInputManager, this.cvy.aqD());
        super.onPause();
    }

    public void aqw() {
        HidenSoftKeyPad(this.mInputManager, this.cvy.aqC());
        HidenSoftKeyPad(this.mInputManager, this.cvy.aqD());
    }
}
