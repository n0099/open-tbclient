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
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
import java.io.File;
import java.io.Serializable;
/* loaded from: classes.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private com.baidu.tieba.tbadkCore.writeModel.b awC;
    private m glS;
    private com.baidu.tbadk.core.dialog.e glT;
    private GestureDetector glU;
    private int glV;
    private InputMethodManager mInputManager;
    private final WriteData fst = new WriteData();
    private Runnable glW = new f(this);
    private final b.d awS = new g(this);
    private Runnable glX = new h(this);
    private a.InterfaceC0079a fFG = new i(this);
    private DialogInterface.OnCancelListener eOK = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.glS = new m(this);
        setSwipeBackEnabled(false);
        bvi();
        if (this.fst.getVideoInfo() != null) {
            this.glS.sX(this.fst.getVideoInfo().getThumbPath());
        }
        if (this.glS.bvq() != null) {
            this.glS.bvq().e(this);
        }
        adjustResizeForSoftInput();
        this.glU = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.glS.bvt());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.h.h.eG().postDelayed(this.glW, 500L);
    }

    private void bvi() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.fst.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.fst.setForumId(intent.getStringExtra("forum_id"));
            this.fst.setForumName(intent.getStringExtra("forum_name"));
            if (this.glS != null && this.fst.getVideoInfo() != null) {
                this.glS.dg((this.fst.getVideoInfo().getVideoDuration() + 1) * 1000);
            }
        }
    }

    private void bvj() {
        this.fst.setTitle(this.glS.getContent());
        this.fst.setContent("");
        this.fst.setType(0);
        if (this.glS.bvq() != null) {
            this.fst.setHasLocationData(this.glS.bvq().bmR());
        }
        this.fst.setIsNoTitle(TextUtils.isEmpty(this.fst.getTitle()));
    }

    private void DO() {
        bhY();
        aAF();
        if (this.awC == null) {
            this.awC = new com.baidu.tieba.tbadkCore.writeModel.b(this);
        }
        this.awC.d(this.fst);
        this.awC.b(this.awS);
        this.awC.a(this.fFG);
        this.awC.bno();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvk() {
        VideoInfo videoInfo;
        if (this.fst != null && (videoInfo = this.fst.getVideoInfo()) != null && videoInfo.getVideoType() == 2 && videoInfo.isCompressedVideo()) {
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
            if (AntiHelper.sm(postWriteCallBackData.getErrorCode())) {
                AntiHelper.S(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(r.j.error_write);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.f.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void aAF() {
        this.glT = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        this.glT.setOnCancelListener(this.eOK);
        this.glT.setCancelable(true);
        this.glT.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.h.j.a(this.glT, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bhY();
        destroyWaitingDialog();
        this.eOK = null;
        closeLoadingDialog();
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.glX);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.glT = null;
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
        this.glS.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.glW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bhY() {
        if (this.awC != null) {
            this.awC.cancelLoadData();
        }
        if (this.glS.bvq() != null) {
            this.glS.bvq().bhY();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.glT != null && this.glT.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.glT, getPageContext());
                return true;
            }
            bvl();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bvl() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ca(r.j.give_up_video_confirm);
        aVar.a(r.j.dialog_ok, new k(this));
        aVar.b(r.j.dialog_cancel, new l(this));
        aVar.b(getPageContext()).tq();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.glS.bvr()) {
            bvm();
        } else if (view == this.glS.bvs()) {
            if (m.glZ - this.glS.bvp() < 0) {
                showToast(getResources().getString(r.j.video_content_overflow));
            } else {
                bvn();
            }
        } else if (view == this.glS.aug()) {
            bvl();
        }
    }

    private void bvm() {
        if (this.fst.getVideoInfo() != null) {
            if (TextUtils.isEmpty(this.fst.getVideoInfo().getVideoPath())) {
                showToast(r.j.file_not_exist);
            } else if (!new File(this.fst.getVideoInfo().getVideoPath()).exists()) {
                showToast(r.j.file_not_exist);
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(getPageContext().getPageActivity(), this.fst.getVideoInfo().getVideoPath(), this.fst.getVideoInfo().getVideoWidth(), this.fst.getVideoInfo().getVideoHeight(), this.fst.getVideoInfo().getThumbPath(), false);
            }
        }
    }

    private void bvn() {
        if (!com.baidu.adp.lib.util.i.gm()) {
            showToast(r.j.neterror);
            return;
        }
        bvj();
        DO();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.glT != null) {
            if (this.glT.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.glT, getPageContext());
            }
            this.glT = null;
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
        if (this.glU.onTouchEvent(motionEvent)) {
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
