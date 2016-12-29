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
    private com.baidu.tieba.tbadkCore.writeModel.b avZ;
    private m fAv;
    private com.baidu.tbadk.core.dialog.e fAw;
    private GestureDetector fAx;
    private int fAy;
    private InputMethodManager mInputManager;
    private final WriteData eWm = new WriteData();
    private Runnable fAz = new f(this);
    private final b.d awp = new g(this);
    private Runnable fAA = new h(this);
    private a.InterfaceC0073a fjN = new i(this);
    private DialogInterface.OnCancelListener esg = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fAv = new m(this);
        setSwipeBackEnabled(false);
        bme();
        if (this.eWm.getVideoInfo() != null) {
            this.fAv.rk(this.eWm.getVideoInfo().getThumbPath());
        }
        if (this.fAv.bmm() != null) {
            this.fAv.bmm().e(this);
        }
        adjustResizeForSoftInput();
        this.fAx = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.fAv.bmp());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.h.h.eG().postDelayed(this.fAz, 500L);
    }

    private void bme() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.eWm.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.eWm.setForumId(intent.getStringExtra("forum_id"));
            this.eWm.setForumName(intent.getStringExtra("forum_name"));
            if (this.fAv != null && this.eWm.getVideoInfo() != null) {
                this.fAv.cM((this.eWm.getVideoInfo().getVideoDuration() + 1) * 1000);
            }
        }
    }

    private void bmf() {
        this.eWm.setTitle(this.fAv.getContent());
        this.eWm.setContent("");
        this.eWm.setType(0);
        if (this.fAv.bmm() != null) {
            this.eWm.setHasLocationData(this.fAv.bmm().bgL());
        }
        this.eWm.setIsNoTitle(TextUtils.isEmpty(this.eWm.getTitle()));
    }

    private void Dw() {
        bbL();
        aub();
        if (this.avZ == null) {
            this.avZ = new com.baidu.tieba.tbadkCore.writeModel.b(this);
        }
        this.avZ.d(this.eWm);
        this.avZ.b(this.awp);
        this.avZ.a(this.fjN);
        this.avZ.bhi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmg() {
        VideoInfo videoInfo;
        if (this.eWm != null && (videoInfo = this.eWm.getVideoInfo()) != null && videoInfo.getVideoType() == 2 && videoInfo.isCompressedVideo()) {
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
            if (AntiHelper.rp(postWriteCallBackData.getErrorCode())) {
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

    public void aub() {
        this.fAw = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        this.fAw.setOnCancelListener(this.esg);
        this.fAw.setCancelable(true);
        this.fAw.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.h.j.a(this.fAw, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bbL();
        destroyWaitingDialog();
        this.esg = null;
        closeLoadingDialog();
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.fAA);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.fAw = null;
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
        this.fAv.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.fAz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bbL() {
        if (this.avZ != null) {
            this.avZ.cancelLoadData();
        }
        if (this.fAv.bmm() != null) {
            this.fAv.bmm().bbL();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fAw != null && this.fAw.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.fAw, getPageContext());
                return true;
            }
            bmh();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bmh() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cb(r.j.give_up_video_confirm);
        aVar.a(r.j.dialog_ok, new k(this));
        aVar.b(r.j.dialog_cancel, new l(this));
        aVar.b(getPageContext()).tb();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fAv.bmn()) {
            bmi();
        } else if (view == this.fAv.bmo()) {
            if (m.fAC - this.fAv.bml() < 0) {
                showToast(getResources().getString(r.j.video_content_overflow));
            } else {
                bmj();
            }
        } else if (view == this.fAv.aoF()) {
            bmh();
        }
    }

    private void bmi() {
        if (this.eWm.getVideoInfo() != null) {
            if (TextUtils.isEmpty(this.eWm.getVideoInfo().getVideoPath())) {
                showToast(r.j.file_not_exist);
            } else if (!new File(this.eWm.getVideoInfo().getVideoPath()).exists()) {
                showToast(r.j.file_not_exist);
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(getPageContext().getPageActivity(), this.eWm.getVideoInfo().getVideoPath(), this.eWm.getVideoInfo().getVideoWidth(), this.eWm.getVideoInfo().getVideoHeight(), this.eWm.getVideoInfo().getThumbPath(), false);
            }
        }
    }

    private void bmj() {
        if (!com.baidu.adp.lib.util.i.gm()) {
            showToast(r.j.neterror);
            return;
        }
        bmf();
        Dw();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.fAw != null) {
            if (this.fAw.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.fAw, getPageContext());
            }
            this.fAw = null;
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
        if (this.fAx.onTouchEvent(motionEvent)) {
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
