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
    private com.baidu.tieba.tbadkCore.writeModel.a avv;
    private String eIP;
    private String eIQ;
    private String eIR;
    private String eIS;
    private PackageManager eIT;
    private PackageInfo eIU;
    private int eIV;
    private o eIW;
    com.baidu.tieba.write.shareSDK.a eIX;
    private com.baidu.tieba.write.view.e eJa;
    private com.baidu.tieba.write.view.e eJb;
    private String emv;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData esv = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener dtc = null;
    private boolean eIY = false;
    private boolean eIZ = false;
    private e.b eJc = new c(this);
    private e.b eJd = new g(this);
    private e.b eJe = new h(this);
    private final a.b eJf = new i(this);
    private final a.c eJg = new j(this);
    private DialogInterface.OnKeyListener eJh = new k(this);
    private View.OnClickListener eJi = new l(this);
    private View.OnClickListener eJj = new m(this);
    private View.OnClickListener eJk = new n(this);
    private final View.OnFocusChangeListener eJl = new d(this);

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
        this.eIT = getPageContext().getPageActivity().getPackageManager();
        aZI();
        boolean aZJ = aZJ();
        initData(bundle);
        pU();
        if (!aZJ) {
            if (TextUtils.isEmpty(this.emv)) {
                qw(t.j.share_parameter_invalid_tip);
            } else {
                qw(t.j.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            aZL();
        } else {
            aZK();
        }
        TiebaStatic.log("share4sdk");
    }

    private void aZI() {
        this.packageName = getCallingPackage();
        if (this.eIT != null && this.packageName != null) {
            try {
                this.eIU = this.eIT.getPackageInfo(this.packageName, 64);
                if (this.eIU != null) {
                    if (this.eIU.applicationInfo != null && this.eIU.applicationInfo.loadLabel(this.eIT) != null) {
                        this.mAppName = this.eIU.applicationInfo.loadLabel(this.eIT).toString();
                    }
                    if (this.eIU.signatures != null && this.eIU.signatures.length > 0 && this.eIU.signatures[0] != null) {
                        this.eIS = ba.v(this.eIU.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.eIS = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.eIP = extras.getString("ShareUrl");
            this.eIQ = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.eIR = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.eIS)) {
                this.eIS = extras.getString("appSign");
            }
            this.emv = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean aZJ() {
        return (TextUtils.isEmpty(this.emv) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.eIQ) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void aZK() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
    }

    private void aZL() {
        if (TextUtils.isEmpty(this.eIR)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            aZM();
        }
    }

    private void aZM() {
        this.eIW.aZU();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.eIX.oR(this.esv.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZN() {
        if (this.eJa == null) {
            this.eJa = new com.baidu.tieba.write.view.e(getActivity());
            this.eJa.jq(false);
            this.eJa.qz(t.f.icon_send_ok);
            this.eJa.qC(t.j.share_alert_success);
            this.eJa.a(t.j.share_stay_in_tieba, this.eJc);
            this.eJa.b(t.j.back, this.eJe);
            this.eJa.a(this.eJh);
            this.eJa.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZO() {
        if (this.eJb == null) {
            this.eJb = new com.baidu.tieba.write.view.e(getActivity());
            this.eJb.qz(t.f.icon_send_error);
            this.eJb.qA(t.f.btn_w_square);
            this.eJb.qB(t.d.dialog_bdalert_title);
            this.eJb.qC(t.j.share_alert_fail);
            this.eJb.a(t.j.share_keep_sending, this.eJd);
            this.eJb.b(t.j.back, this.eJe);
            this.eJb.a(this.eJh);
            this.eJb.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aZP() {
        if (this.avv != null) {
            this.avv.cancelLoadData();
        }
    }

    protected void aZQ() {
        if (this.avv != null) {
            this.avv.aUI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        aZP();
        aZQ();
        JM();
        super.onDestroy();
    }

    private void JM() {
        ShareSDKImageView bae;
        if (this.eIW != null && (bae = this.eIW.bae()) != null) {
            bae.setImageBitmap(null);
        }
    }

    public WriteData aUF() {
        return this.esv;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.eIW != null && this.eIW.baa() != null && this.eIW.baa().isShowing()) {
                com.baidu.adp.lib.h.j.a(this.eIW.baa(), getPageContext().getPageActivity());
                return true;
            }
            aZP();
            if (this.eIZ) {
                setResult(-1);
            } else {
                setResult(0);
            }
            com.baidu.tbadk.core.d.b.b(getPageContext().getPageActivity(), 200, false);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eIW != null) {
            this.eIW.onChangeSkinType(i);
        }
    }

    private void pU() {
        setContentView(t.h.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.eIW = new o(this);
        this.eIW.V(this.eJi);
        this.eIW.W(this.eJj);
        this.eIW.a(this.eJl);
        this.eIW.X(this.eJk);
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
                com.baidu.tbadk.core.d.b.b(this.mActivity, 200, false);
                this.mActivity.finish();
            }
        }
    }

    public void qw(int i) {
        com.baidu.adp.lib.util.k.b(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.avv = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.avv.a(this.eJg);
        this.avv.a(this.eJf);
        this.eIX = new com.baidu.tieba.write.shareSDK.a(this, new e(this));
        this.dtc = new f(this);
        this.esv = new WriteData();
        this.esv.setType(3);
        if (bundle != null) {
            this.esv.setForumName(bundle.getString("forum_name"));
            this.esv.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.esv.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.esv.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.esv.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.esv.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.esv.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.esv.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.esv.setForumName(this.eIR);
            this.esv.setShareSummaryTitle(this.mShareTitle);
            this.esv.setShareSummaryContent(this.mShareContent);
            this.esv.setShareApiKey(this.emv);
            this.esv.setShareAppName(this.mAppName);
            this.esv.setShareSignKey(this.eIS);
            this.esv.setShareReferUrl(this.eIP);
            boolean dg = com.baidu.tbadk.core.util.m.dg(this.eIQ);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || dg) {
                this.avv.d(this.mShareLocalImageData, this.eIQ);
                this.esv.setShareLocalImageUri(this.eIQ);
                this.esv.setShareLocalImageData(this.mShareLocalImageData);
                this.avv.Po();
                this.esv.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.esv.setShareSummaryImg(this.eIQ);
                this.esv.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.esv.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.esv.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.esv.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.esv.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.esv.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.esv.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.esv.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.esv.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.esv.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.esv.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.esv.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.esv.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.esv.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.esv.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.esv.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.esv.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.esv.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.eIW != null && this.eIW.aII() != null && (editable = this.eIW.aII().getEditableText().toString()) != null) {
            this.eIW.aII().setText(TbFaceManager.EN().x(getPageContext().getContext(), editable));
            this.eIW.aII().setSelection(this.eIW.aII().getText().length());
        }
    }

    public void qx(int i) {
        this.eIV = i;
    }

    public int aZR() {
        return this.eIV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZS() {
        aZP();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.eIV != this.mPrefixData.getPrefixs().size() - 1) {
            this.esv.setTitle(String.valueOf(this.eIW.bad().getText().toString()) + this.eIW.aZZ().getText().toString());
        } else {
            this.esv.setTitle(this.eIW.aZZ().getText().toString());
        }
        this.esv.setContent(this.eIW.aII().getText().toString());
        this.avv.d(this.esv);
        this.esv.setVcode(null);
        this.avv.aUF().setVoice(null);
        this.avv.aUF().setVoiceDuringTime(-1);
        if (this.avv.aUG()) {
            showLoadingDialog(getPageContext().getString(t.j.sending), this.dtc);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.eIY = false;
            if (i2 == -1) {
                aZN();
                if (this.eJa != null) {
                    this.eIZ = true;
                    this.eJa.bas();
                }
                setResult(-1);
                return;
            }
            aZO();
            if (this.eJb != null) {
                this.eIZ = false;
                this.eJb.bas();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.eIR = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.esv.setForumName(this.eIR);
                    aZM();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                aZL();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.eIW.aZZ());
        HidenSoftKeyPad(this.mInputManager, this.eIW.aII());
        super.onPause();
    }

    public void aZT() {
        HidenSoftKeyPad(this.mInputManager, this.eIW.aZZ());
        HidenSoftKeyPad(this.mInputManager, this.eIW.aII());
    }
}
