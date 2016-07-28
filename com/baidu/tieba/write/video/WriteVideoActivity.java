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
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.u;
import java.io.File;
import java.io.Serializable;
/* loaded from: classes.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private com.baidu.tieba.tbadkCore.writeModel.a asZ;
    private m fSa;
    private com.baidu.tbadk.core.dialog.e fSb;
    private GestureDetector fSc;
    private int fSd;
    private InputMethodManager mInputManager;
    private final WriteData faq = new WriteData();
    private Runnable fSe = new f(this);
    private final a.d atp = new g(this);
    private Runnable fSf = new h(this);
    private a.InterfaceC0075a fnF = new i(this);
    private DialogInterface.OnCancelListener ezF = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fSa = new m(this);
        setSwipeBackEnabled(false);
        bnS();
        if (this.faq.getVideoInfo() != null) {
            this.fSa.rC(this.faq.getVideoInfo().getThumbPath());
        }
        if (this.fSa.boa() != null) {
            this.fSa.boa().e(this);
        }
        adjustResizeForSoftInput();
        this.fSc = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.fSa.bod());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.h.h.dL().postDelayed(this.fSe, 500L);
    }

    private void bnS() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.faq.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.faq.setForumId(intent.getStringExtra("forum_id"));
            this.faq.setForumName(intent.getStringExtra("forum_name"));
            if (this.fSa != null && this.faq.getVideoInfo() != null) {
                this.fSa.cJ((this.faq.getVideoInfo().getVideoDuration() + 1) * 1000);
            }
        }
    }

    private void bnT() {
        this.faq.setTitle(this.fSa.getContent());
        this.faq.setContent("");
        this.faq.setType(0);
        if (this.fSa.boa() != null) {
            this.faq.setHasLocationData(this.fSa.boa().bgo());
        }
        this.faq.setIsNoTitle(TextUtils.isEmpty(this.faq.getTitle()));
    }

    private void Cp() {
        bbm();
        atw();
        if (this.asZ == null) {
            this.asZ = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        }
        this.asZ.d(this.faq);
        this.asZ.b(this.atp);
        this.asZ.a(this.fnF);
        this.asZ.bgM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnU() {
        VideoInfo videoInfo;
        if (this.faq != null && (videoInfo = this.faq.getVideoInfo()) != null && videoInfo.getVideoType() == 2 && videoInfo.isCompressedVideo()) {
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
            if (AntiHelper.rg(postWriteCallBackData.getErrorCode())) {
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

    public void atw() {
        this.fSb = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        this.fSb.setOnCancelListener(this.ezF);
        this.fSb.setCancelable(true);
        this.fSb.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.h.j.a(this.fSb, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        bbm();
        destroyWaitingDialog();
        this.ezF = null;
        closeLoadingDialog();
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.fSf);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.fSb = null;
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
        this.fSa.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.fSe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bbm() {
        if (this.asZ != null) {
            this.asZ.cancelLoadData();
        }
        if (this.fSa.boa() != null) {
            this.fSa.boa().bbm();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fSb != null && this.fSb.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.fSb, getPageContext());
                return true;
            }
            bnV();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bnV() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bM(u.j.give_up_video_confirm);
        aVar.a(u.j.dialog_ok, new k(this));
        aVar.b(u.j.dialog_cancel, new l(this));
        aVar.b(getPageContext()).rS();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fSa.bob()) {
            bnW();
        } else if (view == this.fSa.boc()) {
            if (m.fSh - this.fSa.bnZ() < 0) {
                showToast(getResources().getString(u.j.video_content_overflow));
            } else {
                bnX();
            }
        } else if (view == this.fSa.amV()) {
            bnV();
        }
    }

    private void bnW() {
        if (this.faq.getVideoInfo() != null) {
            if (TextUtils.isEmpty(this.faq.getVideoInfo().getVideoPath())) {
                showToast(u.j.file_not_exist);
            } else if (!new File(this.faq.getVideoInfo().getVideoPath()).exists()) {
                showToast(u.j.file_not_exist);
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(getPageContext().getPageActivity(), this.faq.getVideoInfo().getVideoPath(), this.faq.getVideoInfo().getVideoWidth(), this.faq.getVideoInfo().getVideoHeight(), this.faq.getVideoInfo().getThumbPath(), false);
            }
        }
    }

    private void bnX() {
        if (!com.baidu.adp.lib.util.i.fq()) {
            showToast(u.j.neterror);
            return;
        }
        bnT();
        Cp();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.fSb != null) {
            if (this.fSb.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.fSb, getPageContext());
            }
            this.fSb = null;
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
        if (this.fSc.onTouchEvent(motionEvent)) {
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
