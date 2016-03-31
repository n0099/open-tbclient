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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import java.io.File;
import java.io.Serializable;
/* loaded from: classes.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private com.baidu.tieba.tbadkCore.writeModel.a avv;
    private m eJH;
    private com.baidu.tbadk.core.dialog.e eJI;
    private GestureDetector eJJ;
    private int eJK;
    private InputMethodManager mInputManager;
    private final WriteData esv = new WriteData();
    private Runnable eJL = new f(this);
    private final a.d avL = new g(this);
    private Runnable eJM = new h(this);
    private a.InterfaceC0082a esD = new i(this);
    private DialogInterface.OnCancelListener dtc = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eJH = new m(this);
        setSwipeBackEnabled(false);
        baf();
        if (this.esv.getVideoInfo() != null) {
            this.eJH.oS(this.esv.getVideoInfo().getThumbPath());
        }
        if (this.eJH.bao() != null) {
            this.eJH.bao().e(this);
        }
        adjustResizeForSoftInput();
        this.eJJ = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.eJH.bar());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.h.h.hx().postDelayed(this.eJL, 500L);
    }

    private void baf() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.esv.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.esv.setForumId(intent.getStringExtra("forum_id"));
            this.esv.setForumName(intent.getStringExtra("forum_name"));
            if (this.eJH != null && this.esv.getVideoInfo() != null) {
                this.eJH.ch((this.esv.getVideoInfo().getVideoDuration() + 1) * 1000);
            }
        }
    }

    private void bag() {
        this.esv.setTitle(this.eJH.getContent());
        this.esv.setContent("");
        this.esv.setType(0);
        if (this.eJH.bao() != null) {
            this.esv.setHasLocationData(this.eJH.bao().aUk());
        }
        this.esv.setIsNoTitle(TextUtils.isEmpty(this.esv.getTitle()));
    }

    private void Eo() {
        aZP();
        akp();
        if (this.avv == null) {
            this.avv = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        }
        this.avv.d(this.esv);
        this.avv.b(this.avL);
        this.avv.a(this.esD);
        this.avv.aUG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bah() {
        VideoInfo videoInfo;
        if (this.esv != null && (videoInfo = this.esv.getVideoInfo()) != null && videoInfo.getVideoType() == 2 && videoInfo.isCompressedVideo()) {
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
            if (AntiHelper.pB(postWriteCallBackData.getErrorCode())) {
                AntiHelper.O(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(t.j.error_write);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.e.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void akp() {
        this.eJI = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        this.eJI.setOnCancelListener(this.dtc);
        this.eJI.setCancelable(true);
        this.eJI.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.h.j.a(this.eJI, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        aZP();
        destroyWaitingDialog();
        this.dtc = null;
        closeLoadingDialog();
        com.baidu.adp.lib.h.h.hx().removeCallbacks(this.eJM);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.eJI = null;
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
        this.eJH.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.h.h.hx().removeCallbacks(this.eJL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aZP() {
        if (this.avv != null) {
            this.avv.cancelLoadData();
        }
        if (this.eJH.bao() != null) {
            this.eJH.bao().aZP();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.eJI != null && this.eJI.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.eJI, getPageContext());
                return true;
            }
            bai();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bai() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ca(t.j.give_up_video_confirm);
        aVar.a(t.j.dialog_ok, new k(this));
        aVar.b(t.j.dialog_cancel, new l(this));
        aVar.b(getPageContext()).up();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eJH.bap()) {
            baj();
        } else if (view == this.eJH.baq()) {
            bak();
        } else if (view == this.eJH.adU()) {
            bai();
        }
    }

    private void baj() {
        if (this.esv.getVideoInfo() != null) {
            if (TextUtils.isEmpty(this.esv.getVideoInfo().getVideoPath())) {
                showToast(t.j.file_not_exist);
            } else if (!new File(this.esv.getVideoInfo().getVideoPath()).exists()) {
                showToast(t.j.file_not_exist);
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(getPageContext().getPageActivity(), this.esv.getVideoInfo().getVideoPath(), this.esv.getVideoInfo().getVideoWidth(), this.esv.getVideoInfo().getVideoHeight(), this.esv.getVideoInfo().getThumbPath(), false);
            }
        }
    }

    private void bak() {
        if (!com.baidu.adp.lib.util.i.jf()) {
            showToast(t.j.neterror);
            return;
        }
        bag();
        Eo();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.eJI != null) {
            if (this.eJI.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.eJI, getPageContext());
            }
            this.eJI = null;
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
            com.baidu.adp.lib.util.k.c(WriteVideoActivity.this.getActivity(), WriteVideoActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.eJJ.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
