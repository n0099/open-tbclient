package com.baidu.tieba.write.video;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.w;
import java.io.File;
import java.io.Serializable;
/* loaded from: classes.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private NewWriteModel aAR;
    private com.baidu.tbadk.core.dialog.e ccF;
    private m fRq;
    private GestureDetector fRr;
    private int fRs;
    private InputMethodManager mInputManager;
    private final WriteData mData = new WriteData();
    private Runnable fRt = new f(this);
    private final NewWriteModel.d aBg = new g(this);
    private Runnable fRu = new h(this);
    private a.InterfaceC0073a fBu = new i(this);
    private DialogInterface.OnCancelListener mDialogCancelListener = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fRq = new m(this);
        setSwipeBackEnabled(false);
        bpa();
        if (this.mData.getVideoInfo() != null) {
            this.fRq.rg(this.mData.getVideoInfo().getThumbPath());
        }
        if (this.fRq.bpi() != null) {
            this.fRq.bpi().e(this);
        }
        adjustResizeForSoftInput();
        this.fRr = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.fRq.bpl());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.g.h.fS().postDelayed(this.fRt, 500L);
    }

    private void bpa() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            if (this.fRq != null && this.mData.getVideoInfo() != null) {
                this.fRq.cI((this.mData.getVideoInfo().getVideoDuration() + 1) * 1000);
            }
        }
    }

    private void bpb() {
        this.mData.setTitle(this.fRq.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        if (this.fRq.bpi() != null) {
            this.mData.setHasLocationData(this.fRq.bpi().QZ());
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void Ei() {
        beY();
        avw();
        if (this.aAR == null) {
            this.aAR = new NewWriteModel(this);
        }
        this.aAR.setWriteData(this.mData);
        this.aAR.b(this.aBg);
        this.aAR.a(this.fBu);
        this.aAR.startPostWrite();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpc() {
        VideoInfo videoInfo;
        if (this.mData != null && (videoInfo = this.mData.getVideoInfo()) != null && videoInfo.getVideoType() == 2 && videoInfo.isCompressedVideo()) {
            File file = new File(videoInfo.getVideoPath());
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            postWriteCallBackData.getErrorString();
            if (AntiHelper.sd(postWriteCallBackData.getErrorCode())) {
                AntiHelper.aq(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(w.l.error_write);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void avw() {
        this.ccF = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        this.ccF.setOnCancelListener(this.mDialogCancelListener);
        this.ccF.setCancelable(true);
        this.ccF.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.g.j.a(this.ccF, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        beY();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fRu);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.ccF = null;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006 && i2 == -1) {
            b((PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS, postWriteCallBackData));
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.fRq.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fRt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void beY() {
        if (this.aAR != null) {
            this.aAR.cancelLoadData();
        }
        if (this.fRq.bpi() != null) {
            this.fRq.bpi().beY();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.ccF != null && this.ccF.isShowing()) {
                com.baidu.adp.lib.g.j.b(this.ccF, getPageContext());
                return true;
            }
            bpd();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bpd() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bZ(w.l.give_up_video_confirm);
        aVar.a(w.l.dialog_ok, new k(this));
        aVar.b(w.l.dialog_cancel, new l(this));
        aVar.b(getPageContext()).tQ();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fRq.bpj()) {
            bpe();
        } else if (view == this.fRq.bpk()) {
            if (m.fRw - this.fRq.bph() < 0) {
                showToast(getResources().getString(w.l.video_content_overflow));
            } else {
                bpf();
            }
        } else if (view == this.fRq.getBackButton()) {
            bpd();
        }
    }

    private void bpe() {
        if (this.mData.getVideoInfo() != null) {
            if (TextUtils.isEmpty(this.mData.getVideoInfo().getVideoPath())) {
                showToast(w.l.file_not_exist);
            } else if (!new File(this.mData.getVideoInfo().getVideoPath()).exists()) {
                showToast(w.l.file_not_exist);
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(getPageContext().getPageActivity(), this.mData.getVideoInfo().getVideoPath(), this.mData.getVideoInfo().getVideoWidth(), this.mData.getVideoInfo().getVideoHeight(), this.mData.getVideoInfo().getThumbPath(), false);
            }
        }
    }

    private void bpf() {
        if (!com.baidu.adp.lib.util.i.hk()) {
            showToast(w.l.neterror);
            return;
        }
        bpb();
        Ei();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.ccF != null) {
            if (this.ccF.isShowing()) {
                com.baidu.adp.lib.g.j.b(this.ccF, getPageContext());
            }
            this.ccF = null;
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        /* synthetic */ a(WriteVideoActivity writeVideoActivity, a aVar) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.baidu.adp.lib.util.k.b(WriteVideoActivity.this.getActivity(), WriteVideoActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.fRr.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }
}
