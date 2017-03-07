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
    private NewWriteModel aAz;
    private com.baidu.tbadk.core.dialog.e cbN;
    private m fNl;
    private GestureDetector fNm;
    private int fNn;
    private InputMethodManager mInputManager;
    private final WriteData mData = new WriteData();
    private Runnable fNo = new f(this);
    private final NewWriteModel.d aAO = new g(this);
    private Runnable fNp = new h(this);
    private a.InterfaceC0074a fxv = new i(this);
    private DialogInterface.OnCancelListener mDialogCancelListener = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fNl = new m(this);
        setSwipeBackEnabled(false);
        bnp();
        if (this.mData.getVideoInfo() != null) {
            this.fNl.qL(this.mData.getVideoInfo().getThumbPath());
        }
        if (this.fNl.bnx() != null) {
            this.fNl.bnx().e(this);
        }
        adjustResizeForSoftInput();
        this.fNm = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.fNl.bnA());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.g.h.fM().postDelayed(this.fNo, 500L);
    }

    private void bnp() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mData.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            if (this.fNl != null && this.mData.getVideoInfo() != null) {
                this.fNl.cI((this.mData.getVideoInfo().getVideoDuration() + 1) * 1000);
            }
        }
    }

    private void bnq() {
        this.mData.setTitle(this.fNl.getContent());
        this.mData.setContent("");
        this.mData.setType(0);
        if (this.fNl.bnx() != null) {
            this.mData.setHasLocationData(this.fNl.bnx().PB());
        }
        this.mData.setIsNoTitle(TextUtils.isEmpty(this.mData.getTitle()));
    }

    private void DK() {
        bdk();
        auC();
        if (this.aAz == null) {
            this.aAz = new NewWriteModel(this);
        }
        this.aAz.setWriteData(this.mData);
        this.aAz.b(this.aAO);
        this.aAz.a(this.fxv);
        this.aAz.startPostWrite();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnr() {
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
            if (AntiHelper.rZ(postWriteCallBackData.getErrorCode())) {
                AntiHelper.an(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(w.l.error_write);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.e.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void auC() {
        this.cbN = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        this.cbN.setOnCancelListener(this.mDialogCancelListener);
        this.cbN.setCancelable(true);
        this.cbN.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.g.j.a(this.cbN, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bdk();
        destroyWaitingDialog();
        this.mDialogCancelListener = null;
        closeLoadingDialog();
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.fNp);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.cbN = null;
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
        this.fNl.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.fNo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bdk() {
        if (this.aAz != null) {
            this.aAz.cancelLoadData();
        }
        if (this.fNl.bnx() != null) {
            this.fNl.bnx().bdk();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cbN != null && this.cbN.isShowing()) {
                com.baidu.adp.lib.g.j.b(this.cbN, getPageContext());
                return true;
            }
            bns();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bns() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bW(w.l.give_up_video_confirm);
        aVar.a(w.l.dialog_ok, new k(this));
        aVar.b(w.l.dialog_cancel, new l(this));
        aVar.b(getPageContext()).ts();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fNl.bny()) {
            bnt();
        } else if (view == this.fNl.bnz()) {
            if (m.fNr - this.fNl.bnw() < 0) {
                showToast(getResources().getString(w.l.video_content_overflow));
            } else {
                bnu();
            }
        } else if (view == this.fNl.apg()) {
            bns();
        }
    }

    private void bnt() {
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

    private void bnu() {
        if (!com.baidu.adp.lib.util.i.he()) {
            showToast(w.l.neterror);
            return;
        }
        bnq();
        DK();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.cbN != null) {
            if (this.cbN.isShowing()) {
                com.baidu.adp.lib.g.j.b(this.cbN, getPageContext());
            }
            this.cbN = null;
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
        if (this.fNm.onTouchEvent(motionEvent)) {
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
