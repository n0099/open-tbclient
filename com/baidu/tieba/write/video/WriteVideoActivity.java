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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
import java.io.File;
import java.io.Serializable;
/* loaded from: classes.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private com.baidu.tieba.tbadkCore.writeModel.b awg;
    private m gcf;
    private com.baidu.tbadk.core.dialog.e gcg;
    private GestureDetector gch;
    private int gci;
    private InputMethodManager mInputManager;
    private final WriteData fiE = new WriteData();
    private Runnable gcj = new f(this);
    private final b.d aww = new g(this);
    private Runnable gck = new h(this);
    private a.InterfaceC0075a fvz = new i(this);
    private DialogInterface.OnCancelListener eGh = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gcf = new m(this);
        setSwipeBackEnabled(false);
        bsh();
        if (this.fiE.getVideoInfo() != null) {
            this.gcf.sm(this.fiE.getVideoInfo().getThumbPath());
        }
        if (this.gcf.bsp() != null) {
            this.gcf.bsp().e(this);
        }
        adjustResizeForSoftInput();
        this.gch = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.gcf.bss());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.h.h.eG().postDelayed(this.gcj, 500L);
    }

    private void bsh() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.fiE.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.fiE.setForumId(intent.getStringExtra("forum_id"));
            this.fiE.setForumName(intent.getStringExtra("forum_name"));
            if (this.gcf != null && this.fiE.getVideoInfo() != null) {
                this.gcf.dd((this.fiE.getVideoInfo().getVideoDuration() + 1) * 1000);
            }
        }
    }

    private void bsi() {
        this.fiE.setTitle(this.gcf.getContent());
        this.fiE.setContent("");
        this.fiE.setType(0);
        if (this.gcf.bsp() != null) {
            this.fiE.setHasLocationData(this.gcf.bsp().bjP());
        }
        this.fiE.setIsNoTitle(TextUtils.isEmpty(this.fiE.getTitle()));
    }

    private void DK() {
        beR();
        ayk();
        if (this.awg == null) {
            this.awg = new com.baidu.tieba.tbadkCore.writeModel.b(this);
        }
        this.awg.d(this.fiE);
        this.awg.b(this.aww);
        this.awg.a(this.fvz);
        this.awg.bkn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsj() {
        VideoInfo videoInfo;
        if (this.fiE != null && (videoInfo = this.fiE.getVideoInfo()) != null && videoInfo.getVideoType() == 2 && videoInfo.isCompressedVideo()) {
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
            if (AntiHelper.rG(postWriteCallBackData.getErrorCode())) {
                AntiHelper.R(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(t.j.error_write);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.f.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void ayk() {
        this.gcg = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        this.gcg.setOnCancelListener(this.eGh);
        this.gcg.setCancelable(true);
        this.gcg.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.h.j.a(this.gcg, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        beR();
        destroyWaitingDialog();
        this.eGh = null;
        closeLoadingDialog();
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.gck);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.gcg = null;
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
        this.gcf.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.gcj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void beR() {
        if (this.awg != null) {
            this.awg.cancelLoadData();
        }
        if (this.gcf.bsp() != null) {
            this.gcf.bsp().beR();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gcg != null && this.gcg.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.gcg, getPageContext());
                return true;
            }
            bsk();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bsk() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bZ(t.j.give_up_video_confirm);
        aVar.a(t.j.dialog_ok, new k(this));
        aVar.b(t.j.dialog_cancel, new l(this));
        aVar.b(getPageContext()).sX();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gcf.bsq()) {
            bsl();
        } else if (view == this.gcf.bsr()) {
            if (m.gcm - this.gcf.bso() < 0) {
                showToast(getResources().getString(t.j.video_content_overflow));
            } else {
                bsm();
            }
        } else if (view == this.gcf.arK()) {
            bsk();
        }
    }

    private void bsl() {
        if (this.fiE.getVideoInfo() != null) {
            if (TextUtils.isEmpty(this.fiE.getVideoInfo().getVideoPath())) {
                showToast(t.j.file_not_exist);
            } else if (!new File(this.fiE.getVideoInfo().getVideoPath()).exists()) {
                showToast(t.j.file_not_exist);
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(getPageContext().getPageActivity(), this.fiE.getVideoInfo().getVideoPath(), this.fiE.getVideoInfo().getVideoWidth(), this.fiE.getVideoInfo().getVideoHeight(), this.fiE.getVideoInfo().getThumbPath(), false);
            }
        }
    }

    private void bsm() {
        if (!com.baidu.adp.lib.util.i.gm()) {
            showToast(t.j.neterror);
            return;
        }
        bsi();
        DK();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.gcg != null) {
            if (this.gcg.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.gcg, getPageContext());
            }
            this.gcg = null;
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
        if (this.gch.onTouchEvent(motionEvent)) {
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
