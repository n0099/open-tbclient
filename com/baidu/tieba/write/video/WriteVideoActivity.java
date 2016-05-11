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
    private com.baidu.tieba.tbadkCore.writeModel.a aru;
    private GestureDetector faA;
    private int faB;
    private m fay;
    private com.baidu.tbadk.core.dialog.e faz;
    private InputMethodManager mInputManager;
    private final WriteData evE = new WriteData();
    private Runnable faC = new f(this);
    private final a.d arK = new g(this);
    private Runnable faD = new h(this);
    private a.InterfaceC0074a evM = new i(this);
    private DialogInterface.OnCancelListener dwy = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fay = new m(this);
        setSwipeBackEnabled(false);
        bcr();
        if (this.evE.getVideoInfo() != null) {
            this.fay.pg(this.evE.getVideoInfo().getThumbPath());
        }
        if (this.fay.bcA() != null) {
            this.fay.bcA().e(this);
        }
        adjustResizeForSoftInput();
        this.faA = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.fay.bcD());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.h.h.dL().postDelayed(this.faC, 500L);
    }

    private void bcr() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.evE.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.evE.setForumId(intent.getStringExtra("forum_id"));
            this.evE.setForumName(intent.getStringExtra("forum_name"));
            if (this.fay != null && this.evE.getVideoInfo() != null) {
                this.fay.ci((this.evE.getVideoInfo().getVideoDuration() + 1) * 1000);
            }
        }
    }

    private void bcs() {
        this.evE.setTitle(this.fay.getContent());
        this.evE.setContent("");
        this.evE.setType(0);
        if (this.fay.bcA() != null) {
            this.evE.setHasLocationData(this.fay.bcA().aUF());
        }
        this.evE.setIsNoTitle(TextUtils.isEmpty(this.evE.getTitle()));
    }

    private void Ch() {
        bcb();
        akv();
        if (this.aru == null) {
            this.aru = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        }
        this.aru.d(this.evE);
        this.aru.b(this.arK);
        this.aru.a(this.evM);
        this.aru.aVb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bct() {
        VideoInfo videoInfo;
        if (this.evE != null && (videoInfo = this.evE.getVideoInfo()) != null && videoInfo.getVideoType() == 2 && videoInfo.isCompressedVideo()) {
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
            if (AntiHelper.pw(postWriteCallBackData.getErrorCode())) {
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

    public void akv() {
        this.faz = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        this.faz.setOnCancelListener(this.dwy);
        this.faz.setCancelable(true);
        this.faz.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.h.j.a(this.faz, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bcb();
        destroyWaitingDialog();
        this.dwy = null;
        closeLoadingDialog();
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.faD);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.faz = null;
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
        this.fay.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.faC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bcb() {
        if (this.aru != null) {
            this.aru.cancelLoadData();
        }
        if (this.fay.bcA() != null) {
            this.fay.bcA().bcb();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.faz != null && this.faz.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.faz, getPageContext());
                return true;
            }
            bcu();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bcu() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bM(t.j.give_up_video_confirm);
        aVar.a(t.j.dialog_ok, new k(this));
        aVar.b(t.j.dialog_cancel, new l(this));
        aVar.b(getPageContext()).rU();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fay.bcB()) {
            bcv();
        } else if (view == this.fay.bcC()) {
            bcw();
        } else if (view == this.fay.adU()) {
            bcu();
        }
    }

    private void bcv() {
        if (this.evE.getVideoInfo() != null) {
            if (TextUtils.isEmpty(this.evE.getVideoInfo().getVideoPath())) {
                showToast(t.j.file_not_exist);
            } else if (!new File(this.evE.getVideoInfo().getVideoPath()).exists()) {
                showToast(t.j.file_not_exist);
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(getPageContext().getPageActivity(), this.evE.getVideoInfo().getVideoPath(), this.evE.getVideoInfo().getVideoWidth(), this.evE.getVideoInfo().getVideoHeight(), this.evE.getVideoInfo().getThumbPath(), false);
            }
        }
    }

    private void bcw() {
        if (!com.baidu.adp.lib.util.i.fq()) {
            showToast(t.j.neterror);
            return;
        }
        bcs();
        Ch();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.faz != null) {
            if (this.faz.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.faz, getPageContext());
            }
            this.faz = null;
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
        if (this.faA.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
