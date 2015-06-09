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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
/* loaded from: classes.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private com.baidu.tieba.tbadkCore.writeModel.a aJU;
    private int cAe;
    private q cAf;
    a cAg;
    private com.baidu.tieba.write.view.f cAj;
    private com.baidu.tieba.write.view.f cAk;
    private String chc;
    private String chd;
    private String che;
    private String chf;
    private String chg;
    private PackageManager chh;
    private PackageInfo chi;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData cup = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener bSJ = null;
    private boolean cAh = false;
    private boolean cAi = false;
    private com.baidu.tieba.write.view.i cAl = new d(this);
    private com.baidu.tieba.write.view.i cAm = new h(this);
    private com.baidu.tieba.write.view.i cAn = new i(this);
    private final com.baidu.tieba.tbadkCore.writeModel.c cAo = new j(this);
    private final com.baidu.tieba.tbadkCore.writeModel.d aJX = new k(this);
    private DialogInterface.OnKeyListener cAp = new l(this);
    private View.OnClickListener cAq = new m(this);
    private View.OnClickListener cAr = new n(this);
    private View.OnClickListener cAs = new o(this);
    private final View.OnFocusChangeListener cAt = new e(this);

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
        this.chh = getPageContext().getPageActivity().getPackageManager();
        akb();
        boolean asu = asu();
        initData(bundle);
        initUI();
        if (!asu) {
            if (TextUtils.isEmpty(this.chf)) {
                jt(com.baidu.tieba.t.share_parameter_invalid_tip);
            } else {
                jt(com.baidu.tieba.t.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            akd();
        } else {
            FA();
        }
        com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "share4sdk");
    }

    private void akb() {
        this.packageName = getCallingPackage();
        if (this.chh != null && this.packageName != null) {
            try {
                this.chi = this.chh.getPackageInfo(this.packageName, 64);
                if (this.chi != null) {
                    if (this.chi.applicationInfo != null && this.chi.applicationInfo.loadLabel(this.chh) != null) {
                        this.mAppName = this.chi.applicationInfo.loadLabel(this.chh).toString();
                    }
                    if (this.chi.signatures != null && this.chi.signatures.length > 0 && this.chi.signatures[0] != null) {
                        this.chg = bd.y(this.chi.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.chg = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.chc = extras.getString("ShareUrl");
            this.chd = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.che = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.chg)) {
                this.chg = extras.getString("appSign");
            }
            this.chf = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean asu() {
        return (TextUtils.isEmpty(this.chf) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.chd) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void FA() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
    }

    private void akd() {
        if (TextUtils.isEmpty(this.che)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            asv();
        }
    }

    private void asv() {
        this.cAf.asD();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.cAg.kb(this.cup.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asw() {
        if (this.cAj == null) {
            this.cAj = new com.baidu.tieba.write.view.f(getActivity());
            this.cAj.fB(false);
            this.cAj.jw(com.baidu.tieba.p.icon_send_ok);
            this.cAj.jz(com.baidu.tieba.t.share_alert_success);
            this.cAj.a(com.baidu.tieba.t.share_stay_in_tieba, this.cAl);
            this.cAj.b(com.baidu.tieba.t.back, this.cAn);
            this.cAj.a(this.cAp);
            this.cAj.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asx() {
        if (this.cAk == null) {
            this.cAk = new com.baidu.tieba.write.view.f(getActivity());
            this.cAk.jw(com.baidu.tieba.p.icon_send_error);
            this.cAk.jx(com.baidu.tieba.p.btn_w_square);
            this.cAk.jy(com.baidu.tieba.n.dialog_bdalert_title);
            this.cAk.jz(com.baidu.tieba.t.share_alert_fail);
            this.cAk.a(com.baidu.tieba.t.share_keep_sending, this.cAm);
            this.cAk.b(com.baidu.tieba.t.back, this.cAn);
            this.cAk.a(this.cAp);
            this.cAk.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asy() {
        if (this.aJU != null) {
            this.aJU.cancelLoadData();
        }
    }

    protected void asz() {
        if (this.aJU != null) {
            this.aJU.apJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        asy();
        asz();
        EP();
        super.onDestroy();
    }

    private void EP() {
        ShareSDKImageView asO;
        if (this.cAf != null && (asO = this.cAf.asO()) != null) {
            asO.setImageBitmap(null);
        }
    }

    public WriteData JT() {
        return this.cup;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cAf != null && this.cAf.asK() != null && this.cAf.asK().isShowing()) {
                com.baidu.adp.lib.g.k.a(this.cAf.asK(), getPageContext().getPageActivity());
                return true;
            }
            asy();
            if (this.cAi) {
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
        if (this.cAf != null) {
            this.cAf.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(com.baidu.tieba.r.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.cAf = new q(this);
        this.cAf.B(this.cAq);
        this.cAf.C(this.cAr);
        this.cAf.a(this.cAt);
        this.cAf.D(this.cAs);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    public void jt(int i) {
        com.baidu.adp.lib.util.n.c(getPageContext().getContext(), i);
        new Handler().postDelayed(new p(this, getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.aJU = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aJU.a(this.aJX);
        this.aJU.a(this.cAo);
        this.cAg = new a(this, new f(this));
        this.bSJ = new g(this);
        this.cup = new WriteData();
        this.cup.setType(3);
        if (bundle != null) {
            this.cup.setForumName(bundle.getString("forum_name"));
            this.cup.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.cup.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.cup.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.cup.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.cup.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.cup.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.cup.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.cup.setForumName(this.che);
            this.cup.setShareSummaryTitle(this.mShareTitle);
            this.cup.setShareSummaryContent(this.mShareContent);
            this.cup.setShareApiKey(this.chf);
            this.cup.setShareAppName(this.mAppName);
            this.cup.setShareSignKey(this.chg);
            this.cup.setShareReferUrl(this.chc);
            boolean cJ = com.baidu.tbadk.core.util.o.cJ(this.chd);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || cJ) {
                this.aJU.c(this.mShareLocalImageData, this.chd);
                this.cup.setShareLocalImageUri(this.chd);
                this.cup.setShareLocalImageData(this.mShareLocalImageData);
                this.aJU.Jl();
                this.cup.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.cup.setShareSummaryImg(this.chd);
                this.cup.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.cup.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.cup.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.cup.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.cup.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.cup.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.cup.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.cup.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.cup.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.cup.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.cup.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.cup.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.cup.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.cup.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.cup.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.cup.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.cup.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.cup.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.cAf != null && this.cAf.asJ() != null && (editable = this.cAf.asJ().getEditableText().toString()) != null) {
            this.cAf.asJ().setText(TbFaceManager.Al().F(getPageContext().getContext(), editable));
            this.cAf.asJ().setSelection(this.cAf.asJ().getText().length());
        }
    }

    public void ju(int i) {
        this.cAe = i;
    }

    public int asA() {
        return this.cAe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asB() {
        asy();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.cAe != this.mPrefixData.getPrefixs().size() - 1) {
            this.cup.setTitle(String.valueOf(this.cAf.asN().getText().toString()) + this.cAf.asI().getText().toString());
        } else {
            this.cup.setTitle(this.cAf.asI().getText().toString());
        }
        this.cup.setContent(this.cAf.asJ().getText().toString());
        this.aJU.c(this.cup);
        this.cup.setVcode(null);
        this.aJU.JT().setVoice(null);
        this.aJU.JT().setVoiceDuringTime(-1);
        if (this.aJU.apI()) {
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.t.sending), this.bSJ);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.cAh = false;
            if (i2 == -1) {
                asw();
                if (this.cAj != null) {
                    this.cAi = true;
                    this.cAj.asQ();
                }
                setResult(-1);
                return;
            }
            asx();
            if (this.cAk != null) {
                this.cAi = false;
                this.cAk.asQ();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.che = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.cup.setForumName(this.che);
                    asv();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                akd();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.cAf.asI());
        HidenSoftKeyPad(this.mInputManager, this.cAf.asJ());
        super.onPause();
    }

    public void asC() {
        HidenSoftKeyPad(this.mInputManager, this.cAf.asI());
        HidenSoftKeyPad(this.mInputManager, this.cAf.asJ());
    }
}
