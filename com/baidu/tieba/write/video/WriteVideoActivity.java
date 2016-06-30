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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.u;
import java.io.File;
import java.io.Serializable;
/* loaded from: classes.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private com.baidu.tieba.tbadkCore.writeModel.a ask;
    private m fFZ;
    private com.baidu.tbadk.core.dialog.e fGa;
    private GestureDetector fGb;
    private int fGc;
    private InputMethodManager mInputManager;
    private final WriteData fau = new WriteData();
    private Runnable fGd = new f(this);
    private final a.d asA = new g(this);
    private Runnable fGe = new h(this);
    private a.InterfaceC0076a faC = new i(this);
    private DialogInterface.OnCancelListener eeQ = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fFZ = new m(this);
        setSwipeBackEnabled(false);
        bkW();
        if (this.fau.getVideoInfo() != null) {
            this.fFZ.qS(this.fau.getVideoInfo().getThumbPath());
        }
        if (this.fFZ.ble() != null) {
            this.fFZ.ble().e(this);
        }
        adjustResizeForSoftInput();
        this.fGb = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.fFZ.blh());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.h.h.dM().postDelayed(this.fGd, 500L);
    }

    private void bkW() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.fau.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.fau.setForumId(intent.getStringExtra("forum_id"));
            this.fau.setForumName(intent.getStringExtra("forum_name"));
            if (this.fFZ != null && this.fau.getVideoInfo() != null) {
                this.fFZ.cK((this.fau.getVideoInfo().getVideoDuration() + 1) * 1000);
            }
        }
    }

    private void bkX() {
        this.fau.setTitle(this.fFZ.getContent());
        this.fau.setContent("");
        this.fau.setType(0);
        if (this.fFZ.ble() != null) {
            this.fau.setHasLocationData(this.fFZ.ble().bcZ());
        }
        this.fau.setIsNoTitle(TextUtils.isEmpty(this.fau.getTitle()));
    }

    private void Cq() {
        bkD();
        asK();
        if (this.ask == null) {
            this.ask = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        }
        this.ask.d(this.fau);
        this.ask.b(this.asA);
        this.ask.a(this.faC);
        this.ask.bdv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkY() {
        VideoInfo videoInfo;
        if (this.fau != null && (videoInfo = this.fau.getVideoInfo()) != null && videoInfo.getVideoType() == 2 && videoInfo.isCompressedVideo()) {
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
            if (AntiHelper.qL(postWriteCallBackData.getErrorCode())) {
                AntiHelper.O(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(u.j.error_write);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.e.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void asK() {
        this.fGa = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        this.fGa.setOnCancelListener(this.eeQ);
        this.fGa.setCancelable(true);
        this.fGa.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.h.j.a(this.fGa, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bkD();
        destroyWaitingDialog();
        this.eeQ = null;
        closeLoadingDialog();
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.fGe);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.fGa = null;
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
        this.fFZ.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.fGd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bkD() {
        if (this.ask != null) {
            this.ask.cancelLoadData();
        }
        if (this.fFZ.ble() != null) {
            this.fFZ.ble().bkD();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fGa != null && this.fGa.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.fGa, getPageContext());
                return true;
            }
            bkZ();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bkZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bM(u.j.give_up_video_confirm);
        aVar.a(u.j.dialog_ok, new k(this));
        aVar.b(u.j.dialog_cancel, new l(this));
        aVar.b(getPageContext()).rT();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fFZ.blf()) {
            bla();
        } else if (view == this.fFZ.blg()) {
            if (m.fGg - this.fFZ.bld() < 0) {
                showToast(getResources().getString(u.j.video_content_overflow));
            } else {
                blb();
            }
        } else if (view == this.fFZ.aml()) {
            bkZ();
        }
    }

    private void bla() {
        if (this.fau.getVideoInfo() != null) {
            if (TextUtils.isEmpty(this.fau.getVideoInfo().getVideoPath())) {
                showToast(u.j.file_not_exist);
            } else if (!new File(this.fau.getVideoInfo().getVideoPath()).exists()) {
                showToast(u.j.file_not_exist);
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(getPageContext().getPageActivity(), this.fau.getVideoInfo().getVideoPath(), this.fau.getVideoInfo().getVideoWidth(), this.fau.getVideoInfo().getVideoHeight(), this.fau.getVideoInfo().getThumbPath(), false);
            }
        }
    }

    private void blb() {
        if (!com.baidu.adp.lib.util.i.fr()) {
            showToast(u.j.neterror);
            return;
        }
        bkX();
        Cq();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.fGa != null) {
            if (this.fGa.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.fGa, getPageContext());
            }
            this.fGa = null;
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
            com.baidu.adp.lib.util.k.a(WriteVideoActivity.this.getActivity(), WriteVideoActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.fGb.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
