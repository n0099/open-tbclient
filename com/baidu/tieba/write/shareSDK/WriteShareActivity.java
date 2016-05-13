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
    private String eZF;
    private String eZG;
    private String eZH;
    private String eZI;
    private PackageManager eZJ;
    private PackageInfo eZK;
    private int eZL;
    private o eZM;
    com.baidu.tieba.write.shareSDK.a eZN;
    private com.baidu.tieba.write.view.e eZQ;
    private com.baidu.tieba.write.view.e eZR;
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
    private boolean eZO = false;
    private boolean eZP = false;
    private e.b eZS = new c(this);
    private e.b eZT = new g(this);
    private e.b eZU = new h(this);
    private final a.b eZV = new i(this);
    private final a.c eZW = new j(this);
    private DialogInterface.OnKeyListener eZX = new k(this);
    private View.OnClickListener eZY = new l(this);
    private View.OnClickListener eZZ = new m(this);
    private View.OnClickListener faa = new n(this);
    private final View.OnFocusChangeListener fab = new d(this);

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
        this.eZJ = getPageContext().getPageActivity().getPackageManager();
        bcb();
        boolean bcc = bcc();
        initData(bundle);
        nq();
        if (!bcc) {
            if (TextUtils.isEmpty(this.epK)) {
                qR(t.j.share_parameter_invalid_tip);
            } else {
                qR(t.j.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            bce();
        } else {
            bcd();
        }
        TiebaStatic.log("share4sdk");
    }

    private void bcb() {
        this.packageName = getCallingPackage();
        if (this.eZJ != null && this.packageName != null) {
            try {
                this.eZK = this.eZJ.getPackageInfo(this.packageName, 64);
                if (this.eZK != null) {
                    if (this.eZK.applicationInfo != null && this.eZK.applicationInfo.loadLabel(this.eZJ) != null) {
                        this.mAppName = this.eZK.applicationInfo.loadLabel(this.eZJ).toString();
                    }
                    if (this.eZK.signatures != null && this.eZK.signatures.length > 0 && this.eZK.signatures[0] != null) {
                        this.eZI = ba.u(this.eZK.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.eZI = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.eZF = extras.getString("ShareUrl");
            this.eZG = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.eZH = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.eZI)) {
                this.eZI = extras.getString("appSign");
            }
            this.epK = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean bcc() {
        return (TextUtils.isEmpty(this.epK) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.eZG) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void bcd() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
    }

    private void bce() {
        if (TextUtils.isEmpty(this.eZH)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            bcf();
        }
    }

    private void bcf() {
        this.eZM.bcn();
        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
        this.eZN.pf(this.evE.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcg() {
        if (this.eZQ == null) {
            this.eZQ = new com.baidu.tieba.write.view.e(getActivity());
            this.eZQ.kw(false);
            this.eZQ.qT(t.f.icon_send_ok);
            this.eZQ.qW(t.j.share_alert_success);
            this.eZQ.a(t.j.share_stay_in_tieba, this.eZS);
            this.eZQ.b(t.j.back, this.eZU);
            this.eZQ.a(this.eZX);
            this.eZQ.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bch() {
        if (this.eZR == null) {
            this.eZR = new com.baidu.tieba.write.view.e(getActivity());
            this.eZR.qT(t.f.icon_send_error);
            this.eZR.qU(t.f.btn_w_square);
            this.eZR.qV(t.d.dialog_bdalert_title);
            this.eZR.qW(t.j.share_alert_fail);
            this.eZR.a(t.j.share_keep_sending, this.eZT);
            this.eZR.b(t.j.back, this.eZU);
            this.eZR.a(this.eZX);
            this.eZR.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bci() {
        if (this.aru != null) {
            this.aru.cancelLoadData();
        }
    }

    protected void bcj() {
        if (this.aru != null) {
            this.aru.aVj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bci();
        bcj();
        If();
        super.onDestroy();
    }

    private void If() {
        ShareSDKImageView bcx;
        if (this.eZM != null && (bcx = this.eZM.bcx()) != null) {
            bcx.setImageBitmap(null);
        }
    }

    public WriteData aVg() {
        return this.evE;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.eZM != null && this.eZM.bct() != null && this.eZM.bct().isShowing()) {
                com.baidu.adp.lib.h.j.a(this.eZM.bct(), getPageContext().getPageActivity());
                return true;
            }
            bci();
            if (this.eZP) {
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
        if (this.eZM != null) {
            this.eZM.onChangeSkinType(i);
        }
    }

    private void nq() {
        setContentView(t.h.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.eZM = new o(this);
        this.eZM.R(this.eZY);
        this.eZM.S(this.eZZ);
        this.eZM.a(this.fab);
        this.eZM.T(this.faa);
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

    public void qR(int i) {
        com.baidu.adp.lib.util.k.b(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.aru = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aru.a(this.eZW);
        this.aru.a(this.eZV);
        this.eZN = new com.baidu.tieba.write.shareSDK.a(this, new e(this));
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
            this.evE.setForumName(this.eZH);
            this.evE.setShareSummaryTitle(this.mShareTitle);
            this.evE.setShareSummaryContent(this.mShareContent);
            this.evE.setShareApiKey(this.epK);
            this.evE.setShareAppName(this.mAppName);
            this.evE.setShareSignKey(this.eZI);
            this.evE.setShareReferUrl(this.eZF);
            boolean de = com.baidu.tbadk.core.util.m.de(this.eZG);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || de) {
                this.aru.d(this.mShareLocalImageData, this.eZG);
                this.evE.setShareLocalImageUri(this.eZG);
                this.evE.setShareLocalImageData(this.mShareLocalImageData);
                this.aru.Ok();
                this.evE.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.evE.setShareSummaryImg(this.eZG);
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
        if (this.eZM != null && this.eZM.aIZ() != null && (editable = this.eZM.aIZ().getEditableText().toString()) != null) {
            this.eZM.aIZ().setText(TbFaceManager.CH().y(getPageContext().getContext(), editable));
            this.eZM.aIZ().setSelection(this.eZM.aIZ().getText().length());
        }
    }

    public void qS(int i) {
        this.eZL = i;
    }

    public int bck() {
        return this.eZL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcl() {
        bci();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.eZL != this.mPrefixData.getPrefixs().size() - 1) {
            this.evE.setTitle(String.valueOf(this.eZM.bcw().getText().toString()) + this.eZM.bcs().getText().toString());
        } else {
            this.evE.setTitle(this.eZM.bcs().getText().toString());
        }
        this.evE.setContent(this.eZM.aIZ().getText().toString());
        this.aru.d(this.evE);
        this.evE.setVcode(null);
        this.aru.aVg().setVoice(null);
        this.aru.aVg().setVoiceDuringTime(-1);
        if (this.aru.aVh()) {
            showLoadingDialog(getPageContext().getString(t.j.sending), this.dwy);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.eZO = false;
            if (i2 == -1) {
                bcg();
                if (this.eZQ != null) {
                    this.eZP = true;
                    this.eZQ.bcM();
                }
                setResult(-1);
                return;
            }
            bch();
            if (this.eZR != null) {
                this.eZP = false;
                this.eZR.bcM();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.eZH = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.evE.setForumName(this.eZH);
                    bcf();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                bce();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.eZM.bcs());
        HidenSoftKeyPad(this.mInputManager, this.eZM.aIZ());
        super.onPause();
    }

    public void bcm() {
        HidenSoftKeyPad(this.mInputManager, this.eZM.bcs());
        HidenSoftKeyPad(this.mInputManager, this.eZM.aIZ());
    }
}
