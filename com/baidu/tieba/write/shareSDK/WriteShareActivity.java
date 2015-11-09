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
    private com.baidu.tieba.tbadkCore.writeModel.a aqv;
    private String bPC;
    private String cXW;
    private String dnJ;
    private String dnK;
    private String dnL;
    private String dnM;
    private PackageManager dnN;
    private PackageInfo dnO;
    private int dnP;
    private o dnQ;
    com.baidu.tieba.write.shareSDK.a dnR;
    private com.baidu.tieba.write.view.e dnU;
    private com.baidu.tieba.write.view.e dnV;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData ddI = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener crt = null;
    private boolean dnS = false;
    private boolean dnT = false;
    private e.b dnW = new c(this);
    private e.b dnX = new g(this);
    private e.b dnY = new h(this);
    private final a.b dnZ = new i(this);
    private final a.c doa = new j(this);
    private DialogInterface.OnKeyListener dob = new k(this);
    private View.OnClickListener doc = new l(this);
    private View.OnClickListener dod = new m(this);
    private View.OnClickListener doe = new n(this);
    private final View.OnFocusChangeListener dof = new d(this);

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
        this.dnN = getPageContext().getPageActivity().getPackageManager();
        aCG();
        boolean aCH = aCH();
        initData(bundle);
        initUI();
        if (!aCH) {
            if (TextUtils.isEmpty(this.cXW)) {
                me(i.h.share_parameter_invalid_tip);
            } else {
                me(i.h.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            aCJ();
        } else {
            aCI();
        }
        TiebaStatic.log("share4sdk");
    }

    private void aCG() {
        this.packageName = getCallingPackage();
        if (this.dnN != null && this.packageName != null) {
            try {
                this.dnO = this.dnN.getPackageInfo(this.packageName, 64);
                if (this.dnO != null) {
                    if (this.dnO.applicationInfo != null && this.dnO.applicationInfo.loadLabel(this.dnN) != null) {
                        this.bPC = this.dnO.applicationInfo.loadLabel(this.dnN).toString();
                    }
                    if (this.dnO.signatures != null && this.dnO.signatures.length > 0 && this.dnO.signatures[0] != null) {
                        this.dnM = au.P(this.dnO.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.bPC = null;
                this.dnM = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.dnJ = extras.getString("ShareUrl");
            this.dnK = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.dnL = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.bPC)) {
                this.bPC = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.dnM)) {
                this.dnM = extras.getString("appSign");
            }
            this.cXW = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean aCH() {
        return (TextUtils.isEmpty(this.cXW) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.dnK) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void aCI() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
    }

    private void aCJ() {
        if (TextUtils.isEmpty(this.dnL)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            aCK();
        }
    }

    private void aCK() {
        this.dnQ.aCS();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.dnR.mv(this.ddI.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCL() {
        if (this.dnU == null) {
            this.dnU = new com.baidu.tieba.write.view.e(getActivity());
            this.dnU.gY(false);
            this.dnU.mh(i.e.icon_send_ok);
            this.dnU.mk(i.h.share_alert_success);
            this.dnU.a(i.h.share_stay_in_tieba, this.dnW);
            this.dnU.b(i.h.back, this.dnY);
            this.dnU.a(this.dob);
            this.dnU.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCM() {
        if (this.dnV == null) {
            this.dnV = new com.baidu.tieba.write.view.e(getActivity());
            this.dnV.mh(i.e.icon_send_error);
            this.dnV.mi(i.e.btn_w_square);
            this.dnV.mj(i.c.dialog_bdalert_title);
            this.dnV.mk(i.h.share_alert_fail);
            this.dnV.a(i.h.share_keep_sending, this.dnX);
            this.dnV.b(i.h.back, this.dnY);
            this.dnV.a(this.dob);
            this.dnV.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aCN() {
        if (this.aqv != null) {
            this.aqv.cancelLoadData();
        }
    }

    protected void aCO() {
        if (this.aqv != null) {
            this.aqv.ayW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        aCN();
        aCO();
        FC();
        super.onDestroy();
    }

    private void FC() {
        ShareSDKImageView aDc;
        if (this.dnQ != null && (aDc = this.dnQ.aDc()) != null) {
            aDc.setImageBitmap(null);
        }
    }

    public WriteData ayT() {
        return this.ddI;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dnQ != null && this.dnQ.aCY() != null && this.dnQ.aCY().isShowing()) {
                com.baidu.adp.lib.g.j.a(this.dnQ.aCY(), getPageContext().getPageActivity());
                return true;
            }
            aCN();
            if (this.dnT) {
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
        if (this.dnQ != null) {
            this.dnQ.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(i.g.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.dnQ = new o(this);
        this.dnQ.K(this.doc);
        this.dnQ.L(this.dod);
        this.dnQ.a(this.dof);
        this.dnQ.M(this.doe);
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

    public void me(int i) {
        com.baidu.adp.lib.util.k.c(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.aqv = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aqv.a(this.doa);
        this.aqv.a(this.dnZ);
        this.dnR = new com.baidu.tieba.write.shareSDK.a(this, new e(this));
        this.crt = new f(this);
        this.ddI = new WriteData();
        this.ddI.setType(3);
        if (bundle != null) {
            this.ddI.setForumName(bundle.getString("forum_name"));
            this.ddI.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.ddI.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.ddI.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.ddI.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.ddI.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.ddI.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.ddI.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.ddI.setForumName(this.dnL);
            this.ddI.setShareSummaryTitle(this.mShareTitle);
            this.ddI.setShareSummaryContent(this.mShareContent);
            this.ddI.setShareApiKey(this.cXW);
            this.ddI.setShareAppName(this.bPC);
            this.ddI.setShareSignKey(this.dnM);
            this.ddI.setShareReferUrl(this.dnJ);
            boolean cU = com.baidu.tbadk.core.util.n.cU(this.dnK);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || cU) {
                this.aqv.c(this.mShareLocalImageData, this.dnK);
                this.ddI.setShareLocalImageUri(this.dnK);
                this.ddI.setShareLocalImageData(this.mShareLocalImageData);
                this.aqv.JU();
                this.ddI.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.ddI.setShareSummaryImg(this.dnK);
                this.ddI.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.ddI.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.ddI.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.ddI.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.ddI.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.ddI.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.ddI.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.ddI.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.ddI.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.ddI.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.ddI.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.ddI.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.ddI.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.ddI.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.ddI.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.ddI.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.ddI.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.ddI.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.dnQ != null && this.dnQ.anu() != null && (editable = this.dnQ.anu().getEditableText().toString()) != null) {
            this.dnQ.anu().setText(TbFaceManager.BU().G(getPageContext().getContext(), editable));
            this.dnQ.anu().setSelection(this.dnQ.anu().getText().length());
        }
    }

    public void mf(int i) {
        this.dnP = i;
    }

    public int aCP() {
        return this.dnP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCQ() {
        aCN();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.dnP != this.mPrefixData.getPrefixs().size() - 1) {
            this.ddI.setTitle(String.valueOf(this.dnQ.aDb().getText().toString()) + this.dnQ.aCX().getText().toString());
        } else {
            this.ddI.setTitle(this.dnQ.aCX().getText().toString());
        }
        this.ddI.setContent(this.dnQ.anu().getText().toString());
        this.aqv.c(this.ddI);
        this.ddI.setVcode(null);
        this.aqv.ayT().setVoice(null);
        this.aqv.ayT().setVoiceDuringTime(-1);
        if (this.aqv.ayU()) {
            showLoadingDialog(getPageContext().getString(i.h.sending), this.crt);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.dnS = false;
            if (i2 == -1) {
                aCL();
                if (this.dnU != null) {
                    this.dnT = true;
                    this.dnU.aDf();
                }
                setResult(-1);
                return;
            }
            aCM();
            if (this.dnV != null) {
                this.dnT = false;
                this.dnV.aDf();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.dnL = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.ddI.setForumName(this.dnL);
                    aCK();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                aCJ();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.dnQ.aCX());
        HidenSoftKeyPad(this.mInputManager, this.dnQ.anu());
        super.onPause();
    }

    public void aCR() {
        HidenSoftKeyPad(this.mInputManager, this.dnQ.aCX());
        HidenSoftKeyPad(this.mInputManager, this.dnQ.anu());
    }
}
