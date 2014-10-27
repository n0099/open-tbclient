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
    private ar ayz;
    private int bJd;
    private o bJe;
    a bJf;
    private com.baidu.tbadk.core.dialog.e bJh;
    private com.baidu.tbadk.core.dialog.e bJi;
    private PostPrefixData mPrefixData;
    private WriteData bpv = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener bCh = null;
    private boolean bJg = false;
    private com.baidu.tbadk.core.dialog.h bJj = new d(this);
    private com.baidu.tbadk.core.dialog.h bJk = new f(this);
    private com.baidu.tbadk.core.dialog.h bJl = new g(this);
    private final as ayC = new h(this);
    private View.OnClickListener bJm = new i(this);
    private View.OnClickListener bJn = new j(this);
    private View.OnClickListener bJo = new k(this);
    private final View.OnFocusChangeListener bJp = new l(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(WriteShareActivityConfig.class, WriteShareActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getWindow().setSoftInputMode(18);
        if (!this.bJg) {
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
        this.bJf.ho(this.bpv.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abY() {
        if (this.bJh == null) {
            this.bJh = new com.baidu.tbadk.core.dialog.e(this);
            this.bJh.R(false);
            this.bJh.aY(com.baidu.tieba.u.icon_send_ok);
            this.bJh.bb(y.share_alert_success);
            this.bJh.a(y.share_stay_in_tieba, this.bJj);
            this.bJh.b(y.back, this.bJl);
            this.bJh.kX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abZ() {
        if (this.bJi == null) {
            this.bJi = new com.baidu.tbadk.core.dialog.e(this);
            this.bJi.aY(com.baidu.tieba.u.icon_send_error);
            this.bJi.aZ(com.baidu.tieba.u.btn_w_square);
            this.bJi.ba(com.baidu.tieba.s.dialog_bdalert_title);
            this.bJi.bb(y.share_alert_fail);
            this.bJi.a(y.share_keep_sending, this.bJk);
            this.bJi.b(y.back, this.bJl);
            this.bJi.kX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aca() {
        if (this.ayz != null) {
            this.ayz.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        aca();
        super.onDestroy();
    }

    public WriteData EC() {
        return this.bpv;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bJe != null && this.bJe.acm() != null && this.bJe.acm().isShowing()) {
                com.baidu.adp.lib.g.j.a(this.bJe.acm(), this);
                return true;
            }
            aca();
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
        if (this.bJe != null) {
            this.bJe.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(com.baidu.tieba.w.write_share_activity);
        addGlobalLayoutListener();
        this.bJe = new o(this);
        this.bJe.y(this.bJm);
        this.bJe.z(this.bJn);
        this.bJe.a(this.bJp);
        this.bJe.A(this.bJo);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    public void acb() {
        com.baidu.adp.lib.util.m.b(this, y.share_load_image_fail_tip);
        new Handler().postDelayed(new n(this, this), 3500L);
    }

    private void d(Bundle bundle) {
        this.ayz = new ar(this);
        this.ayz.a(this.ayC);
        this.bJf = new a(this, new m(this));
        this.bCh = new e(this);
        this.bpv = new WriteData();
        this.bpv.setType(3);
        if (bundle != null) {
            this.bpv.setForumName(bundle.getString("forum_name"));
            this.bpv.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.bpv.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.bpv.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.bpv.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.bpv.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.bpv.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.bpv.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            Intent intent = getIntent();
            this.bpv.setForumName(intent.getStringExtra("forum_name"));
            this.bpv.setShareSummaryTitle(intent.getStringExtra(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.bpv.setShareSummaryContent(intent.getStringExtra(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.bpv.setShareSummaryImg(intent.getStringExtra(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.bpv.setShareApiKey(intent.getStringExtra(WriteShareActivityConfig.SHARE_API_KEY));
            this.bpv.setShareAppName(intent.getStringExtra(WriteShareActivityConfig.SHARE_APP_NAME));
            this.bpv.setShareSignKey(intent.getStringExtra(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.bpv.setShareReferUrl(intent.getStringExtra(WriteShareActivityConfig.SHARE_REFER_URL));
        }
        String shareSummaryImg = this.bpv.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.bpv.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.bpv.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.bpv.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.bpv.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.bpv.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.bpv.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.bpv.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.bpv.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.bpv.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.bpv.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.bpv.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.bpv.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.bpv.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.bpv.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.bpv.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.bpv.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.bJe != null && this.bJe.acl() != null && (editable = this.bJe.acl().getEditableText().toString()) != null) {
            this.bJe.acl().setText(TbFaceManager.sf().q(this, editable));
            this.bJe.acl().setSelection(this.bJe.acl().getText().length());
        }
    }

    public void hi(int i) {
        this.bJd = i;
    }

    public int acc() {
        return this.bJd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acd() {
        aca();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.bJd != this.mPrefixData.getPrefixs().size() - 1) {
            this.bpv.setTitle(String.valueOf(this.bJe.acp().getText().toString()) + this.bJe.ack().getText().toString());
        } else {
            this.bpv.setTitle(this.bJe.ack().getText().toString());
        }
        this.bpv.setContent(this.bJe.acl().getText().toString());
        this.ayz.b(this.bpv);
        this.bpv.setVcode(null);
        this.ayz.EC().setVoice(null);
        this.ayz.EC().setVoiceDuringTime(-1);
        if (this.ayz.TR()) {
            showLoadingDialog(getString(y.sending), this.bCh);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.bJg = false;
            if (i2 == -1) {
                abY();
                if (this.bJh != null) {
                    this.bJh.kY();
                    return;
                }
                return;
            }
            abZ();
            if (this.bJi != null) {
                this.bJi.kY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.bJe.ack());
        HidenSoftKeyPad(this.mInputManager, this.bJe.acl());
        super.onPause();
    }

    public void ace() {
        HidenSoftKeyPad(this.mInputManager, this.bJe.ack());
        HidenSoftKeyPad(this.mInputManager, this.bJe.acl());
    }
}
