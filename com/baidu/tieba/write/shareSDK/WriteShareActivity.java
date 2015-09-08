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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private com.baidu.tieba.tbadkCore.writeModel.a aty;
    private String cHN;
    private String cHO;
    private String cHP;
    private String cHQ;
    private String cHR;
    private String cHS;
    private PackageManager cHT;
    private PackageInfo cHU;
    private int daF;
    private o daG;
    com.baidu.tieba.write.shareSDK.a daH;
    private com.baidu.tieba.write.view.e daK;
    private com.baidu.tieba.write.view.e daL;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData cTs = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener ckj = null;
    private boolean daI = false;
    private boolean daJ = false;
    private e.b daM = new c(this);
    private e.b daN = new g(this);
    private e.b daO = new h(this);
    private final a.b daP = new i(this);
    private final a.c daQ = new j(this);
    private DialogInterface.OnKeyListener daR = new k(this);
    private View.OnClickListener daS = new l(this);
    private View.OnClickListener daT = new m(this);
    private View.OnClickListener daU = new n(this);
    private final View.OnFocusChangeListener daV = new d(this);

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
        this.cHT = getPageContext().getPageActivity().getPackageManager();
        aqM();
        boolean ayD = ayD();
        initData(bundle);
        initUI();
        if (!ayD) {
            if (TextUtils.isEmpty(this.cHR)) {
                kZ(i.h.share_parameter_invalid_tip);
            } else {
                kZ(i.h.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            aqO();
        } else {
            ayE();
        }
        TiebaStatic.log("share4sdk");
    }

    private void aqM() {
        this.packageName = getCallingPackage();
        if (this.cHT != null && this.packageName != null) {
            try {
                this.cHU = this.cHT.getPackageInfo(this.packageName, 64);
                if (this.cHU != null) {
                    if (this.cHU.applicationInfo != null && this.cHU.applicationInfo.loadLabel(this.cHT) != null) {
                        this.cHQ = this.cHU.applicationInfo.loadLabel(this.cHT).toString();
                    }
                    if (this.cHU.signatures != null && this.cHU.signatures.length > 0 && this.cHU.signatures[0] != null) {
                        this.cHS = as.P(this.cHU.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.cHQ = null;
                this.cHS = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.cHN = extras.getString("ShareUrl");
            this.cHO = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.cHP = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.cHQ)) {
                this.cHQ = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.cHS)) {
                this.cHS = extras.getString("appSign");
            }
            this.cHR = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean ayD() {
        return (TextUtils.isEmpty(this.cHR) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.cHO) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void ayE() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
    }

    private void aqO() {
        if (TextUtils.isEmpty(this.cHP)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            ayF();
        }
    }

    private void ayF() {
        this.daG.ayN();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.daH.lI(this.cTs.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayG() {
        if (this.daK == null) {
            this.daK = new com.baidu.tieba.write.view.e(getActivity());
            this.daK.gG(false);
            this.daK.lc(i.e.icon_send_ok);
            this.daK.lf(i.h.share_alert_success);
            this.daK.a(i.h.share_stay_in_tieba, this.daM);
            this.daK.b(i.h.back, this.daO);
            this.daK.a(this.daR);
            this.daK.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayH() {
        if (this.daL == null) {
            this.daL = new com.baidu.tieba.write.view.e(getActivity());
            this.daL.lc(i.e.icon_send_error);
            this.daL.ld(i.e.btn_w_square);
            this.daL.le(i.c.dialog_bdalert_title);
            this.daL.lf(i.h.share_alert_fail);
            this.daL.a(i.h.share_keep_sending, this.daN);
            this.daL.b(i.h.back, this.daO);
            this.daL.a(this.daR);
            this.daL.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ayI() {
        if (this.aty != null) {
            this.aty.cancelLoadData();
        }
    }

    protected void ayJ() {
        if (this.aty != null) {
            this.aty.avt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        ayI();
        ayJ();
        FP();
        super.onDestroy();
    }

    private void FP() {
        ShareSDKImageView ayX;
        if (this.daG != null && (ayX = this.daG.ayX()) != null) {
            ayX.setImageBitmap(null);
        }
    }

    public WriteData avr() {
        return this.cTs;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.daG != null && this.daG.ayT() != null && this.daG.ayT().isShowing()) {
                com.baidu.adp.lib.g.j.a(this.daG.ayT(), getPageContext().getPageActivity());
                return true;
            }
            ayI();
            if (this.daJ) {
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
        if (this.daG != null) {
            this.daG.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(i.g.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.daG = new o(this);
        this.daG.J(this.daS);
        this.daG.K(this.daT);
        this.daG.a(this.daV);
        this.daG.L(this.daU);
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
                com.baidu.tbadk.core.c.b.a(this.mActivity, 200, false);
                this.mActivity.finish();
            }
        }
    }

    public void kZ(int i) {
        com.baidu.adp.lib.util.k.c(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.aty = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aty.a(this.daQ);
        this.aty.a(this.daP);
        this.daH = new com.baidu.tieba.write.shareSDK.a(this, new e(this));
        this.ckj = new f(this);
        this.cTs = new WriteData();
        this.cTs.setType(3);
        if (bundle != null) {
            this.cTs.setForumName(bundle.getString("forum_name"));
            this.cTs.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.cTs.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.cTs.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.cTs.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.cTs.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.cTs.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.cTs.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.cTs.setForumName(this.cHP);
            this.cTs.setShareSummaryTitle(this.mShareTitle);
            this.cTs.setShareSummaryContent(this.mShareContent);
            this.cTs.setShareApiKey(this.cHR);
            this.cTs.setShareAppName(this.cHQ);
            this.cTs.setShareSignKey(this.cHS);
            this.cTs.setShareReferUrl(this.cHN);
            boolean cR = com.baidu.tbadk.core.util.n.cR(this.cHO);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || cR) {
                this.aty.c(this.mShareLocalImageData, this.cHO);
                this.cTs.setShareLocalImageUri(this.cHO);
                this.cTs.setShareLocalImageData(this.mShareLocalImageData);
                this.aty.JN();
                this.cTs.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.cTs.setShareSummaryImg(this.cHO);
                this.cTs.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.cTs.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.cTs.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.cTs.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.cTs.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.cTs.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.cTs.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.cTs.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.cTs.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.cTs.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.cTs.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.cTs.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.cTs.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.cTs.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.cTs.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.cTs.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.cTs.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.cTs.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.daG != null && this.daG.akL() != null && (editable = this.daG.akL().getEditableText().toString()) != null) {
            this.daG.akL().setText(TbFaceManager.Cr().H(getPageContext().getContext(), editable));
            this.daG.akL().setSelection(this.daG.akL().getText().length());
        }
    }

    public void la(int i) {
        this.daF = i;
    }

    public int ayK() {
        return this.daF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayL() {
        ayI();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.daF != this.mPrefixData.getPrefixs().size() - 1) {
            this.cTs.setTitle(String.valueOf(this.daG.ayW().getText().toString()) + this.daG.ayS().getText().toString());
        } else {
            this.cTs.setTitle(this.daG.ayS().getText().toString());
        }
        this.cTs.setContent(this.daG.akL().getText().toString());
        this.aty.c(this.cTs);
        this.cTs.setVcode(null);
        this.aty.avr().setVoice(null);
        this.aty.avr().setVoiceDuringTime(-1);
        if (this.aty.avs()) {
            showLoadingDialog(getPageContext().getString(i.h.sending), this.ckj);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.daI = false;
            if (i2 == -1) {
                ayG();
                if (this.daK != null) {
                    this.daJ = true;
                    this.daK.aza();
                }
                setResult(-1);
                return;
            }
            ayH();
            if (this.daL != null) {
                this.daJ = false;
                this.daL.aza();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.cHP = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.cTs.setForumName(this.cHP);
                    ayF();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                aqO();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.daG.ayS());
        HidenSoftKeyPad(this.mInputManager, this.daG.akL());
        super.onPause();
    }

    public void ayM() {
        HidenSoftKeyPad(this.mInputManager, this.daG.ayS());
        HidenSoftKeyPad(this.mInputManager, this.daG.akL());
    }
}
