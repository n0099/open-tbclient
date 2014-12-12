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
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
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
    private com.baidu.tieba.tbadkCore.f.a aAK;
    private int bNG;
    private q bNH;
    a bNI;
    private com.baidu.tbadk.core.dialog.e bNL;
    private com.baidu.tbadk.core.dialog.e bNM;
    private PostPrefixData mPrefixData;
    private WriteData bNF = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener bFV = null;
    private boolean bNJ = false;
    private boolean bNK = false;
    private com.baidu.tbadk.core.dialog.h bNN = new e(this);
    private com.baidu.tbadk.core.dialog.h bNO = new h(this);
    private com.baidu.tbadk.core.dialog.h bNP = new i(this);
    private final com.baidu.tieba.tbadkCore.f.b aAN = new j(this);
    private DialogInterface.OnKeyListener bNQ = new k(this);
    private View.OnClickListener bNR = new l(this);
    private View.OnClickListener bNS = new m(this);
    private View.OnClickListener bNT = new n(this);
    private final View.OnFocusChangeListener bNU = new o(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(WriteShareActivityConfig.class, WriteShareActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getWindow().setSoftInputMode(18);
        if (!this.bNJ) {
            com.baidu.tbadk.core.b.b.a(getPageContext().getPageActivity(), Constants.MEDIA_INFO, false);
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
        this.bNI.hN(this.bNF.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acw() {
        if (this.bNL == null) {
            this.bNL = new com.baidu.tbadk.core.dialog.e(getActivity());
            this.bNL.ai(false);
            this.bNL.bu(com.baidu.tieba.v.icon_send_ok);
            this.bNL.bx(z.share_alert_success);
            this.bNL.a(z.share_stay_in_tieba, this.bNN);
            this.bNL.b(z.back, this.bNP);
            this.bNL.a(this.bNQ);
            this.bNL.d(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acx() {
        if (this.bNM == null) {
            this.bNM = new com.baidu.tbadk.core.dialog.e(getActivity());
            this.bNM.bu(com.baidu.tieba.v.icon_send_error);
            this.bNM.bv(com.baidu.tieba.v.btn_w_square);
            this.bNM.bw(com.baidu.tieba.t.dialog_bdalert_title);
            this.bNM.bx(z.share_alert_fail);
            this.bNM.a(z.share_keep_sending, this.bNO);
            this.bNM.b(z.back, this.bNP);
            this.bNM.a(this.bNQ);
            this.bNM.d(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acy() {
        if (this.aAK != null) {
            this.aAK.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        acy();
        super.onDestroy();
    }

    public WriteData EV() {
        return this.bNF;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bNH != null && this.bNH.acK() != null && this.bNH.acK().isShowing()) {
                com.baidu.adp.lib.g.k.a(this.bNH.acK(), getPageContext().getPageActivity());
                return true;
            }
            acy();
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(Boolean.valueOf(this.bNK)));
            com.baidu.tbadk.core.b.b.a(getPageContext().getPageActivity(), Constants.MEDIA_INFO, false);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bNH != null) {
            this.bNH.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(com.baidu.tieba.x.write_share_activity);
        addGlobalLayoutListener();
        this.bNH = new q(this);
        this.bNH.D(this.bNR);
        this.bNH.E(this.bNS);
        this.bNH.a(this.bNU);
        this.bNH.F(this.bNT);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    public void acz() {
        com.baidu.adp.lib.util.l.c(getPageContext().getContext(), z.share_load_image_fail_tip);
        new Handler().postDelayed(new p(this, getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.aAK = new com.baidu.tieba.tbadkCore.f.a(this);
        this.aAK.a(this.aAN);
        this.bNI = new a(this, new f(this));
        this.bFV = new g(this);
        this.bNF = new WriteData();
        this.bNF.setType(3);
        if (bundle != null) {
            this.bNF.setForumName(bundle.getString("forum_name"));
            this.bNF.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.bNF.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.bNF.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.bNF.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.bNF.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.bNF.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.bNF.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            Intent intent = getIntent();
            this.bNF.setForumName(intent.getStringExtra("forum_name"));
            this.bNF.setShareSummaryTitle(intent.getStringExtra(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.bNF.setShareSummaryContent(intent.getStringExtra(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.bNF.setShareSummaryImg(intent.getStringExtra(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.bNF.setShareApiKey(intent.getStringExtra(WriteShareActivityConfig.SHARE_API_KEY));
            this.bNF.setShareAppName(intent.getStringExtra(WriteShareActivityConfig.SHARE_APP_NAME));
            this.bNF.setShareSignKey(intent.getStringExtra(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.bNF.setShareReferUrl(intent.getStringExtra(WriteShareActivityConfig.SHARE_REFER_URL));
        }
        String shareSummaryImg = this.bNF.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.bNF.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.bNF.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.bNF.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.bNF.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.bNF.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.bNF.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.bNF.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.bNF.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.bNF.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.bNF.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.bNF.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.bNF.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.bNF.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.bNF.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.bNF.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.bNF.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.bNH != null && this.bNH.acJ() != null && (editable = this.bNH.acJ().getEditableText().toString()) != null) {
            this.bNH.acJ().setText(TbFaceManager.vK().F(getPageContext().getContext(), editable));
            this.bNH.acJ().setSelection(this.bNH.acJ().getText().length());
        }
    }

    public void hr(int i) {
        this.bNG = i;
    }

    public int acA() {
        return this.bNG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acB() {
        acy();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.bNG != this.mPrefixData.getPrefixs().size() - 1) {
            this.bNF.setTitle(String.valueOf(this.bNH.acN().getText().toString()) + this.bNH.acI().getText().toString());
        } else {
            this.bNF.setTitle(this.bNH.acI().getText().toString());
        }
        this.bNF.setContent(this.bNH.acJ().getText().toString());
        this.aAK.c(this.bNF);
        this.bNF.setVcode(null);
        this.aAK.EV().setVoice(null);
        this.aAK.EV().setVoiceDuringTime(-1);
        if (this.aAK.aib()) {
            showLoadingDialog(getPageContext().getString(z.sending), this.bFV);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.bNJ = false;
            if (i2 == -1) {
                acw();
                if (this.bNL != null) {
                    this.bNK = true;
                    MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(true));
                    this.bNL.nV();
                    return;
                }
                return;
            }
            acx();
            if (this.bNM != null) {
                this.bNK = false;
                this.bNM.nV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.bNH.acI());
        HidenSoftKeyPad(this.mInputManager, this.bNH.acJ());
        super.onPause();
    }

    public void acC() {
        HidenSoftKeyPad(this.mInputManager, this.bNH.acI());
        HidenSoftKeyPad(this.mInputManager, this.bNH.acJ());
    }
}
