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
    private com.baidu.tieba.tbadkCore.writeModel.a aHK;
    private String ccX;
    private String ccY;
    private String ccZ;
    private String cda;
    private String cdb;
    private PackageManager cdc;
    private PackageInfo cdd;
    private int cvN;
    private q cvO;
    a cvP;
    private com.baidu.tieba.write.view.f cvS;
    private com.baidu.tieba.write.view.f cvT;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData cqk = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener ccP = null;
    private boolean cvQ = false;
    private boolean cvR = false;
    private com.baidu.tieba.write.view.i cvU = new d(this);
    private com.baidu.tieba.write.view.i cvV = new h(this);
    private com.baidu.tieba.write.view.i cvW = new i(this);
    private final com.baidu.tieba.tbadkCore.writeModel.c cvX = new j(this);
    private final com.baidu.tieba.tbadkCore.writeModel.d aHO = new k(this);
    private DialogInterface.OnKeyListener cvY = new l(this);
    private View.OnClickListener cvZ = new m(this);
    private View.OnClickListener cwa = new n(this);
    private View.OnClickListener cwb = new o(this);
    private final View.OnFocusChangeListener cwc = new e(this);

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
        this.cdc = getPageContext().getPageActivity().getPackageManager();
        aiq();
        boolean aqD = aqD();
        initData(bundle);
        initUI();
        if (!aqD) {
            if (TextUtils.isEmpty(this.cda)) {
                iX(com.baidu.tieba.y.share_parameter_invalid_tip);
            } else {
                iX(com.baidu.tieba.y.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            ais();
        } else {
            EH();
        }
        com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "share4sdk");
    }

    private void aiq() {
        this.packageName = getCallingPackage();
        if (this.cdc != null && this.packageName != null) {
            try {
                this.cdd = this.cdc.getPackageInfo(this.packageName, 64);
                if (this.cdd != null) {
                    if (this.cdd.applicationInfo != null && this.cdd.applicationInfo.loadLabel(this.cdc) != null) {
                        this.mAppName = this.cdd.applicationInfo.loadLabel(this.cdc).toString();
                    }
                    if (this.cdd.signatures != null && this.cdd.signatures.length > 0 && this.cdd.signatures[0] != null) {
                        this.cdb = bf.y(this.cdd.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.cdb = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.ccX = extras.getString("ShareUrl");
            this.ccY = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.ccZ = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.cdb)) {
                this.cdb = extras.getString("appSign");
            }
            this.cda = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean aqD() {
        return (TextUtils.isEmpty(this.cda) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.ccY) && this.mShareLocalImageData == null && TextUtils.isEmpty(this.mShareTitle))) ? false : true;
    }

    private void EH() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
    }

    private void ais() {
        if (TextUtils.isEmpty(this.ccZ)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            aqE();
        }
    }

    private void aqE() {
        this.cvO.aqM();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.cvP.ji(this.cqk.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqF() {
        if (this.cvS == null) {
            this.cvS = new com.baidu.tieba.write.view.f(getActivity());
            this.cvS.ff(false);
            this.cvS.ja(com.baidu.tieba.u.icon_send_ok);
            this.cvS.jd(com.baidu.tieba.y.share_alert_success);
            this.cvS.a(com.baidu.tieba.y.share_stay_in_tieba, this.cvU);
            this.cvS.b(com.baidu.tieba.y.back, this.cvW);
            this.cvS.a(this.cvY);
            this.cvS.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqG() {
        if (this.cvT == null) {
            this.cvT = new com.baidu.tieba.write.view.f(getActivity());
            this.cvT.ja(com.baidu.tieba.u.icon_send_error);
            this.cvT.jb(com.baidu.tieba.u.btn_w_square);
            this.cvT.jc(com.baidu.tieba.s.dialog_bdalert_title);
            this.cvT.jd(com.baidu.tieba.y.share_alert_fail);
            this.cvT.a(com.baidu.tieba.y.share_keep_sending, this.cvV);
            this.cvT.b(com.baidu.tieba.y.back, this.cvW);
            this.cvT.a(this.cvY);
            this.cvT.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqH() {
        if (this.aHK != null) {
            this.aHK.cancelLoadData();
        }
    }

    protected void aqI() {
        if (this.aHK != null) {
            this.aHK.anQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        aqH();
        aqI();
        Eb();
        super.onDestroy();
    }

    private void Eb() {
        ShareSDKImageView aqX;
        if (this.cvO != null && (aqX = this.cvO.aqX()) != null) {
            aqX.setImageBitmap(null);
        }
    }

    public WriteData IS() {
        return this.cqk;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cvO != null && this.cvO.aqT() != null && this.cvO.aqT().isShowing()) {
                com.baidu.adp.lib.g.k.a(this.cvO.aqT(), getPageContext().getPageActivity());
                return true;
            }
            aqH();
            if (this.cvR) {
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
        if (this.cvO != null) {
            this.cvO.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(com.baidu.tieba.w.write_share_activity);
        addGlobalLayoutListener();
        this.cvO = new q(this);
        this.cvO.D(this.cvZ);
        this.cvO.E(this.cwa);
        this.cvO.a(this.cwc);
        this.cvO.F(this.cwb);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    public void iX(int i) {
        com.baidu.adp.lib.util.n.c(getPageContext().getContext(), i);
        new Handler().postDelayed(new p(this, getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.aHK = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aHK.a(this.aHO);
        this.aHK.a(this.cvX);
        this.cvP = new a(this, new f(this));
        this.ccP = new g(this);
        this.cqk = new WriteData();
        this.cqk.setType(3);
        if (bundle != null) {
            this.cqk.setForumName(bundle.getString("forum_name"));
            this.cqk.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.cqk.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.cqk.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.cqk.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.cqk.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.cqk.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.cqk.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.cqk.setForumName(this.ccZ);
            this.cqk.setShareSummaryTitle(this.mShareTitle);
            this.cqk.setShareSummaryContent(this.mShareContent);
            this.cqk.setShareApiKey(this.cda);
            this.cqk.setShareAppName(this.mAppName);
            this.cqk.setShareSignKey(this.cdb);
            this.cqk.setShareReferUrl(this.ccX);
            boolean cu = com.baidu.tbadk.core.util.o.cu(this.ccY);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || cu) {
                this.aHK.c(this.mShareLocalImageData, this.ccY);
                this.cqk.setShareLocalImageUri(this.ccY);
                this.cqk.setShareLocalImageData(this.mShareLocalImageData);
                this.aHK.Ik();
                this.cqk.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.cqk.setShareSummaryImg(this.ccY);
                this.cqk.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.cqk.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.cqk.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.cqk.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.cqk.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.cqk.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.cqk.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.cqk.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.cqk.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.cqk.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.cqk.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.cqk.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.cqk.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.cqk.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.cqk.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.cqk.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.cqk.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.cqk.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.cvO != null && this.cvO.aqS() != null && (editable = this.cvO.aqS().getEditableText().toString()) != null) {
            this.cvO.aqS().setText(TbFaceManager.zx().E(getPageContext().getContext(), editable));
            this.cvO.aqS().setSelection(this.cvO.aqS().getText().length());
        }
    }

    public void iY(int i) {
        this.cvN = i;
    }

    public int aqJ() {
        return this.cvN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqK() {
        aqH();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.cvN != this.mPrefixData.getPrefixs().size() - 1) {
            this.cqk.setTitle(String.valueOf(this.cvO.aqW().getText().toString()) + this.cvO.aqR().getText().toString());
        } else {
            this.cqk.setTitle(this.cvO.aqR().getText().toString());
        }
        this.cqk.setContent(this.cvO.aqS().getText().toString());
        this.aHK.c(this.cqk);
        this.cqk.setVcode(null);
        this.aHK.IS().setVoice(null);
        this.aHK.IS().setVoiceDuringTime(-1);
        if (this.aHK.anP()) {
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.y.sending), this.ccP);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.cvQ = false;
            if (i2 == -1) {
                aqF();
                if (this.cvS != null) {
                    this.cvR = true;
                    this.cvS.aqZ();
                }
                setResult(-1);
                return;
            }
            aqG();
            if (this.cvT != null) {
                this.cvR = false;
                this.cvT.aqZ();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.ccZ = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.cqk.setForumName(this.ccZ);
                    aqE();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                ais();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.cvO.aqR());
        HidenSoftKeyPad(this.mInputManager, this.cvO.aqS());
        super.onPause();
    }

    public void aqL() {
        HidenSoftKeyPad(this.mInputManager, this.cvO.aqR());
        HidenSoftKeyPad(this.mInputManager, this.cvO.aqS());
    }
}
