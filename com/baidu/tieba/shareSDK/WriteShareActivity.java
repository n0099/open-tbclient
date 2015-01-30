package com.baidu.tieba.shareSDK;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private com.baidu.tieba.tbadkCore.f.a aBM;
    private int bPq;
    private q bPr;
    a bPs;
    private com.baidu.tbadk.core.dialog.e bPv;
    private com.baidu.tbadk.core.dialog.e bPw;
    private PostPrefixData mPrefixData;
    private WriteData bPp = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener bHG = null;
    private boolean bPt = false;
    private boolean bPu = false;
    private com.baidu.tbadk.core.dialog.h bPx = new e(this);
    private com.baidu.tbadk.core.dialog.h bPy = new h(this);
    private com.baidu.tbadk.core.dialog.h bPz = new i(this);
    private final com.baidu.tieba.tbadkCore.f.b aBP = new j(this);
    private DialogInterface.OnKeyListener bPA = new k(this);
    private View.OnClickListener bPB = new l(this);
    private View.OnClickListener bPC = new m(this);
    private View.OnClickListener bPD = new n(this);
    private final View.OnFocusChangeListener bPE = new o(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(WriteShareActivityConfig.class, WriteShareActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getWindow().setSoftInputMode(18);
        if (!this.bPt) {
            com.baidu.tbadk.core.b.b.a(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdLog.addLogPackage(WriteShareActivity.class.getPackage().getName());
        super.onCreate(bundle);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        initUI();
        this.bPs.hU(this.bPp.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ada() {
        if (this.bPv == null) {
            this.bPv = new com.baidu.tbadk.core.dialog.e(getActivity());
            this.bPv.ak(false);
            this.bPv.bz(com.baidu.tieba.v.icon_send_ok);
            this.bPv.bC(z.share_alert_success);
            this.bPv.a(z.share_stay_in_tieba, this.bPx);
            this.bPv.b(z.back, this.bPz);
            this.bPv.a(this.bPA);
            this.bPv.d(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adb() {
        if (this.bPw == null) {
            this.bPw = new com.baidu.tbadk.core.dialog.e(getActivity());
            this.bPw.bz(com.baidu.tieba.v.icon_send_error);
            this.bPw.bA(com.baidu.tieba.v.btn_w_square);
            this.bPw.bB(com.baidu.tieba.t.dialog_bdalert_title);
            this.bPw.bC(z.share_alert_fail);
            this.bPw.a(z.share_keep_sending, this.bPy);
            this.bPw.b(z.back, this.bPz);
            this.bPw.a(this.bPA);
            this.bPw.d(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adc() {
        if (this.aBM != null) {
            this.aBM.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        adc();
        super.onDestroy();
    }

    public WriteData Ft() {
        return this.bPp;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bPr != null && this.bPr.ado() != null && this.bPr.ado().isShowing()) {
                com.baidu.adp.lib.g.k.a(this.bPr.ado(), getPageContext().getPageActivity());
                return true;
            }
            adc();
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(Boolean.valueOf(this.bPu)));
            com.baidu.tbadk.core.b.b.a(getPageContext().getPageActivity(), 200, false);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bPr != null) {
            this.bPr.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(com.baidu.tieba.x.write_share_activity);
        addGlobalLayoutListener();
        this.bPr = new q(this);
        this.bPr.E(this.bPB);
        this.bPr.F(this.bPC);
        this.bPr.a(this.bPE);
        this.bPr.G(this.bPD);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    public void add() {
        com.baidu.adp.lib.util.l.c(getPageContext().getContext(), z.share_load_image_fail_tip);
        new Handler().postDelayed(new p(this, getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.aBM = new com.baidu.tieba.tbadkCore.f.a(this);
        this.aBM.a(this.aBP);
        this.bPs = new a(this, new f(this));
        this.bHG = new g(this);
        this.bPp = new WriteData();
        this.bPp.setType(3);
        if (bundle != null) {
            this.bPp.setForumName(bundle.getString("forum_name"));
            this.bPp.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.bPp.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.bPp.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.bPp.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.bPp.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.bPp.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.bPp.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            Intent intent = getIntent();
            this.bPp.setForumName(intent.getStringExtra("forum_name"));
            this.bPp.setShareSummaryTitle(intent.getStringExtra(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.bPp.setShareSummaryContent(intent.getStringExtra(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.bPp.setShareSummaryImg(intent.getStringExtra(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.bPp.setShareApiKey(intent.getStringExtra(WriteShareActivityConfig.SHARE_API_KEY));
            this.bPp.setShareAppName(intent.getStringExtra(WriteShareActivityConfig.SHARE_APP_NAME));
            this.bPp.setShareSignKey(intent.getStringExtra(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.bPp.setShareReferUrl(intent.getStringExtra(WriteShareActivityConfig.SHARE_REFER_URL));
        }
        String shareSummaryImg = this.bPp.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.bPp.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.bPp.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.bPp.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.bPp.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.bPp.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.bPp.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.bPp.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.bPp.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.bPp.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.bPp.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.bPp.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.bPp.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.bPp.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.bPp.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.bPp.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.bPp.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.bPr != null && this.bPr.adn() != null && (editable = this.bPr.adn().getEditableText().toString()) != null) {
            this.bPr.adn().setText(TbFaceManager.wd().E(getPageContext().getContext(), editable));
            this.bPr.adn().setSelection(this.bPr.adn().getText().length());
        }
    }

    public void hA(int i) {
        this.bPq = i;
    }

    public int ade() {
        return this.bPq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adf() {
        adc();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.bPq != this.mPrefixData.getPrefixs().size() - 1) {
            this.bPp.setTitle(String.valueOf(this.bPr.adr().getText().toString()) + this.bPr.adm().getText().toString());
        } else {
            this.bPp.setTitle(this.bPr.adm().getText().toString());
        }
        this.bPp.setContent(this.bPr.adn().getText().toString());
        this.aBM.c(this.bPp);
        this.bPp.setVcode(null);
        this.aBM.Ft().setVoice(null);
        this.aBM.Ft().setVoiceDuringTime(-1);
        if (this.aBM.aiF()) {
            showLoadingDialog(getPageContext().getString(z.sending), this.bHG);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.bPt = false;
            if (i2 == -1) {
                ada();
                if (this.bPv != null) {
                    this.bPu = true;
                    MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(true));
                    this.bPv.nY();
                    return;
                }
                return;
            }
            adb();
            if (this.bPw != null) {
                this.bPu = false;
                this.bPw.nY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.bPr.adm());
        HidenSoftKeyPad(this.mInputManager, this.bPr.adn());
        super.onPause();
    }

    public void adg() {
        HidenSoftKeyPad(this.mInputManager, this.bPr.adm());
        HidenSoftKeyPad(this.mInputManager, this.bPr.adn());
    }
}
