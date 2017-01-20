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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.File;
import java.io.Serializable;
/* loaded from: classes.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private NewWriteModel ave;
    private m fIR;
    private com.baidu.tbadk.core.dialog.e fIS;
    private GestureDetector fIT;
    private int fIU;
    private InputMethodManager mInputManager;
    private final WriteData mData = new WriteData();
    private Runnable fIV = new f(this);
    private final NewWriteModel.d avt = new g(this);
    private Runnable fIW = new h(this);
    private a.InterfaceC0075a fsX = new i(this);
    private DialogInterface.OnCancelListener mDialogCancelListener = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fIR = new m(this);
        setSwipeBackEnabled(false);
        bnC();
        if (this.mData.getVideoInfo() != null) {
            this.fIR.rD(this.mData.getVideoInfo().getThumbPath());
        }
        if (this.fIR.bnK() != null) {
            this.fIR.bnK().e(this);
        }
        adjustResizeForSoftInput();
        this.fIT = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.fIR.bnN());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.g.h.eE().postDelayed(this.fIV, 500L);
    }

    private void bnC() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            if (this.fIR != null && this.mData.getVideoInfo() != null) {
                this.fIR.cF((this.mData.getVideoInfo().getVideoDuration() + 1) * 1000);
            }
        }
    }

    private void bnD() {
        this.mData.setTitle(this.fIR.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        if (this.fIR.bnK() != null) {
            this.mData.setHasLocationData(this.fIR.bnK().OH());
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void Dr() {
        bdz();
        avh();
        if (this.ave == null) {
            this.ave = new NewWriteModel(this);
        }
        this.ave.setWriteData(this.mData);
        this.ave.b(this.avt);
        this.ave.a(this.fsX);
        this.ave.startPostWrite();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnE() {
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
            if (AntiHelper.sa(postWriteCallBackData.getErrorCode())) {
                AntiHelper.T(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(r.l.error_write);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void avh() {
        this.fIS = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        this.fIS.setOnCancelListener(this.mDialogCancelListener);
        this.fIS.setCancelable(true);
        this.fIS.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.g.j.a(this.fIS, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bdz();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.fIW);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.fIS = null;
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
        this.fIR.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.fIV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bdz() {
        if (this.ave != null) {
            this.ave.cancelLoadData();
        }
        if (this.fIR.bnK() != null) {
            this.fIR.bnK().bdz();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fIS != null && this.fIS.isShowing()) {
                com.baidu.adp.lib.g.j.b(this.fIS, getPageContext());
                return true;
            }
            bnF();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bnF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ca(r.l.give_up_video_confirm);
        aVar.a(r.l.dialog_ok, new k(this));
        aVar.b(r.l.dialog_cancel, new l(this));
        aVar.b(getPageContext()).sV();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fIR.bnL()) {
            bnG();
        } else if (view == this.fIR.bnM()) {
            if (m.fIY - this.fIR.bnJ() < 0) {
                showToast(getResources().getString(r.l.video_content_overflow));
            } else {
                bnH();
            }
        } else if (view == this.fIR.apM()) {
            bnF();
        }
    }

    private void bnG() {
        if (this.mData.getVideoInfo() != null) {
            if (TextUtils.isEmpty(this.mData.getVideoInfo().getVideoPath())) {
                showToast(r.l.file_not_exist);
            } else if (!new File(this.mData.getVideoInfo().getVideoPath()).exists()) {
                showToast(r.l.file_not_exist);
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(getPageContext().getPageActivity(), this.mData.getVideoInfo().getVideoPath(), this.mData.getVideoInfo().getVideoWidth(), this.mData.getVideoInfo().getVideoHeight(), this.mData.getVideoInfo().getThumbPath(), false);
            }
        }
    }

    private void bnH() {
        if (!com.baidu.adp.lib.util.i.gk()) {
            showToast(r.l.neterror);
            return;
        }
        bnD();
        Dr();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.fIS != null) {
            if (this.fIS.isShowing()) {
                com.baidu.adp.lib.g.j.b(this.fIS, getPageContext());
            }
            this.fIS = null;
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
        if (this.fIT.onTouchEvent(motionEvent)) {
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
