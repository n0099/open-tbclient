package com.baidu.tieba.shareSDK;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.model.ar;
import com.baidu.tieba.model.as;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class WriteShareActivity extends BaseActivity {
    private ar ayI;
    private int bJr;
    private p bJs;
    a bJt;
    private com.baidu.tbadk.core.dialog.e bJv;
    private com.baidu.tbadk.core.dialog.e bJw;
    private PostPrefixData mPrefixData;
    private WriteData bpJ = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener bCv = null;
    private boolean bJu = false;
    private com.baidu.tbadk.core.dialog.h bJx = new d(this);
    private com.baidu.tbadk.core.dialog.h bJy = new g(this);
    private com.baidu.tbadk.core.dialog.h bJz = new h(this);
    private final as ayL = new i(this);
    private DialogInterface.OnKeyListener bJA = new j(this);
    private View.OnClickListener bJB = new k(this);
    private View.OnClickListener bJC = new l(this);
    private View.OnClickListener bJD = new m(this);
    private final View.OnFocusChangeListener bJE = new n(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(WriteShareActivityConfig.class, WriteShareActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getWindow().setSoftInputMode(18);
        if (!this.bJu) {
            com.baidu.tbadk.core.b.b.a(this, Constants.MEDIA_INFO, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdLog.addLogPackage(WriteShareActivity.class.getPackage().getName());
        super.onCreate(bundle);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        d(bundle);
        initUI();
        this.bJt.ho(this.bpJ.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acb() {
        if (this.bJv == null) {
            this.bJv = new com.baidu.tbadk.core.dialog.e(this);
            this.bJv.R(false);
            this.bJv.aY(com.baidu.tieba.u.icon_send_ok);
            this.bJv.bb(y.share_alert_success);
            this.bJv.a(y.share_stay_in_tieba, this.bJx);
            this.bJv.b(y.back, this.bJz);
            this.bJv.a(this.bJA);
            this.bJv.kX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acc() {
        if (this.bJw == null) {
            this.bJw = new com.baidu.tbadk.core.dialog.e(this);
            this.bJw.aY(com.baidu.tieba.u.icon_send_error);
            this.bJw.aZ(com.baidu.tieba.u.btn_w_square);
            this.bJw.ba(com.baidu.tieba.s.dialog_bdalert_title);
            this.bJw.bb(y.share_alert_fail);
            this.bJw.a(y.share_keep_sending, this.bJy);
            this.bJw.b(y.back, this.bJz);
            this.bJw.a(this.bJA);
            this.bJw.kX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acd() {
        if (this.ayI != null) {
            this.ayI.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        acd();
        super.onDestroy();
    }

    public WriteData EE() {
        return this.bpJ;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bJs != null && this.bJs.acp() != null && this.bJs.acp().isShowing()) {
                com.baidu.adp.lib.g.j.a(this.bJs.acp(), this);
                return true;
            }
            acd();
            com.baidu.tbadk.core.b.b.a(this, Constants.MEDIA_INFO, false);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bJs != null) {
            this.bJs.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(com.baidu.tieba.w.write_share_activity);
        addGlobalLayoutListener();
        this.bJs = new p(this);
        this.bJs.y(this.bJB);
        this.bJs.z(this.bJC);
        this.bJs.a(this.bJE);
        this.bJs.A(this.bJD);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    public void ace() {
        com.baidu.adp.lib.util.m.b(this, y.share_load_image_fail_tip);
        new Handler().postDelayed(new o(this, this), 3500L);
    }

    private void d(Bundle bundle) {
        this.ayI = new ar(this);
        this.ayI.a(this.ayL);
        this.bJt = new a(this, new e(this));
        this.bCv = new f(this);
        this.bpJ = new WriteData();
        this.bpJ.setType(3);
        if (bundle != null) {
            this.bpJ.setForumName(bundle.getString("forum_name"));
            this.bpJ.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.bpJ.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.bpJ.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.bpJ.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.bpJ.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.bpJ.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.bpJ.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            Intent intent = getIntent();
            this.bpJ.setForumName(intent.getStringExtra("forum_name"));
            this.bpJ.setShareSummaryTitle(intent.getStringExtra(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.bpJ.setShareSummaryContent(intent.getStringExtra(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.bpJ.setShareSummaryImg(intent.getStringExtra(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.bpJ.setShareApiKey(intent.getStringExtra(WriteShareActivityConfig.SHARE_API_KEY));
            this.bpJ.setShareAppName(intent.getStringExtra(WriteShareActivityConfig.SHARE_APP_NAME));
            this.bpJ.setShareSignKey(intent.getStringExtra(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.bpJ.setShareReferUrl(intent.getStringExtra(WriteShareActivityConfig.SHARE_REFER_URL));
        }
        String shareSummaryImg = this.bpJ.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.bpJ.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.bpJ.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.bpJ.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.bpJ.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.bpJ.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.bpJ.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.bpJ.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.bpJ.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.bpJ.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.bpJ.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.bpJ.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.bpJ.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.bpJ.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.bpJ.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.bpJ.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.bpJ.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.bJs != null && this.bJs.aco() != null && (editable = this.bJs.aco().getEditableText().toString()) != null) {
            this.bJs.aco().setText(TbFaceManager.sh().q(this, editable));
            this.bJs.aco().setSelection(this.bJs.aco().getText().length());
        }
    }

    public void hi(int i) {
        this.bJr = i;
    }

    public int acf() {
        return this.bJr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acg() {
        acd();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.bJr != this.mPrefixData.getPrefixs().size() - 1) {
            this.bpJ.setTitle(String.valueOf(this.bJs.acs().getText().toString()) + this.bJs.acn().getText().toString());
        } else {
            this.bpJ.setTitle(this.bJs.acn().getText().toString());
        }
        this.bpJ.setContent(this.bJs.aco().getText().toString());
        this.ayI.b(this.bpJ);
        this.bpJ.setVcode(null);
        this.ayI.EE().setVoice(null);
        this.ayI.EE().setVoiceDuringTime(-1);
        if (this.ayI.TU()) {
            showLoadingDialog(getString(y.sending), this.bCv);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.bJu = false;
            if (i2 == -1) {
                acb();
                if (this.bJv != null) {
                    this.bJv.kY();
                    return;
                }
                return;
            }
            acc();
            if (this.bJw != null) {
                this.bJw.kY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.bJs.acn());
        HidenSoftKeyPad(this.mInputManager, this.bJs.aco());
        super.onPause();
    }

    public void ach() {
        HidenSoftKeyPad(this.mInputManager, this.bJs.acn());
        HidenSoftKeyPad(this.mInputManager, this.bJs.aco());
    }
}
