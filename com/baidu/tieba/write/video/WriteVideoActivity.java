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
    private com.baidu.tieba.tbadkCore.writeModel.a auV;
    private m epL;
    private com.baidu.tbadk.core.dialog.e epM;
    private GestureDetector epN;
    private int epO;
    private InputMethodManager mInputManager;
    private final WriteData dZC = new WriteData();
    private Runnable epP = new f(this);
    private final a.d avl = new g(this);
    private Runnable epQ = new h(this);
    private a.InterfaceC0085a dZK = new i(this);
    private DialogInterface.OnCancelListener cYA = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.epL = new m(this);
        setSwipeBackEnabled(false);
        aTF();
        if (this.dZC.getVideoInfo() != null) {
            this.epL.nF(this.dZC.getVideoInfo().getThumbPath());
        }
        if (this.epL.aTN() != null) {
            this.epL.aTN().e(this);
        }
        adjustResizeForSoftInput();
        this.epN = new GestureDetector(getPageContext().getPageActivity(), new a(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.epL.aTQ());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.h.h.hr().postDelayed(this.epP, 200L);
    }

    private void aTF() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.dZC.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.dZC.setForumId(intent.getStringExtra("forum_id"));
            this.dZC.setForumName(intent.getStringExtra("forum_name"));
        }
    }

    private void aTG() {
        this.dZC.setTitle(this.epL.getContent());
        this.dZC.setContent("");
        this.dZC.setType(0);
        if (this.epL.aTN() != null) {
            this.dZC.setHasLocationData(this.epL.aTN().aNi());
        }
        this.dZC.setIsNoTitle(TextUtils.isEmpty(this.dZC.getTitle()));
    }

    private void DE() {
        aTp();
        agV();
        if (this.auV == null) {
            this.auV = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        }
        this.auV.c(this.dZC);
        this.auV.b(this.avl);
        this.auV.a(this.dZK);
        this.auV.aNE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            postWriteCallBackData.getErrorString();
            if (AntiHelper.or(postWriteCallBackData.getErrorCode())) {
                AntiHelper.X(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(t.j.error_write);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.e.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void agV() {
        this.epM = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        this.epM.setOnCancelListener(this.cYA);
        this.epM.setCancelable(true);
        this.epM.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.h.j.a(this.epM, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        aTp();
        destroyWaitingDialog();
        this.cYA = null;
        closeLoadingDialog();
        com.baidu.adp.lib.h.h.hr().removeCallbacks(this.epQ);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.epM = null;
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
        this.epL.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.h.h.hr().removeCallbacks(this.epP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aTp() {
        if (this.auV != null) {
            this.auV.cancelLoadData();
        }
        if (this.epL.aTN() != null) {
            this.epL.aTN().aTp();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.epM != null && this.epM.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.epM, getPageContext());
                return true;
            }
            aTH();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aTH() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bY(t.j.give_up_video_confirm);
        aVar.a(t.j.dialog_ok, new k(this));
        aVar.b(t.j.dialog_cancel, new l(this));
        aVar.b(getPageContext()).uj();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.epL.aTO()) {
            aTI();
        } else if (view == this.epL.aTP()) {
            aTJ();
        } else if (view == this.epL.aay()) {
            aTH();
        }
    }

    private void aTI() {
        if (this.dZC.getVideoInfo() != null) {
            if (TextUtils.isEmpty(this.dZC.getVideoInfo().getVideoPath())) {
                showToast(t.j.file_not_exist);
            } else if (!new File(this.dZC.getVideoInfo().getVideoPath()).exists()) {
                showToast(t.j.file_not_exist);
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(getPageContext().getPageActivity(), this.dZC.getVideoInfo().getVideoPath(), this.dZC.getVideoInfo().getVideoWidth(), this.dZC.getVideoInfo().getVideoHeight(), this.dZC.getVideoInfo().getThumbPath());
            }
        }
    }

    private void aTJ() {
        if (!com.baidu.adp.lib.util.i.iZ()) {
            showToast(t.j.neterror);
            return;
        }
        aTG();
        DE();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.epM != null) {
            if (this.epM.isShowing()) {
                com.baidu.adp.lib.h.j.b(this.epM, getPageContext());
            }
            this.epM = null;
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
        if (this.epN.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
