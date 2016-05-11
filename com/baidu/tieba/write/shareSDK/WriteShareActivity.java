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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.view.ShareSDKImageView;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private com.baidu.tieba.tbadkCore.writeModel.a aru;
    private String eZG;
    private String eZH;
    private String eZI;
    private String eZJ;
    private PackageManager eZK;
    private PackageInfo eZL;
    private int eZM;
    private o eZN;
    com.baidu.tieba.write.shareSDK.a eZO;
    private com.baidu.tieba.write.view.e eZR;
    private com.baidu.tieba.write.view.e eZS;
    private String epK;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData evE = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener dwy = null;
    private boolean eZP = false;
    private boolean eZQ = false;
    private e.b eZT = new c(this);
    private e.b eZU = new g(this);
    private e.b eZV = new h(this);
    private final a.b eZW = new i(this);
    private final a.c eZX = new j(this);
    private DialogInterface.OnKeyListener eZY = new k(this);
    private View.OnClickListener eZZ = new l(this);
    private View.OnClickListener faa = new m(this);
    private View.OnClickListener fab = new n(this);
    private final View.OnFocusChangeListener fac = new d(this);

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
        this.eZK = getPageContext().getPageActivity().getPackageManager();
        bbU();
        boolean bbV = bbV();
        initData(bundle);
        nq();
        if (!bbV) {
            if (TextUtils.isEmpty(this.epK)) {
                qS(t.j.share_parameter_invalid_tip);
            } else {
                qS(t.j.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            bbX();
        } else {
            bbW();
        }
        TiebaStatic.log("share4sdk");
    }

    private void bbU() {
        this.packageName = getCallingPackage();
        if (this.eZK != null && this.packageName != null) {
            try {
                this.eZL = this.eZK.getPackageInfo(this.packageName, 64);
                if (this.eZL != null) {
                    if (this.eZL.applicationInfo != null && this.eZL.applicationInfo.loadLabel(this.eZK) != null) {
                        this.mAppName = this.eZL.applicationInfo.loadLabel(this.eZK).toString();
                    }
                    if (this.eZL.signatures != null && this.eZL.signatures.length > 0 && this.eZL.signatures[0] != null) {
                        this.eZJ = ba.u(this.eZL.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.eZJ = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.eZG = extras.getString("ShareUrl");
            this.eZH = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.eZI = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.eZJ)) {
                this.eZJ = extras.getString("appSign");
            }
            this.epK = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean bbV() {
        return (TextUtils.isEmpty(this.epK) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.eZH) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void bbW() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
    }

    private void bbX() {
        if (TextUtils.isEmpty(this.eZI)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            bbY();
        }
    }

    private void bbY() {
        this.eZN.bcg();
        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
        this.eZO.pf(this.evE.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbZ() {
        if (this.eZR == null) {
            this.eZR = new com.baidu.tieba.write.view.e(getActivity());
            this.eZR.kw(false);
            this.eZR.qU(t.f.icon_send_ok);
            this.eZR.qX(t.j.share_alert_success);
            this.eZR.a(t.j.share_stay_in_tieba, this.eZT);
            this.eZR.b(t.j.back, this.eZV);
            this.eZR.a(this.eZY);
            this.eZR.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bca() {
        if (this.eZS == null) {
            this.eZS = new com.baidu.tieba.write.view.e(getActivity());
            this.eZS.qU(t.f.icon_send_error);
            this.eZS.qV(t.f.btn_w_square);
            this.eZS.qW(t.d.dialog_bdalert_title);
            this.eZS.qX(t.j.share_alert_fail);
            this.eZS.a(t.j.share_keep_sending, this.eZU);
            this.eZS.b(t.j.back, this.eZV);
            this.eZS.a(this.eZY);
            this.eZS.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bcb() {
        if (this.aru != null) {
            this.aru.cancelLoadData();
        }
    }

    protected void bcc() {
        if (this.aru != null) {
            this.aru.aVd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bcb();
        bcc();
        Id();
        super.onDestroy();
    }

    private void Id() {
        ShareSDKImageView bcq;
        if (this.eZN != null && (bcq = this.eZN.bcq()) != null) {
            bcq.setImageBitmap(null);
        }
    }

    public WriteData aVa() {
        return this.evE;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.eZN != null && this.eZN.bcm() != null && this.eZN.bcm().isShowing()) {
                com.baidu.adp.lib.h.j.a(this.eZN.bcm(), getPageContext().getPageActivity());
                return true;
            }
            bcb();
            if (this.eZQ) {
                setResult(-1);
            } else {
                setResult(0);
            }
            com.baidu.tbadk.core.e.b.b(getPageContext().getPageActivity(), 200, false);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eZN != null) {
            this.eZN.onChangeSkinType(i);
        }
    }

    private void nq() {
        setContentView(t.h.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.eZN = new o(this);
        this.eZN.R(this.eZZ);
        this.eZN.S(this.faa);
        this.eZN.a(this.fac);
        this.eZN.T(this.fab);
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
                com.baidu.tbadk.core.e.b.b(this.mActivity, 200, false);
                this.mActivity.finish();
            }
        }
    }

    public void qS(int i) {
        com.baidu.adp.lib.util.k.b(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.aru = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aru.a(this.eZX);
        this.aru.a(this.eZW);
        this.eZO = new com.baidu.tieba.write.shareSDK.a(this, new e(this));
        this.dwy = new f(this);
        this.evE = new WriteData();
        this.evE.setType(3);
        if (bundle != null) {
            this.evE.setForumName(bundle.getString("forum_name"));
            this.evE.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.evE.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.evE.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.evE.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.evE.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.evE.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.evE.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.evE.setForumName(this.eZI);
            this.evE.setShareSummaryTitle(this.mShareTitle);
            this.evE.setShareSummaryContent(this.mShareContent);
            this.evE.setShareApiKey(this.epK);
            this.evE.setShareAppName(this.mAppName);
            this.evE.setShareSignKey(this.eZJ);
            this.evE.setShareReferUrl(this.eZG);
            boolean de = com.baidu.tbadk.core.util.m.de(this.eZH);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || de) {
                this.aru.d(this.mShareLocalImageData, this.eZH);
                this.evE.setShareLocalImageUri(this.eZH);
                this.evE.setShareLocalImageData(this.mShareLocalImageData);
                this.aru.Oi();
                this.evE.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.evE.setShareSummaryImg(this.eZH);
                this.evE.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.evE.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.evE.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.evE.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.evE.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.evE.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.evE.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.evE.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.evE.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.evE.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.evE.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.evE.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.evE.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.evE.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.evE.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.evE.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.evE.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.evE.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.eZN != null && this.eZN.aIW() != null && (editable = this.eZN.aIW().getEditableText().toString()) != null) {
            this.eZN.aIW().setText(TbFaceManager.CG().y(getPageContext().getContext(), editable));
            this.eZN.aIW().setSelection(this.eZN.aIW().getText().length());
        }
    }

    public void qT(int i) {
        this.eZM = i;
    }

    public int bcd() {
        return this.eZM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bce() {
        bcb();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.eZM != this.mPrefixData.getPrefixs().size() - 1) {
            this.evE.setTitle(String.valueOf(this.eZN.bcp().getText().toString()) + this.eZN.bcl().getText().toString());
        } else {
            this.evE.setTitle(this.eZN.bcl().getText().toString());
        }
        this.evE.setContent(this.eZN.aIW().getText().toString());
        this.aru.d(this.evE);
        this.evE.setVcode(null);
        this.aru.aVa().setVoice(null);
        this.aru.aVa().setVoiceDuringTime(-1);
        if (this.aru.aVb()) {
            showLoadingDialog(getPageContext().getString(t.j.sending), this.dwy);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.eZP = false;
            if (i2 == -1) {
                bbZ();
                if (this.eZR != null) {
                    this.eZQ = true;
                    this.eZR.bcF();
                }
                setResult(-1);
                return;
            }
            bca();
            if (this.eZS != null) {
                this.eZQ = false;
                this.eZS.bcF();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.eZI = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.evE.setForumName(this.eZI);
                    bbY();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                bbX();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.eZN.bcl());
        HidenSoftKeyPad(this.mInputManager, this.eZN.aIW());
        super.onPause();
    }

    public void bcf() {
        HidenSoftKeyPad(this.mInputManager, this.eZN.bcl());
        HidenSoftKeyPad(this.mInputManager, this.eZN.aIW());
    }
}
