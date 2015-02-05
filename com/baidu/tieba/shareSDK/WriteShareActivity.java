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
    private com.baidu.tieba.tbadkCore.f.a aBJ;
    private int bPp;
    private q bPq;
    a bPr;
    private com.baidu.tbadk.core.dialog.e bPu;
    private com.baidu.tbadk.core.dialog.e bPv;
    private PostPrefixData mPrefixData;
    private WriteData bPo = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener bHF = null;
    private boolean bPs = false;
    private boolean bPt = false;
    private com.baidu.tbadk.core.dialog.h bPw = new e(this);
    private com.baidu.tbadk.core.dialog.h bPx = new h(this);
    private com.baidu.tbadk.core.dialog.h bPy = new i(this);
    private final com.baidu.tieba.tbadkCore.f.b aBM = new j(this);
    private DialogInterface.OnKeyListener bPz = new k(this);
    private View.OnClickListener bPA = new l(this);
    private View.OnClickListener bPB = new m(this);
    private View.OnClickListener bPC = new n(this);
    private final View.OnFocusChangeListener bPD = new o(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(WriteShareActivityConfig.class, WriteShareActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getWindow().setSoftInputMode(18);
        if (!this.bPs) {
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
        this.bPr.hS(this.bPo.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acV() {
        if (this.bPu == null) {
            this.bPu = new com.baidu.tbadk.core.dialog.e(getActivity());
            this.bPu.ak(false);
            this.bPu.bz(com.baidu.tieba.v.icon_send_ok);
            this.bPu.bC(z.share_alert_success);
            this.bPu.a(z.share_stay_in_tieba, this.bPw);
            this.bPu.b(z.back, this.bPy);
            this.bPu.a(this.bPz);
            this.bPu.d(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acW() {
        if (this.bPv == null) {
            this.bPv = new com.baidu.tbadk.core.dialog.e(getActivity());
            this.bPv.bz(com.baidu.tieba.v.icon_send_error);
            this.bPv.bA(com.baidu.tieba.v.btn_w_square);
            this.bPv.bB(com.baidu.tieba.t.dialog_bdalert_title);
            this.bPv.bC(z.share_alert_fail);
            this.bPv.a(z.share_keep_sending, this.bPx);
            this.bPv.b(z.back, this.bPy);
            this.bPv.a(this.bPz);
            this.bPv.d(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acX() {
        if (this.aBJ != null) {
            this.aBJ.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        acX();
        super.onDestroy();
    }

    public WriteData Fn() {
        return this.bPo;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bPq != null && this.bPq.adj() != null && this.bPq.adj().isShowing()) {
                com.baidu.adp.lib.g.k.a(this.bPq.adj(), getPageContext().getPageActivity());
                return true;
            }
            acX();
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(Boolean.valueOf(this.bPt)));
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
        if (this.bPq != null) {
            this.bPq.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(com.baidu.tieba.x.write_share_activity);
        addGlobalLayoutListener();
        this.bPq = new q(this);
        this.bPq.E(this.bPA);
        this.bPq.F(this.bPB);
        this.bPq.a(this.bPD);
        this.bPq.G(this.bPC);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    public void acY() {
        com.baidu.adp.lib.util.l.c(getPageContext().getContext(), z.share_load_image_fail_tip);
        new Handler().postDelayed(new p(this, getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.aBJ = new com.baidu.tieba.tbadkCore.f.a(this);
        this.aBJ.a(this.aBM);
        this.bPr = new a(this, new f(this));
        this.bHF = new g(this);
        this.bPo = new WriteData();
        this.bPo.setType(3);
        if (bundle != null) {
            this.bPo.setForumName(bundle.getString("forum_name"));
            this.bPo.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.bPo.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.bPo.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.bPo.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.bPo.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.bPo.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.bPo.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            Intent intent = getIntent();
            this.bPo.setForumName(intent.getStringExtra("forum_name"));
            this.bPo.setShareSummaryTitle(intent.getStringExtra(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.bPo.setShareSummaryContent(intent.getStringExtra(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.bPo.setShareSummaryImg(intent.getStringExtra(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.bPo.setShareApiKey(intent.getStringExtra(WriteShareActivityConfig.SHARE_API_KEY));
            this.bPo.setShareAppName(intent.getStringExtra(WriteShareActivityConfig.SHARE_APP_NAME));
            this.bPo.setShareSignKey(intent.getStringExtra(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.bPo.setShareReferUrl(intent.getStringExtra(WriteShareActivityConfig.SHARE_REFER_URL));
        }
        String shareSummaryImg = this.bPo.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.bPo.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.bPo.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.bPo.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.bPo.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.bPo.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.bPo.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.bPo.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.bPo.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.bPo.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.bPo.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.bPo.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.bPo.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.bPo.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.bPo.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.bPo.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.bPo.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.bPq != null && this.bPq.adi() != null && (editable = this.bPq.adi().getEditableText().toString()) != null) {
            this.bPq.adi().setText(TbFaceManager.vX().E(getPageContext().getContext(), editable));
            this.bPq.adi().setSelection(this.bPq.adi().getText().length());
        }
    }

    public void hA(int i) {
        this.bPp = i;
    }

    public int acZ() {
        return this.bPp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ada() {
        acX();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.bPp != this.mPrefixData.getPrefixs().size() - 1) {
            this.bPo.setTitle(String.valueOf(this.bPq.adm().getText().toString()) + this.bPq.adh().getText().toString());
        } else {
            this.bPo.setTitle(this.bPq.adh().getText().toString());
        }
        this.bPo.setContent(this.bPq.adi().getText().toString());
        this.aBJ.c(this.bPo);
        this.bPo.setVcode(null);
        this.aBJ.Fn().setVoice(null);
        this.aBJ.Fn().setVoiceDuringTime(-1);
        if (this.aBJ.aiA()) {
            showLoadingDialog(getPageContext().getString(z.sending), this.bHF);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.bPs = false;
            if (i2 == -1) {
                acV();
                if (this.bPu != null) {
                    this.bPt = true;
                    MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(true));
                    this.bPu.nR();
                    return;
                }
                return;
            }
            acW();
            if (this.bPv != null) {
                this.bPt = false;
                this.bPv.nR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.bPq.adh());
        HidenSoftKeyPad(this.mInputManager, this.bPq.adi());
        super.onPause();
    }

    public void adb() {
        HidenSoftKeyPad(this.mInputManager, this.bPq.adh());
        HidenSoftKeyPad(this.mInputManager, this.bPq.adi());
    }
}
