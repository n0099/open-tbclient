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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.view.ShareSDKImageView;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private com.baidu.tieba.tbadkCore.writeModel.a auV;
    private String dTV;
    private String eoT;
    private String eoU;
    private String eoV;
    private String eoW;
    private PackageManager eoX;
    private PackageInfo eoY;
    private int eoZ;
    private o epa;
    com.baidu.tieba.write.shareSDK.a epb;
    private com.baidu.tieba.write.view.e epe;
    private com.baidu.tieba.write.view.e epf;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData dZC = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener cYA = null;
    private boolean epc = false;
    private boolean epd = false;
    private e.b epg = new c(this);
    private e.b eph = new g(this);
    private e.b epi = new h(this);
    private final a.b epj = new i(this);
    private final a.c epk = new j(this);
    private DialogInterface.OnKeyListener epl = new k(this);
    private View.OnClickListener epm = new l(this);
    private View.OnClickListener epn = new m(this);
    private View.OnClickListener epo = new n(this);
    private final View.OnFocusChangeListener epp = new d(this);

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
        this.eoX = getPageContext().getPageActivity().getPackageManager();
        aTi();
        boolean aTj = aTj();
        initData(bundle);
        qD();
        if (!aTj) {
            if (TextUtils.isEmpty(this.dTV)) {
                pD(t.j.share_parameter_invalid_tip);
            } else {
                pD(t.j.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            aTl();
        } else {
            aTk();
        }
        TiebaStatic.log("share4sdk");
    }

    private void aTi() {
        this.packageName = getCallingPackage();
        if (this.eoX != null && this.packageName != null) {
            try {
                this.eoY = this.eoX.getPackageInfo(this.packageName, 64);
                if (this.eoY != null) {
                    if (this.eoY.applicationInfo != null && this.eoY.applicationInfo.loadLabel(this.eoX) != null) {
                        this.mAppName = this.eoY.applicationInfo.loadLabel(this.eoX).toString();
                    }
                    if (this.eoY.signatures != null && this.eoY.signatures.length > 0 && this.eoY.signatures[0] != null) {
                        this.eoW = ay.O(this.eoY.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.eoW = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.eoT = extras.getString("ShareUrl");
            this.eoU = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.eoV = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.eoW)) {
                this.eoW = extras.getString("appSign");
            }
            this.dTV = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean aTj() {
        return (TextUtils.isEmpty(this.dTV) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.eoU) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void aTk() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
    }

    private void aTl() {
        if (TextUtils.isEmpty(this.eoV)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            aTm();
        }
    }

    private void aTm() {
        this.epa.aTu();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.epb.nE(this.dZC.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTn() {
        if (this.epe == null) {
            this.epe = new com.baidu.tieba.write.view.e(getActivity());
            this.epe.iA(false);
            this.epe.pG(t.f.icon_send_ok);
            this.epe.pJ(t.j.share_alert_success);
            this.epe.a(t.j.share_stay_in_tieba, this.epg);
            this.epe.b(t.j.back, this.epi);
            this.epe.a(this.epl);
            this.epe.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTo() {
        if (this.epf == null) {
            this.epf = new com.baidu.tieba.write.view.e(getActivity());
            this.epf.pG(t.f.icon_send_error);
            this.epf.pH(t.f.btn_w_square);
            this.epf.pI(t.d.dialog_bdalert_title);
            this.epf.pJ(t.j.share_alert_fail);
            this.epf.a(t.j.share_keep_sending, this.eph);
            this.epf.b(t.j.back, this.epi);
            this.epf.a(this.epl);
            this.epf.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aTp() {
        if (this.auV != null) {
            this.auV.cancelLoadData();
        }
    }

    protected void aTq() {
        if (this.auV != null) {
            this.auV.aNG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        aTp();
        aTq();
        Iq();
        super.onDestroy();
    }

    private void Iq() {
        ShareSDKImageView aTE;
        if (this.epa != null && (aTE = this.epa.aTE()) != null) {
            aTE.setImageBitmap(null);
        }
    }

    public WriteData aND() {
        return this.dZC;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.epa != null && this.epa.aTA() != null && this.epa.aTA().isShowing()) {
                com.baidu.adp.lib.h.j.a(this.epa.aTA(), getPageContext().getPageActivity());
                return true;
            }
            aTp();
            if (this.epd) {
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
        if (this.epa != null) {
            this.epa.onChangeSkinType(i);
        }
    }

    private void qD() {
        setContentView(t.h.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.epa = new o(this);
        this.epa.T(this.epm);
        this.epa.U(this.epn);
        this.epa.a(this.epp);
        this.epa.V(this.epo);
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

    public void pD(int i) {
        com.baidu.adp.lib.util.k.b(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.auV = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.auV.a(this.epk);
        this.auV.a(this.epj);
        this.epb = new com.baidu.tieba.write.shareSDK.a(this, new e(this));
        this.cYA = new f(this);
        this.dZC = new WriteData();
        this.dZC.setType(3);
        if (bundle != null) {
            this.dZC.setForumName(bundle.getString("forum_name"));
            this.dZC.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.dZC.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.dZC.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.dZC.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.dZC.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.dZC.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.dZC.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.dZC.setForumName(this.eoV);
            this.dZC.setShareSummaryTitle(this.mShareTitle);
            this.dZC.setShareSummaryContent(this.mShareContent);
            this.dZC.setShareApiKey(this.dTV);
            this.dZC.setShareAppName(this.mAppName);
            this.dZC.setShareSignKey(this.eoW);
            this.dZC.setShareReferUrl(this.eoT);
            boolean dc = com.baidu.tbadk.core.util.m.dc(this.eoU);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || dc) {
                this.auV.c(this.mShareLocalImageData, this.eoU);
                this.dZC.setShareLocalImageUri(this.eoU);
                this.dZC.setShareLocalImageData(this.mShareLocalImageData);
                this.auV.NA();
                this.dZC.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.dZC.setShareSummaryImg(this.eoU);
                this.dZC.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.dZC.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.dZC.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.dZC.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.dZC.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.dZC.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.dZC.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.dZC.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.dZC.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.dZC.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.dZC.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.dZC.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.dZC.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.dZC.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.dZC.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.dZC.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.dZC.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.dZC.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.epa != null && this.epa.aAU() != null && (editable = this.epa.aAU().getEditableText().toString()) != null) {
            this.epa.aAU().setText(TbFaceManager.Ec().G(getPageContext().getContext(), editable));
            this.epa.aAU().setSelection(this.epa.aAU().getText().length());
        }
    }

    public void pE(int i) {
        this.eoZ = i;
    }

    public int aTr() {
        return this.eoZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTs() {
        aTp();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.eoZ != this.mPrefixData.getPrefixs().size() - 1) {
            this.dZC.setTitle(String.valueOf(this.epa.aTD().getText().toString()) + this.epa.aTz().getText().toString());
        } else {
            this.dZC.setTitle(this.epa.aTz().getText().toString());
        }
        this.dZC.setContent(this.epa.aAU().getText().toString());
        this.auV.c(this.dZC);
        this.dZC.setVcode(null);
        this.auV.aND().setVoice(null);
        this.auV.aND().setVoiceDuringTime(-1);
        if (this.auV.aNE()) {
            showLoadingDialog(getPageContext().getString(t.j.sending), this.cYA);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.epc = false;
            if (i2 == -1) {
                aTn();
                if (this.epe != null) {
                    this.epd = true;
                    this.epe.aTS();
                }
                setResult(-1);
                return;
            }
            aTo();
            if (this.epf != null) {
                this.epd = false;
                this.epf.aTS();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.eoV = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.dZC.setForumName(this.eoV);
                    aTm();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                aTl();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.epa.aTz());
        HidenSoftKeyPad(this.mInputManager, this.epa.aAU());
        super.onPause();
    }

    public void aTt() {
        HidenSoftKeyPad(this.mInputManager, this.epa.aTz());
        HidenSoftKeyPad(this.mInputManager, this.epa.aAU());
    }
}
