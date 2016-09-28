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
    private com.baidu.tieba.tbadkCore.writeModel.b avJ;
    private m gep;
    private com.baidu.tbadk.core.dialog.e geq;
    private GestureDetector ger;
    private int ges;
    private InputMethodManager mInputManager;
    private final WriteData flk = new WriteData();
    private Runnable get = new f(this);
    private final b.d avZ = new g(this);
    private Runnable geu = new h(this);
    private a.InterfaceC0078a fyg = new i(this);
    private DialogInterface.OnCancelListener eIl = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gep = new m(this);
        setSwipeBackEnabled(false);
        bsN();
        if (this.flk.getVideoInfo() != null) {
            this.gep.sB(this.flk.getVideoInfo().getThumbPath());
        }
        if (this.gep.bsV() != null) {
            this.gep.bsV().e(this);
        }
        adjustResizeForSoftInput();
        this.ger = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.gep.bsY());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.h.h.eG().postDelayed(this.get, 500L);
    }

    private void bsN() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.flk.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.flk.setForumId(intent.getStringExtra("forum_id"));
            this.flk.setForumName(intent.getStringExtra("forum_name"));
            if (this.gep != null && this.flk.getVideoInfo() != null) {
                this.gep.dc((this.flk.getVideoInfo().getVideoDuration() + 1) * 1000);
            }
        }
    }

    private void bsO() {
        this.flk.setTitle(this.gep.getContent());
        this.flk.setContent("");
        this.flk.setType(0);
        if (this.gep.bsV() != null) {
            this.flk.setHasLocationData(this.gep.bsV().bkB());
        }
        this.flk.setIsNoTitle(TextUtils.isEmpty(this.flk.getTitle()));
    }

    private void DK() {
        bfC();
        ayI();
        if (this.avJ == null) {
            this.avJ = new com.baidu.tieba.tbadkCore.writeModel.b(this);
        }
        this.avJ.d(this.flk);
        this.avJ.b(this.avZ);
        this.avJ.a(this.fyg);
        this.avJ.bkY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsP() {
        VideoInfo videoInfo;
        if (this.flk != null && (videoInfo = this.flk.getVideoInfo()) != null && videoInfo.getVideoType() == 2 && videoInfo.isCompressedVideo()) {
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
            if (AntiHelper.rU(postWriteCallBackData.getErrorCode())) {
                AntiHelper.R(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
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

    public void ayI() {
        this.geq = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        this.geq.setOnCancelListener(this.eIl);
        this.geq.setCancelable(true);
        this.geq.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.h.j.a(this.geq, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bfC();
        destroyWaitingDialog();
        this.eIl = null;
        closeLoadingDialog();
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.geu);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.geq = null;
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
        this.gep.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.get);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bfC() {
        if (this.avJ != null) {
            this.avJ.cancelLoadData();
        }
        if (this.gep.bsV() != null) {
            this.gep.bsV().bfC();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.geq != null && this.geq.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.geq, getPageContext());
                return true;
            }
            bsQ();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bsQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bZ(r.j.give_up_video_confirm);
        aVar.a(r.j.dialog_ok, new k(this));
        aVar.b(r.j.dialog_cancel, new l(this));
        aVar.b(getPageContext()).tm();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gep.bsW()) {
            bsR();
        } else if (view == this.gep.bsX()) {
            if (m.gew - this.gep.bsU() < 0) {
                showToast(getResources().getString(r.j.video_content_overflow));
            } else {
                bsS();
            }
        } else if (view == this.gep.asj()) {
            bsQ();
        }
    }

    private void bsR() {
        if (this.flk.getVideoInfo() != null) {
            if (TextUtils.isEmpty(this.flk.getVideoInfo().getVideoPath())) {
                showToast(r.j.file_not_exist);
            } else if (!new File(this.flk.getVideoInfo().getVideoPath()).exists()) {
                showToast(r.j.file_not_exist);
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(getPageContext().getPageActivity(), this.flk.getVideoInfo().getVideoPath(), this.flk.getVideoInfo().getVideoWidth(), this.flk.getVideoInfo().getVideoHeight(), this.flk.getVideoInfo().getThumbPath(), false);
            }
        }
    }

    private void bsS() {
        if (!com.baidu.adp.lib.util.i.gm()) {
            showToast(r.j.neterror);
            return;
        }
        bsO();
        DK();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.geq != null) {
            if (this.geq.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.geq, getPageContext());
            }
            this.geq = null;
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
        if (this.ger.onTouchEvent(motionEvent)) {
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
