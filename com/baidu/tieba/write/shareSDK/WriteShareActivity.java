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
    private com.baidu.tieba.tbadkCore.writeModel.a aJT;
    private int cAd;
    private q cAe;
    a cAf;
    private com.baidu.tieba.write.view.f cAi;
    private com.baidu.tieba.write.view.f cAj;
    private String chb;
    private String chc;
    private String chd;
    private String che;
    private String chf;
    private PackageManager chg;
    private PackageInfo chh;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData cuo = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener bSI = null;
    private boolean cAg = false;
    private boolean cAh = false;
    private com.baidu.tieba.write.view.i cAk = new d(this);
    private com.baidu.tieba.write.view.i cAl = new h(this);
    private com.baidu.tieba.write.view.i cAm = new i(this);
    private final com.baidu.tieba.tbadkCore.writeModel.c cAn = new j(this);
    private final com.baidu.tieba.tbadkCore.writeModel.d aJW = new k(this);
    private DialogInterface.OnKeyListener cAo = new l(this);
    private View.OnClickListener cAp = new m(this);
    private View.OnClickListener cAq = new n(this);
    private View.OnClickListener cAr = new o(this);
    private final View.OnFocusChangeListener cAs = new e(this);

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
        this.chg = getPageContext().getPageActivity().getPackageManager();
        aka();
        boolean ast = ast();
        initData(bundle);
        initUI();
        if (!ast) {
            if (TextUtils.isEmpty(this.che)) {
                jt(com.baidu.tieba.t.share_parameter_invalid_tip);
            } else {
                jt(com.baidu.tieba.t.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            akc();
        } else {
            Fz();
        }
        com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "share4sdk");
    }

    private void aka() {
        this.packageName = getCallingPackage();
        if (this.chg != null && this.packageName != null) {
            try {
                this.chh = this.chg.getPackageInfo(this.packageName, 64);
                if (this.chh != null) {
                    if (this.chh.applicationInfo != null && this.chh.applicationInfo.loadLabel(this.chg) != null) {
                        this.mAppName = this.chh.applicationInfo.loadLabel(this.chg).toString();
                    }
                    if (this.chh.signatures != null && this.chh.signatures.length > 0 && this.chh.signatures[0] != null) {
                        this.chf = bd.y(this.chh.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.chf = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.chb = extras.getString("ShareUrl");
            this.chc = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.chd = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.chf)) {
                this.chf = extras.getString("appSign");
            }
            this.che = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean ast() {
        return (TextUtils.isEmpty(this.che) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.chc) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void Fz() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
    }

    private void akc() {
        if (TextUtils.isEmpty(this.chd)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            asu();
        }
    }

    private void asu() {
        this.cAe.asC();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.cAf.kb(this.cuo.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asv() {
        if (this.cAi == null) {
            this.cAi = new com.baidu.tieba.write.view.f(getActivity());
            this.cAi.fB(false);
            this.cAi.jw(com.baidu.tieba.p.icon_send_ok);
            this.cAi.jz(com.baidu.tieba.t.share_alert_success);
            this.cAi.a(com.baidu.tieba.t.share_stay_in_tieba, this.cAk);
            this.cAi.b(com.baidu.tieba.t.back, this.cAm);
            this.cAi.a(this.cAo);
            this.cAi.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asw() {
        if (this.cAj == null) {
            this.cAj = new com.baidu.tieba.write.view.f(getActivity());
            this.cAj.jw(com.baidu.tieba.p.icon_send_error);
            this.cAj.jx(com.baidu.tieba.p.btn_w_square);
            this.cAj.jy(com.baidu.tieba.n.dialog_bdalert_title);
            this.cAj.jz(com.baidu.tieba.t.share_alert_fail);
            this.cAj.a(com.baidu.tieba.t.share_keep_sending, this.cAl);
            this.cAj.b(com.baidu.tieba.t.back, this.cAm);
            this.cAj.a(this.cAo);
            this.cAj.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asx() {
        if (this.aJT != null) {
            this.aJT.cancelLoadData();
        }
    }

    protected void asy() {
        if (this.aJT != null) {
            this.aJT.apI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        asx();
        asy();
        EO();
        super.onDestroy();
    }

    private void EO() {
        ShareSDKImageView asN;
        if (this.cAe != null && (asN = this.cAe.asN()) != null) {
            asN.setImageBitmap(null);
        }
    }

    public WriteData JS() {
        return this.cuo;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cAe != null && this.cAe.asJ() != null && this.cAe.asJ().isShowing()) {
                com.baidu.adp.lib.g.k.a(this.cAe.asJ(), getPageContext().getPageActivity());
                return true;
            }
            asx();
            if (this.cAh) {
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
        if (this.cAe != null) {
            this.cAe.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(com.baidu.tieba.r.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.cAe = new q(this);
        this.cAe.B(this.cAp);
        this.cAe.C(this.cAq);
        this.cAe.a(this.cAs);
        this.cAe.D(this.cAr);
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
        this.aJT = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aJT.a(this.aJW);
        this.aJT.a(this.cAn);
        this.cAf = new a(this, new f(this));
        this.bSI = new g(this);
        this.cuo = new WriteData();
        this.cuo.setType(3);
        if (bundle != null) {
            this.cuo.setForumName(bundle.getString("forum_name"));
            this.cuo.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.cuo.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.cuo.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.cuo.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.cuo.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.cuo.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.cuo.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.cuo.setForumName(this.chd);
            this.cuo.setShareSummaryTitle(this.mShareTitle);
            this.cuo.setShareSummaryContent(this.mShareContent);
            this.cuo.setShareApiKey(this.che);
            this.cuo.setShareAppName(this.mAppName);
            this.cuo.setShareSignKey(this.chf);
            this.cuo.setShareReferUrl(this.chb);
            boolean cJ = com.baidu.tbadk.core.util.o.cJ(this.chc);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || cJ) {
                this.aJT.c(this.mShareLocalImageData, this.chc);
                this.cuo.setShareLocalImageUri(this.chc);
                this.cuo.setShareLocalImageData(this.mShareLocalImageData);
                this.aJT.Jk();
                this.cuo.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.cuo.setShareSummaryImg(this.chc);
                this.cuo.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.cuo.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.cuo.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.cuo.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.cuo.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.cuo.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.cuo.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.cuo.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.cuo.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.cuo.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.cuo.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.cuo.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.cuo.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.cuo.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.cuo.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.cuo.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.cuo.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.cuo.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.cAe != null && this.cAe.asI() != null && (editable = this.cAe.asI().getEditableText().toString()) != null) {
            this.cAe.asI().setText(TbFaceManager.Ak().F(getPageContext().getContext(), editable));
            this.cAe.asI().setSelection(this.cAe.asI().getText().length());
        }
    }

    public void ju(int i) {
        this.cAd = i;
    }

    public int asz() {
        return this.cAd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asA() {
        asx();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.cAd != this.mPrefixData.getPrefixs().size() - 1) {
            this.cuo.setTitle(String.valueOf(this.cAe.asM().getText().toString()) + this.cAe.asH().getText().toString());
        } else {
            this.cuo.setTitle(this.cAe.asH().getText().toString());
        }
        this.cuo.setContent(this.cAe.asI().getText().toString());
        this.aJT.c(this.cuo);
        this.cuo.setVcode(null);
        this.aJT.JS().setVoice(null);
        this.aJT.JS().setVoiceDuringTime(-1);
        if (this.aJT.apH()) {
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.t.sending), this.bSI);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.cAg = false;
            if (i2 == -1) {
                asv();
                if (this.cAi != null) {
                    this.cAh = true;
                    this.cAi.asP();
                }
                setResult(-1);
                return;
            }
            asw();
            if (this.cAj != null) {
                this.cAh = false;
                this.cAj.asP();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.chd = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.cuo.setForumName(this.chd);
                    asu();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                akc();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.cAe.asH());
        HidenSoftKeyPad(this.mInputManager, this.cAe.asI());
        super.onPause();
    }

    public void asB() {
        HidenSoftKeyPad(this.mInputManager, this.cAe.asH());
        HidenSoftKeyPad(this.mInputManager, this.cAe.asI());
    }
}
