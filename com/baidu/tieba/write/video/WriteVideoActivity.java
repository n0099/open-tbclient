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
    private int faA;
    private m fax;
    private com.baidu.tbadk.core.dialog.e fay;
    private GestureDetector faz;
    private InputMethodManager mInputManager;
    private final WriteData evE = new WriteData();
    private Runnable faB = new f(this);
    private final a.d arK = new g(this);
    private Runnable faC = new h(this);
    private a.InterfaceC0074a evM = new i(this);
    private DialogInterface.OnCancelListener dwy = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fax = new m(this);
        setSwipeBackEnabled(false);
        bcy();
        if (this.evE.getVideoInfo() != null) {
            this.fax.pg(this.evE.getVideoInfo().getThumbPath());
        }
        if (this.fax.bcH() != null) {
            this.fax.bcH().e(this);
        }
        adjustResizeForSoftInput();
        this.faz = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.fax.bcK());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.h.h.dL().postDelayed(this.faB, 500L);
    }

    private void bcy() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.evE.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.evE.setForumId(intent.getStringExtra("forum_id"));
            this.evE.setForumName(intent.getStringExtra("forum_name"));
            if (this.fax != null && this.evE.getVideoInfo() != null) {
                this.fax.ci((this.evE.getVideoInfo().getVideoDuration() + 1) * 1000);
            }
        }
    }

    private void bcz() {
        this.evE.setTitle(this.fax.getContent());
        this.evE.setContent("");
        this.evE.setType(0);
        if (this.fax.bcH() != null) {
            this.evE.setHasLocationData(this.fax.bcH().aUL());
        }
        this.evE.setIsNoTitle(TextUtils.isEmpty(this.evE.getTitle()));
    }

    private void Ci() {
        bci();
        akx();
        if (this.aru == null) {
            this.aru = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        }
        this.aru.d(this.evE);
        this.aru.b(this.arK);
        this.aru.a(this.evM);
        this.aru.aVh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcA() {
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
            if (AntiHelper.pv(postWriteCallBackData.getErrorCode())) {
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

    public void akx() {
        this.fay = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        this.fay.setOnCancelListener(this.dwy);
        this.fay.setCancelable(true);
        this.fay.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.h.j.a(this.fay, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bci();
        destroyWaitingDialog();
        this.dwy = null;
        closeLoadingDialog();
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.faC);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.fay = null;
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
        this.fax.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.faB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bci() {
        if (this.aru != null) {
            this.aru.cancelLoadData();
        }
        if (this.fax.bcH() != null) {
            this.fax.bcH().bci();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fay != null && this.fay.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.fay, getPageContext());
                return true;
            }
            bcB();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bcB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bL(t.j.give_up_video_confirm);
        aVar.a(t.j.dialog_ok, new k(this));
        aVar.b(t.j.dialog_cancel, new l(this));
        aVar.b(getPageContext()).rV();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fax.bcI()) {
            bcC();
        } else if (view == this.fax.bcJ()) {
            bcD();
        } else if (view == this.fax.adW()) {
            bcB();
        }
    }

    private void bcC() {
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

    private void bcD() {
        if (!com.baidu.adp.lib.util.i.fq()) {
            showToast(t.j.neterror);
            return;
        }
        bcz();
        Ci();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.fay != null) {
            if (this.fay.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.fay, getPageContext());
            }
            this.fay = null;
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
        if (this.faz.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
